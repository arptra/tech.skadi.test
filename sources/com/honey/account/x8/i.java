package com.honey.account.x8;

import android.view.View;
import com.upuphone.xr.sapp.view.GenericWindowView;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericWindowView.IClickCallback f7663a;
    public final /* synthetic */ int b;

    public /* synthetic */ i(GenericWindowView.IClickCallback iClickCallback, int i) {
        this.f7663a = iClickCallback;
        this.b = i;
    }

    public final void onClick(View view) {
        GenericWindowView.O(this.f7663a, this.b, view);
    }
}
