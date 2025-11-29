package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.sdk.core.Location;

public interface InterpolatedLocationListener {
    void onInterpolatedLocationUpdated(@NonNull Location location);
}
