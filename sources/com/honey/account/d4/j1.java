package com.honey.account.d4;

import android.view.View;
import com.upuphone.ar.navi.lite.SettingActivity;
import com.upuphone.ar.navi.lite.view.CustomDialog;

public final /* synthetic */ class j1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SettingActivity f4260a;
    public final /* synthetic */ CustomDialog b;

    public /* synthetic */ j1(SettingActivity settingActivity, CustomDialog customDialog) {
        this.f4260a = settingActivity;
        this.b = customDialog;
    }

    public final void onClick(View view) {
        this.f4260a.S1(this.b, view);
    }
}
