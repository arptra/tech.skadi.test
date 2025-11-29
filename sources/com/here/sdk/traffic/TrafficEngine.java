package com.here.sdk.traffic;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.GeoBox;
import com.here.sdk.core.GeoCircle;
import com.here.sdk.core.GeoCorridor;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.core.threading.TaskHandle;

public final class TrafficEngine extends NativeBase {
    public TrafficEngine() throws InstantiationErrorException {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make() throws InstantiationErrorException;

    private static native long make(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException;

    @NonNull
    public native TaskHandle lookupIncident(@NonNull String str, @NonNull TrafficIncidentLookupOptions trafficIncidentLookupOptions, @NonNull TrafficIncidentLookupCallback trafficIncidentLookupCallback);

    @NonNull
    public native TaskHandle queryForFlow(@NonNull GeoBox geoBox, @NonNull TrafficFlowQueryOptions trafficFlowQueryOptions, @NonNull TrafficFlowQueryCallback trafficFlowQueryCallback);

    @NonNull
    public native TaskHandle queryForFlow(@NonNull GeoCircle geoCircle, @NonNull TrafficFlowQueryOptions trafficFlowQueryOptions, @NonNull TrafficFlowQueryCallback trafficFlowQueryCallback);

    @NonNull
    public native TaskHandle queryForFlow(@NonNull GeoCorridor geoCorridor, @NonNull TrafficFlowQueryOptions trafficFlowQueryOptions, @NonNull TrafficFlowQueryCallback trafficFlowQueryCallback);

    @NonNull
    public native TaskHandle queryForIncidents(@NonNull GeoBox geoBox, @NonNull TrafficIncidentsQueryOptions trafficIncidentsQueryOptions, @NonNull TrafficIncidentsQueryCallback trafficIncidentsQueryCallback);

    @NonNull
    public native TaskHandle queryForIncidents(@NonNull GeoCircle geoCircle, @NonNull TrafficIncidentsQueryOptions trafficIncidentsQueryOptions, @NonNull TrafficIncidentsQueryCallback trafficIncidentsQueryCallback);

    @NonNull
    public native TaskHandle queryForIncidents(@NonNull GeoCorridor geoCorridor, @NonNull TrafficIncidentsQueryOptions trafficIncidentsQueryOptions, @NonNull TrafficIncidentsQueryCallback trafficIncidentsQueryCallback);

    public TrafficEngine(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException {
        this(make(sDKNativeEngine), (Object) null);
        cacheThisInstance();
    }

    public TrafficEngine(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TrafficEngine.disposeNativeHandle(j);
            }
        });
    }
}
