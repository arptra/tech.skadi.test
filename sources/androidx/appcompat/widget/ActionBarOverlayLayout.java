package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

@SuppressLint({"UnknownNullness"})
@RestrictTo
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3 {
    public static final int[] F = {R.attr.actionBarSize, 16842841};
    public ViewPropertyAnimator A;
    public final AnimatorListenerAdapter B;
    public final Runnable C;
    public final Runnable D;
    public final NestedScrollingParentHelper E;

    /* renamed from: a  reason: collision with root package name */
    public int f252a;
    public int b;
    public ContentFrameLayout c;
    public ActionBarContainer d;
    public DecorToolbar e;
    public Drawable f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public final Rect n;
    public final Rect o;
    public final Rect p;
    public final Rect q;
    public final Rect r;
    public final Rect s;
    public final Rect t;
    public WindowInsetsCompat u;
    public WindowInsetsCompat v;
    public WindowInsetsCompat w;
    public WindowInsetsCompat x;
    public ActionBarVisibilityCallback y;
    public OverScroller z;

    public interface ActionBarVisibilityCallback {
        void enableContentAnimations(boolean z);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int i);

        void showForSystem();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public void a(Menu menu, MenuPresenter.Callback callback) {
        l();
        this.e.a(menu, callback);
    }

    public final void b() {
        g();
        this.D.run();
    }

    public final boolean c(View view, Rect rect, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        int i2;
        int i3;
        int i4;
        int i5;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!z2 || layoutParams.leftMargin == (i5 = rect.left)) {
            z6 = false;
        } else {
            layoutParams.leftMargin = i5;
            z6 = true;
        }
        if (z3 && layoutParams.topMargin != (i4 = rect.top)) {
            layoutParams.topMargin = i4;
            z6 = true;
        }
        if (z5 && layoutParams.rightMargin != (i3 = rect.right)) {
            layoutParams.rightMargin = i3;
            z6 = true;
        }
        if (!z4 || layoutParams.bottomMargin == (i2 = rect.bottom)) {
            return z6;
        }
        layoutParams.bottomMargin = i2;
        return true;
    }

    public boolean canShowOverflowMenu() {
        l();
        return this.e.canShowOverflowMenu();
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* renamed from: d */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public void dismissPopups() {
        l();
        this.e.dismissPopupMenus();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f != null && !this.g) {
            int bottom = this.d.getVisibility() == 0 ? (int) (((float) this.d.getBottom()) + this.d.getTranslationY() + 0.5f) : 0;
            this.f.setBounds(0, bottom, getWidth(), this.f.getIntrinsicHeight() + bottom);
            this.f.draw(canvas);
        }
    }

    /* renamed from: e */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public final DecorToolbar f(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public void g() {
        removeCallbacks(this.C);
        removeCallbacks(this.D);
        ViewPropertyAnimator viewPropertyAnimator = this.A;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.E.a();
    }

    public CharSequence getTitle() {
        l();
        return this.e.getTitle();
    }

    public final void h(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(F);
        boolean z2 = false;
        this.f252a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z2 = true;
        }
        this.g = z2;
        this.z = new OverScroller(context);
    }

    public boolean hideOverflowMenu() {
        l();
        return this.e.hideOverflowMenu();
    }

    public boolean i() {
        return this.h;
    }

    public void initFeature(int i2) {
        l();
        if (i2 == 2) {
            this.e.initProgress();
        } else if (i2 == 5) {
            this.e.initIndeterminateProgress();
        } else if (i2 == 109) {
            setOverlayMode(true);
        }
    }

    public boolean isOverflowMenuShowPending() {
        l();
        return this.e.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        l();
        return this.e.isOverflowMenuShowing();
    }

    public final void j() {
        g();
        postDelayed(this.D, 600);
    }

    public final void k() {
        g();
        postDelayed(this.C, 600);
    }

    public void l() {
        if (this.c == null) {
            this.c = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.d = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.e = f(findViewById(R.id.action_bar));
        }
    }

    public final void m() {
        g();
        this.C.run();
    }

    public final boolean n(float f2) {
        this.z.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.z.getFinalY() > this.d.getHeight();
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        l();
        WindowInsetsCompat y2 = WindowInsetsCompat.y(windowInsets, this);
        boolean c2 = c(this.d, new Rect(y2.j(), y2.l(), y2.k(), y2.i()), true, true, false, true);
        ViewCompat.f(this, y2, this.n);
        Rect rect = this.n;
        WindowInsetsCompat n2 = y2.n(rect.left, rect.top, rect.right, rect.bottom);
        this.u = n2;
        boolean z2 = true;
        if (!this.v.equals(n2)) {
            this.v = this.u;
            c2 = true;
        }
        if (!this.o.equals(this.n)) {
            this.o.set(this.n);
        } else {
            z2 = c2;
        }
        if (z2) {
            requestLayout();
        }
        return y2.a().c().b().w();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        h(getContext());
        ViewCompat.q0(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = layoutParams.leftMargin + paddingLeft;
                int i8 = layoutParams.topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        l();
        measureChildWithMargins(this.d, i2, 0, i3, 0);
        LayoutParams layoutParams = (LayoutParams) this.d.getLayoutParams();
        int max = Math.max(0, this.d.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, this.d.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.d.getMeasuredState());
        boolean z2 = (ViewCompat.O(this) & 256) != 0;
        if (z2) {
            i4 = this.f252a;
            if (this.i && this.d.getTabContainer() != null) {
                i4 += this.f252a;
            }
        } else {
            i4 = this.d.getVisibility() != 8 ? this.d.getMeasuredHeight() : 0;
        }
        this.p.set(this.n);
        WindowInsetsCompat windowInsetsCompat = this.u;
        this.w = windowInsetsCompat;
        if (this.h || z2) {
            this.w = new WindowInsetsCompat.Builder(this.w).d(Insets.b(windowInsetsCompat.j(), this.w.l() + i4, this.w.k(), this.w.i())).a();
        } else {
            Rect rect = this.p;
            rect.top += i4;
            rect.bottom = rect.bottom;
            this.w = windowInsetsCompat.n(0, i4, 0, 0);
        }
        c(this.c, this.p, true, true, true, true);
        if (!this.x.equals(this.w)) {
            WindowInsetsCompat windowInsetsCompat2 = this.w;
            this.x = windowInsetsCompat2;
            ViewCompat.g(this.c, windowInsetsCompat2);
        }
        measureChildWithMargins(this.c, i2, 0, i3, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.c.getLayoutParams();
        int max3 = Math.max(max, this.c.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int max4 = Math.max(max2, this.c.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (!this.j || !z2) {
            return false;
        }
        if (n(f3)) {
            b();
        } else {
            m();
        }
        this.k = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        onNestedScroll(view, i2, i3, i4, i5, i6);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i2, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i2);
    }

    public void onStopNestedScroll(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i2) {
        super.onWindowSystemUiVisibilityChanged(i2);
        l();
        int i3 = this.m ^ i2;
        this.m = i2;
        boolean z2 = false;
        boolean z3 = (i2 & 4) == 0;
        if ((i2 & 256) != 0) {
            z2 = true;
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.y;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.enableContentAnimations(!z2);
            if (z3 || !z2) {
                this.y.showForSystem();
            } else {
                this.y.hideForSystem();
            }
        }
        if ((i3 & 256) != 0 && this.y != null) {
            ViewCompat.q0(this);
        }
    }

    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.b = i2;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.y;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onWindowVisibilityChanged(i2);
        }
    }

    public void setActionBarHideOffset(int i2) {
        g();
        this.d.setTranslationY((float) (-Math.max(0, Math.min(i2, this.d.getHeight()))));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.y = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.y.onWindowVisibilityChanged(this.b);
            int i2 = this.m;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                ViewCompat.q0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.i = z2;
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.j) {
            this.j = z2;
            if (!z2) {
                g();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i2) {
        l();
        this.e.setIcon(i2);
    }

    public void setLogo(int i2) {
        l();
        this.e.setLogo(i2);
    }

    public void setMenuPrepared() {
        l();
        this.e.setMenuPrepared();
    }

    public void setOverlayMode(boolean z2) {
        this.h = z2;
        this.g = z2 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i2) {
    }

    public void setWindowCallback(Window.Callback callback) {
        l();
        this.e.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        l();
        this.e.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        l();
        return this.e.showOverflowMenu();
    }

    public ActionBarOverlayLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.n = new Rect();
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.b;
        this.u = windowInsetsCompat;
        this.v = windowInsetsCompat;
        this.w = windowInsetsCompat;
        this.x = windowInsetsCompat;
        this.B = new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.A = null;
                actionBarOverlayLayout.k = false;
            }

            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.A = null;
                actionBarOverlayLayout.k = false;
            }
        };
        this.C = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.g();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.A = actionBarOverlayLayout.d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.B);
            }
        };
        this.D = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.g();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.A = actionBarOverlayLayout.d.animate().translationY((float) (-ActionBarOverlayLayout.this.d.getHeight())).setListener(ActionBarOverlayLayout.this.B);
            }
        };
        h(context);
        this.E = new NestedScrollingParentHelper(this);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.E.b(view, view2, i2);
        this.l = getActionBarHideOffset();
        g();
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.y;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onContentScrollStarted();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.d.getVisibility() != 0) {
            return false;
        }
        return this.j;
    }

    public void onStopNestedScroll(View view) {
        if (this.j && !this.k) {
            if (this.l <= this.d.getHeight()) {
                k();
            } else {
                j();
            }
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.y;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onContentScrollStopped();
        }
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6 = this.l + i3;
        this.l = i6;
        setActionBarHideOffset(i6);
    }

    public void setIcon(Drawable drawable) {
        l();
        this.e.setIcon(drawable);
    }
}
