package com.honey.account.y8;

import android.view.View;
import com.upuphone.xr.sapp.databinding.LayoutConnectViewWindowBinding;
import com.upuphone.xr.sapp.view.GenericWindowView;
import com.upuphone.xr.sapp.view.popup.ConnectViewTipWindowView;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LayoutConnectViewWindowBinding f7713a;
    public final /* synthetic */ GenericWindowView.IClickCallback b;
    public final /* synthetic */ int c;

    public /* synthetic */ b(LayoutConnectViewWindowBinding layoutConnectViewWindowBinding, GenericWindowView.IClickCallback iClickCallback, int i) {
        this.f7713a = layoutConnectViewWindowBinding;
        this.b = iClickCallback;
        this.c = i;
    }

    public final void onClick(View view) {
        ConnectViewTipWindowView.e(this.f7713a, this.b, this.c, view);
    }
}
