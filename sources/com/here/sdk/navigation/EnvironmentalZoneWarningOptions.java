package com.here.sdk.navigation;

import com.google.android.gms.common.ConnectionResult;

public final class EnvironmentalZoneWarningOptions {
    public int highwayWarningDistanceInMeters = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
    public int ruralWarningDistanceInMeters = 750;
    public int urbanWarningDistanceInMeters = 500;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EnvironmentalZoneWarningOptions)) {
            return false;
        }
        EnvironmentalZoneWarningOptions environmentalZoneWarningOptions = (EnvironmentalZoneWarningOptions) obj;
        return this.highwayWarningDistanceInMeters == environmentalZoneWarningOptions.highwayWarningDistanceInMeters && this.ruralWarningDistanceInMeters == environmentalZoneWarningOptions.ruralWarningDistanceInMeters && this.urbanWarningDistanceInMeters == environmentalZoneWarningOptions.urbanWarningDistanceInMeters;
    }

    public int hashCode() {
        return ((((217 + this.highwayWarningDistanceInMeters) * 31) + this.ruralWarningDistanceInMeters) * 31) + this.urbanWarningDistanceInMeters;
    }
}
