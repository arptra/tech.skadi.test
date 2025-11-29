package flyme.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.appcompat.R;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.widget.ScrollerCompat;
import com.meizu.common.util.CommonUtils;
import com.meizu.common.util.ResourceUtils;
import flyme.support.v7.view.menu.MenuPresenter;

@SuppressLint({"RestrictedApi"})
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent {
    static final int[] ATTRS = {R.attr.actionBarSize, 16842841, flyme.support.v7.appcompat.R.attr.mzWindowSplitActionBar, flyme.support.v7.appcompat.R.attr.mzSplitActionBarFloat, flyme.support.v7.appcompat.R.attr.mzActionBarFitStatusBar, flyme.support.v7.appcompat.R.attr.mzActionBarOverlayMode};
    private static final int BACKTOP_HIDE_ALPHA_BASE = 127;
    private static final int BACKTOP_HIDE_ALPHA_TARGET = 0;
    private static final long BACKTOP_HIDE_DURATION = 230;
    private static final int BACKTOP_SHOW_ALPHA_BASE = 0;
    private static final int BACKTOP_SHOW_ALPHA_TARGET = 255;
    private static final long BACKTOP_SHOW_DURATION = 150;
    private static final String PROPERTY_ALPHA = "alpha";
    private static final String TAG = "ActionBarOverlayLayout";
    private final int ACTION_BAR_ANIMATE_DELAY;
    private boolean isBackTopEnable;
    private boolean isBackTopVisible;
    /* access modifiers changed from: private */
    public ActionBarContainer mActionBarBottom;
    private ActionBarDropDownView mActionBarDropDownView;
    private int mActionBarHeight;
    /* access modifiers changed from: private */
    public ActionBarContainer mActionBarTop;
    private ActionBarVisibilityCallback mActionBarVisibilityCallback;
    private final Runnable mAddActionBarHideOffset;
    /* access modifiers changed from: private */
    public boolean mAnimatingForFling;
    private Drawable mBackTopBackground;
    /* access modifiers changed from: private */
    public View mBackTopBtn;
    private ObjectAnimator mBackTopHideAnimator;
    private Interpolator mBackTopHideInterpolator;
    private ObjectAnimator mBackTopShowAnimator;
    private Interpolator mBackTopShowInterpolator;
    private final Rect mBaseContentInsets;
    private final Rect mBaseInnerInsets;
    /* access modifiers changed from: private */
    public final ViewPropertyAnimatorListener mBottomAnimatorListener;
    private FitsWindowsContentLayout mContent;
    private final Rect mContentInsets;
    /* access modifiers changed from: private */
    public ViewPropertyAnimatorCompat mCurrentActionBarBottomAnimator;
    /* access modifiers changed from: private */
    public ViewPropertyAnimatorCompat mCurrentActionBarTopAnimator;
    private DecorToolbar mDecorToolbar;
    private int mDropDownShowStart;
    private ScrollerCompat mFlingEstimator;
    private boolean mFullWindowContent;
    private boolean mHasNonEmbeddedTabs;
    private boolean mHideOnContentScroll;
    private int mHideOnContentScrollReference;
    private boolean mIgnoreWindowContentOverlay;
    private final Rect mInnerInsets;
    private final Rect mLastBaseContentInsets;
    private final Rect mLastInnerInsets;
    private int mLastSystemUiVisibility;
    private boolean mMzActionBarFitStatusBar;
    private boolean mMzSplitBarFloat;
    private boolean mMzWindowSplitToolBar;
    private boolean mOverlayMode;
    private final NestedScrollingParentHelper mParentHelper;
    private final Runnable mRemoveActionBarHideOffset;
    private Rect mSystemInsets;
    /* access modifiers changed from: private */
    public final ViewPropertyAnimatorListener mTopAnimatorListener;
    private int mUiOptions;
    private Drawable mWindowContentOverlay;
    private int mWindowVisibility;

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

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void addActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        this.mAddActionBarHideOffset.run();
    }

    private boolean applyInsetsForFlyme(Rect rect) {
        if (!this.mMzActionBarFitStatusBar) {
            rect.top = ResourceUtils.getStatusBarHeight(getContext());
        }
        return ViewUtils.applyInsetsWithPadding(this.mActionBarTop, rect, true, true, true, false);
    }

    private DecorToolbar getDecorToolbar(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    /* access modifiers changed from: private */
    public void haltActionBarHideOffsetAnimations() {
        removeCallbacks(this.mRemoveActionBarHideOffset);
        removeCallbacks(this.mAddActionBarHideOffset);
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mCurrentActionBarTopAnimator;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.c();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = this.mCurrentActionBarBottomAnimator;
        if (viewPropertyAnimatorCompat2 != null) {
            viewPropertyAnimatorCompat2.c();
        }
    }

    private void init(Context context) {
        boolean z = false;
        if (CommonUtils.hasFullDisplay()) {
            ATTRS[0] = flyme.support.v7.appcompat.R.attr.mzActionBarSizeFullScreen;
        }
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(ATTRS);
        this.mActionBarHeight = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.mWindowContentOverlay = drawable;
        setWillNotDraw(drawable == null);
        this.mMzWindowSplitToolBar = obtainStyledAttributes.getBoolean(2, false);
        this.mMzSplitBarFloat = obtainStyledAttributes.getBoolean(3, false);
        this.mMzActionBarFitStatusBar = obtainStyledAttributes.getBoolean(4, this.mMzActionBarFitStatusBar);
        setOverlayMode(obtainStyledAttributes.getBoolean(5, this.mOverlayMode));
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z = true;
        }
        this.mIgnoreWindowContentOverlay = z;
        this.mFlingEstimator = ScrollerCompat.a(context);
    }

    private void postAddActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        postDelayed(this.mAddActionBarHideOffset, 600);
    }

    private void postRemoveActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        postDelayed(this.mRemoveActionBarHideOffset, 600);
    }

    private void removeActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        this.mRemoveActionBarHideOffset.run();
    }

    private boolean shouldHideActionBarOnFling(float f, float f2) {
        this.mFlingEstimator.c(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.mFlingEstimator.d() > this.mActionBarTop.getHeight();
    }

    private void startBackTopHideAnim() {
        if (this.mBackTopHideInterpolator == null) {
            this.mBackTopHideInterpolator = new PathInterpolator(0.3f, 0.0f, 0.67f, 1.0f);
        }
        if (this.mBackTopHideAnimator == null) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this.mBackTopBackground, PROPERTY_ALPHA, new int[]{127, 0});
            this.mBackTopHideAnimator = ofInt;
            ofInt.setInterpolator(this.mBackTopHideInterpolator);
            this.mBackTopHideAnimator.setDuration(BACKTOP_HIDE_DURATION);
            this.mBackTopHideAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    ActionBarOverlayLayout.this.mBackTopBtn.setVisibility(4);
                }
            });
        }
        this.mBackTopHideAnimator.start();
    }

    private void startBackTopShowAnim() {
        if (this.mBackTopShowInterpolator == null) {
            this.mBackTopShowInterpolator = new PathInterpolator(0.3f, 0.0f, 0.67f, 1.0f);
        }
        if (this.mBackTopShowAnimator == null) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this.mBackTopBackground, PROPERTY_ALPHA, new int[]{0, 255});
            this.mBackTopShowAnimator = ofInt;
            ofInt.setInterpolator(this.mBackTopShowInterpolator);
            this.mBackTopShowAnimator.setDuration(150);
        }
        this.mBackTopShowAnimator.start();
    }

    private void stopBackTopHideAnim() {
        ObjectAnimator objectAnimator = this.mBackTopHideAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mBackTopHideAnimator.cancel();
        }
    }

    private void stopBackTopShowAnim() {
        ObjectAnimator objectAnimator = this.mBackTopShowAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mBackTopShowAnimator.cancel();
        }
    }

    private void updateBackTopBtnPosition() {
        int z = ViewCompat.z(this);
        int measuredWidth = this.mBackTopBtn.getMeasuredWidth();
        int measuredHeight = this.mBackTopBtn.getMeasuredHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(flyme.support.v7.appcompat.R.dimen.mz_list_backtop_btn_margin_right);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(flyme.support.v7.appcompat.R.dimen.mz_list_backtop_btn_margin_bottom);
        if (z == 1) {
            int paddingLeft = getPaddingLeft() + dimensionPixelSize;
            int height = ((getHeight() - getPaddingBottom()) - dimensionPixelSize2) - measuredHeight;
            this.mBackTopBtn.layout(paddingLeft, height, measuredWidth + paddingLeft, measuredHeight + height);
        }
    }

    public boolean canShowOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.canShowOverflowMenu();
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public boolean computeFitSystemWindowsForFullScreen(Rect rect, Rect rect2) {
        if (!super.getFitsSystemWindows() && !this.mFullWindowContent) {
            rect2.bottom = rect.bottom;
            rect.bottom = 0;
        }
        return false;
    }

    public void dismissPopups() {
        pullChildren();
        this.mDecorToolbar.dismissPopupMenus();
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        super.dispatchApplyWindowInsets(windowInsets);
        pullChildren();
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        if (Build.VERSION.SDK_INT >= 30) {
            Insets a2 = windowInsets.getInsets(WindowInsets.Type.systemBars());
            rect.set(a2.left, a2.top, a2.right, a2.bottom);
            rect2.set(rect);
            int i = windowInsets.getInsets(WindowInsets.Type.ime()).bottom;
            if (i > a2.bottom) {
                rect.bottom = i;
            }
        } else {
            rect.set(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
            rect2.set(rect);
        }
        boolean applyInsetsForFlyme = applyInsetsForFlyme(rect);
        this.mBaseInnerInsets.set(rect);
        this.mBaseContentInsets.set(rect);
        ActionBarContainer actionBarContainer = this.mActionBarBottom;
        if (actionBarContainer != null) {
            applyInsetsForFlyme |= ViewUtils.applyInsetsWithPadding(actionBarContainer, rect2, true, false, true, this.mMzSplitBarFloat);
            this.mDecorToolbar.reSetSplitViewHeight(this.mActionBarBottom);
        }
        if (!this.mLastBaseContentInsets.equals(this.mBaseContentInsets)) {
            this.mLastBaseContentInsets.set(this.mBaseContentInsets);
            applyInsetsForFlyme = true;
        }
        if (applyInsetsForFlyme) {
            this.mLastInnerInsets.setEmpty();
            requestLayout();
        } else if (this.mOverlayMode) {
            this.mContent.dispatchFitSystemWindows(this.mLastInnerInsets);
        }
        return windowInsets.consumeSystemWindowInsets();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mWindowContentOverlay != null && !this.mIgnoreWindowContentOverlay) {
            int bottom = this.mActionBarTop.getVisibility() == 0 ? (int) (((float) this.mActionBarTop.getBottom()) + ViewCompat.L(this.mActionBarTop) + 0.5f) : 0;
            this.mWindowContentOverlay.setBounds(0, bottom, getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + bottom);
            this.mWindowContentOverlay.draw(canvas);
        }
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.mActionBarTop;
        if (actionBarContainer != null) {
            return -((int) ViewCompat.L(actionBarContainer));
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.a();
    }

    public CharSequence getTitle() {
        pullChildren();
        return this.mDecorToolbar.getTitle();
    }

    public boolean hasIcon() {
        pullChildren();
        return this.mDecorToolbar.hasIcon();
    }

    public boolean hasLogo() {
        pullChildren();
        return this.mDecorToolbar.hasLogo();
    }

    public void hideBackTopButton() {
        if (this.isBackTopEnable && this.mBackTopBtn != null && this.isBackTopVisible) {
            stopBackTopHideAnim();
            this.mBackTopBtn.setClickable(false);
            this.isBackTopVisible = false;
            startBackTopHideAnim();
        }
    }

    public boolean hideOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.hideOverflowMenu();
    }

    public void initFeature(int i) {
        pullChildren();
        if (i == 2) {
            this.mDecorToolbar.initProgress();
        } else if (i == 5) {
            this.mDecorToolbar.initIndeterminateProgress();
        } else if (i == 109) {
            setOverlayMode(true);
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.mHideOnContentScroll;
    }

    public boolean isInOverlayMode() {
        return this.mOverlayMode;
    }

    public boolean isOverflowMenuShowPending() {
        pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowing();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        init(getContext());
        ViewCompat.q0(this);
        setUiOptions(this.mUiOptions);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        haltActionBarHideOffsetAnimations();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = layoutParams.leftMargin + paddingLeft;
                ActionBarContainer actionBarContainer = this.mActionBarBottom;
                if (childAt == actionBarContainer) {
                    i5 = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
                } else if (childAt == this.mBackTopBtn) {
                    i5 = ((paddingBottom - measuredHeight) - layoutParams.bottomMargin) - ((actionBarContainer == null || actionBarContainer.getVisibility() == 8) ? 0 : this.mActionBarBottom.getMeasuredHeight());
                    i7 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                } else {
                    i5 = paddingTop + layoutParams.topMargin;
                }
                childAt.layout(i7, i5, measuredWidth + i7, measuredHeight + i5);
            }
        }
        updateBackTopBtnPosition();
    }

    public void onMeasure(int i, int i2) {
        int i3;
        ActionBarContainer actionBarContainer;
        int i4;
        pullChildren();
        View view = this.mBackTopBtn;
        if (!(view == null || view.getVisibility() == 8)) {
            measureChildWithMargins(this.mBackTopBtn, i, 0, i2, 0);
        }
        measureChildWithMargins(this.mActionBarTop, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.mActionBarTop.getLayoutParams();
        int i5 = 0;
        int max = Math.max(0, this.mActionBarTop.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, this.mActionBarTop.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
        int combineMeasuredStates = ViewUtils.combineMeasuredStates(0, ViewCompat.A(this.mActionBarTop));
        ActionBarContainer actionBarContainer2 = this.mActionBarBottom;
        if (actionBarContainer2 != null) {
            measureChildWithMargins(actionBarContainer2, i, 0, i2, 0);
            LayoutParams layoutParams2 = (LayoutParams) this.mActionBarBottom.getLayoutParams();
            max = Math.max(max, this.mActionBarBottom.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
            max2 = Math.max(max2, this.mActionBarBottom.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin);
            combineMeasuredStates = ViewUtils.combineMeasuredStates(combineMeasuredStates, ViewCompat.A(this.mActionBarBottom));
        }
        if (this.mActionBarTop.getVisibility() != 8) {
            i3 = this.mActionBarTop.getMeasuredHeight();
            int i6 = this.mBaseInnerInsets.top;
            if (i3 > i6) {
                i3 -= i6;
            }
        } else {
            i3 = 0;
        }
        if ((this.mDecorToolbar.isSplit() || this.mDecorToolbar.isShowNavigationMenu() || this.mDecorToolbar.isShowNavigationCustomView()) && (actionBarContainer = this.mActionBarBottom) != null && actionBarContainer.getVisibility() != 8 && (i5 = this.mActionBarBottom.getMeasuredHeight()) > (i4 = this.mBaseInnerInsets.bottom)) {
            i5 -= i4;
        }
        this.mContentInsets.set(this.mBaseContentInsets);
        this.mInnerInsets.set(this.mBaseInnerInsets);
        if (!this.mOverlayMode) {
            Rect rect = this.mContentInsets;
            rect.top += i3;
            rect.bottom += i5;
            this.mInnerInsets.setEmpty();
        } else {
            Rect rect2 = this.mInnerInsets;
            rect2.top += i3;
            rect2.bottom += i5;
            this.mContentInsets.setEmpty();
        }
        ViewUtils.applyInsets(this.mContent, this.mContentInsets, true, true, true, true);
        if (!this.mLastInnerInsets.equals(this.mInnerInsets)) {
            this.mLastInnerInsets.set(this.mInnerInsets);
            this.mContent.dispatchFitSystemWindows(this.mInnerInsets);
        }
        measureChildWithMargins(this.mContent, i, 0, i2, 0);
        LayoutParams layoutParams3 = (LayoutParams) this.mContent.getLayoutParams();
        int max3 = Math.max(max, this.mContent.getMeasuredWidth() + layoutParams3.leftMargin + layoutParams3.rightMargin);
        int max4 = Math.max(max2, this.mContent.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin);
        int combineMeasuredStates2 = ViewUtils.combineMeasuredStates(combineMeasuredStates, ViewCompat.A(this.mContent));
        ActionBarDropDownView actionBarDropDownView = this.mActionBarDropDownView;
        if (!(actionBarDropDownView == null || actionBarDropDownView.getVisibility() == 8)) {
            Rect rect3 = !this.mOverlayMode ? this.mContentInsets : this.mInnerInsets;
            int i7 = this.mDropDownShowStart;
            if (i7 != -1) {
                rect3.top = i7;
            }
            ViewUtils.applyInsetsWithPadding(this.mActionBarDropDownView, rect3, true, true, true, true);
            measureChildWithMargins(this.mActionBarDropDownView, i, 0, i2, 0);
            combineMeasuredStates2 = ViewUtils.combineMeasuredStates(combineMeasuredStates2, ViewCompat.A(this.mActionBarDropDownView));
        }
        setMeasuredDimension(ViewCompat.r0(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), ViewCompat.r0(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.mHideOnContentScroll || !z) {
            return false;
        }
        if (shouldHideActionBarOnFling(f, f2)) {
            addActionBarHideOffset();
        } else {
            removeActionBarHideOffset();
        }
        this.mAnimatingForFling = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.mHideOnContentScrollReference + i2;
        this.mHideOnContentScrollReference = i5;
        setActionBarHideOffset(i5);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mParentHelper.b(view, view2, i);
        this.mHideOnContentScrollReference = getActionBarHideOffset();
        haltActionBarHideOffsetAnimations();
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onContentScrollStarted();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.mActionBarTop.getVisibility() != 0) {
            return false;
        }
        return this.mHideOnContentScroll;
    }

    public void onStopNestedScroll(View view) {
        if (this.mHideOnContentScroll && !this.mAnimatingForFling) {
            if (this.mHideOnContentScrollReference <= this.mActionBarTop.getHeight()) {
                postRemoveActionBarHideOffset();
            } else {
                postAddActionBarHideOffset();
            }
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onContentScrollStopped();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        pullChildren();
        int i2 = this.mLastSystemUiVisibility ^ i;
        this.mLastSystemUiVisibility = i;
        boolean z = false;
        boolean z2 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.enableContentAnimations(!z);
            if (z2 || !z) {
                this.mActionBarVisibilityCallback.showForSystem();
            } else {
                this.mActionBarVisibilityCallback.hideForSystem();
            }
        }
        if ((i2 & 256) != 0 && this.mActionBarVisibilityCallback != null) {
            ViewCompat.q0(this);
        }
    }

    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.mWindowVisibility = i;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onWindowVisibilityChanged(i);
        }
    }

    public void pullChildren() {
        if (this.mContent == null) {
            this.mContent = (FitsWindowsContentLayout) findViewById(R.id.action_bar_activity_content);
            this.mActionBarTop = (ActionBarContainer) findViewById(flyme.support.v7.appcompat.R.id.action_bar_container);
            this.mDecorToolbar = getDecorToolbar(findViewById(flyme.support.v7.appcompat.R.id.action_bar));
            this.mActionBarBottom = (ActionBarContainer) findViewById(flyme.support.v7.appcompat.R.id.split_action_bar);
            this.mBackTopBtn = findViewById(flyme.support.v7.appcompat.R.id.mz_list_backtop_container);
        }
    }

    public void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        pullChildren();
        this.mDecorToolbar.restoreHierarchyState(sparseArray);
    }

    public void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        pullChildren();
        this.mDecorToolbar.saveHierarchyState(sparseArray);
    }

    public void setActionBarDropDownView(ActionBarDropDownView actionBarDropDownView) {
        this.mActionBarDropDownView = actionBarDropDownView;
    }

    public void setActionBarFitStatusBar(boolean z) {
        this.mMzActionBarFitStatusBar = z;
    }

    public void setActionBarHideOffset(int i) {
        haltActionBarHideOffsetAnimations();
        int height = this.mActionBarTop.getHeight();
        int max = Math.max(0, Math.min(i, height));
        ViewCompat.Z0(this.mActionBarTop, (float) (-max));
        ActionBarContainer actionBarContainer = this.mActionBarBottom;
        if (actionBarContainer != null && actionBarContainer.getVisibility() != 8) {
            ViewCompat.Z0(this.mActionBarBottom, (float) ((int) (((float) this.mActionBarBottom.getHeight()) * (((float) max) / ((float) height)))));
        }
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.mActionBarVisibilityCallback = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.mActionBarVisibilityCallback.onWindowVisibilityChanged(this.mWindowVisibility);
            int i = this.mLastSystemUiVisibility;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                ViewCompat.q0(this);
            }
        }
    }

    public void setBackTopBackground(Drawable drawable) {
        if (!this.isBackTopEnable) {
            return;
        }
        if (drawable != null) {
            this.mBackTopBackground = drawable;
            this.mBackTopBtn.setBackground(drawable);
            return;
        }
        this.mBackTopBtn.setBackgroundResource(flyme.support.v7.appcompat.R.drawable.mz_list_backtop);
    }

    public void setBackTopClickCallback(View.OnClickListener onClickListener) {
        this.mBackTopBtn.setOnClickListener(onClickListener);
    }

    public void setBackTopEnable(boolean z) {
        this.isBackTopEnable = z;
        if (z) {
            this.mBackTopBtn.setBackgroundResource(flyme.support.v7.appcompat.R.drawable.mz_list_backtop);
        }
    }

    public void setBottomMenu(Menu menu, MenuPresenter.Callback callback) {
        pullChildren();
        this.mDecorToolbar.setNavigationMenu(menu, callback);
        if (this.mDecorToolbar.isShowNavigationMenu() && menu == null) {
            this.mDecorToolbar.setShowNavigationMenu(false);
        }
    }

    public void setDropDownShowStart(int i) {
        this.mDropDownShowStart = i;
    }

    public void setFullWindowContent(boolean z) {
        if (this.mFullWindowContent != z) {
            this.mFullWindowContent = z;
            requestLayout();
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.mHasNonEmbeddedTabs = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.mHideOnContentScroll) {
            this.mHideOnContentScroll = z;
            if (!z) {
                haltActionBarHideOffsetAnimations();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        pullChildren();
        this.mDecorToolbar.setIcon(i);
    }

    public void setLogo(int i) {
        pullChildren();
        this.mDecorToolbar.setLogo(i);
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        pullChildren();
        this.mDecorToolbar.setMenu(menu, callback);
    }

    public void setMenuPrepared() {
        pullChildren();
        this.mDecorToolbar.setMenuPrepared();
    }

    public void setOverlayMode(boolean z) {
        this.mOverlayMode = z;
        this.mIgnoreWindowContentOverlay = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setSplitBarFitSystemWindows(boolean z) {
        this.mMzSplitBarFloat = z;
    }

    @Deprecated
    public void setTransStatusBarInFlyme3(boolean z) {
    }

    public void setUiOptions(int i) {
        this.mUiOptions = i;
        int i2 = 0;
        boolean z = true;
        boolean z2 = (i & 1) != 0;
        boolean z3 = z2 ? getContext().getResources().getBoolean(flyme.support.v7.appcompat.R.bool.mz_split_action_bar_is_narrow) : this.mMzWindowSplitToolBar;
        if (i != 2) {
            z = false;
        }
        if (!z3 || !z) {
            pullChildren();
            ActionBarContainer actionBarContainer = this.mActionBarTop;
            ActionBarContextView actionBarContextView = actionBarContainer != null ? (ActionBarContextView) actionBarContainer.findViewById(flyme.support.v7.appcompat.R.id.action_context_bar) : (ActionBarContextView) findViewById(flyme.support.v7.appcompat.R.id.action_context_bar);
            if (z3) {
                if (this.mActionBarBottom == null || !this.mDecorToolbar.canSplit()) {
                    Log.e(TAG, "Requested split action bar with incompatible window decor! Ignoring request.");
                    return;
                } else {
                    this.mDecorToolbar.setSplitView(this.mActionBarBottom);
                    actionBarContextView.setSplitView(this.mActionBarBottom);
                }
            } else if (z) {
                ActionBarContainer actionBarContainer2 = this.mActionBarBottom;
                if (actionBarContainer2 != null) {
                    this.mDecorToolbar.setSplitView(actionBarContainer2);
                } else {
                    Log.e(TAG, "Requested split action bar with incompatible window decor! Ignoring request.");
                    return;
                }
            } else {
                this.mDecorToolbar.setSplitView((ViewGroup) null);
                if (!actionBarContextView.isInMultiChoiceActionMode()) {
                    actionBarContextView.setSplitView((ViewGroup) null);
                }
            }
            this.mDecorToolbar.setSplitToolbar(z3);
            this.mDecorToolbar.setShowNavigationMenu(z);
            this.mDecorToolbar.setSplitWhenNarrow(z2);
            actionBarContextView.setSplitToolbar(z3);
            actionBarContextView.setSplitWhenNarrow(z2);
            ActionBarContainer actionBarContainer3 = this.mActionBarBottom;
            if (actionBarContainer3 != null) {
                if (!this.mDecorToolbar.isSplit() && !actionBarContextView.isInMultiChoiceActionMode() && !z) {
                    i2 = 8;
                }
                actionBarContainer3.setVisibility(i2);
                return;
            }
            return;
        }
        throw new IllegalStateException("You can't split action bar and use bottom menu in the same time.");
    }

    public void setWindowCallback(Window.Callback callback) {
        pullChildren();
        this.mDecorToolbar.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        pullChildren();
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void showBackTopButton() {
        if (this.isBackTopEnable && this.mBackTopBtn != null && !this.isBackTopVisible) {
            stopBackTopShowAnim();
            this.isBackTopVisible = true;
            this.mBackTopBtn.setVisibility(0);
            startBackTopShowAnim();
            this.mBackTopBtn.setClickable(true);
        }
    }

    public boolean showOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.showOverflowMenu();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWindowVisibility = 0;
        this.mOverlayMode = true;
        this.mBaseContentInsets = new Rect();
        this.mLastBaseContentInsets = new Rect();
        this.mContentInsets = new Rect();
        this.mBaseInnerInsets = new Rect();
        this.mInnerInsets = new Rect();
        this.mLastInnerInsets = new Rect();
        this.ACTION_BAR_ANIMATE_DELAY = 600;
        this.mDropDownShowStart = -1;
        this.isBackTopEnable = false;
        this.mTopAnimatorListener = new ViewPropertyAnimatorListenerAdapter() {
            public void onAnimationCancel(View view) {
                ViewPropertyAnimatorCompat unused = ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = null;
                boolean unused2 = ActionBarOverlayLayout.this.mAnimatingForFling = false;
            }

            public void onAnimationEnd(View view) {
                ViewPropertyAnimatorCompat unused = ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = null;
                boolean unused2 = ActionBarOverlayLayout.this.mAnimatingForFling = false;
            }
        };
        this.mBottomAnimatorListener = new ViewPropertyAnimatorListenerAdapter() {
            public void onAnimationCancel(View view) {
                ViewPropertyAnimatorCompat unused = ActionBarOverlayLayout.this.mCurrentActionBarBottomAnimator = null;
                boolean unused2 = ActionBarOverlayLayout.this.mAnimatingForFling = false;
            }

            public void onAnimationEnd(View view) {
                ViewPropertyAnimatorCompat unused = ActionBarOverlayLayout.this.mCurrentActionBarBottomAnimator = null;
                boolean unused2 = ActionBarOverlayLayout.this.mAnimatingForFling = false;
            }
        };
        this.mRemoveActionBarHideOffset = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                ViewPropertyAnimatorCompat unused = actionBarOverlayLayout.mCurrentActionBarTopAnimator = ViewCompat.e(actionBarOverlayLayout.mActionBarTop).q(0.0f).k(ActionBarOverlayLayout.this.mTopAnimatorListener);
                if (ActionBarOverlayLayout.this.mActionBarBottom != null && ActionBarOverlayLayout.this.mActionBarBottom.getVisibility() != 8) {
                    ActionBarOverlayLayout actionBarOverlayLayout2 = ActionBarOverlayLayout.this;
                    ViewPropertyAnimatorCompat unused2 = actionBarOverlayLayout2.mCurrentActionBarBottomAnimator = ViewCompat.e(actionBarOverlayLayout2.mActionBarBottom).q(0.0f).k(ActionBarOverlayLayout.this.mBottomAnimatorListener);
                }
            }
        };
        this.mAddActionBarHideOffset = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                ViewPropertyAnimatorCompat unused = actionBarOverlayLayout.mCurrentActionBarTopAnimator = ViewCompat.e(actionBarOverlayLayout.mActionBarTop).q((float) (-ActionBarOverlayLayout.this.mActionBarTop.getHeight())).k(ActionBarOverlayLayout.this.mTopAnimatorListener);
                if (ActionBarOverlayLayout.this.mActionBarBottom != null && ActionBarOverlayLayout.this.mActionBarBottom.getVisibility() != 8) {
                    ActionBarOverlayLayout actionBarOverlayLayout2 = ActionBarOverlayLayout.this;
                    ViewPropertyAnimatorCompat unused2 = actionBarOverlayLayout2.mCurrentActionBarBottomAnimator = ViewCompat.e(actionBarOverlayLayout2.mActionBarBottom).q((float) ActionBarOverlayLayout.this.mActionBarBottom.getHeight()).k(ActionBarOverlayLayout.this.mBottomAnimatorListener);
                }
            }
        };
        this.isBackTopVisible = false;
        init(context);
        this.mParentHelper = new NestedScrollingParentHelper(this);
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        pullChildren();
        this.mDecorToolbar.setIcon(drawable);
    }
}
