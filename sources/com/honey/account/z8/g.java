package com.honey.account.z8;

import androidx.lifecycle.Observer;
import com.upuphone.xr.sapp.vm.Ring2ControlViewModel;

public final /* synthetic */ class g implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ring2ControlViewModel f7720a;

    public /* synthetic */ g(Ring2ControlViewModel ring2ControlViewModel) {
        this.f7720a = ring2ControlViewModel;
    }

    public final void onChanged(Object obj) {
        Ring2ControlViewModel.n(this.f7720a, ((Boolean) obj).booleanValue());
    }
}
