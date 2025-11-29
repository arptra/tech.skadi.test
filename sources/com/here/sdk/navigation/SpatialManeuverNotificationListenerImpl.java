package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class SpatialManeuverNotificationListenerImpl extends NativeBase implements SpatialManeuverNotificationListener {
    public SpatialManeuverNotificationListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                SpatialManeuverNotificationListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onSpatialManeuverNotification(@NonNull SpatialManeuver spatialManeuver, @NonNull SpatialManeuverAudioCuePanning spatialManeuverAudioCuePanning);
}
