package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f1335a;
    public final float b;

    public LookupTableInterpolator(float[] fArr) {
        this.f1335a = fArr;
        this.b = 1.0f / ((float) (fArr.length - 1));
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f1335a;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f), fArr.length - 2);
        float f2 = this.b;
        float[] fArr2 = this.f1335a;
        float f3 = fArr2[min];
        return f3 + (((f - (((float) min) * f2)) / f2) * (fArr2[min + 1] - f3));
    }
}
