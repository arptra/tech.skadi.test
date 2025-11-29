package com.honey.account.y8;

import android.view.View;
import com.upuphone.xr.sapp.view.GenericWindowView;
import com.upuphone.xr.sapp.view.popup.ConnectTipWindowView;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericWindowView.IClickCallback f7712a;
    public final /* synthetic */ int b;

    public /* synthetic */ a(GenericWindowView.IClickCallback iClickCallback, int i) {
        this.f7712a = iClickCallback;
        this.b = i;
    }

    public final void onClick(View view) {
        ConnectTipWindowView.d(this.f7712a, this.b, view);
    }
}
