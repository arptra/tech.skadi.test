package flyme.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.meizu.common.util.ResourceUtils;
import flyme.support.v7.app.ActionBar;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.drawable.EmptyDivider;
import flyme.support.v7.view.ActionBarPolicy;
import java.util.ArrayList;
import java.util.Iterator;

public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final int ANIMATION_DURATION = 400;
    private static final int FADE_DURATION = 200;
    private static final int FIXED_WRAP_GUTTER_MIN = 16;
    /* access modifiers changed from: private */
    public static final Interpolator INDICATOR_POSITION_INTERPOLATOR = PathInterpolatorCompat.a(0.17f, 0.17f, 0.2f, 1.0f);
    /* access modifiers changed from: private */
    public static final Interpolator INDICATOR_SHORT_INTERPOLATOR = PathInterpolatorCompat.a(0.17f, 0.17f, 0.2f, 1.0f);
    private static final int INDICATOR_STRETCH_DURATION = 130;
    /* access modifiers changed from: private */
    public static final Interpolator INDICATOR_STRETCH_INTERPOLATOR = PathInterpolatorCompat.a(0.33f, 0.0f, 0.83f, 0.83f);
    private static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    private static final int MOTION_NON_ADJACENT_OFFSET = 24;
    private static final String TAG = "ScrollingTabContainerView";
    private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();
    /* access modifiers changed from: private */
    public boolean isAtToolbar;
    private boolean mAllowCollapse;
    private int mContentHeight;
    /* access modifiers changed from: private */
    public int mCustomTabTextColor;
    /* access modifiers changed from: private */
    public boolean mIsAdaptTabWidth;
    /* access modifiers changed from: private */
    public boolean mIsAloneTabContainer;
    private boolean mIsCapsuleStyle;
    private boolean mIsEqualTabWidth;
    private boolean mIsTabClick;
    /* access modifiers changed from: private */
    public int mMinTabWidth;
    /* access modifiers changed from: private */
    public int mMode;
    private boolean mNeedCollapse;
    private int mSelectedTabIndex;
    int mStackedTabMaxWidth;
    private TabClickListener mTabClickListener;
    /* access modifiers changed from: private */
    public SlidingTabStrip mTabLayout;
    private int mTabPadding2;
    private int mTabPaddingOver5;
    Runnable mTabSelector;
    private Spinner mTabSpinner;
    private int mTabWidth3;
    private int mTabWidth4;
    private int mTabWidthNoCollapse5;
    private int mTabsGravity;
    protected final VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimatorCompat mVisibilityAnim;

    public class SlidingTabStrip extends LinearLayoutCompat {
        private boolean mDrawIndicator;
        private boolean mDrawIndicatorInToolbar;
        private ValueAnimator mIndicatorAnimator;
        private Drawable mIndicatorDrawable;
        private int mIndicatorLeft;
        private int mIndicatorRight;
        private int mIndicatorScrollStretchMaxWidth;
        private int mSelectedIndicatorColor;
        private int mSelectedIndicatorExceedContent;
        private int mSelectedIndicatorHeight;
        private int mSelectedIndicatorPaddingBottom;
        private int mSelectedIndicatorPaddingBottomAtToolBar;
        private final Paint mSelectedIndicatorPaint;
        private int mSelectedIndicatorWidth;
        private int mSelectedIndicatorWidthMain;
        private int mSelectedIndicatorWidthSecond;
        /* access modifiers changed from: private */
        public int mSelectedPosition;
        /* access modifiers changed from: private */
        public float mSelectionOffset;

        public SlidingTabStrip(ScrollingTabContainerView scrollingTabContainerView, Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        private int getIndicatorWidth(View view) {
            return this.mSelectedIndicatorWidth;
        }

        private void setIndicatorPosition(int i, int i2) {
            if (i != this.mIndicatorLeft || i2 != this.mIndicatorRight) {
                this.mIndicatorLeft = i;
                this.mIndicatorRight = i2;
                ViewCompat.k0(this);
            }
        }

        private void tryScatterLayout() {
            int childCount = getChildCount();
            if (childCount != 0) {
                int i = 0;
                for (int i2 = 0; i2 < childCount; i2++) {
                    i += getChildAt(i2).getMeasuredWidth();
                }
                if (i < getMeasuredWidth()) {
                    int dimensionPixelSize = childCount == 2 ? getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_bar_inset_2_tab) : childCount == 3 ? getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_bar_inset_3_tab) : 0;
                    if (getMeasuredWidth() - i < dimensionPixelSize * 2) {
                        dimensionPixelSize = 0;
                    }
                    int measuredWidth = getMeasuredWidth() - (dimensionPixelSize * 2);
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = getChildAt(i3);
                        int measuredWidth2 = childAt.getMeasuredWidth();
                        int i4 = (int) ((((float) measuredWidth2) / ((float) i)) * ((float) measuredWidth));
                        int i5 = ((i4 - measuredWidth2) / 2) + dimensionPixelSize;
                        dimensionPixelSize += i4;
                        childAt.layout(i5, childAt.getTop(), measuredWidth2 + i5, childAt.getBottom());
                    }
                }
            }
        }

        private void updateIndicatorPosition() {
            int i;
            int i2;
            View childAt = getChildAt(this.mSelectedPosition);
            if (childAt == null || childAt.getWidth() <= 0) {
                i2 = -1;
                i = -1;
            } else {
                int left = (childAt.getLeft() + childAt.getRight()) / 2;
                int i3 = this.mSelectedIndicatorWidth;
                i2 = left - (i3 / 2);
                i = left + (i3 / 2);
                if (this.mSelectionOffset > 0.0f && this.mSelectedPosition < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.mSelectedPosition + 1);
                    int left2 = (childAt2.getLeft() + childAt2.getRight()) / 2;
                    int indicatorWidth = getIndicatorWidth(childAt2) / 2;
                    setIndicatorPosition(this.mSelectionOffset, i2, i, left2 - indicatorWidth, left2 + indicatorWidth);
                    return;
                }
            }
            setIndicatorPosition(i2, i);
        }

        public void animateIndicatorToPosition(final int i, int i2) {
            ViewCompat.z(this);
            View childAt = getChildAt(i);
            if (childAt != null) {
                int left = (childAt.getLeft() + childAt.getRight()) / 2;
                int indicatorWidth = getIndicatorWidth(childAt) / 2;
                final int i3 = left - indicatorWidth;
                final int i4 = left + indicatorWidth;
                final int i5 = this.mIndicatorLeft;
                final int i6 = this.mIndicatorRight;
                if ((i5 == i3 && i6 == i4) || i5 < 0 || i6 < 0) {
                    this.mSelectedPosition = i;
                    this.mSelectionOffset = 0.0f;
                } else if (i2 > 0) {
                    ValueAnimator valueAnimator = this.mIndicatorAnimator;
                    if (valueAnimator != null && valueAnimator.isRunning()) {
                        this.mIndicatorAnimator.cancel();
                    }
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                    this.mIndicatorAnimator = ofFloat;
                    ofFloat.setDuration((long) i2);
                    this.mIndicatorAnimator.setInterpolator((TimeInterpolator) null);
                    this.mIndicatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            SlidingTabStrip.this.setIndicatorPosition(valueAnimator.getAnimatedFraction(), i5, i6, i3, i4);
                        }
                    });
                    this.mIndicatorAnimator.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationCancel(Animator animator) {
                            int unused = SlidingTabStrip.this.mSelectedPosition = i;
                            float unused2 = SlidingTabStrip.this.mSelectionOffset = 0.0f;
                        }

                        public void onAnimationEnd(Animator animator) {
                            int unused = SlidingTabStrip.this.mSelectedPosition = i;
                            float unused2 = SlidingTabStrip.this.mSelectionOffset = 0.0f;
                        }
                    });
                    this.mIndicatorAnimator.start();
                } else {
                    setIndicatorPosition(1.0f, i5, i6, i3, i4);
                }
            }
        }

        public void cancelIndicatorAnim() {
            ValueAnimator valueAnimator = this.mIndicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mIndicatorAnimator.cancel();
            }
        }

        public int getContentBottom() {
            TabView tabView = (TabView) getChildAt(0);
            if (tabView == null) {
                return 0;
            }
            return tabView.getBottom() - (tabView.getMeasuredHeight() - tabView.getContentBottom());
        }

        public int getContentStart() {
            int i = 0;
            View childAt = getChildAt(0);
            int paddingStart = getPaddingStart();
            if (childAt != null) {
                i = childAt.getPaddingStart();
            }
            return paddingStart + i;
        }

        public boolean isIndicatorAnimRunning() {
            ValueAnimator valueAnimator = this.mIndicatorAnimator;
            return valueAnimator != null && valueAnimator.isRunning();
        }

        public void onDraw(Canvas canvas) {
            int i = this.mIndicatorLeft;
            if (i >= 0 && this.mIndicatorRight > i) {
                if (((!ScrollingTabContainerView.this.isAtToolbar && this.mDrawIndicator) || (ScrollingTabContainerView.this.isAtToolbar && this.mDrawIndicatorInToolbar)) && !ScrollingTabContainerView.this.useCapsuleStyle()) {
                    int height = (getHeight() - this.mSelectedIndicatorHeight) - (ScrollingTabContainerView.this.isAtToolbar ? this.mSelectedIndicatorPaddingBottomAtToolBar : this.mSelectedIndicatorPaddingBottom);
                    int contentBottom = getContentBottom();
                    if (height < contentBottom) {
                        height = contentBottom;
                    }
                    if (this.mSelectedIndicatorHeight + height > getHeight()) {
                        height = getHeight() - this.mSelectedIndicatorHeight;
                    }
                    Drawable drawable = this.mIndicatorDrawable;
                    if (drawable != null) {
                        drawable.setBounds(this.mIndicatorLeft, height, this.mIndicatorRight, this.mSelectedIndicatorHeight + height);
                        this.mIndicatorDrawable.draw(canvas);
                        return;
                    }
                    canvas.drawRect((float) this.mIndicatorLeft, (float) height, (float) this.mIndicatorRight, (float) (height + this.mSelectedIndicatorHeight), this.mSelectedIndicatorPaint);
                }
            }
        }

        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (!ScrollingTabContainerView.isAnimationRunning(getAnimation())) {
                updateIndicatorPosition();
            }
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) == 1073741824 && ScrollingTabContainerView.this.mMode == 1) {
                int childCount = getChildCount();
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                int i3 = 0;
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    childAt.measure(makeMeasureSpec, i2);
                    i3 = Math.max(i3, childAt.getMeasuredWidth());
                }
                if (i3 > 0) {
                    if (i3 * childCount <= getMeasuredWidth() - (ScrollingTabContainerView.this.dpToPx(16) * 2)) {
                        for (int i5 = 0; i5 < childCount; i5++) {
                            LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) getChildAt(i5).getLayoutParams();
                            layoutParams.width = i3;
                            layoutParams.weight = 0.0f;
                        }
                    }
                    super.onMeasure(i, i2);
                }
            }
        }

        public void resetPosition(int i) {
            if (this.mSelectedPosition == i) {
                this.mIndicatorLeft = -1;
                this.mIndicatorRight = -1;
                return;
            }
            setIndicatorPositionFromTabPosition(Math.max(0, i - 1), 0.0f);
        }

        public void setAtToolbar(boolean z) {
            if (z) {
                this.mSelectedIndicatorWidth = this.mSelectedIndicatorWidthMain;
            } else {
                this.mSelectedIndicatorWidth = this.mSelectedIndicatorWidthSecond;
            }
        }

        public void setIndicatorDrawable(Drawable drawable) {
            if (this.mIndicatorDrawable != drawable) {
                this.mIndicatorDrawable = drawable;
                invalidate();
            }
        }

        public void setIndicatorPositionFromTabPosition(int i, float f) {
            if (!ScrollingTabContainerView.isAnimationRunning(getAnimation())) {
                cancelIndicatorAnim();
                this.mSelectedPosition = i;
                this.mSelectionOffset = f;
                updateIndicatorPosition();
            }
        }

        public void setSelectedIndicatorColor(int i) {
            this.mSelectedIndicatorPaint.setColor(i);
            ViewCompat.k0(this);
        }

        public void setSelectedIndicatorHeight(int i) {
            this.mSelectedIndicatorHeight = i;
            ViewCompat.k0(this);
        }

        public void setSelectedIndicatorPaddingBottom(int i) {
            this.mSelectedIndicatorPaddingBottom = i;
            ViewCompat.k0(this);
        }

        public void setSelectedIndicatorPaddingBottomAtToolBar(int i) {
            this.mSelectedIndicatorPaddingBottomAtToolBar = i;
            ViewCompat.k0(this);
        }

        public void setSelectedIndicatorWidth(int i) {
            this.mSelectedIndicatorWidth = i;
            ViewCompat.k0(this);
        }

        public void updateIndicatorWidth(View view) {
            this.mSelectedIndicatorWidth = getIndicatorWidth(view);
        }

        public SlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.mSelectedPosition = -1;
            this.mIndicatorLeft = -1;
            this.mIndicatorRight = -1;
            setWillNotDraw(false);
            Paint paint = new Paint();
            this.mSelectedIndicatorPaint = paint;
            TintTypedArray v = TintTypedArray.v(context, attributeSet, R.styleable.MzActionBarTabBar, i, 0);
            int b = v.b(R.styleable.MzActionBarTabBar_mzTabBarIndicatorColor, getResources().getColor(R.color.mz_action_bar_tab_indicator_default_color));
            this.mSelectedIndicatorColor = b;
            paint.setColor(b);
            this.mSelectedIndicatorHeight = v.f(R.styleable.MzActionBarTabBar_mzTabBarIndicatorHeight, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_indicator_height));
            this.mDrawIndicator = v.a(R.styleable.MzActionBarTabBar_mzDrawTabBarIndicator, true);
            this.mDrawIndicatorInToolbar = v.a(R.styleable.MzActionBarTabBar_mzDrawToolbarTabBarIndicator, false);
            this.mIndicatorDrawable = v.g(R.styleable.MzActionBarTabBar_mzTabBarIndicatorDrawable);
            this.mSelectedIndicatorWidthMain = v.f(R.styleable.MzActionBarTabBar_mzTabBarIndicatorWidth, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_indicator_width));
            this.mSelectedIndicatorWidthSecond = v.f(R.styleable.MzActionBarTabBar_mzTabBarIndicatorWidthSecond, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_indicator_width_second));
            if (ScrollingTabContainerView.this.isAtToolbar) {
                this.mSelectedIndicatorWidth = this.mSelectedIndicatorWidthMain;
            } else {
                this.mSelectedIndicatorWidth = this.mSelectedIndicatorWidthSecond;
            }
            this.mSelectedIndicatorExceedContent = v.f(R.styleable.MzActionBarTabBar_mzTabBarIndicatorExceedContent, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_view_indicator_exceed_content));
            this.mSelectedIndicatorPaddingBottom = v.f(R.styleable.MzActionBarTabBar_mzTabBarIndicatorPaddingBottom, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_indicator_padding_bottom));
            this.mSelectedIndicatorPaddingBottomAtToolBar = v.f(R.styleable.MzActionBarTabBar_mzTabBarIndicatorPaddingBottomAtToolBar, getResources().getDimensionPixelSize(R.dimen.mz_tool_bar_tab_indicator_padding_bottom));
            v.w();
            this.mIndicatorScrollStretchMaxWidth = getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_indicator_edge_max_move_width);
            setMotionEventSplittingEnabled(false);
            EmptyDivider emptyDivider = new EmptyDivider();
            emptyDivider.setDividerWidth(33);
            setDividerDrawable(emptyDivider);
        }

        /* access modifiers changed from: private */
        public void setIndicatorPosition(float f, int i, int i2, int i3, int i4) {
            Interpolator interpolator;
            float f2;
            float max = Math.max(Math.min(f, 1.0f), 0.0f);
            if (max < 0.325f) {
                f2 = max / 0.325f;
                interpolator = ScrollingTabContainerView.INDICATOR_STRETCH_INTERPOLATOR;
            } else {
                f2 = (1.0f - max) / 0.675f;
                interpolator = ScrollingTabContainerView.INDICATOR_SHORT_INTERPOLATOR;
            }
            int interpolation = this.mSelectedIndicatorWidth + ((int) (interpolator.getInterpolation(f2) * ((float) this.mIndicatorScrollStretchMaxWidth)));
            if (i < i3) {
                i2 = AnimationUtils.lerp(i2, i4, ScrollingTabContainerView.INDICATOR_POSITION_INTERPOLATOR.getInterpolation(max));
                i = i2 - interpolation;
            } else if (i > i3) {
                i = AnimationUtils.lerp(i, i3, ScrollingTabContainerView.INDICATOR_POSITION_INTERPOLATOR.getInterpolation(max));
                i2 = i + interpolation;
            }
            setIndicatorPosition(i, i2);
        }
    }

    public class TabAdapter extends BaseAdapter {
        private TabAdapter() {
        }

        public int getCount() {
            return ScrollingTabContainerView.this.mTabLayout.getChildCount();
        }

        public Object getItem(int i) {
            return ((TabView) ScrollingTabContainerView.this.mTabLayout.getChildAt(i)).getTab();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.createTabView((ActionBar.Tab) getItem(i), true);
            }
            ((TabView) view).bindTab((ActionBar.Tab) getItem(i));
            return view;
        }
    }

    public class TabClickListener implements View.OnClickListener {
        private TabClickListener() {
        }

        public void onClick(View view) {
            ((TabView) view).getTab().select(true);
            int childCount = ScrollingTabContainerView.this.mTabLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ScrollingTabContainerView.this.mTabLayout.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    public class TabView extends LinearLayoutCompat implements View.OnLongClickListener {
        private final int[] BG_ATTRS;
        private View mCustomView;
        private ImageView mIconView;
        private ActionBar.Tab mTab;
        private TextView mTextView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TabView(Context context, ActionBar.Tab tab, boolean z) {
            super(context, (AttributeSet) null, ScrollingTabContainerView.this.isAtToolbar ? R.attr.mzToolBarTabStyle : androidx.appcompat.R.attr.actionBarTabStyle);
            int[] iArr = {16842964};
            this.BG_ATTRS = iArr;
            this.mTab = tab;
            TintTypedArray v = TintTypedArray.v(context, (AttributeSet) null, iArr, ScrollingTabContainerView.this.isAtToolbar ? R.attr.mzToolBarTabStyle : androidx.appcompat.R.attr.actionBarTabStyle, 0);
            v.s(0);
            v.w();
            if (z) {
                setGravity(8388627);
            }
            update();
            if (ScrollingTabContainerView.this.useCapsuleStyle()) {
                this.mTextView.setTextSize(2, 13.0f);
            }
        }

        private TextView getContentTextView() {
            return this.mTextView;
        }

        public void bindTab(ActionBar.Tab tab) {
            this.mTab = tab;
            update();
        }

        public int getContentBottom() {
            View view = this.mCustomView;
            if ((view instanceof CustomTabView) && view.getVisibility() == 0) {
                return ((CustomTabView) this.mCustomView).getContentBottom();
            }
            View view2 = this.mCustomView;
            if (view2 == null || view2.getVisibility() != 0) {
                TextView textView = this.mTextView;
                if (textView == null || textView.getVisibility() != 0) {
                    ImageView imageView = this.mIconView;
                    this = this;
                    if (imageView != null) {
                        this = this;
                        if (imageView.getVisibility() == 0) {
                            this = this.mIconView;
                        }
                    }
                } else {
                    this = this.mTextView;
                }
            } else {
                this = this.mCustomView;
            }
            return this.getBottom();
        }

        public ActionBar.Tab getTab() {
            return this.mTab;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.mTab.getContentDescription(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ScrollingTabContainerView.this.mMinTabWidth > 0 && getMeasuredWidth() < ScrollingTabContainerView.this.mMinTabWidth && !ScrollingTabContainerView.this.mIsAdaptTabWidth) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(ScrollingTabContainerView.this.mMinTabWidth, 1073741824), i2);
            }
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
            if (!ScrollingTabContainerView.this.useCapsuleStyle()) {
                return;
            }
            if (ScrollingTabContainerView.this.mCustomTabTextColor != 0) {
                this.mTextView.setTextColor(ScrollingTabContainerView.this.mCustomTabTextColor);
            } else if (z) {
                this.mTextView.setTextColor(-1);
            } else {
                this.mTextView.setTextColor(getContext().getColor(R.color.fd_sys_color_on_surface_default));
            }
        }

        public void update() {
            ActionBar.Tab tab = this.mTab;
            View customView = tab.getCustomView();
            boolean z = true;
            boolean z2 = false;
            if (customView != null) {
                ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(customView);
                    }
                    setClipChildren(false);
                    setClipToPadding(false);
                    addView(customView);
                }
                this.mCustomView = customView;
                TextView textView = this.mTextView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.mIconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.mIconView.setImageDrawable((Drawable) null);
                }
                if (customView instanceof CustomTabView) {
                    this.mTextView = ((CustomTabView) customView).getTabTextView();
                }
            } else {
                View view = this.mCustomView;
                if (view != null) {
                    removeView(view);
                    this.mCustomView = null;
                }
                Drawable icon = tab.getIcon();
                CharSequence text = tab.getText();
                ColorStateList textColor = tab.getTextColor();
                if (icon != null) {
                    if (this.mIconView == null) {
                        ImageView imageView2 = new ImageView(getContext());
                        LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                        layoutParams.gravity = 16;
                        imageView2.setLayoutParams(layoutParams);
                        addView(imageView2, 0);
                        this.mIconView = imageView2;
                    }
                    this.mIconView.setImageDrawable(icon);
                    this.mIconView.setVisibility(0);
                } else {
                    ImageView imageView3 = this.mIconView;
                    if (imageView3 != null) {
                        imageView3.setVisibility(8);
                        this.mIconView.setImageDrawable((Drawable) null);
                    }
                }
                boolean z3 = !TextUtils.isEmpty(text);
                if (z3) {
                    if (this.mTextView == null) {
                        int i = ScrollingTabContainerView.this.isAtToolbar ? R.attr.mzToolBarTabTextStyle : androidx.appcompat.R.attr.actionBarTabTextStyle;
                        if (ScrollingTabContainerView.this.mIsAloneTabContainer) {
                            i = R.attr.mzAloneTabContainerTabTextStyle;
                        }
                        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), (AttributeSet) null, i);
                        appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                        LinearLayoutCompat.LayoutParams layoutParams2 = new LinearLayoutCompat.LayoutParams(-2, -2);
                        boolean unused = ScrollingTabContainerView.this.isAtToolbar;
                        layoutParams2.gravity = 16;
                        appCompatTextView.setLayoutParams(layoutParams2);
                        addView(appCompatTextView);
                        this.mTextView = appCompatTextView;
                    }
                    this.mTextView.setText(text);
                    if (textColor != null) {
                        this.mTextView.setTextColor(textColor);
                    }
                    this.mTextView.setVisibility(0);
                    this.mTextView.setEnabled(tab.isEnabled());
                } else {
                    TextView textView2 = this.mTextView;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                        this.mTextView.setText((CharSequence) null);
                    }
                }
                ImageView imageView4 = this.mIconView;
                if (imageView4 != null) {
                    imageView4.setContentDescription(tab.getContentDescription());
                }
                if (z3 || TextUtils.isEmpty(tab.getContentDescription())) {
                    setOnLongClickListener((View.OnLongClickListener) null);
                    setLongClickable(false);
                } else {
                    setOnLongClickListener(this);
                }
            }
            setEnabled(tab.isEnabled());
            int paddingStart = tab.getPaddingStart();
            int paddingEnd = tab.getPaddingEnd();
            if (paddingStart >= 0) {
                z2 = true;
            } else {
                paddingStart = getPaddingLeft();
            }
            if (paddingEnd < 0) {
                paddingEnd = getPaddingRight();
                z = z2;
            }
            if (z) {
                setPadding(paddingStart, getPaddingTop(), paddingEnd, getPaddingBottom());
            }
            int minWidth = tab.getMinWidth();
            if (minWidth >= 0) {
                setMinimumWidth(minWidth);
            }
            TextView textView3 = this.mTextView;
            if (textView3 != null) {
                textView3.setEllipsize(TextUtils.TruncateAt.END);
            }
        }
    }

    public class VisibilityAnimListener implements ViewPropertyAnimatorListener {
        private boolean mCanceled = false;
        private int mFinalVisibility;

        public VisibilityAnimListener() {
        }

        public void onAnimationCancel(View view) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(View view) {
            if (!this.mCanceled) {
                ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
                scrollingTabContainerView.mVisibilityAnim = null;
                scrollingTabContainerView.setVisibility(this.mFinalVisibility);
            }
        }

        public void onAnimationStart(View view) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
            this.mFinalVisibility = i;
            ScrollingTabContainerView.this.mVisibilityAnim = viewPropertyAnimatorCompat;
            return this;
        }
    }

    public ScrollingTabContainerView(Context context) {
        this(context, (AttributeSet) null);
    }

    private int calculateScrollXForTab(int i, float f) {
        int i2 = 0;
        if (this.mMode != 0) {
            return 0;
        }
        View childAt = this.mTabLayout.getChildAt(i);
        int i3 = i + 1;
        View childAt2 = i3 < this.mTabLayout.getChildCount() ? this.mTabLayout.getChildAt(i3) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        if (this.mTabLayout.getShowDividers() == 2) {
            i2 = this.mTabLayout.getDividerDrawable().getIntrinsicWidth();
        }
        float f2 = ((float) (width + width2 + (i2 * 2))) * f * 0.5f;
        if (ViewCompat.z(this) == 1) {
            f2 = -f2;
        }
        return (int) (((((float) childAt.getLeft()) + f2) + (((float) childAt.getWidth()) * 0.5f)) - (((float) getWidth()) * 0.5f));
    }

    private Spinner createSpinner() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), (AttributeSet) null, androidx.appcompat.R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private SlidingTabStrip createTabLayout() {
        SlidingTabStrip slidingTabStrip = new SlidingTabStrip(getContext(), (AttributeSet) null, androidx.appcompat.R.attr.actionBarTabBarStyle);
        slidingTabStrip.setClipChildren(false);
        slidingTabStrip.setClipToPadding(false);
        slidingTabStrip.setGravity(this.mTabsGravity);
        slidingTabStrip.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return slidingTabStrip;
    }

    /* access modifiers changed from: private */
    public TabView createTabView(ActionBar.Tab tab, boolean z) {
        TabView tabView = new TabView(getContext(), tab, z);
        if (z) {
            tabView.setBackgroundDrawable((Drawable) null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContentHeight));
        } else {
            tabView.setFocusable(true);
            if (this.mTabClickListener == null) {
                this.mTabClickListener = new TabClickListener();
            }
            tabView.setOnClickListener(this.mTabClickListener);
        }
        if (useCapsuleStyle()) {
            tabView.setBackground(getContext().getDrawable(R.drawable.action_bar_capsure_tab_view_background));
        }
        return tabView;
    }

    /* access modifiers changed from: private */
    public int dpToPx(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    /* access modifiers changed from: private */
    public static boolean isAnimationRunning(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    private boolean isCollapsed() {
        Spinner spinner = this.mTabSpinner;
        return spinner != null && spinner.getParent() == this;
    }

    private void performCollapse() {
        if (!isCollapsed()) {
            if (this.mTabSpinner == null) {
                this.mTabSpinner = createSpinner();
            }
            removeView(this.mTabLayout);
            addView(this.mTabSpinner, new ViewGroup.LayoutParams(-2, -1));
            if (this.mTabSpinner.getAdapter() == null) {
                this.mTabSpinner.setAdapter(new TabAdapter());
            }
            Runnable runnable = this.mTabSelector;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.mTabSelector = null;
            }
            this.mTabSpinner.setSelection(this.mSelectedTabIndex);
        }
    }

    private boolean performExpand() {
        if (!isCollapsed()) {
            return false;
        }
        removeView(this.mTabSpinner);
        addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.mTabSpinner.getSelectedItemPosition());
        return false;
    }

    private void setSelectedTabView(int i) {
        int childCount = this.mTabLayout.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            this.mTabLayout.getChildAt(i2).setSelected(i2 == i);
            i2++;
        }
    }

    private void setTabsGravityInner(int i) {
        SlidingTabStrip slidingTabStrip = this.mTabLayout;
        if (slidingTabStrip != null) {
            slidingTabStrip.setGravity(i);
        }
    }

    /* access modifiers changed from: private */
    public boolean useCapsuleStyle() {
        return this.mIsCapsuleStyle && !this.isAtToolbar;
    }

    public void addTab(ActionBar.Tab tab, boolean z) {
        TabView createTabView = createTabView(tab, false);
        this.mTabLayout.addView(createTabView, new LinearLayoutCompat.LayoutParams(-2, -1));
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            createTabView.setSelected(true);
            SlidingTabStrip slidingTabStrip = this.mTabLayout;
            slidingTabStrip.setIndicatorPositionFromTabPosition(slidingTabStrip.getChildCount() - 1, 0.0f);
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void animateToTab(final int i) {
        final View childAt = this.mTabLayout.getChildAt(i);
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        AnonymousClass1 r1 = new Runnable() {
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.mTabLayout.animateIndicatorToPosition(i, 400);
                ScrollingTabContainerView.this.mTabSelector = null;
            }
        };
        this.mTabSelector = r1;
        post(r1);
    }

    public void animateToVisibility(int i) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVisibilityAnim;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.c();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                ViewCompat.y0(this, 0.0f);
            }
            ViewPropertyAnimatorCompat b = ViewCompat.e(this).b(1.0f);
            b.i(200);
            b.j(sAlphaInterpolator);
            b.k(this.mVisAnimListener.withFinalVisibility(b, i));
            b.o();
            return;
        }
        ViewPropertyAnimatorCompat b2 = ViewCompat.e(this).b(0.0f);
        b2.i(200);
        b2.j(sAlphaInterpolator);
        b2.k(this.mVisAnimListener.withFinalVisibility(b2, i));
        b2.o();
    }

    public void customTabTextColor(@ColorInt int i) {
        this.mCustomTabTextColor = i;
    }

    public float getContentBottom() {
        return (float) (this.mTabLayout.getBottom() - (this.mTabLayout.getMeasuredHeight() - this.mTabLayout.getContentBottom()));
    }

    public int getContentStart() {
        return getPaddingStart() + this.mTabLayout.getContentStart();
    }

    public int getTabStripWidth() {
        return this.mTabLayout.getMeasuredWidth();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            post(runnable);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(getContext());
        int actionBarButtonMaxHeight = this.isAtToolbar ? actionBarPolicy.getActionBarButtonMaxHeight() : actionBarPolicy.getTabContainerHeight();
        if (useCapsuleStyle()) {
            setContentHeight((int) ResourceUtils.dp2px(55.0f, getContext()));
        } else {
            setContentHeight(actionBarButtonMaxHeight);
        }
        this.mStackedTabMaxWidth = actionBarPolicy.getStackedTabMaxWidth();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((TabView) view).getTab().select();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @TargetApi(16)
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        setTabsGravity(this.mTabsGravity);
        int childCount = this.mTabLayout.getChildCount();
        this.mTabLayout.setShowDividers(0);
        if (useCapsuleStyle()) {
            this.mTabLayout.setShowDividers(2);
            int i3 = 20;
            if (this.mTabsGravity != 3) {
                if (childCount == 2) {
                    i3 = 47;
                } else if (childCount == 3) {
                    i3 = 25;
                }
            }
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = this.mTabLayout.getChildAt(i4);
                if (useCapsuleStyle()) {
                    float f = (float) i3;
                    childAt.setPadding((int) ResourceUtils.dp2px(f, getContext()), 0, (int) ResourceUtils.dp2px(f, getContext()), 0);
                }
            }
        }
        if (childCount > 1 && ((mode == 1073741824 || mode == Integer.MIN_VALUE) && !this.isAtToolbar && !useCapsuleStyle())) {
            this.mMinTabWidth = 0;
            if (childCount > 2 && childCount < 5 && this.mIsEqualTabWidth) {
                this.mMinTabWidth = View.MeasureSpec.getSize(i) / childCount;
            } else if (childCount >= 5 && this.mNeedCollapse) {
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt2 = this.mTabLayout.getChildAt(i5);
                    int i6 = this.mTabPaddingOver5;
                    childAt2.setPadding(i6, 0, i6, 0);
                }
                this.mTabLayout.setShowDividers(2);
            } else if (this.mIsAdaptTabWidth) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                int i7 = 0;
                for (int i8 = 0; i8 < childCount; i8++) {
                    View childAt3 = this.mTabLayout.getChildAt(i8);
                    childAt3.measure(makeMeasureSpec, i2);
                    i7 += childAt3.getMeasuredWidth();
                }
                int size = View.MeasureSpec.getSize(i);
                for (int i9 = 0; i9 < childCount; i9++) {
                    View childAt4 = this.mTabLayout.getChildAt(i9);
                    LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt4.getLayoutParams();
                    layoutParams.width = (int) (((float) (childAt4.getMeasuredWidth() * size)) / ((float) i7));
                    layoutParams.weight = 0.0f;
                }
            } else if (childCount == 2) {
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt5 = this.mTabLayout.getChildAt(i10);
                    int i11 = this.mTabPadding2;
                    childAt5.setPadding(i11, 0, i11, 0);
                }
            } else if (childCount == 3) {
                this.mMinTabWidth = this.mTabWidth3;
                setTabsGravityInner(17);
            } else if (childCount == 4) {
                this.mMinTabWidth = this.mTabWidth4;
            } else if (childCount == 5) {
                this.mMinTabWidth = this.mTabWidthNoCollapse5;
                setTabsGravityInner(17);
            }
        }
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
        if (z || !this.mAllowCollapse) {
            performExpand();
        } else {
            this.mTabLayout.measure(0, makeMeasureSpec2);
            if (this.mTabLayout.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                performCollapse();
            } else {
                performExpand();
            }
        }
        getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec2);
        getMeasuredWidth();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void removeAllTabs() {
        this.mTabLayout.removeAllViews();
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void removeTabAt(int i) {
        this.mTabLayout.removeViewAt(i);
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void setAdaptTabWidthNoScroll(boolean z) {
        if (this.mIsAdaptTabWidth != z) {
            this.mIsAdaptTabWidth = z;
            requestLayout();
        }
    }

    public void setAllowCollapse(boolean z) {
        this.mAllowCollapse = z;
    }

    public void setCapsuleStyleEnable(boolean z) {
        this.mIsCapsuleStyle = z;
        if (useCapsuleStyle()) {
            EmptyDivider emptyDivider = new EmptyDivider();
            emptyDivider.setDividerWidth((int) ResourceUtils.dp2px(16.0f, getContext()));
            this.mTabLayout.setDividerDrawable(emptyDivider);
            setContentHeight((int) ResourceUtils.dp2px(55.0f, getContext()));
            SlidingTabStrip slidingTabStrip = this.mTabLayout;
            slidingTabStrip.setPadding(slidingTabStrip.getPaddingLeft(), (int) ResourceUtils.dp2px(8.0f, getContext()), this.mTabLayout.getPaddingRight(), (int) ResourceUtils.dp2px(8.0f, getContext()));
        }
    }

    public void setContentHeight(int i) {
        this.mContentHeight = i;
        requestLayout();
    }

    public void setEqualTabWidth(boolean z) {
        this.mIsEqualTabWidth = z;
    }

    public void setIndicatorDrawable(Drawable drawable) {
        this.mTabLayout.setIndicatorDrawable(drawable);
    }

    public void setIsAloneTabContainer(boolean z) {
        this.mIsAloneTabContainer = z;
    }

    public void setNeedCollapse(boolean z) {
        this.mNeedCollapse = z;
    }

    public void setScrollPosition(int i, float f, boolean z) {
        if (!isAnimationRunning(getAnimation()) && i >= 0 && i < this.mTabLayout.getChildCount()) {
            this.mTabLayout.setIndicatorPositionFromTabPosition(i, f);
            smoothScrollTo(calculateScrollXForTab(i, f), 0);
            if (z && !this.mIsTabClick) {
                setSelectedTabView(Math.round(((float) i) + f));
            }
            if (i == this.mSelectedTabIndex && f <= 0.0f) {
                this.mIsTabClick = false;
            }
        }
    }

    public void setTabSelected(int i) {
        setTabSelected(i, false);
    }

    public void setTabsGravity(int i) {
        this.mTabsGravity = i;
        SlidingTabStrip slidingTabStrip = this.mTabLayout;
        if (slidingTabStrip != null) {
            slidingTabStrip.setGravity(i);
        }
    }

    public void showAtToolbar(boolean z) {
        if (this.isAtToolbar != z) {
            this.isAtToolbar = z;
            ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(getContext());
            setContentHeight(this.isAtToolbar ? actionBarPolicy.getActionBarButtonMaxHeight() : actionBarPolicy.getTabContainerHeight());
            SlidingTabStrip slidingTabStrip = this.mTabLayout;
            if (slidingTabStrip != null) {
                slidingTabStrip.setAtToolbar(this.isAtToolbar);
            }
            SlidingTabStrip slidingTabStrip2 = this.mTabLayout;
            if (slidingTabStrip2 != null && slidingTabStrip2.getChildCount() > 0) {
                int childCount = this.mTabLayout.getChildCount();
                ArrayList arrayList = new ArrayList();
                int i = this.mSelectedTabIndex;
                for (int i2 = 0; i2 < childCount; i2++) {
                    TabView tabView = (TabView) this.mTabLayout.getChildAt(i2);
                    if (tabView.isSelected()) {
                        i = i2;
                    }
                    arrayList.add(tabView.getTab());
                }
                this.mTabLayout.removeAllViews();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ActionBar.Tab tab = (ActionBar.Tab) it.next();
                    addTab(tab, tab.getPosition() == i);
                }
                setTabSelected(i);
            }
        }
    }

    public void updateTab(int i) {
        ((TabView) this.mTabLayout.getChildAt(i)).update();
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public ScrollingTabContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.mzActionBarTabScrollViewStyle);
    }

    public void setTabSelected(int i, boolean z) {
        this.mSelectedTabIndex = i;
        int childCount = this.mTabLayout.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.mTabLayout.getChildAt(i2);
            boolean z2 = i2 == i;
            childAt.setSelected(z2);
            if (z2) {
                if (z) {
                    this.mIsTabClick = true;
                    animateToTab(i);
                } else {
                    this.mIsTabClick = false;
                    this.mTabLayout.animateIndicatorToPosition(i, 0);
                }
            }
            i2++;
        }
        Spinner spinner = this.mTabSpinner;
        if (spinner != null && i >= 0) {
            spinner.setSelection(i);
        }
    }

    public ScrollingTabContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mVisAnimListener = new VisibilityAnimListener();
        this.mMode = 0;
        this.mIsEqualTabWidth = false;
        this.mTabsGravity = 17;
        this.mCustomTabTextColor = 0;
        this.mIsAdaptTabWidth = false;
        this.mIsAloneTabContainer = false;
        setOverScrollMode(2);
        setHorizontalFadingEdgeEnabled(true);
        setFadingEdgeLength(getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_scroll_fading_edge_length));
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.mStackedTabMaxWidth = actionBarPolicy.getStackedTabMaxWidth();
        TintTypedArray v = TintTypedArray.v(context, attributeSet, R.styleable.MzActionBarTabScrollView, i, 0);
        this.mTabPadding2 = v.f(R.styleable.MzActionBarTabScrollView_mzTabScrollView2TabsPadding, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_view_2_tabs_padding));
        this.mTabPaddingOver5 = v.f(R.styleable.MzActionBarTabScrollView_mzTabScrollViewOver5TabsPadding, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_view_over_5_tabs_padding));
        this.mTabWidth3 = v.f(R.styleable.MzActionBarTabScrollView_mzTabScrollView3TabsWidth, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_view_3_tabs_width));
        this.mTabWidth4 = v.f(R.styleable.MzActionBarTabScrollView_mzTabScrollView4TabsWidth, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_view_4_tabs_width));
        this.mTabWidthNoCollapse5 = v.f(R.styleable.MzActionBarTabScrollView_mzTabScrollViewNoCollapse5TabsWidth, getResources().getDimensionPixelSize(R.dimen.mz_action_bar_tab_view_5_tabs_nocollapse_width));
        v.w();
        SlidingTabStrip createTabLayout = createTabLayout();
        this.mTabLayout = createTabLayout;
        addView(createTabLayout, new ViewGroup.LayoutParams(-2, -1));
    }

    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        TabView createTabView = createTabView(tab, false);
        this.mTabLayout.addView(createTabView, i, new LinearLayoutCompat.LayoutParams(-2, -1));
        Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            createTabView.setSelected(true);
            SlidingTabStrip slidingTabStrip = this.mTabLayout;
            slidingTabStrip.setIndicatorPositionFromTabPosition(slidingTabStrip.getChildCount() - 1, 0.0f);
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }
}
