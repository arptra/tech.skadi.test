package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

class DimensionDependency extends DependencyNode {
    public int m;

    public DimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof HorizontalWidgetRun) {
            this.e = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.e = DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }

    public void d(int i) {
        if (!this.j) {
            this.j = true;
            this.g = i;
            for (Dependency dependency : this.k) {
                dependency.a(dependency);
            }
        }
    }
}
