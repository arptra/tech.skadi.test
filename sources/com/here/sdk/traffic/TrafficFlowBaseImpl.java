package com.here.sdk.traffic;

import com.here.NativeBase;

class TrafficFlowBaseImpl extends NativeBase implements TrafficFlowBase {
    public TrafficFlowBaseImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TrafficFlowBaseImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native double getFreeFlowSpeedInMetersPerSecond();

    public native double getJamFactor();
}
