package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo
public abstract class BaseMenuPresenter implements MenuPresenter {

    /* renamed from: a  reason: collision with root package name */
    public Context f222a;
    public Context b;
    public MenuBuilder c;
    public LayoutInflater d;
    public LayoutInflater e;
    public MenuPresenter.Callback f;
    public int g;
    public int h;
    public MenuView i;
    public int j;

    public BaseMenuPresenter(Context context, int i2, int i3) {
        this.f222a = context;
        this.d = LayoutInflater.from(context);
        this.g = i2;
        this.h = i3;
    }

    public void a(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.i).addView(view, i2);
    }

    public abstract void b(MenuItemImpl menuItemImpl, MenuView.ItemView itemView);

    public MenuView.ItemView c(ViewGroup viewGroup) {
        return (MenuView.ItemView) this.d.inflate(this.h, viewGroup, false);
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean d(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    public MenuPresenter.Callback e() {
        return this.f;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public View f(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        MenuView.ItemView c2 = view instanceof MenuView.ItemView ? (MenuView.ItemView) view : c(viewGroup);
        b(menuItemImpl, c2);
        return (View) c2;
    }

    public boolean flagActionItems() {
        return false;
    }

    public MenuView g(ViewGroup viewGroup) {
        if (this.i == null) {
            MenuView menuView = (MenuView) this.d.inflate(this.g, viewGroup, false);
            this.i = menuView;
            menuView.initialize(this.c);
            updateMenuView(true);
        }
        return this.i;
    }

    public int getId() {
        return this.j;
    }

    public void h(int i2) {
        this.j = i2;
    }

    public boolean i(int i2, MenuItemImpl menuItemImpl) {
        return true;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.b = context;
        this.e = LayoutInflater.from(context);
        this.c = menuBuilder;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.f;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.SubMenuBuilder r2) {
        /*
            r1 = this;
            androidx.appcompat.view.menu.MenuPresenter$Callback r0 = r1.f
            if (r0 == 0) goto L_0x000e
            if (r2 == 0) goto L_0x0007
            goto L_0x0009
        L_0x0007:
            androidx.appcompat.view.menu.MenuBuilder r2 = r1.c
        L_0x0009:
            boolean r1 = r0.a(r2)
            return r1
        L_0x000e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.BaseMenuPresenter.onSubMenuSelected(androidx.appcompat.view.menu.SubMenuBuilder):boolean");
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.f = callback;
    }

    public void updateMenuView(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.i;
        if (viewGroup != null) {
            MenuBuilder menuBuilder = this.c;
            int i2 = 0;
            if (menuBuilder != null) {
                menuBuilder.flagActionItems();
                ArrayList<MenuItemImpl> visibleItems = this.c.getVisibleItems();
                int size = visibleItems.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    MenuItemImpl menuItemImpl = visibleItems.get(i4);
                    if (i(i3, menuItemImpl)) {
                        View childAt = viewGroup.getChildAt(i3);
                        MenuItemImpl itemData = childAt instanceof MenuView.ItemView ? ((MenuView.ItemView) childAt).getItemData() : null;
                        View f2 = f(menuItemImpl, childAt, viewGroup);
                        if (menuItemImpl != itemData) {
                            f2.setPressed(false);
                            f2.jumpDrawablesToCurrentState();
                        }
                        if (f2 != childAt) {
                            a(f2, i3);
                        }
                        i3++;
                    }
                }
                i2 = i3;
            }
            while (i2 < viewGroup.getChildCount()) {
                if (!d(viewGroup, i2)) {
                    i2++;
                }
            }
        }
    }
}
