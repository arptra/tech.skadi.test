package com.here.sdk.venue.service;

import androidx.annotation.NonNull;

public interface VenueServiceListener {
    void onInitializationCompleted(@NonNull VenueServiceInitStatus venueServiceInitStatus);

    void onVenueServiceStopped();
}
