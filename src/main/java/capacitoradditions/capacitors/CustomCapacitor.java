package capacitoradditions.capacitors;

import com.enderio.enderio.api.EnderIOAPI;
import com.enderio.enderio.api.capacitor.CapacitorData;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class CustomCapacitor extends Item {

    private static final DeferredHolder<DataComponentType<?>, DataComponentType<CapacitorData>> CAPACITOR_DATA =
            DeferredHolder.create(Registries.DATA_COMPONENT_TYPE, Identifier.fromNamespaceAndPath(EnderIOAPI.MOD_ID, "capacitor_data"));

    private final Supplier<CapacitorData> capacitorDataSupplier;

    public CustomCapacitor(Properties properties, Supplier<CapacitorData> capacitorDataSupplier) {
        super(properties);
        this.capacitorDataSupplier = capacitorDataSupplier;
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = super.getDefaultInstance();
        applyCapacitorData(stack);
        return stack;
    }

    @Override
    public void onCraftedBy(ItemStack stack, Player player) {
        super.onCraftedBy(stack, player);
        applyCapacitorData(stack);
    }

    @Override
    public void onCraftedPostProcess(ItemStack stack, Level level) {
        super.onCraftedPostProcess(stack, level);
        applyCapacitorData(stack);
    }

    private void applyCapacitorData(ItemStack stack) {
        if (CAPACITOR_DATA.isBound()) {
            stack.set(CAPACITOR_DATA.value(), capacitorDataSupplier.get());
        }
    }
}
