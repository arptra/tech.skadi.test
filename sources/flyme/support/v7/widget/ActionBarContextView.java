package flyme.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.meizu.common.util.CommonUtils;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.view.ActionBarPolicy;
import flyme.support.v7.view.ActionMode;
import flyme.support.v7.view.menu.MenuBuilder;

@SuppressLint({"RestrictedApi"})
public class ActionBarContextView extends AbsActionBarView {
    private static final int ANIMATE_IDLE = 0;
    private static final int ANIMATE_IN = 1;
    private static final int ANIMATE_OUT = 2;
    private static final int MULTI_CHOICE_ANIMATION_DURATION = 260;
    /* access modifiers changed from: private */
    public static final Interpolator MULTI_CHOICE_ANIMATION_INTERPOLATOR_IN;
    private static final Interpolator MULTI_CHOICE_ANIMATION_INTERPOLATOR_OUT;
    private static final String TAG = "ActionBarContextView";
    /* access modifiers changed from: private */
    public int mAnimationMode;
    private View mClose;
    private int mCloseItemLayout;
    private View mCustomView;
    private boolean mInMultiChoiceActionMode;
    protected final SplitViewVisibilityAnimListener mSplitViewVisAnimListener;
    /* access modifiers changed from: private */
    public ViewPropertyAnimatorCompat mSplitVisibilityAnim;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private boolean mTitleOptional;
    private int mTitleStyleRes;
    private TextView mTitleView;

    public class SplitViewVisibilityAnimListener implements ViewPropertyAnimatorListener {
        private boolean mCanceled = false;
        int mFinalVisibility;

        public SplitViewVisibilityAnimListener() {
        }

        public void onAnimationCancel(View view) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(View view) {
            if (!this.mCanceled) {
                if (ActionBarContextView.this.mAnimationMode == 2) {
                    ActionBarContextView.this.killMode();
                }
                ViewGroup viewGroup = ActionBarContextView.this.mSplitView;
                if (viewGroup != null) {
                    viewGroup.setTranslationY(0.0f);
                }
                int unused = ActionBarContextView.this.mAnimationMode = 0;
                ViewPropertyAnimatorCompat unused2 = ActionBarContextView.this.mSplitVisibilityAnim = null;
            }
        }

        public void onAnimationStart(View view) {
            ViewGroup viewGroup = ActionBarContextView.this.mSplitView;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            this.mCanceled = false;
        }

