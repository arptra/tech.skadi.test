package flyme.support.v7.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SpinnerAdapter;
import androidx.annotation.ColorInt;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.fragment.app.FragmentActivity;
import com.meizu.common.util.CommonUtils;
import flyme.support.v7.app.ActionBar;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.view.ActionBarPolicy;
import flyme.support.v7.view.ActionMode;
import flyme.support.v7.view.SupportMenuInflater;
import flyme.support.v7.view.menu.MenuBuilder;
import flyme.support.v7.view.menu.MenuPopupHelper;
import flyme.support.v7.view.menu.SubMenuBuilder;
import flyme.support.v7.widget.ActionBarContainer;
import flyme.support.v7.widget.ActionBarContextView;
import flyme.support.v7.widget.ActionBarCoordinatorLayout;
import flyme.support.v7.widget.ActionBarDropDownView;
import flyme.support.v7.widget.AloneTabContainer;
import flyme.support.v7.widget.CollapsingToolbarLayoutWrapper;
import flyme.support.v7.widget.DecorToolbar;
import flyme.support.v7.widget.MzActionBarTabContainer;
import flyme.support.v7.widget.MzAppBarLayout;
import flyme.support.v7.widget.MzCollapsingToolbarLayout;
import flyme.support.v7.widget.ScrollingTabContainerView;
import flyme.support.v7.widget.TabCollapseButton;
import flyme.support.v7.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@SuppressLint({"RestrictedApi"})
public class NestedScrollActionbar extends ActionBar {
    private static final boolean ALLOW_SHOW_HIDE_ANIMATIONS = true;
    public static final long FADE_IN_DURATION_MS = 200;
    public static final long FADE_OUT_DURATION_MS = 100;
    private static final int INVALID_POSITION = -1;
    private static final String TAG = "WindowDecorActionBar";
    /* access modifiers changed from: private */
    public ActionBarCoordinatorLayout mActionBarCoordinatorLayout;
    private FrameLayout mActionBarSpringLayoutMiddle;
    private FrameLayout mActionBarSpringLayoutQuick;
    ActionModeImpl mActionMode;
    private Activity mActivity;
    private AloneTabContainer mAloneTabContainer;
    /* access modifiers changed from: private */
    public boolean mContentAnimations = true;
    /* access modifiers changed from: private */
    public View mContentView;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public ActionBarContextView mContextView;
    private int mCurWindowVisibility = 0;
    /* access modifiers changed from: private */
    public ViewPropertyAnimatorCompatSet mCurrentShowAnim;
    /* access modifiers changed from: private */
    public DecorToolbar mDecorToolbar;
    ActionMode mDeferredDestroyActionMode;
    ActionMode.Callback mDeferredModeDestroyCallback;
    private boolean mDisplayHomeAsUpSet;
    ActionBar.DropDownCallback mDropDownCallback;
    private ActionBarDropDownView mDropDownView;
    /* access modifiers changed from: private */
    public boolean mDropDownViewShowing = false;
    private int mDuration = 288;
    private boolean mHasEmbeddedTabs;
    /* access modifiers changed from: private */
    public boolean mHiddenByApp;
    /* access modifiers changed from: private */
    public boolean mHiddenBySystem;
    final ViewPropertyAnimatorListener mHideListener = new ViewPropertyAnimatorListenerAdapter() {
        public void onAnimationEnd(View view) {
            if (NestedScrollActionbar.this.mContentAnimations && NestedScrollActionbar.this.mContentView != null) {
                ViewCompat.Z0(NestedScrollActionbar.this.mContentView, 0.0f);
                ViewCompat.Z0(NestedScrollActionbar.this.mToolbarContainerView, 0.0f);
            }
            if (NestedScrollActionbar.this.mSplitView != null) {
                NestedScrollActionbar.this.mSplitView.setVisibility(8);
            }
            NestedScrollActionbar.this.mMzAppBarLayout.setVisibility(8);
            NestedScrollActionbar.this.mMzAppBarLayout.setTransitioning(false);
            ViewPropertyAnimatorCompatSet unused = NestedScrollActionbar.this.mCurrentShowAnim = null;
            boolean unused2 = NestedScrollActionbar.this.mIsSplitActionBarShow = false;
            NestedScrollActionbar.this.completeDeferredDestroyActionMode();
            if (NestedScrollActionbar.this.mActionBarCoordinatorLayout != null) {
                ViewCompat.q0(NestedScrollActionbar.this.mActionBarCoordinatorLayout);
            }
        }
    };
    final ViewPropertyAnimatorListener mHideSplitActionBarListener = new ViewPropertyAnimatorListenerAdapter() {
        public void onAnimationEnd(View view) {
            if (NestedScrollActionbar.this.mSplitView != null) {
                NestedScrollActionbar.this.mSplitView.setVisibility(8);
            }
            boolean unused = NestedScrollActionbar.this.mIsSplitActionBarShow = false;
            ViewPropertyAnimatorCompatSet unused2 = NestedScrollActionbar.this.mCurrentShowAnim = null;
        }
    };
    private boolean mIsSetScrollTabsExpendView = false;
    /* access modifiers changed from: private */
    public boolean mIsSplitActionBarShow;
    private boolean mLastMenuVisibility;
    private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList<>();
    /* access modifiers changed from: private */
    public MzAppBarLayout mMzAppBarLayout;
    private boolean mNowShowing = true;
    TabCollapseButton.OnTabCollapseButtonClickListener mOnTabCollapseButtonClickListener;
    private int mSavedTabPosition = -1;
    private String mScrollTabsExpendTitle;
    private TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    final ViewPropertyAnimatorListener mShowListener = new ViewPropertyAnimatorListenerAdapter() {
        public void onAnimationEnd(View view) {
            ViewPropertyAnimatorCompatSet unused = NestedScrollActionbar.this.mCurrentShowAnim = null;
            boolean unused2 = NestedScrollActionbar.this.mIsSplitActionBarShow = true;
            ViewCompat.Z0(NestedScrollActionbar.this.mMzAppBarLayout, 0.0f);
            if (NestedScrollActionbar.this.mSplitView != null) {
                ViewCompat.Z0(NestedScrollActionbar.this.mSplitView, 0.0f);
            }
            NestedScrollActionbar.this.mMzAppBarLayout.requestLayout();
        }
    };
    final ViewPropertyAnimatorListener mShowSplitActionBarListener = new ViewPropertyAnimatorListenerAdapter() {
        public void onAnimationEnd(View view) {
            if (NestedScrollActionbar.this.mSplitView != null) {
                ViewCompat.Z0(NestedScrollActionbar.this.mSplitView, 0.0f);
                boolean unused = NestedScrollActionbar.this.mIsSplitActionBarShow = true;
            }
            ViewPropertyAnimatorCompatSet unused2 = NestedScrollActionbar.this.mCurrentShowAnim = null;
        }
    };
    private boolean mShowingForMode;
    /* access modifiers changed from: private */
    public ActionBarContainer mSplitView;
    private boolean mStackedTabsCanBeEmbedded = true;
    /* access modifiers changed from: private */
    public TabCollapseButton mTabCollapseButton;
    private int mTabMinWidth = -1;
    private int mTabPaddingEnd = -1;
    private int mTabPaddingStart = -1;
    /* access modifiers changed from: private */
    public ScrollingTabContainerView mTabScrollView;
    private ArrayList<TabImpl> mTabs = new ArrayList<>();
    private int mTabsGravity;
    private boolean mTabsGravitySet;
    private Context mThemedContext;
    /* access modifiers changed from: private */
    public MzCollapsingToolbarLayout mToolbarContainerView;
    final ViewPropertyAnimatorUpdateListener mUpdateListener = new ViewPropertyAnimatorUpdateListener() {
        public void onAnimationUpdate(View view) {
            ((View) NestedScrollActionbar.this.mToolbarContainerView.getParent()).invalidate();
        }
    };
    private boolean mforceShowTab;

    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private final Context mActionModeContext;
        private ActionMode.BackPressedListener mBackPressedListener = new ActionMode.BackPressedListener() {
            public boolean onBackPressed() {
                return true;
            }
        };
        private ActionMode.Callback mCallback;
        private WeakReference<View> mCustomView;
        private boolean mIsMultiChoiceMode;
        private boolean mIsShowActionBar = true;
        private final MenuBuilder mMenu;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.mActionModeContext = context;
            this.mCallback = callback;
            MenuBuilder defaultShowAsAction = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.mMenu = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
            setBackPressListener(this.mBackPressedListener);
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                return this.mCallback.onCreateActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        public void finish() {
            NestedScrollActionbar nestedScrollActionbar = NestedScrollActionbar.this;
            if (nestedScrollActionbar.mActionMode == this) {
                if (NestedScrollActionbar.checkShowingFlags(nestedScrollActionbar.mHiddenByApp, NestedScrollActionbar.this.mHiddenBySystem, false) || !isShowActionBar()) {
                    this.mCallback.onDestroyActionMode(this);
                } else {
                    NestedScrollActionbar nestedScrollActionbar2 = NestedScrollActionbar.this;
                    nestedScrollActionbar2.mDeferredDestroyActionMode = this;
                    nestedScrollActionbar2.mDeferredModeDestroyCallback = this.mCallback;
                }
                this.mCallback = null;
                NestedScrollActionbar.this.animateToMode(false);
                NestedScrollActionbar.this.mContextView.closeMode();
                NestedScrollActionbar.this.mToolbarContainerView.closeMode();
                NestedScrollActionbar.this.mDecorToolbar.getViewGroup().sendAccessibilityEvent(32);
                NestedScrollActionbar.this.mActionMode = null;
            }
        }

