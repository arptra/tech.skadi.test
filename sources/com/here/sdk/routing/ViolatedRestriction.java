package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.IntegerRange;
import com.here.sdk.transport.HazardousMaterial;
import com.here.sdk.transport.TruckRoadType;
import com.here.sdk.transport.TruckType;
import com.here.sdk.transport.TunnelCategory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class ViolatedRestriction {
    @NonNull
    public String cause;
    @Nullable
    public Details details = null;
    public boolean timeDependent;

    public static final class Details {
        @Nullable
        public IntegerRange forbiddenAxleCount = null;
        @NonNull
        public List<HazardousMaterial> forbiddenHazardousGoods = new ArrayList();
        @Nullable
        public IntegerRange forbiddenTrailerCount = null;
        @NonNull
        public List<TruckRoadType> forbiddenTruckRoadTypes = new ArrayList();
        @Nullable
        public TruckType forbiddenTruckType = null;
        @Nullable
        public Integer maxGrossWeightInKilograms = null;
        @Nullable
        public Integer maxHeightInCentimeters = null;
        @Nullable
        public Integer maxLengthInCentimeters = null;
        @Nullable
        public Integer maxPayloadCapacityInKilograms = null;
        @Nullable
        public TunnelCategory maxTunnelCategory = null;
        @Nullable
        public MaxAxleGroupWeight maxWeightPerAxleGroupInKilograms = null;
        @Nullable
        public Integer maxWeightPerAxleInKilograms = null;
        @Nullable
        public Integer maxWidthInCentimeters = null;
        @Nullable
        public String routingZoneReference = null;

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Details)) {
                return false;
            }
            Details details = (Details) obj;
            return Objects.equals(this.maxGrossWeightInKilograms, details.maxGrossWeightInKilograms) && Objects.equals(this.maxWeightPerAxleInKilograms, details.maxWeightPerAxleInKilograms) && Objects.equals(this.maxWeightPerAxleGroupInKilograms, details.maxWeightPerAxleGroupInKilograms) && Objects.equals(this.maxHeightInCentimeters, details.maxHeightInCentimeters) && Objects.equals(this.maxWidthInCentimeters, details.maxWidthInCentimeters) && Objects.equals(this.maxLengthInCentimeters, details.maxLengthInCentimeters) && Objects.equals(this.forbiddenAxleCount, details.forbiddenAxleCount) && Objects.equals(this.forbiddenTrailerCount, details.forbiddenTrailerCount) && Objects.equals(this.forbiddenHazardousGoods, details.forbiddenHazardousGoods) && Objects.equals(this.maxTunnelCategory, details.maxTunnelCategory) && Objects.equals(this.forbiddenTruckType, details.forbiddenTruckType) && Objects.equals(this.forbiddenTruckRoadTypes, details.forbiddenTruckRoadTypes) && Objects.equals(this.routingZoneReference, details.routingZoneReference) && Objects.equals(this.maxPayloadCapacityInKilograms, details.maxPayloadCapacityInKilograms);
        }

        public int hashCode() {
            Integer num = this.maxGrossWeightInKilograms;
            int i = 0;
            int hashCode = (217 + (num != null ? num.hashCode() : 0)) * 31;
            Integer num2 = this.maxWeightPerAxleInKilograms;
            int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
            MaxAxleGroupWeight maxAxleGroupWeight = this.maxWeightPerAxleGroupInKilograms;
            int hashCode3 = (hashCode2 + (maxAxleGroupWeight != null ? maxAxleGroupWeight.hashCode() : 0)) * 31;
            Integer num3 = this.maxHeightInCentimeters;
            int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 31;
            Integer num4 = this.maxWidthInCentimeters;
            int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 31;
            Integer num5 = this.maxLengthInCentimeters;
            int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 31;
            IntegerRange integerRange = this.forbiddenAxleCount;
            int hashCode7 = (hashCode6 + (integerRange != null ? integerRange.hashCode() : 0)) * 31;
            IntegerRange integerRange2 = this.forbiddenTrailerCount;
            int hashCode8 = (hashCode7 + (integerRange2 != null ? integerRange2.hashCode() : 0)) * 31;
            List<HazardousMaterial> list = this.forbiddenHazardousGoods;
            int hashCode9 = (hashCode8 + (list != null ? list.hashCode() : 0)) * 31;
            TunnelCategory tunnelCategory = this.maxTunnelCategory;
            int hashCode10 = (hashCode9 + (tunnelCategory != null ? tunnelCategory.hashCode() : 0)) * 31;
            TruckType truckType = this.forbiddenTruckType;
            int hashCode11 = (hashCode10 + (truckType != null ? truckType.hashCode() : 0)) * 31;
            List<TruckRoadType> list2 = this.forbiddenTruckRoadTypes;
            int hashCode12 = (hashCode11 + (list2 != null ? list2.hashCode() : 0)) * 31;
            String str = this.routingZoneReference;
            int hashCode13 = (hashCode12 + (str != null ? str.hashCode() : 0)) * 31;
            Integer num6 = this.maxPayloadCapacityInKilograms;
            if (num6 != null) {
                i = num6.hashCode();
            }
            return hashCode13 + i;
        }
    }

    public ViolatedRestriction(@NonNull String str, boolean z) {
        this.cause = str;
        this.timeDependent = z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ViolatedRestriction)) {
            return false;
        }
        ViolatedRestriction violatedRestriction = (ViolatedRestriction) obj;
        return Objects.equals(this.cause, violatedRestriction.cause) && this.timeDependent == violatedRestriction.timeDependent && Objects.equals(this.details, violatedRestriction.details);
    }

    public int hashCode() {
        String str = this.cause;
        int i = 0;
        int hashCode = (((217 + (str != null ? str.hashCode() : 0)) * 31) + (this.timeDependent ? 79 : 97)) * 31;
        Details details2 = this.details;
        if (details2 != null) {
            i = details2.hashCode();
        }
        return hashCode + i;
    }
}
