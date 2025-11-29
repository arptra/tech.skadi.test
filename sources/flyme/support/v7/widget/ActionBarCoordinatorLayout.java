package flyme.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.meizu.common.util.ReflectUtils;
import com.meizu.common.util.ResourceUtils;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.view.menu.MenuPresenter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ActionBarCoordinatorLayout extends CoordinatorLayout implements DecorContentParent {
    static final int[] ATTRS = {R.attr.mzActionBarCanScroll, R.attr.mzActionBarOverlayMode};
    private static final String TAG = "ActionBarCoordinatorLayout";
    private ActionBarContainer mActionBarBottom;
    private boolean mActionBarCanScroll;
    private ActionBarDropDownView mActionBarDropDownView;
    private MzCollapsingToolbarLayout mActionBarTop;
    private MzAppBarLayout mAppBarLayout;
    private final Rect mBaseContentInsets;
    private final Rect mBottomBarInsets;
    private FitsBottomContentLayout mContent;
    private FrameLayout mContentContainer;
    private final Rect mContentInnerInsets;
    private DecorToolbar mDecorToolbar;
    /* access modifiers changed from: private */
    public boolean mIsExpand;
    private boolean mIsOverlayMode;
    private final Rect mLastContentInsets;
    private final Rect mTopAreaRect;

    @Keep
    public static class MzScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        public MzScrollingViewBehavior() {
        }

        public void layoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
            super.layoutChild(coordinatorLayout, view, i);
            List<View> dependencies = coordinatorLayout.getDependencies(view);
            try {
                ReflectUtils.IReflectClass from = ReflectUtils.from((Object) this);
                if (((Integer) from.method("getOverlapPixelsForOffset", View.class).invoke(this, (View) from.method("findFirstDependency", List.class).invoke(this, dependencies))).intValue() == 0) {
                    view.layout(view.getLeft(), view.getTop() - getOverlayTop(), view.getRight(), view.getBottom() - getOverlayTop());
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                Log.e(ActionBarCoordinatorLayout.TAG, "MzScrollingViewBehavior layoutChild error :" + e.getMessage());
            }
        }

        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, View view, WindowInsetsCompat windowInsetsCompat) {
            return super.onApplyWindowInsets(coordinatorLayout, view, windowInsetsCompat);
        }

        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            ViewCompat.e0(view, (view2.getBottom() - view.getTop()) - getOverlayTop());
            return false;
        }

        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i, int i2, int i3, int i4) {
            int i5 = view.getLayoutParams().height;
            boolean onMeasureChild = super.onMeasureChild(coordinatorLayout, view, i, i2, i3, i4);
            coordinatorLayout.onMeasureChild(view, i, i2, View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight() + getOverlayTop(), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
            return onMeasureChild;
        }

        public MzScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public ActionBarCoordinatorLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void applyInsets(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        if (z) {
            paddingLeft = rect.left;
        }
        if (z2) {
            paddingTop = rect.top;
        }
        if (z4) {
            paddingRight = rect.right;
        }
        if (z3) {
            paddingBottom = rect.bottom;
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
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

    public boolean canShowOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.canShowOverflowMenu();
    }

    public void dismissPopups() {
        pullChildren();
        this.mDecorToolbar.dismissPopupMenus();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.WindowInsets dispatchApplyWindowInsets(android.view.WindowInsets r13) {
        /*
            r12 = this;
            android.view.WindowInsets r0 = super.dispatchApplyWindowInsets(r13)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 30
            r4 = 1
            r5 = 0
            if (r2 < r3) goto L_0x003b
            int r2 = android.view.WindowInsets.Type.systemBars()
            android.graphics.Insets r2 = r13.getInsets(r2)
            int r3 = r2.left
            int r6 = r2.top
            int r7 = r2.right
            int r8 = r2.bottom
            r1.set(r3, r6, r7, r8)
            android.graphics.Rect r3 = r12.mBottomBarInsets
            r3.set(r1)
            int r3 = android.view.WindowInsets.Type.ime()
            android.graphics.Insets r13 = r13.getInsets(r3)
            int r13 = r13.bottom
            int r2 = r2.bottom
            if (r13 <= r2) goto L_0x0053
            r1.bottom = r13
            r13 = r4
            goto L_0x0054
        L_0x003b:
            int r2 = r13.getSystemWindowInsetLeft()
            int r3 = r13.getSystemWindowInsetTop()
            int r6 = r13.getSystemWindowInsetRight()
            int r13 = r13.getSystemWindowInsetBottom()
            r1.set(r2, r3, r6, r13)
            android.graphics.Rect r13 = r12.mBottomBarInsets
            r13.set(r1)
        L_0x0053:
            r13 = r5
        L_0x0054:
            android.graphics.Rect r2 = r12.mBaseContentInsets
            int r3 = r1.top
            r2.top = r3
            int r3 = r1.bottom
            r2.bottom = r3
            android.graphics.Rect r2 = r12.mTopAreaRect
            r2.set(r1)
            android.graphics.Rect r1 = r12.mContentInnerInsets
            android.graphics.Rect r2 = r12.mBaseContentInsets
            boolean r1 = r1.equals(r2)
            r1 = r1 ^ r4
            flyme.support.v7.widget.ActionBarContainer r6 = r12.mActionBarBottom
            if (r6 == 0) goto L_0x007a
            android.graphics.Rect r7 = r12.mBottomBarInsets
            r10 = 1
            r11 = 1
            r8 = 1
            r9 = 0
            boolean r5 = flyme.support.v7.widget.ViewUtils.applyInsetsWithPadding(r6, r7, r8, r9, r10, r11)
        L_0x007a:
            android.graphics.Rect r2 = r12.mContentInnerInsets
            android.graphics.Rect r3 = r12.mBaseContentInsets
            r2.set(r3)
            boolean r2 = r12.mIsOverlayMode
            if (r2 == 0) goto L_0x00a6
            flyme.support.v7.widget.MzAppBarLayout r2 = r12.mAppBarLayout
            int r2 = r2.getMeasuredHeight()
            flyme.support.v7.widget.MzAppBarLayout r3 = r12.mAppBarLayout
            int r3 = r3.getTotalScrollRange()
            android.widget.FrameLayout r6 = r12.mContentContainer
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.f()
            boolean r6 = r6 instanceof flyme.support.v7.widget.ActionBarCoordinatorLayout.MzScrollingViewBehavior
            if (r6 == 0) goto L_0x00a6
            int r2 = r2 - r3
            android.graphics.Rect r3 = r12.mContentInnerInsets
            r3.top = r2
        L_0x00a6:
            flyme.support.v7.widget.ActionBarContainer r2 = r12.mActionBarBottom
            if (r2 == 0) goto L_0x00c8
            int r2 = r2.getVisibility()
            r3 = 8
            if (r2 == r3) goto L_0x00c8
            flyme.support.v7.widget.ActionBarContainer r2 = r12.mActionBarBottom
            int r2 = r2.getMeasuredHeight()
            android.graphics.Rect r3 = r12.mBaseContentInsets
            int r3 = r3.bottom
            if (r2 <= r3) goto L_0x00bf
            int r2 = r2 - r3
        L_0x00bf:
            if (r13 != 0) goto L_0x00c8
            android.graphics.Rect r13 = r12.mContentInnerInsets
            int r3 = r13.bottom
            int r3 = r3 + r2
            r13.bottom = r3
        L_0x00c8:
            if (r1 == 0) goto L_0x00d9
            android.graphics.Rect r13 = r12.mLastContentInsets
            android.graphics.Rect r1 = r12.mContentInnerInsets
            r13.set(r1)
            flyme.support.v7.widget.FitsBottomContentLayout r13 = r12.mContent
            android.graphics.Rect r1 = r12.mLastContentInsets
            r13.dispatchFitSystemWindows(r1)
            goto L_0x00da
        L_0x00d9:
            r4 = r5
        L_0x00da:
            if (r4 == 0) goto L_0x00df
            r12.requestLayout()
        L_0x00df:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: flyme.support.v7.widget.ActionBarCoordinatorLayout.dispatchApplyWindowInsets(android.view.WindowInsets):android.view.WindowInsets");
    }

    public ActionBarDropDownView getActionBarDropDownView() {
        return this.mActionBarDropDownView;
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
    }

    public boolean hideOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.hideOverflowMenu();
    }

    public void initFeature(int i) {
    }

    public boolean isOverflowMenuShowPending() {
        pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowing();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mActionBarCanScroll) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        ActionBarContainer actionBarContainer = this.mActionBarBottom;
        if (actionBarContainer == null || actionBarContainer.getVisibility() == 8) {
            i3 = 0;
        } else {
            i3 = this.mActionBarBottom.getMeasuredHeight();
            int i4 = this.mBaseContentInsets.bottom;
            if (i3 > i4) {
                i3 -= i4;
            }
        }
        this.mContentInnerInsets.set(this.mBaseContentInsets);
        if (this.mIsOverlayMode) {
            int measuredHeight = this.mAppBarLayout.getMeasuredHeight();
            int totalScrollRange = this.mAppBarLayout.getTotalScrollRange();
            CoordinatorLayout.Behavior f = ((CoordinatorLayout.LayoutParams) this.mContentContainer.getLayoutParams()).f();
            if (f instanceof MzScrollingViewBehavior) {
                int i5 = measuredHeight - totalScrollRange;
                ((MzScrollingViewBehavior) f).setOverlayTop(i5);
                this.mContentInnerInsets.top = i5;
            }
        }
        if (this.mBaseContentInsets.bottom <= this.mBottomBarInsets.bottom) {
            this.mContentInnerInsets.bottom += i3;
        }
        if (!this.mLastContentInsets.equals(this.mContentInnerInsets) || getHeight() == 0) {
            this.mLastContentInsets.set(this.mContentInnerInsets);
            this.mContent.dispatchFitSystemWindows(this.mLastContentInsets);
            super.onMeasure(i, i2);
        }
        if (this.mIsExpand) {
            this.mTopAreaRect.top = this.mAppBarLayout.getMeasuredHeight() - this.mBaseContentInsets.top;
        } else {
            this.mTopAreaRect.top = (int) (((float) findViewById(R.id.action_bar).getMeasuredHeight()) + ResourceUtils.dp2px(54.0f, getContext()));
        }
        ActionBarDropDownView actionBarDropDownView = this.mActionBarDropDownView;
        if (actionBarDropDownView != null && actionBarDropDownView.getVisibility() != 8) {
            ViewUtils.applyInsetsWithPadding(this.mActionBarDropDownView, this.mTopAreaRect, true, true, true, true);
            measureChildWithMargins(this.mActionBarDropDownView, i, 0, i2, 0);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mActionBarCanScroll) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void pullChildren() {
        if (this.mContent == null) {
            this.mContent = (FitsBottomContentLayout) findViewById(androidx.appcompat.R.id.action_bar_activity_content);
            this.mAppBarLayout = (MzAppBarLayout) findViewById(R.id.app_bar_layout);
            this.mActionBarTop = (MzCollapsingToolbarLayout) findViewById(R.id.action_bar_container);
            this.mDecorToolbar = getDecorToolbar(findViewById(R.id.action_bar));
            this.mActionBarBottom = (ActionBarContainer) findViewById(R.id.split_action_bar);
            this.mContentContainer = (FrameLayout) findViewById(R.id.content_container);
            this.mContent.setActionBarOverlay(this.mIsOverlayMode);
            this.mContent.setInterceptNestedScrollEnabled(!this.mActionBarCanScroll);
            this.mAppBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarLayout.OnOffsetChangedListener() {
                public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                    boolean unused = ActionBarCoordinatorLayout.this.mIsExpand = i == 0;
                }
            });
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

    public void setActionBarCanScroll(boolean z) {
        this.mActionBarCanScroll = z;
        this.mContent.setInterceptNestedScrollEnabled(!z);
    }

    public void setActionBarFitStatusBar(boolean z) {
    }

    public void setBackTopBackground(Drawable drawable) {
    }

    public void setBackTopClickCallback(View.OnClickListener onClickListener) {
    }

    public void setBackTopEnable(boolean z) {
    }

    public void setBottomMenu(Menu menu, MenuPresenter.Callback callback) {
        pullChildren();
        this.mDecorToolbar.setNavigationMenu(menu, callback);
        if (this.mDecorToolbar.isShowNavigationMenu() && menu == null) {
            this.mDecorToolbar.setShowNavigationMenu(false);
        }
    }

    public void setDropDownShowStart(int i) {
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

    public void setShowingForActionMode(boolean z) {
    }

    public void setSplitBarFitSystemWindows(boolean z) {
    }

    public void setTransStatusBarInFlyme3(boolean z) {
    }

    public void setUiOptions(int i) {
        int i2 = 0;
        boolean z = i == 2;
        pullChildren();
        MzCollapsingToolbarLayout mzCollapsingToolbarLayout = this.mActionBarTop;
        ActionBarContextView actionBarContextView = mzCollapsingToolbarLayout != null ? (ActionBarContextView) mzCollapsingToolbarLayout.findViewById(R.id.action_context_bar) : (ActionBarContextView) findViewById(R.id.action_context_bar);
        if (z) {
            ActionBarContainer actionBarContainer = this.mActionBarBottom;
            if (actionBarContainer != null) {
                this.mDecorToolbar.setSplitView(actionBarContainer);
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
        this.mDecorToolbar.setShowNavigationMenu(z);
        ActionBarContainer actionBarContainer2 = this.mActionBarBottom;
        if (actionBarContainer2 != null) {
            if (!this.mDecorToolbar.isSplit() && !actionBarContextView.isInMultiChoiceActionMode() && !z) {
                i2 = 8;
            }
            actionBarContainer2.setVisibility(i2);
        }
    }

    public void setWindowCallback(Window.Callback callback) {
        pullChildren();
        this.mDecorToolbar.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        pullChildren();
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public void setupActionBarDropDownView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.mz_action_bar_dropdown_stub);
        if (viewStub != null) {
            viewStub.inflate();
            this.mActionBarDropDownView = (ActionBarDropDownView) findViewById(R.id.mz_action_bar_dropdown);
        }
    }

    public void showBackTopButton() {
    }

    public boolean showOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.showOverflowMenu();
    }

    public ActionBarCoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLastContentInsets = new Rect();
        this.mBaseContentInsets = new Rect();
        this.mContentInnerInsets = new Rect();
        this.mBottomBarInsets = new Rect();
        this.mTopAreaRect = new Rect();
        this.mIsExpand = true;
        this.mActionBarCanScroll = true;
        this.mIsOverlayMode = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(ATTRS);
        this.mActionBarCanScroll = obtainStyledAttributes.getBoolean(0, this.mActionBarCanScroll);
        this.mIsOverlayMode = obtainStyledAttributes.getBoolean(1, this.mIsOverlayMode);
        obtainStyledAttributes.recycle();
    }

    public void setIcon(Drawable drawable) {
        pullChildren();
        this.mDecorToolbar.setIcon(drawable);
    }
}
