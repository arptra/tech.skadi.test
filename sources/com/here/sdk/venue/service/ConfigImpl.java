package com.here.sdk.venue.service;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class ConfigImpl extends NativeBase implements Config {
    public ConfigImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                ConfigImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native String getPrivateDir();

    @NonNull
    public native String getPublicDir();

    public native void initialiseRenderer();
}
