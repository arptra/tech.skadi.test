package com.honey.account.h3;

import com.ucar.vehiclesdk.SurfaceProvider;
import com.ucar.vehiclesdk.UCarTextureView;
import java.util.function.Consumer;

public final /* synthetic */ class b0 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarTextureView f4478a;

    public /* synthetic */ b0(UCarTextureView uCarTextureView) {
        this.f4478a = uCarTextureView;
    }

    public final void accept(Object obj) {
        this.f4478a.o((SurfaceProvider.Callback) obj);
    }
}
