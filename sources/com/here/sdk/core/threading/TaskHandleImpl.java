package com.here.sdk.core.threading;

import com.here.NativeBase;

class TaskHandleImpl extends NativeBase implements TaskHandle {
    public TaskHandleImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TaskHandleImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native boolean cancel();

    public native boolean isCancelled();

    public native boolean isFinished();
}
