package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.Location;
import java.util.Objects;

public final class NavigableLocation {
    @Nullable
    public MapMatchedLocation mapMatchedLocation;
    @NonNull
    public Location originalLocation;

    public NavigableLocation(@NonNull Location location, @Nullable MapMatchedLocation mapMatchedLocation2) {
        this.originalLocation = location;
        this.mapMatchedLocation = mapMatchedLocation2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NavigableLocation)) {
            return false;
        }
        NavigableLocation navigableLocation = (NavigableLocation) obj;
        return Objects.equals(this.originalLocation, navigableLocation.originalLocation) && Objects.equals(this.mapMatchedLocation, navigableLocation.mapMatchedLocation);
    }

    public int hashCode() {
        Location location = this.originalLocation;
        int i = 0;
        int hashCode = (217 + (location != null ? location.hashCode() : 0)) * 31;
        MapMatchedLocation mapMatchedLocation2 = this.mapMatchedLocation;
        if (mapMatchedLocation2 != null) {
            i = mapMatchedLocation2.hashCode();
        }
        return hashCode + i;
    }
}
