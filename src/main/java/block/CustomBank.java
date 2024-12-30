package block;

import com.enderio.base.api.capacitor.CapacitorData;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.level.block.Block;

public class CustomBank extends Block {
    private final DataComponentType<CapacitorData> dataType;
    private final CapacitorData capacitorData;

    public CustomBank(Block.Properties properties, DataComponentType<CapacitorData> dataType, CapacitorData capacitorData) {
        super(properties);
        this.dataType = dataType;
        this.capacitorData = capacitorData;
    }
}
