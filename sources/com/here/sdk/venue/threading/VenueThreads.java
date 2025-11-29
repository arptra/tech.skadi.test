package com.here.sdk.venue.threading;

import androidx.annotation.NonNull;

interface VenueThreads {
    void createThread(@NonNull String str, @NonNull VenueRunnable venueRunnable);

    void postToMainThread(@NonNull VenueRunnable venueRunnable);
}
