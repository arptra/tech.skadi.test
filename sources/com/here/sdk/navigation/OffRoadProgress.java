package com.here.sdk.navigation;

public final class OffRoadProgress {
    public double bearingInDegrees = 0.0d;
    public int remainingDistanceInMeters = 0;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OffRoadProgress)) {
            return false;
        }
        OffRoadProgress offRoadProgress = (OffRoadProgress) obj;
        return this.remainingDistanceInMeters == offRoadProgress.remainingDistanceInMeters && Double.compare(this.bearingInDegrees, offRoadProgress.bearingInDegrees) == 0;
    }

    public int hashCode() {
        return ((217 + this.remainingDistanceInMeters) * 31) + ((int) (Double.doubleToLongBits(this.bearingInDegrees) ^ (Double.doubleToLongBits(this.bearingInDegrees) >>> 32)));
    }
}
