package com.here.posclient;

public class EutraNetworkMeasurement extends NetworkMeasurement {
    public final int earfcn;
    public boolean hasRsrp;
    public boolean hasRsrq;
    public final int pci;
    public int rsrp = Integer.MAX_VALUE;
    public int rsrq = Integer.MAX_VALUE;

    public EutraNetworkMeasurement(int i, int i2) {
        this.pci = i;
        this.earfcn = i2;
    }

    public void setReferenceSignalPower(int i) {
        this.rsrp = i;
        this.hasRsrp = true;
    }

    public void setReferenceSignalPowerAndQuality(int i, int i2) {
        this.rsrp = i;
        this.hasRsrp = true;
        this.rsrq = i2;
        this.hasRsrq = true;
    }

    public void setReferenceSignalQuality(int i) {
        this.rsrq = i;
        this.hasRsrq = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[TYPE:E-UTRA PCI:");
        sb.append(this.pci);
        sb.append(" E-ARFCN:");
        sb.append(this.earfcn);
        if (this.hasRsrp) {
            sb.append(" RSRP:");
            sb.append(this.rsrp);
        }
        if (this.hasRsrq) {
            sb.append(" RSRQ:");
            sb.append(this.rsrq);
        }
        sb.append("]");
        return sb.toString();
    }
}
