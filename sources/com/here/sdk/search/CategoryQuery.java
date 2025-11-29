package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.GeoBox;
import com.here.sdk.core.GeoCircle;
import com.here.sdk.core.GeoCoordinates;
import com.here.sdk.core.GeoCorridor;
import java.util.List;
import java.util.Objects;

public final class CategoryQuery {
    @NonNull
    public Area area;
    @NonNull
    public List<PlaceCategory> categories;
    @NonNull
    public List<PlaceCategory> excludeCategories;
    @NonNull
    public List<PlaceChain> excludeChains;
    @NonNull
    public List<PlaceFoodType> excludeFoodTypes;
    @Nullable
    public String filter;
    @NonNull
    public List<PlaceChain> includeChains;
    @NonNull
    public List<PlaceFoodType> includeFoodTypes;
    @NonNull
    public PlaceFilter placeFilter;

    public CategoryQuery(@NonNull PlaceCategory placeCategory, @NonNull Area area2) {
        CategoryQuery make = make(placeCategory, area2);
        this.categories = make.categories;
        this.excludeCategories = make.excludeCategories;
        this.includeChains = make.includeChains;
        this.excludeChains = make.excludeChains;
        this.includeFoodTypes = make.includeFoodTypes;
        this.excludeFoodTypes = make.excludeFoodTypes;
        this.filter = make.filter;
        this.placeFilter = make.placeFilter;
        this.area = make.area;
    }

    private static native CategoryQuery make(@NonNull PlaceCategory placeCategory, @NonNull Area area2);

    private static native CategoryQuery make(@NonNull PlaceCategory placeCategory, @NonNull String str, @NonNull Area area2);

    private static native CategoryQuery make(@NonNull List<PlaceCategory> list, @NonNull Area area2);

