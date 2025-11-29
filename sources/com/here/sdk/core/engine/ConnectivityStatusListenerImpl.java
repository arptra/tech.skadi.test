package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class ConnectivityStatusListenerImpl extends NativeBase implements ConnectivityStatusListener {
    public ConnectivityStatusListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                ConnectivityStatusListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onConnectivityStatusChange(@NonNull ConnectivityStatus connectivityStatus);
}
