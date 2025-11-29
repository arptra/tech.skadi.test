package com.here.sdk.traffic;

import androidx.annotation.Nullable;
import com.here.NativeBase;

class TrafficIncidentLookupCallbackImpl extends NativeBase implements TrafficIncidentLookupCallback {
    public TrafficIncidentLookupCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TrafficIncidentLookupCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onTrafficIncidentFetched(@Nullable TrafficQueryError trafficQueryError, @Nullable TrafficIncident trafficIncident);
}
