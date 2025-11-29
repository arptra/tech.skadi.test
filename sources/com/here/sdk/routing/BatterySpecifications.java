package com.here.sdk.routing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class BatterySpecifications {
    @NonNull
    public Map<Double, Double> chargingCurve;
    @NonNull
    public Duration chargingSetupDuration;
    @NonNull
    public List<ChargingConnectorType> connectorTypes;
    public double initialChargeInKilowattHours;
    @Nullable
    public Double maxChargingCurrentInAmperes;
    @Nullable
    public Double maxChargingVoltageInVolts;
    public double minChargeAtChargingStationInKilowattHours;
    public double minChargeAtDestinationInKilowattHours;
    @Nullable
    public Double minChargeAtFirstChargingStationInKilowattHours;
    public double targetChargeInKilowattHours;
    public double totalCapacityInKilowattHours;

    public BatterySpecifications() {
        this.totalCapacityInKilowattHours = 0.0d;
        this.initialChargeInKilowattHours = 0.0d;
        this.targetChargeInKilowattHours = 0.0d;
        this.chargingCurve = new HashMap();
        this.connectorTypes = new ArrayList();
        this.minChargeAtChargingStationInKilowattHours = 0.0d;
        this.minChargeAtFirstChargingStationInKilowattHours = null;
        this.minChargeAtDestinationInKilowattHours = 0.0d;
        this.maxChargingVoltageInVolts = null;
        this.maxChargingCurrentInAmperes = null;
        this.chargingSetupDuration = Duration.ofSeconds(0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatterySpecifications)) {
            return false;
        }
        BatterySpecifications batterySpecifications = (BatterySpecifications) obj;
        return Double.compare(this.totalCapacityInKilowattHours, batterySpecifications.totalCapacityInKilowattHours) == 0 && Double.compare(this.initialChargeInKilowattHours, batterySpecifications.initialChargeInKilowattHours) == 0 && Double.compare(this.targetChargeInKilowattHours, batterySpecifications.targetChargeInKilowattHours) == 0 && Objects.equals(this.chargingCurve, batterySpecifications.chargingCurve) && Objects.equals(this.connectorTypes, batterySpecifications.connectorTypes) && Double.compare(this.minChargeAtChargingStationInKilowattHours, batterySpecifications.minChargeAtChargingStationInKilowattHours) == 0 && Objects.equals(this.minChargeAtFirstChargingStationInKilowattHours, batterySpecifications.minChargeAtFirstChargingStationInKilowattHours) && Double.compare(this.minChargeAtDestinationInKilowattHours, batterySpecifications.minChargeAtDestinationInKilowattHours) == 0 && Objects.equals(this.maxChargingVoltageInVolts, batterySpecifications.maxChargingVoltageInVolts) && Objects.equals(this.maxChargingCurrentInAmperes, batterySpecifications.maxChargingCurrentInAmperes) && Objects.equals(this.chargingSetupDuration, batterySpecifications.chargingSetupDuration);
    }

    public int hashCode() {
        int doubleToLongBits = (((((217 + ((int) (Double.doubleToLongBits(this.totalCapacityInKilowattHours) ^ (Double.doubleToLongBits(this.totalCapacityInKilowattHours) >>> 32)))) * 31) + ((int) (Double.doubleToLongBits(this.initialChargeInKilowattHours) ^ (Double.doubleToLongBits(this.initialChargeInKilowattHours) >>> 32)))) * 31) + ((int) (Double.doubleToLongBits(this.targetChargeInKilowattHours) ^ (Double.doubleToLongBits(this.targetChargeInKilowattHours) >>> 32)))) * 31;
        Map<Double, Double> map = this.chargingCurve;
        int i = 0;
        int hashCode = (doubleToLongBits + (map != null ? map.hashCode() : 0)) * 31;
        List<ChargingConnectorType> list = this.connectorTypes;
        int hashCode2 = (((hashCode + (list != null ? list.hashCode() : 0)) * 31) + ((int) (Double.doubleToLongBits(this.minChargeAtChargingStationInKilowattHours) ^ (Double.doubleToLongBits(this.minChargeAtChargingStationInKilowattHours) >>> 32)))) * 31;
        Double d = this.minChargeAtFirstChargingStationInKilowattHours;
        int hashCode3 = (((hashCode2 + (d != null ? d.hashCode() : 0)) * 31) + ((int) ((Double.doubleToLongBits(this.minChargeAtDestinationInKilowattHours) >>> 32) ^ Double.doubleToLongBits(this.minChargeAtDestinationInKilowattHours)))) * 31;
        Double d2 = this.maxChargingVoltageInVolts;
        int hashCode4 = (hashCode3 + (d2 != null ? d2.hashCode() : 0)) * 31;
        Double d3 = this.maxChargingCurrentInAmperes;
        int hashCode5 = (hashCode4 + (d3 != null ? d3.hashCode() : 0)) * 31;
        Duration duration = this.chargingSetupDuration;
        if (duration != null) {
            i = duration.hashCode();
        }
        return hashCode5 + i;
    }

    public BatterySpecifications(double d) {
        this.totalCapacityInKilowattHours = d;
        this.initialChargeInKilowattHours = 0.0d;
        this.targetChargeInKilowattHours = 0.0d;
        this.chargingCurve = new HashMap();
        this.connectorTypes = new ArrayList();
        this.minChargeAtChargingStationInKilowattHours = 0.0d;
        this.minChargeAtFirstChargingStationInKilowattHours = null;
        this.minChargeAtDestinationInKilowattHours = 0.0d;
        this.maxChargingVoltageInVolts = null;
        this.maxChargingCurrentInAmperes = null;
        this.chargingSetupDuration = Duration.ofSeconds(0);
    }

    public BatterySpecifications(double d, double d2) {
        this.totalCapacityInKilowattHours = d;
        this.initialChargeInKilowattHours = d2;
        this.targetChargeInKilowattHours = 0.0d;
        this.chargingCurve = new HashMap();
        this.connectorTypes = new ArrayList();
        this.minChargeAtChargingStationInKilowattHours = 0.0d;
        this.minChargeAtFirstChargingStationInKilowattHours = null;
        this.minChargeAtDestinationInKilowattHours = 0.0d;
        this.maxChargingVoltageInVolts = null;
        this.maxChargingCurrentInAmperes = null;
        this.chargingSetupDuration = Duration.ofSeconds(0);
    }

    public BatterySpecifications(double d, double d2, double d3) {
        this.totalCapacityInKilowattHours = d;
        this.initialChargeInKilowattHours = d2;
        this.targetChargeInKilowattHours = d3;
        this.chargingCurve = new HashMap();
        this.connectorTypes = new ArrayList();
        this.minChargeAtChargingStationInKilowattHours = 0.0d;
        this.minChargeAtFirstChargingStationInKilowattHours = null;
        this.minChargeAtDestinationInKilowattHours = 0.0d;
        this.maxChargingVoltageInVolts = null;
        this.maxChargingCurrentInAmperes = null;
        this.chargingSetupDuration = Duration.ofSeconds(0);
    }

    public BatterySpecifications(double d, double d2, double d3, @NonNull Map<Double, Double> map) {
        this.totalCapacityInKilowattHours = d;
        this.initialChargeInKilowattHours = d2;
        this.targetChargeInKilowattHours = d3;
        this.chargingCurve = map;
        this.connectorTypes = new ArrayList();
        this.minChargeAtChargingStationInKilowattHours = 0.0d;
        this.minChargeAtFirstChargingStationInKilowattHours = null;
        this.minChargeAtDestinationInKilowattHours = 0.0d;
        this.maxChargingVoltageInVolts = null;
        this.maxChargingCurrentInAmperes = null;
        this.chargingSetupDuration = Duration.ofSeconds(0);
    }

    public BatterySpecifications(double d, double d2, double d3, @NonNull Map<Double, Double> map, @NonNull List<ChargingConnectorType> list) {
        this.totalCapacityInKilowattHours = d;
        this.initialChargeInKilowattHours = d2;
        this.targetChargeInKilowattHours = d3;
        this.chargingCurve = map;
        this.connectorTypes = list;
        this.minChargeAtChargingStationInKilowattHours = 0.0d;
        this.minChargeAtFirstChargingStationInKilowattHours = null;
        this.minChargeAtDestinationInKilowattHours = 0.0d;
        this.maxChargingVoltageInVolts = null;
        this.maxChargingCurrentInAmperes = null;
        this.chargingSetupDuration = Duration.ofSeconds(0);
    }

    public BatterySpecifications(double d, double d2, double d3, @NonNull Map<Double, Double> map, @NonNull List<ChargingConnectorType> list, double d4) {
        this.totalCapacityInKilowattHours = d;
        this.initialChargeInKilowattHours = d2;
        this.targetChargeInKilowattHours = d3;
        this.chargingCurve = map;
        this.connectorTypes = list;
        this.minChargeAtChargingStationInKilowattHours = d4;
        this.minChargeAtFirstChargingStationInKilowattHours = null;
        this.minChargeAtDestinationInKilowattHours = 0.0d;
        this.maxChargingVoltageInVolts = null;
        this.maxChargingCurrentInAmperes = null;
        this.chargingSetupDuration = Duration.ofSeconds(0);
    }

    public BatterySpecifications(double d, double d2, double d3, @NonNull Map<Double, Double> map, @NonNull List<ChargingConnectorType> list, double d4, @Nullable Double d5) {
        this.totalCapacityInKilowattHours = d;
        this.initialChargeInKilowattHours = d2;
        this.targetChargeInKilowattHours = d3;
        this.chargingCurve = map;
        this.connectorTypes = list;
        this.minChargeAtChargingStationInKilowattHours = d4;
        this.minChargeAtFirstChargingStationInKilowattHours = d5;
        this.minChargeAtDestinationInKilowattHours = 0.0d;
        this.maxChargingVoltageInVolts = null;
        this.maxChargingCurrentInAmperes = null;
        this.chargingSetupDuration = Duration.ofSeconds(0);
    }

    public BatterySpecifications(double d, double d2, double d3, @NonNull Map<Double, Double> map, @NonNull List<ChargingConnectorType> list, double d4, @Nullable Double d5, double d6) {
        this.totalCapacityInKilowattHours = d;
        this.initialChargeInKilowattHours = d2;
        this.targetChargeInKilowattHours = d3;
        this.chargingCurve = map;
        this.connectorTypes = list;
        this.minChargeAtChargingStationInKilowattHours = d4;
        this.minChargeAtFirstChargingStationInKilowattHours = d5;
        this.minChargeAtDestinationInKilowattHours = d6;
        this.maxChargingVoltageInVolts = null;
        this.maxChargingCurrentInAmperes = null;
        this.chargingSetupDuration = Duration.ofSeconds(0);
    }

    public BatterySpecifications(double d, double d2, double d3, @NonNull Map<Double, Double> map, @NonNull List<ChargingConnectorType> list, double d4, @Nullable Double d5, double d6, @Nullable Double d7) {
        this.totalCapacityInKilowattHours = d;
        this.initialChargeInKilowattHours = d2;
        this.targetChargeInKilowattHours = d3;
        this.chargingCurve = map;
        this.connectorTypes = list;
        this.minChargeAtChargingStationInKilowattHours = d4;
        this.minChargeAtFirstChargingStationInKilowattHours = d5;
        this.minChargeAtDestinationInKilowattHours = d6;
        this.maxChargingVoltageInVolts = d7;
        this.maxChargingCurrentInAmperes = null;
        this.chargingSetupDuration = Duration.ofSeconds(0);
    }

    public BatterySpecifications(double d, double d2, double d3, @NonNull Map<Double, Double> map, @NonNull List<ChargingConnectorType> list, double d4, @Nullable Double d5, double d6, @Nullable Double d7, @Nullable Double d8) {
        this.totalCapacityInKilowattHours = d;
        this.initialChargeInKilowattHours = d2;
        this.targetChargeInKilowattHours = d3;
        this.chargingCurve = map;
        this.connectorTypes = list;
        this.minChargeAtChargingStationInKilowattHours = d4;
        this.minChargeAtFirstChargingStationInKilowattHours = d5;
        this.minChargeAtDestinationInKilowattHours = d6;
        this.maxChargingVoltageInVolts = d7;
        this.maxChargingCurrentInAmperes = d8;
        this.chargingSetupDuration = Duration.ofSeconds(0);
    }

    public BatterySpecifications(double d, double d2, double d3, @NonNull Map<Double, Double> map, @NonNull List<ChargingConnectorType> list, double d4, @Nullable Double d5, double d6, @Nullable Double d7, @Nullable Double d8, @NonNull Duration duration) {
        this.totalCapacityInKilowattHours = d;
        this.initialChargeInKilowattHours = d2;
        this.targetChargeInKilowattHours = d3;
        this.chargingCurve = map;
        this.connectorTypes = list;
        this.minChargeAtChargingStationInKilowattHours = d4;
        this.minChargeAtFirstChargingStationInKilowattHours = d5;
        this.minChargeAtDestinationInKilowattHours = d6;
        this.maxChargingVoltageInVolts = d7;
        this.maxChargingCurrentInAmperes = d8;
        this.chargingSetupDuration = duration;
    }
}
