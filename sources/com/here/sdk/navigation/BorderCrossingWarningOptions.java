package com.here.sdk.navigation;

import com.google.android.gms.common.ConnectionResult;

public final class BorderCrossingWarningOptions {
    public boolean filterOutStateBorderWarnings = false;
    public int highwayWarningDistanceInMeters = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
    public int ruralWarningDistanceInMeters = 750;
    public int urbanWarningDistanceInMeters = 500;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BorderCrossingWarningOptions)) {
            return false;
        }
        BorderCrossingWarningOptions borderCrossingWarningOptions = (BorderCrossingWarningOptions) obj;
        return this.filterOutStateBorderWarnings == borderCrossingWarningOptions.filterOutStateBorderWarnings && this.highwayWarningDistanceInMeters == borderCrossingWarningOptions.highwayWarningDistanceInMeters && this.ruralWarningDistanceInMeters == borderCrossingWarningOptions.ruralWarningDistanceInMeters && this.urbanWarningDistanceInMeters == borderCrossingWarningOptions.urbanWarningDistanceInMeters;
    }

    public int hashCode() {
        return ((((((217 + (this.filterOutStateBorderWarnings ? 79 : 97)) * 31) + this.highwayWarningDistanceInMeters) * 31) + this.ruralWarningDistanceInMeters) * 31) + this.urbanWarningDistanceInMeters;
    }
}
