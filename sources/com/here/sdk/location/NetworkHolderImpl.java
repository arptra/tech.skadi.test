package com.here.sdk.location;

import com.here.NativeBase;

class NetworkHolderImpl extends NativeBase implements NetworkHolder {
    public NetworkHolderImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                NetworkHolderImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native long getNetwork();
}
