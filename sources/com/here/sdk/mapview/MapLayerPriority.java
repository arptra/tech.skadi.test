package com.here.sdk.mapview;

import com.here.NativeBase;

public final class MapLayerPriority extends NativeBase {
    public MapLayerPriority(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapLayerPriority.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);
}
