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

public interface DecorToolbar {
    void animateToVisibility(int i);

    boolean canShowOverflowMenu();

    boolean canSplit();

    void collapseActionView();

    void dismissPopupMenus();

    Context getContext();

    View getCustomView();

    int getDisplayOptions();

    int getDropdownItemCount();

    int getDropdownSelectedPosition();

    int getHeight();

    Menu getMenu();

    int getNavigationMode();

    Drawable getOverflowIcon();

    CharSequence getSubtitle();

    MzActionBarTabContainer getTabContainer();

    CharSequence getTitle();

    ViewGroup getViewGroup();

    int getVisibility();

    boolean hasEmbeddedTabs();

    boolean hasExpandedActionView();

    boolean hasIcon();

    boolean hasLogo();

    boolean hideOverflowMenu();

    void initIndeterminateProgress();

    void initProgress();

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    boolean isShowNavigationCustomView();

    boolean isShowNavigationMenu();

    boolean isSplit();

    boolean isTitleTruncated();

    void reSetSplitViewHeight(ViewGroup viewGroup);

    void restoreHierarchyState(SparseArray<Parcelable> sparseArray);

    void saveHierarchyState(SparseArray<Parcelable> sparseArray);

    void setBackgroundDrawable(Drawable drawable);

    void setCollapsible(boolean z);

    void setContentInsetsRelative(int i, int i2);

    void setControlTitleBarCallback(ActionBar.ControlTitleBarCallback controlTitleBarCallback);

    void setControlTitleTextColor(int i);

    void setCustomView(View view);

    void setDefaultNavigationContentDescription(int i);

    void setDefaultNavigationIcon(Drawable drawable);

    void setDisplayOptions(int i);

    void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener);

    void setDropdownSelectedPosition(int i);

    void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView);

    void setHomeButtonEnabled(boolean z);

    void setIcon(int i);

    void setIcon(Drawable drawable);

    void setLogo(int i);

    void setLogo(Drawable drawable);

    void setMenu(Menu menu, MenuPresenter.Callback callback);

    void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2);

    void setMenuPrepared();

    void setNavigationBarCustomView(View view);

    void setNavigationContentDescription(int i);

    void setNavigationContentDescription(CharSequence charSequence);

    void setNavigationIcon(int i);

    void setNavigationIcon(Drawable drawable);

    void setNavigationMenu(Menu menu, MenuPresenter.Callback callback);

    void setNavigationMode(int i);

    void setOverflowIcon(Drawable drawable);

    void setShowNavigationMenu(boolean z);

    void setSplitToolbar(boolean z);

    void setSplitView(ViewGroup viewGroup);

    void setSplitWhenNarrow(boolean z);

    void setSubtitle(CharSequence charSequence);

    void setTitle(CharSequence charSequence);

    void setTitleTextColor(int i);

    void setVisibility(int i);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i, long j);

    boolean showOverflowMenu();
}
