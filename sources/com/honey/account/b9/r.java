package com.honey.account.b9;

import androidx.lifecycle.Observer;
import com.upuphone.xr.sapp.vu.VuGlassesActivity;

public final /* synthetic */ class r implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VuGlassesActivity f7141a;

    public /* synthetic */ r(VuGlassesActivity vuGlassesActivity) {
        this.f7141a = vuGlassesActivity;
    }

    public final void onChanged(Object obj) {
        VuGlassesActivity.n(this.f7141a, ((Boolean) obj).booleanValue());
    }
}
