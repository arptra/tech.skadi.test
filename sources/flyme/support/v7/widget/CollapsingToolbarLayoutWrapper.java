package flyme.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import androidx.core.view.ViewPropertyAnimatorCompat;
import flyme.support.v7.app.ActionBar;
import flyme.support.v7.view.menu.MenuBuilder;
import flyme.support.v7.view.menu.MenuPresenter;

public class CollapsingToolbarLayoutWrapper implements DecorToolbar {
    private MzCollapsingToolbarLayout mCollapsingToolbarLayout;
    private DecorToolbar mDecorToolbar;
    private int mDisplayOpts;
    private int mNavigationMode = 0;
    private ScrollingTabContainerView mTabView;

    public CollapsingToolbarLayoutWrapper(MzCollapsingToolbarLayout mzCollapsingToolbarLayout, DecorToolbar decorToolbar) {
        this.mCollapsingToolbarLayout = mzCollapsingToolbarLayout;
        this.mDecorToolbar = decorToolbar;
        this.mDisplayOpts = decorToolbar.getDisplayOptions();
    }

    public void animateToVisibility(int i) {
        this.mDecorToolbar.animateToVisibility(i);
    }

    public boolean canShowOverflowMenu() {
        return this.mDecorToolbar.canShowOverflowMenu();
    }

    public boolean canSplit() {
        return this.mDecorToolbar.canSplit();
    }

    public void collapseActionView() {
        this.mDecorToolbar.collapseActionView();
    }

    public void dismissPopupMenus() {
        this.mDecorToolbar.dismissPopupMenus();
    }

    public Context getContext() {
        return this.mDecorToolbar.getContext();
    }

    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    public int getDisplayOptions() {
        return this.mDisplayOpts;
    }

    public int getDropdownItemCount() {
        return this.mDecorToolbar.getDropdownItemCount();
    }

    public int getDropdownSelectedPosition() {
        return this.mDecorToolbar.getDropdownSelectedPosition();
    }

    public int getHeight() {
        return this.mDecorToolbar.getHeight();
    }

    public Menu getMenu() {
        return this.mDecorToolbar.getMenu();
    }

    public int getNavigationMode() {
        return this.mNavigationMode;
    }

