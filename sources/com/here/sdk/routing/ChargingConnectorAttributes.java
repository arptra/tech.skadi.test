package com.here.sdk.routing;

import androidx.annotation.Nullable;
import java.util.Objects;

public final class ChargingConnectorAttributes {
    @Nullable
    public ChargingConnectorType connectorType;
    @Nullable
    public Double currentInAmperes;
    public double powerInKilowatts;
    @Nullable
    public ChargingSupplyType supplyType;
    @Nullable
    public Double voltageInVolts;

    public ChargingConnectorAttributes(double d, @Nullable Double d2, @Nullable Double d3, @Nullable ChargingSupplyType chargingSupplyType, @Nullable ChargingConnectorType chargingConnectorType) {
        this.powerInKilowatts = d;
        this.currentInAmperes = d2;
        this.voltageInVolts = d3;
        this.supplyType = chargingSupplyType;
        this.connectorType = chargingConnectorType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChargingConnectorAttributes)) {
            return false;
        }
        ChargingConnectorAttributes chargingConnectorAttributes = (ChargingConnectorAttributes) obj;
        return Double.compare(this.powerInKilowatts, chargingConnectorAttributes.powerInKilowatts) == 0 && Objects.equals(this.currentInAmperes, chargingConnectorAttributes.currentInAmperes) && Objects.equals(this.voltageInVolts, chargingConnectorAttributes.voltageInVolts) && Objects.equals(this.supplyType, chargingConnectorAttributes.supplyType) && Objects.equals(this.connectorType, chargingConnectorAttributes.connectorType);
    }

    public int hashCode() {
        int doubleToLongBits = (217 + ((int) (Double.doubleToLongBits(this.powerInKilowatts) ^ (Double.doubleToLongBits(this.powerInKilowatts) >>> 32)))) * 31;
        Double d = this.currentInAmperes;
        int i = 0;
        int hashCode = (doubleToLongBits + (d != null ? d.hashCode() : 0)) * 31;
        Double d2 = this.voltageInVolts;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 31;
        ChargingSupplyType chargingSupplyType = this.supplyType;
        int hashCode3 = (hashCode2 + (chargingSupplyType != null ? chargingSupplyType.hashCode() : 0)) * 31;
        ChargingConnectorType chargingConnectorType = this.connectorType;
        if (chargingConnectorType != null) {
            i = chargingConnectorType.hashCode();
        }
        return hashCode3 + i;
    }
}
