package com.honey.account.h3;

import com.ucar.vehiclesdk.SurfaceProvider;
import com.ucar.vehiclesdk.UCarTextureView;
import java.util.function.Consumer;

public final /* synthetic */ class c0 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarTextureView f4480a;

    public /* synthetic */ c0(UCarTextureView uCarTextureView) {
        this.f4480a = uCarTextureView;
    }

    public final void accept(Object obj) {
        this.f4480a.l((SurfaceProvider.Callback) obj);
    }
}
