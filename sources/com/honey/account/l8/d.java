package com.honey.account.l8;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.xr.sapp.guide.wifi.WifiSettingFragment;

public final /* synthetic */ class d implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiSettingFragment f4935a;

    public /* synthetic */ d(WifiSettingFragment wifiSettingFragment) {
        this.f4935a = wifiSettingFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return WifiSettingFragment.p1(this.f4935a, view, motionEvent);
    }
}
