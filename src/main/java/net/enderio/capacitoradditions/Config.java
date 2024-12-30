package net.enderio.capacitoradditions;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;

@EventBusSubscriber(modid = CapacitorAdditions.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class Config
{

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
    }
}
