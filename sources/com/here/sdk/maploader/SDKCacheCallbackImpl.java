package com.here.sdk.maploader;

import androidx.annotation.Nullable;
import com.here.NativeBase;

class SDKCacheCallbackImpl extends NativeBase implements SDKCacheCallback {
    public SDKCacheCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SDKCacheCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onCompleted(@Nullable MapLoaderError mapLoaderError);
}
