package com.here.sdk.traffic;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.LocalizedText;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class TrafficIncident extends NativeBase implements TrafficIncidentBase {

    public enum RestrictedVehicleCategory {
        BUS(0),
        CAR(1),
        HEAVY_GOODS_VEHICLE(2),
        TRUCK(3),
        MOTORCYCLE(4),
        MOTOR_VEHICLE(5),
        TAXI(6),
        TRAIN(7),
        TRANSPORTING_ABNORMAL_SIZE_LOAD(8),
        TRANSPORTING_HAZARDOUS_GOODS(9),
        VEHICLE_WITH_TRAILER(10),
        OTHER(11),
        ALL(12);
        
        public final int value;

        private RestrictedVehicleCategory(int i) {
            this.value = i;
        }
    }

    public static final class VehicleRestriction {
        public boolean isCaravanRestricted = false;
        public boolean isDestinationInIncidentAreaRestricted = false;
        public boolean isDieselFuelRestricted = false;
        public boolean isDrivingWithoutSnowChainsRestricted = false;
        public boolean isDrivingWithoutWinterTyresRestricted = false;
        public boolean isEuro3EmissionStandardRestricted = false;
        public boolean isEuro4EmissionStandardRestricted = false;
        public boolean isEuro5EmissionStandardRestricted = false;
        public boolean isEvenNumberPlateRestricted = false;
        public boolean isLpgFuelRestricted = false;
        public boolean isOddNumberPlateRestricted = false;
        public boolean isPetrolFuelRestricted = false;
        public boolean isResidentsTrafficRestricted = false;
        public boolean isRestrictedAlways = false;
        public boolean isThroughTrafficRestricted = false;
        public boolean isTrailerRestricted = false;
        @Nullable
        public Integer restrictedIfAxleWeightLessThanInKilograms = null;
        @Nullable
        public Integer restrictedIfAxleWeightMoreThanInKilograms = null;
        @Nullable
        public Integer restrictedIfGrossWeightLessThanInKilograms = null;
        @Nullable
        public Integer restrictedIfGrossWeightMoreThanInKilograms = null;
        @Nullable
        public Integer restrictedIfHigherThanInCentimeters = null;
        @Nullable
        public Integer restrictedIfLongerThanInCentimeters = null;
        @Nullable
        public Integer restrictedIfLowerThanInCentimeters = null;
        @Nullable
        public Integer restrictedIfNarrowerThanInCentimeters = null;
        @Nullable
        public Integer restrictedIfOccupantsFewerThan = null;
        @Nullable
        public Integer restrictedIfOccupantsMoreThan = null;
        @Nullable
        public Integer restrictedIfShorterThanInCentimeters = null;
        @Nullable
        public Integer restrictedIfWiderThanInCentimeters = null;

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof VehicleRestriction)) {
                return false;
            }
            VehicleRestriction vehicleRestriction = (VehicleRestriction) obj;
            return this.isRestrictedAlways == vehicleRestriction.isRestrictedAlways && this.isDieselFuelRestricted == vehicleRestriction.isDieselFuelRestricted && this.isPetrolFuelRestricted == vehicleRestriction.isPetrolFuelRestricted && this.isLpgFuelRestricted == vehicleRestriction.isLpgFuelRestricted && this.isCaravanRestricted == vehicleRestriction.isCaravanRestricted && this.isTrailerRestricted == vehicleRestriction.isTrailerRestricted && this.isDrivingWithoutSnowChainsRestricted == vehicleRestriction.isDrivingWithoutSnowChainsRestricted && this.isDrivingWithoutWinterTyresRestricted == vehicleRestriction.isDrivingWithoutWinterTyresRestricted && this.isEvenNumberPlateRestricted == vehicleRestriction.isEvenNumberPlateRestricted && this.isOddNumberPlateRestricted == vehicleRestriction.isOddNumberPlateRestricted && this.isThroughTrafficRestricted == vehicleRestriction.isThroughTrafficRestricted && this.isResidentsTrafficRestricted == vehicleRestriction.isResidentsTrafficRestricted && this.isDestinationInIncidentAreaRestricted == vehicleRestriction.isDestinationInIncidentAreaRestricted && this.isEuro3EmissionStandardRestricted == vehicleRestriction.isEuro3EmissionStandardRestricted && this.isEuro4EmissionStandardRestricted == vehicleRestriction.isEuro4EmissionStandardRestricted && this.isEuro5EmissionStandardRestricted == vehicleRestriction.isEuro5EmissionStandardRestricted && Objects.equals(this.restrictedIfGrossWeightMoreThanInKilograms, vehicleRestriction.restrictedIfGrossWeightMoreThanInKilograms) && Objects.equals(this.restrictedIfGrossWeightLessThanInKilograms, vehicleRestriction.restrictedIfGrossWeightLessThanInKilograms) && Objects.equals(this.restrictedIfAxleWeightMoreThanInKilograms, vehicleRestriction.restrictedIfAxleWeightMoreThanInKilograms) && Objects.equals(this.restrictedIfAxleWeightLessThanInKilograms, vehicleRestriction.restrictedIfAxleWeightLessThanInKilograms) && Objects.equals(this.restrictedIfLongerThanInCentimeters, vehicleRestriction.restrictedIfLongerThanInCentimeters) && Objects.equals(this.restrictedIfShorterThanInCentimeters, vehicleRestriction.restrictedIfShorterThanInCentimeters) && Objects.equals(this.restrictedIfHigherThanInCentimeters, vehicleRestriction.restrictedIfHigherThanInCentimeters) && Objects.equals(this.restrictedIfLowerThanInCentimeters, vehicleRestriction.restrictedIfLowerThanInCentimeters) && Objects.equals(this.restrictedIfWiderThanInCentimeters, vehicleRestriction.restrictedIfWiderThanInCentimeters) && Objects.equals(this.restrictedIfNarrowerThanInCentimeters, vehicleRestriction.restrictedIfNarrowerThanInCentimeters) && Objects.equals(this.restrictedIfOccupantsMoreThan, vehicleRestriction.restrictedIfOccupantsMoreThan) && Objects.equals(this.restrictedIfOccupantsFewerThan, vehicleRestriction.restrictedIfOccupantsFewerThan);
        }

        public int hashCode() {
            int i = 97;
            int i2 = (((((((((((((((((((((((((((((217 + (this.isRestrictedAlways ? 79 : 97)) * 31) + (this.isDieselFuelRestricted ? 79 : 97)) * 31) + (this.isPetrolFuelRestricted ? 79 : 97)) * 31) + (this.isLpgFuelRestricted ? 79 : 97)) * 31) + (this.isCaravanRestricted ? 79 : 97)) * 31) + (this.isTrailerRestricted ? 79 : 97)) * 31) + (this.isDrivingWithoutSnowChainsRestricted ? 79 : 97)) * 31) + (this.isDrivingWithoutWinterTyresRestricted ? 79 : 97)) * 31) + (this.isEvenNumberPlateRestricted ? 79 : 97)) * 31) + (this.isOddNumberPlateRestricted ? 79 : 97)) * 31) + (this.isThroughTrafficRestricted ? 79 : 97)) * 31) + (this.isResidentsTrafficRestricted ? 79 : 97)) * 31) + (this.isDestinationInIncidentAreaRestricted ? 79 : 97)) * 31) + (this.isEuro3EmissionStandardRestricted ? 79 : 97)) * 31) + (this.isEuro4EmissionStandardRestricted ? 79 : 97)) * 31;
            if (this.isEuro5EmissionStandardRestricted) {
                i = 79;
            }
            int i3 = (i2 + i) * 31;
            Integer num = this.restrictedIfGrossWeightMoreThanInKilograms;
            int i4 = 0;
            int hashCode = (i3 + (num != null ? num.hashCode() : 0)) * 31;
            Integer num2 = this.restrictedIfGrossWeightLessThanInKilograms;
            int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
            Integer num3 = this.restrictedIfAxleWeightMoreThanInKilograms;
            int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
            Integer num4 = this.restrictedIfAxleWeightLessThanInKilograms;
            int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
            Integer num5 = this.restrictedIfLongerThanInCentimeters;
            int hashCode5 = (hashCode4 + (num5 != null ? num5.hashCode() : 0)) * 31;
            Integer num6 = this.restrictedIfShorterThanInCentimeters;
            int hashCode6 = (hashCode5 + (num6 != null ? num6.hashCode() : 0)) * 31;
            Integer num7 = this.restrictedIfHigherThanInCentimeters;
            int hashCode7 = (hashCode6 + (num7 != null ? num7.hashCode() : 0)) * 31;
            Integer num8 = this.restrictedIfLowerThanInCentimeters;
            int hashCode8 = (hashCode7 + (num8 != null ? num8.hashCode() : 0)) * 31;
            Integer num9 = this.restrictedIfWiderThanInCentimeters;
            int hashCode9 = (hashCode8 + (num9 != null ? num9.hashCode() : 0)) * 31;
            Integer num10 = this.restrictedIfNarrowerThanInCentimeters;
            int hashCode10 = (hashCode9 + (num10 != null ? num10.hashCode() : 0)) * 31;
            Integer num11 = this.restrictedIfOccupantsMoreThan;
            int hashCode11 = (hashCode10 + (num11 != null ? num11.hashCode() : 0)) * 31;
            Integer num12 = this.restrictedIfOccupantsFewerThan;
            if (num12 != null) {
                i4 = num12.hashCode();
            }
            return hashCode11 + i4;
        }
    }

    public TrafficIncident(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                TrafficIncident.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native List<Integer> getCodes();

    @NonNull
    public native LocalizedText getDescription();

    @Nullable
    public native Date getEndTime();

    @Nullable
    public native Date getEntryTime();

    @NonNull
    public native String getId();

    @NonNull
    public native TrafficIncidentImpact getImpact();

    @NonNull
    public native JunctionsTraversability getJunctionsTraversability();

    @NonNull
    public native TrafficLocation getLocation();

    @NonNull
    public native String getOriginalId();

    @Nullable
    public native String getParentId();

    @Nullable
    public native Date getStartTime();

    @NonNull
    public native LocalizedText getSummary();

    @NonNull
    public native TrafficIncidentType getType();

    @NonNull
    public native Map<RestrictedVehicleCategory, VehicleRestriction> getVehicleRestrictions();

    public native boolean isRoadClosed();
}
