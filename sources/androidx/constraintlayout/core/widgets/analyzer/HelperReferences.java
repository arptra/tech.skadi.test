package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

class HelperReferences extends WidgetRun {
    public HelperReferences(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void q(DependencyNode dependencyNode) {
        this.h.k.add(dependencyNode);
        dependencyNode.l.add(this.h);
    }

    public void a(Dependency dependency) {
        Barrier barrier = (Barrier) this.b;
        int z1 = barrier.z1();
        int i = 0;
        int i2 = -1;
        for (DependencyNode dependencyNode : this.h.l) {
            int i3 = dependencyNode.g;
            if (i2 == -1 || i3 < i2) {
                i2 = i3;
            }
            if (i < i3) {
                i = i3;
            }
        }
        if (z1 == 0 || z1 == 2) {
            this.h.d(i2 + barrier.A1());
        } else {
            this.h.d(i + barrier.A1());
        }
    }

    public void d() {
        ConstraintWidget constraintWidget = this.b;
        if (constraintWidget instanceof Barrier) {
            this.h.b = true;
            Barrier barrier = (Barrier) constraintWidget;
            int z1 = barrier.z1();
            boolean y1 = barrier.y1();
            int i = 0;
            if (z1 == 0) {
                this.h.e = DependencyNode.Type.LEFT;
                while (i < barrier.W0) {
                    ConstraintWidget constraintWidget2 = barrier.V0[i];
                    if (y1 || constraintWidget2.X() != 8) {
                        DependencyNode dependencyNode = constraintWidget2.e.h;
                        dependencyNode.k.add(this.h);
                        this.h.l.add(dependencyNode);
                    }
                    i++;
                }
                q(this.b.e.h);
                q(this.b.e.i);
            } else if (z1 == 1) {
                this.h.e = DependencyNode.Type.RIGHT;
                while (i < barrier.W0) {
                    ConstraintWidget constraintWidget3 = barrier.V0[i];
                    if (y1 || constraintWidget3.X() != 8) {
                        DependencyNode dependencyNode2 = constraintWidget3.e.i;
                        dependencyNode2.k.add(this.h);
                        this.h.l.add(dependencyNode2);
                    }
                    i++;
                }
                q(this.b.e.h);
                q(this.b.e.i);
            } else if (z1 == 2) {
                this.h.e = DependencyNode.Type.TOP;
                while (i < barrier.W0) {
                    ConstraintWidget constraintWidget4 = barrier.V0[i];
                    if (y1 || constraintWidget4.X() != 8) {
                        DependencyNode dependencyNode3 = constraintWidget4.f.h;
                        dependencyNode3.k.add(this.h);
                        this.h.l.add(dependencyNode3);
                    }
                    i++;
                }
                q(this.b.f.h);
                q(this.b.f.i);
            } else if (z1 == 3) {
                this.h.e = DependencyNode.Type.BOTTOM;
                while (i < barrier.W0) {
                    ConstraintWidget constraintWidget5 = barrier.V0[i];
                    if (y1 || constraintWidget5.X() != 8) {
                        DependencyNode dependencyNode4 = constraintWidget5.f.i;
                        dependencyNode4.k.add(this.h);
                        this.h.l.add(dependencyNode4);
                    }
                    i++;
                }
                q(this.b.f.h);
                q(this.b.f.i);
            }
        }
    }

    public void e() {
        ConstraintWidget constraintWidget = this.b;
        if (constraintWidget instanceof Barrier) {
            int z1 = ((Barrier) constraintWidget).z1();
            if (z1 == 0 || z1 == 1) {
                this.b.q1(this.h.g);
            } else {
                this.b.r1(this.h.g);
            }
        }
    }

    public void f() {
        this.c = null;
        this.h.c();
    }

    public boolean m() {
        return false;
    }
}
