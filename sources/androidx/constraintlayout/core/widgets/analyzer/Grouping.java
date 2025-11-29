package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;

public class Grouping {
    public static WidgetGroup a(ConstraintWidget constraintWidget, int i, ArrayList arrayList, WidgetGroup widgetGroup) {
        int w1;
        int i2 = i == 0 ? constraintWidget.S0 : constraintWidget.T0;
        int i3 = 0;
        if (i2 != -1 && (widgetGroup == null || i2 != widgetGroup.b)) {
            int i4 = 0;
            while (true) {
                if (i4 >= arrayList.size()) {
                    break;
                }
                WidgetGroup widgetGroup2 = (WidgetGroup) arrayList.get(i4);
                if (widgetGroup2.c() == i2) {
                    if (widgetGroup != null) {
                        widgetGroup.g(i, widgetGroup2);
                        arrayList.remove(widgetGroup);
                    }
                    widgetGroup = widgetGroup2;
                } else {
                    i4++;
                }
            }
        } else if (i2 != -1) {
            return widgetGroup;
        }
        if (widgetGroup == null) {
            if ((constraintWidget instanceof HelperWidget) && (w1 = ((HelperWidget) constraintWidget).w1(i)) != -1) {
                int i5 = 0;
                while (true) {
                    if (i5 >= arrayList.size()) {
                        break;
                    }
                    WidgetGroup widgetGroup3 = (WidgetGroup) arrayList.get(i5);
                    if (widgetGroup3.c() == w1) {
                        widgetGroup = widgetGroup3;
                        break;
                    }
                    i5++;
                }
            }
            if (widgetGroup == null) {
                widgetGroup = new WidgetGroup(i);
            }
            arrayList.add(widgetGroup);
        }
        if (widgetGroup.a(constraintWidget)) {
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                ConstraintAnchor v1 = guideline.v1();
                if (guideline.w1() == 0) {
                    i3 = 1;
                }
                v1.c(i3, arrayList, widgetGroup);
            }
            if (i == 0) {
                constraintWidget.S0 = widgetGroup.c();
                constraintWidget.Q.c(i, arrayList, widgetGroup);
                constraintWidget.S.c(i, arrayList, widgetGroup);
            } else {
                constraintWidget.T0 = widgetGroup.c();
                constraintWidget.R.c(i, arrayList, widgetGroup);
                constraintWidget.U.c(i, arrayList, widgetGroup);
                constraintWidget.T.c(i, arrayList, widgetGroup);
            }
            constraintWidget.X.c(i, arrayList, widgetGroup);
        }
        return widgetGroup;
    }

    public static WidgetGroup b(ArrayList arrayList, int i) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            WidgetGroup widgetGroup = (WidgetGroup) arrayList.get(i2);
            if (i == widgetGroup.b) {
                return widgetGroup;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:178:0x035c  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0398  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x039d A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r16, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer r17) {
        /*
            r0 = r16
            java.util.ArrayList r1 = r16.v1()
            int r2 = r1.size()
            r3 = 0
            r4 = r3
        L_0x000c:
            if (r4 >= r2) goto L_0x0033
            java.lang.Object r5 = r1.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = r16.C()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = r16.V()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r5.C()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = r5.V()
            boolean r6 = d(r6, r7, r8, r9)
            if (r6 != 0) goto L_0x002b
            return r3
        L_0x002b:
            boolean r5 = r5 instanceof androidx.constraintlayout.core.widgets.Flow
            if (r5 == 0) goto L_0x0030
            return r3
        L_0x0030:
            int r4 = r4 + 1
            goto L_0x000c
        L_0x0033:
            androidx.constraintlayout.core.Metrics r4 = r0.b1
            if (r4 == 0) goto L_0x003e
            long r5 = r4.E
            r7 = 1
            long r5 = r5 + r7
            r4.E = r5
        L_0x003e:
            r5 = r3
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x0045:
            if (r5 >= r2) goto L_0x011e
            java.lang.Object r13 = r1.get(r5)
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r13
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = r16.C()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = r16.V()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = r13.C()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r13.V()
            boolean r4 = d(r14, r15, r4, r12)
            if (r4 != 0) goto L_0x006d
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r4 = r0.A1
            int r12 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.k
            r14 = r17
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.X1(r3, r13, r14, r4, r12)
            goto L_0x006f
        L_0x006d:
            r14 = r17
        L_0x006f:
            boolean r4 = r13 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r4 == 0) goto L_0x0097
            r12 = r13
            androidx.constraintlayout.core.widgets.Guideline r12 = (androidx.constraintlayout.core.widgets.Guideline) r12
            int r15 = r12.w1()
            if (r15 != 0) goto L_0x0086
            if (r8 != 0) goto L_0x0083
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L_0x0083:
            r8.add(r12)
        L_0x0086:
            int r15 = r12.w1()
            r3 = 1
            if (r15 != r3) goto L_0x0097
            if (r6 != 0) goto L_0x0094
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x0094:
            r6.add(r12)
        L_0x0097:
            boolean r3 = r13 instanceof androidx.constraintlayout.core.widgets.HelperWidget
            if (r3 == 0) goto L_0x00db
            boolean r3 = r13 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r3 == 0) goto L_0x00c4
            r3 = r13
            androidx.constraintlayout.core.widgets.Barrier r3 = (androidx.constraintlayout.core.widgets.Barrier) r3
            int r12 = r3.B1()
            if (r12 != 0) goto L_0x00b2
            if (r7 != 0) goto L_0x00af
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x00af:
            r7.add(r3)
        L_0x00b2:
            int r12 = r3.B1()
            r15 = 1
            if (r12 != r15) goto L_0x00db
            if (r9 != 0) goto L_0x00c0
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
        L_0x00c0:
            r9.add(r3)
            goto L_0x00db
        L_0x00c4:
            r3 = r13
            androidx.constraintlayout.core.widgets.HelperWidget r3 = (androidx.constraintlayout.core.widgets.HelperWidget) r3
            if (r7 != 0) goto L_0x00ce
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x00ce:
            r7.add(r3)
            if (r9 != 0) goto L_0x00d8
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
        L_0x00d8:
            r9.add(r3)
        L_0x00db:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f
            if (r3 != 0) goto L_0x00f7
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f
            if (r3 != 0) goto L_0x00f7
            if (r4 != 0) goto L_0x00f7
            boolean r3 = r13 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r3 != 0) goto L_0x00f7
            if (r10 != 0) goto L_0x00f4
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
        L_0x00f4:
            r10.add(r13)
        L_0x00f7:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f
            if (r3 != 0) goto L_0x0119
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f
            if (r3 != 0) goto L_0x0119
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.U
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f
            if (r3 != 0) goto L_0x0119
            if (r4 != 0) goto L_0x0119
            boolean r3 = r13 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r3 != 0) goto L_0x0119
            if (r11 != 0) goto L_0x0116
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
        L_0x0116:
            r11.add(r13)
        L_0x0119:
            int r5 = r5 + 1
            r3 = 0
            goto L_0x0045
        L_0x011e:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            if (r6 == 0) goto L_0x013b
            java.util.Iterator r4 = r6.iterator()
        L_0x0129:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x013b
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.Guideline r5 = (androidx.constraintlayout.core.widgets.Guideline) r5
            r6 = 0
            r12 = 0
            a(r5, r6, r3, r12)
            goto L_0x0129
        L_0x013b:
            r6 = 0
            r12 = 0
            if (r7 == 0) goto L_0x015c
            java.util.Iterator r4 = r7.iterator()
        L_0x0143:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x015c
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.HelperWidget r5 = (androidx.constraintlayout.core.widgets.HelperWidget) r5
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r7 = a(r5, r6, r3, r12)
            r5.v1(r3, r6, r7)
            r7.b(r3)
            r6 = 0
            r12 = 0
            goto L_0x0143
        L_0x015c:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.q(r4)
            java.util.HashSet r5 = r4.d()
            if (r5 == 0) goto L_0x0184
            java.util.HashSet r4 = r4.d()
            java.util.Iterator r4 = r4.iterator()
        L_0x0170:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0184
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.d
            r6 = 0
            r7 = 0
            a(r5, r6, r3, r7)
            goto L_0x0170
        L_0x0184:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.q(r4)
            java.util.HashSet r5 = r4.d()
            if (r5 == 0) goto L_0x01ac
            java.util.HashSet r4 = r4.d()
            java.util.Iterator r4 = r4.iterator()
        L_0x0198:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01ac
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.d
            r6 = 0
            r7 = 0
            a(r5, r6, r3, r7)
            goto L_0x0198
        L_0x01ac:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.q(r4)
            java.util.HashSet r5 = r4.d()
            if (r5 == 0) goto L_0x01d4
            java.util.HashSet r4 = r4.d()
            java.util.Iterator r4 = r4.iterator()
        L_0x01c0:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01d4
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.d
            r6 = 0
            r7 = 0
            a(r5, r6, r3, r7)
            goto L_0x01c0
        L_0x01d4:
            r6 = 0
            r7 = 0
            if (r10 == 0) goto L_0x01ec
            java.util.Iterator r4 = r10.iterator()
        L_0x01dc:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01ec
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            a(r5, r6, r3, r7)
            goto L_0x01dc
        L_0x01ec:
            if (r8 == 0) goto L_0x0203
            java.util.Iterator r4 = r8.iterator()
        L_0x01f2:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0203
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.Guideline r5 = (androidx.constraintlayout.core.widgets.Guideline) r5
            r6 = 1
            a(r5, r6, r3, r7)
            goto L_0x01f2
        L_0x0203:
            r6 = 1
            if (r9 == 0) goto L_0x0223
            java.util.Iterator r4 = r9.iterator()
        L_0x020a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0223
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.HelperWidget r5 = (androidx.constraintlayout.core.widgets.HelperWidget) r5
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r8 = a(r5, r6, r3, r7)
            r5.v1(r3, r6, r8)
            r8.b(r3)
            r6 = 1
            r7 = 0
            goto L_0x020a
        L_0x0223:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.q(r4)
            java.util.HashSet r5 = r4.d()
            if (r5 == 0) goto L_0x024b
            java.util.HashSet r4 = r4.d()
            java.util.Iterator r4 = r4.iterator()
        L_0x0237:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x024b
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.d
            r6 = 0
            r7 = 1
            a(r5, r7, r3, r6)
            goto L_0x0237
        L_0x024b:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.q(r4)
            java.util.HashSet r5 = r4.d()
            if (r5 == 0) goto L_0x0273
            java.util.HashSet r4 = r4.d()
            java.util.Iterator r4 = r4.iterator()
        L_0x025f:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0273
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.d
            r6 = 0
            r7 = 1
            a(r5, r7, r3, r6)
            goto L_0x025f
        L_0x0273:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.q(r4)
            java.util.HashSet r5 = r4.d()
            if (r5 == 0) goto L_0x029b
            java.util.HashSet r4 = r4.d()
            java.util.Iterator r4 = r4.iterator()
        L_0x0287:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x029b
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.d
            r6 = 0
            r7 = 1
            a(r5, r7, r3, r6)
            goto L_0x0287
        L_0x029b:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.q(r4)
            java.util.HashSet r5 = r4.d()
            if (r5 == 0) goto L_0x02c3
            java.util.HashSet r4 = r4.d()
            java.util.Iterator r4 = r4.iterator()
        L_0x02af:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x02c3
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.d
            r6 = 1
            r12 = 0
            a(r5, r6, r3, r12)
            goto L_0x02af
        L_0x02c3:
            r6 = 1
            r12 = 0
            if (r11 == 0) goto L_0x02db
            java.util.Iterator r4 = r11.iterator()
        L_0x02cb:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x02db
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            a(r5, r6, r3, r12)
            goto L_0x02cb
        L_0x02db:
            r4 = 0
        L_0x02dc:
            if (r4 >= r2) goto L_0x0308
            java.lang.Object r5 = r1.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            boolean r6 = r5.u0()
            if (r6 == 0) goto L_0x0305
            int r6 = r5.S0
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r6 = b(r3, r6)
            int r5 = r5.T0
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r5 = b(r3, r5)
            if (r6 == 0) goto L_0x0305
            if (r5 == 0) goto L_0x0305
            r7 = 0
            r6.g(r7, r5)
            r7 = 2
            r5.i(r7)
            r3.remove(r6)
        L_0x0305:
            int r4 = r4 + 1
            goto L_0x02dc
        L_0x0308:
            int r1 = r3.size()
            r2 = 1
            if (r1 > r2) goto L_0x0311
            r1 = 0
            return r1
        L_0x0311:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = r16.C()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r2) goto L_0x0353
            java.util.Iterator r1 = r3.iterator()
            r2 = r12
            r6 = 0
        L_0x031f:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0344
            java.lang.Object r4 = r1.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r4 = (androidx.constraintlayout.core.widgets.analyzer.WidgetGroup) r4
            int r5 = r4.d()
            r7 = 1
            if (r5 != r7) goto L_0x0333
            goto L_0x031f
        L_0x0333:
            r5 = 0
            r4.h(r5)
            androidx.constraintlayout.core.LinearSystem r7 = r16.P1()
            int r7 = r4.f(r7, r5)
            if (r7 <= r6) goto L_0x031f
            r2 = r4
            r6 = r7
            goto L_0x031f
        L_0x0344:
            if (r2 == 0) goto L_0x0353
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0.T0(r1)
            r0.o1(r6)
            r1 = 1
            r2.h(r1)
            goto L_0x0354
        L_0x0353:
            r2 = r12
        L_0x0354:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = r16.V()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r4) goto L_0x0398
            java.util.Iterator r1 = r3.iterator()
            r3 = r12
            r6 = 0
        L_0x0362:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0387
            java.lang.Object r4 = r1.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r4 = (androidx.constraintlayout.core.widgets.analyzer.WidgetGroup) r4
            int r5 = r4.d()
            if (r5 != 0) goto L_0x0375
            goto L_0x0362
        L_0x0375:
            r5 = 0
            r4.h(r5)
            androidx.constraintlayout.core.LinearSystem r7 = r16.P1()
            r8 = 1
            int r7 = r4.f(r7, r8)
            if (r7 <= r6) goto L_0x0362
            r3 = r4
            r6 = r7
            goto L_0x0362
        L_0x0387:
            r5 = 0
            r8 = 1
            if (r3 == 0) goto L_0x039a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0.k1(r1)
            r0.P0(r6)
            r3.h(r8)
            r4 = r3
            goto L_0x039b
        L_0x0398:
            r5 = 0
            r8 = 1
        L_0x039a:
            r4 = r12
        L_0x039b:
            if (r2 != 0) goto L_0x03a2
            if (r4 == 0) goto L_0x03a0
            goto L_0x03a2
        L_0x03a0:
            r3 = r5
            goto L_0x03a3
        L_0x03a2:
            r3 = r8
        L_0x03a3:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Grouping.c(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d(androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r5, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r6, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r7, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r8) {
        /*
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r1 = 1
            r2 = 0
            if (r7 == r0) goto L_0x0013
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 == r3) goto L_0x0013
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r7 != r4) goto L_0x0011
            if (r5 == r3) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r5 = r2
            goto L_0x0014
        L_0x0013:
            r5 = r1
        L_0x0014:
            if (r8 == r0) goto L_0x0023
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r8 == r7) goto L_0x0023
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r8 != r0) goto L_0x0021
            if (r6 == r7) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r6 = r2
            goto L_0x0024
        L_0x0023:
            r6 = r1
        L_0x0024:
            if (r5 != 0) goto L_0x002a
            if (r6 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            return r2
        L_0x002a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Grouping.d(androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour):boolean");
    }
}
