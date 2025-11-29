package com.honey.account.x8;

import android.view.View;
import com.upuphone.xr.sapp.view.GenericWindowView;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericWindowView f7667a;
    public final /* synthetic */ int b;

    public /* synthetic */ m(GenericWindowView genericWindowView, int i) {
        this.f7667a = genericWindowView;
        this.b = i;
    }

    public final void onClick(View view) {
        GenericWindowView.V(this.f7667a, this.b, view);
    }
}
