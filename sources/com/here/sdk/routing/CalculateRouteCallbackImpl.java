package com.here.sdk.routing;

import androidx.annotation.Nullable;
import com.here.NativeBase;
import java.util.List;

class CalculateRouteCallbackImpl extends NativeBase implements CalculateRouteCallback {
    public CalculateRouteCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                CalculateRouteCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onRouteCalculated(@Nullable RoutingError routingError, @Nullable List<Route> list);
}
