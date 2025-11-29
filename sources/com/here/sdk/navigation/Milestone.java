package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.GeoCoordinates;
import java.util.Objects;

public final class Milestone {
    @NonNull
    public GeoCoordinates mapMatchedCoordinates;
    @Nullable
    public GeoCoordinates originalCoordinates;
    public int sectionIndex;
    @NonNull
    public MilestoneType type;
    @Nullable
    public Integer waypointIndex;

    @Deprecated
    public Milestone(int i, @Nullable Integer num, @Nullable GeoCoordinates geoCoordinates, @NonNull GeoCoordinates geoCoordinates2) {
        this.sectionIndex = i;
        this.waypointIndex = num;
        this.originalCoordinates = geoCoordinates;
        this.mapMatchedCoordinates = geoCoordinates2;
        this.type = MilestoneType.STOPOVER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Milestone)) {
            return false;
        }
        Milestone milestone = (Milestone) obj;
        return this.sectionIndex == milestone.sectionIndex && Objects.equals(this.waypointIndex, milestone.waypointIndex) && Objects.equals(this.originalCoordinates, milestone.originalCoordinates) && Objects.equals(this.mapMatchedCoordinates, milestone.mapMatchedCoordinates) && Objects.equals(this.type, milestone.type);
    }

    public int hashCode() {
        int i = (217 + this.sectionIndex) * 31;
        Integer num = this.waypointIndex;
        int i2 = 0;
        int hashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
        GeoCoordinates geoCoordinates = this.originalCoordinates;
        int hashCode2 = (hashCode + (geoCoordinates != null ? geoCoordinates.hashCode() : 0)) * 31;
        GeoCoordinates geoCoordinates2 = this.mapMatchedCoordinates;
        int hashCode3 = (hashCode2 + (geoCoordinates2 != null ? geoCoordinates2.hashCode() : 0)) * 31;
        MilestoneType milestoneType = this.type;
        if (milestoneType != null) {
            i2 = milestoneType.hashCode();
        }
        return hashCode3 + i2;
    }

    public Milestone(int i, @Nullable Integer num, @Nullable GeoCoordinates geoCoordinates, @NonNull GeoCoordinates geoCoordinates2, @NonNull MilestoneType milestoneType) {
        this.sectionIndex = i;
        this.waypointIndex = num;
        this.originalCoordinates = geoCoordinates;
        this.mapMatchedCoordinates = geoCoordinates2;
        this.type = milestoneType;
    }
}
