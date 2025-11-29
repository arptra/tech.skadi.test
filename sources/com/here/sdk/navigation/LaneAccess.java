package com.here.sdk.navigation;

public final class LaneAccess {
    public boolean automobiles;
    public boolean buses;
    public boolean carpools;
    public boolean deliveryVehicles;
    public boolean emergencyVehicles;
    public boolean motorcycles;
    public boolean pedestrians;
    public boolean taxis;
    public boolean throughTraffic;
    public boolean trucks;

    public LaneAccess(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.automobiles = z;
        this.buses = z2;
        this.taxis = z3;
        this.carpools = z4;
        this.pedestrians = z5;
        this.trucks = z6;
        this.throughTraffic = z7;
        this.deliveryVehicles = z8;
        this.emergencyVehicles = z9;
        this.motorcycles = z10;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaneAccess)) {
            return false;
        }
        LaneAccess laneAccess = (LaneAccess) obj;
        return this.automobiles == laneAccess.automobiles && this.buses == laneAccess.buses && this.taxis == laneAccess.taxis && this.carpools == laneAccess.carpools && this.pedestrians == laneAccess.pedestrians && this.trucks == laneAccess.trucks && this.throughTraffic == laneAccess.throughTraffic && this.deliveryVehicles == laneAccess.deliveryVehicles && this.emergencyVehicles == laneAccess.emergencyVehicles && this.motorcycles == laneAccess.motorcycles;
    }

    public int hashCode() {
        int i = 97;
        int i2 = (((((((((((((((((217 + (this.automobiles ? 79 : 97)) * 31) + (this.buses ? 79 : 97)) * 31) + (this.taxis ? 79 : 97)) * 31) + (this.carpools ? 79 : 97)) * 31) + (this.pedestrians ? 79 : 97)) * 31) + (this.trucks ? 79 : 97)) * 31) + (this.throughTraffic ? 79 : 97)) * 31) + (this.deliveryVehicles ? 79 : 97)) * 31) + (this.emergencyVehicles ? 79 : 97)) * 31;
        if (this.motorcycles) {
            i = 79;
        }
        return i2 + i;
    }
}
