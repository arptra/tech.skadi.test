package com.here.sdk.maploader;

import androidx.annotation.Nullable;
import com.here.NativeBase;
import java.util.List;

class DeletedRegionsCallbackImpl extends NativeBase implements DeletedRegionsCallback {
    public DeletedRegionsCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                DeletedRegionsCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onCompleted(@Nullable MapLoaderError mapLoaderError, @Nullable List<RegionId> list);
}
