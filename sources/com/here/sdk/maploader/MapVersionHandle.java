package com.here.sdk.maploader;

import androidx.annotation.NonNull;
import com.here.NativeBase;

public final class MapVersionHandle extends NativeBase {
    public MapVersionHandle(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapVersionHandle.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native String stringRepresentation(@NonNull String str);
}
