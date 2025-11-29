package flyme.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import com.meizu.common.util.CommonUtils;
import flyme.support.v7.app.ActionBar;
import flyme.support.v7.view.ActionBarPolicy;
import flyme.support.v7.view.menu.ActionMenuItem;
import flyme.support.v7.view.menu.MenuBuilder;
import flyme.support.v7.view.menu.MenuPresenter;
import flyme.support.v7.widget.Toolbar;

@SuppressLint({"RestrictedApi"})
public class ToolbarWidgetWrapper implements DecorToolbar {
    private static final int AFFECTS_LOGO_MASK = 3;
    private static final long DEFAULT_FADE_DURATION_MS = 200;
    private static final String TAG = "ToolbarWidgetWrapper";
    private ActionMenuPresenter mActionMenuPresenter;
    private ActionMenuPresenter mBottomActionMenuPresenter;
    private ControlTitleBar mControlTitleBar;
    ActionBar.ControlTitleBarCallback mControlTitleBarCallback;
    private ControlTitleBarController mControlTitleBarController;
    private View mCustomView;
    private int mDefaultNavigationContentDescription;
    private Drawable mDefaultNavigationIcon;
    private int mDisplayOpts;
    private final AppCompatDrawableManager mDrawableManager;
    private CharSequence mHomeDescription;
    private Drawable mIcon;
    private Drawable mLogo;
    /* access modifiers changed from: private */
    public boolean mMenuPrepared;
    private Drawable mNavIcon;
    private int mNavigationMode;
    private Spinner mSpinner;
    protected boolean mSplitActionBar;
    protected boolean mSplitWhenNarrow;
    private CharSequence mSubtitle;
    private MzActionBarTabContainer mTabView;
    /* access modifiers changed from: private */
    public CharSequence mTitle;
    private boolean mTitleSet;
    /* access modifiers changed from: private */
    public Toolbar mToolbar;
    /* access modifiers changed from: private */
    public Window.Callback mWindowCallback;

    public class ControlButtonImpl implements ActionBar.ControlButton {
        private static final int ENABLED = 16;
        private static final int HIDDEN = 8;
        private ControlTitleBarController mControlTitleBarController;
        private int mFlags = 16;
        private Drawable mIcon;
        private int mId = -1;
        private String mTitle;

        public ControlButtonImpl(ControlTitleBarController controlTitleBarController) {
            this.mControlTitleBarController = controlTitleBarController;
        }

        public Drawable getIcon() {
            return this.mIcon;
        }

        public int getId() {
            return this.mId;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public boolean isEnabled() {
            return (this.mFlags & 16) != 0;
        }

        public boolean isVisible() {
            return (this.mFlags & 8) == 0;
        }

        public void setControlTitleBarController(ControlTitleBarController controlTitleBarController) {
            this.mControlTitleBarController = controlTitleBarController;
        }

        public void setEnabled(boolean z) {
            if (isEnabled() != z) {
                this.mFlags = (z ? 16 : 0) | (this.mFlags & -17);
                ControlTitleBarController controlTitleBarController = this.mControlTitleBarController;
                if (controlTitleBarController != null) {
                    controlTitleBarController.onItemDataChanged();
                }
            }
        }

        public void setIcon(Drawable drawable) {
            if (this.mIcon != drawable) {
                this.mIcon = drawable;
                ControlTitleBarController controlTitleBarController = this.mControlTitleBarController;
                if (controlTitleBarController != null) {
                    controlTitleBarController.onItemDataChanged();
                }
            }
        }

        public void setId(int i) {
            this.mId = i;
        }

        public void setTitle(String str) {
            if (this.mTitle != str) {
                this.mTitle = str;
                ControlTitleBarController controlTitleBarController = this.mControlTitleBarController;
                if (controlTitleBarController != null) {
                    controlTitleBarController.onItemDataChanged();
                }
            }
        }

        public void setVisible(boolean z) {
            if (isVisible() != z) {
                this.mFlags = (z ? 0 : 8) | (this.mFlags & -9);
                ControlTitleBarController controlTitleBarController = this.mControlTitleBarController;
                if (controlTitleBarController != null) {
                    controlTitleBarController.onItemDataChanged();
                }
            }
        }
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.string.abc_action_bar_up_description, com.meizu.common.R.drawable.mz_titlebar_ic_back_dark);
    }

