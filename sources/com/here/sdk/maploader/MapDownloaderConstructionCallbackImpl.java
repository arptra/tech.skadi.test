package com.here.sdk.maploader;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class MapDownloaderConstructionCallbackImpl extends NativeBase implements MapDownloaderConstructionCallback {
    public MapDownloaderConstructionCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapDownloaderConstructionCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onMapDownloaderConstructedCompleted(@NonNull MapDownloader mapDownloader);
}
