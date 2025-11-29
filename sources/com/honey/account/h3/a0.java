package com.honey.account.h3;

import com.ucar.vehiclesdk.SurfaceProvider;
import com.ucar.vehiclesdk.UCarTextureView;
import java.util.function.Consumer;

public final /* synthetic */ class a0 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarTextureView f4476a;

    public /* synthetic */ a0(UCarTextureView uCarTextureView) {
        this.f4476a = uCarTextureView;
    }

    public final void accept(Object obj) {
        this.f4476a.n((SurfaceProvider.Callback) obj);
    }
}
