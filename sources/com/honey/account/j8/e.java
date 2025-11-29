package com.honey.account.j8;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.xr.sapp.guide.adapter.WifiListAdapter;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class e implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiListAdapter f4893a;
    public final /* synthetic */ Ref.FloatRef b;
    public final /* synthetic */ Ref.FloatRef c;
    public final /* synthetic */ Ref.IntRef d;
    public final /* synthetic */ WifiListAdapter.PairWifiContentHolder e;
    public final /* synthetic */ int f;

    public /* synthetic */ e(WifiListAdapter wifiListAdapter, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.IntRef intRef, WifiListAdapter.PairWifiContentHolder pairWifiContentHolder, int i) {
        this.f4893a = wifiListAdapter;
        this.b = floatRef;
        this.c = floatRef2;
        this.d = intRef;
        this.e = pairWifiContentHolder;
        this.f = i;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return WifiListAdapter.C(this.f4893a, this.b, this.c, this.d, this.e, this.f, view, motionEvent);
    }
}
