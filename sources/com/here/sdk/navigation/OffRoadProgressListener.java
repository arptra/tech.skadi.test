package com.here.sdk.navigation;

import androidx.annotation.NonNull;

public interface OffRoadProgressListener {
    void onOffRoadProgressUpdated(@NonNull OffRoadProgress offRoadProgress);
}
