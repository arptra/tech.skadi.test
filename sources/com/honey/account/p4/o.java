package com.honey.account.p4;

import android.view.MenuItem;
import com.upuphone.ar.tici.phone.TiciHistoryActivity;
import flyme.support.v7.widget.PopupMenu;

public final /* synthetic */ class o implements PopupMenu.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TiciHistoryActivity f5062a;

    public /* synthetic */ o(TiciHistoryActivity ticiHistoryActivity) {
        this.f5062a = ticiHistoryActivity;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return TiciHistoryActivity.x1(this.f5062a, menuItem);
    }
}
