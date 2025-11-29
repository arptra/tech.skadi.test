package com.here.sdk.navigation;

import androidx.annotation.NonNull;

public interface ManeuverViewLaneAssistanceListener {
    void onLaneAssistanceUpdated(@NonNull ManeuverViewLaneAssistance maneuverViewLaneAssistance);
}
