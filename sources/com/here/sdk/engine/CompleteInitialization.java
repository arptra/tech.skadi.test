package com.here.sdk.engine;

import com.here.NativeBase;

final class CompleteInitialization extends NativeBase {
    public CompleteInitialization(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                CompleteInitialization.disposeNativeHandle(j);
            }
        });
    }

    public static native void completed();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);
}
