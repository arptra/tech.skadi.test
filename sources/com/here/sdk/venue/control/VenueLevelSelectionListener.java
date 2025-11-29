package com.here.sdk.venue.control;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.venue.data.VenueDrawing;
import com.here.sdk.venue.data.VenueLevel;

public interface VenueLevelSelectionListener {
    void onLevelSelected(@NonNull Venue venue, @NonNull VenueDrawing venueDrawing, @Nullable VenueLevel venueLevel, @NonNull VenueLevel venueLevel2);
}
