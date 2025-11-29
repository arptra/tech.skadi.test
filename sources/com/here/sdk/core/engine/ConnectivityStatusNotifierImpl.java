package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.engine.ConnectivityStatusNotifier;

class ConnectivityStatusNotifierImpl extends NativeBase implements ConnectivityStatusNotifier {
    public ConnectivityStatusNotifierImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                ConnectivityStatusNotifierImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native ConnectivityStatusNotifier.NetworkState getNetworkState();

    public native void start();

    public native void subscribe(@NonNull ConnectivityStatusListener connectivityStatusListener);
}
