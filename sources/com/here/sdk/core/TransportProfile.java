package com.here.sdk.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.transport.VehicleProfile;
import java.util.Objects;

public final class TransportProfile {
    @NonNull
    public PedestrianProfile pedestrianProfile = new PedestrianProfile();
    @Nullable
    public VehicleProfile vehicleProfile = null;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransportProfile)) {
            return false;
        }
        TransportProfile transportProfile = (TransportProfile) obj;
        return Objects.equals(this.pedestrianProfile, transportProfile.pedestrianProfile) && Objects.equals(this.vehicleProfile, transportProfile.vehicleProfile);
    }

    public int hashCode() {
        PedestrianProfile pedestrianProfile2 = this.pedestrianProfile;
        int i = 0;
        int hashCode = (217 + (pedestrianProfile2 != null ? pedestrianProfile2.hashCode() : 0)) * 31;
        VehicleProfile vehicleProfile2 = this.vehicleProfile;
        if (vehicleProfile2 != null) {
            i = vehicleProfile2.hashCode();
        }
        return hashCode + i;
    }
}
