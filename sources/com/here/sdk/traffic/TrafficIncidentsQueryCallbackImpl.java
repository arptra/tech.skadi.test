package com.here.sdk.traffic;

import androidx.annotation.Nullable;
import com.here.NativeBase;
import java.util.List;

class TrafficIncidentsQueryCallbackImpl extends NativeBase implements TrafficIncidentsQueryCallback {
    public TrafficIncidentsQueryCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TrafficIncidentsQueryCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onTrafficIncidentsFetched(@Nullable TrafficQueryError trafficQueryError, @Nullable List<TrafficIncident> list);
}
