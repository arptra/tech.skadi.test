package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class ConstraintWidget {
    public static float U0 = 0.5f;
    public int A = 0;
    public int A0;
    public float B = 1.0f;
    public int B0;
    public int C = 0;
    public boolean C0;
    public int D = 0;
    public boolean D0;
    public float E = 1.0f;
    public boolean E0;
    public boolean F;
    public boolean F0;
    public boolean G;
    public boolean G0;
    public int H = -1;
    public boolean H0;
    public float I = 1.0f;
    public boolean I0;
    public int[] J = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public int J0;
    public float K = 0.0f;
    public int K0;
    public boolean L = false;
    public boolean L0;
    public boolean M;
    public boolean M0;
    public boolean N = false;
    public float[] N0;
    public int O = 0;
    public ConstraintWidget[] O0;
    public int P = 0;
    public ConstraintWidget[] P0;
    public ConstraintAnchor Q = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
    public ConstraintWidget Q0;
    public ConstraintAnchor R = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
    public ConstraintWidget R0;
    public ConstraintAnchor S = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
    public int S0;
    public ConstraintAnchor T = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
    public int T0;
    public ConstraintAnchor U = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
    public ConstraintAnchor V = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    public ConstraintAnchor W = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
    public ConstraintAnchor X;
    public ConstraintAnchor[] Y;
    public ArrayList Z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f530a = false;
    public boolean[] a0;
    public WidgetRun[] b = new WidgetRun[2];
    public DimensionBehaviour[] b0;
    public ChainRun c;
    public ConstraintWidget c0;
    public ChainRun d;
    public int d0;
    public HorizontalWidgetRun e = null;
    public int e0;
    public VerticalWidgetRun f = null;
    public float f0;
    public boolean[] g = {true, true};
    public int g0;
    public boolean h = false;
    public int h0;
    public boolean i = true;
    public int i0;
    public boolean j = false;
    public int j0;
    public boolean k = true;
    public int k0;
    public int l = -1;
    public int l0;
    public int m = -1;
    public int m0;
    public WidgetFrame n = new WidgetFrame(this);
    public int n0;
    public String o;
    public int o0;
    public boolean p = false;
    public int p0;
    public boolean q = false;
    public float q0;
    public boolean r = false;
    public float r0;
    public boolean s = false;
    public Object s0;
    public int t = -1;
    public int t0;
    public int u = -1;
    public int u0;
    public int v = 0;
    public boolean v0;
    public int w = 0;
    public String w0;
    public int x = 0;
    public String x0;
    public int[] y = new int[2];
    public int y0;
    public int z = 0;
    public int z0;

    /* renamed from: androidx.constraintlayout.core.widgets.ConstraintWidget$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f531a;
        public static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008f */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b = r0
                r1 = 1
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = b     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f531a = r4
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f531a     // Catch:{ NoSuchFieldError -> 0x004e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f531a     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f531a     // Catch:{ NoSuchFieldError -> 0x0062 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f531a     // Catch:{ NoSuchFieldError -> 0x006d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f531a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f531a     // Catch:{ NoSuchFieldError -> 0x0083 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f531a     // Catch:{ NoSuchFieldError -> 0x008f }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                int[] r0 = f531a     // Catch:{ NoSuchFieldError -> 0x009b }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x009b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009b }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.AnonymousClass1.<clinit>():void");
        }
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.X = constraintAnchor;
        this.Y = new ConstraintAnchor[]{this.Q, this.S, this.R, this.T, this.U, constraintAnchor};
        this.Z = new ArrayList();
        this.a0 = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.b0 = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.c0 = null;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0.0f;
        this.g0 = -1;
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = 0;
        this.k0 = 0;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = 0;
        float f2 = U0;
        this.q0 = f2;
        this.r0 = f2;
        this.t0 = 0;
        this.u0 = 0;
        this.v0 = false;
        this.w0 = null;
        this.x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new ConstraintWidget[]{null, null};
        this.P0 = new ConstraintWidget[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        d();
    }

    public float A() {
        return this.q0;
    }

    public final void A0(StringBuilder sb, String str, float f2, float f3) {
        if (f2 != f3) {
            sb.append(str);
            sb.append(" :   ");
            sb.append(f2);
            sb.append(",\n");
        }
    }

    public int B() {
        return this.J0;
    }

    public final void B0(StringBuilder sb, String str, int i2, int i3) {
        if (i2 != i3) {
            sb.append(str);
            sb.append(" :   ");
            sb.append(i2);
            sb.append(",\n");
        }
    }

    public DimensionBehaviour C() {
        return this.b0[0];
    }

    public final void C0(StringBuilder sb, String str, float f2, int i2) {
        if (f2 != 0.0f) {
            sb.append(str);
            sb.append(" :  [");
            sb.append(f2);
            sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
            sb.append(i2);
            sb.append("");
            sb.append("],\n");
        }
    }

    public int D() {
        ConstraintAnchor constraintAnchor = this.Q;
        int i2 = constraintAnchor != null ? constraintAnchor.g : 0;
        ConstraintAnchor constraintAnchor2 = this.S;
        return constraintAnchor2 != null ? i2 + constraintAnchor2.g : i2;
    }

    public void D0(boolean z2) {
        this.v0 = z2;
    }

    public int E() {
        return this.O;
    }

    public void E0(int i2) {
        this.n0 = i2;
        this.L = i2 > 0;
    }

    public int F() {
        return this.P;
    }

    public void F0(Object obj) {
        this.s0 = obj;
    }

    public int G(int i2) {
        if (i2 == 0) {
            return Y();
        }
        if (i2 == 1) {
            return z();
        }
        return 0;
    }

    public void G0(String str) {
        this.w0 = str;
    }

    public int H() {
        return this.J[1];
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void H0(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0090
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x0090
        L_0x000b:
            int r1 = r9.length()
            r2 = 44
            int r2 = r9.indexOf(r2)
            r3 = 0
            r4 = 1
            r5 = -1
            if (r2 <= 0) goto L_0x0039
            int r6 = r1 + -1
            if (r2 >= r6) goto L_0x0039
            java.lang.String r6 = r9.substring(r3, r2)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002b
            goto L_0x0036
        L_0x002b:
            java.lang.String r3 = "H"
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0035
            r3 = r4
            goto L_0x0036
        L_0x0035:
            r3 = r5
        L_0x0036:
            int r2 = r2 + r4
            r5 = r3
            r3 = r2
        L_0x0039:
            r2 = 58
            int r2 = r9.indexOf(r2)
            if (r2 < 0) goto L_0x0077
            int r1 = r1 - r4
            if (r2 >= r1) goto L_0x0077
            java.lang.String r1 = r9.substring(r3, r2)
            int r2 = r2 + r4
            java.lang.String r9 = r9.substring(r2)
            int r2 = r1.length()
            if (r2 <= 0) goto L_0x0086
            int r2 = r9.length()
            if (r2 <= 0) goto L_0x0086
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x0086 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0086
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0086
            if (r5 != r4) goto L_0x0071
            float r9 = r9 / r1
            float r9 = java.lang.Math.abs(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0087
        L_0x0071:
            float r1 = r1 / r9
            float r9 = java.lang.Math.abs(r1)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0087
        L_0x0077:
            java.lang.String r9 = r9.substring(r3)
            int r1 = r9.length()
            if (r1 <= 0) goto L_0x0086
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0087
        L_0x0086:
            r9 = r0
        L_0x0087:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x008f
            r8.f0 = r9
            r8.g0 = r5
        L_0x008f:
            return
        L_0x0090:
            r8.f0 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.H0(java.lang.String):void");
    }

    public int I() {
        return this.J[0];
    }

    public void I0(int i2) {
        if (this.L) {
            int i3 = i2 - this.n0;
            int i4 = this.e0 + i3;
            this.i0 = i3;
            this.R.t(i3);
            this.T.t(i4);
            this.U.t(i2);
            this.q = true;
        }
    }

    public int J() {
        return this.p0;
    }

    public void J0(int i2, int i3) {
        if (!this.p) {
            this.Q.t(i2);
            this.S.t(i3);
            this.h0 = i2;
            this.d0 = i3 - i2;
            this.p = true;
        }
    }

    public int K() {
        return this.o0;
    }

    public void K0(int i2) {
        this.Q.t(i2);
        this.h0 = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r1 = r1.T;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.core.widgets.ConstraintWidget L(int r2) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x000f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.f
            if (r2 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r2.f
            if (r0 != r1) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r2.d
            return r1
        L_0x000f:
            r0 = 1
            if (r2 != r0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.f
            if (r2 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r2.f
            if (r0 != r1) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r2.d
            return r1
        L_0x001f:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.L(int):androidx.constraintlayout.core.widgets.ConstraintWidget");
    }

    public void L0(int i2) {
        this.R.t(i2);
        this.i0 = i2;
    }

    public ConstraintWidget M() {
        return this.c0;
    }

    public void M0(int i2, int i3) {
        if (!this.q) {
            this.R.t(i2);
            this.T.t(i3);
            this.i0 = i2;
            this.e0 = i3 - i2;
            if (this.L) {
                this.U.t(i2 + this.n0);
            }
            this.q = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r1 = r1.R;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.core.widgets.ConstraintWidget N(int r2) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x000f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.f
            if (r2 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r2.f
            if (r0 != r1) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r2.d
            return r1
        L_0x000f:
            r0 = 1
            if (r2 != r0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.f
            if (r2 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r2.f
            if (r0 != r1) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r2.d
            return r1
        L_0x001f:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.N(int):androidx.constraintlayout.core.widgets.ConstraintWidget");
    }

    public void N0(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        this.h0 = i2;
        this.i0 = i3;
        if (this.u0 == 8) {
            this.d0 = 0;
            this.e0 = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.b0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i8 < (i7 = this.d0)) {
            i8 = i7;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i9 < (i6 = this.e0)) {
            i9 = i6;
        }
        this.d0 = i8;
        this.e0 = i9;
        int i10 = this.p0;
        if (i9 < i10) {
            this.e0 = i10;
        }
        int i11 = this.o0;
        if (i8 < i11) {
            this.d0 = i11;
        }
        int i12 = this.A;
        if (i12 > 0 && dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.d0 = Math.min(this.d0, i12);
        }
        int i13 = this.D;
        if (i13 > 0 && this.b0[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.e0 = Math.min(this.e0, i13);
        }
        int i14 = this.d0;
        if (i8 != i14) {
            this.l = i14;
        }
        int i15 = this.e0;
        if (i9 != i15) {
            this.m = i15;
        }
    }

    public int O() {
        return Z() + this.d0;
    }

    public void O0(boolean z2) {
        this.L = z2;
    }

    public WidgetRun P(int i2) {
        if (i2 == 0) {
            return this.e;
        }
        if (i2 == 1) {
            return this.f;
        }
        return null;
    }

    public void P0(int i2) {
        this.e0 = i2;
        int i3 = this.p0;
        if (i2 < i3) {
            this.e0 = i3;
        }
    }

    public void Q(StringBuilder sb) {
        sb.append(FastRecordHistoryDetailActivity.TAG_SPLIT + this.o + ":{\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("    actualWidth:");
        sb2.append(this.d0);
        sb.append(sb2.toString());
        sb.append(StringUtils.LF);
        sb.append("    actualHeight:" + this.e0);
        sb.append(StringUtils.LF);
        sb.append("    actualLeft:" + this.h0);
        sb.append(StringUtils.LF);
        sb.append("    actualTop:" + this.i0);
        sb.append(StringUtils.LF);
        S(sb, "left", this.Q);
        S(sb, "top", this.R);
        S(sb, "right", this.S);
        S(sb, "bottom", this.T);
        S(sb, "baseline", this.U);
        S(sb, "centerX", this.V);
        S(sb, "centerY", this.W);
        R(sb, "    width", this.d0, this.o0, this.J[0], this.l, this.z, this.w, this.B, this.N0[0]);
        R(sb, "    height", this.e0, this.p0, this.J[1], this.m, this.C, this.x, this.E, this.N0[1]);
        C0(sb, "    dimensionRatio", this.f0, this.g0);
        A0(sb, "    horizontalBias", this.q0, U0);
        A0(sb, "    verticalBias", this.r0, U0);
        B0(sb, "    horizontalChainStyle", this.J0, 0);
        B0(sb, "    verticalChainStyle", this.K0, 0);
        sb.append("  }");
    }

    public void Q0(float f2) {
        this.q0 = f2;
    }

    public final void R(StringBuilder sb, String str, int i2, int i3, int i4, int i5, int i6, int i7, float f2, float f3) {
        sb.append(str);
        sb.append(" :  {\n");
        B0(sb, "      size", i2, 0);
        B0(sb, "      min", i3, 0);
        B0(sb, "      max", i4, Integer.MAX_VALUE);
        B0(sb, "      matchMin", i6, 0);
        B0(sb, "      matchDef", i7, 0);
        A0(sb, "      matchPercent", f2, 1.0f);
        sb.append("    },\n");
    }

    public void R0(int i2) {
        this.J0 = i2;
    }

    public final void S(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.f != null) {
            sb.append("    ");
            sb.append(str);
            sb.append(" : [ '");
            sb.append(constraintAnchor.f);
            sb.append("'");
            if (!(constraintAnchor.h == Integer.MIN_VALUE && constraintAnchor.g == 0)) {
                sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
                sb.append(constraintAnchor.g);
                if (constraintAnchor.h != Integer.MIN_VALUE) {
                    sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
                    sb.append(constraintAnchor.h);
                    sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
                }
            }
            sb.append(" ] ,\n");
        }
    }

    public void S0(int i2, int i3) {
        this.h0 = i2;
        int i4 = i3 - i2;
        this.d0 = i4;
        int i5 = this.o0;
        if (i4 < i5) {
            this.d0 = i5;
        }
    }

    public float T() {
        return this.r0;
    }

    public void T0(DimensionBehaviour dimensionBehaviour) {
        this.b0[0] = dimensionBehaviour;
    }

    public int U() {
        return this.K0;
    }

    public void U0(int i2, int i3, int i4, float f2) {
        this.w = i2;
        this.z = i3;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.A = i4;
        this.B = f2;
        if (f2 > 0.0f && f2 < 1.0f && i2 == 0) {
            this.w = 2;
        }
    }

    public DimensionBehaviour V() {
        return this.b0[1];
    }

    public void V0(float f2) {
        this.N0[0] = f2;
    }

    public int W() {
        int i2 = this.Q != null ? this.R.g : 0;
        return this.S != null ? i2 + this.T.g : i2;
    }

    public void W0(int i2, boolean z2) {
        this.a0[i2] = z2;
    }

    public int X() {
        return this.u0;
    }

    public void X0(boolean z2) {
        this.M = z2;
    }

    public int Y() {
        if (this.u0 == 8) {
            return 0;
        }
        return this.d0;
    }

    public void Y0(boolean z2) {
        this.N = z2;
    }

    public int Z() {
        ConstraintWidget constraintWidget = this.c0;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.h0 : ((ConstraintWidgetContainer) constraintWidget).d1 + this.h0;
    }

    public void Z0(int i2, int i3) {
        this.O = i2;
        this.P = i3;
        c1(false);
    }

    public int a0() {
        ConstraintWidget constraintWidget = this.c0;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.i0 : ((ConstraintWidgetContainer) constraintWidget).e1 + this.i0;
    }

    public void a1(int i2) {
        this.J[1] = i2;
    }

    public boolean b0() {
        return this.L;
    }

    public void b1(int i2) {
        this.J[0] = i2;
    }

    public boolean c0(int i2) {
        if (i2 == 0) {
            return (this.Q.f != null ? 1 : 0) + (this.S.f != null ? 1 : 0) < 2;
        }
        return ((this.R.f != null ? 1 : 0) + (this.T.f != null ? 1 : 0)) + (this.U.f != null ? 1 : 0) < 2;
    }

    public void c1(boolean z2) {
        this.i = z2;
    }

    public final void d() {
        this.Z.add(this.Q);
        this.Z.add(this.R);
        this.Z.add(this.S);
        this.Z.add(this.T);
        this.Z.add(this.V);
        this.Z.add(this.W);
        this.Z.add(this.X);
        this.Z.add(this.U);
    }

    public boolean d0() {
        int size = this.Z.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((ConstraintAnchor) this.Z.get(i2)).m()) {
                return true;
            }
        }
        return false;
    }

    public void d1(int i2) {
        if (i2 < 0) {
            this.p0 = 0;
        } else {
            this.p0 = i2;
        }
    }

    public void e(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet hashSet, int i2, boolean z2) {
        if (z2) {
            if (hashSet.contains(this)) {
                Optimizer.a(constraintWidgetContainer, linearSystem, this);
                hashSet.remove(this);
                g(linearSystem, constraintWidgetContainer.Y1(64));
            } else {
                return;
            }
        }
        if (i2 == 0) {
            HashSet d2 = this.Q.d();
            if (d2 != null) {
                Iterator it = d2.iterator();
                while (it.hasNext()) {
                    ((ConstraintAnchor) it.next()).d.e(constraintWidgetContainer, linearSystem, hashSet, i2, true);
                }
            }
            HashSet d3 = this.S.d();
            if (d3 != null) {
                Iterator it2 = d3.iterator();
                while (it2.hasNext()) {
                    ((ConstraintAnchor) it2.next()).d.e(constraintWidgetContainer, linearSystem, hashSet, i2, true);
                }
                return;
            }
            return;
        }
        HashSet d4 = this.R.d();
        if (d4 != null) {
            Iterator it3 = d4.iterator();
            while (it3.hasNext()) {
                ((ConstraintAnchor) it3.next()).d.e(constraintWidgetContainer, linearSystem, hashSet, i2, true);
            }
        }
        HashSet d5 = this.T.d();
        if (d5 != null) {
            Iterator it4 = d5.iterator();
            while (it4.hasNext()) {
                ((ConstraintAnchor) it4.next()).d.e(constraintWidgetContainer, linearSystem, hashSet, i2, true);
            }
        }
        HashSet d6 = this.U.d();
        if (d6 != null) {
            Iterator it5 = d6.iterator();
            while (it5.hasNext()) {
                ((ConstraintAnchor) it5.next()).d.e(constraintWidgetContainer, linearSystem, hashSet, i2, true);
            }
        }
    }

    public boolean e0() {
        return (this.l == -1 && this.m == -1) ? false : true;
    }

    public void e1(int i2) {
        if (i2 < 0) {
            this.o0 = 0;
        } else {
            this.o0 = i2;
        }
    }

    public boolean f() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    public boolean f0(int i2, int i3) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i2 == 0) {
            ConstraintAnchor constraintAnchor3 = this.Q.f;
            if (constraintAnchor3 != null && constraintAnchor3.n() && (constraintAnchor2 = this.S.f) != null && constraintAnchor2.n()) {
                return (this.S.f.e() - this.S.f()) - (this.Q.f.e() + this.Q.f()) >= i3;
            }
        } else {
            ConstraintAnchor constraintAnchor4 = this.R.f;
            if (constraintAnchor4 != null && constraintAnchor4.n() && (constraintAnchor = this.T.f) != null && constraintAnchor.n()) {
                return (this.T.f.e() - this.T.f()) - (this.R.f.e() + this.R.f()) >= i3;
            }
        }
        return false;
    }

    public void f1(int i2, int i3) {
        this.h0 = i2;
        this.i0 = i3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0390  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x044b  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x04af  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x04c3  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x04c5  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x04cc  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x0563  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x0566  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x05a7  */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x05af  */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x05dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(androidx.constraintlayout.core.LinearSystem r54, boolean r55) {
        /*
            r53 = this;
            r15 = r53
            r14 = r54
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.Q
            androidx.constraintlayout.core.SolverVariable r13 = r14.q(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.S
            androidx.constraintlayout.core.SolverVariable r12 = r14.q(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.R
            androidx.constraintlayout.core.SolverVariable r11 = r14.q(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.T
            androidx.constraintlayout.core.SolverVariable r10 = r14.q(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.U
            androidx.constraintlayout.core.SolverVariable r9 = r14.q(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            r8 = 2
            r1 = 3
            r7 = 1
            r6 = 0
            if (r0 == 0) goto L_0x004f
            if (r0 == 0) goto L_0x0036
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r0.b0
            r2 = r2[r6]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r3) goto L_0x0036
            r2 = r7
            goto L_0x0037
        L_0x0036:
            r2 = r6
        L_0x0037:
            if (r0 == 0) goto L_0x0043
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r0.b0
            r0 = r0[r7]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r3) goto L_0x0043
            r0 = r7
            goto L_0x0044
        L_0x0043:
            r0 = r6
        L_0x0044:
            int r3 = r15.v
            if (r3 == r7) goto L_0x0055
            if (r3 == r8) goto L_0x0052
            if (r3 == r1) goto L_0x004f
            r5 = r0
            r4 = r2
            goto L_0x0057
        L_0x004f:
            r4 = r6
            r5 = r4
            goto L_0x0057
        L_0x0052:
            r5 = r0
            r4 = r6
            goto L_0x0057
        L_0x0055:
            r4 = r2
            r5 = r6
        L_0x0057:
            int r0 = r15.u0
            r3 = 8
            if (r0 != r3) goto L_0x0072
            boolean r0 = r15.v0
            if (r0 != 0) goto L_0x0072
            boolean r0 = r53.d0()
            if (r0 != 0) goto L_0x0072
            boolean[] r0 = r15.a0
            boolean r2 = r0[r6]
            if (r2 != 0) goto L_0x0072
            boolean r0 = r0[r7]
            if (r0 != 0) goto L_0x0072
            return
        L_0x0072:
            boolean r0 = r15.p
            r2 = 5
            if (r0 != 0) goto L_0x007b
            boolean r8 = r15.q
            if (r8 == 0) goto L_0x00f8
        L_0x007b:
            if (r0 == 0) goto L_0x00aa
            int r0 = r15.h0
            r14.f(r13, r0)
            int r0 = r15.h0
            int r8 = r15.d0
            int r0 = r0 + r8
            r14.f(r12, r0)
            if (r4 == 0) goto L_0x00aa
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x00aa
            boolean r8 = r15.k
            if (r8 == 0) goto L_0x00a1
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.Q
            r0.D1(r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.S
            r0.C1(r8)
            goto L_0x00aa
        L_0x00a1:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.S
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r14.h(r0, r12, r6, r2)
        L_0x00aa:
            boolean r0 = r15.q
            if (r0 == 0) goto L_0x00eb
            int r0 = r15.i0
            r14.f(r11, r0)
            int r0 = r15.i0
            int r8 = r15.e0
            int r0 = r0 + r8
            r14.f(r10, r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.U
            boolean r0 = r0.m()
            if (r0 == 0) goto L_0x00cb
            int r0 = r15.i0
            int r8 = r15.n0
            int r0 = r0 + r8
            r14.f(r9, r0)
        L_0x00cb:
            if (r5 == 0) goto L_0x00eb
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x00eb
            boolean r8 = r15.k
            if (r8 == 0) goto L_0x00e2
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.R
            r0.I1(r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.T
            r0.H1(r8)
            goto L_0x00eb
        L_0x00e2:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.T
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r14.h(r0, r10, r6, r2)
        L_0x00eb:
            boolean r0 = r15.p
            if (r0 == 0) goto L_0x00f8
            boolean r0 = r15.q
            if (r0 == 0) goto L_0x00f8
            r15.p = r6
            r15.q = r6
            return
        L_0x00f8:
            androidx.constraintlayout.core.Metrics r0 = androidx.constraintlayout.core.LinearSystem.x
            r17 = 1
            if (r0 == 0) goto L_0x0104
            long r1 = r0.y
            long r1 = r1 + r17
            r0.y = r1
        L_0x0104:
            if (r55 == 0) goto L_0x0193
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r1 = r15.e
            if (r1 == 0) goto L_0x0193
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r2 = r15.f
            if (r2 == 0) goto L_0x0193
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r8 = r1.h
            boolean r7 = r8.j
            if (r7 == 0) goto L_0x0193
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.i
            boolean r1 = r1.j
            if (r1 == 0) goto L_0x0193
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r2.h
            boolean r1 = r1.j
            if (r1 == 0) goto L_0x0193
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r2.i
            boolean r1 = r1.j
            if (r1 == 0) goto L_0x0193
            if (r0 == 0) goto L_0x012e
            long r1 = r0.r
            long r1 = r1 + r17
            r0.r = r1
        L_0x012e:
            int r0 = r8.g
            r14.f(r13, r0)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r15.e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.i
            int r0 = r0.g
            r14.f(r12, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.h
            int r0 = r0.g
            r14.f(r11, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.i
            int r0 = r0.g
            r14.f(r10, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.k
            int r0 = r0.g
            r14.f(r9, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x018e
            if (r4 == 0) goto L_0x0174
            boolean[] r0 = r15.g
            boolean r0 = r0[r6]
            if (r0 == 0) goto L_0x0174
            boolean r0 = r53.k0()
            if (r0 != 0) goto L_0x0174
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.S
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r14.h(r0, r12, r6, r3)
        L_0x0174:
            if (r5 == 0) goto L_0x018e
            boolean[] r0 = r15.g
            r1 = 1
            boolean r0 = r0[r1]
            if (r0 == 0) goto L_0x018e
            boolean r0 = r53.m0()
            if (r0 != 0) goto L_0x018e
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.T
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r14.h(r0, r10, r6, r3)
        L_0x018e:
            r15.p = r6
            r15.q = r6
            return
        L_0x0193:
            if (r0 == 0) goto L_0x019b
            long r1 = r0.s
            long r1 = r1 + r17
            r0.s = r1
        L_0x019b:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x0210
            boolean r0 = r15.h0(r6)
            if (r0 == 0) goto L_0x01af
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r0
            r0.z1(r15, r6)
            r0 = 1
        L_0x01ad:
            r1 = 1
            goto L_0x01b4
        L_0x01af:
            boolean r0 = r53.k0()
            goto L_0x01ad
        L_0x01b4:
            boolean r2 = r15.h0(r1)
            if (r2 == 0) goto L_0x01c3
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r15.c0
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r2 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r2
            r2.z1(r15, r1)
            r1 = 1
            goto L_0x01c7
        L_0x01c3:
            boolean r1 = r53.m0()
        L_0x01c7:
            if (r0 != 0) goto L_0x01e7
            if (r4 == 0) goto L_0x01e7
            int r2 = r15.u0
            if (r2 == r3) goto L_0x01e7
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f
            if (r2 != 0) goto L_0x01e7
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f
            if (r2 != 0) goto L_0x01e7
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r15.c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.S
            androidx.constraintlayout.core.SolverVariable r2 = r14.q(r2)
            r7 = 1
            r14.h(r2, r12, r6, r7)
        L_0x01e7:
            if (r1 != 0) goto L_0x020b
            if (r5 == 0) goto L_0x020b
            int r2 = r15.u0
            if (r2 == r3) goto L_0x020b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f
            if (r2 != 0) goto L_0x020b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f
            if (r2 != 0) goto L_0x020b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.U
            if (r2 != 0) goto L_0x020b
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r15.c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.T
            androidx.constraintlayout.core.SolverVariable r2 = r14.q(r2)
            r7 = 1
            r14.h(r2, r10, r6, r7)
        L_0x020b:
            r29 = r0
            r28 = r1
            goto L_0x0214
        L_0x0210:
            r28 = r6
            r29 = r28
        L_0x0214:
            int r0 = r15.d0
            int r1 = r15.o0
            if (r0 >= r1) goto L_0x021b
            goto L_0x021c
        L_0x021b:
            r1 = r0
        L_0x021c:
            int r2 = r15.e0
            int r7 = r15.p0
            if (r2 >= r7) goto L_0x0223
            goto L_0x0224
        L_0x0223:
            r7 = r2
        L_0x0224:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r15.b0
            r3 = r8[r6]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r22 = r1
            if (r3 == r6) goto L_0x0232
            r1 = 1
        L_0x022f:
            r21 = 1
            goto L_0x0234
        L_0x0232:
            r1 = 0
            goto L_0x022f
        L_0x0234:
            r8 = r8[r21]
            r23 = r7
            r27 = r9
            if (r8 == r6) goto L_0x023e
            r7 = 1
            goto L_0x023f
        L_0x023e:
            r7 = 0
        L_0x023f:
            int r9 = r15.g0
            r15.H = r9
            r30 = r10
            float r10 = r15.f0
            r15.I = r10
            r31 = r11
            int r11 = r15.w
            r32 = r12
            int r12 = r15.x
            r24 = 0
            int r24 = (r10 > r24 ? 1 : (r10 == r24 ? 0 : -1))
            r33 = r13
            if (r24 <= 0) goto L_0x02c6
            int r13 = r15.u0
            r14 = 8
            if (r13 == r14) goto L_0x02c6
            if (r3 != r6) goto L_0x0264
            if (r11 != 0) goto L_0x0264
            r11 = 3
        L_0x0264:
            if (r8 != r6) goto L_0x0269
            if (r12 != 0) goto L_0x0269
            r12 = 3
        L_0x0269:
            if (r3 != r6) goto L_0x0276
            if (r8 != r6) goto L_0x0276
            r13 = 3
            if (r11 != r13) goto L_0x0277
            if (r12 != r13) goto L_0x0277
            r15.s1(r4, r5, r1, r7)
            goto L_0x02bf
        L_0x0276:
            r13 = 3
        L_0x0277:
            r1 = 4
            if (r3 != r6) goto L_0x0296
            if (r11 != r13) goto L_0x0296
            r7 = 0
            r15.H = r7
            float r0 = (float) r2
            float r10 = r10 * r0
            int r0 = (int) r10
            if (r8 == r6) goto L_0x028d
            r36 = r1
            r35 = r12
            r34 = r23
            r14 = 0
            r1 = r0
            goto L_0x02cf
        L_0x028d:
            r1 = r0
            r36 = r11
            r35 = r12
        L_0x0292:
            r34 = r23
        L_0x0294:
            r14 = 1
            goto L_0x02cf
        L_0x0296:
            if (r8 != r6) goto L_0x02bf
            if (r12 != r13) goto L_0x02bf
            r2 = 1
            r15.H = r2
            r2 = -1
            if (r9 != r2) goto L_0x02a5
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 / r10
            r15.I = r2
        L_0x02a5:
            float r2 = r15.I
            float r0 = (float) r0
            float r2 = r2 * r0
            int r7 = (int) r2
            if (r3 == r6) goto L_0x02b6
            r35 = r1
            r34 = r7
            r36 = r11
            r1 = r22
        L_0x02b4:
            r14 = 0
            goto L_0x02cf
        L_0x02b6:
            r34 = r7
            r36 = r11
            r35 = r12
            r1 = r22
            goto L_0x0294
        L_0x02bf:
            r36 = r11
            r35 = r12
            r1 = r22
            goto L_0x0292
        L_0x02c6:
            r36 = r11
            r35 = r12
            r1 = r22
            r34 = r23
            goto L_0x02b4
        L_0x02cf:
            int[] r0 = r15.y
            r2 = 0
            r0[r2] = r36
            r2 = 1
            r0[r2] = r35
            r15.h = r14
            if (r14 == 0) goto L_0x02e5
            int r0 = r15.H
            r2 = -1
            if (r0 == 0) goto L_0x02e2
            if (r0 != r2) goto L_0x02e6
        L_0x02e2:
            r20 = 1
            goto L_0x02e8
        L_0x02e5:
            r2 = -1
        L_0x02e6:
            r20 = 0
        L_0x02e8:
            if (r14 == 0) goto L_0x02f4
            int r0 = r15.H
            r3 = 1
            if (r0 == r3) goto L_0x02f1
            if (r0 != r2) goto L_0x02f4
        L_0x02f1:
            r37 = 1
            goto L_0x02f6
        L_0x02f4:
            r37 = 0
        L_0x02f6:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.b0
            r2 = 0
            r0 = r0[r2]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r13) goto L_0x0305
            boolean r0 = r15 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x0305
            r9 = 1
            goto L_0x0306
        L_0x0305:
            r9 = 0
        L_0x0306:
            if (r9 == 0) goto L_0x030b
            r22 = 0
            goto L_0x030d
        L_0x030b:
            r22 = r1
        L_0x030d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.X
            boolean r0 = r0.o()
            r1 = 1
            r38 = r0 ^ 1
            boolean[] r0 = r15.a0
            r2 = 0
            boolean r23 = r0[r2]
            boolean r39 = r0[r1]
            int r0 = r15.t
            r40 = 0
            r8 = 2
            if (r0 == r8) goto L_0x0392
            boolean r0 = r15.p
            if (r0 != 0) goto L_0x0392
            if (r55 == 0) goto L_0x033a
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r15.e
            if (r0 == 0) goto L_0x033a
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.h
            boolean r2 = r1.j
            if (r2 == 0) goto L_0x033a
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.i
            boolean r0 = r0.j
            if (r0 != 0) goto L_0x0344
        L_0x033a:
            r12 = r54
            r10 = r32
            r11 = r33
            r3 = 8
            goto L_0x03a8
        L_0x0344:
            if (r55 == 0) goto L_0x0390
            int r0 = r1.g
            r12 = r54
            r11 = r33
            r12.f(r11, r0)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r15.e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.i
            int r0 = r0.g
            r10 = r32
            r12.f(r10, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x037a
            if (r4 == 0) goto L_0x037a
            boolean[] r0 = r15.g
            r1 = 0
            boolean r0 = r0[r1]
            if (r0 == 0) goto L_0x037a
            boolean r0 = r53.k0()
            if (r0 != 0) goto L_0x037a
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.S
            androidx.constraintlayout.core.SolverVariable r0 = r12.q(r0)
            r3 = 8
            r12.h(r0, r10, r1, r3)
        L_0x037a:
            r46 = r4
            r47 = r5
            r48 = r6
            r52 = r13
            r32 = r14
            r49 = r27
            r50 = r30
            r51 = r31
            r30 = r10
            r31 = r11
            goto L_0x0449
        L_0x0390:
            r12 = r54
        L_0x0392:
            r46 = r4
            r47 = r5
            r48 = r6
            r52 = r13
            r49 = r27
            r50 = r30
            r51 = r31
            r30 = r32
            r31 = r33
            r32 = r14
            goto L_0x0449
        L_0x03a8:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x03b4
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.S
            androidx.constraintlayout.core.SolverVariable r0 = r12.q(r0)
            r7 = r0
            goto L_0x03b6
        L_0x03b4:
            r7 = r40
        L_0x03b6:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x03c3
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.Q
            androidx.constraintlayout.core.SolverVariable r0 = r12.q(r0)
            r16 = r0
            goto L_0x03c5
        L_0x03c3:
            r16 = r40
        L_0x03c5:
            boolean[] r0 = r15.g
            r17 = 0
            boolean r18 = r0[r17]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.b0
            r32 = r0[r17]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r15.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.S
            r33 = r2
            int r2 = r15.h0
            r41 = r2
            int r2 = r15.o0
            int[] r3 = r15.J
            r43 = r3[r17]
            float r3 = r15.q0
            r21 = 1
            r0 = r0[r21]
            if (r0 != r6) goto L_0x03ea
            r44 = r21
            goto L_0x03ec
        L_0x03ea:
            r44 = r17
        L_0x03ec:
            int r0 = r15.z
            r24 = r0
            int r0 = r15.A
            r25 = r0
            float r0 = r15.B
            r26 = r0
            r0 = 1
            r19 = r33
            r33 = r41
            r41 = r2
            r2 = r0
            r0 = r53
            r45 = r1
            r1 = r54
            r42 = r3
            r3 = r4
            r46 = r4
            r4 = r5
            r47 = r5
            r5 = r18
            r48 = r6
            r6 = r16
            r8 = r32
            r49 = r27
            r16 = r10
            r50 = r30
            r10 = r45
            r17 = r11
            r51 = r31
            r11 = r19
            r30 = r16
            r12 = r33
            r52 = r13
            r31 = r17
            r13 = r22
            r32 = r14
            r14 = r41
            r15 = r43
            r16 = r42
            r17 = r20
            r18 = r44
            r19 = r29
            r20 = r28
            r21 = r23
            r22 = r36
            r23 = r35
            r27 = r38
            r0.i(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
        L_0x0449:
            if (r55 == 0) goto L_0x04af
            r15 = r53
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.f
            if (r0 == 0) goto L_0x04a2
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.h
            boolean r2 = r1.j
            if (r2 == 0) goto L_0x04a2
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.i
            boolean r0 = r0.j
            if (r0 == 0) goto L_0x04a2
            int r0 = r1.g
            r14 = r54
            r13 = r51
            r14.f(r13, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.i
            int r0 = r0.g
            r12 = r50
            r14.f(r12, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.k
            int r0 = r0.g
            r1 = r49
            r14.f(r1, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x049c
            if (r28 != 0) goto L_0x049c
            if (r47 == 0) goto L_0x049c
            boolean[] r2 = r15.g
            r11 = 1
            boolean r2 = r2[r11]
            if (r2 == 0) goto L_0x0498
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.T
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r2 = 8
            r10 = 0
            r14.h(r0, r12, r10, r2)
            goto L_0x04a0
        L_0x0498:
            r2 = 8
            r10 = 0
            goto L_0x04a0
        L_0x049c:
            r2 = 8
            r10 = 0
            r11 = 1
        L_0x04a0:
            r7 = r10
            goto L_0x04be
        L_0x04a2:
            r14 = r54
            r1 = r49
            r12 = r50
            r13 = r51
            r2 = 8
            r10 = 0
            r11 = 1
            goto L_0x04bd
        L_0x04af:
            r2 = 8
            r10 = 0
            r11 = 1
            r15 = r53
            r14 = r54
            r1 = r49
            r12 = r50
            r13 = r51
        L_0x04bd:
            r7 = r11
        L_0x04be:
            int r0 = r15.u
            r3 = 2
            if (r0 != r3) goto L_0x04c5
            r6 = r10
            goto L_0x04c6
        L_0x04c5:
            r6 = r7
        L_0x04c6:
            if (r6 == 0) goto L_0x05a7
            boolean r0 = r15.q
            if (r0 != 0) goto L_0x05a7
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.b0
            r0 = r0[r11]
            r3 = r52
            if (r0 != r3) goto L_0x04da
            boolean r0 = r15 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x04da
            r9 = r11
            goto L_0x04db
        L_0x04da:
            r9 = r10
        L_0x04db:
            if (r9 == 0) goto L_0x04df
            r34 = r10
        L_0x04df:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x04eb
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.T
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r7 = r0
            goto L_0x04ed
        L_0x04eb:
            r7 = r40
        L_0x04ed:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x04f9
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.R
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r6 = r0
            goto L_0x04fb
        L_0x04f9:
            r6 = r40
        L_0x04fb:
            int r0 = r15.n0
            if (r0 > 0) goto L_0x0503
            int r0 = r15.u0
            if (r0 != r2) goto L_0x0543
        L_0x0503:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.U
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r0.f
            if (r3 == 0) goto L_0x0530
            int r0 = r53.r()
            r14.e(r1, r13, r0, r2)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.U
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.U
            int r3 = r3.f()
            r14.e(r1, r0, r3, r2)
            if (r47 == 0) goto L_0x052d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.T
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r1 = 5
            r14.h(r7, r0, r10, r1)
        L_0x052d:
            r27 = r10
            goto L_0x0545
        L_0x0530:
            int r3 = r15.u0
            if (r3 != r2) goto L_0x053c
            int r0 = r0.f()
            r14.e(r1, r13, r0, r2)
            goto L_0x0543
        L_0x053c:
            int r0 = r53.r()
            r14.e(r1, r13, r0, r2)
        L_0x0543:
            r27 = r38
        L_0x0545:
            boolean[] r0 = r15.g
            boolean r5 = r0[r11]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.b0
            r8 = r0[r11]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r15.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.T
            int r1 = r15.i0
            int r2 = r15.p0
            int[] r10 = r15.J
            r16 = r10[r11]
            float r10 = r15.r0
            r17 = 0
            r0 = r0[r17]
            r11 = r48
            if (r0 != r11) goto L_0x0566
            r18 = 1
            goto L_0x0568
        L_0x0566:
            r18 = r17
        L_0x0568:
            int r0 = r15.C
            r24 = r0
            int r0 = r15.D
            r25 = r0
            float r0 = r15.E
            r26 = r0
            r0 = 0
            r19 = r2
            r2 = r0
            r0 = r53
            r20 = r1
            r1 = r54
            r11 = r3
            r3 = r47
            r21 = r4
            r4 = r46
            r17 = r10
            r10 = r21
            r33 = r12
            r12 = r20
            r38 = r13
            r13 = r34
            r14 = r19
            r15 = r16
            r16 = r17
            r17 = r37
            r19 = r28
            r20 = r29
            r21 = r39
            r22 = r35
            r23 = r36
            r0.i(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x05ab
        L_0x05a7:
            r33 = r12
            r38 = r13
        L_0x05ab:
            r7 = r53
            if (r32 == 0) goto L_0x05d5
            int r0 = r7.H
            r6 = 8
            r1 = 1
            if (r0 != r1) goto L_0x05c6
            float r5 = r7.I
            r0 = r54
            r1 = r33
            r2 = r38
            r3 = r30
            r4 = r31
            r0.k(r1, r2, r3, r4, r5, r6)
            goto L_0x05d5
        L_0x05c6:
            float r5 = r7.I
            r0 = r54
            r1 = r30
            r2 = r31
            r3 = r33
            r4 = r38
            r0.k(r1, r2, r3, r4, r5, r6)
        L_0x05d5:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r7.X
            boolean r0 = r0.o()
            if (r0 == 0) goto L_0x05fd
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r7.X
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.j()
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.h()
            float r1 = r7.K
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r7.X
            int r2 = r2.f()
            r3 = r54
            r3.b(r7, r0, r1, r2)
        L_0x05fd:
            r0 = 0
            r7.p = r0
            r7.q = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.g(androidx.constraintlayout.core.LinearSystem, boolean):void");
    }

    public void g0(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2, int i3) {
        q(type).b(constraintWidget.q(type2), i2, i3, true);
    }

    public void g1(ConstraintWidget constraintWidget) {
        this.c0 = constraintWidget;
    }

    public boolean h() {
        return this.u0 != 8;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r2 = r2[r3 + 1];
        r3 = r2.f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h0(int r3) {
        /*
            r2 = this;
            int r3 = r3 * 2
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r2.Y
            r0 = r2[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f
            if (r1 == 0) goto L_0x001b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f
            if (r1 == r0) goto L_0x001b
            r0 = 1
            int r3 = r3 + r0
            r2 = r2[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.f
            if (r3 == 0) goto L_0x001b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f
            if (r3 != r2) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.h0(int):boolean");
    }

    public void h1(float f2) {
        this.r0 = f2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x03a3 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x03f4  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x040a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x040b  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x044d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x0497  */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x04fd  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(androidx.constraintlayout.core.LinearSystem r32, boolean r33, boolean r34, boolean r35, boolean r36, androidx.constraintlayout.core.SolverVariable r37, androidx.constraintlayout.core.SolverVariable r38, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r39, boolean r40, androidx.constraintlayout.core.widgets.ConstraintAnchor r41, androidx.constraintlayout.core.widgets.ConstraintAnchor r42, int r43, int r44, int r45, int r46, float r47, boolean r48, boolean r49, boolean r50, boolean r51, boolean r52, int r53, int r54, int r55, int r56, float r57, boolean r58) {
        /*
            r31 = this;
            r0 = r31
            r10 = r32
            r11 = r37
            r12 = r38
            r13 = r41
            r14 = r42
            r15 = r45
            r1 = r46
            r2 = r54
            r3 = r55
            r4 = r56
            androidx.constraintlayout.core.SolverVariable r9 = r10.q(r13)
            androidx.constraintlayout.core.SolverVariable r8 = r10.q(r14)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r41.j()
            androidx.constraintlayout.core.SolverVariable r7 = r10.q(r5)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r42.j()
            androidx.constraintlayout.core.SolverVariable r6 = r10.q(r5)
            androidx.constraintlayout.core.Metrics r5 = androidx.constraintlayout.core.LinearSystem.x()
            if (r5 == 0) goto L_0x0040
            androidx.constraintlayout.core.Metrics r5 = androidx.constraintlayout.core.LinearSystem.x()
            long r11 = r5.w
            r16 = 1
            long r11 = r11 + r16
            r5.w = r11
        L_0x0040:
            boolean r11 = r41.o()
            boolean r12 = r42.o()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.X
            boolean r16 = r5.o()
            if (r12 == 0) goto L_0x0053
            int r5 = r11 + 1
            goto L_0x0054
        L_0x0053:
            r5 = r11
        L_0x0054:
            if (r16 == 0) goto L_0x0058
            int r5 = r5 + 1
        L_0x0058:
            if (r48 == 0) goto L_0x005d
            r18 = 3
            goto L_0x005f
        L_0x005d:
            r18 = r53
        L_0x005f:
            int[] r17 = androidx.constraintlayout.core.widgets.ConstraintWidget.AnonymousClass1.b
            int r19 = r39.ordinal()
            r2 = r17[r19]
            r14 = 1
            if (r2 == r14) goto L_0x0073
            r14 = 2
            if (r2 == r14) goto L_0x0073
            r14 = 3
            if (r2 == r14) goto L_0x0073
            r14 = 4
            if (r2 == r14) goto L_0x0078
        L_0x0073:
            r2 = r18
        L_0x0075:
            r18 = 0
            goto L_0x007e
        L_0x0078:
            r2 = r18
            if (r2 == r14) goto L_0x0075
            r18 = 1
        L_0x007e:
            int r14 = r0.l
            r13 = -1
            if (r14 == r13) goto L_0x008c
            if (r33 == 0) goto L_0x008c
            r0.l = r13
            r21 = r6
            r18 = 0
            goto L_0x0090
        L_0x008c:
            r14 = r44
            r21 = r6
        L_0x0090:
            int r6 = r0.m
            if (r6 == r13) goto L_0x009b
            if (r33 != 0) goto L_0x009b
            r0.m = r13
            r14 = r6
            r18 = 0
        L_0x009b:
            int r6 = r0.u0
            r13 = 8
            if (r6 != r13) goto L_0x00a4
            r14 = 0
            r18 = 0
        L_0x00a4:
            if (r58 == 0) goto L_0x00bd
            if (r11 != 0) goto L_0x00b2
            if (r12 != 0) goto L_0x00b2
            if (r16 != 0) goto L_0x00b2
            r6 = r43
            r10.f(r9, r6)
            goto L_0x00bd
        L_0x00b2:
            if (r11 == 0) goto L_0x00bd
            if (r12 != 0) goto L_0x00bd
            int r6 = r41.f()
            r10.e(r9, r7, r6, r13)
        L_0x00bd:
            if (r18 != 0) goto L_0x00ea
            if (r40 == 0) goto L_0x00d6
            r6 = 3
            r13 = 0
            r10.e(r8, r9, r13, r6)
            r6 = 8
            if (r15 <= 0) goto L_0x00cd
            r10.h(r8, r9, r15, r6)
        L_0x00cd:
            r14 = 2147483647(0x7fffffff, float:NaN)
            if (r1 >= r14) goto L_0x00db
            r10.j(r8, r9, r1, r6)
            goto L_0x00db
        L_0x00d6:
            r6 = r13
            r13 = 0
            r10.e(r8, r9, r14, r6)
        L_0x00db:
            r1 = r4
            r40 = r5
            r13 = r7
            r15 = r8
            r23 = r18
            r14 = r21
            r18 = r36
            r21 = r3
            goto L_0x01e0
        L_0x00ea:
            r1 = 2
            r13 = 0
            if (r5 == r1) goto L_0x0113
            if (r48 != 0) goto L_0x0113
            r1 = 1
            if (r2 == r1) goto L_0x00f5
            if (r2 != 0) goto L_0x0113
        L_0x00f5:
            int r1 = java.lang.Math.max(r3, r14)
            if (r4 <= 0) goto L_0x00ff
            int r1 = java.lang.Math.min(r4, r1)
        L_0x00ff:
            r6 = 8
            r10.e(r8, r9, r1, r6)
            r18 = r36
            r1 = r4
            r40 = r5
            r15 = r8
            r23 = r13
            r14 = r21
            r21 = r3
            r13 = r7
            goto L_0x01e0
        L_0x0113:
            r1 = -2
            if (r3 != r1) goto L_0x0118
            r6 = r14
            goto L_0x0119
        L_0x0118:
            r6 = r3
        L_0x0119:
            if (r4 != r1) goto L_0x011d
            r1 = r14
            goto L_0x011e
        L_0x011d:
            r1 = r4
        L_0x011e:
            if (r14 <= 0) goto L_0x0124
            r3 = 1
            if (r2 == r3) goto L_0x0124
            r14 = r13
        L_0x0124:
            r3 = 8
            if (r6 <= 0) goto L_0x012f
            r10.h(r8, r9, r6, r3)
            int r14 = java.lang.Math.max(r14, r6)
        L_0x012f:
            r4 = 1
            if (r1 <= 0) goto L_0x013e
            if (r34 == 0) goto L_0x0137
            if (r2 != r4) goto L_0x0137
            goto L_0x013a
        L_0x0137:
            r10.j(r8, r9, r1, r3)
        L_0x013a:
            int r14 = java.lang.Math.min(r14, r1)
        L_0x013e:
            if (r2 != r4) goto L_0x0166
            if (r34 == 0) goto L_0x0147
            r10.e(r8, r9, r14, r3)
            r4 = 5
            goto L_0x0158
        L_0x0147:
            if (r50 == 0) goto L_0x0151
            r4 = 5
            r10.e(r8, r9, r14, r4)
            r10.j(r8, r9, r14, r3)
            goto L_0x0158
        L_0x0151:
            r4 = 5
            r10.e(r8, r9, r14, r4)
            r10.j(r8, r9, r14, r3)
        L_0x0158:
            r40 = r5
            r13 = r7
            r15 = r8
            r23 = r18
            r14 = r21
            r18 = r36
            r21 = r6
            goto L_0x01e0
        L_0x0166:
            r4 = 5
            r14 = 2
            if (r2 != r14) goto L_0x01d4
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = r41.k()
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            if (r3 == r4) goto L_0x0197
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = r41.k()
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r13 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            if (r3 != r13) goto L_0x017b
            goto L_0x0197
        L_0x017b:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.q(r4)
            androidx.constraintlayout.core.SolverVariable r3 = r10.q(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r13 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.q(r13)
            androidx.constraintlayout.core.SolverVariable r4 = r10.q(r4)
        L_0x0193:
            r23 = r3
            r13 = r4
            goto L_0x01ae
        L_0x0197:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.q(r4)
            androidx.constraintlayout.core.SolverVariable r3 = r10.q(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r13 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.q(r13)
            androidx.constraintlayout.core.SolverVariable r4 = r10.q(r4)
            goto L_0x0193
        L_0x01ae:
            androidx.constraintlayout.core.ArrayRow r3 = r32.r()
            r24 = 5
            r4 = r8
            r14 = r5
            r5 = r9
            r40 = r14
            r14 = r21
            r21 = r6
            r6 = r13
            r13 = r7
            r7 = r23
            r15 = r8
            r8 = r57
            androidx.constraintlayout.core.ArrayRow r3 = r3.k(r4, r5, r6, r7, r8)
            r10.d(r3)
            if (r34 == 0) goto L_0x01cf
            r18 = 0
        L_0x01cf:
            r23 = r18
            r18 = r36
            goto L_0x01e0
        L_0x01d4:
            r40 = r5
            r13 = r7
            r15 = r8
            r14 = r21
            r21 = r6
            r23 = r18
            r18 = 1
        L_0x01e0:
            if (r58 == 0) goto L_0x04fd
            if (r50 == 0) goto L_0x01f0
            r1 = r37
            r4 = r38
            r5 = r40
            r2 = r15
            r3 = 0
            r6 = 2
            r15 = r9
            goto L_0x0507
        L_0x01f0:
            if (r11 != 0) goto L_0x01fb
            if (r12 != 0) goto L_0x01fb
            if (r16 != 0) goto L_0x01fb
            r2 = r15
            r1 = 5
            r3 = 0
            goto L_0x04c8
        L_0x01fb:
            if (r11 == 0) goto L_0x0217
            if (r12 != 0) goto L_0x0217
            r7 = r41
            r8 = 0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r7.f
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.d
            if (r34 == 0) goto L_0x020f
            boolean r1 = r1 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 == 0) goto L_0x020f
            r13 = 8
            goto L_0x0210
        L_0x020f:
            r13 = 5
        L_0x0210:
            r22 = r34
            r3 = r8
            r6 = r13
            r2 = r15
            goto L_0x04cb
        L_0x0217:
            r7 = r41
            r8 = 0
            if (r11 != 0) goto L_0x0250
            if (r12 == 0) goto L_0x0250
            int r1 = r42.f()
            int r1 = -r1
            r2 = 8
            r10.e(r15, r14, r1, r2)
            if (r34 == 0) goto L_0x0241
            boolean r1 = r0.j
            if (r1 == 0) goto L_0x0246
            boolean r1 = r9.g
            if (r1 == 0) goto L_0x0246
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.c0
            if (r1 == 0) goto L_0x0246
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r1
            if (r33 == 0) goto L_0x023e
            r1.D1(r7)
            goto L_0x0241
        L_0x023e:
            r1.I1(r7)
        L_0x0241:
            r3 = r8
            r2 = r15
            r1 = 5
            goto L_0x04c8
        L_0x0246:
            r6 = r37
            r1 = 5
            r10.h(r9, r6, r8, r1)
            r3 = r8
            r2 = r15
            goto L_0x04c8
        L_0x0250:
            r6 = r37
            if (r11 == 0) goto L_0x0241
            if (r12 == 0) goto L_0x0241
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r7.f
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r3.d
            r12 = r42
            r3 = 2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r12.f
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r4.d
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r31.M()
            r16 = 6
            if (r23 == 0) goto L_0x0361
            if (r2 != 0) goto L_0x02bf
            if (r1 != 0) goto L_0x0294
            if (r21 != 0) goto L_0x0294
            boolean r1 = r13.g
            if (r1 == 0) goto L_0x0289
            boolean r1 = r14.g
            if (r1 == 0) goto L_0x0289
            int r0 = r41.f()
            r1 = 8
            r10.e(r9, r13, r0, r1)
            int r0 = r42.f()
            int r0 = -r0
            r10.e(r15, r14, r0, r1)
            return
        L_0x0289:
            r19 = r8
            r24 = r19
            r1 = 8
            r3 = 8
            r22 = 1
            goto L_0x029c
        L_0x0294:
            r22 = r8
            r1 = 5
            r3 = 5
            r19 = 1
            r24 = 1
        L_0x029c:
            boolean r8 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r8 != 0) goto L_0x02b2
            boolean r8 = r5 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r8 == 0) goto L_0x02a5
            goto L_0x02b2
        L_0x02a5:
            r8 = r38
            r25 = r22
            r22 = r19
            r19 = r3
        L_0x02ad:
            r3 = r1
            r1 = r16
            goto L_0x03a1
        L_0x02b2:
            r8 = r38
            r3 = r1
            r1 = r16
            r25 = r22
            r22 = r19
            r19 = 4
            goto L_0x03a1
        L_0x02bf:
            if (r2 != r3) goto L_0x02e1
            boolean r1 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 != 0) goto L_0x02d9
            boolean r1 = r5 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 == 0) goto L_0x02ca
            goto L_0x02d9
        L_0x02ca:
            r8 = r38
            r1 = r16
            r3 = 5
            r19 = 5
        L_0x02d1:
            r22 = 1
            r24 = 1
        L_0x02d5:
            r25 = 0
            goto L_0x03a1
        L_0x02d9:
            r8 = r38
            r1 = r16
            r3 = 5
        L_0x02de:
            r19 = 4
            goto L_0x02d1
        L_0x02e1:
            r8 = 1
            if (r2 != r8) goto L_0x02eb
            r8 = r38
            r1 = r16
            r3 = 8
            goto L_0x02de
        L_0x02eb:
            r8 = 3
            if (r2 != r8) goto L_0x0354
            int r8 = r0.H
            r3 = -1
            if (r8 != r3) goto L_0x030d
            if (r51 == 0) goto L_0x0308
            r8 = r38
            if (r34 == 0) goto L_0x0306
            r1 = 5
        L_0x02fa:
            r3 = 8
        L_0x02fc:
            r19 = 5
        L_0x02fe:
            r22 = 1
            r24 = 1
            r25 = 1
            goto L_0x03a1
        L_0x0306:
            r1 = 4
            goto L_0x02fa
        L_0x0308:
            r8 = r38
            r1 = 8
            goto L_0x02fa
        L_0x030d:
            if (r48 == 0) goto L_0x0329
            r3 = r54
            r8 = 2
            if (r3 == r8) goto L_0x031c
            r1 = 1
            if (r3 != r1) goto L_0x0318
            goto L_0x031c
        L_0x0318:
            r1 = 8
            r3 = 5
            goto L_0x031e
        L_0x031c:
            r1 = 5
            r3 = 4
        L_0x031e:
            r8 = r38
            r19 = r3
            r22 = 1
            r24 = 1
            r25 = 1
            goto L_0x02ad
        L_0x0329:
            if (r1 <= 0) goto L_0x0331
            r8 = r38
            r1 = r16
            r3 = 5
            goto L_0x02fc
        L_0x0331:
            if (r1 != 0) goto L_0x034e
            if (r21 != 0) goto L_0x034e
            if (r51 != 0) goto L_0x033f
            r8 = r38
            r1 = r16
            r3 = 5
            r19 = 8
            goto L_0x02fe
        L_0x033f:
            if (r11 == r4) goto L_0x0345
            if (r5 == r4) goto L_0x0345
            r1 = 4
            goto L_0x0346
        L_0x0345:
            r1 = 5
        L_0x0346:
            r8 = r38
            r3 = r1
            r1 = r16
        L_0x034b:
            r19 = 4
            goto L_0x02fe
        L_0x034e:
            r8 = r38
            r1 = r16
            r3 = 5
            goto L_0x034b
        L_0x0354:
            r8 = r38
            r1 = r16
            r3 = 5
            r19 = 4
            r22 = 0
            r24 = 0
            goto L_0x02d5
        L_0x0361:
            boolean r1 = r13.g
            if (r1 == 0) goto L_0x02d9
            boolean r1 = r14.g
            if (r1 == 0) goto L_0x02d9
            int r0 = r41.f()
            int r1 = r42.f()
            r2 = 8
            r48 = r32
            r49 = r9
            r50 = r13
            r51 = r0
            r52 = r47
            r53 = r14
            r54 = r15
            r55 = r1
            r56 = r2
            r48.c(r49, r50, r51, r52, r53, r54, r55, r56)
            if (r34 == 0) goto L_0x03a0
            if (r18 == 0) goto L_0x03a0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r12.f
            if (r0 == 0) goto L_0x0397
            int r13 = r42.f()
            r8 = r38
            goto L_0x039a
        L_0x0397:
            r8 = r38
            r13 = 0
        L_0x039a:
            if (r14 == r8) goto L_0x03a0
            r0 = 5
            r10.h(r8, r15, r13, r0)
        L_0x03a0:
            return
        L_0x03a1:
            if (r24 == 0) goto L_0x03ac
            if (r13 != r14) goto L_0x03ac
            if (r11 == r4) goto L_0x03ac
            r24 = 0
            r26 = 0
            goto L_0x03ae
        L_0x03ac:
            r26 = 1
        L_0x03ae:
            if (r22 == 0) goto L_0x03f4
            if (r23 != 0) goto L_0x03c3
            if (r49 != 0) goto L_0x03c3
            if (r51 != 0) goto L_0x03c3
            if (r13 != r6) goto L_0x03c3
            if (r14 != r8) goto L_0x03c3
            r22 = 0
            r26 = 8
            r27 = 8
            r28 = 0
            goto L_0x03cb
        L_0x03c3:
            r22 = r34
            r27 = r1
            r28 = r26
            r26 = r3
        L_0x03cb:
            int r29 = r41.f()
            int r30 = r42.f()
            r1 = r32
            r3 = r2
            r2 = r9
            r12 = r3
            r3 = r13
            r39 = r12
            r12 = r4
            r4 = r29
            r29 = r12
            r12 = r5
            r5 = r47
            r6 = r14
            r7 = r15
            r8 = r30
            r20 = r15
            r15 = r9
            r9 = r27
            r1.c(r2, r3, r4, r5, r6, r7, r8, r9)
            r3 = r26
            r26 = r28
            goto L_0x03fe
        L_0x03f4:
            r39 = r2
            r29 = r4
            r12 = r5
            r20 = r15
            r15 = r9
            r22 = r34
        L_0x03fe:
            int r1 = r0.u0
            r2 = 8
            if (r1 != r2) goto L_0x040b
            boolean r1 = r42.m()
            if (r1 != 0) goto L_0x040b
            return
        L_0x040b:
            if (r24 == 0) goto L_0x042f
            if (r22 == 0) goto L_0x041d
            if (r13 == r14) goto L_0x041d
            if (r23 != 0) goto L_0x041d
            boolean r1 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 != 0) goto L_0x041b
            boolean r1 = r12 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 == 0) goto L_0x041d
        L_0x041b:
            r3 = r16
        L_0x041d:
            int r1 = r41.f()
            r10.h(r15, r13, r1, r3)
            int r1 = r42.f()
            int r1 = -r1
            r2 = r20
            r10.j(r2, r14, r1, r3)
            goto L_0x0431
        L_0x042f:
            r2 = r20
        L_0x0431:
            if (r22 == 0) goto L_0x0447
            if (r52 == 0) goto L_0x0447
            boolean r1 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 != 0) goto L_0x0447
            boolean r1 = r12 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 != 0) goto L_0x0447
            r1 = r29
            if (r12 == r1) goto L_0x0449
            r3 = r16
            r4 = r3
            r26 = 1
            goto L_0x044b
        L_0x0447:
            r1 = r29
        L_0x0449:
            r4 = r19
        L_0x044b:
            if (r26 == 0) goto L_0x0495
            if (r25 == 0) goto L_0x0475
            if (r51 == 0) goto L_0x0453
            if (r35 == 0) goto L_0x0475
        L_0x0453:
            if (r11 == r1) goto L_0x045a
            if (r12 != r1) goto L_0x0458
            goto L_0x045a
        L_0x0458:
            r6 = r4
            goto L_0x045c
        L_0x045a:
            r6 = r16
        L_0x045c:
            boolean r5 = r11 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r5 != 0) goto L_0x0464
            boolean r5 = r12 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r5 == 0) goto L_0x0465
        L_0x0464:
            r6 = 5
        L_0x0465:
            boolean r5 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r5 != 0) goto L_0x046d
            boolean r5 = r12 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r5 == 0) goto L_0x046e
        L_0x046d:
            r6 = 5
        L_0x046e:
            if (r51 == 0) goto L_0x0471
            r6 = 5
        L_0x0471:
            int r4 = java.lang.Math.max(r6, r4)
        L_0x0475:
            if (r22 == 0) goto L_0x0486
            int r3 = java.lang.Math.min(r3, r4)
            if (r48 == 0) goto L_0x0485
            if (r51 != 0) goto L_0x0485
            if (r11 == r1) goto L_0x0483
            if (r12 != r1) goto L_0x0485
        L_0x0483:
            r4 = 4
            goto L_0x0486
        L_0x0485:
            r4 = r3
        L_0x0486:
            int r1 = r41.f()
            r10.e(r15, r13, r1, r4)
            int r1 = r42.f()
            int r1 = -r1
            r10.e(r2, r14, r1, r4)
        L_0x0495:
            if (r22 == 0) goto L_0x04a7
            r1 = r37
            if (r1 != r13) goto L_0x04a0
            int r3 = r41.f()
            goto L_0x04a1
        L_0x04a0:
            r3 = 0
        L_0x04a1:
            if (r13 == r1) goto L_0x04a7
            r4 = 5
            r10.h(r15, r1, r3, r4)
        L_0x04a7:
            if (r22 == 0) goto L_0x04c4
            if (r23 == 0) goto L_0x04c4
            if (r45 != 0) goto L_0x04c4
            if (r21 != 0) goto L_0x04c4
            if (r23 == 0) goto L_0x04be
            r3 = r39
            r1 = 3
            if (r3 != r1) goto L_0x04be
            r1 = 8
            r3 = 0
            r10.h(r2, r15, r3, r1)
            r1 = 5
            goto L_0x04c6
        L_0x04be:
            r3 = 0
            r1 = 5
            r10.h(r2, r15, r3, r1)
            goto L_0x04c6
        L_0x04c4:
            r1 = 5
            r3 = 0
        L_0x04c6:
            r6 = r1
            goto L_0x04cb
        L_0x04c8:
            r22 = r34
            goto L_0x04c6
        L_0x04cb:
            if (r22 == 0) goto L_0x04fc
            if (r18 == 0) goto L_0x04fc
            r1 = r42
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r1.f
            if (r4 == 0) goto L_0x04dc
            int r13 = r42.f()
            r4 = r38
            goto L_0x04df
        L_0x04dc:
            r4 = r38
            r13 = r3
        L_0x04df:
            if (r14 == r4) goto L_0x04fc
            boolean r3 = r0.j
            if (r3 == 0) goto L_0x04f9
            boolean r3 = r2.g
            if (r3 == 0) goto L_0x04f9
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.c0
            if (r0 == 0) goto L_0x04f9
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r0
            if (r33 == 0) goto L_0x04f5
            r0.C1(r1)
            goto L_0x04f8
        L_0x04f5:
            r0.H1(r1)
        L_0x04f8:
            return
        L_0x04f9:
            r10.h(r4, r2, r13, r6)
        L_0x04fc:
            return
        L_0x04fd:
            r1 = r37
            r4 = r38
            r2 = r15
            r3 = 0
            r15 = r9
            r5 = r40
            r6 = 2
        L_0x0507:
            if (r5 >= r6) goto L_0x0548
            if (r34 == 0) goto L_0x0548
            if (r18 == 0) goto L_0x0548
            r5 = 8
            r10.h(r15, r1, r3, r5)
            if (r33 != 0) goto L_0x051d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.U
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f
            if (r1 != 0) goto L_0x051b
            goto L_0x051d
        L_0x051b:
            r13 = r3
            goto L_0x051e
        L_0x051d:
            r13 = 1
        L_0x051e:
            if (r33 != 0) goto L_0x0540
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.U
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f
            if (r0 == 0) goto L_0x0540
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.d
            float r1 = r0.f0
            r5 = 0
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x053e
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r0.b0
            r1 = r0[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r5) goto L_0x053e
            r1 = 1
            r0 = r0[r1]
            if (r0 != r5) goto L_0x053e
            r14 = r1
            goto L_0x0541
        L_0x053e:
            r14 = r3
            goto L_0x0541
        L_0x0540:
            r14 = r13
        L_0x0541:
            if (r14 == 0) goto L_0x0548
            r0 = 8
            r10.h(r4, r2, r3, r0)
        L_0x0548:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.i(androidx.constraintlayout.core.LinearSystem, boolean, boolean, boolean, boolean, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public boolean i0() {
        return this.r;
    }

    public void i1(int i2) {
        this.K0 = i2;
    }

    public void j(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        k(type, constraintWidget, type2, 0);
    }

    public boolean j0(int i2) {
        return this.a0[i2];
    }

    public void j1(int i2, int i3) {
        this.i0 = i2;
        int i4 = i3 - i2;
        this.e0 = i4;
        int i5 = this.p0;
        if (i4 < i5) {
            this.e0 = i5;
        }
    }

    public void k(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z2;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type != type5) {
            ConstraintAnchor.Type type6 = ConstraintAnchor.Type.CENTER_X;
            if (type == type6 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
                ConstraintAnchor q2 = q(type4);
                ConstraintAnchor q3 = constraintWidget.q(type2);
                ConstraintAnchor q4 = q(ConstraintAnchor.Type.RIGHT);
                q2.a(q3, 0);
                q4.a(q3, 0);
                q(type6).a(q3, 0);
                return;
            }
            ConstraintAnchor.Type type7 = ConstraintAnchor.Type.CENTER_Y;
            if (type == type7 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
                ConstraintAnchor q5 = constraintWidget.q(type2);
                q(type3).a(q5, 0);
                q(ConstraintAnchor.Type.BOTTOM).a(q5, 0);
                q(type7).a(q5, 0);
            } else if (type == type6 && type2 == type6) {
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.LEFT;
                q(type8).a(constraintWidget.q(type8), 0);
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.RIGHT;
                q(type9).a(constraintWidget.q(type9), 0);
                q(type6).a(constraintWidget.q(type2), 0);
            } else if (type == type7 && type2 == type7) {
                ConstraintAnchor.Type type10 = ConstraintAnchor.Type.TOP;
                q(type10).a(constraintWidget.q(type10), 0);
                ConstraintAnchor.Type type11 = ConstraintAnchor.Type.BOTTOM;
                q(type11).a(constraintWidget.q(type11), 0);
                q(type7).a(constraintWidget.q(type2), 0);
            } else {
                ConstraintAnchor q6 = q(type);
                ConstraintAnchor q7 = constraintWidget.q(type2);
                if (q6.p(q7)) {
                    ConstraintAnchor.Type type12 = ConstraintAnchor.Type.BASELINE;
                    if (type == type12) {
                        ConstraintAnchor q8 = q(ConstraintAnchor.Type.TOP);
                        ConstraintAnchor q9 = q(ConstraintAnchor.Type.BOTTOM);
                        if (q8 != null) {
                            q8.q();
                        }
                        if (q9 != null) {
                            q9.q();
                        }
                    } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                        ConstraintAnchor q10 = q(type12);
                        if (q10 != null) {
                            q10.q();
                        }
                        ConstraintAnchor q11 = q(type5);
                        if (q11.j() != q7) {
                            q11.q();
                        }
                        ConstraintAnchor g2 = q(type).g();
                        ConstraintAnchor q12 = q(type7);
                        if (q12.o()) {
                            g2.q();
                            q12.q();
                        }
                    } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                        ConstraintAnchor q13 = q(type5);
                        if (q13.j() != q7) {
                            q13.q();
                        }
                        ConstraintAnchor g3 = q(type).g();
                        ConstraintAnchor q14 = q(type6);
                        if (q14.o()) {
                            g3.q();
                            q14.q();
                        }
                    }
                    q6.a(q7, i2);
                }
            }
        } else if (type2 == type5) {
            ConstraintAnchor.Type type13 = ConstraintAnchor.Type.LEFT;
            ConstraintAnchor q15 = q(type13);
            ConstraintAnchor.Type type14 = ConstraintAnchor.Type.RIGHT;
            ConstraintAnchor q16 = q(type14);
            ConstraintAnchor.Type type15 = ConstraintAnchor.Type.TOP;
            ConstraintAnchor q17 = q(type15);
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.BOTTOM;
            ConstraintAnchor q18 = q(type16);
            boolean z3 = true;
            if ((q15 == null || !q15.o()) && (q16 == null || !q16.o())) {
                k(type13, constraintWidget, type13, 0);
                k(type14, constraintWidget, type14, 0);
                z2 = true;
            } else {
                z2 = false;
            }
            if ((q17 == null || !q17.o()) && (q18 == null || !q18.o())) {
                k(type15, constraintWidget, type15, 0);
                k(type16, constraintWidget, type16, 0);
            } else {
                z3 = false;
            }
            if (z2 && z3) {
                q(type5).a(constraintWidget.q(type5), 0);
            } else if (z2) {
                ConstraintAnchor.Type type17 = ConstraintAnchor.Type.CENTER_X;
                q(type17).a(constraintWidget.q(type17), 0);
            } else if (z3) {
                ConstraintAnchor.Type type18 = ConstraintAnchor.Type.CENTER_Y;
                q(type18).a(constraintWidget.q(type18), 0);
            }
        } else {
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.LEFT;
            if (type2 == type19 || type2 == ConstraintAnchor.Type.RIGHT) {
                k(type19, constraintWidget, type2, 0);
                k(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                q(type5).a(constraintWidget.q(type2), 0);
                return;
            }
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.TOP;
            if (type2 == type20 || type2 == ConstraintAnchor.Type.BOTTOM) {
                k(type20, constraintWidget, type2, 0);
                k(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                q(type5).a(constraintWidget.q(type2), 0);
            }
        }
    }

    public boolean k0() {
        ConstraintAnchor constraintAnchor = this.Q;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f;
        if (constraintAnchor2 != null && constraintAnchor2.f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.S;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f;
        return constraintAnchor4 != null && constraintAnchor4.f == constraintAnchor3;
    }

    public void k1(DimensionBehaviour dimensionBehaviour) {
        this.b0[1] = dimensionBehaviour;
    }

    public void l(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2) {
        if (constraintAnchor.h() == this) {
            k(constraintAnchor.k(), constraintAnchor2.h(), constraintAnchor2.k(), i2);
        }
    }

    public boolean l0() {
        return this.M;
    }

    public void l1(int i2, int i3, int i4, float f2) {
        this.x = i2;
        this.C = i3;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.D = i4;
        this.E = f2;
        if (f2 > 0.0f && f2 < 1.0f && i2 == 0) {
            this.x = 2;
        }
    }

    public void m(ConstraintWidget constraintWidget, float f2, int i2) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        g0(type, constraintWidget, type, i2, 0);
        this.K = f2;
    }

    public boolean m0() {
        ConstraintAnchor constraintAnchor = this.R;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f;
        if (constraintAnchor2 != null && constraintAnchor2.f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.T;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f;
        return constraintAnchor4 != null && constraintAnchor4.f == constraintAnchor3;
    }

    public void m1(float f2) {
        this.N0[1] = f2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: androidx.constraintlayout.core.widgets.ConstraintWidget} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n(androidx.constraintlayout.core.widgets.ConstraintWidget r7, java.util.HashMap r8) {
        /*
            r6 = this;
            int r0 = r7.t
            r6.t = r0
            int r0 = r7.u
            r6.u = r0
            int r0 = r7.w
            r6.w = r0
            int r0 = r7.x
            r6.x = r0
            int[] r0 = r6.y
            int[] r1 = r7.y
            r2 = 0
            r3 = r1[r2]
            r0[r2] = r3
            r3 = 1
            r1 = r1[r3]
            r0[r3] = r1
            int r0 = r7.z
            r6.z = r0
            int r0 = r7.A
            r6.A = r0
            int r0 = r7.C
            r6.C = r0
            int r0 = r7.D
            r6.D = r0
            float r0 = r7.E
            r6.E = r0
            boolean r0 = r7.F
            r6.F = r0
            boolean r0 = r7.G
            r6.G = r0
            int r0 = r7.H
            r6.H = r0
            float r0 = r7.I
            r6.I = r0
            int[] r0 = r7.J
            int r1 = r0.length
            int[] r0 = java.util.Arrays.copyOf(r0, r1)
            r6.J = r0
            float r0 = r7.K
            r6.K = r0
            boolean r0 = r7.L
            r6.L = r0
            boolean r0 = r7.M
            r6.M = r0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.Q
            r0.q()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.R
            r0.q()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.S
            r0.q()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.T
            r0.q()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.U
            r0.q()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.V
            r0.q()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.W
            r0.q()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.X
            r0.q()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r6.b0
            r1 = 2
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = (androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour[]) r0
            r6.b0 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r6.c0
            r1 = 0
            if (r0 != 0) goto L_0x0091
            r0 = r1
            goto L_0x0099
        L_0x0091:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r7.c0
            java.lang.Object r0 = r8.get(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r0
        L_0x0099:
            r6.c0 = r0
            int r0 = r7.d0
            r6.d0 = r0
            int r0 = r7.e0
            r6.e0 = r0
            float r0 = r7.f0
            r6.f0 = r0
            int r0 = r7.g0
            r6.g0 = r0
            int r0 = r7.h0
            r6.h0 = r0
            int r0 = r7.i0
            r6.i0 = r0
            int r0 = r7.j0
            r6.j0 = r0
            int r0 = r7.k0
            r6.k0 = r0
            int r0 = r7.l0
            r6.l0 = r0
            int r0 = r7.m0
            r6.m0 = r0
            int r0 = r7.n0
            r6.n0 = r0
            int r0 = r7.o0
            r6.o0 = r0
            int r0 = r7.p0
            r6.p0 = r0
            float r0 = r7.q0
            r6.q0 = r0
            float r0 = r7.r0
            r6.r0 = r0
            java.lang.Object r0 = r7.s0
            r6.s0 = r0
            int r0 = r7.t0
            r6.t0 = r0
            int r0 = r7.u0
            r6.u0 = r0
            boolean r0 = r7.v0
            r6.v0 = r0
            java.lang.String r0 = r7.w0
            r6.w0 = r0
            java.lang.String r0 = r7.x0
            r6.x0 = r0
            int r0 = r7.y0
            r6.y0 = r0
            int r0 = r7.z0
            r6.z0 = r0
            int r0 = r7.A0
            r6.A0 = r0
            int r0 = r7.B0
            r6.B0 = r0
            boolean r0 = r7.C0
            r6.C0 = r0
            boolean r0 = r7.D0
            r6.D0 = r0
            boolean r0 = r7.E0
            r6.E0 = r0
            boolean r0 = r7.F0
            r6.F0 = r0
            boolean r0 = r7.G0
            r6.G0 = r0
            boolean r0 = r7.H0
            r6.H0 = r0
            int r0 = r7.J0
            r6.J0 = r0
            int r0 = r7.K0
            r6.K0 = r0
            boolean r0 = r7.L0
            r6.L0 = r0
            boolean r0 = r7.M0
            r6.M0 = r0
            float[] r0 = r6.N0
            float[] r4 = r7.N0
            r5 = r4[r2]
            r0[r2] = r5
            r4 = r4[r3]
            r0[r3] = r4
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r6.O0
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r4 = r7.O0
            r5 = r4[r2]
            r0[r2] = r5
            r4 = r4[r3]
            r0[r3] = r4
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r6.P0
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r4 = r7.P0
            r5 = r4[r2]
            r0[r2] = r5
            r2 = r4[r3]
            r0[r3] = r2
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r7.Q0
            if (r0 != 0) goto L_0x0151
            r0 = r1
            goto L_0x0157
        L_0x0151:
            java.lang.Object r0 = r8.get(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r0
        L_0x0157:
            r6.Q0 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r7.R0
            if (r7 != 0) goto L_0x015e
            goto L_0x0165
        L_0x015e:
            java.lang.Object r7 = r8.get(r7)
            r1 = r7
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r1
        L_0x0165:
            r6.R0 = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.n(androidx.constraintlayout.core.widgets.ConstraintWidget, java.util.HashMap):void");
    }

    public boolean n0() {
        return this.N;
    }

    public void n1(int i2) {
        this.u0 = i2;
    }

    public void o(LinearSystem linearSystem) {
        linearSystem.q(this.Q);
        linearSystem.q(this.R);
        linearSystem.q(this.S);
        linearSystem.q(this.T);
        if (this.n0 > 0) {
            linearSystem.q(this.U);
        }
    }

    public boolean o0() {
        return this.i && this.u0 != 8;
    }

    public void o1(int i2) {
        this.d0 = i2;
        int i3 = this.o0;
        if (i2 < i3) {
            this.d0 = i3;
        }
    }

    public void p() {
        if (this.e == null) {
            this.e = new HorizontalWidgetRun(this);
        }
        if (this.f == null) {
            this.f = new VerticalWidgetRun(this);
        }
    }

    public boolean p0() {
        return this.p || (this.Q.n() && this.S.n());
    }

    public void p1(int i2) {
        if (i2 >= 0 && i2 <= 3) {
            this.v = i2;
        }
    }

    public ConstraintAnchor q(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.f531a[type.ordinal()]) {
            case 1:
                return this.Q;
            case 2:
                return this.R;
            case 3:
                return this.S;
            case 4:
                return this.T;
            case 5:
                return this.U;
            case 6:
                return this.X;
            case 7:
                return this.V;
            case 8:
                return this.W;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public boolean q0() {
        return this.q || (this.R.n() && this.T.n());
    }

    public void q1(int i2) {
        this.h0 = i2;
    }

    public int r() {
        return this.n0;
    }

    public boolean r0() {
        return this.s;
    }

    public void r1(int i2) {
        this.i0 = i2;
    }

    public float s(int i2) {
        if (i2 == 0) {
            return this.q0;
        }
        if (i2 == 1) {
            return this.r0;
        }
        return -1.0f;
    }

    public void s0() {
        this.r = true;
    }

    public void s1(boolean z2, boolean z3, boolean z4, boolean z5) {
        if (this.H == -1) {
            if (z4 && !z5) {
                this.H = 0;
            } else if (!z4 && z5) {
                this.H = 1;
                if (this.g0 == -1) {
                    this.I = 1.0f / this.I;
                }
            }
        }
        if (this.H == 0 && (!this.R.o() || !this.T.o())) {
            this.H = 1;
        } else if (this.H == 1 && (!this.Q.o() || !this.S.o())) {
            this.H = 0;
        }
        if (this.H == -1 && (!this.R.o() || !this.T.o() || !this.Q.o() || !this.S.o())) {
            if (this.R.o() && this.T.o()) {
                this.H = 0;
            } else if (this.Q.o() && this.S.o()) {
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
        if (this.H == -1) {
            int i2 = this.z;
            if (i2 > 0 && this.C == 0) {
                this.H = 0;
            } else if (i2 == 0 && this.C > 0) {
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
    }

    public int t() {
        return a0() + this.e0;
    }

    public void t0() {
        this.s = true;
    }

    public void t1(boolean z2, boolean z3) {
        int i2;
        int i3;
        boolean k2 = z2 & this.e.k();
        boolean k3 = z3 & this.f.k();
        HorizontalWidgetRun horizontalWidgetRun = this.e;
        int i4 = horizontalWidgetRun.h.g;
        VerticalWidgetRun verticalWidgetRun = this.f;
        int i5 = verticalWidgetRun.h.g;
        int i6 = horizontalWidgetRun.i.g;
        int i7 = verticalWidgetRun.i.g;
        int i8 = i7 - i5;
        if (i6 - i4 < 0 || i8 < 0 || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE) {
            i6 = 0;
            i4 = 0;
            i7 = 0;
            i5 = 0;
        }
        int i9 = i6 - i4;
        int i10 = i7 - i5;
        if (k2) {
            this.h0 = i4;
        }
        if (k3) {
            this.i0 = i5;
        }
        if (this.u0 == 8) {
            this.d0 = 0;
            this.e0 = 0;
            return;
        }
        if (k2) {
            if (this.b0[0] == DimensionBehaviour.FIXED && i9 < (i3 = this.d0)) {
                i9 = i3;
            }
            this.d0 = i9;
            int i11 = this.o0;
            if (i9 < i11) {
                this.d0 = i11;
            }
        }
        if (k3) {
            if (this.b0[1] == DimensionBehaviour.FIXED && i10 < (i2 = this.e0)) {
                i10 = i2;
            }
            this.e0 = i10;
            int i12 = this.p0;
            if (i10 < i12) {
                this.e0 = i12;
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.x0 != null) {
            str = "type: " + this.x0 + " ";
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.w0 != null) {
            str2 = "id: " + this.w0 + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.h0);
        sb.append(", ");
        sb.append(this.i0);
        sb.append(") - (");
        sb.append(this.d0);
        sb.append(" x ");
        sb.append(this.e0);
        sb.append(")");
        return sb.toString();
    }

    public Object u() {
        return this.s0;
    }

    public boolean u0() {
        DimensionBehaviour[] dimensionBehaviourArr = this.b0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public void u1(LinearSystem linearSystem, boolean z2) {
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int y2 = linearSystem.y(this.Q);
        int y3 = linearSystem.y(this.R);
        int y4 = linearSystem.y(this.S);
        int y5 = linearSystem.y(this.T);
        if (z2 && (horizontalWidgetRun = this.e) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun.h;
            if (dependencyNode.j) {
                DependencyNode dependencyNode2 = horizontalWidgetRun.i;
                if (dependencyNode2.j) {
                    y2 = dependencyNode.g;
                    y4 = dependencyNode2.g;
                }
            }
        }
        if (z2 && (verticalWidgetRun = this.f) != null) {
            DependencyNode dependencyNode3 = verticalWidgetRun.h;
            if (dependencyNode3.j) {
                DependencyNode dependencyNode4 = verticalWidgetRun.i;
                if (dependencyNode4.j) {
                    y3 = dependencyNode3.g;
                    y5 = dependencyNode4.g;
                }
            }
        }
        int i2 = y5 - y3;
        if (y4 - y2 < 0 || i2 < 0 || y2 == Integer.MIN_VALUE || y2 == Integer.MAX_VALUE || y3 == Integer.MIN_VALUE || y3 == Integer.MAX_VALUE || y4 == Integer.MIN_VALUE || y4 == Integer.MAX_VALUE || y5 == Integer.MIN_VALUE || y5 == Integer.MAX_VALUE) {
            y2 = 0;
            y5 = 0;
            y3 = 0;
            y4 = 0;
        }
        N0(y2, y3, y4, y5);
    }

    public String v() {
        return this.w0;
    }

    public void v0() {
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.W.q();
        this.X.q();
        this.c0 = null;
        this.K = 0.0f;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0.0f;
        this.g0 = -1;
        this.h0 = 0;
        this.i0 = 0;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = 0;
        this.p0 = 0;
        float f2 = U0;
        this.q0 = f2;
        this.r0 = f2;
        DimensionBehaviour[] dimensionBehaviourArr = this.b0;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.s0 = null;
        this.t0 = 0;
        this.u0 = 0;
        this.x0 = null;
        this.G0 = false;
        this.H0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.L0 = false;
        this.M0 = false;
        float[] fArr = this.N0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.t = -1;
        this.u = -1;
        int[] iArr = this.J;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.w = 0;
        this.x = 0;
        this.B = 1.0f;
        this.E = 1.0f;
        this.A = Integer.MAX_VALUE;
        this.D = Integer.MAX_VALUE;
        this.z = 0;
        this.C = 0;
        this.h = false;
        this.H = -1;
        this.I = 1.0f;
        this.I0 = false;
        boolean[] zArr = this.g;
        zArr[0] = true;
        zArr[1] = true;
        this.N = false;
        boolean[] zArr2 = this.a0;
        zArr2[0] = false;
        zArr2[1] = false;
        this.i = true;
        int[] iArr2 = this.y;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.l = -1;
        this.m = -1;
    }

    public DimensionBehaviour w(int i2) {
        if (i2 == 0) {
            return C();
        }
        if (i2 == 1) {
            return V();
        }
        return null;
    }

    public void w0() {
        x0();
        h1(U0);
        Q0(U0);
    }

    public float x() {
        return this.f0;
    }

    public void x0() {
        ConstraintWidget M2 = M();
        if (M2 == null || !(M2 instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) M()).Q1()) {
            int size = this.Z.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((ConstraintAnchor) this.Z.get(i2)).q();
            }
        }
    }

    public int y() {
        return this.g0;
    }

    public void y0() {
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        int size = this.Z.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ConstraintAnchor) this.Z.get(i2)).r();
        }
    }

    public int z() {
        if (this.u0 == 8) {
            return 0;
        }
        return this.e0;
    }

    public void z0(Cache cache) {
        this.Q.s(cache);
        this.R.s(cache);
        this.S.s(cache);
        this.T.s(cache);
        this.U.s(cache);
        this.X.s(cache);
        this.V.s(cache);
        this.W.s(cache);
    }
}
