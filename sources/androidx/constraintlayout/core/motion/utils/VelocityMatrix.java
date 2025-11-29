package androidx.constraintlayout.core.motion.utils;

public class VelocityMatrix {

    /* renamed from: a  reason: collision with root package name */
    public float f513a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;

    public void a(float f2, float f3, int i, int i2, float[] fArr) {
        int i3 = i;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = (f2 - 0.5f) * 2.0f;
        float f7 = (f3 - 0.5f) * 2.0f;
        float f8 = f4 + this.c;
        float f9 = f5 + this.d;
        float f10 = f8 + (this.f513a * f6);
        float f11 = f9 + (this.b * f7);
        float radians = (float) Math.toRadians((double) this.e);
        double radians2 = (double) ((float) Math.toRadians((double) this.f));
        double d2 = (double) (((float) i2) * f7);
        fArr[0] = f10 + (((float) ((((double) (((float) (-i3)) * f6)) * Math.sin(radians2)) - (Math.cos(radians2) * d2))) * radians);
        fArr[1] = f11 + (radians * ((float) ((((double) (((float) i3) * f6)) * Math.cos(radians2)) - (d2 * Math.sin(radians2)))));
    }

    public void b() {
        this.e = 0.0f;
        this.d = 0.0f;
        this.c = 0.0f;
        this.b = 0.0f;
        this.f513a = 0.0f;
    }

    public void c(KeyCycleOscillator keyCycleOscillator, float f2) {
        if (keyCycleOscillator != null) {
            this.e = keyCycleOscillator.b(f2);
        }
    }

    public void d(SplineSet splineSet, float f2) {
        if (splineSet != null) {
            this.e = splineSet.b(f2);
            this.f = splineSet.a(f2);
        }
    }

    public void e(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f2) {
        if (keyCycleOscillator != null) {
            this.f513a = keyCycleOscillator.b(f2);
        }
        if (keyCycleOscillator2 != null) {
            this.b = keyCycleOscillator2.b(f2);
        }
    }

    public void f(SplineSet splineSet, SplineSet splineSet2, float f2) {
        if (splineSet != null) {
            this.f513a = splineSet.b(f2);
        }
        if (splineSet2 != null) {
            this.b = splineSet2.b(f2);
        }
    }

    public void g(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f2) {
        if (keyCycleOscillator != null) {
            this.c = keyCycleOscillator.b(f2);
        }
        if (keyCycleOscillator2 != null) {
            this.d = keyCycleOscillator2.b(f2);
        }
    }

    public void h(SplineSet splineSet, SplineSet splineSet2, float f2) {
        if (splineSet != null) {
            this.c = splineSet.b(f2);
        }
        if (splineSet2 != null) {
            this.d = splineSet2.b(f2);
        }
    }
}
