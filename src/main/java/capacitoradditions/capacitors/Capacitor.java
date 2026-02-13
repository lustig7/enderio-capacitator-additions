package capacitoradditions.capacitors;

import com.enderio.enderio.api.capacitor.CapacitorData;
import net.enderio.capacitoradditions.Config;

public class Capacitor {
    public static CapacitorData ALLTHEMODIUM_CAPACITOR_DATA() { return CapacitorData.simple(Config.ALLTHEMODIUM_BOOST.get().floatValue()); }
    public static CapacitorData VIBRANIUM_CAPACITOR_DATA() { return CapacitorData.simple(Config.VIBRANIUM_BOOST.get().floatValue()); }
    public static CapacitorData UNOBTAINIUM_CAPACITOR_DATA() { return CapacitorData.simple(Config.UNOBTAINIUM_BOOST.get().floatValue()); }
}
