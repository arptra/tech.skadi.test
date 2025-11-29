package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

class GuidelineReference extends WidgetRun {
    public GuidelineReference(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.e.f();
        constraintWidget.f.f();
        this.f = ((Guideline) constraintWidget).w1();
    }

    public void a(Dependency dependency) {
        DependencyNode dependencyNode = this.h;
        if (dependencyNode.c && !dependencyNode.j) {
            this.h.d((int) ((((float) ((DependencyNode) dependencyNode.l.get(0)).g) * ((Guideline) this.b).z1()) + 0.5f));
        }
    }

    public void d() {
        Guideline guideline = (Guideline) this.b;
        int x1 = guideline.x1();
        int y1 = guideline.y1();
        guideline.z1();
        if (guideline.w1() == 1) {
            if (x1 != -1) {
                this.h.l.add(this.b.c0.e.h);
                this.b.c0.e.h.k.add(this.h);
                this.h.f = x1;
            } else if (y1 != -1) {
                this.h.l.add(this.b.c0.e.i);
                this.b.c0.e.i.k.add(this.h);
                this.h.f = -y1;
            } else {
                DependencyNode dependencyNode = this.h;
                dependencyNode.b = true;
                dependencyNode.l.add(this.b.c0.e.i);
                this.b.c0.e.i.k.add(this.h);
            }
            q(this.b.e.h);
            q(this.b.e.i);
            return;
        }
        if (x1 != -1) {
            this.h.l.add(this.b.c0.f.h);
            this.b.c0.f.h.k.add(this.h);
            this.h.f = x1;
        } else if (y1 != -1) {
            this.h.l.add(this.b.c0.f.i);
            this.b.c0.f.i.k.add(this.h);
            this.h.f = -y1;
        } else {
            DependencyNode dependencyNode2 = this.h;
            dependencyNode2.b = true;
            dependencyNode2.l.add(this.b.c0.f.i);
            this.b.c0.f.i.k.add(this.h);
        }
        q(this.b.f.h);
        q(this.b.f.i);
    }

    public void e() {
        if (((Guideline) this.b).w1() == 1) {
            this.b.q1(this.h.g);
        } else {
            this.b.r1(this.h.g);
        }
    }

    public void f() {
        this.h.c();
    }

    public boolean m() {
        return false;
    }

    public final void q(DependencyNode dependencyNode) {
        this.h.k.add(dependencyNode);
        dependencyNode.l.add(this.h);
    }
}
