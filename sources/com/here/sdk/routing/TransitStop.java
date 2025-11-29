package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.time.Duration;

public final class TransitStop {
    @NonNull
    public TransitDeparture departure;
    @Nullable
    public Duration duration = null;

    public TransitStop(@NonNull TransitDeparture transitDeparture) {
        this.departure = transitDeparture;
    }
}
