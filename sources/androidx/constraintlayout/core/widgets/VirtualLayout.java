package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.HashSet;

public class VirtualLayout extends HelperWidget {
    public int X0 = 0;
    public int Y0 = 0;
    public int Z0 = 0;
    public int a1 = 0;
    public int b1 = 0;
    public int c1 = 0;
    public int d1 = 0;
    public int e1 = 0;
    public boolean f1 = false;
    public int g1 = 0;
    public int h1 = 0;
    public BasicMeasure.Measure i1 = new BasicMeasure.Measure();
    public BasicMeasure.Measurer j1 = null;

    public int A1() {
        return this.h1;
    }

    public int B1() {
        return this.g1;
    }

    public int C1() {
        return this.Y0;
    }

    public int D1() {
        return this.d1;
    }

    public int E1() {
        return this.e1;
    }

    public int F1() {
        return this.X0;
    }

    public void G1(int i, int i2, int i3, int i4) {
    }

    public void H1(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        while (this.j1 == null && M() != null) {
            this.j1 = ((ConstraintWidgetContainer) M()).N1();
        }
        BasicMeasure.Measure measure = this.i1;
        measure.f536a = dimensionBehaviour;
        measure.b = dimensionBehaviour2;
        measure.c = i;
        measure.d = i2;
        this.j1.b(constraintWidget, measure);
        constraintWidget.o1(this.i1.e);
        constraintWidget.P0(this.i1.f);
        constraintWidget.O0(this.i1.h);
        constraintWidget.E0(this.i1.g);
    }

    public boolean I1() {
        ConstraintWidget constraintWidget = this.c0;
        BasicMeasure.Measurer N1 = constraintWidget != null ? ((ConstraintWidgetContainer) constraintWidget).N1() : null;
        if (N1 == null) {
            return false;
        }
        for (int i = 0; i < this.W0; i++) {
            ConstraintWidget constraintWidget2 = this.V0[i];
            if (constraintWidget2 != null && !(constraintWidget2 instanceof Guideline)) {
                ConstraintWidget.DimensionBehaviour w = constraintWidget2.w(0);
                ConstraintWidget.DimensionBehaviour w2 = constraintWidget2.w(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (w != dimensionBehaviour || constraintWidget2.w == 1 || w2 != dimensionBehaviour || constraintWidget2.x == 1) {
                    if (w == dimensionBehaviour) {
                        w = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (w2 == dimensionBehaviour) {
                        w2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    BasicMeasure.Measure measure = this.i1;
                    measure.f536a = w;
                    measure.b = w2;
                    measure.c = constraintWidget2.Y();
                    this.i1.d = constraintWidget2.z();
                    N1.b(constraintWidget2, this.i1);
                    constraintWidget2.o1(this.i1.e);
                    constraintWidget2.P0(this.i1.f);
                    constraintWidget2.E0(this.i1.g);
                }
            }
        }
        return true;
    }

    public boolean J1() {
        return this.f1;
    }

    public void K1(boolean z) {
        this.f1 = z;
    }

    public void L1(int i, int i2) {
        this.g1 = i;
        this.h1 = i2;
    }

    public void M1(int i) {
        this.Z0 = i;
        this.X0 = i;
        this.a1 = i;
        this.Y0 = i;
        this.b1 = i;
        this.c1 = i;
    }

    public void N1(int i) {
        this.Y0 = i;
    }

    public void O1(int i) {
        this.c1 = i;
    }

    public void P1(int i) {
        this.Z0 = i;
        this.d1 = i;
    }

    public void Q1(int i) {
        this.a1 = i;
        this.e1 = i;
    }

    public void R1(int i) {
        this.b1 = i;
        this.d1 = i;
        this.e1 = i;
    }

    public void S1(int i) {
        this.X0 = i;
    }

    public void c(ConstraintWidgetContainer constraintWidgetContainer) {
        y1();
    }

    public void x1(boolean z) {
        int i = this.b1;
        if (i <= 0 && this.c1 <= 0) {
            return;
        }
        if (z) {
            this.d1 = this.c1;
            this.e1 = i;
            return;
        }
        this.d1 = i;
        this.e1 = this.c1;
    }

    public void y1() {
        for (int i = 0; i < this.W0; i++) {
            ConstraintWidget constraintWidget = this.V0[i];
            if (constraintWidget != null) {
                constraintWidget.Y0(true);
            }
        }
    }

    public boolean z1(HashSet hashSet) {
        for (int i = 0; i < this.W0; i++) {
            if (hashSet.contains(this.V0[i])) {
                return true;
            }
        }
        return false;
    }
}
