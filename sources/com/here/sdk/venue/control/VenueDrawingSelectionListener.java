package com.here.sdk.venue.control;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.venue.data.VenueDrawing;

public interface VenueDrawingSelectionListener {
    void onDrawingSelected(@NonNull Venue venue, @Nullable VenueDrawing venueDrawing, @NonNull VenueDrawing venueDrawing2);
}
