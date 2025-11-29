package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.routing.RoadTexts;

class RoadTextsListenerImpl extends NativeBase implements RoadTextsListener {
    public RoadTextsListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                RoadTextsListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onRoadTextsUpdated(@NonNull RoadTexts roadTexts);
}
