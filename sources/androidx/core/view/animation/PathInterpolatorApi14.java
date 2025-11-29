package androidx.core.view.animation;

import android.view.animation.Interpolator;

class PathInterpolatorApi14 implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f935a;
    public final float[] b;

    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.f935a.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f935a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.f935a;
        float f2 = fArr[length];
        float f3 = fArr[i];
        float f4 = f2 - f3;
        if (f4 == 0.0f) {
            return this.b[i];
        }
        float[] fArr2 = this.b;
        float f5 = fArr2[i];
        return f5 + (((f - f3) / f4) * (fArr2[length] - f5));
    }
}
