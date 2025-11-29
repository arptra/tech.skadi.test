package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class ManeuverViewLaneAssistanceListenerImpl extends NativeBase implements ManeuverViewLaneAssistanceListener {
    public ManeuverViewLaneAssistanceListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                ManeuverViewLaneAssistanceListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onLaneAssistanceUpdated(@NonNull ManeuverViewLaneAssistance maneuverViewLaneAssistance);
}
