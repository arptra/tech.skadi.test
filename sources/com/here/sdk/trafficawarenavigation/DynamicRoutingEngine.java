package com.here.sdk.trafficawarenavigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.navigation.MapMatchedLocation;
import com.here.sdk.routing.RefreshRouteOptions;
import com.here.sdk.routing.Route;
import com.here.sdk.routing.RouteHandle;
import com.here.sdk.routing.Waypoint;
import java.util.List;

public final class DynamicRoutingEngine extends NativeBase {

    public enum StartError {
        INTERNAL_ERROR(0),
        MISSING_ROUTE(1),
        MISSING_ROUTE_HANDLE(2),
        MISSING_LISTENER(3),
        TOO_FEW_WAYPOINTS(4),
        INVALID_REFRESH_ROUTE_OPTIONS(5);
        
        public final int value;

        private StartError(int i) {
            this.value = i;
        }
    }

    public static final class StartException extends Exception {
        public final StartError error;

        public StartException(StartError startError) {
            super(startError.toString());
            this.error = startError;
        }
    }

    public DynamicRoutingEngine(@Nullable DynamicRoutingEngineOptions dynamicRoutingEngineOptions) throws InstantiationErrorException {
        this(make(dynamicRoutingEngineOptions), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull SDKNativeEngine sDKNativeEngine, @Nullable DynamicRoutingEngineOptions dynamicRoutingEngineOptions) throws InstantiationErrorException;

    private static native long make(@Nullable DynamicRoutingEngineOptions dynamicRoutingEngineOptions) throws InstantiationErrorException;

    public native void start(@NonNull Route route, @NonNull DynamicRoutingListener dynamicRoutingListener) throws StartException;

    public native void start(@NonNull RouteHandle routeHandle, @NonNull List<Waypoint> list, @NonNull RefreshRouteOptions refreshRouteOptions, @NonNull DynamicRoutingListener dynamicRoutingListener) throws StartException;

    public native void stop();

    public native void updateCurrentLocation(@NonNull MapMatchedLocation mapMatchedLocation, int i);

    public DynamicRoutingEngine(@NonNull SDKNativeEngine sDKNativeEngine, @Nullable DynamicRoutingEngineOptions dynamicRoutingEngineOptions) throws InstantiationErrorException {
        this(make(sDKNativeEngine, dynamicRoutingEngineOptions), (Object) null);
        cacheThisInstance();
    }

    public DynamicRoutingEngine(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                DynamicRoutingEngine.disposeNativeHandle(j);
            }
        });
    }
}
