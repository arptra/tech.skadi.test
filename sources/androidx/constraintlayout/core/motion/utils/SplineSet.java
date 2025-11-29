package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class SplineSet {

    /* renamed from: a  reason: collision with root package name */
    public CurveFit f509a;
    public int[] b = new int[10];
    public float[] c = new float[10];
    public int d;
    public String e;

    public static class CoreSpline extends SplineSet {
    }

    public static class CustomSet extends SplineSet {
        public KeyFrameArray.CustomArray f;
        public float[] g;

        public void c(int i, float f2) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void e(int i) {
            int b = this.f.b();
            int b2 = this.f.c(0).b();
            double[] dArr = new double[b];
            this.g = new float[b2];
            int[] iArr = new int[2];
            iArr[1] = b2;
            iArr[0] = b;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i2 = 0; i2 < b; i2++) {
                int a2 = this.f.a(i2);
                CustomAttribute c = this.f.c(i2);
                dArr[i2] = ((double) a2) * 0.01d;
                c.a(this.g);
                int i3 = 0;
                while (true) {
                    float[] fArr = this.g;
                    if (i3 >= fArr.length) {
                        break;
                    }
                    dArr2[i2][i3] = (double) fArr[i3];
                    i3++;
                }
            }
            this.f509a = CurveFit.a(i, dArr, dArr2);
        }
    }

    public static class CustomSpline extends SplineSet {
        public KeyFrameArray.CustomVar f;
        public float[] g;

        public void c(int i, float f2) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void e(int i) {
            int b = this.f.b();
            int c = this.f.c(0).c();
            double[] dArr = new double[b];
            this.g = new float[c];
            int[] iArr = new int[2];
            iArr[1] = c;
            iArr[0] = b;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i2 = 0; i2 < b; i2++) {
                int a2 = this.f.a(i2);
                CustomVariable c2 = this.f.c(i2);
                dArr[i2] = ((double) a2) * 0.01d;
                c2.b(this.g);
                int i3 = 0;
                while (true) {
                    float[] fArr = this.g;
                    if (i3 >= fArr.length) {
                        break;
                    }
                    dArr2[i2][i3] = (double) fArr[i3];
                    i3++;
                }
            }
            this.f509a = CurveFit.a(i, dArr, dArr2);
        }
    }

    public static class Sort {
        public static void a(int[] iArr, float[] fArr, int i, int i2) {
            int[] iArr2 = new int[(iArr.length + 10)];
            iArr2[0] = i2;
            iArr2[1] = i;
            int i3 = 2;
            while (i3 > 0) {
                int i4 = iArr2[i3 - 1];
                int i5 = i3 - 2;
                int i6 = iArr2[i5];
                if (i4 < i6) {
                    int b = b(iArr, fArr, i4, i6);
                    iArr2[i5] = b - 1;
                    iArr2[i3 - 1] = i4;
                    int i7 = i3 + 1;
                    iArr2[i3] = i6;
                    i3 += 2;
                    iArr2[i7] = b + 1;
                } else {
                    i3 = i5;
                }
            }
        }

        public static int b(int[] iArr, float[] fArr, int i, int i2) {
            int i3 = iArr[i2];
            int i4 = i;
            while (i < i2) {
                if (iArr[i] <= i3) {
                    c(iArr, fArr, i4, i);
                    i4++;
                }
                i++;
            }
            c(iArr, fArr, i4, i2);
            return i4;
        }

        public static void c(int[] iArr, float[] fArr, int i, int i2) {
            int i3 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i3;
            float f = fArr[i];
            fArr[i] = fArr[i2];
            fArr[i2] = f;
        }
    }

    public float a(float f) {
        return (float) this.f509a.c((double) f, 0);
    }

    public float b(float f) {
        return (float) this.f509a.f((double) f, 0);
    }

    public void c(int i, float f) {
        int[] iArr = this.b;
        if (iArr.length < this.d + 1) {
            this.b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.c;
            this.c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.b;
        int i2 = this.d;
        iArr2[i2] = i;
        this.c[i2] = f;
        this.d = i2 + 1;
    }

    public void d(String str) {
        this.e = str;
    }

    public void e(int i) {
        int i2 = this.d;
        if (i2 != 0) {
            Sort.a(this.b, this.c, 0, i2 - 1);
            int i3 = 1;
            for (int i4 = 1; i4 < this.d; i4++) {
                int[] iArr = this.b;
                if (iArr[i4 - 1] != iArr[i4]) {
                    i3++;
                }
            }
            double[] dArr = new double[i3];
            int[] iArr2 = new int[2];
            iArr2[1] = 1;
            iArr2[0] = i3;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr2);
            int i5 = 0;
            for (int i6 = 0; i6 < this.d; i6++) {
                if (i6 > 0) {
                    int[] iArr3 = this.b;
                    if (iArr3[i6] == iArr3[i6 - 1]) {
                    }
                }
                dArr[i5] = ((double) this.b[i6]) * 0.01d;
                dArr2[i5][0] = (double) this.c[i6];
                i5++;
            }
            this.f509a = CurveFit.a(i, dArr, dArr2);
        }
    }

    public String toString() {
        String str = this.e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.d; i++) {
            str = str + "[" + this.b[i] + " , " + decimalFormat.format((double) this.c[i]) + "] ";
        }
        return str;
    }
}
