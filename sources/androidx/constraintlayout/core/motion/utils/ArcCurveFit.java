package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

public class ArcCurveFit extends CurveFit {

    /* renamed from: a  reason: collision with root package name */
    public final double[] f495a;
    public Arc[] b;
    public boolean c = true;

    public static class Arc {
        public static double[] s = new double[91];

        /* renamed from: a  reason: collision with root package name */
        public double[] f496a;
        public double b;
        public double c;
        public double d;
        public double e;
        public double f;
        public double g;
        public double h;
        public double i;
        public double j;
        public double k;
        public double l;
        public double m;
        public double n;
        public double o;
        public double p;
        public boolean q;
        public boolean r = false;

        public Arc(int i2, double d2, double d3, double d4, double d5, double d6, double d7) {
            int i3 = i2;
            double d8 = d2;
            double d9 = d3;
            double d10 = d4;
            double d11 = d5;
            double d12 = d6;
            double d13 = d7;
            boolean z = false;
            int i4 = 1;
            this.q = i3 == 1 ? true : z;
            this.c = d8;
            this.d = d9;
            this.i = 1.0d / (d9 - d8);
            if (3 == i3) {
                this.r = true;
            }
            double d14 = d12 - d10;
            double d15 = d13 - d11;
            if (this.r || Math.abs(d14) < 0.001d || Math.abs(d15) < 0.001d) {
                this.r = true;
                this.e = d10;
                this.f = d12;
                this.g = d11;
                this.h = d7;
                double hypot = Math.hypot(d15, d14);
                this.b = hypot;
                this.n = hypot * this.i;
                double d16 = this.d;
                double d17 = this.c;
                this.l = d14 / (d16 - d17);
                this.m = d15 / (d16 - d17);
                return;
            }
            this.f496a = new double[101];
            boolean z2 = this.q;
            this.j = d14 * ((double) (z2 ? -1 : 1));
            this.k = d15 * ((double) (!z2 ? -1 : i4));
            this.l = z2 ? d12 : d10;
            this.m = z2 ? d11 : d7;
            a(d4, d5, d6, d7);
            this.n = this.b * this.i;
        }

        public final void a(double d2, double d3, double d4, double d5) {
            double d6;
            double d7 = d4 - d2;
            double d8 = d3 - d5;
            int i2 = 0;
            double d9 = 0.0d;
            double d10 = 0.0d;
            double d11 = 0.0d;
            while (true) {
                double[] dArr = s;
                if (i2 >= dArr.length) {
                    break;
                }
                double d12 = d9;
                double radians = Math.toRadians((((double) i2) * 90.0d) / ((double) (dArr.length - 1)));
                double sin = Math.sin(radians) * d7;
                double cos = Math.cos(radians) * d8;
                if (i2 > 0) {
                    d6 = Math.hypot(sin - d10, cos - d11) + d12;
                    s[i2] = d6;
                } else {
                    d6 = d12;
                }
                i2++;
                d11 = cos;
                double d13 = sin;
                d9 = d6;
                d10 = d13;
            }
            double d14 = d9;
            this.b = d14;
            int i3 = 0;
            while (true) {
                double[] dArr2 = s;
                if (i3 >= dArr2.length) {
                    break;
                }
                dArr2[i3] = dArr2[i3] / d14;
                i3++;
            }
            int i4 = 0;
            while (true) {
                double[] dArr3 = this.f496a;
                if (i4 < dArr3.length) {
                    double length = ((double) i4) / ((double) (dArr3.length - 1));
                    int binarySearch = Arrays.binarySearch(s, length);
                    if (binarySearch >= 0) {
                        this.f496a[i4] = ((double) binarySearch) / ((double) (s.length - 1));
                    } else if (binarySearch == -1) {
                        this.f496a[i4] = 0.0d;
                    } else {
                        int i5 = -binarySearch;
                        int i6 = i5 - 2;
                        double[] dArr4 = s;
                        double d15 = dArr4[i6];
                        this.f496a[i4] = (((double) i6) + ((length - d15) / (dArr4[i5 - 1] - d15))) / ((double) (dArr4.length - 1));
                    }
                    i4++;
                } else {
                    return;
                }
            }
        }

