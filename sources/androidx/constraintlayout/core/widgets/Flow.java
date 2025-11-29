package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

public class Flow extends VirtualLayout {
    public int A1 = 0;
    public int B1 = -1;
    public int C1 = 0;
    public ArrayList D1 = new ArrayList();
    public ConstraintWidget[] E1 = null;
    public ConstraintWidget[] F1 = null;
    public int[] G1 = null;
    public ConstraintWidget[] H1;
    public int I1 = 0;
    public int k1 = -1;
    public int l1 = -1;
    public int m1 = -1;
    public int n1 = -1;
    public int o1 = -1;
    public int p1 = -1;
    public float q1 = 0.5f;
    public float r1 = 0.5f;
    public float s1 = 0.5f;
    public float t1 = 0.5f;
    public float u1 = 0.5f;
    public float v1 = 0.5f;
    public int w1 = 0;
    public int x1 = 0;
    public int y1 = 2;
    public int z1 = 2;

    public class WidgetsList {

        /* renamed from: a  reason: collision with root package name */
        public int f532a;
        public ConstraintWidget b = null;
        public int c = 0;
        public ConstraintAnchor d;
        public ConstraintAnchor e;
        public ConstraintAnchor f;
        public ConstraintAnchor g;
        public int h = 0;
        public int i = 0;
        public int j = 0;
        public int k = 0;
        public int l = 0;
        public int m = 0;
        public int n = 0;
        public int o = 0;
        public int p = 0;
        public int q = 0;

        public WidgetsList(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3) {
            this.f532a = i2;
            this.d = constraintAnchor;
            this.e = constraintAnchor2;
            this.f = constraintAnchor3;
            this.g = constraintAnchor4;
            this.h = Flow.this.D1();
            this.i = Flow.this.F1();
            this.j = Flow.this.E1();
            this.k = Flow.this.C1();
            this.q = i3;
        }

        public void b(ConstraintWidget constraintWidget) {
            int i2 = 0;
            if (this.f532a == 0) {
                int f2 = Flow.this.p2(constraintWidget, this.q);
                if (constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.p++;
                    f2 = 0;
                }
                int T1 = Flow.this.w1;
                if (constraintWidget.X() != 8) {
                    i2 = T1;
                }
                this.l += f2 + i2;
                int g2 = Flow.this.o2(constraintWidget, this.q);
                if (this.b == null || this.c < g2) {
                    this.b = constraintWidget;
                    this.c = g2;
                    this.m = g2;
                }
            } else {
                int f22 = Flow.this.p2(constraintWidget, this.q);
                int g22 = Flow.this.o2(constraintWidget, this.q);
                if (constraintWidget.V() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.p++;
                    g22 = 0;
                }
                int U1 = Flow.this.x1;
                if (constraintWidget.X() != 8) {
                    i2 = U1;
                }
                this.m += g22 + i2;
                if (this.b == null || this.c < f22) {
                    this.b = constraintWidget;
                    this.c = f22;
                    this.l = f22;
                }
            }
            this.o++;
        }

