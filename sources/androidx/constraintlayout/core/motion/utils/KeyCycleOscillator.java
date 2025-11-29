package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public abstract class KeyCycleOscillator {

    /* renamed from: a  reason: collision with root package name */
    public CurveFit f500a;
    public CycleOscillator b;
    public String c;
    public int d = 0;
    public String e = null;
    public int f = 0;
    public ArrayList g = new ArrayList();

    public static class CoreSpline extends KeyCycleOscillator {
    }

    public static class CycleOscillator {

        /* renamed from: a  reason: collision with root package name */
        public final int f502a;
        public Oscillator b;
        public final int c = 0;
        public final int d = 1;
        public final int e = 2;
        public float[] f;
        public double[] g;
        public float[] h;
        public float[] i;
        public float[] j;
        public float[] k;
        public int l;
        public CurveFit m;
        public double[] n;
        public double[] o;
        public float p;

        public CycleOscillator(int i2, String str, int i3, int i4) {
            Oscillator oscillator = new Oscillator();
            this.b = oscillator;
            this.l = i2;
            this.f502a = i3;
            oscillator.g(i2, str);
            this.f = new float[i4];
            this.g = new double[i4];
            this.h = new float[i4];
            this.i = new float[i4];
            this.j = new float[i4];
            this.k = new float[i4];
        }

        public double a(float f2) {
            CurveFit curveFit = this.m;
            if (curveFit != null) {
                double d2 = (double) f2;
                curveFit.g(d2, this.o);
                this.m.d(d2, this.n);
            } else {
                double[] dArr = this.o;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d3 = (double) f2;
            double e2 = this.b.e(d3, this.n[1]);
            double d4 = this.b.d(d3, this.n[1], this.o[1]);
            double[] dArr2 = this.o;
            return dArr2[0] + (e2 * dArr2[2]) + (d4 * this.n[2]);
        }

        public double b(float f2) {
            CurveFit curveFit = this.m;
            if (curveFit != null) {
                curveFit.d((double) f2, this.n);
            } else {
                double[] dArr = this.n;
                dArr[0] = (double) this.i[0];
                dArr[1] = (double) this.j[0];
                dArr[2] = (double) this.f[0];
            }
            double[] dArr2 = this.n;
            return dArr2[0] + (this.b.e((double) f2, dArr2[1]) * this.n[2]);
        }

        public void c(int i2, int i3, float f2, float f3, float f4, float f5) {
            this.g[i2] = ((double) i3) / 100.0d;
            this.h[i2] = f2;
            this.i[i2] = f3;
            this.j[i2] = f4;
            this.f[i2] = f5;
        }

        public void d(float f2) {
            this.p = f2;
            int length = this.g.length;
            int[] iArr = new int[2];
            iArr[1] = 3;
            iArr[0] = length;
            double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, iArr);
            float[] fArr = this.f;
            this.n = new double[(fArr.length + 2)];
            this.o = new double[(fArr.length + 2)];
            if (this.g[0] > 0.0d) {
                this.b.a(0.0d, this.h[0]);
            }
            double[] dArr2 = this.g;
            int length2 = dArr2.length - 1;
            if (dArr2[length2] < 1.0d) {
                this.b.a(1.0d, this.h[length2]);
            }
            for (int i2 = 0; i2 < dArr.length; i2++) {
                double[] dArr3 = dArr[i2];
                dArr3[0] = (double) this.i[i2];
                dArr3[1] = (double) this.j[i2];
                dArr3[2] = (double) this.f[i2];
                this.b.a(this.g[i2], this.h[i2]);
            }
            this.b.f();
            double[] dArr4 = this.g;
            if (dArr4.length > 1) {
                this.m = CurveFit.a(0, dArr4, dArr);
            } else {
                this.m = null;
            }
        }
    }

    public static class IntDoubleSort {
    }

    public static class IntFloatFloatSort {
    }

    public static class PathRotateSet extends KeyCycleOscillator {
    }

    public static class WavePoint {

        /* renamed from: a  reason: collision with root package name */
        public int f503a;
        public float b;
        public float c;
        public float d;
        public float e;

        public WavePoint(int i, float f, float f2, float f3, float f4) {
            this.f503a = i;
            this.b = f4;
            this.c = f2;
            this.d = f;
            this.e = f3;
        }
    }

    public float a(float f2) {
        return (float) this.b.b(f2);
    }

    public float b(float f2) {
        return (float) this.b.a(f2);
    }

    public void c(Object obj) {
    }

    public void d(int i, int i2, String str, int i3, float f2, float f3, float f4, float f5) {
        int i4 = i3;
        this.g.add(new WavePoint(i, f2, f3, f4, f5));
        if (i4 != -1) {
            this.f = i4;
        }
        this.d = i2;
        this.e = str;
    }

    public void e(int i, int i2, String str, int i3, float f2, float f3, float f4, float f5, Object obj) {
        int i4 = i3;
        this.g.add(new WavePoint(i, f2, f3, f4, f5));
        if (i4 != -1) {
            this.f = i4;
        }
        this.d = i2;
        c(obj);
        this.e = str;
    }

    public void f(String str) {
        this.c = str;
    }

    public void g(float f2) {
        int size = this.g.size();
        if (size != 0) {
            Collections.sort(this.g, new Comparator<WavePoint>() {
                /* renamed from: a */
                public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                    return Integer.compare(wavePoint.f503a, wavePoint2.f503a);
                }
            });
            double[] dArr = new double[size];
            int[] iArr = new int[2];
            iArr[1] = 3;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            this.b = new CycleOscillator(this.d, this.e, this.f, size);
            Iterator it = this.g.iterator();
            int i = 0;
            while (it.hasNext()) {
                WavePoint wavePoint = (WavePoint) it.next();
                float f3 = wavePoint.d;
                dArr[i] = ((double) f3) * 0.01d;
                double[] dArr3 = dArr2[i];
                float f4 = wavePoint.b;
                dArr3[0] = (double) f4;
                float f5 = wavePoint.c;
                dArr3[1] = (double) f5;
                float f6 = wavePoint.e;
                dArr3[2] = (double) f6;
                this.b.c(i, wavePoint.f503a, f3, f5, f6, f4);
                i++;
                dArr2 = dArr2;
            }
            double[][] dArr4 = dArr2;
            this.b.d(f2);
            this.f500a = CurveFit.a(0, dArr, dArr2);
        }
    }

    public boolean h() {
        return this.f == 1;
    }

    public String toString() {
        String str = this.c;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            WavePoint wavePoint = (WavePoint) it.next();
            str = str + "[" + wavePoint.f503a + " , " + decimalFormat.format((double) wavePoint.b) + "] ";
        }
        return str;
    }
}
