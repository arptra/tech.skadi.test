package com.honey.account.p4;

import android.view.View;
import com.upuphone.ar.tici.phone.TiciHistoryActivity;
import flyme.support.v7.widget.PopupMenu;

public final /* synthetic */ class n implements PopupMenu.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f5060a;

    public /* synthetic */ n(View view) {
        this.f5060a = view;
    }

    public final void onDismiss(PopupMenu popupMenu) {
        TiciHistoryActivity.v1(this.f5060a, popupMenu);
    }
}
