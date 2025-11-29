package com.here.sdk.core.engine;

import android.content.Context;
import androidx.annotation.NonNull;
import com.here.NativeBase;

class CAresInitialiserBridgeImpl extends NativeBase implements CAresInitialiserBridge {
    public CAresInitialiserBridgeImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                CAresInitialiserBridgeImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void extractConnectivityManager(@NonNull Context context);
}
