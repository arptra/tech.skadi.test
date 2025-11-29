package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

public class Guideline extends ConstraintWidget {
    public float V0 = -1.0f;
    public int W0 = -1;
    public int X0 = -1;
    public boolean Y0 = true;
    public ConstraintAnchor Z0 = this.R;
    public int a1;
    public int b1;
    public boolean c1;

    /* renamed from: androidx.constraintlayout.core.widgets.Guideline$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f533a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f533a = r0
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f533a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f533a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f533a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f533a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f533a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f533a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f533a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f533a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Guideline.AnonymousClass1.<clinit>():void");
        }
    }

    public Guideline() {
        this.a1 = 0;
        this.b1 = 0;
        this.Z.clear();
        this.Z.add(this.Z0);
        int length = this.Y.length;
        for (int i = 0; i < length; i++) {
            this.Y[i] = this.Z0;
        }
    }

    public void A1(int i) {
        this.Z0.t(i);
        this.c1 = true;
    }

    public void B1(int i) {
        if (i > -1) {
            this.V0 = -1.0f;
            this.W0 = i;
            this.X0 = -1;
        }
    }

    public void C1(int i) {
        if (i > -1) {
            this.V0 = -1.0f;
            this.W0 = -1;
            this.X0 = i;
        }
    }

    public void D1(float f) {
        if (f > -1.0f) {
            this.V0 = f;
            this.W0 = -1;
            this.X0 = -1;
        }
    }

    public void E1(int i) {
        if (this.a1 != i) {
            this.a1 = i;
            this.Z.clear();
            if (this.a1 == 1) {
                this.Z0 = this.Q;
            } else {
                this.Z0 = this.R;
            }
            this.Z.add(this.Z0);
            int length = this.Y.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.Y[i2] = this.Z0;
            }
        }
    }

    public void g(LinearSystem linearSystem, boolean z) {
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) M();
        if (constraintWidgetContainer != null) {
            ConstraintAnchor q = constraintWidgetContainer.q(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor q2 = constraintWidgetContainer.q(ConstraintAnchor.Type.RIGHT);
            ConstraintWidget constraintWidget = this.c0;
            boolean z2 = true;
            boolean z3 = constraintWidget != null && constraintWidget.b0[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (this.a1 == 0) {
                q = constraintWidgetContainer.q(ConstraintAnchor.Type.TOP);
                q2 = constraintWidgetContainer.q(ConstraintAnchor.Type.BOTTOM);
                ConstraintWidget constraintWidget2 = this.c0;
                if (constraintWidget2 == null || constraintWidget2.b0[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    z2 = false;
                }
                z3 = z2;
            }
            if (this.c1 && this.Z0.n()) {
                SolverVariable q3 = linearSystem.q(this.Z0);
                linearSystem.f(q3, this.Z0.e());
                if (this.W0 != -1) {
                    if (z3) {
                        linearSystem.h(linearSystem.q(q2), q3, 0, 5);
                    }
                } else if (this.X0 != -1 && z3) {
                    SolverVariable q4 = linearSystem.q(q2);
                    linearSystem.h(q3, linearSystem.q(q), 0, 5);
                    linearSystem.h(q4, q3, 0, 5);
                }
                this.c1 = false;
            } else if (this.W0 != -1) {
                SolverVariable q5 = linearSystem.q(this.Z0);
                linearSystem.e(q5, linearSystem.q(q), this.W0, 8);
                if (z3) {
                    linearSystem.h(linearSystem.q(q2), q5, 0, 5);
                }
            } else if (this.X0 != -1) {
                SolverVariable q6 = linearSystem.q(this.Z0);
                SolverVariable q7 = linearSystem.q(q2);
                linearSystem.e(q6, q7, -this.X0, 8);
                if (z3) {
                    linearSystem.h(q6, linearSystem.q(q), 0, 5);
                    linearSystem.h(q7, q6, 0, 5);
                }
            } else if (this.V0 != -1.0f) {
                linearSystem.d(LinearSystem.s(linearSystem, linearSystem.q(this.Z0), linearSystem.q(q2), this.V0));
            }
        }
    }

    public boolean h() {
        return true;
    }

    public void n(ConstraintWidget constraintWidget, HashMap hashMap) {
        super.n(constraintWidget, hashMap);
        Guideline guideline = (Guideline) constraintWidget;
        this.V0 = guideline.V0;
        this.W0 = guideline.W0;
        this.X0 = guideline.X0;
        this.Y0 = guideline.Y0;
        E1(guideline.a1);
    }

    public boolean p0() {
        return this.c1;
    }

    public ConstraintAnchor q(ConstraintAnchor.Type type) {
        int i = AnonymousClass1.f533a[type.ordinal()];
        if (i == 1 || i == 2) {
            if (this.a1 == 1) {
                return this.Z0;
            }
            return null;
        } else if ((i == 3 || i == 4) && this.a1 == 0) {
            return this.Z0;
        } else {
            return null;
        }
    }

    public boolean q0() {
        return this.c1;
    }

    public void u1(LinearSystem linearSystem, boolean z) {
        if (M() != null) {
            int y = linearSystem.y(this.Z0);
            if (this.a1 == 1) {
                q1(y);
                r1(0);
                P0(M().z());
                o1(0);
                return;
            }
            q1(0);
            r1(y);
            o1(M().Y());
            P0(0);
        }
    }

    public ConstraintAnchor v1() {
        return this.Z0;
    }

    public int w1() {
        return this.a1;
    }

    public int x1() {
        return this.W0;
    }

    public int y1() {
        return this.X0;
    }

    public float z1() {
        return this.V0;
    }
}
