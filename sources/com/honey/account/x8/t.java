package com.honey.account.x8;

import android.widget.CompoundButton;
import com.upuphone.xr.sapp.view.GenericWindowView;

public final /* synthetic */ class t implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericWindowView f7674a;

    public /* synthetic */ t(GenericWindowView genericWindowView) {
        this.f7674a = genericWindowView;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        GenericWindowView.I(this.f7674a, compoundButton, z);
    }
}
