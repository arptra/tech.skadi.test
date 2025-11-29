package com.upuphone.xr.sapp;

import android.view.MenuItem;
import flyme.support.v7.widget.PopupMenu;

public final /* synthetic */ class a implements PopupMenu.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TodoManageActivity f6598a;

    public /* synthetic */ a(TodoManageActivity todoManageActivity) {
        this.f6598a = todoManageActivity;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return TodoManageActivity$morePopupMenu$2.invoke$lambda$0(this.f6598a, menuItem);
    }
}
