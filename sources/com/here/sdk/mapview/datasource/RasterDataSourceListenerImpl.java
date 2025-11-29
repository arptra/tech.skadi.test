package com.here.sdk.mapview.datasource;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class RasterDataSourceListenerImpl extends NativeBase implements RasterDataSourceListener {
    public RasterDataSourceListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                RasterDataSourceListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onRasterDataSourceError(@NonNull RasterDataSourceError rasterDataSourceError);

    public native void onRasterDataSourceReady();
}
