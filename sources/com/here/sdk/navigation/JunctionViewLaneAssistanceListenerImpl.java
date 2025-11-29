package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class JunctionViewLaneAssistanceListenerImpl extends NativeBase implements JunctionViewLaneAssistanceListener {
    public JunctionViewLaneAssistanceListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                JunctionViewLaneAssistanceListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onLaneAssistanceUpdated(@NonNull JunctionViewLaneAssistance junctionViewLaneAssistance);
}
