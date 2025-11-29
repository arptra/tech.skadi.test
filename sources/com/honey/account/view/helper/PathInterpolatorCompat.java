package com.honey.account.view.helper;

import android.view.animation.Interpolator;

public class PathInterpolatorCompat implements Interpolator {
    private int count = 100;
    private float[] mX;
    private float[] mY;
    private float precision = 0.01f;

    public PathInterpolatorCompat(float f, float f2, float f3, float f4) {
        initPath(f, f2, f3, f4);
    }

    private void initPath(float f, float f2, float f3, float f4) {
        int i = this.count;
        this.mX = new float[i];
        this.mY = new float[i];
        float f5 = f * 3.0f;
        float f6 = f3 * 3.0f;
        float f7 = (f5 + 1.0f) - f6;
        float f8 = f6 - (f * 6.0f);
        float f9 = f2 * 3.0f;
        float f10 = f4 * 3.0f;
        float f11 = (1.0f + f9) - f10;
        float f12 = f10 - (f2 * 6.0f);
        float f13 = 0.0f;
        for (int i2 = 0; i2 < this.count; i2++) {
            float f14 = f13 * f13;
            float f15 = f14 * f13;
            this.mX[i2] = (f7 * f15) + (f8 * f14) + (f5 * f13);
            this.mY[i2] = (f15 * f11) + (f14 * f12) + (f9 * f13);
            f13 += this.precision;
        }
    }

    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.mX.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.mX[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.mX;
        float f2 = fArr[length];
        float f3 = fArr[i];
        float f4 = f2 - f3;
        if (f4 == 0.0f) {
            return this.mY[i];
        }
        float[] fArr2 = this.mY;
        float f5 = fArr2[i];
        return f5 + (((f - f3) / f4) * (fArr2[length] - f5));
    }

    public PathInterpolatorCompat(float f, float f2, float f3, float f4, int i) {
        int i2 = 100;
        int i3 = i / 5;
        i2 = i3 > 100 ? i3 : i2;
        this.count = i2;
        this.precision = 1.0f / ((float) i2);
        initPath(f, f2, f3, f4);
    }
}
