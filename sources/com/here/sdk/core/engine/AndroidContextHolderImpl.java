package com.here.sdk.core.engine;

import com.here.NativeBase;

class AndroidContextHolderImpl extends NativeBase implements AndroidContextHolder {
    public AndroidContextHolderImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                AndroidContextHolderImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);
}
