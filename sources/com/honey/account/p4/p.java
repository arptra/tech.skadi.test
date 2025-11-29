package com.honey.account.p4;

import android.view.View;
import com.upuphone.ar.tici.phone.TiciHistoryActivity;
import flyme.support.v7.widget.PopupMenu;

public final /* synthetic */ class p implements PopupMenu.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f5064a;

    public /* synthetic */ p(View view) {
        this.f5064a = view;
    }

    public final void onDismiss(PopupMenu popupMenu) {
        TiciHistoryActivity.y1(this.f5064a, popupMenu);
    }
}
