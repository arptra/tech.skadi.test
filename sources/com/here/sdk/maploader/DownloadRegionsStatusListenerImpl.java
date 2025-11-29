package com.here.sdk.maploader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import java.util.List;

class DownloadRegionsStatusListenerImpl extends NativeBase implements DownloadRegionsStatusListener {
    public DownloadRegionsStatusListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                DownloadRegionsStatusListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onDownloadRegionsComplete(@Nullable MapLoaderError mapLoaderError, @Nullable List<RegionId> list);

    public native void onPause(@Nullable MapLoaderError mapLoaderError);

    public native void onProgress(@NonNull RegionId regionId, int i);

    public native void onResume();
}
