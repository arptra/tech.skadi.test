package com.honey.account.x8;

import android.view.View;
import com.upuphone.xr.sapp.view.GenericWindowView;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericWindowView.IClickCallback f7664a;
    public final /* synthetic */ int b;

    public /* synthetic */ j(GenericWindowView.IClickCallback iClickCallback, int i) {
        this.f7664a = iClickCallback;
        this.b = i;
    }

    public final void onClick(View view) {
        GenericWindowView.P(this.f7664a, this.b, view);
    }
}
