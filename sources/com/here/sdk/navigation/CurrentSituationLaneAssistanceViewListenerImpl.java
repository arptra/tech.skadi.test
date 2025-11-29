package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class CurrentSituationLaneAssistanceViewListenerImpl extends NativeBase implements CurrentSituationLaneAssistanceViewListener {
    public CurrentSituationLaneAssistanceViewListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                CurrentSituationLaneAssistanceViewListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onCurrentSituationLaneAssistanceViewUpdate(@NonNull CurrentSituationLaneAssistanceView currentSituationLaneAssistanceView);
}
