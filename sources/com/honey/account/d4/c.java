package com.honey.account.d4;

import android.content.Context;
import android.view.View;
import com.upuphone.ar.navi.lite.AddressActivity;
import com.upuphone.ar.navi.lite.view.CustomDialog;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddressActivity f4237a;
    public final /* synthetic */ CustomDialog b;
    public final /* synthetic */ Context c;

    public /* synthetic */ c(AddressActivity addressActivity, CustomDialog customDialog, Context context) {
        this.f4237a = addressActivity;
        this.b = customDialog;
        this.c = context;
    }

    public final void onClick(View view) {
        this.f4237a.p1(this.b, this.c, view);
    }
}
