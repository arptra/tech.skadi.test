package com.honey.account.l8;

import android.widget.CompoundButton;
import com.upuphone.xr.sapp.guide.wifi.WifiSettingFragment;

public final /* synthetic */ class a implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiSettingFragment f4932a;

    public /* synthetic */ a(WifiSettingFragment wifiSettingFragment) {
        this.f4932a = wifiSettingFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        WifiSettingFragment.s1(this.f4932a, compoundButton, z);
    }
}
