package com.honey.account.d4;

import android.view.View;
import com.upuphone.ar.navi.lite.AddressSettingActivity;
import com.upuphone.ar.navi.lite.view.CustomDialog;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddressSettingActivity f4258a;
    public final /* synthetic */ CustomDialog b;

    public /* synthetic */ j(AddressSettingActivity addressSettingActivity, CustomDialog customDialog) {
        this.f4258a = addressSettingActivity;
        this.b = customDialog;
    }

    public final void onClick(View view) {
        this.f4258a.D1(this.b, view);
    }
}