        public SplitViewVisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
            ViewPropertyAnimatorCompat unused = ActionBarContextView.this.mSplitVisibilityAnim = viewPropertyAnimatorCompat;
            this.mFinalVisibility = i;
            return this;
        }
    }

    static {
        Interpolator a2 = PathInterpolatorCompat.a(0.2f, 0.028f, 0.1f, 1.0f);
        MULTI_CHOICE_ANIMATION_INTERPOLATOR_IN = a2;
        MULTI_CHOICE_ANIMATION_INTERPOLATOR_OUT = a2;
    }

    public ActionBarContextView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void animateToSplitMode(boolean z) {
        multiChoiceMenuViewAnimateToVisibility(z ? 0 : 8);
    }

    private void initTitle() {
        if (this.mTitleLayout == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.mz_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.mTitleLayout = linearLayout;
            this.mTitleView = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.mSubtitleView = (TextView) this.mTitleLayout.findViewById(R.id.action_bar_subtitle);
            if (this.mTitleStyleRes != 0) {
                this.mTitleView.setTextAppearance(getContext(), this.mTitleStyleRes);
            }
            if (this.mSubtitleStyleRes != 0) {
                this.mSubtitleView.setTextAppearance(getContext(), this.mSubtitleStyleRes);
            }
        }
        this.mTitleView.setText(this.mTitle);
        this.mSubtitleView.setText(this.mSubtitle);
        boolean z = !TextUtils.isEmpty(this.mTitle);
        boolean z2 = !TextUtils.isEmpty(this.mSubtitle);
        int i = 8;
        this.mSubtitleView.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout2 = this.mTitleLayout;
        if (z || z2) {
            i = 0;
        }
        linearLayout2.setVisibility(i);
        if (this.mTitleLayout.getParent() == null) {
            addView(this.mTitleLayout);
        }
    }

    public void animateToMode(boolean z, ActionMode actionMode) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        (z ? setupAnimatorToVisibility(0, 200) : setupAnimatorToVisibility(8, 100)).o();
        if (this.mSplitActionBar || this.mInMultiChoiceActionMode) {
            if (actionMode != null ? actionMode.isAnimateToShowMenu() : true) {
                animateToSplitMode(z);
            } else if (this.mAnimationMode == 2 && (viewPropertyAnimatorCompat = this.mSplitVisibilityAnim) != null && z) {
                viewPropertyAnimatorCompat.c();
            }
        }
    }

    public /* bridge */ /* synthetic */ void animateToVisibility(int i) {
        super.animateToVisibility(i);
    }

    public /* bridge */ /* synthetic */ boolean canShowOverflowMenu() {
        return super.canShowOverflowMenu();
    }

    public void closeMode() {
        if (this.mClose == null && !this.mInMultiChoiceActionMode) {
            killMode();
        }
    }

    public /* bridge */ /* synthetic */ void dismissPopupMenus() {
        super.dismissPopupMenus();
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public View getCustomView() {
        return this.mCustomView;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.hideOverflowMenu();
        }
        return false;
    }

    public void initForMode(final ActionMode actionMode) {
        View view = this.mClose;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.mCloseItemLayout, this, false);
            this.mClose = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.mClose);
        }
        this.mClose.findViewById(androidx.appcompat.R.id.action_mode_close_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                actionMode.finish();
            }
        });
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.getMenu();
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.mActionMenuPresenter = actionMenuPresenter2;
        actionMenuPresenter2.setReserveOverflow(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        if (!this.mSplitActionBar) {
            menuBuilder.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
            ActionMenuView actionMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
            this.mMenuView = actionMenuView;
            actionMenuView.setBackgroundDrawable((Drawable) null);
            addView(this.mMenuView, layoutParams);
            return;
        }
        this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels - (ActionBarPolicy.get(getContext()).getSplitActionBarPadding() * 2), true);
        this.mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
        this.mActionMenuPresenter.setIsSplit(true);
        layoutParams.width = -1;
        layoutParams.height = -2;
        menuBuilder.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
        ActionMenuView actionMenuView2 = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
        this.mMenuView = actionMenuView2;
        actionMenuView2.setId(R.id.mz_action_mode_menu_view);
        ViewGroup viewGroup = this.mSplitView;
        if (viewGroup != null) {
            viewGroup.addView(this.mMenuView, layoutParams);
        }
    }

    public void initForMultiChoiceMode(ActionMode actionMode) {
        this.mInMultiChoiceActionMode = true;
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.getMenu();
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.mActionMenuPresenter = actionMenuPresenter2;
        actionMenuPresenter2.setReserveOverflow(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        if (this.mSplitView == null) {
            menuBuilder.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
            ActionMenuView actionMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
            this.mMenuView = actionMenuView;
            actionMenuView.setBackgroundDrawable((Drawable) null);
            addView(this.mMenuView, layoutParams);
            return;
        }
        this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels - (ActionBarPolicy.get(getContext()).getSplitActionBarPadding() * 2), true);
        this.mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
        this.mActionMenuPresenter.setIsSplit(true);
        layoutParams.width = -1;
        layoutParams.height = -2;
        menuBuilder.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
        ActionMenuView actionMenuView2 = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
        this.mMenuView = actionMenuView2;
        actionMenuView2.setId(R.id.mz_action_mode_menu_view);
        this.mSplitView.addView(this.mMenuView, layoutParams);
    }

    public boolean isInMultiChoiceActionMode() {
        return this.mInMultiChoiceActionMode;
    }

    public /* bridge */ /* synthetic */ boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.isOverflowMenuShowing();
        }
        return false;
    }

    public /* bridge */ /* synthetic */ boolean isOverflowReserved() {
        return super.isOverflowReserved();
    }

    public boolean isTitleOptional() {
        return this.mTitleOptional;
    }

    public void killMode() {
        removeAllViews();
        ViewGroup viewGroup = this.mSplitView;
        if (viewGroup != null) {
            viewGroup.removeView(this.mMenuView);
        }
        this.mCustomView = null;
        this.mMenuView = null;
        this.mInMultiChoiceActionMode = false;
        this.mActionMenuPresenter = null;
    }

    public void multiChoiceMenuViewAnimateToVisibility(final int i) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mSplitVisibilityAnim;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.c();
        }
        this.mAnimationMode = i == 0 ? 1 : 2;
        ViewGroup viewGroup = this.mSplitView;
        ViewGroup viewGroup2 = viewGroup != null ? (ViewGroup) viewGroup.getChildAt(0) : null;
        final View view = this.mSplitView == null ? this.mMenuView : (viewGroup2 == null || viewGroup2 == this.mMenuView || viewGroup2.getChildCount() <= 0) ? this.mSplitView : this.mMenuView;
        if (view == null) {
            this.mAnimationMode = 0;
        } else if (i == 0) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (ActionBarContextView.this.mAnimationMode == 2) {
                            ActionBarContextView.this.mSplitViewVisAnimListener.onAnimationEnd(view);
                            return false;
                        }
                        ViewCompat.Z0(view, (float) view.getHeight());
                        ViewPropertyAnimatorCompat q = ViewCompat.e(view).q(0.0f);
                        q.i(260);
                        q.j(ActionBarContextView.MULTI_CHOICE_ANIMATION_INTERPOLATOR_IN);
                        q.k(ActionBarContextView.this.mSplitViewVisAnimListener.withFinalVisibility(q, i));
                        q.o();
                        return false;
                    }
                });
            }
        } else {
            ViewPropertyAnimatorCompat q = ViewCompat.e(view).q((float) view.getHeight());
            q.i(260);
            q.k(this.mSplitViewVisAnimListener.withFinalVisibility(q, i));
            q.j(MULTI_CHOICE_ANIMATION_INTERPOLATOR_OUT);
            q.o();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.mSplitWhenNarrow) {
            setSplitToolbar(getContext().getResources().getBoolean(R.bool.mz_split_action_bar_is_narrow));
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.hideOverflowMenu();
            this.mActionMenuPresenter.hideSubMenus();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.mTitle);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingRight = isLayoutRtl ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.mClose;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
            int i5 = isLayoutRtl ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = isLayoutRtl ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int next = AbsActionBarView.next(paddingRight, i5, isLayoutRtl);
            paddingRight = AbsActionBarView.next(next + positionChild(this.mClose, next, paddingTop, paddingTop2, isLayoutRtl), i6, isLayoutRtl);
        }
        int i7 = paddingRight;
        LinearLayout linearLayout = this.mTitleLayout;
        if (!(linearLayout == null || this.mCustomView != null || linearLayout.getVisibility() == 8)) {
            i7 += positionChild(this.mTitleLayout, i7, paddingTop, paddingTop2, isLayoutRtl);
        }
        int i8 = i7;
        View view2 = this.mCustomView;
        if (view2 != null) {
            positionChild(view2, i8, paddingTop, paddingTop2, isLayoutRtl);
        }
        int paddingLeft = isLayoutRtl ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            positionChild(this.mMenuView, paddingLeft, paddingTop, paddingTop2, !isLayoutRtl);
        }
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i2) != 0) {
            int size = View.MeasureSpec.getSize(i);
            int i4 = this.mContentHeight;
            if (i4 <= 0) {
                i4 = View.MeasureSpec.getSize(i2);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = i4 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            View view = this.mClose;
            if (view != null) {
                int measureChildView = measureChildView(view, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
                paddingLeft = measureChildView - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.mMenuView;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = measureChildView(this.mMenuView, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.mTitleLayout;
            if (linearLayout != null && this.mCustomView == null) {
                if (this.mTitleOptional) {
                    this.mTitleLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.mTitleLayout.getMeasuredWidth();
                    boolean z = measuredWidth <= paddingLeft;
                    if (z) {
                        paddingLeft -= measuredWidth;
                    }
                    this.mTitleLayout.setVisibility(z ? 0 : 8);
                } else {
                    paddingLeft = measureChildView(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.mCustomView;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i6 = layoutParams.width;
                int i7 = i6 != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (i6 >= 0) {
                    paddingLeft = Math.min(i6, paddingLeft);
                }
                int i8 = layoutParams.height;
                if (i8 == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                if (i8 >= 0) {
                    i5 = Math.min(i8, i5);
                }
                this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i7), View.MeasureSpec.makeMeasureSpec(i5, i3));
            }
            if (this.mContentHeight <= 0) {
                int childCount = getChildCount();
                int i9 = 0;
                for (int i10 = 0; i10 < childCount; i10++) {
                    int measuredHeight = getChildAt(i10).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i9) {
                        i9 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i9);
                return;
            }
            setMeasuredDimension(size, i4);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void postShowOverflowMenu() {
        super.postShowOverflowMenu();
    }

    public void setContentHeight(int i) {
        this.mContentHeight = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.mCustomView;
        if (view2 != null) {
            removeView(view2);
        }
        this.mCustomView = view;
        if (!(view == null || (linearLayout = this.mTitleLayout) == null)) {
            removeView(linearLayout);
            this.mTitleLayout = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSplitToolbar(boolean z) {
        if (this.mSplitActionBar != z) {
            if (this.mActionMenuPresenter != null) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
                if (!z) {
                    ActionMenuView actionMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
                    this.mMenuView = actionMenuView;
                    actionMenuView.setBackgroundDrawable((Drawable) null);
                    ViewGroup viewGroup = (ViewGroup) this.mMenuView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.mMenuView);
                    }
                    addView(this.mMenuView, layoutParams);
                } else if (this.mSplitView != null) {
                    this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    this.mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
                    layoutParams.width = -1;
                    layoutParams.height = this.mContentHeight;
                    ActionMenuView actionMenuView2 = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
                    this.mMenuView = actionMenuView2;
                    ViewGroup viewGroup2 = (ViewGroup) actionMenuView2.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(this.mMenuView);
                    }
                    this.mSplitView.addView(this.mMenuView, layoutParams);
                }
            }
            super.setSplitToolbar(z);
        }
    }

    public /* bridge */ /* synthetic */ void setSplitView(ViewGroup viewGroup) {
        super.setSplitView(viewGroup);
    }

    public /* bridge */ /* synthetic */ void setSplitWhenNarrow(boolean z) {
        super.setSplitWhenNarrow(z);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        initTitle();
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        initTitle();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.mTitleOptional) {
            requestLayout();
        }
        this.mTitleOptional = z;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i, long j) {
        return super.setupAnimatorToVisibility(i, j);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.showOverflowMenu();
        }
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, CommonUtils.hasFullDisplay() ? R.attr.mzActionModeStyleFullScreen : androidx.appcompat.R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSplitViewVisAnimListener = new SplitViewVisibilityAnimListener();
        TintTypedArray v = TintTypedArray.v(context, attributeSet, androidx.appcompat.R.styleable.ActionMode, i, 0);
        setBackgroundDrawable(v.g(androidx.appcompat.R.styleable.ActionMode_background));
        this.mTitleStyleRes = v.n(androidx.appcompat.R.styleable.ActionMode_titleTextStyle, 0);
        this.mSubtitleStyleRes = v.n(androidx.appcompat.R.styleable.ActionMode_subtitleTextStyle, 0);
        this.mContentHeight = v.m(androidx.appcompat.R.styleable.ActionMode_height, 0);
        this.mCloseItemLayout = v.n(androidx.appcompat.R.styleable.ActionMode_closeItemLayout, androidx.appcompat.R.layout.abc_action_mode_close_item_material);
        v.w();
    }
}
