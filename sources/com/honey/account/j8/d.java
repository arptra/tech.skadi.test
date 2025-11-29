package com.honey.account.j8;

import android.view.View;
import com.upuphone.xr.sapp.guide.adapter.WifiListAdapter;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiListAdapter f4892a;
    public final /* synthetic */ int b;

    public /* synthetic */ d(WifiListAdapter wifiListAdapter, int i) {
        this.f4892a = wifiListAdapter;
        this.b = i;
    }

    public final void onClick(View view) {
        WifiListAdapter.B(this.f4892a, this.b, view);
    }
}
