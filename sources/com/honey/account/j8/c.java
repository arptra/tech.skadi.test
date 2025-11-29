package com.honey.account.j8;

import android.view.View;
import com.upuphone.xr.sapp.guide.adapter.WifiListAdapter;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiListAdapter f4891a;
    public final /* synthetic */ int b;

    public /* synthetic */ c(WifiListAdapter wifiListAdapter, int i) {
        this.f4891a = wifiListAdapter;
        this.b = i;
    }

    public final void onClick(View view) {
        WifiListAdapter.A(this.f4891a, this.b, view);
    }
}
