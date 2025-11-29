package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;

public class PriorityGoalRow extends ArrayRow {
    public int g = 128;
    public SolverVariable[] h = new SolverVariable[128];
    public SolverVariable[] i = new SolverVariable[128];
    public int j = 0;
    public GoalVariableAccessor k = new GoalVariableAccessor(this);
    public Cache l;

    public class GoalVariableAccessor {

        /* renamed from: a  reason: collision with root package name */
        public SolverVariable f483a;
        public PriorityGoalRow b;

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.b = priorityGoalRow;
        }

        public boolean a(SolverVariable solverVariable, float f) {
            boolean z = true;
            if (this.f483a.f484a) {
                for (int i = 0; i < 9; i++) {
                    float[] fArr = this.f483a.i;
                    float f2 = fArr[i] + (solverVariable.i[i] * f);
                    fArr[i] = f2;
                    if (Math.abs(f2) < 1.0E-4f) {
                        this.f483a.i[i] = 0.0f;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    PriorityGoalRow.this.G(this.f483a);
                }
                return false;
            }
            for (int i2 = 0; i2 < 9; i2++) {
                float f3 = solverVariable.i[i2];
                if (f3 != 0.0f) {
                    float f4 = f3 * f;
                    if (Math.abs(f4) < 1.0E-4f) {
                        f4 = 0.0f;
                    }
                    this.f483a.i[i2] = f4;
                } else {
                    this.f483a.i[i2] = 0.0f;
                }
            }
            return true;
        }

        public void b(SolverVariable solverVariable) {
            this.f483a = solverVariable;
        }

        public final boolean c() {
            for (int i = 8; i >= 0; i--) {
                float f = this.f483a.i[i];
                if (f > 0.0f) {
                    return false;
                }
                if (f < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(SolverVariable solverVariable) {
            int i = 8;
            while (true) {
                if (i < 0) {
                    break;
                }
                float f = solverVariable.i[i];
                float f2 = this.f483a.i[i];
                if (f2 == f) {
                    i--;
                } else if (f2 < f) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f483a.i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f483a != null) {
                for (int i = 0; i < 9; i++) {
                    str = str + this.f483a.i[i] + " ";
                }
            }
            return str + "] " + this.f483a;
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.l = cache;
    }

    public void B(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        SolverVariable solverVariable = arrayRow.f477a;
        if (solverVariable != null) {
            ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.e;
            int c = arrayRowVariables.c();
            for (int i2 = 0; i2 < c; i2++) {
                SolverVariable e = arrayRowVariables.e(i2);
                float m = arrayRowVariables.m(i2);
                this.k.b(e);
                if (this.k.a(solverVariable, m)) {
                    F(e);
                }
                this.b += arrayRow.b * m;
            }
            G(solverVariable);
        }
    }

    public final void F(SolverVariable solverVariable) {
        int i2;
        int i3 = this.j + 1;
        SolverVariable[] solverVariableArr = this.h;
        if (i3 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.h = solverVariableArr2;
            this.i = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.h;
        int i4 = this.j;
        solverVariableArr3[i4] = solverVariable;
        int i5 = i4 + 1;
        this.j = i5;
        if (i5 > 1 && solverVariableArr3[i4].c > solverVariable.c) {
            int i6 = 0;
            while (true) {
                i2 = this.j;
                if (i6 >= i2) {
                    break;
                }
                this.i[i6] = this.h[i6];
                i6++;
            }
            Arrays.sort(this.i, 0, i2, new Comparator<SolverVariable>() {
                /* renamed from: a */
                public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
                    return solverVariable.c - solverVariable2.c;
                }
            });
            for (int i7 = 0; i7 < this.j; i7++) {
                this.h[i7] = this.i[i7];
            }
        }
        solverVariable.f484a = true;
        solverVariable.a(this);
    }

    public final void G(SolverVariable solverVariable) {
        int i2 = 0;
        while (i2 < this.j) {
            if (this.h[i2] == solverVariable) {
                while (true) {
                    int i3 = this.j;
                    if (i2 < i3 - 1) {
                        SolverVariable[] solverVariableArr = this.h;
                        int i4 = i2 + 1;
                        solverVariableArr[i2] = solverVariableArr[i4];
                        i2 = i4;
                    } else {
                        this.j = i3 - 1;
                        solverVariable.f484a = false;
                        return;
                    }
                }
            } else {
                i2++;
            }
        }
    }

    public SolverVariable a(LinearSystem linearSystem, boolean[] zArr) {
        int i2 = -1;
        for (int i3 = 0; i3 < this.j; i3++) {
            SolverVariable solverVariable = this.h[i3];
            if (!zArr[solverVariable.c]) {
                this.k.b(solverVariable);
                if (i2 == -1) {
                    if (!this.k.c()) {
                    }
                } else if (!this.k.d(this.h[i2])) {
                }
                i2 = i3;
            }
        }
        if (i2 == -1) {
            return null;
        }
        return this.h[i2];
    }

    public void c(SolverVariable solverVariable) {
        this.k.b(solverVariable);
        this.k.e();
        solverVariable.i[solverVariable.e] = 1.0f;
        F(solverVariable);
    }

    public void clear() {
        this.j = 0;
        this.b = 0.0f;
    }

    public boolean isEmpty() {
        return this.j == 0;
    }

    public String toString() {
        String str = "" + " goal -> (" + this.b + ") : ";
        for (int i2 = 0; i2 < this.j; i2++) {
            this.k.b(this.h[i2]);
            str = str + this.k + " ";
        }
        return str;
    }
}
