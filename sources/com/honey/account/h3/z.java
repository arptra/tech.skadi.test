package com.honey.account.h3;

import com.ucar.vehiclesdk.SurfaceProvider;
import com.ucar.vehiclesdk.UCarGLSurfaceView;
import java.util.function.Consumer;

public final /* synthetic */ class z implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarGLSurfaceView f4504a;

    public /* synthetic */ z(UCarGLSurfaceView uCarGLSurfaceView) {
        this.f4504a = uCarGLSurfaceView;
    }

    public final void accept(Object obj) {
        this.f4504a.k((SurfaceProvider.Callback) obj);
    }
}
