package com.honey.account.b9;

import com.upuphone.xr.sapp.vu.VuGlassesActivity;
import com.upuphone.xr.sapp.vu.ota.VuUpdateStatus;
import com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel;

public final /* synthetic */ class p implements VuGlassesOtaModel.UpdateStatusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuGlassesActivity f7140a;

    public /* synthetic */ p(VuGlassesActivity vuGlassesActivity) {
        this.f7140a = vuGlassesActivity;
    }

    public final void a(VuUpdateStatus vuUpdateStatus) {
        VuGlassesActivity.N(this.f7140a, vuUpdateStatus);
    }
}
