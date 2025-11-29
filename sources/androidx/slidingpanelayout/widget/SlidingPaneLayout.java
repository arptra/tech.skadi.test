package androidx.slidingpanelayout.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import androidx.slidingpanelayout.widget.FoldingFeatureObserver;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SlidingPaneLayout extends ViewGroup implements Openable {
    public static boolean y = true;

    /* renamed from: a  reason: collision with root package name */
    public int f1783a;
    public int b;
    public Drawable c;
    public Drawable d;
    public boolean e;
    public View f;
    public float g;
    public float h;
    public int i;
    public boolean j;
    public int k;
    public float l;
    public float m;
    public final List n;
    public PanelSlideListener o;
    public final ViewDragHelper p;
    public boolean q;
    public boolean r;
    public final Rect s;
    public final ArrayList t;
    public int u;
    public FoldingFeature v;
    public FoldingFeatureObserver.OnFoldingFeatureChangeListener w;
    public FoldingFeatureObserver x;

    public class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* renamed from: a  reason: collision with root package name */
        public final Rect f1785a = new Rect();

        public AccessibilityDelegate() {
        }

        private void c(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f1785a;
            accessibilityNodeInfoCompat2.l(rect);
            accessibilityNodeInfoCompat.d0(rect);
            accessibilityNodeInfoCompat.N0(accessibilityNodeInfoCompat2.U());
            accessibilityNodeInfoCompat.y0(accessibilityNodeInfoCompat2.w());
            accessibilityNodeInfoCompat.h0(accessibilityNodeInfoCompat2.o());
            accessibilityNodeInfoCompat.l0(accessibilityNodeInfoCompat2.r());
            accessibilityNodeInfoCompat.o0(accessibilityNodeInfoCompat2.J());
            accessibilityNodeInfoCompat.i0(accessibilityNodeInfoCompat2.H());
            accessibilityNodeInfoCompat.q0(accessibilityNodeInfoCompat2.K());
            accessibilityNodeInfoCompat.r0(accessibilityNodeInfoCompat2.L());
            accessibilityNodeInfoCompat.b0(accessibilityNodeInfoCompat2.E());
            accessibilityNodeInfoCompat.G0(accessibilityNodeInfoCompat2.R());
            accessibilityNodeInfoCompat.v0(accessibilityNodeInfoCompat2.O());
            accessibilityNodeInfoCompat.a(accessibilityNodeInfoCompat2.i());
            accessibilityNodeInfoCompat.x0(accessibilityNodeInfoCompat2.v());
        }

        public boolean d(View view) {
            return SlidingPaneLayout.this.k(view);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.slidingpanelayout.widget.SlidingPaneLayout");
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat X = AccessibilityNodeInfoCompat.X(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, X);
            c(accessibilityNodeInfoCompat, X);
            X.Z();
            accessibilityNodeInfoCompat.h0("androidx.slidingpanelayout.widget.SlidingPaneLayout");
            accessibilityNodeInfoCompat.I0(view);
            ViewParent G = ViewCompat.G(view);
            if (G instanceof View) {
                accessibilityNodeInfoCompat.A0((View) G);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!d(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.G0(childAt, 1);
                    accessibilityNodeInfoCompat.c(childAt);
                }
            }
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!d(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    public class DisableLayerRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final View f1786a;
        public final /* synthetic */ SlidingPaneLayout b;

        public void run() {
            if (this.f1786a.getParent() == this.b) {
                this.f1786a.setLayerType(0, (Paint) null);
                this.b.j(this.f1786a);
            }
            this.b.t.remove(this);
        }
    }

    public class DragHelperCallback extends ViewDragHelper.Callback {
        public DragHelperCallback() {
        }

        public final boolean a() {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.j || slidingPaneLayout.getLockMode() == 3) {
                return false;
            }
            if (!SlidingPaneLayout.this.m() || SlidingPaneLayout.this.getLockMode() != 1) {
                return SlidingPaneLayout.this.m() || SlidingPaneLayout.this.getLockMode() != 2;
            }
            return false;
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.f.getLayoutParams();
            if (SlidingPaneLayout.this.l()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin) + SlidingPaneLayout.this.f.getWidth());
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.i);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.i + paddingLeft);
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.i;
        }

        public void onEdgeDragStarted(int i, int i2) {
            if (a()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.p.c(slidingPaneLayout.f, i2);
            }
        }

        public void onEdgeTouched(int i, int i2) {
            if (a()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.p.c(slidingPaneLayout.f, i2);
            }
        }

        public void onViewCaptured(View view, int i) {
            SlidingPaneLayout.this.u();
        }

        public void onViewDragStateChanged(int i) {
            if (SlidingPaneLayout.this.p.B() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.g == 1.0f) {
                    slidingPaneLayout.x(slidingPaneLayout.f);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.d(slidingPaneLayout2.f);
                    SlidingPaneLayout.this.q = false;
                    return;
                }
                slidingPaneLayout.e(slidingPaneLayout.f);
                SlidingPaneLayout.this.q = true;
            }
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout.this.p(i);
            SlidingPaneLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f, float f2) {
            int i;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.l()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin;
                if (f < 0.0f || (f == 0.0f && SlidingPaneLayout.this.g > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.i;
                }
                i = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f.getWidth();
            } else {
                i = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i2 > 0 || (i2 == 0 && SlidingPaneLayout.this.g > 0.5f)) {
                    i += SlidingPaneLayout.this.i;
                }
            }
            SlidingPaneLayout.this.p.P(i, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public boolean tryCaptureView(View view, int i) {
            if (!a()) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).b;
        }
    }

    public interface PanelSlideListener {
        void a(View view);

        void b(View view);

        void c(View view, float f);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean isOpen;
        int mLockMode;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isOpen ? 1 : 0);
            parcel.writeInt(this.mLockMode);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isOpen = parcel.readInt() != 0;
            this.mLockMode = parcel.readInt();
        }
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        public void a(View view) {
        }

        public void b(View view) {
        }

        public void c(View view, float f) {
        }
    }

    public static class TouchBlocker extends FrameLayout {
        public TouchBlocker(View view) {
            super(view.getContext());
            addView(view);
        }

        public boolean onGenericMotionEvent(MotionEvent motionEvent) {
            return true;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    public SlidingPaneLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public static Activity g(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    private Insets getSystemGestureInsets() {
        WindowInsetsCompat H;
        if (!y || (H = ViewCompat.H(this)) == null) {
            return null;
        }
        return H.h();
    }

    public static Rect h(FoldingFeature foldingFeature, View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i2 = iArr[0];
        Rect rect = new Rect(i2, iArr[1], view.getWidth() + i2, iArr[1] + view.getWidth());
        Rect rect2 = new Rect(foldingFeature.getBounds());
        boolean intersect = rect2.intersect(rect);
        if ((rect2.width() == 0 && rect2.height() == 0) || !intersect) {
            return null;
        }
        rect2.offset(-iArr[0], -iArr[1]);
        return rect2;
    }

    public static int i(View view) {
        return view instanceof TouchBlocker ? ViewCompat.C(((TouchBlocker) view).getChildAt(0)) : ViewCompat.C(view);
    }

    public static int o(View view, int i2, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return (layoutParams.width != 0 || layoutParams.f1788a <= 0.0f) ? View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824) : ViewGroup.getChildMeasureSpec(i2, i3, layoutParams.height);
    }

    private void setFoldingFeatureObserver(FoldingFeatureObserver foldingFeatureObserver) {
        this.x = foldingFeatureObserver;
        foldingFeatureObserver.f(this.w);
    }

    public static boolean y(View view) {
        return view.isOpaque();
    }

    public void a(PanelSlideListener panelSlideListener) {
        this.n.add(panelSlideListener);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() == 1) {
            super.addView(new TouchBlocker(view), i2, layoutParams);
        } else {
            super.addView(view, i2, layoutParams);
        }
    }

    public boolean b() {
        return c(0);
    }

    public final boolean c(int i2) {
        if (!this.e) {
            this.q = false;
        }
        if (!this.r && !v(1.0f, i2)) {
            return false;
        }
        this.q = false;
        return true;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (!this.p.n(true)) {
            return;
        }
        if (!this.e) {
            this.p.a();
        } else {
            ViewCompat.k0(this);
        }
    }

    public void d(View view) {
        for (PanelSlideListener b2 : this.n) {
            b2.b(view);
        }
        sendAccessibilityEvent(32);
    }

    public void draw(Canvas canvas) {
        int i2;
        int i3;
        super.draw(canvas);
        Drawable drawable = l() ? this.d : this.c;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int top2 = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (l()) {
                i2 = childAt.getRight();
                i3 = intrinsicWidth + i2;
            } else {
                int left = childAt.getLeft();
                int i4 = left - intrinsicWidth;
                i3 = left;
                i2 = i4;
            }
            drawable.setBounds(i2, top2, i3, bottom);
            drawable.draw(canvas);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        if (l() ^ m()) {
            this.p.N(1);
            Insets systemGestureInsets = getSystemGestureInsets();
            if (systemGestureInsets != null) {
                ViewDragHelper viewDragHelper = this.p;
                viewDragHelper.M(Math.max(viewDragHelper.x(), systemGestureInsets.f712a));
            }
        } else {
            this.p.N(2);
            Insets systemGestureInsets2 = getSystemGestureInsets();
            if (systemGestureInsets2 != null) {
                ViewDragHelper viewDragHelper2 = this.p;
                viewDragHelper2.M(Math.max(viewDragHelper2.x(), systemGestureInsets2.c));
            }
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.e && !layoutParams.b && this.f != null) {
            canvas.getClipBounds(this.s);
            if (l()) {
                Rect rect = this.s;
                rect.left = Math.max(rect.left, this.f.getRight());
            } else {
                Rect rect2 = this.s;
                rect2.right = Math.min(rect2.right, this.f.getLeft());
            }
            canvas.clipRect(this.s);
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        return drawChild;
    }

    public void e(View view) {
        for (PanelSlideListener a2 : this.n) {
            a2.a(view);
        }
        sendAccessibilityEvent(32);
    }

    public void f(View view) {
        for (PanelSlideListener c2 : this.n) {
            c2.c(view, this.g);
        }
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @ColorInt
    @Deprecated
    public int getCoveredFadeColor() {
        return this.b;
    }

    public final int getLockMode() {
        return this.u;
    }

    @Px
    public int getParallaxDistance() {
        return this.k;
    }

    @ColorInt
    @Deprecated
    public int getSliderFadeColor() {
        return this.f1783a;
    }

    public void j(View view) {
        ViewCompat.K0(view, ((LayoutParams) view.getLayoutParams()).d);
    }

    public boolean k(View view) {
        if (view == null) {
            return false;
        }
        return this.e && ((LayoutParams) view.getLayoutParams()).c && this.g > 0.0f;
    }

    public boolean l() {
        return ViewCompat.z(this) == 1;
    }

    public boolean m() {
        return !this.e || this.g == 0.0f;
    }

    public boolean n() {
        return this.e;
    }

    public void onAttachedToWindow() {
        Activity g2;
        super.onAttachedToWindow();
        this.r = true;
        if (this.x != null && (g2 = g(getContext())) != null) {
            this.x.e(g2);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.r = true;
        FoldingFeatureObserver foldingFeatureObserver = this.x;
        if (foldingFeatureObserver != null) {
            foldingFeatureObserver.g();
        }
        int size = this.t.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((DisableLayerRunnable) this.t.get(i2)).run();
        }
        this.t.clear();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.e && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.q = this.p.F(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.e || (this.j && actionMasked != 0)) {
            this.p.b();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.p.b();
            return false;
        } else {
            if (actionMasked == 0) {
                this.j = false;
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                this.l = x2;
                this.m = y2;
                if (this.p.F(this.f, (int) x2, (int) y2) && k(this.f)) {
                    z = true;
                    return this.p.Q(motionEvent) || z;
                }
            } else if (actionMasked == 2) {
                float x3 = motionEvent.getX();
                float y3 = motionEvent.getY();
                float abs = Math.abs(x3 - this.l);
                float abs2 = Math.abs(y3 - this.m);
                if (abs > ((float) this.p.A()) && abs2 > abs) {
                    this.p.b();
                    this.j = true;
                    return false;
                }
            }
            z = false;
            if (this.p.Q(motionEvent)) {
                return true;
            }
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean l2 = l();
        int i11 = i4 - i2;
        int paddingRight = l2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = l2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.r) {
            this.g = (!this.e || !this.q) ? 1.0f : 0.0f;
        }
        int i12 = paddingRight;
        int i13 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 8) {
                i6 = i12;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.b) {
                    int i14 = i11 - paddingLeft;
                    int min = (Math.min(paddingRight, i14) - i12) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.i = min;
                    int i15 = l2 ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.c = ((i12 + i15) + min) + (measuredWidth / 2) > i14;
                    int i16 = (int) (((float) min) * this.g);
                    this.g = ((float) i16) / ((float) min);
                    i6 = i12 + i15 + i16;
                    i7 = 0;
                } else if (!this.e || (i10 = this.k) == 0) {
                    i6 = paddingRight;
                    i7 = 0;
                } else {
                    i7 = (int) ((1.0f - this.g) * ((float) i10));
                    i6 = paddingRight;
                }
                if (l2) {
                    i8 = (i11 - i6) + i7;
                    i9 = i8 - measuredWidth;
                } else {
                    i9 = i6 - i7;
                    i8 = i9 + measuredWidth;
                }
                childAt.layout(i9, paddingTop, i8, childAt.getMeasuredHeight() + paddingTop);
                FoldingFeature foldingFeature = this.v;
                paddingRight += childAt.getWidth() + Math.abs((foldingFeature == null || foldingFeature.getOrientation() != FoldingFeature.Orientation.c || !this.v.a()) ? 0 : this.v.getBounds().width());
            }
            i13++;
            i12 = i6;
        }
        if (this.r) {
            if (this.e && this.k != 0) {
                s(this.g);
            }
            x(this.f);
        }
        this.r = false;
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = i3;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        boolean z = false;
        if (mode2 != Integer.MIN_VALUE) {
            i5 = mode2 != 1073741824 ? 0 : (size2 - getPaddingTop()) - getPaddingBottom();
            i4 = i5;
        } else {
            i4 = (size2 - getPaddingTop()) - getPaddingBottom();
            i5 = 0;
        }
        int max = Math.max((size - getPaddingLeft()) - getPaddingRight(), 0);
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f = null;
        int i11 = 0;
        boolean z2 = false;
        int i12 = max;
        float f2 = 0.0f;
        while (true) {
            i6 = 8;
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int i13 = size;
            if (childAt.getVisibility() == 8) {
                layoutParams.c = z;
            } else {
                float f3 = layoutParams.f1788a;
                if (f3 > 0.0f) {
                    f2 += f3;
                    if (layoutParams.width == 0) {
                    }
                }
                int max2 = Math.max(max - (layoutParams.leftMargin + layoutParams.rightMargin), z ? 1 : 0);
                int i14 = layoutParams.width;
                if (i14 == -2) {
                    i9 = View.MeasureSpec.makeMeasureSpec(max2, mode == 0 ? mode : Integer.MIN_VALUE);
                } else {
                    i9 = i14 == -1 ? View.MeasureSpec.makeMeasureSpec(max2, mode) : View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
                }
                childAt.measure(i9, ViewGroup.getChildMeasureSpec(i10, getPaddingTop() + getPaddingBottom(), layoutParams.height));
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i5) {
                    if (mode2 == Integer.MIN_VALUE) {
                        i5 = Math.min(measuredHeight, i4);
                    } else if (mode2 == 0) {
                        i5 = measuredHeight;
                    }
                }
                i12 -= measuredWidth;
                if (i11 != 0) {
                    boolean z3 = i12 < 0;
                    layoutParams.b = z3;
                    z2 |= z3;
                    if (z3) {
                        this.f = childAt;
                    }
                }
            }
            i11++;
            size = i13;
            z = false;
        }
        int i15 = size;
        int i16 = i12;
        if (z2 || f2 > 0.0f) {
            int i17 = 0;
            while (i17 < childCount) {
                View childAt2 = getChildAt(i17);
                if (childAt2.getVisibility() != i6) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    int measuredWidth2 = (layoutParams2.width != 0 || layoutParams2.f1788a <= 0.0f) ? childAt2.getMeasuredWidth() : 0;
                    if (z2) {
                        i7 = max - (layoutParams2.leftMargin + layoutParams2.rightMargin);
                        i8 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                    } else if (layoutParams2.f1788a > 0.0f) {
                        i7 = measuredWidth2 + ((int) ((layoutParams2.f1788a * ((float) Math.max(0, i16))) / f2));
                        i8 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                    } else {
                        i7 = measuredWidth2;
                        i8 = 0;
                    }
                    int o2 = o(childAt2, i10, getPaddingTop() + getPaddingBottom());
                    if (measuredWidth2 != i7) {
                        childAt2.measure(i8, o2);
                        int measuredHeight2 = childAt2.getMeasuredHeight();
                        if (measuredHeight2 > i5) {
                            if (mode2 == Integer.MIN_VALUE) {
                                measuredHeight2 = Math.min(measuredHeight2, i4);
                            } else if (mode2 != 0) {
                            }
                            i5 = measuredHeight2;
                        }
                    }
                }
                i17++;
                i6 = 8;
            }
        }
        ArrayList w2 = w();
        if (w2 != null && !z2) {
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt3 = getChildAt(i18);
                if (childAt3.getVisibility() != 8) {
                    Rect rect = (Rect) w2.get(i18);
                    LayoutParams layoutParams3 = (LayoutParams) childAt3.getLayoutParams();
                    int i19 = layoutParams3.leftMargin + layoutParams3.rightMargin;
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt3.getMeasuredHeight(), 1073741824);
                    childAt3.measure(View.MeasureSpec.makeMeasureSpec(rect.width(), Integer.MIN_VALUE), makeMeasureSpec);
                    if ((childAt3.getMeasuredWidthAndState() & 16777216) == 1 || (i(childAt3) != 0 && rect.width() < i(childAt3))) {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(max - i19, 1073741824), makeMeasureSpec);
                        if (i18 != 0) {
                            layoutParams3.b = true;
                            this.f = childAt3;
                            z2 = true;
                        }
                    } else {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(rect.width(), 1073741824), makeMeasureSpec);
                    }
                }
            }
        }
        setMeasuredDimension(i15, i5 + getPaddingTop() + getPaddingBottom());
        this.e = z2;
        if (this.p.B() != 0 && !z2) {
            this.p.a();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isOpen) {
            q();
        } else {
            b();
        }
        this.q = savedState.isOpen;
        setLockMode(savedState.mLockMode);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isOpen = n() ? m() : this.q;
        savedState.mLockMode = this.u;
        return savedState;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            this.r = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.e) {
            return super.onTouchEvent(motionEvent);
        }
        this.p.G(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.l = x2;
            this.m = y2;
        } else if (actionMasked == 1 && k(this.f)) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            float f2 = x3 - this.l;
            float f3 = y3 - this.m;
            int A = this.p.A();
            if ((f2 * f2) + (f3 * f3) < ((float) (A * A)) && this.p.F(this.f, (int) x3, (int) y3)) {
                c(0);
            }
        }
        return true;
    }

    public void p(int i2) {
        if (this.f == null) {
            this.g = 0.0f;
            return;
        }
        boolean l2 = l();
        LayoutParams layoutParams = (LayoutParams) this.f.getLayoutParams();
        int width = this.f.getWidth();
        if (l2) {
            i2 = (getWidth() - i2) - width;
        }
        float paddingRight = ((float) (i2 - ((l2 ? getPaddingRight() : getPaddingLeft()) + (l2 ? layoutParams.rightMargin : layoutParams.leftMargin)))) / ((float) this.i);
        this.g = paddingRight;
        if (this.k != 0) {
            s(paddingRight);
        }
        f(this.f);
    }

    public boolean q() {
        return r(0);
    }

    public final boolean r(int i2) {
        if (!this.e) {
            this.q = true;
        }
        if (!this.r && !v(0.0f, i2)) {
            return false;
        }
        this.q = true;
        return true;
    }

    public void removeView(View view) {
        if (view.getParent() instanceof TouchBlocker) {
            super.removeView((View) view.getParent());
        } else {
            super.removeView(view);
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.e) {
            this.q = view == this.f;
        }
    }

    public final void s(float f2) {
        boolean l2 = l();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != this.f) {
                int i3 = this.k;
                this.h = f2;
                int i4 = ((int) ((1.0f - this.h) * ((float) i3))) - ((int) ((1.0f - f2) * ((float) i3)));
                if (l2) {
                    i4 = -i4;
                }
                childAt.offsetLeftAndRight(i4);
            }
        }
    }

    @Deprecated
    public void setCoveredFadeColor(@ColorInt int i2) {
        this.b = i2;
    }

    public final void setLockMode(int i2) {
        this.u = i2;
    }

    @Deprecated
    public void setPanelSlideListener(@Nullable PanelSlideListener panelSlideListener) {
        PanelSlideListener panelSlideListener2 = this.o;
        if (panelSlideListener2 != null) {
            t(panelSlideListener2);
        }
        if (panelSlideListener != null) {
            a(panelSlideListener);
        }
        this.o = panelSlideListener;
    }

    public void setParallaxDistance(@Px int i2) {
        this.k = i2;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(@Nullable Drawable drawable) {
        this.c = drawable;
    }

    public void setShadowDrawableRight(@Nullable Drawable drawable) {
        this.d = drawable;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i2) {
        setShadowDrawableLeft(getResources().getDrawable(i2));
    }

    public void setShadowResourceLeft(int i2) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setShadowResourceRight(int i2) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), i2));
    }

    @Deprecated
    public void setSliderFadeColor(@ColorInt int i2) {
        this.f1783a = i2;
    }

    public void t(PanelSlideListener panelSlideListener) {
        this.n.remove(panelSlideListener);
    }

    public void u() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public boolean v(float f2, int i2) {
        int i3;
        if (!this.e) {
            return false;
        }
        boolean l2 = l();
        LayoutParams layoutParams = (LayoutParams) this.f.getLayoutParams();
        if (l2) {
            i3 = (int) (((float) getWidth()) - ((((float) (getPaddingRight() + layoutParams.rightMargin)) + (f2 * ((float) this.i))) + ((float) this.f.getWidth())));
        } else {
            i3 = (int) (((float) (getPaddingLeft() + layoutParams.leftMargin)) + (f2 * ((float) this.i)));
        }
        ViewDragHelper viewDragHelper = this.p;
        View view = this.f;
        if (!viewDragHelper.R(view, i3, view.getTop())) {
            return false;
        }
        u();
        ViewCompat.k0(this);
        return true;
    }

    public final ArrayList w() {
        Rect h2;
        FoldingFeature foldingFeature = this.v;
        if (foldingFeature == null || !foldingFeature.a() || this.v.getBounds().left == 0 || this.v.getBounds().top != 0 || (h2 = h(this.v, this)) == null) {
            return null;
        }
        Rect rect = new Rect(getPaddingLeft(), getPaddingTop(), Math.max(getPaddingLeft(), h2.left), getHeight() - getPaddingBottom());
        int width = getWidth() - getPaddingRight();
        return new ArrayList(Arrays.asList(new Rect[]{rect, new Rect(Math.min(width, h2.right), getPaddingTop(), width, getHeight() - getPaddingBottom())}));
    }

    public void x(View view) {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        View view2 = view;
        boolean l2 = l();
        int width = l2 ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = l2 ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !y(view)) {
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        } else {
            i5 = view.getLeft();
            i4 = view.getRight();
            i3 = view.getTop();
            i2 = view.getBottom();
        }
        int childCount = getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            if (childAt != view2) {
                if (childAt.getVisibility() == 8) {
                    z = l2;
                } else {
                    z = l2;
                    childAt.setVisibility((Math.max(l2 ? paddingLeft : width, childAt.getLeft()) < i5 || Math.max(paddingTop, childAt.getTop()) < i3 || Math.min(l2 ? width : paddingLeft, childAt.getRight()) > i4 || Math.min(height, childAt.getBottom()) > i2) ? 0 : 4);
                }
                i6++;
                view2 = view;
                l2 = z;
            } else {
                return;
            }
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int[] e = {16843137};

        /* renamed from: a  reason: collision with root package name */
        public float f1788a = 0.0f;
        public boolean b;
        public boolean c;
        public Paint d;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e);
            this.f1788a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1783a = 0;
        this.g = 1.0f;
        this.n = new CopyOnWriteArrayList();
        this.r = true;
        this.s = new Rect();
        this.t = new ArrayList();
        this.w = new FoldingFeatureObserver.OnFoldingFeatureChangeListener() {
            public void a(FoldingFeature foldingFeature) {
                SlidingPaneLayout.this.v = foldingFeature;
                ChangeBounds changeBounds = new ChangeBounds();
                changeBounds.setDuration(300);
                changeBounds.setInterpolator(PathInterpolatorCompat.a(0.2f, 0.0f, 0.0f, 1.0f));
                TransitionManager.b(SlidingPaneLayout.this, changeBounds);
                SlidingPaneLayout.this.requestLayout();
            }
        };
        float f2 = context.getResources().getDisplayMetrics().density;
        setWillNotDraw(false);
        ViewCompat.u0(this, new AccessibilityDelegate());
        ViewCompat.G0(this, 1);
        ViewDragHelper o2 = ViewDragHelper.o(this, 0.5f, new DragHelperCallback());
        this.p = o2;
        o2.O(f2 * 400.0f);
        setFoldingFeatureObserver(new FoldingFeatureObserver(WindowInfoTracker.a(context), ContextCompat.getMainExecutor(context)));
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
