package com.here.sdk.trafficawarenavigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.routing.Route;
import com.here.sdk.routing.RoutingError;

class DynamicRoutingListenerImpl extends NativeBase implements DynamicRoutingListener {
    public DynamicRoutingListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                DynamicRoutingListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onBetterRouteFound(@NonNull Route route, int i, int i2);

    public native void onRoutingError(@NonNull RoutingError routingError);
}
