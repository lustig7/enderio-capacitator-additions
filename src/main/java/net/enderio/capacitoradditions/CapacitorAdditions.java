package net.enderio.capacitoradditions;

import capacitoradditions.CapacitorItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CapacitorAdditions.MOD_ID)
public class CapacitorAdditions {

    public static final String MOD_ID = "capacitoradditions";

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CAPACITOR_TAB = CREATIVE_MODE_TABS
            .register("capacitor_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("tab.capacitoradditions.capacitor"))

                    .icon(() -> CapacitorItems.unobtainium_capacitor.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(CapacitorItems.allthemodium_capacitor.get());
                        output.accept(CapacitorItems.vibranium_capacitor.get());
                        output.accept(CapacitorItems.unobtainium_capacitor.get());

                    }).build());

    public CapacitorAdditions(IEventBus modEventBus, ModContainer modContainer) {
        // Register configuration FIRST before registering items
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        modEventBus.addListener(this::commonSetup);

        CapacitorItems.register(modEventBus);

        CREATIVE_MODE_TABS.register(modEventBus);

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

    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
