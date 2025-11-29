package com.here.sdk.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.time.Duration;
import java.util.Date;
import java.util.Objects;

public final class Location {
    @Nullable
    public Double bearingAccuracyInDegrees = null;
    @Nullable
    public Double bearingInDegrees = null;
    @NonNull
    public GeoCoordinates coordinates;
    @Nullable
    public Duration gnssTime = null;
    @Nullable
    public Double horizontalAccuracyInMeters = null;
    @Nullable
    public LocationTechnology locationTechnology = null;
    @Nullable
    public Double speedAccuracyInMetersPerSecond = null;
    @Nullable
    public Double speedInMetersPerSecond = null;
    public Date time = null;
    @Nullable
    public Duration timestampSinceBoot = null;
    @Nullable
    public Double verticalAccuracyInMeters = null;

    public Location(@NonNull GeoCoordinates geoCoordinates) {
        this.coordinates = geoCoordinates;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Location)) {
            return false;
        }
        Location location = (Location) obj;
        return Objects.equals(this.coordinates, location.coordinates) && Objects.equals(this.bearingInDegrees, location.bearingInDegrees) && Objects.equals(this.speedInMetersPerSecond, location.speedInMetersPerSecond) && Objects.equals(this.time, location.time) && Objects.equals(this.horizontalAccuracyInMeters, location.horizontalAccuracyInMeters) && Objects.equals(this.verticalAccuracyInMeters, location.verticalAccuracyInMeters) && Objects.equals(this.bearingAccuracyInDegrees, location.bearingAccuracyInDegrees) && Objects.equals(this.speedAccuracyInMetersPerSecond, location.speedAccuracyInMetersPerSecond) && Objects.equals(this.timestampSinceBoot, location.timestampSinceBoot) && Objects.equals(this.locationTechnology, location.locationTechnology) && Objects.equals(this.gnssTime, location.gnssTime);
    }

    public int hashCode() {
        GeoCoordinates geoCoordinates = this.coordinates;
        int i = 0;
        int hashCode = (217 + (geoCoordinates != null ? geoCoordinates.hashCode() : 0)) * 31;
        Double d = this.bearingInDegrees;
        int hashCode2 = (hashCode + (d != null ? d.hashCode() : 0)) * 31;
        Double d2 = this.speedInMetersPerSecond;
        int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 31;
        Date date = this.time;
        int hashCode4 = (hashCode3 + (date != null ? date.hashCode() : 0)) * 31;
        Double d3 = this.horizontalAccuracyInMeters;
        int hashCode5 = (hashCode4 + (d3 != null ? d3.hashCode() : 0)) * 31;
        Double d4 = this.verticalAccuracyInMeters;
        int hashCode6 = (hashCode5 + (d4 != null ? d4.hashCode() : 0)) * 31;
        Double d5 = this.bearingAccuracyInDegrees;
        int hashCode7 = (hashCode6 + (d5 != null ? d5.hashCode() : 0)) * 31;
        Double d6 = this.speedAccuracyInMetersPerSecond;
        int hashCode8 = (hashCode7 + (d6 != null ? d6.hashCode() : 0)) * 31;
        Duration duration = this.timestampSinceBoot;
        int hashCode9 = (hashCode8 + (duration != null ? duration.hashCode() : 0)) * 31;
        LocationTechnology locationTechnology2 = this.locationTechnology;
        int hashCode10 = (hashCode9 + (locationTechnology2 != null ? locationTechnology2.hashCode() : 0)) * 31;
        Duration duration2 = this.gnssTime;
        if (duration2 != null) {
            i = duration2.hashCode();
        }
        return hashCode10 + i;
    }
}
