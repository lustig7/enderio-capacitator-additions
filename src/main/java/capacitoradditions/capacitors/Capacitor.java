package capacitoradditions.capacitors;

import com.enderio.enderio.api.capacitor.CapacitorData;
import net.enderio.capacitoradditions.Config;

public class Capacitor {
    public static CapacitorData ALLTHEMODIUM_CAPACITOR_DATA() { return CapacitorData.simple(Config.allthemodiumBoost()); }
    public static CapacitorData VIBRANIUM_CAPACITOR_DATA() { return CapacitorData.simple(Config.vibraniumBoost()); }
    public static CapacitorData UNOBTAINIUM_CAPACITOR_DATA() { return CapacitorData.simple(Config.unobtainiumBoost()); }
}
