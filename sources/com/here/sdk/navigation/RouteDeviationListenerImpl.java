package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class RouteDeviationListenerImpl extends NativeBase implements RouteDeviationListener {
    public RouteDeviationListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                RouteDeviationListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onRouteDeviation(@NonNull RouteDeviation routeDeviation);
}
