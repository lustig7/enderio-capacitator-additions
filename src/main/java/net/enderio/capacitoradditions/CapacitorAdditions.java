package net.enderio.capacitoradditions;

import com.enderio.base.api.capacitor.CapacitorData;
import com.mojang.logging.LogUtils;
import item.Items;
import net.enderio.capacitoradditions.component.ModDataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.InterModComms;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import java.util.Map;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CapacitorAdditions.MOD_ID)
public class CapacitorAdditions {

    public static final String MOD_ID = "capacitatoradditions";

    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CAPACITOR_TAB = CREATIVE_MODE_TABS
            .register("capacitor_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("tab.capacitatoradditions.capacitor"))

                    .icon(() -> Items.unobtainium_capacitor.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(Items.unobtainium_capacitor.get());
                        output.accept(Items.allthemodium_capacitor.get());
                        output.accept(Items.vibranium_capacitor.get());
                    }).build());

    public CapacitorAdditions(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);

        Items.register(modEventBus);

        CREATIVE_MODE_TABS.register(modEventBus);
        ModDataComponents.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::enqueueIMC);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    private void enqueueIMC(final InterModEnqueueEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
