package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

public class VerticalWidgetRun extends WidgetRun {
    public DependencyNode k;
    public DimensionDependency l = null;

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f542a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType[] r0 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f542a = r0
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f542a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f542a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun.AnonymousClass1.<clinit>():void");
        }
    }

    public VerticalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.k = dependencyNode;
        this.h.e = DependencyNode.Type.TOP;
        this.i.e = DependencyNode.Type.BOTTOM;
        dependencyNode.e = DependencyNode.Type.BASELINE;
        this.f = 1;
    }

    public void a(Dependency dependency) {
        int i;
        float f;
        float x;
        float f2;
        int i2 = AnonymousClass1.f542a[this.j.ordinal()];
        if (i2 == 1) {
            p(dependency);
        } else if (i2 == 2) {
            o(dependency);
        } else if (i2 == 3) {
            ConstraintWidget constraintWidget = this.b;
            n(dependency, constraintWidget.R, constraintWidget.T, 1);
            return;
        }
        DimensionDependency dimensionDependency = this.e;
        if (dimensionDependency.c && !dimensionDependency.j && this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.b;
            int i3 = constraintWidget2.x;
            if (i3 == 2) {
                ConstraintWidget M = constraintWidget2.M();
                if (M != null) {
                    DimensionDependency dimensionDependency2 = M.f.e;
                    if (dimensionDependency2.j) {
                        this.e.d((int) ((((float) dimensionDependency2.g) * this.b.E) + 0.5f));
                    }
                }
            } else if (i3 == 3 && constraintWidget2.e.e.j) {
                int y = constraintWidget2.y();
                if (y == -1) {
                    ConstraintWidget constraintWidget3 = this.b;
                    f = (float) constraintWidget3.e.e.g;
                    x = constraintWidget3.x();
                } else if (y == 0) {
                    ConstraintWidget constraintWidget4 = this.b;
                    f2 = ((float) constraintWidget4.e.e.g) * constraintWidget4.x();
                    i = (int) (f2 + 0.5f);
                    this.e.d(i);
                } else if (y != 1) {
                    i = 0;
                    this.e.d(i);
                } else {
                    ConstraintWidget constraintWidget5 = this.b;
                    f = (float) constraintWidget5.e.e.g;
                    x = constraintWidget5.x();
                }
                f2 = f / x;
                i = (int) (f2 + 0.5f);
                this.e.d(i);
            }
        }
        DependencyNode dependencyNode = this.h;
        if (dependencyNode.c) {
            DependencyNode dependencyNode2 = this.i;
            if (dependencyNode2.c) {
                if (!dependencyNode.j || !dependencyNode2.j || !this.e.j) {
                    if (!this.e.j && this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        ConstraintWidget constraintWidget6 = this.b;
                        if (constraintWidget6.w == 0 && !constraintWidget6.m0()) {
                            int i4 = ((DependencyNode) this.h.l.get(0)).g;
                            DependencyNode dependencyNode3 = this.h;
                            int i5 = i4 + dependencyNode3.f;
                            int i6 = ((DependencyNode) this.i.l.get(0)).g + this.i.f;
                            dependencyNode3.d(i5);
                            this.i.d(i6);
                            this.e.d(i6 - i5);
                            return;
                        }
                    }
                    if (!this.e.j && this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.f545a == 1 && this.h.l.size() > 0 && this.i.l.size() > 0) {
                        int i7 = (((DependencyNode) this.i.l.get(0)).g + this.i.f) - (((DependencyNode) this.h.l.get(0)).g + this.h.f);
                        DimensionDependency dimensionDependency3 = this.e;
                        int i8 = dimensionDependency3.m;
                        if (i7 < i8) {
                            dimensionDependency3.d(i7);
                        } else {
                            dimensionDependency3.d(i8);
                        }
                    }
                    if (this.e.j && this.h.l.size() > 0 && this.i.l.size() > 0) {
                        DependencyNode dependencyNode4 = (DependencyNode) this.h.l.get(0);
                        DependencyNode dependencyNode5 = (DependencyNode) this.i.l.get(0);
                        int i9 = dependencyNode4.g + this.h.f;
                        int i10 = dependencyNode5.g + this.i.f;
                        float T = this.b.T();
                        if (dependencyNode4 == dependencyNode5) {
                            i9 = dependencyNode4.g;
                            i10 = dependencyNode5.g;
                            T = 0.5f;
                        }
                        this.h.d((int) (((float) i9) + 0.5f + (((float) ((i10 - i9) - this.e.g)) * T)));
                        this.i.d(this.h.g + this.e.g);
                    }
                }
            }
        }
    }

    public void d() {
        ConstraintWidget M;
        ConstraintWidget M2;
        ConstraintWidget constraintWidget = this.b;
        if (constraintWidget.f530a) {
            this.e.d(constraintWidget.z());
        }
        if (!this.e.j) {
            this.d = this.b.V();
            if (this.b.b0()) {
                this.l = new BaselineDimensionDependency(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.d;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (M2 = this.b.M()) != null && M2.V() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int z = (M2.z() - this.b.R.f()) - this.b.T.f();
                    b(this.h, M2.f.h, this.b.R.f());
                    b(this.i, M2.f.i, -this.b.T.f());
                    this.e.d(z);
                    return;
                } else if (this.d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.e.d(this.b.z());
                }
            }
        } else if (this.d == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (M = this.b.M()) != null && M.V() == ConstraintWidget.DimensionBehaviour.FIXED) {
            b(this.h, M.f.h, this.b.R.f());
            b(this.i, M.f.i, -this.b.T.f());
            return;
        }
        DimensionDependency dimensionDependency = this.e;
        boolean z2 = dimensionDependency.j;
        if (z2) {
            ConstraintWidget constraintWidget2 = this.b;
            if (constraintWidget2.f530a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.Y;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f;
                if (constraintAnchor2 != null && constraintAnchorArr[3].f != null) {
                    if (constraintWidget2.m0()) {
                        this.h.f = this.b.Y[2].f();
                        this.i.f = -this.b.Y[3].f();
                    } else {
                        DependencyNode h = h(this.b.Y[2]);
                        if (h != null) {
                            b(this.h, h, this.b.Y[2].f());
                        }
                        DependencyNode h2 = h(this.b.Y[3]);
                        if (h2 != null) {
                            b(this.i, h2, -this.b.Y[3].f());
                        }
                        this.h.b = true;
                        this.i.b = true;
                    }
                    if (this.b.b0()) {
                        b(this.k, this.h, this.b.r());
                        return;
                    }
                    return;
                } else if (constraintAnchor2 != null) {
                    DependencyNode h3 = h(constraintAnchor);
                    if (h3 != null) {
                        b(this.h, h3, this.b.Y[2].f());
                        b(this.i, this.h, this.e.g);
                        if (this.b.b0()) {
                            b(this.k, this.h, this.b.r());
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                    if (constraintAnchor3.f != null) {
                        DependencyNode h4 = h(constraintAnchor3);
                        if (h4 != null) {
                            b(this.i, h4, -this.b.Y[3].f());
                            b(this.h, this.i, -this.e.g);
                        }
                        if (this.b.b0()) {
                            b(this.k, this.h, this.b.r());
                            return;
                        }
                        return;
                    }
                    ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                    if (constraintAnchor4.f != null) {
                        DependencyNode h5 = h(constraintAnchor4);
                        if (h5 != null) {
                            b(this.k, h5, 0);
                            b(this.h, this.k, -this.b.r());
                            b(this.i, this.h, this.e.g);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget2 instanceof Helper) && constraintWidget2.M() != null && this.b.q(ConstraintAnchor.Type.CENTER).f == null) {
                        b(this.h, this.b.M().f.h, this.b.a0());
                        b(this.i, this.h, this.e.g);
                        if (this.b.b0()) {
                            b(this.k, this.h, this.b.r());
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
        if (z2 || this.d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            dimensionDependency.b(this);
        } else {
            ConstraintWidget constraintWidget3 = this.b;
            int i = constraintWidget3.x;
            if (i == 2) {
                ConstraintWidget M3 = constraintWidget3.M();
                if (M3 != null) {
                    DimensionDependency dimensionDependency2 = M3.f.e;
                    this.e.l.add(dimensionDependency2);
                    dimensionDependency2.k.add(this.e);
                    DimensionDependency dimensionDependency3 = this.e;
                    dimensionDependency3.b = true;
                    dimensionDependency3.k.add(this.h);
                    this.e.k.add(this.i);
                }
            } else if (i == 3 && !constraintWidget3.m0()) {
                ConstraintWidget constraintWidget4 = this.b;
                if (constraintWidget4.w != 3) {
                    DimensionDependency dimensionDependency4 = constraintWidget4.e.e;
                    this.e.l.add(dimensionDependency4);
                    dimensionDependency4.k.add(this.e);
                    DimensionDependency dimensionDependency5 = this.e;
                    dimensionDependency5.b = true;
                    dimensionDependency5.k.add(this.h);
                    this.e.k.add(this.i);
                }
            }
        }
        ConstraintWidget constraintWidget5 = this.b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.Y;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.f;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].f != null) {
            if (constraintWidget5.m0()) {
                this.h.f = this.b.Y[2].f();
                this.i.f = -this.b.Y[3].f();
            } else {
                DependencyNode h6 = h(this.b.Y[2]);
                DependencyNode h7 = h(this.b.Y[3]);
                if (h6 != null) {
                    h6.b(this);
                }
                if (h7 != null) {
                    h7.b(this);
                }
                this.j = WidgetRun.RunType.CENTER;
            }
            if (this.b.b0()) {
                c(this.k, this.h, 1, this.l);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode h8 = h(constraintAnchor5);
            if (h8 != null) {
                b(this.h, h8, this.b.Y[2].f());
                c(this.i, this.h, 1, this.e);
                if (this.b.b0()) {
                    c(this.k, this.h, 1, this.l);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.d;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3 && this.b.x() > 0.0f) {
                    HorizontalWidgetRun horizontalWidgetRun = this.b.e;
                    if (horizontalWidgetRun.d == dimensionBehaviour3) {
                        horizontalWidgetRun.e.k.add(this.e);
                        this.e.l.add(this.b.e.e);
                        this.e.f538a = this;
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.f != null) {
                DependencyNode h9 = h(constraintAnchor7);
                if (h9 != null) {
                    b(this.i, h9, -this.b.Y[3].f());
                    c(this.h, this.i, -1, this.e);
                    if (this.b.b0()) {
                        c(this.k, this.h, 1, this.l);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.f != null) {
                    DependencyNode h10 = h(constraintAnchor8);
                    if (h10 != null) {
                        b(this.k, h10, 0);
                        c(this.h, this.k, -1, this.l);
                        c(this.i, this.h, 1, this.e);
                    }
                } else if (!(constraintWidget5 instanceof Helper) && constraintWidget5.M() != null) {
                    b(this.h, this.b.M().f.h, this.b.a0());
                    c(this.i, this.h, 1, this.e);
                    if (this.b.b0()) {
                        c(this.k, this.h, 1, this.l);
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.d;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour5 && this.b.x() > 0.0f) {
                        HorizontalWidgetRun horizontalWidgetRun2 = this.b.e;
                        if (horizontalWidgetRun2.d == dimensionBehaviour5) {
                            horizontalWidgetRun2.e.k.add(this.e);
                            this.e.l.add(this.b.e.e);
                            this.e.f538a = this;
                        }
                    }
                }
            }
        }
        if (this.e.l.size() == 0) {
            this.e.c = true;
        }
    }

    public void e() {
        DependencyNode dependencyNode = this.h;
        if (dependencyNode.j) {
            this.b.r1(dependencyNode.g);
        }
    }

    public void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.k.c();
        this.e.c();
        this.g = false;
    }

    public boolean m() {
        return this.d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.b.x == 0;
    }

    public void q() {
        this.g = false;
        this.h.c();
        this.h.j = false;
        this.i.c();
        this.i.j = false;
        this.k.c();
        this.k.j = false;
        this.e.j = false;
    }

    public String toString() {
        return "VerticalRun " + this.b.v();
    }
}
