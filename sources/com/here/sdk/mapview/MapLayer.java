package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.NativeBase;

public final class MapLayer extends NativeBase {
    public MapLayer(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapLayer.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void destroy();

    public native void setEnabled(boolean z);

    public native void setPriority(@NonNull MapLayerPriority mapLayerPriority);

    public native void setStyle(@NonNull Style style);
}