        public double b() {
            double d2 = this.j * this.p;
            double hypot = this.n / Math.hypot(d2, (-this.k) * this.o);
            if (this.q) {
                d2 = -d2;
            }
            return d2 * hypot;
        }

        public double c() {
            double d2 = this.j * this.p;
            double d3 = (-this.k) * this.o;
            double hypot = this.n / Math.hypot(d2, d3);
            return this.q ? (-d3) * hypot : d3 * hypot;
        }

        public double d(double d2) {
            return this.l;
        }

        public double e(double d2) {
            return this.m;
        }

        public double f(double d2) {
            double d3 = (d2 - this.c) * this.i;
            double d4 = this.e;
            return d4 + (d3 * (this.f - d4));
        }

        public double g(double d2) {
            double d3 = (d2 - this.c) * this.i;
            double d4 = this.g;
            return d4 + (d3 * (this.h - d4));
        }

        public double h() {
            return this.l + (this.j * this.o);
        }

        public double i() {
            return this.m + (this.k * this.p);
        }

        public double j(double d2) {
            if (d2 <= 0.0d) {
                return 0.0d;
            }
            if (d2 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f496a;
            double length = d2 * ((double) (dArr.length - 1));
            int i2 = (int) length;
            double d3 = length - ((double) i2);
            double d4 = dArr[i2];
            return d4 + (d3 * (dArr[i2 + 1] - d4));
        }

        public void k(double d2) {
            double j2 = j((this.q ? this.d - d2 : d2 - this.c) * this.i) * 1.5707963267948966d;
            this.o = Math.sin(j2);
            this.p = Math.cos(j2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        if (r5 == 1) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ArcCurveFit(int[] r25, double[] r26, double[][] r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = r26
            r24.<init>()
            r2 = 1
            r0.c = r2
            r0.f495a = r1
            int r3 = r1.length
            int r3 = r3 - r2
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc[] r3 = new androidx.constraintlayout.core.motion.utils.ArcCurveFit.Arc[r3]
            r0.b = r3
            r3 = 0
            r5 = r2
            r6 = r5
            r4 = r3
        L_0x0016:
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc[] r7 = r0.b
            int r8 = r7.length
            if (r4 >= r8) goto L_0x0051
            r8 = r25[r4]
            r9 = 3
            if (r8 == 0) goto L_0x0031
            if (r8 == r2) goto L_0x002f
            r10 = 2
            if (r8 == r10) goto L_0x002d
            if (r8 == r9) goto L_0x0028
            goto L_0x0032
        L_0x0028:
            if (r5 != r2) goto L_0x002f
            goto L_0x002d
        L_0x002b:
            r6 = r5
            goto L_0x0032
        L_0x002d:
            r5 = r10
            goto L_0x002b
        L_0x002f:
            r5 = r2
            goto L_0x002b
        L_0x0031:
            r6 = r9
        L_0x0032:
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc r22 = new androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc
            r10 = r1[r4]
            int r23 = r4 + 1
            r12 = r1[r23]
            r8 = r27[r4]
            r14 = r8[r3]
            r16 = r8[r2]
            r8 = r27[r23]
            r18 = r8[r3]
            r20 = r8[r2]
            r8 = r22
            r9 = r6
            r8.<init>(r9, r10, r12, r14, r16, r18, r20)
            r7[r4] = r22
            r4 = r23
            goto L_0x0016
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.ArcCurveFit.<init>(int[], double[], double[][]):void");
    }

    public double c(double d, int i) {
        double g;
        double e;
        double i2;
        double c2;
        double g2;
        double e2;
        int i3 = 0;
        if (this.c) {
            Arc[] arcArr = this.b;
            Arc arc = arcArr[0];
            double d2 = arc.c;
            if (d < d2) {
                double d3 = d - d2;
                if (arc.r) {
                    if (i == 0) {
                        g2 = arc.f(d2);
                        e2 = this.b[0].d(d2);
                    } else {
                        g2 = arc.g(d2);
                        e2 = this.b[0].e(d2);
                    }
                    return g2 + (d3 * e2);
                }
                arc.k(d2);
                if (i == 0) {
                    i2 = this.b[0].h();
                    c2 = this.b[0].b();
                } else {
                    i2 = this.b[0].i();
                    c2 = this.b[0].c();
                }
                return i2 + (d3 * c2);
            } else if (d > arcArr[arcArr.length - 1].d) {
                double d4 = arcArr[arcArr.length - 1].d;
                double d5 = d - d4;
                int length = arcArr.length - 1;
                if (i == 0) {
                    g = arcArr[length].f(d4);
                    e = this.b[length].d(d4);
                } else {
                    g = arcArr[length].g(d4);
                    e = this.b[length].e(d4);
                }
                return g + (d5 * e);
            }
        } else {
            Arc[] arcArr2 = this.b;
            double d6 = arcArr2[0].c;
            if (d < d6) {
                d = d6;
            } else if (d > arcArr2[arcArr2.length - 1].d) {
                d = arcArr2[arcArr2.length - 1].d;
            }
        }
        while (true) {
            Arc[] arcArr3 = this.b;
            if (i3 >= arcArr3.length) {
                return Double.NaN;
            }
            Arc arc2 = arcArr3[i3];
            if (d > arc2.d) {
                i3++;
            } else if (arc2.r) {
                return i == 0 ? arc2.f(d) : arc2.g(d);
            } else {
                arc2.k(d);
                return i == 0 ? this.b[i3].h() : this.b[i3].i();
            }
        }
    }

    public void d(double d, double[] dArr) {
        if (this.c) {
            Arc[] arcArr = this.b;
            Arc arc = arcArr[0];
            double d2 = arc.c;
            if (d < d2) {
                double d3 = d - d2;
                if (arc.r) {
                    dArr[0] = arc.f(d2) + (this.b[0].d(d2) * d3);
                    dArr[1] = this.b[0].g(d2) + (d3 * this.b[0].e(d2));
                    return;
                }
                arc.k(d2);
                dArr[0] = this.b[0].h() + (this.b[0].b() * d3);
                dArr[1] = this.b[0].i() + (d3 * this.b[0].c());
                return;
            } else if (d > arcArr[arcArr.length - 1].d) {
                double d4 = arcArr[arcArr.length - 1].d;
                double d5 = d - d4;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.r) {
                    dArr[0] = arc2.f(d4) + (this.b[length].d(d4) * d5);
                    dArr[1] = this.b[length].g(d4) + (d5 * this.b[length].e(d4));
                    return;
                }
                arc2.k(d);
                dArr[0] = this.b[length].h() + (this.b[length].b() * d5);
                dArr[1] = this.b[length].i() + (d5 * this.b[length].c());
                return;
            }
        } else {
            Arc[] arcArr2 = this.b;
            double d6 = arcArr2[0].c;
            if (d < d6) {
                d = d6;
            }
            if (d > arcArr2[arcArr2.length - 1].d) {
                d = arcArr2[arcArr2.length - 1].d;
            }
        }
        int i = 0;
        while (true) {
            Arc[] arcArr3 = this.b;
            if (i < arcArr3.length) {
                Arc arc3 = arcArr3[i];
                if (d > arc3.d) {
                    i++;
                } else if (arc3.r) {
                    dArr[0] = arc3.f(d);
                    dArr[1] = this.b[i].g(d);
                    return;
                } else {
                    arc3.k(d);
                    dArr[0] = this.b[i].h();
                    dArr[1] = this.b[i].i();
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void e(double d, float[] fArr) {
        if (this.c) {
            Arc[] arcArr = this.b;
            Arc arc = arcArr[0];
            double d2 = arc.c;
            if (d < d2) {
                double d3 = d - d2;
                if (arc.r) {
                    fArr[0] = (float) (arc.f(d2) + (this.b[0].d(d2) * d3));
                    fArr[1] = (float) (this.b[0].g(d2) + (d3 * this.b[0].e(d2)));
                    return;
                }
                arc.k(d2);
                fArr[0] = (float) (this.b[0].h() + (this.b[0].b() * d3));
                fArr[1] = (float) (this.b[0].i() + (d3 * this.b[0].c()));
                return;
            } else if (d > arcArr[arcArr.length - 1].d) {
                double d4 = arcArr[arcArr.length - 1].d;
                double d5 = d - d4;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.r) {
                    fArr[0] = (float) (arc2.f(d4) + (this.b[length].d(d4) * d5));
                    fArr[1] = (float) (this.b[length].g(d4) + (d5 * this.b[length].e(d4)));
                    return;
                }
                arc2.k(d);
                fArr[0] = (float) this.b[length].h();
                fArr[1] = (float) this.b[length].i();
                return;
            }
        } else {
            Arc[] arcArr2 = this.b;
            double d6 = arcArr2[0].c;
            if (d < d6) {
                d = d6;
            } else if (d > arcArr2[arcArr2.length - 1].d) {
                d = arcArr2[arcArr2.length - 1].d;
            }
        }
        int i = 0;
        while (true) {
            Arc[] arcArr3 = this.b;
            if (i < arcArr3.length) {
                Arc arc3 = arcArr3[i];
                if (d > arc3.d) {
                    i++;
                } else if (arc3.r) {
                    fArr[0] = (float) arc3.f(d);
                    fArr[1] = (float) this.b[i].g(d);
                    return;
                } else {
                    arc3.k(d);
                    fArr[0] = (float) this.b[i].h();
                    fArr[1] = (float) this.b[i].i();
                    return;
                }
            } else {
                return;
            }
        }
    }

    public double f(double d, int i) {
        Arc[] arcArr = this.b;
        int i2 = 0;
        double d2 = arcArr[0].c;
        if (d < d2) {
            d = d2;
        }
        if (d > arcArr[arcArr.length - 1].d) {
            d = arcArr[arcArr.length - 1].d;
        }
        while (true) {
            Arc[] arcArr2 = this.b;
            if (i2 >= arcArr2.length) {
                return Double.NaN;
            }
            Arc arc = arcArr2[i2];
            if (d > arc.d) {
                i2++;
            } else if (arc.r) {
                return i == 0 ? arc.d(d) : arc.e(d);
            } else {
                arc.k(d);
                return i == 0 ? this.b[i2].b() : this.b[i2].c();
            }
        }
    }

    public void g(double d, double[] dArr) {
        Arc[] arcArr = this.b;
        double d2 = arcArr[0].c;
        if (d < d2) {
            d = d2;
        } else if (d > arcArr[arcArr.length - 1].d) {
            d = arcArr[arcArr.length - 1].d;
        }
        int i = 0;
        while (true) {
            Arc[] arcArr2 = this.b;
            if (i < arcArr2.length) {
                Arc arc = arcArr2[i];
                if (d > arc.d) {
                    i++;
                } else if (arc.r) {
                    dArr[0] = arc.d(d);
                    dArr[1] = this.b[i].e(d);
                    return;
                } else {
                    arc.k(d);
                    dArr[0] = this.b[i].b();
                    dArr[1] = this.b[i].c();
                    return;
                }
            } else {
                return;
            }
        }
    }

    public double[] h() {
        return this.f495a;
    }
}
