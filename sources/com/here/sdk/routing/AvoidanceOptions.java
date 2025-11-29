package com.here.sdk.routing;

import androidx.annotation.NonNull;
import com.here.sdk.core.CountryCode;
import com.here.sdk.core.GeoBox;
import com.here.sdk.core.GeoPolygon;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class AvoidanceOptions {
    @NonNull
    @Deprecated
    public List<GeoBox> avoidAreas = new ArrayList();
    @NonNull
    public List<GeoBox> avoidBoundingBoxAreas = new ArrayList();
    @NonNull
    public List<GeoPolygon> avoidPolygonAreas = new ArrayList();
    @NonNull
    public List<CountryCode> countries = new ArrayList();
    @NonNull
    public List<RoadFeatures> roadFeatures = new ArrayList();
    @NonNull
    public List<SegmentReference> segments = new ArrayList();
    @NonNull
    public List<ZoneCategory> zoneCategories = new ArrayList();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AvoidanceOptions)) {
            return false;
        }
        AvoidanceOptions avoidanceOptions = (AvoidanceOptions) obj;
        return Objects.equals(this.roadFeatures, avoidanceOptions.roadFeatures) && Objects.equals(this.countries, avoidanceOptions.countries) && Objects.equals(this.avoidAreas, avoidanceOptions.avoidAreas) && Objects.equals(this.avoidBoundingBoxAreas, avoidanceOptions.avoidBoundingBoxAreas) && Objects.equals(this.avoidPolygonAreas, avoidanceOptions.avoidPolygonAreas) && Objects.equals(this.zoneCategories, avoidanceOptions.zoneCategories) && Objects.equals(this.segments, avoidanceOptions.segments);
    }

    public int hashCode() {
        List<RoadFeatures> list = this.roadFeatures;
        int i = 0;
        int hashCode = (217 + (list != null ? list.hashCode() : 0)) * 31;
        List<CountryCode> list2 = this.countries;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<GeoBox> list3 = this.avoidAreas;
        int hashCode3 = (hashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<GeoBox> list4 = this.avoidBoundingBoxAreas;
        int hashCode4 = (hashCode3 + (list4 != null ? list4.hashCode() : 0)) * 31;
        List<GeoPolygon> list5 = this.avoidPolygonAreas;
        int hashCode5 = (hashCode4 + (list5 != null ? list5.hashCode() : 0)) * 31;
        List<ZoneCategory> list6 = this.zoneCategories;
        int hashCode6 = (hashCode5 + (list6 != null ? list6.hashCode() : 0)) * 31;
        List<SegmentReference> list7 = this.segments;
        if (list7 != null) {
            i = list7.hashCode();
        }
        return hashCode6 + i;
    }
}
