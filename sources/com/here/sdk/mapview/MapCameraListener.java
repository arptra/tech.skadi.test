package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.sdk.mapview.MapCamera;

public interface MapCameraListener {
    void onMapCameraUpdated(@NonNull MapCamera.State state);
}