    private int detectDisplayOptions() {
        return this.mToolbar.getNavigationIcon() != null ? 15 : 11;
    }

    private void ensureControlTitleBar() {
        if (this.mControlTitleBar == null) {
            ControlTitleBarController controlTitleBarController = new ControlTitleBarController();
            this.mControlTitleBarController = controlTitleBarController;
            this.mControlTitleBar = controlTitleBarController.getControlTitleBar(getContext());
            this.mControlTitleBarController.setTitle(this.mTitle);
            int i = flyme.support.v7.appcompat.R.id.mz_control_title_bar_btn_ok;
            int i2 = flyme.support.v7.appcompat.R.id.mz_control_title_bar_btn_cancel;
            String string = getContext().getString(17039370);
            String string2 = getContext().getString(17039360);
            ControlButtonImpl controlButtonImpl = new ControlButtonImpl(this.mControlTitleBarController);
            ControlButtonImpl controlButtonImpl2 = new ControlButtonImpl(this.mControlTitleBarController);
            this.mControlTitleBarController.stopDispatchingItemsChanged();
            ActionBar.ControlTitleBarCallback controlTitleBarCallback = this.mControlTitleBarCallback;
            if (controlTitleBarCallback != null) {
                controlTitleBarCallback.onCreateControlButton(1, controlButtonImpl);
                this.mControlTitleBarCallback.onCreateControlButton(0, controlButtonImpl2);
            } else {
                controlButtonImpl.setTitle(string);
                controlButtonImpl2.setTitle(string2);
            }
            if (controlButtonImpl.getId() == -1) {
                controlButtonImpl.setId(i);
            }
            if (controlButtonImpl2.getId() == -1) {
                controlButtonImpl2.setId(i2);
            }
            final ActionMenuItem actionMenuItem = new ActionMenuItem(this.mToolbar.getContext(), controlButtonImpl2);
            final ActionMenuItem actionMenuItem2 = new ActionMenuItem(this.mToolbar.getContext(), controlButtonImpl);
            this.mControlTitleBarController.bindButton(0, controlButtonImpl2, new View.OnClickListener() {
                public void onClick(View view) {
                    if (ToolbarWidgetWrapper.this.mWindowCallback != null && ToolbarWidgetWrapper.this.mMenuPrepared) {
                        ToolbarWidgetWrapper.this.mWindowCallback.onMenuItemSelected(0, actionMenuItem);
                    }
                }
            });
            this.mControlTitleBarController.bindButton(1, controlButtonImpl, new View.OnClickListener() {
                public void onClick(View view) {
                    if (ToolbarWidgetWrapper.this.mWindowCallback != null && ToolbarWidgetWrapper.this.mMenuPrepared) {
                        ToolbarWidgetWrapper.this.mWindowCallback.onMenuItemSelected(0, actionMenuItem2);
                    }
                }
            });
            this.mControlTitleBarController.startDispatchingItemsChanged();
        }
    }

