package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;

public class Placeholder extends VirtualLayout {
    public void G1(int i, int i2, int i3, int i4) {
        int D1 = D1() + E1();
        int F1 = F1() + C1();
        boolean z = false;
        if (this.W0 > 0) {
            D1 += this.V0[0].Y();
            F1 += this.V0[0].z();
        }
        int max = Math.max(K(), D1);
        int max2 = Math.max(J(), F1);
        if (i != 1073741824) {
            i2 = i == Integer.MIN_VALUE ? Math.min(max, i2) : i == 0 ? max : 0;
        }
        if (i3 != 1073741824) {
            i4 = i3 == Integer.MIN_VALUE ? Math.min(max2, i4) : i3 == 0 ? max2 : 0;
        }
        L1(i2, i4);
        o1(i2);
        P0(i4);
        if (this.W0 > 0) {
            z = true;
        }
        K1(z);
    }

    public void g(LinearSystem linearSystem, boolean z) {
        super.g(linearSystem, z);
        if (this.W0 > 0) {
            ConstraintWidget constraintWidget = this.V0[0];
            constraintWidget.w0();
            ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
            constraintWidget.j(type, this, type);
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
            constraintWidget.j(type2, this, type2);
            ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
            constraintWidget.j(type3, this, type3);
            ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
            constraintWidget.j(type4, this, type4);
        }
    }
}