    private static native CategoryQuery make(@NonNull List<PlaceCategory> list, @NonNull String str, @NonNull Area area2);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CategoryQuery)) {
            return false;
        }
        CategoryQuery categoryQuery = (CategoryQuery) obj;
        return Objects.equals(this.categories, categoryQuery.categories) && Objects.equals(this.excludeCategories, categoryQuery.excludeCategories) && Objects.equals(this.includeChains, categoryQuery.includeChains) && Objects.equals(this.excludeChains, categoryQuery.excludeChains) && Objects.equals(this.includeFoodTypes, categoryQuery.includeFoodTypes) && Objects.equals(this.excludeFoodTypes, categoryQuery.excludeFoodTypes) && Objects.equals(this.filter, categoryQuery.filter) && Objects.equals(this.placeFilter, categoryQuery.placeFilter) && Objects.equals(this.area, categoryQuery.area);
    }

    public int hashCode() {
        List<PlaceCategory> list = this.categories;
        int i = 0;
        int hashCode = (217 + (list != null ? list.hashCode() : 0)) * 31;
        List<PlaceCategory> list2 = this.excludeCategories;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<PlaceChain> list3 = this.includeChains;
        int hashCode3 = (hashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<PlaceChain> list4 = this.excludeChains;
        int hashCode4 = (hashCode3 + (list4 != null ? list4.hashCode() : 0)) * 31;
        List<PlaceFoodType> list5 = this.includeFoodTypes;
        int hashCode5 = (hashCode4 + (list5 != null ? list5.hashCode() : 0)) * 31;
        List<PlaceFoodType> list6 = this.excludeFoodTypes;
        int hashCode6 = (hashCode5 + (list6 != null ? list6.hashCode() : 0)) * 31;
        String str = this.filter;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 31;
        PlaceFilter placeFilter2 = this.placeFilter;
        int hashCode8 = (hashCode7 + (placeFilter2 != null ? placeFilter2.hashCode() : 0)) * 31;
        Area area2 = this.area;
        if (area2 != null) {
            i = area2.hashCode();
        }
        return hashCode8 + i;
    }

    public static final class Area {
        @NonNull
        public final GeoCoordinates areaCenter;
        @Nullable
        public final GeoBox boxArea;
        @Nullable
        public final GeoCircle circleArea;
        @Nullable
        public final GeoCorridor corridorArea;

        public Area(@NonNull GeoCoordinates geoCoordinates) {
            Area make = make(geoCoordinates);
            this.areaCenter = make.areaCenter;
            this.boxArea = make.boxArea;
            this.circleArea = make.circleArea;
            this.corridorArea = make.corridorArea;
        }

        private static native Area make(@NonNull GeoCoordinates geoCoordinates);

        private static native Area make(@NonNull GeoCoordinates geoCoordinates, @NonNull GeoBox geoBox);

        private static native Area make(@NonNull GeoCoordinates geoCoordinates, @NonNull GeoCircle geoCircle);

        private static native Area make(@NonNull GeoCorridor geoCorridor);

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Area)) {
                return false;
            }
            Area area = (Area) obj;
            return Objects.equals(this.areaCenter, area.areaCenter) && Objects.equals(this.boxArea, area.boxArea) && Objects.equals(this.circleArea, area.circleArea) && Objects.equals(this.corridorArea, area.corridorArea);
        }

        public int hashCode() {
            GeoCoordinates geoCoordinates = this.areaCenter;
            int i = 0;
            int hashCode = (217 + (geoCoordinates != null ? geoCoordinates.hashCode() : 0)) * 31;
            GeoBox geoBox = this.boxArea;
            int hashCode2 = (hashCode + (geoBox != null ? geoBox.hashCode() : 0)) * 31;
            GeoCircle geoCircle = this.circleArea;
            int hashCode3 = (hashCode2 + (geoCircle != null ? geoCircle.hashCode() : 0)) * 31;
            GeoCorridor geoCorridor = this.corridorArea;
            if (geoCorridor != null) {
                i = geoCorridor.hashCode();
            }
            return hashCode3 + i;
        }

        public Area(@NonNull GeoCoordinates geoCoordinates, @NonNull GeoBox geoBox) {
            Area make = make(geoCoordinates, geoBox);
            this.areaCenter = make.areaCenter;
            this.boxArea = make.boxArea;
            this.circleArea = make.circleArea;
            this.corridorArea = make.corridorArea;
        }

        public Area(@NonNull GeoCoordinates geoCoordinates, @NonNull GeoCircle geoCircle) {
            Area make = make(geoCoordinates, geoCircle);
            this.areaCenter = make.areaCenter;
            this.boxArea = make.boxArea;
            this.circleArea = make.circleArea;
            this.corridorArea = make.corridorArea;
        }

        public Area(@NonNull GeoCorridor geoCorridor) {
            Area make = make(geoCorridor);
            this.areaCenter = make.areaCenter;
            this.boxArea = make.boxArea;
            this.circleArea = make.circleArea;
            this.corridorArea = make.corridorArea;
        }
    }

    public CategoryQuery(@NonNull List<PlaceCategory> list, @NonNull Area area2) {
        CategoryQuery make = make(list, area2);
        this.categories = make.categories;
        this.excludeCategories = make.excludeCategories;
        this.includeChains = make.includeChains;
        this.excludeChains = make.excludeChains;
        this.includeFoodTypes = make.includeFoodTypes;
        this.excludeFoodTypes = make.excludeFoodTypes;
        this.filter = make.filter;
        this.placeFilter = make.placeFilter;
        this.area = make.area;
    }

    public CategoryQuery(@NonNull PlaceCategory placeCategory, @NonNull String str, @NonNull Area area2) {
        CategoryQuery make = make(placeCategory, str, area2);
        this.categories = make.categories;
        this.excludeCategories = make.excludeCategories;
        this.includeChains = make.includeChains;
        this.excludeChains = make.excludeChains;
        this.includeFoodTypes = make.includeFoodTypes;
        this.excludeFoodTypes = make.excludeFoodTypes;
        this.filter = make.filter;
        this.placeFilter = make.placeFilter;
        this.area = make.area;
    }

    public CategoryQuery(@NonNull List<PlaceCategory> list, @NonNull String str, @NonNull Area area2) {
        CategoryQuery make = make(list, str, area2);
        this.categories = make.categories;
        this.excludeCategories = make.excludeCategories;
        this.includeChains = make.includeChains;
        this.excludeChains = make.excludeChains;
        this.includeFoodTypes = make.includeFoodTypes;
        this.excludeFoodTypes = make.excludeFoodTypes;
        this.filter = make.filter;
        this.placeFilter = make.placeFilter;
        this.area = make.area;
    }
}
