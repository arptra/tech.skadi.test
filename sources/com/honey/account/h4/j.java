package com.honey.account.h4;

import android.content.Context;
import android.view.View;
import com.upuphone.ar.navi.lite.manger.NaviOperatorManager;
import com.upuphone.ar.navi.lite.view.CustomDialog;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NaviOperatorManager f4506a;
    public final /* synthetic */ CustomDialog b;
    public final /* synthetic */ Context c;

    public /* synthetic */ j(NaviOperatorManager naviOperatorManager, CustomDialog customDialog, Context context) {
        this.f4506a = naviOperatorManager;
        this.b = customDialog;
        this.c = context;
    }

    public final void onClick(View view) {
        this.f4506a.lambda$home$0(this.b, this.c, view);
    }
}
