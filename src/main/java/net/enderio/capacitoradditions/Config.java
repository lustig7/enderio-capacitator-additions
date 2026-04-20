package net.enderio.capacitoradditions;

import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config
{

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.DoubleValue ALLTHEMODIUM_BOOST = BUILDER
            .comment("Boost Factor for Allthemodium Capacitor")
            .defineInRange("allthemodium_boost", 4.0, 1.0, Float.MAX_VALUE);

    public static final ModConfigSpec.DoubleValue VIBRANIUM_BOOST = BUILDER
            .comment("Boost Factor for Vibranium Capacitor")
            .defineInRange("vibranium_boost", 5.0, 1.0, Float.MAX_VALUE);

    public static final ModConfigSpec.DoubleValue UNOBTAINIUM_BOOST = BUILDER
            .comment("Boost Factor for Unobtainium Capacitor")
            .defineInRange("unobtainium_boost", 6.0, 1.0, Float.MAX_VALUE);

    public static final ModConfigSpec SPEC = BUILDER.build();

    private static float allthemodiumBoostBaked = 4.0F;
    private static float vibraniumBoostBaked = 5.0F;
    private static float unobtainiumBoostBaked = 6.0F;

    public static float allthemodiumBoost() {
        return allthemodiumBoostBaked;
    }

    public static float vibraniumBoost() {
        return vibraniumBoostBaked;
    }

    public static float unobtainiumBoost() {
        return unobtainiumBoostBaked;
    }

    public static void onConfigLoading(final ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec() == SPEC) {
            bake();
        }
    }

    public static void onConfigReloading(final ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec() == SPEC) {
            bake();
        }
    }

    private static void bake() {
        allthemodiumBoostBaked = ALLTHEMODIUM_BOOST.get().floatValue();
        vibraniumBoostBaked = VIBRANIUM_BOOST.get().floatValue();
        unobtainiumBoostBaked = UNOBTAINIUM_BOOST.get().floatValue();
    }
}
