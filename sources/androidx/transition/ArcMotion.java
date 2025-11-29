package androidx.transition;

import android.graphics.Path;

public class ArcMotion extends PathMotion {
    public static final float d = ((float) Math.tan(Math.toRadians(35.0d)));

    /* renamed from: a  reason: collision with root package name */
    public float f1824a;
    public float b;
    public float c;

    public Path getPath(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        Path path = new Path();
        path.moveTo(f, f2);
        float f10 = f3 - f;
        float f11 = f4 - f2;
        float f12 = (f10 * f10) + (f11 * f11);
        float f13 = (f + f3) / 2.0f;
        float f14 = (f2 + f4) / 2.0f;
        float f15 = 0.25f * f12;
        boolean z = f2 > f4;
        if (Math.abs(f10) < Math.abs(f11)) {
            float abs = Math.abs(f12 / (f11 * 2.0f));
            if (z) {
                f6 = abs + f4;
                f5 = f3;
            } else {
                f6 = abs + f2;
                f5 = f;
            }
            f7 = this.b;
        } else {
            float f16 = f12 / (f10 * 2.0f);
            if (z) {
                f9 = f2;
                f8 = f16 + f;
            } else {
                f8 = f3 - f16;
                f9 = f4;
            }
            f7 = this.f1824a;
        }
        float f17 = f15 * f7 * f7;
        float f18 = f13 - f5;
        float f19 = f14 - f6;
        float f20 = (f18 * f18) + (f19 * f19);
        float f21 = this.c;
        float f22 = f15 * f21 * f21;
        if (f20 >= f17) {
            f17 = f20 > f22 ? f22 : 0.0f;
        }
        if (f17 != 0.0f) {
            float sqrt = (float) Math.sqrt((double) (f17 / f20));
            f5 = ((f5 - f13) * sqrt) + f13;
            f6 = f14 + (sqrt * (f6 - f14));
        }
        path.cubicTo((f + f5) / 2.0f, (f2 + f6) / 2.0f, (f5 + f3) / 2.0f, (f6 + f4) / 2.0f, f3, f4);
        return path;
    }
}
