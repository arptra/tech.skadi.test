package com.here.sdk.venue.control;

import androidx.annotation.Nullable;

@FunctionalInterface
public interface VenueLoadErrorCallback {
    void onVenueLoadError(@Nullable VenueErrorCode venueErrorCode);
}
