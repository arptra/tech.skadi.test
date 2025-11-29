package com.honey.account.h3;

import com.ucar.vehiclesdk.SurfaceProvider;
import com.ucar.vehiclesdk.UCarGLSurfaceView;
import java.util.function.Consumer;

public final /* synthetic */ class y implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarGLSurfaceView f4503a;

    public /* synthetic */ y(UCarGLSurfaceView uCarGLSurfaceView) {
        this.f4503a = uCarGLSurfaceView;
    }

    public final void accept(Object obj) {
        this.f4503a.m((SurfaceProvider.Callback) obj);
    }
}
