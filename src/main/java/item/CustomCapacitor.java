package item;

import com.enderio.base.api.capacitor.CapacitorData;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import net.enderio.capacitoradditions.component.ModDataComponents;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class CustomCapacitor extends Item {
    private final DataComponentType<CapacitorData> dataType;
    private final CapacitorData capacitorData;

    public CustomCapacitor(Properties properties, DataComponentType<CapacitorData> dataType, CapacitorData capacitorData) {
        super(properties);
        this.dataType = dataType;
        this.capacitorData = capacitorData;
    }


    @NotNull
    public CapacitorData getCapacitorData(@NotNull ItemStack stack) {
        // Return the capacitor data tied to this item
        return capacitorData;
    }

    public DataComponentType<CapacitorData> getDataType() {
        return dataType;
    }

    @Override
    public void verifyComponentsAfterLoad(ItemStack stack) {
        if(stack.get(ModDataComponents.CAPACITOR_DATA_TYPE) == null) {
            stack.set(ModDataComponents.CAPACITOR_DATA_TYPE, getCapacitorData(stack));
        }

    }


}
