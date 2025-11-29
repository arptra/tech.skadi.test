package com.here.sdk.routing;

public final class EVDetails {
    public double consumptionInKilowattHour;

    public EVDetails(double d) {
        this.consumptionInKilowattHour = d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EVDetails)) {
            return false;
        }
        return Double.compare(this.consumptionInKilowattHour, ((EVDetails) obj).consumptionInKilowattHour) == 0;
    }

    public int hashCode() {
        return 217 + ((int) (Double.doubleToLongBits(this.consumptionInKilowattHour) ^ (Double.doubleToLongBits(this.consumptionInKilowattHour) >>> 32)));
    }
}
