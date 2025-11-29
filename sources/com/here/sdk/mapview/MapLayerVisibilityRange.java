package com.here.sdk.mapview;

public final class MapLayerVisibilityRange {
    public final double maximumZoomLevel;
    public final double minimumZoomLevel;

    public MapLayerVisibilityRange(double d, double d2) {
        this.minimumZoomLevel = d;
        this.maximumZoomLevel = d2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapLayerVisibilityRange)) {
            return false;
        }
        MapLayerVisibilityRange mapLayerVisibilityRange = (MapLayerVisibilityRange) obj;
        return Double.compare(this.minimumZoomLevel, mapLayerVisibilityRange.minimumZoomLevel) == 0 && Double.compare(this.maximumZoomLevel, mapLayerVisibilityRange.maximumZoomLevel) == 0;
    }

    public int hashCode() {
        return ((217 + ((int) (Double.doubleToLongBits(this.minimumZoomLevel) ^ (Double.doubleToLongBits(this.minimumZoomLevel) >>> 32)))) * 31) + ((int) (Double.doubleToLongBits(this.maximumZoomLevel) ^ (Double.doubleToLongBits(this.maximumZoomLevel) >>> 32)));
    }
}
