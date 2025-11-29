package com.here.sdk.venue.data;

import androidx.annotation.NonNull;

final class Vector2D {
    public double x = 0.0d;
    public double y = 0.0d;

    public static native double dot(@NonNull Vector2D vector2D, @NonNull Vector2D vector2D2);

    @NonNull
    public static native Vector2D scale(@NonNull Vector2D vector2D, @NonNull Vector2D vector2D2);

    @NonNull
    public native Vector2D add(@NonNull Vector2D vector2D);

    public native double angle(@NonNull Vector2D vector2D);

    @NonNull
    public native Vector2D divide(double d);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Vector2D)) {
            return false;
        }
        Vector2D vector2D = (Vector2D) obj;
        return Double.compare(this.x, vector2D.x) == 0 && Double.compare(this.y, vector2D.y) == 0;
    }

    public int hashCode() {
        return ((217 + ((int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32)))) * 31) + ((int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32)));
    }

    public native double length();

    @NonNull
    public native Vector2D multiply(double d);

    @NonNull
    public native Vector2D normalize();

    @NonNull
    public native Vector2D rotate(double d);

    @NonNull
    public native Vector2D subtract(@NonNull Vector2D vector2D);
}
