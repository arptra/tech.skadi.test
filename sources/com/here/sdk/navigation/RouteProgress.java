package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.Objects;

public final class RouteProgress {
    @NonNull
    public List<ManeuverProgress> maneuverProgress;
    public int sectionIndex;
    @NonNull
    public List<SectionProgress> sectionProgress;
    public int spanIndex;

    public RouteProgress(int i, int i2, @NonNull List<SectionProgress> list, @NonNull List<ManeuverProgress> list2) {
        this.sectionIndex = i;
        this.spanIndex = i2;
        this.sectionProgress = list;
        this.maneuverProgress = list2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RouteProgress)) {
            return false;
        }
        RouteProgress routeProgress = (RouteProgress) obj;
        return this.sectionIndex == routeProgress.sectionIndex && this.spanIndex == routeProgress.spanIndex && Objects.equals(this.sectionProgress, routeProgress.sectionProgress) && Objects.equals(this.maneuverProgress, routeProgress.maneuverProgress);
    }

    public int hashCode() {
        int i = (((217 + this.sectionIndex) * 31) + this.spanIndex) * 31;
        List<SectionProgress> list = this.sectionProgress;
        int i2 = 0;
        int hashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<ManeuverProgress> list2 = this.maneuverProgress;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        return hashCode + i2;
    }
}
