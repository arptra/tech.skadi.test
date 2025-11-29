package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.sdk.routing.RoadTexts;

public interface RoadTextsListener {
    void onRoadTextsUpdated(@NonNull RoadTexts roadTexts);
}
