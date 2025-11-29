package com.here.sdk.mapview.datasource;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class TileUrlProviderCallbackImpl extends NativeBase implements TileUrlProviderCallback {
    public TileUrlProviderCallbackImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TileUrlProviderCallbackImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native String onTileUrlRequest(int i, int i2, int i3);
}
