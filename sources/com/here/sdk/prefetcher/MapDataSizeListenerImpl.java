package com.here.sdk.prefetcher;

import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.maploader.MapLoaderError;

class MapDataSizeListenerImpl extends NativeBase implements MapDataSizeListener {
    public MapDataSizeListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapDataSizeListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onSizeEstimated(@Nullable MapLoaderError mapLoaderError, @Nullable MapDataSize mapDataSize);
}
