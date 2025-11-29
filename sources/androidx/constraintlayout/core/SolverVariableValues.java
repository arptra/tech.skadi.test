package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;

public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    public static float n = 0.001f;

    /* renamed from: a  reason: collision with root package name */
    public final int f486a = -1;
    public int b = 16;
    public int c = 16;
    public int[] d = new int[16];
    public int[] e = new int[16];
    public int[] f = new int[16];
    public float[] g = new float[16];
    public int[] h = new int[16];
    public int[] i = new int[16];
    public int j = 0;
    public int k = -1;
    public final ArrayRow l;
    public final Cache m;

    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.l = arrayRow;
        this.m = cache;
        clear();
    }

    public final void a(SolverVariable solverVariable, int i2) {
        int[] iArr;
        int i3 = solverVariable.c % this.c;
        int[] iArr2 = this.d;
        int i4 = iArr2[i3];
        if (i4 == -1) {
            iArr2[i3] = i2;
        } else {
            while (true) {
                iArr = this.e;
                int i5 = iArr[i4];
                if (i5 == -1) {
                    break;
                }
                i4 = i5;
            }
            iArr[i4] = i2;
        }
        this.e[i2] = -1;
    }

    public final void b(int i2, SolverVariable solverVariable, float f2) {
        this.f[i2] = solverVariable.c;
        this.g[i2] = f2;
        this.h[i2] = -1;
        this.i[i2] = -1;
        solverVariable.a(this.l);
        solverVariable.m++;
        this.j++;
    }

    public int c() {
        return this.j;
    }

    public void clear() {
        int i2 = this.j;
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable e2 = e(i3);
            if (e2 != null) {
                e2.f(this.l);
            }
        }
        for (int i4 = 0; i4 < this.b; i4++) {
            this.f[i4] = -1;
            this.e[i4] = -1;
        }
        for (int i5 = 0; i5 < this.c; i5++) {
            this.d[i5] = -1;
        }
        this.j = 0;
        this.k = -1;
    }

    public boolean d(SolverVariable solverVariable) {
        return p(solverVariable) != -1;
    }

    public SolverVariable e(int i2) {
        int i3 = this.j;
        if (i3 == 0) {
            return null;
        }
        int i4 = this.k;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2 && i4 != -1) {
                return this.m.d[this.f[i4]];
            }
            i4 = this.i[i4];
            if (i4 == -1) {
                break;
            }
        }
        return null;
    }

    public void f(SolverVariable solverVariable, float f2) {
        float f3 = n;
        if (f2 <= (-f3) || f2 >= f3) {
            if (this.j == 0) {
                b(0, solverVariable, f2);
                a(solverVariable, 0);
                this.k = 0;
                return;
            }
            int p = p(solverVariable);
            if (p != -1) {
                this.g[p] = f2;
                return;
            }
            if (this.j + 1 >= this.b) {
                o();
            }
            int i2 = this.j;
            int i3 = this.k;
            int i4 = -1;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = this.f[i3];
                int i7 = solverVariable.c;
                if (i6 == i7) {
                    this.g[i3] = f2;
                    return;
                }
                if (i6 < i7) {
                    i4 = i3;
                }
                i3 = this.i[i3];
                if (i3 == -1) {
                    break;
                }
            }
            q(i4, solverVariable, f2);
            return;
        }
        k(solverVariable, true);
    }

    public float g(SolverVariable solverVariable) {
        int p = p(solverVariable);
        if (p != -1) {
            return this.g[p];
        }
        return 0.0f;
    }

    public void h(float f2) {
        int i2 = this.j;
        int i3 = this.k;
        int i4 = 0;
        while (i4 < i2) {
            float[] fArr = this.g;
            fArr[i3] = fArr[i3] / f2;
            i3 = this.i[i3];
            if (i3 != -1) {
                i4++;
            } else {
                return;
            }
        }
    }

    public void i(SolverVariable solverVariable, float f2, boolean z) {
        float f3 = n;
        if (f2 <= (-f3) || f2 >= f3) {
            int p = p(solverVariable);
            if (p == -1) {
                f(solverVariable, f2);
                return;
            }
            float[] fArr = this.g;
            float f4 = fArr[p] + f2;
            fArr[p] = f4;
            float f5 = n;
            if (f4 > (-f5) && f4 < f5) {
                fArr[p] = 0.0f;
                k(solverVariable, z);
            }
        }
    }

    public void j() {
        int i2 = this.j;
        int i3 = this.k;
        int i4 = 0;
        while (i4 < i2) {
            float[] fArr = this.g;
            fArr[i3] = fArr[i3] * -1.0f;
            i3 = this.i[i3];
            if (i3 != -1) {
                i4++;
            } else {
                return;
            }
        }
    }

    public float k(SolverVariable solverVariable, boolean z) {
        int p = p(solverVariable);
        if (p == -1) {
            return 0.0f;
        }
        r(solverVariable);
        float f2 = this.g[p];
        if (this.k == p) {
            this.k = this.i[p];
        }
        this.f[p] = -1;
        int[] iArr = this.h;
        int i2 = iArr[p];
        if (i2 != -1) {
            int[] iArr2 = this.i;
            iArr2[i2] = iArr2[p];
        }
        int i3 = this.i[p];
        if (i3 != -1) {
            iArr[i3] = iArr[p];
        }
        this.j--;
        solverVariable.m--;
        if (z) {
            solverVariable.f(this.l);
        }
        return f2;
    }

    public float l(ArrayRow arrayRow, boolean z) {
        float g2 = g(arrayRow.f477a);
        k(arrayRow.f477a, z);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.e;
        int c2 = solverVariableValues.c();
        int i2 = 0;
        int i3 = 0;
        while (i2 < c2) {
            int i4 = solverVariableValues.f[i3];
            if (i4 != -1) {
                i(this.m.d[i4], solverVariableValues.g[i3] * g2, z);
                i2++;
            }
            i3++;
        }
        return g2;
    }

    public float m(int i2) {
        int i3 = this.j;
        int i4 = this.k;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2) {
                return this.g[i4];
            }
            i4 = this.i[i4];
            if (i4 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    public final int n() {
        for (int i2 = 0; i2 < this.b; i2++) {
            if (this.f[i2] == -1) {
                return i2;
            }
        }
        return -1;
    }

    public final void o() {
        int i2 = this.b * 2;
        this.f = Arrays.copyOf(this.f, i2);
        this.g = Arrays.copyOf(this.g, i2);
        this.h = Arrays.copyOf(this.h, i2);
        this.i = Arrays.copyOf(this.i, i2);
        this.e = Arrays.copyOf(this.e, i2);
        for (int i3 = this.b; i3 < i2; i3++) {
            this.f[i3] = -1;
            this.e[i3] = -1;
        }
        this.b = i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int p(androidx.constraintlayout.core.SolverVariable r4) {
        /*
            r3 = this;
            int r0 = r3.j
            r1 = -1
            if (r0 == 0) goto L_0x0033
            if (r4 != 0) goto L_0x0008
            goto L_0x0033
        L_0x0008:
            int r4 = r4.c
            int r0 = r3.c
            int r0 = r4 % r0
            int[] r2 = r3.d
            r0 = r2[r0]
            if (r0 != r1) goto L_0x0015
            return r1
        L_0x0015:
            int[] r2 = r3.f
            r2 = r2[r0]
            if (r2 != r4) goto L_0x001c
            return r0
        L_0x001c:
            int[] r2 = r3.e
            r0 = r2[r0]
            if (r0 == r1) goto L_0x0029
            int[] r2 = r3.f
            r2 = r2[r0]
            if (r2 == r4) goto L_0x0029
            goto L_0x001c
        L_0x0029:
            if (r0 != r1) goto L_0x002c
            return r1
        L_0x002c:
            int[] r3 = r3.f
            r3 = r3[r0]
            if (r3 != r4) goto L_0x0033
            return r0
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.SolverVariableValues.p(androidx.constraintlayout.core.SolverVariable):int");
    }

    public final void q(int i2, SolverVariable solverVariable, float f2) {
        int n2 = n();
        b(n2, solverVariable, f2);
        if (i2 != -1) {
            this.h[n2] = i2;
            int[] iArr = this.i;
            iArr[n2] = iArr[i2];
            iArr[i2] = n2;
        } else {
            this.h[n2] = -1;
            if (this.j > 0) {
                this.i[n2] = this.k;
                this.k = n2;
            } else {
                this.i[n2] = -1;
            }
        }
        int i3 = this.i[n2];
        if (i3 != -1) {
            this.h[i3] = n2;
        }
        a(solverVariable, n2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r(androidx.constraintlayout.core.SolverVariable r6) {
        /*
            r5 = this;
            int r6 = r6.c
            int r0 = r5.c
            int r0 = r6 % r0
            int[] r1 = r5.d
            r2 = r1[r0]
            r3 = -1
            if (r2 != r3) goto L_0x000e
            return
        L_0x000e:
            int[] r4 = r5.f
            r4 = r4[r2]
            if (r4 != r6) goto L_0x001d
            int[] r5 = r5.e
            r6 = r5[r2]
            r1[r0] = r6
            r5[r2] = r3
            goto L_0x0039
        L_0x001d:
            int[] r0 = r5.e
            r1 = r0[r2]
            if (r1 == r3) goto L_0x002b
            int[] r4 = r5.f
            r4 = r4[r1]
            if (r4 == r6) goto L_0x002b
            r2 = r1
            goto L_0x001d
        L_0x002b:
            if (r1 == r3) goto L_0x0039
            int[] r5 = r5.f
            r5 = r5[r1]
            if (r5 != r6) goto L_0x0039
            r5 = r0[r1]
            r0[r2] = r5
            r0[r1] = r3
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.SolverVariableValues.r(androidx.constraintlayout.core.SolverVariable):void");
    }

    public String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i2 = this.j;
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable e2 = e(i3);
            if (e2 != null) {
                String str4 = str3 + e2 + " = " + m(i3) + " ";
                int p = p(e2);
                String str5 = str4 + "[p: ";
                if (this.h[p] != -1) {
                    str = str5 + this.m.d[this.f[this.h[p]]];
                } else {
                    str = str5 + "none";
                }
                String str6 = str + ", n: ";
                if (this.i[p] != -1) {
                    str2 = str6 + this.m.d[this.f[this.i[p]]];
                } else {
                    str2 = str6 + "none";
                }
                str3 = str2 + "]";
            }
        }
        return str3 + " }";
    }
}
