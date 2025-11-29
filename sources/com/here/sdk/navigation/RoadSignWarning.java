package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.LocalizedText;
import java.util.List;
import java.util.Objects;

public final class RoadSignWarning {
    @NonNull
    public RoadSignCategory category;
    public double distanceToRoadSignInMeters;
    @NonNull
    public DistanceType distanceType;
    @Nullable
    public LocalizedText duration = null;
    @NonNull
    public GeneralWarningRoadSignType generalWarningType;
    public boolean isPrioritySign;
    @Nullable
    public LocalizedText preWarning = null;
    @Nullable
    public LocalizedText signValue = null;
    @NonNull
    public RoadSignType type;
    @Nullable
    public LocalizedText validityTime = null;
    @NonNull
    public List<RoadSignVehicleType> vehicleTypes;
    @NonNull
    public WeatherType weatherType;

    public RoadSignWarning(double d, @NonNull RoadSignType roadSignType, @NonNull RoadSignCategory roadSignCategory, @NonNull GeneralWarningRoadSignType generalWarningRoadSignType, boolean z, @NonNull List<RoadSignVehicleType> list, @NonNull WeatherType weatherType2, @NonNull DistanceType distanceType2) {
        this.distanceToRoadSignInMeters = d;
        this.type = roadSignType;
        this.category = roadSignCategory;
        this.generalWarningType = generalWarningRoadSignType;
        this.isPrioritySign = z;
        this.vehicleTypes = list;
        this.weatherType = weatherType2;
        this.distanceType = distanceType2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RoadSignWarning)) {
            return false;
        }
        RoadSignWarning roadSignWarning = (RoadSignWarning) obj;
        return Double.compare(this.distanceToRoadSignInMeters, roadSignWarning.distanceToRoadSignInMeters) == 0 && Objects.equals(this.type, roadSignWarning.type) && Objects.equals(this.category, roadSignWarning.category) && Objects.equals(this.generalWarningType, roadSignWarning.generalWarningType) && this.isPrioritySign == roadSignWarning.isPrioritySign && Objects.equals(this.vehicleTypes, roadSignWarning.vehicleTypes) && Objects.equals(this.weatherType, roadSignWarning.weatherType) && Objects.equals(this.signValue, roadSignWarning.signValue) && Objects.equals(this.preWarning, roadSignWarning.preWarning) && Objects.equals(this.duration, roadSignWarning.duration) && Objects.equals(this.validityTime, roadSignWarning.validityTime) && Objects.equals(this.distanceType, roadSignWarning.distanceType);
    }

    public int hashCode() {
        int doubleToLongBits = (217 + ((int) (Double.doubleToLongBits(this.distanceToRoadSignInMeters) ^ (Double.doubleToLongBits(this.distanceToRoadSignInMeters) >>> 32)))) * 31;
        RoadSignType roadSignType = this.type;
        int i = 0;
        int hashCode = (doubleToLongBits + (roadSignType != null ? roadSignType.hashCode() : 0)) * 31;
        RoadSignCategory roadSignCategory = this.category;
        int hashCode2 = (hashCode + (roadSignCategory != null ? roadSignCategory.hashCode() : 0)) * 31;
        GeneralWarningRoadSignType generalWarningRoadSignType = this.generalWarningType;
        int hashCode3 = (((hashCode2 + (generalWarningRoadSignType != null ? generalWarningRoadSignType.hashCode() : 0)) * 31) + (this.isPrioritySign ? 79 : 97)) * 31;
        List<RoadSignVehicleType> list = this.vehicleTypes;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        WeatherType weatherType2 = this.weatherType;
        int hashCode5 = (hashCode4 + (weatherType2 != null ? weatherType2.hashCode() : 0)) * 31;
        LocalizedText localizedText = this.signValue;
        int hashCode6 = (hashCode5 + (localizedText != null ? localizedText.hashCode() : 0)) * 31;
        LocalizedText localizedText2 = this.preWarning;
        int hashCode7 = (hashCode6 + (localizedText2 != null ? localizedText2.hashCode() : 0)) * 31;
        LocalizedText localizedText3 = this.duration;
        int hashCode8 = (hashCode7 + (localizedText3 != null ? localizedText3.hashCode() : 0)) * 31;
        LocalizedText localizedText4 = this.validityTime;
        int hashCode9 = (hashCode8 + (localizedText4 != null ? localizedText4.hashCode() : 0)) * 31;
        DistanceType distanceType2 = this.distanceType;
        if (distanceType2 != null) {
            i = distanceType2.hashCode();
        }
        return hashCode9 + i;
    }
}
