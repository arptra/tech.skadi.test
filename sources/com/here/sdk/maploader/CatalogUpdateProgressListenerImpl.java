package com.here.sdk.maploader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;

class CatalogUpdateProgressListenerImpl extends NativeBase implements CatalogUpdateProgressListener {
    public CatalogUpdateProgressListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                CatalogUpdateProgressListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onComplete(@Nullable MapLoaderError mapLoaderError);

    public native void onPause(@Nullable MapLoaderError mapLoaderError);

    public native void onProgress(@NonNull RegionId regionId, int i);

    public native void onResume();
}
