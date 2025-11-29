package com.here.sdk.mapview.datasource;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;

public final class TileUrlProviderFactory extends NativeBase {
    public TileUrlProviderFactory(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TileUrlProviderFactory.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @Nullable
    public static native TileUrlProviderCallback fromXyzUrlTemplate(@NonNull String str);
}
