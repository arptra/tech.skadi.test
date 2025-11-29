package com.here.sdk.navigation;

public final class LaneDirectionCategory {
    public boolean hardLeft;
    public boolean hardRight;
    public boolean quiteLeft;
    public boolean quiteRight;
    public boolean slightlyLeft;
    public boolean slightlyRight;
    public boolean straight;
    public boolean uTurnLeft;
    public boolean uTurnRight;

    public LaneDirectionCategory(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.straight = z;
        this.slightlyLeft = z2;
        this.quiteLeft = z3;
        this.hardLeft = z4;
        this.uTurnLeft = z5;
        this.slightlyRight = z6;
        this.quiteRight = z7;
        this.hardRight = z8;
        this.uTurnRight = z9;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaneDirectionCategory)) {
            return false;
        }
        LaneDirectionCategory laneDirectionCategory = (LaneDirectionCategory) obj;
        return this.straight == laneDirectionCategory.straight && this.slightlyLeft == laneDirectionCategory.slightlyLeft && this.quiteLeft == laneDirectionCategory.quiteLeft && this.hardLeft == laneDirectionCategory.hardLeft && this.uTurnLeft == laneDirectionCategory.uTurnLeft && this.slightlyRight == laneDirectionCategory.slightlyRight && this.quiteRight == laneDirectionCategory.quiteRight && this.hardRight == laneDirectionCategory.hardRight && this.uTurnRight == laneDirectionCategory.uTurnRight;
    }

    public int hashCode() {
        int i = 97;
        int i2 = (((((((((((((((217 + (this.straight ? 79 : 97)) * 31) + (this.slightlyLeft ? 79 : 97)) * 31) + (this.quiteLeft ? 79 : 97)) * 31) + (this.hardLeft ? 79 : 97)) * 31) + (this.uTurnLeft ? 79 : 97)) * 31) + (this.slightlyRight ? 79 : 97)) * 31) + (this.quiteRight ? 79 : 97)) * 31) + (this.hardRight ? 79 : 97)) * 31;
        if (this.uTurnRight) {
            i = 79;
        }
        return i2 + i;
    }
}
