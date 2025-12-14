package item;

import item.CapacitorModifier;
import net.minecraft.nbt.CompoundTag;
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
        CompoundTag capTag = new CompoundTag();
        capTag.putInt("baseValue", (int) data.base());
        CompoundTag mods = new CompoundTag();
        for (Map.Entry<CapacitorModifier, Float> entry : data.modifiers().entrySet()) {
            mods.putFloat(entry.getKey().name(), entry.getValue());
        }
        capTag.put("modifiers", mods);
        tag.put(CAPACITOR_DATA_TAG, capTag);
    }

    private CapacitorData loadCapacitorDataFromNBT(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        if (tag != null && tag.contains(CAPACITOR_DATA_TAG)) {
            CompoundTag capTag = tag.getCompound(CAPACITOR_DATA_TAG);
            int baseValue = capTag.getInt("baseValue");
            Map<CapacitorModifier, Float> modifiers = new java.util.HashMap<>();
            CompoundTag mods = capTag.getCompound("modifiers");
            for (String key : mods.getAllKeys()) {
                modifiers.put(CapacitorModifier.valueOf(key), mods.getFloat(key));
            }
            return new CapacitorData(baseValue, modifiers);
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