    private void ensureSpinner() {
        if (this.mSpinner == null) {
            this.mSpinner = new AppCompatSpinner(getContext(), (AttributeSet) null, R.attr.actionDropDownStyle);
            this.mSpinner.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    private void setTitleInt(CharSequence charSequence) {
        this.mTitle = charSequence;
        if ((this.mDisplayOpts & 8) != 0) {
            this.mToolbar.setTitle(charSequence);
        }
        ControlTitleBarController controlTitleBarController = this.mControlTitleBarController;
        if (controlTitleBarController != null) {
            controlTitleBarController.setTitle(this.mTitle);
        }
    }

    private void updateHomeAccessibility() {
        if ((this.mDisplayOpts & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.mHomeDescription)) {
            this.mToolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        } else {
            this.mToolbar.setNavigationContentDescription(this.mHomeDescription);
        }
    }

    private void updateNavigationIcon() {
        if ((this.mDisplayOpts & 4) != 0) {
            Toolbar toolbar = this.mToolbar;
            Drawable drawable = this.mNavIcon;
            if (drawable == null) {
                drawable = this.mDefaultNavigationIcon;
            }
            toolbar.setNavigationIcon(drawable);
        }
    }

    private void updateToolbarLogo() {
        Drawable drawable;
        int i = this.mDisplayOpts;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) != 0) {
            drawable = this.mLogo;
            if (drawable == null) {
                drawable = this.mIcon;
            }
        } else {
            drawable = this.mIcon;
        }
        this.mToolbar.setLogo(drawable);
    }

