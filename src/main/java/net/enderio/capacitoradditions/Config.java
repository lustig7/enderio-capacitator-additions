package net.enderio.capacitoradditions;

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
}
