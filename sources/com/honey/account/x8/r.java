package com.honey.account.x8;

import android.view.View;
import com.upuphone.xr.sapp.view.GenericWindowView;

public final /* synthetic */ class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericWindowView.IClickCallback f7672a;
    public final /* synthetic */ int b;

    public /* synthetic */ r(GenericWindowView.IClickCallback iClickCallback, int i) {
        this.f7672a = iClickCallback;
        this.b = i;
    }

    public final void onClick(View view) {
        GenericWindowView.G(this.f7672a, this.b, view);
    }
}
