package androidx.constraintlayout.core;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.ArrayList;

public class ArrayRow implements LinearSystem.Row {

    /* renamed from: a  reason: collision with root package name */
    public SolverVariable f477a = null;
    public float b = 0.0f;
    public boolean c = false;
    public ArrayList d = new ArrayList();
    public ArrayRowVariables e;
    public boolean f = false;

    public interface ArrayRowVariables {
        int c();

        void clear();

        boolean d(SolverVariable solverVariable);

        SolverVariable e(int i);

        void f(SolverVariable solverVariable, float f);

        float g(SolverVariable solverVariable);

        void h(float f);

        void i(SolverVariable solverVariable, float f, boolean z);

        void j();

        float k(SolverVariable solverVariable, boolean z);

        float l(ArrayRow arrayRow, boolean z);

        float m(int i);
    }

    public ArrayRow() {
    }

    public void A(LinearSystem linearSystem, SolverVariable solverVariable, boolean z) {
        if (solverVariable != null && solverVariable.g) {
            this.b += solverVariable.f * this.e.g(solverVariable);
            this.e.k(solverVariable, z);
            if (z) {
                solverVariable.f(this);
            }
            if (LinearSystem.t && this.e.c() == 0) {
                this.f = true;
                linearSystem.f479a = true;
            }
        }
    }

    public void B(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        this.b += arrayRow.b * this.e.l(arrayRow, z);
        if (z) {
            arrayRow.f477a.f(this);
        }
        if (LinearSystem.t && this.f477a != null && this.e.c() == 0) {
            this.f = true;
            linearSystem.f479a = true;
        }
    }

    public void C(LinearSystem linearSystem, SolverVariable solverVariable, boolean z) {
        if (solverVariable != null && solverVariable.n) {
            float g = this.e.g(solverVariable);
            this.b += solverVariable.p * g;
            this.e.k(solverVariable, z);
            if (z) {
                solverVariable.f(this);
            }
            this.e.i(linearSystem.n.d[solverVariable.o], g, z);
            if (LinearSystem.t && this.e.c() == 0) {
                this.f = true;
                linearSystem.f479a = true;
            }
        }
    }

