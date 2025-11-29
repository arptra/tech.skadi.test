package com.here.sdk.navigation;

import androidx.annotation.NonNull;

public interface DangerZoneWarningListener {
    void onDangerZoneWarningsUpdated(@NonNull DangerZoneWarning dangerZoneWarning);
}
