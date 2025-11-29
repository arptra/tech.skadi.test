package com.here.sdk.navigation;

import androidx.annotation.NonNull;

public interface RoadSignWarningListener {
    void onRoadSignWarningUpdated(@NonNull RoadSignWarning roadSignWarning);
}
