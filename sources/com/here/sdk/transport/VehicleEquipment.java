package com.here.sdk.transport;

public final class VehicleEquipment {
    public boolean hasSnowChains = false;
    public boolean hasWinterTyres = false;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VehicleEquipment)) {
            return false;
        }
        VehicleEquipment vehicleEquipment = (VehicleEquipment) obj;
        return this.hasSnowChains == vehicleEquipment.hasSnowChains && this.hasWinterTyres == vehicleEquipment.hasWinterTyres;
    }

    public int hashCode() {
        int i = 97;
        int i2 = (217 + (this.hasSnowChains ? 79 : 97)) * 31;
        if (this.hasWinterTyres) {
            i = 79;
        }
        return i2 + i;
    }
}
