package com.here.sdk.location;

import android.location.Location;
import androidx.annotation.Nullable;

interface PositioningClient extends PositioningClientAndroid {
    @Nullable
    Location getLastKnownLocation();

    void restart();

    boolean start(PositioningClientListener positioningClientListener);

    void stop();
}
