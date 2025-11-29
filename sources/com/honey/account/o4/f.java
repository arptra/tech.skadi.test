package com.honey.account.o4;

import android.view.View;
import com.upuphone.ar.navi.lite.view.AvoidLimitPopView;
import com.upuphone.ar.navi.lite.view.CarSetDialog;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AvoidLimitPopView f4973a;
    public final /* synthetic */ CarSetDialog b;

    public /* synthetic */ f(AvoidLimitPopView avoidLimitPopView, CarSetDialog carSetDialog) {
        this.f4973a = avoidLimitPopView;
        this.b = carSetDialog;
    }

    public final void onClick(View view) {
        this.f4973a.r(this.b, view);
    }
}
