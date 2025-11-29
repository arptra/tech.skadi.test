package androidx.drawerlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import androidx.drawerlayout.R;
import com.here.posclient.PositionEstimate;
import io.flutter.plugin.platform.PlatformPlugin;
import io.netty.handler.codec.http2.Http2CodecUtil;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup implements Openable {
    public static final int[] L = {16843828};
    public static final int[] M = {16842931};
    public static final boolean N = true;
    public static final boolean O = true;
    public static boolean P = true;
    public CharSequence A;
    public Object B;
    public boolean C;
    public Drawable D;
    public Drawable E;
    public Drawable F;
    public Drawable G;
    public final ArrayList H;
    public Rect I;
    public Matrix J;
    public final AccessibilityViewCommand K;

    /* renamed from: a  reason: collision with root package name */
    public final ChildAccessibilityDelegate f1172a;
    public float b;
    public int c;
    public int d;
    public float e;
    public Paint f;
    public final ViewDragHelper g;
    public final ViewDragHelper h;
    public final ViewDragCallback i;
    public final ViewDragCallback j;
    public int k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public DrawerListener s;
    public List t;
    public float u;
    public float v;
    public Drawable w;
    public Drawable x;
    public Drawable y;
    public CharSequence z;

    public class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* renamed from: a  reason: collision with root package name */
        public final Rect f1175a = new Rect();

        public AccessibilityDelegate() {
        }

        public final void c(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.A(childAt)) {
                    accessibilityNodeInfoCompat.c(childAt);
                }
            }
        }

        public final void d(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f1175a;
            accessibilityNodeInfoCompat2.l(rect);
            accessibilityNodeInfoCompat.d0(rect);
            accessibilityNodeInfoCompat.N0(accessibilityNodeInfoCompat2.U());
            accessibilityNodeInfoCompat.y0(accessibilityNodeInfoCompat2.w());
            accessibilityNodeInfoCompat.h0(accessibilityNodeInfoCompat2.o());
            accessibilityNodeInfoCompat.l0(accessibilityNodeInfoCompat2.r());
            accessibilityNodeInfoCompat.o0(accessibilityNodeInfoCompat2.J());
            accessibilityNodeInfoCompat.r0(accessibilityNodeInfoCompat2.L());
            accessibilityNodeInfoCompat.b0(accessibilityNodeInfoCompat2.E());
            accessibilityNodeInfoCompat.G0(accessibilityNodeInfoCompat2.R());
            accessibilityNodeInfoCompat.a(accessibilityNodeInfoCompat2.i());
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence s;
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View p = DrawerLayout.this.p();
            if (p == null || (s = DrawerLayout.this.s(DrawerLayout.this.t(p))) == null) {
                return true;
            }
            text.add(s);
            return true;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.N) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfoCompat X = AccessibilityNodeInfoCompat.X(accessibilityNodeInfoCompat);
                super.onInitializeAccessibilityNodeInfo(view, X);
                accessibilityNodeInfoCompat.I0(view);
                ViewParent G = ViewCompat.G(view);
                if (G instanceof View) {
                    accessibilityNodeInfoCompat.A0((View) G);
                }
                d(accessibilityNodeInfoCompat, X);
                X.Z();
                c(accessibilityNodeInfoCompat, (ViewGroup) view);
            }
            accessibilityNodeInfoCompat.h0("androidx.drawerlayout.widget.DrawerLayout");
            accessibilityNodeInfoCompat.q0(false);
            accessibilityNodeInfoCompat.r0(false);
            accessibilityNodeInfoCompat.a0(AccessibilityNodeInfoCompat.AccessibilityActionCompat.e);
            accessibilityNodeInfoCompat.a0(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.N || DrawerLayout.A(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    public static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!DrawerLayout.A(view)) {
                accessibilityNodeInfoCompat.A0((View) null);
            }
        }
    }

    public interface DrawerListener {
        void onDrawerClosed(View view);

        void onDrawerOpened(View view);

        void onDrawerSlide(View view, float f);

        void onDrawerStateChanged(int i);
    }

    public static abstract class SimpleDrawerListener implements DrawerListener {
        public void onDrawerClosed(View view) {
        }

        public void onDrawerOpened(View view) {
        }

        public void onDrawerSlide(View view, float f) {
        }

        public void onDrawerStateChanged(int i) {
        }
    }

    public class ViewDragCallback extends ViewDragHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final int f1177a;
        public ViewDragHelper b;
        public final Runnable c = new Runnable() {
            public void run() {
                ViewDragCallback.this.b();
            }
        };

        public ViewDragCallback(int i) {
            this.f1177a = i;
        }

        public final void a() {
            int i = 3;
            if (this.f1177a == 3) {
                i = 5;
            }
            View n = DrawerLayout.this.n(i);
            if (n != null) {
                DrawerLayout.this.f(n);
            }
        }

        public void b() {
            View view;
            int i;
            int y = this.b.y();
            int i2 = 0;
            boolean z = this.f1177a == 3;
            if (z) {
                view = DrawerLayout.this.n(3);
                if (view != null) {
                    i2 = -view.getWidth();
                }
                i = i2 + y;
            } else {
                view = DrawerLayout.this.n(5);
                i = DrawerLayout.this.getWidth() - y;
            }
            if (view == null) {
                return;
            }
            if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && DrawerLayout.this.r(view) == 0) {
                this.b.R(view, i, view.getTop());
                ((LayoutParams) view.getLayoutParams()).c = true;
                DrawerLayout.this.invalidate();
                a();
                DrawerLayout.this.b();
            }
        }

        public void c() {
            DrawerLayout.this.removeCallbacks(this.c);
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            if (DrawerLayout.this.c(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        public void d(ViewDragHelper viewDragHelper) {
            this.b = viewDragHelper;
        }

        public int getViewHorizontalDragRange(View view) {
            if (DrawerLayout.this.D(view)) {
                return view.getWidth();
            }
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
            View n = (i & 1) == 1 ? DrawerLayout.this.n(3) : DrawerLayout.this.n(5);
            if (n != null && DrawerLayout.this.r(n) == 0) {
                this.b.c(n, i2);
            }
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
            DrawerLayout.this.postDelayed(this.c, 160);
        }

        public void onViewCaptured(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).c = false;
            a();
        }

        public void onViewDragStateChanged(int i) {
            DrawerLayout.this.W(i, this.b.w());
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            int width = view.getWidth();
            float width2 = (DrawerLayout.this.c(view, 3) ? (float) (i + width) : (float) (DrawerLayout.this.getWidth() - i)) / ((float) width);
            DrawerLayout.this.T(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f, float f2) {
            int i;
            float u = DrawerLayout.this.u(view);
            int width = view.getWidth();
            if (DrawerLayout.this.c(view, 3)) {
                int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                i = (i2 > 0 || (i2 == 0 && u > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && u > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.b.P(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        public boolean tryCaptureView(View view, int i) {
            return DrawerLayout.this.D(view) && DrawerLayout.this.c(view, this.f1177a) && DrawerLayout.this.r(view) == 0;
        }
    }

    public DrawerLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public static boolean A(View view) {
        return (ViewCompat.x(view) == 4 || ViewCompat.x(view) == 2) ? false : true;
    }

    public static String w(int i2) {
        return (i2 & 3) == 3 ? "LEFT" : (i2 & 5) == 5 ? "RIGHT" : Integer.toHexString(i2);
    }

    public static boolean x(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public boolean B(View view) {
        return ((LayoutParams) view.getLayoutParams()).f1176a == 0;
    }

    public boolean C(View view) {
        if (D(view)) {
            return (((LayoutParams) view.getLayoutParams()).d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean D(View view) {
        int b2 = GravityCompat.b(((LayoutParams) view.getLayoutParams()).f1176a, ViewCompat.z(view));
        return ((b2 & 3) == 0 && (b2 & 5) == 0) ? false : true;
    }

    public boolean E(int i2) {
        View n2 = n(i2);
        if (n2 != null) {
            return F(n2);
        }
        return false;
    }

    public boolean F(View view) {
        if (D(view)) {
            return ((LayoutParams) view.getLayoutParams()).b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public final boolean G(float f2, float f3, View view) {
        if (this.I == null) {
            this.I = new Rect();
        }
        view.getHitRect(this.I);
        return this.I.contains((int) f2, (int) f3);
    }

    public final void H(Drawable drawable, int i2) {
        if (drawable != null && DrawableCompat.h(drawable)) {
            DrawableCompat.m(drawable, i2);
        }
    }

    public void I(View view, float f2) {
        float u2 = u(view);
        float width = (float) view.getWidth();
        int i2 = ((int) (width * f2)) - ((int) (u2 * width));
        if (!c(view, 3)) {
            i2 = -i2;
        }
        view.offsetLeftAndRight(i2);
        T(view, f2);
    }

    public void J(int i2) {
        K(i2, true);
    }

    public void K(int i2, boolean z2) {
        View n2 = n(i2);
        if (n2 != null) {
            M(n2, z2);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + w(i2));
    }

    public void L(View view) {
        M(view, true);
    }

    public void M(View view, boolean z2) {
        if (D(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.m) {
                layoutParams.b = 1.0f;
                layoutParams.d = 1;
                V(view, true);
                U(view);
            } else if (z2) {
                layoutParams.d |= 2;
                if (c(view, 3)) {
                    this.g.R(view, 0, view.getTop());
                } else {
                    this.h.R(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                I(view, 1.0f);
                W(0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void N(DrawerListener drawerListener) {
        List list;
        if (drawerListener != null && (list = this.t) != null) {
            list.remove(drawerListener);
        }
    }

    public final Drawable O() {
        int z2 = ViewCompat.z(this);
        if (z2 == 0) {
            Drawable drawable = this.D;
            if (drawable != null) {
                H(drawable, z2);
                return this.D;
            }
        } else {
            Drawable drawable2 = this.E;
            if (drawable2 != null) {
                H(drawable2, z2);
                return this.E;
            }
        }
        return this.F;
    }

    public final Drawable P() {
        int z2 = ViewCompat.z(this);
        if (z2 == 0) {
            Drawable drawable = this.E;
            if (drawable != null) {
                H(drawable, z2);
                return this.E;
            }
        } else {
            Drawable drawable2 = this.D;
            if (drawable2 != null) {
                H(drawable2, z2);
                return this.D;
            }
        }
        return this.G;
    }

    public final void Q() {
        if (!O) {
            this.x = O();
            this.y = P();
        }
    }

    public void R(Object obj, boolean z2) {
        this.B = obj;
        this.C = z2;
        setWillNotDraw(!z2 && getBackground() == null);
        requestLayout();
    }

    public void S(int i2, int i3) {
        View n2;
        int b2 = GravityCompat.b(i3, ViewCompat.z(this));
        if (i3 == 3) {
            this.n = i2;
        } else if (i3 == 5) {
            this.o = i2;
        } else if (i3 == 8388611) {
            this.p = i2;
        } else if (i3 == 8388613) {
            this.q = i2;
        }
        if (i2 != 0) {
            (b2 == 3 ? this.g : this.h).b();
        }
        if (i2 == 1) {
            View n3 = n(b2);
            if (n3 != null) {
                f(n3);
            }
        } else if (i2 == 2 && (n2 = n(b2)) != null) {
            L(n2);
        }
    }

    public void T(View view, float f2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 != layoutParams.b) {
            layoutParams.b = f2;
            l(view, f2);
        }
    }

    public final void U(View view) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.y;
        ViewCompat.n0(view, accessibilityActionCompat.b());
        if (C(view) && r(view) != 2) {
            ViewCompat.p0(view, accessibilityActionCompat, (CharSequence) null, this.K);
        }
    }

    public final void V(View view, boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((z2 || D(childAt)) && (!z2 || childAt != view)) {
                ViewCompat.G0(childAt, 4);
            } else {
                ViewCompat.G0(childAt, 1);
            }
        }
    }

    public void W(int i2, View view) {
        int i3;
        int B2 = this.g.B();
        int B3 = this.h.B();
        if (B2 == 1 || B3 == 1) {
            i3 = 1;
        } else {
            i3 = 2;
            if (!(B2 == 2 || B3 == 2)) {
                i3 = 0;
            }
        }
        if (view != null && i2 == 0) {
            float f2 = ((LayoutParams) view.getLayoutParams()).b;
            if (f2 == 0.0f) {
                j(view);
            } else if (f2 == 1.0f) {
                k(view);
            }
        }
        if (i3 != this.k) {
            this.k = i3;
            List list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((DrawerListener) this.t.get(size)).onDrawerStateChanged(i3);
                }
            }
        }
    }

    public void a(DrawerListener drawerListener) {
        if (drawerListener != null) {
            if (this.t == null) {
                this.t = new ArrayList();
            }
            this.t.add(drawerListener);
        }
    }

    public void addFocusables(ArrayList arrayList, int i2, int i3) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z2 = false;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (!D(childAt)) {
                    this.H.add(childAt);
                } else if (C(childAt)) {
                    childAt.addFocusables(arrayList, i2, i3);
                    z2 = true;
                }
            }
            if (!z2) {
                int size = this.H.size();
                for (int i5 = 0; i5 < size; i5++) {
                    View view = (View) this.H.get(i5);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i2, i3);
                    }
                }
            }
            this.H.clear();
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (o() != null || D(view)) {
            ViewCompat.G0(view, 4);
        } else {
            ViewCompat.G0(view, 1);
        }
        if (!N) {
            ViewCompat.u0(view, this.f1172a);
        }
    }

    public void b() {
        if (!this.r) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                getChildAt(i2).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.r = true;
        }
    }

    public boolean c(View view, int i2) {
        return (t(view) & i2) == i2;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            f2 = Math.max(f2, ((LayoutParams) getChildAt(i2).getLayoutParams()).b);
        }
        this.e = f2;
        boolean n2 = this.g.n(true);
        boolean n3 = this.h.n(true);
        if (n2 || n3) {
            ViewCompat.k0(this);
        }
    }

    public void d(int i2) {
        e(i2, true);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            View childAt = getChildAt(i2);
            if (G(x2, y2, childAt) && !B(childAt) && m(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        Canvas canvas2 = canvas;
        View view2 = view;
        int height = getHeight();
        boolean B2 = B(view2);
        int width = getWidth();
        int save = canvas.save();
        int i2 = 0;
        if (B2) {
            int childCount = getChildCount();
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != view2 && childAt.getVisibility() == 0 && x(childAt) && D(childAt) && childAt.getHeight() >= height) {
                    if (c(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i3) {
                            i3 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i3, 0, width, getHeight());
            i2 = i3;
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        float f2 = this.e;
        if (f2 > 0.0f && B2) {
            int i5 = this.d;
            this.f.setColor((i5 & Http2CodecUtil.MAX_FRAME_SIZE_UPPER_BOUND) | (((int) (((float) ((-16777216 & i5) >>> 24)) * f2)) << 24));
            canvas.drawRect((float) i2, 0.0f, (float) width, (float) getHeight(), this.f);
        } else if (this.x != null && c(view2, 3)) {
            int intrinsicWidth = this.x.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(((float) right2) / ((float) this.g.y()), 1.0f));
            this.x.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.x.setAlpha((int) (max * 255.0f));
            this.x.draw(canvas);
        } else if (this.y != null && c(view2, 5)) {
            int intrinsicWidth2 = this.y.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min(((float) (getWidth() - left2)) / ((float) this.h.y()), 1.0f));
            this.y.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.y.setAlpha((int) (max2 * 255.0f));
            this.y.draw(canvas);
        }
        return drawChild;
    }

    public void e(int i2, boolean z2) {
        View n2 = n(i2);
        if (n2 != null) {
            g(n2, z2);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + w(i2));
    }

    public void f(View view) {
        g(view, true);
    }

    public void g(View view, boolean z2) {
        if (D(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.m) {
                layoutParams.b = 0.0f;
                layoutParams.d = 0;
            } else if (z2) {
                layoutParams.d |= 4;
                if (c(view, 3)) {
                    this.g.R(view, -view.getWidth(), view.getTop());
                } else {
                    this.h.R(view, getWidth(), view.getTop());
                }
            } else {
                I(view, 0.0f);
                W(0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (O) {
            return this.b;
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        return this.w;
    }

    public void h() {
        i(false);
    }

    public void i(boolean z2) {
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (D(childAt) && (!z2 || layoutParams.c)) {
                z3 |= c(childAt, 3) ? this.g.R(childAt, -childAt.getWidth(), childAt.getTop()) : this.h.R(childAt, getWidth(), childAt.getTop());
                layoutParams.c = false;
            }
        }
        this.i.c();
        this.j.c();
        if (z3) {
            invalidate();
        }
    }

    public void j(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.d & 1) == 1) {
            layoutParams.d = 0;
            List list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((DrawerListener) this.t.get(size)).onDrawerClosed(view);
                }
            }
            V(view, false);
            U(view);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    public void k(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.d & 1) == 0) {
            layoutParams.d = 1;
            List list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((DrawerListener) this.t.get(size)).onDrawerOpened(view);
                }
            }
            V(view, true);
            U(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    public void l(View view, float f2) {
        List list = this.t;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((DrawerListener) this.t.get(size)).onDrawerSlide(view, f2);
            }
        }
    }

    public final boolean m(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent v2 = v(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(v2);
            v2.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = (float) (getScrollX() - view.getLeft());
        float scrollY = (float) (getScrollY() - view.getTop());
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    public View n(int i2) {
        int b2 = GravityCompat.b(i2, ViewCompat.z(this)) & 7;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((t(childAt) & 7) == b2) {
                return childAt;
            }
        }
        return null;
    }

    public View o() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((((LayoutParams) childAt.getLayoutParams()).d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.m = true;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.C && this.w != null) {
            Object obj = this.B;
            int systemWindowInsetTop = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.w.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.w.draw(canvas);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004b, code lost:
        r7 = r6.g.u((int) r0, (int) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0 != 3) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            androidx.customview.widget.ViewDragHelper r1 = r6.g
            boolean r1 = r1.Q(r7)
            androidx.customview.widget.ViewDragHelper r2 = r6.h
            boolean r2 = r2.Q(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0038
            if (r0 == r2) goto L_0x0031
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L_0x001e
            if (r0 == r4) goto L_0x0031
            goto L_0x0036
        L_0x001e:
            androidx.customview.widget.ViewDragHelper r7 = r6.g
            boolean r7 = r7.e(r4)
            if (r7 == 0) goto L_0x0036
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r7 = r6.i
            r7.c()
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r7 = r6.j
            r7.c()
            goto L_0x0036
        L_0x0031:
            r6.i(r2)
            r6.r = r3
        L_0x0036:
            r7 = r3
            goto L_0x0060
        L_0x0038:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.u = r0
            r6.v = r7
            float r4 = r6.e
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x005d
            androidx.customview.widget.ViewDragHelper r4 = r6.g
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.u(r0, r7)
            if (r7 == 0) goto L_0x005d
            boolean r7 = r6.B(r7)
            if (r7 == 0) goto L_0x005d
            r7 = r2
            goto L_0x005e
        L_0x005d:
            r7 = r3
        L_0x005e:
            r6.r = r3
        L_0x0060:
            if (r1 != 0) goto L_0x0070
            if (r7 != 0) goto L_0x0070
            boolean r7 = r6.y()
            if (r7 != 0) goto L_0x0070
            boolean r6 = r6.r
            if (r6 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r2 = r3
        L_0x0070:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !z()) {
            return super.onKeyDown(i2, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        View p2 = p();
        if (p2 != null && r(p2) == 0) {
            h();
        }
        return p2 != null;
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        WindowInsets rootWindowInsets;
        float f2;
        int i6;
        boolean z3 = true;
        this.l = true;
        int i7 = i4 - i2;
        int childCount = getChildCount();
        int i8 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (B(childAt)) {
                    int i9 = layoutParams.leftMargin;
                    childAt.layout(i9, layoutParams.topMargin, childAt.getMeasuredWidth() + i9, layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (c(childAt, 3)) {
                        float f3 = (float) measuredWidth;
                        i6 = (-measuredWidth) + ((int) (layoutParams.b * f3));
                        f2 = ((float) (measuredWidth + i6)) / f3;
                    } else {
                        float f4 = (float) measuredWidth;
                        int i10 = i7 - ((int) (layoutParams.b * f4));
                        f2 = ((float) (i7 - i10)) / f4;
                        i6 = i10;
                    }
                    boolean z4 = f2 != layoutParams.b ? z3 : false;
                    int i11 = layoutParams.f1176a & 112;
                    if (i11 == 16) {
                        int i12 = i5 - i3;
                        int i13 = (i12 - measuredHeight) / 2;
                        int i14 = layoutParams.topMargin;
                        if (i13 < i14) {
                            i13 = i14;
                        } else {
                            int i15 = i13 + measuredHeight;
                            int i16 = layoutParams.bottomMargin;
                            if (i15 > i12 - i16) {
                                i13 = (i12 - i16) - measuredHeight;
                            }
                        }
                        childAt.layout(i6, i13, measuredWidth + i6, measuredHeight + i13);
                    } else if (i11 != 80) {
                        int i17 = layoutParams.topMargin;
                        childAt.layout(i6, i17, measuredWidth + i6, measuredHeight + i17);
                    } else {
                        int i18 = i5 - i3;
                        childAt.layout(i6, (i18 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i6, i18 - layoutParams.bottomMargin);
                    }
                    if (z4) {
                        T(childAt, f2);
                    }
                    int i19 = layoutParams.b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i19) {
                        childAt.setVisibility(i19);
                    }
                }
            }
            i8++;
            z3 = true;
        }
        if (P && (rootWindowInsets = getRootWindowInsets()) != null) {
            Insets h2 = WindowInsetsCompat.x(rootWindowInsets).h();
            ViewDragHelper viewDragHelper = this.g;
            viewDragHelper.M(Math.max(viewDragHelper.x(), h2.f712a));
            ViewDragHelper viewDragHelper2 = this.h;
            viewDragHelper2.M(Math.max(viewDragHelper2.x(), h2.c));
        }
        this.l = false;
        this.m = false;
    }

    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode == 0) {
                    size = 300;
                }
                if (mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        boolean z2 = this.B != null && ViewCompat.w(this);
        int z3 = ViewCompat.z(this);
        int childCount = getChildCount();
        boolean z4 = false;
        boolean z5 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z2) {
                    int b2 = GravityCompat.b(layoutParams.f1176a, z3);
                    if (ViewCompat.w(childAt)) {
                        WindowInsets windowInsets = (WindowInsets) this.B;
                        if (b2 == 3) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                        } else if (b2 == 5) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsets);
                    } else {
                        WindowInsets windowInsets2 = (WindowInsets) this.B;
                        if (b2 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), 0, windowInsets2.getSystemWindowInsetBottom());
                        } else if (b2 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(0, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        layoutParams.leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        layoutParams.topMargin = windowInsets2.getSystemWindowInsetTop();
                        layoutParams.rightMargin = windowInsets2.getSystemWindowInsetRight();
                        layoutParams.bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (B(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824));
                } else if (D(childAt)) {
                    if (O) {
                        float u2 = ViewCompat.u(childAt);
                        float f2 = this.b;
                        if (u2 != f2) {
                            ViewCompat.D0(childAt, f2);
                        }
                    }
                    int t2 = t(childAt) & 7;
                    boolean z6 = t2 == 3;
                    if ((!z6 || !z4) && (z6 || !z5)) {
                        if (z6) {
                            z4 = true;
                        } else {
                            z5 = true;
                        }
                        childAt.measure(ViewGroup.getChildMeasureSpec(i2, this.c + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), ViewGroup.getChildMeasureSpec(i3, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                    } else {
                        throw new IllegalStateException("Child drawer has absolute gravity " + w(t2) + " but this " + "DrawerLayout" + " already has a drawer view along that edge");
                    }
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i4 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            int i5 = i2;
            int i6 = i3;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        View n2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i2 = savedState.openDrawerGravity;
        if (!(i2 == 0 || (n2 = n(i2)) == null)) {
            L(n2);
        }
        int i3 = savedState.lockModeLeft;
        if (i3 != 3) {
            S(i3, 3);
        }
        int i4 = savedState.lockModeRight;
        if (i4 != 3) {
            S(i4, 5);
        }
        int i5 = savedState.lockModeStart;
        if (i5 != 3) {
            S(i5, 8388611);
        }
        int i6 = savedState.lockModeEnd;
        if (i6 != 3) {
            S(i6, 8388613);
        }
    }

    public void onRtlPropertiesChanged(int i2) {
        Q();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
            int i3 = layoutParams.d;
            boolean z2 = true;
            boolean z3 = i3 == 1;
            if (i3 != 2) {
                z2 = false;
            }
            if (z3 || z2) {
                savedState.openDrawerGravity = layoutParams.f1176a;
            } else {
                i2++;
            }
        }
        savedState.lockModeLeft = this.n;
        savedState.lockModeRight = this.o;
        savedState.lockModeStart = this.p;
        savedState.lockModeEnd = this.q;
        return savedState;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
        if (r(r7) != 2) goto L_0x005b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.widget.ViewDragHelper r0 = r6.g
            r0.G(r7)
            androidx.customview.widget.ViewDragHelper r0 = r6.h
            r0.G(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x005f
            if (r0 == r2) goto L_0x0020
            r7 = 3
            if (r0 == r7) goto L_0x001a
            goto L_0x006d
        L_0x001a:
            r6.i(r2)
            r6.r = r1
            goto L_0x006d
        L_0x0020:
            float r0 = r7.getX()
            float r7 = r7.getY()
            androidx.customview.widget.ViewDragHelper r3 = r6.g
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.u(r4, r5)
            if (r3 == 0) goto L_0x005a
            boolean r3 = r6.B(r3)
            if (r3 == 0) goto L_0x005a
            float r3 = r6.u
            float r0 = r0 - r3
            float r3 = r6.v
            float r7 = r7 - r3
            androidx.customview.widget.ViewDragHelper r3 = r6.g
            int r3 = r3.A()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x005a
            android.view.View r7 = r6.o()
            if (r7 == 0) goto L_0x005a
            int r7 = r6.r(r7)
            r0 = 2
            if (r7 != r0) goto L_0x005b
        L_0x005a:
            r1 = r2
        L_0x005b:
            r6.i(r1)
            goto L_0x006d
        L_0x005f:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.u = r0
            r6.v = r7
            r6.r = r1
        L_0x006d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public View p() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (D(childAt) && F(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public int q(int i2) {
        int z2 = ViewCompat.z(this);
        if (i2 == 3) {
            int i3 = this.n;
            if (i3 != 3) {
                return i3;
            }
            int i4 = z2 == 0 ? this.p : this.q;
            if (i4 != 3) {
                return i4;
            }
            return 0;
        } else if (i2 == 5) {
            int i5 = this.o;
            if (i5 != 3) {
                return i5;
            }
            int i6 = z2 == 0 ? this.q : this.p;
            if (i6 != 3) {
                return i6;
            }
            return 0;
        } else if (i2 == 8388611) {
            int i7 = this.p;
            if (i7 != 3) {
                return i7;
            }
            int i8 = z2 == 0 ? this.n : this.o;
            if (i8 != 3) {
                return i8;
            }
            return 0;
        } else if (i2 != 8388613) {
            return 0;
        } else {
            int i9 = this.q;
            if (i9 != 3) {
                return i9;
            }
            int i10 = z2 == 0 ? this.o : this.n;
            if (i10 != 3) {
                return i10;
            }
            return 0;
        }
    }

    public int r(View view) {
        if (D(view)) {
            return q(((LayoutParams) view.getLayoutParams()).f1176a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (z2) {
            i(true);
        }
    }

    public void requestLayout() {
        if (!this.l) {
            super.requestLayout();
        }
    }

    public CharSequence s(int i2) {
        int b2 = GravityCompat.b(i2, ViewCompat.z(this));
        if (b2 == 3) {
            return this.z;
        }
        if (b2 == 5) {
            return this.A;
        }
        return null;
    }

    public void setDrawerElevation(float f2) {
        this.b = f2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (D(childAt)) {
                ViewCompat.D0(childAt, this.b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        DrawerListener drawerListener2 = this.s;
        if (drawerListener2 != null) {
            N(drawerListener2);
        }
        if (drawerListener != null) {
            a(drawerListener);
        }
        this.s = drawerListener;
    }

    public void setDrawerLockMode(int i2) {
        S(i2, 3);
        S(i2, 5);
    }

    public void setScrimColor(@ColorInt int i2) {
        this.d = i2;
        invalidate();
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        this.w = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int i2) {
        this.w = new ColorDrawable(i2);
        invalidate();
    }

    public int t(View view) {
        return GravityCompat.b(((LayoutParams) view.getLayoutParams()).f1176a, ViewCompat.z(this));
    }

    public float u(View view) {
        return ((LayoutParams) view.getLayoutParams()).b;
    }

    public final MotionEvent v(MotionEvent motionEvent, View view) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation((float) (getScrollX() - view.getLeft()), (float) (getScrollY() - view.getTop()));
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.J == null) {
                this.J = new Matrix();
            }
            matrix.invert(this.J);
            obtain.transform(this.J);
        }
        return obtain;
    }

    public final boolean y() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((LayoutParams) getChildAt(i2).getLayoutParams()).c) {
                return true;
            }
        }
        return false;
    }

    public final boolean z() {
        return p() != null;
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.drawerLayoutStyle);
    }

    /* JADX INFO: finally extract failed */
    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1172a = new ChildAccessibilityDelegate();
        this.d = -1728053248;
        this.f = new Paint();
        this.m = true;
        this.n = 3;
        this.o = 3;
        this.p = 3;
        this.q = 3;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.K = new AccessibilityViewCommand() {
            public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                if (!DrawerLayout.this.C(view) || DrawerLayout.this.r(view) == 2) {
                    return false;
                }
                DrawerLayout.this.f(view);
                return true;
            }
        };
        setDescendantFocusability(PositionEstimate.Value.BUILDING_NAME);
        float f2 = getResources().getDisplayMetrics().density;
        this.c = (int) ((64.0f * f2) + 0.5f);
        float f3 = f2 * 400.0f;
        ViewDragCallback viewDragCallback = new ViewDragCallback(3);
        this.i = viewDragCallback;
        ViewDragCallback viewDragCallback2 = new ViewDragCallback(5);
        this.j = viewDragCallback2;
        ViewDragHelper o2 = ViewDragHelper.o(this, 1.0f, viewDragCallback);
        this.g = o2;
        o2.N(1);
        o2.O(f3);
        viewDragCallback.d(o2);
        ViewDragHelper o3 = ViewDragHelper.o(this, 1.0f, viewDragCallback2);
        this.h = o3;
        o3.N(2);
        o3.O(f3);
        viewDragCallback2.d(o3);
        setFocusableInTouchMode(true);
        ViewCompat.G0(this, 1);
        ViewCompat.u0(this, new AccessibilityDelegate());
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.w(this)) {
            setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    ((DrawerLayout) view).R(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
                    return windowInsets.consumeSystemWindowInsets();
                }
            });
            setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(L);
            try {
                this.w = obtainStyledAttributes.getDrawable(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.DrawerLayout, i2, 0);
        try {
            if (obtainStyledAttributes2.hasValue(R.styleable.DrawerLayout_elevation)) {
                this.b = obtainStyledAttributes2.getDimension(R.styleable.DrawerLayout_elevation, 0.0f);
            } else {
                this.b = getResources().getDimension(R.dimen.def_drawer_elevation);
            }
            obtainStyledAttributes2.recycle();
            this.H = new ArrayList();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public void setStatusBarBackground(int i2) {
        this.w = i2 != 0 ? ContextCompat.getDrawable(getContext(), i2) : null;
        invalidate();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f1176a = 0;
        public float b;
        public boolean c;
        public int d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.M);
            this.f1176a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1176a = layoutParams.f1176a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        int openDrawerGravity = 0;

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.openDrawerGravity = parcel.readInt();
            this.lockModeLeft = parcel.readInt();
            this.lockModeRight = parcel.readInt();
            this.lockModeStart = parcel.readInt();
            this.lockModeEnd = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.openDrawerGravity);
            parcel.writeInt(this.lockModeLeft);
            parcel.writeInt(this.lockModeRight);
            parcel.writeInt(this.lockModeStart);
            parcel.writeInt(this.lockModeEnd);
        }

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
        }
    }
}
