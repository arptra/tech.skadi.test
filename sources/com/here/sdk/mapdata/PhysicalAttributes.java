package com.here.sdk.mapdata;

public final class PhysicalAttributes {
    public boolean isBridge = false;
    public boolean isDirtRoad = false;
    public boolean isDividedRoad = false;
    public boolean isPrivate = false;
    public boolean isRoundabout = false;
    public boolean isTunnel = false;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PhysicalAttributes)) {
            return false;
        }
        PhysicalAttributes physicalAttributes = (PhysicalAttributes) obj;
        return this.isDirtRoad == physicalAttributes.isDirtRoad && this.isTunnel == physicalAttributes.isTunnel && this.isBridge == physicalAttributes.isBridge && this.isPrivate == physicalAttributes.isPrivate && this.isDividedRoad == physicalAttributes.isDividedRoad && this.isRoundabout == physicalAttributes.isRoundabout;
    }

    public int hashCode() {
        int i = 97;
        int i2 = (((((((((217 + (this.isDirtRoad ? 79 : 97)) * 31) + (this.isTunnel ? 79 : 97)) * 31) + (this.isBridge ? 79 : 97)) * 31) + (this.isPrivate ? 79 : 97)) * 31) + (this.isDividedRoad ? 79 : 97)) * 31;
        if (this.isRoundabout) {
            i = 79;
        }
        return i2 + i;
    }
}
