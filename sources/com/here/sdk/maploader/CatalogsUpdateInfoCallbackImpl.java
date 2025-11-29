package com.here.sdk.maploader;

import androidx.annotation.Nullable;
import com.here.NativeBase;
import java.util.List;

class CatalogsUpdateInfoCallbackImpl extends NativeBase implements CatalogsUpdateInfoCallback {
    public CatalogsUpdateInfoCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                CatalogsUpdateInfoCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void apply(@Nullable MapLoaderError mapLoaderError, @Nullable List<CatalogUpdateInfo> list);
}
