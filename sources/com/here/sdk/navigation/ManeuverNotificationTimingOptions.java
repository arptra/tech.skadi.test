package com.here.sdk.navigation;

public final class ManeuverNotificationTimingOptions {
    public int actionNotificationDistanceInMeters;
    public int actionNotificationTimeInSeconds;
    public int distanceNotificationDistanceInMeters;
    public int distanceNotificationTimeInSeconds;
    public int doubleNotificationDistanceInMeters;
    public int rangeNotificationDistanceInMeters;
    public int rangeNotificationTimeInSeconds;
    public int reminderNotificationDistanceInMeters;
    public int reminderNotificationTimeInSeconds;

    public ManeuverNotificationTimingOptions(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.rangeNotificationDistanceInMeters = i;
        this.rangeNotificationTimeInSeconds = i2;
        this.reminderNotificationDistanceInMeters = i3;
        this.reminderNotificationTimeInSeconds = i4;
        this.distanceNotificationDistanceInMeters = i5;
        this.distanceNotificationTimeInSeconds = i6;
        this.actionNotificationDistanceInMeters = i7;
        this.actionNotificationTimeInSeconds = i8;
        this.doubleNotificationDistanceInMeters = i9;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ManeuverNotificationTimingOptions)) {
            return false;
        }
        ManeuverNotificationTimingOptions maneuverNotificationTimingOptions = (ManeuverNotificationTimingOptions) obj;
        return this.rangeNotificationDistanceInMeters == maneuverNotificationTimingOptions.rangeNotificationDistanceInMeters && this.rangeNotificationTimeInSeconds == maneuverNotificationTimingOptions.rangeNotificationTimeInSeconds && this.reminderNotificationDistanceInMeters == maneuverNotificationTimingOptions.reminderNotificationDistanceInMeters && this.reminderNotificationTimeInSeconds == maneuverNotificationTimingOptions.reminderNotificationTimeInSeconds && this.distanceNotificationDistanceInMeters == maneuverNotificationTimingOptions.distanceNotificationDistanceInMeters && this.distanceNotificationTimeInSeconds == maneuverNotificationTimingOptions.distanceNotificationTimeInSeconds && this.actionNotificationDistanceInMeters == maneuverNotificationTimingOptions.actionNotificationDistanceInMeters && this.actionNotificationTimeInSeconds == maneuverNotificationTimingOptions.actionNotificationTimeInSeconds && this.doubleNotificationDistanceInMeters == maneuverNotificationTimingOptions.doubleNotificationDistanceInMeters;
    }

    public int hashCode() {
        return ((((((((((((((((217 + this.rangeNotificationDistanceInMeters) * 31) + this.rangeNotificationTimeInSeconds) * 31) + this.reminderNotificationDistanceInMeters) * 31) + this.reminderNotificationTimeInSeconds) * 31) + this.distanceNotificationDistanceInMeters) * 31) + this.distanceNotificationTimeInSeconds) * 31) + this.actionNotificationDistanceInMeters) * 31) + this.actionNotificationTimeInSeconds) * 31) + this.doubleNotificationDistanceInMeters;
    }
}
