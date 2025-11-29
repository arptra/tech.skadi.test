package com.honey.account.c9;

import com.upuphone.xr.sapp.vu.fragment.VuGlassesManagerFragment;
import com.upuphone.xr.sapp.vu.ota.VuUpdateInfo;
import com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel;

public final /* synthetic */ class t implements VuGlassesOtaModel.UpdateInfoChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuGlassesManagerFragment f7186a;

    public /* synthetic */ t(VuGlassesManagerFragment vuGlassesManagerFragment) {
        this.f7186a = vuGlassesManagerFragment;
    }

    public final void a(VuUpdateInfo vuUpdateInfo) {
        VuGlassesManagerFragment.V0(this.f7186a, vuUpdateInfo);
    }
}
