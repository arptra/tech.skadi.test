package com.here.sdk.search;

import androidx.annotation.Nullable;
import java.util.Objects;

public final class EVChargingStation {
    @Nullable
    public Integer availableConnectorCount;
    @Nullable
    public String chargingMode;
    @Nullable
    public Integer connectorCount;
    @Nullable
    public String connectorTypeId;
    @Nullable
    public String connectorTypeName;
    @Nullable
    public String currentRangeInAmperes;
    @Nullable
    public Boolean hasFixedCable = null;
    @Nullable
    public Double maxPowerInKilowatts;
    @Nullable
    public Integer phaseCount;
    @Nullable
    public String powerFeedTypeId;
    @Nullable
    public String powerFeedTypeName;
    @Nullable
    public String supplierName;
    @Nullable
    public String voltageRangeInVolts;

    public EVChargingStation(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Double d, @Nullable Integer num, @Nullable Integer num2, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable Integer num3) {
        this.supplierName = str;
        this.connectorTypeName = str2;
        this.connectorTypeId = str3;
        this.powerFeedTypeName = str4;
        this.powerFeedTypeId = str5;
        this.maxPowerInKilowatts = d;
        this.connectorCount = num;
        this.availableConnectorCount = num2;
        this.chargingMode = str6;
        this.voltageRangeInVolts = str7;
        this.currentRangeInAmperes = str8;
        this.phaseCount = num3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EVChargingStation)) {
            return false;
        }
        EVChargingStation eVChargingStation = (EVChargingStation) obj;
        return Objects.equals(this.supplierName, eVChargingStation.supplierName) && Objects.equals(this.connectorTypeName, eVChargingStation.connectorTypeName) && Objects.equals(this.connectorTypeId, eVChargingStation.connectorTypeId) && Objects.equals(this.powerFeedTypeName, eVChargingStation.powerFeedTypeName) && Objects.equals(this.powerFeedTypeId, eVChargingStation.powerFeedTypeId) && Objects.equals(this.maxPowerInKilowatts, eVChargingStation.maxPowerInKilowatts) && Objects.equals(this.connectorCount, eVChargingStation.connectorCount) && Objects.equals(this.availableConnectorCount, eVChargingStation.availableConnectorCount) && Objects.equals(this.chargingMode, eVChargingStation.chargingMode) && Objects.equals(this.voltageRangeInVolts, eVChargingStation.voltageRangeInVolts) && Objects.equals(this.currentRangeInAmperes, eVChargingStation.currentRangeInAmperes) && Objects.equals(this.phaseCount, eVChargingStation.phaseCount) && Objects.equals(this.hasFixedCable, eVChargingStation.hasFixedCable);
    }

    public int hashCode() {
        String str = this.supplierName;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.connectorTypeName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.connectorTypeId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.powerFeedTypeName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.powerFeedTypeId;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Double d = this.maxPowerInKilowatts;
        int hashCode6 = (hashCode5 + (d != null ? d.hashCode() : 0)) * 31;
        Integer num = this.connectorCount;
        int hashCode7 = (hashCode6 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.availableConnectorCount;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str6 = this.chargingMode;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.voltageRangeInVolts;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.currentRangeInAmperes;
        int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Integer num3 = this.phaseCount;
        int hashCode12 = (hashCode11 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Boolean bool = this.hasFixedCable;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode12 + i;
    }
}
