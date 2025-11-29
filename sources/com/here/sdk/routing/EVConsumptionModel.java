package com.here.sdk.routing;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class EVConsumptionModel {
    public double ascentConsumptionInWattHoursPerMeter = 0.0d;
    public double auxiliaryConsumptionInWattHoursPerSecond = 0.0d;
    public double descentRecoveryInWattHoursPerMeter = 0.0d;
    @NonNull
    public Map<Integer, Double> freeFlowSpeedTable = new HashMap();
    @NonNull
    public Map<Integer, Double> trafficSpeedTable = new HashMap();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EVConsumptionModel)) {
            return false;
        }
        EVConsumptionModel eVConsumptionModel = (EVConsumptionModel) obj;
        return Double.compare(this.ascentConsumptionInWattHoursPerMeter, eVConsumptionModel.ascentConsumptionInWattHoursPerMeter) == 0 && Double.compare(this.descentRecoveryInWattHoursPerMeter, eVConsumptionModel.descentRecoveryInWattHoursPerMeter) == 0 && Objects.equals(this.freeFlowSpeedTable, eVConsumptionModel.freeFlowSpeedTable) && Objects.equals(this.trafficSpeedTable, eVConsumptionModel.trafficSpeedTable) && Double.compare(this.auxiliaryConsumptionInWattHoursPerSecond, eVConsumptionModel.auxiliaryConsumptionInWattHoursPerSecond) == 0;
    }

    public int hashCode() {
        int doubleToLongBits = (((217 + ((int) (Double.doubleToLongBits(this.ascentConsumptionInWattHoursPerMeter) ^ (Double.doubleToLongBits(this.ascentConsumptionInWattHoursPerMeter) >>> 32)))) * 31) + ((int) (Double.doubleToLongBits(this.descentRecoveryInWattHoursPerMeter) ^ (Double.doubleToLongBits(this.descentRecoveryInWattHoursPerMeter) >>> 32)))) * 31;
        Map<Integer, Double> map = this.freeFlowSpeedTable;
        int i = 0;
        int hashCode = (doubleToLongBits + (map != null ? map.hashCode() : 0)) * 31;
        Map<Integer, Double> map2 = this.trafficSpeedTable;
        if (map2 != null) {
            i = map2.hashCode();
        }
        return ((hashCode + i) * 31) + ((int) (Double.doubleToLongBits(this.auxiliaryConsumptionInWattHoursPerSecond) ^ (Double.doubleToLongBits(this.auxiliaryConsumptionInWattHoursPerSecond) >>> 32)));
    }
}
