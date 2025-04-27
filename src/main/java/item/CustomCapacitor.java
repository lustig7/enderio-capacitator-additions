package item;


import com.enderio.api.capacitor.CapacitorModifier;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class CustomCapacitor extends Item {
    private static final String CAPACITOR_DATA_TAG = "capacitorData";
    private final CapacitorData capacitorData;

    public CustomCapacitor(Properties properties, CapacitorData capacitorData) {
        super(properties);
        this.capacitorData = capacitorData;
    }

    @NotNull
    public CapacitorData getCapacitorData(@NotNull ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        if (!tag.contains(CAPACITOR_DATA_TAG)) {
            saveCapacitorData(stack, capacitorData);
        }
        return loadCapacitorDataFromNBT(stack);
    }

    private void saveCapacitorData(ItemStack stack, CapacitorData data) {
        CompoundTag tag = stack.getOrCreateTag();
        CapacitorData.CODEC.encodeStart(NbtOps.INSTANCE, data)
                .resultOrPartial(error -> System.err.println("Failed to save capacitor data: " + error))
                .ifPresent(nbt -> tag.put(CAPACITOR_DATA_TAG, nbt));
    }

    private CapacitorData loadCapacitorDataFromNBT(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        if (tag != null && tag.contains(CAPACITOR_DATA_TAG)) {
            return CapacitorData.CODEC.parse(NbtOps.INSTANCE, tag.get(CAPACITOR_DATA_TAG))
                    .resultOrPartial(error -> System.err.println("Failed to load capacitor data: " + error))
                    .orElse(capacitorData);
        }
        return capacitorData;
    }

    @Override
    public void appendHoverText(ItemStack stack, @org.jetbrains.annotations.Nullable net.minecraft.world.level.Level level,
                                @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);

        CapacitorData data = getCapacitorData(stack);

        tooltipComponents.add(Component.literal("Base Multiplier: " + String.format("%.1f", data.base())));

        Map<CapacitorModifier, Float> modifiers = data.modifiers();
        if (!modifiers.isEmpty()) {
            tooltipComponents.add(Component.literal("Specializations:"));
            for (Map.Entry<CapacitorModifier, Float> entry : modifiers.entrySet()) {
                tooltipComponents.add(Component.literal("  " + entry.getKey().toString() + ": " +
                        String.format("%.1f", entry.getValue())));
            }
        }
    }
}