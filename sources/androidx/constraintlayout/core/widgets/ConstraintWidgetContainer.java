package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.core.widgets.analyzer.DependencyGraph;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class ConstraintWidgetContainer extends WidgetContainer {
    public BasicMeasure.Measure A1 = new BasicMeasure.Measure();
    public BasicMeasure W0 = new BasicMeasure(this);
    public DependencyGraph X0 = new DependencyGraph(this);
    public int Y0;
    public BasicMeasure.Measurer Z0 = null;
    public boolean a1 = false;
    public Metrics b1;
    public LinearSystem c1 = new LinearSystem();
    public int d1;
    public int e1;
    public int f1;
    public int g1;
    public int h1 = 0;
    public int i1 = 0;
    public ChainHead[] j1 = new ChainHead[4];
    public ChainHead[] k1 = new ChainHead[4];
    public boolean l1 = false;
    public boolean m1 = false;
    public boolean n1 = false;
    public int o1 = 0;
    public int p1 = 0;
    public int q1 = 257;
    public boolean r1 = false;
    public boolean s1 = false;
    public boolean t1 = false;
    public int u1 = 0;
    public WeakReference v1 = null;
    public WeakReference w1 = null;
    public WeakReference x1 = null;
    public WeakReference y1 = null;
    public HashSet z1 = new HashSet();

    public static boolean X1(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, BasicMeasure.Measure measure, int i2) {
        int i3;
        int i4;
        if (measurer == null) {
            return false;
        }
        if (constraintWidget.X() == 8 || (constraintWidget instanceof Guideline) || (constraintWidget instanceof Barrier)) {
            measure.e = 0;
            measure.f = 0;
            return false;
        }
        measure.f536a = constraintWidget.C();
        measure.b = constraintWidget.V();
        measure.c = constraintWidget.Y();
        measure.d = constraintWidget.z();
        measure.i = false;
        measure.j = i2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.f536a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z = dimensionBehaviour == dimensionBehaviour2;
        boolean z2 = measure.b == dimensionBehaviour2;
        boolean z3 = z && constraintWidget.f0 > 0.0f;
        boolean z4 = z2 && constraintWidget.f0 > 0.0f;
        if (z && constraintWidget.c0(0) && constraintWidget.w == 0 && !z3) {
            measure.f536a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z2 && constraintWidget.x == 0) {
                measure.f536a = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z = false;
        }
        if (z2 && constraintWidget.c0(1) && constraintWidget.x == 0 && !z4) {
            measure.b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z && constraintWidget.w == 0) {
                measure.b = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z2 = false;
        }
        if (constraintWidget.p0()) {
            measure.f536a = ConstraintWidget.DimensionBehaviour.FIXED;
            z = false;
        }
        if (constraintWidget.q0()) {
            measure.b = ConstraintWidget.DimensionBehaviour.FIXED;
            z2 = false;
        }
        if (z3) {
            if (constraintWidget.y[0] == 4) {
                measure.f536a = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z2) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = measure.b;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour3 == dimensionBehaviour4) {
                    i4 = measure.d;
                } else {
                    measure.f536a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.b(constraintWidget, measure);
                    i4 = measure.f;
                }
                measure.f536a = dimensionBehaviour4;
                measure.c = (int) (constraintWidget.x() * ((float) i4));
            }
        }
        if (z4) {
            if (constraintWidget.y[1] == 4) {
                measure.b = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = measure.f536a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour5 == dimensionBehaviour6) {
                    i3 = measure.c;
                } else {
                    measure.b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.b(constraintWidget, measure);
                    i3 = measure.e;
                }
                measure.b = dimensionBehaviour6;
                if (constraintWidget.y() == -1) {
                    measure.d = (int) (((float) i3) / constraintWidget.x());
                } else {
                    measure.d = (int) (constraintWidget.x() * ((float) i3));
                }
            }
        }
        measurer.b(constraintWidget, measure);
        constraintWidget.o1(measure.e);
        constraintWidget.P0(measure.f);
        constraintWidget.O0(measure.h);
        constraintWidget.E0(measure.g);
        measure.j = BasicMeasure.Measure.k;
        return measure.i;
    }

    public boolean A1(LinearSystem linearSystem) {
        boolean Y1 = Y1(64);
        g(linearSystem, Y1);
        int size = this.V0.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.V0.get(i);
            constraintWidget.W0(0, false);
            constraintWidget.W0(1, false);
            if (constraintWidget instanceof Barrier) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) this.V0.get(i2);
                if (constraintWidget2 instanceof Barrier) {
                    ((Barrier) constraintWidget2).C1();
                }
            }
        }
        this.z1.clear();
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget3 = (ConstraintWidget) this.V0.get(i3);
            if (constraintWidget3.f()) {
                if (constraintWidget3 instanceof VirtualLayout) {
                    this.z1.add(constraintWidget3);
                } else {
                    constraintWidget3.g(linearSystem, Y1);
                }
            }
        }
        while (this.z1.size() > 0) {
            int size2 = this.z1.size();
            Iterator it = this.z1.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VirtualLayout virtualLayout = (VirtualLayout) ((ConstraintWidget) it.next());
                if (virtualLayout.z1(this.z1)) {
                    virtualLayout.g(linearSystem, Y1);
                    this.z1.remove(virtualLayout);
                    break;
                }
            }
            if (size2 == this.z1.size()) {
                Iterator it2 = this.z1.iterator();
                while (it2.hasNext()) {
                    ((ConstraintWidget) it2.next()).g(linearSystem, Y1);
                }
                this.z1.clear();
            }
        }
        if (LinearSystem.r) {
            HashSet hashSet = new HashSet();
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget4 = (ConstraintWidget) this.V0.get(i4);
                if (!constraintWidget4.f()) {
                    hashSet.add(constraintWidget4);
                }
            }
            e(this, linearSystem, hashSet, C() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1, false);
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                ConstraintWidget constraintWidget5 = (ConstraintWidget) it3.next();
                Optimizer.a(this, linearSystem, constraintWidget5);
                constraintWidget5.g(linearSystem, Y1);
            }
        } else {
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintWidget constraintWidget6 = (ConstraintWidget) this.V0.get(i5);
                if (constraintWidget6 instanceof ConstraintWidgetContainer) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget6.b0;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.T0(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.k1(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget6.g(linearSystem, Y1);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.T0(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.k1(dimensionBehaviour2);
                    }
                } else {
                    Optimizer.a(this, linearSystem, constraintWidget6);
                    if (!constraintWidget6.f()) {
                        constraintWidget6.g(linearSystem, Y1);
                    }
                }
            }
        }
        if (this.h1 > 0) {
            Chain.b(this, linearSystem, (ArrayList) null, 0);
        }
        if (this.i1 > 0) {
            Chain.b(this, linearSystem, (ArrayList) null, 1);
        }
        return true;
    }

    public final void B1(ConstraintWidget constraintWidget) {
        int i = this.h1 + 1;
        ChainHead[] chainHeadArr = this.k1;
        if (i >= chainHeadArr.length) {
            this.k1 = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.k1[this.h1] = new ChainHead(constraintWidget, 0, U1());
        this.h1++;
    }

    public void C1(ConstraintAnchor constraintAnchor) {
        WeakReference weakReference = this.y1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.y1.get()).e()) {
            this.y1 = new WeakReference(constraintAnchor);
        }
    }

    public void D1(ConstraintAnchor constraintAnchor) {
        WeakReference weakReference = this.w1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.w1.get()).e()) {
            this.w1 = new WeakReference(constraintAnchor);
        }
    }

    public final void E1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.c1.h(solverVariable, this.c1.q(constraintAnchor), 0, 5);
    }

    public final void F1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.c1.h(this.c1.q(constraintAnchor), solverVariable, 0, 5);
    }

    public final void G1(ConstraintWidget constraintWidget) {
        int i = this.i1 + 1;
        ChainHead[] chainHeadArr = this.j1;
        if (i >= chainHeadArr.length) {
            this.j1 = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.j1[this.i1] = new ChainHead(constraintWidget, 1, U1());
        this.i1++;
    }

    public void H1(ConstraintAnchor constraintAnchor) {
        WeakReference weakReference = this.x1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.x1.get()).e()) {
            this.x1 = new WeakReference(constraintAnchor);
        }
    }

    public void I1(ConstraintAnchor constraintAnchor) {
        WeakReference weakReference = this.v1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.v1.get()).e()) {
            this.v1 = new WeakReference(constraintAnchor);
        }
    }

    public boolean J1(boolean z) {
        return this.X0.f(z);
    }

    public boolean K1(boolean z) {
        return this.X0.g(z);
    }

    public boolean L1(boolean z, int i) {
        return this.X0.h(z, i);
    }

    public void M1(Metrics metrics) {
        this.b1 = metrics;
        this.c1.v(metrics);
    }

    public BasicMeasure.Measurer N1() {
        return this.Z0;
    }

    public int O1() {
        return this.q1;
    }

    public LinearSystem P1() {
        return this.c1;
    }

    public void Q(StringBuilder sb) {
        sb.append(this.o + ":{\n");
        sb.append("  actualWidth:" + this.d0);
        sb.append(StringUtils.LF);
        sb.append("  actualHeight:" + this.e0);
        sb.append(StringUtils.LF);
        Iterator it = v1().iterator();
        while (it.hasNext()) {
            ((ConstraintWidget) it.next()).Q(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }

    public boolean Q1() {
        return false;
    }

    public void R1() {
        this.X0.j();
    }

    public void S1() {
        this.X0.k();
    }

    public boolean T1() {
        return this.t1;
    }

    public boolean U1() {
        return this.a1;
    }

    public boolean V1() {
        return this.s1;
    }

    public long W1(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i8;
        this.d1 = i10;
        int i11 = i9;
        this.e1 = i11;
        return this.W0.d(this, i, i10, i11, i2, i3, i4, i5, i6, i7);
    }

    public boolean Y1(int i) {
        return (this.q1 & i) == i;
    }

    public final void Z1() {
        this.h1 = 0;
        this.i1 = 0;
    }

    public void a2(BasicMeasure.Measurer measurer) {
        this.Z0 = measurer;
        this.X0.n(measurer);
    }

    public void b2(int i) {
        this.q1 = i;
        LinearSystem.r = Y1(512);
    }

    public void c2(int i) {
        this.Y0 = i;
    }

    public void d2(boolean z) {
        this.a1 = z;
    }

    public boolean e2(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        boolean Y1 = Y1(64);
        u1(linearSystem, Y1);
        int size = this.V0.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.V0.get(i);
            constraintWidget.u1(linearSystem, Y1);
            if (constraintWidget.e0()) {
                z = true;
            }
        }
        return z;
    }

    public void f2() {
        this.W0.e(this);
    }

    public void t1(boolean z, boolean z2) {
        super.t1(z, z2);
        int size = this.V0.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.V0.get(i)).t1(z, z2);
        }
    }

    public void v0() {
        this.c1.E();
        this.d1 = 0;
        this.f1 = 0;
        this.e1 = 0;
        this.g1 = 0;
        this.r1 = false;
        super.v0();
    }

    /* JADX WARNING: type inference failed for: r6v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0319  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x031b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void w1() {
        /*
            r18 = this;
            r1 = r18
            r2 = 0
            r1.h0 = r2
            r1.i0 = r2
            r1.s1 = r2
            r1.t1 = r2
            java.util.ArrayList r0 = r1.V0
            int r3 = r0.size()
            int r0 = r18.Y()
            int r0 = java.lang.Math.max(r2, r0)
            int r4 = r18.z()
            int r4 = java.lang.Math.max(r2, r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r1.b0
            r6 = 1
            r7 = r5[r6]
            r5 = r5[r2]
            androidx.constraintlayout.core.Metrics r8 = r1.b1
            if (r8 == 0) goto L_0x0033
            long r9 = r8.D
            r11 = 1
            long r9 = r9 + r11
            r8.D = r9
        L_0x0033:
            int r8 = r1.Y0
            if (r8 != 0) goto L_0x008f
            int r8 = r1.q1
            boolean r8 = androidx.constraintlayout.core.widgets.Optimizer.b(r8, r6)
            if (r8 == 0) goto L_0x008f
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r8 = r18.N1()
            androidx.constraintlayout.core.widgets.analyzer.Direct.h(r1, r8)
            r8 = r2
        L_0x0047:
            if (r8 >= r3) goto L_0x008f
            java.util.ArrayList r9 = r1.V0
            java.lang.Object r9 = r9.get(r8)
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r9
            boolean r10 = r9.o0()
            if (r10 == 0) goto L_0x008c
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r10 != 0) goto L_0x008c
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r10 != 0) goto L_0x008c
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
            if (r10 != 0) goto L_0x008c
            boolean r10 = r9.n0()
            if (r10 != 0) goto L_0x008c
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = r9.w(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r9.w(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r10 != r12) goto L_0x0080
            int r10 = r9.w
            if (r10 == r6) goto L_0x0080
            if (r11 != r12) goto L_0x0080
            int r10 = r9.x
            if (r10 == r6) goto L_0x0080
            goto L_0x008c
        L_0x0080:
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r10 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r10.<init>()
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r11 = r1.Z0
            int r12 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.k
            X1(r2, r9, r11, r10, r12)
        L_0x008c:
            int r8 = r8 + 1
            goto L_0x0047
        L_0x008f:
            r8 = 2
            if (r3 <= r8) goto L_0x00d8
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 == r9) goto L_0x0098
            if (r7 != r9) goto L_0x00d8
        L_0x0098:
            int r10 = r1.q1
            r11 = 1024(0x400, float:1.435E-42)
            boolean r10 = androidx.constraintlayout.core.widgets.Optimizer.b(r10, r11)
            if (r10 == 0) goto L_0x00d8
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r10 = r18.N1()
            boolean r10 = androidx.constraintlayout.core.widgets.analyzer.Grouping.c(r1, r10)
            if (r10 == 0) goto L_0x00d8
            if (r5 != r9) goto L_0x00c0
            int r10 = r18.Y()
            if (r0 >= r10) goto L_0x00bc
            if (r0 <= 0) goto L_0x00bc
            r1.o1(r0)
            r1.s1 = r6
            goto L_0x00c0
        L_0x00bc:
            int r0 = r18.Y()
        L_0x00c0:
            if (r7 != r9) goto L_0x00d4
            int r9 = r18.z()
            if (r4 >= r9) goto L_0x00d0
            if (r4 <= 0) goto L_0x00d0
            r1.P0(r4)
            r1.t1 = r6
            goto L_0x00d4
        L_0x00d0:
            int r4 = r18.z()
        L_0x00d4:
            r9 = r4
            r4 = r0
            r0 = r6
            goto L_0x00db
        L_0x00d8:
            r9 = r4
            r4 = r0
            r0 = r2
        L_0x00db:
            r10 = 64
            boolean r11 = r1.Y1(r10)
            if (r11 != 0) goto L_0x00ee
            r11 = 128(0x80, float:1.794E-43)
            boolean r11 = r1.Y1(r11)
            if (r11 == 0) goto L_0x00ec
            goto L_0x00ee
        L_0x00ec:
            r11 = r2
            goto L_0x00ef
        L_0x00ee:
            r11 = r6
        L_0x00ef:
            androidx.constraintlayout.core.LinearSystem r12 = r1.c1
            r12.h = r2
            r12.i = r2
            int r13 = r1.q1
            if (r13 == 0) goto L_0x00fd
            if (r11 == 0) goto L_0x00fd
            r12.i = r6
        L_0x00fd:
            java.util.ArrayList r11 = r1.V0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r18.C()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r12 == r13) goto L_0x0110
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r18.V()
            if (r12 != r13) goto L_0x010e
            goto L_0x0110
        L_0x010e:
            r12 = r2
            goto L_0x0111
        L_0x0110:
            r12 = r6
        L_0x0111:
            r18.Z1()
            r13 = r2
        L_0x0115:
            if (r13 >= r3) goto L_0x012b
            java.util.ArrayList r14 = r1.V0
            java.lang.Object r14 = r14.get(r13)
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r14
            boolean r15 = r14 instanceof androidx.constraintlayout.core.widgets.WidgetContainer
            if (r15 == 0) goto L_0x0128
            androidx.constraintlayout.core.widgets.WidgetContainer r14 = (androidx.constraintlayout.core.widgets.WidgetContainer) r14
            r14.w1()
        L_0x0128:
            int r13 = r13 + 1
            goto L_0x0115
        L_0x012b:
            boolean r10 = r1.Y1(r10)
            r13 = r0
            r0 = r2
            r14 = r6
        L_0x0132:
            if (r14 == 0) goto L_0x0322
            int r15 = r0 + 1
            androidx.constraintlayout.core.LinearSystem r0 = r1.c1     // Catch:{ Exception -> 0x0158 }
            r0.E()     // Catch:{ Exception -> 0x0158 }
            r18.Z1()     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.LinearSystem r0 = r1.c1     // Catch:{ Exception -> 0x0158 }
            r1.o(r0)     // Catch:{ Exception -> 0x0158 }
            r0 = r2
        L_0x0144:
            if (r0 >= r3) goto L_0x015b
            java.util.ArrayList r6 = r1.V0     // Catch:{ Exception -> 0x0158 }
            java.lang.Object r6 = r6.get(r0)     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r6     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.LinearSystem r2 = r1.c1     // Catch:{ Exception -> 0x0158 }
            r6.o(r2)     // Catch:{ Exception -> 0x0158 }
            int r0 = r0 + 1
            r2 = 0
            r6 = 1
            goto L_0x0144
        L_0x0158:
            r0 = move-exception
            goto L_0x01e6
        L_0x015b:
            androidx.constraintlayout.core.LinearSystem r0 = r1.c1     // Catch:{ Exception -> 0x0158 }
            boolean r14 = r1.A1(r0)     // Catch:{ Exception -> 0x0158 }
            java.lang.ref.WeakReference r0 = r1.v1     // Catch:{ Exception -> 0x0158 }
            r2 = 0
            if (r0 == 0) goto L_0x0181
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0158 }
            if (r0 == 0) goto L_0x0181
            java.lang.ref.WeakReference r0 = r1.v1     // Catch:{ Exception -> 0x0158 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.c1     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.R     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.q(r8)     // Catch:{ Exception -> 0x0158 }
            r1.F1(r0, r6)     // Catch:{ Exception -> 0x0158 }
            r1.v1 = r2     // Catch:{ Exception -> 0x0158 }
        L_0x0181:
            java.lang.ref.WeakReference r0 = r1.x1     // Catch:{ Exception -> 0x0158 }
            if (r0 == 0) goto L_0x01a0
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0158 }
            if (r0 == 0) goto L_0x01a0
            java.lang.ref.WeakReference r0 = r1.x1     // Catch:{ Exception -> 0x0158 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.c1     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.T     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.q(r8)     // Catch:{ Exception -> 0x0158 }
            r1.E1(r0, r6)     // Catch:{ Exception -> 0x0158 }
            r1.x1 = r2     // Catch:{ Exception -> 0x0158 }
        L_0x01a0:
            java.lang.ref.WeakReference r0 = r1.w1     // Catch:{ Exception -> 0x0158 }
            if (r0 == 0) goto L_0x01bf
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0158 }
            if (r0 == 0) goto L_0x01bf
            java.lang.ref.WeakReference r0 = r1.w1     // Catch:{ Exception -> 0x0158 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.c1     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.Q     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.q(r8)     // Catch:{ Exception -> 0x0158 }
            r1.F1(r0, r6)     // Catch:{ Exception -> 0x0158 }
            r1.w1 = r2     // Catch:{ Exception -> 0x0158 }
        L_0x01bf:
            java.lang.ref.WeakReference r0 = r1.y1     // Catch:{ Exception -> 0x0158 }
            if (r0 == 0) goto L_0x01de
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0158 }
            if (r0 == 0) goto L_0x01de
            java.lang.ref.WeakReference r0 = r1.y1     // Catch:{ Exception -> 0x0158 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.c1     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.S     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.q(r8)     // Catch:{ Exception -> 0x0158 }
            r1.E1(r0, r6)     // Catch:{ Exception -> 0x0158 }
            r1.y1 = r2     // Catch:{ Exception -> 0x0158 }
        L_0x01de:
            if (r14 == 0) goto L_0x01ff
            androidx.constraintlayout.core.LinearSystem r0 = r1.c1     // Catch:{ Exception -> 0x0158 }
            r0.A()     // Catch:{ Exception -> 0x0158 }
            goto L_0x01ff
        L_0x01e6:
            r0.printStackTrace()
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "EXCEPTION : "
            r6.append(r8)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r2.println(r0)
        L_0x01ff:
            if (r14 == 0) goto L_0x020a
            androidx.constraintlayout.core.LinearSystem r0 = r1.c1
            boolean[] r2 = androidx.constraintlayout.core.widgets.Optimizer.f534a
            boolean r0 = r1.e2(r0, r2)
            goto L_0x0223
        L_0x020a:
            androidx.constraintlayout.core.LinearSystem r0 = r1.c1
            r1.u1(r0, r10)
            r0 = 0
        L_0x0210:
            if (r0 >= r3) goto L_0x0222
            java.util.ArrayList r2 = r1.V0
            java.lang.Object r2 = r2.get(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            androidx.constraintlayout.core.LinearSystem r6 = r1.c1
            r2.u1(r6, r10)
            int r0 = r0 + 1
            goto L_0x0210
        L_0x0222:
            r0 = 0
        L_0x0223:
            r2 = 8
            if (r12 == 0) goto L_0x0294
            if (r15 >= r2) goto L_0x0294
            boolean[] r6 = androidx.constraintlayout.core.widgets.Optimizer.f534a
            r8 = 2
            boolean r6 = r6[r8]
            if (r6 == 0) goto L_0x0294
            r6 = 0
            r8 = 0
            r14 = 0
        L_0x0233:
            if (r6 >= r3) goto L_0x025d
            java.util.ArrayList r2 = r1.V0
            java.lang.Object r2 = r2.get(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            r16 = r0
            int r0 = r2.h0
            int r17 = r2.Y()
            int r0 = r0 + r17
            int r14 = java.lang.Math.max(r14, r0)
            int r0 = r2.i0
            int r2 = r2.z()
            int r0 = r0 + r2
            int r8 = java.lang.Math.max(r8, r0)
            int r6 = r6 + 1
            r0 = r16
            r2 = 8
            goto L_0x0233
        L_0x025d:
            r16 = r0
            int r0 = r1.o0
            int r0 = java.lang.Math.max(r0, r14)
            int r2 = r1.p0
            int r2 = java.lang.Math.max(r2, r8)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 != r6) goto L_0x0280
            int r8 = r18.Y()
            if (r8 >= r0) goto L_0x0280
            r1.o1(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.b0
            r8 = 0
            r0[r8] = r6
            r13 = 1
            r16 = 1
        L_0x0280:
            if (r7 != r6) goto L_0x0296
            int r0 = r18.z()
            if (r0 >= r2) goto L_0x0296
            r1.P0(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.b0
            r2 = 1
            r0[r2] = r6
            r13 = 1
            r16 = 1
            goto L_0x0296
        L_0x0294:
            r16 = r0
        L_0x0296:
            int r0 = r1.o0
            int r2 = r18.Y()
            int r0 = java.lang.Math.max(r0, r2)
            int r2 = r18.Y()
            if (r0 <= r2) goto L_0x02b3
            r1.o1(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.b0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r6 = 0
            r0[r6] = r2
            r13 = 1
            r16 = 1
        L_0x02b3:
            int r0 = r1.p0
            int r2 = r18.z()
            int r0 = java.lang.Math.max(r0, r2)
            int r2 = r18.z()
            if (r0 <= r2) goto L_0x02d1
            r1.P0(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.b0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r6 = 1
            r0[r6] = r2
            r2 = r6
            r16 = r2
            goto L_0x02d3
        L_0x02d1:
            r6 = 1
            r2 = r13
        L_0x02d3:
            if (r2 != 0) goto L_0x0312
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.b0
            r8 = 0
            r0 = r0[r8]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r13) goto L_0x02f4
            if (r4 <= 0) goto L_0x02f4
            int r0 = r18.Y()
            if (r0 <= r4) goto L_0x02f4
            r1.s1 = r6
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.b0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r8] = r2
            r1.o1(r4)
            r2 = r6
            r16 = r2
        L_0x02f4:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.b0
            r0 = r0[r6]
            if (r0 != r13) goto L_0x0312
            if (r9 <= 0) goto L_0x0312
            int r0 = r18.z()
            if (r0 <= r9) goto L_0x0312
            r1.t1 = r6
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.b0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r6] = r2
            r1.P0(r9)
            r0 = 8
            r2 = 1
            r13 = 1
            goto L_0x0317
        L_0x0312:
            r13 = r2
            r2 = r16
            r0 = 8
        L_0x0317:
            if (r15 <= r0) goto L_0x031b
            r14 = 0
            goto L_0x031c
        L_0x031b:
            r14 = r2
        L_0x031c:
            r0 = r15
            r2 = 0
            r6 = 1
            r8 = 2
            goto L_0x0132
        L_0x0322:
            r1.V0 = r11
            if (r13 == 0) goto L_0x032e
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.b0
            r2 = 0
            r0[r2] = r5
            r2 = 1
            r0[r2] = r7
        L_0x032e:
            androidx.constraintlayout.core.LinearSystem r0 = r1.c1
            androidx.constraintlayout.core.Cache r0 = r0.w()
            r1.z0(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.w1():void");
    }

    public void z1(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            B1(constraintWidget);
        } else if (i == 1) {
            G1(constraintWidget);
        }
    }
}
