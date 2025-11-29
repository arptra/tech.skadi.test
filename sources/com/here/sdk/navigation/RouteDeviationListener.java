package com.here.sdk.navigation;

import androidx.annotation.NonNull;

public interface RouteDeviationListener {
    void onRouteDeviation(@NonNull RouteDeviation routeDeviation);
}
