package com.here.sdk.routing;

import androidx.annotation.Nullable;
import java.util.Objects;

public final class ChargingStation {
    @Nullable
    public ChargingConnectorAttributes connectorAttributes;
    @Nullable
    public String id;
    @Nullable
    public String name;

    public ChargingStation(@Nullable String str, @Nullable String str2, @Nullable ChargingConnectorAttributes chargingConnectorAttributes) {
        this.id = str;
        this.name = str2;
        this.connectorAttributes = chargingConnectorAttributes;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChargingStation)) {
            return false;
        }
        ChargingStation chargingStation = (ChargingStation) obj;
        return Objects.equals(this.id, chargingStation.id) && Objects.equals(this.name, chargingStation.name) && Objects.equals(this.connectorAttributes, chargingStation.connectorAttributes);
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ChargingConnectorAttributes chargingConnectorAttributes = this.connectorAttributes;
        if (chargingConnectorAttributes != null) {
            i = chargingConnectorAttributes.hashCode();
        }
        return hashCode2 + i;
    }
}
