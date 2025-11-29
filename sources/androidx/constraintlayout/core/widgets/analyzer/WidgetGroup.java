package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Chain;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class WidgetGroup {
    public static int g;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f543a = new ArrayList();
    public int b;
    public boolean c = false;
    public int d;
    public ArrayList e = null;
    public int f = -1;

    public class MeasureResult {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference f544a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;

        public MeasureResult(ConstraintWidget constraintWidget, LinearSystem linearSystem, int i) {
            this.f544a = new WeakReference(constraintWidget);
            this.b = linearSystem.y(constraintWidget.Q);
            this.c = linearSystem.y(constraintWidget.R);
            this.d = linearSystem.y(constraintWidget.S);
            this.e = linearSystem.y(constraintWidget.T);
            this.f = linearSystem.y(constraintWidget.U);
            this.g = i;
        }
    }

    public WidgetGroup(int i) {
        int i2 = g;
        g = i2 + 1;
        this.b = i2;
        this.d = i;
    }

    public boolean a(ConstraintWidget constraintWidget) {
        if (this.f543a.contains(constraintWidget)) {
            return false;
        }
        this.f543a.add(constraintWidget);
        return true;
    }

    public void b(ArrayList arrayList) {
        int size = this.f543a.size();
        if (this.f != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                WidgetGroup widgetGroup = (WidgetGroup) arrayList.get(i);
                if (this.f == widgetGroup.b) {
                    g(this.d, widgetGroup);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public final String e() {
        int i = this.d;
        return i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown";
    }

    public int f(LinearSystem linearSystem, int i) {
        if (this.f543a.size() == 0) {
            return 0;
        }
        return j(linearSystem, this.f543a, i);
    }

    public void g(int i, WidgetGroup widgetGroup) {
        Iterator it = this.f543a.iterator();
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            widgetGroup.a(constraintWidget);
            if (i == 0) {
                constraintWidget.S0 = widgetGroup.c();
            } else {
                constraintWidget.T0 = widgetGroup.c();
            }
        }
        this.f = widgetGroup.b;
    }

    public void h(boolean z) {
        this.c = z;
    }

    public void i(int i) {
        this.d = i;
    }

    public final int j(LinearSystem linearSystem, ArrayList arrayList, int i) {
        int y;
        int y2;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) ((ConstraintWidget) arrayList.get(0)).M();
        linearSystem.E();
        constraintWidgetContainer.g(linearSystem, false);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((ConstraintWidget) arrayList.get(i2)).g(linearSystem, false);
        }
        if (i == 0 && constraintWidgetContainer.h1 > 0) {
            Chain.b(constraintWidgetContainer, linearSystem, arrayList, 0);
        }
        if (i == 1 && constraintWidgetContainer.i1 > 0) {
            Chain.b(constraintWidgetContainer, linearSystem, arrayList, 1);
        }
        try {
            linearSystem.A();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.e = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.e.add(new MeasureResult((ConstraintWidget) arrayList.get(i3), linearSystem, i));
        }
        if (i == 0) {
            y = linearSystem.y(constraintWidgetContainer.Q);
            y2 = linearSystem.y(constraintWidgetContainer.S);
            linearSystem.E();
        } else {
            y = linearSystem.y(constraintWidgetContainer.R);
            y2 = linearSystem.y(constraintWidgetContainer.T);
            linearSystem.E();
        }
        return y2 - y;
    }

    public String toString() {
        String str = e() + " [" + this.b + "] <";
        Iterator it = this.f543a.iterator();
        while (it.hasNext()) {
            str = str + " " + ((ConstraintWidget) it.next()).v();
        }
        return str + " >";
    }
}
