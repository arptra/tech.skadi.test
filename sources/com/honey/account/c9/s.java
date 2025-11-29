package com.honey.account.c9;

import com.upuphone.xr.sapp.vu.fragment.VuGlassUpdateFragment;
import com.upuphone.xr.sapp.vu.ota.VuUpdateStatus;
import com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel;

public final /* synthetic */ class s implements VuGlassesOtaModel.UpdateStatusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuGlassUpdateFragment f7185a;

    public /* synthetic */ s(VuGlassUpdateFragment vuGlassUpdateFragment) {
        this.f7185a = vuGlassUpdateFragment;
    }

    public final void a(VuUpdateStatus vuUpdateStatus) {
        VuGlassUpdateFragment.Y0(this.f7185a, vuUpdateStatus);
    }
}
