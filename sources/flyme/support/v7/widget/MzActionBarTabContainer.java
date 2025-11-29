package flyme.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import com.meizu.common.util.ResourceUtils;
import flyme.support.v7.app.ActionBar;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.widget.AnimationUtils;
import flyme.support.v7.widget.TabCollapseButton;

public class MzActionBarTabContainer extends ViewGroup {
    private static final int DEFAULT_CHILD_GRAVITY = 8388659;
    public static final int SCROLL_TABS_ANIMATION_DURATION_TRANSLATION = 100;
    public static final int SCROLL_TABS_EXPTEND_TITLE_ANIMATION_DURATION_TRANSLATION = 100;
    private boolean mAllowCollapse;
    private TabCollapseButton mCollapseButton;
    private TabCollapseButton.OnTabCollapseButtonClickListener mCollapseButtonClickListener;
    private Drawable mCollapseButtonDrawable;
    private Context mContext;
    private boolean mIsCapsuleStyle;
    private boolean mIsCollapse;
    private boolean mIsForceCollapse = false;
    private boolean mIsPreventEqualWidth = true;
    /* access modifiers changed from: private */
    public ActionBar.OnScrollTabsVisibilityChangeListener mOnScrollTabsVisibilityChangeListener;
    protected AnimationUtils.AlphaVisibilityAnimator mScollTabsVisibleAnim;
    private ViewPropertyAnimatorListener mScrollTabsAnimListener = new ViewPropertyAnimatorListener() {
        public void onAnimationCancel(View view) {
        }

        public void onAnimationEnd(View view) {
            if (MzActionBarTabContainer.this.mOnScrollTabsVisibilityChangeListener != null) {
                MzActionBarTabContainer.this.mOnScrollTabsVisibilityChangeListener.onChanged(MzActionBarTabContainer.this.mScollTabsVisibleAnim.getFinalVisibility() == 0);
            }
        }

        public void onAnimationStart(View view) {
            if (MzActionBarTabContainer.this.mOnScrollTabsVisibilityChangeListener != null) {
                MzActionBarTabContainer.this.mOnScrollTabsVisibilityChangeListener.onPrepareChange(MzActionBarTabContainer.this.mScollTabsVisibleAnim.getFinalVisibility() == 0);
            }
        }
    };
    private int mScrollTabsExpendTitleTextAppearance;
    private int mScrollTabsExpendTitleTextColor;
    private TextView mScrollTabsExpendTitleTextView;
    protected AnimationUtils.AlphaVisibilityAnimator mScrollTabsExpendTitleVisibilityAnim;
    private ScrollingTabContainerView mScrollingTabView;
    private boolean mShowAtToolbar = false;
    private boolean mTabsGravitySet;
    private int mTopDividerColor;
    private int mTopDividerHeight;
    private final Paint mTopDividerPaint;

