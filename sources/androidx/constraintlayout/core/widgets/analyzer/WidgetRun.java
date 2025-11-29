package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

public abstract class WidgetRun implements Dependency {

    /* renamed from: a  reason: collision with root package name */
    public int f545a;
    public ConstraintWidget b;
    public RunGroup c;
    public ConstraintWidget.DimensionBehaviour d;
    public DimensionDependency e = new DimensionDependency(this);
    public int f = 0;
    public boolean g = false;
    public DependencyNode h = new DependencyNode(this);
    public DependencyNode i = new DependencyNode(this);
    public RunType j = RunType.NONE;

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.WidgetRun$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f546a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f546a = r0
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f546a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f546a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f546a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f546a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.WidgetRun.AnonymousClass1.<clinit>():void");
        }
    }

    public enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.b = constraintWidget;
    }

    public void a(Dependency dependency) {
    }

    public final void b(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i2) {
        dependencyNode.l.add(dependencyNode2);
        dependencyNode.f = i2;
        dependencyNode2.k.add(dependencyNode);
    }

    public final void c(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i2, DimensionDependency dimensionDependency) {
        dependencyNode.l.add(dependencyNode2);
        dependencyNode.l.add(this.e);
        dependencyNode.h = i2;
        dependencyNode.i = dimensionDependency;
        dependencyNode2.k.add(dependencyNode);
        dimensionDependency.k.add(dependencyNode);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i2, int i3) {
        int i4;
        if (i3 == 0) {
            ConstraintWidget constraintWidget = this.b;
            int i5 = constraintWidget.A;
            i4 = Math.max(constraintWidget.z, i2);
            if (i5 > 0) {
                i4 = Math.min(i5, i2);
            }
            if (i4 == i2) {
                return i2;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.b;
            int i6 = constraintWidget2.D;
            int max = Math.max(constraintWidget2.C, i2);
            if (i6 > 0) {
                max = Math.min(i6, i2);
            }
            if (i4 == i2) {
                return i2;
            }
        }
        return i4;
    }

    public final DependencyNode h(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.d;
        int i2 = AnonymousClass1.f546a[constraintAnchor2.e.ordinal()];
        if (i2 == 1) {
            return constraintWidget.e.h;
        }
        if (i2 == 2) {
            return constraintWidget.e.i;
        }
        if (i2 == 3) {
            return constraintWidget.f.h;
        }
        if (i2 == 4) {
            return constraintWidget.f.k;
        }
        if (i2 != 5) {
            return null;
        }
        return constraintWidget.f.i;
    }

    public final DependencyNode i(ConstraintAnchor constraintAnchor, int i2) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.d;
        WidgetRun widgetRun = i2 == 0 ? constraintWidget.e : constraintWidget.f;
        int i3 = AnonymousClass1.f546a[constraintAnchor2.e.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.i;
        }
        return widgetRun.h;
    }

    public long j() {
        DimensionDependency dimensionDependency = this.e;
        if (dimensionDependency.j) {
            return (long) dimensionDependency.g;
        }
        return 0;
    }

    public boolean k() {
        return this.g;
    }

    public final void l(int i2, int i3) {
        int i4 = this.f545a;
        if (i4 == 0) {
            this.e.d(g(i3, i2));
        } else if (i4 == 1) {
            this.e.d(Math.min(g(this.e.m, i2), i3));
        } else if (i4 == 2) {
            ConstraintWidget M = this.b.M();
            if (M != null) {
                DimensionDependency dimensionDependency = (i2 == 0 ? M.e : M.f).e;
                if (dimensionDependency.j) {
                    ConstraintWidget constraintWidget = this.b;
                    this.e.d(g((int) ((((float) dimensionDependency.g) * (i2 == 0 ? constraintWidget.B : constraintWidget.E)) + 0.5f), i2));
                }
            }
        } else if (i4 == 3) {
            ConstraintWidget constraintWidget2 = this.b;
            WidgetRun widgetRun = constraintWidget2.e;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun.d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && widgetRun.f545a == 3) {
                VerticalWidgetRun verticalWidgetRun = constraintWidget2.f;
                if (verticalWidgetRun.d == dimensionBehaviour2 && verticalWidgetRun.f545a == 3) {
                    return;
                }
            }
            if (i2 == 0) {
                widgetRun = constraintWidget2.f;
            }
            if (widgetRun.e.j) {
                float x = constraintWidget2.x();
                this.e.d(i2 == 1 ? (int) ((((float) widgetRun.e.g) / x) + 0.5f) : (int) ((x * ((float) widgetRun.e.g)) + 0.5f));
            }
        }
    }

    public abstract boolean m();

    public void n(Dependency dependency, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2) {
        DependencyNode h2 = h(constraintAnchor);
        DependencyNode h3 = h(constraintAnchor2);
        if (h2.j && h3.j) {
            int f2 = h2.g + constraintAnchor.f();
            int f3 = h3.g - constraintAnchor2.f();
            int i3 = f3 - f2;
            if (!this.e.j && this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                l(i2, i3);
            }
            DimensionDependency dimensionDependency = this.e;
            if (dimensionDependency.j) {
                if (dimensionDependency.g == i3) {
                    this.h.d(f2);
                    this.i.d(f3);
                    return;
                }
                ConstraintWidget constraintWidget = this.b;
                float A = i2 == 0 ? constraintWidget.A() : constraintWidget.T();
                if (h2 == h3) {
                    f2 = h2.g;
                    f3 = h3.g;
                    A = 0.5f;
                }
                this.h.d((int) (((float) f2) + 0.5f + (((float) ((f3 - f2) - this.e.g)) * A)));
                this.i.d(this.h.g + this.e.g);
            }
        }
    }

    public void o(Dependency dependency) {
    }

    public void p(Dependency dependency) {
    }
}
