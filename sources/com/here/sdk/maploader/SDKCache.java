package com.here.sdk.maploader;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.engine.SDKNativeEngine;

public final class SDKCache extends NativeBase {
    public SDKCache() {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native SDKCache fromEngine(@NonNull SDKNativeEngine sDKNativeEngine);

    private static native long make();

    public native void clearCache(@NonNull SDKCacheCallback sDKCacheCallback);

    public SDKCache(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SDKCache.disposeNativeHandle(j);
            }
        });
    }
}
