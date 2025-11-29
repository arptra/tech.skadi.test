package com.honey.account.b9;

import com.upuphone.xr.sapp.vu.VuGlassesActivity;
import com.upuphone.xr.sapp.vu.ota.VuUpdateInfo;
import com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel;

public final /* synthetic */ class o implements VuGlassesOtaModel.UpdateInfoChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuGlassesActivity f7139a;

    public /* synthetic */ o(VuGlassesActivity vuGlassesActivity) {
        this.f7139a = vuGlassesActivity;
    }

    public final void a(VuUpdateInfo vuUpdateInfo) {
        VuGlassesActivity.M(this.f7139a, vuUpdateInfo);
    }
}
