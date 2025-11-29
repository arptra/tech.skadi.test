package com.honey.account.p4;

import android.view.MenuItem;
import com.upuphone.ar.tici.phone.TiciHistoryActivity;
import com.upuphone.ar.tici.phone.data.TiciHistory;
import flyme.support.v7.widget.PopupMenu;

public final /* synthetic */ class z implements PopupMenu.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TiciHistoryActivity f5083a;
    public final /* synthetic */ TiciHistory b;

    public /* synthetic */ z(TiciHistoryActivity ticiHistoryActivity, TiciHistory ticiHistory) {
        this.f5083a = ticiHistoryActivity;
        this.b = ticiHistory;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return TiciHistoryActivity.u1(this.f5083a, this.b, menuItem);
    }
}
