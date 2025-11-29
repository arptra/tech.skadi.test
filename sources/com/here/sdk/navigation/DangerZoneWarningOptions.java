package com.here.sdk.navigation;

import com.google.android.gms.common.ConnectionResult;

public final class DangerZoneWarningOptions {
    public int highwayWarningDistanceInMeters = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
    public int ruralWarningDistanceInMeters = 750;
    public int urbanWarningDistanceInMeters = 500;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DangerZoneWarningOptions)) {
            return false;
        }
        DangerZoneWarningOptions dangerZoneWarningOptions = (DangerZoneWarningOptions) obj;
        return this.highwayWarningDistanceInMeters == dangerZoneWarningOptions.highwayWarningDistanceInMeters && this.ruralWarningDistanceInMeters == dangerZoneWarningOptions.ruralWarningDistanceInMeters && this.urbanWarningDistanceInMeters == dangerZoneWarningOptions.urbanWarningDistanceInMeters;
    }

    public int hashCode() {
        return ((((217 + this.highwayWarningDistanceInMeters) * 31) + this.ruralWarningDistanceInMeters) * 31) + this.urbanWarningDistanceInMeters;
    }
}
