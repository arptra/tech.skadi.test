package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

public class Oscillator {

    /* renamed from: a  reason: collision with root package name */
    public float[] f508a = new float[0];
    public double[] b = new double[0];
    public double[] c;
    public String d;
    public MonotonicCurveFit e;
    public int f;
    public double g = 6.283185307179586d;
    public boolean h = false;

    public void a(double d2, float f2) {
        int length = this.f508a.length + 1;
        int binarySearch = Arrays.binarySearch(this.b, d2);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.b = Arrays.copyOf(this.b, length);
        this.f508a = Arrays.copyOf(this.f508a, length);
        this.c = new double[length];
        double[] dArr = this.b;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.b[binarySearch] = d2;
        this.f508a[binarySearch] = f2;
        this.h = false;
    }

    public double b(double d2) {
        if (d2 <= 0.0d) {
            d2 = 1.0E-5d;
        } else if (d2 >= 1.0d) {
            d2 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.b, d2);
        if (binarySearch > 0 || binarySearch == 0) {
            return 0.0d;
        }
        int i = -binarySearch;
        int i2 = i - 1;
        float[] fArr = this.f508a;
        float f2 = fArr[i2];
        int i3 = i - 2;
        float f3 = fArr[i3];
        double[] dArr = this.b;
        double d3 = dArr[i2];
        double d4 = dArr[i3];
        double d5 = ((double) (f2 - f3)) / (d3 - d4);
        return (d2 * d5) + (((double) f3) - (d5 * d4));
    }

    public double c(double d2) {
        if (d2 < 0.0d) {
            d2 = 0.0d;
        } else if (d2 > 1.0d) {
            d2 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.b, d2);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return 0.0d;
        }
        int i = -binarySearch;
        int i2 = i - 1;
        float[] fArr = this.f508a;
        float f2 = fArr[i2];
        int i3 = i - 2;
        float f3 = fArr[i3];
        double[] dArr = this.b;
        double d3 = dArr[i2];
        double d4 = dArr[i3];
        double d5 = ((double) (f2 - f3)) / (d3 - d4);
        return this.c[i3] + ((((double) f3) - (d5 * d4)) * (d2 - d4)) + ((d5 * ((d2 * d2) - (d4 * d4))) / 2.0d);
    }

    public double d(double d2, double d3, double d4) {
        double d5;
        double signum;
        double c2 = d3 + c(d2);
        double b2 = b(d2) + d4;
        switch (this.f) {
            case 1:
                return 0.0d;
            case 2:
                d5 = b2 * 4.0d;
                signum = Math.signum((((c2 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return b2 * 2.0d;
            case 4:
                return (-b2) * 2.0d;
            case 5:
                double d6 = this.g;
                return (-d6) * b2 * Math.sin(d6 * c2);
            case 6:
                d5 = b2 * 4.0d;
                signum = (((c2 * 4.0d) + 2.0d) % 4.0d) - 2.0d;
                break;
            case 7:
                return this.e.f(c2 % 1.0d, 0);
            default:
                double d7 = this.g;
                d5 = b2 * d7;
                signum = Math.cos(d7 * c2);
                break;
        }
        return d5 * signum;
    }

    public double e(double d2, double d3) {
        double c2 = c(d2) + d3;
        switch (this.f) {
            case 1:
                return Math.signum(0.5d - (c2 % 1.0d));
            case 2:
                return 1.0d - Math.abs((((c2 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
            case 3:
                return (((c2 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                return 1.0d - (((c2 * 2.0d) + 1.0d) % 2.0d);
            case 5:
                return Math.cos(this.g * (d3 + c2));
            case 6:
                double abs = 1.0d - Math.abs(((c2 * 4.0d) % 4.0d) - 2.0d);
                return 1.0d - (abs * abs);
            case 7:
                return this.e.c(c2 % 1.0d, 0);
            default:
                return Math.sin(this.g * c2);
        }
    }

    public void f() {
        double d2 = 0.0d;
        int i = 0;
        while (true) {
            float[] fArr = this.f508a;
            if (i >= fArr.length) {
                break;
            }
            d2 += (double) fArr[i];
            i++;
        }
        double d3 = 0.0d;
        int i2 = 1;
        while (true) {
            float[] fArr2 = this.f508a;
            if (i2 >= fArr2.length) {
                break;
            }
            int i3 = i2 - 1;
            double[] dArr = this.b;
            d3 += (dArr[i2] - dArr[i3]) * ((double) ((fArr2[i3] + fArr2[i2]) / 2.0f));
            i2++;
        }
        int i4 = 0;
        while (true) {
            float[] fArr3 = this.f508a;
            if (i4 >= fArr3.length) {
                break;
            }
            fArr3[i4] = (float) (((double) fArr3[i4]) * (d2 / d3));
            i4++;
        }
        this.c[0] = 0.0d;
        int i5 = 1;
        while (true) {
            float[] fArr4 = this.f508a;
            if (i5 < fArr4.length) {
                int i6 = i5 - 1;
                double[] dArr2 = this.b;
                double d4 = dArr2[i5] - dArr2[i6];
                double[] dArr3 = this.c;
                dArr3[i5] = dArr3[i6] + (d4 * ((double) ((fArr4[i6] + fArr4[i5]) / 2.0f)));
                i5++;
            } else {
                this.h = true;
                return;
            }
        }
    }

    public void g(int i, String str) {
        this.f = i;
        this.d = str;
        if (str != null) {
            this.e = MonotonicCurveFit.i(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.b) + " period=" + Arrays.toString(this.f508a);
    }
}
