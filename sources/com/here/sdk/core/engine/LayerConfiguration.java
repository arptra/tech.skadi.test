package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class LayerConfiguration {
    @NonNull
    public List<Feature> enabledFeatures;

    public enum Feature {
        DETAIL_RENDERING(0),
        NAVIGATION(1),
        OFFLINE_SEARCH(2),
        OFFLINE_ROUTING(3),
        RENDERING(4),
        TRUCK(5),
        LANDMARKS_3D(6),
        TRAFFIC(7),
        EV(8),
        TRUCK_SERVICE_ATTRIBUTES(9),
        FUEL_STATION_ATTRIBUTES(10),
        OFFLINE_BUS_ROUTING(11),
        JUNCTION_VIEW_3X4(12),
        JUNCTION_VIEW_16X9(13),
        JUNCTION_SIGN_3X4(14),
        JUNCTION_SIGN_3X5(15),
        JUNCTION_SIGN_4X3(16),
        JUNCTION_SIGN_5X3(17),
        JUNCTION_SIGN_16X9(18),
        TERRAIN(19),
        ADAS(20),
        EHORIZON(21);
        
        public final int value;

        private Feature(int i) {
            this.value = i;
        }
    }

    public LayerConfiguration() {
        this.enabledFeatures = new ArrayList();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LayerConfiguration)) {
            return false;
        }
        return Objects.equals(this.enabledFeatures, ((LayerConfiguration) obj).enabledFeatures);
    }

    public int hashCode() {
        List<Feature> list = this.enabledFeatures;
        return 217 + (list != null ? list.hashCode() : 0);
    }

    public LayerConfiguration(@NonNull List<Feature> list) {
        this.enabledFeatures = list;
    }
}
