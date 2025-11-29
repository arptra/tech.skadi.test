package com.here.sdk.navigation;

public final class SpatialTrajectoryData {
    public double azimuthInDegrees;
    public boolean completedSpatialTrajectory;

    public SpatialTrajectoryData(double d, boolean z) {
        this.azimuthInDegrees = d;
        this.completedSpatialTrajectory = z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpatialTrajectoryData)) {
            return false;
        }
        SpatialTrajectoryData spatialTrajectoryData = (SpatialTrajectoryData) obj;
        return Double.compare(this.azimuthInDegrees, spatialTrajectoryData.azimuthInDegrees) == 0 && this.completedSpatialTrajectory == spatialTrajectoryData.completedSpatialTrajectory;
    }

    public int hashCode() {
        return ((217 + ((int) (Double.doubleToLongBits(this.azimuthInDegrees) ^ (Double.doubleToLongBits(this.azimuthInDegrees) >>> 32)))) * 31) + (this.completedSpatialTrajectory ? 79 : 97);
    }
}
