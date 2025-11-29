package com.here.sdk.search;

import androidx.annotation.Nullable;

@FunctionalInterface
public interface PlaceIdSearchCallbackExtended {
    void onPlaceIdSearchExtendedCompleted(@Nullable SearchError searchError, @Nullable Place place, @Nullable ResponseDetails responseDetails);
}
