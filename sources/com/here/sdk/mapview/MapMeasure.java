package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class MapMeasure {
    @NonNull
    public final Kind kind;
    public final double value;

    public enum Kind {
        DISTANCE(0),
        ZOOM_LEVEL(1),
        SCALE(2);
        
        public final int value;

        private Kind(int i) {
            this.value = i;
        }
    }

    public MapMeasure(@NonNull Kind kind2, double d) {
        MapMeasure create = create(kind2, d);
        this.kind = create.kind;
        this.value = create.value;
    }

    private static native MapMeasure create(@NonNull Kind kind2, double d);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapMeasure)) {
            return false;
        }
        MapMeasure mapMeasure = (MapMeasure) obj;
        return Objects.equals(this.kind, mapMeasure.kind) && Double.compare(this.value, mapMeasure.value) == 0;
    }

    public int hashCode() {
        Kind kind2 = this.kind;
        return ((217 + (kind2 != null ? kind2.hashCode() : 0)) * 31) + ((int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32)));
    }
}
