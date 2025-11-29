package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.LocalizedText;
import com.here.sdk.traffic.TrafficIncidentBase;
import com.here.sdk.traffic.TrafficIncidentImpact;
import com.here.sdk.traffic.TrafficIncidentType;
import java.util.Date;

public final class TrafficIncidentOnRoute extends NativeBase implements TrafficIncidentBase {
    public TrafficIncidentOnRoute(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TrafficIncidentOnRoute.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native LocalizedText getDescription();

    @Nullable
    public native Date getEndTime();

    @Nullable
    public native String getId();

    @NonNull
    public native TrafficIncidentImpact getImpact();

    @Nullable
    public native Date getStartTime();

    @NonNull
    public native TrafficIncidentType getType();
}