    public Drawable getOverflowIcon() {
        return this.mDecorToolbar.getOverflowIcon();
    }

    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }

    public MzActionBarTabContainer getTabContainer() {
        return null;
    }

    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    public ViewGroup getViewGroup() {
        return this.mDecorToolbar.getViewGroup();
    }

    public int getVisibility() {
        return this.mDecorToolbar.getVisibility();
    }

    public boolean hasEmbeddedTabs() {
        return this.mTabView != null;
    }

    public boolean hasExpandedActionView() {
        return this.mDecorToolbar.hasExpandedActionView();
    }

    public boolean hasIcon() {
        return this.mDecorToolbar.hasIcon();
    }

    public boolean hasLogo() {
        return this.mDecorToolbar.hasLogo();
    }

    public boolean hideOverflowMenu() {
        return this.mDecorToolbar.hideOverflowMenu();
    }

    public void initIndeterminateProgress() {
        this.mDecorToolbar.initIndeterminateProgress();
    }

    public void initProgress() {
        this.mDecorToolbar.initProgress();
    }

    public boolean isOverflowMenuShowPending() {
        return this.mDecorToolbar.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        return this.mDecorToolbar.isOverflowMenuShowing();
    }

    public boolean isShowNavigationCustomView() {
        return this.mDecorToolbar.isShowNavigationCustomView();
    }

    public boolean isShowNavigationMenu() {
        return this.mDecorToolbar.isShowNavigationMenu();
    }

    public boolean isSplit() {
        return this.mDecorToolbar.isSplit();
    }

    public boolean isTitleTruncated() {
        return this.mDecorToolbar.isTitleTruncated();
    }

    public void reSetSplitViewHeight(ViewGroup viewGroup) {
    }

    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.mDecorToolbar.restoreHierarchyState(sparseArray);
    }

    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.mDecorToolbar.saveHierarchyState(sparseArray);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mDecorToolbar.setBackgroundDrawable(drawable);
    }

    public void setCollapsible(boolean z) {
        this.mDecorToolbar.setCollapsible(z);
    }

    public void setContentInsetsRelative(int i, int i2) {
        this.mDecorToolbar.setContentInsetsRelative(i, i2);
    }

    public void setControlTitleBarCallback(ActionBar.ControlTitleBarCallback controlTitleBarCallback) {
        this.mDecorToolbar.setControlTitleBarCallback(controlTitleBarCallback);
    }

    public void setControlTitleTextColor(int i) {
        this.mDecorToolbar.setControlTitleTextColor(i);
    }

    public void setCustomView(View view) {
        this.mDecorToolbar.setCustomView(view);
    }

    public void setDefaultNavigationContentDescription(int i) {
        this.mDecorToolbar.setDefaultNavigationContentDescription(i);
    }

    public void setDefaultNavigationIcon(Drawable drawable) {
        this.mDecorToolbar.setDefaultNavigationIcon(drawable);
    }

    public void setDisplayOptions(int i) {
        ScrollingTabContainerView scrollingTabContainerView;
        int i2 = this.mDisplayOpts ^ i;
        this.mDisplayOpts = i;
        if (i2 != 0) {
            if ((i2 & 32) == 0 || (scrollingTabContainerView = this.mTabView) == null) {
                this.mDecorToolbar.setDisplayOptions(i);
            } else if ((i & 32) == 0) {
                this.mCollapsingToolbarLayout.setTabLayout((ScrollingTabContainerView) null);
            } else if (this.mNavigationMode == 2) {
                this.mCollapsingToolbarLayout.setTabLayout(scrollingTabContainerView);
            }
            if ((i & 8) != 0) {
                this.mCollapsingToolbarLayout.setTitle(this.mDecorToolbar.getTitle());
            } else {
                this.mCollapsingToolbarLayout.setTitle((CharSequence) null);
            }
        }
    }

    public void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.mDecorToolbar.setDropdownParams(spinnerAdapter, onItemSelectedListener);
    }

    public void setDropdownSelectedPosition(int i) {
        this.mDecorToolbar.setDropdownSelectedPosition(i);
    }

    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        MzCollapsingToolbarLayout mzCollapsingToolbarLayout;
        ScrollingTabContainerView scrollingTabContainerView2 = this.mTabView;
        if (scrollingTabContainerView2 != null && scrollingTabContainerView2.getParent() == (mzCollapsingToolbarLayout = this.mCollapsingToolbarLayout)) {
            mzCollapsingToolbarLayout.removeView(this.mTabView);
        }
        this.mTabView = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.showAtToolbar(true);
            if (this.mNavigationMode == 2) {
                this.mCollapsingToolbarLayout.setTabLayout(this.mTabView);
            }
        }
    }

    public void setHomeButtonEnabled(boolean z) {
        this.mDecorToolbar.setHomeButtonEnabled(z);
    }

    public void setIcon(int i) {
        this.mDecorToolbar.setIcon(i);
    }

    public void setLogo(int i) {
        this.mDecorToolbar.setLogo(i);
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        this.mDecorToolbar.setMenu(menu, callback);
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mDecorToolbar.setMenuCallbacks(callback, callback2);
    }

    public void setMenuPrepared() {
        this.mDecorToolbar.setMenuPrepared();
    }

    public void setNavigationBarCustomView(View view) {
        this.mDecorToolbar.setNavigationBarCustomView(view);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        this.mDecorToolbar.setNavigationContentDescription(charSequence);
    }

    public void setNavigationIcon(Drawable drawable) {
        this.mDecorToolbar.setNavigationIcon(drawable);
    }

    public void setNavigationMenu(Menu menu, MenuPresenter.Callback callback) {
        this.mDecorToolbar.setNavigationMenu(menu, callback);
    }

    public void setNavigationMode(int i) {
        ScrollingTabContainerView scrollingTabContainerView;
        MzCollapsingToolbarLayout mzCollapsingToolbarLayout;
        int i2 = this.mNavigationMode;
        if (i != i2) {
            if (i2 == 1) {
                this.mDecorToolbar.setNavigationMode(i);
            } else if (i2 == 2 && (scrollingTabContainerView = this.mTabView) != null && scrollingTabContainerView.getParent() == (mzCollapsingToolbarLayout = this.mCollapsingToolbarLayout)) {
                mzCollapsingToolbarLayout.removeView(this.mTabView);
            }
            this.mNavigationMode = i;
            if (i == 0) {
                return;
            }
            if (i == 1) {
                this.mDecorToolbar.setNavigationMode(i);
            } else if (i == 2) {
                ScrollingTabContainerView scrollingTabContainerView2 = this.mTabView;
                if (scrollingTabContainerView2 != null) {
                    this.mCollapsingToolbarLayout.setTabLayout(scrollingTabContainerView2);
                }
            } else {
                throw new IllegalArgumentException("Invalid navigation mode " + i);
            }
        }
    }

    public void setOverflowIcon(Drawable drawable) {
        this.mDecorToolbar.setOverflowIcon(drawable);
    }

    public void setShowNavigationMenu(boolean z) {
        this.mDecorToolbar.setShowNavigationMenu(z);
    }

    public void setSplitToolbar(boolean z) {
        this.mDecorToolbar.setSplitToolbar(z);
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.mDecorToolbar.setSplitView(viewGroup);
    }

    public void setSplitWhenNarrow(boolean z) {
        this.mDecorToolbar.setSplitWhenNarrow(z);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mDecorToolbar.setSubtitle(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.mDecorToolbar.setTitle(charSequence);
        if ((this.mDisplayOpts & 8) != 0) {
            this.mCollapsingToolbarLayout.setTitle(charSequence);
        }
    }

    public void setTitleTextColor(int i) {
        this.mDecorToolbar.setTitleTextColor(i);
        this.mCollapsingToolbarLayout.setTitleTextColor(i);
    }

    public void setVisibility(int i) {
        this.mDecorToolbar.setVisibility(i);
    }

    public void setWindowCallback(Window.Callback callback) {
        this.mDecorToolbar.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i, long j) {
        return this.mDecorToolbar.setupAnimatorToVisibility(i, j);
    }

    public boolean showOverflowMenu() {
        return this.mDecorToolbar.showOverflowMenu();
    }

    public void setIcon(Drawable drawable) {
        this.mDecorToolbar.setIcon(drawable);
    }

    public void setLogo(Drawable drawable) {
        this.mDecorToolbar.setLogo(drawable);
    }

    public void setNavigationContentDescription(int i) {
        this.mDecorToolbar.setNavigationContentDescription(i);
    }

    public void setNavigationIcon(int i) {
        this.mDecorToolbar.setNavigationIcon(i);
    }
}
