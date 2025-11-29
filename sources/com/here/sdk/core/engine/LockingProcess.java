package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;

public final class LockingProcess extends NativeBase {
    public LockingProcess(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                LockingProcess.disposeNativeHandle(j);
            }
        });
    }

    public static native void destroyLockingProcess(@NonNull SDKOptions sDKOptions, long j);

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @Nullable
    public static native Integer getLockingProcessId(@NonNull SDKOptions sDKOptions);
}
