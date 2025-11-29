package com.honey.account.j8;

import android.view.View;
import com.upuphone.xr.sapp.guide.adapter.WifiListAdapter;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiListAdapter.PairWifiContentHolder f4894a;
    public final /* synthetic */ WifiListAdapter b;
    public final /* synthetic */ int c;

    public /* synthetic */ f(WifiListAdapter.PairWifiContentHolder pairWifiContentHolder, WifiListAdapter wifiListAdapter, int i) {
        this.f4894a = pairWifiContentHolder;
        this.b = wifiListAdapter;
        this.c = i;
    }

    public final void onClick(View view) {
        WifiListAdapter.D(this.f4894a, this.b, this.c, view);
    }
}
