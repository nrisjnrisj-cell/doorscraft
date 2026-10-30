package gerder06.doors;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import gerder06.doors.blocks.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/** Port of 1.16.5 ItemInit. Items are registered with their original models/textures; behaviours are NOT ported (see README). */
public class ModItems {
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DoorsMod.MODID);
  public static final Map<String, RegistryObject<Item>> ALL = new LinkedHashMap<>();
  /** creative tab id -> items (tab assignment is a best guess from item names). */
  public static final Map<String, java.util.List<RegistryObject<Item>>> BY_TAB = new LinkedHashMap<>();

  private static void reg(String name, String tab, Supplier<Item> s) {
    RegistryObject<Item> o = ITEMS.register(name, s);
    ALL.put(name, o);
    BY_TAB.computeIfAbsent(tab, k -> new java.util.ArrayList<>()).add(o);
  }

  static {
    reg("hotel_number_plate", "hotel", () -> new Item(new Item.Properties()));
    reg("hotel_door_modifier", "hotel", () -> new Item(new Item.Properties()));
    reg("sound_ambient_block", "doors", () -> new BlockItem(ModBlocks.ALL.get("sound_ambient_block").get(), new Item.Properties()));
    reg("super_hard_mode_modifier", "doors", () -> new Item(new Item.Properties()));
    reg("candy_mischevious", "halloween", () -> new Item(new Item.Properties()));
    reg("candy_moon", "halloween", () -> new Item(new Item.Properties()));
    reg("candy_starlight", "halloween", () -> new Item(new Item.Properties()));
    reg("candy_other_1", "halloween", () -> new Item(new Item.Properties()));
    reg("candy_other_2", "halloween", () -> new Item(new Item.Properties()));
    reg("candy_other_3", "halloween", () -> new Item(new Item.Properties()));
    reg("candy_other_4", "halloween", () -> new Item(new Item.Properties()));
    reg("candy_other_5", "halloween", () -> new Item(new Item.Properties()));
    reg("candy_other_6", "halloween", () -> new Item(new Item.Properties()));
    reg("hotel_door", "hotel", () -> new BlockItem(ModBlocks.ALL.get("hotel_door").get(), new Item.Properties()));
    reg("green_house_door", "hotel", () -> new BlockItem(ModBlocks.ALL.get("green_house_door").get(), new Item.Properties()));
    reg("skeleton_door", "hotel", () -> new BlockItem(ModBlocks.ALL.get("skeleton_door").get(), new Item.Properties()));
    reg("electrical_door", "hotel", () -> new BlockItem(ModBlocks.ALL.get("electrical_door").get(), new Item.Properties()));
    reg("starlight_gateway", "hotel", () -> new BlockItem(ModBlocks.ALL.get("starlight_gateway").get(), new Item.Properties()));
    reg("hotel_closet", "hotel", () -> new BlockItem(ModBlocks.ALL.get("hotel_closet").get(), new Item.Properties()));
    reg("toolsheds_closet", "hotel", () -> new BlockItem(ModBlocks.ALL.get("toolsheds_closet").get(), new Item.Properties()));
    reg("hotel_bookshelf", "hotel", () -> new BlockItem(ModBlocks.ALL.get("hotel_bookshelf").get(), new Item.Properties()));
    reg("elevator_door", "hotel", () -> new BlockItem(ModBlocks.ALL.get("elevator_door").get(), new Item.Properties()));
    reg("long_table", "hotel", () -> new BlockItem(ModBlocks.ALL.get("long_table").get(), new Item.Properties()));
    reg("little_table", "hotel", () -> new BlockItem(ModBlocks.ALL.get("little_table").get(), new Item.Properties()));
    reg("hotel_chest", "hotel", () -> new BlockItem(ModBlocks.ALL.get("hotel_chest").get(), new Item.Properties()));
    reg("wall_light", "hotel", () -> new BlockItem(ModBlocks.ALL.get("wall_light").get(), new Item.Properties()));
    reg("hotel_ceiling_lamp", "hotel", () -> new BlockItem(ModBlocks.ALL.get("hotel_ceiling_lamp").get(), new Item.Properties()));
    reg("hotel_lamp", "hotel", () -> new BlockItem(ModBlocks.ALL.get("hotel_lamp").get(), new Item.Properties()));
    reg("wooden_box", "hotel", () -> new BlockItem(ModBlocks.ALL.get("wooden_box").get(), new Item.Properties()));
    reg("hotel_key", "hotel", () -> new Item(new Item.Properties()));
    reg("electrical_key", "hotel", () -> new Item(new Item.Properties()));
    reg("skeleton_key", "hotel", () -> new Item(new Item.Properties()));
    reg("lighter", "doors", () -> new Item(new Item.Properties().stacksTo(1)));
    reg("flashlight", "doors", () -> new Item(new Item.Properties().stacksTo(1)));
    reg("lockpick", "hotel", () -> new Item(new Item.Properties().stacksTo(1)));
    reg("hotel_candle", "hotel", () -> new Item(new Item.Properties().stacksTo(1)));
    reg("vitamins", "hotel", () -> new Item(new Item.Properties()));
    reg("battery", "hotel", () -> new Item(new Item.Properties()));
    reg("bandage", "hotel", () -> new Item(new Item.Properties()));
    reg("crucifix", "hotel", () -> new Item(new Item.Properties().stacksTo(1)));
    reg("crucifix_used", "hotel", () -> new Item(new Item.Properties().stacksTo(1)));
    reg("crucifix_failed", "hotel", () -> new Item(new Item.Properties().stacksTo(1)));
    reg("shears", "hotel", () -> new Item(new Item.Properties().stacksTo(1)));
    reg("herb_of_viridis", "hotel", () -> new BlockItem(ModBlocks.ALL.get("herb_of_viridis").get(), new Item.Properties()));
    reg("bramble", "hotel", () -> new BlockItem(ModBlocks.ALL.get("bramble").get(), new Item.Properties()));
    reg("mine_door", "mines", () -> new BlockItem(ModBlocks.ALL.get("mine_door").get(), new Item.Properties()));
    reg("mine_alt_door", "mines", () -> new BlockItem(ModBlocks.ALL.get("mine_alt_door").get(), new Item.Properties()));
    reg("mine_locker", "mines", () -> new BlockItem(ModBlocks.ALL.get("mine_locker").get(), new Item.Properties()));
    reg("mine_loot_locker", "mines", () -> new BlockItem(ModBlocks.ALL.get("mine_loot_locker").get(), new Item.Properties()));
    reg("mine_generator", "mines", () -> new BlockItem(ModBlocks.ALL.get("mine_generator").get(), new Item.Properties()));
    reg("fuse", "hotel", () -> new Item(new Item.Properties()));
    reg("mines_lamp", "mines", () -> new BlockItem(ModBlocks.ALL.get("mines_lamp").get(), new Item.Properties()));
    reg("mines_bulb", "mines", () -> new BlockItem(ModBlocks.ALL.get("mines_bulb").get(), new Item.Properties()));
    reg("bulklight", "doors", () -> new Item(new Item.Properties().stacksTo(1)));
    reg("straplight", "doors", () -> new Item(new Item.Properties().stacksTo(1)));
    reg("rooms_wall", "rooms", () -> new BlockItem(ModBlocks.ALL.get("rooms_wall").get(), new Item.Properties()));
    reg("rooms_door", "rooms", () -> new BlockItem(ModBlocks.ALL.get("rooms_door").get(), new Item.Properties()));
    reg("rooms_door_number_plate", "rooms", () -> new BlockItem(ModBlocks.ALL.get("rooms_door_number_plate").get(), new Item.Properties()));
    reg("rooms_locker", "rooms", () -> new BlockItem(ModBlocks.ALL.get("rooms_locker").get(), new Item.Properties()));
    reg("starlight_jug", "doors", () -> new Item(new Item.Properties()));
    reg("starlight_bottle", "doors", () -> new Item(new Item.Properties()));
    reg("starlight_vial", "doors", () -> new Item(new Item.Properties()));
    reg("shakelight", "doors", () -> new Item(new Item.Properties().stacksTo(1)));
    reg("archives_flowers", "archives", () -> new BlockItem(ModBlocks.ALL.get("archives_flowers").get(), new Item.Properties()));
    reg("archives_server", "archives", () -> new BlockItem(ModBlocks.ALL.get("archives_server").get(), new Item.Properties()));
    reg("archives_plant", "archives", () -> new BlockItem(ModBlocks.ALL.get("archives_plant").get(), new Item.Properties()));
    reg("marble", "archives", () -> new BlockItem(ModBlocks.ALL.get("marble").get(), new Item.Properties()));
    reg("water_cup", "archives", () -> new Item(new Item.Properties()));
    reg("archives_number", "archives", () -> new Item(new Item.Properties()));
    reg("ironscrap", "archives", () -> new Item(new Item.Properties()));
    reg("scrambler", "archives", () -> new BlockItem(ModBlocks.ALL.get("scrambler").get(), new Item.Properties()));
    reg("pack_bottle_item", "archives", () -> new Item(new Item.Properties()));
    reg("computer_item", "archives", () -> new Item(new Item.Properties()));
    reg("lamp_item", "doors", () -> new Item(new Item.Properties()));
    reg("backdoor_door", "backdoors", () -> new BlockItem(ModBlocks.ALL.get("backdoor_door").get(), new Item.Properties()));
    reg("backdoor_key", "backdoors", () -> new Item(new Item.Properties()));
    reg("backdoor_lever", "backdoors", () -> new BlockItem(ModBlocks.ALL.get("backdoor_lever").get(), new Item.Properties()));
    reg("outdoor_door", "outdoors", () -> new BlockItem(ModBlocks.ALL.get("outdoor_door").get(), new Item.Properties()));
    reg("outdoor_wooden_door", "outdoors", () -> new BlockItem(ModBlocks.ALL.get("outdoor_wooden_door").get(), new Item.Properties()));
    reg("lantern", "doors", () -> new Item(new Item.Properties().stacksTo(1)));
    reg("holy_hand_grenade", "doors", () -> new Item(new Item.Properties().stacksTo(1)));
    reg("small_shield_potion", "doors", () -> new Item(new Item.Properties().stacksTo(1)));
    reg("large_shield_potion", "doors", () -> new Item(new Item.Properties().stacksTo(1)));
  }
}
