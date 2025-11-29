package com.here.sdk.core;

import androidx.annotation.NonNull;

public final class AngleRange {
    public final double extent;
    public final double start;

    public AngleRange(double d, double d2) {
        AngleRange fromDegreesClockwise = fromDegreesClockwise(d, d2);
        this.start = fromDegreesClockwise.start;
        this.extent = fromDegreesClockwise.extent;
    }

    private static native AngleRange fromDegreesClockwise(double d, double d2);

    @NonNull
    public static native AngleRange fromDirectionDegreesClockwise(double d, double d2);

    @NonNull
    public static native AngleRange fromMinMaxDegreesClockwise(double d, double d2);

    private static native AngleRange fullCircle();

    public native double closestInRange(double d);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AngleRange)) {
            return false;
        }
        AngleRange angleRange = (AngleRange) obj;
        return Double.compare(this.start, angleRange.start) == 0 && Double.compare(this.extent, angleRange.extent) == 0;
    }

    public int hashCode() {
        return ((217 + ((int) (Double.doubleToLongBits(this.start) ^ (Double.doubleToLongBits(this.start) >>> 32)))) * 31) + ((int) (Double.doubleToLongBits(this.extent) ^ (Double.doubleToLongBits(this.extent) >>> 32)));
    }

    public native boolean inRange(double d);

    public native double max();

    public AngleRange() {
        AngleRange fullCircle = fullCircle();
        this.start = fullCircle.start;
        this.extent = fullCircle.extent;
    }
}
