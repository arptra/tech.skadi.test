package com.here.sdk.traffic;

import androidx.annotation.Nullable;
import com.here.NativeBase;
import java.util.List;

class TrafficFlowQueryCallbackImpl extends NativeBase implements TrafficFlowQueryCallback {
    public TrafficFlowQueryCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TrafficFlowQueryCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onTrafficFlowFetched(@Nullable TrafficQueryError trafficQueryError, @Nullable List<TrafficFlow> list);
}
