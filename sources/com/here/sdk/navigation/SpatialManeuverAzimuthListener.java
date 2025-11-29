package com.here.sdk.navigation;

import androidx.annotation.NonNull;

public interface SpatialManeuverAzimuthListener {
    void onAzimuthNotification(@NonNull SpatialTrajectoryData spatialTrajectoryData);
}
