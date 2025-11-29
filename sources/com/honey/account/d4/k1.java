package com.honey.account.d4;

import android.view.View;
import com.upuphone.ar.navi.lite.SettingActivity;
import com.upuphone.ar.navi.lite.view.CarSetDialog;

public final /* synthetic */ class k1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SettingActivity f4263a;
    public final /* synthetic */ CarSetDialog b;

    public /* synthetic */ k1(SettingActivity settingActivity, CarSetDialog carSetDialog) {
        this.f4263a = settingActivity;
        this.b = carSetDialog;
    }

    public final void onClick(View view) {
        this.f4263a.P1(this.b, view);
    }
}
