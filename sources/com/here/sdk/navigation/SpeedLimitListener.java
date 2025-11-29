package com.here.sdk.navigation;

import androidx.annotation.NonNull;

public interface SpeedLimitListener {
    void onSpeedLimitUpdated(@NonNull SpeedLimit speedLimit);
}
