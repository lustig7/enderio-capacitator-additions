package item.grindingball;


import com.enderio.base.api.grindingball.GrindingBallData;

/**
 * Predefined grinding balls for the mod.
 */
public class GrindingBall {

    /**
     * Allthemodium Grinding Ball
     */
    public static final GrindingBallData ALLTHEMODIUM_GRINDBALL = new GrindingBallData(
        1.8f,    // outputMultiplier
        2.0f,    // bonusMultiplier
        1.4f,    // powerUse
        90000      // durability
    );

    /**
     * Vibranium Grinding Ball
     */
    public static final GrindingBallData VIBRANIUM_GRINDBALL = new GrindingBallData(
        2.0f,    // outputMultiplier
        4.0f,    // bonusMultiplier
        2.0f,    // powerUse
        240000      // durability
    );

    /**
     * Unobtainium Grinding Ball
     */
    public static final GrindingBallData UNOBTAINIUM_GRINDBALL = new GrindingBallData(
        3.0f,    // outputMultiplier - exceptional output
        2.0f,    // bonusMultiplier
        1.0f,    // powerUse
        300000      // durability
    );

    /**
     * Infinite Durability Grinding Ball
     * An unlimited grinding ball with infinite durability.
     * Uses the highest possible float value for effectively infinite lifespan.
     */
    public static final GrindingBallData INFINITE_GRINDBALL = new GrindingBallData(
        3.0f,    // outputMultiplier
        3.0f,    // bonusMultiplier
        3.0f,    // powerUse
        Integer.MAX_VALUE // durability - highest possible integer (2,147,483,647)
    );
}
