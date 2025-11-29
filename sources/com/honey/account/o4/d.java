package com.honey.account.o4;

import android.view.View;
import com.upuphone.ar.navi.lite.view.AvoidLimitPopView;
import com.upuphone.ar.navi.lite.view.CustomDialog;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AvoidLimitPopView f4971a;
    public final /* synthetic */ CustomDialog b;

    public /* synthetic */ d(AvoidLimitPopView avoidLimitPopView, CustomDialog customDialog) {
        this.f4971a = avoidLimitPopView;
        this.b = customDialog;
    }

    public final void onClick(View view) {
        this.f4971a.u(this.b, view);
    }
}
