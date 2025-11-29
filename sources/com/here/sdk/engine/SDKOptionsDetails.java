package com.here.sdk.engine;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.engine.SDKOptions;

final class SDKOptionsDetails extends NativeBase {
    public SDKOptionsDetails(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SDKOptionsDetails.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native SDKOptions makeInternal(@NonNull SDKOptions sDKOptions);
}
