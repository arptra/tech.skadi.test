package androidx.constraintlayout.core.motion.utils;

public class SpringStopEngine implements StopEngine {

    /* renamed from: a  reason: collision with root package name */
    public double f510a = 0.5d;
    public boolean b = false;
    public double c;
    public double d;
    public double e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public int k = 0;

    public float a() {
        return 0.0f;
    }

    public final void b(double d2) {
        double d3 = this.c;
        double d4 = this.f510a;
        int sqrt = (int) ((9.0d / ((Math.sqrt(d3 / ((double) this.i)) * d2) * 4.0d)) + 1.0d);
        double d5 = d2 / ((double) sqrt);
        int i2 = 0;
        while (i2 < sqrt) {
            float f2 = this.g;
            double d6 = this.d;
            float f3 = this.h;
            double d7 = d3;
            float f4 = this.i;
            double d8 = d4;
            double d9 = ((double) f3) + ((((((-d3) * (((double) f2) - d6)) - (((double) f3) * d4)) / ((double) f4)) * d5) / 2.0d);
            double d10 = ((((-((((double) f2) + ((d5 * d9) / 2.0d)) - d6)) * d7) - (d9 * d8)) / ((double) f4)) * d5;
            float f5 = (float) (((double) f3) + d10);
            this.h = f5;
            float f6 = (float) (((double) f2) + ((((double) f3) + (d10 / 2.0d)) * d5));
            this.g = f6;
            int i3 = this.k;
            if (i3 > 0) {
                if (f6 < 0.0f && (i3 & 1) == 1) {
                    this.g = -f6;
                    this.h = -f5;
                }
                float f7 = this.g;
                if (f7 > 1.0f && (i3 & 2) == 2) {
                    this.g = 2.0f - f7;
                    this.h = -this.h;
                }
            }
            i2++;
            d3 = d7;
            d4 = d8;
        }
    }

    public void c(float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i2) {
        this.d = (double) f3;
        this.f510a = (double) f7;
        this.b = false;
        this.g = f2;
        this.e = (double) f4;
        this.c = (double) f6;
        this.i = f5;
        this.j = f8;
        this.k = i2;
        this.f = 0.0f;
    }

    public float getInterpolation(float f2) {
        b((double) (f2 - this.f));
        this.f = f2;
        return this.g;
    }

    public boolean isStopped() {
        double d2 = ((double) this.g) - this.d;
        double d3 = this.c;
        double d4 = (double) this.h;
        return Math.sqrt((((d4 * d4) * ((double) this.i)) + ((d3 * d2) * d2)) / d3) <= ((double) this.j);
    }
}
