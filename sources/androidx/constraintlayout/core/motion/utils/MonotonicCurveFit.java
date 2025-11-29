package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MonotonicCurveFit extends CurveFit {

    /* renamed from: a  reason: collision with root package name */
    public double[] f507a;
    public double[][] b;
    public double[][] c;
    public boolean d = true;
    public double[] e;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        double[] dArr3 = dArr;
        double[][] dArr4 = dArr2;
        int length = dArr3.length;
        int length2 = dArr4[0].length;
        this.e = new double[length2];
        int i = length - 1;
        int[] iArr = new int[2];
        iArr[1] = length2;
        iArr[0] = i;
        Class cls = Double.TYPE;
        double[][] dArr5 = (double[][]) Array.newInstance(cls, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = length2;
        iArr2[0] = length;
        double[][] dArr6 = (double[][]) Array.newInstance(cls, iArr2);
        for (int i2 = 0; i2 < length2; i2++) {
            int i3 = 0;
            while (i3 < i) {
                int i4 = i3 + 1;
                double d2 = dArr3[i4] - dArr3[i3];
                double[] dArr7 = dArr5[i3];
                double d3 = (dArr4[i4][i2] - dArr4[i3][i2]) / d2;
                dArr7[i2] = d3;
                if (i3 == 0) {
                    dArr6[i3][i2] = d3;
                } else {
                    dArr6[i3][i2] = (dArr5[i3 - 1][i2] + d3) * 0.5d;
                }
                i3 = i4;
            }
            dArr6[i][i2] = dArr5[length - 2][i2];
        }
        for (int i5 = 0; i5 < i; i5++) {
            for (int i6 = 0; i6 < length2; i6++) {
                double d4 = dArr5[i5][i6];
                if (d4 == 0.0d) {
                    dArr6[i5][i6] = 0.0d;
                    dArr6[i5 + 1][i6] = 0.0d;
                } else {
                    double d5 = dArr6[i5][i6] / d4;
                    int i7 = i5 + 1;
                    double d6 = dArr6[i7][i6] / d4;
                    double hypot = Math.hypot(d5, d6);
                    if (hypot > 9.0d) {
                        double d7 = 3.0d / hypot;
                        double[] dArr8 = dArr6[i5];
                        double[] dArr9 = dArr5[i5];
                        dArr8[i6] = d5 * d7 * dArr9[i6];
                        dArr6[i7][i6] = d7 * d6 * dArr9[i6];
                    }
                }
            }
        }
        this.f507a = dArr3;
        this.b = dArr4;
        this.c = dArr6;
    }

    public static MonotonicCurveFit i(String str) {
        double[] dArr = new double[(str.length() / 2)];
        int indexOf = str.indexOf(40) + 1;
        int indexOf2 = str.indexOf(44, indexOf);
        int i = 0;
        while (indexOf2 != -1) {
            dArr[i] = Double.parseDouble(str.substring(indexOf, indexOf2).trim());
            indexOf = indexOf2 + 1;
            indexOf2 = str.indexOf(44, indexOf);
            i++;
        }
        dArr[i] = Double.parseDouble(str.substring(indexOf, str.indexOf(41, indexOf)).trim());
        return j(Arrays.copyOf(dArr, i + 1));
    }

    public static MonotonicCurveFit j(double[] dArr) {
        double[] dArr2 = dArr;
        int length = (dArr2.length * 3) - 2;
        int length2 = dArr2.length - 1;
        double d2 = 1.0d / ((double) length2);
        int[] iArr = new int[2];
        iArr[1] = 1;
        iArr[0] = length;
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, iArr);
        double[] dArr4 = new double[length];
        for (int i = 0; i < dArr2.length; i++) {
            double d3 = dArr2[i];
            int i2 = i + length2;
            dArr3[i2][0] = d3;
            double d4 = ((double) i) * d2;
            dArr4[i2] = d4;
            if (i > 0) {
                int i3 = (length2 * 2) + i;
                dArr3[i3][0] = d3 + 1.0d;
                dArr4[i3] = d4 + 1.0d;
                int i4 = i - 1;
                dArr3[i4][0] = (d3 - 1.0d) - d2;
                dArr4[i4] = (d4 - 4.0d) - d2;
            }
        }
        return new MonotonicCurveFit(dArr4, dArr3);
    }

    public static double k(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d3 * d3;
        double d9 = d3 * 6.0d;
        double d10 = 3.0d * d2;
        return (((((((((-6.0d * d8) * d5) + (d9 * d5)) + ((6.0d * d8) * d4)) - (d9 * d4)) + ((d10 * d7) * d8)) + ((d10 * d6) * d8)) - (((2.0d * d2) * d7) * d3)) - (((4.0d * d2) * d6) * d3)) + (d2 * d6);
    }

    public static double l(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d3 * d3;
        double d9 = d8 * d3;
        double d10 = 3.0d * d8;
        double d11 = d2 * d7;
        double d12 = d2 * d6;
        return ((((((((((-2.0d * d9) * d5) + (d10 * d5)) + ((d9 * 2.0d) * d4)) - (d10 * d4)) + d4) + (d11 * d9)) + (d9 * d12)) - (d11 * d8)) - (((d2 * 2.0d) * d6) * d8)) + (d12 * d3);
    }

    public double c(double d2, int i) {
        double d3;
        double d4;
        double f;
        int i2 = i;
        double[] dArr = this.f507a;
        int length = dArr.length;
        int i3 = 0;
        if (this.d) {
            double d5 = dArr[0];
            if (d2 <= d5) {
                d3 = this.b[0][i2];
                d4 = d2 - d5;
                f = f(d5, i2);
            } else {
                int i4 = length - 1;
                double d6 = dArr[i4];
                if (d2 >= d6) {
                    d3 = this.b[i4][i2];
                    d4 = d2 - d6;
                    f = f(d6, i2);
                }
            }
            return d3 + (d4 * f);
        } else if (d2 <= dArr[0]) {
            return this.b[0][i2];
        } else {
            int i5 = length - 1;
            if (d2 >= dArr[i5]) {
                return this.b[i5][i2];
            }
        }
        while (i3 < length - 1) {
            double[] dArr2 = this.f507a;
            double d7 = dArr2[i3];
            if (d2 == d7) {
                return this.b[i3][i2];
            }
            int i6 = i3 + 1;
            double d8 = dArr2[i6];
            if (d2 < d8) {
                double d9 = d8 - d7;
                double d10 = (d2 - d7) / d9;
                double[][] dArr3 = this.b;
                double d11 = dArr3[i3][i2];
                double d12 = dArr3[i6][i2];
                double[][] dArr4 = this.c;
                return l(d9, d10, d11, d12, dArr4[i3][i2], dArr4[i6][i2]);
            }
            i3 = i6;
        }
        return 0.0d;
    }

    public void d(double d2, double[] dArr) {
        double[] dArr2 = this.f507a;
        int length = dArr2.length;
        int i = 0;
        int length2 = this.b[0].length;
        if (this.d) {
            double d3 = dArr2[0];
            if (d2 <= d3) {
                g(d3, this.e);
                for (int i2 = 0; i2 < length2; i2++) {
                    dArr[i2] = this.b[0][i2] + ((d2 - this.f507a[0]) * this.e[i2]);
                }
                return;
            }
            int i3 = length - 1;
            double d4 = dArr2[i3];
            if (d2 >= d4) {
                g(d4, this.e);
                while (i < length2) {
                    dArr[i] = this.b[i3][i] + ((d2 - this.f507a[i3]) * this.e[i]);
                    i++;
                }
                return;
            }
        } else if (d2 <= dArr2[0]) {
            for (int i4 = 0; i4 < length2; i4++) {
                dArr[i4] = this.b[0][i4];
            }
            return;
        } else {
            int i5 = length - 1;
            if (d2 >= dArr2[i5]) {
                while (i < length2) {
                    dArr[i] = this.b[i5][i];
                    i++;
                }
                return;
            }
        }
        int i6 = 0;
        while (i6 < length - 1) {
            if (d2 == this.f507a[i6]) {
                for (int i7 = 0; i7 < length2; i7++) {
                    dArr[i7] = this.b[i6][i7];
                }
            }
            double[] dArr3 = this.f507a;
            int i8 = i6 + 1;
            double d5 = dArr3[i8];
            if (d2 < d5) {
                double d6 = dArr3[i6];
                double d7 = d5 - d6;
                double d8 = (d2 - d6) / d7;
                while (i < length2) {
                    double[][] dArr4 = this.b;
                    double d9 = dArr4[i6][i];
                    double d10 = dArr4[i8][i];
                    double[][] dArr5 = this.c;
                    dArr[i] = l(d7, d8, d9, d10, dArr5[i6][i], dArr5[i8][i]);
                    i++;
                }
                return;
            }
            i6 = i8;
        }
    }

    public void e(double d2, float[] fArr) {
        double[] dArr = this.f507a;
        int length = dArr.length;
        int i = 0;
        int length2 = this.b[0].length;
        if (this.d) {
            double d3 = dArr[0];
            if (d2 <= d3) {
                g(d3, this.e);
                for (int i2 = 0; i2 < length2; i2++) {
                    fArr[i2] = (float) (this.b[0][i2] + ((d2 - this.f507a[0]) * this.e[i2]));
                }
                return;
            }
            int i3 = length - 1;
            double d4 = dArr[i3];
            if (d2 >= d4) {
                g(d4, this.e);
                while (i < length2) {
                    fArr[i] = (float) (this.b[i3][i] + ((d2 - this.f507a[i3]) * this.e[i]));
                    i++;
                }
                return;
            }
        } else if (d2 <= dArr[0]) {
            for (int i4 = 0; i4 < length2; i4++) {
                fArr[i4] = (float) this.b[0][i4];
            }
            return;
        } else {
            int i5 = length - 1;
            if (d2 >= dArr[i5]) {
                while (i < length2) {
                    fArr[i] = (float) this.b[i5][i];
                    i++;
                }
                return;
            }
        }
        int i6 = 0;
        while (i6 < length - 1) {
            if (d2 == this.f507a[i6]) {
                for (int i7 = 0; i7 < length2; i7++) {
                    fArr[i7] = (float) this.b[i6][i7];
                }
            }
            double[] dArr2 = this.f507a;
            int i8 = i6 + 1;
            double d5 = dArr2[i8];
            if (d2 < d5) {
                double d6 = dArr2[i6];
                double d7 = d5 - d6;
                double d8 = (d2 - d6) / d7;
                while (i < length2) {
                    double[][] dArr3 = this.b;
                    double d9 = dArr3[i6][i];
                    double d10 = dArr3[i8][i];
                    double[][] dArr4 = this.c;
                    fArr[i] = (float) l(d7, d8, d9, d10, dArr4[i6][i], dArr4[i8][i]);
                    i++;
                }
                return;
            }
            i6 = i8;
        }
    }

    public double f(double d2, int i) {
        double[] dArr = this.f507a;
        int length = dArr.length;
        int i2 = 0;
        double d3 = dArr[0];
        if (d2 >= d3) {
            d3 = dArr[length - 1];
            if (d2 < d3) {
                d3 = d2;
            }
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.f507a;
            int i3 = i2 + 1;
            double d4 = dArr2[i3];
            if (d3 <= d4) {
                double d5 = dArr2[i2];
                double d6 = d4 - d5;
                double[][] dArr3 = this.b;
                double d7 = dArr3[i2][i];
                double d8 = dArr3[i3][i];
                double[][] dArr4 = this.c;
                return k(d6, (d3 - d5) / d6, d7, d8, dArr4[i2][i], dArr4[i3][i]) / d6;
            }
            i2 = i3;
        }
        return 0.0d;
    }

    public void g(double d2, double[] dArr) {
        double[] dArr2 = this.f507a;
        int length = dArr2.length;
        int length2 = this.b[0].length;
        double d3 = dArr2[0];
        if (d2 > d3) {
            d3 = dArr2[length - 1];
            if (d2 < d3) {
                d3 = d2;
            }
        }
        int i = 0;
        while (i < length - 1) {
            double[] dArr3 = this.f507a;
            int i2 = i + 1;
            double d4 = dArr3[i2];
            if (d3 <= d4) {
                double d5 = dArr3[i];
                double d6 = d4 - d5;
                double d7 = (d3 - d5) / d6;
                for (int i3 = 0; i3 < length2; i3++) {
                    double[][] dArr4 = this.b;
                    double d8 = dArr4[i][i3];
                    double d9 = dArr4[i2][i3];
                    double[][] dArr5 = this.c;
                    dArr[i3] = k(d6, d7, d8, d9, dArr5[i][i3], dArr5[i2][i3]) / d6;
                }
                return;
            }
            i = i2;
        }
    }

    public double[] h() {
        return this.f507a;
    }
}
