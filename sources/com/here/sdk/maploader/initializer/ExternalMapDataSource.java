package com.here.sdk.maploader.initializer;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.engine.CatalogIdentifier;
import com.here.sdk.core.engine.SDKNativeEngine;
import java.util.List;

public final class ExternalMapDataSource extends NativeBase {
    public ExternalMapDataSource(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                ExternalMapDataSource.disposeNativeHandle(j);
            }
        });
    }

    public static native void configureSdkEngineWithAutoRemoteConnection(@NonNull String str, @NonNull SDKNativeEngine sDKNativeEngine) throws ExternalMapDataSourceException;

    public static native void configureSdkEngineWithFixedRemoteConnection(@NonNull String str, @NonNull List<CatalogIdentifier> list, @NonNull SDKNativeEngine sDKNativeEngine) throws ExternalMapDataSourceException;

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native ExternalMapDataSource start(@NonNull String str, @NonNull SDKNativeEngine sDKNativeEngine) throws ExternalMapDataSourceException;

    public native void stop(@NonNull SDKNativeEngine sDKNativeEngine) throws ExternalMapDataSourceException;
}
