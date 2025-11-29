package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

class RunGroup {
    public static int h;

    /* renamed from: a  reason: collision with root package name */
    public int f541a = 0;
    public boolean b = false;
    public WidgetRun c = null;
    public WidgetRun d = null;
    public ArrayList e = new ArrayList();
    public int f;
    public int g;

    public RunGroup(WidgetRun widgetRun, int i) {
        int i2 = h;
        this.f = i2;
        h = i2 + 1;
        this.c = widgetRun;
        this.d = widgetRun;
        this.g = i;
    }

    public void a(WidgetRun widgetRun) {
        this.e.add(widgetRun);
        this.d = widgetRun;
    }

    public long b(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        WidgetRun widgetRun = this.c;
        long j = 0;
        if (widgetRun instanceof ChainRun) {
            if (((ChainRun) widgetRun).f != i) {
                return 0;
            }
        } else if (i == 0) {
            if (!(widgetRun instanceof HorizontalWidgetRun)) {
                return 0;
            }
        } else if (!(widgetRun instanceof VerticalWidgetRun)) {
            return 0;
        }
        DependencyNode dependencyNode = (i == 0 ? constraintWidgetContainer.e : constraintWidgetContainer.f).h;
        DependencyNode dependencyNode2 = (i == 0 ? constraintWidgetContainer.e : constraintWidgetContainer.f).i;
        boolean contains = widgetRun.h.l.contains(dependencyNode);
        boolean contains2 = this.c.i.l.contains(dependencyNode2);
        long j2 = this.c.j();
        if (contains && contains2) {
            long d2 = d(this.c.h, 0);
            long c2 = c(this.c.i, 0);
            long j3 = d2 - j2;
            WidgetRun widgetRun2 = this.c;
            int i2 = widgetRun2.i.f;
            if (j3 >= ((long) (-i2))) {
                j3 += (long) i2;
            }
            int i3 = widgetRun2.h.f;
            long j4 = ((-c2) - j2) - ((long) i3);
            if (j4 >= ((long) i3)) {
                j4 -= (long) i3;
            }
            float s = widgetRun2.b.s(i);
            if (s > 0.0f) {
                j = (long) ((((float) j4) / s) + (((float) j3) / (1.0f - s)));
            }
            float f2 = (float) j;
            long j5 = ((long) ((f2 * s) + 0.5f)) + j2 + ((long) ((f2 * (1.0f - s)) + 0.5f));
            WidgetRun widgetRun3 = this.c;
            return (((long) widgetRun3.h.f) + j5) - ((long) widgetRun3.i.f);
        } else if (contains) {
            DependencyNode dependencyNode3 = this.c.h;
            return Math.max(d(dependencyNode3, (long) dependencyNode3.f), ((long) this.c.h.f) + j2);
        } else if (contains2) {
            DependencyNode dependencyNode4 = this.c.i;
            return Math.max(-c(dependencyNode4, (long) dependencyNode4.f), ((long) (-this.c.i.f)) + j2);
        } else {
            WidgetRun widgetRun4 = this.c;
            return (((long) widgetRun4.h.f) + widgetRun4.j()) - ((long) this.c.i.f);
        }
    }

    public final long c(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.d;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        int size = dependencyNode.k.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            Dependency dependency = (Dependency) dependencyNode.k.get(i);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.d != widgetRun) {
                    j2 = Math.min(j2, c(dependencyNode2, ((long) dependencyNode2.f) + j));
                }
            }
        }
        if (dependencyNode != widgetRun.i) {
            return j2;
        }
        long j3 = j - widgetRun.j();
        return Math.min(Math.min(j2, c(widgetRun.h, j3)), j3 - ((long) widgetRun.h.f));
    }

    public final long d(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.d;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        int size = dependencyNode.k.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            Dependency dependency = (Dependency) dependencyNode.k.get(i);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.d != widgetRun) {
                    j2 = Math.max(j2, d(dependencyNode2, ((long) dependencyNode2.f) + j));
                }
            }
        }
        if (dependencyNode != widgetRun.h) {
            return j2;
        }
        long j3 = j + widgetRun.j();
        return Math.max(Math.max(j2, d(widgetRun.i, j3)), j3 - ((long) widgetRun.i.f));
    }
}
