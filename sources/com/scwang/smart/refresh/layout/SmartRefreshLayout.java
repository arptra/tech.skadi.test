package com.scwang.smart.refresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.scwang.smart.refresh.layout.api.RefreshComponent;
import com.scwang.smart.refresh.layout.api.RefreshContent;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshKernel;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.DimensionStatus;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;
import com.scwang.smart.refresh.layout.kernel.R;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshInitializer;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnMultiListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.scwang.smart.refresh.layout.listener.ScrollBoundaryDecider;
import com.scwang.smart.refresh.layout.util.SmartUtil;
import com.scwang.smart.refresh.layout.wrapper.RefreshContentWrapper;

@SuppressLint({"RestrictedApi"})
public class SmartRefreshLayout extends ViewGroup implements RefreshLayout, NestedScrollingParent {
    public static DefaultRefreshFooterCreator U0;
    public static DefaultRefreshHeaderCreator V0;
    public static DefaultRefreshInitializer W0;
    public static ViewGroup.MarginLayoutParams X0 = new ViewGroup.MarginLayoutParams(-1, -1);
    public int[] A;
    public float A0;
    public boolean B;
    public RefreshComponent B0;
    public boolean C;
    public RefreshComponent C0;
    public boolean D;
    public RefreshContent D0;
    public boolean E;
    public Paint E0;
    public boolean F;
    public Handler F0;
    public boolean G;
    public RefreshKernel G0;
    public boolean H;
    public RefreshState H0;
    public boolean I;
    public RefreshState I0;
    public boolean J;
    public long J0;
    public boolean K;
    public int K0;
    public boolean L;
    public int L0;
    public boolean M;
    public boolean M0;
    public boolean N;
    public boolean N0;
    public boolean O;
    public boolean O0;
    public boolean P;
    public boolean P0;
    public boolean Q;
    public boolean Q0;
    public boolean R;
    public MotionEvent R0;
    public boolean S;
    public Runnable S0;
    public boolean T;
    public ValueAnimator T0;
    public boolean U;
    public boolean V;
    public boolean W;

    /* renamed from: a  reason: collision with root package name */
    public int f9841a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public boolean g0;
    public float h;
    public OnRefreshListener h0;
    public float i;
    public OnLoadMoreListener i0;
    public float j;
    public OnMultiListener j0;
    public float k;
    public ScrollBoundaryDecider k0;
    public float l;
    public int l0;
    public char m;
    public boolean m0;
    public boolean n;
    public int[] n0;
    public boolean o;
    public NestedScrollingChildHelper o0;
    public boolean p;
    public NestedScrollingParentHelper p0;
    public int q;
    public int q0;
    public int r;
    public DimensionStatus r0;
    public int s;
    public int s0;
    public int t;
    public DimensionStatus t0;
    public int u;
    public int u0;
    public int v;
    public int v0;
    public int w;
    public float w0;
    public Scroller x;
    public float x0;
    public VelocityTracker y;
    public float y0;
    public Interpolator z;
    public float z0;

    /* renamed from: com.scwang.smart.refresh.layout.SmartRefreshLayout$10  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass10 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9843a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.scwang.smart.refresh.layout.constant.RefreshState[] r0 = com.scwang.smart.refresh.layout.constant.RefreshState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9843a = r0
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9843a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9843a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.PullUpToLoad     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9843a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.PullDownCanceled     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9843a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.PullUpCanceled     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f9843a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.ReleaseToRefresh     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f9843a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.ReleaseToLoad     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f9843a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.ReleaseToTwoLevel     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f9843a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.RefreshReleased     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f9843a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.LoadReleased     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f9843a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f9843a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.Loading     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.AnonymousClass10.<clinit>():void");
        }
    }

    /* renamed from: com.scwang.smart.refresh.layout.SmartRefreshLayout$8  reason: invalid class name */
    class AnonymousClass8 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f9852a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ SmartRefreshLayout d;

