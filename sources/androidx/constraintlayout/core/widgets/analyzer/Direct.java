package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;

public class Direct {

    /* renamed from: a  reason: collision with root package name */
    public static BasicMeasure.Measure f539a = new BasicMeasure.Measure();
    public static int b = 0;
    public static int c = 0;

    public static boolean a(int i, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour C = constraintWidget.C();
        ConstraintWidget.DimensionBehaviour V = constraintWidget.V();
        ConstraintWidgetContainer constraintWidgetContainer = constraintWidget.M() != null ? (ConstraintWidgetContainer) constraintWidget.M() : null;
        if (constraintWidgetContainer != null) {
            ConstraintWidget.DimensionBehaviour C2 = constraintWidgetContainer.C();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (constraintWidgetContainer != null) {
            ConstraintWidget.DimensionBehaviour V2 = constraintWidgetContainer.V();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        boolean z = C == dimensionBehaviour5 || constraintWidget.p0() || C == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (C == (dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.w == 0 && constraintWidget.f0 == 0.0f && constraintWidget.c0(0)) || (C == dimensionBehaviour2 && constraintWidget.w == 1 && constraintWidget.f0(0, constraintWidget.Y()));
        boolean z2 = V == dimensionBehaviour5 || constraintWidget.q0() || V == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (V == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.x == 0 && constraintWidget.f0 == 0.0f && constraintWidget.c0(1)) || (V == dimensionBehaviour && constraintWidget.x == 1 && constraintWidget.f0(1, constraintWidget.z()));
        if (constraintWidget.f0 <= 0.0f || (!z && !z2)) {
            return z && z2;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0084, code lost:
        r11 = r12.S.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0094, code lost:
        r11 = r12.Q.f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(int r16, androidx.constraintlayout.core.widgets.ConstraintWidget r17, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer r18, boolean r19) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r17.i0()
            if (r3 == 0) goto L_0x000d
            return
        L_0x000d:
            int r3 = b
            r4 = 1
            int r3 = r3 + r4
            b = r3
            boolean r3 = r0 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r3 != 0) goto L_0x002f
            boolean r3 = r17.o0()
            if (r3 == 0) goto L_0x002f
            int r3 = r16 + 1
            boolean r5 = a(r3, r0)
            if (r5 == 0) goto L_0x002f
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r5 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r5.<init>()
            int r6 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.X1(r3, r0, r1, r5, r6)
        L_0x002f:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r0.q(r3)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.q(r5)
            int r6 = r3.e()
            int r7 = r5.e()
            java.util.HashSet r8 = r3.d()
            r9 = 0
            r10 = 8
            if (r8 == 0) goto L_0x0131
            boolean r8 = r3.n()
            if (r8 == 0) goto L_0x0131
            java.util.HashSet r3 = r3.d()
            java.util.Iterator r3 = r3.iterator()
        L_0x005a:
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x0131
            java.lang.Object r8 = r3.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r8
            androidx.constraintlayout.core.widgets.ConstraintWidget r12 = r8.d
            int r13 = r16 + 1
            boolean r14 = a(r13, r12)
            boolean r15 = r12.o0()
            if (r15 == 0) goto L_0x0080
            if (r14 == 0) goto L_0x0080
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r15 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r15.<init>()
            int r11 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.X1(r13, r12, r1, r15, r11)
        L_0x0080:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.Q
            if (r8 != r11) goto L_0x0090
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r11.f
            if (r11 == 0) goto L_0x0090
            boolean r11 = r11.n()
            if (r11 != 0) goto L_0x00a0
        L_0x0090:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.S
            if (r8 != r11) goto L_0x00a2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r11.f
            if (r11 == 0) goto L_0x00a2
            boolean r11 = r11.n()
            if (r11 == 0) goto L_0x00a2
        L_0x00a0:
            r11 = r4
            goto L_0x00a3
        L_0x00a2:
            r11 = 0
        L_0x00a3:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = r12.C()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r15 != r4) goto L_0x00e6
            if (r14 == 0) goto L_0x00ae
            goto L_0x00e6
        L_0x00ae:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r12.C()
            if (r8 != r4) goto L_0x00ec
            int r4 = r12.A
            if (r4 < 0) goto L_0x00ec
            int r4 = r12.z
            if (r4 < 0) goto L_0x00ec
            int r4 = r12.X()
            if (r4 == r10) goto L_0x00ce
            int r4 = r12.w
            if (r4 != 0) goto L_0x00ec
            float r4 = r12.x()
            int r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r4 != 0) goto L_0x00ec
        L_0x00ce:
            boolean r4 = r12.k0()
            if (r4 != 0) goto L_0x00ec
            boolean r4 = r12.n0()
            if (r4 != 0) goto L_0x00ec
            if (r11 == 0) goto L_0x00ec
            boolean r4 = r12.k0()
            if (r4 != 0) goto L_0x00ec
            e(r13, r0, r1, r12, r2)
            goto L_0x00ec
        L_0x00e6:
            boolean r4 = r12.o0()
            if (r4 == 0) goto L_0x00ef
        L_0x00ec:
            r4 = 1
            goto L_0x005a
        L_0x00ef:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r12.Q
            if (r8 != r4) goto L_0x010a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r12.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r14.f
            if (r14 != 0) goto L_0x010a
            int r4 = r4.f()
            int r4 = r4 + r6
            int r8 = r12.Y()
            int r8 = r8 + r4
            r12.J0(r4, r8)
            b(r13, r12, r1, r2)
            goto L_0x00ec
        L_0x010a:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r12.S
            if (r8 != r14) goto L_0x0125
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f
            if (r4 != 0) goto L_0x0125
            int r4 = r14.f()
            int r4 = r6 - r4
            int r8 = r12.Y()
            int r8 = r4 - r8
            r12.J0(r8, r4)
            b(r13, r12, r1, r2)
            goto L_0x00ec
        L_0x0125:
            if (r11 == 0) goto L_0x00ec
            boolean r4 = r12.k0()
            if (r4 != 0) goto L_0x00ec
            d(r13, r1, r12, r2)
            goto L_0x00ec
        L_0x0131:
            boolean r3 = r0 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r3 == 0) goto L_0x0136
            return
        L_0x0136:
            java.util.HashSet r3 = r5.d()
            if (r3 == 0) goto L_0x0225
            boolean r3 = r5.n()
            if (r3 == 0) goto L_0x0225
            java.util.HashSet r3 = r5.d()
            java.util.Iterator r3 = r3.iterator()
        L_0x014a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0225
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r4.d
            r6 = 1
            int r8 = r16 + 1
            boolean r11 = a(r8, r5)
            boolean r12 = r5.o0()
            if (r12 == 0) goto L_0x0171
            if (r11 == 0) goto L_0x0171
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r12 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r12.<init>()
            int r13 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.X1(r8, r5, r1, r12, r13)
        L_0x0171:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r5.Q
            if (r4 != r12) goto L_0x0181
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r5.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r12.f
            if (r12 == 0) goto L_0x0181
            boolean r12 = r12.n()
            if (r12 != 0) goto L_0x0191
        L_0x0181:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r5.S
            if (r4 != r12) goto L_0x0193
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r5.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r12.f
            if (r12 == 0) goto L_0x0193
            boolean r12 = r12.n()
            if (r12 == 0) goto L_0x0193
        L_0x0191:
            r12 = r6
            goto L_0x0194
        L_0x0193:
            r12 = 0
        L_0x0194:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = r5.C()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r13 != r14) goto L_0x01d8
            if (r11 == 0) goto L_0x019f
            goto L_0x01d8
        L_0x019f:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = r5.C()
            if (r4 != r14) goto L_0x014a
            int r4 = r5.A
            if (r4 < 0) goto L_0x014a
            int r4 = r5.z
            if (r4 < 0) goto L_0x014a
            int r4 = r5.X()
            if (r4 == r10) goto L_0x01bf
            int r4 = r5.w
            if (r4 != 0) goto L_0x014a
            float r4 = r5.x()
            int r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r4 != 0) goto L_0x014a
        L_0x01bf:
            boolean r4 = r5.k0()
            if (r4 != 0) goto L_0x014a
            boolean r4 = r5.n0()
            if (r4 != 0) goto L_0x014a
            if (r12 == 0) goto L_0x014a
            boolean r4 = r5.k0()
            if (r4 != 0) goto L_0x014a
            e(r8, r0, r1, r5, r2)
            goto L_0x014a
        L_0x01d8:
            boolean r11 = r5.o0()
            if (r11 == 0) goto L_0x01e0
            goto L_0x014a
        L_0x01e0:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r5.Q
            if (r4 != r11) goto L_0x01fc
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r5.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r13.f
            if (r13 != 0) goto L_0x01fc
            int r4 = r11.f()
            int r4 = r4 + r7
            int r11 = r5.Y()
            int r11 = r11 + r4
            r5.J0(r4, r11)
            b(r8, r5, r1, r2)
            goto L_0x014a
        L_0x01fc:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r5.S
            if (r4 != r13) goto L_0x0218
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r11.f
            if (r4 != 0) goto L_0x0218
            int r4 = r13.f()
            int r4 = r7 - r4
            int r11 = r5.Y()
            int r11 = r4 - r11
            r5.J0(r11, r4)
            b(r8, r5, r1, r2)
            goto L_0x014a
        L_0x0218:
            if (r12 == 0) goto L_0x014a
            boolean r4 = r5.k0()
            if (r4 != 0) goto L_0x014a
            d(r8, r1, r5, r2)
            goto L_0x014a
        L_0x0225:
            r17.s0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Direct.b(int, androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer, boolean):void");
    }

    public static void c(int i, Barrier barrier, BasicMeasure.Measurer measurer, int i2, boolean z) {
        if (!barrier.x1()) {
            return;
        }
        if (i2 == 0) {
            b(i + 1, barrier, measurer, z);
        } else {
            i(i + 1, barrier, measurer);
        }
    }

    public static void d(int i, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget, boolean z) {
        float A = constraintWidget.A();
        int e = constraintWidget.Q.f.e();
        int e2 = constraintWidget.S.f.e();
        int f = constraintWidget.Q.f() + e;
        int f2 = e2 - constraintWidget.S.f();
        if (e == e2) {
            A = 0.5f;
        } else {
            e = f;
            e2 = f2;
        }
        int Y = constraintWidget.Y();
        int i2 = (e2 - e) - Y;
        if (e > e2) {
            i2 = (e - e2) - Y;
        }
        int i3 = ((int) (i2 > 0 ? (A * ((float) i2)) + 0.5f : A * ((float) i2))) + e;
        int i4 = i3 + Y;
        if (e > e2) {
            i4 = i3 - Y;
        }
        constraintWidget.J0(i3, i4);
        b(i + 1, constraintWidget, measurer, z);
    }

    public static void e(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2, boolean z) {
        float A = constraintWidget2.A();
        int e = constraintWidget2.Q.f.e() + constraintWidget2.Q.f();
        int e2 = constraintWidget2.S.f.e() - constraintWidget2.S.f();
        if (e2 >= e) {
            int Y = constraintWidget2.Y();
            if (constraintWidget2.X() != 8) {
                int i2 = constraintWidget2.w;
                if (i2 == 2) {
                    Y = (int) (constraintWidget2.A() * 0.5f * ((float) (constraintWidget instanceof ConstraintWidgetContainer ? constraintWidget.Y() : constraintWidget.M().Y())));
                } else if (i2 == 0) {
                    Y = e2 - e;
                }
                Y = Math.max(constraintWidget2.z, Y);
                int i3 = constraintWidget2.A;
                if (i3 > 0) {
                    Y = Math.min(i3, Y);
                }
            }
            int i4 = e + ((int) ((A * ((float) ((e2 - e) - Y))) + 0.5f));
            constraintWidget2.J0(i4, Y + i4);
            b(i + 1, constraintWidget2, measurer, z);
        }
    }

    public static void f(int i, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget) {
        float T = constraintWidget.T();
        int e = constraintWidget.R.f.e();
        int e2 = constraintWidget.T.f.e();
        int f = constraintWidget.R.f() + e;
        int f2 = e2 - constraintWidget.T.f();
        if (e == e2) {
            T = 0.5f;
        } else {
            e = f;
            e2 = f2;
        }
        int z = constraintWidget.z();
        int i2 = (e2 - e) - z;
        if (e > e2) {
            i2 = (e - e2) - z;
        }
        int i3 = (int) (i2 > 0 ? (T * ((float) i2)) + 0.5f : T * ((float) i2));
        int i4 = e + i3;
        int i5 = i4 + z;
        if (e > e2) {
            i4 = e - i3;
            i5 = i4 - z;
        }
        constraintWidget.M0(i4, i5);
        i(i + 1, constraintWidget, measurer);
    }

    public static void g(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2) {
        float T = constraintWidget2.T();
        int e = constraintWidget2.R.f.e() + constraintWidget2.R.f();
        int e2 = constraintWidget2.T.f.e() - constraintWidget2.T.f();
        if (e2 >= e) {
            int z = constraintWidget2.z();
            if (constraintWidget2.X() != 8) {
                int i2 = constraintWidget2.x;
                if (i2 == 2) {
                    z = (int) (T * 0.5f * ((float) (constraintWidget instanceof ConstraintWidgetContainer ? constraintWidget.z() : constraintWidget.M().z())));
                } else if (i2 == 0) {
                    z = e2 - e;
                }
                z = Math.max(constraintWidget2.C, z);
                int i3 = constraintWidget2.D;
                if (i3 > 0) {
                    z = Math.min(i3, z);
                }
            }
            int i4 = e + ((int) ((T * ((float) ((e2 - e) - z))) + 0.5f));
            constraintWidget2.M0(i4, z + i4);
            i(i + 1, constraintWidget2, measurer);
        }
    }

    public static void h(ConstraintWidgetContainer constraintWidgetContainer, BasicMeasure.Measurer measurer) {
        ConstraintWidget.DimensionBehaviour C = constraintWidgetContainer.C();
        ConstraintWidget.DimensionBehaviour V = constraintWidgetContainer.V();
        b = 0;
        c = 0;
        constraintWidgetContainer.y0();
        ArrayList v1 = constraintWidgetContainer.v1();
        int size = v1.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) v1.get(i)).y0();
        }
        boolean U1 = constraintWidgetContainer.U1();
        if (C == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.J0(0, constraintWidgetContainer.Y());
        } else {
            constraintWidgetContainer.K0(0);
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) v1.get(i2);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.w1() == 1) {
                    if (guideline.x1() != -1) {
                        guideline.A1(guideline.x1());
                    } else if (guideline.y1() != -1 && constraintWidgetContainer.p0()) {
                        guideline.A1(constraintWidgetContainer.Y() - guideline.y1());
                    } else if (constraintWidgetContainer.p0()) {
                        guideline.A1((int) ((guideline.z1() * ((float) constraintWidgetContainer.Y())) + 0.5f));
                    }
                    z = true;
                }
            } else if ((constraintWidget instanceof Barrier) && ((Barrier) constraintWidget).B1() == 0) {
                z2 = true;
            }
        }
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) v1.get(i3);
                if (constraintWidget2 instanceof Guideline) {
                    Guideline guideline2 = (Guideline) constraintWidget2;
                    if (guideline2.w1() == 1) {
                        b(0, guideline2, measurer, U1);
                    }
                }
            }
        }
        b(0, constraintWidgetContainer, measurer, U1);
        if (z2) {
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget3 = (ConstraintWidget) v1.get(i4);
                if (constraintWidget3 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget3;
                    if (barrier.B1() == 0) {
                        c(0, barrier, measurer, 0, U1);
                    }
                }
            }
        }
        if (V == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.M0(0, constraintWidgetContainer.z());
        } else {
            constraintWidgetContainer.L0(0);
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget4 = (ConstraintWidget) v1.get(i5);
            if (constraintWidget4 instanceof Guideline) {
                Guideline guideline3 = (Guideline) constraintWidget4;
                if (guideline3.w1() == 0) {
                    if (guideline3.x1() != -1) {
                        guideline3.A1(guideline3.x1());
                    } else if (guideline3.y1() != -1 && constraintWidgetContainer.q0()) {
                        guideline3.A1(constraintWidgetContainer.z() - guideline3.y1());
                    } else if (constraintWidgetContainer.q0()) {
                        guideline3.A1((int) ((guideline3.z1() * ((float) constraintWidgetContainer.z())) + 0.5f));
                    }
                    z3 = true;
                }
            } else if ((constraintWidget4 instanceof Barrier) && ((Barrier) constraintWidget4).B1() == 1) {
                z4 = true;
            }
        }
        if (z3) {
            for (int i6 = 0; i6 < size; i6++) {
                ConstraintWidget constraintWidget5 = (ConstraintWidget) v1.get(i6);
                if (constraintWidget5 instanceof Guideline) {
                    Guideline guideline4 = (Guideline) constraintWidget5;
                    if (guideline4.w1() == 0) {
                        i(1, guideline4, measurer);
                    }
                }
            }
        }
        i(0, constraintWidgetContainer, measurer);
        if (z4) {
            for (int i7 = 0; i7 < size; i7++) {
                ConstraintWidget constraintWidget6 = (ConstraintWidget) v1.get(i7);
                if (constraintWidget6 instanceof Barrier) {
                    Barrier barrier2 = (Barrier) constraintWidget6;
                    if (barrier2.B1() == 1) {
                        c(0, barrier2, measurer, 1, U1);
                    }
                }
            }
        }
        for (int i8 = 0; i8 < size; i8++) {
            ConstraintWidget constraintWidget7 = (ConstraintWidget) v1.get(i8);
            if (constraintWidget7.o0() && a(0, constraintWidget7)) {
                ConstraintWidgetContainer.X1(0, constraintWidget7, measurer, f539a, BasicMeasure.Measure.k);
                if (!(constraintWidget7 instanceof Guideline)) {
                    b(0, constraintWidget7, measurer, U1);
                    i(0, constraintWidget7, measurer);
                } else if (((Guideline) constraintWidget7).w1() == 0) {
                    i(0, constraintWidget7, measurer);
                } else {
                    b(0, constraintWidget7, measurer, U1);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0082, code lost:
        r14 = r11.T.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0092, code lost:
        r14 = r11.R.f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void i(int r16, androidx.constraintlayout.core.widgets.ConstraintWidget r17, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer r18) {
        /*
            r0 = r17
            r1 = r18
            boolean r2 = r17.r0()
            if (r2 == 0) goto L_0x000b
            return
        L_0x000b:
            int r2 = c
            r3 = 1
            int r2 = r2 + r3
            c = r2
            boolean r2 = r0 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r2 != 0) goto L_0x002d
            boolean r2 = r17.o0()
            if (r2 == 0) goto L_0x002d
            int r2 = r16 + 1
            boolean r4 = a(r2, r0)
            if (r4 == 0) goto L_0x002d
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r4 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r4.<init>()
            int r5 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.X1(r2, r0, r1, r4, r5)
        L_0x002d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.q(r2)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.q(r4)
            int r5 = r2.e()
            int r6 = r4.e()
            java.util.HashSet r7 = r2.d()
            r8 = 0
            r9 = 8
            if (r7 == 0) goto L_0x0132
            boolean r7 = r2.n()
            if (r7 == 0) goto L_0x0132
            java.util.HashSet r2 = r2.d()
            java.util.Iterator r2 = r2.iterator()
        L_0x0058:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x0132
            java.lang.Object r7 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r7
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r7.d
            int r12 = r16 + 1
            boolean r13 = a(r12, r11)
            boolean r14 = r11.o0()
            if (r14 == 0) goto L_0x007e
            if (r13 == 0) goto L_0x007e
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r14 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r14.<init>()
            int r15 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.X1(r12, r11, r1, r14, r15)
        L_0x007e:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r11.R
            if (r7 != r14) goto L_0x008e
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r11.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r14.f
            if (r14 == 0) goto L_0x008e
            boolean r14 = r14.n()
            if (r14 != 0) goto L_0x009e
        L_0x008e:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r11.T
            if (r7 != r14) goto L_0x00a0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r11.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r14.f
            if (r14 == 0) goto L_0x00a0
            boolean r14 = r14.n()
            if (r14 == 0) goto L_0x00a0
        L_0x009e:
            r14 = r3
            goto L_0x00a1
        L_0x00a0:
            r14 = 0
        L_0x00a1:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = r11.V()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r15 != r10) goto L_0x00e5
            if (r13 == 0) goto L_0x00ac
            goto L_0x00e5
        L_0x00ac:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = r11.V()
            if (r7 != r10) goto L_0x0058
            int r7 = r11.D
            if (r7 < 0) goto L_0x0058
            int r7 = r11.C
            if (r7 < 0) goto L_0x0058
            int r7 = r11.X()
            if (r7 == r9) goto L_0x00cc
            int r7 = r11.x
            if (r7 != 0) goto L_0x0058
            float r7 = r11.x()
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x0058
        L_0x00cc:
            boolean r7 = r11.m0()
            if (r7 != 0) goto L_0x0058
            boolean r7 = r11.n0()
            if (r7 != 0) goto L_0x0058
            if (r14 == 0) goto L_0x0058
            boolean r7 = r11.m0()
            if (r7 != 0) goto L_0x0058
            g(r12, r0, r1, r11)
            goto L_0x0058
        L_0x00e5:
            boolean r10 = r11.o0()
            if (r10 == 0) goto L_0x00ed
            goto L_0x0058
        L_0x00ed:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r11.R
            if (r7 != r10) goto L_0x0109
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r11.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r13.f
            if (r13 != 0) goto L_0x0109
            int r7 = r10.f()
            int r7 = r7 + r5
            int r10 = r11.z()
            int r10 = r10 + r7
            r11.M0(r7, r10)
            i(r12, r11, r1)
            goto L_0x0058
        L_0x0109:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r11.T
            if (r7 != r13) goto L_0x0125
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r10.f
            if (r7 != 0) goto L_0x0125
            int r7 = r13.f()
            int r7 = r5 - r7
            int r10 = r11.z()
            int r10 = r7 - r10
            r11.M0(r10, r7)
            i(r12, r11, r1)
            goto L_0x0058
        L_0x0125:
            if (r14 == 0) goto L_0x0058
            boolean r7 = r11.m0()
            if (r7 != 0) goto L_0x0058
            f(r12, r1, r11)
            goto L_0x0058
        L_0x0132:
            boolean r2 = r0 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r2 == 0) goto L_0x0137
            return
        L_0x0137:
            java.util.HashSet r2 = r4.d()
            if (r2 == 0) goto L_0x0225
            boolean r2 = r4.n()
            if (r2 == 0) goto L_0x0225
            java.util.HashSet r2 = r4.d()
            java.util.Iterator r2 = r2.iterator()
        L_0x014b:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0225
            java.lang.Object r4 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r4.d
            int r7 = r16 + 1
            boolean r10 = a(r7, r5)
            boolean r11 = r5.o0()
            if (r11 == 0) goto L_0x0171
            if (r10 == 0) goto L_0x0171
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r11 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r11.<init>()
            int r12 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.X1(r7, r5, r1, r11, r12)
        L_0x0171:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r5.R
            if (r4 != r11) goto L_0x0181
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r5.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r11.f
            if (r11 == 0) goto L_0x0181
            boolean r11 = r11.n()
            if (r11 != 0) goto L_0x0191
        L_0x0181:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r5.T
            if (r4 != r11) goto L_0x0193
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r5.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r11.f
            if (r11 == 0) goto L_0x0193
            boolean r11 = r11.n()
            if (r11 == 0) goto L_0x0193
        L_0x0191:
            r11 = r3
            goto L_0x0194
        L_0x0193:
            r11 = 0
        L_0x0194:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r5.V()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r12 != r13) goto L_0x01d8
            if (r10 == 0) goto L_0x019f
            goto L_0x01d8
        L_0x019f:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = r5.V()
            if (r4 != r13) goto L_0x014b
            int r4 = r5.D
            if (r4 < 0) goto L_0x014b
            int r4 = r5.C
            if (r4 < 0) goto L_0x014b
            int r4 = r5.X()
            if (r4 == r9) goto L_0x01bf
            int r4 = r5.x
            if (r4 != 0) goto L_0x014b
            float r4 = r5.x()
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x014b
        L_0x01bf:
            boolean r4 = r5.m0()
            if (r4 != 0) goto L_0x014b
            boolean r4 = r5.n0()
            if (r4 != 0) goto L_0x014b
            if (r11 == 0) goto L_0x014b
            boolean r4 = r5.m0()
            if (r4 != 0) goto L_0x014b
            g(r7, r0, r1, r5)
            goto L_0x014b
        L_0x01d8:
            boolean r10 = r5.o0()
            if (r10 == 0) goto L_0x01e0
            goto L_0x014b
        L_0x01e0:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r5.R
            if (r4 != r10) goto L_0x01fc
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r5.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r12.f
            if (r12 != 0) goto L_0x01fc
            int r4 = r10.f()
            int r4 = r4 + r6
            int r10 = r5.z()
            int r10 = r10 + r4
            r5.M0(r4, r10)
            i(r7, r5, r1)
            goto L_0x014b
        L_0x01fc:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r5.T
            if (r4 != r12) goto L_0x0218
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r10.f
            if (r4 != 0) goto L_0x0218
            int r4 = r12.f()
            int r4 = r6 - r4
            int r10 = r5.z()
            int r10 = r4 - r10
            r5.M0(r10, r4)
            i(r7, r5, r1)
            goto L_0x014b
        L_0x0218:
            if (r11 == 0) goto L_0x014b
            boolean r4 = r5.m0()
            if (r4 != 0) goto L_0x014b
            f(r7, r1, r5)
            goto L_0x014b
        L_0x0225:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.q(r2)
            java.util.HashSet r4 = r2.d()
            if (r4 == 0) goto L_0x028a
            boolean r4 = r2.n()
            if (r4 == 0) goto L_0x028a
            int r4 = r2.e()
            java.util.HashSet r2 = r2.d()
            java.util.Iterator r2 = r2.iterator()
        L_0x0243:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x028a
            java.lang.Object r5 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r5.d
            int r7 = r16 + 1
            boolean r8 = a(r7, r6)
            boolean r9 = r6.o0()
            if (r9 == 0) goto L_0x0269
            if (r8 == 0) goto L_0x0269
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r9 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r9.<init>()
            int r10 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.X1(r7, r6, r1, r9, r10)
        L_0x0269:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = r6.V()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r9 != r10) goto L_0x0273
            if (r8 == 0) goto L_0x0243
        L_0x0273:
            boolean r8 = r6.o0()
            if (r8 == 0) goto L_0x027a
            goto L_0x0243
        L_0x027a:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r6.U
            if (r5 != r8) goto L_0x0243
            int r5 = r5.f()
            int r5 = r5 + r4
            r6.I0(r5)
            i(r7, r6, r1)
            goto L_0x0243
        L_0x028a:
            r17.t0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Direct.i(int, androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer):void");
    }
}
