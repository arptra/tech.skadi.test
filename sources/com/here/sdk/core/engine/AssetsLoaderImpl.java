package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import java.util.List;

class AssetsLoaderImpl extends NativeBase implements AssetsLoader {
    public AssetsLoaderImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                AssetsLoaderImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native boolean checkAssetAvailability(@NonNull String str);

    @NonNull
    public native String getAssetsPath();

    @NonNull
    public native List<String> getSubfolderNames(@NonNull String str);

    @NonNull
    public native String loadAsset(@NonNull String str);

    @NonNull
    public native byte[] loadAssetBlob(@NonNull String str);
}
