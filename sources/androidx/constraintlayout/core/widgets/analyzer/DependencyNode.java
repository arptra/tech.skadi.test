package androidx.constraintlayout.core.widgets.analyzer;

import com.honey.account.constant.AccountConstantKt;
import java.util.ArrayList;
import java.util.List;

public class DependencyNode implements Dependency {

    /* renamed from: a  reason: collision with root package name */
    public Dependency f538a = null;
    public boolean b = false;
    public boolean c = false;
    public WidgetRun d;
    public Type e = Type.UNKNOWN;
    public int f;
    public int g;
    public int h = 1;
    public DimensionDependency i = null;
    public boolean j = false;
    public List k = new ArrayList();
    public List l = new ArrayList();

    public enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.d = widgetRun;
    }

    public void a(Dependency dependency) {
        for (DependencyNode dependencyNode : this.l) {
            if (!dependencyNode.j) {
                return;
            }
        }
        this.c = true;
        Dependency dependency2 = this.f538a;
        if (dependency2 != null) {
            dependency2.a(this);
        }
        if (this.b) {
            this.d.a(this);
            return;
        }
        DependencyNode dependencyNode2 = null;
        int i2 = 0;
        for (DependencyNode dependencyNode3 : this.l) {
            if (!(dependencyNode3 instanceof DimensionDependency)) {
                i2++;
                dependencyNode2 = dependencyNode3;
            }
        }
        if (dependencyNode2 != null && i2 == 1 && dependencyNode2.j) {
            DimensionDependency dimensionDependency = this.i;
            if (dimensionDependency != null) {
                if (dimensionDependency.j) {
                    this.f = this.h * dimensionDependency.g;
                } else {
                    return;
                }
            }
            d(dependencyNode2.g + this.f);
        }
        Dependency dependency3 = this.f538a;
        if (dependency3 != null) {
            dependency3.a(this);
        }
    }

    public void b(Dependency dependency) {
        this.k.add(dependency);
        if (this.j) {
            dependency.a(dependency);
        }
    }

    public void c() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }

    public void d(int i2) {
        if (!this.j) {
            this.j = true;
            this.g = i2;
            for (Dependency dependency : this.k) {
                dependency.a(dependency);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.b.v());
        sb.append(AccountConstantKt.CODE_SEPARTOR);
        sb.append(this.e);
        sb.append("(");
        sb.append(this.j ? Integer.valueOf(this.g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.k.size());
        sb.append(">");
        return sb.toString();
    }
}
