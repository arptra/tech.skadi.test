package androidx.core.content.res;

import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;

@RestrictTo
public class CamColor {

    /* renamed from: a  reason: collision with root package name */
    public final float f694a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;

    public CamColor(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.f694a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
        this.e = f6;
        this.f = f7;
        this.g = f8;
        this.h = f9;
        this.i = f10;
    }

    public static CamColor b(float f2, float f3, float f4) {
        float f5 = 100.0f;
        float f6 = 1000.0f;
        float f7 = 0.0f;
        CamColor camColor = null;
        float f8 = 1000.0f;
        while (Math.abs(f7 - f5) > 0.01f) {
            float f9 = ((f5 - f7) / 2.0f) + f7;
            int p = e(f9, f3, f2).p();
            float b2 = CamUtils.b(p);
            float abs = Math.abs(f4 - b2);
            if (abs < 0.2f) {
                CamColor c2 = c(p);
                float a2 = c2.a(e(c2.k(), c2.i(), f2));
                if (a2 <= 1.0f) {
                    camColor = c2;
                    f6 = abs;
                    f8 = a2;
                }
            }
            if (f6 == 0.0f && f8 == 0.0f) {
                break;
            } else if (b2 < f4) {
                f7 = f9;
            } else {
                f5 = f9;
            }
        }
        return camColor;
    }

