package com.here.sdk.location;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.Location;
import com.here.sdk.core.LocationListener;

class LocationEngineBaseImpl extends NativeBase implements LocationEngineBase {
    public LocationEngineBaseImpl(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                LocationEngineBaseImpl.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void addLocationIssueListener(@NonNull LocationIssueListener locationIssueListener);

    public native void addLocationListener(@NonNull LocationListener locationListener);

    public native void addLocationStatusListener(@NonNull LocationStatusListener locationStatusListener);

    @Nullable
    public native Location getLastKnownLocation();

    public native boolean isStarted();

    public native void removeLocationIssueListener(@NonNull LocationIssueListener locationIssueListener);

    public native void removeLocationListener(@NonNull LocationListener locationListener);

    public native void removeLocationStatusListener(@NonNull LocationStatusListener locationStatusListener);

    public native void setCallListenerFromMainThreadEnabled(boolean z);

    @NonNull
    public native LocationEngineStatus start(@NonNull LocationAccuracy locationAccuracy);

    @NonNull
    public native LocationEngineStatus start(@NonNull LocationOptions locationOptions);

    public native void stop();

    @NonNull
    public native LocationEngineStatus updateLocationAccuracy(@NonNull LocationAccuracy locationAccuracy);

    @NonNull
    public native LocationEngineStatus updateLocationOptions(@NonNull LocationOptions locationOptions);
}
