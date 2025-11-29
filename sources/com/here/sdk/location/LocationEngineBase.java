package com.here.sdk.location;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.Location;
import com.here.sdk.core.LocationListener;

public interface LocationEngineBase {
    void addLocationIssueListener(@NonNull LocationIssueListener locationIssueListener);

    void addLocationListener(@NonNull LocationListener locationListener);

    void addLocationStatusListener(@NonNull LocationStatusListener locationStatusListener);

    @Nullable
    Location getLastKnownLocation();

    boolean isStarted();

    void removeLocationIssueListener(@NonNull LocationIssueListener locationIssueListener);

    void removeLocationListener(@NonNull LocationListener locationListener);

    void removeLocationStatusListener(@NonNull LocationStatusListener locationStatusListener);

    void setCallListenerFromMainThreadEnabled(boolean z);

    @NonNull
    LocationEngineStatus start(@NonNull LocationAccuracy locationAccuracy);

    @NonNull
    LocationEngineStatus start(@NonNull LocationOptions locationOptions);

    void stop();

    @NonNull
    LocationEngineStatus updateLocationAccuracy(@NonNull LocationAccuracy locationAccuracy);

    @NonNull
    LocationEngineStatus updateLocationOptions(@NonNull LocationOptions locationOptions);
}
