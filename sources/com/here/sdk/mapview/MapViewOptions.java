package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.Color;
import java.util.Objects;

public final class MapViewOptions {
    @Nullable
    public Color initialBackgroundColor = null;
    @NonNull
    public MapProjection projection = MapProjection.GLOBE;
    @NonNull
    public MapRenderMode renderMode = MapRenderMode.SURFACE;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapViewOptions)) {
            return false;
        }
        MapViewOptions mapViewOptions = (MapViewOptions) obj;
        return Objects.equals(this.projection, mapViewOptions.projection) && Objects.equals(this.initialBackgroundColor, mapViewOptions.initialBackgroundColor) && Objects.equals(this.renderMode, mapViewOptions.renderMode);
    }

    public int hashCode() {
        MapProjection mapProjection = this.projection;
        int i = 0;
        int hashCode = (217 + (mapProjection != null ? mapProjection.hashCode() : 0)) * 31;
        Color color = this.initialBackgroundColor;
        int hashCode2 = (hashCode + (color != null ? color.hashCode() : 0)) * 31;
        MapRenderMode mapRenderMode = this.renderMode;
        if (mapRenderMode != null) {
            i = mapRenderMode.hashCode();
        }
        return hashCode2 + i;
    }
}
