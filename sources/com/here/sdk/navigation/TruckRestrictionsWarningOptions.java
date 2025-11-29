package com.here.sdk.navigation;

import com.google.android.gms.common.ConnectionResult;

public final class TruckRestrictionsWarningOptions {
    public boolean filterOutInactiveTimeDependentRestrictions = false;
    public int highwayWarningDistanceInMeters = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
    public int ruralWarningDistanceInMeters = 750;
    public int urbanWarningDistanceInMeters = 500;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TruckRestrictionsWarningOptions)) {
            return false;
        }
        TruckRestrictionsWarningOptions truckRestrictionsWarningOptions = (TruckRestrictionsWarningOptions) obj;
        return this.filterOutInactiveTimeDependentRestrictions == truckRestrictionsWarningOptions.filterOutInactiveTimeDependentRestrictions && this.highwayWarningDistanceInMeters == truckRestrictionsWarningOptions.highwayWarningDistanceInMeters && this.ruralWarningDistanceInMeters == truckRestrictionsWarningOptions.ruralWarningDistanceInMeters && this.urbanWarningDistanceInMeters == truckRestrictionsWarningOptions.urbanWarningDistanceInMeters;
    }

    public int hashCode() {
        return ((((((217 + (this.filterOutInactiveTimeDependentRestrictions ? 79 : 97)) * 31) + this.highwayWarningDistanceInMeters) * 31) + this.ruralWarningDistanceInMeters) * 31) + this.urbanWarningDistanceInMeters;
    }
}
