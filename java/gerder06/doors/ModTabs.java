package gerder06.doors;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;

import java.util.List;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.Item;

public class ModTabs {
  public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DoorsMod.MODID);

  static {
    for (String id : new String[] {"hotel", "mines", "rooms", "archives", "stairwell", "backdoors", "outdoors", "halloween", "doors"}) {
      TABS.register(id, () -> CreativeModeTab.builder()
          .title(Component.translatable("itemGroup." + id))
          .icon(() -> {
            List<RegistryObject<Item>> l = ModItems.BY_TAB.get(id);
            return l == null || l.isEmpty() ? new ItemStack(net.minecraft.world.item.Items.OAK_DOOR) : new ItemStack(l.get(0).get());
          })
          .displayItems((params, out) -> {
            List<RegistryObject<Item>> l = ModItems.BY_TAB.get(id);
            if (l != null) l.forEach(o -> out.accept(o.get()));
          })
          .build());
    }
  }
}
