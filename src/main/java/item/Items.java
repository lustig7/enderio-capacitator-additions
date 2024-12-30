package item;

import block.CustomBank;
import net.enderio.capacitoradditions.CapacitorAdditions;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


import static net.enderio.capacitoradditions.component.ModDataComponents.CAPACITOR_DATA_TYPE;

public class Items {

        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CapacitorAdditions.MOD_ID);



        public static final DeferredItem<Item> allthemodium_capacitor = ITEMS.register(
                        "allthemodium_capacitor",
                        () -> new CustomCapacitor(new Item.Properties(), CAPACITOR_DATA_TYPE.get(),
                                        Capacitor.ALLTHEMODIUM_CAPACITOR_DATA));

        public static final DeferredItem<Item> unobtainium_capacitor = ITEMS.register(
                        "unobtainium_capacitor",
                        () -> new CustomCapacitor(new Item.Properties(), CAPACITOR_DATA_TYPE.get(),
                                        Capacitor.UNOBTAINIUM_CAPACITOR_DATA));

        public static final DeferredItem<Item> vibranium_capacitor = ITEMS.register(
                "vibranium_capacitor",
                () -> new CustomCapacitor(new Item.Properties(), CAPACITOR_DATA_TYPE.get(),
                        Capacitor.VIBRANIUM_CAPACITOR_DATA));





        public static void register(IEventBus eventBus) {
                ITEMS.register(eventBus);

        }
}
