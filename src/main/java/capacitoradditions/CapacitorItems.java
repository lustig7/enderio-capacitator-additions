package capacitoradditions;

import capacitoradditions.capacitors.Capacitor;
import capacitoradditions.capacitors.CustomCapacitor;
import net.enderio.capacitoradditions.CapacitorAdditions;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CapacitorItems {

        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CapacitorAdditions.MOD_ID);

        public static final DeferredItem<Item> allthemodium_capacitor = ITEMS.register(
                        "allthemodium_capacitor",
                        id -> new CustomCapacitor(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, id)),
                                        Capacitor::ALLTHEMODIUM_CAPACITOR_DATA));

        public static final DeferredItem<Item> unobtainium_capacitor = ITEMS.register(
                        "unobtainium_capacitor",
                        id -> new CustomCapacitor(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, id)),
                                        Capacitor::UNOBTAINIUM_CAPACITOR_DATA));

        public static final DeferredItem<Item> vibranium_capacitor = ITEMS.register(
                "vibranium_capacitor",
                id -> new CustomCapacitor(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, id)),
                        Capacitor::VIBRANIUM_CAPACITOR_DATA));


        public static void register(IEventBus eventBus) {
                ITEMS.register(eventBus);
        }
}
