package item;

import com.enderio.base.api.capacitor.CapacitorData;
import com.enderio.base.api.registry.EnderIORegistries;
import com.enderio.regilite.holder.RegiliteItem;
import net.enderio.capacitoradditions.CapacitorAdditions;
import net.enderio.capacitoradditions.component.ModDataComponents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.enderio.capacitoradditions.component.ModDataComponents.CAPACITOR_DATA_TYPE;

public class Items {

        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CapacitorAdditions.MOD_ID);

        /*
         * public static Supplier<DataComponentType<CapacitorData>> CAPACITOR_DATA_TYPE
         * = DATA_COMPONENT_TYPES.registerComponentType("capacitor_data",
         * builder ->
         * builder.persistent(CapacitorData.CODEC).networkSynchronized(CapacitorData.
         * STREAM_CODEC));
         */

        public static final DeferredItem<Item> vibranium_capacitor = ITEMS.register(
                        "vibranium_capacitor",
                        () -> new CustomCapacitor(new Item.Properties(), CAPACITOR_DATA_TYPE.get(),
                                        Capacitor.VIBRANIUM_CAPACITOR_DATA));

        public static final DeferredItem<Item> allthemodium_capacitor = ITEMS.register(
                        "allthemodium_capacitor",
                        () -> new CustomCapacitor(new Item.Properties(), CAPACITOR_DATA_TYPE.get(),
                                        Capacitor.ALLTHEMODIUM_CAPACITOR_DATA));

        public static final DeferredItem<Item> unobtainium_capacitor = ITEMS.register(
                        "unobtainium_capacitor",
                        () -> new CustomCapacitor(new Item.Properties(), CAPACITOR_DATA_TYPE.get(),
                                        Capacitor.UNOBTAINIUM_CAPACITOR_DATA));

        /*
         * public static final DeferredItem<Item> vibranium_capacitor = ITEMS.register(
         * "vibranium_capacitor",
         * () -> new CustomCapacitor(new Item.Properties()));
         * 
         * 
         * public static final DeferredItem<Item> allthemodium_capacitor =
         * ITEMS.register(
         * "allthemodium_capacitor",
         * () -> new CustomCapacitor(new Item.Properties()));
         * 
         * public static final DeferredItem<Item> unobtainium_capacitor =
         * ITEMS.register(
         * "unobtainium_capacitor",
         * () -> new CustomCapacitor(new Item.Properties()));
         */

        public static void register(IEventBus eventBus) {
                ITEMS.register(eventBus);
        }
}
