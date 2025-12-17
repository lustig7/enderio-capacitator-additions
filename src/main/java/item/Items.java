package item;

import item.capacitors.Capacitor;
import item.capacitors.CustomCapacitor;
import item.grindingball.CustomGrindingBall;
import item.grindingball.GrindingBall;
import net.enderio.capacitoradditions.CapacitorAdditions;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {

        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CapacitorAdditions.MOD_ID);

        public static final DeferredItem<Item> allthemodium_capacitor = ITEMS.register(
                        "allthemodium_capacitor",
                        () -> new CustomCapacitor(new Item.Properties(),
                                        Capacitor.ALLTHEMODIUM_CAPACITOR_DATA));

        public static final DeferredItem<Item> unobtainium_capacitor = ITEMS.register(
                        "unobtainium_capacitor",
                        () -> new CustomCapacitor(new Item.Properties(),
                                        Capacitor.UNOBTAINIUM_CAPACITOR_DATA));

        public static final DeferredItem<Item> vibranium_capacitor = ITEMS.register(
                "vibranium_capacitor",
                () -> new CustomCapacitor(new Item.Properties(),
                        Capacitor.VIBRANIUM_CAPACITOR_DATA));

        public static final DeferredItem<Item> allthemodium_grindstone = ITEMS.register(
                        "allthemodium_grindstone",
                        () -> new CustomGrindingBall(new Item.Properties(),
                                GrindingBall.ALLTHEMODIUM_GRINDBALL));

        public static final DeferredItem<Item> vibranium_grindstone = ITEMS.register(
                "vibranium_grindstone",
                () -> new CustomGrindingBall(new Item.Properties(),
                        GrindingBall.VIBRANIUM_GRINDBALL));

        public static final DeferredItem<Item> unobtainium_grindstone = ITEMS.register(
                "unobtainium_grindstone",
                () -> new CustomGrindingBall(new Item.Properties(),
                        GrindingBall.UNOBTAINIUM_GRINDBALL));

        public static final DeferredItem<Item> infinite_grindstone = ITEMS.register(
            "infinite_grindstone",
            () -> new CustomGrindingBall(new Item.Properties(),
                    GrindingBall.INFINITE_GRINDBALL));


        public static void register(IEventBus eventBus) {
                ITEMS.register(eventBus);
        }
}
