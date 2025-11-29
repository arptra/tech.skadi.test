package com.here.sdk.venue.control;

import androidx.annotation.NonNull;

public interface VenueLifecycleListener {
    void onVenueAdded(@NonNull Venue venue);

    void onVenueRemoved(int i);
}
