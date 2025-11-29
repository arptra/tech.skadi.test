package com.here.sdk.mapview;

import com.here.NativeBase;

class MapIdleListenerImpl extends NativeBase implements MapIdleListener {
    public MapIdleListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapIdleListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onMapBusy();

    public native void onMapIdle();
}
