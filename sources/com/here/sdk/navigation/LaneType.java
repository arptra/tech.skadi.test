package com.here.sdk.navigation;

public final class LaneType {
    public boolean isAcceleration;
    public boolean isAuxiliary;
    public boolean isBicycle;
    public boolean isCenterTurn;
    public boolean isDeceleration;
    public boolean isExpress;
    public boolean isHighOccupancyVehicle;
    public boolean isParking;
    public boolean isPassing;
    public boolean isRegular;
    public boolean isRegulatedAccess;
    public boolean isReversible;
    public boolean isShoulder;
    public boolean isSlow;
    public boolean isTruckParking;
    public boolean isTurn;
    public boolean isVariableDriving;

    public LaneType(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17) {
        this.isRegular = z;
        this.isHighOccupancyVehicle = z2;
        this.isReversible = z3;
        this.isExpress = z4;
        this.isAcceleration = z5;
        this.isDeceleration = z6;
        this.isAuxiliary = z7;
        this.isSlow = z8;
        this.isPassing = z9;
        this.isShoulder = z10;
        this.isRegulatedAccess = z11;
        this.isTurn = z12;
        this.isCenterTurn = z13;
        this.isTruckParking = z14;
        this.isParking = z15;
        this.isVariableDriving = z16;
        this.isBicycle = z17;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaneType)) {
            return false;
        }
        LaneType laneType = (LaneType) obj;
        return this.isRegular == laneType.isRegular && this.isHighOccupancyVehicle == laneType.isHighOccupancyVehicle && this.isReversible == laneType.isReversible && this.isExpress == laneType.isExpress && this.isAcceleration == laneType.isAcceleration && this.isDeceleration == laneType.isDeceleration && this.isAuxiliary == laneType.isAuxiliary && this.isSlow == laneType.isSlow && this.isPassing == laneType.isPassing && this.isShoulder == laneType.isShoulder && this.isRegulatedAccess == laneType.isRegulatedAccess && this.isTurn == laneType.isTurn && this.isCenterTurn == laneType.isCenterTurn && this.isTruckParking == laneType.isTruckParking && this.isParking == laneType.isParking && this.isVariableDriving == laneType.isVariableDriving && this.isBicycle == laneType.isBicycle;
    }

    public int hashCode() {
        int i = 97;
        int i2 = (((((((((((((((((((((((((((((((217 + (this.isRegular ? 79 : 97)) * 31) + (this.isHighOccupancyVehicle ? 79 : 97)) * 31) + (this.isReversible ? 79 : 97)) * 31) + (this.isExpress ? 79 : 97)) * 31) + (this.isAcceleration ? 79 : 97)) * 31) + (this.isDeceleration ? 79 : 97)) * 31) + (this.isAuxiliary ? 79 : 97)) * 31) + (this.isSlow ? 79 : 97)) * 31) + (this.isPassing ? 79 : 97)) * 31) + (this.isShoulder ? 79 : 97)) * 31) + (this.isRegulatedAccess ? 79 : 97)) * 31) + (this.isTurn ? 79 : 97)) * 31) + (this.isCenterTurn ? 79 : 97)) * 31) + (this.isTruckParking ? 79 : 97)) * 31) + (this.isParking ? 79 : 97)) * 31) + (this.isVariableDriving ? 79 : 97)) * 31;
        if (this.isBicycle) {
            i = 79;
        }
        return i2 + i;
    }
}
