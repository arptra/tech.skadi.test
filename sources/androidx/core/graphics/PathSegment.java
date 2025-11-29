package androidx.core.graphics;

import android.graphics.PointF;

public final class PathSegment {

    /* renamed from: a  reason: collision with root package name */
    public final PointF f716a;
    public final float b;
    public final PointF c;
    public final float d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathSegment)) {
            return false;
        }
        PathSegment pathSegment = (PathSegment) obj;
        return Float.compare(this.b, pathSegment.b) == 0 && Float.compare(this.d, pathSegment.d) == 0 && this.f716a.equals(pathSegment.f716a) && this.c.equals(pathSegment.c);
    }

    public int hashCode() {
        int hashCode = this.f716a.hashCode() * 31;
        float f = this.b;
        int i = 0;
        int floatToIntBits = (((hashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31) + this.c.hashCode()) * 31;
        float f2 = this.d;
        if (f2 != 0.0f) {
            i = Float.floatToIntBits(f2);
        }
        return floatToIntBits + i;
    }

    public String toString() {
        return "PathSegment{start=" + this.f716a + ", startFraction=" + this.b + ", end=" + this.c + ", endFraction=" + this.d + '}';
    }
}
