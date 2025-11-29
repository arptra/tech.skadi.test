package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class SpatialManeuverAzimuthListenerImpl extends NativeBase implements SpatialManeuverAzimuthListener {
    public SpatialManeuverAzimuthListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SpatialManeuverAzimuthListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onAzimuthNotification(@NonNull SpatialTrajectoryData spatialTrajectoryData);
}
