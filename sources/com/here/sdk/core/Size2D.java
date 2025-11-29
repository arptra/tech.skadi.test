package com.here.sdk.core;

public final class Size2D {
    public double height;
    public double width;

    public Size2D() {
        this.width = 0.0d;
        this.height = 0.0d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Size2D)) {
            return false;
        }
        Size2D size2D = (Size2D) obj;
        return Double.compare(this.width, size2D.width) == 0 && Double.compare(this.height, size2D.height) == 0;
    }

    public int hashCode() {
        return ((217 + ((int) (Double.doubleToLongBits(this.width) ^ (Double.doubleToLongBits(this.width) >>> 32)))) * 31) + ((int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32)));
    }

    public Size2D(double d, double d2) {
        this.width = d;
        this.height = d2;
    }
}