        public View getCustomView() {
            WeakReference<View> weakReference = this.mCustomView;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        public Menu getMenu() {
            return this.mMenu;
        }

        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.mActionModeContext);
        }

        public CharSequence getSubtitle() {
            return NestedScrollActionbar.this.mContextView.getSubtitle();
        }

        public CharSequence getTitle() {
            return NestedScrollActionbar.this.mContextView.getTitle();
        }

        public void invalidate() {
            if (NestedScrollActionbar.this.mActionMode == this) {
                this.mMenu.stopDispatchingItemsChanged();
                try {
                    this.mCallback.onPrepareActionMode(this, this.mMenu);
                } finally {
                    this.mMenu.startDispatchingItemsChanged();
                }
            }
        }

        public boolean isShowActionBar() {
            return this.mIsShowActionBar;
        }

        public boolean isTitleOptional() {
            return NestedScrollActionbar.this.mContextView.isTitleOptional();
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            ActionMode.Callback callback = this.mCallback;
            if (callback != null) {
                return callback.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.mCallback != null) {
                invalidate();
                NestedScrollActionbar.this.mContextView.showOverflowMenu();
            }
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            if (this.mCallback == null) {
                return false;
            }
            if (!subMenuBuilder.hasVisibleItems()) {
                return true;
            }
            new MenuPopupHelper(NestedScrollActionbar.this.getThemedContext(), subMenuBuilder).show();
            return true;
        }

        public void setCustomView(View view) {
            NestedScrollActionbar.this.mContextView.setCustomView(view);
            this.mCustomView = new WeakReference<>(view);
        }

        public void setIsMultiChoiceMode(boolean z) {
            this.mIsMultiChoiceMode = z;
        }

        public void setShowActionBar(boolean z) {
            this.mIsShowActionBar = z;
        }

        public void setSubtitle(CharSequence charSequence) {
            NestedScrollActionbar.this.mContextView.setSubtitle(charSequence);
        }

        public void setTitle(CharSequence charSequence) {
            NestedScrollActionbar.this.mContextView.setTitle(charSequence);
        }

        public void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            NestedScrollActionbar.this.mContextView.setTitleOptional(z);
        }

        public void setSubtitle(int i) {
            setSubtitle((CharSequence) NestedScrollActionbar.this.mContext.getResources().getString(i));
        }

        public void setTitle(int i) {
            setTitle((CharSequence) NestedScrollActionbar.this.mContext.getResources().getString(i));
        }
    }

    public class TabImpl extends ActionBar.Tab {
        private ActionBar.TabListener mCallback;
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

        public ActionBar.TabListener getCallback() {
            return this.mCallback;
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

        public ActionBar.Tab setContentDescription(int i) {
            return setContentDescription(NestedScrollActionbar.this.mContext.getResources().getText(i));
        }

        public ActionBar.Tab setCustomView(View view) {
            this.mCustomView = view;
            if (this.mPosition >= 0) {
                NestedScrollActionbar.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public ActionBar.Tab setEnabled(boolean z) {
            this.mIsEnabled = z;
            if (this.mPosition >= 0) {
                NestedScrollActionbar.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public ActionBar.Tab setIcon(Drawable drawable) {
            this.mIcon = drawable;
            if (this.mPosition >= 0) {
                NestedScrollActionbar.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public void setMinWidth(int i) {
            if (this.mMinWidth != i) {
                this.mMinWidth = i;
                if (this.mPosition >= 0) {
                    NestedScrollActionbar.this.mTabScrollView.updateTab(this.mPosition);
                }
            }
        }

        public void setPadding(int i, int i2) {
            if (this.mPaddingStart != i || this.mPaddingEnd != i2) {
                this.mPaddingStart = i;
                this.mPaddingEnd = i2;
                if (this.mPosition >= 0) {
                    NestedScrollActionbar.this.mTabScrollView.updateTab(this.mPosition);
                }
            }
        }

        public void setPosition(int i) {
            this.mPosition = i;
        }

        public ActionBar.Tab setTabListener(ActionBar.TabListener tabListener) {
            this.mCallback = tabListener;
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
            if (this.mPosition >= 0) {
                NestedScrollActionbar.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public ActionBar.Tab setTextColor(ColorStateList colorStateList) {
            this.mTextColor = colorStateList;
            if (this.mPosition >= 0) {
                NestedScrollActionbar.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public void select(boolean z) {
            NestedScrollActionbar.this.selectTab(this, z);
        }

        public ActionBar.Tab setContentDescription(CharSequence charSequence) {
            this.mContentDesc = charSequence;
            if (this.mPosition >= 0) {
                NestedScrollActionbar.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public ActionBar.Tab setCustomView(int i) {
            return setCustomView(LayoutInflater.from(NestedScrollActionbar.this.getThemedContext()).inflate(i, (ViewGroup) null));
        }

        public ActionBar.Tab setIcon(int i) {
            return setIcon(AppCompatDrawableManager.b().c(NestedScrollActionbar.this.mContext, i));
        }

        public ActionBar.Tab setText(int i) {
            return setText(NestedScrollActionbar.this.mContext.getResources().getText(i));
        }
    }

    public NestedScrollActionbar(Activity activity) {
        this.mActivity = activity;
        init(activity.getWindow().getDecorView());
    }

    private void animateToTabs(boolean z) {
        if (this.mDecorToolbar.getNavigationMode() == 2 && this.mTabScrollView != null) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = z ? this.mMzAppBarLayout.setupTabsAnimatorToVisibility(0, 200) : this.mMzAppBarLayout.setupTabsAnimatorToVisibility(8, 200);
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.o();
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean checkShowingFlags(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return !z && !z2;
    }

    private void cleanupTabs() {
        if (this.mSelectedTab != null) {
            selectTab((ActionBar.Tab) null);
        }
        this.mTabs.clear();
        ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.removeAllTabs();
        }
        this.mSavedTabPosition = -1;
    }

    private void configureTab(ActionBar.Tab tab, int i) {
        TabImpl tabImpl = (TabImpl) tab;
        ActionBar.TabListener callback = tabImpl.getCallback();
        ActionBar.TabListenerSDK callbackSDK = tabImpl.getCallbackSDK();
        if (callback == null && callbackSDK == null) {
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

    private void doHideSplitActionBar() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
        }
        if (this.mCurWindowVisibility != 0 || !ALLOW_SHOW_HIDE_ANIMATIONS || !this.mShowHideAnimationEnabled) {
            this.mHideSplitActionBarListener.onAnimationEnd((View) null);
            return;
        }
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
        ActionBarContainer actionBarContainer = this.mSplitView;
        if (actionBarContainer != null && actionBarContainer.getVisibility() == 0 && this.mIsSplitActionBarShow) {
            ViewCompat.y0(this.mSplitView, 1.0f);
            viewPropertyAnimatorCompatSet2.c(ViewCompat.e(this.mSplitView).q((float) this.mSplitView.getHeight()).n(this.mUpdateListener));
        }
        viewPropertyAnimatorCompatSet2.f(PathInterpolatorCompat.a(0.29f, 0.5f, 0.16f, 1.0f));
        viewPropertyAnimatorCompatSet2.e((long) this.mDuration);
        viewPropertyAnimatorCompatSet2.g(this.mHideSplitActionBarListener);
        this.mCurrentShowAnim = viewPropertyAnimatorCompatSet2;
        viewPropertyAnimatorCompatSet2.h();
    }

    private void doShowSplitActionBar() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
        }
        if (this.mCurWindowVisibility != 0 || !ALLOW_SHOW_HIDE_ANIMATIONS || !this.mShowHideAnimationEnabled) {
            ActionBarContainer actionBarContainer = this.mSplitView;
            if (actionBarContainer != null) {
                ViewCompat.y0(actionBarContainer, 1.0f);
                ViewCompat.Z0(this.mSplitView, 0.0f);
                this.mSplitView.setVisibility(0);
            }
            this.mShowSplitActionBarListener.onAnimationEnd((View) null);
            return;
        }
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
        ActionBarContainer actionBarContainer2 = this.mSplitView;
        if (actionBarContainer2 != null && !this.mIsSplitActionBarShow) {
            ViewCompat.Z0(actionBarContainer2, (float) actionBarContainer2.getMeasuredHeight());
            this.mSplitView.setVisibility(0);
            viewPropertyAnimatorCompatSet2.c(ViewCompat.e(this.mSplitView).q(0.0f).n(this.mUpdateListener));
        }
        viewPropertyAnimatorCompatSet2.f(PathInterpolatorCompat.a(0.2f, 0.5f, 0.05f, 1.0f));
        viewPropertyAnimatorCompatSet2.e((long) this.mDuration);
        viewPropertyAnimatorCompatSet2.g(this.mShowSplitActionBarListener);
        this.mCurrentShowAnim = viewPropertyAnimatorCompatSet2;
        viewPropertyAnimatorCompatSet2.h();
    }

    private void ensureDropDownView() {
        if (this.mDropDownView == null) {
            this.mActionBarCoordinatorLayout.setupActionBarDropDownView();
            this.mDropDownView = this.mActionBarCoordinatorLayout.getActionBarDropDownView();
        }
    }

    private void ensureTabsExist() {
        if (this.mTabScrollView == null) {
            ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.mContext);
            scrollingTabContainerView.setId(R.id.mz_action_bar_tab_scroll_view);
            scrollingTabContainerView.setVisibility(0);
            this.mDecorToolbar.setEmbeddedTabView(scrollingTabContainerView);
            this.mTabScrollView = scrollingTabContainerView;
            scrollingTabContainerView.setVisibility(0);
            if (getNavigationMode() == 2) {
                scrollingTabContainerView.setVisibility(0);
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
            if (this.mTabsGravitySet) {
                scrollingTabContainerView.setTabsGravity(this.mTabsGravity);
            }
        }
    }

    private DecorToolbar getDecorToolbar(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view);
        throw new IllegalStateException(sb.toString() != null ? view.getClass().getSimpleName() : "null");
    }

    private void hideForActionMode() {
        if (this.mShowingForMode) {
            this.mShowingForMode = false;
            ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.mActionBarCoordinatorLayout;
            if (actionBarCoordinatorLayout != null) {
                actionBarCoordinatorLayout.setShowingForActionMode(false);
            }
            updateVisibility(false);
        }
    }

    private void init(View view) {
        this.mActionBarCoordinatorLayout = (ActionBarCoordinatorLayout) view.findViewById(R.id.decor_content_parent);
        this.mContextView = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        this.mToolbarContainerView = (MzCollapsingToolbarLayout) view.findViewById(R.id.action_bar_container);
        this.mMzAppBarLayout = (MzAppBarLayout) view.findViewById(R.id.app_bar_layout);
        this.mActionBarSpringLayoutMiddle = (FrameLayout) view.findViewById(R.id.action_bar_spring_layout_middle);
        this.mActionBarSpringLayoutQuick = (FrameLayout) view.findViewById(R.id.action_bar_spring_layout_quick);
        this.mSplitView = (ActionBarContainer) view.findViewById(R.id.split_action_bar);
        CollapsingToolbarLayoutWrapper wrapper = this.mToolbarContainerView.getWrapper(getDecorToolbar(view.findViewById(R.id.action_bar)));
        this.mDecorToolbar = wrapper;
        if (wrapper == null || this.mContextView == null || this.mToolbarContainerView == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        wrapper.setControlTitleBarCallback(new ActionBar.ControlTitleBarCallback() {
            public void onCreateControlButton(int i, ActionBar.ControlButton controlButton) {
                NestedScrollActionbar.this.setControlButton(i, controlButton);
            }
        });
        this.mContext = this.mDecorToolbar.getContext();
        int displayOptions = this.mDecorToolbar.getDisplayOptions();
        boolean z = true;
        boolean z2 = (displayOptions & 4) != 0;
        if (z2) {
            this.mDisplayHomeAsUpSet = true;
        }
        setHomeButtonEnabled(ActionBarPolicy.get(this.mContext).enableHomeButtonByDefault() || z2);
        if ((displayOptions & 32) == 0) {
            z = false;
        }
        this.mforceShowTab = z;
        if ((displayOptions & 8) == 0 || !z) {
            setHasEmbeddedTabs(z);
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes((AttributeSet) null, androidx.appcompat.R.styleable.ActionBar, CommonUtils.hasFullDisplay() ? R.attr.mzActionBarStyleFullScreen : androidx.appcompat.R.attr.actionBarStyle, 0);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.ActionBar_elevation, 0);
            if (dimensionPixelSize != 0) {
                setElevation((float) dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            this.mIsSplitActionBarShow = isShowing();
            return;
        }
        throw new IllegalStateException("nested scroll actionbar can't display title and tabs in the same time");
    }

    private void setHasEmbeddedTabs(boolean z) {
        this.mHasEmbeddedTabs = z;
        if (!z) {
            this.mDecorToolbar.setEmbeddedTabView((ScrollingTabContainerView) null);
        } else {
            this.mDecorToolbar.setEmbeddedTabView(this.mTabScrollView);
        }
        boolean z2 = true;
        boolean z3 = getNavigationMode() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
        if (scrollingTabContainerView != null) {
            if (z3) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.mActionBarCoordinatorLayout;
                if (actionBarCoordinatorLayout != null) {
                    ViewCompat.q0(actionBarCoordinatorLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (this.mHasEmbeddedTabs || !z3) {
            z2 = false;
        }
        decorToolbar.setCollapsible(z2);
    }

    private void setupTabStyle(ActionBar.Tab tab) {
        tab.setMinWidth(this.mTabMinWidth);
        tab.setPadding(this.mTabPaddingStart, this.mTabPaddingEnd);
    }

    private void showForActionMode() {
        if (!this.mShowingForMode) {
            this.mShowingForMode = true;
            ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.mActionBarCoordinatorLayout;
            if (actionBarCoordinatorLayout != null) {
                actionBarCoordinatorLayout.setShowingForActionMode(true);
            }
            updateVisibility(false);
        }
    }

    private void updateVisibility(boolean z) {
        if (checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode)) {
            if (!this.mNowShowing) {
                this.mNowShowing = true;
                doShow(z);
            }
        } else if (this.mNowShowing) {
            this.mNowShowing = false;
            doHide(z);
        }
    }

    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.add(onMenuVisibilityListener);
    }

    public void addTab(ActionBar.Tab tab) {
        addTab(tab, this.mTabs.isEmpty());
    }

    public void animateToMode(boolean z) {
        animateToMode(z, (ActionModeImpl) null);
    }

    public boolean collapseActionView() {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (decorToolbar == null || !decorToolbar.hasExpandedActionView()) {
            return false;
        }
        this.mDecorToolbar.collapseActionView();
        return true;
    }

    public void completeDeferredDestroyActionMode() {
        ActionMode.Callback callback = this.mDeferredModeDestroyCallback;
        if (callback != null) {
            callback.onDestroyActionMode(this.mDeferredDestroyActionMode);
            this.mDeferredDestroyActionMode = null;
            this.mDeferredModeDestroyCallback = null;
        }
    }

    public void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = z;
            int size = this.mMenuVisibilityListeners.size();
            for (int i = 0; i < size; i++) {
                this.mMenuVisibilityListeners.get(i).onMenuVisibilityChanged(z);
            }
        }
    }

    public void doHide(boolean z) {
        View view;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
        }
        if (this.mCurWindowVisibility != 0 || !ALLOW_SHOW_HIDE_ANIMATIONS || (!this.mShowHideAnimationEnabled && !z)) {
            this.mHideListener.onAnimationEnd((View) null);
            return;
        }
        ViewCompat.y0(this.mMzAppBarLayout, 1.0f);
        this.mMzAppBarLayout.setTransitioning(true);
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
        float f = (float) (-this.mMzAppBarLayout.getHeight());
        if (z) {
            int[] iArr = {0, 0};
            this.mMzAppBarLayout.getLocationInWindow(iArr);
            f -= (float) iArr[1];
        }
        ViewPropertyAnimatorCompat q = ViewCompat.e(this.mMzAppBarLayout).q(f);
        q.n(this.mUpdateListener);
        viewPropertyAnimatorCompatSet2.c(q);
        if (this.mContentAnimations && (view = this.mContentView) != null) {
            viewPropertyAnimatorCompatSet2.c(ViewCompat.e(view).q(f));
        }
        ActionBarContainer actionBarContainer = this.mSplitView;
        if (actionBarContainer != null && actionBarContainer.getVisibility() == 0 && this.mIsSplitActionBarShow) {
            ViewCompat.y0(this.mSplitView, 1.0f);
            viewPropertyAnimatorCompatSet2.c(ViewCompat.e(this.mSplitView).q((float) this.mSplitView.getHeight()));
        }
        viewPropertyAnimatorCompatSet2.f(PathInterpolatorCompat.a(0.29f, 0.5f, 0.16f, 1.0f));
        viewPropertyAnimatorCompatSet2.e((long) this.mDuration);
        viewPropertyAnimatorCompatSet2.g(this.mHideListener);
        this.mCurrentShowAnim = viewPropertyAnimatorCompatSet2;
        viewPropertyAnimatorCompatSet2.h();
    }

    public void doShow(boolean z) {
        View view;
        View view2;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
        }
        this.mMzAppBarLayout.setVisibility(0);
        if (this.mCurWindowVisibility != 0 || !ALLOW_SHOW_HIDE_ANIMATIONS || (!this.mShowHideAnimationEnabled && !z)) {
            ViewCompat.y0(this.mMzAppBarLayout, 1.0f);
            ViewCompat.Z0(this.mMzAppBarLayout, 0.0f);
            if (this.mContentAnimations && (view = this.mContentView) != null) {
                ViewCompat.Z0(view, 0.0f);
            }
            ActionBarContainer actionBarContainer = this.mSplitView;
            if (actionBarContainer != null) {
                ViewCompat.y0(actionBarContainer, 1.0f);
                ViewCompat.Z0(this.mSplitView, 0.0f);
                this.mSplitView.setVisibility(0);
            }
            this.mShowListener.onAnimationEnd((View) null);
        } else {
            ViewCompat.Z0(this.mMzAppBarLayout, 0.0f);
            float f = (float) (-this.mMzAppBarLayout.getHeight());
            if (z) {
                int[] iArr = {0, 0};
                this.mMzAppBarLayout.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            ViewCompat.Z0(this.mMzAppBarLayout, f);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat q = ViewCompat.e(this.mMzAppBarLayout).q(0.0f);
            q.n(this.mUpdateListener);
            viewPropertyAnimatorCompatSet2.c(q);
            if (this.mContentAnimations && (view2 = this.mContentView) != null) {
                ViewCompat.Z0(view2, f);
                viewPropertyAnimatorCompatSet2.c(ViewCompat.e(this.mContentView).q(0.0f));
            }
            ActionBarContainer actionBarContainer2 = this.mSplitView;
            if (actionBarContainer2 != null && !this.mIsSplitActionBarShow) {
                actionBarContainer2.setVisibility(0);
                ActionBarContainer actionBarContainer3 = this.mSplitView;
                ViewCompat.Z0(actionBarContainer3, (float) actionBarContainer3.getMeasuredHeight());
                viewPropertyAnimatorCompatSet2.c(ViewCompat.e(this.mSplitView).q(0.0f));
            }
            viewPropertyAnimatorCompatSet2.f(PathInterpolatorCompat.a(0.2f, 0.5f, 0.05f, 1.0f));
            viewPropertyAnimatorCompatSet2.e((long) this.mDuration);
            viewPropertyAnimatorCompatSet2.g(this.mShowListener);
            this.mCurrentShowAnim = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.h();
        }
        ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.mActionBarCoordinatorLayout;
        if (actionBarCoordinatorLayout != null) {
            ViewCompat.q0(actionBarCoordinatorLayout);
        }
    }

    public void enableContentAnimations(boolean z) {
        this.mContentAnimations = z;
    }

    public MzActionBarTabContainer getActionBarTabContainer() {
        return this.mDecorToolbar.getTabContainer();
    }

    public ArrayList getAllTabs() {
        return this.mTabs;
    }

    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    public float getElevation() {
        return ViewCompat.u(this.mMzAppBarLayout);
    }

    public int getExpandRange() {
        return this.mMzAppBarLayout.getTotalScrollRange();
    }

    public int getHeight() {
        return this.mToolbarContainerView.getHeight();
    }

    public int getHideOffset() {
        throw new UnsupportedOperationException("don't support this feature");
    }

    public int getMeasuredHeight() {
        return this.mToolbarContainerView.getMeasuredHeight();
    }

    public MzAppBarLayout getMzAppBarLayout() {
        return this.mMzAppBarLayout;
    }

    public MzCollapsingToolbarLayout getMzCollapsingToolbarLayout() {
        return this.mToolbarContainerView;
    }

    public int getNavigationItemCount() {
        int navigationMode = this.mDecorToolbar.getNavigationMode();
        if (navigationMode == 1) {
            return this.mDecorToolbar.getDropdownItemCount();
        }
        if (navigationMode != 2) {
            return 0;
        }
        return this.mTabs.size();
    }

    public int getNavigationMode() {
        return this.mDecorToolbar.getNavigationMode();
    }

    public int getSelectedNavigationIndex() {
        TabImpl tabImpl;
        int navigationMode = this.mDecorToolbar.getNavigationMode();
        if (navigationMode == 1) {
            return this.mDecorToolbar.getDropdownSelectedPosition();
        }
        if (navigationMode == 2 && (tabImpl = this.mSelectedTab) != null) {
            return tabImpl.getPosition();
        }
        return -1;
    }

    public ActionBar.Tab getSelectedTab() {
        return this.mSelectedTab;
    }

    public int getSplitHeight() {
        ActionBarContainer actionBarContainer = this.mSplitView;
        if (actionBarContainer != null) {
            return actionBarContainer.getHeight();
        }
        return 0;
    }

    public int getSplitMeasuredHeight() {
        ActionBarContainer actionBarContainer = this.mSplitView;
        if (actionBarContainer != null) {
            return actionBarContainer.getMeasuredHeight();
        }
        return 0;
    }

    public ViewGroup getSpringLayoutMiddle() {
        return this.mActionBarSpringLayoutMiddle;
    }

    public ViewGroup getSpringLayoutQuick() {
        return this.mActionBarSpringLayoutQuick;
    }

    public ViewGroup getSubDecorView() {
        return this.mActionBarCoordinatorLayout;
    }

    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }

    public ActionBar.Tab getTabAt(int i) {
        return this.mTabs.get(i);
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public Context getThemedContext() {
        if (this.mThemedContext == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.mThemedContext = new ContextThemeWrapper(this.mContext, i);
            } else {
                this.mThemedContext = this.mContext;
            }
        }
        return this.mThemedContext;
    }

    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    public DecorToolbar getToolBar() {
        return this.mDecorToolbar;
    }

    public boolean hasIcon() {
        return this.mDecorToolbar.hasIcon();
    }

    public boolean hasLogo() {
        return this.mDecorToolbar.hasLogo();
    }

    public void hide() {
        if (!this.mHiddenByApp) {
            this.mHiddenByApp = true;
            updateVisibility(false);
        }
    }

    public void hideDropDown() {
        ensureDropDownView();
        this.mDropDownView.dismiss();
    }

    public void hideForSystem() {
        if (!this.mHiddenBySystem) {
            this.mHiddenBySystem = true;
            updateVisibility(true);
        }
    }

    public void hideScrollTabs(ActionBar.OnScrollTabsVisibilityChangeListener onScrollTabsVisibilityChangeListener) {
        this.mAloneTabContainer.setupScrollTabsAnimatorToVisibility(4);
    }

    public void hideSplitActionBar() {
        if (this.mSplitView != null) {
            doHideSplitActionBar();
        }
    }

    public void hideTabBar() {
        animateToTabs(false);
    }

    public boolean isHideOnContentScrollEnabled() {
        throw new UnsupportedOperationException("don't support this feature");
    }

    public boolean isShowing() {
        int height = getHeight();
        return this.mNowShowing && (height == 0 || getHideOffset() < height);
    }

    public boolean isSplitActionBarShowing() {
        if (this.mSplitView != null) {
            return this.mIsSplitActionBarShow;
        }
        return false;
    }

    public boolean isTitleTruncated() {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        return decorToolbar != null && decorToolbar.isTitleTruncated();
    }

    public ActionBar.Tab newTab() {
        return new TabImpl();
    }

    public void onConfigurationChanged(Configuration configuration) {
        setHasEmbeddedTabs(this.mforceShowTab);
    }

    public void onWindowVisibilityChanged(int i) {
        this.mCurWindowVisibility = i;
    }

    public void removeAllTabs() {
        cleanupTabs();
    }

    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.remove(onMenuVisibilityListener);
    }

    public void removeTab(ActionBar.Tab tab) {
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int i) {
        if (this.mTabScrollView != null) {
            TabImpl tabImpl = this.mSelectedTab;
            int position = tabImpl != null ? tabImpl.getPosition() : this.mSavedTabPosition;
            this.mTabScrollView.removeTabAt(i);
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

    public boolean requestFocus() {
        ViewGroup viewGroup = this.mDecorToolbar.getViewGroup();
        if (viewGroup == null || viewGroup.hasFocus()) {
            return false;
        }
        viewGroup.requestFocus();
        return true;
    }

    public void selectTab(ActionBar.Tab tab) {
        selectTab(tab, false);
    }

    public void setActionBarCanScroll(boolean z) {
        this.mActionBarCoordinatorLayout.setActionBarCanScroll(z);
    }

    public void setActionBarFitStatusBar(boolean z) {
        ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.mActionBarCoordinatorLayout;
        if (actionBarCoordinatorLayout != null) {
            actionBarCoordinatorLayout.setActionBarFitStatusBar(z);
        }
    }

    public void setActionBarTabMinWidth(int i) {
        this.mTabMinWidth = i;
    }

    public void setActionBarTabPadding(int i, int i2) {
        this.mTabPaddingStart = i;
        this.mTabPaddingEnd = i2;
    }

    public void setAdaptTabWith(boolean z) {
        ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.setAdaptTabWidthNoScroll(z);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mMzAppBarLayout.setPrimaryBackground(drawable);
    }

    public void setBottomBarCustomView(View view) {
        this.mDecorToolbar.setNavigationBarCustomView(view);
    }

    public void setContentInsetsRelative(int i, int i2) {
        this.mDecorToolbar.setContentInsetsRelative(i, i2);
    }

    public void setControlTitleTextColor(@ColorInt int i) {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (decorToolbar != null) {
            decorToolbar.setControlTitleTextColor(i);
        }
    }

    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.mDecorToolbar.getViewGroup(), false));
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        if (!this.mDisplayHomeAsUpSet) {
            setDisplayHomeAsUpEnabled(z);
        }
    }

    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public void setDisplayOptions(int i) {
        if ((i & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mDecorToolbar.setDisplayOptions(i);
    }

    public void setDisplayShowControlTitleBar(boolean z) {
        setDisplayOptions(z ? 64 : 0, 64);
        if (!z) {
            clearControlButton();
        }
    }

    public void setDisplayShowCustomEnabled(boolean z) {
        setDisplayOptions(z ? 16 : 0, 16);
    }

    public void setDisplayShowHomeEnabled(boolean z) {
        setDisplayOptions(z ? 2 : 0, 2);
    }

    public void setDisplayShowTabEnabled(boolean z) {
        if ((this.mDecorToolbar.getDisplayOptions() & 8) == 0 || !z) {
            this.mforceShowTab = z;
            setHasEmbeddedTabs(z);
            return;
        }
        throw new IllegalStateException("nested scroll actionbar can't display title and tabs in the same time");
    }

    public void setDisplayShowTitleEnabled(boolean z) {
        if (!this.mforceShowTab || !z) {
            setDisplayOptions(z ? 8 : 0, 8);
            return;
        }
        throw new IllegalStateException("nested scroll actionbar can't display title and tabs in the same time");
    }

    public void setDisplayUseLogoEnabled(boolean z) {
        setDisplayOptions(z ? 1 : 0, 1);
    }

    public void setDropDownCallback(ActionBar.DropDownCallback dropDownCallback) {
        ensureDropDownView();
        this.mDropDownCallback = dropDownCallback;
        if (!this.mIsSetScrollTabsExpendView) {
            this.mDropDownView.setCallback(dropDownCallback);
        }
    }

    public void setDropDownStartY(int i) {
        this.mActionBarCoordinatorLayout.setDropDownShowStart(i);
    }

    public void setDropDownView(View view) {
        ensureDropDownView();
        this.mDropDownView.setContentView(view, -1, -2);
    }

    public void setElevation(float f) {
        ViewCompat.D0(this.mMzAppBarLayout, f);
        ActionBarContainer actionBarContainer = this.mSplitView;
        if (actionBarContainer != null) {
            ViewCompat.D0(actionBarContainer, f);
        }
    }

    public void setExpanded(boolean z, boolean z2) {
        this.mMzAppBarLayout.setExpanded(z, z2);
    }

    public void setHideOffset(int i) {
        throw new UnsupportedOperationException("don't support this feature");
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        throw new UnsupportedOperationException("don't support this feature");
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.mDecorToolbar.setNavigationContentDescription(charSequence);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.mDecorToolbar.setNavigationIcon(drawable);
    }

    public void setHomeButtonEnabled(boolean z) {
        this.mDecorToolbar.setHomeButtonEnabled(z);
    }

    public void setIcon(int i) {
        this.mDecorToolbar.setIcon(i);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.mDecorToolbar.setDropdownParams(spinnerAdapter, new NavItemSelectedListener(onNavigationListener));
    }

    public void setLogo(int i) {
        this.mDecorToolbar.setLogo(i);
    }

    public void setNavigationMode(int i) {
        ActionBarCoordinatorLayout actionBarCoordinatorLayout;
        int navigationMode = this.mDecorToolbar.getNavigationMode();
        if (navigationMode == 2) {
            this.mSavedTabPosition = getSelectedNavigationIndex();
            selectTab((ActionBar.Tab) null);
            this.mTabScrollView.setVisibility(8);
        }
        if (!(navigationMode == i || this.mHasEmbeddedTabs || (actionBarCoordinatorLayout = this.mActionBarCoordinatorLayout) == null)) {
            ViewCompat.q0(actionBarCoordinatorLayout);
        }
        this.mDecorToolbar.setNavigationMode(i);
        boolean z = false;
        if (i == 2) {
            ensureTabsExist();
            this.mTabScrollView.setVisibility(0);
            int i2 = this.mSavedTabPosition;
            if (i2 != -1) {
                setSelectedNavigationItem(i2);
                this.mSavedTabPosition = -1;
            }
        }
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (i == 2 && !this.mHasEmbeddedTabs) {
            z = true;
        }
        decorToolbar.setCollapsible(z);
    }

    public void setOnOffsetChangedListener(ActionBar.OnOffsetChangedListener onOffsetChangedListener) {
        this.mToolbarContainerView.setOnOffsetChangedListener(onOffsetChangedListener);
    }

    public void setScrollTabAllowCollapse(boolean z) {
        throw new UnsupportedOperationException("Collapsing tabs are not supported in nested action bars");
    }

    public void setScrollTabCollapseButtonClickListener(final View.OnClickListener onClickListener) {
        setScrollTabCollapseButtonClickListener((TabCollapseButton.OnTabCollapseButtonClickListener) new TabCollapseButton.OnTabCollapseButtonClickListener() {
            public void onTabCollapseButtonOnClick(TabCollapseButton tabCollapseButton) {
                onClickListener.onClick(tabCollapseButton);
            }
        });
    }

    public void setScrollTabCollapseDrawable(Drawable drawable) {
        MzActionBarTabContainer tabContainer = this.mDecorToolbar.getTabContainer();
        if (tabContainer != null) {
            tabContainer.setCollapseButtonDrawable(drawable);
        }
    }

    public void setScrollTabForceCollapse(boolean z) {
    }

    public void setScrollTabsExpendTitle(String str) {
    }

    public void setScrollTabsExpendTitleTextAppearance(int i) {
    }

    public void setScrollTabsExpendTitleTextColor(@ColorInt int i) {
    }

    public void setScrollTabsExpendView(View view) {
        throw new UnsupportedOperationException("Collapsing tabs are not supported in nested action bars");
    }

    public void setSelectedNavigationItem(int i) {
        int navigationMode = this.mDecorToolbar.getNavigationMode();
        if (navigationMode == 1) {
            this.mDecorToolbar.setDropdownSelectedPosition(i);
        } else if (navigationMode == 2) {
            selectTab(this.mTabs.get(i));
        } else {
            throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    public void setShowHideAnimationEnabled(boolean z) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.mShowHideAnimationEnabled = z;
        if (!z && (viewPropertyAnimatorCompatSet = this.mCurrentShowAnim) != null) {
            viewPropertyAnimatorCompatSet.a();
        }
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
        ActionBarContainer actionBarContainer = this.mSplitView;
        if (actionBarContainer != null) {
            actionBarContainer.setSplitBackground(drawable);
        }
    }

    public void setSplitBarFitSystemWindows(boolean z) {
        ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.mActionBarCoordinatorLayout;
        if (actionBarCoordinatorLayout != null) {
            actionBarCoordinatorLayout.setSplitBarFitSystemWindows(z);
        }
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.mMzAppBarLayout.setStackedBackground(drawable);
    }

    public void setStackedTabsCanBeEmbedded(boolean z) {
        throw new UnsupportedOperationException("nested scroll actionbar only support embedded tabs");
    }

    public void setSubtitle(int i) {
        setSubtitle((CharSequence) this.mContext.getString(i));
    }

    public void setTabIndicatorDrawable(Drawable drawable) {
        ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.setIndicatorDrawable(drawable);
        }
    }

    public void setTabScrolled(int i, float f, int i2) {
        ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.setScrollPosition(i, f, true);
        }
    }

    public void setTabsGravity(int i) {
        this.mTabsGravity = i;
        this.mTabsGravitySet = true;
        ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.setTabsGravity(i);
        }
    }

    public void setTitle(int i) {
        setTitle((CharSequence) this.mContext.getString(i));
    }

    public void setTitleTextColor(@ColorInt int i) {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (decorToolbar != null) {
            decorToolbar.setTitleTextColor(i);
        }
    }

    public void setUiOptions(int i) {
        this.mActionBarCoordinatorLayout.setUiOptions(i);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public void show() {
        if (this.mHiddenByApp) {
            this.mHiddenByApp = false;
            updateVisibility(false);
        }
    }

    public void showDropDown(View view, ActionBar.DropDownCallback dropDownCallback) {
        throw new UnsupportedOperationException("use setDropDownView and showDropDow instead");
    }

    public void showForSystem() {
        if (this.mHiddenBySystem) {
            this.mHiddenBySystem = false;
            updateVisibility(true);
        }
    }

    public void showScrollTabs(ActionBar.OnScrollTabsVisibilityChangeListener onScrollTabsVisibilityChangeListener) {
        this.mAloneTabContainer.setupScrollTabsAnimatorToVisibility(0);
    }

    public void showSplitActionBar() {
        if (this.mSplitView != null) {
            doShowSplitActionBar();
        }
    }

    public void showTabBar() {
        animateToTabs(true);
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        ActionModeImpl actionModeImpl = this.mActionMode;
        if (actionModeImpl != null) {
            actionModeImpl.finish();
        }
        this.mContextView.killMode();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.mContextView.getContext(), callback);
        if (!actionModeImpl2.dispatchOnCreate()) {
            return null;
        }
        actionModeImpl2.invalidate();
        this.mContextView.initForMode(actionModeImpl2);
        animateToMode(true);
        ActionBarContainer actionBarContainer = this.mSplitView;
        if (!(actionBarContainer == null || actionBarContainer.getVisibility() == 0)) {
            this.mSplitView.setVisibility(0);
            ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.mActionBarCoordinatorLayout;
            if (actionBarCoordinatorLayout != null) {
                ViewCompat.q0(actionBarCoordinatorLayout);
            }
        }
        this.mContextView.sendAccessibilityEvent(32);
        this.mActionMode = actionModeImpl2;
        return actionModeImpl2;
    }

    public ActionMode startMultiChoiceActionMode(ActionMode.Callback callback) {
        ActionModeImpl actionModeImpl = this.mActionMode;
        if (actionModeImpl != null) {
            actionModeImpl.finish();
        }
        this.mContextView.killMode();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.mContextView.getContext(), callback);
        if (!actionModeImpl2.dispatchOnCreate()) {
            return null;
        }
        actionModeImpl2.invalidate();
        this.mContextView.setSplitView(this.mSplitView);
        this.mContextView.initForMultiChoiceMode(actionModeImpl2);
        this.mToolbarContainerView.initForMultiChoiceMode();
        animateToMode(true, actionModeImpl2);
        ActionBarContainer actionBarContainer = this.mSplitView;
        if (!(actionBarContainer == null || actionBarContainer.getVisibility() == 0)) {
            this.mSplitView.setVisibility(0);
            ActionBarCoordinatorLayout actionBarCoordinatorLayout = this.mActionBarCoordinatorLayout;
            if (actionBarCoordinatorLayout != null) {
                ViewCompat.q0(actionBarCoordinatorLayout);
            }
        }
        this.mContextView.sendAccessibilityEvent(32);
        actionModeImpl2.setIsMultiChoiceMode(true);
        this.mActionMode = actionModeImpl2;
        return actionModeImpl2;
    }

    public void addTab(ActionBar.Tab tab, int i) {
        addTab(tab, i, this.mTabs.isEmpty());
    }

    public void animateToMode(boolean z, ActionModeImpl actionModeImpl) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        if (actionModeImpl != null ? actionModeImpl.isShowActionBar() : z) {
            showForActionMode();
        } else {
            hideForActionMode();
        }
        if (z) {
            viewPropertyAnimatorCompat = this.mDecorToolbar.setupAnimatorToVisibility(4, 100);
        } else {
            viewPropertyAnimatorCompat = this.mDecorToolbar.setupAnimatorToVisibility(0, 200);
        }
        viewPropertyAnimatorCompat.o();
        this.mContextView.animateToMode(z, actionModeImpl);
    }

    public void selectTab(ActionBar.Tab tab, boolean z) {
        int i = -1;
        if (getNavigationMode() != 2) {
            if (tab != null) {
                i = tab.getPosition();
            }
            this.mSavedTabPosition = i;
            return;
        }
        FragmentTransaction fragmentTransaction = null;
        androidx.fragment.app.FragmentTransaction o = (!(this.mActivity instanceof FragmentActivity) || this.mDecorToolbar.getViewGroup().isInEditMode()) ? null : ((FragmentActivity) this.mActivity).getSupportFragmentManager().s().o();
        if (!this.mDecorToolbar.getViewGroup().isInEditMode()) {
            fragmentTransaction = this.mActivity.getFragmentManager().beginTransaction().disallowAddToBackStack();
        }
        TabImpl tabImpl = this.mSelectedTab;
        if (tabImpl != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (tab != null) {
                i = tab.getPosition();
            }
            scrollingTabContainerView.setTabSelected(i, z);
            TabImpl tabImpl2 = this.mSelectedTab;
            if (tabImpl2 != null) {
                if (tabImpl2.getCallback() != null) {
                    this.mSelectedTab.getCallback().onTabUnselected(this.mSelectedTab, o);
                } else {
                    this.mSelectedTab.getCallbackSDK().onTabUnselected(this.mSelectedTab, fragmentTransaction);
                }
            }
            TabImpl tabImpl3 = (TabImpl) tab;
            this.mSelectedTab = tabImpl3;
            if (tabImpl3 != null) {
                if (tabImpl3.getCallback() != null) {
                    this.mSelectedTab.getCallback().onTabSelected(this.mSelectedTab, o);
                } else {
                    this.mSelectedTab.getCallbackSDK().onTabSelected(this.mSelectedTab, fragmentTransaction);
                }
            }
        } else if (tabImpl != null) {
            if (tabImpl.getCallback() != null) {
                this.mSelectedTab.getCallback().onTabReselected(this.mSelectedTab, o);
            } else {
                this.mSelectedTab.getCallbackSDK().onTabReselected(this.mSelectedTab, fragmentTransaction);
            }
            if (z) {
                this.mTabScrollView.animateToTab(tab.getPosition());
            }
        }
        if (o != null && !o.r()) {
            o.j();
        }
    }

    public void setHomeActionContentDescription(int i) {
        this.mDecorToolbar.setNavigationContentDescription(i);
    }

    public void setHomeAsUpIndicator(int i) {
        this.mDecorToolbar.setNavigationIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.mDecorToolbar.setIcon(drawable);
    }

    public void setLogo(Drawable drawable) {
        this.mDecorToolbar.setLogo(drawable);
    }

    public void setScrollTabCollapseButtonClickListener(TabCollapseButton.OnTabCollapseButtonClickListener onTabCollapseButtonClickListener) {
        MzActionBarTabContainer tabContainer = this.mDecorToolbar.getTabContainer();
        this.mOnTabCollapseButtonClickListener = onTabCollapseButtonClickListener;
        if (tabContainer != null && !this.mIsSetScrollTabsExpendView) {
            tabContainer.setCollapseButtonClickListener(onTabCollapseButtonClickListener);
        }
    }

    public void setScrollTabsExpendView(View view, AloneTabContainer aloneTabContainer) {
        setDropDownView(view);
        TabCollapseButton tabCollapseButton = aloneTabContainer.getTabCollapseButton();
        if (tabCollapseButton != null) {
            this.mAloneTabContainer = aloneTabContainer;
            tabCollapseButton.setOnTabCollapseButtonClickListener(new TabCollapseButton.OnTabCollapseButtonClickListener() {
                public void onTabCollapseButtonOnClick(TabCollapseButton tabCollapseButton) {
                    TabCollapseButton unused = NestedScrollActionbar.this.mTabCollapseButton = tabCollapseButton;
                    if (NestedScrollActionbar.this.mDropDownViewShowing) {
                        NestedScrollActionbar.this.hideDropDown();
                        boolean unused2 = NestedScrollActionbar.this.mDropDownViewShowing = false;
                        return;
                    }
                    NestedScrollActionbar.this.showDropDown();
                    boolean unused3 = NestedScrollActionbar.this.mDropDownViewShowing = true;
                }
            });
        }
        this.mDropDownView.setCallback(new ActionBar.DropDownCallback() {
            public void onHidden() {
                ActionBar.DropDownCallback dropDownCallback = NestedScrollActionbar.this.mDropDownCallback;
                if (dropDownCallback != null) {
                    dropDownCallback.onHidden();
                }
            }

            public void onHide() {
                if (NestedScrollActionbar.this.mTabCollapseButton != null) {
                    NestedScrollActionbar.this.mTabCollapseButton.setCollapsed(true);
                }
                NestedScrollActionbar.this.showScrollTabs((ActionBar.OnScrollTabsVisibilityChangeListener) null);
                boolean unused = NestedScrollActionbar.this.mDropDownViewShowing = false;
                ActionBar.DropDownCallback dropDownCallback = NestedScrollActionbar.this.mDropDownCallback;
                if (dropDownCallback != null) {
                    dropDownCallback.onHide();
                }
            }

            public void onShow() {
                if (NestedScrollActionbar.this.mTabCollapseButton != null) {
                    NestedScrollActionbar.this.mTabCollapseButton.setCollapsed(false);
                }
                NestedScrollActionbar.this.hideScrollTabs((ActionBar.OnScrollTabsVisibilityChangeListener) null);
                ActionBar.DropDownCallback dropDownCallback = NestedScrollActionbar.this.mDropDownCallback;
                if (dropDownCallback != null) {
                    dropDownCallback.onShow();
                }
            }

            public void onShown() {
                ActionBar.DropDownCallback dropDownCallback = NestedScrollActionbar.this.mDropDownCallback;
                if (dropDownCallback != null) {
                    dropDownCallback.onShown();
                }
            }
        });
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mDecorToolbar.setSubtitle(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.mDecorToolbar.setTitle(charSequence);
    }

    public void showDropDown(View view, ActionBar.DropDownCallback dropDownCallback, int i) {
        throw new UnsupportedOperationException("use setDropDownView and showDropDow instead");
    }

    public void addTab(ActionBar.Tab tab, boolean z) {
        ensureTabsExist();
        setupTabStyle(tab);
        this.mTabScrollView.addTab(tab, z);
        configureTab(tab, this.mTabs.size());
        if (z) {
            selectTab(tab);
        }
    }

    public void setDisplayOptions(int i, int i2) {
        int displayOptions = this.mDecorToolbar.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mDecorToolbar.setDisplayOptions((i & i2) | ((~i2) & displayOptions));
    }

    public void setDisplayShowControlTitleBar(boolean z, final ActionBar.ControlTitleBarCallback controlTitleBarCallback) {
        this.mDecorToolbar.setControlTitleBarCallback(new ActionBar.ControlTitleBarCallback() {
            public void onCreateControlButton(int i, ActionBar.ControlButton controlButton) {
                NestedScrollActionbar.this.setControlButton(i, controlButton);
                controlTitleBarCallback.onCreateControlButton(i, controlButton);
            }
        });
        setDisplayShowControlTitleBar(z);
    }

    public void showDropDown() {
        ensureDropDownView();
        this.mDropDownView.show(48);
    }

    public void hide(int i) {
        this.mDuration = i;
        hide();
    }

    public void setCustomView(View view) {
        this.mDecorToolbar.setCustomView(view);
    }

    public void show(int i) {
        this.mDuration = i;
        show();
    }

    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.mDecorToolbar.setCustomView(view);
    }

    public void showDropDown(int i) {
        this.mActionBarCoordinatorLayout.setDropDownShowStart(i);
        showDropDown();
    }

    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        ensureTabsExist();
        setupTabStyle(tab);
        this.mTabScrollView.addTab(tab, i, z);
        configureTab(tab, i);
        if (z) {
            selectTab(tab);
        }
    }
}
