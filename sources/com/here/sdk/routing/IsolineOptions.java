package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public final class IsolineOptions {
    @NonNull
    public Calculation calculationOptions;
    @Nullable
    public CarOptions carOptions;
    @Nullable
    public EVCarOptions evCarOptions;
    @Nullable
    public EVTruckOptions evTruckOptions;
    @Nullable
    public TruckOptions truckOptions;

    public IsolineOptions(@NonNull Calculation calculation, @NonNull CarOptions carOptions2) {
        IsolineOptions make = make(calculation, carOptions2);
        this.calculationOptions = make.calculationOptions;
        this.carOptions = make.carOptions;
        this.truckOptions = make.truckOptions;
        this.evCarOptions = make.evCarOptions;
        this.evTruckOptions = make.evTruckOptions;
    }

    private static native IsolineOptions make(@NonNull Calculation calculation, @NonNull CarOptions carOptions2);

    private static native IsolineOptions make(@NonNull Calculation calculation, @NonNull EVCarOptions eVCarOptions);

    private static native IsolineOptions make(@NonNull Calculation calculation, @NonNull EVTruckOptions eVTruckOptions);

    private static native IsolineOptions make(@NonNull Calculation calculation, @NonNull TruckOptions truckOptions2);

    public static final class Calculation {
        @NonNull
        public IsolineCalculationMode isolineCalculationMode;
        @NonNull
        public RoutePlaceDirection isolineDirection;
        @Nullable
        public Integer maxPoints;
        @NonNull
        public IsolineRangeType rangeType;
        @NonNull
        public List<Integer> rangeValues;

        public Calculation(@NonNull IsolineRangeType isolineRangeType, @NonNull List<Integer> list) {
            Calculation make = make(isolineRangeType, list);
            this.rangeType = make.rangeType;
            this.rangeValues = make.rangeValues;
            this.isolineCalculationMode = make.isolineCalculationMode;
            this.maxPoints = make.maxPoints;
            this.isolineDirection = make.isolineDirection;
        }

        private static native Calculation make(@NonNull IsolineRangeType isolineRangeType, @NonNull List<Integer> list);

        private static native Calculation make(@NonNull IsolineRangeType isolineRangeType, @NonNull List<Integer> list, @NonNull IsolineCalculationMode isolineCalculationMode2);

        private static native Calculation make(@NonNull IsolineRangeType isolineRangeType, @NonNull List<Integer> list, @NonNull IsolineCalculationMode isolineCalculationMode2, @Nullable Integer num, @NonNull RoutePlaceDirection routePlaceDirection);

        private static native Calculation make(@NonNull IsolineRangeType isolineRangeType, @NonNull List<Integer> list, @NonNull RoutePlaceDirection routePlaceDirection);

        public Calculation(@NonNull IsolineRangeType isolineRangeType, @NonNull List<Integer> list, @NonNull RoutePlaceDirection routePlaceDirection) {
            Calculation make = make(isolineRangeType, list, routePlaceDirection);
            this.rangeType = make.rangeType;
            this.rangeValues = make.rangeValues;
            this.isolineCalculationMode = make.isolineCalculationMode;
            this.maxPoints = make.maxPoints;
            this.isolineDirection = make.isolineDirection;
        }

        public Calculation(@NonNull IsolineRangeType isolineRangeType, @NonNull List<Integer> list, @NonNull IsolineCalculationMode isolineCalculationMode2) {
            Calculation make = make(isolineRangeType, list, isolineCalculationMode2);
            this.rangeType = make.rangeType;
            this.rangeValues = make.rangeValues;
            this.isolineCalculationMode = make.isolineCalculationMode;
            this.maxPoints = make.maxPoints;
            this.isolineDirection = make.isolineDirection;
        }

        public Calculation(@NonNull IsolineRangeType isolineRangeType, @NonNull List<Integer> list, @NonNull IsolineCalculationMode isolineCalculationMode2, @Nullable Integer num, @NonNull RoutePlaceDirection routePlaceDirection) {
            Calculation make = make(isolineRangeType, list, isolineCalculationMode2, num, routePlaceDirection);
            this.rangeType = make.rangeType;
            this.rangeValues = make.rangeValues;
            this.isolineCalculationMode = make.isolineCalculationMode;
            this.maxPoints = make.maxPoints;
            this.isolineDirection = make.isolineDirection;
        }
    }

    public IsolineOptions(@NonNull Calculation calculation, @NonNull TruckOptions truckOptions2) {
        IsolineOptions make = make(calculation, truckOptions2);
        this.calculationOptions = make.calculationOptions;
        this.carOptions = make.carOptions;
        this.truckOptions = make.truckOptions;
        this.evCarOptions = make.evCarOptions;
        this.evTruckOptions = make.evTruckOptions;
    }

    public IsolineOptions(@NonNull Calculation calculation, @NonNull EVCarOptions eVCarOptions) {
        IsolineOptions make = make(calculation, eVCarOptions);
        this.calculationOptions = make.calculationOptions;
        this.carOptions = make.carOptions;
        this.truckOptions = make.truckOptions;
        this.evCarOptions = make.evCarOptions;
        this.evTruckOptions = make.evTruckOptions;
    }

    public IsolineOptions(@NonNull Calculation calculation, @NonNull EVTruckOptions eVTruckOptions) {
        IsolineOptions make = make(calculation, eVTruckOptions);
        this.calculationOptions = make.calculationOptions;
        this.carOptions = make.carOptions;
        this.truckOptions = make.truckOptions;
        this.evCarOptions = make.evCarOptions;
        this.evTruckOptions = make.evTruckOptions;
    }
}
