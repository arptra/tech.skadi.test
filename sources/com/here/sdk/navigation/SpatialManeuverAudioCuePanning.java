package com.here.sdk.navigation;

import androidx.annotation.Nullable;
import com.here.NativeBase;

public final class SpatialManeuverAudioCuePanning extends NativeBase {
    public SpatialManeuverAudioCuePanning(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SpatialManeuverAudioCuePanning.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void startPanning(@Nullable CustomPanningData customPanningData);
}
