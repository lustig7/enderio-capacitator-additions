package net.enderio.capacitoradditions.component;

import com.enderio.base.api.capacitor.CapacitorData;
import com.enderio.base.api.grindingball.GrindingBallData;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.UnaryOperator;

public class ModDataComponents {

    private static final DeferredRegister.DataComponents DATA_COMPONENT_TYPES = DeferredRegister.createDataComponents("enderio");

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<CapacitorData>> CAPACITOR_DATA_TYPE = register("capacitor_data",
            builder -> builder.persistent(CapacitorData.CODEC));

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<GrindingBallData>> GRINDING_BALL_DATA_TYPE = register("grinding_ball",
            builder -> builder.persistent(GrindingBallData.CODEC));

    private static <T>DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name,
                                                                                          UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return DATA_COMPONENT_TYPES.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }


    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}
