package flyme.support.v7.app;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.R;
import androidx.fragment.app.FragmentTransaction;
import flyme.support.v7.view.ActionMode;
import flyme.support.v7.widget.AloneTabContainer;
import flyme.support.v7.widget.DecorToolbar;
import flyme.support.v7.widget.MzActionBarTabContainer;
import flyme.support.v7.widget.MzAppBarLayout;
import flyme.support.v7.widget.MzCollapsingToolbarLayout;
import flyme.support.v7.widget.TabCollapseButton;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public abstract class ActionBar {
    public static final int DISPLAY_HOME_AS_UP = 4;
    public static final int DISPLAY_SHOW_CONTROL_TITLE_BAR = 64;
    public static final int DISPLAY_SHOW_CUSTOM = 16;
    public static final int DISPLAY_SHOW_HOME = 2;
    public static final int DISPLAY_SHOW_TAB = 32;
    public static final int DISPLAY_SHOW_TITLE = 8;
    public static final int DISPLAY_USE_LOGO = 1;
    public static final int NAVIGATION_MODE_LIST = 1;
    public static final int NAVIGATION_MODE_STANDARD = 0;
    public static final int NAVIGATION_MODE_TABS = 2;
    private final String TAG = " [ActionBar] ";
    private ControlButton mNegativeBtn;
    private ControlButtonConfigure mNegativeCtlBtnCfg;
    private ControlButton mPositiveBtn;
    private ControlButtonConfigure mPositiveCtlBtnCfg;

    public interface AloneTabListener {
        void onTabReselected(Tab tab);

        void onTabSelected(Tab tab);

        void onTabUnselected(Tab tab);
    }

    public interface ControlButton {
        public static final int BUTTON_NEGATIVE = 0;
        public static final int BUTTON_POSITIVE = 1;

        Drawable getIcon();

        int getId();

        String getTitle();

        boolean isEnabled();

        boolean isVisible();

        void setEnabled(boolean z);

        void setIcon(Drawable drawable);

        void setId(int i);

        void setTitle(String str);

        void setVisible(boolean z);
    }

    public interface ControlButtonConfigure {
        void configControlBtn(@NonNull ControlButton controlButton);
    }

    public interface ControlTitleBarCallback {
        void onCreateControlButton(int i, ControlButton controlButton);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DisplayOptions {
    }

    public interface DropDownCallback {
        void onHidden();

        void onHide();

        void onShow();

        void onShown();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NavigationMode {
    }

    public interface OnMenuVisibilityListener {
        void onMenuVisibilityChanged(boolean z);
    }

    public interface OnNavigationListener {
        boolean onNavigationItemSelected(int i, long j);
    }

    public interface OnOffsetChangedListener {
        void onOffsetChanged(int i);
    }

    public interface OnScrollTabsVisibilityChangeListener {
        void onChanged(boolean z);

        void onPrepareChange(boolean z);
    }

    public static abstract class Tab {
        public static final int INVALID_POSITION = -1;

        public AloneTabListener getAloneTabListenerCallback() {
            return null;
        }

        public abstract TabListener getCallback();

        public abstract TabListenerSDK getCallbackSDK();

        public abstract CharSequence getContentDescription();

        public abstract View getCustomView();

        public abstract Drawable getIcon();

        public abstract int getMinWidth();

        public abstract int getPaddingEnd();

        public abstract int getPaddingStart();

        public abstract int getPosition();

        public abstract Object getTag();

        public abstract CharSequence getText();

        public abstract ColorStateList getTextColor();

        public abstract boolean isEnabled();

        public abstract void select();

        public abstract void select(boolean z);

        public Tab setAloneTabListener(AloneTabListener aloneTabListener) {
            return null;
        }

        public abstract Tab setContentDescription(int i);

        public abstract Tab setContentDescription(CharSequence charSequence);

        public abstract Tab setCustomView(int i);

        public abstract Tab setCustomView(View view);

        public abstract Tab setEnabled(boolean z);

        public abstract Tab setIcon(@DrawableRes int i);

        public abstract Tab setIcon(Drawable drawable);

        public abstract void setMinWidth(int i);

        public abstract void setPadding(int i, int i2);

        public abstract Tab setTabListener(TabListener tabListener);

        public abstract Tab setTabListenerSDK(TabListenerSDK tabListenerSDK);

        public abstract Tab setTag(Object obj);

        public abstract Tab setText(int i);

        public abstract Tab setText(CharSequence charSequence);

        public abstract Tab setTextColor(ColorStateList colorStateList);
    }

    public interface TabListener {
        void onTabReselected(Tab tab, FragmentTransaction fragmentTransaction);

        void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction);

        void onTabUnselected(Tab tab, FragmentTransaction fragmentTransaction);
    }

    public interface TabListenerSDK {
        void onTabReselected(Tab tab, android.app.FragmentTransaction fragmentTransaction);

        void onTabSelected(Tab tab, android.app.FragmentTransaction fragmentTransaction);

        void onTabUnselected(Tab tab, android.app.FragmentTransaction fragmentTransaction);
    }

    public abstract void addOnMenuVisibilityListener(OnMenuVisibilityListener onMenuVisibilityListener);

    public abstract void addTab(Tab tab);

    public abstract void addTab(Tab tab, int i);

    public abstract void addTab(Tab tab, int i, boolean z);

    public abstract void addTab(Tab tab, boolean z);

    public void clearControlButton() {
        setControlButton(0, (ControlButton) null);
        setControlButton(1, (ControlButton) null);
    }

    public boolean collapseActionView() {
        return false;
    }

    public void configNegativeControlButton(@NonNull ControlButtonConfigure controlButtonConfigure) {
        setDisplayShowControlTitleBar(true);
        ControlButton controlButton = this.mNegativeBtn;
        if (controlButton == null) {
            this.mNegativeCtlBtnCfg = controlButtonConfigure;
        } else {
            controlButtonConfigure.configControlBtn(controlButton);
        }
    }

    public void configPositiveControlButton(@NonNull ControlButtonConfigure controlButtonConfigure) {
        setDisplayShowControlTitleBar(true);
        ControlButton controlButton = this.mPositiveBtn;
        if (controlButton == null) {
            this.mPositiveCtlBtnCfg = controlButtonConfigure;
        } else {
            controlButtonConfigure.configControlBtn(controlButton);
        }
    }

    public void dispatchMenuVisibilityChanged(boolean z) {
    }

    public MzActionBarTabContainer getActionBarTabContainer() {
        return null;
    }

    public ArrayList getAllTabs() {
        return null;
    }

    public abstract View getCustomView();

    public abstract int getDisplayOptions();

    public float getElevation() {
        return 0.0f;
    }

    public int getExpandRange() {
        return 0;
    }

    public abstract int getHeight();

    public int getHideOffset() {
        return 0;
    }

    public int getMeasuredHeight() {
        return 0;
    }

    public MzAppBarLayout getMzAppBarLayout() {
        Log.w(" [ActionBar] ", "only NestedScrollActionbar has  MzAppBarLayout");
        return null;
    }

    public MzCollapsingToolbarLayout getMzCollapsingToolbarLayout() {
        Log.w(" [ActionBar] ", "only NestedScrollActionbar has  MzCollapsingToolbarLayout");
        return null;
    }

    public abstract int getNavigationItemCount();

    public abstract int getNavigationMode();

    public abstract int getSelectedNavigationIndex();

    @Nullable
    public abstract Tab getSelectedTab();

    public int getSplitHeight() {
        return 0;
    }

    public int getSplitMeasuredHeight() {
        return 0;
    }

    public ViewGroup getSpringLayoutMiddle() {
        Log.w(" [ActionBar] ", "only NestedScrollActionbar has SpringLayout");
        return null;
    }

    public ViewGroup getSpringLayoutQuick() {
        Log.w(" [ActionBar] ", "only NestedScrollActionbar has SpringLayout");
        return null;
    }

    public ViewGroup getSubDecorView() {
        return null;
    }

    @Nullable
    public abstract CharSequence getSubtitle();

    public abstract Tab getTabAt(int i);

    public abstract int getTabCount();

    public Context getThemedContext() {
        return null;
    }

    @Nullable
    public abstract CharSequence getTitle();

    public DecorToolbar getToolBar() {
        return null;
    }

    public abstract void hide();

    public void hide(int i) {
        hide();
    }

    public void hideDropDown() {
    }

    public void hideScrollTabs(OnScrollTabsVisibilityChangeListener onScrollTabsVisibilityChangeListener) {
    }

    public void hideSplitActionBar() {
    }

    public void hideTabBar() {
    }

    public boolean invalidateOptionsMenu() {
        return false;
    }

    public boolean isHideOnContentScrollEnabled() {
        return false;
    }

    public abstract boolean isShowing();

    public boolean isSplitActionBarShowing() {
        return isShowing();
    }

    public boolean isTitleTruncated() {
        return false;
    }

    public abstract Tab newTab();

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    public boolean openOptionsMenu() {
        return false;
    }

    public abstract void removeAllTabs();

    public abstract void removeOnMenuVisibilityListener(OnMenuVisibilityListener onMenuVisibilityListener);

    public abstract void removeTab(Tab tab);

    public abstract void removeTabAt(int i);

    public boolean requestFocus() {
        return false;
    }

    public abstract void selectTab(Tab tab);

    public abstract void selectTab(Tab tab, boolean z);

    public void setActionBarCanScroll(boolean z) {
    }

    public void setActionBarFitStatusBar(boolean z) {
    }

    public void setActionBarTabMinWidth(int i) {
    }

    public void setActionBarTabPadding(int i, int i2) {
    }

    public void setAdaptTabWith(boolean z) {
    }

    public abstract void setBackgroundDrawable(@Nullable Drawable drawable);

    public void setBottomBarCustomView(View view) {
    }

    public void setCapsuleStyleEnable(boolean z) {
    }

    public void setContentInsetsRelative(int i, int i2) {
    }

    public void setControlButton(@IntRange int i, @Nullable ControlButton controlButton) {
        if (i == 0) {
            this.mNegativeBtn = controlButton;
            ControlButtonConfigure controlButtonConfigure = this.mNegativeCtlBtnCfg;
            if (controlButtonConfigure != null) {
                if (controlButton != null) {
                    controlButtonConfigure.configControlBtn(controlButton);
                }
                this.mNegativeCtlBtnCfg = null;
            }
        } else if (i == 1) {
            this.mPositiveBtn = controlButton;
            ControlButtonConfigure controlButtonConfigure2 = this.mPositiveCtlBtnCfg;
            if (controlButtonConfigure2 != null) {
                if (controlButton != null) {
                    controlButtonConfigure2.configControlBtn(controlButton);
                }
                this.mPositiveCtlBtnCfg = null;
            }
        } else {
            throw new InvalidParameterException();
        }
    }

    public abstract void setControlTitleTextColor(@ColorInt int i);

    public abstract void setCustomView(int i);

    public abstract void setCustomView(View view);

    public abstract void setCustomView(View view, LayoutParams layoutParams);

    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
    }

    public abstract void setDisplayHomeAsUpEnabled(boolean z);

    public abstract void setDisplayOptions(int i);

    public abstract void setDisplayOptions(int i, int i2);

    public abstract void setDisplayShowControlTitleBar(boolean z);

    public abstract void setDisplayShowControlTitleBar(boolean z, ControlTitleBarCallback controlTitleBarCallback);

    public abstract void setDisplayShowCustomEnabled(boolean z);

    public abstract void setDisplayShowHomeEnabled(boolean z);

    public abstract void setDisplayShowTabEnabled(boolean z);

    public abstract void setDisplayShowTitleEnabled(boolean z);

    public abstract void setDisplayUseLogoEnabled(boolean z);

    public void setDropDownCallback(DropDownCallback dropDownCallback) {
    }

    public void setDropDownStartY(int i) {
    }

    public void setDropDownView(View view) {
    }

    public void setElevation(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void setExpanded(boolean z, boolean z2) {
    }

    public void setHideOffset(int i) {
        if (i != 0) {
            throw new UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
        }
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public void setHomeActionContentDescription(@StringRes int i) {
    }

    public void setHomeAsUpIndicator(@DrawableRes int i) {
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public abstract void setIcon(@DrawableRes int i);

    public abstract void setIcon(Drawable drawable);

    public abstract void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, OnNavigationListener onNavigationListener);

    public abstract void setLogo(@DrawableRes int i);

    public abstract void setLogo(Drawable drawable);

    public abstract void setNavigationMode(int i);

    public void setOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
    }

    public void setOverlayMode(boolean z) {
    }

    public void setScrollTabAllowCollapse(boolean z) {
    }

    public void setScrollTabCollapseButtonClickListener(View.OnClickListener onClickListener) {
    }

    public void setScrollTabCollapseDrawable(Drawable drawable) {
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
    }

    public abstract void setSelectedNavigationItem(int i);

    public void setShowHideAnimationEnabled(boolean z) {
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setSplitBarFitSystemWindows(boolean z) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
    }

    public void setStackedTabsCanBeEmbedded(boolean z) {
    }

    public abstract void setSubtitle(int i);

    public abstract void setSubtitle(CharSequence charSequence);

    public void setTabIndicatorDrawable(Drawable drawable) {
    }

    public abstract void setTabScrolled(int i, float f, int i2);

    public void setTabsGravity(int i) {
    }

    public abstract void setTitle(@StringRes int i);

    public abstract void setTitle(CharSequence charSequence);

    public abstract void setTitleTextColor(@ColorInt int i);

    public void setUiOptions(int i) {
    }

    public void setWindowTitle(CharSequence charSequence) {
    }

    public abstract void show();

    public void show(int i) {
        show();
    }

    public void showDropDown() {
    }

    public void showScrollTabs(OnScrollTabsVisibilityChangeListener onScrollTabsVisibilityChangeListener) {
    }

    public void showSplitActionBar() {
    }

    public void showTabBar() {
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        return null;
    }

    public ActionMode startMultiChoiceActionMode(ActionMode.Callback callback) {
        return null;
    }

    public void setHomeActionContentDescription(@Nullable CharSequence charSequence) {
    }

    public void setHomeAsUpIndicator(@Nullable Drawable drawable) {
    }

    public void setScrollTabCollapseButtonClickListener(TabCollapseButton.OnTabCollapseButtonClickListener onTabCollapseButtonClickListener) {
    }

    public void setScrollTabsExpendView(View view, AloneTabContainer aloneTabContainer) {
    }

    public void showDropDown(int i) {
    }

    public void showDropDown(View view, DropDownCallback dropDownCallback) {
    }

    public void showDropDown(View view, DropDownCallback dropDownCallback, int i) {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBarLayout);
            this.gravity = obtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = 8388627;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.gravity = i3;
        }

        public LayoutParams(int i) {
            this(-2, -1, i);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }
    }

    public void showDropDown(View view) {
        showDropDown(view, (DropDownCallback) null);
    }
}
