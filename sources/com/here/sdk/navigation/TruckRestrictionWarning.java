package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.IntegerRange;
import com.here.sdk.core.TimeRule;
import com.here.sdk.transport.HazardousMaterial;
import com.here.sdk.transport.TruckRoadType;
import com.here.sdk.transport.TunnelCategory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class TruckRestrictionWarning {
    @Nullable
    public IntegerRange axleCount = null;
    @Nullable
    public DimensionRestriction dimensionRestriction;
    public double distanceInMeters;
    @NonNull
    public DistanceType distanceType;
    @NonNull
    public List<HazardousMaterial> hazardousMaterials = new ArrayList();
    @Nullable
    public TimeRule timeRule;
    @Nullable
    public IntegerRange trailerCount;
    @Nullable
    public TruckRoadType truckRoadType = null;
    @Nullable
    public TunnelCategory tunnelCategory = null;
    @NonNull
    public TruckRestrictionWarningType type;
    @Nullable
    public WeightRestriction weightRestriction;

    public TruckRestrictionWarning(double d, @Nullable WeightRestriction weightRestriction2, @Nullable DimensionRestriction dimensionRestriction2, @NonNull DistanceType distanceType2, @NonNull TruckRestrictionWarningType truckRestrictionWarningType, @Nullable IntegerRange integerRange, @Nullable TimeRule timeRule2) {
        this.distanceInMeters = d;
        this.weightRestriction = weightRestriction2;
        this.dimensionRestriction = dimensionRestriction2;
        this.distanceType = distanceType2;
        this.type = truckRestrictionWarningType;
        this.trailerCount = integerRange;
        this.timeRule = timeRule2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TruckRestrictionWarning)) {
            return false;
        }
        TruckRestrictionWarning truckRestrictionWarning = (TruckRestrictionWarning) obj;
        return Double.compare(this.distanceInMeters, truckRestrictionWarning.distanceInMeters) == 0 && Objects.equals(this.weightRestriction, truckRestrictionWarning.weightRestriction) && Objects.equals(this.dimensionRestriction, truckRestrictionWarning.dimensionRestriction) && Objects.equals(this.distanceType, truckRestrictionWarning.distanceType) && Objects.equals(this.type, truckRestrictionWarning.type) && Objects.equals(this.trailerCount, truckRestrictionWarning.trailerCount) && Objects.equals(this.timeRule, truckRestrictionWarning.timeRule) && Objects.equals(this.truckRoadType, truckRestrictionWarning.truckRoadType) && Objects.equals(this.hazardousMaterials, truckRestrictionWarning.hazardousMaterials) && Objects.equals(this.tunnelCategory, truckRestrictionWarning.tunnelCategory) && Objects.equals(this.axleCount, truckRestrictionWarning.axleCount);
    }

    public int hashCode() {
        int doubleToLongBits = (217 + ((int) (Double.doubleToLongBits(this.distanceInMeters) ^ (Double.doubleToLongBits(this.distanceInMeters) >>> 32)))) * 31;
        WeightRestriction weightRestriction2 = this.weightRestriction;
        int i = 0;
        int hashCode = (doubleToLongBits + (weightRestriction2 != null ? weightRestriction2.hashCode() : 0)) * 31;
        DimensionRestriction dimensionRestriction2 = this.dimensionRestriction;
        int hashCode2 = (hashCode + (dimensionRestriction2 != null ? dimensionRestriction2.hashCode() : 0)) * 31;
        DistanceType distanceType2 = this.distanceType;
        int hashCode3 = (hashCode2 + (distanceType2 != null ? distanceType2.hashCode() : 0)) * 31;
        TruckRestrictionWarningType truckRestrictionWarningType = this.type;
        int hashCode4 = (hashCode3 + (truckRestrictionWarningType != null ? truckRestrictionWarningType.hashCode() : 0)) * 31;
        IntegerRange integerRange = this.trailerCount;
        int hashCode5 = (hashCode4 + (integerRange != null ? integerRange.hashCode() : 0)) * 31;
        TimeRule timeRule2 = this.timeRule;
        int hashCode6 = (hashCode5 + (timeRule2 != null ? timeRule2.hashCode() : 0)) * 31;
        TruckRoadType truckRoadType2 = this.truckRoadType;
        int hashCode7 = (hashCode6 + (truckRoadType2 != null ? truckRoadType2.hashCode() : 0)) * 31;
        List<HazardousMaterial> list = this.hazardousMaterials;
        int hashCode8 = (hashCode7 + (list != null ? list.hashCode() : 0)) * 31;
        TunnelCategory tunnelCategory2 = this.tunnelCategory;
        int hashCode9 = (hashCode8 + (tunnelCategory2 != null ? tunnelCategory2.hashCode() : 0)) * 31;
        IntegerRange integerRange2 = this.axleCount;
        if (integerRange2 != null) {
            i = integerRange2.hashCode();
        }
        return hashCode9 + i;
    }
}
