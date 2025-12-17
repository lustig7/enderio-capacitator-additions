package item.grindingball;

import net.enderio.capacitoradditions.component.ModDataComponents;
import com.enderio.base.api.grindingball.GrindingBallData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CustomGrindingBall extends Item {

    private final GrindingBallData grindingBallData;

    public CustomGrindingBall(Properties properties, GrindingBallData grindingBallData) {
        super(properties);
        this.grindingBallData = grindingBallData;
    }

    public GrindingBallData getGrindingBallData(@NotNull ItemStack stack) {
        return grindingBallData;
    }

    @Override
    public void verifyComponentsAfterLoad(ItemStack stack) {
        if(stack.get(ModDataComponents.GRINDING_BALL_DATA_TYPE.value()) == null) {
            stack.set(ModDataComponents.GRINDING_BALL_DATA_TYPE.value(), getGrindingBallData(stack));
        }
    }
}
