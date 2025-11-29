package com.honey.account.x8;

import android.view.View;
import com.upuphone.xr.sapp.view.GenericMenuView;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericMenuView.MenuItem f7660a;
    public final /* synthetic */ GenericMenuView.MenuItemClickListener b;

    public /* synthetic */ f(GenericMenuView.MenuItem menuItem, GenericMenuView.MenuItemClickListener menuItemClickListener) {
        this.f7660a = menuItem;
        this.b = menuItemClickListener;
    }

    public final void onClick(View view) {
        GenericMenuView.MenuItemView.i(this.f7660a, this.b, view);
    }
}
