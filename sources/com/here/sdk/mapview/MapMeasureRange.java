package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.sdk.mapview.MapMeasure;
import java.util.Objects;

public final class MapMeasureRange {
    @NonNull
    public final MapMeasure.Kind kind;
    public final double maximumValue;
    public final double minimumValue;

    public MapMeasureRange(@NonNull MapMeasure.Kind kind2, double d, double d2) {
        MapMeasureRange create = create(kind2, d, d2);
        this.kind = create.kind;
        this.minimumValue = create.minimumValue;
        this.maximumValue = create.maximumValue;
    }

    private static native MapMeasureRange create(@NonNull MapMeasure.Kind kind2, double d, double d2);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapMeasureRange)) {
            return false;
        }
        MapMeasureRange mapMeasureRange = (MapMeasureRange) obj;
        return Objects.equals(this.kind, mapMeasureRange.kind) && Double.compare(this.minimumValue, mapMeasureRange.minimumValue) == 0 && Double.compare(this.maximumValue, mapMeasureRange.maximumValue) == 0;
    }

    public int hashCode() {
        MapMeasure.Kind kind2 = this.kind;
        return ((((217 + (kind2 != null ? kind2.hashCode() : 0)) * 31) + ((int) (Double.doubleToLongBits(this.minimumValue) ^ (Double.doubleToLongBits(this.minimumValue) >>> 32)))) * 31) + ((int) (Double.doubleToLongBits(this.maximumValue) ^ (Double.doubleToLongBits(this.maximumValue) >>> 32)));
    }
}
