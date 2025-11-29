package com.here.sdk.core.engine;

import com.here.NativeBase;

class ProcessKillerImpl extends NativeBase implements ProcessKiller {
    public ProcessKillerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                ProcessKillerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void killProcess(int i);
}
