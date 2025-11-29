package com.here.sdk.core.threading;

import com.here.NativeBase;

class RunnableImpl extends NativeBase implements Runnable {
    public RunnableImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                RunnableImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void run();
}
