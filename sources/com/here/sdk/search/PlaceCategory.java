package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;

public final class PlaceCategory extends NativeBase {
    public static final String ACCOMMODATION = "500";
    public static final String ACCOMMODATION_HOTEL_MOTEL = "500-5000";
    public static final String ACCOMMODATION_LODGING = "500-5100";
    public static final String AREAS_AND_BUILDINGS = "900";
    public static final String AREAS_AND_BUILDINGS_OUTDOOR_COMPLEX = "900-9200";
    public static final String AREAS_AND_BUILDINGS_RESIDENTAL_OFFICE = "900-9300";
    public static final String BUSINESS_AND_COMMERCIAL_SERVICES = "700-7200";
    public static final String BUSINESS_AND_CONSUMER_SERVICES = "700-7400";
    public static final String BUSINESS_AND_SERVICES = "700";
    public static final String BUSINESS_AND_SERVICES_ATM = "700-7010";
    public static final String BUSINESS_AND_SERVICES_BANKING = "700-7000";
    public static final String BUSINESS_AND_SERVICES_CAR_DEALER_SALES = "700-7800";
    public static final String BUSINESS_AND_SERVICES_CAR_RENTAL = "700-7851";
    public static final String BUSINESS_AND_SERVICES_CAR_REPAIR_SERVICES = "700-7850";
    public static final String BUSINESS_AND_SERVICES_COMMUNICATION_MEDIA = "700-7100";
    public static final String BUSINESS_AND_SERVICES_EV_CHARGING_STATION = "700-7600-0322";
    public static final String BUSINESS_AND_SERVICES_FUELING_STATION = "700-7600";
    public static final String BUSINESS_AND_SERVICES_INDUSTRY = "700-7250";
    public static final String BUSINESS_AND_SERVICES_MONEY_CASH = "700-7050";
    public static final String BUSINESS_AND_SERVICES_POLICE_FIRE_EMERGENCY = "700-7300";
    public static final String BUSINESS_AND_SERVICES_POST_OFFICE = "700-7450";
    public static final String BUSINESS_AND_SERVICES_TOURIST_INFORMATION = "700-7460";
    public static final String BUSINESS_AND_SERVICES_TRUCK_SEMI_DEALER = "700-7900";
    public static final String EAT_AND_DRINK = "100";
    public static final String EAT_AND_DRINK_COFFEE_TEA = "100-1100";
    public static final String EAT_AND_DRINK_RESTAURANT = "100-1000";
    public static final String FACILITIES = "800";
    public static final String FACILITIES_EDUCATION = "800-8200";
    public static final String FACILITIES_EVENT_SPACES = "800-8400";
    public static final String FACILITIES_GOVERNMENT_COMMUNITTY = "800-8100";
    public static final String FACILITIES_HOSPITAL_HEALTHCARE = "800-8000";
    public static final String FACILITIES_LIBRARY = "800-8300";
    public static final String FACILITIES_OTHER = "800-8700";
    public static final String FACILITIES_PARKING = "800-8500";
    public static final String FACILITIES_VENUE_SPORTS = "800-8600";
    public static final String GOING_OUT_CINEMA = "200-2100";
    public static final String GOING_OUT_ENTERTAINMENT = "200";
    public static final String GOING_OUT_GAMBLING_LOTTERY_BETTING = "200-2300";
    public static final String GOING_OUT_NIGHTLIFE = "200-2000";
    public static final String GOING_OUT_THEATRE_MUSIC_CULTURE = "200-2200";
    public static final String LEISURE_AND_OUTDOOR = "550";
    public static final String LEISURE_OTHER = "550-5520";
    public static final String LEISURE_OUTDOOR_RECREATION = "550-5510";
    public static final String NATURAL_AND_GEOGRAPHICAL = "350";
    public static final String NATURAL_AND_GEOGRAPHICAL_BODY_OF_WATER = "350-3500";
    public static final String NATURAL_AND_GEOGRAPHICAL_FOREST_HEALTH_OTHER_VEGETATION = "350-3522";
    public static final String NATURAL_AND_GEOGRAPHICAL_MOUNTAIN_OR_HILL = "350-3510";
    public static final String NATURAL_AND_GEOGRAPHICAL_OTHER = "350-3550";
    public static final String NATURAL_AND_GEOGRAPHICAL_UNDERSEA_FEATURE = "350-3520";
    public static final String SHOPPING = "600";
    public static final String SHOPPING_BOOKSTORE = "600-6700";
    public static final String SHOPPING_CLOTHING_AND_ACCESORIES = "600-6800";
    public static final String SHOPPING_CONSUMER_GOODS = "600-6900";
    public static final String SHOPPING_CONVENIENCE_STORE = "600-6000";
    public static final String SHOPPING_DEPARTMENT_STORE = "600-6200";
    public static final String SHOPPING_DRUGSTORE_PHARMACY = "600-6400";
    public static final String SHOPPING_ELECTRONICS = "600-6500";
    public static final String SHOPPING_FOOD_AND_DRINK = "600-6300";
    public static final String SHOPPING_HAIR_AND_BEAUTY = "600-6950";
    public static final String SHOPPING_HARDWARE_HOUSE_GARDEN = "600-6600";
    public static final String SHOPPING_MALL_COMPLEX = "600-6100";
    public static final String SIGHTS_AND_MUSEUMS = "300";
    public static final String SIGHTS_LANDMARK_ATTACTION = "300-3000";
    public static final String SIGHTS_MUSEUM = "300-3100";
    public static final String SIGHTS_RELIGIOUS_PLACE = "300-3200";
    public static final String TRANSPORT = "400";
    public static final String TRANSPORT_AIRPORT = "400-4000";
    public static final String TRANSPORT_CARGO = "400-4200";
    public static final String TRANSPORT_PUBLIC = "400-4100";
    public static final String TRANSPORT_REST_AREA = "400-4300";

    public PlaceCategory(@NonNull String str) {
        this(make(str), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make(@NonNull String str);

    private static native long make(@NonNull String str, @Nullable String str2, boolean z);

    @NonNull
    public native String getId();

    @Nullable
    public native String getName();

    public native boolean isPrimary();

    public PlaceCategory(@NonNull String str, @Nullable String str2, boolean z) {
        this(make(str, str2, z), (Object) null);
        cacheThisInstance();
    }

    public PlaceCategory(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                PlaceCategory.disposeNativeHandle(j);
            }
        });
    }
}
