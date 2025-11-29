package com.honey.account.b9;

import androidx.lifecycle.Observer;
import com.upuphone.xr.sapp.vu.VuTouchpadActivity;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;

public final /* synthetic */ class x implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuTouchpadActivity f7147a;

    public /* synthetic */ x(VuTouchpadActivity vuTouchpadActivity) {
        this.f7147a = vuTouchpadActivity;
    }

    public final void onChanged(Object obj) {
        VuTouchpadActivity.f1(this.f7147a, (VuGlassControlModel.ViewGlassesInfo) obj);
    }
}
