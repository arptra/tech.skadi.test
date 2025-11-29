package com.here.sdk.venue.control;

import androidx.annotation.Nullable;

public interface VenueSelectionListener {
    void onSelectedVenueChanged(@Nullable Venue venue, @Nullable Venue venue2);
}
