package com.here.sdk.mapdata;

public final class AllowedTransportModes {
    public boolean bicycleAllowed = false;
    public boolean busAllowed = false;
    public boolean carAllowed = false;
    public boolean pedestrianAllowed = false;
    public boolean scooterAllowed = false;
    public boolean taxiAllowed = false;
    public boolean truckAllowed = false;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AllowedTransportModes)) {
            return false;
        }
        AllowedTransportModes allowedTransportModes = (AllowedTransportModes) obj;
        return this.bicycleAllowed == allowedTransportModes.bicycleAllowed && this.busAllowed == allowedTransportModes.busAllowed && this.carAllowed == allowedTransportModes.carAllowed && this.pedestrianAllowed == allowedTransportModes.pedestrianAllowed && this.scooterAllowed == allowedTransportModes.scooterAllowed && this.taxiAllowed == allowedTransportModes.taxiAllowed && this.truckAllowed == allowedTransportModes.truckAllowed;
    }

    public int hashCode() {
        int i = 97;
        int i2 = (((((((((((217 + (this.bicycleAllowed ? 79 : 97)) * 31) + (this.busAllowed ? 79 : 97)) * 31) + (this.carAllowed ? 79 : 97)) * 31) + (this.pedestrianAllowed ? 79 : 97)) * 31) + (this.scooterAllowed ? 79 : 97)) * 31) + (this.taxiAllowed ? 79 : 97)) * 31;
        if (this.truckAllowed) {
            i = 79;
        }
        return i2 + i;
    }
}
