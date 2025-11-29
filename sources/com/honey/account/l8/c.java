package com.honey.account.l8;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.xr.sapp.guide.wifi.WifiSettingFragment;

public final /* synthetic */ class c implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiSettingFragment f4934a;

    public /* synthetic */ c(WifiSettingFragment wifiSettingFragment) {
        this.f4934a = wifiSettingFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return WifiSettingFragment.o1(this.f4934a, view, motionEvent);
    }
}
