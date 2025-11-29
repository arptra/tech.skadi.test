package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class ManeuverNotificationListenerImpl extends NativeBase implements ManeuverNotificationListener {
    public ManeuverNotificationListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                ManeuverNotificationListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onManeuverNotification(@NonNull String str);
}