    public void animateToVisibility(int i) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = setupAnimatorToVisibility(i, 200);
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.o();
        }
    }

    public boolean canShowOverflowMenu() {
        return this.mToolbar.canShowOverflowMenu();
    }

    public boolean canSplit() {
        return true;
    }

    public void collapseActionView() {
        this.mToolbar.collapseActionView();
    }

    public void dismissPopupMenus() {
        this.mToolbar.dismissPopupMenus();
    }

    public Context getContext() {
        return this.mToolbar.getContext();
    }

    public View getCustomView() {
        return this.mCustomView;
    }

    public int getDisplayOptions() {
        return this.mDisplayOpts;
    }

    public int getDropdownItemCount() {
        Spinner spinner = this.mSpinner;
        if (spinner != null) {
            return spinner.getCount();
        }
        return 0;
    }

    public int getDropdownSelectedPosition() {
        Spinner spinner = this.mSpinner;
        if (spinner != null) {
            return spinner.getSelectedItemPosition();
        }
        return 0;
    }

    public int getHeight() {
        return this.mToolbar.getHeight();
    }

    public Menu getMenu() {
        return this.mToolbar.getMenu();
    }

    public int getNavigationMode() {
        return this.mNavigationMode;
    }

    public Drawable getOverflowIcon() {
        return this.mToolbar.getOverflowIcon();
    }

    public CharSequence getSubtitle() {
        return this.mToolbar.getSubtitle();
    }

    public MzActionBarTabContainer getTabContainer() {
        return this.mTabView;
    }

    public CharSequence getTitle() {
        return this.mToolbar.getTitle();
    }

    public ViewGroup getViewGroup() {
        return this.mToolbar;
    }

    public int getVisibility() {
        return this.mToolbar.getVisibility();
    }

    public boolean hasEmbeddedTabs() {
        return this.mTabView != null;
    }

    public boolean hasExpandedActionView() {
        return this.mToolbar.hasExpandedActionView();
    }

    public boolean hasIcon() {
        return this.mIcon != null;
    }

    public boolean hasLogo() {
        return this.mLogo != null;
    }

    public boolean hideOverflowMenu() {
        return this.mToolbar.hideOverflowMenu();
    }

    public void initIndeterminateProgress() {
        Log.i(TAG, "Progress display unsupported");
    }

    public void initProgress() {
        Log.i(TAG, "Progress display unsupported");
    }

    public boolean isOverflowMenuShowPending() {
        return this.mToolbar.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        return this.mToolbar.isOverflowMenuShowing();
    }

    public boolean isShowNavigationCustomView() {
        return this.mToolbar.getSplitBarCustomView() != null;
    }

    public boolean isShowNavigationMenu() {
        return this.mToolbar.isShowBottomMenu();
    }

    public boolean isSplit() {
        return this.mSplitActionBar;
    }

    public boolean isTitleTruncated() {
        return this.mToolbar.isTitleTruncated();
    }

    public void reSetSplitViewHeight(ViewGroup viewGroup) {
        this.mToolbar.reSetSplitViewHeight(viewGroup);
    }

    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.mToolbar.restoreHierarchyState(sparseArray);
    }

    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.mToolbar.saveHierarchyState(sparseArray);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mToolbar.setBackgroundDrawable(drawable);
    }

    public void setCollapsible(boolean z) {
        this.mToolbar.setCollapsible(z);
    }

    public void setContentInsetsRelative(int i, int i2) {
        this.mToolbar.setContentInsetsRelative(i, i2);
    }

    public void setControlTitleBarCallback(ActionBar.ControlTitleBarCallback controlTitleBarCallback) {
        this.mControlTitleBarCallback = controlTitleBarCallback;
    }

    public void setControlTitleTextColor(int i) {
        ControlTitleBarController controlTitleBarController = this.mControlTitleBarController;
        if (controlTitleBarController != null) {
            controlTitleBarController.setTitleColor(i);
        }
    }

    public void setCustomView(View view) {
        View view2 = this.mCustomView;
        if (!(view2 == null || (this.mDisplayOpts & 16) == 0)) {
            this.mToolbar.removeView(view2);
        }
        this.mCustomView = view;
        if (view != null && (this.mDisplayOpts & 16) != 0) {
            this.mToolbar.addView(view);
        }
    }

    public void setDefaultNavigationContentDescription(int i) {
        if (i != this.mDefaultNavigationContentDescription) {
            this.mDefaultNavigationContentDescription = i;
            if (TextUtils.isEmpty(this.mToolbar.getNavigationContentDescription())) {
                setNavigationContentDescription(this.mDefaultNavigationContentDescription);
            }
        }
    }

    public void setDefaultNavigationIcon(Drawable drawable) {
        if (this.mDefaultNavigationIcon != drawable) {
            this.mDefaultNavigationIcon = drawable;
            updateNavigationIcon();
        }
    }

    public void setDisplayOptions(int i) {
        MzActionBarTabContainer mzActionBarTabContainer;
        Toolbar toolbar;
        View view;
        int i2 = this.mDisplayOpts ^ i;
        this.mDisplayOpts = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    updateNavigationIcon();
                    updateHomeAccessibility();
                } else {
                    this.mToolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i2 & 3) != 0) {
                updateToolbarLogo();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.mToolbar.setTitle(this.mTitle);
                    this.mToolbar.setSubtitle(this.mSubtitle);
                    this.mToolbar.setContentInsetsRelative(getContext().getResources().getDimensionPixelSize(flyme.support.v7.appcompat.R.dimen.mz_toolbar_content_inset_start), this.mToolbar.getContentInsetEnd());
                } else {
                    this.mToolbar.setTitle((CharSequence) null);
                    this.mToolbar.setSubtitle((CharSequence) null);
                }
            }
            if (!((i2 & 16) == 0 || (view = this.mCustomView) == null)) {
                if ((i & 16) != 0) {
                    this.mToolbar.addView(view);
                } else {
                    this.mToolbar.removeView(view);
                }
            }
            if (!((i2 & 32) == 0 || (mzActionBarTabContainer = this.mTabView) == null)) {
                if ((i & 32) != 0) {
                    if (mzActionBarTabContainer != null && this.mNavigationMode == 2) {
                        this.mToolbar.addView(mzActionBarTabContainer, 0);
                        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        layoutParams.gravity = 8388627;
                        this.mTabView.showAtToolbar(true);
                    }
                } else if (mzActionBarTabContainer != null && mzActionBarTabContainer.getParent() == (toolbar = this.mToolbar)) {
                    toolbar.removeView(this.mTabView);
                }
            }
            if ((i2 & 64) != 0) {
                ensureControlTitleBar();
                if ((i & 64) != 0) {
                    this.mToolbar.addView(this.mControlTitleBar);
                    this.mToolbar.setContentInsetsRelative(0, 0);
                } else {
                    this.mToolbar.removeView(this.mControlTitleBar);
                    this.mControlTitleBar = null;
                }
            }
        }
        if ((i & 64) == 0) {
            this.mToolbar.removeView(this.mControlTitleBar);
            this.mControlTitleBar = null;
        } else if (this.mToolbar.indexOfChild(this.mControlTitleBar) < 0) {
            ensureControlTitleBar();
            this.mToolbar.addView(this.mControlTitleBar);
            this.mToolbar.setContentInsetsRelative(0, 0);
        }
    }

    public void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        ensureSpinner();
        this.mSpinner.setAdapter(spinnerAdapter);
        this.mSpinner.setOnItemSelectedListener(onItemSelectedListener);
    }

    public void setDropdownSelectedPosition(int i) {
        Spinner spinner = this.mSpinner;
        if (spinner != null) {
            spinner.setSelection(i);
            return;
        }
        throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }

    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        Toolbar toolbar;
        MzActionBarTabContainer mzActionBarTabContainer = this.mTabView;
        if (mzActionBarTabContainer != null && mzActionBarTabContainer.getParent() == (toolbar = this.mToolbar)) {
            toolbar.removeView(this.mTabView);
        }
        if (this.mTabView == null && scrollingTabContainerView != null) {
            this.mTabView = new MzActionBarTabContainer(getContext());
        }
        if (scrollingTabContainerView != null) {
            this.mTabView.setTabView(scrollingTabContainerView);
            this.mTabView.showAtToolbar(true);
            if (this.mNavigationMode == 2) {
                this.mToolbar.addView(this.mTabView);
                this.mToolbar.setContentInsetsRelative(getContext().getResources().getDimensionPixelSize(flyme.support.v7.appcompat.R.dimen.mz_toolbar_content_inset_start_with_tab), this.mToolbar.getContentInsetEnd());
                Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.gravity = 8388627;
                return;
            }
            return;
        }
        MzActionBarTabContainer mzActionBarTabContainer2 = this.mTabView;
        if (mzActionBarTabContainer2 != null) {
            mzActionBarTabContainer2.setTabView((ScrollingTabContainerView) null);
            this.mTabView = null;
        }
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public void setIcon(int i) {
        setIcon(i != 0 ? this.mDrawableManager.c(getContext(), i) : null);
    }

    public void setLogo(int i) {
        setLogo(i != 0 ? this.mDrawableManager.c(getContext(), i) : null);
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        if (this.mActionMenuPresenter == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.mToolbar.getContext());
            this.mActionMenuPresenter = actionMenuPresenter;
            actionMenuPresenter.setId(R.id.action_menu_presenter);
            if (this.mSplitActionBar) {
                this.mActionMenuPresenter.setExpandedActionViewsExclusive(true);
                this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels - (ActionBarPolicy.get(getContext()).getSplitActionBarPadding() * 2), true);
                this.mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
                this.mActionMenuPresenter.setIsSplit(true);
            }
        }
        this.mActionMenuPresenter.setCallback(callback);
        this.mToolbar.setMenu((MenuBuilder) menu, this.mActionMenuPresenter);
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mToolbar.setMenuCallbacks(callback, callback2);
    }

    public void setMenuPrepared() {
        this.mMenuPrepared = true;
    }

    public void setNavigationBarCustomView(View view) {
        if (isSplit() || this.mToolbar.mSplitView != null) {
            this.mToolbar.setSplitCustomView(view);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        this.mHomeDescription = charSequence;
        updateHomeAccessibility();
    }

    public void setNavigationIcon(Drawable drawable) {
        this.mNavIcon = drawable;
        updateNavigationIcon();
    }

    public void setNavigationMenu(Menu menu, MenuPresenter.Callback callback) {
        if (this.mBottomActionMenuPresenter == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.mToolbar.getContext());
            this.mBottomActionMenuPresenter = actionMenuPresenter;
            actionMenuPresenter.setId(flyme.support.v7.appcompat.R.id.bottom_action_menu_presenter);
            this.mBottomActionMenuPresenter.setExpandedActionViewsExclusive(true);
            this.mBottomActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels - (ActionBarPolicy.get(getContext()).getSplitActionBarPadding() * 2), true);
            this.mBottomActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
            this.mBottomActionMenuPresenter.setIsSplit(true);
        }
        this.mBottomActionMenuPresenter.setCallback(callback);
        this.mToolbar.setBottomMenu((MenuBuilder) menu, this.mBottomActionMenuPresenter);
    }

    public void setNavigationMode(int i) {
        Toolbar toolbar;
        MzActionBarTabContainer mzActionBarTabContainer;
        Toolbar toolbar2;
        int i2 = this.mNavigationMode;
        if (i != i2) {
            if (i2 == 1) {
                Spinner spinner = this.mSpinner;
                if (spinner != null && spinner.getParent() == (toolbar = this.mToolbar)) {
                    toolbar.removeView(this.mSpinner);
                }
            } else if (i2 == 2 && (mzActionBarTabContainer = this.mTabView) != null && mzActionBarTabContainer.getParent() == (toolbar2 = this.mToolbar)) {
                toolbar2.removeView(this.mTabView);
            }
            this.mNavigationMode = i;
            if (i == 0) {
                return;
            }
            if (i == 1) {
                ensureSpinner();
                this.mToolbar.addView(this.mSpinner, 0);
            } else if (i == 2) {
                MzActionBarTabContainer mzActionBarTabContainer2 = this.mTabView;
                if (mzActionBarTabContainer2 != null) {
                    this.mToolbar.addView(mzActionBarTabContainer2, 0);
                    Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                    layoutParams.gravity = 8388691;
                }
            } else {
                throw new IllegalArgumentException("Invalid navigation mode " + i);
            }
        }
    }

    public void setOverflowIcon(Drawable drawable) {
        this.mToolbar.setOverflowIcon(drawable);
    }

    public void setShowNavigationMenu(boolean z) {
        this.mToolbar.setShowBottomMenu(z);
    }

    public void setSplitToolbar(boolean z) {
        if (this.mSplitActionBar != z) {
            this.mSplitActionBar = z;
            this.mToolbar.setSplitToolbar(z);
            ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
            if (actionMenuPresenter != null) {
                if (!z) {
                    actionMenuPresenter.setExpandedActionViewsExclusive(false);
                } else {
                    actionMenuPresenter.setExpandedActionViewsExclusive(true);
                    this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels - (ActionBarPolicy.get(getContext()).getSplitActionBarPadding() * 2), true);
                    this.mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
                }
                this.mActionMenuPresenter.setIsSplit(z);
            }
        }
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.mToolbar.setSplitView(viewGroup);
    }

    public void setSplitWhenNarrow(boolean z) {
        this.mSplitWhenNarrow = z;
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        if ((this.mDisplayOpts & 8) != 0) {
            this.mToolbar.setSubtitle(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitleSet = true;
        setTitleInt(charSequence);
    }

    public void setTitleTextColor(int i) {
        this.mToolbar.setTitleTextColor(i);
    }

    public void setVisibility(int i) {
        this.mToolbar.setVisibility(i);
    }

    public void setWindowCallback(Window.Callback callback) {
        this.mWindowCallback = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.mTitleSet) {
            setTitleInt(charSequence);
        }
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int i, long j) {
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setMenuViewAnimateToVisibility(i, j);
        }
        return ViewCompat.e(this.mToolbar).b(i == 0 ? 1.0f : 0.0f).i(j).k(new ViewPropertyAnimatorListenerAdapter() {
            private boolean mCanceled = false;

            public void onAnimationCancel(View view) {
                this.mCanceled = true;
            }

            public void onAnimationEnd(View view) {
                if (!this.mCanceled) {
                    ToolbarWidgetWrapper.this.mToolbar.setVisibility(i);
                    ToolbarWidgetWrapper.this.mToolbar.setMenuVisibility(i);
                    if (i == 4) {
                        ToolbarWidgetWrapper.this.mToolbar.requestLayout();
                    }
                }
            }

            public void onAnimationStart(View view) {
                ToolbarWidgetWrapper.this.mToolbar.setVisibility(0);
            }
        });
    }

    public boolean showOverflowMenu() {
        return this.mToolbar.showOverflowMenu();
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i, int i2) {
        this.mNavigationMode = 0;
        this.mDefaultNavigationContentDescription = 0;
        this.mToolbar = toolbar;
        this.mTitle = toolbar.getTitle();
        this.mSubtitle = toolbar.getSubtitle();
        this.mTitleSet = this.mTitle != null;
        this.mNavIcon = toolbar.getNavigationIcon();
        if (z) {
            TintTypedArray v = TintTypedArray.v(toolbar.getContext(), (AttributeSet) null, R.styleable.ActionBar, CommonUtils.hasFullDisplay() ? flyme.support.v7.appcompat.R.attr.mzActionBarStyleFullScreen : R.attr.actionBarStyle, 0);
            CharSequence p = v.p(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(p)) {
                setTitle(p);
            }
            CharSequence p2 = v.p(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(p2)) {
                setSubtitle(p2);
            }
            Drawable g = v.g(R.styleable.ActionBar_logo);
            if (g != null) {
                setLogo(g);
            }
            Drawable g2 = v.g(R.styleable.ActionBar_icon);
            if (this.mNavIcon == null && g2 != null) {
                setIcon(g2);
            }
            Drawable g3 = v.g(R.styleable.ActionBar_homeAsUpIndicator);
            if (g3 != null) {
                setNavigationIcon(g3);
            }
            setDisplayOptions(v.k(R.styleable.ActionBar_displayOptions, 0));
            int n = v.n(R.styleable.ActionBar_customNavigationLayout, 0);
            if (n != 0) {
                setCustomView(LayoutInflater.from(this.mToolbar.getContext()).inflate(n, this.mToolbar, false));
                setDisplayOptions(this.mDisplayOpts | 16);
            }
            int m = v.m(R.styleable.ActionBar_height, 0);
            if (m > 0) {
                ViewGroup.LayoutParams layoutParams = this.mToolbar.getLayoutParams();
                layoutParams.height = m;
                this.mToolbar.setLayoutParams(layoutParams);
            }
            int e = v.e(R.styleable.ActionBar_contentInsetStart, -1);
            int e2 = v.e(R.styleable.ActionBar_contentInsetEnd, -1);
            if (e >= 0 || e2 >= 0) {
                this.mToolbar.setContentInsetsRelative(Math.max(e, 0), Math.max(e2, 0));
            }
            int n2 = v.n(R.styleable.ActionBar_titleTextStyle, 0);
            if (n2 != 0) {
                Toolbar toolbar2 = this.mToolbar;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), n2);
            }
            int n3 = v.n(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (n3 != 0) {
                Toolbar toolbar3 = this.mToolbar;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), n3);
            }
            int n4 = v.n(R.styleable.ActionBar_popupTheme, 0);
            if (n4 != 0) {
                this.mToolbar.setPopupTheme(n4);
            }
            v.w();
        } else {
            this.mDisplayOpts = detectDisplayOptions();
        }
        AppCompatDrawableManager b = AppCompatDrawableManager.b();
        this.mDrawableManager = b;
        setDefaultNavigationContentDescription(i);
        this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
        setDefaultNavigationIcon(b.c(getContext(), i2));
        this.mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            final ActionMenuItem mNavItem;

            {
                this.mNavItem = new ActionMenuItem(ToolbarWidgetWrapper.this.mToolbar.getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.this.mTitle);
            }

            public void onClick(View view) {
                if (ToolbarWidgetWrapper.this.mWindowCallback != null && ToolbarWidgetWrapper.this.mMenuPrepared) {
                    ToolbarWidgetWrapper.this.mWindowCallback.onMenuItemSelected(0, this.mNavItem);
                }
            }
        });
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        updateToolbarLogo();
    }

    public void setLogo(Drawable drawable) {
        this.mLogo = drawable;
        updateToolbarLogo();
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription((CharSequence) i == 0 ? null : getContext().getString(i));
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(i != 0 ? AppCompatDrawableManager.b().c(getContext(), i) : null);
    }
}
