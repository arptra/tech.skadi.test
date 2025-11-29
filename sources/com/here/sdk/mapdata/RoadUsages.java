package com.here.sdk.mapdata;

public final class RoadUsages {
    public boolean isControlledAccess = false;
    public boolean isRamp = false;
    public boolean isTollway = false;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RoadUsages)) {
            return false;
        }
        RoadUsages roadUsages = (RoadUsages) obj;
        return this.isRamp == roadUsages.isRamp && this.isControlledAccess == roadUsages.isControlledAccess && this.isTollway == roadUsages.isTollway;
    }

    public int hashCode() {
        int i = 97;
        int i2 = (((217 + (this.isRamp ? 79 : 97)) * 31) + (this.isControlledAccess ? 79 : 97)) * 31;
        if (this.isTollway) {
            i = 79;
        }
        return i2 + i;
    }
}
