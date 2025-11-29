package com.here.sdk.maploader;

import androidx.annotation.Nullable;
import com.here.NativeBase;
import java.util.List;

class DownloadableRegionsCallbackImpl extends NativeBase implements DownloadableRegionsCallback {
    public DownloadableRegionsCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                DownloadableRegionsCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onCompleted(@Nullable MapLoaderError mapLoaderError, @Nullable List<Region> list);
}
