package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class RouteProgressListenerImpl extends NativeBase implements RouteProgressListener {
    public RouteProgressListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                RouteProgressListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onRouteProgressUpdated(@NonNull RouteProgress routeProgress);
}
