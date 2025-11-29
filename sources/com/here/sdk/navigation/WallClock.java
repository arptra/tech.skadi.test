package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.Date;

interface WallClock {
    @NonNull
    static WallClock getDefault() {
        return WallClockImpl.getDefault();
    }

    @NonNull
    Date now();
}
