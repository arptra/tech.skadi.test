package flyme.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.meizu.common.util.ResourceUtils;
import flyme.support.v7.app.ActionBar;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.widget.AnimationUtils;
import java.util.ArrayList;

public class AloneTabContainer extends FrameLayout {
    private static final int INVALID_POSITION = -1;
    private boolean mAllowCollapse;
    private TabCollapseButton mCollapseButton;
    /* access modifiers changed from: private */
    public Context mContext;
    private boolean mIsCapsuleStyle;
    protected AnimationUtils.AlphaVisibilityAnimator mScollTabsVisibleAnim;
    private TextView mScrollTabsExpendTitleTextView;
    protected AnimationUtils.AlphaVisibilityAnimator mScrollTabsExpendTitleVisibilityAnim;
    ScrollingTabContainerView mScrollingTabView;
    private ActionBar.Tab mSelectedTab;
    private int mTabMinWidth;
    private int mTabPaddingEnd;
    private int mTabPaddingStart;
    private ArrayList<TabImpl> mTabs;

    public class TabImpl extends ActionBar.Tab {
        private ActionBar.AloneTabListener mCallback;
        private ActionBar.TabListenerSDK mCallbackSDK;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        private boolean mIsEnabled = true;
        private int mMinWidth = -1;
        private int mPaddingEnd = -1;
        private int mPaddingStart = -1;
        private int mPosition = -1;
        private Object mTag;
        private CharSequence mText;
        private ColorStateList mTextColor;

        public TabImpl() {
        }

        public ActionBar.AloneTabListener getAloneTabListenerCallback() {
            return this.mCallback;
        }

        public ActionBar.TabListener getCallback() {
            return null;
        }

        public ActionBar.TabListenerSDK getCallbackSDK() {
            return this.mCallbackSDK;
        }

        public CharSequence getContentDescription() {
            return this.mContentDesc;
        }

        public View getCustomView() {
            return this.mCustomView;
        }

        public Drawable getIcon() {
            return this.mIcon;
        }

        public int getMinWidth() {
            return this.mMinWidth;
        }

        public int getPaddingEnd() {
            return this.mPaddingEnd;
        }

        public int getPaddingStart() {
            return this.mPaddingStart;
        }

        public int getPosition() {
            return this.mPosition;
        }

        public Object getTag() {
            return this.mTag;
        }

        public CharSequence getText() {
            return this.mText;
        }

        public ColorStateList getTextColor() {
            ColorStateList colorStateList = this.mTextColor;
            if (colorStateList != null) {
                return colorStateList;
            }
            return null;
        }

        public boolean isEnabled() {
            return this.mIsEnabled;
        }

        public void select() {
            select(false);
        }

        public ActionBar.Tab setAloneTabListener(ActionBar.AloneTabListener aloneTabListener) {
            this.mCallback = aloneTabListener;
            return this;
        }

        public ActionBar.Tab setContentDescription(int i) {
            return setContentDescription(AloneTabContainer.this.mContext.getResources().getText(i));
        }

        public ActionBar.Tab setCustomView(View view) {
            this.mCustomView = view;
            int i = this.mPosition;
            if (i >= 0) {
                AloneTabContainer.this.mScrollingTabView.updateTab(i);
            }
            return this;
        }

        public ActionBar.Tab setEnabled(boolean z) {
            this.mIsEnabled = z;
            int i = this.mPosition;
            if (i >= 0) {
                AloneTabContainer.this.mScrollingTabView.updateTab(i);
            }
            return this;
        }

        public ActionBar.Tab setIcon(Drawable drawable) {
            this.mIcon = drawable;
            int i = this.mPosition;
            if (i >= 0) {
                AloneTabContainer.this.mScrollingTabView.updateTab(i);
            }
            return this;
        }

        public void setMinWidth(int i) {
            if (this.mMinWidth != i) {
                this.mMinWidth = i;
                int i2 = this.mPosition;
                if (i2 >= 0) {
                    AloneTabContainer.this.mScrollingTabView.updateTab(i2);
                }
            }
        }

        public void setPadding(int i, int i2) {
            if (this.mPaddingStart != i || this.mPaddingEnd != i2) {
                this.mPaddingStart = i;
                this.mPaddingEnd = i2;
                int i3 = this.mPosition;
                if (i3 >= 0) {
                    AloneTabContainer.this.mScrollingTabView.updateTab(i3);
                }
            }
        }

