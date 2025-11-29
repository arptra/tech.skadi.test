package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import java.util.ArrayList;

public class WidgetContainer extends ConstraintWidget {
    public ArrayList V0 = new ArrayList();

    public void a(ConstraintWidget constraintWidget) {
        this.V0.add(constraintWidget);
        if (constraintWidget.M() != null) {
            ((WidgetContainer) constraintWidget.M()).x1(constraintWidget);
        }
        constraintWidget.g1(this);
    }

    public void v0() {
        this.V0.clear();
        super.v0();
    }

    public ArrayList v1() {
        return this.V0;
    }

    public void w1() {
        ArrayList arrayList = this.V0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) this.V0.get(i);
                if (constraintWidget instanceof WidgetContainer) {
                    ((WidgetContainer) constraintWidget).w1();
                }
            }
        }
    }

    public void x1(ConstraintWidget constraintWidget) {
        this.V0.remove(constraintWidget);
        constraintWidget.v0();
    }

    public void y1() {
        this.V0.clear();
    }

    public void z0(Cache cache) {
        super.z0(cache);
        int size = this.V0.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.V0.get(i)).z0(cache);
        }
    }
}
