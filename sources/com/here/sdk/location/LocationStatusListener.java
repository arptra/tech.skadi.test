package com.here.sdk.location;

import androidx.annotation.NonNull;
import java.util.List;

public interface LocationStatusListener {
    void onFeaturesNotAvailable(@NonNull List<LocationFeature> list);

    void onStatusChanged(@NonNull LocationEngineStatus locationEngineStatus);
}
