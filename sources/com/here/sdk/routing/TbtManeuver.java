package com.here.sdk.routing;

final class TbtManeuver {
    public int distanceToNextManeuverInMeters;
    public int linkIndex;

    public TbtManeuver(int i, int i2) {
        this.distanceToNextManeuverInMeters = i;
        this.linkIndex = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TbtManeuver)) {
            return false;
        }
        TbtManeuver tbtManeuver = (TbtManeuver) obj;
        return this.distanceToNextManeuverInMeters == tbtManeuver.distanceToNextManeuverInMeters && this.linkIndex == tbtManeuver.linkIndex;
    }

    public int hashCode() {
        return ((217 + this.distanceToNextManeuverInMeters) * 31) + this.linkIndex;
    }
}
