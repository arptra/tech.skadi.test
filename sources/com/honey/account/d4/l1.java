package com.honey.account.d4;

import android.view.View;
import com.upuphone.ar.navi.lite.SettingActivity;
import com.upuphone.ar.navi.lite.view.CarSetDialog;

public final /* synthetic */ class l1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SettingActivity f4266a;
    public final /* synthetic */ CarSetDialog b;

    public /* synthetic */ l1(SettingActivity settingActivity, CarSetDialog carSetDialog) {
        this.f4266a = settingActivity;
        this.b = carSetDialog;
    }

    public final void onClick(View view) {
        this.f4266a.Q1(this.b, view);
    }
}
