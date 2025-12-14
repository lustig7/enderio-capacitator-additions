package item;

import java.util.Map;

public class CapacitorData {
    private final int baseValue;
    private final Map<CapacitorModifier, Float> modifiers;

    public CapacitorData(int baseValue, Map<CapacitorModifier, Float> modifiers) {
        this.baseValue = baseValue;
        this.modifiers = modifiers;
    }


    public float base() {
        return baseValue;
    }

    public Map<CapacitorModifier, Float> modifiers() {
        return modifiers;
    }
}