        public void setPosition(int i) {
            this.mPosition = i;
        }

        public ActionBar.Tab setTabListener(ActionBar.TabListener tabListener) {
            return this;
        }

        public ActionBar.Tab setTabListenerSDK(ActionBar.TabListenerSDK tabListenerSDK) {
            this.mCallbackSDK = tabListenerSDK;
            return this;
        }

        public ActionBar.Tab setTag(Object obj) {
            this.mTag = obj;
            return this;
        }

        public ActionBar.Tab setText(CharSequence charSequence) {
            this.mText = charSequence;
            int i = this.mPosition;
            if (i >= 0) {
                AloneTabContainer.this.mScrollingTabView.updateTab(i);
            }
            return this;
        }

        public ActionBar.Tab setTextColor(ColorStateList colorStateList) {
            this.mTextColor = colorStateList;
            int i = this.mPosition;
            if (i >= 0) {
                AloneTabContainer.this.mScrollingTabView.updateTab(i);
            }
            return this;
        }

        public void select(boolean z) {
            AloneTabContainer.this.selectTab(this, z);
        }

        public ActionBar.Tab setContentDescription(CharSequence charSequence) {
            this.mContentDesc = charSequence;
            int i = this.mPosition;
            if (i >= 0) {
                AloneTabContainer.this.mScrollingTabView.updateTab(i);
            }
            return this;
        }

        public ActionBar.Tab setCustomView(int i) {
            return setCustomView(LayoutInflater.from(AloneTabContainer.this.mContext).inflate(i, (ViewGroup) null));
        }

        @SuppressLint({"RestrictedApi"})
        public ActionBar.Tab setIcon(int i) {
            return setIcon(AppCompatDrawableManager.b().c(AloneTabContainer.this.mContext, i));
        }

        public ActionBar.Tab setText(int i) {
            return setText(AloneTabContainer.this.mContext.getResources().getText(i));
        }
    }

