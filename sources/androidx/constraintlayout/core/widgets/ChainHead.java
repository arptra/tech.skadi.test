package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

public class ChainHead {

    /* renamed from: a  reason: collision with root package name */
    public ConstraintWidget f527a;
    public ConstraintWidget b;
    public ConstraintWidget c;
    public ConstraintWidget d;
    public ConstraintWidget e;
    public ConstraintWidget f;
    public ConstraintWidget g;
    public ArrayList h;
    public int i;
    public int j;
    public float k = 0.0f;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;

    public ChainHead(ConstraintWidget constraintWidget, int i2, boolean z) {
        this.f527a = constraintWidget;
        this.p = i2;
        this.q = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r2 = r2.y[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(androidx.constraintlayout.core.widgets.ConstraintWidget r2, int r3) {
        /*
            int r0 = r2.X()
            r1 = 8
            if (r0 == r1) goto L_0x001b
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r2.b0
            r0 = r0[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x001b
            int[] r2 = r2.y
            r2 = r2[r3]
            if (r2 == 0) goto L_0x0019
            r3 = 3
            if (r2 != r3) goto L_0x001b
        L_0x0019:
            r2 = 1
            goto L_0x001c
        L_0x001b:
            r2 = 0
        L_0x001c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ChainHead.c(androidx.constraintlayout.core.widgets.ConstraintWidget, int):boolean");
    }

    public void a() {
        if (!this.v) {
            b();
        }
        this.v = true;
    }

    public final void b() {
        int i2 = this.p * 2;
        ConstraintWidget constraintWidget = this.f527a;
        boolean z = true;
        this.o = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z2 = false;
        while (!z2) {
            this.i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.P0;
            int i3 = this.p;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i3] = null;
            constraintWidget.O0[i3] = null;
            if (constraintWidget.X() != 8) {
                this.l++;
                ConstraintWidget.DimensionBehaviour w = constraintWidget.w(this.p);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (w != dimensionBehaviour) {
                    this.m += constraintWidget.G(this.p);
                }
                int f2 = this.m + constraintWidget.Y[i2].f();
                this.m = f2;
                int i4 = i2 + 1;
                this.m = f2 + constraintWidget.Y[i4].f();
                int f3 = this.n + constraintWidget.Y[i2].f();
                this.n = f3;
                this.n = f3 + constraintWidget.Y[i4].f();
                if (this.b == null) {
                    this.b = constraintWidget;
                }
                this.d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.b0;
                int i5 = this.p;
                if (dimensionBehaviourArr[i5] == dimensionBehaviour) {
                    int i6 = constraintWidget.y[i5];
                    if (i6 == 0 || i6 == 3 || i6 == 2) {
                        this.j++;
                        float f4 = constraintWidget.N0[i5];
                        if (f4 > 0.0f) {
                            this.k += f4;
                        }
                        if (c(constraintWidget, i5)) {
                            if (f4 < 0.0f) {
                                this.r = true;
                            } else {
                                this.s = true;
                            }
                            if (this.h == null) {
                                this.h = new ArrayList();
                            }
                            this.h.add(constraintWidget);
                        }
                        if (this.f == null) {
                            this.f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.O0[this.p] = constraintWidget;
                        }
                        this.g = constraintWidget;
                    }
                    if (this.p == 0) {
                        if (constraintWidget.w != 0) {
                            this.o = false;
                        } else if (!(constraintWidget.z == 0 && constraintWidget.A == 0)) {
                            this.o = false;
                        }
                    } else if (constraintWidget.x != 0) {
                        this.o = false;
                    } else if (!(constraintWidget.C == 0 && constraintWidget.D == 0)) {
                        this.o = false;
                    }
                    if (constraintWidget.f0 != 0.0f) {
                        this.o = false;
                        this.u = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.P0[this.p] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.Y[i2 + 1].f;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.d;
                ConstraintAnchor constraintAnchor2 = constraintWidget5.Y[i2].f;
                if (constraintAnchor2 != null && constraintAnchor2.d == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z2 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        ConstraintWidget constraintWidget6 = this.b;
        if (constraintWidget6 != null) {
            this.m -= constraintWidget6.Y[i2].f();
        }
        ConstraintWidget constraintWidget7 = this.d;
        if (constraintWidget7 != null) {
            this.m -= constraintWidget7.Y[i2 + 1].f();
        }
        this.c = constraintWidget;
        if (this.p != 0 || !this.q) {
            this.e = this.f527a;
        } else {
            this.e = constraintWidget;
        }
        if (!this.s || !this.r) {
            z = false;
        }
        this.t = z;
    }
}
