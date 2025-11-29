package com.honey.account.h4;

import android.content.Context;
import android.view.View;
import com.upuphone.ar.navi.lite.manger.NaviOperatorManager;
import com.upuphone.ar.navi.lite.view.CustomDialog;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NaviOperatorManager f4507a;
    public final /* synthetic */ CustomDialog b;
    public final /* synthetic */ Context c;

    public /* synthetic */ k(NaviOperatorManager naviOperatorManager, CustomDialog customDialog, Context context) {
        this.f4507a = naviOperatorManager;
        this.b = customDialog;
        this.c = context;
    }

    public final void onClick(View view) {
        this.f4507a.lambda$company$1(this.b, this.c, view);
    }
}
