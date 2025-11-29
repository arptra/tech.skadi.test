package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class DependencyGraph {

    /* renamed from: a  reason: collision with root package name */
    public ConstraintWidgetContainer f537a;
    public boolean b = true;
    public boolean c = true;
    public ConstraintWidgetContainer d;
    public ArrayList e = new ArrayList();
    public ArrayList f = new ArrayList();
    public BasicMeasure.Measurer g = null;
    public BasicMeasure.Measure h = new BasicMeasure.Measure();
    public ArrayList i = new ArrayList();

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f537a = constraintWidgetContainer;
        this.d = constraintWidgetContainer;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: androidx.constraintlayout.core.widgets.analyzer.DependencyNode} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: androidx.constraintlayout.core.widgets.analyzer.DependencyNode} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9, int r10, int r11, androidx.constraintlayout.core.widgets.analyzer.DependencyNode r12, java.util.ArrayList r13, androidx.constraintlayout.core.widgets.analyzer.RunGroup r14) {
        /*
            r8 = this;
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r9 = r9.d
            androidx.constraintlayout.core.widgets.analyzer.RunGroup r0 = r9.c
            if (r0 != 0) goto L_0x0107
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = r8.f537a
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r1 = r0.e
            if (r9 == r1) goto L_0x0107
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.f
            if (r9 != r0) goto L_0x0012
            goto L_0x0107
        L_0x0012:
            if (r14 != 0) goto L_0x001c
            androidx.constraintlayout.core.widgets.analyzer.RunGroup r14 = new androidx.constraintlayout.core.widgets.analyzer.RunGroup
            r14.<init>(r9, r11)
            r13.add(r14)
        L_0x001c:
            r9.c = r14
            r14.a(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r11 = r9.h
            java.util.List r11 = r11.k
            java.util.Iterator r11 = r11.iterator()
        L_0x0029:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x0046
            java.lang.Object r0 = r11.next()
            androidx.constraintlayout.core.widgets.analyzer.Dependency r0 = (androidx.constraintlayout.core.widgets.analyzer.Dependency) r0
            boolean r1 = r0 instanceof androidx.constraintlayout.core.widgets.analyzer.DependencyNode
            if (r1 == 0) goto L_0x0029
            r1 = r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            r3 = 0
            r0 = r8
            r2 = r10
            r4 = r12
            r5 = r13
            r6 = r14
            r0.a(r1, r2, r3, r4, r5, r6)
            goto L_0x0029
        L_0x0046:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r11 = r9.i
            java.util.List r11 = r11.k
            java.util.Iterator r11 = r11.iterator()
        L_0x004e:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x006b
            java.lang.Object r0 = r11.next()
            androidx.constraintlayout.core.widgets.analyzer.Dependency r0 = (androidx.constraintlayout.core.widgets.analyzer.Dependency) r0
            boolean r1 = r0 instanceof androidx.constraintlayout.core.widgets.analyzer.DependencyNode
            if (r1 == 0) goto L_0x004e
            r1 = r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            r3 = 1
            r0 = r8
            r2 = r10
            r4 = r12
            r5 = r13
            r6 = r14
            r0.a(r1, r2, r3, r4, r5, r6)
            goto L_0x004e
        L_0x006b:
            r11 = 1
            if (r10 != r11) goto L_0x009a
            boolean r0 = r9 instanceof androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun
            if (r0 == 0) goto L_0x009a
            r0 = r9
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = (androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.k
            java.util.List r0 = r0.k
            java.util.Iterator r7 = r0.iterator()
        L_0x007d:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x009a
            java.lang.Object r0 = r7.next()
            androidx.constraintlayout.core.widgets.analyzer.Dependency r0 = (androidx.constraintlayout.core.widgets.analyzer.Dependency) r0
            boolean r1 = r0 instanceof androidx.constraintlayout.core.widgets.analyzer.DependencyNode
            if (r1 == 0) goto L_0x007d
            r1 = r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            r3 = 2
            r0 = r8
            r2 = r10
            r4 = r12
            r5 = r13
            r6 = r14
            r0.a(r1, r2, r3, r4, r5, r6)
            goto L_0x007d
        L_0x009a:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r9.h
            java.util.List r0 = r0.l
            java.util.Iterator r7 = r0.iterator()
        L_0x00a2:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x00bd
            java.lang.Object r0 = r7.next()
            r1 = r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            if (r1 != r12) goto L_0x00b3
            r14.b = r11
        L_0x00b3:
            r3 = 0
            r0 = r8
            r2 = r10
            r4 = r12
            r5 = r13
            r6 = r14
            r0.a(r1, r2, r3, r4, r5, r6)
            goto L_0x00a2
        L_0x00bd:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r9.i
            java.util.List r0 = r0.l
            java.util.Iterator r7 = r0.iterator()
        L_0x00c5:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x00e0
            java.lang.Object r0 = r7.next()
            r1 = r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            if (r1 != r12) goto L_0x00d6
            r14.b = r11
        L_0x00d6:
            r3 = 1
            r0 = r8
            r2 = r10
            r4 = r12
            r5 = r13
            r6 = r14
            r0.a(r1, r2, r3, r4, r5, r6)
            goto L_0x00c5
        L_0x00e0:
            if (r10 != r11) goto L_0x0107
            boolean r11 = r9 instanceof androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun
            if (r11 == 0) goto L_0x0107
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r9 = (androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun) r9
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r9.k
            java.util.List r9 = r9.l
            java.util.Iterator r9 = r9.iterator()
        L_0x00f0:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x0107
            java.lang.Object r11 = r9.next()
            r1 = r11
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            r3 = 2
            r0 = r8
            r2 = r10
            r4 = r12
            r5 = r13
            r6 = r14
            r0.a(r1, r2, r3, r4, r5, r6)
            goto L_0x00f0
        L_0x0107:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.DependencyGraph.a(androidx.constraintlayout.core.widgets.analyzer.DependencyNode, int, int, androidx.constraintlayout.core.widgets.analyzer.DependencyNode, java.util.ArrayList, androidx.constraintlayout.core.widgets.analyzer.RunGroup):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0280, code lost:
        r4 = r0.b0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r17) {
        /*
            r16 = this;
            r0 = r17
            java.util.ArrayList r1 = r0.V0
            java.util.Iterator r1 = r1.iterator()
        L_0x0008:
            boolean r2 = r1.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x0338
            java.lang.Object r2 = r1.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r2.b0
            r5 = r4[r3]
            r10 = 1
            r4 = r4[r10]
            int r6 = r2.X()
            r7 = 8
            if (r6 != r7) goto L_0x0027
            r2.f530a = r10
            goto L_0x0008
        L_0x0027:
            float r6 = r2.B
            r11 = 1065353216(0x3f800000, float:1.0)
            int r6 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            r7 = 2
            if (r6 >= 0) goto L_0x0036
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x0036
            r2.w = r7
        L_0x0036:
            float r6 = r2.E
            int r6 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r6 >= 0) goto L_0x0042
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r6) goto L_0x0042
            r2.x = r7
        L_0x0042:
            float r6 = r2.x()
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            r8 = 3
            if (r6 <= 0) goto L_0x0078
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x005b
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 == r9) goto L_0x0058
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r4 != r9) goto L_0x005b
        L_0x0058:
            r2.w = r8
            goto L_0x0078
        L_0x005b:
            if (r4 != r6) goto L_0x0068
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 == r9) goto L_0x0065
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r5 != r9) goto L_0x0068
        L_0x0065:
            r2.x = r8
            goto L_0x0078
        L_0x0068:
            if (r5 != r6) goto L_0x0078
            if (r4 != r6) goto L_0x0078
            int r6 = r2.w
            if (r6 != 0) goto L_0x0072
            r2.w = r8
        L_0x0072:
            int r6 = r2.x
            if (r6 != 0) goto L_0x0078
            r2.x = r8
        L_0x0078:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x008e
            int r9 = r2.w
            if (r9 != r10) goto L_0x008e
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r2.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.f
            if (r9 == 0) goto L_0x008c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r2.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.f
            if (r9 != 0) goto L_0x008e
        L_0x008c:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
        L_0x008e:
            r9 = r5
            if (r4 != r6) goto L_0x00a3
            int r5 = r2.x
            if (r5 != r10) goto L_0x00a3
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f
            if (r5 == 0) goto L_0x00a1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f
            if (r5 != 0) goto L_0x00a3
        L_0x00a1:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
        L_0x00a3:
            r12 = r4
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r4 = r2.e
            r4.d = r9
            int r5 = r2.w
            r4.f545a = r5
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r4 = r2.f
            r4.d = r12
            int r13 = r2.x
            r4.f545a = r13
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r9 == r4) goto L_0x00c0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r9 == r14) goto L_0x00c0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r9 != r14) goto L_0x00cc
        L_0x00c0:
            if (r12 == r4) goto L_0x02e2
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r12 == r14) goto L_0x02e2
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r12 != r14) goto L_0x00cc
            goto L_0x02e2
        L_0x00cc:
            r14 = 1056964608(0x3f000000, float:0.5)
            if (r9 != r6) goto L_0x0199
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r12 == r15) goto L_0x00d8
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r12 != r11) goto L_0x0199
        L_0x00d8:
            if (r5 != r8) goto L_0x0113
            if (r12 != r15) goto L_0x00e6
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r15
            r8 = r15
            r4.l(r5, r6, r7, r8, r9)
        L_0x00e6:
            int r9 = r2.z()
            float r3 = (float) r9
            float r4 = r2.f0
            float r3 = r3 * r4
            float r3 = r3 + r14
            int r7 = (int) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r4 = r16
            r5 = r2
            r6 = r8
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r2.e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r4 = r2.Y()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r2.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r4 = r2.z()
            r3.d(r4)
            r2.f530a = r10
            goto L_0x0008
        L_0x0113:
            if (r5 != r10) goto L_0x012b
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r15
            r8 = r12
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r2.e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r2 = r2.Y()
            r3.m = r2
            goto L_0x0008
        L_0x012b:
            if (r5 != r7) goto L_0x0167
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r11 = r0.b0
            r11 = r11[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r11 == r15) goto L_0x0137
            if (r11 != r4) goto L_0x0199
        L_0x0137:
            float r3 = r2.B
            int r4 = r17.Y()
            float r4 = (float) r4
            float r3 = r3 * r4
            float r3 = r3 + r14
            int r7 = (int) r3
            int r9 = r2.z()
            r4 = r16
            r5 = r2
            r6 = r15
            r8 = r12
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r2.e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r4 = r2.Y()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r2.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r4 = r2.z()
            r3.d(r4)
            r2.f530a = r10
            goto L_0x0008
        L_0x0167:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r11 = r2.Y
            r7 = r11[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.f
            if (r7 == 0) goto L_0x0175
            r7 = r11[r10]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.f
            if (r7 != 0) goto L_0x0199
        L_0x0175:
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r15
            r8 = r12
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r2.e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r4 = r2.Y()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r2.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r4 = r2.z()
            r3.d(r4)
            r2.f530a = r10
            goto L_0x0008
        L_0x0199:
            if (r12 != r6) goto L_0x0272
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r9 == r11) goto L_0x01a3
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r9 != r7) goto L_0x0272
        L_0x01a3:
            if (r13 != r8) goto L_0x01e9
            if (r9 != r11) goto L_0x01b1
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r11
            r8 = r11
            r4.l(r5, r6, r7, r8, r9)
        L_0x01b1:
            int r7 = r2.Y()
            float r3 = r2.f0
            int r4 = r2.y()
            r5 = -1
            if (r4 != r5) goto L_0x01c2
            r4 = 1065353216(0x3f800000, float:1.0)
            float r3 = r4 / r3
        L_0x01c2:
            float r4 = (float) r7
            float r4 = r4 * r3
            float r4 = r4 + r14
            int r9 = (int) r4
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r4 = r16
            r5 = r2
            r6 = r8
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r2.e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r4 = r2.Y()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r2.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r4 = r2.z()
            r3.d(r4)
            r2.f530a = r10
            goto L_0x0008
        L_0x01e9:
            if (r13 != r10) goto L_0x0202
            r7 = 0
            r3 = 0
            r4 = r16
            r5 = r2
            r6 = r9
            r8 = r11
            r9 = r3
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r2.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r2 = r2.z()
            r3.m = r2
            goto L_0x0008
        L_0x0202:
            r7 = 2
            if (r13 != r7) goto L_0x023f
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r0.b0
            r7 = r7[r10]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r7 == r8) goto L_0x020f
            if (r7 != r4) goto L_0x0272
        L_0x020f:
            float r3 = r2.E
            int r7 = r2.Y()
            int r4 = r17.z()
            float r4 = (float) r4
            float r3 = r3 * r4
            float r3 = r3 + r14
            int r3 = (int) r3
            r4 = r16
            r5 = r2
            r6 = r9
            r9 = r3
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r2.e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r4 = r2.Y()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r2.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r4 = r2.z()
            r3.d(r4)
            r2.f530a = r10
            goto L_0x0008
        L_0x023f:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r2.Y
            r7 = 2
            r15 = r4[r7]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r15.f
            if (r7 == 0) goto L_0x024e
            r4 = r4[r8]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f
            if (r4 != 0) goto L_0x0272
        L_0x024e:
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r11
            r8 = r12
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r2.e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r4 = r2.Y()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r2.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r4 = r2.z()
            r3.d(r4)
            r2.f530a = r10
            goto L_0x0008
        L_0x0272:
            if (r9 != r6) goto L_0x0008
            if (r12 != r6) goto L_0x0008
            if (r5 == r10) goto L_0x02c1
            if (r13 != r10) goto L_0x027b
            goto L_0x02c1
        L_0x027b:
            r4 = 2
            if (r13 != r4) goto L_0x0008
            if (r5 != r4) goto L_0x0008
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.b0
            r3 = r4[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r3 != r8) goto L_0x0008
            r3 = r4[r10]
            if (r3 != r8) goto L_0x0008
            float r3 = r2.B
            float r4 = r2.E
            int r5 = r17.Y()
            float r5 = (float) r5
            float r3 = r3 * r5
            float r3 = r3 + r14
            int r7 = (int) r3
            int r3 = r17.z()
            float r3 = (float) r3
            float r4 = r4 * r3
            float r4 = r4 + r14
            int r9 = (int) r4
            r4 = r16
            r5 = r2
            r6 = r8
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r2.e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r4 = r2.Y()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r2.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r4 = r2.z()
            r3.d(r4)
            r2.f530a = r10
            goto L_0x0008
        L_0x02c1:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r8
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r2.e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r4 = r2.Y()
            r3.m = r4
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r2.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r2 = r2.z()
            r3.m = r2
            goto L_0x0008
        L_0x02e2:
            int r3 = r2.Y()
            if (r9 != r4) goto L_0x02fb
            int r3 = r17.Y()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.Q
            int r5 = r5.g
            int r3 = r3 - r5
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.S
            int r5 = r5.g
            int r3 = r3 - r5
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r7 = r3
            r6 = r5
            goto L_0x02fd
        L_0x02fb:
            r7 = r3
            r6 = r9
        L_0x02fd:
            int r3 = r2.z()
            if (r12 != r4) goto L_0x0316
            int r3 = r17.z()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r2.R
            int r4 = r4.g
            int r3 = r3 - r4
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r2.T
            int r4 = r4.g
            int r3 = r3 - r4
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r9 = r3
            r8 = r4
            goto L_0x0318
        L_0x0316:
            r9 = r3
            r8 = r12
        L_0x0318:
            r4 = r16
            r5 = r2
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r2.e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r4 = r2.Y()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r2.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.e
            int r4 = r2.z()
            r3.d(r4)
            r2.f530a = r10
            goto L_0x0008
        L_0x0338:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.DependencyGraph.b(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer):boolean");
    }

    public void c() {
        d(this.e);
        this.i.clear();
        RunGroup.h = 0;
        i(this.f537a.e, 0, this.i);
        i(this.f537a.f, 1, this.i);
        this.b = false;
    }

    public void d(ArrayList arrayList) {
        arrayList.clear();
        this.d.e.f();
        this.d.f.f();
        arrayList.add(this.d.e);
        arrayList.add(this.d.f);
        Iterator it = this.d.V0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            if (constraintWidget instanceof Guideline) {
                arrayList.add(new GuidelineReference(constraintWidget));
            } else {
                if (constraintWidget.k0()) {
                    if (constraintWidget.c == null) {
                        constraintWidget.c = new ChainRun(constraintWidget, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.c);
                } else {
                    arrayList.add(constraintWidget.e);
                }
                if (constraintWidget.m0()) {
                    if (constraintWidget.d == null) {
                        constraintWidget.d = new ChainRun(constraintWidget, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.d);
                } else {
                    arrayList.add(constraintWidget.f);
                }
                if (constraintWidget instanceof HelperWidget) {
                    arrayList.add(new HelperReferences(constraintWidget));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((WidgetRun) it2.next()).f();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun widgetRun = (WidgetRun) it3.next();
            if (widgetRun.b != this.d) {
                widgetRun.d();
            }
        }
    }

    public final int e(ConstraintWidgetContainer constraintWidgetContainer, int i2) {
        int size = this.i.size();
        long j = 0;
        for (int i3 = 0; i3 < size; i3++) {
            j = Math.max(j, ((RunGroup) this.i.get(i3)).b(constraintWidgetContainer, i2));
        }
        return (int) j;
    }

    public boolean f(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (this.b || this.c) {
            Iterator it = this.f537a.V0.iterator();
            while (it.hasNext()) {
                ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
                constraintWidget.p();
                constraintWidget.f530a = false;
                constraintWidget.e.r();
                constraintWidget.f.q();
            }
            this.f537a.p();
            ConstraintWidgetContainer constraintWidgetContainer = this.f537a;
            constraintWidgetContainer.f530a = false;
            constraintWidgetContainer.e.r();
            this.f537a.f.q();
            this.c = false;
        }
        if (b(this.d)) {
            return false;
        }
        this.f537a.q1(0);
        this.f537a.r1(0);
        ConstraintWidget.DimensionBehaviour w = this.f537a.w(0);
        ConstraintWidget.DimensionBehaviour w2 = this.f537a.w(1);
        if (this.b) {
            c();
        }
        int Z = this.f537a.Z();
        int a0 = this.f537a.a0();
        this.f537a.e.h.d(Z);
        this.f537a.f.h.d(a0);
        m();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (w == dimensionBehaviour || w2 == dimensionBehaviour) {
            if (z) {
                Iterator it2 = this.e.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!((WidgetRun) it2.next()).m()) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z && w == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f537a.T0(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer2 = this.f537a;
                constraintWidgetContainer2.o1(e(constraintWidgetContainer2, 0));
                ConstraintWidgetContainer constraintWidgetContainer3 = this.f537a;
                constraintWidgetContainer3.e.e.d(constraintWidgetContainer3.Y());
            }
            if (z && w2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f537a.k1(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer4 = this.f537a;
                constraintWidgetContainer4.P0(e(constraintWidgetContainer4, 1));
                ConstraintWidgetContainer constraintWidgetContainer5 = this.f537a;
                constraintWidgetContainer5.f.e.d(constraintWidgetContainer5.z());
            }
        }
        ConstraintWidgetContainer constraintWidgetContainer6 = this.f537a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidgetContainer6.b0[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour2 == dimensionBehaviour3 || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int Y = constraintWidgetContainer6.Y() + Z;
            this.f537a.e.i.d(Y);
            this.f537a.e.e.d(Y - Z);
            m();
            ConstraintWidgetContainer constraintWidgetContainer7 = this.f537a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidgetContainer7.b0[1];
            if (dimensionBehaviour4 == dimensionBehaviour3 || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int z4 = constraintWidgetContainer7.z() + a0;
                this.f537a.f.i.d(z4);
                this.f537a.f.e.d(z4 - a0);
            }
            m();
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator it3 = this.e.iterator();
        while (it3.hasNext()) {
            WidgetRun widgetRun = (WidgetRun) it3.next();
            if (widgetRun.b != this.f537a || widgetRun.g) {
                widgetRun.e();
            }
        }
        Iterator it4 = this.e.iterator();
        while (true) {
            if (!it4.hasNext()) {
                z3 = true;
                break;
            }
            WidgetRun widgetRun2 = (WidgetRun) it4.next();
            if ((z2 || widgetRun2.b != this.f537a) && (!widgetRun2.h.j || ((!widgetRun2.i.j && !(widgetRun2 instanceof GuidelineReference)) || (!widgetRun2.e.j && !(widgetRun2 instanceof ChainRun) && !(widgetRun2 instanceof GuidelineReference))))) {
                break;
            }
        }
        this.f537a.T0(w);
        this.f537a.k1(w2);
        return z3;
    }

    public boolean g(boolean z) {
        if (this.b) {
            Iterator it = this.f537a.V0.iterator();
            while (it.hasNext()) {
                ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
                constraintWidget.p();
                constraintWidget.f530a = false;
                HorizontalWidgetRun horizontalWidgetRun = constraintWidget.e;
                horizontalWidgetRun.e.j = false;
                horizontalWidgetRun.g = false;
                horizontalWidgetRun.r();
                VerticalWidgetRun verticalWidgetRun = constraintWidget.f;
                verticalWidgetRun.e.j = false;
                verticalWidgetRun.g = false;
                verticalWidgetRun.q();
            }
            this.f537a.p();
            ConstraintWidgetContainer constraintWidgetContainer = this.f537a;
            constraintWidgetContainer.f530a = false;
            HorizontalWidgetRun horizontalWidgetRun2 = constraintWidgetContainer.e;
            horizontalWidgetRun2.e.j = false;
            horizontalWidgetRun2.g = false;
            horizontalWidgetRun2.r();
            VerticalWidgetRun verticalWidgetRun2 = this.f537a.f;
            verticalWidgetRun2.e.j = false;
            verticalWidgetRun2.g = false;
            verticalWidgetRun2.q();
            c();
        }
        if (b(this.d)) {
            return false;
        }
        this.f537a.q1(0);
        this.f537a.r1(0);
        this.f537a.e.h.d(0);
        this.f537a.f.h.d(0);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x013e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h(boolean r10, int r11) {
        /*
            r9 = this;
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = r9.f537a
            r1 = 0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r0.w(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r2 = r9.f537a
            r3 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = r2.w(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r4 = r9.f537a
            int r4 = r4.Z()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r9.f537a
            int r5 = r5.a0()
            if (r10 == 0) goto L_0x0088
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 == r6) goto L_0x0022
            if (r2 != r6) goto L_0x0088
        L_0x0022:
            java.util.ArrayList r6 = r9.e
            java.util.Iterator r6 = r6.iterator()
        L_0x0028:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x003f
            java.lang.Object r7 = r6.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r7 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r7
            int r8 = r7.f
            if (r8 != r11) goto L_0x0028
            boolean r7 = r7.m()
            if (r7 != 0) goto L_0x0028
            r10 = r1
        L_0x003f:
            if (r11 != 0) goto L_0x0065
            if (r10 == 0) goto L_0x0088
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r10) goto L_0x0088
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f537a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r10.T0(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f537a
            int r6 = r9.e(r10, r1)
            r10.o1(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f537a
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r6 = r10.e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r6.e
            int r10 = r10.Y()
            r6.d(r10)
            goto L_0x0088
        L_0x0065:
            if (r10 == 0) goto L_0x0088
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r10) goto L_0x0088
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f537a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r10.k1(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f537a
            int r6 = r9.e(r10, r3)
            r10.P0(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f537a
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r6 = r10.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r6.e
            int r10 = r10.z()
            r6.d(r10)
        L_0x0088:
            if (r11 != 0) goto L_0x00b2
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f537a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r10.b0
            r5 = r5[r1]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r5 == r6) goto L_0x0098
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r5 != r6) goto L_0x00c1
        L_0x0098:
            int r10 = r10.Y()
            int r10 = r10 + r4
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r9.f537a
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r5 = r5.e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r5 = r5.i
            r5.d(r10)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r9.f537a
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r5 = r5.e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r5 = r5.e
            int r10 = r10 - r4
            r5.d(r10)
        L_0x00b0:
            r10 = r3
            goto L_0x00dc
        L_0x00b2:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f537a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r10.b0
            r4 = r4[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r4 == r6) goto L_0x00c3
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r4 != r6) goto L_0x00c1
            goto L_0x00c3
        L_0x00c1:
            r10 = r1
            goto L_0x00dc
        L_0x00c3:
            int r10 = r10.z()
            int r10 = r10 + r5
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r4 = r9.f537a
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r4 = r4.f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r4.i
            r4.d(r10)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r4 = r9.f537a
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r4 = r4.f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r4 = r4.e
            int r10 = r10 - r5
            r4.d(r10)
            goto L_0x00b0
        L_0x00dc:
            r9.m()
            java.util.ArrayList r4 = r9.e
            java.util.Iterator r4 = r4.iterator()
        L_0x00e5:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0105
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r5 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r5
            int r6 = r5.f
            if (r6 == r11) goto L_0x00f6
            goto L_0x00e5
        L_0x00f6:
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r5.b
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r9.f537a
            if (r6 != r7) goto L_0x0101
            boolean r6 = r5.g
            if (r6 != 0) goto L_0x0101
            goto L_0x00e5
        L_0x0101:
            r5.e()
            goto L_0x00e5
        L_0x0105:
            java.util.ArrayList r4 = r9.e
            java.util.Iterator r4 = r4.iterator()
        L_0x010b:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x013e
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r5 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r5
            int r6 = r5.f
            if (r6 == r11) goto L_0x011c
            goto L_0x010b
        L_0x011c:
            if (r10 != 0) goto L_0x0125
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r5.b
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r9.f537a
            if (r6 != r7) goto L_0x0125
            goto L_0x010b
        L_0x0125:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r6 = r5.h
            boolean r6 = r6.j
            if (r6 != 0) goto L_0x012c
            goto L_0x013f
        L_0x012c:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r6 = r5.i
            boolean r6 = r6.j
            if (r6 != 0) goto L_0x0133
            goto L_0x013f
        L_0x0133:
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.analyzer.ChainRun
            if (r6 != 0) goto L_0x010b
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r5 = r5.e
            boolean r5 = r5.j
            if (r5 != 0) goto L_0x010b
            goto L_0x013f
        L_0x013e:
            r1 = r3
        L_0x013f:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f537a
            r10.T0(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r9 = r9.f537a
            r9.k1(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.DependencyGraph.h(boolean, int):boolean");
    }

    public final void i(WidgetRun widgetRun, int i2, ArrayList arrayList) {
        for (Dependency dependency : widgetRun.h.k) {
            if (dependency instanceof DependencyNode) {
                a((DependencyNode) dependency, i2, 0, widgetRun.i, arrayList, (RunGroup) null);
            } else if (dependency instanceof WidgetRun) {
                a(((WidgetRun) dependency).h, i2, 0, widgetRun.i, arrayList, (RunGroup) null);
            }
        }
        for (Dependency dependency2 : widgetRun.i.k) {
            if (dependency2 instanceof DependencyNode) {
                a((DependencyNode) dependency2, i2, 1, widgetRun.h, arrayList, (RunGroup) null);
            } else if (dependency2 instanceof WidgetRun) {
                a(((WidgetRun) dependency2).i, i2, 1, widgetRun.h, arrayList, (RunGroup) null);
            }
        }
        if (i2 == 1) {
            for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).k.k) {
                if (dependency3 instanceof DependencyNode) {
                    a((DependencyNode) dependency3, i2, 2, (DependencyNode) null, arrayList, (RunGroup) null);
                }
            }
        }
    }

    public void j() {
        this.b = true;
    }

    public void k() {
        this.c = true;
    }

    public final void l(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i2, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i3) {
        BasicMeasure.Measure measure = this.h;
        measure.f536a = dimensionBehaviour;
        measure.b = dimensionBehaviour2;
        measure.c = i2;
        measure.d = i3;
        this.g.b(constraintWidget, measure);
        constraintWidget.o1(this.h.e);
        constraintWidget.P0(this.h.f);
        constraintWidget.O0(this.h.h);
        constraintWidget.E0(this.h.g);
    }

    public void m() {
        DimensionDependency dimensionDependency;
        Iterator it = this.f537a.V0.iterator();
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            if (!constraintWidget.f530a) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.b0;
                boolean z = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i2 = constraintWidget.w;
                int i3 = constraintWidget.x;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                boolean z2 = dimensionBehaviour == dimensionBehaviour3 || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i2 == 1);
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i3 == 1)) {
                    z = true;
                }
                DimensionDependency dimensionDependency2 = constraintWidget.e.e;
                boolean z3 = dimensionDependency2.j;
                DimensionDependency dimensionDependency3 = constraintWidget.f.e;
                boolean z4 = dimensionDependency3.j;
                if (z3 && z4) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    l(constraintWidget, dimensionBehaviour4, dimensionDependency2.g, dimensionBehaviour4, dimensionDependency3.g);
                    constraintWidget.f530a = true;
                } else if (z3 && z) {
                    l(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, dimensionDependency2.g, dimensionBehaviour3, dimensionDependency3.g);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        constraintWidget.f.e.m = constraintWidget.z();
                    } else {
                        constraintWidget.f.e.d(constraintWidget.z());
                        constraintWidget.f530a = true;
                    }
                } else if (z4 && z2) {
                    l(constraintWidget, dimensionBehaviour3, dimensionDependency2.g, ConstraintWidget.DimensionBehaviour.FIXED, dimensionDependency3.g);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        constraintWidget.e.e.m = constraintWidget.Y();
                    } else {
                        constraintWidget.e.e.d(constraintWidget.Y());
                        constraintWidget.f530a = true;
                    }
                }
                if (constraintWidget.f530a && (dimensionDependency = constraintWidget.f.l) != null) {
                    dimensionDependency.d(constraintWidget.r());
                }
            }
        }
    }

    public void n(BasicMeasure.Measurer measurer) {
        this.g = measurer;
    }
}
