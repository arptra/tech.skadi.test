package com.here.sdk.core;

import androidx.annotation.NonNull;

public interface LocationListener {
    void onLocationUpdated(@NonNull Location location);
}
