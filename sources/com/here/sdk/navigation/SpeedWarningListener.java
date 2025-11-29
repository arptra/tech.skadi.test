package com.here.sdk.navigation;

import androidx.annotation.NonNull;

public interface SpeedWarningListener {
    void onSpeedWarningStatusChanged(@NonNull SpeedWarningStatus speedWarningStatus);
}
