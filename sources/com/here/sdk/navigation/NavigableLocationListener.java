package com.here.sdk.navigation;

import androidx.annotation.NonNull;

public interface NavigableLocationListener {
    void onNavigableLocationUpdated(@NonNull NavigableLocation navigableLocation);
}