    public AloneTabContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    private void cleanupTabs() {
        if (this.mSelectedTab != null) {
            selectTab((ActionBar.Tab) null);
        }
        this.mTabs.clear();
        ScrollingTabContainerView scrollingTabContainerView = this.mScrollingTabView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.removeAllTabs();
        }
    }

    private void configureTab(ActionBar.Tab tab, int i) {
        TabImpl tabImpl = (TabImpl) tab;
        ActionBar.AloneTabListener aloneTabListenerCallback = tabImpl.getAloneTabListenerCallback();
        ActionBar.TabListenerSDK callbackSDK = tabImpl.getCallbackSDK();
        if (aloneTabListenerCallback == null && callbackSDK == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        tabImpl.setPosition(i);
        this.mTabs.add(i, tabImpl);
        int size = this.mTabs.size();
        while (true) {
            i++;
            if (i < size) {
                this.mTabs.get(i).setPosition(i);
            } else {
                return;
            }
        }
    }

    private void hideCollapse() {
        TabCollapseButton tabCollapseButton = this.mCollapseButton;
        if (tabCollapseButton != null) {
            tabCollapseButton.setVisibility(8);
        }
        post(new Runnable() {
            public void run() {
                AloneTabContainer aloneTabContainer = AloneTabContainer.this;
                aloneTabContainer.setPadding((int) ResourceUtils.dp2px(15.0f, aloneTabContainer.getContext()), 0, (int) ResourceUtils.dp2px(15.0f, AloneTabContainer.this.getContext()), 0);
            }
        });
    }

    private void initCollapseButton() {
        TabCollapseButton tabCollapseButton = new TabCollapseButton(this.mContext);
        this.mCollapseButton = tabCollapseButton;
        tabCollapseButton.setImageDrawable(getContext().getDrawable(R.drawable.mz_titlebar_ic_tab_unfold_capstyle));
        this.mCollapseButton.setPadding((int) ResourceUtils.dp2px(16.0f, getContext()), 0, (int) ResourceUtils.dp2px(16.0f, getContext()), 0);
        this.mCollapseButton.setScaleType(ImageView.ScaleType.CENTER);
    }

    private void initScrollTabsExpendTitleTextView() {
        TextView textView = new TextView(getContext());
        this.mScrollTabsExpendTitleTextView = textView;
        textView.setSingleLine();
        this.mScrollTabsExpendTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.mScrollTabsExpendTitleTextView.setMaxWidth(getContext().getResources().getDimensionPixelSize(R.dimen.mz_toolbar_title_max_width));
        addView(this.mScrollTabsExpendTitleTextView);
        this.mScrollTabsExpendTitleTextView.setVisibility(8);
        this.mScrollTabsExpendTitleTextView.setTextAppearance(getContext(), R.style.TextAppearance_Flyme_AppCompat_Widget_ActionBar_TabScrollView_ExpendTitle);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mz_scroll_tabs_expend_title_padding_vertical);
        this.mScrollTabsExpendTitleTextView.setPadding(getResources().getDimensionPixelSize(R.dimen.mz_scroll_tabs_expend_title_margin_left), dimensionPixelSize, 0, dimensionPixelSize);
        this.mScrollTabsExpendTitleTextView.setGravity(16);
    }

    private void setTabView(ScrollingTabContainerView scrollingTabContainerView) {
        ScrollingTabContainerView scrollingTabContainerView2 = this.mScrollingTabView;
        if (scrollingTabContainerView2 != scrollingTabContainerView || scrollingTabContainerView2.getParent() != this) {
            ScrollingTabContainerView scrollingTabContainerView3 = this.mScrollingTabView;
            if (scrollingTabContainerView3 != null) {
                removeView(scrollingTabContainerView3);
            }
            this.mScrollingTabView = scrollingTabContainerView;
            if (scrollingTabContainerView != null) {
                scrollingTabContainerView.setIsAloneTabContainer(true);
                addView(scrollingTabContainerView, new LinearLayout.LayoutParams(-1, -1));
            }
        }
    }

    private void setupTabStyle(ActionBar.Tab tab) {
        tab.setMinWidth(this.mTabMinWidth);
        tab.setPadding(this.mTabPaddingStart, this.mTabPaddingEnd);
    }

    private void showCollapse() {
        if (this.mCollapseButton.getParent() != this) {
            addView(this.mCollapseButton);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCollapseButton.getLayoutParams();
            layoutParams.width = (int) ResourceUtils.dp2px(64.0f, getContext());
            layoutParams.height = -1;
        }
        this.mCollapseButton.setVisibility(0);
        post(new Runnable() {
            public void run() {
                AloneTabContainer aloneTabContainer = AloneTabContainer.this;
                aloneTabContainer.setPadding((int) ResourceUtils.dp2px(15.0f, aloneTabContainer.getContext()), 0, 0, 0);
            }
        });
    }

    public void addTab(ActionBar.Tab tab) {
        addTab(tab, this.mTabs.isEmpty());
    }

    public void customTabTextColor(@ColorInt int i) {
        this.mScrollingTabView.customTabTextColor(i);
    }

    public ActionBar.Tab getTabAt(int i) {
        return this.mTabs.get(i);
    }

    public TabCollapseButton getTabCollapseButton() {
        return this.mCollapseButton;
    }

    public int getTabsCount() {
        return this.mTabs.size();
    }

    public ActionBar.Tab newTab() {
        return new TabImpl();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mCollapseButton.layout(this.mScrollingTabView.getMeasuredWidth() + getPaddingLeft(), 0, getMeasuredWidth(), this.mCollapseButton.getMeasuredHeight());
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mAllowCollapse) {
            showCollapse();
            this.mCollapseButton.measure(View.MeasureSpec.makeMeasureSpec((int) ResourceUtils.dp2px(64.0f, getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mScrollingTabView.getMeasuredHeight(), 1073741824));
            this.mScrollingTabView.measure(View.MeasureSpec.makeMeasureSpec((int) (((float) ((getMeasuredWidth() - getPaddingRight()) - getPaddingLeft())) - ResourceUtils.dp2px(64.0f, getContext())), 1073741824), i2);
            return;
        }
        hideCollapse();
    }

    public void removeAllTabs() {
        cleanupTabs();
    }

    public void removeTab(ActionBar.Tab tab) {
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int i) {
        if (this.mScrollingTabView != null) {
            ActionBar.Tab tab = this.mSelectedTab;
            int position = tab != null ? tab.getPosition() : -1;
            this.mScrollingTabView.removeTabAt(i);
            TabImpl remove = this.mTabs.remove(i);
            if (remove != null) {
                remove.setPosition(-1);
            }
            int size = this.mTabs.size();
            for (int i2 = i; i2 < size; i2++) {
                this.mTabs.get(i2).setPosition(i2);
            }
            if (position == i) {
                selectTab(this.mTabs.isEmpty() ? null : this.mTabs.get(Math.max(0, i - 1)));
            }
        }
    }

    public void selectTab(ActionBar.Tab tab) {
        selectTab(tab, false);
    }

    public void setAllowCollapse(boolean z) {
        if (this.mAllowCollapse != z) {
            this.mAllowCollapse = z;
            requestLayout();
        }
    }

    public void setCapsuleStyleEnable(boolean z) {
        this.mIsCapsuleStyle = z;
        this.mScrollingTabView.setCapsuleStyleEnable(z);
    }

    public void setIndicatorDrawable(Drawable drawable) {
        ScrollingTabContainerView scrollingTabContainerView = this.mScrollingTabView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.setIndicatorDrawable(drawable);
        }
    }

    public void setIsEmbeddedTabs(boolean z) {
        this.mScrollingTabView.showAtToolbar(z);
    }

    public void setScrollTabsExpendTitle(CharSequence charSequence) {
        this.mScrollTabsExpendTitleTextView.setText(charSequence);
    }

    public void setTabScrolled(int i, float f, int i2) {
        ScrollingTabContainerView scrollingTabContainerView = this.mScrollingTabView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.setScrollPosition(i, f, true);
        }
    }

    public void setTabsGravity(int i) {
        ScrollingTabContainerView scrollingTabContainerView = this.mScrollingTabView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.setTabsGravity(i);
        }
    }

    public void setupScrollTabsAnimatorToVisibility(int i) {
        AnimationUtils.AlphaVisibilityAnimator alphaVisibilityAnimator = this.mScollTabsVisibleAnim;
        if (alphaVisibilityAnimator != null) {
            alphaVisibilityAnimator.cancel();
        }
        ScrollingTabContainerView scrollingTabContainerView = this.mScrollingTabView;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = null;
        if (scrollingTabContainerView != null) {
            AnimationUtils.AlphaVisibilityAnimator alphaVisibilityAnimator2 = new AnimationUtils.AlphaVisibilityAnimator(scrollingTabContainerView, i);
            this.mScollTabsVisibleAnim = alphaVisibilityAnimator2;
            alphaVisibilityAnimator2.setDuration(100);
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

    public AloneTabContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void addTab(ActionBar.Tab tab, int i) {
        addTab(tab, i, this.mTabs.isEmpty());
    }

    public void selectTab(ActionBar.Tab tab, boolean z) {
        ActionBar.Tab tab2 = this.mSelectedTab;
        if (tab2 != tab) {
            this.mScrollingTabView.setTabSelected(tab != null ? tab.getPosition() : -1, z);
            ActionBar.Tab tab3 = this.mSelectedTab;
            if (!(tab3 == null || tab3.getAloneTabListenerCallback() == null)) {
                this.mSelectedTab.getAloneTabListenerCallback().onTabUnselected(this.mSelectedTab);
            }
            this.mSelectedTab = tab;
            if (tab != null && tab.getAloneTabListenerCallback() != null) {
                this.mSelectedTab.getAloneTabListenerCallback().onTabSelected(this.mSelectedTab);
            }
        } else if (tab2 != null) {
            if (tab2.getAloneTabListenerCallback() != null) {
                this.mSelectedTab.getAloneTabListenerCallback().onTabReselected(this.mSelectedTab);
            }
            if (z) {
                this.mScrollingTabView.animateToTab(tab.getPosition());
            }
        }
    }

    public AloneTabContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTabs = new ArrayList<>();
        this.mTabPaddingStart = -1;
        this.mTabPaddingEnd = -1;
        this.mTabMinWidth = -1;
        this.mContext = context;
        setTabView(new ScrollingTabContainerView(context));
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mz_action_tab_bar_margin_left);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        initCollapseButton();
        initScrollTabsExpendTitleTextView();
    }

    public void addTab(ActionBar.Tab tab, boolean z) {
        setupTabStyle(tab);
        this.mScrollingTabView.addTab(tab, z);
        configureTab(tab, this.mTabs.size());
        if (z) {
            selectTab(tab);
        }
    }

    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        setupTabStyle(tab);
        this.mScrollingTabView.addTab(tab, i, z);
        configureTab(tab, i);
        if (z) {
            selectTab(tab);
        }
    }
}
