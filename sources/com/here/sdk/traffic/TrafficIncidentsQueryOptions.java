package com.here.sdk.traffic;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.LanguageCode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public final class TrafficIncidentsQueryOptions {
    @Nullable
    public Date earliestStartTime = null;
    @NonNull
    public List<TrafficIncidentImpact> impactFilter = new ArrayList();
    @Nullable
    public LanguageCode languageCode = null;
    @Nullable
    public Date latestEndTime = null;
    @NonNull
    public List<TrafficIncidentType> typeFilter = new ArrayList();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrafficIncidentsQueryOptions)) {
            return false;
        }
        TrafficIncidentsQueryOptions trafficIncidentsQueryOptions = (TrafficIncidentsQueryOptions) obj;
        return Objects.equals(this.typeFilter, trafficIncidentsQueryOptions.typeFilter) && Objects.equals(this.impactFilter, trafficIncidentsQueryOptions.impactFilter) && Objects.equals(this.earliestStartTime, trafficIncidentsQueryOptions.earliestStartTime) && Objects.equals(this.latestEndTime, trafficIncidentsQueryOptions.latestEndTime) && Objects.equals(this.languageCode, trafficIncidentsQueryOptions.languageCode);
    }

    public int hashCode() {
        List<TrafficIncidentType> list = this.typeFilter;
        int i = 0;
        int hashCode = (217 + (list != null ? list.hashCode() : 0)) * 31;
        List<TrafficIncidentImpact> list2 = this.impactFilter;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        Date date = this.earliestStartTime;
        int hashCode3 = (hashCode2 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.latestEndTime;
        int hashCode4 = (hashCode3 + (date2 != null ? date2.hashCode() : 0)) * 31;
        LanguageCode languageCode2 = this.languageCode;
        if (languageCode2 != null) {
            i = languageCode2.hashCode();
        }
        return hashCode4 + i;
    }
}
