package com.here.sdk.prefetcher;

import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.maploader.MapLoaderError;

class PrefetchStatusListenerImpl extends NativeBase implements PrefetchStatusListener {
    public PrefetchStatusListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                PrefetchStatusListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onComplete(@Nullable MapLoaderError mapLoaderError);

    public native void onProgress(int i);
}
