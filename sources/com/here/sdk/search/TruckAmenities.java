package com.here.sdk.search;

import androidx.annotation.Nullable;
import java.util.Objects;

public final class TruckAmenities {
    public boolean hasCarWash = false;
    public boolean hasChemicalToiletDisposal = false;
    public boolean hasHighCanopy = false;
    public boolean hasIdleReductionSystem = false;
    public boolean hasParking = false;
    public boolean hasPowerSupply = false;
    public boolean hasSecureParking = false;
    public boolean hasShower = false;
    public boolean hasTruckScales = false;
    public boolean hasTruckService = false;
    public boolean hasTruckStop = false;
    public boolean hasTruckWash = false;
    public boolean hasWifi = false;
    @Nullable
    public Integer showerCount = null;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TruckAmenities)) {
            return false;
        }
        TruckAmenities truckAmenities = (TruckAmenities) obj;
        return this.hasParking == truckAmenities.hasParking && this.hasSecureParking == truckAmenities.hasSecureParking && this.hasCarWash == truckAmenities.hasCarWash && this.hasTruckWash == truckAmenities.hasTruckWash && this.hasHighCanopy == truckAmenities.hasHighCanopy && this.hasIdleReductionSystem == truckAmenities.hasIdleReductionSystem && this.hasTruckScales == truckAmenities.hasTruckScales && this.hasPowerSupply == truckAmenities.hasPowerSupply && this.hasChemicalToiletDisposal == truckAmenities.hasChemicalToiletDisposal && this.hasTruckStop == truckAmenities.hasTruckStop && this.hasWifi == truckAmenities.hasWifi && this.hasTruckService == truckAmenities.hasTruckService && this.hasShower == truckAmenities.hasShower && Objects.equals(this.showerCount, truckAmenities.showerCount);
    }

    public int hashCode() {
        int i = 97;
        int i2 = (((((((((((((((((((((((217 + (this.hasParking ? 79 : 97)) * 31) + (this.hasSecureParking ? 79 : 97)) * 31) + (this.hasCarWash ? 79 : 97)) * 31) + (this.hasTruckWash ? 79 : 97)) * 31) + (this.hasHighCanopy ? 79 : 97)) * 31) + (this.hasIdleReductionSystem ? 79 : 97)) * 31) + (this.hasTruckScales ? 79 : 97)) * 31) + (this.hasPowerSupply ? 79 : 97)) * 31) + (this.hasChemicalToiletDisposal ? 79 : 97)) * 31) + (this.hasTruckStop ? 79 : 97)) * 31) + (this.hasWifi ? 79 : 97)) * 31) + (this.hasTruckService ? 79 : 97)) * 31;
        if (this.hasShower) {
            i = 79;
        }
        int i3 = (i2 + i) * 31;
        Integer num = this.showerCount;
        return i3 + (num != null ? num.hashCode() : 0);
    }
}
