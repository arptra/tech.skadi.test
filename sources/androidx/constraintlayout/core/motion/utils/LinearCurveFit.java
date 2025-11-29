package androidx.constraintlayout.core.motion.utils;

public class LinearCurveFit extends CurveFit {

    /* renamed from: a  reason: collision with root package name */
    public double[] f506a;
    public double[][] b;
    public double c = Double.NaN;
    public boolean d = true;
    public double[] e;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.e = new double[length2];
        this.f506a = dArr;
        this.b = dArr2;
        if (length2 > 2) {
            int i = 0;
            double d2 = 0.0d;
            while (true) {
                double d3 = d2;
                if (i < dArr.length) {
                    double d4 = dArr2[i][0];
                    if (i > 0) {
                        Math.hypot(d4 - d2, d4 - d3);
                    }
                    i++;
                    d2 = d4;
                } else {
                    this.c = 0.0d;
                    return;
                }
            }
        }
    }

    public double c(double d2, int i) {
        double[] dArr = this.f506a;
        int length = dArr.length;
        int i2 = 0;
        if (this.d) {
            double d3 = dArr[0];
            if (d2 <= d3) {
                return this.b[0][i] + ((d2 - d3) * f(d3, i));
            }
            int i3 = length - 1;
            double d4 = dArr[i3];
            if (d2 >= d4) {
                return this.b[i3][i] + ((d2 - d4) * f(d4, i));
            }
        } else if (d2 <= dArr[0]) {
            return this.b[0][i];
        } else {
            int i4 = length - 1;
            if (d2 >= dArr[i4]) {
                return this.b[i4][i];
            }
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.f506a;
            double d5 = dArr2[i2];
            if (d2 == d5) {
                return this.b[i2][i];
            }
            int i5 = i2 + 1;
            double d6 = dArr2[i5];
            if (d2 < d6) {
                double d7 = (d2 - d5) / (d6 - d5);
                double[][] dArr3 = this.b;
                return (dArr3[i2][i] * (1.0d - d7)) + (dArr3[i5][i] * d7);
            }
            i2 = i5;
        }
        return 0.0d;
    }

    public void d(double d2, double[] dArr) {
        double[] dArr2 = this.f506a;
        int length = dArr2.length;
        int i = 0;
        int length2 = this.b[0].length;
        if (this.d) {
            double d3 = dArr2[0];
            if (d2 <= d3) {
                g(d3, this.e);
                for (int i2 = 0; i2 < length2; i2++) {
                    dArr[i2] = this.b[0][i2] + ((d2 - this.f506a[0]) * this.e[i2]);
                }
                return;
            }
            int i3 = length - 1;
            double d4 = dArr2[i3];
            if (d2 >= d4) {
                g(d4, this.e);
                while (i < length2) {
                    dArr[i] = this.b[i3][i] + ((d2 - this.f506a[i3]) * this.e[i]);
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
            if (d2 == this.f506a[i6]) {
                for (int i7 = 0; i7 < length2; i7++) {
                    dArr[i7] = this.b[i6][i7];
                }
            }
            double[] dArr3 = this.f506a;
            int i8 = i6 + 1;
            double d5 = dArr3[i8];
            if (d2 < d5) {
                double d6 = dArr3[i6];
                double d7 = (d2 - d6) / (d5 - d6);
                while (i < length2) {
                    double[][] dArr4 = this.b;
                    dArr[i] = (dArr4[i6][i] * (1.0d - d7)) + (dArr4[i8][i] * d7);
                    i++;
                }
                return;
            }
            i6 = i8;
        }
    }

    public void e(double d2, float[] fArr) {
        double[] dArr = this.f506a;
        int length = dArr.length;
        int i = 0;
        int length2 = this.b[0].length;
        if (this.d) {
            double d3 = dArr[0];
            if (d2 <= d3) {
                g(d3, this.e);
                for (int i2 = 0; i2 < length2; i2++) {
                    fArr[i2] = (float) (this.b[0][i2] + ((d2 - this.f506a[0]) * this.e[i2]));
                }
                return;
            }
            int i3 = length - 1;
            double d4 = dArr[i3];
            if (d2 >= d4) {
                g(d4, this.e);
                while (i < length2) {
                    fArr[i] = (float) (this.b[i3][i] + ((d2 - this.f506a[i3]) * this.e[i]));
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
            if (d2 == this.f506a[i6]) {
                for (int i7 = 0; i7 < length2; i7++) {
                    fArr[i7] = (float) this.b[i6][i7];
                }
            }
            double[] dArr2 = this.f506a;
            int i8 = i6 + 1;
            double d5 = dArr2[i8];
            if (d2 < d5) {
                double d6 = dArr2[i6];
                double d7 = (d2 - d6) / (d5 - d6);
                while (i < length2) {
                    double[][] dArr3 = this.b;
                    fArr[i] = (float) ((dArr3[i6][i] * (1.0d - d7)) + (dArr3[i8][i] * d7));
                    i++;
                }
                return;
            }
            i6 = i8;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        if (r8 >= r3) goto L_0x000a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double f(double r8, int r10) {
        /*
            r7 = this;
            double[] r0 = r7.f506a
            int r1 = r0.length
            r2 = 0
            r3 = r0[r2]
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x000c
        L_0x000a:
            r8 = r3
            goto L_0x0015
        L_0x000c:
            int r3 = r1 + -1
            r3 = r0[r3]
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x0015
            goto L_0x000a
        L_0x0015:
            int r0 = r1 + -1
            if (r2 >= r0) goto L_0x0035
            double[] r0 = r7.f506a
            int r3 = r2 + 1
            r4 = r0[r3]
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0033
            r8 = r0[r2]
            double r4 = r4 - r8
            double[][] r7 = r7.b
            r8 = r7[r2]
            r8 = r8[r10]
            r7 = r7[r3]
            r0 = r7[r10]
            double r0 = r0 - r8
            double r0 = r0 / r4
            return r0
        L_0x0033:
            r2 = r3
            goto L_0x0015
        L_0x0035:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.f(double, int):double");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0017, code lost:
        if (r11 >= r4) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(double r11, double[] r13) {
        /*
            r10 = this;
            double[] r0 = r10.f506a
            int r1 = r0.length
            double[][] r2 = r10.b
            r3 = 0
            r2 = r2[r3]
            int r2 = r2.length
            r4 = r0[r3]
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0011
        L_0x000f:
            r11 = r4
            goto L_0x001a
        L_0x0011:
            int r4 = r1 + -1
            r4 = r0[r4]
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x001a
            goto L_0x000f
        L_0x001a:
            r0 = r3
        L_0x001b:
            int r4 = r1 + -1
            if (r0 >= r4) goto L_0x0041
            double[] r4 = r10.f506a
            int r5 = r0 + 1
            r6 = r4[r5]
            int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x003f
            r11 = r4[r0]
            double r6 = r6 - r11
        L_0x002c:
            if (r3 >= r2) goto L_0x0041
            double[][] r11 = r10.b
            r12 = r11[r0]
            r8 = r12[r3]
            r11 = r11[r5]
            r11 = r11[r3]
            double r11 = r11 - r8
            double r11 = r11 / r6
            r13[r3] = r11
            int r3 = r3 + 1
            goto L_0x002c
        L_0x003f:
            r0 = r5
            goto L_0x001b
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.g(double, double[]):void");
    }

    public double[] h() {
        return this.f506a;
    }
}
