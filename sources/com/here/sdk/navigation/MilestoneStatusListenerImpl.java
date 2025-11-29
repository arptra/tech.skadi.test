package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;

class MilestoneStatusListenerImpl extends NativeBase implements MilestoneStatusListener {
    public MilestoneStatusListenerImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MilestoneStatusListenerImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void onMilestoneStatusUpdated(@NonNull Milestone milestone, @NonNull MilestoneStatus milestoneStatus);
}
