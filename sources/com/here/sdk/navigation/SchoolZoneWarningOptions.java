package com.here.sdk.navigation;

public final class SchoolZoneWarningOptions {
    public boolean filterOutInactiveTimeDependentWarnings = false;
    public int warningDistanceInMeters = 100;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchoolZoneWarningOptions)) {
            return false;
        }
        SchoolZoneWarningOptions schoolZoneWarningOptions = (SchoolZoneWarningOptions) obj;
        return this.filterOutInactiveTimeDependentWarnings == schoolZoneWarningOptions.filterOutInactiveTimeDependentWarnings && this.warningDistanceInMeters == schoolZoneWarningOptions.warningDistanceInMeters;
    }

    public int hashCode() {
        return ((217 + (this.filterOutInactiveTimeDependentWarnings ? 79 : 97)) * 31) + this.warningDistanceInMeters;
    }
}
