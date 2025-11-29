package com.here.sdk.location;

import android.location.Location;
import androidx.annotation.NonNull;
import com.here.services.location.hybrid.HybridLocationApi;

interface LocationProvider {
    HybridLocationApi getHybridLocationProvider();

    Location getLastKnownLocation();

    boolean startLocationUpdates(@NonNull LocationOptions locationOptions);

    void stopLocationUpdates();
}
