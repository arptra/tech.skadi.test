package com.here.sdk.navigation;

import androidx.annotation.NonNull;

public interface SpatialManeuverNotificationListener {
    void onSpatialManeuverNotification(@NonNull SpatialManeuver spatialManeuver, @NonNull SpatialManeuverAudioCuePanning spatialManeuverAudioCuePanning);
}
