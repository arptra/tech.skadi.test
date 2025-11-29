package com.honey.account.x8;

import android.view.View;
import com.upuphone.xr.sapp.view.GenericWindowView;

public final /* synthetic */ class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7671a;
    public final /* synthetic */ GenericWindowView b;
    public final /* synthetic */ GenericWindowView.IClickCallback c;

    public /* synthetic */ q(int i, GenericWindowView genericWindowView, GenericWindowView.IClickCallback iClickCallback) {
        this.f7671a = i;
        this.b = genericWindowView;
        this.c = iClickCallback;
    }

    public final void onClick(View view) {
        GenericWindowView.F(this.f7671a, this.b, this.c, view);
    }
}