    public static CamColor c(int i2) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        d(i2, ViewingConditions.k, fArr, fArr2);
        return new CamColor(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    public static void d(int i2, ViewingConditions viewingConditions, float[] fArr, float[] fArr2) {
        float[] fArr3 = fArr2;
        CamUtils.f(i2, fArr3);
        float[][] fArr4 = CamUtils.f695a;
        float f2 = fArr3[0];
        float[] fArr5 = fArr4[0];
        float f3 = fArr3[1];
        float f4 = fArr3[2];
        float f5 = (fArr5[0] * f2) + (fArr5[1] * f3) + (fArr5[2] * f4);
        float[] fArr6 = fArr4[1];
        float f6 = (fArr6[0] * f2) + (fArr6[1] * f3) + (fArr6[2] * f4);
        float[] fArr7 = fArr4[2];
        float f7 = viewingConditions.i()[0] * f5;
        float f8 = viewingConditions.i()[1] * f6;
        float f9 = viewingConditions.i()[2] * ((f2 * fArr7[0]) + (f3 * fArr7[1]) + (f4 * fArr7[2]));
        float pow = (float) Math.pow(((double) (viewingConditions.c() * Math.abs(f7))) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow(((double) (viewingConditions.c() * Math.abs(f8))) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow(((double) (viewingConditions.c() * Math.abs(f9))) / 100.0d, 0.42d);
        float signum = ((Math.signum(f7) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f8) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f9) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d2 = (double) signum3;
        float f10 = ((float) (((((double) signum) * 11.0d) + (((double) signum2) * -12.0d)) + d2)) / 11.0f;
        float f11 = ((float) (((double) (signum + signum2)) - (d2 * 2.0d))) / 9.0f;
        float f12 = signum2 * 20.0f;
        float f13 = (((signum * 20.0f) + f12) + (21.0f * signum3)) / 20.0f;
        float f14 = (((signum * 40.0f) + f12) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2((double) f11, (double) f10)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f15 = (3.1415927f * atan2) / 180.0f;
        float f16 = f13;
        float f17 = f11;
        float pow4 = ((float) Math.pow((double) ((f14 * viewingConditions.f()) / viewingConditions.a()), (double) (viewingConditions.b() * viewingConditions.j()))) * 100.0f;
        float b2 = (4.0f / viewingConditions.b()) * ((float) Math.sqrt((double) (pow4 / 100.0f))) * (viewingConditions.a() + 4.0f) * viewingConditions.d();
        float pow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, (double) viewingConditions.e()), 0.73d)) * ((float) Math.pow((double) ((((((((float) (Math.cos(((((double) (((double) atan2) < 20.14d ? 360.0f + atan2 : atan2)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.g()) * viewingConditions.h()) * ((float) Math.sqrt((double) ((f10 * f10) + (f17 * f17))))) / (f16 + 0.305f)), 0.9d));
        float sqrt = ((float) Math.sqrt(((double) pow4) / 100.0d)) * pow5;
        float d3 = viewingConditions.d() * sqrt;
        float sqrt2 = ((float) Math.sqrt((double) ((pow5 * viewingConditions.b()) / (viewingConditions.a() + 4.0f)))) * 50.0f;
        float f18 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((double) ((0.0228f * d3) + 1.0f))) * 43.85965f;
        double d4 = (double) f15;
        float cos = ((float) Math.cos(d4)) * log;
        float sin = log * ((float) Math.sin(d4));
        fArr3[0] = atan2;
        fArr3[1] = sqrt;
        if (fArr != null) {
            fArr[0] = pow4;
            fArr[1] = b2;
            fArr[2] = d3;
            fArr[3] = sqrt2;
            fArr[4] = f18;
            fArr[5] = cos;
            fArr[6] = sin;
        }
    }

    public static CamColor e(float f2, float f3, float f4) {
        return f(f2, f3, f4, ViewingConditions.k);
    }

    public static CamColor f(float f2, float f3, float f4, ViewingConditions viewingConditions) {
        float f5 = f2;
        double d2 = ((double) f5) / 100.0d;
        float b2 = (4.0f / viewingConditions.b()) * ((float) Math.sqrt(d2)) * (viewingConditions.a() + 4.0f) * viewingConditions.d();
        float d3 = f3 * viewingConditions.d();
        float sqrt = ((float) Math.sqrt((double) (((f3 / ((float) Math.sqrt(d2))) * viewingConditions.b()) / (viewingConditions.a() + 4.0f)))) * 50.0f;
        float f6 = (1.7f * f5) / ((0.007f * f5) + 1.0f);
        float log = ((float) Math.log((((double) d3) * 0.0228d) + 1.0d)) * 43.85965f;
        double d4 = (double) ((3.1415927f * f4) / 180.0f);
        return new CamColor(f4, f3, f5, b2, d3, sqrt, f6, log * ((float) Math.cos(d4)), log * ((float) Math.sin(d4)));
    }

    public static int m(float f2, float f3, float f4) {
        return n(f2, f3, f4, ViewingConditions.k);
    }

    public static int n(float f2, float f3, float f4, ViewingConditions viewingConditions) {
        if (((double) f3) < 1.0d || ((double) Math.round(f4)) <= 0.0d || ((double) Math.round(f4)) >= 100.0d) {
            return CamUtils.a(f4);
        }
        float min = f2 < 0.0f ? 0.0f : Math.min(360.0f, f2);
        CamColor camColor = null;
        boolean z = true;
        float f5 = 0.0f;
        float f6 = f3;
        while (Math.abs(f5 - f3) >= 0.4f) {
            CamColor b2 = b(min, f6, f4);
            if (!z) {
                if (b2 == null) {
                    f3 = f6;
                } else {
                    f5 = f6;
                    camColor = b2;
                }
                f6 = ((f3 - f5) / 2.0f) + f5;
            } else if (b2 != null) {
                return b2.o(viewingConditions);
            } else {
                f6 = ((f3 - f5) / 2.0f) + f5;
                z = false;
            }
        }
        return camColor == null ? CamUtils.a(f4) : camColor.o(viewingConditions);
    }

    public float a(CamColor camColor) {
        float l = l() - camColor.l();
        float g2 = g() - camColor.g();
        float h2 = h() - camColor.h();
        return (float) (Math.pow(Math.sqrt((double) ((l * l) + (g2 * g2) + (h2 * h2))), 0.63d) * 1.41d);
    }

    public float g() {
        return this.h;
    }

    public float h() {
        return this.i;
    }

    public float i() {
        return this.b;
    }

    public float j() {
        return this.f694a;
    }

    public float k() {
        return this.c;
    }

    public float l() {
        return this.g;
    }

    public int o(ViewingConditions viewingConditions) {
        float pow = (float) Math.pow(((double) ((((double) i()) == 0.0d || ((double) k()) == 0.0d) ? 0.0f : i() / ((float) Math.sqrt(((double) k()) / 100.0d)))) / Math.pow(1.64d - Math.pow(0.29d, (double) viewingConditions.e()), 0.73d), 1.1111111111111112d);
        double j = (double) ((j() * 3.1415927f) / 180.0f);
        float a2 = viewingConditions.a() * ((float) Math.pow(((double) k()) / 100.0d, (1.0d / ((double) viewingConditions.b())) / ((double) viewingConditions.j())));
        float cos = ((float) (Math.cos(2.0d + j) + 3.8d)) * 0.25f * 3846.1538f * viewingConditions.g() * viewingConditions.h();
        float f2 = a2 / viewingConditions.f();
        float sin = (float) Math.sin(j);
        float cos2 = (float) Math.cos(j);
        float f3 = (((0.305f + f2) * 23.0f) * pow) / (((cos * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f4 = cos2 * f3;
        float f5 = f3 * sin;
        float f6 = f2 * 460.0f;
        float f7 = (((451.0f * f4) + f6) + (288.0f * f5)) / 1403.0f;
        float f8 = ((f6 - (891.0f * f4)) - (261.0f * f5)) / 1403.0f;
        float f9 = ((f6 - (f4 * 220.0f)) - (f5 * 6300.0f)) / 1403.0f;
        float signum = Math.signum(f7) * (100.0f / viewingConditions.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f7)) * 27.13d) / (400.0d - ((double) Math.abs(f7))))), 2.380952380952381d));
        float signum2 = Math.signum(f8) * (100.0f / viewingConditions.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f8)) * 27.13d) / (400.0d - ((double) Math.abs(f8))))), 2.380952380952381d));
        float signum3 = Math.signum(f9) * (100.0f / viewingConditions.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f9)) * 27.13d) / (400.0d - ((double) Math.abs(f9))))), 2.380952380952381d));
        float f10 = signum / viewingConditions.i()[0];
        float f11 = signum2 / viewingConditions.i()[1];
        float f12 = signum3 / viewingConditions.i()[2];
        float[][] fArr = CamUtils.b;
        float[] fArr2 = fArr[0];
        float f13 = (fArr2[0] * f10) + (fArr2[1] * f11) + (fArr2[2] * f12);
        float[] fArr3 = fArr[1];
        float[] fArr4 = fArr[2];
        return ColorUtils.b((double) f13, (double) ((fArr3[0] * f10) + (fArr3[1] * f11) + (fArr3[2] * f12)), (double) ((f10 * fArr4[0]) + (f11 * fArr4[1]) + (f12 * fArr4[2])));
    }

    public int p() {
        return o(ViewingConditions.k);
    }
}
