package com.honey.account.x8;

import android.widget.CompoundButton;
import com.upuphone.xr.sapp.view.GenericWindowView;

public final /* synthetic */ class k implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericWindowView f7665a;

    public /* synthetic */ k(GenericWindowView genericWindowView) {
        this.f7665a = genericWindowView;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        GenericWindowView.Q(this.f7665a, compoundButton, z);
    }
}