        public void run() {
            SmartRefreshLayout smartRefreshLayout = this.d;
            if (smartRefreshLayout.I0 == RefreshState.Refreshing) {
                ValueAnimator valueAnimator = smartRefreshLayout.T0;
                if (valueAnimator != null) {
                    valueAnimator.setDuration(0);
                    this.d.T0.cancel();
                    this.d.T0 = null;
                }
                SmartRefreshLayout smartRefreshLayout2 = this.d;
                smartRefreshLayout2.j = ((float) smartRefreshLayout2.getMeasuredWidth()) / 2.0f;
                this.d.G0.f(RefreshState.PullDownToRefresh);
                SmartRefreshLayout smartRefreshLayout3 = this.d;
                int i = smartRefreshLayout3.q0;
                float f = i == 0 ? smartRefreshLayout3.y0 : (float) i;
                float f2 = this.f9852a;
                if (f2 < 10.0f) {
                    f2 *= f;
                }
                smartRefreshLayout3.T0 = ValueAnimator.ofInt(new int[]{smartRefreshLayout3.b, (int) f2});
                this.d.T0.setDuration((long) this.b);
                this.d.T0.setInterpolator(new SmartUtil(SmartUtil.b));
                this.d.T0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        SmartRefreshLayout smartRefreshLayout = AnonymousClass8.this.d;
                        if (smartRefreshLayout.T0 != null && smartRefreshLayout.B0 != null) {
                            smartRefreshLayout.G0.d(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
                        }
                    }
                });
                this.d.T0.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        if (animator == null || animator.getDuration() != 0) {
                            SmartRefreshLayout smartRefreshLayout = AnonymousClass8.this.d;
                            smartRefreshLayout.T0 = null;
                            if (smartRefreshLayout.B0 != null) {
                                RefreshState refreshState = smartRefreshLayout.H0;
                                RefreshState refreshState2 = RefreshState.ReleaseToRefresh;
                                if (refreshState != refreshState2) {
                                    smartRefreshLayout.G0.f(refreshState2);
                                }
                                AnonymousClass8 r4 = AnonymousClass8.this;
                                r4.d.setStateRefreshing(!r4.c);
                                return;
                            }
                            smartRefreshLayout.G0.f(RefreshState.None);
                        }
                    }
                });
                this.d.T0.start();
            }
        }
    }

    public class BounceRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public int f9858a = 0;
        public int b = 10;
        public int c;
        public long d;
        public float e = 0.0f;
        public float f;

        public BounceRunnable(float f2, int i) {
            this.f = f2;
            this.c = i;
            this.d = AnimationUtils.currentAnimationTimeMillis();
            SmartRefreshLayout.this.F0.postDelayed(this, (long) this.b);
            if (f2 > 0.0f) {
                SmartRefreshLayout.this.G0.f(RefreshState.PullDownToRefresh);
            } else {
                SmartRefreshLayout.this.G0.f(RefreshState.PullUpToLoad);
            }
        }

        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.S0 == this && !smartRefreshLayout.H0.isFinishing) {
                if (Math.abs(smartRefreshLayout.b) < Math.abs(this.c)) {
                    int i = this.f9858a + 1;
                    this.f9858a = i;
                    this.f = (float) (((double) this.f) * Math.pow(0.949999988079071d, (double) (i * 2)));
                } else if (this.c != 0) {
                    int i2 = this.f9858a + 1;
                    this.f9858a = i2;
                    this.f = (float) (((double) this.f) * Math.pow(0.44999998807907104d, (double) (i2 * 2)));
                } else {
                    int i3 = this.f9858a + 1;
                    this.f9858a = i3;
                    this.f = (float) (((double) this.f) * Math.pow(0.8500000238418579d, (double) (i3 * 2)));
                }
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float f2 = this.f * ((((float) (currentAnimationTimeMillis - this.d)) * 1.0f) / 1000.0f);
                if (Math.abs(f2) >= 1.0f) {
                    this.d = currentAnimationTimeMillis;
                    float f3 = this.e + f2;
                    this.e = f3;
                    SmartRefreshLayout.this.w(f3);
                    SmartRefreshLayout.this.F0.postDelayed(this, (long) this.b);
                    return;
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                RefreshState refreshState = smartRefreshLayout2.I0;
                boolean z = refreshState.isDragging;
                if (z && refreshState.isHeader) {
                    smartRefreshLayout2.G0.f(RefreshState.PullDownCanceled);
                } else if (z && refreshState.isFooter) {
                    smartRefreshLayout2.G0.f(RefreshState.PullUpCanceled);
                }
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                smartRefreshLayout3.S0 = null;
                if (Math.abs(smartRefreshLayout3.b) >= Math.abs(this.c)) {
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    smartRefreshLayout4.k(this.c, 0, smartRefreshLayout4.z, Math.min(Math.max((int) SmartUtil.i(Math.abs(SmartRefreshLayout.this.b - this.c)), 30), 100) * 10);
                }
            }
        }
    }

    public class FlingRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public int f9859a;
        public int b = 0;
        public int c = 10;
        public float d;
        public float e = 0.98f;
        public long f = 0;
        public long g = AnimationUtils.currentAnimationTimeMillis();

        public FlingRunnable(float f2) {
            this.d = f2;
            this.f9859a = SmartRefreshLayout.this.b;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0049, code lost:
            if (r0.b >= (-r0.s0)) goto L_0x004b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0057, code lost:
            if (r0.b > r0.q0) goto L_0x0059;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Runnable a() {
            /*
                r11 = this;
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = r0.H0
                boolean r2 = r1.isFinishing
                r3 = 0
                if (r2 == 0) goto L_0x000a
                return r3
            L_0x000a:
                int r2 = r0.b
                if (r2 == 0) goto L_0x00a7
                boolean r1 = r1.isOpening
                if (r1 != 0) goto L_0x0026
                boolean r1 = r0.T
                if (r1 == 0) goto L_0x0059
                boolean r1 = r0.H
                if (r1 == 0) goto L_0x0059
                boolean r1 = r0.U
                if (r1 == 0) goto L_0x0059
                boolean r1 = r0.C
                boolean r0 = r0.u(r1)
                if (r0 == 0) goto L_0x0059
            L_0x0026:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = r0.H0
                com.scwang.smart.refresh.layout.constant.RefreshState r2 = com.scwang.smart.refresh.layout.constant.RefreshState.Loading
                if (r1 == r2) goto L_0x0042
                boolean r1 = r0.T
                if (r1 == 0) goto L_0x004b
                boolean r1 = r0.H
                if (r1 == 0) goto L_0x004b
                boolean r1 = r0.U
                if (r1 == 0) goto L_0x004b
                boolean r1 = r0.C
                boolean r0 = r0.u(r1)
                if (r0 == 0) goto L_0x004b
            L_0x0042:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r1 = r0.b
                int r0 = r0.s0
                int r0 = -r0
                if (r1 < r0) goto L_0x0059
            L_0x004b:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = r0.H0
                com.scwang.smart.refresh.layout.constant.RefreshState r2 = com.scwang.smart.refresh.layout.constant.RefreshState.Refreshing
                if (r1 != r2) goto L_0x00a7
                int r1 = r0.b
                int r0 = r0.q0
                if (r1 <= r0) goto L_0x00a7
            L_0x0059:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r0 = r0.b
                float r1 = r11.d
                r2 = 0
                r4 = r0
            L_0x0061:
                int r5 = r0 * r4
                if (r5 <= 0) goto L_0x00a7
                double r5 = (double) r1
                float r1 = r11.e
                double r7 = (double) r1
                int r2 = r2 + 1
                int r1 = r11.c
                int r1 = r1 * r2
                float r1 = (float) r1
                r9 = 1092616192(0x41200000, float:10.0)
                float r1 = r1 / r9
                double r9 = (double) r1
                double r7 = java.lang.Math.pow(r7, r9)
                double r5 = r5 * r7
                float r1 = (float) r5
                int r5 = r11.c
                float r5 = (float) r5
                r6 = 1065353216(0x3f800000, float:1.0)
                float r5 = r5 * r6
                r7 = 1148846080(0x447a0000, float:1000.0)
                float r5 = r5 / r7
                float r5 = r5 * r1
                float r7 = java.lang.Math.abs(r5)
                int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
                if (r6 >= 0) goto L_0x00a3
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = r0.H0
                boolean r2 = r1.isOpening
                if (r2 == 0) goto L_0x00a2
                com.scwang.smart.refresh.layout.constant.RefreshState r2 = com.scwang.smart.refresh.layout.constant.RefreshState.Refreshing
                if (r1 != r2) goto L_0x009b
                int r5 = r0.q0
                if (r4 > r5) goto L_0x00a2
            L_0x009b:
                if (r1 == r2) goto L_0x00a7
                int r0 = r0.s0
                int r0 = -r0
                if (r4 >= r0) goto L_0x00a7
            L_0x00a2:
                return r3
            L_0x00a3:
                float r4 = (float) r4
                float r4 = r4 + r5
                int r4 = (int) r4
                goto L_0x0061
            L_0x00a7:
                long r0 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
                r11.f = r0
                com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                android.os.Handler r0 = r0.F0
                int r1 = r11.c
                long r1 = (long) r1
                r0.postDelayed(r11, r1)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.FlingRunnable.a():java.lang.Runnable");
        }

        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.S0 == this && !smartRefreshLayout.H0.isFinishing) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float pow = (float) (((double) this.d) * Math.pow((double) this.e, (double) (((float) (currentAnimationTimeMillis - this.f)) / (1000.0f / ((float) this.c)))));
                this.d = pow;
                float f2 = pow * ((((float) (currentAnimationTimeMillis - this.g)) * 1.0f) / 1000.0f);
                if (Math.abs(f2) > 1.0f) {
                    this.g = currentAnimationTimeMillis;
                    int i = (int) (((float) this.f9859a) + f2);
                    this.f9859a = i;
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.b * i > 0) {
                        smartRefreshLayout2.G0.d(i, true);
                        SmartRefreshLayout.this.F0.postDelayed(this, (long) this.c);
                        return;
                    }
                    smartRefreshLayout2.S0 = null;
                    smartRefreshLayout2.G0.d(0, true);
                    SmartUtil.d(SmartRefreshLayout.this.D0.h(), (int) (-this.d));
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.P0 && f2 > 0.0f) {
                        smartRefreshLayout3.P0 = false;
                        return;
                    }
                    return;
                }
                SmartRefreshLayout.this.S0 = null;
            }
        }
    }

    public class RefreshKernelImpl implements RefreshKernel {

        /* renamed from: com.scwang.smart.refresh.layout.SmartRefreshLayout$RefreshKernelImpl$1  reason: invalid class name */
        class AnonymousClass1 extends AnimatorListenerAdapter {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RefreshKernelImpl f9862a;

            public void onAnimationEnd(Animator animator) {
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout.this.G0.f(RefreshState.TwoLevel);
                }
            }
        }

        public RefreshKernelImpl() {
        }

        public ValueAnimator a(int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.k(i, 0, smartRefreshLayout.z, smartRefreshLayout.f);
        }

        public RefreshLayout b() {
            return SmartRefreshLayout.this;
        }

        public RefreshKernel c() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.H0 == RefreshState.TwoLevel) {
                smartRefreshLayout.G0.f(RefreshState.TwoLevelFinish);
                if (SmartRefreshLayout.this.b == 0) {
                    d(0, false);
                    SmartRefreshLayout.this.x(RefreshState.None);
                } else {
                    a(0).setDuration((long) SmartRefreshLayout.this.e);
                }
            }
            return this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:72:0x00ff, code lost:
            r3 = r3.B0;
         */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00a3  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00b8  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.scwang.smart.refresh.layout.api.RefreshKernel d(int r19, boolean r20) {
            /*
                r18 = this;
                r0 = r18
                r1 = r19
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r3 = r2.b
                if (r3 != r1) goto L_0x0021
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.B0
                if (r2 == 0) goto L_0x0014
                boolean r2 = r2.e()
                if (r2 != 0) goto L_0x0021
            L_0x0014:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.C0
                if (r2 == 0) goto L_0x0020
                boolean r2 = r2.e()
                if (r2 != 0) goto L_0x0021
            L_0x0020:
                return r0
            L_0x0021:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r9 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r10 = r9.b
                r9.b = r1
                r11 = 1092616192(0x41200000, float:10.0)
                if (r20 == 0) goto L_0x0085
                com.scwang.smart.refresh.layout.constant.RefreshState r2 = r9.I0
                boolean r3 = r2.isDragging
                if (r3 != 0) goto L_0x0035
                boolean r2 = r2.isOpening
                if (r2 == 0) goto L_0x0085
            L_0x0035:
                float r2 = (float) r1
                float r3 = r9.y0
                int r4 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
                if (r4 >= 0) goto L_0x0040
                int r4 = r9.q0
                float r4 = (float) r4
                float r3 = r3 * r4
            L_0x0040:
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 <= 0) goto L_0x0052
                com.scwang.smart.refresh.layout.constant.RefreshState r2 = r9.H0
                com.scwang.smart.refresh.layout.constant.RefreshState r3 = com.scwang.smart.refresh.layout.constant.RefreshState.ReleaseToTwoLevel
                if (r2 == r3) goto L_0x0085
                com.scwang.smart.refresh.layout.api.RefreshKernel r2 = r9.G0
                com.scwang.smart.refresh.layout.constant.RefreshState r3 = com.scwang.smart.refresh.layout.constant.RefreshState.ReleaseToRefresh
                r2.f(r3)
                goto L_0x0085
            L_0x0052:
                int r2 = -r1
                float r2 = (float) r2
                float r3 = r9.z0
                int r4 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
                if (r4 >= 0) goto L_0x005e
                int r4 = r9.s0
                float r4 = (float) r4
                float r3 = r3 * r4
            L_0x005e:
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 <= 0) goto L_0x006e
                boolean r2 = r9.T
                if (r2 != 0) goto L_0x006e
                com.scwang.smart.refresh.layout.api.RefreshKernel r2 = r9.G0
                com.scwang.smart.refresh.layout.constant.RefreshState r3 = com.scwang.smart.refresh.layout.constant.RefreshState.ReleaseToLoad
                r2.f(r3)
                goto L_0x0085
            L_0x006e:
                if (r1 >= 0) goto L_0x007c
                boolean r2 = r9.T
                if (r2 != 0) goto L_0x007c
                com.scwang.smart.refresh.layout.api.RefreshKernel r2 = r9.G0
                com.scwang.smart.refresh.layout.constant.RefreshState r3 = com.scwang.smart.refresh.layout.constant.RefreshState.PullUpToLoad
                r2.f(r3)
                goto L_0x0085
            L_0x007c:
                if (r1 <= 0) goto L_0x0085
                com.scwang.smart.refresh.layout.api.RefreshKernel r2 = r9.G0
                com.scwang.smart.refresh.layout.constant.RefreshState r3 = com.scwang.smart.refresh.layout.constant.RefreshState.PullDownToRefresh
                r2.f(r3)
            L_0x0085:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshContent r3 = r2.D0
                r13 = 0
                if (r3 == 0) goto L_0x0140
                if (r1 < 0) goto L_0x009f
                boolean r3 = r2.F
                com.scwang.smart.refresh.layout.api.RefreshComponent r4 = r2.B0
                boolean r2 = r2.v(r3, r4)
                if (r2 == 0) goto L_0x009b
                r2 = r1
            L_0x0099:
                r3 = 1
                goto L_0x00a1
            L_0x009b:
                if (r10 >= 0) goto L_0x009f
                r2 = r13
                goto L_0x0099
            L_0x009f:
                r2 = r13
                r3 = r2
            L_0x00a1:
                if (r1 > 0) goto L_0x00b6
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r5 = r4.G
                com.scwang.smart.refresh.layout.api.RefreshComponent r6 = r4.C0
                boolean r4 = r4.v(r5, r6)
                if (r4 == 0) goto L_0x00b2
                r2 = r1
            L_0x00b0:
                r3 = 1
                goto L_0x00b6
            L_0x00b2:
                if (r10 <= 0) goto L_0x00b6
                r2 = r13
                goto L_0x00b0
            L_0x00b6:
                if (r3 == 0) goto L_0x0140
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshContent r4 = r3.D0
                int r5 = r3.s
                int r3 = r3.t
                r4.d(r2, r5, r3)
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r4 = r3.T
                if (r4 == 0) goto L_0x00f9
                boolean r4 = r3.U
                if (r4 == 0) goto L_0x00f9
                boolean r4 = r3.H
                if (r4 == 0) goto L_0x00f9
                com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r3.C0
                boolean r4 = r3 instanceof com.scwang.smart.refresh.layout.api.RefreshFooter
                if (r4 == 0) goto L_0x00f9
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r3 = r3.getSpinnerStyle()
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r4 = com.scwang.smart.refresh.layout.constant.SpinnerStyle.d
                if (r3 != r4) goto L_0x00f9
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r4 = r3.C
                boolean r3 = r3.u(r4)
                if (r3 == 0) goto L_0x00f9
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r3.C0
                android.view.View r3 = r3.getView()
                int r4 = java.lang.Math.max(r13, r2)
                float r4 = (float) r4
                r3.setTranslationY(r4)
            L_0x00f9:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r4 = r3.D
                if (r4 == 0) goto L_0x010c
                com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r3.B0
                if (r3 == 0) goto L_0x010c
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r3 = r3.getSpinnerStyle()
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r4 = com.scwang.smart.refresh.layout.constant.SpinnerStyle.f
                if (r3 != r4) goto L_0x010c
                goto L_0x0112
            L_0x010c:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r3 = r3.K0
                if (r3 == 0) goto L_0x0114
            L_0x0112:
                r3 = 1
                goto L_0x0115
            L_0x0114:
                r3 = r13
            L_0x0115:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                boolean r5 = r4.E
                if (r5 == 0) goto L_0x0128
                com.scwang.smart.refresh.layout.api.RefreshComponent r4 = r4.C0
                if (r4 == 0) goto L_0x0128
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r4 = r4.getSpinnerStyle()
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r5 = com.scwang.smart.refresh.layout.constant.SpinnerStyle.f
                if (r4 != r5) goto L_0x0128
                goto L_0x012e
            L_0x0128:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r4 = r4.L0
                if (r4 == 0) goto L_0x0130
            L_0x012e:
                r4 = 1
                goto L_0x0131
            L_0x0130:
                r4 = r13
            L_0x0131:
                if (r3 == 0) goto L_0x0137
                if (r2 >= 0) goto L_0x013d
                if (r10 > 0) goto L_0x013d
            L_0x0137:
                if (r4 == 0) goto L_0x0140
                if (r2 <= 0) goto L_0x013d
                if (r10 >= 0) goto L_0x0140
            L_0x013d:
                r9.invalidate()
            L_0x0140:
                r14 = 1065353216(0x3f800000, float:1.0)
                r15 = 1073741824(0x40000000, float:2.0)
                if (r1 >= 0) goto L_0x0148
                if (r10 <= 0) goto L_0x0269
            L_0x0148:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.B0
                if (r2 == 0) goto L_0x0269
                int r8 = java.lang.Math.max(r1, r13)
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r7 = r2.q0
                float r3 = r2.w0
                int r4 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
                if (r4 >= 0) goto L_0x015e
                float r4 = (float) r7
                float r3 = r3 * r4
            L_0x015e:
                int r6 = (int) r3
                float r3 = (float) r8
                float r3 = r3 * r14
                float r4 = r2.y0
                int r5 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
                if (r5 >= 0) goto L_0x0169
                float r5 = (float) r7
                float r4 = r4 * r5
            L_0x0169:
                float r16 = r3 / r4
                boolean r3 = r2.B
                boolean r2 = r2.u(r3)
                if (r2 != 0) goto L_0x0183
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r2 = r2.H0
                com.scwang.smart.refresh.layout.constant.RefreshState r3 = com.scwang.smart.refresh.layout.constant.RefreshState.RefreshFinish
                if (r2 != r3) goto L_0x017e
                if (r20 != 0) goto L_0x017e
                goto L_0x0183
            L_0x017e:
                r12 = r6
                r17 = r7
                goto L_0x0249
            L_0x0183:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r3 = r2.b
                if (r10 == r3) goto L_0x0221
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.B0
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r2 = r2.getSpinnerStyle()
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r3 = com.scwang.smart.refresh.layout.constant.SpinnerStyle.d
                if (r2 != r3) goto L_0x01bb
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.B0
                android.view.View r2 = r2.getView()
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r3 = r3.b
                float r3 = (float) r3
                r2.setTranslationY(r3)
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r3 = r2.K0
                if (r3 == 0) goto L_0x020f
                android.graphics.Paint r3 = r2.E0
                if (r3 == 0) goto L_0x020f
                boolean r3 = r2.F
                com.scwang.smart.refresh.layout.api.RefreshComponent r4 = r2.B0
                boolean r2 = r2.v(r3, r4)
                if (r2 != 0) goto L_0x020f
                r9.invalidate()
                goto L_0x020f
            L_0x01bb:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.B0
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r2 = r2.getSpinnerStyle()
                boolean r2 = r2.c
                if (r2 == 0) goto L_0x020f
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.B0
                android.view.View r2 = r2.getView()
                android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
                boolean r4 = r3 instanceof android.view.ViewGroup.MarginLayoutParams
                if (r4 == 0) goto L_0x01da
                android.view.ViewGroup$MarginLayoutParams r3 = (android.view.ViewGroup.MarginLayoutParams) r3
                goto L_0x01dc
            L_0x01da:
                android.view.ViewGroup$MarginLayoutParams r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.X0
            L_0x01dc:
                int r4 = r2.getMeasuredWidth()
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r15)
                com.scwang.smart.refresh.layout.SmartRefreshLayout r5 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r5 = r5.b
                int r12 = r3.bottomMargin
                int r5 = r5 - r12
                int r12 = r3.topMargin
                int r5 = r5 - r12
                int r5 = java.lang.Math.max(r5, r13)
                int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r15)
                r2.measure(r4, r5)
                int r4 = r3.leftMargin
                int r3 = r3.topMargin
                com.scwang.smart.refresh.layout.SmartRefreshLayout r5 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r5 = r5.u0
                int r3 = r3 + r5
                int r5 = r2.getMeasuredWidth()
                int r5 = r5 + r4
                int r12 = r2.getMeasuredHeight()
                int r12 = r12 + r3
                r2.layout(r4, r3, r5, r12)
            L_0x020f:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.B0
                r3 = r20
                r4 = r16
                r5 = r8
                r12 = r6
                r6 = r7
                r17 = r7
                r7 = r12
                r2.h(r3, r4, r5, r6, r7)
                goto L_0x0224
            L_0x0221:
                r12 = r6
                r17 = r7
            L_0x0224:
                if (r20 == 0) goto L_0x0249
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.B0
                boolean r2 = r2.e()
                if (r2 == 0) goto L_0x0249
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r2 = r2.j
                int r2 = (int) r2
                int r3 = r9.getWidth()
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r5 = r4.j
                if (r3 != 0) goto L_0x0241
                r6 = 1
                goto L_0x0242
            L_0x0241:
                r6 = r3
            L_0x0242:
                float r6 = (float) r6
                float r5 = r5 / r6
                com.scwang.smart.refresh.layout.api.RefreshComponent r4 = r4.B0
                r4.d(r5, r2, r3)
            L_0x0249:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r3 = r2.b
                if (r10 == r3) goto L_0x0269
                com.scwang.smart.refresh.layout.listener.OnMultiListener r3 = r2.j0
                if (r3 == 0) goto L_0x0269
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.B0
                boolean r4 = r2 instanceof com.scwang.smart.refresh.layout.api.RefreshHeader
                if (r4 == 0) goto L_0x0269
                r4 = r2
                com.scwang.smart.refresh.layout.api.RefreshHeader r4 = (com.scwang.smart.refresh.layout.api.RefreshHeader) r4
                r2 = r3
                r3 = r4
                r4 = r20
                r5 = r16
                r6 = r8
                r7 = r17
                r8 = r12
                r2.onHeaderMoving(r3, r4, r5, r6, r7, r8)
            L_0x0269:
                if (r1 <= 0) goto L_0x026d
                if (r10 >= 0) goto L_0x0386
            L_0x026d:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r2.C0
                if (r2 == 0) goto L_0x0386
                int r1 = java.lang.Math.min(r1, r13)
                int r7 = -r1
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r8 = r1.s0
                float r2 = r1.x0
                int r3 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
                if (r3 >= 0) goto L_0x0284
                float r3 = (float) r8
                float r2 = r2 * r3
            L_0x0284:
                int r12 = (int) r2
                float r2 = (float) r7
                float r2 = r2 * r14
                float r3 = r1.z0
                int r4 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
                if (r4 >= 0) goto L_0x028f
                float r4 = (float) r8
                float r3 = r3 * r4
            L_0x028f:
                float r11 = r2 / r3
                boolean r2 = r1.C
                boolean r1 = r1.u(r2)
                if (r1 != 0) goto L_0x02a3
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = r1.H0
                com.scwang.smart.refresh.layout.constant.RefreshState r2 = com.scwang.smart.refresh.layout.constant.RefreshState.LoadFinish
                if (r1 != r2) goto L_0x0368
                if (r20 != 0) goto L_0x0368
            L_0x02a3:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r2 = r1.b
                if (r10 == r2) goto L_0x0343
                com.scwang.smart.refresh.layout.api.RefreshComponent r1 = r1.C0
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r1 = r1.getSpinnerStyle()
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r2 = com.scwang.smart.refresh.layout.constant.SpinnerStyle.d
                if (r1 != r2) goto L_0x02db
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r1 = r1.C0
                android.view.View r1 = r1.getView()
                com.scwang.smart.refresh.layout.SmartRefreshLayout r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r2 = r2.b
                float r2 = (float) r2
                r1.setTranslationY(r2)
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r2 = r1.L0
                if (r2 == 0) goto L_0x0336
                android.graphics.Paint r2 = r1.E0
                if (r2 == 0) goto L_0x0336
                boolean r2 = r1.G
                com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r1.C0
                boolean r1 = r1.v(r2, r3)
                if (r1 != 0) goto L_0x0336
                r9.invalidate()
                goto L_0x0336
            L_0x02db:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r1 = r1.C0
                com.scwang.smart.refresh.layout.constant.SpinnerStyle r1 = r1.getSpinnerStyle()
                boolean r1 = r1.c
                if (r1 == 0) goto L_0x0336
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r1 = r1.C0
                android.view.View r1 = r1.getView()
                android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
                boolean r3 = r2 instanceof android.view.ViewGroup.MarginLayoutParams
                if (r3 == 0) goto L_0x02fa
                android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
                goto L_0x02fc
            L_0x02fa:
                android.view.ViewGroup$MarginLayoutParams r2 = com.scwang.smart.refresh.layout.SmartRefreshLayout.X0
            L_0x02fc:
                int r3 = r1.getMeasuredWidth()
                int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r15)
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r4 = r4.b
                int r4 = -r4
                int r5 = r2.bottomMargin
                int r4 = r4 - r5
                int r5 = r2.topMargin
                int r4 = r4 - r5
                int r4 = java.lang.Math.max(r4, r13)
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r15)
                r1.measure(r3, r4)
                int r3 = r2.leftMargin
                int r2 = r2.topMargin
                int r4 = r9.getMeasuredHeight()
                int r2 = r2 + r4
                com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r4 = r4.v0
                int r2 = r2 - r4
                int r4 = r1.getMeasuredHeight()
                int r4 = r2 - r4
                int r5 = r1.getMeasuredWidth()
                int r5 = r5 + r3
                r1.layout(r3, r4, r5, r2)
            L_0x0336:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r1 = r1.C0
                r2 = r20
                r3 = r11
                r4 = r7
                r5 = r8
                r6 = r12
                r1.h(r2, r3, r4, r5, r6)
            L_0x0343:
                if (r20 == 0) goto L_0x0368
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                com.scwang.smart.refresh.layout.api.RefreshComponent r1 = r1.C0
                boolean r1 = r1.e()
                if (r1 == 0) goto L_0x0368
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r1 = r1.j
                int r1 = (int) r1
                int r2 = r9.getWidth()
                com.scwang.smart.refresh.layout.SmartRefreshLayout r3 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                float r4 = r3.j
                if (r2 != 0) goto L_0x0360
                r5 = 1
                goto L_0x0361
            L_0x0360:
                r5 = r2
            L_0x0361:
                float r5 = (float) r5
                float r4 = r4 / r5
                com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r3.C0
                r3.d(r4, r1, r2)
            L_0x0368:
                com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                int r2 = r1.b
                if (r10 == r2) goto L_0x0386
                com.scwang.smart.refresh.layout.listener.OnMultiListener r2 = r1.j0
                if (r2 == 0) goto L_0x0386
                com.scwang.smart.refresh.layout.api.RefreshComponent r1 = r1.C0
                boolean r3 = r1 instanceof com.scwang.smart.refresh.layout.api.RefreshFooter
                if (r3 == 0) goto L_0x0386
                r3 = r1
                com.scwang.smart.refresh.layout.api.RefreshFooter r3 = (com.scwang.smart.refresh.layout.api.RefreshFooter) r3
                r1 = r2
                r2 = r3
                r3 = r20
                r4 = r11
                r5 = r7
                r6 = r8
                r7 = r12
                r1.onFooterMoving(r2, r3, r4, r5, r6, r7)
            L_0x0386:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.RefreshKernelImpl.d(int, boolean):com.scwang.smart.refresh.layout.api.RefreshKernel");
        }

        public RefreshKernel e(RefreshComponent refreshComponent, int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.E0 == null && i != 0) {
                smartRefreshLayout.E0 = new Paint();
            }
            if (refreshComponent.equals(SmartRefreshLayout.this.B0)) {
                SmartRefreshLayout.this.K0 = i;
            } else if (refreshComponent.equals(SmartRefreshLayout.this.C0)) {
                SmartRefreshLayout.this.L0 = i;
            }
            return this;
        }

        public RefreshKernel f(RefreshState refreshState) {
            switch (AnonymousClass10.f9843a[refreshState.ordinal()]) {
                case 1:
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    RefreshState refreshState2 = smartRefreshLayout.H0;
                    RefreshState refreshState3 = RefreshState.None;
                    if (refreshState2 != refreshState3 && smartRefreshLayout.b == 0) {
                        smartRefreshLayout.x(refreshState3);
                        return null;
                    } else if (smartRefreshLayout.b == 0) {
                        return null;
                    } else {
                        a(0);
                        return null;
                    }
                case 2:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.H0.isOpening || !smartRefreshLayout2.u(smartRefreshLayout2.B)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
                        return null;
                    }
                    SmartRefreshLayout.this.x(RefreshState.PullDownToRefresh);
                    return null;
                case 3:
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.u(smartRefreshLayout3.C)) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        RefreshState refreshState4 = smartRefreshLayout4.H0;
                        if (!refreshState4.isOpening && !refreshState4.isFinishing && (!smartRefreshLayout4.T || !smartRefreshLayout4.H || !smartRefreshLayout4.U)) {
                            smartRefreshLayout4.x(RefreshState.PullUpToLoad);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpToLoad);
                    return null;
                case 4:
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.H0.isOpening || !smartRefreshLayout5.u(smartRefreshLayout5.B)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
                        return null;
                    }
                    SmartRefreshLayout.this.x(RefreshState.PullDownCanceled);
                    f(RefreshState.None);
                    return null;
                case 5:
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.u(smartRefreshLayout6.C)) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (!smartRefreshLayout7.H0.isOpening && (!smartRefreshLayout7.T || !smartRefreshLayout7.H || !smartRefreshLayout7.U)) {
                            smartRefreshLayout7.x(RefreshState.PullUpCanceled);
                            f(RefreshState.None);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpCanceled);
                    return null;
                case 6:
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (smartRefreshLayout8.H0.isOpening || !smartRefreshLayout8.u(smartRefreshLayout8.B)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
                        return null;
                    }
                    SmartRefreshLayout.this.x(RefreshState.ReleaseToRefresh);
                    return null;
                case 7:
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.u(smartRefreshLayout9.C)) {
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        RefreshState refreshState5 = smartRefreshLayout10.H0;
                        if (!refreshState5.isOpening && !refreshState5.isFinishing && (!smartRefreshLayout10.T || !smartRefreshLayout10.H || !smartRefreshLayout10.U)) {
                            smartRefreshLayout10.x(RefreshState.ReleaseToLoad);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToLoad);
                    return null;
                case 8:
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (smartRefreshLayout11.H0.isOpening || !smartRefreshLayout11.u(smartRefreshLayout11.B)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
                        return null;
                    }
                    SmartRefreshLayout.this.x(RefreshState.ReleaseToTwoLevel);
                    return null;
                case 9:
                    SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                    if (smartRefreshLayout12.H0.isOpening || !smartRefreshLayout12.u(smartRefreshLayout12.B)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.RefreshReleased);
                        return null;
                    }
                    SmartRefreshLayout.this.x(RefreshState.RefreshReleased);
                    return null;
                case 10:
                    SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                    if (smartRefreshLayout13.H0.isOpening || !smartRefreshLayout13.u(smartRefreshLayout13.C)) {
                        SmartRefreshLayout.this.setViceState(RefreshState.LoadReleased);
                        return null;
                    }
                    SmartRefreshLayout.this.x(RefreshState.LoadReleased);
                    return null;
                case 11:
                    SmartRefreshLayout.this.setStateRefreshing(true);
                    return null;
                case 12:
                    SmartRefreshLayout.this.setStateLoading(true);
                    return null;
                default:
                    SmartRefreshLayout.this.x(refreshState);
                    return null;
            }
        }
    }

    public SmartRefreshLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public static void setDefaultRefreshFooterCreator(@NonNull DefaultRefreshFooterCreator defaultRefreshFooterCreator) {
        U0 = defaultRefreshFooterCreator;
    }

    public static void setDefaultRefreshHeaderCreator(@NonNull DefaultRefreshHeaderCreator defaultRefreshHeaderCreator) {
        V0 = defaultRefreshHeaderCreator;
    }

    public static void setDefaultRefreshInitializer(@NonNull DefaultRefreshInitializer defaultRefreshInitializer) {
        W0 = defaultRefreshInitializer;
    }

    public RefreshLayout A(boolean z2) {
        RefreshState refreshState = this.H0;
        if (refreshState == RefreshState.Refreshing && z2) {
            s();
        } else if (refreshState == RefreshState.Loading && z2) {
            p();
        } else if (this.T != z2) {
            this.T = z2;
            RefreshComponent refreshComponent = this.C0;
            if (refreshComponent instanceof RefreshFooter) {
                if (((RefreshFooter) refreshComponent).a(z2)) {
                    this.U = true;
                    if (this.T && this.H && this.b > 0 && this.C0.getSpinnerStyle() == SpinnerStyle.d && u(this.C) && v(this.B, this.B0)) {
                        this.C0.getView().setTranslationY((float) this.b);
                    }
                } else {
                    this.U = false;
                    new RuntimeException("Footer:" + this.C0 + " NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])").printStackTrace();
                }
            }
        }
        return this;
    }

    public RefreshLayout B(OnMultiListener onMultiListener) {
        this.j0 = onMultiListener;
        return this;
    }

    public RefreshLayout C(RefreshFooter refreshFooter) {
        return D(refreshFooter, 0, 0);
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.scwang.smart.refresh.layout.api.RefreshLayout D(com.scwang.smart.refresh.layout.api.RefreshFooter r3, int r4, int r5) {
        /*
            r2 = this;
            com.scwang.smart.refresh.layout.api.RefreshComponent r0 = r2.C0
            if (r0 == 0) goto L_0x000b
            android.view.View r0 = r0.getView()
            super.removeView(r0)
        L_0x000b:
            r2.C0 = r3
            r0 = 0
            r2.P0 = r0
            r2.L0 = r0
            r2.U = r0
            r2.N0 = r0
            com.scwang.smart.refresh.layout.constant.DimensionStatus r1 = com.scwang.smart.refresh.layout.constant.DimensionStatus.c
            r2.t0 = r1
            boolean r1 = r2.V
            if (r1 == 0) goto L_0x0025
            boolean r1 = r2.C
            if (r1 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r1 = r0
            goto L_0x0026
        L_0x0025:
            r1 = 1
        L_0x0026:
            r2.C = r1
            if (r4 != 0) goto L_0x002b
            r4 = -1
        L_0x002b:
            if (r5 != 0) goto L_0x002e
            r5 = -2
        L_0x002e:
            com.scwang.smart.refresh.layout.SmartRefreshLayout$LayoutParams r1 = new com.scwang.smart.refresh.layout.SmartRefreshLayout$LayoutParams
            r1.<init>((int) r4, (int) r5)
            android.view.View r3 = r3.getView()
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            boolean r4 = r3 instanceof com.scwang.smart.refresh.layout.SmartRefreshLayout.LayoutParams
            if (r4 == 0) goto L_0x0042
            r1 = r3
            com.scwang.smart.refresh.layout.SmartRefreshLayout$LayoutParams r1 = (com.scwang.smart.refresh.layout.SmartRefreshLayout.LayoutParams) r1
        L_0x0042:
            com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r2.C0
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r3 = r3.getSpinnerStyle()
            boolean r3 = r3.b
            if (r3 == 0) goto L_0x005a
            com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r2.C0
            android.view.View r3 = r3.getView()
            int r4 = r2.getChildCount()
            super.addView(r3, r4, r1)
            goto L_0x0063
        L_0x005a:
            com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r2.C0
            android.view.View r3 = r3.getView()
            super.addView(r3, r0, r1)
        L_0x0063:
            int[] r3 = r2.A
            if (r3 == 0) goto L_0x006e
            com.scwang.smart.refresh.layout.api.RefreshComponent r4 = r2.C0
            if (r4 == 0) goto L_0x006e
            r4.setPrimaryColors(r3)
        L_0x006e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.D(com.scwang.smart.refresh.layout.api.RefreshFooter, int, int):com.scwang.smart.refresh.layout.api.RefreshLayout");
    }

    public RefreshLayout E(RefreshHeader refreshHeader) {
        return F(refreshHeader, 0, 0);
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.scwang.smart.refresh.layout.api.RefreshLayout F(com.scwang.smart.refresh.layout.api.RefreshHeader r3, int r4, int r5) {
        /*
            r2 = this;
            com.scwang.smart.refresh.layout.api.RefreshComponent r0 = r2.B0
            if (r0 == 0) goto L_0x000b
            android.view.View r0 = r0.getView()
            super.removeView(r0)
        L_0x000b:
            r2.B0 = r3
            r0 = 0
            r2.K0 = r0
            r2.M0 = r0
            com.scwang.smart.refresh.layout.constant.DimensionStatus r1 = com.scwang.smart.refresh.layout.constant.DimensionStatus.c
            r2.r0 = r1
            if (r4 != 0) goto L_0x0019
            r4 = -1
        L_0x0019:
            if (r5 != 0) goto L_0x001c
            r5 = -2
        L_0x001c:
            com.scwang.smart.refresh.layout.SmartRefreshLayout$LayoutParams r1 = new com.scwang.smart.refresh.layout.SmartRefreshLayout$LayoutParams
            r1.<init>((int) r4, (int) r5)
            android.view.View r3 = r3.getView()
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            boolean r4 = r3 instanceof com.scwang.smart.refresh.layout.SmartRefreshLayout.LayoutParams
            if (r4 == 0) goto L_0x0030
            r1 = r3
            com.scwang.smart.refresh.layout.SmartRefreshLayout$LayoutParams r1 = (com.scwang.smart.refresh.layout.SmartRefreshLayout.LayoutParams) r1
        L_0x0030:
            com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r2.B0
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r3 = r3.getSpinnerStyle()
            boolean r3 = r3.b
            if (r3 == 0) goto L_0x0048
            com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r2.B0
            android.view.View r3 = r3.getView()
            int r4 = r2.getChildCount()
            super.addView(r3, r4, r1)
            goto L_0x0051
        L_0x0048:
            com.scwang.smart.refresh.layout.api.RefreshComponent r3 = r2.B0
            android.view.View r3 = r3.getView()
            super.addView(r3, r0, r1)
        L_0x0051:
            int[] r3 = r2.A
            if (r3 == 0) goto L_0x005c
            com.scwang.smart.refresh.layout.api.RefreshComponent r4 = r2.B0
            if (r4 == 0) goto L_0x005c
            r4.setPrimaryColors(r3)
        L_0x005c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.F(com.scwang.smart.refresh.layout.api.RefreshHeader, int, int):com.scwang.smart.refresh.layout.api.RefreshLayout");
    }

    public boolean G(float f2) {
        if (f2 == 0.0f) {
            f2 = (float) this.w;
        }
        if (Math.abs(f2) > ((float) this.u)) {
            int i2 = this.b;
            if (((float) i2) * f2 < 0.0f) {
                RefreshState refreshState = this.H0;
                if (refreshState == RefreshState.Refreshing || refreshState == RefreshState.Loading || (i2 < 0 && this.T)) {
                    this.S0 = new FlingRunnable(f2).a();
                    return true;
                } else if (refreshState.isReleaseToOpening) {
                    return true;
                }
            }
            if ((f2 < 0.0f && ((this.J && (this.C || this.K)) || ((this.H0 == RefreshState.Loading && i2 >= 0) || (this.L && u(this.C))))) || (f2 > 0.0f && ((this.J && this.B) || this.K || (this.H0 == RefreshState.Refreshing && this.b <= 0)))) {
                this.Q0 = false;
                this.x.fling(0, 0, 0, (int) (-f2), 0, 0, -2147483647, Integer.MAX_VALUE);
                this.x.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    public RefreshLayout a(boolean z2) {
        return o(z2 ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.J0))), 300) << 16 : 0, z2, false);
    }

    public boolean b() {
        return m(0, this.f, (this.x0 + this.z0) / 2.0f, false);
    }

    public RefreshLayout c(OnLoadMoreListener onLoadMoreListener) {
        this.i0 = onLoadMoreListener;
        this.C = this.C || (!this.V && onLoadMoreListener != null);
        return this;
    }

    public void computeScroll() {
        this.x.getCurrY();
        if (this.x.computeScrollOffset()) {
            int finalY = this.x.getFinalY();
            if ((finalY >= 0 || ((!this.B && !this.K) || !this.D0.i())) && (finalY <= 0 || ((!this.C && !this.K) || !this.D0.e()))) {
                this.Q0 = true;
                invalidate();
                return;
            }
            if (this.Q0) {
                l(finalY > 0 ? -this.x.getCurrVelocity() : this.x.getCurrVelocity());
            }
            this.x.forceFinished(true);
        }
    }

    public RefreshLayout d(boolean z2) {
        setNestedScrollingEnabled(z2);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00c6, code lost:
        if (r2.isFinishing == false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ca, code lost:
        if (r2.isHeader == false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00d8, code lost:
        if (r2.isFinishing == false) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00dc, code lost:
        if (r2.isFooter == false) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0108, code lost:
        if (r6 != 3) goto L_0x0314;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r24) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            int r6 = r24.getActionMasked()
            r10 = 0
            r11 = 1
            r2 = 6
            if (r6 != r2) goto L_0x000f
            r3 = r11
            goto L_0x0010
        L_0x000f:
            r3 = r10
        L_0x0010:
            if (r3 == 0) goto L_0x0017
            int r4 = r24.getActionIndex()
            goto L_0x0018
        L_0x0017:
            r4 = -1
        L_0x0018:
            int r5 = r24.getPointerCount()
            r7 = 0
            r9 = r7
            r12 = r9
            r8 = r10
        L_0x0020:
            if (r8 >= r5) goto L_0x0032
            if (r4 != r8) goto L_0x0025
            goto L_0x002f
        L_0x0025:
            float r13 = r1.getX(r8)
            float r9 = r9 + r13
            float r13 = r1.getY(r8)
            float r12 = r12 + r13
        L_0x002f:
            int r8 = r8 + 1
            goto L_0x0020
        L_0x0032:
            if (r3 == 0) goto L_0x0036
            int r5 = r5 + -1
        L_0x0036:
            float r3 = (float) r5
            float r9 = r9 / r3
            float r8 = r12 / r3
            if (r6 == r2) goto L_0x003f
            r2 = 5
            if (r6 != r2) goto L_0x004c
        L_0x003f:
            boolean r2 = r0.n
            if (r2 == 0) goto L_0x004c
            float r2 = r0.i
            float r3 = r0.k
            float r3 = r8 - r3
            float r2 = r2 + r3
            r0.i = r2
        L_0x004c:
            r0.j = r9
            r0.k = r8
            boolean r2 = r0.m0
            r3 = 2
            if (r2 == 0) goto L_0x00a8
            int r2 = r0.l0
            boolean r1 = super.dispatchTouchEvent(r24)
            if (r6 != r3) goto L_0x00a7
            int r3 = r0.l0
            if (r2 != r3) goto L_0x00a7
            float r2 = r0.j
            int r2 = (int) r2
            int r3 = r23.getWidth()
            float r4 = r0.j
            if (r3 != 0) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r11 = r3
        L_0x006e:
            float r5 = (float) r11
            float r4 = r4 / r5
            boolean r5 = r0.B
            boolean r5 = r0.u(r5)
            if (r5 == 0) goto L_0x008c
            int r5 = r0.b
            if (r5 <= 0) goto L_0x008c
            com.scwang.smart.refresh.layout.api.RefreshComponent r5 = r0.B0
            if (r5 == 0) goto L_0x008c
            boolean r5 = r5.e()
            if (r5 == 0) goto L_0x008c
            com.scwang.smart.refresh.layout.api.RefreshComponent r0 = r0.B0
            r0.d(r4, r2, r3)
            goto L_0x00a7
        L_0x008c:
            boolean r5 = r0.C
            boolean r5 = r0.u(r5)
            if (r5 == 0) goto L_0x00a7
            int r5 = r0.b
            if (r5 >= 0) goto L_0x00a7
            com.scwang.smart.refresh.layout.api.RefreshComponent r5 = r0.C0
            if (r5 == 0) goto L_0x00a7
            boolean r5 = r5.e()
            if (r5 == 0) goto L_0x00a7
            com.scwang.smart.refresh.layout.api.RefreshComponent r0 = r0.C0
            r0.d(r4, r2, r3)
        L_0x00a7:
            return r1
        L_0x00a8:
            boolean r2 = r23.isEnabled()
            if (r2 == 0) goto L_0x035e
            boolean r2 = r0.B
            if (r2 != 0) goto L_0x00ba
            boolean r2 = r0.C
            if (r2 != 0) goto L_0x00ba
            boolean r2 = r0.K
            if (r2 == 0) goto L_0x035e
        L_0x00ba:
            boolean r2 = r0.M0
            if (r2 == 0) goto L_0x00cc
            com.scwang.smart.refresh.layout.constant.RefreshState r2 = r0.H0
            boolean r4 = r2.isOpening
            if (r4 != 0) goto L_0x00c8
            boolean r4 = r2.isFinishing
            if (r4 == 0) goto L_0x00cc
        L_0x00c8:
            boolean r2 = r2.isHeader
            if (r2 != 0) goto L_0x035e
        L_0x00cc:
            boolean r2 = r0.N0
            if (r2 == 0) goto L_0x00e0
            com.scwang.smart.refresh.layout.constant.RefreshState r2 = r0.H0
            boolean r4 = r2.isOpening
            if (r4 != 0) goto L_0x00da
            boolean r4 = r2.isFinishing
            if (r4 == 0) goto L_0x00e0
        L_0x00da:
            boolean r2 = r2.isFooter
            if (r2 == 0) goto L_0x00e0
            goto L_0x035e
        L_0x00e0:
            boolean r2 = r0.t(r6)
            if (r2 != 0) goto L_0x035d
            com.scwang.smart.refresh.layout.constant.RefreshState r2 = r0.H0
            boolean r4 = r2.isFinishing
            if (r4 != 0) goto L_0x035d
            com.scwang.smart.refresh.layout.constant.RefreshState r4 = com.scwang.smart.refresh.layout.constant.RefreshState.Loading
            if (r2 != r4) goto L_0x00f4
            boolean r5 = r0.S
            if (r5 != 0) goto L_0x035d
        L_0x00f4:
            com.scwang.smart.refresh.layout.constant.RefreshState r5 = com.scwang.smart.refresh.layout.constant.RefreshState.Refreshing
            if (r2 != r5) goto L_0x00fe
            boolean r2 = r0.R
            if (r2 == 0) goto L_0x00fe
            goto L_0x035d
        L_0x00fe:
            r2 = 104(0x68, float:1.46E-43)
            if (r6 == 0) goto L_0x0319
            r5 = 0
            if (r6 == r11) goto L_0x02cb
            r12 = 3
            if (r6 == r3) goto L_0x010c
            if (r6 == r12) goto L_0x02e6
            goto L_0x0314
        L_0x010c:
            float r3 = r0.h
            float r9 = r9 - r3
            float r3 = r0.i
            float r3 = r8 - r3
            android.view.VelocityTracker r6 = r0.y
            r6.addMovement(r1)
            boolean r6 = r0.n
            if (r6 != 0) goto L_0x01e3
            boolean r6 = r0.p
            if (r6 != 0) goto L_0x01e3
            char r6 = r0.m
            if (r6 == r2) goto L_0x01e3
            com.scwang.smart.refresh.layout.api.RefreshContent r13 = r0.D0
            if (r13 == 0) goto L_0x01e3
            r13 = 118(0x76, float:1.65E-43)
            if (r6 == r13) goto L_0x0163
            float r6 = java.lang.Math.abs(r3)
            int r14 = r0.f9841a
            float r14 = (float) r14
            int r6 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r6 < 0) goto L_0x0144
            float r6 = java.lang.Math.abs(r9)
            float r14 = java.lang.Math.abs(r3)
            int r6 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r6 >= 0) goto L_0x0144
            goto L_0x0163
        L_0x0144:
            float r4 = java.lang.Math.abs(r9)
            int r6 = r0.f9841a
            float r6 = (float) r6
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 < 0) goto L_0x01e3
            float r4 = java.lang.Math.abs(r9)
            float r6 = java.lang.Math.abs(r3)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x01e3
            char r4 = r0.m
            if (r4 == r13) goto L_0x01e3
            r0.m = r2
            goto L_0x01e3
        L_0x0163:
            r0.m = r13
            int r2 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x0187
            int r2 = r0.b
            if (r2 < 0) goto L_0x017d
            boolean r2 = r0.K
            if (r2 != 0) goto L_0x0175
            boolean r2 = r0.B
            if (r2 == 0) goto L_0x0187
        L_0x0175:
            com.scwang.smart.refresh.layout.api.RefreshContent r2 = r0.D0
            boolean r2 = r2.i()
            if (r2 == 0) goto L_0x0187
        L_0x017d:
            r0.n = r11
            int r2 = r0.f9841a
            float r2 = (float) r2
            float r2 = r8 - r2
            r0.i = r2
            goto L_0x01af
        L_0x0187:
            int r2 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r2 >= 0) goto L_0x01af
            int r2 = r0.b
            if (r2 > 0) goto L_0x01a7
            boolean r2 = r0.K
            if (r2 != 0) goto L_0x0197
            boolean r2 = r0.C
            if (r2 == 0) goto L_0x01af
        L_0x0197:
            com.scwang.smart.refresh.layout.constant.RefreshState r2 = r0.H0
            if (r2 != r4) goto L_0x019f
            boolean r2 = r0.P0
            if (r2 != 0) goto L_0x01a7
        L_0x019f:
            com.scwang.smart.refresh.layout.api.RefreshContent r2 = r0.D0
            boolean r2 = r2.e()
            if (r2 == 0) goto L_0x01af
        L_0x01a7:
            r0.n = r11
            int r2 = r0.f9841a
            float r2 = (float) r2
            float r2 = r2 + r8
            r0.i = r2
        L_0x01af:
            boolean r2 = r0.n
            if (r2 == 0) goto L_0x01e3
            float r2 = r0.i
            float r3 = r8 - r2
            boolean r2 = r0.o
            if (r2 == 0) goto L_0x01c1
            r1.setAction(r12)
            super.dispatchTouchEvent(r24)
        L_0x01c1:
            com.scwang.smart.refresh.layout.api.RefreshKernel r2 = r0.G0
            int r4 = r0.b
            if (r4 > 0) goto L_0x01d1
            if (r4 != 0) goto L_0x01ce
            int r4 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x01ce
            goto L_0x01d1
        L_0x01ce:
            com.scwang.smart.refresh.layout.constant.RefreshState r4 = com.scwang.smart.refresh.layout.constant.RefreshState.PullUpToLoad
            goto L_0x01d3
        L_0x01d1:
            com.scwang.smart.refresh.layout.constant.RefreshState r4 = com.scwang.smart.refresh.layout.constant.RefreshState.PullDownToRefresh
        L_0x01d3:
            r2.f(r4)
            android.view.ViewParent r2 = r23.getParent()
            boolean r4 = r2 instanceof android.view.ViewGroup
            if (r4 == 0) goto L_0x01e3
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r2.requestDisallowInterceptTouchEvent(r11)
        L_0x01e3:
            boolean r2 = r0.n
            if (r2 == 0) goto L_0x02b9
            int r2 = (int) r3
            int r4 = r0.d
            int r2 = r2 + r4
            com.scwang.smart.refresh.layout.constant.RefreshState r4 = r0.I0
            boolean r6 = r4.isHeader
            if (r6 == 0) goto L_0x01f7
            if (r2 < 0) goto L_0x0201
            int r6 = r0.c
            if (r6 < 0) goto L_0x0201
        L_0x01f7:
            boolean r4 = r4.isFooter
            if (r4 == 0) goto L_0x02b4
            if (r2 > 0) goto L_0x0201
            int r4 = r0.c
            if (r4 <= 0) goto L_0x02b4
        L_0x0201:
            r0.c = r2
            long r21 = r24.getEventTime()
            android.view.MotionEvent r1 = r0.R0
            if (r1 != 0) goto L_0x0224
            float r1 = r0.h
            float r18 = r1 + r9
            float r1 = r0.i
            r20 = 0
            r17 = 0
            r13 = r21
            r15 = r21
            r19 = r1
            android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r13, r15, r17, r18, r19, r20)
            r0.R0 = r1
            super.dispatchTouchEvent(r1)
        L_0x0224:
            float r1 = r0.h
            float r18 = r1 + r9
            float r1 = r0.i
            float r4 = (float) r2
            float r19 = r1 + r4
            r20 = 0
            r17 = 2
            r13 = r21
            r15 = r21
            android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r13, r15, r17, r18, r19, r20)
            super.dispatchTouchEvent(r1)
            boolean r4 = r0.P0
            if (r4 == 0) goto L_0x024d
            int r4 = r0.f9841a
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x024d
            int r3 = r0.b
            if (r3 >= 0) goto L_0x024d
            r0.P0 = r10
        L_0x024d:
            if (r2 <= 0) goto L_0x026d
            boolean r3 = r0.K
            if (r3 != 0) goto L_0x0257
            boolean r3 = r0.B
            if (r3 == 0) goto L_0x026d
        L_0x0257:
            com.scwang.smart.refresh.layout.api.RefreshContent r3 = r0.D0
            boolean r3 = r3.i()
            if (r3 == 0) goto L_0x026d
            r0.k = r8
            r0.i = r8
            r0.d = r10
            com.scwang.smart.refresh.layout.api.RefreshKernel r2 = r0.G0
            com.scwang.smart.refresh.layout.constant.RefreshState r3 = com.scwang.smart.refresh.layout.constant.RefreshState.PullDownToRefresh
            r2.f(r3)
            goto L_0x028e
        L_0x026d:
            if (r2 >= 0) goto L_0x028d
            boolean r3 = r0.K
            if (r3 != 0) goto L_0x0277
            boolean r3 = r0.C
            if (r3 == 0) goto L_0x028d
        L_0x0277:
            com.scwang.smart.refresh.layout.api.RefreshContent r3 = r0.D0
            boolean r3 = r3.e()
            if (r3 == 0) goto L_0x028d
            r0.k = r8
            r0.i = r8
            r0.d = r10
            com.scwang.smart.refresh.layout.api.RefreshKernel r2 = r0.G0
            com.scwang.smart.refresh.layout.constant.RefreshState r3 = com.scwang.smart.refresh.layout.constant.RefreshState.PullUpToLoad
            r2.f(r3)
            goto L_0x028e
        L_0x028d:
            r10 = r2
        L_0x028e:
            com.scwang.smart.refresh.layout.constant.RefreshState r2 = r0.I0
            boolean r3 = r2.isHeader
            if (r3 == 0) goto L_0x0296
            if (r10 < 0) goto L_0x029c
        L_0x0296:
            boolean r2 = r2.isFooter
            if (r2 == 0) goto L_0x02a4
            if (r10 <= 0) goto L_0x02a4
        L_0x029c:
            int r1 = r0.b
            if (r1 == 0) goto L_0x02a3
            r0.w(r7)
        L_0x02a3:
            return r11
        L_0x02a4:
            android.view.MotionEvent r2 = r0.R0
            if (r2 == 0) goto L_0x02b0
            r0.R0 = r5
            r1.setAction(r12)
            super.dispatchTouchEvent(r1)
        L_0x02b0:
            r1.recycle()
            r2 = r10
        L_0x02b4:
            float r1 = (float) r2
            r0.w(r1)
            return r11
        L_0x02b9:
            boolean r2 = r0.P0
            if (r2 == 0) goto L_0x0314
            int r2 = r0.f9841a
            float r2 = (float) r2
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0314
            int r2 = r0.b
            if (r2 >= 0) goto L_0x0314
            r0.P0 = r10
            goto L_0x0314
        L_0x02cb:
            android.view.VelocityTracker r2 = r0.y
            r2.addMovement(r1)
            android.view.VelocityTracker r2 = r0.y
            int r3 = r0.v
            float r3 = (float) r3
            r4 = 1000(0x3e8, float:1.401E-42)
            r2.computeCurrentVelocity(r4, r3)
            android.view.VelocityTracker r2 = r0.y
            float r2 = r2.getYVelocity()
            int r2 = (int) r2
            r0.w = r2
            r0.G(r7)
        L_0x02e6:
            android.view.VelocityTracker r2 = r0.y
            r2.clear()
            r2 = 110(0x6e, float:1.54E-43)
            r0.m = r2
            android.view.MotionEvent r2 = r0.R0
            if (r2 == 0) goto L_0x030a
            r2.recycle()
            r0.R0 = r5
            long r4 = r24.getEventTime()
            float r7 = r0.h
            r9 = 0
            r2 = r4
            android.view.MotionEvent r2 = android.view.MotionEvent.obtain(r2, r4, r6, r7, r8, r9)
            super.dispatchTouchEvent(r2)
            r2.recycle()
        L_0x030a:
            r23.y()
            boolean r2 = r0.n
            if (r2 == 0) goto L_0x0314
            r0.n = r10
            return r11
        L_0x0314:
            boolean r0 = super.dispatchTouchEvent(r24)
            return r0
        L_0x0319:
            r0.w = r10
            android.view.VelocityTracker r3 = r0.y
            r3.addMovement(r1)
            android.widget.Scroller r3 = r0.x
            r3.forceFinished(r11)
            r0.h = r9
            r0.i = r8
            r0.c = r10
            int r3 = r0.b
            r0.d = r3
            r0.n = r10
            r0.p = r10
            boolean r3 = super.dispatchTouchEvent(r24)
            r0.o = r3
            com.scwang.smart.refresh.layout.constant.RefreshState r3 = r0.H0
            com.scwang.smart.refresh.layout.constant.RefreshState r4 = com.scwang.smart.refresh.layout.constant.RefreshState.TwoLevel
            if (r3 != r4) goto L_0x0355
            float r3 = r0.i
            int r4 = r23.getMeasuredHeight()
            float r4 = (float) r4
            r5 = 1065353216(0x3f800000, float:1.0)
            float r6 = r0.A0
            float r5 = r5 - r6
            float r4 = r4 * r5
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0355
            r0.m = r2
            boolean r0 = r0.o
            return r0
        L_0x0355:
            com.scwang.smart.refresh.layout.api.RefreshContent r0 = r0.D0
            if (r0 == 0) goto L_0x035c
            r0.a(r1)
        L_0x035c:
            return r11
        L_0x035d:
            return r10
        L_0x035e:
            boolean r0 = super.dispatchTouchEvent(r24)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        Paint paint;
        Paint paint2;
        RefreshContent refreshContent = this.D0;
        View view2 = refreshContent != null ? refreshContent.getView() : null;
        RefreshComponent refreshComponent = this.B0;
        if (refreshComponent != null && refreshComponent.getView() == view) {
            if (!u(this.B) || (!this.I && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int max = Math.max(view2.getTop() + view2.getPaddingTop() + this.b, view.getTop());
                int i2 = this.K0;
                if (!(i2 == 0 || (paint2 = this.E0) == null)) {
                    paint2.setColor(i2);
                    if (this.B0.getSpinnerStyle().c) {
                        max = view.getBottom();
                    } else if (this.B0.getSpinnerStyle() == SpinnerStyle.d) {
                        max = view.getBottom() + this.b;
                    }
                    canvas.drawRect(0.0f, (float) view.getTop(), (float) getWidth(), (float) max, this.E0);
                }
                if ((this.D && this.B0.getSpinnerStyle() == SpinnerStyle.f) || this.B0.getSpinnerStyle().c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), max);
                    boolean drawChild = super.drawChild(canvas, view, j2);
                    canvas.restore();
                    return drawChild;
                }
            }
        }
        RefreshComponent refreshComponent2 = this.C0;
        if (refreshComponent2 != null && refreshComponent2.getView() == view) {
            if (!u(this.C) || (!this.I && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int min = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.b, view.getBottom());
                int i3 = this.L0;
                if (!(i3 == 0 || (paint = this.E0) == null)) {
                    paint.setColor(i3);
                    if (this.C0.getSpinnerStyle().c) {
                        min = view.getTop();
                    } else if (this.C0.getSpinnerStyle() == SpinnerStyle.d) {
                        min = view.getTop() + this.b;
                    }
                    canvas.drawRect(0.0f, (float) min, (float) getWidth(), (float) view.getBottom(), this.E0);
                }
                if ((this.E && this.C0.getSpinnerStyle() == SpinnerStyle.f) || this.C0.getSpinnerStyle().c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), min, view.getRight(), view.getBottom());
                    boolean drawChild2 = super.drawChild(canvas, view, j2);
                    canvas.restore();
                    return drawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @NonNull
    public ViewGroup getLayout() {
        return this;
    }

    public int getNestedScrollAxes() {
        return this.p0.a();
    }

    @Nullable
    public RefreshFooter getRefreshFooter() {
        RefreshComponent refreshComponent = this.C0;
        if (refreshComponent instanceof RefreshFooter) {
            return (RefreshFooter) refreshComponent;
        }
        return null;
    }

    @Nullable
    public RefreshHeader getRefreshHeader() {
        RefreshComponent refreshComponent = this.B0;
        if (refreshComponent instanceof RefreshHeader) {
            return (RefreshHeader) refreshComponent;
        }
        return null;
    }

    @NonNull
    public RefreshState getState() {
        return this.H0;
    }

    public boolean isNestedScrollingEnabled() {
        return this.Q && (this.K || this.B || this.C);
    }

    public ValueAnimator k(int i2, int i3, Interpolator interpolator, int i4) {
        if (this.b == i2) {
            return null;
        }
        ValueAnimator valueAnimator = this.T0;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0);
            this.T0.cancel();
            this.T0 = null;
        }
        this.S0 = null;
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.b, i2});
        this.T0 = ofInt;
        ofInt.setDuration((long) i4);
        this.T0.setInterpolator(interpolator);
        this.T0.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                RefreshState refreshState;
                RefreshState refreshState2;
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.T0 = null;
                    if (smartRefreshLayout.b != 0 || (refreshState = smartRefreshLayout.H0) == (refreshState2 = RefreshState.None) || refreshState.isOpening || refreshState.isDragging) {
                        RefreshState refreshState3 = smartRefreshLayout.H0;
                        if (refreshState3 != smartRefreshLayout.I0) {
                            smartRefreshLayout.setViceState(refreshState3);
                            return;
                        }
                        return;
                    }
                    smartRefreshLayout.x(refreshState2);
                }
            }
        });
        this.T0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout.this.G0.d(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        });
        this.T0.setStartDelay((long) i3);
        this.T0.start();
        return this.T0;
    }

    public void l(float f2) {
        RefreshState refreshState;
        if (this.T0 != null) {
            return;
        }
        if (f2 > 0.0f && ((refreshState = this.H0) == RefreshState.Refreshing || refreshState == RefreshState.TwoLevel)) {
            this.S0 = new BounceRunnable(f2, this.q0);
        } else if (f2 < 0.0f && (this.H0 == RefreshState.Loading || ((this.H && this.T && this.U && u(this.C)) || (this.L && !this.T && u(this.C) && this.H0 != RefreshState.Refreshing)))) {
            this.S0 = new BounceRunnable(f2, -this.s0);
        } else if (this.b == 0 && this.J) {
            this.S0 = new BounceRunnable(f2, 0);
        }
    }

    public boolean m(int i2, final int i3, final float f2, final boolean z2) {
        if (this.H0 != RefreshState.None || !u(this.C) || this.T) {
            return false;
        }
        AnonymousClass9 r02 = new Runnable() {
            public void run() {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (smartRefreshLayout.I0 == RefreshState.Loading) {
                    ValueAnimator valueAnimator = smartRefreshLayout.T0;
                    if (valueAnimator != null) {
                        valueAnimator.setDuration(0);
                        SmartRefreshLayout.this.T0.cancel();
                        SmartRefreshLayout.this.T0 = null;
                    }
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    smartRefreshLayout2.j = ((float) smartRefreshLayout2.getMeasuredWidth()) / 2.0f;
                    SmartRefreshLayout.this.G0.f(RefreshState.PullUpToLoad);
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    int i = smartRefreshLayout3.s0;
                    float f = i == 0 ? smartRefreshLayout3.z0 : (float) i;
                    float f2 = f2;
                    if (f2 < 10.0f) {
                        f2 *= f;
                    }
                    smartRefreshLayout3.T0 = ValueAnimator.ofInt(new int[]{smartRefreshLayout3.b, -((int) f2)});
                    SmartRefreshLayout.this.T0.setDuration((long) i3);
                    SmartRefreshLayout.this.T0.setInterpolator(new SmartUtil(SmartUtil.b));
                    SmartRefreshLayout.this.T0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                            if (smartRefreshLayout.T0 != null && smartRefreshLayout.C0 != null) {
                                smartRefreshLayout.G0.d(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
                            }
                        }
                    });
                    SmartRefreshLayout.this.T0.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            if (animator == null || animator.getDuration() != 0) {
                                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                                smartRefreshLayout.T0 = null;
                                if (smartRefreshLayout.C0 != null) {
                                    RefreshState refreshState = smartRefreshLayout.H0;
                                    RefreshState refreshState2 = RefreshState.ReleaseToLoad;
                                    if (refreshState != refreshState2) {
                                        smartRefreshLayout.G0.f(refreshState2);
                                    }
                                    AnonymousClass9 r4 = AnonymousClass9.this;
                                    SmartRefreshLayout.this.setStateLoading(!z2);
                                    return;
                                }
                                smartRefreshLayout.G0.f(RefreshState.None);
                            }
                        }
                    });
                    SmartRefreshLayout.this.T0.start();
                }
            }
        };
        setViceState(RefreshState.Loading);
        if (i2 > 0) {
            this.F0.postDelayed(r02, (long) i2);
            return true;
        }
        r02.run();
        return true;
    }

    public RefreshLayout n(int i2) {
        return o(i2, true, false);
    }

    public RefreshLayout o(int i2, final boolean z2, final boolean z3) {
        final int i3 = i2 >> 16;
        int i4 = (i2 << 16) >> 16;
        AnonymousClass7 r1 = new Runnable() {

            /* renamed from: a  reason: collision with root package name */
            public int f9849a = 0;

            /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b0, code lost:
                if (r6.D0.e() != false) goto L_0x00b4;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r19 = this;
                    r0 = r19
                    int r1 = r0.f9849a
                    r2 = 0
                    r4 = 1
                    r5 = 0
                    if (r1 != 0) goto L_0x007a
                    com.scwang.smart.refresh.layout.SmartRefreshLayout r6 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                    com.scwang.smart.refresh.layout.constant.RefreshState r7 = r6.H0
                    com.scwang.smart.refresh.layout.constant.RefreshState r8 = com.scwang.smart.refresh.layout.constant.RefreshState.None
                    if (r7 != r8) goto L_0x001b
                    com.scwang.smart.refresh.layout.constant.RefreshState r9 = r6.I0
                    com.scwang.smart.refresh.layout.constant.RefreshState r10 = com.scwang.smart.refresh.layout.constant.RefreshState.Loading
                    if (r9 != r10) goto L_0x001b
                    r6.I0 = r8
                    goto L_0x006f
                L_0x001b:
                    android.animation.ValueAnimator r9 = r6.T0
                    if (r9 == 0) goto L_0x0050
                    boolean r10 = r7.isDragging
                    if (r10 != 0) goto L_0x0027
                    com.scwang.smart.refresh.layout.constant.RefreshState r10 = com.scwang.smart.refresh.layout.constant.RefreshState.LoadReleased
                    if (r7 != r10) goto L_0x0050
                L_0x0027:
                    boolean r10 = r7.isFooter
                    if (r10 == 0) goto L_0x0050
                    r9.setDuration(r2)
                    com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                    android.animation.ValueAnimator r1 = r1.T0
                    r1.cancel()
                    com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                    r2 = 0
                    r1.T0 = r2
                    com.scwang.smart.refresh.layout.api.RefreshKernel r1 = r1.G0
                    android.animation.ValueAnimator r1 = r1.a(r5)
                    if (r1 != 0) goto L_0x0048
                    com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                    r1.x(r8)
                    goto L_0x006f
                L_0x0048:
                    com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                    com.scwang.smart.refresh.layout.constant.RefreshState r2 = com.scwang.smart.refresh.layout.constant.RefreshState.PullUpCanceled
                    r1.x(r2)
                    goto L_0x006f
                L_0x0050:
                    com.scwang.smart.refresh.layout.constant.RefreshState r2 = com.scwang.smart.refresh.layout.constant.RefreshState.Loading
                    if (r7 != r2) goto L_0x006f
                    com.scwang.smart.refresh.layout.api.RefreshComponent r2 = r6.C0
                    if (r2 == 0) goto L_0x006f
                    com.scwang.smart.refresh.layout.api.RefreshContent r2 = r6.D0
                    if (r2 == 0) goto L_0x006f
                    int r1 = r1 + r4
                    r0.f9849a = r1
                    android.os.Handler r1 = r6.F0
                    int r2 = r0
                    long r2 = (long) r2
                    r1.postDelayed(r0, r2)
                    com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                    com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.LoadFinish
                    r0.x(r1)
                    return
                L_0x006f:
                    boolean r1 = r7
                    if (r1 == 0) goto L_0x0148
                    com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                    r0.A(r4)
                    goto L_0x0148
                L_0x007a:
                    com.scwang.smart.refresh.layout.SmartRefreshLayout r1 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                    com.scwang.smart.refresh.layout.api.RefreshComponent r6 = r1.C0
                    boolean r7 = r6
                    int r1 = r6.f(r1, r7)
                    com.scwang.smart.refresh.layout.SmartRefreshLayout r6 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                    com.scwang.smart.refresh.layout.listener.OnMultiListener r7 = r6.j0
                    if (r7 == 0) goto L_0x0097
                    com.scwang.smart.refresh.layout.api.RefreshComponent r6 = r6.C0
                    boolean r8 = r6 instanceof com.scwang.smart.refresh.layout.api.RefreshFooter
                    if (r8 == 0) goto L_0x0097
                    com.scwang.smart.refresh.layout.api.RefreshFooter r6 = (com.scwang.smart.refresh.layout.api.RefreshFooter) r6
                    boolean r8 = r6
                    r7.onFooterFinish(r6, r8)
                L_0x0097:
                    r6 = 2147483647(0x7fffffff, float:NaN)
                    if (r1 >= r6) goto L_0x0148
                    boolean r6 = r7
                    if (r6 == 0) goto L_0x00b3
                    com.scwang.smart.refresh.layout.SmartRefreshLayout r6 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                    boolean r7 = r6.H
                    if (r7 == 0) goto L_0x00b3
                    int r7 = r6.b
                    if (r7 >= 0) goto L_0x00b3
                    com.scwang.smart.refresh.layout.api.RefreshContent r6 = r6.D0
                    boolean r6 = r6.e()
                    if (r6 == 0) goto L_0x00b3
                    goto L_0x00b4
                L_0x00b3:
                    r4 = r5
                L_0x00b4:
                    com.scwang.smart.refresh.layout.SmartRefreshLayout r6 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                    int r7 = r6.b
                    if (r4 == 0) goto L_0x00c2
                    int r4 = r6.s0
                    int r4 = -r4
                    int r4 = java.lang.Math.max(r7, r4)
                    goto L_0x00c3
                L_0x00c2:
                    r4 = r5
                L_0x00c3:
                    int r7 = r7 - r4
                    com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                    boolean r6 = r4.n
                    if (r6 != 0) goto L_0x00ce
                    boolean r4 = r4.m0
                    if (r4 == 0) goto L_0x0135
                L_0x00ce:
                    long r16 = java.lang.System.currentTimeMillis()
                    com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                    boolean r6 = r4.n
                    if (r6 == 0) goto L_0x0116
                    float r6 = r4.k
                    r4.i = r6
                    int r8 = r4.b
                    int r8 = r8 - r7
                    r4.d = r8
                    r4.n = r5
                    boolean r8 = r4.G
                    if (r8 == 0) goto L_0x00e9
                    r8 = r7
                    goto L_0x00ea
                L_0x00e9:
                    r8 = r5
                L_0x00ea:
                    float r13 = r4.j
                    float r15 = (float) r8
                    float r6 = r6 + r15
                    int r8 = r4.f9841a
                    int r8 = r8 * 2
                    float r8 = (float) r8
                    float r14 = r6 + r8
                    r6 = 0
                    r12 = 0
                    r8 = r16
                    r10 = r16
                    r18 = r15
                    r15 = r6
                    android.view.MotionEvent r6 = android.view.MotionEvent.obtain(r8, r10, r12, r13, r14, r15)
                    boolean unused = com.scwang.smart.refresh.layout.SmartRefreshLayout.super.dispatchTouchEvent(r6)
                    com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                    float r13 = r4.j
                    float r6 = r4.k
                    float r14 = r6 + r18
                    r15 = 0
                    r12 = 2
                    android.view.MotionEvent r6 = android.view.MotionEvent.obtain(r8, r10, r12, r13, r14, r15)
                    boolean unused = com.scwang.smart.refresh.layout.SmartRefreshLayout.super.dispatchTouchEvent(r6)
                L_0x0116:
                    com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                    boolean r6 = r4.m0
                    if (r6 == 0) goto L_0x0135
                    r4.l0 = r5
                    float r13 = r4.j
                    float r14 = r4.k
                    r15 = 0
                    r12 = 1
                    r8 = r16
                    r10 = r16
                    android.view.MotionEvent r6 = android.view.MotionEvent.obtain(r8, r10, r12, r13, r14, r15)
                    boolean unused = com.scwang.smart.refresh.layout.SmartRefreshLayout.super.dispatchTouchEvent(r6)
                    com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                    r4.m0 = r5
                    r4.d = r5
                L_0x0135:
                    com.scwang.smart.refresh.layout.SmartRefreshLayout r4 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                    android.os.Handler r4 = r4.F0
                    com.scwang.smart.refresh.layout.SmartRefreshLayout$7$1 r5 = new com.scwang.smart.refresh.layout.SmartRefreshLayout$7$1
                    r5.<init>(r7)
                    com.scwang.smart.refresh.layout.SmartRefreshLayout r0 = com.scwang.smart.refresh.layout.SmartRefreshLayout.this
                    int r0 = r0.b
                    if (r0 >= 0) goto L_0x0145
                    long r2 = (long) r1
                L_0x0145:
                    r4.postDelayed(r5, r2)
                L_0x0148:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.AnonymousClass7.run():void");
            }
        };
        if (i4 > 0) {
            this.F0.postDelayed(r1, (long) i4);
        } else {
            r1.run();
        }
        return this;
    }

    public void onAttachedToWindow() {
        RefreshComponent refreshComponent;
        DefaultRefreshHeaderCreator defaultRefreshHeaderCreator;
        super.onAttachedToWindow();
        boolean z2 = true;
        this.O0 = true;
        if (!isInEditMode()) {
            if (this.B0 == null && (defaultRefreshHeaderCreator = V0) != null) {
                RefreshHeader a2 = defaultRefreshHeaderCreator.a(getContext(), this);
                if (a2 != null) {
                    E(a2);
                } else {
                    throw new RuntimeException("DefaultRefreshHeaderCreator can not return null");
                }
            }
            if (this.C0 == null) {
                DefaultRefreshFooterCreator defaultRefreshFooterCreator = U0;
                if (defaultRefreshFooterCreator != null) {
                    RefreshFooter a3 = defaultRefreshFooterCreator.a(getContext(), this);
                    if (a3 != null) {
                        C(a3);
                    } else {
                        throw new RuntimeException("DefaultRefreshFooterCreator can not return null");
                    }
                }
            } else {
                if (!this.C && this.V) {
                    z2 = false;
                }
                this.C = z2;
            }
            if (this.D0 == null) {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    RefreshComponent refreshComponent2 = this.B0;
                    if ((refreshComponent2 == null || childAt != refreshComponent2.getView()) && ((refreshComponent = this.C0) == null || childAt != refreshComponent.getView())) {
                        this.D0 = new RefreshContentWrapper(childAt);
                    }
                }
            }
            if (this.D0 == null) {
                int c2 = SmartUtil.c(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R.string.srl_content_empty);
                super.addView(textView, 0, new LayoutParams(-1, -1));
                RefreshContentWrapper refreshContentWrapper = new RefreshContentWrapper(textView);
                this.D0 = refreshContentWrapper;
                refreshContentWrapper.getView().setPadding(c2, c2, c2, c2);
            }
            View findViewById = findViewById(this.q);
            View findViewById2 = findViewById(this.r);
            this.D0.f(this.k0);
            this.D0.b(this.P);
            this.D0.g(this.G0, findViewById, findViewById2);
            if (this.b != 0) {
                x(RefreshState.None);
                RefreshContent refreshContent = this.D0;
                this.b = 0;
                refreshContent.d(0, this.s, this.t);
            }
        }
        int[] iArr = this.A;
        if (iArr != null) {
            RefreshComponent refreshComponent3 = this.B0;
            if (refreshComponent3 != null) {
                refreshComponent3.setPrimaryColors(iArr);
            }
            RefreshComponent refreshComponent4 = this.C0;
            if (refreshComponent4 != null) {
                refreshComponent4.setPrimaryColors(this.A);
            }
        }
        RefreshContent refreshContent2 = this.D0;
        if (refreshContent2 != null) {
            super.bringChildToFront(refreshContent2.getView());
        }
        RefreshComponent refreshComponent5 = this.B0;
        if (refreshComponent5 != null && refreshComponent5.getSpinnerStyle().b) {
            super.bringChildToFront(this.B0.getView());
        }
        RefreshComponent refreshComponent6 = this.C0;
        if (refreshComponent6 != null && refreshComponent6.getSpinnerStyle().b) {
            super.bringChildToFront(this.C0.getView());
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.O0 = false;
        this.V = true;
        this.S0 = null;
        ValueAnimator valueAnimator = this.T0;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.T0.removeAllUpdateListeners();
            this.T0.setDuration(0);
            this.T0.cancel();
            this.T0 = null;
        }
        RefreshComponent refreshComponent = this.B0;
        if (refreshComponent != null && this.H0 == RefreshState.Refreshing) {
            refreshComponent.f(this, false);
        }
        RefreshComponent refreshComponent2 = this.C0;
        if (refreshComponent2 != null && this.H0 == RefreshState.Loading) {
            refreshComponent2.f(this, false);
        }
        if (this.b != 0) {
            this.G0.d(0, true);
        }
        RefreshState refreshState = this.H0;
        RefreshState refreshState2 = RefreshState.None;
        if (refreshState != refreshState2) {
            x(refreshState2);
        }
        Handler handler = this.F0;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.P0 = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFinishInflate() {
        /*
            r11 = this;
            super.onFinishInflate()
            int r0 = super.getChildCount()
            r1 = 3
            if (r0 > r1) goto L_0x009e
            r2 = -1
            r3 = 0
            r5 = r2
            r4 = r3
            r6 = r4
        L_0x000f:
            r7 = 2
            r8 = 1
            if (r4 >= r0) goto L_0x0033
            android.view.View r9 = super.getChildAt(r4)
            boolean r10 = com.scwang.smart.refresh.layout.util.SmartUtil.e(r9)
            if (r10 == 0) goto L_0x0024
            if (r6 < r7) goto L_0x0021
            if (r4 != r8) goto L_0x0024
        L_0x0021:
            r5 = r4
            r6 = r7
            goto L_0x0030
        L_0x0024:
            boolean r7 = r9 instanceof com.scwang.smart.refresh.layout.api.RefreshComponent
            if (r7 != 0) goto L_0x0030
            if (r6 >= r8) goto L_0x0030
            if (r4 <= 0) goto L_0x002e
            r6 = r8
            goto L_0x002f
        L_0x002e:
            r6 = r3
        L_0x002f:
            r5 = r4
        L_0x0030:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x0033:
            if (r5 < 0) goto L_0x004d
            com.scwang.smart.refresh.layout.wrapper.RefreshContentWrapper r4 = new com.scwang.smart.refresh.layout.wrapper.RefreshContentWrapper
            android.view.View r6 = super.getChildAt(r5)
            r4.<init>(r6)
            r11.D0 = r4
            if (r5 != r8) goto L_0x0048
            if (r0 != r1) goto L_0x0046
        L_0x0044:
            r1 = r3
            goto L_0x004f
        L_0x0046:
            r7 = r2
            goto L_0x0044
        L_0x0048:
            if (r0 != r7) goto L_0x004d
            r1 = r2
            r7 = r8
            goto L_0x004f
        L_0x004d:
            r1 = r2
            r7 = r1
        L_0x004f:
            r4 = r3
        L_0x0050:
            if (r4 >= r0) goto L_0x009d
            android.view.View r5 = super.getChildAt(r4)
            if (r4 == r1) goto L_0x008b
            if (r4 == r7) goto L_0x0065
            if (r1 != r2) goto L_0x0065
            com.scwang.smart.refresh.layout.api.RefreshComponent r6 = r11.B0
            if (r6 != 0) goto L_0x0065
            boolean r6 = r5 instanceof com.scwang.smart.refresh.layout.api.RefreshHeader
            if (r6 == 0) goto L_0x0065
            goto L_0x008b
        L_0x0065:
            if (r4 == r7) goto L_0x006d
            if (r7 != r2) goto L_0x009a
            boolean r6 = r5 instanceof com.scwang.smart.refresh.layout.api.RefreshFooter
            if (r6 == 0) goto L_0x009a
        L_0x006d:
            boolean r6 = r11.C
            if (r6 != 0) goto L_0x0078
            boolean r6 = r11.V
            if (r6 != 0) goto L_0x0076
            goto L_0x0078
        L_0x0076:
            r6 = r3
            goto L_0x0079
        L_0x0078:
            r6 = r8
        L_0x0079:
            r11.C = r6
            boolean r6 = r5 instanceof com.scwang.smart.refresh.layout.api.RefreshFooter
            if (r6 == 0) goto L_0x0082
            com.scwang.smart.refresh.layout.api.RefreshFooter r5 = (com.scwang.smart.refresh.layout.api.RefreshFooter) r5
            goto L_0x0088
        L_0x0082:
            com.scwang.smart.refresh.layout.wrapper.RefreshFooterWrapper r6 = new com.scwang.smart.refresh.layout.wrapper.RefreshFooterWrapper
            r6.<init>(r5)
            r5 = r6
        L_0x0088:
            r11.C0 = r5
            goto L_0x009a
        L_0x008b:
            boolean r6 = r5 instanceof com.scwang.smart.refresh.layout.api.RefreshHeader
            if (r6 == 0) goto L_0x0092
            com.scwang.smart.refresh.layout.api.RefreshHeader r5 = (com.scwang.smart.refresh.layout.api.RefreshHeader) r5
            goto L_0x0098
        L_0x0092:
            com.scwang.smart.refresh.layout.wrapper.RefreshHeaderWrapper r6 = new com.scwang.smart.refresh.layout.wrapper.RefreshHeaderWrapper
            r6.<init>(r5)
            r5 = r6
        L_0x0098:
            r11.B0 = r5
        L_0x009a:
            int r4 = r4 + 1
            goto L_0x0050
        L_0x009d:
            return
        L_0x009e:
            java.lang.RuntimeException r11 = new java.lang.RuntimeException
            java.lang.String r0 = "最多只支持3个子View，Most only support three sub view"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.onFinishInflate():void");
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = super.getChildAt(i7);
            if (childAt.getVisibility() != 8 && !"GONE".equals(childAt.getTag(R.id.srl_tag))) {
                RefreshContent refreshContent = this.D0;
                boolean z3 = true;
                if (refreshContent != null && refreshContent.getView() == childAt) {
                    boolean z4 = isInEditMode() && this.I && u(this.B) && this.B0 != null;
                    View view = this.D0.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : X0;
                    int i8 = marginLayoutParams.leftMargin + paddingLeft;
                    int i9 = marginLayoutParams.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i8;
                    int measuredHeight = view.getMeasuredHeight() + i9;
                    if (z4 && v(this.F, this.B0)) {
                        int i10 = this.q0;
                        i9 += i10;
                        measuredHeight += i10;
                    }
                    view.layout(i8, i9, measuredWidth, measuredHeight);
                }
                RefreshComponent refreshComponent = this.B0;
                if (refreshComponent != null && refreshComponent.getView() == childAt) {
                    boolean z5 = isInEditMode() && this.I && u(this.B);
                    View view2 = this.B0.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : X0;
                    int i11 = marginLayoutParams2.leftMargin;
                    int i12 = marginLayoutParams2.topMargin + this.u0;
                    int measuredWidth2 = view2.getMeasuredWidth() + i11;
                    int measuredHeight2 = view2.getMeasuredHeight() + i12;
                    if (!z5 && this.B0.getSpinnerStyle() == SpinnerStyle.d) {
                        int i13 = this.q0;
                        i12 -= i13;
                        measuredHeight2 -= i13;
                    }
                    view2.layout(i11, i12, measuredWidth2, measuredHeight2);
                }
                RefreshComponent refreshComponent2 = this.C0;
                if (refreshComponent2 != null && refreshComponent2.getView() == childAt) {
                    if (!isInEditMode() || !this.I || !u(this.C)) {
                        z3 = false;
                    }
                    View view3 = this.C0.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : X0;
                    SpinnerStyle spinnerStyle = this.C0.getSpinnerStyle();
                    int i14 = marginLayoutParams3.leftMargin;
                    int measuredHeight3 = (marginLayoutParams3.topMargin + getMeasuredHeight()) - this.v0;
                    if (this.T && this.U && this.H && this.D0 != null && this.C0.getSpinnerStyle() == SpinnerStyle.d && u(this.C)) {
                        View view4 = this.D0.getView();
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        measuredHeight3 = view4.getMeasuredHeight() + paddingTop + paddingTop + (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin : 0);
                    }
                    if (spinnerStyle == SpinnerStyle.h) {
                        measuredHeight3 = marginLayoutParams3.topMargin - this.v0;
                    } else {
                        if (z3 || spinnerStyle == SpinnerStyle.g || spinnerStyle == SpinnerStyle.f) {
                            i6 = this.s0;
                        } else if (spinnerStyle.c && this.b < 0) {
                            i6 = Math.max(u(this.C) ? -this.b : 0, 0);
                        }
                        measuredHeight3 -= i6;
                    }
                    view3.layout(i14, measuredHeight3, view3.getMeasuredWidth() + i14, view3.getMeasuredHeight() + measuredHeight3);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0244  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r18, int r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r17.isInEditMode()
            if (r3 == 0) goto L_0x0012
            boolean r3 = r0.I
            if (r3 == 0) goto L_0x0012
            r3 = 1
            goto L_0x0013
        L_0x0012:
            r3 = 0
        L_0x0013:
            int r6 = super.getChildCount()
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x001a:
            if (r7 >= r6) goto L_0x0321
            android.view.View r10 = super.getChildAt(r7)
            int r11 = r10.getVisibility()
            r12 = 8
            if (r11 == r12) goto L_0x0036
            int r11 = com.scwang.smart.refresh.layout.kernel.R.id.srl_tag
            java.lang.Object r11 = r10.getTag(r11)
            java.lang.String r12 = "GONE"
            boolean r11 = r12.equals(r11)
            if (r11 == 0) goto L_0x003b
        L_0x0036:
            r16 = r6
            r12 = 0
            goto L_0x031b
        L_0x003b:
            com.scwang.smart.refresh.layout.api.RefreshComponent r11 = r0.B0
            if (r11 == 0) goto L_0x0159
            android.view.View r11 = r11.getView()
            if (r11 != r10) goto L_0x0159
            com.scwang.smart.refresh.layout.api.RefreshComponent r11 = r0.B0
            android.view.View r11 = r11.getView()
            android.view.ViewGroup$LayoutParams r12 = r11.getLayoutParams()
            boolean r13 = r12 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r13 == 0) goto L_0x0057
            r13 = r12
            android.view.ViewGroup$MarginLayoutParams r13 = (android.view.ViewGroup.MarginLayoutParams) r13
            goto L_0x0059
        L_0x0057:
            android.view.ViewGroup$MarginLayoutParams r13 = X0
        L_0x0059:
            int r4 = r13.leftMargin
            int r14 = r13.rightMargin
            int r4 = r4 + r14
            int r14 = r12.width
            int r4 = android.view.ViewGroup.getChildMeasureSpec(r1, r4, r14)
            int r14 = r0.q0
            com.scwang.smart.refresh.layout.constant.DimensionStatus r5 = r0.r0
            int r15 = r5.f9863a
            r16 = r6
            com.scwang.smart.refresh.layout.constant.DimensionStatus r6 = com.scwang.smart.refresh.layout.constant.DimensionStatus.i
            int r6 = r6.f9863a
            if (r15 >= r6) goto L_0x00da
            int r6 = r12.height
            if (r6 <= 0) goto L_0x0092
            int r14 = r13.bottomMargin
            int r6 = r6 + r14
            int r14 = r13.topMargin
            int r6 = r6 + r14
            com.scwang.smart.refresh.layout.constant.DimensionStatus r14 = com.scwang.smart.refresh.layout.constant.DimensionStatus.g
            boolean r5 = r5.a(r14)
            if (r5 == 0) goto L_0x0090
            int r5 = r12.height
            int r12 = r13.bottomMargin
            int r5 = r5 + r12
            int r12 = r13.topMargin
            int r5 = r5 + r12
            r0.q0 = r5
            r0.r0 = r14
        L_0x0090:
            r14 = r6
            goto L_0x00da
        L_0x0092:
            r5 = -2
            if (r6 != r5) goto L_0x00da
            com.scwang.smart.refresh.layout.api.RefreshComponent r5 = r0.B0
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r5 = r5.getSpinnerStyle()
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r6 = com.scwang.smart.refresh.layout.constant.SpinnerStyle.h
            if (r5 != r6) goto L_0x00a5
            com.scwang.smart.refresh.layout.constant.DimensionStatus r5 = r0.r0
            boolean r5 = r5.b
            if (r5 != 0) goto L_0x00da
        L_0x00a5:
            int r5 = android.view.View.MeasureSpec.getSize(r19)
            int r6 = r13.bottomMargin
            int r5 = r5 - r6
            int r6 = r13.topMargin
            int r5 = r5 - r6
            r6 = 0
            int r5 = java.lang.Math.max(r5, r6)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            int r12 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r6)
            r11.measure(r4, r12)
            int r6 = r11.getMeasuredHeight()
            if (r6 <= 0) goto L_0x00da
            if (r6 == r5) goto L_0x00d9
            com.scwang.smart.refresh.layout.constant.DimensionStatus r5 = r0.r0
            com.scwang.smart.refresh.layout.constant.DimensionStatus r12 = com.scwang.smart.refresh.layout.constant.DimensionStatus.e
            boolean r5 = r5.a(r12)
            if (r5 == 0) goto L_0x00d9
            int r5 = r13.bottomMargin
            int r6 = r6 + r5
            int r5 = r13.topMargin
            int r6 = r6 + r5
            r0.q0 = r6
            r0.r0 = r12
        L_0x00d9:
            r14 = -1
        L_0x00da:
            com.scwang.smart.refresh.layout.api.RefreshComponent r5 = r0.B0
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r5 = r5.getSpinnerStyle()
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r6 = com.scwang.smart.refresh.layout.constant.SpinnerStyle.h
            if (r5 != r6) goto L_0x00eb
            int r14 = android.view.View.MeasureSpec.getSize(r19)
            r5 = -1
            r6 = 0
            goto L_0x010d
        L_0x00eb:
            com.scwang.smart.refresh.layout.api.RefreshComponent r5 = r0.B0
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r5 = r5.getSpinnerStyle()
            boolean r5 = r5.c
            if (r5 == 0) goto L_0x010b
            if (r3 != 0) goto L_0x010b
            boolean r5 = r0.B
            boolean r5 = r0.u(r5)
            if (r5 == 0) goto L_0x0103
            int r5 = r0.b
        L_0x0101:
            r6 = 0
            goto L_0x0105
        L_0x0103:
            r5 = 0
            goto L_0x0101
        L_0x0105:
            int r14 = java.lang.Math.max(r6, r5)
        L_0x0109:
            r5 = -1
            goto L_0x010d
        L_0x010b:
            r6 = 0
            goto L_0x0109
        L_0x010d:
            if (r14 == r5) goto L_0x0122
            int r5 = r13.bottomMargin
            int r14 = r14 - r5
            int r5 = r13.topMargin
            int r14 = r14 - r5
            int r5 = java.lang.Math.max(r14, r6)
            r6 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r6)
            r11.measure(r4, r5)
        L_0x0122:
            com.scwang.smart.refresh.layout.constant.DimensionStatus r4 = r0.r0
            boolean r5 = r4.b
            if (r5 != 0) goto L_0x0144
            float r5 = r0.w0
            r6 = 1092616192(0x41200000, float:10.0)
            int r12 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r12 >= 0) goto L_0x0134
            int r6 = r0.q0
            float r6 = (float) r6
            float r5 = r5 * r6
        L_0x0134:
            com.scwang.smart.refresh.layout.constant.DimensionStatus r4 = r4.b()
            r0.r0 = r4
            com.scwang.smart.refresh.layout.api.RefreshComponent r4 = r0.B0
            com.scwang.smart.refresh.layout.api.RefreshKernel r6 = r0.G0
            int r12 = r0.q0
            int r5 = (int) r5
            r4.g(r6, r12, r5)
        L_0x0144:
            if (r3 == 0) goto L_0x015b
            boolean r4 = r0.B
            boolean r4 = r0.u(r4)
            if (r4 == 0) goto L_0x015b
            int r4 = r11.getMeasuredWidth()
            int r8 = r8 + r4
            int r4 = r11.getMeasuredHeight()
            int r9 = r9 + r4
            goto L_0x015b
        L_0x0159:
            r16 = r6
        L_0x015b:
            com.scwang.smart.refresh.layout.api.RefreshComponent r4 = r0.C0
            if (r4 == 0) goto L_0x0275
            android.view.View r4 = r4.getView()
            if (r4 != r10) goto L_0x0275
            com.scwang.smart.refresh.layout.api.RefreshComponent r4 = r0.C0
            android.view.View r4 = r4.getView()
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            boolean r6 = r5 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r6 == 0) goto L_0x0177
            r6 = r5
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            goto L_0x0179
        L_0x0177:
            android.view.ViewGroup$MarginLayoutParams r6 = X0
        L_0x0179:
            int r11 = r6.leftMargin
            int r12 = r6.rightMargin
            int r11 = r11 + r12
            int r12 = r5.width
            int r11 = android.view.ViewGroup.getChildMeasureSpec(r1, r11, r12)
            int r12 = r0.s0
            com.scwang.smart.refresh.layout.constant.DimensionStatus r13 = r0.t0
            int r14 = r13.f9863a
            com.scwang.smart.refresh.layout.constant.DimensionStatus r15 = com.scwang.smart.refresh.layout.constant.DimensionStatus.i
            int r15 = r15.f9863a
            if (r14 >= r15) goto L_0x01ae
            int r14 = r5.height
            if (r14 <= 0) goto L_0x01b0
            int r12 = r6.topMargin
            int r14 = r14 + r12
            int r12 = r6.bottomMargin
            int r12 = r12 + r14
            com.scwang.smart.refresh.layout.constant.DimensionStatus r14 = com.scwang.smart.refresh.layout.constant.DimensionStatus.g
            boolean r13 = r13.a(r14)
            if (r13 == 0) goto L_0x01ae
            int r5 = r5.height
            int r13 = r6.topMargin
            int r5 = r5 + r13
            int r13 = r6.bottomMargin
            int r5 = r5 + r13
            r0.s0 = r5
            r0.t0 = r14
        L_0x01ae:
            r5 = r12
            goto L_0x01f8
        L_0x01b0:
            r5 = -2
            if (r14 != r5) goto L_0x01ae
            com.scwang.smart.refresh.layout.api.RefreshComponent r5 = r0.C0
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r5 = r5.getSpinnerStyle()
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r13 = com.scwang.smart.refresh.layout.constant.SpinnerStyle.h
            if (r5 != r13) goto L_0x01c3
            com.scwang.smart.refresh.layout.constant.DimensionStatus r5 = r0.t0
            boolean r5 = r5.b
            if (r5 != 0) goto L_0x01ae
        L_0x01c3:
            int r5 = android.view.View.MeasureSpec.getSize(r19)
            int r13 = r6.bottomMargin
            int r5 = r5 - r13
            int r13 = r6.topMargin
            int r5 = r5 - r13
            r13 = 0
            int r5 = java.lang.Math.max(r5, r13)
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r13)
            r4.measure(r11, r13)
            int r13 = r4.getMeasuredHeight()
            if (r13 <= 0) goto L_0x01ae
            if (r13 == r5) goto L_0x01f7
            com.scwang.smart.refresh.layout.constant.DimensionStatus r5 = r0.t0
            com.scwang.smart.refresh.layout.constant.DimensionStatus r12 = com.scwang.smart.refresh.layout.constant.DimensionStatus.e
            boolean r5 = r5.a(r12)
            if (r5 == 0) goto L_0x01f7
            int r5 = r6.topMargin
            int r13 = r13 + r5
            int r5 = r6.bottomMargin
            int r13 = r13 + r5
            r0.s0 = r13
            r0.t0 = r12
        L_0x01f7:
            r5 = -1
        L_0x01f8:
            com.scwang.smart.refresh.layout.api.RefreshComponent r12 = r0.C0
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r12 = r12.getSpinnerStyle()
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r13 = com.scwang.smart.refresh.layout.constant.SpinnerStyle.h
            if (r12 != r13) goto L_0x0209
            int r5 = android.view.View.MeasureSpec.getSize(r19)
        L_0x0206:
            r12 = 0
        L_0x0207:
            r13 = -1
            goto L_0x0229
        L_0x0209:
            com.scwang.smart.refresh.layout.api.RefreshComponent r12 = r0.C0
            com.scwang.smart.refresh.layout.constant.SpinnerStyle r12 = r12.getSpinnerStyle()
            boolean r12 = r12.c
            if (r12 == 0) goto L_0x0206
            if (r3 != 0) goto L_0x0206
            boolean r5 = r0.C
            boolean r5 = r0.u(r5)
            if (r5 == 0) goto L_0x0222
            int r5 = r0.b
            int r5 = -r5
        L_0x0220:
            r12 = 0
            goto L_0x0224
        L_0x0222:
            r5 = 0
            goto L_0x0220
        L_0x0224:
            int r5 = java.lang.Math.max(r12, r5)
            goto L_0x0207
        L_0x0229:
            if (r5 == r13) goto L_0x023e
            int r13 = r6.bottomMargin
            int r5 = r5 - r13
            int r6 = r6.topMargin
            int r5 = r5 - r6
            int r5 = java.lang.Math.max(r5, r12)
            r6 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r6)
            r4.measure(r11, r5)
        L_0x023e:
            com.scwang.smart.refresh.layout.constant.DimensionStatus r5 = r0.t0
            boolean r6 = r5.b
            if (r6 != 0) goto L_0x0260
            float r6 = r0.x0
            r11 = 1092616192(0x41200000, float:10.0)
            int r11 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x0250
            int r11 = r0.s0
            float r11 = (float) r11
            float r6 = r6 * r11
        L_0x0250:
            com.scwang.smart.refresh.layout.constant.DimensionStatus r5 = r5.b()
            r0.t0 = r5
            com.scwang.smart.refresh.layout.api.RefreshComponent r5 = r0.C0
            com.scwang.smart.refresh.layout.api.RefreshKernel r11 = r0.G0
            int r13 = r0.s0
            int r6 = (int) r6
            r5.g(r11, r13, r6)
        L_0x0260:
            if (r3 == 0) goto L_0x0276
            boolean r5 = r0.C
            boolean r5 = r0.u(r5)
            if (r5 == 0) goto L_0x0276
            int r5 = r4.getMeasuredWidth()
            int r8 = r8 + r5
            int r4 = r4.getMeasuredHeight()
            int r9 = r9 + r4
            goto L_0x0276
        L_0x0275:
            r12 = 0
        L_0x0276:
            com.scwang.smart.refresh.layout.api.RefreshContent r4 = r0.D0
            if (r4 == 0) goto L_0x031b
            android.view.View r4 = r4.getView()
            if (r4 != r10) goto L_0x031b
            com.scwang.smart.refresh.layout.api.RefreshContent r4 = r0.D0
            android.view.View r4 = r4.getView()
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            boolean r6 = r5 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r6 == 0) goto L_0x0292
            r6 = r5
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            goto L_0x0294
        L_0x0292:
            android.view.ViewGroup$MarginLayoutParams r6 = X0
        L_0x0294:
            com.scwang.smart.refresh.layout.api.RefreshComponent r10 = r0.B0
            if (r10 == 0) goto L_0x02ac
            boolean r10 = r0.B
            boolean r10 = r0.u(r10)
            if (r10 == 0) goto L_0x02ac
            boolean r10 = r0.F
            com.scwang.smart.refresh.layout.api.RefreshComponent r11 = r0.B0
            boolean r10 = r0.v(r10, r11)
            if (r10 == 0) goto L_0x02ac
            r10 = 1
            goto L_0x02ad
        L_0x02ac:
            r10 = r12
        L_0x02ad:
            com.scwang.smart.refresh.layout.api.RefreshComponent r11 = r0.C0
            if (r11 == 0) goto L_0x02c5
            boolean r11 = r0.C
            boolean r11 = r0.u(r11)
            if (r11 == 0) goto L_0x02c5
            boolean r11 = r0.G
            com.scwang.smart.refresh.layout.api.RefreshComponent r13 = r0.C0
            boolean r11 = r0.v(r11, r13)
            if (r11 == 0) goto L_0x02c5
            r11 = 1
            goto L_0x02c6
        L_0x02c5:
            r11 = r12
        L_0x02c6:
            int r13 = r17.getPaddingLeft()
            int r14 = r17.getPaddingRight()
            int r13 = r13 + r14
            int r14 = r6.leftMargin
            int r13 = r13 + r14
            int r14 = r6.rightMargin
            int r13 = r13 + r14
            int r14 = r5.width
            int r13 = android.view.ViewGroup.getChildMeasureSpec(r1, r13, r14)
            int r14 = r17.getPaddingTop()
            int r15 = r17.getPaddingBottom()
            int r14 = r14 + r15
            int r15 = r6.topMargin
            int r14 = r14 + r15
            int r15 = r6.bottomMargin
            int r14 = r14 + r15
            if (r3 == 0) goto L_0x02f1
            if (r10 == 0) goto L_0x02f1
            int r10 = r0.q0
            goto L_0x02f2
        L_0x02f1:
            r10 = r12
        L_0x02f2:
            int r14 = r14 + r10
            if (r3 == 0) goto L_0x02fa
            if (r11 == 0) goto L_0x02fa
            int r10 = r0.s0
            goto L_0x02fb
        L_0x02fa:
            r10 = r12
        L_0x02fb:
            int r14 = r14 + r10
            int r5 = r5.height
            int r5 = android.view.ViewGroup.getChildMeasureSpec(r2, r14, r5)
            r4.measure(r13, r5)
            int r5 = r4.getMeasuredWidth()
            int r10 = r6.leftMargin
            int r5 = r5 + r10
            int r10 = r6.rightMargin
            int r5 = r5 + r10
            int r8 = r8 + r5
            int r4 = r4.getMeasuredHeight()
            int r5 = r6.topMargin
            int r4 = r4 + r5
            int r5 = r6.bottomMargin
            int r4 = r4 + r5
            int r9 = r9 + r4
        L_0x031b:
            int r7 = r7 + 1
            r6 = r16
            goto L_0x001a
        L_0x0321:
            int r3 = r17.getPaddingLeft()
            int r4 = r17.getPaddingRight()
            int r3 = r3 + r4
            int r8 = r8 + r3
            int r3 = r17.getPaddingTop()
            int r4 = r17.getPaddingBottom()
            int r3 = r3 + r4
            int r9 = r9 + r3
            int r3 = super.getSuggestedMinimumWidth()
            int r3 = java.lang.Math.max(r8, r3)
            int r1 = android.view.View.resolveSize(r3, r1)
            int r3 = super.getSuggestedMinimumHeight()
            int r3 = java.lang.Math.max(r9, r3)
            int r2 = android.view.View.resolveSize(r3, r2)
            super.setMeasuredDimension(r1, r2)
            int r1 = r17.getMeasuredWidth()
            float r1 = (float) r1
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            r0.j = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.onMeasure(int, int):void");
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        return this.o0.a(f2, f3, z2);
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return (this.P0 && f3 > 0.0f) || G(-f3) || this.o0.b(f2, f3);
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        int i4 = this.l0;
        int i5 = 0;
        if (i3 * i4 > 0) {
            if (Math.abs(i3) > Math.abs(this.l0)) {
                int i6 = this.l0;
                this.l0 = 0;
                i5 = i6;
            } else {
                this.l0 -= i3;
                i5 = i3;
            }
            w((float) this.l0);
        } else if (i3 > 0 && this.P0) {
            int i7 = i4 - i3;
            this.l0 = i7;
            w((float) i7);
            i5 = i3;
        }
        this.o0.c(i2, i3 - i5, iArr, (int[]) null);
        iArr[1] = iArr[1] + i5;
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        ViewParent parent;
        ScrollBoundaryDecider scrollBoundaryDecider;
        ScrollBoundaryDecider scrollBoundaryDecider2;
        boolean f2 = this.o0.f(i2, i3, i4, i5, this.n0);
        int i6 = i5 + this.n0[1];
        if ((i6 < 0 && ((this.B || this.K) && (this.l0 != 0 || (scrollBoundaryDecider2 = this.k0) == null || scrollBoundaryDecider2.b(this.D0.getView())))) || (i6 > 0 && ((this.C || this.K) && (this.l0 != 0 || (scrollBoundaryDecider = this.k0) == null || scrollBoundaryDecider.a(this.D0.getView()))))) {
            RefreshState refreshState = this.I0;
            if (refreshState == RefreshState.None || refreshState.isOpening) {
                this.G0.f(i6 > 0 ? RefreshState.PullUpToLoad : RefreshState.PullDownToRefresh);
                if (!f2 && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
            int i7 = this.l0 - i6;
            this.l0 = i7;
            w((float) i7);
        }
        if (this.P0 && i3 < 0) {
            this.P0 = false;
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.p0.b(view, view2, i2);
        this.o0.p(i2 & 2);
        this.l0 = this.b;
        this.m0 = true;
        t(0);
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return isEnabled() && isNestedScrollingEnabled() && (i2 & 2) != 0 && (this.K || this.B || this.C);
    }

    public void onStopNestedScroll(View view) {
        this.p0.d(view);
        this.m0 = false;
        this.l0 = 0;
        y();
        this.o0.r();
    }

    public RefreshLayout p() {
        return o(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.J0))), 300) << 16, true, true);
    }

    public RefreshLayout q(int i2) {
        return r(i2, true, Boolean.FALSE);
    }

    public RefreshLayout r(int i2, final boolean z2, final Boolean bool) {
        final int i3 = i2 >> 16;
        int i4 = (i2 << 16) >> 16;
        AnonymousClass6 r1 = new Runnable() {

            /* renamed from: a  reason: collision with root package name */
            public int f9848a = 0;

            public void run() {
                int i = this.f9848a;
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
                if (i == 0) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    RefreshState refreshState = smartRefreshLayout.H0;
                    RefreshState refreshState2 = RefreshState.None;
                    if (refreshState == refreshState2 && smartRefreshLayout.I0 == RefreshState.Refreshing) {
                        smartRefreshLayout.I0 = refreshState2;
                    } else {
                        ValueAnimator valueAnimator = smartRefreshLayout.T0;
                        if (valueAnimator != null && refreshState.isHeader && (refreshState.isDragging || refreshState == RefreshState.RefreshReleased)) {
                            valueAnimator.setDuration(0);
                            SmartRefreshLayout.this.T0.cancel();
                            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                            smartRefreshLayout2.T0 = null;
                            if (smartRefreshLayout2.G0.a(0) == null) {
                                SmartRefreshLayout.this.x(refreshState2);
                            } else {
                                SmartRefreshLayout.this.x(RefreshState.PullDownCanceled);
                            }
                        } else if (!(refreshState != RefreshState.Refreshing || smartRefreshLayout.B0 == null || smartRefreshLayout.D0 == null)) {
                            this.f9848a = i + 1;
                            smartRefreshLayout.F0.postDelayed(this, (long) i3);
                            SmartRefreshLayout.this.x(RefreshState.RefreshFinish);
                            if (bool == Boolean.FALSE) {
                                SmartRefreshLayout.this.A(false);
                            }
                        }
                    }
                    if (bool == Boolean.TRUE) {
                        SmartRefreshLayout.this.A(true);
                        return;
                    }
                    return;
                }
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                int f = smartRefreshLayout3.B0.f(smartRefreshLayout3, z2);
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                OnMultiListener onMultiListener = smartRefreshLayout4.j0;
                if (onMultiListener != null) {
                    RefreshComponent refreshComponent = smartRefreshLayout4.B0;
                    if (refreshComponent instanceof RefreshHeader) {
                        onMultiListener.onHeaderFinish((RefreshHeader) refreshComponent, z2);
                    }
                }
                if (f < Integer.MAX_VALUE) {
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.n || smartRefreshLayout5.m0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        if (smartRefreshLayout6.n) {
                            float f2 = smartRefreshLayout6.k;
                            smartRefreshLayout6.i = f2;
                            smartRefreshLayout6.d = 0;
                            smartRefreshLayout6.n = false;
                            long j = currentTimeMillis;
                            boolean unused = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, j, 0, smartRefreshLayout6.j, (f2 + ((float) smartRefreshLayout6.b)) - ((float) (smartRefreshLayout6.f9841a * 2)), 0));
                            SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                            boolean unused2 = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, j, 2, smartRefreshLayout7.j, smartRefreshLayout7.k + ((float) smartRefreshLayout7.b), 0));
                        }
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        if (smartRefreshLayout8.m0) {
                            smartRefreshLayout8.l0 = 0;
                            boolean unused3 = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout8.j, smartRefreshLayout8.k, 0));
                            SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                            smartRefreshLayout9.m0 = false;
                            smartRefreshLayout9.d = 0;
                        }
                    }
                    SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                    int i2 = smartRefreshLayout10.b;
                    if (i2 > 0) {
                        ValueAnimator k = smartRefreshLayout10.k(0, f, smartRefreshLayout10.z, smartRefreshLayout10.f);
                        SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                        if (smartRefreshLayout11.O) {
                            animatorUpdateListener = smartRefreshLayout11.D0.c(smartRefreshLayout11.b);
                        }
                        if (k != null && animatorUpdateListener != null) {
                            k.addUpdateListener(animatorUpdateListener);
                        }
                    } else if (i2 < 0) {
                        smartRefreshLayout10.k(0, f, smartRefreshLayout10.z, smartRefreshLayout10.f);
                    } else {
                        smartRefreshLayout10.G0.d(0, false);
                        SmartRefreshLayout.this.G0.f(RefreshState.None);
                    }
                }
            }
        };
        if (i4 > 0) {
            this.F0.postDelayed(r1, (long) i4);
        } else {
            r1.run();
        }
        return this;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (ViewCompat.X(this.D0.h())) {
            this.p = z2;
            super.requestDisallowInterceptTouchEvent(z2);
        }
    }

    public RefreshLayout s() {
        return r(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.J0))), 300) << 16, true, Boolean.TRUE);
    }

    public void setNestedScrollingEnabled(boolean z2) {
        this.Q = z2;
        this.o0.n(z2);
    }

    public void setStateDirectLoading(boolean z2) {
        RefreshState refreshState = this.H0;
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2) {
            this.J0 = System.currentTimeMillis();
            this.P0 = true;
            x(refreshState2);
            OnLoadMoreListener onLoadMoreListener = this.i0;
            if (onLoadMoreListener != null) {
                if (z2) {
                    onLoadMoreListener.onLoadMore(this);
                }
            } else if (this.j0 == null) {
                n(2000);
            }
            RefreshComponent refreshComponent = this.C0;
            if (refreshComponent != null) {
                float f2 = this.x0;
                if (f2 < 10.0f) {
                    f2 *= (float) this.s0;
                }
                refreshComponent.b(this, this.s0, (int) f2);
            }
            OnMultiListener onMultiListener = this.j0;
            if (onMultiListener != null && (this.C0 instanceof RefreshFooter)) {
                if (z2) {
                    onMultiListener.onLoadMore(this);
                }
                float f3 = this.x0;
                if (f3 < 10.0f) {
                    f3 *= (float) this.s0;
                }
                this.j0.onFooterStartAnimator((RefreshFooter) this.C0, this.s0, (int) f3);
            }
        }
    }

    public void setStateLoading(final boolean z2) {
        AnonymousClass1 r02 = new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout.this.setStateDirectLoading(z2);
                }
            }
        };
        x(RefreshState.LoadReleased);
        ValueAnimator a2 = this.G0.a(-this.s0);
        if (a2 != null) {
            a2.addListener(r02);
        }
        RefreshComponent refreshComponent = this.C0;
        if (refreshComponent != null) {
            float f2 = this.x0;
            if (f2 < 10.0f) {
                f2 *= (float) this.s0;
            }
            refreshComponent.c(this, this.s0, (int) f2);
        }
        OnMultiListener onMultiListener = this.j0;
        if (onMultiListener != null) {
            RefreshComponent refreshComponent2 = this.C0;
            if (refreshComponent2 instanceof RefreshFooter) {
                float f3 = this.x0;
                if (f3 < 10.0f) {
                    f3 *= (float) this.s0;
                }
                onMultiListener.onFooterReleased((RefreshFooter) refreshComponent2, this.s0, (int) f3);
            }
        }
        if (a2 == null) {
            r02.onAnimationEnd((Animator) null);
        }
    }

    public void setStateRefreshing(final boolean z2) {
        AnonymousClass2 r02 = new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout.this.J0 = System.currentTimeMillis();
                    SmartRefreshLayout.this.x(RefreshState.Refreshing);
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    OnRefreshListener onRefreshListener = smartRefreshLayout.h0;
                    if (onRefreshListener != null) {
                        if (z2) {
                            onRefreshListener.onRefresh(smartRefreshLayout);
                        }
                    } else if (smartRefreshLayout.j0 == null) {
                        smartRefreshLayout.q(3000);
                    }
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    RefreshComponent refreshComponent = smartRefreshLayout2.B0;
                    if (refreshComponent != null) {
                        float f = smartRefreshLayout2.w0;
                        if (f < 10.0f) {
                            f *= (float) smartRefreshLayout2.q0;
                        }
                        refreshComponent.b(smartRefreshLayout2, smartRefreshLayout2.q0, (int) f);
                    }
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    OnMultiListener onMultiListener = smartRefreshLayout3.j0;
                    if (onMultiListener != null && (smartRefreshLayout3.B0 instanceof RefreshHeader)) {
                        if (z2) {
                            onMultiListener.onRefresh(smartRefreshLayout3);
                        }
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        float f2 = smartRefreshLayout4.w0;
                        if (f2 < 10.0f) {
                            f2 *= (float) smartRefreshLayout4.q0;
                        }
                        smartRefreshLayout4.j0.onHeaderStartAnimator((RefreshHeader) smartRefreshLayout4.B0, smartRefreshLayout4.q0, (int) f2);
                    }
                }
            }
        };
        x(RefreshState.RefreshReleased);
        ValueAnimator a2 = this.G0.a(this.q0);
        if (a2 != null) {
            a2.addListener(r02);
        }
        RefreshComponent refreshComponent = this.B0;
        if (refreshComponent != null) {
            float f2 = this.w0;
            if (f2 < 10.0f) {
                f2 *= (float) this.q0;
            }
            refreshComponent.c(this, this.q0, (int) f2);
        }
        OnMultiListener onMultiListener = this.j0;
        if (onMultiListener != null) {
            RefreshComponent refreshComponent2 = this.B0;
            if (refreshComponent2 instanceof RefreshHeader) {
                float f3 = this.w0;
                if (f3 < 10.0f) {
                    f3 *= (float) this.q0;
                }
                onMultiListener.onHeaderReleased((RefreshHeader) refreshComponent2, this.q0, (int) f3);
            }
        }
        if (a2 == null) {
            r02.onAnimationEnd((Animator) null);
        }
    }

    public void setViceState(RefreshState refreshState) {
        RefreshState refreshState2 = this.H0;
        if (refreshState2.isDragging && refreshState2.isHeader != refreshState.isHeader) {
            x(RefreshState.None);
        }
        if (this.I0 != refreshState) {
            this.I0 = refreshState;
        }
    }

    public boolean t(int i2) {
        if (i2 == 0) {
            if (this.T0 != null) {
                RefreshState refreshState = this.H0;
                if (refreshState.isFinishing || refreshState == RefreshState.TwoLevelReleased || refreshState == RefreshState.RefreshReleased || refreshState == RefreshState.LoadReleased) {
                    return true;
                }
                if (refreshState == RefreshState.PullDownCanceled) {
                    this.G0.f(RefreshState.PullDownToRefresh);
                } else if (refreshState == RefreshState.PullUpCanceled) {
                    this.G0.f(RefreshState.PullUpToLoad);
                }
                this.T0.setDuration(0);
                this.T0.cancel();
                this.T0 = null;
            }
            this.S0 = null;
        }
        return this.T0 != null;
    }

    public boolean u(boolean z2) {
        return z2 && !this.M;
    }

    public boolean v(boolean z2, RefreshComponent refreshComponent) {
        return z2 || this.M || refreshComponent == null || refreshComponent.getSpinnerStyle() == SpinnerStyle.f;
    }

    public void w(float f2) {
        RefreshState refreshState;
        float f3 = (!this.m0 || this.P || f2 >= 0.0f || this.D0.e()) ? f2 : 0.0f;
        if (f3 > ((float) (this.g * 5)) && getTag() == null && getTag(R.id.srl_tag) == null) {
            float f4 = this.k;
            int i2 = this.g;
            if (f4 < ((float) i2) / 6.0f && this.j < ((float) i2) / 16.0f) {
                Toast.makeText(getContext(), "你这么死拉，臣妾做不到啊！", 0).show();
                setTag(R.id.srl_tag, "你这么死拉，臣妾做不到啊！");
            }
        }
        RefreshState refreshState2 = this.H0;
        if (refreshState2 == RefreshState.TwoLevel && f3 > 0.0f) {
            this.G0.d(Math.min((int) f3, getMeasuredHeight()), true);
        } else if (refreshState2 == RefreshState.Refreshing && f3 >= 0.0f) {
            int i3 = this.q0;
            if (f3 < ((float) i3)) {
                this.G0.d((int) f3, true);
            } else {
                float f5 = this.w0;
                if (f5 < 10.0f) {
                    f5 *= (float) i3;
                }
                double d2 = (double) (f5 - ((float) i3));
                int max = Math.max((this.g * 4) / 3, getHeight());
                int i4 = this.q0;
                double d3 = (double) (max - i4);
                double max2 = (double) Math.max(0.0f, (f3 - ((float) i4)) * this.l);
                double d4 = -max2;
                if (d3 == 0.0d) {
                    d3 = 1.0d;
                }
                this.G0.d(((int) Math.min(d2 * (1.0d - Math.pow(100.0d, d4 / d3)), max2)) + this.q0, true);
            }
        } else if (f3 < 0.0f && (refreshState2 == RefreshState.Loading || ((this.H && this.T && this.U && u(this.C)) || (this.L && !this.T && u(this.C))))) {
            int i5 = this.s0;
            if (f3 > ((float) (-i5))) {
                this.G0.d((int) f3, true);
            } else {
                float f6 = this.x0;
                if (f6 < 10.0f) {
                    f6 *= (float) i5;
                }
                double d5 = (double) (f6 - ((float) i5));
                int max3 = Math.max((this.g * 4) / 3, getHeight());
                int i6 = this.s0;
                double d6 = (double) (max3 - i6);
                double d7 = (double) (-Math.min(0.0f, (((float) i6) + f3) * this.l));
                double d8 = -d7;
                if (d6 == 0.0d) {
                    d6 = 1.0d;
                }
                this.G0.d(((int) (-Math.min(d5 * (1.0d - Math.pow(100.0d, d8 / d6)), d7))) - this.s0, true);
            }
        } else if (f3 >= 0.0f) {
            float f7 = this.w0;
            double d9 = f7 < 10.0f ? (double) (((float) this.q0) * f7) : (double) f7;
            double max4 = (double) Math.max(this.g / 2, getHeight());
            double max5 = (double) Math.max(0.0f, this.l * f3);
            double d10 = -max5;
            if (max4 == 0.0d) {
                max4 = 1.0d;
            }
            this.G0.d((int) Math.min(d9 * (1.0d - Math.pow(100.0d, d10 / max4)), max5), true);
        } else {
            float f8 = this.x0;
            double d11 = f8 < 10.0f ? (double) (((float) this.s0) * f8) : (double) f8;
            double max6 = (double) Math.max(this.g / 2, getHeight());
            double d12 = (double) (-Math.min(0.0f, this.l * f3));
            this.G0.d((int) (-Math.min(d11 * (1.0d - Math.pow(100.0d, (-d12) / (max6 == 0.0d ? 1.0d : max6))), d12)), true);
        }
        if (this.L && !this.T && u(this.C) && f3 < 0.0f && (refreshState = this.H0) != RefreshState.Refreshing && refreshState != RefreshState.Loading && refreshState != RefreshState.LoadFinish) {
            if (this.S) {
                this.S0 = null;
                this.G0.a(-this.s0);
            }
            setStateDirectLoading(false);
            this.F0.postDelayed(new Runnable() {
                public void run() {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    OnLoadMoreListener onLoadMoreListener = smartRefreshLayout.i0;
                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLoadMore(smartRefreshLayout);
                    } else if (smartRefreshLayout.j0 == null) {
                        smartRefreshLayout.n(2000);
                    }
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    OnMultiListener onMultiListener = smartRefreshLayout2.j0;
                    if (onMultiListener != null) {
                        onMultiListener.onLoadMore(smartRefreshLayout2);
                    }
                }
            }, (long) this.f);
        }
    }

    public void x(RefreshState refreshState) {
        RefreshState refreshState2 = this.H0;
        if (refreshState2 != refreshState) {
            this.H0 = refreshState;
            this.I0 = refreshState;
            RefreshComponent refreshComponent = this.B0;
            RefreshComponent refreshComponent2 = this.C0;
            OnMultiListener onMultiListener = this.j0;
            if (refreshComponent != null) {
                refreshComponent.onStateChanged(this, refreshState2, refreshState);
            }
            if (refreshComponent2 != null) {
                refreshComponent2.onStateChanged(this, refreshState2, refreshState);
            }
            if (onMultiListener != null) {
                onMultiListener.onStateChanged(this, refreshState2, refreshState);
            }
            if (refreshState == RefreshState.LoadFinish) {
                this.P0 = false;
            }
        } else if (this.I0 != refreshState2) {
            this.I0 = refreshState2;
        }
    }

    public void y() {
        RefreshState refreshState = this.H0;
        if (refreshState != RefreshState.TwoLevel) {
            RefreshState refreshState2 = RefreshState.Loading;
            if (refreshState == refreshState2 || (this.H && this.T && this.U && this.b < 0 && u(this.C))) {
                int i2 = this.b;
                int i3 = this.s0;
                if (i2 < (-i3)) {
                    this.G0.a(-i3);
                } else if (i2 > 0) {
                    this.G0.a(0);
                }
            } else {
                RefreshState refreshState3 = this.H0;
                RefreshState refreshState4 = RefreshState.Refreshing;
                if (refreshState3 == refreshState4) {
                    int i4 = this.b;
                    int i5 = this.q0;
                    if (i4 > i5) {
                        this.G0.a(i5);
                    } else if (i4 < 0) {
                        this.G0.a(0);
                    }
                } else if (refreshState3 == RefreshState.PullDownToRefresh) {
                    this.G0.f(RefreshState.PullDownCanceled);
                } else if (refreshState3 == RefreshState.PullUpToLoad) {
                    this.G0.f(RefreshState.PullUpCanceled);
                } else if (refreshState3 == RefreshState.ReleaseToRefresh) {
                    this.G0.f(refreshState4);
                } else if (refreshState3 == RefreshState.ReleaseToLoad) {
                    this.G0.f(refreshState2);
                } else if (refreshState3 == RefreshState.ReleaseToTwoLevel) {
                    this.G0.f(RefreshState.TwoLevelReleased);
                } else if (refreshState3 == RefreshState.RefreshReleased) {
                    if (this.T0 == null) {
                        this.G0.a(this.q0);
                    }
                } else if (refreshState3 == RefreshState.LoadReleased) {
                    if (this.T0 == null) {
                        this.G0.a(-this.s0);
                    }
                } else if (refreshState3 != RefreshState.LoadFinish && this.b != 0) {
                    this.G0.a(0);
                }
            }
        } else if (this.w > -1000 && this.b > getHeight() / 2) {
            ValueAnimator a2 = this.G0.a(getHeight());
            if (a2 != null) {
                a2.setDuration((long) this.e);
            }
        } else if (this.n) {
            this.G0.c();
        }
    }

    public RefreshLayout z(boolean z2) {
        this.B = z2;
        return this;
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 300;
        this.f = 300;
        this.l = 0.5f;
        this.m = 'n';
        this.q = -1;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = true;
        this.M = false;
        this.N = true;
        this.O = true;
        this.P = true;
        this.Q = true;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.g0 = false;
        this.n0 = new int[2];
        this.o0 = new NestedScrollingChildHelper(this);
        this.p0 = new NestedScrollingParentHelper(this);
        DimensionStatus dimensionStatus = DimensionStatus.c;
        this.r0 = dimensionStatus;
        this.t0 = dimensionStatus;
        this.w0 = 2.5f;
        this.x0 = 2.5f;
        this.y0 = 1.0f;
        this.z0 = 1.0f;
        this.A0 = 0.16666667f;
        this.G0 = new RefreshKernelImpl();
        RefreshState refreshState = RefreshState.None;
        this.H0 = refreshState;
        this.I0 = refreshState;
        this.J0 = 0;
        this.K0 = 0;
        this.L0 = 0;
        this.P0 = false;
        this.Q0 = false;
        this.R0 = null;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.F0 = new Handler(Looper.getMainLooper());
        this.x = new Scroller(context);
        this.y = VelocityTracker.obtain();
        this.g = context.getResources().getDisplayMetrics().heightPixels;
        this.z = new SmartUtil(SmartUtil.b);
        this.f9841a = viewConfiguration.getScaledTouchSlop();
        this.u = viewConfiguration.getScaledMinimumFlingVelocity();
        this.v = viewConfiguration.getScaledMaximumFlingVelocity();
        this.s0 = SmartUtil.c(60.0f);
        this.q0 = SmartUtil.c(100.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout);
        if (!obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_android_clipToPadding)) {
            super.setClipToPadding(false);
        }
        if (!obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_android_clipChildren)) {
            super.setClipChildren(false);
        }
        DefaultRefreshInitializer defaultRefreshInitializer = W0;
        if (defaultRefreshInitializer != null) {
            defaultRefreshInitializer.a(context, this);
        }
        this.l = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlDragRate, this.l);
        this.w0 = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.w0);
        this.x0 = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.x0);
        this.y0 = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.y0);
        this.z0 = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterTriggerRate, this.z0);
        this.B = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableRefresh, this.B);
        this.f = obtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_srlReboundDuration, this.f);
        this.C = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMore, this.C);
        this.q0 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderHeight, this.q0);
        this.s0 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterHeight, this.s0);
        this.u0 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderInsetStart, this.u0);
        this.v0 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterInsetStart, this.v0);
        this.R = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.R);
        this.S = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.S);
        this.F = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent, this.F);
        this.G = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent, this.G);
        this.I = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.I);
        this.L = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.L);
        this.J = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.J);
        this.M = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.M);
        this.N = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.N);
        this.O = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.O);
        this.P = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.P);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.H);
        this.H = z2;
        this.H = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, z2);
        this.D = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.D);
        this.E = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.E);
        this.K = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.K);
        this.q = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedHeaderViewId, this.q);
        this.r = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedFooterViewId, this.r);
        this.s = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlHeaderTranslationViewId, this.s);
        this.t = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFooterTranslationViewId, this.t);
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableNestedScrolling, this.Q);
        this.Q = z3;
        this.o0.n(z3);
        this.V = this.V || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableLoadMore);
        this.W = this.W || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent);
        this.g0 = this.g0 || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent);
        this.r0 = obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlHeaderHeight) ? DimensionStatus.i : this.r0;
        this.t0 = obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlFooterHeight) ? DimensionStatus.i : this.t0;
        int color = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.A = new int[]{color2, color};
            } else {
                this.A = new int[]{color2};
            }
        } else if (color != 0) {
            this.A = new int[]{0, color};
        }
        if (this.M && !this.V && !this.C) {
            this.C = true;
        }
        obtainStyledAttributes.recycle();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f9860a = 0;
        public SpinnerStyle b = null;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout_Layout);
            this.f9860a = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.f9860a);
            if (obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle)) {
                this.b = SpinnerStyle.i[obtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle, SpinnerStyle.d.f9864a)];
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }
    }
}
