package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.CountryCode;
import com.here.sdk.core.GeoCoordinates;
import java.util.List;
import java.util.Objects;

public final class AddressQuery {
    @Nullable
    public final GeoCoordinates areaCenter;
    @NonNull
    public final List<CountryCode> countries;
    @NonNull
    public final String query;

    public AddressQuery(@NonNull String str, @NonNull GeoCoordinates geoCoordinates) {
        AddressQuery make = make(str, geoCoordinates);
        this.query = make.query;
        this.areaCenter = make.areaCenter;
        this.countries = make.countries;
    }

    private static native AddressQuery make(@NonNull String str);

    private static native AddressQuery make(@NonNull String str, @NonNull GeoCoordinates geoCoordinates);

    private static native AddressQuery make(@NonNull String str, @NonNull GeoCoordinates geoCoordinates, @NonNull List<CountryCode> list);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AddressQuery)) {
            return false;
        }
        AddressQuery addressQuery = (AddressQuery) obj;
        return Objects.equals(this.query, addressQuery.query) && Objects.equals(this.areaCenter, addressQuery.areaCenter) && Objects.equals(this.countries, addressQuery.countries);
    }

    public int hashCode() {
        String str = this.query;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        GeoCoordinates geoCoordinates = this.areaCenter;
        int hashCode2 = (hashCode + (geoCoordinates != null ? geoCoordinates.hashCode() : 0)) * 31;
        List<CountryCode> list = this.countries;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public AddressQuery(@NonNull String str, @NonNull GeoCoordinates geoCoordinates, @NonNull List<CountryCode> list) {
        AddressQuery make = make(str, geoCoordinates, list);
        this.query = make.query;
        this.areaCenter = make.areaCenter;
        this.countries = make.countries;
    }

    public AddressQuery(@NonNull String str) {
        AddressQuery make = make(str);
        this.query = make.query;
        this.areaCenter = make.areaCenter;
        this.countries = make.countries;
    }
}
