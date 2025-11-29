package flyme.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import flyme.support.v7.view.menu.MenuPresenter;

public interface DecorContentParent {
    boolean canShowOverflowMenu();

    void dismissPopups();

    CharSequence getTitle();

    boolean hasIcon();

    boolean hasLogo();

    void hideBackTopButton();

    boolean hideOverflowMenu();

    void initFeature(int i);

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray);

    void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray);

    void setBackTopBackground(Drawable drawable);

    void setBackTopClickCallback(View.OnClickListener onClickListener);

    void setBackTopEnable(boolean z);

    void setBottomMenu(Menu menu, MenuPresenter.Callback callback);

    void setIcon(int i);

    void setIcon(Drawable drawable);

    void setLogo(int i);

    void setMenu(Menu menu, MenuPresenter.Callback callback);

    void setMenuPrepared();

    void setTransStatusBarInFlyme3(boolean z);

    void setUiOptions(int i);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void showBackTopButton();

    boolean showOverflowMenu();
}
