package androidx.constraintlayout.core.motion.utils;

public class StopLogicEngine implements StopEngine {

    /* renamed from: a  reason: collision with root package name */
    public float f511a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public int j;
    public String k;
    public boolean l = false;
    public float m;
    public float n;
    public boolean o = false;

    public float a() {
        return this.l ? -d(this.n) : d(this.n);
    }

    public final float b(float f2) {
        this.o = false;
        float f3 = this.d;
        if (f2 <= f3) {
            float f4 = this.f511a;
            return (f4 * f2) + ((((this.b - f4) * f2) * f2) / (f3 * 2.0f));
        }
        int i2 = this.j;
        if (i2 == 1) {
            return this.g;
        }
        float f5 = f2 - f3;
        float f6 = this.e;
        if (f5 < f6) {
            float f7 = this.g;
            float f8 = this.b;
            return f7 + (f8 * f5) + ((((this.c - f8) * f5) * f5) / (f6 * 2.0f));
        } else if (i2 == 2) {
            return this.h;
        } else {
            float f9 = f5 - f6;
            float f10 = this.f;
            if (f9 <= f10) {
                float f11 = this.h;
                float f12 = this.c;
                return (f11 + (f12 * f9)) - (((f12 * f9) * f9) / (f10 * 2.0f));
            }
            this.o = true;
            return this.i;
        }
    }

    public void c(float f2, float f3, float f4, float f5, float f6, float f7) {
        boolean z = false;
        this.o = false;
        this.m = f2;
        if (f2 > f3) {
            z = true;
        }
        this.l = z;
        if (z) {
            e(-f4, f2 - f3, f6, f7, f5);
        } else {
            e(f4, f3 - f2, f6, f7, f5);
        }
    }

    public float d(float f2) {
        float f3;
        float f4;
        float f5 = this.d;
        if (f2 <= f5) {
            f3 = this.f511a;
            f4 = this.b;
        } else {
            int i2 = this.j;
            if (i2 == 1) {
                return 0.0f;
            }
            f2 -= f5;
            f5 = this.e;
            if (f2 < f5) {
                f3 = this.b;
                f4 = this.c;
            } else if (i2 == 2) {
                return this.h;
            } else {
                float f6 = f2 - f5;
                float f7 = this.f;
                if (f6 >= f7) {
                    return this.i;
                }
                float f8 = this.c;
                return f8 - ((f6 * f8) / f7);
            }
        }
        return f3 + (((f4 - f3) * f2) / f5);
    }

    public final void e(float f2, float f3, float f4, float f5, float f6) {
        this.o = false;
        if (f2 == 0.0f) {
            f2 = 1.0E-4f;
        }
        this.f511a = f2;
        float f7 = f2 / f4;
        float f8 = (f7 * f2) / 2.0f;
        if (f2 < 0.0f) {
            float sqrt = (float) Math.sqrt((double) ((f3 - ((((-f2) / f4) * f2) / 2.0f)) * f4));
            if (sqrt < f5) {
                this.k = "backward accelerate, decelerate";
                this.j = 2;
                this.f511a = f2;
                this.b = sqrt;
                this.c = 0.0f;
                float f9 = (sqrt - f2) / f4;
                this.d = f9;
                this.e = sqrt / f4;
                this.g = ((f2 + sqrt) * f9) / 2.0f;
                this.h = f3;
                this.i = f3;
                return;
            }
            this.k = "backward accelerate cruse decelerate";
            this.j = 3;
            this.f511a = f2;
            this.b = f5;
            this.c = f5;
            float f10 = (f5 - f2) / f4;
            this.d = f10;
            float f11 = f5 / f4;
            this.f = f11;
            float f12 = ((f2 + f5) * f10) / 2.0f;
            float f13 = (f11 * f5) / 2.0f;
            this.e = ((f3 - f12) - f13) / f5;
            this.g = f12;
            this.h = f3 - f13;
            this.i = f3;
        } else if (f8 >= f3) {
            this.k = "hard stop";
            this.j = 1;
            this.f511a = f2;
            this.b = 0.0f;
            this.g = f3;
            this.d = (2.0f * f3) / f2;
        } else {
            float f14 = f3 - f8;
            float f15 = f14 / f2;
            if (f15 + f7 < f6) {
                this.k = "cruse decelerate";
                this.j = 2;
                this.f511a = f2;
                this.b = f2;
                this.c = 0.0f;
                this.g = f14;
                this.h = f3;
                this.d = f15;
                this.e = f7;
                return;
            }
            float sqrt2 = (float) Math.sqrt((double) ((f4 * f3) + ((f2 * f2) / 2.0f)));
            float f16 = (sqrt2 - f2) / f4;
            this.d = f16;
            float f17 = sqrt2 / f4;
            this.e = f17;
            if (sqrt2 < f5) {
                this.k = "accelerate decelerate";
                this.j = 2;
                this.f511a = f2;
                this.b = sqrt2;
                this.c = 0.0f;
                this.d = f16;
                this.e = f17;
                this.g = ((f2 + sqrt2) * f16) / 2.0f;
                this.h = f3;
                return;
            }
            this.k = "accelerate cruse decelerate";
            this.j = 3;
            this.f511a = f2;
            this.b = f5;
            this.c = f5;
            float f18 = (f5 - f2) / f4;
            this.d = f18;
            float f19 = f5 / f4;
            this.f = f19;
            float f20 = ((f2 + f5) * f18) / 2.0f;
            float f21 = (f19 * f5) / 2.0f;
            this.e = ((f3 - f20) - f21) / f5;
            this.g = f20;
            this.h = f3 - f21;
            this.i = f3;
        }
    }

    public float getInterpolation(float f2) {
        float b2 = b(f2);
        this.n = f2;
        boolean z = this.l;
        float f3 = this.m;
        return z ? f3 - b2 : f3 + b2;
    }

    public boolean isStopped() {
        return a() < 1.0E-5f && Math.abs(this.i - this.n) < 1.0E-5f;
    }
}
