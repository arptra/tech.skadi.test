package com.here.sdk.mapview;

import com.here.NativeBase;

final class MapLogConfig extends NativeBase {
    public MapLogConfig(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapLogConfig.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public static native boolean extraLoggingEnabled();
}
