package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f231a;
    public LayoutInflater b;
    public MenuBuilder c;
    public ExpandedMenuView d;
    public int e;
    public int f;
    public int g;
    public MenuPresenter.Callback h;
    public MenuAdapter i;
    public int j;

    public class MenuAdapter extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        public int f232a = -1;

        public MenuAdapter() {
            a();
        }

        public void a() {
            MenuItemImpl expandedItem = ListMenuPresenter.this.c.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.c.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (nonActionItems.get(i) == expandedItem) {
                        this.f232a = i;
                        return;
                    }
                }
            }
            this.f232a = -1;
        }

        /* renamed from: b */
        public MenuItemImpl getItem(int i) {
            ArrayList<MenuItemImpl> nonActionItems = ListMenuPresenter.this.c.getNonActionItems();
            int i2 = i + ListMenuPresenter.this.e;
            int i3 = this.f232a;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return nonActionItems.get(i2);
        }

        public int getCount() {
            int size = ListMenuPresenter.this.c.getNonActionItems().size() - ListMenuPresenter.this.e;
            return this.f232a < 0 ? size : size - 1;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                ListMenuPresenter listMenuPresenter = ListMenuPresenter.this;
                view = listMenuPresenter.b.inflate(listMenuPresenter.g, viewGroup, false);
            }
            ((MenuView.ItemView) view).initialize(getItem(i), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(Context context, int i2) {
        this(i2, 0);
        this.f231a = context;
        this.b = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.i == null) {
            this.i = new MenuAdapter();
        }
        return this.i;
    }

    public MenuView b(ViewGroup viewGroup) {
        if (this.d == null) {
            this.d = (ExpandedMenuView) this.b.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.i == null) {
                this.i = new MenuAdapter();
            }
            this.d.setAdapter(this.i);
            this.d.setOnItemClickListener(this);
        }
        return this.d;
    }

    public void c(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(flyme.support.v7.view.menu.ListMenuPresenter.VIEWS_TAG);
        if (sparseParcelableArray != null) {
            this.d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void d(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray(flyme.support.v7.view.menu.ListMenuPresenter.VIEWS_TAG, sparseArray);
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return this.j;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        if (this.f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f);
            this.f231a = contextThemeWrapper;
            this.b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f231a != null) {
            this.f231a = context;
            if (this.b == null) {
                this.b = LayoutInflater.from(context);
            }
        }
        this.c = menuBuilder;
        MenuAdapter menuAdapter = this.i;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.h;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        this.c.performItemAction(this.i.getItem(i2), this, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        c((Bundle) parcelable);
    }

    public Parcelable onSaveInstanceState() {
        if (this.d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        d(bundle);
        return bundle;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new MenuDialogHelper(subMenuBuilder).c((IBinder) null);
        MenuPresenter.Callback callback = this.h;
        if (callback == null) {
            return true;
        }
        callback.a(subMenuBuilder);
        return true;
    }

    public void setCallback(MenuPresenter.Callback callback) {
        this.h = callback;
    }

    public void updateMenuView(boolean z) {
        MenuAdapter menuAdapter = this.i;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(int i2, int i3) {
        this.g = i2;
        this.f = i3;
    }
}
