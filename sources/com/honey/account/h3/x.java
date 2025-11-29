package com.honey.account.h3;

import com.ucar.vehiclesdk.SurfaceProvider;
import com.ucar.vehiclesdk.UCarGLSurfaceView;
import java.util.function.Consumer;

public final /* synthetic */ class x implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarGLSurfaceView f4502a;

    public /* synthetic */ x(UCarGLSurfaceView uCarGLSurfaceView) {
        this.f4502a = uCarGLSurfaceView;
    }

    public final void accept(Object obj) {
        this.f4502a.l((SurfaceProvider.Callback) obj);
    }
}
