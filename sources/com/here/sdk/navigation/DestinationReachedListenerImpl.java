package com.here.sdk.navigation;

import com.here.NativeBase;

class DestinationReachedListenerImpl extends NativeBase implements DestinationReachedListener {
    public DestinationReachedListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                DestinationReachedListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onDestinationReached();
}
