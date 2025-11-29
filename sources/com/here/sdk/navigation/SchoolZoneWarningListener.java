package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.List;

public interface SchoolZoneWarningListener {
    void onSchoolZoneWarningUpdated(@NonNull List<SchoolZoneWarning> list);
}
