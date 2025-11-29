package com.here.sdk.core;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class PickedPlace {
    @NonNull
    public GeoCoordinates coordinates;
    @NonNull
    public String name;
    @NonNull
    public String placeCategoryId;

    public PickedPlace(@NonNull String str, @NonNull GeoCoordinates geoCoordinates, @NonNull String str2) {
        this.name = str;
        this.coordinates = geoCoordinates;
        this.placeCategoryId = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PickedPlace)) {
            return false;
        }
        PickedPlace pickedPlace = (PickedPlace) obj;
        return Objects.equals(this.name, pickedPlace.name) && Objects.equals(this.coordinates, pickedPlace.coordinates) && Objects.equals(this.placeCategoryId, pickedPlace.placeCategoryId);
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        GeoCoordinates geoCoordinates = this.coordinates;
        int hashCode2 = (hashCode + (geoCoordinates != null ? geoCoordinates.hashCode() : 0)) * 31;
        String str2 = this.placeCategoryId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }
}
