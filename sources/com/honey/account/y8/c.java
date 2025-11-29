package com.honey.account.y8;

import android.view.View;
import com.upuphone.xr.sapp.view.GenericWindowView;
import com.upuphone.xr.sapp.view.popup.ConnectViewTipWindowView;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericWindowView.IClickCallback f7714a;
    public final /* synthetic */ int b;

    public /* synthetic */ c(GenericWindowView.IClickCallback iClickCallback, int i) {
        this.f7714a = iClickCallback;
        this.b = i;
    }

    public final void onClick(View view) {
        ConnectViewTipWindowView.f(this.f7714a, this.b, view);
    }
}
