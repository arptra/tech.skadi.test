package com.here.sdk.routing;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.core.threading.TaskHandle;

public final class TransitRoutingEngine extends NativeBase {
    public TransitRoutingEngine() throws InstantiationErrorException {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make() throws InstantiationErrorException;

    private static native long make(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException;

    @NonNull
    public native TaskHandle calculateRoute(@NonNull TransitWaypoint transitWaypoint, @NonNull TransitWaypoint transitWaypoint2, @NonNull TransitRouteOptions transitRouteOptions, @NonNull CalculateRouteCallback calculateRouteCallback);

    public TransitRoutingEngine(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException {
        this(make(sDKNativeEngine), (Object) null);
        cacheThisInstance();
    }

    public TransitRoutingEngine(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TransitRoutingEngine.disposeNativeHandle(j);
            }
        });
    }
}
