package gerder06.doors.blocks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import gerder06.doors.DoorsMod;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/** Port of 1.16.5 BlockInit. Block states match the original blockstate JSONs. */
public class ModBlocks {
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DoorsMod.MODID);
  public static final Map<String, RegistryObject<Block>> ALL = new LinkedHashMap<>();

  private static void reg(String name, Supplier<Block> s) { ALL.put(name, BLOCKS.register(name, s)); }

  static {
    reg("sound_ambient_block", () -> new DoorsBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("elevator_door", () -> new ElevatorDoorBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.METAL).noOcclusion()));
    reg("hotel_door", () -> new HotelDoorBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("skeleton_door", () -> new SkeletonDoorBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("green_house_door", () -> new GreenHouseDoorBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("electrical_door", () -> new ElectricalDoorBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.METAL).noOcclusion()));
    reg("starlight_gateway", () -> new StarlightGatewayBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.GLASS).noOcclusion()));
    reg("hotel_bookshelf", () -> new HotelBookshelfBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("invisible_light", () -> new DoorsBlock(BlockBehaviour.Properties.of().strength(-1.0F, 3600000.0F).sound(SoundType.WOOD).noOcclusion().noCollission().lightLevel(st -> 15)));
    reg("hotel_closet", () -> new HotelClosetBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("toolsheds_closet", () -> new ToolshedsClosetBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("long_table", () -> new LongTableBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("little_table", () -> new LittleTableBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("hotel_chest", () -> new HotelChestBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("wall_light", () -> new WallLightBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).noOcclusion().lightLevel(st -> 15)));
    reg("hotel_ceiling_lamp", () -> new HotelCeilingLampBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.GLASS).noOcclusion().lightLevel(st -> 15)));
    reg("hotel_lamp", () -> new HotelLampBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.GLASS).noOcclusion().lightLevel(st -> 15)));
    reg("wooden_box", () -> new WoodenBoxBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("bramble", () -> new DoorsBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.GRASS).noOcclusion()));
    reg("herb_of_viridis", () -> new DoorsBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.GRASS).noOcclusion().noCollission()));
    reg("rooms_wall", () -> new DoorsBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("rooms_door", () -> new RoomsDoorBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("rooms_door_number_plate", () -> new RoomsDoorNumberPlateBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("rooms_locker", () -> new RoomsLockerBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.METAL).noOcclusion()));
    reg("archives_flowers", () -> new ArchivesFlowersBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.GRASS).noOcclusion()));
    reg("archives_server", () -> new ArchivesServerBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.METAL).noOcclusion()));
    reg("archives_plant", () -> new DoorsBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.GRASS).noOcclusion().noCollission()));
    reg("marble", () -> new DoorsBlock(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.STONE).noOcclusion()));
    reg("scrambler", () -> new ScramblerBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.METAL).noOcclusion()));
    reg("backdoor_door", () -> new BackdoorDoorBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.METAL).noOcclusion()));
    reg("backdoor_lever", () -> new BackdoorLeverBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("outdoor_door", () -> new OutdoorDoorBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("outdoor_wooden_door", () -> new OutdoorWoodenDoorBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("mine_door", () -> new MineDoorBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("mine_alt_door", () -> new MineAltDoorBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    reg("mine_locker", () -> new MineLockerBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.METAL).noOcclusion()));
    reg("mine_loot_locker", () -> new MineLootLockerBlock(BlockBehaviour.Properties.of().strength(3.0F).sound(SoundType.METAL).noOcclusion()));
    reg("mine_generator", () -> new MineGeneratorBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.METAL).noOcclusion()));
    reg("mines_lamp", () -> new MinesLampBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.GLASS).noOcclusion().lightLevel(st -> 15)));
    reg("mines_bulb", () -> new MinesBulbBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.GLASS).noOcclusion().lightLevel(st -> 15)));
  }

  public static class ElevatorDoorBlock extends DoorsBlock {
    
    
    public ElevatorDoorBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.OPEN, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF, BlockStateProperties.OPEN);
    }
  }
  public static class HotelDoorBlock extends DoorsBlock {
    
    static final BooleanProperty P_DOOR_NUMEROTED = BooleanProperty.create("door_numeroted");
    static final BooleanProperty P_LOCKED = BooleanProperty.create("locked");
    public HotelDoorBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(P_DOOR_NUMEROTED, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(P_LOCKED, false).setValue(BlockStateProperties.OPEN, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(P_DOOR_NUMEROTED, BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF, P_LOCKED, BlockStateProperties.OPEN);
    }
  }
  public static class SkeletonDoorBlock extends DoorsBlock {
      public enum HalfValue implements StringRepresentable {
      BOTTOM("bottom"),
      TOP("top");
      private final String n; HalfValue(String n) { this.n = n; }
      @Override public String getSerializedName() { return n; }
      @Override public String toString() { return n; }
    }
    static final EnumProperty<HalfValue> P_HALF = EnumProperty.create("half", HalfValue.class);
    public SkeletonDoorBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(P_HALF, HalfValue.BOTTOM));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING, P_HALF);
    }
  }
  public static class GreenHouseDoorBlock extends DoorsBlock {
    
    static final BooleanProperty P_DOOR_NUMEROTED = BooleanProperty.create("door_numeroted");
    public GreenHouseDoorBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(P_DOOR_NUMEROTED, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.OPEN, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(P_DOOR_NUMEROTED, BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF, BlockStateProperties.OPEN);
    }
  }
  public static class ElectricalDoorBlock extends DoorsBlock {
    
    static final BooleanProperty P_LOCKED = BooleanProperty.create("locked");
    public ElectricalDoorBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(P_LOCKED, false).setValue(BlockStateProperties.OPEN, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF, P_LOCKED, BlockStateProperties.OPEN);
    }
  }
  public static class StarlightGatewayBlock extends DoorsBlock {
    
    
    public StarlightGatewayBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF);
    }
  }
  public static class HotelBookshelfBlock extends DoorsBlock {
    
    
    public HotelBookshelfBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING);
    }
  }
  public static class HotelClosetBlock extends DoorsBlock {
      public enum PartValue implements StringRepresentable {
      CLOSET_1("closet_1"),
      CLOSET_2("closet_2"),
      CLOSET_3("closet_3"),
      CLOSET_4("closet_4"),
      CLOSET_5("closet_5"),
      CLOSET_6("closet_6");
      private final String n; PartValue(String n) { this.n = n; }
      @Override public String getSerializedName() { return n; }
      @Override public String toString() { return n; }
    }
    static final EnumProperty<PartValue> P_PART = EnumProperty.create("part", PartValue.class);
    public HotelClosetBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(P_PART, PartValue.CLOSET_1));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING, P_PART);
    }
  }
  public static class ToolshedsClosetBlock extends DoorsBlock {
      public enum PartValue implements StringRepresentable {
      CLOSET_1("closet_1"),
      CLOSET_2("closet_2"),
      CLOSET_3("closet_3"),
      CLOSET_4("closet_4"),
      CLOSET_5("closet_5"),
      CLOSET_6("closet_6");
      private final String n; PartValue(String n) { this.n = n; }
      @Override public String getSerializedName() { return n; }
      @Override public String toString() { return n; }
    }
    static final EnumProperty<PartValue> P_PART = EnumProperty.create("part", PartValue.class);
    public ToolshedsClosetBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(P_PART, PartValue.CLOSET_1));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING, P_PART);
    }
  }
  public static class LongTableBlock extends DoorsBlock {
      public enum PartValue implements StringRepresentable {
      LEFT("left"),
      RIGHT("right");
      private final String n; PartValue(String n) { this.n = n; }
      @Override public String getSerializedName() { return n; }
      @Override public String toString() { return n; }
    }
    public enum TypeValue implements StringRepresentable {
      BASIC_LONG("basic_long"),
      CARPET_LONG("carpet_long"),
      DRAWER_LONG("drawer_long");
      private final String n; TypeValue(String n) { this.n = n; }
      @Override public String getSerializedName() { return n; }
      @Override public String toString() { return n; }
    }
    static final EnumProperty<PartValue> P_PART = EnumProperty.create("part", PartValue.class);
    static final EnumProperty<TypeValue> P_TYPE = EnumProperty.create("type", TypeValue.class);
    public LongTableBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(P_PART, PartValue.LEFT).setValue(P_TYPE, TypeValue.BASIC_LONG));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING, P_PART, P_TYPE);
    }
  }
  public static class LittleTableBlock extends DoorsBlock {
      public enum TypeValue implements StringRepresentable {
      BASIC("basic"),
      DRAWER("drawer"),
      DRAWER_SINGLE("drawer_single");
      private final String n; TypeValue(String n) { this.n = n; }
      @Override public String getSerializedName() { return n; }
      @Override public String toString() { return n; }
    }
    static final EnumProperty<TypeValue> P_TYPE = EnumProperty.create("type", TypeValue.class);
    public LittleTableBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(P_TYPE, TypeValue.BASIC));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING, P_TYPE);
    }
  }
  public static class HotelChestBlock extends DoorsBlock {
      public enum ModeValue implements StringRepresentable {
      BASIC("basic"),
      LOCKED("locked"),
      BRAMBLED("brambled");
      private final String n; ModeValue(String n) { this.n = n; }
      @Override public String getSerializedName() { return n; }
      @Override public String toString() { return n; }
    }
    static final EnumProperty<ModeValue> P_MODE = EnumProperty.create("mode", ModeValue.class);
    public HotelChestBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(P_MODE, ModeValue.BASIC));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING, P_MODE);
    }
  }
  public static class WallLightBlock extends DoorsBlock {
    
    
    public WallLightBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING);
    }
  }
  public static class HotelCeilingLampBlock extends DoorsBlock {
    
    static final BooleanProperty P_CONTINUATION = BooleanProperty.create("continuation");
    public HotelCeilingLampBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(P_CONTINUATION, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(P_CONTINUATION);
    }
  }
  public static class HotelLampBlock extends DoorsBlock {
      public enum PartValue implements StringRepresentable {
      BOTTOM("bottom"),
      MEDIUM("medium"),
      TOP("top");
      private final String n; PartValue(String n) { this.n = n; }
      @Override public String getSerializedName() { return n; }
      @Override public String toString() { return n; }
    }
    static final EnumProperty<PartValue> P_PART = EnumProperty.create("part", PartValue.class);
    public HotelLampBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(P_PART, PartValue.BOTTOM));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(P_PART);
    }
  }
  public static class WoodenBoxBlock extends DoorsBlock {
    
    
    public WoodenBoxBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.AXIS, Direction.Axis.Y));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.AXIS);
    }
  }
  public static class RoomsDoorBlock extends DoorsBlock {
    
    static final IntegerProperty P_LOCKED_REMAIN = IntegerProperty.create("locked_remain", 0, 3);
    public RoomsDoorBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(P_LOCKED_REMAIN, 0).setValue(BlockStateProperties.OPEN, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF, P_LOCKED_REMAIN, BlockStateProperties.OPEN);
    }
  }
  public static class RoomsDoorNumberPlateBlock extends DoorsBlock {
    
    
    public RoomsDoorNumberPlateBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING);
    }
  }
  public static class RoomsLockerBlock extends DoorsBlock {
    
    static final BooleanProperty P_BROKEN = BooleanProperty.create("broken");
    public RoomsLockerBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(P_BROKEN, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF, P_BROKEN);
    }
  }
  public static class ArchivesFlowersBlock extends DoorsBlock {
    
    
    public ArchivesFlowersBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF);
    }
  }
  public static class ArchivesServerBlock extends DoorsBlock {
    
    
    public ArchivesServerBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING);
    }
  }
  public static class ScramblerBlock extends DoorsBlock {
    
    
    public ScramblerBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING);
    }
  }
  public static class BackdoorDoorBlock extends DoorsBlock {
    
    static final BooleanProperty P_DOOR_NUMEROTED = BooleanProperty.create("door_numeroted");
    static final BooleanProperty P_LOCKED = BooleanProperty.create("locked");
    public BackdoorDoorBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(P_DOOR_NUMEROTED, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(P_LOCKED, false).setValue(BlockStateProperties.OPEN, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(P_DOOR_NUMEROTED, BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF, P_LOCKED, BlockStateProperties.OPEN);
    }
  }
  public static class BackdoorLeverBlock extends DoorsBlock {
    
    static final BooleanProperty P_ACTIVATED = BooleanProperty.create("activated");
    public BackdoorLeverBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(P_ACTIVATED, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(P_ACTIVATED, BlockStateProperties.HORIZONTAL_FACING);
    }
  }
  public static class OutdoorDoorBlock extends DoorsBlock {
    
    
    public OutdoorDoorBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.OPEN, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF, BlockStateProperties.OPEN);
    }
  }
  public static class OutdoorWoodenDoorBlock extends DoorsBlock {
    
    
    public OutdoorWoodenDoorBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.OPEN, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF, BlockStateProperties.OPEN);
    }
  }
  public static class MineDoorBlock extends DoorsBlock {
    
    static final BooleanProperty P_DOOR_NUMEROTED = BooleanProperty.create("door_numeroted");
    static final BooleanProperty P_LOCKED = BooleanProperty.create("locked");
    public MineDoorBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(P_DOOR_NUMEROTED, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(P_LOCKED, false).setValue(BlockStateProperties.OPEN, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(P_DOOR_NUMEROTED, BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF, P_LOCKED, BlockStateProperties.OPEN);
    }
  }
  public static class MineAltDoorBlock extends DoorsBlock {
    
    static final BooleanProperty P_DOOR_NUMEROTED = BooleanProperty.create("door_numeroted");
    static final BooleanProperty P_LOCKED = BooleanProperty.create("locked");
    public MineAltDoorBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(P_DOOR_NUMEROTED, false).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(P_LOCKED, false).setValue(BlockStateProperties.OPEN, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(P_DOOR_NUMEROTED, BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF, P_LOCKED, BlockStateProperties.OPEN);
    }
  }
  public static class MineLockerBlock extends DoorsBlock {
      public enum PartValue implements StringRepresentable {
      CLOSET_1("closet_1"),
      CLOSET_2("closet_2"),
      CLOSET_3("closet_3"),
      CLOSET_4("closet_4"),
      CLOSET_5("closet_5"),
      CLOSET_6("closet_6");
      private final String n; PartValue(String n) { this.n = n; }
      @Override public String getSerializedName() { return n; }
      @Override public String toString() { return n; }
    }
    static final EnumProperty<PartValue> P_PART = EnumProperty.create("part", PartValue.class);
    public MineLockerBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(P_PART, PartValue.CLOSET_1));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING, P_PART);
    }
  }
  public static class MineLootLockerBlock extends DoorsBlock {
    
    static final IntegerProperty P_PART = IntegerProperty.create("part", 0, 2);
    public MineLootLockerBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(P_PART, 0));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING, P_PART);
    }
  }
  public static class MineGeneratorBlock extends DoorsBlock {
    
    static final IntegerProperty P_FUSES = IntegerProperty.create("fuses", 0, 3);
    static final BooleanProperty P_POWERED = BooleanProperty.create("powered");
    public MineGeneratorBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(P_FUSES, 0).setValue(P_POWERED, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING, P_FUSES, P_POWERED);
    }
  }
  public static class MinesLampBlock extends DoorsBlock {
    
    
    public MinesLampBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF);
    }
  }
  public static class MinesBulbBlock extends DoorsBlock {
    
    
    public MinesBulbBlock(BlockBehaviour.Properties p) {
      super(p);
      this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
      b.add(BlockStateProperties.HORIZONTAL_FACING);
    }
  }
}
