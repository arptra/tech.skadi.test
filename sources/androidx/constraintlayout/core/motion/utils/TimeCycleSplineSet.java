package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

public abstract class TimeCycleSplineSet {
    public static float k = 6.2831855f;

    /* renamed from: a  reason: collision with root package name */
    public CurveFit f512a;
    public int b = 0;
    public int[] c = new int[10];
    public float[][] d;
    public int e;
    public String f;
    public float[] g;
    public boolean h;
    public long i;
    public float j;

    public static class CustomSet extends TimeCycleSplineSet {
    }

    public static class CustomVarSet extends TimeCycleSplineSet {
    }

    public static class Sort {
        public static void a(int[] iArr, float[][] fArr, int i, int i2) {
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

        public static int b(int[] iArr, float[][] fArr, int i, int i2) {
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

        public static void c(int[] iArr, float[][] fArr, int i, int i2) {
            int i3 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i3;
            float[] fArr2 = fArr[i];
            fArr[i] = fArr[i2];
            fArr[i2] = fArr2;
        }
    }

    public TimeCycleSplineSet() {
        int[] iArr = new int[2];
        iArr[1] = 3;
        iArr[0] = 10;
        this.d = (float[][]) Array.newInstance(Float.TYPE, iArr);
        this.g = new float[3];
        this.h = false;
        this.j = Float.NaN;
    }

    public float a(float f2) {
        switch (this.b) {
            case 1:
                return Math.signum(f2 * k);
            case 2:
                return 1.0f - Math.abs(f2);
            case 3:
                return (((f2 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                return 1.0f - (((f2 * 2.0f) + 1.0f) % 2.0f);
            case 5:
                return (float) Math.cos((double) (f2 * k));
            case 6:
                float abs = 1.0f - Math.abs(((f2 * 4.0f) % 4.0f) - 2.0f);
                return 1.0f - (abs * abs);
            default:
                return (float) Math.sin((double) (f2 * k));
        }
    }

    public void b(int i2, float f2, float f3, int i3, float f4) {
        int[] iArr = this.c;
        int i4 = this.e;
        iArr[i4] = i2;
        float[] fArr = this.d[i4];
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        this.b = Math.max(this.b, i3);
        this.e++;
    }

    public void c(long j2) {
        this.i = j2;
    }

    public void d(String str) {
        this.f = str;
    }

    public void e(int i2) {
        int i3 = this.e;
        if (i3 == 0) {
            System.err.println("Error no points added to " + this.f);
            return;
        }
        Sort.a(this.c, this.d, 0, i3 - 1);
        int i4 = 1;
        int i5 = 0;
        while (true) {
            int[] iArr = this.c;
            if (i4 >= iArr.length) {
                break;
            }
            if (iArr[i4] != iArr[i4 - 1]) {
                i5++;
            }
            i4++;
        }
        if (i5 == 0) {
            i5 = 1;
        }
        double[] dArr = new double[i5];
        int[] iArr2 = new int[2];
        iArr2[1] = 3;
        iArr2[0] = i5;
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr2);
        int i6 = 0;
        for (int i7 = 0; i7 < this.e; i7++) {
            if (i7 > 0) {
                int[] iArr3 = this.c;
                if (iArr3[i7] == iArr3[i7 - 1]) {
                }
            }
            dArr[i6] = ((double) this.c[i7]) * 0.01d;
            double[] dArr3 = dArr2[i6];
            float[] fArr = this.d[i7];
            dArr3[0] = (double) fArr[0];
            dArr3[1] = (double) fArr[1];
            dArr3[2] = (double) fArr[2];
            i6++;
        }
        this.f512a = CurveFit.a(i2, dArr, dArr2);
    }

    public String toString() {
        String str = this.f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i2 = 0; i2 < this.e; i2++) {
            str = str + "[" + this.c[i2] + " , " + decimalFormat.format(this.d[i2]) + "] ";
        }
        return str;
    }
}
