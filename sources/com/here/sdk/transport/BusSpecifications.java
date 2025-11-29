package com.here.sdk.transport;

import androidx.annotation.Nullable;
import java.util.Objects;

public final class BusSpecifications {
    @Nullable
    public Integer grossWeightInKilograms = null;
    @Nullable
    public Integer heightInCentimeters = null;
    @Nullable
    public String lastCharacterOfLicensePlate = null;
    @Nullable
    public Integer lengthInCentimeters = null;
    @Nullable
    public Integer widthInCentimeters = null;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BusSpecifications)) {
            return false;
        }
        BusSpecifications busSpecifications = (BusSpecifications) obj;
        return Objects.equals(this.grossWeightInKilograms, busSpecifications.grossWeightInKilograms) && Objects.equals(this.heightInCentimeters, busSpecifications.heightInCentimeters) && Objects.equals(this.widthInCentimeters, busSpecifications.widthInCentimeters) && Objects.equals(this.lengthInCentimeters, busSpecifications.lengthInCentimeters) && Objects.equals(this.lastCharacterOfLicensePlate, busSpecifications.lastCharacterOfLicensePlate);
    }

    public int hashCode() {
        Integer num = this.grossWeightInKilograms;
        int i = 0;
        int hashCode = (217 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.heightInCentimeters;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.widthInCentimeters;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.lengthInCentimeters;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
        String str = this.lastCharacterOfLicensePlate;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode4 + i;
    }
}
