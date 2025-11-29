package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.mapview.MapCamera;

class MapCameraListenerImpl extends NativeBase implements MapCameraListener {
    public MapCameraListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapCameraListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onMapCameraUpdated(@NonNull MapCamera.State state);
}
