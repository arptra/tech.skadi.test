package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class Fare {
    @NonNull
    public String name;
    @Nullable
    public FarePrice price;
    @NonNull
    public FareReason reason;

    public Fare(@NonNull String str, @Nullable FarePrice farePrice, @NonNull FareReason fareReason) {
        this.name = str;
        this.price = farePrice;
        this.reason = fareReason;
    }
}
