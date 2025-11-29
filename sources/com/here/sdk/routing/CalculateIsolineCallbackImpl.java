package com.here.sdk.routing;

import androidx.annotation.Nullable;
import com.here.NativeBase;
import java.util.List;

class CalculateIsolineCallbackImpl extends NativeBase implements CalculateIsolineCallback {
    public CalculateIsolineCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                CalculateIsolineCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onIsolineCalculated(@Nullable RoutingError routingError, @Nullable List<Isoline> list);
}
