package com.here.sdk.mapview;

import com.here.NativeBase;

public final class MapContext extends NativeBase {
    public MapContext(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapContext.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);
}
