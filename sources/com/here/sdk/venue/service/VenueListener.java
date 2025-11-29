package com.here.sdk.venue.service;

import androidx.annotation.Nullable;
import com.here.sdk.venue.data.VenueModel;
import com.here.sdk.venue.style.VenueStyle;

public interface VenueListener {
    void onGetVenueCompleted(int i, @Nullable VenueModel venueModel, boolean z, @Nullable VenueStyle venueStyle);
}
