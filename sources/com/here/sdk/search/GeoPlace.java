package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.ExternalID;
import com.here.sdk.core.GeoCoordinates;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class GeoPlace {
    @NonNull
    public Address address = new Address();
    @NonNull
    public BusinessDetails business = new BusinessDetails();
    @NonNull
    public List<PlaceCategory> categories = new ArrayList();
    @NonNull
    public List<ExternalID> externalIDs = new ArrayList();
    @NonNull
    String id = "";
    @Nullable
    public LocationDetails location = null;
    boolean myPlace = false;
    @NonNull
    public String title = "";
    @NonNull
    public PlaceType type = PlaceType.UNKNOWN;
    @NonNull
    public WebDetails web = new WebDetails();

    @NonNull
    public static native GeoPlace makeMyPlace(@NonNull String str, @NonNull GeoCoordinates geoCoordinates);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GeoPlace)) {
            return false;
        }
        GeoPlace geoPlace = (GeoPlace) obj;
        return Objects.equals(this.title, geoPlace.title) && Objects.equals(this.externalIDs, geoPlace.externalIDs) && Objects.equals(this.type, geoPlace.type) && Objects.equals(this.categories, geoPlace.categories) && Objects.equals(this.address, geoPlace.address) && Objects.equals(this.location, geoPlace.location) && Objects.equals(this.business, geoPlace.business) && Objects.equals(this.web, geoPlace.web) && Objects.equals(this.id, geoPlace.id) && this.myPlace == geoPlace.myPlace;
    }

    @NonNull
    public native String getID();

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        List<ExternalID> list = this.externalIDs;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        PlaceType placeType = this.type;
        int hashCode3 = (hashCode2 + (placeType != null ? placeType.hashCode() : 0)) * 31;
        List<PlaceCategory> list2 = this.categories;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Address address2 = this.address;
        int hashCode5 = (hashCode4 + (address2 != null ? address2.hashCode() : 0)) * 31;
        LocationDetails locationDetails = this.location;
        int hashCode6 = (hashCode5 + (locationDetails != null ? locationDetails.hashCode() : 0)) * 31;
        BusinessDetails businessDetails = this.business;
        int hashCode7 = (hashCode6 + (businessDetails != null ? businessDetails.hashCode() : 0)) * 31;
        WebDetails webDetails = this.web;
        int hashCode8 = (hashCode7 + (webDetails != null ? webDetails.hashCode() : 0)) * 31;
        String str2 = this.id;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode8 + i) * 31) + (this.myPlace ? 79 : 97);
    }

    public native boolean isMyPlace();
}
