package com.here.sdk.maploader;

import androidx.annotation.Nullable;
import com.here.NativeBase;

class RepairPersistentMapCallbackImpl extends NativeBase implements RepairPersistentMapCallback {
    public RepairPersistentMapCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                RepairPersistentMapCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onCompleted(@Nullable PersistentMapRepairError persistentMapRepairError);
}
