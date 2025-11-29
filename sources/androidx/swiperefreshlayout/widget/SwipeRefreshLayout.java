package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;

public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final String O = "SwipeRefreshLayout";
    public static final int[] P = {16842766};
    public int A;
    public CircularProgressDrawable B;
    public Animation C;
    public Animation D;
    public Animation E;
    public Animation F;
    public Animation G;
    public boolean H;
    public int I;
    public boolean J;
    public OnChildScrollUpCallback K;
    public Animation.AnimationListener L;
    public final Animation M;
    public final Animation N;

    /* renamed from: a  reason: collision with root package name */
    public View f1814a;
    public OnRefreshListener b;
    public boolean c;
    public int d;
    public float e;
    public float f;
    public final NestedScrollingParentHelper g;
    public final NestedScrollingChildHelper h;
    public final int[] i;
    public final int[] j;
    public boolean k;
    public int l;
    public int m;
    public float n;
    public float o;
    public boolean p;
    public int q;
    public boolean r;
    public boolean s;
    public final DecelerateInterpolator t;
    public CircleImageView u;
    public int v;
    public int w;
    public float x;
    public int y;
    public int z;

    public interface OnChildScrollUpCallback {
        boolean a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    public interface OnRefreshListener {
        void a();
    }

    public SwipeRefreshLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void k(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.q) {
            this.q = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void setColorViewAlpha(int i2) {
        this.u.getBackground().setAlpha(i2);
        this.B.setAlpha(i2);
    }

    public final void a(int i2, Animation.AnimationListener animationListener) {
        this.w = i2;
        this.M.reset();
        this.M.setDuration(200);
        this.M.setInterpolator(this.t);
        if (animationListener != null) {
            this.u.b(animationListener);
        }
        this.u.clearAnimation();
        this.u.startAnimation(this.M);
    }

    public final void b(int i2, Animation.AnimationListener animationListener) {
        if (this.r) {
            s(i2, animationListener);
            return;
        }
        this.w = i2;
        this.N.reset();
        this.N.setDuration(200);
        this.N.setInterpolator(this.t);
        if (animationListener != null) {
            this.u.b(animationListener);
        }
        this.u.clearAnimation();
        this.u.startAnimation(this.N);
    }

    public boolean c() {
        OnChildScrollUpCallback onChildScrollUpCallback = this.K;
        if (onChildScrollUpCallback != null) {
            return onChildScrollUpCallback.a(this, this.f1814a);
        }
        View view = this.f1814a;
        return view instanceof ListView ? ListViewCompat.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    public final void d() {
        this.u = new CircleImageView(getContext(), -328966);
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(getContext());
        this.B = circularProgressDrawable;
        circularProgressDrawable.l(1);
        this.u.setImageDrawable(this.B);
        this.u.setVisibility(8);
        addView(this.u);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.h.a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.h.b(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.h.c(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.h.f(i2, i3, i4, i5, iArr);
    }

    public final void e() {
        if (this.f1814a == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.u)) {
                    this.f1814a = childAt;
                    return;
                }
            }
        }
    }

    public final void f(float f2) {
        if (f2 > this.e) {
            m(true, true);
            return;
        }
        this.c = false;
        this.B.j(0.0f, 0.0f);
        b(this.m, !this.r ? new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                if (!swipeRefreshLayout.r) {
                    swipeRefreshLayout.r((Animation.AnimationListener) null);
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        } : null);
        this.B.d(false);
    }

    public final boolean g(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    public int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.v;
        return i4 < 0 ? i3 : i3 == i2 + -1 ? i4 : i3 >= i4 ? i3 + 1 : i3;
    }

    public int getNestedScrollAxes() {
        return this.g.a();
    }

    public int getProgressCircleDiameter() {
        return this.I;
    }

    public int getProgressViewEndOffset() {
        return this.z;
    }

    public int getProgressViewStartOffset() {
        return this.y;
    }

    public boolean h() {
        return this.c;
    }

    public boolean hasNestedScrollingParent() {
        return this.h.k();
    }

    public final void i(float f2) {
        this.B.d(true);
        float min = Math.min(1.0f, Math.abs(f2 / this.e));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.e;
        int i2 = this.A;
        if (i2 <= 0) {
            i2 = this.J ? this.z - this.y : this.z;
        }
        float f3 = (float) i2;
        double max2 = (double) (Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f);
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i3 = this.y + ((int) ((f3 * min) + (f3 * pow * 2.0f)));
        if (this.u.getVisibility() != 0) {
            this.u.setVisibility(0);
        }
        if (!this.r) {
            this.u.setScaleX(1.0f);
            this.u.setScaleY(1.0f);
        }
        if (this.r) {
            setAnimationProgress(Math.min(1.0f, f2 / this.e));
        }
        if (f2 < this.e) {
            if (this.B.getAlpha() > 76 && !g(this.E)) {
                q();
            }
        } else if (this.B.getAlpha() < 255 && !g(this.F)) {
            p();
        }
        this.B.j(0.0f, Math.min(0.8f, max * 0.8f));
        this.B.e(Math.min(1.0f, max));
        this.B.g((((max * 0.4f) - 16.0f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i3 - this.m);
    }

    public boolean isNestedScrollingEnabled() {
        return this.h.m();
    }

    public void j(float f2) {
        int i2 = this.w;
        setTargetOffsetTopAndBottom((i2 + ((int) (((float) (this.y - i2)) * f2))) - this.u.getTop());
    }

    public void l() {
        this.u.clearAnimation();
        this.B.stop();
        this.u.setVisibility(8);
        setColorViewAlpha(255);
        if (this.r) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.y - this.m);
        }
        this.m = this.u.getTop();
    }

    public final void m(boolean z2, boolean z3) {
        if (this.c != z2) {
            this.H = z3;
            e();
            this.c = z2;
            if (z2) {
                a(this.m, this.L);
            } else {
                r(this.L);
            }
        }
    }

    public final Animation n(final int i2, final int i3) {
        AnonymousClass4 r0 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                CircularProgressDrawable circularProgressDrawable = SwipeRefreshLayout.this.B;
                int i = i2;
                circularProgressDrawable.setAlpha((int) (((float) i) + (((float) (i3 - i)) * f)));
            }
        };
        r0.setDuration(300);
        this.u.b((Animation.AnimationListener) null);
        this.u.clearAnimation();
        this.u.startAnimation(r0);
        return r0;
    }

    public final void o(float f2) {
        float f3 = this.o;
        int i2 = this.d;
        if (f2 - f3 > ((float) i2) && !this.p) {
            this.n = f3 + ((float) i2);
            this.p = true;
            this.B.setAlpha(76);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        e();
        int actionMasked = motionEvent.getActionMasked();
        if (this.s && actionMasked == 0) {
            this.s = false;
        }
        if (!isEnabled() || this.s || c() || this.c || this.k) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.q;
                    if (i2 == -1) {
                        Log.e(O, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    o(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        k(motionEvent);
                    }
                }
            }
            this.p = false;
            this.q = -1;
        } else {
            setTargetOffsetTopAndBottom(this.y - this.u.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.q = pointerId;
            this.p = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.o = motionEvent.getY(findPointerIndex2);
        }
        return this.p;
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f1814a == null) {
                e();
            }
            View view = this.f1814a;
            if (view != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.u.getMeasuredWidth();
                int measuredHeight2 = this.u.getMeasuredHeight();
                int i6 = measuredWidth / 2;
                int i7 = measuredWidth2 / 2;
                int i8 = this.m;
                this.u.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f1814a == null) {
            e();
        }
        View view = this.f1814a;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.u.measure(View.MeasureSpec.makeMeasureSpec(this.I, 1073741824), View.MeasureSpec.makeMeasureSpec(this.I, 1073741824));
            this.v = -1;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4) == this.u) {
                    this.v = i4;
                    return;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        return dispatchNestedFling(f2, f3, z2);
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.f;
            if (f2 > 0.0f) {
                float f3 = (float) i3;
                if (f3 > f2) {
                    iArr[1] = i3 - ((int) f2);
                    this.f = 0.0f;
                } else {
                    this.f = f2 - f3;
                    iArr[1] = i3;
                }
                i(this.f);
            }
        }
        if (this.J && i3 > 0 && this.f == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.u.setVisibility(8);
        }
        int[] iArr2 = this.i;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, (int[]) null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        dispatchNestedScroll(i2, i3, i4, i5, this.j);
        int i6 = i5 + this.j[1];
        if (i6 < 0 && !c()) {
            float abs = this.f + ((float) Math.abs(i6));
            this.f = abs;
            i(abs);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.g.b(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.f = 0.0f;
        this.k = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return isEnabled() && !this.s && !this.c && (i2 & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.g.d(view);
        this.k = false;
        float f2 = this.f;
        if (f2 > 0.0f) {
            f(f2);
            this.f = 0.0f;
        }
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.s && actionMasked == 0) {
            this.s = false;
        }
        if (!isEnabled() || this.s || c() || this.c || this.k) {
            return false;
        }
        if (actionMasked == 0) {
            this.q = motionEvent.getPointerId(0);
            this.p = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.q);
            if (findPointerIndex < 0) {
                Log.e(O, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.p) {
                this.p = false;
                f((motionEvent.getY(findPointerIndex) - this.n) * 0.5f);
            }
            this.q = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.q);
            if (findPointerIndex2 < 0) {
                Log.e(O, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y2 = motionEvent.getY(findPointerIndex2);
            o(y2);
            if (this.p) {
                float f2 = (y2 - this.n) * 0.5f;
                if (f2 <= 0.0f) {
                    return false;
                }
                i(f2);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(O, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.q = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                k(motionEvent);
            }
        }
        return true;
    }

    public final void p() {
        this.F = n(this.B.getAlpha(), 255);
    }

    public final void q() {
        this.E = n(this.B.getAlpha(), 76);
    }

    public void r(Animation.AnimationListener animationListener) {
        AnonymousClass3 r0 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.D = r0;
        r0.setDuration(150);
        this.u.b(animationListener);
        this.u.clearAnimation();
        this.u.startAnimation(this.D);
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        View view = this.f1814a;
        if (view == null || ViewCompat.X(view)) {
            super.requestDisallowInterceptTouchEvent(z2);
        }
    }

    public final void s(int i2, Animation.AnimationListener animationListener) {
        this.w = i2;
        this.x = this.u.getScaleX();
        AnonymousClass8 r3 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                float f2 = swipeRefreshLayout.x;
                swipeRefreshLayout.setAnimationProgress(f2 + ((-f2) * f));
                SwipeRefreshLayout.this.j(f);
            }
        };
        this.G = r3;
        r3.setDuration(150);
        if (animationListener != null) {
            this.u.b(animationListener);
        }
        this.u.clearAnimation();
        this.u.startAnimation(this.G);
    }

    public void setAnimationProgress(float f2) {
        this.u.setScaleX(f2);
        this.u.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(@ColorRes int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(@ColorInt int... iArr) {
        e();
        this.B.f(iArr);
    }

    public void setColorSchemeResources(@ColorRes int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = ContextCompat.getColor(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.e = (float) i2;
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (!z2) {
            l();
        }
    }

    public void setNestedScrollingEnabled(boolean z2) {
        this.h.n(z2);
    }

    public void setOnChildScrollUpCallback(@Nullable OnChildScrollUpCallback onChildScrollUpCallback) {
        this.K = onChildScrollUpCallback;
    }

    public void setOnRefreshListener(@Nullable OnRefreshListener onRefreshListener) {
        this.b = onRefreshListener;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int i2) {
        this.u.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int i2) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), i2));
    }

    public void setRefreshing(boolean z2) {
        if (!z2 || this.c == z2) {
            m(z2, false);
            return;
        }
        this.c = z2;
        setTargetOffsetTopAndBottom((!this.J ? this.z + this.y : this.z) - this.m);
        this.H = false;
        t(this.L);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.I = (int) (displayMetrics.density * 56.0f);
            } else {
                this.I = (int) (displayMetrics.density * 40.0f);
            }
            this.u.setImageDrawable((Drawable) null);
            this.B.l(i2);
            this.u.setImageDrawable(this.B);
        }
    }

    public void setSlingshotDistance(@Px int i2) {
        this.A = i2;
    }

    public void setTargetOffsetTopAndBottom(int i2) {
        this.u.bringToFront();
        ViewCompat.e0(this.u, i2);
        this.m = this.u.getTop();
    }

    public boolean startNestedScroll(int i2) {
        return this.h.p(i2);
    }

    public void stopNestedScroll() {
        this.h.r();
    }

    public final void t(Animation.AnimationListener animationListener) {
        this.u.setVisibility(0);
        this.B.setAlpha(255);
        AnonymousClass2 r0 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f);
            }
        };
        this.C = r0;
        r0.setDuration((long) this.l);
        if (animationListener != null) {
            this.u.b(animationListener);
        }
        this.u.clearAnimation();
        this.u.startAnimation(this.C);
    }

    public SwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        this.e = -1.0f;
        this.i = new int[2];
        this.j = new int[2];
        this.q = -1;
        this.v = -1;
        this.L = new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                OnRefreshListener onRefreshListener;
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                if (swipeRefreshLayout.c) {
                    swipeRefreshLayout.B.setAlpha(255);
                    SwipeRefreshLayout.this.B.start();
                    SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                    if (swipeRefreshLayout2.H && (onRefreshListener = swipeRefreshLayout2.b) != null) {
                        onRefreshListener.a();
                    }
                    SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
                    swipeRefreshLayout3.m = swipeRefreshLayout3.u.getTop();
                    return;
                }
                swipeRefreshLayout.l();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        };
        this.M = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                int abs = !swipeRefreshLayout.J ? swipeRefreshLayout.z - Math.abs(swipeRefreshLayout.y) : swipeRefreshLayout.z;
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                int i = swipeRefreshLayout2.w;
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i + ((int) (((float) (abs - i)) * f))) - swipeRefreshLayout2.u.getTop());
                SwipeRefreshLayout.this.B.e(1.0f - f);
            }
        };
        this.N = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.j(f);
            }
        };
        this.d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.l = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.t = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.I = (int) (displayMetrics.density * 40.0f);
        d();
        setChildrenDrawingOrderEnabled(true);
        int i2 = (int) (displayMetrics.density * 64.0f);
        this.z = i2;
        this.e = (float) i2;
        this.g = new NestedScrollingParentHelper(this);
        this.h = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i3 = -this.I;
        this.m = i3;
        this.y = i3;
        j(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }
}
