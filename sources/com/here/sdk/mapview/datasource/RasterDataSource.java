package com.here.sdk.mapview.datasource;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.mapview.MapContext;

public final class RasterDataSource extends NativeBase {
    public RasterDataSource(@NonNull MapContext mapContext, @NonNull String str) {
        this(create(mapContext, str), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    private static native long create(@NonNull MapContext mapContext, @NonNull RasterDataSourceConfiguration rasterDataSourceConfiguration);

    private static native long create(@NonNull MapContext mapContext, @NonNull RasterDataSourceConfiguration rasterDataSourceConfiguration, @NonNull RasterDataSourceListener rasterDataSourceListener);

    private static native long create(@NonNull MapContext mapContext, @NonNull String str);

    private static native long create(@NonNull MapContext mapContext, @NonNull String str, @NonNull RasterDataSourceListener rasterDataSourceListener);

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void addListener(@NonNull RasterDataSourceListener rasterDataSourceListener);

    public native void changeConfiguration(@NonNull RasterDataSourceConfigurationUpdate rasterDataSourceConfigurationUpdate);

    public native void destroy();

    public native void removeListener(@NonNull RasterDataSourceListener rasterDataSourceListener);

    public native void removeListeners();

    public RasterDataSource(@NonNull MapContext mapContext, @NonNull String str, @NonNull RasterDataSourceListener rasterDataSourceListener) {
        this(create(mapContext, str, rasterDataSourceListener), (Object) null);
        cacheThisInstance();
    }

    public RasterDataSource(@NonNull MapContext mapContext, @NonNull RasterDataSourceConfiguration rasterDataSourceConfiguration) {
        this(create(mapContext, rasterDataSourceConfiguration), (Object) null);
        cacheThisInstance();
    }

    public RasterDataSource(@NonNull MapContext mapContext, @NonNull RasterDataSourceConfiguration rasterDataSourceConfiguration, @NonNull RasterDataSourceListener rasterDataSourceListener) {
        this(create(mapContext, rasterDataSourceConfiguration, rasterDataSourceListener), (Object) null);
        cacheThisInstance();
    }

    public RasterDataSource(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                RasterDataSource.disposeNativeHandle(j);
            }
        });
    }
}
