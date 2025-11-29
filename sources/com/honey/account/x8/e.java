package com.honey.account.x8;

import android.view.View;
import com.upuphone.xr.sapp.view.GenericMenuView;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericMenuView.MenuAdapter f7659a;
    public final /* synthetic */ int b;

    public /* synthetic */ e(GenericMenuView.MenuAdapter menuAdapter, int i) {
        this.f7659a = menuAdapter;
        this.b = i;
    }

    public final void onClick(View view) {
        GenericMenuView.MenuAdapter.i(this.f7659a, this.b, view);
    }
}
