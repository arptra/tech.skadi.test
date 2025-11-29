package com.here.sdk.venue.control;

import androidx.annotation.NonNull;
import com.here.sdk.core.GeoBox;
import com.here.sdk.venue.data.VenueGeometry;
import java.util.List;

interface Renderer {
    void addVenue(@NonNull Venue venue);

    boolean center(@NonNull VenueGeometry venueGeometry);

    @NonNull
    GeoBox getViewRectangle();

    float getZoomLevel();

    void removeVenue(@NonNull Venue venue);

    void selectVenue(@NonNull Venue venue);

    void update();

    void updateGeometries(@NonNull Venue venue, @NonNull List<VenueGeometry> list);
}
