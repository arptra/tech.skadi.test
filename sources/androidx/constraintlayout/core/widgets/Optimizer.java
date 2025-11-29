package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

public class Optimizer {

    /* renamed from: a  reason: collision with root package name */
    public static boolean[] f534a = new boolean[3];

    public static void a(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        constraintWidget.t = -1;
        constraintWidget.u = -1;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidgetContainer.b0[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != dimensionBehaviour2 && constraintWidget.b0[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i = constraintWidget.Q.g;
            int Y = constraintWidgetContainer.Y() - constraintWidget.S.g;
            ConstraintAnchor constraintAnchor = constraintWidget.Q;
            constraintAnchor.i = linearSystem.q(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.S;
            constraintAnchor2.i = linearSystem.q(constraintAnchor2);
            linearSystem.f(constraintWidget.Q.i, i);
            linearSystem.f(constraintWidget.S.i, Y);
            constraintWidget.t = 2;
            constraintWidget.S0(i, Y);
        }
        if (constraintWidgetContainer.b0[1] != dimensionBehaviour2 && constraintWidget.b0[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i2 = constraintWidget.R.g;
            int z = constraintWidgetContainer.z() - constraintWidget.T.g;
            ConstraintAnchor constraintAnchor3 = constraintWidget.R;
            constraintAnchor3.i = linearSystem.q(constraintAnchor3);
            ConstraintAnchor constraintAnchor4 = constraintWidget.T;
            constraintAnchor4.i = linearSystem.q(constraintAnchor4);
            linearSystem.f(constraintWidget.R.i, i2);
            linearSystem.f(constraintWidget.T.i, z);
            if (constraintWidget.n0 > 0 || constraintWidget.X() == 8) {
                ConstraintAnchor constraintAnchor5 = constraintWidget.U;
                constraintAnchor5.i = linearSystem.q(constraintAnchor5);
                linearSystem.f(constraintWidget.U.i, constraintWidget.n0 + i2);
            }
            constraintWidget.u = 2;
            constraintWidget.j1(i2, z);
        }
    }

    public static final boolean b(int i, int i2) {
        return (i & i2) == i2;
    }
}
