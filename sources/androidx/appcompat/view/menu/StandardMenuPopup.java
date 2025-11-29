package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;

final class StandardMenuPopup extends MenuPopup implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, MenuPresenter, View.OnKeyListener {
    public static final int v = R.layout.abc_popup_menu_item_layout;
    public final Context b;
    public final MenuBuilder c;
    public final MenuAdapter d;
    public final boolean e;
    public final int f;
    public final int g;
    public final int h;
    public final MenuPopupWindow i;
    public final ViewTreeObserver.OnGlobalLayoutListener j = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (StandardMenuPopup.this.isShowing() && !StandardMenuPopup.this.i.isModal()) {
                View view = StandardMenuPopup.this.n;
                if (view == null || !view.isShown()) {
                    StandardMenuPopup.this.dismiss();
                } else {
                    StandardMenuPopup.this.i.show();
                }
            }
        }
    };
    public final View.OnAttachStateChangeListener k = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = StandardMenuPopup.this.p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    StandardMenuPopup.this.p = view.getViewTreeObserver();
                }
                StandardMenuPopup standardMenuPopup = StandardMenuPopup.this;
                standardMenuPopup.p.removeGlobalOnLayoutListener(standardMenuPopup.j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    public PopupWindow.OnDismissListener l;
    public View m;
    public View n;
    public MenuPresenter.Callback o;
    public ViewTreeObserver p;
    public boolean q;
    public boolean r;
    public int s;
    public int t = 0;
    public boolean u;

    public StandardMenuPopup(Context context, MenuBuilder menuBuilder, View view, int i2, int i3, boolean z) {
        this.b = context;
        this.c = menuBuilder;
        this.e = z;
        this.d = new MenuAdapter(menuBuilder, LayoutInflater.from(context), z, v);
        this.g = i2;
        this.h = i3;
        Resources resources = context.getResources();
        this.f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.m = view;
        this.i = new MenuPopupWindow(context, (AttributeSet) null, i2, i3);
        menuBuilder.addMenuPresenter(this, context);
    }

    private boolean o() {
        View view;
        if (isShowing()) {
            return true;
        }
        if (this.q || (view = this.m) == null) {
            return false;
        }
        this.n = view;
        this.i.setOnDismissListener(this);
        this.i.setOnItemClickListener(this);
        this.i.setModal(true);
        View view2 = this.n;
        boolean z = this.p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.p = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.j);
        }
        view2.addOnAttachStateChangeListener(this.k);
        this.i.setAnchorView(view2);
        this.i.setDropDownGravity(this.t);
        if (!this.r) {
            this.s = MenuPopup.d(this.d, (ViewGroup) null, this.b, this.f);
            this.r = true;
        }
        this.i.setContentWidth(this.s);
        this.i.setInputMethodMode(2);
        this.i.setEpicenterBounds(c());
        this.i.show();
        ListView listView = this.i.getListView();
        listView.setOnKeyListener(this);
        if (this.u && this.c.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.b).inflate(R.layout.abc_popup_menu_header_item_layout, listView, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.c.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            listView.addHeaderView(frameLayout, (Object) null, false);
        }
        this.i.setAdapter(this.d);
        this.i.show();
        return true;
    }

    public void a(MenuBuilder menuBuilder) {
    }

    public void dismiss() {
        if (isShowing()) {
            this.i.dismiss();
        }
    }

    public void e(View view) {
        this.m = view;
    }

    public boolean flagActionItems() {
        return false;
    }

    public void g(boolean z) {
        this.d.d(z);
    }

    public ListView getListView() {
        return this.i.getListView();
    }

    public void h(int i2) {
        this.t = i2;
    }

    public void i(int i2) {
        this.i.setHorizontalOffset(i2);
    }

    public boolean isShowing() {
        return !this.q && this.i.isShowing();
    }

    public void j(PopupWindow.OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }

    public void k(boolean z) {
        this.u = z;
    }

    public void l(int i2) {
        this.i.setVerticalOffset(i2);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.c) {
            dismiss();
            MenuPresenter.Callback callback = this.o;
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }
    }

    public void onDismiss() {
        this.q = true;
        this.c.close();
        ViewTreeObserver viewTreeObserver = this.p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.p = this.n.getViewTreeObserver();
            }
            this.p.removeGlobalOnLayoutListener(this.j);
            this.p = null;
        }
        this.n.removeOnAttachStateChangeListener(this.k);
        PopupWindow.OnDismissListener onDismissListener = this.l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.b, subMenuBuilder, this.n, this.e, this.g, this.h);
            menuPopupHelper.j(this.o);
            menuPopupHelper.g(MenuPopup.m(subMenuBuilder));
            menuPopupHelper.i(this.l);
            this.l = null;
            this.c.close(false);
            int horizontalOffset = this.i.getHorizontalOffset();
            int verticalOffset = this.i.getVerticalOffset();
            if ((Gravity.getAbsoluteGravity(this.t, ViewCompat.z(this.m)) & 7) == 5) {
                horizontalOffset += this.m.getWidth();
            }
            if (menuPopupHelper.n(horizontalOffset, verticalOffset)) {
                MenuPresenter.Callback callback = this.o;
                if (callback == null) {
                    return true;
                }
                callback.a(subMenuBuilder);
                return true;
            }
        }
        return false;
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.o = callback;
    }

    public void show() {
        if (!o()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void updateMenuView(boolean z) {
        this.r = false;
        MenuAdapter menuAdapter = this.d;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }
}
