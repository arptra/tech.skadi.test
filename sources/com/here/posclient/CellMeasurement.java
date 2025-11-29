package com.here.posclient;

import com.here.odnp.util.Log;

public class CellMeasurement {
    static final int[] INVALID_LACS = {65534};
    static final int MAX_ARFCN = 1023;
    static final int MAX_BSIC = 63;
    static final int MAX_BSID = 65535;
    static final int MAX_CID = 65535;
    static final int MAX_EARFCN = 262143;
    static final int MAX_LAC = 65535;
    private static final int MAX_MCC = 999;
    private static final int MAX_MNC = 999;
    private static final int MAX_MNC_LENGTH = 3;
    static final long MAX_NCI = 68719476735L;
    static final int MAX_NID = 65535;
    static final int MAX_NRARFCN = 3279165;
    static final int MAX_NR_PCI = 1007;
    static final int MAX_NR_RSRP = -31;
    static final int MAX_NR_RSRQ = 20;
    static final int MAX_NR_SINR = 40;
    static final int MAX_NR_TAC = 16777215;
    static final int MAX_PCI = 503;
    static final int MAX_PSC = 511;
    static final int MAX_SID = 32767;
    static final int MAX_TAC = 65535;
    static final int MAX_UARFCN = 16383;
    static final int MAX_UCID = 268435455;
    private static final int MCC_LENGTH = 3;
    static final int MIN_ARFCN = 1;
    static final int MIN_BSIC = 1;
    static final int MIN_BSID = 0;
    static final int MIN_CID = 1;
    static final int MIN_EARFCN = 1;
    static final int MIN_LAC = 1;
    private static final int MIN_MCC = 1;
    private static final int MIN_MNC = 0;
    private static final int MIN_MNC_LENGTH = 2;
    static final long MIN_NCI = 0;
    static final int MIN_NID = 0;
    static final int MIN_NRARFCN = 0;
    static final int MIN_NR_PCI = 0;
    static final int MIN_NR_RSRP = -156;
    static final int MIN_NR_RSRQ = -43;
    static final int MIN_NR_SINR = -23;
    static final int MIN_NR_TAC = 0;
    static final int MIN_PCI = 1;
    static final int MIN_PSC = 1;
    static final int MIN_SID = 0;
    static final int MIN_TAC = 1;
    static final int MIN_UARFCN = 1;
    static final int MIN_UCID = 1;
    private static final String TAG = "posclient.CellMeasurement";
    public int gciL1Value;
    public int gciL2Value;
    public int gciL3Value;
    public int gciL4Value;
    public long gclL4Value;
    public boolean hasGciL3Value;
    public boolean hasGciL4Value;
    public boolean hasGclL4Value;
    public boolean hasLciL1Value;
    public boolean hasLciL2Value;
    public boolean hasLciL3Value;
    public boolean hasLciL4Value;
    public boolean hasLciL5Value;
    public boolean hasLciL6Value;
    public boolean hasLciL7Value;
    public boolean hasLciL8Value;
    public int lciL1Value;
    public int lciL2Value;
    public int lciL3Value;
    public int lciL4Value;
    public int lciL5Value;
    public int lciL6Value;
    public int lciL7Value;
    public int lciL8Value;
    public String mccStr;
    public long measurementId;
    public String mncStr;
    public NetworkMeasurement[] networkMeasurements;
    public boolean simulated;
    public long timeStamp;
    public RANType type = RANType.UNKNOWN;

    public enum RANType {
        UNKNOWN,
        GERAN,
        UTRAFDD,
        UTRATDD,
        EUTRA,
        CDMA,
        NR
    }

    public static boolean storeOperator(CellMeasurement cellMeasurement, int i, int i2) {
        if (i < 1 || i > 999) {
            Log.w(TAG, "storeOperator: Invalid MCC: %d", Integer.valueOf(i));
            return false;
        }
        cellMeasurement.gciL1Value = i;
        if (i2 < 0 || i2 > 999) {
            Log.w(TAG, "storeOperator: Invalid MNC: %d", Integer.valueOf(i2));
            return false;
        }
        cellMeasurement.gciL2Value = i2;
        return true;
    }

