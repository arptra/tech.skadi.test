package com.here.services.location;

import android.location.Location;
import androidx.annotation.NonNull;
import com.here.services.common.PositioningError;

public interface LocationListener {
    void onLocationChanged(@NonNull Location location);

    void onLocationInfoChanged(@NonNull PositioningError positioningError);

    void onLocationRequestFailed(@NonNull PositioningError positioningError);

    void onOptionsChanged(@NonNull OptionsChangedEvent optionsChangedEvent);

    void onOptionsRestored() {
    }
}
