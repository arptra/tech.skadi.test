package com.here.sdk.navigation;

import androidx.annotation.NonNull;

public interface MilestoneStatusListener {
    void onMilestoneStatusUpdated(@NonNull Milestone milestone, @NonNull MilestoneStatus milestoneStatus);
}
