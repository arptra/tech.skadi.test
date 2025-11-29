package com.honey.account.j8;

import android.view.View;
import com.upuphone.xr.sapp.guide.adapter.WifiListAdapter;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiListAdapter.WifiSwitchHolder f4890a;
    public final /* synthetic */ WifiListAdapter b;

    public /* synthetic */ b(WifiListAdapter.WifiSwitchHolder wifiSwitchHolder, WifiListAdapter wifiListAdapter) {
        this.f4890a = wifiSwitchHolder;
        this.b = wifiListAdapter;
    }

    public final void onClick(View view) {
        WifiListAdapter.z(this.f4890a, this.b, view);
    }
}
