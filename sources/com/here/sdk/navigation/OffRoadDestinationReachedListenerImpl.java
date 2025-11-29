package com.here.sdk.navigation;

import com.here.NativeBase;

class OffRoadDestinationReachedListenerImpl extends NativeBase implements OffRoadDestinationReachedListener {
    public OffRoadDestinationReachedListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                OffRoadDestinationReachedListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onOffRoadDestinationReached();
}
