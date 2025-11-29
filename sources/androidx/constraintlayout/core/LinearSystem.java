package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem {
    public static boolean r = false;
    public static boolean s = true;
    public static boolean t = true;
    public static boolean u = true;
    public static boolean v = false;
    public static int w = 1000;
    public static Metrics x;
    public static long y;
    public static long z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f479a;
    public int b;
    public HashMap c;
    public Row d;
    public int e;
    public int f;
    public ArrayRow[] g;
    public boolean h;
    public boolean i;
    public boolean[] j;
    public int k;
    public int l;
    public int m;
    public final Cache n;
    public SolverVariable[] o;
    public int p;
    public Row q;

    public interface Row {
        SolverVariable a(LinearSystem linearSystem, boolean[] zArr);

        void b(Row row);

        void c(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        boolean isEmpty();
    }

    public class ValuesRow extends ArrayRow {
        public ValuesRow(Cache cache) {
            this.e = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        this.f479a = false;
        this.b = 0;
        this.c = null;
        this.e = 32;
        this.f = 32;
        this.g = null;
        this.h = false;
        this.i = false;
        this.j = new boolean[32];
        this.k = 1;
        this.l = 0;
        this.m = 32;
        this.o = new SolverVariable[w];
        this.p = 0;
        this.g = new ArrayRow[32];
        D();
        Cache cache = new Cache();
        this.n = cache;
        this.d = new PriorityGoalRow(cache);
        if (v) {
            this.q = new ValuesRow(cache);
        } else {
            this.q = new ArrayRow(cache);
        }
    }

    public static ArrayRow s(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f2) {
        return linearSystem.r().j(solverVariable, solverVariable2, f2);
    }

    public static Metrics x() {
        return x;
    }

    public void A() {
        Metrics metrics = x;
        if (metrics != null) {
            metrics.e++;
        }
        if (this.d.isEmpty()) {
            n();
        } else if (this.h || this.i) {
            Metrics metrics2 = x;
            if (metrics2 != null) {
                metrics2.q++;
            }
            for (int i2 = 0; i2 < this.l; i2++) {
                if (!this.g[i2].f) {
                    B(this.d);
                    return;
                }
            }
            Metrics metrics3 = x;
            if (metrics3 != null) {
                metrics3.p++;
            }
            n();
        } else {
            B(this.d);
        }
    }

    public void B(Row row) {
        Metrics metrics = x;
        if (metrics != null) {
            metrics.t++;
            metrics.u = Math.max(metrics.u, (long) this.k);
            Metrics metrics2 = x;
            metrics2.v = Math.max(metrics2.v, (long) this.l);
        }
        u(row);
        C(row, false);
        n();
    }

    public final int C(Row row, boolean z2) {
        Metrics metrics = x;
        if (metrics != null) {
            metrics.h++;
        }
        for (int i2 = 0; i2 < this.k; i2++) {
            this.j[i2] = false;
        }
        boolean z3 = false;
        int i3 = 0;
        while (!z3) {
            Metrics metrics2 = x;
            if (metrics2 != null) {
                metrics2.i++;
            }
            i3++;
            if (i3 >= this.k * 2) {
                return i3;
            }
            if (row.getKey() != null) {
                this.j[row.getKey().c] = true;
            }
            SolverVariable a2 = row.a(this, this.j);
            if (a2 != null) {
                boolean[] zArr = this.j;
                int i4 = a2.c;
                if (zArr[i4]) {
                    return i3;
                }
                zArr[i4] = true;
            }
            if (a2 != null) {
                float f2 = Float.MAX_VALUE;
                int i5 = -1;
                for (int i6 = 0; i6 < this.l; i6++) {
                    ArrayRow arrayRow = this.g[i6];
                    if (arrayRow.f477a.j != SolverVariable.Type.UNRESTRICTED && !arrayRow.f && arrayRow.t(a2)) {
                        float g2 = arrayRow.e.g(a2);
                        if (g2 < 0.0f) {
                            float f3 = (-arrayRow.b) / g2;
                            if (f3 < f2) {
                                i5 = i6;
                                f2 = f3;
                            }
                        }
                    }
                }
                if (i5 > -1) {
                    ArrayRow arrayRow2 = this.g[i5];
                    arrayRow2.f477a.d = -1;
                    Metrics metrics3 = x;
                    if (metrics3 != null) {
                        metrics3.j++;
                    }
                    arrayRow2.x(a2);
                    SolverVariable solverVariable = arrayRow2.f477a;
                    solverVariable.d = i5;
                    solverVariable.j(this, arrayRow2);
                }
            } else {
                z3 = true;
            }
        }
        return i3;
    }

    public final void D() {
        int i2 = 0;
        if (v) {
            while (i2 < this.l) {
                ArrayRow arrayRow = this.g[i2];
                if (arrayRow != null) {
                    this.n.f478a.a(arrayRow);
                }
                this.g[i2] = null;
                i2++;
            }
            return;
        }
        while (i2 < this.l) {
            ArrayRow arrayRow2 = this.g[i2];
            if (arrayRow2 != null) {
                this.n.b.a(arrayRow2);
            }
            this.g[i2] = null;
            i2++;
        }
    }

    public void E() {
        Cache cache;
        int i2 = 0;
        while (true) {
            cache = this.n;
            SolverVariable[] solverVariableArr = cache.d;
            if (i2 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i2];
            if (solverVariable != null) {
                solverVariable.g();
            }
            i2++;
        }
        cache.c.b(this.o, this.p);
        this.p = 0;
        Arrays.fill(this.n.d, (Object) null);
        HashMap hashMap = this.c;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.b = 0;
        this.d.clear();
        this.k = 1;
        for (int i3 = 0; i3 < this.l; i3++) {
            ArrayRow arrayRow = this.g[i3];
            if (arrayRow != null) {
                arrayRow.c = false;
            }
        }
        D();
        this.l = 0;
        if (v) {
            this.q = new ValuesRow(this.n);
        } else {
            this.q = new ArrayRow(this.n);
        }
    }

    public final SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable solverVariable = (SolverVariable) this.n.c.acquire();
        if (solverVariable == null) {
            solverVariable = new SolverVariable(type, str);
            solverVariable.i(type, str);
        } else {
            solverVariable.g();
            solverVariable.i(type, str);
        }
        int i2 = this.p;
        int i3 = w;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            w = i4;
            this.o = (SolverVariable[]) Arrays.copyOf(this.o, i4);
        }
        SolverVariable[] solverVariableArr = this.o;
        int i5 = this.p;
        this.p = i5 + 1;
        solverVariableArr[i5] = solverVariable;
        return solverVariable;
    }

    public void b(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f2, int i2) {
        ConstraintWidget constraintWidget3 = constraintWidget;
        ConstraintWidget constraintWidget4 = constraintWidget2;
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable q2 = q(constraintWidget3.q(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable q3 = q(constraintWidget3.q(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable q4 = q(constraintWidget3.q(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable q5 = q(constraintWidget3.q(type4));
        SolverVariable q6 = q(constraintWidget4.q(type));
        SolverVariable q7 = q(constraintWidget4.q(type2));
        SolverVariable q8 = q(constraintWidget4.q(type3));
        SolverVariable q9 = q(constraintWidget4.q(type4));
        ArrayRow r2 = r();
        double d2 = (double) f2;
        SolverVariable solverVariable = q8;
        double d3 = (double) i2;
        r2.q(q3, q5, q7, q9, (float) (Math.sin(d2) * d3));
        d(r2);
        ArrayRow r3 = r();
        r3.q(q2, q4, q6, solverVariable, (float) (Math.cos(d2) * d3));
        d(r3);
    }

    public void c(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3, int i4) {
        int i5 = i4;
        ArrayRow r2 = r();
        r2.h(solverVariable, solverVariable2, i2, f2, solverVariable3, solverVariable4, i3);
        if (i5 != 8) {
            r2.d(this, i5);
        }
        d(r2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x009f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(androidx.constraintlayout.core.ArrayRow r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            androidx.constraintlayout.core.Metrics r0 = x
            r1 = 1
            if (r0 == 0) goto L_0x0017
            long r3 = r0.f
            long r3 = r3 + r1
            r0.f = r3
            boolean r3 = r8.f
            if (r3 == 0) goto L_0x0017
            long r3 = r0.g
            long r3 = r3 + r1
            r0.g = r3
        L_0x0017:
            int r0 = r7.l
            r3 = 1
            int r0 = r0 + r3
            int r4 = r7.m
            if (r0 >= r4) goto L_0x0026
            int r0 = r7.k
            int r0 = r0 + r3
            int r4 = r7.f
            if (r0 < r4) goto L_0x0029
        L_0x0026:
            r7.z()
        L_0x0029:
            boolean r0 = r8.f
            r4 = 0
            if (r0 != 0) goto L_0x00a1
            r8.D(r7)
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L_0x0038
            return
        L_0x0038:
            r8.r()
            boolean r0 = r8.f(r7)
            if (r0 == 0) goto L_0x0098
            androidx.constraintlayout.core.SolverVariable r0 = r7.p()
            r8.f477a = r0
            int r5 = r7.l
            r7.l(r8)
            int r6 = r7.l
            int r5 = r5 + r3
            if (r6 != r5) goto L_0x0098
            androidx.constraintlayout.core.LinearSystem$Row r4 = r7.q
            r4.b(r8)
            androidx.constraintlayout.core.LinearSystem$Row r4 = r7.q
            r7.C(r4, r3)
            int r4 = r0.d
            r5 = -1
            if (r4 != r5) goto L_0x0099
            androidx.constraintlayout.core.SolverVariable r4 = r8.f477a
            if (r4 != r0) goto L_0x0076
            androidx.constraintlayout.core.SolverVariable r0 = r8.v(r0)
            if (r0 == 0) goto L_0x0076
            androidx.constraintlayout.core.Metrics r4 = x
            if (r4 == 0) goto L_0x0073
            long r5 = r4.j
            long r5 = r5 + r1
            r4.j = r5
        L_0x0073:
            r8.x(r0)
        L_0x0076:
            boolean r0 = r8.f
            if (r0 != 0) goto L_0x007f
            androidx.constraintlayout.core.SolverVariable r0 = r8.f477a
            r0.j(r7, r8)
        L_0x007f:
            boolean r0 = v
            if (r0 == 0) goto L_0x008b
            androidx.constraintlayout.core.Cache r0 = r7.n
            androidx.constraintlayout.core.Pools$Pool r0 = r0.f478a
            r0.a(r8)
            goto L_0x0092
        L_0x008b:
            androidx.constraintlayout.core.Cache r0 = r7.n
            androidx.constraintlayout.core.Pools$Pool r0 = r0.b
            r0.a(r8)
        L_0x0092:
            int r0 = r7.l
            int r0 = r0 - r3
            r7.l = r0
            goto L_0x0099
        L_0x0098:
            r3 = r4
        L_0x0099:
            boolean r0 = r8.s()
            if (r0 != 0) goto L_0x00a0
            return
        L_0x00a0:
            r4 = r3
        L_0x00a1:
            if (r4 != 0) goto L_0x00a6
            r7.l(r8)
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.LinearSystem.d(androidx.constraintlayout.core.ArrayRow):void");
    }

    public ArrayRow e(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        if (!s || i3 != 8 || !solverVariable2.g || solverVariable.d != -1) {
            ArrayRow r2 = r();
            r2.n(solverVariable, solverVariable2, i2);
            if (i3 != 8) {
                r2.d(this, i3);
            }
            d(r2);
            return r2;
        }
        solverVariable.h(this, solverVariable2.f + ((float) i2));
        return null;
    }

    public void f(SolverVariable solverVariable, int i2) {
        if (!s || solverVariable.d != -1) {
            int i3 = solverVariable.d;
            if (i3 != -1) {
                ArrayRow arrayRow = this.g[i3];
                if (arrayRow.f) {
                    arrayRow.b = (float) i2;
                } else if (arrayRow.e.c() == 0) {
                    arrayRow.f = true;
                    arrayRow.b = (float) i2;
                } else {
                    ArrayRow r2 = r();
                    r2.m(solverVariable, i2);
                    d(r2);
                }
            } else {
                ArrayRow r3 = r();
                r3.i(solverVariable, i2);
                d(r3);
            }
        } else {
            float f2 = (float) i2;
            solverVariable.h(this, f2);
            for (int i4 = 0; i4 < this.b + 1; i4++) {
                SolverVariable solverVariable2 = this.n.d[i4];
                if (solverVariable2 != null && solverVariable2.n && solverVariable2.o == solverVariable.c) {
                    solverVariable2.h(this, solverVariable2.p + f2);
                }
            }
        }
    }

    public void g(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z2) {
        ArrayRow r2 = r();
        SolverVariable t2 = t();
        t2.e = 0;
        r2.o(solverVariable, solverVariable2, t2, i2);
        d(r2);
    }

    public void h(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow r2 = r();
        SolverVariable t2 = t();
        t2.e = 0;
        r2.o(solverVariable, solverVariable2, t2, i2);
        if (i3 != 8) {
            m(r2, (int) (r2.e.g(t2) * -1.0f), i3);
        }
        d(r2);
    }

    public void i(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z2) {
        ArrayRow r2 = r();
        SolverVariable t2 = t();
        t2.e = 0;
        r2.p(solverVariable, solverVariable2, t2, i2);
        d(r2);
    }

    public void j(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow r2 = r();
        SolverVariable t2 = t();
        t2.e = 0;
        r2.p(solverVariable, solverVariable2, t2, i2);
        if (i3 != 8) {
            m(r2, (int) (r2.e.g(t2) * -1.0f), i3);
        }
        d(r2);
    }

    public void k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2, int i2) {
        ArrayRow r2 = r();
        r2.k(solverVariable, solverVariable2, solverVariable3, solverVariable4, f2);
        if (i2 != 8) {
            r2.d(this, i2);
        }
        d(r2);
    }

    public final void l(ArrayRow arrayRow) {
        int i2;
        if (!t || !arrayRow.f) {
            ArrayRow[] arrayRowArr = this.g;
            int i3 = this.l;
            arrayRowArr[i3] = arrayRow;
            SolverVariable solverVariable = arrayRow.f477a;
            solverVariable.d = i3;
            this.l = i3 + 1;
            solverVariable.j(this, arrayRow);
        } else {
            arrayRow.f477a.h(this, arrayRow.b);
        }
        if (t && this.f479a) {
            int i4 = 0;
            while (i4 < this.l) {
                if (this.g[i4] == null) {
                    System.out.println("WTF");
                }
                ArrayRow arrayRow2 = this.g[i4];
                if (arrayRow2 != null && arrayRow2.f) {
                    arrayRow2.f477a.h(this, arrayRow2.b);
                    if (v) {
                        this.n.f478a.a(arrayRow2);
                    } else {
                        this.n.b.a(arrayRow2);
                    }
                    this.g[i4] = null;
                    int i5 = i4 + 1;
                    int i6 = i5;
                    while (true) {
                        i2 = this.l;
                        if (i5 >= i2) {
                            break;
                        }
                        ArrayRow[] arrayRowArr2 = this.g;
                        int i7 = i5 - 1;
                        ArrayRow arrayRow3 = arrayRowArr2[i5];
                        arrayRowArr2[i7] = arrayRow3;
                        SolverVariable solverVariable2 = arrayRow3.f477a;
                        if (solverVariable2.d == i5) {
                            solverVariable2.d = i7;
                        }
                        i6 = i5;
                        i5++;
                    }
                    if (i6 < i2) {
                        this.g[i6] = null;
                    }
                    this.l = i2 - 1;
                    i4--;
                }
                i4++;
            }
            this.f479a = false;
        }
    }

    public void m(ArrayRow arrayRow, int i2, int i3) {
        arrayRow.e(o(i3, (String) null), i2);
    }

    public final void n() {
        for (int i2 = 0; i2 < this.l; i2++) {
            ArrayRow arrayRow = this.g[i2];
            arrayRow.f477a.f = arrayRow.b;
        }
    }

    public SolverVariable o(int i2, String str) {
        Metrics metrics = x;
        if (metrics != null) {
            metrics.l++;
        }
        if (this.k + 1 >= this.f) {
            z();
        }
        SolverVariable a2 = a(SolverVariable.Type.ERROR, str);
        int i3 = this.b + 1;
        this.b = i3;
        this.k++;
        a2.c = i3;
        a2.e = i2;
        this.n.d[i3] = a2;
        this.d.c(a2);
        return a2;
    }

    public SolverVariable p() {
        Metrics metrics = x;
        if (metrics != null) {
            metrics.n++;
        }
        if (this.k + 1 >= this.f) {
            z();
        }
        SolverVariable a2 = a(SolverVariable.Type.SLACK, (String) null);
        int i2 = this.b + 1;
        this.b = i2;
        this.k++;
        a2.c = i2;
        this.n.d[i2] = a2;
        return a2;
    }

    public SolverVariable q(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.k + 1 >= this.f) {
            z();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.i();
            if (solverVariable == null) {
                constraintAnchor.s(this.n);
                solverVariable = constraintAnchor.i();
            }
            int i2 = solverVariable.c;
            if (i2 == -1 || i2 > this.b || this.n.d[i2] == null) {
                if (i2 != -1) {
                    solverVariable.g();
                }
                int i3 = this.b + 1;
                this.b = i3;
                this.k++;
                solverVariable.c = i3;
                solverVariable.j = SolverVariable.Type.UNRESTRICTED;
                this.n.d[i3] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow r() {
        ArrayRow arrayRow;
        if (v) {
            arrayRow = (ArrayRow) this.n.f478a.acquire();
            if (arrayRow == null) {
                arrayRow = new ValuesRow(this.n);
                z++;
            } else {
                arrayRow.y();
            }
        } else {
            arrayRow = (ArrayRow) this.n.b.acquire();
            if (arrayRow == null) {
                arrayRow = new ArrayRow(this.n);
                y++;
            } else {
                arrayRow.y();
            }
        }
        SolverVariable.d();
        return arrayRow;
    }

    public SolverVariable t() {
        Metrics metrics = x;
        if (metrics != null) {
            metrics.m++;
        }
        if (this.k + 1 >= this.f) {
            z();
        }
        SolverVariable a2 = a(SolverVariable.Type.SLACK, (String) null);
        int i2 = this.b + 1;
        this.b = i2;
        this.k++;
        a2.c = i2;
        this.n.d[i2] = a2;
        return a2;
    }

    public final int u(Row row) {
        for (int i2 = 0; i2 < this.l; i2++) {
            ArrayRow arrayRow = this.g[i2];
            if (arrayRow.f477a.j != SolverVariable.Type.UNRESTRICTED && arrayRow.b < 0.0f) {
                boolean z2 = false;
                int i3 = 0;
                while (!z2) {
                    Metrics metrics = x;
                    if (metrics != null) {
                        metrics.k++;
                    }
                    i3++;
                    float f2 = Float.MAX_VALUE;
                    int i4 = 0;
                    int i5 = -1;
                    int i6 = -1;
                    int i7 = 0;
                    while (true) {
                        if (i4 >= this.l) {
                            break;
                        }
                        ArrayRow arrayRow2 = this.g[i4];
                        if (arrayRow2.f477a.j != SolverVariable.Type.UNRESTRICTED && !arrayRow2.f && arrayRow2.b < 0.0f) {
                            int i8 = 9;
                            if (u) {
                                int c2 = arrayRow2.e.c();
                                int i9 = 0;
                                while (i9 < c2) {
                                    SolverVariable e2 = arrayRow2.e.e(i9);
                                    float g2 = arrayRow2.e.g(e2);
                                    if (g2 > 0.0f) {
                                        int i10 = 0;
                                        while (i10 < i8) {
                                            float f3 = e2.h[i10] / g2;
                                            if ((f3 < f2 && i10 == i7) || i10 > i7) {
                                                i7 = i10;
                                                i6 = e2.c;
                                                i5 = i4;
                                                f2 = f3;
                                            }
                                            i10++;
                                            i8 = 9;
                                        }
                                    }
                                    i9++;
                                    i8 = 9;
                                }
                            } else {
                                for (int i11 = 1; i11 < this.k; i11++) {
                                    SolverVariable solverVariable = this.n.d[i11];
                                    float g3 = arrayRow2.e.g(solverVariable);
                                    if (g3 > 0.0f) {
                                        for (int i12 = 0; i12 < 9; i12++) {
                                            float f4 = solverVariable.h[i12] / g3;
                                            if ((f4 < f2 && i12 == i7) || i12 > i7) {
                                                i7 = i12;
                                                i5 = i4;
                                                i6 = i11;
                                                f2 = f4;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i4++;
                    }
                    if (i5 != -1) {
                        ArrayRow arrayRow3 = this.g[i5];
                        arrayRow3.f477a.d = -1;
                        Metrics metrics2 = x;
                        if (metrics2 != null) {
                            metrics2.j++;
                        }
                        arrayRow3.x(this.n.d[i6]);
                        SolverVariable solverVariable2 = arrayRow3.f477a;
                        solverVariable2.d = i5;
                        solverVariable2.j(this, arrayRow3);
                    } else {
                        z2 = true;
                    }
                    if (i3 > this.k / 2) {
                        z2 = true;
                    }
                }
                return i3;
            }
        }
        return 0;
    }

    public void v(Metrics metrics) {
        x = metrics;
    }

    public Cache w() {
        return this.n;
    }

    public int y(Object obj) {
        SolverVariable i2 = ((ConstraintAnchor) obj).i();
        if (i2 != null) {
            return (int) (i2.f + 0.5f);
        }
        return 0;
    }

    public final void z() {
        int i2 = this.e * 2;
        this.e = i2;
        this.g = (ArrayRow[]) Arrays.copyOf(this.g, i2);
        Cache cache = this.n;
        cache.d = (SolverVariable[]) Arrays.copyOf(cache.d, this.e);
        int i3 = this.e;
        this.j = new boolean[i3];
        this.f = i3;
        this.m = i3;
        Metrics metrics = x;
        if (metrics != null) {
            metrics.d++;
            metrics.o = Math.max(metrics.o, (long) i3);
            Metrics metrics2 = x;
            metrics2.x = metrics2.o;
        }
    }
}
