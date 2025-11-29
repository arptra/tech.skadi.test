package com.here.sdk.routing;

import androidx.annotation.NonNull;
import com.here.time.Duration;

public final class RouteStop {
    public int locationIndex;
    @NonNull
    public Duration stopDuration = Duration.ofSeconds(0);

    public RouteStop(int i) {
        this.locationIndex = i;
    }
}
