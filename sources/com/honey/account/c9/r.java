package com.honey.account.c9;

import com.upuphone.xr.sapp.vu.fragment.VuGlassUpdateFragment;
import com.upuphone.xr.sapp.vu.ota.VuUpdateInfo;
import com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel;

public final /* synthetic */ class r implements VuGlassesOtaModel.UpdateInfoChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuGlassUpdateFragment f7184a;

    public /* synthetic */ r(VuGlassUpdateFragment vuGlassUpdateFragment) {
        this.f7184a = vuGlassUpdateFragment;
    }

    public final void a(VuUpdateInfo vuUpdateInfo) {
        VuGlassUpdateFragment.X0(this.f7184a, vuUpdateInfo);
    }
}
