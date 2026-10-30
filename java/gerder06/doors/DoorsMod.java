package gerder06.doors;

import gerder06.doors.blocks.ModBlocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DoorsMod.MODID)
public class DoorsMod {
  public static final String MODID = "doors";

  public DoorsMod() {
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    ModBlocks.BLOCKS.register(bus);
    ModItems.ITEMS.register(bus);
    ModSounds.SOUNDS.register(bus);
    ModTabs.TABS.register(bus);
  }
}
