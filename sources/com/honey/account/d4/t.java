package com.honey.account.d4;

import android.view.View;
import com.upuphone.ar.navi.lite.AddressSettingActivity;
import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.ar.navi.lite.view.CustomDialog;

public final /* synthetic */ class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddressSettingActivity f4287a;
    public final /* synthetic */ CustomDialog b;
    public final /* synthetic */ SearchModel c;

    public /* synthetic */ t(AddressSettingActivity addressSettingActivity, CustomDialog customDialog, SearchModel searchModel) {
        this.f4287a = addressSettingActivity;
        this.b = customDialog;
        this.c = searchModel;
    }

    public final void onClick(View view) {
        this.f4287a.O1(this.b, this.c, view);
    }
}
