package com.here.sdk.search;

import androidx.annotation.Nullable;

@FunctionalInterface
public interface PlaceIdSearchCallback {
    void onPlaceIdSearchCompleted(@Nullable SearchError searchError, @Nullable Place place);
}
