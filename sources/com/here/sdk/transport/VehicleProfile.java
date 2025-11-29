package com.here.sdk.transport;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class VehicleProfile {
    @Nullable
    public Integer axleCount = null;
    @Nullable
    EmissionStandard emissionStandard = null;
    @NonNull
    VehicleEquipment equipment = new VehicleEquipment();
    @Nullable
    FuelType fuelType = null;
    @Nullable
    public Integer grossWeightInKilograms = null;
    @NonNull
    public List<HazardousMaterial> hazardousMaterials = new ArrayList();
    @Nullable
    public Integer heightInCentimeters = null;
    boolean isTaxi = false;
    @Nullable
    public Integer lengthInCentimeters = null;
    int occupantsCount = 1;
    @Nullable
    PlateNumberType plateNumberType = null;
    public int trailerCount = 0;
    @Nullable
    public TruckType truckType = null;
    @Nullable
    public TunnelCategory tunnelCategory = null;
    @NonNull
    public VehicleType vehicleType;
    @Nullable
    public Integer weightPerAxleInKilograms = null;
    @Nullable
    public Integer widthInCentimeters = null;

    public VehicleProfile(@NonNull VehicleType vehicleType2) {
        this.vehicleType = vehicleType2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VehicleProfile)) {
            return false;
        }
        VehicleProfile vehicleProfile = (VehicleProfile) obj;
        return Objects.equals(this.vehicleType, vehicleProfile.vehicleType) && Objects.equals(this.plateNumberType, vehicleProfile.plateNumberType) && Objects.equals(this.fuelType, vehicleProfile.fuelType) && Objects.equals(this.equipment, vehicleProfile.equipment) && Objects.equals(this.truckType, vehicleProfile.truckType) && this.trailerCount == vehicleProfile.trailerCount && this.isTaxi == vehicleProfile.isTaxi && this.occupantsCount == vehicleProfile.occupantsCount && Objects.equals(this.emissionStandard, vehicleProfile.emissionStandard) && Objects.equals(this.hazardousMaterials, vehicleProfile.hazardousMaterials) && Objects.equals(this.tunnelCategory, vehicleProfile.tunnelCategory) && Objects.equals(this.axleCount, vehicleProfile.axleCount) && Objects.equals(this.grossWeightInKilograms, vehicleProfile.grossWeightInKilograms) && Objects.equals(this.heightInCentimeters, vehicleProfile.heightInCentimeters) && Objects.equals(this.lengthInCentimeters, vehicleProfile.lengthInCentimeters) && Objects.equals(this.widthInCentimeters, vehicleProfile.widthInCentimeters) && Objects.equals(this.weightPerAxleInKilograms, vehicleProfile.weightPerAxleInKilograms);
    }

    public int hashCode() {
        VehicleType vehicleType2 = this.vehicleType;
        int i = 0;
        int hashCode = (217 + (vehicleType2 != null ? vehicleType2.hashCode() : 0)) * 31;
        PlateNumberType plateNumberType2 = this.plateNumberType;
        int hashCode2 = (hashCode + (plateNumberType2 != null ? plateNumberType2.hashCode() : 0)) * 31;
        FuelType fuelType2 = this.fuelType;
        int hashCode3 = (hashCode2 + (fuelType2 != null ? fuelType2.hashCode() : 0)) * 31;
        VehicleEquipment vehicleEquipment = this.equipment;
        int hashCode4 = (hashCode3 + (vehicleEquipment != null ? vehicleEquipment.hashCode() : 0)) * 31;
        TruckType truckType2 = this.truckType;
        int hashCode5 = (((((((hashCode4 + (truckType2 != null ? truckType2.hashCode() : 0)) * 31) + this.trailerCount) * 31) + (this.isTaxi ? 79 : 97)) * 31) + this.occupantsCount) * 31;
        EmissionStandard emissionStandard2 = this.emissionStandard;
        int hashCode6 = (hashCode5 + (emissionStandard2 != null ? emissionStandard2.hashCode() : 0)) * 31;
        List<HazardousMaterial> list = this.hazardousMaterials;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 0)) * 31;
        TunnelCategory tunnelCategory2 = this.tunnelCategory;
        int hashCode8 = (hashCode7 + (tunnelCategory2 != null ? tunnelCategory2.hashCode() : 0)) * 31;
        Integer num = this.axleCount;
        int hashCode9 = (hashCode8 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.grossWeightInKilograms;
        int hashCode10 = (hashCode9 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.heightInCentimeters;
        int hashCode11 = (hashCode10 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.lengthInCentimeters;
        int hashCode12 = (hashCode11 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.widthInCentimeters;
        int hashCode13 = (hashCode12 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Integer num6 = this.weightPerAxleInKilograms;
        if (num6 != null) {
            i = num6.hashCode();
        }
        return hashCode13 + i;
    }
}
