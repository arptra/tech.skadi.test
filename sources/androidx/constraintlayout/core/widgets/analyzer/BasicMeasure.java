package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import java.util.ArrayList;

public class BasicMeasure {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f535a = new ArrayList();
    public Measure b = new Measure();
    public ConstraintWidgetContainer c;

    public static class Measure {
        public static int k = 0;
        public static int l = 1;
        public static int m = 2;

        /* renamed from: a  reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f536a;
        public ConstraintWidget.DimensionBehaviour b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public boolean i;
        public int j;
    }

    public interface Measurer {
        void a();

        void b(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.c = constraintWidgetContainer;
    }

    public final boolean a(Measurer measurer, ConstraintWidget constraintWidget, int i) {
        this.b.f536a = constraintWidget.C();
        this.b.b = constraintWidget.V();
        this.b.c = constraintWidget.Y();
        this.b.d = constraintWidget.z();
        Measure measure = this.b;
        measure.i = false;
        measure.j = i;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.f536a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z = dimensionBehaviour == dimensionBehaviour2;
        boolean z2 = measure.b == dimensionBehaviour2;
        boolean z3 = z && constraintWidget.f0 > 0.0f;
        boolean z4 = z2 && constraintWidget.f0 > 0.0f;
        if (z3 && constraintWidget.y[0] == 4) {
            measure.f536a = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z4 && constraintWidget.y[1] == 4) {
            measure.b = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.b(constraintWidget, measure);
        constraintWidget.o1(this.b.e);
        constraintWidget.P0(this.b.f);
        constraintWidget.O0(this.b.h);
        constraintWidget.E0(this.b.g);
        Measure measure2 = this.b;
        measure2.j = Measure.k;
        return measure2.i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008e, code lost:
        if (r8 != r9) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0095, code lost:
        if (r5.f0 <= 0.0f) goto L_0x0098;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r13) {
        /*
            r12 = this;
            java.util.ArrayList r0 = r13.V0
            int r0 = r0.size()
            r1 = 64
            boolean r1 = r13.Y1(r1)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r2 = r13.N1()
            r3 = 0
            r4 = r3
        L_0x0012:
            if (r4 >= r0) goto L_0x00b0
            java.util.ArrayList r5 = r13.V0
            java.lang.Object r5 = r5.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r6 == 0) goto L_0x0022
            goto L_0x00ac
        L_0x0022:
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r6 == 0) goto L_0x0028
            goto L_0x00ac
        L_0x0028:
            boolean r6 = r5.n0()
            if (r6 == 0) goto L_0x0030
            goto L_0x00ac
        L_0x0030:
            if (r1 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r6 = r5.e
            if (r6 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r7 = r5.f
            if (r7 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r6.e
            boolean r6 = r6.j
            if (r6 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r7.e
            boolean r6 = r6.j
            if (r6 == 0) goto L_0x0048
            goto L_0x00ac
        L_0x0048:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = r5.w(r3)
            r7 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r5.w(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r9) goto L_0x0061
            int r10 = r5.w
            if (r10 == r7) goto L_0x0061
            if (r8 != r9) goto L_0x0061
            int r10 = r5.x
            if (r10 == r7) goto L_0x0061
            r10 = r7
            goto L_0x0062
        L_0x0061:
            r10 = r3
        L_0x0062:
            if (r10 != 0) goto L_0x0098
            boolean r11 = r13.Y1(r7)
            if (r11 == 0) goto L_0x0098
            boolean r11 = r5 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
            if (r11 != 0) goto L_0x0098
            if (r6 != r9) goto L_0x007d
            int r11 = r5.w
            if (r11 != 0) goto L_0x007d
            if (r8 == r9) goto L_0x007d
            boolean r11 = r5.k0()
            if (r11 != 0) goto L_0x007d
            r10 = r7
        L_0x007d:
            if (r8 != r9) goto L_0x008c
            int r11 = r5.x
            if (r11 != 0) goto L_0x008c
            if (r6 == r9) goto L_0x008c
            boolean r11 = r5.k0()
            if (r11 != 0) goto L_0x008c
            r10 = r7
        L_0x008c:
            if (r6 == r9) goto L_0x0090
            if (r8 != r9) goto L_0x0098
        L_0x0090:
            float r6 = r5.f0
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x0098
            goto L_0x0099
        L_0x0098:
            r7 = r10
        L_0x0099:
            if (r7 == 0) goto L_0x009c
            goto L_0x00ac
        L_0x009c:
            int r6 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.k
            r12.a(r2, r5, r6)
            androidx.constraintlayout.core.Metrics r5 = r13.b1
            if (r5 == 0) goto L_0x00ac
            long r6 = r5.f480a
            r8 = 1
            long r6 = r6 + r8
            r5.f480a = r6
        L_0x00ac:
            int r4 = r4 + 1
            goto L_0x0012
        L_0x00b0:
            r2.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.b(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer):void");
    }

    public final void c(ConstraintWidgetContainer constraintWidgetContainer, String str, int i, int i2, int i3) {
        int K = constraintWidgetContainer.K();
        int J = constraintWidgetContainer.J();
        constraintWidgetContainer.e1(0);
        constraintWidgetContainer.d1(0);
        constraintWidgetContainer.o1(i2);
        constraintWidgetContainer.P0(i3);
        constraintWidgetContainer.e1(K);
        constraintWidgetContainer.d1(J);
        this.c.c2(i);
        this.c.w1();
    }

    public long d(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10;
        boolean z;
        int i11;
        int i12;
        boolean z2;
        Measurer measurer;
        int i13;
        int i14;
        int i15;
        boolean z3;
        Metrics metrics;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        int i16 = i;
        int i17 = i4;
        int i18 = i6;
        Measurer N1 = constraintWidgetContainer.N1();
        int size = constraintWidgetContainer2.V0.size();
        int Y = constraintWidgetContainer.Y();
        int z4 = constraintWidgetContainer.z();
        boolean b2 = Optimizer.b(i16, 128);
        boolean z5 = b2 || Optimizer.b(i16, 64);
        if (z5) {
            int i19 = 0;
            while (true) {
                if (i19 >= size) {
                    break;
                }
                ConstraintWidget constraintWidget = (ConstraintWidget) constraintWidgetContainer2.V0.get(i19);
                ConstraintWidget.DimensionBehaviour C = constraintWidget.C();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z6 = (C == dimensionBehaviour) && (constraintWidget.V() == dimensionBehaviour) && constraintWidget.x() > 0.0f;
                if ((!constraintWidget.k0() || !z6) && ((!constraintWidget.m0() || !z6) && !(constraintWidget instanceof VirtualLayout) && !constraintWidget.k0() && !constraintWidget.m0())) {
                    i19++;
                }
            }
            z5 = false;
        }
        if (z5 && (metrics = LinearSystem.x) != null) {
            metrics.c++;
        }
        boolean z7 = z5 & ((i17 == 1073741824 && i18 == 1073741824) || b2);
        int i20 = 2;
        if (z7) {
            int min = Math.min(constraintWidgetContainer.I(), i5);
            int min2 = Math.min(constraintWidgetContainer.H(), i7);
            if (i17 == 1073741824 && constraintWidgetContainer.Y() != min) {
                constraintWidgetContainer2.o1(min);
                constraintWidgetContainer.R1();
            }
            if (i18 == 1073741824 && constraintWidgetContainer.z() != min2) {
                constraintWidgetContainer2.P0(min2);
                constraintWidgetContainer.R1();
            }
            if (i17 == 1073741824 && i18 == 1073741824) {
                z = constraintWidgetContainer2.J1(b2);
                i10 = 2;
            } else {
                boolean K1 = constraintWidgetContainer2.K1(b2);
                if (i17 == 1073741824) {
                    K1 &= constraintWidgetContainer2.L1(b2, 0);
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if (i18 == 1073741824) {
                    z = constraintWidgetContainer2.L1(b2, 1) & K1;
                    i10++;
                } else {
                    z = K1;
                }
            }
            if (z) {
                constraintWidgetContainer2.t1(i17 == 1073741824, i18 == 1073741824);
            }
        } else {
            z = false;
            i10 = 0;
        }
        if (z && i10 == 2) {
            return 0;
        }
        int O1 = constraintWidgetContainer.O1();
        if (size > 0) {
            b(constraintWidgetContainer);
        }
        e(constraintWidgetContainer);
        int size2 = this.f535a.size();
        if (size > 0) {
            c(constraintWidgetContainer, "First pass", 0, Y, z4);
        }
        if (size2 > 0) {
            ConstraintWidget.DimensionBehaviour C2 = constraintWidgetContainer.C();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z8 = C2 == dimensionBehaviour2;
            boolean z9 = constraintWidgetContainer.V() == dimensionBehaviour2;
            int max = Math.max(constraintWidgetContainer.Y(), this.c.K());
            int max2 = Math.max(constraintWidgetContainer.z(), this.c.J());
            int i21 = 0;
            boolean z10 = false;
            while (i21 < size2) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) this.f535a.get(i21);
                if (!(constraintWidget2 instanceof VirtualLayout)) {
                    i13 = O1;
                    i14 = Y;
                    i15 = z4;
                } else {
                    int Y2 = constraintWidget2.Y();
                    i13 = O1;
                    int z11 = constraintWidget2.z();
                    i15 = z4;
                    boolean a2 = a(N1, constraintWidget2, Measure.l) | z10;
                    Metrics metrics2 = constraintWidgetContainer2.b1;
                    i14 = Y;
                    boolean z12 = a2;
                    if (metrics2 != null) {
                        metrics2.b++;
                    }
                    int Y3 = constraintWidget2.Y();
                    int z13 = constraintWidget2.z();
                    if (Y3 != Y2) {
                        constraintWidget2.o1(Y3);
                        if (z8 && constraintWidget2.O() > max) {
                            max = Math.max(max, constraintWidget2.O() + constraintWidget2.q(ConstraintAnchor.Type.RIGHT).f());
                        }
                        z3 = true;
                    } else {
                        z3 = z12;
                    }
                    if (z13 != z11) {
                        constraintWidget2.P0(z13);
                        if (z9 && constraintWidget2.t() > max2) {
                            max2 = Math.max(max2, constraintWidget2.t() + constraintWidget2.q(ConstraintAnchor.Type.BOTTOM).f());
                        }
                        z3 = true;
                    }
                    z10 = z3 | ((VirtualLayout) constraintWidget2).J1();
                }
                i21++;
                O1 = i13;
                z4 = i15;
                Y = i14;
                i20 = 2;
            }
            int i22 = O1;
            int i23 = Y;
            int i24 = z4;
            int i25 = i20;
            int i26 = 0;
            while (i26 < i25) {
                int i27 = 0;
                while (i27 < size2) {
                    ConstraintWidget constraintWidget3 = (ConstraintWidget) this.f535a.get(i27);
                    if ((!(constraintWidget3 instanceof Helper) || (constraintWidget3 instanceof VirtualLayout)) && !(constraintWidget3 instanceof Guideline) && constraintWidget3.X() != 8 && ((!z7 || !constraintWidget3.e.e.j || !constraintWidget3.f.e.j) && !(constraintWidget3 instanceof VirtualLayout))) {
                        int Y4 = constraintWidget3.Y();
                        int z14 = constraintWidget3.z();
                        int r = constraintWidget3.r();
                        int i28 = Measure.l;
                        z2 = z7;
                        if (i26 == 1) {
                            i28 = Measure.m;
                        }
                        boolean a3 = a(N1, constraintWidget3, i28) | z10;
                        Metrics metrics3 = constraintWidgetContainer2.b1;
                        i12 = size2;
                        measurer = N1;
                        if (metrics3 != null) {
                            metrics3.b++;
                        }
                        int Y5 = constraintWidget3.Y();
                        int z15 = constraintWidget3.z();
                        if (Y5 != Y4) {
                            constraintWidget3.o1(Y5);
                            if (z8 && constraintWidget3.O() > max) {
                                max = Math.max(max, constraintWidget3.O() + constraintWidget3.q(ConstraintAnchor.Type.RIGHT).f());
                            }
                            a3 = true;
                        }
                        if (z15 != z14) {
                            constraintWidget3.P0(z15);
                            if (z9 && constraintWidget3.t() > max2) {
                                max2 = Math.max(max2, constraintWidget3.t() + constraintWidget3.q(ConstraintAnchor.Type.BOTTOM).f());
                            }
                            a3 = true;
                        }
                        z10 = (!constraintWidget3.b0() || r == constraintWidget3.r()) ? a3 : true;
                    } else {
                        z2 = z7;
                        i12 = size2;
                        measurer = N1;
                    }
                    i27++;
                    N1 = measurer;
                    z7 = z2;
                    size2 = i12;
                }
                boolean z16 = z7;
                int i29 = size2;
                Measurer measurer2 = N1;
                if (!z10) {
                    break;
                }
                i26++;
                c(constraintWidgetContainer, "intermediate pass", i26, i23, i24);
                N1 = measurer2;
                z7 = z16;
                size2 = i29;
                i25 = 2;
                z10 = false;
            }
            i11 = i22;
        } else {
            i11 = O1;
        }
        constraintWidgetContainer2.b2(i11);
        return 0;
    }

    public void e(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f535a.clear();
        int size = constraintWidgetContainer.V0.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) constraintWidgetContainer.V0.get(i);
            ConstraintWidget.DimensionBehaviour C = constraintWidget.C();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (C == dimensionBehaviour || constraintWidget.V() == dimensionBehaviour) {
                this.f535a.add(constraintWidget);
            }
        }
        constraintWidgetContainer.R1();
    }
}
