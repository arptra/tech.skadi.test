package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.Objects;

public final class Lane {
    @NonNull
    public LaneAccess access;
    @NonNull
    public LaneDirectionCategory directionCategory;
    @NonNull
    public LaneRecommendationState recommendationState;
    @NonNull
    public LaneType type;

    public Lane(@NonNull LaneType laneType, @NonNull LaneDirectionCategory laneDirectionCategory, @NonNull LaneRecommendationState laneRecommendationState, @NonNull LaneAccess laneAccess) {
        this.type = laneType;
        this.directionCategory = laneDirectionCategory;
        this.recommendationState = laneRecommendationState;
        this.access = laneAccess;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Lane)) {
            return false;
        }
        Lane lane = (Lane) obj;
        return Objects.equals(this.type, lane.type) && Objects.equals(this.directionCategory, lane.directionCategory) && Objects.equals(this.recommendationState, lane.recommendationState) && Objects.equals(this.access, lane.access);
    }

    public int hashCode() {
        LaneType laneType = this.type;
        int i = 0;
        int hashCode = (217 + (laneType != null ? laneType.hashCode() : 0)) * 31;
        LaneDirectionCategory laneDirectionCategory = this.directionCategory;
        int hashCode2 = (hashCode + (laneDirectionCategory != null ? laneDirectionCategory.hashCode() : 0)) * 31;
        LaneRecommendationState laneRecommendationState = this.recommendationState;
        int hashCode3 = (hashCode2 + (laneRecommendationState != null ? laneRecommendationState.hashCode() : 0)) * 31;
        LaneAccess laneAccess = this.access;
        if (laneAccess != null) {
            i = laneAccess.hashCode();
        }
        return hashCode3 + i;
    }
}
