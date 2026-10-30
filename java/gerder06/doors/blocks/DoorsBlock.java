package gerder06.doors.blocks;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Shared behaviour for every DoorsCraft block:
 *  - two-block-tall placement for blocks with a "half" property
 *  - right-click open/close for blocks with an "open" property
 *  - locked doors can be unlocked with a matching key item
 */
public class DoorsBlock extends Block {
  public DoorsBlock(Properties p) { super(p); }

  // ----- property helpers (name based, so one class serves every block) -----
  protected Property<?> prop(String n) { return getStateDefinition().getProperty(n); }
  protected boolean has(String n) { return prop(n) != null; }

  private static <T extends Comparable<T>> String nameOf(BlockState s, Property<T> p) { return p.getName(s.getValue(p)); }

  private static <T extends Comparable<T>> BlockState named(BlockState s, Property<T> p, String v) {
    return p.getValue(v).map(x -> s.setValue(p, x)).orElse(s);
  }

  protected BlockState setNamed(BlockState s, String prop, String v) {
    Property<?> p = prop(prop);
    return p == null ? s : named(s, p, v);
  }

  protected boolean flag(BlockState s, String n) {
    Property<?> p = prop(n);
    return p instanceof BooleanProperty bp && s.getValue(bp);
  }

  protected BlockState withFlag(BlockState s, String n, boolean v) {
    Property<?> p = prop(n);
    return p instanceof BooleanProperty bp ? s.setValue(bp, v) : s;
  }

  protected boolean isTall() { return has("half"); }
  protected boolean isUpper(BlockState s) { String n = nameOf(s, prop("half")); return n.equals("upper") || n.equals("top"); }
  protected String lowerName() { return prop("half").getValue("lower").isPresent() ? "lower" : "bottom"; }
  protected String upperName() { return prop("half").getValue("upper").isPresent() ? "upper" : "top"; }
  protected boolean doorLike() { return has("open") && isTall(); }

  // ----- placement -----
  @Nullable
  @Override
  public BlockState getStateForPlacement(BlockPlaceContext c) {
    BlockState s = this.defaultBlockState();
    if (isTall()) {
      BlockPos p = c.getClickedPos();
      if (p.getY() >= c.getLevel().getMaxBuildHeight() - 1 || !c.getLevel().getBlockState(p.above()).canBeReplaced(c)) return null;
      s = setNamed(s, "half", lowerName());
    }
    if (s.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
      Direction d = doorLike() ? c.getHorizontalDirection() : c.getHorizontalDirection().getOpposite();
      s = s.setValue(BlockStateProperties.HORIZONTAL_FACING, d);
    }
    if (s.hasProperty(BlockStateProperties.AXIS)) s = s.setValue(BlockStateProperties.AXIS, c.getClickedFace().getAxis());
    return s;
  }

  @Override
  public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
    if (isTall()) level.setBlock(pos.above(), setNamed(state, "half", upperName()), 3);
  }

  @Override
  public BlockState updateShape(BlockState state, Direction dir, BlockState neighbor, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
    if (isTall()) {
      boolean up = isUpper(state);
      if (dir == (up ? Direction.DOWN : Direction.UP) && (!neighbor.is(this) || isUpper(neighbor) == up)) return Blocks.AIR.defaultBlockState();
    }
    return super.updateShape(state, dir, neighbor, level, pos, neighborPos);
  }

  @Override
  public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
    if (!level.isClientSide && isTall()) {
      BlockPos other = isUpper(state) ? pos.below() : pos.above();
      BlockState os = level.getBlockState(other);
      if (os.is(this)) {
        level.setBlock(other, Blocks.AIR.defaultBlockState(), 35);
        level.levelEvent(player, 2001, other, Block.getId(os));
      }
    }
    super.playerWillDestroy(level, pos, state, player);
  }

  // ----- interaction -----
  @Override
  public InteractionResult use(BlockState s, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
    if (!has("open")) return InteractionResult.PASS;
    if (flag(s, "locked")) {
      if (!tryUnlock(player, hand)) {
        level.playSound(player, pos, SoundEvents.CHEST_LOCKED, SoundSource.BLOCKS, 1.0F, 1.0F);
        return InteractionResult.sidedSuccess(level.isClientSide);
      }
      s = withFlag(s, "locked", false);
    }
    boolean open = !flag(s, "open");
    s = withFlag(s, "open", open);
    level.setBlock(pos, s, 10);
    if (isTall()) {
      BlockPos other = isUpper(s) ? pos.below() : pos.above();
      BlockState os = level.getBlockState(other);
      if (os.is(this)) level.setBlock(other, withFlag(withFlag(os, "open", open), "locked", false), 10);
    }
    level.playSound(player, pos, open ? SoundEvents.WOODEN_DOOR_OPEN : SoundEvents.WOODEN_DOOR_CLOSE, SoundSource.BLOCKS, 1.0F, 1.0F);
    return InteractionResult.sidedSuccess(level.isClientSide);
  }

  /** GUESS: original key rules were in compiled code. hotel_key -> hotel/mine doors, X_key -> X_door. */
  private boolean tryUnlock(Player player, InteractionHand hand) {
    ItemStack st = player.getItemInHand(hand);
    ResourceLocation key = ForgeRegistries.ITEMS.getKey(st.getItem());
    ResourceLocation me = ForgeRegistries.BLOCKS.getKey(this);
    if (key == null || me == null || !key.getPath().endsWith("_key")) return false;
    String prefix = key.getPath().replace("_key", "");
    boolean ok = me.getPath().startsWith(prefix) || (prefix.equals("hotel") && me.getPath().startsWith("mine"));
    if (ok && !player.getAbilities().instabuild) st.shrink(1);
    return ok;
  }

  // ----- shape -----
  @Override
  public VoxelShape getShape(BlockState s, BlockGetter g, BlockPos p, CollisionContext c) {
    if (doorLike() && s.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
      Direction f = s.getValue(BlockStateProperties.HORIZONTAL_FACING);
      if (flag(s, "open")) f = f.getClockWise();
      return switch (f) {
        case NORTH -> Block.box(0, 0, 13, 16, 16, 16);
        case SOUTH -> Block.box(0, 0, 0, 16, 16, 3);
        case WEST -> Block.box(13, 0, 0, 16, 16, 16);
        default -> Block.box(0, 0, 0, 3, 16, 16);
      };
    }
    return super.getShape(s, g, p, c);
  }
}
