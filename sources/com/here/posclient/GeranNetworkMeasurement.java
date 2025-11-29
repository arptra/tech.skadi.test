package com.here.posclient;

public class GeranNetworkMeasurement extends NetworkMeasurement {
    public final int arfcn;
    public final int bsic;
    public boolean hasRxLevel;
    public int rxLevel = Integer.MAX_VALUE;

    public GeranNetworkMeasurement(int i, int i2) {
        this.bsic = i;
        this.arfcn = i2;
    }

    public void setRxLevel(int i) {
        this.rxLevel = i;
        this.hasRxLevel = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[TYPE:GERAN BSIC:");
        sb.append(this.bsic);
        sb.append(" ARFCN:");
        sb.append(this.arfcn);
        if (this.hasRxLevel) {
            sb.append(" RX:");
            sb.append(this.rxLevel);
        }
        sb.append("]");
        return sb.toString();
    }
}
