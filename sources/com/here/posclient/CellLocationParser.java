package com.here.posclient;

import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.here.odnp.util.Log;
import com.here.odnp.util.TimeManager;
import com.here.posclient.CellMeasurement;
import java.util.Arrays;

public class CellLocationParser {
    private static final String TAG = "posclient.CellLocationParser";

    /* renamed from: com.here.posclient.CellLocationParser$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$here$posclient$CellMeasurement$RANType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.here.posclient.CellMeasurement$RANType[] r0 = com.here.posclient.CellMeasurement.RANType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$here$posclient$CellMeasurement$RANType = r0
                com.here.posclient.CellMeasurement$RANType r1 = com.here.posclient.CellMeasurement.RANType.GERAN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$here$posclient$CellMeasurement$RANType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.here.posclient.CellMeasurement$RANType r1 = com.here.posclient.CellMeasurement.RANType.EUTRA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$here$posclient$CellMeasurement$RANType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.here.posclient.CellMeasurement$RANType r1 = com.here.posclient.CellMeasurement.RANType.UTRAFDD     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$here$posclient$CellMeasurement$RANType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.here.posclient.CellMeasurement$RANType r1 = com.here.posclient.CellMeasurement.RANType.UTRATDD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.here.posclient.CellLocationParser.AnonymousClass1.<clinit>():void");
        }
    }

    private CellLocationParser() {
    }

    public static CellMeasurement createCellMeasurement(CellMeasurement.RANType rANType, String str, GsmCellLocation gsmCellLocation) {
        CellMeasurement cellMeasurement = new CellMeasurement();
        int i = AnonymousClass1.$SwitchMap$com$here$posclient$CellMeasurement$RANType[rANType.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            cellMeasurement.type = rANType;
            cellMeasurement.timeStamp = TimeManager.currentTimeMillis() / 1000;
            if (str == null || str.length() < 5 || str.length() > 6) {
                Log.w(TAG, "createCellMeasurement: Invalid operator string length: %s", str);
                return null;
            }
            try {
                if (!CellMeasurement.storeOperator(cellMeasurement, Integer.parseInt(str.substring(0, 3)), Integer.parseInt(str.substring(3)))) {
                    return null;
                }
                int lac = gsmCellLocation.getLac();
                cellMeasurement.gciL3Value = lac;
                if (lac >= 1 && lac <= 65535 && (cellMeasurement.type == CellMeasurement.RANType.EUTRA || Arrays.binarySearch(CellMeasurement.INVALID_LACS, lac) < 0)) {
                    cellMeasurement.hasGciL3Value = true;
                }
                if (!cellMeasurement.hasGciL3Value) {
                    Log.w(TAG, "createCellMeasurement: Invalid gciL3Value: %d", Integer.valueOf(cellMeasurement.gciL3Value));
                    if (cellMeasurement.type == CellMeasurement.RANType.GERAN) {
                        return null;
                    }
                }
                int cid = gsmCellLocation.getCid();
                cellMeasurement.gciL4Value = cid;
                if (cid < 1 || cid > 268435455) {
                    Log.w(TAG, "createCellMeasurement: Invalid gciL4Value: %d", Integer.valueOf(cid));
                    return null;
                }
                cellMeasurement.hasGciL4Value = true;
                cellMeasurement.simulated = false;
                return cellMeasurement;
            } catch (NumberFormatException e) {
                Log.w(TAG, "createCellMeasurement: Operator string parsing failed: %s, %s", str, Log.getStackTraceString(e));
                return null;
            }
        } else {
            Log.w(TAG, "createCellMeasurement: Unsupported GSM network type: %s", rANType);
            return null;
        }
    }

    public static CellMeasurement createCellMeasurement(CdmaCellLocation cdmaCellLocation) {
        CellMeasurement cellMeasurement = new CellMeasurement();
        cellMeasurement.type = CellMeasurement.RANType.CDMA;
        cellMeasurement.timeStamp = TimeManager.currentTimeMillis() / 1000;
        int systemId = cdmaCellLocation.getSystemId();
        cellMeasurement.gciL1Value = systemId;
        if (systemId < 0 || systemId > 32767) {
            Log.w(TAG, "createCellMeasurement: Invalid gciL1Value: %d", Integer.valueOf(systemId));
            return null;
        }
        int networkId = cdmaCellLocation.getNetworkId();
        cellMeasurement.gciL2Value = networkId;
        if (networkId < 0 || networkId > 65535) {
            Log.w(TAG, "createCellMeasurement: Invalid gciL2Value: %d", Integer.valueOf(networkId));
            return null;
        }
        int baseStationId = cdmaCellLocation.getBaseStationId();
        cellMeasurement.gciL4Value = baseStationId;
        if (baseStationId < 0 || baseStationId > 65535) {
            Log.w(TAG, "createCellMeasurement: Invalid gciL4Value: %d", Integer.valueOf(baseStationId));
            return null;
        }
        cellMeasurement.hasGciL4Value = true;
        cellMeasurement.simulated = false;
        return cellMeasurement;
    }
}
