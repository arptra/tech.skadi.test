package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.Objects;

public final class ManeuverViewLaneAssistance {
    @NonNull
    public List<Lane> lanesForNextManeuver;
    @NonNull
    public List<Lane> lanesForNextNextManeuver;

    public ManeuverViewLaneAssistance(@NonNull List<Lane> list, @NonNull List<Lane> list2) {
        this.lanesForNextManeuver = list;
        this.lanesForNextNextManeuver = list2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ManeuverViewLaneAssistance)) {
            return false;
        }
        ManeuverViewLaneAssistance maneuverViewLaneAssistance = (ManeuverViewLaneAssistance) obj;
        return Objects.equals(this.lanesForNextManeuver, maneuverViewLaneAssistance.lanesForNextManeuver) && Objects.equals(this.lanesForNextNextManeuver, maneuverViewLaneAssistance.lanesForNextNextManeuver);
    }

    public int hashCode() {
        List<Lane> list = this.lanesForNextManeuver;
        int i = 0;
        int hashCode = (217 + (list != null ? list.hashCode() : 0)) * 31;
        List<Lane> list2 = this.lanesForNextNextManeuver;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }
}
