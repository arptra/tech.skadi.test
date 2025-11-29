package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.time.Duration;

public final class FarePrice {
    @NonNull
    public String currency = "EUR";
    public boolean estimated = false;
    public double maximum = 0.0d;
    public double minimum = 0.0d;
    @NonNull
    public FarePriceType type = FarePriceType.VALUE;
    @Nullable
    public Duration validityPeriod = null;
}
