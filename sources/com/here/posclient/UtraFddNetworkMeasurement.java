package com.here.posclient;

public class UtraFddNetworkMeasurement extends NetworkMeasurement {
    public boolean hasRscp;
    public final int psc;
    public int rscp = Integer.MAX_VALUE;
    public final int uarfcn;

    public UtraFddNetworkMeasurement(int i, int i2) {
        this.psc = i;
        this.uarfcn = i2;
    }

    public void setRscp(int i) {
        this.rscp = i;
        this.hasRscp = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[TYPE:UTRA-FDD PSC:");
        sb.append(this.psc);
        sb.append(" U-ARFCN:");
        sb.append(this.uarfcn);
        if (this.hasRscp) {
            sb.append(" RSCP:");
            sb.append(this.rscp);
        }
        sb.append("]");
        return sb.toString();
    }
}
