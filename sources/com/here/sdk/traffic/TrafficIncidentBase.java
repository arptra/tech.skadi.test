package com.here.sdk.traffic;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.LocalizedText;
import java.util.Date;

public interface TrafficIncidentBase {
    @NonNull
    LocalizedText getDescription();

    @Nullable
    Date getEndTime();

    @NonNull
    TrafficIncidentImpact getImpact();

    @Nullable
    Date getStartTime();

    @NonNull
    TrafficIncidentType getType();
}
