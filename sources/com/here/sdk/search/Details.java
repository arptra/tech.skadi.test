package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Details {
    @NonNull
    public List<PlaceCategory> categories;
    @NonNull
    public List<Contact> contacts;
    @NonNull
    public List<WebEditorial> editorials;
    @Nullable
    public EVChargingPool evChargingPool;
    @NonNull
    public List<PlaceFoodType> foodTypes;
    @Nullable
    public FuelStation fuelStation;
    @NonNull
    public List<WebImage> images;
    @NonNull
    public List<OpeningHours> openingHours;
    @Nullable
    public POIPaymentDetails payment;
    @NonNull
    public List<WebRating> ratings;
    @NonNull
    public List<SupplierReference> references;
    @Nullable
    public TruckAmenities truckAmenities;

    public Details(@NonNull List<Contact> list, @NonNull List<OpeningHours> list2, @NonNull List<PlaceCategory> list3, @NonNull List<WebImage> list4, @NonNull List<WebEditorial> list5, @NonNull List<WebRating> list6, @NonNull List<SupplierReference> list7) {
        this.contacts = list;
        this.openingHours = list2;
        this.categories = list3;
        this.images = list4;
        this.editorials = list5;
        this.ratings = list6;
        this.references = list7;
        this.evChargingPool = null;
        this.truckAmenities = null;
        this.fuelStation = null;
        this.foodTypes = new ArrayList();
        this.payment = null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Details)) {
            return false;
        }
        Details details = (Details) obj;
        return Objects.equals(this.contacts, details.contacts) && Objects.equals(this.openingHours, details.openingHours) && Objects.equals(this.categories, details.categories) && Objects.equals(this.images, details.images) && Objects.equals(this.editorials, details.editorials) && Objects.equals(this.ratings, details.ratings) && Objects.equals(this.references, details.references) && Objects.equals(this.evChargingPool, details.evChargingPool) && Objects.equals(this.truckAmenities, details.truckAmenities) && Objects.equals(this.fuelStation, details.fuelStation) && Objects.equals(this.foodTypes, details.foodTypes) && Objects.equals(this.payment, details.payment);
    }

    @NonNull
    public native List<PlaceCategory> getPrimaryCategories();

    public int hashCode() {
        List<Contact> list = this.contacts;
        int i = 0;
        int hashCode = (217 + (list != null ? list.hashCode() : 0)) * 31;
        List<OpeningHours> list2 = this.openingHours;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<PlaceCategory> list3 = this.categories;
        int hashCode3 = (hashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<WebImage> list4 = this.images;
        int hashCode4 = (hashCode3 + (list4 != null ? list4.hashCode() : 0)) * 31;
        List<WebEditorial> list5 = this.editorials;
        int hashCode5 = (hashCode4 + (list5 != null ? list5.hashCode() : 0)) * 31;
        List<WebRating> list6 = this.ratings;
        int hashCode6 = (hashCode5 + (list6 != null ? list6.hashCode() : 0)) * 31;
        List<SupplierReference> list7 = this.references;
        int hashCode7 = (hashCode6 + (list7 != null ? list7.hashCode() : 0)) * 31;
        EVChargingPool eVChargingPool = this.evChargingPool;
        int hashCode8 = (hashCode7 + (eVChargingPool != null ? eVChargingPool.hashCode() : 0)) * 31;
        TruckAmenities truckAmenities2 = this.truckAmenities;
        int hashCode9 = (hashCode8 + (truckAmenities2 != null ? truckAmenities2.hashCode() : 0)) * 31;
        FuelStation fuelStation2 = this.fuelStation;
        int hashCode10 = (hashCode9 + (fuelStation2 != null ? fuelStation2.hashCode() : 0)) * 31;
        List<PlaceFoodType> list8 = this.foodTypes;
        int hashCode11 = (hashCode10 + (list8 != null ? list8.hashCode() : 0)) * 31;
        POIPaymentDetails pOIPaymentDetails = this.payment;
        if (pOIPaymentDetails != null) {
            i = pOIPaymentDetails.hashCode();
        }
        return hashCode11 + i;
    }

    public Details(@NonNull List<Contact> list, @NonNull List<OpeningHours> list2, @NonNull List<PlaceCategory> list3, @NonNull List<WebImage> list4, @NonNull List<WebEditorial> list5, @NonNull List<WebRating> list6, @NonNull List<SupplierReference> list7, @Nullable EVChargingPool eVChargingPool) {
        this.contacts = list;
        this.openingHours = list2;
        this.categories = list3;
        this.images = list4;
        this.editorials = list5;
        this.ratings = list6;
        this.references = list7;
        this.evChargingPool = eVChargingPool;
        this.truckAmenities = null;
        this.fuelStation = null;
        this.foodTypes = new ArrayList();
        this.payment = null;
    }

    public Details(@NonNull List<Contact> list, @NonNull List<OpeningHours> list2, @NonNull List<PlaceCategory> list3, @NonNull List<WebImage> list4, @NonNull List<WebEditorial> list5, @NonNull List<WebRating> list6, @NonNull List<SupplierReference> list7, @Nullable EVChargingPool eVChargingPool, @Nullable TruckAmenities truckAmenities2) {
        this.contacts = list;
        this.openingHours = list2;
        this.categories = list3;
        this.images = list4;
        this.editorials = list5;
        this.ratings = list6;
        this.references = list7;
        this.evChargingPool = eVChargingPool;
        this.truckAmenities = truckAmenities2;
        this.fuelStation = null;
        this.foodTypes = new ArrayList();
        this.payment = null;
    }

    public Details(@NonNull List<Contact> list, @NonNull List<OpeningHours> list2, @NonNull List<PlaceCategory> list3, @NonNull List<WebImage> list4, @NonNull List<WebEditorial> list5, @NonNull List<WebRating> list6, @NonNull List<SupplierReference> list7, @Nullable EVChargingPool eVChargingPool, @Nullable TruckAmenities truckAmenities2, @Nullable FuelStation fuelStation2) {
        this.contacts = list;
        this.openingHours = list2;
        this.categories = list3;
        this.images = list4;
        this.editorials = list5;
        this.ratings = list6;
        this.references = list7;
        this.evChargingPool = eVChargingPool;
        this.truckAmenities = truckAmenities2;
        this.fuelStation = fuelStation2;
        this.foodTypes = new ArrayList();
        this.payment = null;
    }

    public Details(@NonNull List<Contact> list, @NonNull List<OpeningHours> list2, @NonNull List<PlaceCategory> list3, @NonNull List<WebImage> list4, @NonNull List<WebEditorial> list5, @NonNull List<WebRating> list6, @NonNull List<SupplierReference> list7, @Nullable EVChargingPool eVChargingPool, @Nullable TruckAmenities truckAmenities2, @Nullable FuelStation fuelStation2, @NonNull List<PlaceFoodType> list8) {
        this.contacts = list;
        this.openingHours = list2;
        this.categories = list3;
        this.images = list4;
        this.editorials = list5;
        this.ratings = list6;
        this.references = list7;
        this.evChargingPool = eVChargingPool;
        this.truckAmenities = truckAmenities2;
        this.fuelStation = fuelStation2;
        this.foodTypes = list8;
        this.payment = null;
    }

    public Details(@NonNull List<Contact> list, @NonNull List<OpeningHours> list2, @NonNull List<PlaceCategory> list3, @NonNull List<WebImage> list4, @NonNull List<WebEditorial> list5, @NonNull List<WebRating> list6, @NonNull List<SupplierReference> list7, @Nullable EVChargingPool eVChargingPool, @Nullable TruckAmenities truckAmenities2, @Nullable FuelStation fuelStation2, @NonNull List<PlaceFoodType> list8, @Nullable POIPaymentDetails pOIPaymentDetails) {
        this.contacts = list;
        this.openingHours = list2;
        this.categories = list3;
        this.images = list4;
        this.editorials = list5;
        this.ratings = list6;
        this.references = list7;
        this.evChargingPool = eVChargingPool;
        this.truckAmenities = truckAmenities2;
        this.fuelStation = fuelStation2;
        this.foodTypes = list8;
        this.payment = pOIPaymentDetails;
    }
}
