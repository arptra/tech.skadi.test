package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class CurrentSituationLaneView {
    @NonNull
    public LaneAccess access;
    @NonNull
    public LaneDirectionCategory directionCategory;
    @NonNull
    public LaneType type;

    public CurrentSituationLaneView(@NonNull LaneAccess laneAccess, @NonNull LaneDirectionCategory laneDirectionCategory, @NonNull LaneType laneType) {
        this.access = laneAccess;
        this.directionCategory = laneDirectionCategory;
        this.type = laneType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrentSituationLaneView)) {
            return false;
        }
        CurrentSituationLaneView currentSituationLaneView = (CurrentSituationLaneView) obj;
        return Objects.equals(this.access, currentSituationLaneView.access) && Objects.equals(this.directionCategory, currentSituationLaneView.directionCategory) && Objects.equals(this.type, currentSituationLaneView.type);
    }

    public int hashCode() {
        LaneAccess laneAccess = this.access;
        int i = 0;
        int hashCode = (217 + (laneAccess != null ? laneAccess.hashCode() : 0)) * 31;
        LaneDirectionCategory laneDirectionCategory = this.directionCategory;
        int hashCode2 = (hashCode + (laneDirectionCategory != null ? laneDirectionCategory.hashCode() : 0)) * 31;
        LaneType laneType = this.type;
        if (laneType != null) {
            i = laneType.hashCode();
        }
        return hashCode2 + i;
    }
}
