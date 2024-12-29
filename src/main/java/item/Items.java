package item;

import com.enderio.base.api.capacitor.CapacitorData;
import com.enderio.regilite.holder.RegiliteItem;
import net.enderio.capacitoradditions.CapacitorAdditions;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class Items {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CapacitorAdditions.MOD_ID);

    public static final DeferredItem<Item> vibranium_capacitor = ITEMS.register(
            "vibranium_capacitor",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> allthemodium_capacitor = ITEMS.register(
            "allthemodium_capacitor",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> unobtanium_capacitor = ITEMS.register(
            "unobtanium_capacitor",
            () -> new Item(new Item.Properties()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