    public void D(LinearSystem linearSystem) {
        if (linearSystem.g.length != 0) {
            boolean z = false;
            while (!z) {
                int c2 = this.e.c();
                for (int i = 0; i < c2; i++) {
                    SolverVariable e2 = this.e.e(i);
                    if (e2.d != -1 || e2.g || e2.n) {
                        this.d.add(e2);
                    }
                }
                int size = this.d.size();
                if (size > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        SolverVariable solverVariable = (SolverVariable) this.d.get(i2);
                        if (solverVariable.g) {
                            A(linearSystem, solverVariable, true);
                        } else if (solverVariable.n) {
                            C(linearSystem, solverVariable, true);
                        } else {
                            B(linearSystem, linearSystem.g[solverVariable.d], true);
                        }
                    }
                    this.d.clear();
                } else {
                    z = true;
                }
            }
            if (LinearSystem.t && this.f477a != null && this.e.c() == 0) {
                this.f = true;
                linearSystem.f479a = true;
            }
        }
    }

    public SolverVariable a(LinearSystem linearSystem, boolean[] zArr) {
        return w(zArr, (SolverVariable) null);
    }

    public void b(LinearSystem.Row row) {
        if (row instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.f477a = null;
            this.e.clear();
            for (int i = 0; i < arrayRow.e.c(); i++) {
                this.e.i(arrayRow.e.e(i), arrayRow.e.m(i), true);
            }
        }
    }

    public void c(SolverVariable solverVariable) {
        int i = solverVariable.e;
        float f2 = 1.0f;
        if (i != 1) {
            if (i == 2) {
                f2 = 1000.0f;
            } else if (i == 3) {
                f2 = 1000000.0f;
            } else if (i == 4) {
                f2 = 1.0E9f;
            } else if (i == 5) {
                f2 = 1.0E12f;
            }
        }
        this.e.f(solverVariable, f2);
    }

    public void clear() {
        this.e.clear();
        this.f477a = null;
        this.b = 0.0f;
    }

    public ArrayRow d(LinearSystem linearSystem, int i) {
        this.e.f(linearSystem.o(i, "ep"), 1.0f);
        this.e.f(linearSystem.o(i, "em"), -1.0f);
        return this;
    }

    public ArrayRow e(SolverVariable solverVariable, int i) {
        this.e.f(solverVariable, (float) i);
        return this;
    }

    public boolean f(LinearSystem linearSystem) {
        boolean z;
        SolverVariable g = g(linearSystem);
        if (g == null) {
            z = true;
        } else {
            x(g);
            z = false;
        }
        if (this.e.c() == 0) {
            this.f = true;
        }
        return z;
    }

    public SolverVariable g(LinearSystem linearSystem) {
        boolean u;
        boolean u2;
        int c2 = this.e.c();
        SolverVariable solverVariable = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        SolverVariable solverVariable2 = null;
        for (int i = 0; i < c2; i++) {
            float m = this.e.m(i);
            SolverVariable e2 = this.e.e(i);
            if (e2.j == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null) {
                    u2 = u(e2, linearSystem);
                } else if (f2 > m) {
                    u2 = u(e2, linearSystem);
                } else if (!z && u(e2, linearSystem)) {
                    f2 = m;
                    solverVariable = e2;
                    z = true;
                }
                z = u2;
                f2 = m;
                solverVariable = e2;
            } else if (solverVariable == null && m < 0.0f) {
                if (solverVariable2 == null) {
                    u = u(e2, linearSystem);
                } else if (f3 > m) {
                    u = u(e2, linearSystem);
                } else if (!z2 && u(e2, linearSystem)) {
                    f3 = m;
                    solverVariable2 = e2;
                    z2 = true;
                }
                z2 = u;
                f3 = m;
                solverVariable2 = e2;
            }
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    public SolverVariable getKey() {
        return this.f477a;
    }

    public ArrayRow h(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2) {
        if (solverVariable2 == solverVariable3) {
            this.e.f(solverVariable, 1.0f);
            this.e.f(solverVariable4, 1.0f);
            this.e.f(solverVariable2, -2.0f);
            return this;
        }
        if (f2 == 0.5f) {
            this.e.f(solverVariable, 1.0f);
            this.e.f(solverVariable2, -1.0f);
            this.e.f(solverVariable3, -1.0f);
            this.e.f(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.b = (float) ((-i) + i2);
            }
        } else if (f2 <= 0.0f) {
            this.e.f(solverVariable, -1.0f);
            this.e.f(solverVariable2, 1.0f);
            this.b = (float) i;
        } else if (f2 >= 1.0f) {
            this.e.f(solverVariable4, -1.0f);
            this.e.f(solverVariable3, 1.0f);
            this.b = (float) (-i2);
        } else {
            float f3 = 1.0f - f2;
            this.e.f(solverVariable, f3 * 1.0f);
            this.e.f(solverVariable2, f3 * -1.0f);
            this.e.f(solverVariable3, -1.0f * f2);
            this.e.f(solverVariable4, 1.0f * f2);
            if (i > 0 || i2 > 0) {
                this.b = (((float) (-i)) * f3) + (((float) i2) * f2);
            }
        }
        return this;
    }

    public ArrayRow i(SolverVariable solverVariable, int i) {
        this.f477a = solverVariable;
        float f2 = (float) i;
        solverVariable.f = f2;
        this.b = f2;
        this.f = true;
        return this;
    }

    public boolean isEmpty() {
        return this.f477a == null && this.b == 0.0f && this.e.c() == 0;
    }

    public ArrayRow j(SolverVariable solverVariable, SolverVariable solverVariable2, float f2) {
        this.e.f(solverVariable, -1.0f);
        this.e.f(solverVariable2, f2);
        return this;
    }

    public ArrayRow k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        this.e.f(solverVariable, -1.0f);
        this.e.f(solverVariable2, 1.0f);
        this.e.f(solverVariable3, f2);
        this.e.f(solverVariable4, -f2);
        return this;
    }

    public ArrayRow l(float f2, float f3, float f4, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.b = 0.0f;
        if (f3 == 0.0f || f2 == f4) {
            this.e.f(solverVariable, 1.0f);
            this.e.f(solverVariable2, -1.0f);
            this.e.f(solverVariable4, 1.0f);
            this.e.f(solverVariable3, -1.0f);
        } else if (f2 == 0.0f) {
            this.e.f(solverVariable, 1.0f);
            this.e.f(solverVariable2, -1.0f);
        } else if (f4 == 0.0f) {
            this.e.f(solverVariable3, 1.0f);
            this.e.f(solverVariable4, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.e.f(solverVariable, 1.0f);
            this.e.f(solverVariable2, -1.0f);
            this.e.f(solverVariable4, f5);
            this.e.f(solverVariable3, -f5);
        }
        return this;
    }

    public ArrayRow m(SolverVariable solverVariable, int i) {
        if (i < 0) {
            this.b = (float) (i * -1);
            this.e.f(solverVariable, 1.0f);
        } else {
            this.b = (float) i;
            this.e.f(solverVariable, -1.0f);
        }
        return this;
    }

    public ArrayRow n(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = (float) i;
        }
        if (!z) {
            this.e.f(solverVariable, -1.0f);
            this.e.f(solverVariable2, 1.0f);
        } else {
            this.e.f(solverVariable, 1.0f);
            this.e.f(solverVariable2, -1.0f);
        }
        return this;
    }

    public ArrayRow o(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = (float) i;
        }
        if (!z) {
            this.e.f(solverVariable, -1.0f);
            this.e.f(solverVariable2, 1.0f);
            this.e.f(solverVariable3, 1.0f);
        } else {
            this.e.f(solverVariable, 1.0f);
            this.e.f(solverVariable2, -1.0f);
            this.e.f(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow p(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = (float) i;
        }
        if (!z) {
            this.e.f(solverVariable, -1.0f);
            this.e.f(solverVariable2, 1.0f);
            this.e.f(solverVariable3, -1.0f);
        } else {
            this.e.f(solverVariable, 1.0f);
            this.e.f(solverVariable2, -1.0f);
            this.e.f(solverVariable3, 1.0f);
        }
        return this;
    }

    public ArrayRow q(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        this.e.f(solverVariable3, 0.5f);
        this.e.f(solverVariable4, 0.5f);
        this.e.f(solverVariable, -0.5f);
        this.e.f(solverVariable2, -0.5f);
        this.b = -f2;
        return this;
    }

    public void r() {
        float f2 = this.b;
        if (f2 < 0.0f) {
            this.b = f2 * -1.0f;
            this.e.j();
        }
    }

    public boolean s() {
        SolverVariable solverVariable = this.f477a;
        return solverVariable != null && (solverVariable.j == SolverVariable.Type.UNRESTRICTED || this.b >= 0.0f);
    }

    public boolean t(SolverVariable solverVariable) {
        return this.e.d(solverVariable);
    }

    public String toString() {
        return z();
    }

    public final boolean u(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.m <= 1;
    }

    public SolverVariable v(SolverVariable solverVariable) {
        return w((boolean[]) null, solverVariable);
    }

    public final SolverVariable w(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int c2 = this.e.c();
        SolverVariable solverVariable2 = null;
        float f2 = 0.0f;
        for (int i = 0; i < c2; i++) {
            float m = this.e.m(i);
            if (m < 0.0f) {
                SolverVariable e2 = this.e.e(i);
                if ((zArr == null || !zArr[e2.c]) && e2 != solverVariable && (((type = e2.j) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && m < f2)) {
                    f2 = m;
                    solverVariable2 = e2;
                }
            }
        }
        return solverVariable2;
    }

    public void x(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f477a;
        if (solverVariable2 != null) {
            this.e.f(solverVariable2, -1.0f);
            this.f477a.d = -1;
            this.f477a = null;
        }
        float k = this.e.k(solverVariable, true) * -1.0f;
        this.f477a = solverVariable;
        if (k != 1.0f) {
            this.b /= k;
            this.e.h(k);
        }
    }

    public void y() {
        this.f477a = null;
        this.e.clear();
        this.b = 0.0f;
        this.f = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0069, code lost:
        r7 = r10.e.m(r3);
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String z() {
        /*
            r10 = this;
            androidx.constraintlayout.core.SolverVariable r0 = r10.f477a
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0018
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x0029
        L_0x0018:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            androidx.constraintlayout.core.SolverVariable r1 = r10.f477a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0029:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r10.b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0056
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = r4
            goto L_0x0057
        L_0x0056:
            r1 = r3
        L_0x0057:
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r5 = r10.e
            int r5 = r5.c()
        L_0x005d:
            if (r3 >= r5) goto L_0x00ec
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r6 = r10.e
            androidx.constraintlayout.core.SolverVariable r6 = r6.e(r3)
            if (r6 != 0) goto L_0x0069
            goto L_0x00e8
        L_0x0069:
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r7 = r10.e
            float r7 = r7.m(r3)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x0075
            goto L_0x00e8
        L_0x0075:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L_0x0094
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ba
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x0092:
            float r7 = r7 * r9
            goto L_0x00ba
        L_0x0094:
            if (r8 <= 0) goto L_0x00a8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00ba
        L_0x00a8:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x0092
        L_0x00ba:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00d0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            goto L_0x00e7
        L_0x00d0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L_0x00e7:
            r1 = r4
        L_0x00e8:
            int r3 = r3 + 1
            goto L_0x005d
        L_0x00ec:
            if (r1 != 0) goto L_0x00ff
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            java.lang.String r0 = "0.0"
            r10.append(r0)
            java.lang.String r0 = r10.toString()
        L_0x00ff:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.ArrayRow.z():java.lang.String");
    }

    public ArrayRow(Cache cache) {
        this.e = new ArrayLinkedVariables(this, cache);
    }
}