    public MzActionBarTabContainer(Context context) {
        super(context, (AttributeSet) null, R.attr.mzActionBarTabContainerStyle);
        TintTypedArray v = TintTypedArray.v(context, (AttributeSet) null, R.styleable.MzActionBarTabContainer, R.attr.mzActionBarTabContainerStyle, 0);
        this.mAllowCollapse = v.a(R.styleable.MzActionBarTabContainer_mzAllowCollapse, false);
        v.w();
        TintTypedArray v2 = TintTypedArray.v(context, (AttributeSet) null, R.styleable.MzActionBarTabScrollView, R.attr.mzActionBarTabScrollViewStyle, 0);
        this.mTopDividerColor = v2.b(R.styleable.MzActionBarTabScrollView_mzTopDividerColor, getResources().getColor(R.color.mz_action_bar_scrollview_divider_default_color));
        this.mTopDividerHeight = v2.f(R.styleable.MzActionBarTabScrollView_mzTopDividerHeight, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_scroll_top_divider_height));
        this.mScrollTabsExpendTitleTextColor = v2.b(R.styleable.MzActionBarTabScrollView_mzTabScrollViewExpendTitleColor, getResources().getColor(com.meizu.common.R.color.mz_white_action_bar_textcolor));
        this.mScrollTabsExpendTitleTextAppearance = v2.n(R.styleable.MzActionBarTabScrollView_mzTabScrollViewExpendTitleTextAppearance, R.style.TextAppearance_Flyme_AppCompat_Widget_ActionBar_TabScrollView_ExpendTitle);
        v2.w();
        this.mContext = context;
        Paint paint = new Paint();
        this.mTopDividerPaint = paint;
        paint.setColor(this.mTopDividerColor);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mz_action_tab_bar_margin_left);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
    }

    private void performCollapse() {
        if (this.mCollapseButton == null) {
            this.mCollapseButton = new TabCollapseButton(this.mContext);
        }
        if (this.mCollapseButton.getParent() != this) {
            addView(this.mCollapseButton);
            ViewGroup.LayoutParams layoutParams = this.mCollapseButton.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        this.mCollapseButton.setOnTabCollapseButtonClickListener(this.mCollapseButtonClickListener);
        Drawable drawable = this.mCollapseButtonDrawable;
        if (drawable != null) {
            this.mCollapseButton.setImageDrawable(drawable);
        }
        this.mCollapseButton.setVisibility(0);
        if (!this.mShowAtToolbar) {
            setPadding(getResources().getDimensionPixelSize(R.dimen.mz_action_tab_bar_margin_left), 0, 0, 0);
            this.mCollapseButton.setScaleType(ImageView.ScaleType.MATRIX);
        } else {
            this.mCollapseButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        if (this.mIsCapsuleStyle) {
            this.mCollapseButton.setImageDrawable(getContext().getDrawable(R.drawable.mz_titlebar_ic_tab_unfold_capstyle));
            this.mCollapseButton.setPadding((int) ResourceUtils.dp2px(16.0f, getContext()), 0, (int) ResourceUtils.dp2px(16.0f, getContext()), 0);
            this.mCollapseButton.setScaleType(ImageView.ScaleType.CENTER);
        }
    }

    private void performNotCollapse() {
        TabCollapseButton tabCollapseButton = this.mCollapseButton;
        if (tabCollapseButton != null) {
            tabCollapseButton.setVisibility(8);
        }
        TextView textView = this.mScrollTabsExpendTitleTextView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        if (this.mShowAtToolbar) {
            setPadding(0, 0, 0, 0);
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mz_action_tab_bar_margin_left);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
    }

    private void positionStartChild(View view, int i, boolean z, boolean z2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i2 = z ? layoutParams.rightMargin : layoutParams.leftMargin;
        int i3 = z ? layoutParams.leftMargin : layoutParams.rightMargin;
        int paddingTop = getPaddingTop();
        int measuredHeight = getMeasuredHeight() - getPaddingBottom();
        int measuredWidth = z ? (i - i3) - view.getMeasuredWidth() : i + i2;
        int i4 = layoutParams.gravity;
        if (i4 == -1) {
            i4 = 8388659;
        }
        int i5 = i4 & 112;
        int measuredHeight2 = view.getMeasuredHeight();
        int i6 = i5 != 48 ? i5 != 80 ? ((paddingTop + (((measuredHeight - paddingTop) - measuredHeight2) / 2)) + layoutParams.topMargin) - layoutParams.bottomMargin : (measuredHeight - measuredHeight2) - layoutParams.bottomMargin : paddingTop + layoutParams.topMargin;
        if (z2) {
            i6 = (getMeasuredHeight() - view.getMeasuredHeight()) / 2;
        }
        view.layout(measuredWidth, i6, view.getMeasuredWidth() + measuredWidth, measuredHeight2 + i6);
    }

    private boolean shouldLayout(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (!this.mShowAtToolbar && this.mTopDividerHeight > 0) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mz_action_tab_bar_divider_padding);
            canvas.drawRect((float) dimensionPixelSize, 0.0f, (float) (getMeasuredWidth() - dimensionPixelSize), (float) this.mTopDividerHeight, this.mTopDividerPaint);
        }
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getContentStart() {
        return getPaddingStart() + this.mScrollingTabView.getContentStart();
    }

    public ScrollingTabContainerView getTabView() {
        return this.mScrollingTabView;
    }

    public boolean isCollapse() {
        return this.mIsCollapse;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingRight = isLayoutRtl ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        if (shouldLayout(this.mScrollingTabView)) {
            positionStartChild(this.mScrollingTabView, paddingRight, isLayoutRtl, false);
        }
        if (shouldLayout(this.mScrollTabsExpendTitleTextView)) {
            positionStartChild(this.mScrollTabsExpendTitleTextView, paddingRight, isLayoutRtl, true);
        }
        if (shouldLayout(this.mCollapseButton)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCollapseButton.getLayoutParams();
            int paddingLeft = isLayoutRtl ? getPaddingLeft() + (isLayoutRtl ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin) : ((getMeasuredWidth() - getPaddingRight()) - (isLayoutRtl ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin)) - this.mCollapseButton.getMeasuredWidth();
            TabCollapseButton tabCollapseButton = this.mCollapseButton;
            tabCollapseButton.layout(paddingLeft, 0, tabCollapseButton.getMeasuredWidth() + paddingLeft, this.mCollapseButton.getMeasuredHeight());
        }
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (View.MeasureSpec.getMode(i2) != 0) {
            int size = View.MeasureSpec.getSize(i);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            boolean z = false;
            int dimensionPixelSize = !this.mShowAtToolbar ? getResources().getDimensionPixelSize(R.dimen.mz_action_tab_bar_margin_left) : 0;
            boolean z2 = true;
            if (this.mIsForceCollapse) {
                this.mScrollingTabView.setEqualTabWidth(false);
            } else if (!this.mIsPreventEqualWidth) {
                this.mScrollingTabView.setEqualTabWidth(true);
            }
            if (shouldLayout(this.mScrollingTabView)) {
                this.mScrollingTabView.setNeedCollapse(false);
                int i5 = dimensionPixelSize * 2;
                this.mScrollingTabView.measure(View.MeasureSpec.makeMeasureSpec(size - i5, View.MeasureSpec.getMode(i)), i2);
                if (!this.mAllowCollapse || (size >= this.mScrollingTabView.getTabStripWidth() + i5 && !this.mIsForceCollapse)) {
                    z2 = false;
                } else {
                    z = true;
                }
                i3 = this.mScrollingTabView.getMeasuredHeight();
            } else {
                i3 = 0;
                z2 = false;
            }
            if (z != this.mIsCollapse) {
                if (z) {
                    performCollapse();
                } else {
                    performNotCollapse();
                }
                this.mIsCollapse = z;
            }
            if (!this.mTabsGravitySet) {
                if (z) {
                    this.mScrollingTabView.setTabsGravity(3);
                } else {
                    this.mScrollingTabView.setTabsGravity(17);
                }
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
            if (shouldLayout(this.mCollapseButton)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCollapseButton.getLayoutParams();
                this.mCollapseButton.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
                i4 = size - ((this.mCollapseButton.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight());
            } else {
                i4 = size;
            }
            if (shouldLayout(this.mScrollTabsExpendTitleTextView)) {
                this.mScrollTabsExpendTitleTextView.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), makeMeasureSpec);
            }
            if (z2 && shouldLayout(this.mScrollingTabView)) {
                this.mScrollingTabView.setNeedCollapse(z);
                this.mScrollingTabView.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), makeMeasureSpec);
            }
            setMeasuredDimension(size, i3 + paddingTop);
            return;
        }
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
    }

    public void setAdaptTabWidth(boolean z) {
        ScrollingTabContainerView scrollingTabContainerView = this.mScrollingTabView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.setAdaptTabWidthNoScroll(z);
        }
    }

    public void setAllowCollapse(boolean z) {
        if (this.mAllowCollapse != z) {
            this.mAllowCollapse = z;
            requestLayout();
        }
    }

    public void setCapsuleStyleEnable(boolean z) {
        this.mIsCapsuleStyle = z;
    }

    public void setCollapseButtonClickListener(TabCollapseButton.OnTabCollapseButtonClickListener onTabCollapseButtonClickListener) {
        this.mCollapseButtonClickListener = onTabCollapseButtonClickListener;
        TabCollapseButton tabCollapseButton = this.mCollapseButton;
        if (tabCollapseButton != null) {
            tabCollapseButton.setOnTabCollapseButtonClickListener(onTabCollapseButtonClickListener);
        }
    }

    public void setCollapseButtonDrawable(Drawable drawable) {
        this.mCollapseButtonDrawable = drawable;
        TabCollapseButton tabCollapseButton = this.mCollapseButton;
        if (tabCollapseButton != null && drawable != null) {
            tabCollapseButton.setImageDrawable(drawable);
        }
    }

    public void setIsForceCollapse(boolean z) {
        if (this.mIsForceCollapse != z) {
            this.mIsForceCollapse = z;
            requestLayout();
        }
    }

    public void setPreventEqualWidth(boolean z) {
        this.mIsPreventEqualWidth = z;
    }

    public void setScrollTabsExpendTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.mScrollTabsExpendTitleTextView;
            if (textView != null) {
                removeView(textView);
                this.mScrollTabsExpendTitleTextView = null;
            }
        } else if (this.mScrollTabsExpendTitleTextView == null) {
            Context context = getContext();
            TextView textView2 = new TextView(context);
            this.mScrollTabsExpendTitleTextView = textView2;
            textView2.setSingleLine();
            this.mScrollTabsExpendTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
            this.mScrollTabsExpendTitleTextView.setMaxWidth(context.getResources().getDimensionPixelSize(R.dimen.mz_toolbar_title_max_width));
            int i = this.mScrollTabsExpendTitleTextAppearance;
            if (i != 0) {
                this.mScrollTabsExpendTitleTextView.setTextAppearance(context, i);
            }
            int i2 = this.mScrollTabsExpendTitleTextColor;
            if (i2 != 0) {
                this.mScrollTabsExpendTitleTextView.setTextColor(i2);
            }
            this.mScrollTabsExpendTitleTextView.setVisibility(8);
            addView(this.mScrollTabsExpendTitleTextView);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mz_scroll_tabs_expend_title_padding_vertical);
            this.mScrollTabsExpendTitleTextView.setPadding(getResources().getDimensionPixelSize(R.dimen.mz_scroll_tabs_expend_title_margin_left), dimensionPixelSize, 0, dimensionPixelSize);
            LayoutParams layoutParams = (LayoutParams) this.mScrollTabsExpendTitleTextView.getLayoutParams();
            if (this.mShowAtToolbar) {
                layoutParams.gravity = 16;
            } else {
                layoutParams.gravity = 48;
            }
        }
        TextView textView3 = this.mScrollTabsExpendTitleTextView;
        if (textView3 != null) {
            textView3.setText(charSequence);
        }
    }

    public void setScrollTabsExpendTitleTextAppearance(int i) {
        this.mScrollTabsExpendTitleTextAppearance = i;
        if (this.mScrollTabsExpendTitleTextView != null) {
            this.mScrollTabsExpendTitleTextView.setTextAppearance(getContext(), i);
        }
    }

    public void setScrollTabsExpendTitleTextColor(int i) {
        this.mScrollTabsExpendTitleTextColor = i;
        TextView textView = this.mScrollTabsExpendTitleTextView;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setTabView(ScrollingTabContainerView scrollingTabContainerView) {
        ScrollingTabContainerView scrollingTabContainerView2 = this.mScrollingTabView;
        if (scrollingTabContainerView2 != scrollingTabContainerView || scrollingTabContainerView2.getParent() != this) {
            ScrollingTabContainerView scrollingTabContainerView3 = this.mScrollingTabView;
            if (scrollingTabContainerView3 != null) {
                removeView(scrollingTabContainerView3);
            }
            this.mScrollingTabView = scrollingTabContainerView;
            if (scrollingTabContainerView != null) {
                addView(scrollingTabContainerView);
                scrollingTabContainerView.setAllowCollapse(false);
            }
        }
    }

    public void setTabsContentHeight(int i) {
        ScrollingTabContainerView scrollingTabContainerView = this.mScrollingTabView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.setContentHeight(i);
        }
    }

    public void setTabsGravity(int i) {
        this.mTabsGravitySet = true;
        ScrollingTabContainerView scrollingTabContainerView = this.mScrollingTabView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.setTabsGravity(i);
        }
    }

    public void setupScrollTabsAnimatorToVisibility(int i, ActionBar.OnScrollTabsVisibilityChangeListener onScrollTabsVisibilityChangeListener) {
        AnimationUtils.AlphaVisibilityAnimator alphaVisibilityAnimator = this.mScollTabsVisibleAnim;
        if (alphaVisibilityAnimator != null) {
            alphaVisibilityAnimator.cancel();
        }
        ScrollingTabContainerView scrollingTabContainerView = this.mScrollingTabView;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = null;
        if (scrollingTabContainerView != null) {
            this.mOnScrollTabsVisibilityChangeListener = onScrollTabsVisibilityChangeListener;
            AnimationUtils.AlphaVisibilityAnimator alphaVisibilityAnimator2 = new AnimationUtils.AlphaVisibilityAnimator(scrollingTabContainerView, i);
            this.mScollTabsVisibleAnim = alphaVisibilityAnimator2;
            alphaVisibilityAnimator2.setDuration(100);
            this.mScollTabsVisibleAnim.setAnimatorListener(this.mScrollTabsAnimListener);
        } else {
            this.mScollTabsVisibleAnim = null;
        }
        AnimationUtils.AlphaVisibilityAnimator alphaVisibilityAnimator3 = this.mScrollTabsExpendTitleVisibilityAnim;
        if (alphaVisibilityAnimator3 != null) {
            alphaVisibilityAnimator3.cancel();
        }
        TextView textView = this.mScrollTabsExpendTitleTextView;
        if (textView != null) {
            if (i == 4) {
                this.mScrollTabsExpendTitleVisibilityAnim = new AnimationUtils.AlphaVisibilityAnimator(textView, 0);
            } else {
                this.mScrollTabsExpendTitleVisibilityAnim = new AnimationUtils.AlphaVisibilityAnimator(textView, 4);
            }
            this.mScrollTabsExpendTitleVisibilityAnim.setDuration(100);
        } else {
            this.mScrollTabsExpendTitleVisibilityAnim = null;
        }
        AnimationUtils.AlphaVisibilityAnimator alphaVisibilityAnimator4 = this.mScollTabsVisibleAnim;
        ViewPropertyAnimatorCompat animator = alphaVisibilityAnimator4 != null ? alphaVisibilityAnimator4.getAnimator() : null;
        AnimationUtils.AlphaVisibilityAnimator alphaVisibilityAnimator5 = this.mScrollTabsExpendTitleVisibilityAnim;
        if (alphaVisibilityAnimator5 != null) {
            viewPropertyAnimatorCompat = alphaVisibilityAnimator5.getAnimator();
        }
        if (i == 4) {
            if (animator != null) {
                animator.o();
            }
            if (viewPropertyAnimatorCompat == null) {
                return;
            }
            if (animator != null) {
                viewPropertyAnimatorCompat.m(150);
            } else {
                viewPropertyAnimatorCompat.o();
            }
        } else {
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.o();
            }
            if (animator == null) {
                return;
            }
            if (viewPropertyAnimatorCompat != null) {
                animator.m(150);
            } else {
                animator.o();
            }
        }
    }

    public void showAtToolbar(boolean z) {
        this.mScrollingTabView.showAtToolbar(z);
        if (this.mShowAtToolbar != z) {
            this.mShowAtToolbar = z;
            if (z) {
                setPadding(0, 0, 0, 0);
                TextView textView = this.mScrollTabsExpendTitleTextView;
                if (textView != null && textView.getLayoutParams() != null) {
                    ((LayoutParams) this.mScrollTabsExpendTitleTextView.getLayoutParams()).gravity = 16;
                    return;
                }
                return;
            }
            TextView textView2 = this.mScrollTabsExpendTitleTextView;
            if (textView2 != null && textView2.getLayoutParams() != null) {
                ((LayoutParams) this.mScrollTabsExpendTitleTextView.getLayoutParams()).gravity = 48;
            }
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity = 16;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
