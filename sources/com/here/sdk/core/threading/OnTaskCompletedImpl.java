package com.here.sdk.core.threading;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class OnTaskCompletedImpl extends NativeBase implements OnTaskCompleted {
    public OnTaskCompletedImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                OnTaskCompletedImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onTaskCompleted(@NonNull TaskOutcome taskOutcome);
}
