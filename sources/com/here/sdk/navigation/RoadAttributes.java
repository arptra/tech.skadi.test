package com.here.sdk.navigation;

public final class RoadAttributes {
    public boolean isBridge = false;
    public boolean isControlledAccess = false;
    public boolean isDirtRoad = false;
    public boolean isDividedRoad = false;
    public boolean isNoThrough = false;
    public boolean isPrivate = false;
    public boolean isRamp = false;
    public boolean isRightDrivingSide = false;
    public boolean isRoundabout = false;
    public boolean isTollway = false;
    public boolean isTunnel = false;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RoadAttributes)) {
            return false;
        }
        RoadAttributes roadAttributes = (RoadAttributes) obj;
        return this.isDirtRoad == roadAttributes.isDirtRoad && this.isTunnel == roadAttributes.isTunnel && this.isBridge == roadAttributes.isBridge && this.isRamp == roadAttributes.isRamp && this.isControlledAccess == roadAttributes.isControlledAccess && this.isPrivate == roadAttributes.isPrivate && this.isNoThrough == roadAttributes.isNoThrough && this.isTollway == roadAttributes.isTollway && this.isDividedRoad == roadAttributes.isDividedRoad && this.isRightDrivingSide == roadAttributes.isRightDrivingSide && this.isRoundabout == roadAttributes.isRoundabout;
    }

    public int hashCode() {
        int i = 97;
        int i2 = (((((((((((((((((((217 + (this.isDirtRoad ? 79 : 97)) * 31) + (this.isTunnel ? 79 : 97)) * 31) + (this.isBridge ? 79 : 97)) * 31) + (this.isRamp ? 79 : 97)) * 31) + (this.isControlledAccess ? 79 : 97)) * 31) + (this.isPrivate ? 79 : 97)) * 31) + (this.isNoThrough ? 79 : 97)) * 31) + (this.isTollway ? 79 : 97)) * 31) + (this.isDividedRoad ? 79 : 97)) * 31) + (this.isRightDrivingSide ? 79 : 97)) * 31;
        if (this.isRoundabout) {
            i = 79;
        }
        return i2 + i;
    }
}
