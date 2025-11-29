package com.here.sdk.traffic;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.LocalizedText;
import java.util.Date;

class TrafficIncidentBaseImpl extends NativeBase implements TrafficIncidentBase {
    public TrafficIncidentBaseImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TrafficIncidentBaseImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native LocalizedText getDescription();

    @Nullable
    public native Date getEndTime();

    @NonNull
    public native TrafficIncidentImpact getImpact();

    @Nullable
    public native Date getStartTime();

    @NonNull
    public native TrafficIncidentType getType();
}
