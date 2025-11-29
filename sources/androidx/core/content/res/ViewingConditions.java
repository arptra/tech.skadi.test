package androidx.core.content.res;

final class ViewingConditions {
    public static final ViewingConditions k = k(CamUtils.c, (float) ((((double) CamUtils.h(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: a  reason: collision with root package name */
    public final float f707a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float[] g;
    public final float h;
    public final float i;
    public final float j;

    public ViewingConditions(float f2, float f3, float f4, float f5, float f6, float f7, float[] fArr, float f8, float f9, float f10) {
        this.f = f2;
        this.f707a = f3;
        this.b = f4;
        this.c = f5;
        this.d = f6;
        this.e = f7;
        this.g = fArr;
        this.h = f8;
        this.i = f9;
        this.j = f10;
    }

    public static ViewingConditions k(float[] fArr, float f2, float f3, float f4, boolean z) {
        float f5 = f2;
        float[][] fArr2 = CamUtils.f695a;
        float f6 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f7 = fArr[1];
        float f8 = fArr[2];
        float f9 = (fArr3[0] * f6) + (fArr3[1] * f7) + (fArr3[2] * f8);
        float[] fArr4 = fArr2[1];
        float f10 = (fArr4[0] * f6) + (fArr4[1] * f7) + (fArr4[2] * f8);
        float[] fArr5 = fArr2[2];
        float f11 = (f6 * fArr5[0]) + (f7 * fArr5[1]) + (f8 * fArr5[2]);
        float f12 = (f4 / 10.0f) + 0.8f;
        float d2 = ((double) f12) >= 0.9d ? CamUtils.d(0.59f, 0.69f, (f12 - 0.9f) * 10.0f) : CamUtils.d(0.525f, 0.59f, (f12 - 0.8f) * 10.0f);
        float exp = z ? 1.0f : (1.0f - (((float) Math.exp((double) (((-f5) - 42.0f) / 92.0f))) * 0.2777778f)) * f12;
        double d3 = (double) exp;
        if (d3 > 1.0d) {
            exp = 1.0f;
        } else if (d3 < 0.0d) {
            exp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f9) * exp) + 1.0f) - exp, (((100.0f / f10) * exp) + 1.0f) - exp, (((100.0f / f11) * exp) + 1.0f) - exp};
        float f13 = 1.0f / ((5.0f * f5) + 1.0f);
        float f14 = f13 * f13 * f13 * f13;
        float f15 = 1.0f - f14;
        float cbrt = (f14 * f5) + (0.1f * f15 * f15 * ((float) Math.cbrt(((double) f5) * 5.0d)));
        float h2 = CamUtils.h(f3) / fArr[1];
        double d4 = (double) h2;
        float sqrt = ((float) Math.sqrt(d4)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d4, 0.2d));
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * cbrt) * f9)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * cbrt) * f10)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[2] * cbrt) * f11)) / 100.0d, 0.42d)};
        float f16 = fArr7[0];
        float f17 = (f16 * 400.0f) / (f16 + 27.13f);
        float f18 = fArr7[1];
        float f19 = (f18 * 400.0f) / (f18 + 27.13f);
        float f20 = fArr7[2];
        float[] fArr8 = {f17, f19, (400.0f * f20) / (f20 + 27.13f)};
        return new ViewingConditions(h2, ((fArr8[0] * 2.0f) + fArr8[1] + (fArr8[2] * 0.05f)) * pow, pow, pow, d2, f12, fArr6, cbrt, (float) Math.pow((double) cbrt, 0.25d), sqrt);
    }

    public float a() {
        return this.f707a;
    }

    public float b() {
        return this.d;
    }

    public float c() {
        return this.h;
    }

    public float d() {
        return this.i;
    }

    public float e() {
        return this.f;
    }

    public float f() {
        return this.b;
    }

    public float g() {
        return this.e;
    }

    public float h() {
        return this.c;
    }

    public float[] i() {
        return this.g;
    }

    public float j() {
        return this.j;
    }
}
