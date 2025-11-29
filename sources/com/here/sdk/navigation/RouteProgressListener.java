package com.here.sdk.navigation;

import androidx.annotation.NonNull;

public interface RouteProgressListener {
    void onRouteProgressUpdated(@NonNull RouteProgress routeProgress);
}