    public boolean isEqual(CellMeasurement cellMeasurement) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        if (cellMeasurement == null || this.type != cellMeasurement.type || this.gciL1Value != cellMeasurement.gciL1Value || this.gciL2Value != cellMeasurement.gciL2Value || (z = this.hasGciL3Value) != cellMeasurement.hasGciL3Value || ((z && this.gciL3Value != cellMeasurement.gciL3Value) || (z2 = this.hasGciL4Value) != cellMeasurement.hasGciL4Value || ((z2 && this.gciL4Value != cellMeasurement.gciL4Value) || (z3 = this.hasLciL1Value) != cellMeasurement.hasLciL1Value || ((z3 && this.lciL1Value != cellMeasurement.lciL1Value) || (z4 = this.hasLciL2Value) != cellMeasurement.hasLciL2Value || ((z4 && this.lciL2Value != cellMeasurement.lciL2Value) || (z5 = this.hasLciL3Value) != cellMeasurement.hasLciL3Value || ((z5 && this.lciL3Value != cellMeasurement.lciL3Value) || (z6 = this.hasLciL4Value) != cellMeasurement.hasLciL4Value || ((z6 && this.lciL4Value != cellMeasurement.lciL4Value) || (z7 = this.hasLciL5Value) != cellMeasurement.hasLciL5Value || ((z7 && this.lciL5Value != cellMeasurement.lciL5Value) || (z8 = this.hasLciL6Value) != cellMeasurement.hasLciL6Value || ((z8 && this.lciL6Value != cellMeasurement.lciL6Value) || (z9 = this.hasLciL7Value) != cellMeasurement.hasLciL7Value || ((z9 && this.lciL7Value != cellMeasurement.lciL7Value) || (z10 = this.hasLciL8Value) != cellMeasurement.hasLciL8Value || (z10 && this.lciL8Value != cellMeasurement.lciL8Value))))))))))) {
            return false;
        }
        String str = this.mccStr;
        if (str == null && cellMeasurement.mccStr != null) {
            return false;
        }
        if (str != null && !str.equals(cellMeasurement.mccStr)) {
            return false;
        }
        String str2 = this.mncStr;
        if (str2 != null || cellMeasurement.mncStr == null) {
            return (str2 == null || str2.equals(cellMeasurement.mncStr)) && this.simulated == cellMeasurement.simulated;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[TYPE:");
        sb.append(this.type.name());
        sb.append(" MCC:");
        String str = this.mccStr;
        if (str != null) {
            sb.append(str);
            sb.append(" (");
            sb.append(this.gciL1Value);
            sb.append(")");
        } else {
            sb.append(this.gciL1Value);
        }
        sb.append(" MNC:");
        String str2 = this.mncStr;
        if (str2 != null) {
            sb.append(str2);
            sb.append(" (");
            sb.append(this.gciL2Value);
            sb.append(")");
        } else {
            sb.append(this.gciL2Value);
        }
        if (this.hasGciL3Value) {
            RANType rANType = this.type;
            if (rANType == RANType.EUTRA || rANType == RANType.NR) {
                sb.append(" TAC:");
                sb.append(this.gciL3Value);
            } else if (rANType != RANType.CDMA) {
                sb.append(" LAC:");
                sb.append(this.gciL3Value);
            }
        }
        if (this.hasGciL4Value) {
            sb.append(" CID:");
            sb.append(this.gciL4Value);
        } else if (this.hasGclL4Value) {
            sb.append(" NCI:");
            sb.append(this.gclL4Value);
        }
        if (this.hasLciL1Value) {
            RANType rANType2 = this.type;
            if (rANType2 == RANType.GERAN) {
                sb.append(" BSIC:");
                sb.append(this.lciL1Value);
            } else if (rANType2 == RANType.UTRAFDD) {
                sb.append(" PSC:");
                sb.append(this.lciL1Value);
            } else if (rANType2 == RANType.EUTRA || rANType2 == RANType.NR) {
                sb.append(" PCI:");
                sb.append(this.lciL1Value);
            }
        }
        if (this.hasLciL2Value) {
            RANType rANType3 = this.type;
            if (rANType3 == RANType.GERAN) {
                sb.append(" ARFCN:");
                sb.append(this.lciL2Value);
            } else if (rANType3 == RANType.UTRAFDD) {
                sb.append(" U-ARFCN:");
                sb.append(this.lciL2Value);
            } else if (rANType3 == RANType.EUTRA) {
                sb.append(" E-ARFCN:");
                sb.append(this.lciL2Value);
            } else if (rANType3 == RANType.NR) {
                sb.append(" NRARFCN:");
                sb.append(this.lciL2Value);
            }
        }
        if (this.hasLciL3Value) {
            RANType rANType4 = this.type;
            if (rANType4 == RANType.GERAN) {
                sb.append(" RX:");
                sb.append(this.lciL3Value);
            } else if (rANType4 == RANType.UTRAFDD) {
                sb.append(" RSCP:");
                sb.append(this.lciL3Value);
            } else if (rANType4 == RANType.EUTRA) {
                sb.append(" TA:");
                sb.append(this.lciL3Value);
            } else if (rANType4 == RANType.NR) {
                sb.append(" SSRSRP:");
                sb.append(this.lciL3Value);
            }
        }
        if (this.hasLciL4Value) {
            RANType rANType5 = this.type;
            if (rANType5 == RANType.GERAN) {
                sb.append(" TA:");
                sb.append(this.lciL4Value);
            } else if (rANType5 == RANType.EUTRA) {
                sb.append(" RSRP:");
                sb.append(this.lciL4Value);
            } else if (rANType5 == RANType.NR) {
                sb.append(" SSRSRQ:");
                sb.append(this.lciL4Value);
            }
        }
        if (this.hasLciL5Value) {
            RANType rANType6 = this.type;
            if (rANType6 == RANType.EUTRA) {
                sb.append(" RSRQ:");
                sb.append(this.lciL5Value);
            } else if (rANType6 == RANType.NR) {
                sb.append(" SSSINR:");
                sb.append(this.lciL5Value);
            }
        }
        if (this.hasLciL6Value && this.type == RANType.NR) {
            sb.append(" CSIRSRP:");
            sb.append(this.lciL6Value);
        }
        if (this.hasLciL7Value && this.type == RANType.NR) {
            sb.append(" CSIRSRQ:");
            sb.append(this.lciL7Value);
        }
        if (this.hasLciL8Value && this.type == RANType.NR) {
            sb.append(" CSISINR:");
            sb.append(this.lciL8Value);
        }
        NetworkMeasurement[] networkMeasurementArr = this.networkMeasurements;
        if (networkMeasurementArr != null) {
            for (NetworkMeasurement append : networkMeasurementArr) {
                sb.append(" ");
                sb.append(append);
            }
        }
        if (this.simulated) {
            sb.append(" SIMULATED");
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:15|16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        com.here.odnp.util.Log.w(TAG, "storeOperator: Invalid MNC: %s", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        return false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0032 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean storeOperator(com.here.posclient.CellMeasurement r7, java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "storeOperator: Invalid MCC: %s"
            r1 = 0
            java.lang.String r2 = "posclient.CellMeasurement"
            if (r8 == 0) goto L_0x004a
            int r3 = r8.length()
            r4 = 3
            if (r3 == r4) goto L_0x000f
            goto L_0x004a
        L_0x000f:
            java.lang.String r3 = "storeOperator: Invalid MNC: %s"
            if (r9 == 0) goto L_0x0042
            int r5 = r9.length()
            r6 = 2
            if (r5 < r6) goto L_0x0042
            int r5 = r9.length()
            if (r5 <= r4) goto L_0x0021
            goto L_0x0042
        L_0x0021:
            int r4 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x003a }
            int r5 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x0032 }
            storeOperator((com.here.posclient.CellMeasurement) r7, (int) r4, (int) r5)     // Catch:{ NumberFormatException -> 0x0032 }
            r7.mccStr = r8     // Catch:{ NumberFormatException -> 0x0032 }
            r7.mncStr = r9     // Catch:{ NumberFormatException -> 0x0032 }
            r7 = 1
            return r7
        L_0x0032:
            java.lang.Object[] r7 = new java.lang.Object[]{r9}     // Catch:{ NumberFormatException -> 0x003a }
            com.here.odnp.util.Log.w(r2, r3, r7)     // Catch:{ NumberFormatException -> 0x003a }
            return r1
        L_0x003a:
            java.lang.Object[] r7 = new java.lang.Object[]{r8}
            com.here.odnp.util.Log.w(r2, r0, r7)
            return r1
        L_0x0042:
            java.lang.Object[] r7 = new java.lang.Object[]{r9}
            com.here.odnp.util.Log.w(r2, r3, r7)
            return r1
        L_0x004a:
            java.lang.Object[] r7 = new java.lang.Object[]{r8}
            com.here.odnp.util.Log.w(r2, r0, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.posclient.CellMeasurement.storeOperator(com.here.posclient.CellMeasurement, java.lang.String, java.lang.String):boolean");
    }
}
