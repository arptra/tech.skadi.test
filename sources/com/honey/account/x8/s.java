package com.honey.account.x8;

import android.view.View;
import com.upuphone.xr.sapp.view.GenericWindowView;

public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericWindowView.IClickCallback f7673a;
    public final /* synthetic */ int b;

    public /* synthetic */ s(GenericWindowView.IClickCallback iClickCallback, int i) {
        this.f7673a = iClickCallback;
        this.b = i;
    }

    public final void onClick(View view) {
        GenericWindowView.H(this.f7673a, this.b, view);
    }
}