        public void c() {
            this.c = 0;
            this.b = null;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:57:0x00e1  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d(boolean r17, int r18, boolean r19) {
            /*
                r16 = this;
                r0 = r16
                int r1 = r0.o
                r2 = 0
                r3 = r2
            L_0x0006:
                if (r3 >= r1) goto L_0x0027
                int r4 = r0.n
                int r4 = r4 + r3
                androidx.constraintlayout.core.widgets.Flow r5 = androidx.constraintlayout.core.widgets.Flow.this
                int r5 = r5.I1
                if (r4 < r5) goto L_0x0014
                goto L_0x0027
            L_0x0014:
                androidx.constraintlayout.core.widgets.Flow r4 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r4 = r4.H1
                int r5 = r0.n
                int r5 = r5 + r3
                r4 = r4[r5]
                if (r4 == 0) goto L_0x0024
                r4.x0()
            L_0x0024:
                int r3 = r3 + 1
                goto L_0x0006
            L_0x0027:
                if (r1 == 0) goto L_0x0383
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.b
                if (r3 != 0) goto L_0x002f
                goto L_0x0383
            L_0x002f:
                if (r19 == 0) goto L_0x0035
                if (r18 != 0) goto L_0x0035
                r4 = 1
                goto L_0x0036
            L_0x0035:
                r4 = r2
            L_0x0036:
                r5 = -1
                r6 = r2
                r7 = r5
                r8 = r7
            L_0x003a:
                if (r6 >= r1) goto L_0x0069
                if (r17 == 0) goto L_0x0042
                int r9 = r1 + -1
                int r9 = r9 - r6
                goto L_0x0043
            L_0x0042:
                r9 = r6
            L_0x0043:
                int r10 = r0.n
                int r10 = r10 + r9
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.I1
                if (r10 < r11) goto L_0x004f
                goto L_0x0069
            L_0x004f:
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r10 = r10.H1
                int r11 = r0.n
                int r11 = r11 + r9
                r9 = r10[r11]
                if (r9 == 0) goto L_0x0066
                int r9 = r9.X()
                if (r9 != 0) goto L_0x0066
                if (r7 != r5) goto L_0x0065
                r7 = r6
            L_0x0065:
                r8 = r6
            L_0x0066:
                int r6 = r6 + 1
                goto L_0x003a
            L_0x0069:
                int r6 = r0.f532a
                r9 = 0
                if (r6 != 0) goto L_0x020e
                androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r0.b
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                int r10 = r10.l1
                r6.i1(r10)
                int r10 = r0.i
                if (r18 <= 0) goto L_0x0084
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.x1
                int r10 = r10 + r11
            L_0x0084:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.e
                r11.a(r12, r10)
                if (r19 == 0) goto L_0x0096
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r6.T
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.g
                int r12 = r0.k
                r10.a(r11, r12)
            L_0x0096:
                if (r18 <= 0) goto L_0x00a3
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.e
                androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r10.d
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.T
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.R
                r10.a(r11, r2)
            L_0x00a3:
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                int r10 = r10.z1
                r11 = 3
                if (r10 != r11) goto L_0x00dd
                boolean r10 = r6.b0()
                if (r10 != 0) goto L_0x00dd
                r10 = r2
            L_0x00b3:
                if (r10 >= r1) goto L_0x00dd
                if (r17 == 0) goto L_0x00bb
                int r12 = r1 + -1
                int r12 = r12 - r10
                goto L_0x00bc
            L_0x00bb:
                r12 = r10
            L_0x00bc:
                int r13 = r0.n
                int r13 = r13 + r12
                androidx.constraintlayout.core.widgets.Flow r14 = androidx.constraintlayout.core.widgets.Flow.this
                int r14 = r14.I1
                if (r13 < r14) goto L_0x00c8
                goto L_0x00dd
            L_0x00c8:
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r13 = r13.H1
                int r14 = r0.n
                int r14 = r14 + r12
                r12 = r13[r14]
                boolean r13 = r12.b0()
                if (r13 == 0) goto L_0x00da
                goto L_0x00de
            L_0x00da:
                int r10 = r10 + 1
                goto L_0x00b3
            L_0x00dd:
                r12 = r6
            L_0x00de:
                r10 = r2
            L_0x00df:
                if (r10 >= r1) goto L_0x0383
                if (r17 == 0) goto L_0x00e7
                int r13 = r1 + -1
                int r13 = r13 - r10
                goto L_0x00e8
            L_0x00e7:
                r13 = r10
            L_0x00e8:
                int r14 = r0.n
                int r14 = r14 + r13
                androidx.constraintlayout.core.widgets.Flow r15 = androidx.constraintlayout.core.widgets.Flow.this
                int r15 = r15.I1
                if (r14 < r15) goto L_0x00f5
                goto L_0x0383
            L_0x00f5:
                androidx.constraintlayout.core.widgets.Flow r14 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r14 = r14.H1
                int r15 = r0.n
                int r15 = r15 + r13
                r14 = r14[r15]
                if (r14 != 0) goto L_0x0106
                r14 = r9
                r9 = r11
                goto L_0x0208
            L_0x0106:
                if (r10 != 0) goto L_0x0111
                androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r14.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.d
                int r3 = r0.h
                r14.l(r15, r11, r3)
            L_0x0111:
                if (r13 != 0) goto L_0x016f
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.k1
                r11 = 1065353216(0x3f800000, float:1.0)
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                float r13 = r13.q1
                if (r17 == 0) goto L_0x0125
                float r13 = r11 - r13
            L_0x0125:
                int r15 = r0.n
                if (r15 != 0) goto L_0x0149
                androidx.constraintlayout.core.widgets.Flow r15 = androidx.constraintlayout.core.widgets.Flow.this
                int r15 = r15.m1
                if (r15 == r5) goto L_0x0149
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.m1
                if (r17 == 0) goto L_0x0142
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                float r13 = r13.s1
            L_0x013f:
                float r11 = r11 - r13
            L_0x0140:
                r13 = r11
                goto L_0x0169
            L_0x0142:
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                float r11 = r11.s1
                goto L_0x0140
            L_0x0149:
                if (r19 == 0) goto L_0x0169
                androidx.constraintlayout.core.widgets.Flow r15 = androidx.constraintlayout.core.widgets.Flow.this
                int r15 = r15.o1
                if (r15 == r5) goto L_0x0169
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.o1
                if (r17 == 0) goto L_0x0162
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                float r13 = r13.u1
                goto L_0x013f
            L_0x0162:
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                float r11 = r11.u1
                goto L_0x0140
            L_0x0169:
                r14.R0(r3)
                r14.Q0(r13)
            L_0x016f:
                int r3 = r1 + -1
                if (r10 != r3) goto L_0x017c
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f
                int r13 = r0.j
                r14.l(r3, r11, r13)
            L_0x017c:
                if (r9 == 0) goto L_0x01a7
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.S
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.w1
                r3.a(r11, r13)
                if (r10 != r7) goto L_0x0194
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.Q
                int r11 = r0.h
                r3.u(r11)
            L_0x0194:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r9.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r14.Q
                r3.a(r11, r2)
                r3 = 1
                int r11 = r8 + 1
                if (r10 != r11) goto L_0x01a7
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r9.S
                int r9 = r0.j
                r3.u(r9)
            L_0x01a7:
                if (r14 == r6) goto L_0x0207
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.z1
                r9 = 3
                if (r3 != r9) goto L_0x01c8
                boolean r3 = r12.b0()
                if (r3 == 0) goto L_0x01c8
                if (r14 == r12) goto L_0x01c8
                boolean r3 = r14.b0()
                if (r3 == 0) goto L_0x01c8
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.U
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.U
                r3.a(r11, r2)
                goto L_0x0208
            L_0x01c8:
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.z1
                if (r3 == 0) goto L_0x01ff
                r11 = 1
                if (r3 == r11) goto L_0x01f7
                if (r4 == 0) goto L_0x01e8
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.e
                int r13 = r0.i
                r3.a(r11, r13)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.T
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.g
                int r13 = r0.k
                r3.a(r11, r13)
                goto L_0x0208
            L_0x01e8:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.R
                r3.a(r11, r2)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.T
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.T
                r3.a(r11, r2)
                goto L_0x0208
            L_0x01f7:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.T
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.T
                r3.a(r11, r2)
                goto L_0x0208
            L_0x01ff:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.R
                r3.a(r11, r2)
                goto L_0x0208
            L_0x0207:
                r9 = 3
            L_0x0208:
                int r10 = r10 + 1
                r11 = r9
                r9 = r14
                goto L_0x00df
            L_0x020e:
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.b
                androidx.constraintlayout.core.widgets.Flow r6 = androidx.constraintlayout.core.widgets.Flow.this
                int r6 = r6.k1
                r3.R0(r6)
                int r6 = r0.h
                if (r18 <= 0) goto L_0x0224
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                int r10 = r10.w1
                int r6 = r6 + r10
            L_0x0224:
                if (r17 == 0) goto L_0x0246
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f
                r10.a(r11, r6)
                if (r19 == 0) goto L_0x0238
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.d
                int r11 = r0.j
                r6.a(r10, r11)
            L_0x0238:
                if (r18 <= 0) goto L_0x0265
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r0.f
                androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r6.d
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.S
                r6.a(r10, r2)
                goto L_0x0265
            L_0x0246:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.d
                r10.a(r11, r6)
                if (r19 == 0) goto L_0x0258
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.f
                int r11 = r0.j
                r6.a(r10, r11)
            L_0x0258:
                if (r18 <= 0) goto L_0x0265
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r0.d
                androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r6.d
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.Q
                r6.a(r10, r2)
            L_0x0265:
                r6 = r2
            L_0x0266:
                if (r6 >= r1) goto L_0x0383
                int r10 = r0.n
                int r10 = r10 + r6
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.I1
                if (r10 < r11) goto L_0x0275
                goto L_0x0383
            L_0x0275:
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r10 = r10.H1
                int r11 = r0.n
                int r11 = r11 + r6
                r10 = r10[r11]
                if (r10 != 0) goto L_0x0285
                r12 = 1
                goto L_0x037f
            L_0x0285:
                if (r6 != 0) goto L_0x02d1
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.e
                int r13 = r0.i
                r10.l(r11, r12, r13)
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.l1
                androidx.constraintlayout.core.widgets.Flow r12 = androidx.constraintlayout.core.widgets.Flow.this
                float r12 = r12.r1
                int r13 = r0.n
                if (r13 != 0) goto L_0x02b5
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.n1
                if (r13 == r5) goto L_0x02b5
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.n1
                androidx.constraintlayout.core.widgets.Flow r12 = androidx.constraintlayout.core.widgets.Flow.this
                float r12 = r12.t1
                goto L_0x02cb
            L_0x02b5:
                if (r19 == 0) goto L_0x02cb
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.p1
                if (r13 == r5) goto L_0x02cb
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.p1
                androidx.constraintlayout.core.widgets.Flow r12 = androidx.constraintlayout.core.widgets.Flow.this
                float r12 = r12.v1
            L_0x02cb:
                r10.i1(r11)
                r10.h1(r12)
            L_0x02d1:
                int r11 = r1 + -1
                if (r6 != r11) goto L_0x02de
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.T
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.g
                int r13 = r0.k
                r10.l(r11, r12, r13)
            L_0x02de:
                if (r9 == 0) goto L_0x0309
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r9.T
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.x1
                r11.a(r12, r13)
                if (r6 != r7) goto L_0x02f6
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.R
                int r12 = r0.i
                r11.u(r12)
            L_0x02f6:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.T
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r10.R
                r11.a(r12, r2)
                r11 = 1
                int r12 = r8 + 1
                if (r6 != r12) goto L_0x0309
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.T
                int r11 = r0.k
                r9.u(r11)
            L_0x0309:
                if (r10 == r3) goto L_0x033a
                r9 = 2
                if (r17 == 0) goto L_0x033c
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.y1
                if (r11 == 0) goto L_0x0333
                r12 = 1
                if (r11 == r12) goto L_0x032b
                if (r11 == r9) goto L_0x031c
                goto L_0x033a
            L_0x031c:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.Q
                r9.a(r11, r2)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.S
                r9.a(r11, r2)
                goto L_0x033a
            L_0x032b:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.Q
                r9.a(r11, r2)
                goto L_0x033a
            L_0x0333:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.S
                r9.a(r11, r2)
            L_0x033a:
                r12 = 1
                goto L_0x037e
            L_0x033c:
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.y1
                if (r11 == 0) goto L_0x0376
                r12 = 1
                if (r11 == r12) goto L_0x036e
                if (r11 == r9) goto L_0x034a
                goto L_0x037e
            L_0x034a:
                if (r4 == 0) goto L_0x035f
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.d
                int r13 = r0.h
                r9.a(r11, r13)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f
                int r13 = r0.j
                r9.a(r11, r13)
                goto L_0x037e
            L_0x035f:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.Q
                r9.a(r11, r2)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.S
                r9.a(r11, r2)
                goto L_0x037e
            L_0x036e:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.S
                r9.a(r11, r2)
                goto L_0x037e
            L_0x0376:
                r12 = 1
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.Q
                r9.a(r11, r2)
            L_0x037e:
                r9 = r10
            L_0x037f:
                int r6 = r6 + 1
                goto L_0x0266
            L_0x0383:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.WidgetsList.d(boolean, int, boolean):void");
        }

        public int e() {
            return this.f532a == 1 ? this.m - Flow.this.x1 : this.m;
        }

        public int f() {
            return this.f532a == 0 ? this.l - Flow.this.w1 : this.l;
        }

        public void g(int i2) {
            int i3 = this.p;
            if (i3 != 0) {
                int i4 = this.o;
                int i5 = i2 / i3;
                int i6 = 0;
                while (i6 < i4 && this.n + i6 < Flow.this.I1) {
                    ConstraintWidget constraintWidget = Flow.this.H1[this.n + i6];
                    if (this.f532a == 0) {
                        if (constraintWidget != null && constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.w == 0) {
                            Flow.this.H1(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i5, constraintWidget.V(), constraintWidget.z());
                        }
                    } else if (constraintWidget != null && constraintWidget.V() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.x == 0) {
                        Flow.this.H1(constraintWidget, constraintWidget.C(), constraintWidget.Y(), ConstraintWidget.DimensionBehaviour.FIXED, i5);
                    }
                    i6++;
                }
                h();
            }
        }

        public final void h() {
            this.l = 0;
            this.m = 0;
            this.b = null;
            this.c = 0;
            int i2 = this.o;
            int i3 = 0;
            while (i3 < i2 && this.n + i3 < Flow.this.I1) {
                ConstraintWidget constraintWidget = Flow.this.H1[this.n + i3];
                if (this.f532a == 0) {
                    int Y = constraintWidget.Y();
                    int T1 = Flow.this.w1;
                    if (constraintWidget.X() == 8) {
                        T1 = 0;
                    }
                    this.l += Y + T1;
                    int g2 = Flow.this.o2(constraintWidget, this.q);
                    if (this.b == null || this.c < g2) {
                        this.b = constraintWidget;
                        this.c = g2;
                        this.m = g2;
                    }
                } else {
                    int f2 = Flow.this.p2(constraintWidget, this.q);
                    int g22 = Flow.this.o2(constraintWidget, this.q);
                    int U1 = Flow.this.x1;
                    if (constraintWidget.X() == 8) {
                        U1 = 0;
                    }
                    this.m += g22 + U1;
                    if (this.b == null || this.c < f2) {
                        this.b = constraintWidget;
                        this.c = f2;
                        this.l = f2;
                    }
                }
                i3++;
            }
        }

        public void i(int i2) {
            this.n = i2;
        }

        public void j(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3, int i4, int i5, int i6, int i7) {
            this.f532a = i2;
            this.d = constraintAnchor;
            this.e = constraintAnchor2;
            this.f = constraintAnchor3;
            this.g = constraintAnchor4;
            this.h = i3;
            this.i = i4;
            this.j = i5;
            this.k = i6;
            this.q = i7;
        }
    }

    public void A2(int i) {
        this.w1 = i;
    }

    public void B2(int i) {
        this.k1 = i;
    }

    public void C2(float f) {
        this.u1 = f;
    }

    public void D2(int i) {
        this.o1 = i;
    }

    public void E2(float f) {
        this.v1 = f;
    }

    public void F2(int i) {
        this.p1 = i;
    }

    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r11v6 */
    /* JADX WARNING: type inference failed for: r11v7 */
    /* JADX WARNING: type inference failed for: r11v8 */
    /* JADX WARNING: type inference failed for: r11v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void G1(int r19, int r20, int r21, int r22) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            int r0 = r6.W0
            r11 = 0
            if (r0 <= 0) goto L_0x001c
            boolean r0 = r18.I1()
            if (r0 != 0) goto L_0x001c
            r6.L1(r11, r11)
            r6.K1(r11)
            return
        L_0x001c:
            int r12 = r18.D1()
            int r13 = r18.E1()
            int r14 = r18.F1()
            int r15 = r18.C1()
            r0 = 2
            int[] r5 = new int[r0]
            int r1 = r8 - r12
            int r1 = r1 - r13
            int r2 = r6.C1
            r4 = 1
            if (r2 != r4) goto L_0x003a
            int r1 = r10 - r14
            int r1 = r1 - r15
        L_0x003a:
            r16 = r1
            r1 = -1
            if (r2 != 0) goto L_0x004c
            int r2 = r6.k1
            if (r2 != r1) goto L_0x0045
            r6.k1 = r11
        L_0x0045:
            int r2 = r6.l1
            if (r2 != r1) goto L_0x0058
            r6.l1 = r11
            goto L_0x0058
        L_0x004c:
            int r2 = r6.k1
            if (r2 != r1) goto L_0x0052
            r6.k1 = r11
        L_0x0052:
            int r2 = r6.l1
            if (r2 != r1) goto L_0x0058
            r6.l1 = r11
        L_0x0058:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = r6.V0
            r2 = r11
            r3 = r2
        L_0x005c:
            int r11 = r6.W0
            r0 = 8
            if (r2 >= r11) goto L_0x0072
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r11 = r6.V0
            r11 = r11[r2]
            int r11 = r11.X()
            if (r11 != r0) goto L_0x006e
            int r3 = r3 + 1
        L_0x006e:
            int r2 = r2 + 1
            r0 = 2
            goto L_0x005c
        L_0x0072:
            if (r3 <= 0) goto L_0x0091
            int r11 = r11 - r3
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r11]
            r2 = 0
            r3 = 0
        L_0x0079:
            int r11 = r6.W0
            if (r2 >= r11) goto L_0x008f
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r11 = r6.V0
            r11 = r11[r2]
            int r4 = r11.X()
            if (r4 == r0) goto L_0x008b
            r1[r3] = r11
            int r3 = r3 + 1
        L_0x008b:
            int r2 = r2 + 1
            r4 = 1
            goto L_0x0079
        L_0x008f:
            r2 = r3
            goto L_0x0092
        L_0x0091:
            r2 = r11
        L_0x0092:
            r6.H1 = r1
            r6.I1 = r2
            int r0 = r6.A1
            if (r0 == 0) goto L_0x00cf
            r4 = 1
            if (r0 == r4) goto L_0x00c2
            r3 = 2
            if (r0 == r3) goto L_0x00b5
            r3 = 3
            if (r0 == r3) goto L_0x00a8
            r11 = r4
            r17 = r5
        L_0x00a6:
            r0 = 0
            goto L_0x00dc
        L_0x00a8:
            int r3 = r6.C1
            r0 = r18
            r11 = r4
            r4 = r16
            r17 = r5
            r0.s2(r1, r2, r3, r4, r5)
            goto L_0x00a6
        L_0x00b5:
            r11 = r4
            r17 = r5
            int r3 = r6.C1
            r0 = r18
            r4 = r16
            r0.q2(r1, r2, r3, r4, r5)
            goto L_0x00a6
        L_0x00c2:
            r11 = r4
            r17 = r5
            int r3 = r6.C1
            r0 = r18
            r4 = r16
            r0.r2(r1, r2, r3, r4, r5)
            goto L_0x00a6
        L_0x00cf:
            r17 = r5
            r11 = 1
            int r3 = r6.C1
            r0 = r18
            r4 = r16
            r0.t2(r1, r2, r3, r4, r5)
            goto L_0x00a6
        L_0x00dc:
            r1 = r17[r0]
            int r1 = r1 + r12
            int r1 = r1 + r13
            r2 = r17[r11]
            int r2 = r2 + r14
            int r2 = r2 + r15
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 1073741824(0x40000000, float:2.0)
            if (r7 != r4) goto L_0x00ec
            r1 = r8
            goto L_0x00f7
        L_0x00ec:
            if (r7 != r3) goto L_0x00f3
            int r1 = java.lang.Math.min(r1, r8)
            goto L_0x00f7
        L_0x00f3:
            if (r7 != 0) goto L_0x00f6
            goto L_0x00f7
        L_0x00f6:
            r1 = r0
        L_0x00f7:
            if (r9 != r4) goto L_0x00fb
            r2 = r10
            goto L_0x0106
        L_0x00fb:
            if (r9 != r3) goto L_0x0102
            int r2 = java.lang.Math.min(r2, r10)
            goto L_0x0106
        L_0x0102:
            if (r9 != 0) goto L_0x0105
            goto L_0x0106
        L_0x0105:
            r2 = r0
        L_0x0106:
            r6.L1(r1, r2)
            r6.o1(r1)
            r6.P0(r2)
            int r1 = r6.W0
            if (r1 <= 0) goto L_0x0114
            goto L_0x0115
        L_0x0114:
            r11 = r0
        L_0x0115:
            r6.K1(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.G1(int, int, int, int):void");
    }

    public void G2(int i) {
        this.B1 = i;
    }

    public void H2(int i) {
        this.C1 = i;
    }

    public void I2(int i) {
        this.z1 = i;
    }

    public void J2(float f) {
        this.r1 = f;
    }

    public void K2(int i) {
        this.x1 = i;
    }

    public void L2(int i) {
        this.l1 = i;
    }

    public void M2(int i) {
        this.A1 = i;
    }

    public void g(LinearSystem linearSystem, boolean z) {
        super.g(linearSystem, z);
        boolean z2 = M() != null && ((ConstraintWidgetContainer) M()).U1();
        int i = this.A1;
        if (i != 0) {
            if (i == 1) {
                int size = this.D1.size();
                int i2 = 0;
                while (i2 < size) {
                    ((WidgetsList) this.D1.get(i2)).d(z2, i2, i2 == size + -1);
                    i2++;
                }
            } else if (i == 2) {
                n2(z2);
            } else if (i == 3) {
                int size2 = this.D1.size();
                int i3 = 0;
                while (i3 < size2) {
                    ((WidgetsList) this.D1.get(i3)).d(z2, i3, i3 == size2 + -1);
                    i3++;
                }
            }
        } else if (this.D1.size() > 0) {
            ((WidgetsList) this.D1.get(0)).d(z2, 0, true);
        }
        K1(false);
    }

    public void n(ConstraintWidget constraintWidget, HashMap hashMap) {
        super.n(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.k1 = flow.k1;
        this.l1 = flow.l1;
        this.m1 = flow.m1;
        this.n1 = flow.n1;
        this.o1 = flow.o1;
        this.p1 = flow.p1;
        this.q1 = flow.q1;
        this.r1 = flow.r1;
        this.s1 = flow.s1;
        this.t1 = flow.t1;
        this.u1 = flow.u1;
        this.v1 = flow.v1;
        this.w1 = flow.w1;
        this.x1 = flow.x1;
        this.y1 = flow.y1;
        this.z1 = flow.z1;
        this.A1 = flow.A1;
        this.B1 = flow.B1;
        this.C1 = flow.C1;
    }

    public final void n2(boolean z) {
        ConstraintWidget constraintWidget;
        float f;
        int i;
        if (this.G1 != null && this.F1 != null && this.E1 != null) {
            for (int i2 = 0; i2 < this.I1; i2++) {
                this.H1[i2].x0();
            }
            int[] iArr = this.G1;
            int i3 = iArr[0];
            int i4 = iArr[1];
            float f2 = this.q1;
            ConstraintWidget constraintWidget2 = null;
            int i5 = 0;
            while (i5 < i3) {
                if (z) {
                    i = (i3 - i5) - 1;
                    f = 1.0f - this.q1;
                } else {
                    f = f2;
                    i = i5;
                }
                ConstraintWidget constraintWidget3 = this.F1[i];
                if (!(constraintWidget3 == null || constraintWidget3.X() == 8)) {
                    if (i5 == 0) {
                        constraintWidget3.l(constraintWidget3.Q, this.Q, D1());
                        constraintWidget3.R0(this.k1);
                        constraintWidget3.Q0(f);
                    }
                    if (i5 == i3 - 1) {
                        constraintWidget3.l(constraintWidget3.S, this.S, E1());
                    }
                    if (i5 > 0 && constraintWidget2 != null) {
                        constraintWidget3.l(constraintWidget3.Q, constraintWidget2.S, this.w1);
                        constraintWidget2.l(constraintWidget2.S, constraintWidget3.Q, 0);
                    }
                    constraintWidget2 = constraintWidget3;
                }
                i5++;
                f2 = f;
            }
            for (int i6 = 0; i6 < i4; i6++) {
                ConstraintWidget constraintWidget4 = this.E1[i6];
                if (!(constraintWidget4 == null || constraintWidget4.X() == 8)) {
                    if (i6 == 0) {
                        constraintWidget4.l(constraintWidget4.R, this.R, F1());
                        constraintWidget4.i1(this.l1);
                        constraintWidget4.h1(this.r1);
                    }
                    if (i6 == i4 - 1) {
                        constraintWidget4.l(constraintWidget4.T, this.T, C1());
                    }
                    if (i6 > 0 && constraintWidget2 != null) {
                        constraintWidget4.l(constraintWidget4.R, constraintWidget2.T, this.x1);
                        constraintWidget2.l(constraintWidget2.T, constraintWidget4.R, 0);
                    }
                    constraintWidget2 = constraintWidget4;
                }
            }
            for (int i7 = 0; i7 < i3; i7++) {
                for (int i8 = 0; i8 < i4; i8++) {
                    int i9 = (i8 * i3) + i7;
                    if (this.C1 == 1) {
                        i9 = (i7 * i4) + i8;
                    }
                    ConstraintWidget[] constraintWidgetArr = this.H1;
                    if (!(i9 >= constraintWidgetArr.length || (constraintWidget = constraintWidgetArr[i9]) == null || constraintWidget.X() == 8)) {
                        ConstraintWidget constraintWidget5 = this.F1[i7];
                        ConstraintWidget constraintWidget6 = this.E1[i8];
                        if (constraintWidget != constraintWidget5) {
                            constraintWidget.l(constraintWidget.Q, constraintWidget5.Q, 0);
                            constraintWidget.l(constraintWidget.S, constraintWidget5.S, 0);
                        }
                        if (constraintWidget != constraintWidget6) {
                            constraintWidget.l(constraintWidget.R, constraintWidget6.R, 0);
                            constraintWidget.l(constraintWidget.T, constraintWidget6.T, 0);
                        }
                    }
                }
            }
        }
    }

    public final int o2(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.V() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i2 = constraintWidget.x;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (constraintWidget.E * ((float) i));
                if (i3 != constraintWidget.z()) {
                    constraintWidget.c1(true);
                    H1(constraintWidget, constraintWidget.C(), constraintWidget.Y(), ConstraintWidget.DimensionBehaviour.FIXED, i3);
                }
                return i3;
            } else if (i2 == 1) {
                return constraintWidget.z();
            } else {
                if (i2 == 3) {
                    return (int) ((((float) constraintWidget.Y()) * constraintWidget.f0) + 0.5f);
                }
            }
        }
        return constraintWidget.z();
    }

    public final int p2(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i2 = constraintWidget.w;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (constraintWidget.B * ((float) i));
                if (i3 != constraintWidget.Y()) {
                    constraintWidget.c1(true);
                    H1(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i3, constraintWidget.V(), constraintWidget.z());
                }
                return i3;
            } else if (i2 == 1) {
                return constraintWidget.Y();
            } else {
                if (i2 == 3) {
                    return (int) ((((float) constraintWidget.z()) * constraintWidget.f0) + 0.5f);
                }
            }
        }
        return constraintWidget.Y();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x011d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005e  */
    public final void q2(androidx.constraintlayout.core.widgets.ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            r10 = this;
            r0 = 0
            if (r13 != 0) goto L_0x0026
            int r1 = r10.B1
            if (r1 > 0) goto L_0x0023
            r1 = r0
            r2 = r1
            r3 = r2
        L_0x000a:
            if (r2 >= r12) goto L_0x0023
            if (r2 <= 0) goto L_0x0011
            int r4 = r10.w1
            int r3 = r3 + r4
        L_0x0011:
            r4 = r11[r2]
            if (r4 != 0) goto L_0x0016
            goto L_0x0020
        L_0x0016:
            int r4 = r10.p2(r4, r14)
            int r3 = r3 + r4
            if (r3 <= r14) goto L_0x001e
            goto L_0x0023
        L_0x001e:
            int r1 = r1 + 1
        L_0x0020:
            int r2 = r2 + 1
            goto L_0x000a
        L_0x0023:
            r2 = r1
            r1 = r0
            goto L_0x0047
        L_0x0026:
            int r1 = r10.B1
            if (r1 > 0) goto L_0x0046
            r1 = r0
            r2 = r1
            r3 = r2
        L_0x002d:
            if (r2 >= r12) goto L_0x0046
            if (r2 <= 0) goto L_0x0034
            int r4 = r10.x1
            int r3 = r3 + r4
        L_0x0034:
            r4 = r11[r2]
            if (r4 != 0) goto L_0x0039
            goto L_0x0043
        L_0x0039:
            int r4 = r10.o2(r4, r14)
            int r3 = r3 + r4
            if (r3 <= r14) goto L_0x0041
            goto L_0x0046
        L_0x0041:
            int r1 = r1 + 1
        L_0x0043:
            int r2 = r2 + 1
            goto L_0x002d
        L_0x0046:
            r2 = r0
        L_0x0047:
            int[] r3 = r10.G1
            if (r3 != 0) goto L_0x0050
            r3 = 2
            int[] r3 = new int[r3]
            r10.G1 = r3
        L_0x0050:
            r3 = 1
            if (r1 != 0) goto L_0x0055
            if (r13 == r3) goto L_0x0059
        L_0x0055:
            if (r2 != 0) goto L_0x005b
            if (r13 != 0) goto L_0x005b
        L_0x0059:
            r4 = r3
            goto L_0x005c
        L_0x005b:
            r4 = r0
        L_0x005c:
            if (r4 != 0) goto L_0x011d
            if (r13 != 0) goto L_0x006a
            float r1 = (float) r12
            float r5 = (float) r2
            float r1 = r1 / r5
            double r5 = (double) r1
            double r5 = java.lang.Math.ceil(r5)
            int r1 = (int) r5
            goto L_0x0073
        L_0x006a:
            float r2 = (float) r12
            float r5 = (float) r1
            float r2 = r2 / r5
            double r5 = (double) r2
            double r5 = java.lang.Math.ceil(r5)
            int r2 = (int) r5
        L_0x0073:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = r10.F1
            r6 = 0
            if (r5 == 0) goto L_0x0080
            int r7 = r5.length
            if (r7 >= r2) goto L_0x007c
            goto L_0x0080
        L_0x007c:
            java.util.Arrays.fill(r5, r6)
            goto L_0x0084
        L_0x0080:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r2]
            r10.F1 = r5
        L_0x0084:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = r10.E1
            if (r5 == 0) goto L_0x0090
            int r7 = r5.length
            if (r7 >= r1) goto L_0x008c
            goto L_0x0090
        L_0x008c:
            java.util.Arrays.fill(r5, r6)
            goto L_0x0094
        L_0x0090:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r1]
            r10.E1 = r5
        L_0x0094:
            r5 = r0
        L_0x0095:
            if (r5 >= r2) goto L_0x00d9
            r6 = r0
        L_0x0098:
            if (r6 >= r1) goto L_0x00d6
            int r7 = r6 * r2
            int r7 = r7 + r5
            if (r13 != r3) goto L_0x00a2
            int r7 = r5 * r1
            int r7 = r7 + r6
        L_0x00a2:
            int r8 = r11.length
            if (r7 < r8) goto L_0x00a6
            goto L_0x00d3
        L_0x00a6:
            r7 = r11[r7]
            if (r7 != 0) goto L_0x00ab
            goto L_0x00d3
        L_0x00ab:
            int r8 = r10.p2(r7, r14)
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r9 = r10.F1
            r9 = r9[r5]
            if (r9 == 0) goto L_0x00bb
            int r9 = r9.Y()
            if (r9 >= r8) goto L_0x00bf
        L_0x00bb:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r8 = r10.F1
            r8[r5] = r7
        L_0x00bf:
            int r8 = r10.o2(r7, r14)
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r9 = r10.E1
            r9 = r9[r6]
            if (r9 == 0) goto L_0x00cf
            int r9 = r9.z()
            if (r9 >= r8) goto L_0x00d3
        L_0x00cf:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r8 = r10.E1
            r8[r6] = r7
        L_0x00d3:
            int r6 = r6 + 1
            goto L_0x0098
        L_0x00d6:
            int r5 = r5 + 1
            goto L_0x0095
        L_0x00d9:
            r5 = r0
            r6 = r5
        L_0x00db:
            if (r5 >= r2) goto L_0x00f0
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r7 = r10.F1
            r7 = r7[r5]
            if (r7 == 0) goto L_0x00ed
            if (r5 <= 0) goto L_0x00e8
            int r8 = r10.w1
            int r6 = r6 + r8
        L_0x00e8:
            int r7 = r10.p2(r7, r14)
            int r6 = r6 + r7
        L_0x00ed:
            int r5 = r5 + 1
            goto L_0x00db
        L_0x00f0:
            r5 = r0
            r7 = r5
        L_0x00f2:
            if (r5 >= r1) goto L_0x0107
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r8 = r10.E1
            r8 = r8[r5]
            if (r8 == 0) goto L_0x0104
            if (r5 <= 0) goto L_0x00ff
            int r9 = r10.x1
            int r7 = r7 + r9
        L_0x00ff:
            int r8 = r10.o2(r8, r14)
            int r7 = r7 + r8
        L_0x0104:
            int r5 = r5 + 1
            goto L_0x00f2
        L_0x0107:
            r15[r0] = r6
            r15[r3] = r7
            if (r13 != 0) goto L_0x0115
            if (r6 <= r14) goto L_0x0059
            if (r2 <= r3) goto L_0x0059
            int r2 = r2 + -1
            goto L_0x005c
        L_0x0115:
            if (r7 <= r14) goto L_0x0059
            if (r1 <= r3) goto L_0x0059
            int r1 = r1 + -1
            goto L_0x005c
        L_0x011d:
            int[] r10 = r10.G1
            r10[r0] = r2
            r10[r3] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.q2(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    public final void r2(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        int i4;
        ConstraintAnchor constraintAnchor;
        int i5;
        int i6;
        int i7;
        ConstraintAnchor constraintAnchor2;
        int i8;
        int i9;
        int i10 = i;
        int i11 = i3;
        if (i10 != 0) {
            this.D1.clear();
            WidgetsList widgetsList = new WidgetsList(i2, this.Q, this.R, this.S, this.T, i3);
            this.D1.add(widgetsList);
            if (i2 == 0) {
                i4 = 0;
                int i12 = 0;
                int i13 = 0;
                while (i13 < i10) {
                    ConstraintWidget constraintWidget = constraintWidgetArr[i13];
                    int p2 = p2(constraintWidget, i11);
                    if (constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i4++;
                    }
                    int i14 = i4;
                    boolean z = (i12 == i11 || (this.w1 + i12) + p2 > i11) && widgetsList.b != null;
                    if (!z && i13 > 0 && (i9 = this.B1) > 0 && i13 % i9 == 0) {
                        z = true;
                    }
                    if (z) {
                        widgetsList = new WidgetsList(i2, this.Q, this.R, this.S, this.T, i3);
                        widgetsList.i(i13);
                        this.D1.add(widgetsList);
                    } else if (i13 > 0) {
                        i12 += this.w1 + p2;
                        widgetsList.b(constraintWidget);
                        i13++;
                        i4 = i14;
                    }
                    i12 = p2;
                    widgetsList.b(constraintWidget);
                    i13++;
                    i4 = i14;
                }
            } else {
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                while (i17 < i10) {
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i17];
                    int o2 = o2(constraintWidget2, i11);
                    if (constraintWidget2.V() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i4++;
                    }
                    int i18 = i4;
                    boolean z2 = (i16 == i11 || (this.x1 + i16) + o2 > i11) && widgetsList.b != null;
                    if (!z2 && i17 > 0 && (i8 = this.B1) > 0 && i17 % i8 == 0) {
                        z2 = true;
                    }
                    if (z2) {
                        widgetsList = new WidgetsList(i2, this.Q, this.R, this.S, this.T, i3);
                        widgetsList.i(i17);
                        this.D1.add(widgetsList);
                    } else if (i17 > 0) {
                        i16 += this.x1 + o2;
                        widgetsList.b(constraintWidget2);
                        i17++;
                        i15 = i18;
                    }
                    i16 = o2;
                    widgetsList.b(constraintWidget2);
                    i17++;
                    i15 = i18;
                }
            }
            int size = this.D1.size();
            ConstraintAnchor constraintAnchor3 = this.Q;
            ConstraintAnchor constraintAnchor4 = this.R;
            ConstraintAnchor constraintAnchor5 = this.S;
            ConstraintAnchor constraintAnchor6 = this.T;
            int D12 = D1();
            int F12 = F1();
            int E12 = E1();
            int C12 = C1();
            ConstraintWidget.DimensionBehaviour C = C();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z3 = C == dimensionBehaviour || V() == dimensionBehaviour;
            if (i4 > 0 && z3) {
                for (int i19 = 0; i19 < size; i19++) {
                    WidgetsList widgetsList2 = (WidgetsList) this.D1.get(i19);
                    if (i2 == 0) {
                        widgetsList2.g(i11 - widgetsList2.f());
                    } else {
                        widgetsList2.g(i11 - widgetsList2.e());
                    }
                }
            }
            int i20 = F12;
            int i21 = E12;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = D12;
            ConstraintAnchor constraintAnchor7 = constraintAnchor4;
            ConstraintAnchor constraintAnchor8 = constraintAnchor3;
            int i26 = C12;
            while (i24 < size) {
                WidgetsList widgetsList3 = (WidgetsList) this.D1.get(i24);
                if (i2 == 0) {
                    if (i24 < size - 1) {
                        constraintAnchor2 = ((WidgetsList) this.D1.get(i24 + 1)).b.R;
                        i7 = 0;
                    } else {
                        constraintAnchor2 = this.T;
                        i7 = C1();
                    }
                    ConstraintAnchor constraintAnchor9 = widgetsList3.b.T;
                    ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                    ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                    int i27 = i22;
                    ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                    int i28 = i23;
                    ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                    ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                    i5 = i24;
                    widgetsList3.j(i2, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i25, i20, i21, i7, i3);
                    int max = Math.max(i28, widgetsList3.f());
                    i22 = i27 + widgetsList3.e();
                    if (i5 > 0) {
                        i22 += this.x1;
                    }
                    constraintAnchor8 = constraintAnchor11;
                    i23 = max;
                    i20 = 0;
                    constraintAnchor7 = constraintAnchor9;
                    constraintAnchor = constraintAnchor14;
                    int i29 = i7;
                    constraintAnchor6 = constraintAnchor2;
                    i26 = i29;
                } else {
                    ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                    int i30 = i22;
                    int i31 = i23;
                    i5 = i24;
                    if (i5 < size - 1) {
                        constraintAnchor = ((WidgetsList) this.D1.get(i5 + 1)).b.Q;
                        i6 = 0;
                    } else {
                        constraintAnchor = this.S;
                        i6 = E1();
                    }
                    ConstraintAnchor constraintAnchor16 = widgetsList3.b.S;
                    widgetsList3.j(i2, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i25, i20, i6, i26, i3);
                    i23 = i31 + widgetsList3.f();
                    int max2 = Math.max(i30, widgetsList3.e());
                    if (i5 > 0) {
                        i23 += this.w1;
                    }
                    i22 = max2;
                    i25 = 0;
                    i21 = i6;
                    constraintAnchor8 = constraintAnchor16;
                }
                i24 = i5 + 1;
                int i32 = i3;
                constraintAnchor5 = constraintAnchor;
            }
            iArr[0] = i23;
            iArr[1] = i22;
        }
    }

    public final void s2(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        int i4;
        ConstraintAnchor constraintAnchor;
        int i5;
        int i6;
        int i7;
        ConstraintAnchor constraintAnchor2;
        int i8;
        int i9;
        int i10 = i;
        int i11 = i3;
        if (i10 != 0) {
            this.D1.clear();
            WidgetsList widgetsList = new WidgetsList(i2, this.Q, this.R, this.S, this.T, i3);
            this.D1.add(widgetsList);
            if (i2 == 0) {
                int i12 = 0;
                i4 = 0;
                int i13 = 0;
                int i14 = 0;
                while (i14 < i10) {
                    int i15 = i12 + 1;
                    ConstraintWidget constraintWidget = constraintWidgetArr[i14];
                    int p2 = p2(constraintWidget, i11);
                    if (constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i4++;
                    }
                    int i16 = i4;
                    boolean z = (i13 == i11 || (this.w1 + i13) + p2 > i11) && widgetsList.b != null;
                    if (!z && i14 > 0 && (i9 = this.B1) > 0 && i15 > i9) {
                        z = true;
                    }
                    if (z) {
                        widgetsList = new WidgetsList(i2, this.Q, this.R, this.S, this.T, i3);
                        widgetsList.i(i14);
                        this.D1.add(widgetsList);
                        i12 = i15;
                        i13 = p2;
                    } else {
                        i13 = i14 > 0 ? i13 + this.w1 + p2 : p2;
                        i12 = 0;
                    }
                    widgetsList.b(constraintWidget);
                    i14++;
                    i4 = i16;
                }
            } else {
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                while (i19 < i10) {
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i19];
                    int o2 = o2(constraintWidget2, i11);
                    if (constraintWidget2.V() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i4++;
                    }
                    int i20 = i4;
                    boolean z2 = (i17 == i11 || (this.x1 + i17) + o2 > i11) && widgetsList.b != null;
                    if (!z2 && i19 > 0 && (i8 = this.B1) > 0 && i8 < 0) {
                        z2 = true;
                    }
                    if (z2) {
                        widgetsList = new WidgetsList(i2, this.Q, this.R, this.S, this.T, i3);
                        widgetsList.i(i19);
                        this.D1.add(widgetsList);
                    } else if (i19 > 0) {
                        i17 += this.x1 + o2;
                        widgetsList.b(constraintWidget2);
                        i19++;
                        i18 = i20;
                    }
                    i17 = o2;
                    widgetsList.b(constraintWidget2);
                    i19++;
                    i18 = i20;
                }
            }
            int size = this.D1.size();
            ConstraintAnchor constraintAnchor3 = this.Q;
            ConstraintAnchor constraintAnchor4 = this.R;
            ConstraintAnchor constraintAnchor5 = this.S;
            ConstraintAnchor constraintAnchor6 = this.T;
            int D12 = D1();
            int F12 = F1();
            int E12 = E1();
            int C12 = C1();
            ConstraintWidget.DimensionBehaviour C = C();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z3 = C == dimensionBehaviour || V() == dimensionBehaviour;
            if (i4 > 0 && z3) {
                for (int i21 = 0; i21 < size; i21++) {
                    WidgetsList widgetsList2 = (WidgetsList) this.D1.get(i21);
                    if (i2 == 0) {
                        widgetsList2.g(i11 - widgetsList2.f());
                    } else {
                        widgetsList2.g(i11 - widgetsList2.e());
                    }
                }
            }
            int i22 = F12;
            int i23 = E12;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            int i27 = D12;
            ConstraintAnchor constraintAnchor7 = constraintAnchor4;
            ConstraintAnchor constraintAnchor8 = constraintAnchor3;
            int i28 = C12;
            while (i26 < size) {
                WidgetsList widgetsList3 = (WidgetsList) this.D1.get(i26);
                if (i2 == 0) {
                    if (i26 < size - 1) {
                        constraintAnchor2 = ((WidgetsList) this.D1.get(i26 + 1)).b.R;
                        i7 = 0;
                    } else {
                        constraintAnchor2 = this.T;
                        i7 = C1();
                    }
                    ConstraintAnchor constraintAnchor9 = widgetsList3.b.T;
                    ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                    ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                    int i29 = i24;
                    ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                    int i30 = i25;
                    ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                    ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                    i5 = i26;
                    widgetsList3.j(i2, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i27, i22, i23, i7, i3);
                    int max = Math.max(i30, widgetsList3.f());
                    i24 = i29 + widgetsList3.e();
                    if (i5 > 0) {
                        i24 += this.x1;
                    }
                    constraintAnchor8 = constraintAnchor11;
                    i25 = max;
                    i22 = 0;
                    constraintAnchor7 = constraintAnchor9;
                    constraintAnchor = constraintAnchor14;
                    int i31 = i7;
                    constraintAnchor6 = constraintAnchor2;
                    i28 = i31;
                } else {
                    ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                    int i32 = i24;
                    int i33 = i25;
                    i5 = i26;
                    if (i5 < size - 1) {
                        constraintAnchor = ((WidgetsList) this.D1.get(i5 + 1)).b.Q;
                        i6 = 0;
                    } else {
                        constraintAnchor = this.S;
                        i6 = E1();
                    }
                    ConstraintAnchor constraintAnchor16 = widgetsList3.b.S;
                    widgetsList3.j(i2, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i27, i22, i6, i28, i3);
                    i25 = i33 + widgetsList3.f();
                    int max2 = Math.max(i32, widgetsList3.e());
                    if (i5 > 0) {
                        i25 += this.w1;
                    }
                    i24 = max2;
                    i27 = 0;
                    i23 = i6;
                    constraintAnchor8 = constraintAnchor16;
                }
                i26 = i5 + 1;
                int i34 = i3;
                constraintAnchor5 = constraintAnchor;
            }
            iArr[0] = i25;
            iArr[1] = i24;
        }
    }

    public final void t2(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        WidgetsList widgetsList;
        int i4 = i;
        if (i4 != 0) {
            if (this.D1.size() == 0) {
                widgetsList = new WidgetsList(i2, this.Q, this.R, this.S, this.T, i3);
                this.D1.add(widgetsList);
            } else {
                WidgetsList widgetsList2 = (WidgetsList) this.D1.get(0);
                widgetsList2.c();
                widgetsList = widgetsList2;
                widgetsList.j(i2, this.Q, this.R, this.S, this.T, D1(), F1(), E1(), C1(), i3);
            }
            for (int i5 = 0; i5 < i4; i5++) {
                widgetsList.b(constraintWidgetArr[i5]);
            }
            iArr[0] = widgetsList.f();
            iArr[1] = widgetsList.e();
        }
    }

    public void u2(float f) {
        this.s1 = f;
    }

    public void v2(int i) {
        this.m1 = i;
    }

    public void w2(float f) {
        this.t1 = f;
    }

    public void x2(int i) {
        this.n1 = i;
    }

    public void y2(int i) {
        this.y1 = i;
    }

    public void z2(float f) {
        this.q1 = f;
    }
}
