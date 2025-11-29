package com.here.sdk.search;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

public final class Address {
    @NonNull
    public String addressText = "";
    @NonNull
    public String block = "";
    @NonNull
    public String city = "";
    @NonNull
    public String country = "";
    @NonNull
    public String countryCode = "";
    @NonNull
    public String county = "";
    @NonNull
    public String district = "";
    @NonNull
    public String houseNumOrName = "";
    @NonNull
    public String postalCode = "";
    @NonNull
    public String state = "";
    @NonNull
    public String street = "";
    @NonNull
    public String subBlock = "";
    @NonNull
    public String subdistrict = "";
    @Nullable
    public AddressType type = null;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        return Objects.equals(this.city, address.city) && Objects.equals(this.countryCode, address.countryCode) && Objects.equals(this.country, address.country) && Objects.equals(this.district, address.district) && Objects.equals(this.subdistrict, address.subdistrict) && Objects.equals(this.houseNumOrName, address.houseNumOrName) && Objects.equals(this.postalCode, address.postalCode) && Objects.equals(this.state, address.state) && Objects.equals(this.county, address.county) && Objects.equals(this.street, address.street) && Objects.equals(this.block, address.block) && Objects.equals(this.subBlock, address.subBlock) && Objects.equals(this.addressText, address.addressText) && Objects.equals(this.type, address.type);
    }

    public int hashCode() {
        String str = this.city;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.countryCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.country;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.district;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.subdistrict;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.houseNumOrName;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.postalCode;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.state;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.county;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.street;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.block;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.subBlock;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.addressText;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        AddressType addressType = this.type;
        if (addressType != null) {
            i = addressType.hashCode();
        }
        return hashCode13 + i;
    }
}
