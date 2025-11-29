package com.here.posclient;

import com.meizu.common.util.LunarCalendar;

public class NrNetworkMeasurement extends NetworkMeasurement {
    public static final int NOT_SET = Integer.MAX_VALUE;
    public int csirsrp = Integer.MAX_VALUE;
    public int csirsrq = Integer.MAX_VALUE;
    public int csisinr = Integer.MAX_VALUE;
    public final int nrarfcn;
    public final int pci;
    public int ssrsrp = Integer.MAX_VALUE;
    public int ssrsrq = Integer.MAX_VALUE;
    public int sssinr = Integer.MAX_VALUE;
    public int tac = Integer.MAX_VALUE;

    public NrNetworkMeasurement(int i, int i2) {
        this.pci = i;
        this.nrarfcn = i2;
    }

    public void setChannelStateSignal(int i, int i2, int i3) {
        this.csirsrp = i;
        this.csirsrq = i2;
        this.csisinr = i3;
    }

    public void setSynchronizationSignal(int i, int i2, int i3) {
        this.ssrsrp = i;
        this.ssrsrq = i2;
        this.sssinr = i3;
    }

    public void setTac(int i) {
        this.tac = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[TYPE:NR PCI:");
        sb.append(this.pci);
        sb.append(" NR-ARFCN:");
        sb.append(this.nrarfcn);
        sb.append(" TAC:");
        int i = this.tac;
        if (i != Integer.MAX_VALUE) {
            sb.append(i);
        } else {
            sb.append(LunarCalendar.DATE_SEPARATOR);
        }
        sb.append(" SS: [RSRP:");
        int i2 = this.ssrsrp;
        if (i2 != Integer.MAX_VALUE) {
            sb.append(i2);
        } else {
            sb.append(LunarCalendar.DATE_SEPARATOR);
        }
        sb.append(" RSRQ:");
        int i3 = this.ssrsrq;
        if (i3 != Integer.MAX_VALUE) {
            sb.append(i3);
        } else {
            sb.append(LunarCalendar.DATE_SEPARATOR);
        }
        sb.append(" SINR:");
        int i4 = this.sssinr;
        if (i4 != Integer.MAX_VALUE) {
            sb.append(i4);
        } else {
            sb.append(LunarCalendar.DATE_SEPARATOR);
        }
        sb.append("]");
        sb.append(" CSI: [RSRP:");
        int i5 = this.csirsrp;
        if (i5 != Integer.MAX_VALUE) {
            sb.append(i5);
        } else {
            sb.append(LunarCalendar.DATE_SEPARATOR);
        }
        sb.append(" RSRQ:");
        int i6 = this.csirsrq;
        if (i6 != Integer.MAX_VALUE) {
            sb.append(i6);
        } else {
            sb.append(LunarCalendar.DATE_SEPARATOR);
        }
        sb.append(" SINR:");
        int i7 = this.csisinr;
        if (i7 != Integer.MAX_VALUE) {
            sb.append(i7);
        } else {
            sb.append(LunarCalendar.DATE_SEPARATOR);
        }
        sb.append("]");
        sb.append("]");
        return sb.toString();
    }
}
