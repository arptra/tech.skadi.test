package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.List;

public interface EnvironmentalZoneWarningListener {
    void onEnvironmentalZoneWarningsUpdated(@NonNull List<EnvironmentalZoneWarning> list);
}
