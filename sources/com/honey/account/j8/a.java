package com.honey.account.j8;

import android.view.View;
import com.upuphone.xr.sapp.guide.adapter.WifiListAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiListAdapter f4889a;
    public final /* synthetic */ int b;

    public /* synthetic */ a(WifiListAdapter wifiListAdapter, int i) {
        this.f4889a = wifiListAdapter;
        this.b = i;
    }

    public final void onClick(View view) {
        WifiListAdapter.y(this.f4889a, this.b, view);
    }
}
