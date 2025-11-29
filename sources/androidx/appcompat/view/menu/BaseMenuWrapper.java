package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

abstract class BaseMenuWrapper {

    /* renamed from: a  reason: collision with root package name */
    public final Context f223a;
    public SimpleArrayMap b;
    public SimpleArrayMap c;

    public BaseMenuWrapper(Context context) {
        this.f223a = context;
    }

    public final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.b == null) {
            this.b = new SimpleArrayMap();
        }
        MenuItem menuItem2 = (MenuItem) this.b.get(supportMenuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.f223a, supportMenuItem);
        this.b.put(supportMenuItem, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    public final SubMenu b(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.c == null) {
            this.c = new SimpleArrayMap();
        }
        SubMenu subMenu2 = (SubMenu) this.c.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenuWrapperICS subMenuWrapperICS = new SubMenuWrapperICS(this.f223a, supportSubMenu);
        this.c.put(supportSubMenu, subMenuWrapperICS);
        return subMenuWrapperICS;
    }

    public final void c() {
        SimpleArrayMap simpleArrayMap = this.b;
        if (simpleArrayMap != null) {
            simpleArrayMap.clear();
        }
        SimpleArrayMap simpleArrayMap2 = this.c;
        if (simpleArrayMap2 != null) {
            simpleArrayMap2.clear();
        }
    }

    public final void d(int i) {
        if (this.b != null) {
            int i2 = 0;
            while (i2 < this.b.size()) {
                if (((SupportMenuItem) this.b.j(i2)).getGroupId() == i) {
                    this.b.l(i2);
                    i2--;
                }
                i2++;
            }
        }
    }

    public final void e(int i) {
        if (this.b != null) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                if (((SupportMenuItem) this.b.j(i2)).getItemId() == i) {
                    this.b.l(i2);
                    return;
                }
            }
        }
    }
}
