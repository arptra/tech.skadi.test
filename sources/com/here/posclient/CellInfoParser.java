package com.here.posclient;

import android.annotation.TargetApi;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthWcdma;
import com.here.odnp.util.Log;
import com.here.odnp.util.TimeManager;
import com.here.posclient.CellMeasurement;
import com.upuphone.xr.interconnect.pm.OpenRemoteStarryNetAppCode;
import io.netty.handler.codec.http2.Http2CodecUtil;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@TargetApi(24)
public final class CellInfoParser {
    private static final int EUTRA_MAX_ANDROID_REFERENCE_SIGNAL_RECEIVED_POWER = -43;
    private static final int EUTRA_MAX_ANDROID_REFERENCE_SIGNAL_RECEIVED_QUALITY = -3;
    private static final int EUTRA_MIN_ANDROID_REFERENCE_SIGNAL_RECEIVED_POWER = -140;
    private static final int EUTRA_MIN_ANDROID_REFERENCE_SIGNAL_RECEIVED_QUALITY = -40;
    private static final int GERAN_ANDROID_MAX_SIGNAL_STRENGTH_DBM_VALUE = -25;
    private static final int GERAN_ANDROID_MIN_SIGNAL_STRENGTH_DBM_VALUE = -110;
    private static final int GERAN_MAX_ANDROID_TIMING_ADVANCE_VALUE = 219;
    private static final int GERAN_MAX_POSCLIENT_TIMING_ADVANCE_VALUE = 63;
    private static final int GERAN_POSCLIENT_MAX_SIGNAL_STRENGTH_DBM_VALUE = 87;
    private static final int GERAN_POSCLIENT_MIN_SIGNAL_STRENGTH_DBM_VALUE = 0;
    private static final int GERAN_POSCLIENT_RX_LEVEL_BASE = 111;
    private static final String TAG = "posclient.CellInfoParser";
    private static final int UTRAFDD_ANDROID_MIN_DBM_VALUE = -120;
    private static final int UTRAFDD_POSCLIENT_MAX_RSCP_VALUE = 91;
    private static final int UTRAFDD_POSCLIENT_MIN_RSCP_VALUE = -5;

    private CellInfoParser() {
    }

    public static String cellInfoToString(List<CellInfo> list) {
        return "";
    }

    @TargetApi(24)
    private static CellMeasurement createCdmaServingCell(CellInfoCdma cellInfoCdma) {
        CellMeasurement cellMeasurement = new CellMeasurement();
        cellMeasurement.type = CellMeasurement.RANType.CDMA;
        cellMeasurement.timeStamp = getCellTimeStamp(cellInfoCdma);
        CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
        int systemId = cellIdentity.getSystemId();
        cellMeasurement.gciL1Value = systemId;
        if (!inRange(systemId, 0, 32767)) {
            Log.w(TAG, "createCdmaServingCell: Invalid gciL1Value %d", Integer.valueOf(cellMeasurement.gciL1Value));
            return null;
        }
        int networkId = cellIdentity.getNetworkId();
        cellMeasurement.gciL2Value = networkId;
        if (!inRange(networkId, 0, 65535)) {
            Log.w(TAG, "createCdmaServingCell: Invalid gciL2Value %d", Integer.valueOf(cellMeasurement.gciL2Value));
            return null;
        }
        int basestationId = cellIdentity.getBasestationId();
        cellMeasurement.gciL4Value = basestationId;
        boolean inRange = inRange(basestationId, 0, 65535);
        cellMeasurement.hasGciL4Value = inRange;
        if (!inRange) {
            Log.w(TAG, "createCdmaServingCell: Invalid gciL4Value %d", Integer.valueOf(cellMeasurement.gciL4Value));
            return null;
        }
        cellMeasurement.simulated = false;
        return cellMeasurement;
    }

    public static CellMeasurement createCellMeasurement(List<CellInfo> list) {
        if (list == null || list.isEmpty()) {
            Log.w(TAG, "createCellMeasurement: No measurements found", new Object[0]);
            return null;
        }
        CellInfo cellInfo = list.get(0);
        if (cellInfo == null) {
            Log.w(TAG, "createCellMeasurement: Null serving cell", new Object[0]);
            return null;
        } else if (!cellInfo.isRegistered()) {
            Log.w(TAG, "createCellMeasurement: No serving cell", new Object[0]);
            return null;
        } else {
            CellMeasurement createServingCell = createServingCell(cellInfo);
            if (createServingCell == null) {
                Log.w(TAG, "createCellMeasurement: Ignoring due to invalid serving cell", new Object[0]);
                return null;
            }
            LinkedList linkedList = new LinkedList();
            int i = 1;
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                CellInfo cellInfo2 = list.get(i);
                if (cellInfo2.isRegistered()) {
                    Log.v(TAG, "createCellMeasurement: Ignoring secondary SIM measurements", new Object[0]);
                    break;
                }
                NetworkMeasurement createNeighbor = createNeighbor(createServingCell, cellInfo2);
                if (createNeighbor != null) {
                    linkedList.add(createNeighbor);
                }
                i++;
            }
            if (!linkedList.isEmpty()) {
                NetworkMeasurement[] networkMeasurementArr = new NetworkMeasurement[linkedList.size()];
                createServingCell.networkMeasurements = networkMeasurementArr;
                linkedList.toArray(networkMeasurementArr);
            }
            return createServingCell;
        }
    }

    @TargetApi(24)
    private static EutraNetworkMeasurement createEutraNeighbor(CellMeasurement cellMeasurement, CellInfoLte cellInfoLte) {
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        if (cellIdentity == null) {
            Log.w(TAG, "createEutraNeighbor: No cell identity", new Object[0]);
            return null;
        } else if (!validateNeighborOperator(cellMeasurement, cellIdentity.getMccString(), cellIdentity.getMncString())) {
            return null;
        } else {
            int pci = cellIdentity.getPci();
            if (!inRange(pci, 1, (int) OpenRemoteStarryNetAppCode.CODE_PULL_MAIN_APP_FAIL)) {
                Log.w(TAG, "createEutraNeighbor: Invalid PCI value: %d", Integer.valueOf(pci));
                return null;
            }
            int earfcn = cellIdentity.getEarfcn();
            if (!inRange(earfcn, 1, 262143)) {
                Log.w(TAG, "createEutraNeighbor: Invalid EARFCN value: %d", Integer.valueOf(earfcn));
                return null;
            } else if (!cellMeasurement.hasLciL1Value || cellMeasurement.lciL1Value != pci || !cellMeasurement.hasLciL2Value || cellMeasurement.lciL2Value != earfcn) {
                EutraNetworkMeasurement eutraNetworkMeasurement = new EutraNetworkMeasurement(pci, earfcn);
                CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
                if (cellSignalStrength != null) {
                    int rsrp = cellSignalStrength.getRsrp();
                    boolean inRange = inRange(rsrp, (int) EUTRA_MIN_ANDROID_REFERENCE_SIGNAL_RECEIVED_POWER, (int) EUTRA_MAX_ANDROID_REFERENCE_SIGNAL_RECEIVED_POWER);
                    if (!inRange && rsrp != Integer.MAX_VALUE) {
                        Log.w(TAG, "createEutraNeighbor: Invalid RSRP %d", Integer.valueOf(rsrp));
                    }
                    int rsrq = cellSignalStrength.getRsrq();
                    boolean inRange2 = inRange(rsrq, (int) EUTRA_MIN_ANDROID_REFERENCE_SIGNAL_RECEIVED_QUALITY, -3);
                    if (!inRange2 && rsrq != Integer.MAX_VALUE) {
                        Log.w(TAG, "createEutraNeighbor: Invalid RSRQ %d", Integer.valueOf(rsrq));
                    }
                    if (inRange) {
                        eutraNetworkMeasurement.setReferenceSignalPower(rsrp);
                        if (inRange2) {
                            eutraNetworkMeasurement.setReferenceSignalQuality(rsrq);
                        }
                    }
                }
                return eutraNetworkMeasurement;
            } else {
                Log.w(TAG, "createEutraNeighbor: Duplicate neighbor measurement for serving cell: PCI: %d, EARFCN: %d", Integer.valueOf(pci), Integer.valueOf(earfcn));
                return null;
            }
        }
    }

    @TargetApi(24)
    private static CellMeasurement createEutraServingCell(CellInfoLte cellInfoLte) {
        CellMeasurement cellMeasurement = new CellMeasurement();
        cellMeasurement.type = CellMeasurement.RANType.EUTRA;
        cellMeasurement.timeStamp = getCellTimeStamp(cellInfoLte);
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        if (!CellMeasurement.storeOperator(cellMeasurement, cellIdentity.getMccString(), cellIdentity.getMncString())) {
            return null;
        }
        int ci = cellIdentity.getCi();
        cellMeasurement.gciL4Value = ci;
        boolean inRange = inRange(ci, 1, 268435455);
        cellMeasurement.hasGciL4Value = inRange;
        if (!inRange) {
            Log.w(TAG, "createEutraServingCell: Invalid gciL4Value %d", Integer.valueOf(cellMeasurement.gciL4Value));
            return null;
        }
        int tac = cellIdentity.getTac();
        cellMeasurement.gciL3Value = tac;
        boolean inRange2 = inRange(tac, 1, 65535);
        cellMeasurement.hasGciL3Value = inRange2;
        if (!inRange2) {
            Log.w(TAG, "createEutraServingCell: Invalid gciL3Value ignored: %d", Integer.valueOf(cellMeasurement.gciL3Value));
        }
        int pci = cellIdentity.getPci();
        int earfcn = cellIdentity.getEarfcn();
        if (inRange(pci, 1, (int) OpenRemoteStarryNetAppCode.CODE_PULL_MAIN_APP_FAIL) && inRange(earfcn, 1, 262143)) {
            cellMeasurement.lciL1Value = pci;
            cellMeasurement.hasLciL1Value = true;
            cellMeasurement.lciL2Value = earfcn;
            cellMeasurement.hasLciL2Value = true;
        }
        CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
        if (cellSignalStrength != null) {
            int timingAdvance = cellSignalStrength.getTimingAdvance();
            boolean z = timingAdvance != Integer.MAX_VALUE;
            cellMeasurement.hasLciL3Value = z;
            if (z) {
                cellMeasurement.lciL3Value = timingAdvance;
            }
            int rsrp = cellSignalStrength.getRsrp();
            boolean inRange3 = inRange(rsrp, (int) EUTRA_MIN_ANDROID_REFERENCE_SIGNAL_RECEIVED_POWER, (int) EUTRA_MAX_ANDROID_REFERENCE_SIGNAL_RECEIVED_POWER);
            if (!inRange3 && rsrp != Integer.MAX_VALUE) {
                Log.w(TAG, "createEutraServingCell: Invalid RSRP %d", Integer.valueOf(rsrp));
            }
            int rsrq = cellSignalStrength.getRsrq();
            boolean inRange4 = inRange(rsrq, (int) EUTRA_MIN_ANDROID_REFERENCE_SIGNAL_RECEIVED_QUALITY, -3);
            if (!inRange4 && rsrq != Integer.MAX_VALUE) {
                Log.w(TAG, "createEutraServingCell: Invalid RSRQ %d", Integer.valueOf(rsrq));
            }
            if (inRange3) {
                cellMeasurement.lciL4Value = rsrp;
                cellMeasurement.hasLciL4Value = true;
                if (inRange4) {
                    cellMeasurement.lciL5Value = rsrq;
                    cellMeasurement.hasLciL5Value = true;
                }
            }
        }
        cellMeasurement.simulated = false;
        return cellMeasurement;
    }

    @TargetApi(24)
    private static GeranNetworkMeasurement createGeranNeighbor(CellMeasurement cellMeasurement, CellInfoGsm cellInfoGsm) {
        int dbm;
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        if (cellIdentity == null) {
            Log.w(TAG, "createGeranNeighbor: No cell identity", new Object[0]);
            return null;
        } else if (!validateNeighborOperator(cellMeasurement, cellIdentity.getMccString(), cellIdentity.getMncString())) {
            return null;
        } else {
            int bsic = cellIdentity.getBsic();
            if (!inRange(bsic, 1, 63)) {
                Log.w(TAG, "createGeranNeighbor: Invalid BSIC value: %d", Integer.valueOf(bsic));
                return null;
            }
            int arfcn = cellIdentity.getArfcn();
            if (!inRange(arfcn, 1, 1023)) {
                Log.w(TAG, "createGeranNeighbor: Invalid ARFCN value: %d", Integer.valueOf(arfcn));
                return null;
            } else if (!cellMeasurement.hasLciL1Value || cellMeasurement.lciL1Value != bsic || !cellMeasurement.hasLciL2Value || cellMeasurement.lciL2Value != arfcn) {
                GeranNetworkMeasurement geranNetworkMeasurement = new GeranNetworkMeasurement(bsic, arfcn);
                CellSignalStrengthGsm cellSignalStrength = cellInfoGsm.getCellSignalStrength();
                if (!(cellSignalStrength == null || (dbm = cellSignalStrength.getDbm()) == Integer.MAX_VALUE)) {
                    geranNetworkMeasurement.setRxLevel(geranDbmToRxLevel(dbm));
                }
                return geranNetworkMeasurement;
            } else {
                Log.w(TAG, "createGeranNeighbor: Duplicate neighbor measurement for serving cell: BSIC: %d, ARFCN: %d", Integer.valueOf(bsic), Integer.valueOf(arfcn));
                return null;
            }
        }
    }

    private static CellMeasurement createGeranServingCell(CellInfoGsm cellInfoGsm) {
        CellMeasurement cellMeasurement = new CellMeasurement();
        cellMeasurement.type = CellMeasurement.RANType.GERAN;
        cellMeasurement.timeStamp = getCellTimeStamp(cellInfoGsm);
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        if (!CellMeasurement.storeOperator(cellMeasurement, cellIdentity.getMccString(), cellIdentity.getMncString())) {
            return null;
        }
        int lac = cellIdentity.getLac();
        cellMeasurement.gciL3Value = lac;
        if (inRange(lac, 1, 65535)) {
            cellMeasurement.hasGciL3Value = Arrays.binarySearch(CellMeasurement.INVALID_LACS, cellMeasurement.gciL3Value) < 0;
        }
        if (!cellMeasurement.hasGciL3Value) {
            Log.w(TAG, "createGeranServingCell: Invalid gciL3Value: %d", Integer.valueOf(cellMeasurement.gciL3Value));
            return null;
        }
        int cid = cellIdentity.getCid();
        cellMeasurement.gciL4Value = cid;
        boolean inRange = inRange(cid, 1, 65535);
        cellMeasurement.hasGciL4Value = inRange;
        if (!inRange) {
            Log.w(TAG, "createGeranServingCell: Invalid gciL4Value %d", Integer.valueOf(cellMeasurement.gciL4Value));
            return null;
        }
        int bsic = cellIdentity.getBsic();
        int arfcn = cellIdentity.getArfcn();
        if (inRange(bsic, 1, 63) && inRange(arfcn, 1, 1023)) {
            cellMeasurement.lciL1Value = bsic;
            cellMeasurement.hasLciL1Value = true;
            cellMeasurement.lciL2Value = arfcn;
            cellMeasurement.hasLciL2Value = true;
        }
        CellSignalStrengthGsm cellSignalStrength = cellInfoGsm.getCellSignalStrength();
        if (cellSignalStrength != null) {
            int dbm = cellSignalStrength.getDbm();
            if (dbm != Integer.MAX_VALUE) {
                cellMeasurement.lciL3Value = geranDbmToRxLevel(dbm);
                cellMeasurement.hasLciL3Value = true;
            }
            int timingAdvance = cellSignalStrength.getTimingAdvance();
            if (timingAdvance != Integer.MAX_VALUE) {
                cellMeasurement.lciL4Value = scaleGeranTimingAdvance(timingAdvance);
                cellMeasurement.hasLciL4Value = true;
            }
        }
        cellMeasurement.simulated = false;
        return cellMeasurement;
    }

    @TargetApi(24)
    private static NetworkMeasurement createNeighbor(CellMeasurement cellMeasurement, CellInfo cellInfo) {
        CellMeasurement.RANType rANType = cellMeasurement.type;
        if (rANType == CellMeasurement.RANType.GERAN && (cellInfo instanceof CellInfoGsm)) {
            return createGeranNeighbor(cellMeasurement, (CellInfoGsm) cellInfo);
        }
        if (rANType == CellMeasurement.RANType.UTRAFDD && (cellInfo instanceof CellInfoWcdma)) {
            return createUtraFddNeighbor(cellMeasurement, (CellInfoWcdma) cellInfo);
        }
        CellMeasurement.RANType rANType2 = CellMeasurement.RANType.EUTRA;
        if (rANType == rANType2 && (cellInfo instanceof CellInfoLte)) {
            return createEutraNeighbor(cellMeasurement, (CellInfoLte) cellInfo);
        }
        if (rANType == rANType2 && (cellInfo instanceof CellInfoNr)) {
            return createNrNeighbor(cellMeasurement, (CellInfoNr) cellInfo);
        }
        if (rANType == CellMeasurement.RANType.NR && (cellInfo instanceof CellInfoNr)) {
            return createNrNeighbor(cellMeasurement, (CellInfoNr) cellInfo);
        }
        Log.v(TAG, "createNeighbor: Ignoring unsupported neighbor cell: %s", cellInfo);
        return null;
    }

    @TargetApi(29)
    private static NrNetworkMeasurement createNrNeighbor(CellMeasurement cellMeasurement, CellInfoNr cellInfoNr) {
        CellIdentityNr cellIdentityNr = (CellIdentityNr) cellInfoNr.getCellIdentity();
        if (cellIdentityNr == null) {
            Log.w(TAG, "createNrNeighbor: No cell identity", new Object[0]);
            return null;
        } else if (!validateNeighborOperator(cellMeasurement, cellIdentityNr.getMccString(), cellIdentityNr.getMncString())) {
            return null;
        } else {
            int pci = cellIdentityNr.getPci();
            if (!inRange(pci, 0, 1007)) {
                Log.w(TAG, "createNrNeighbor: Invalid PCI %d", Integer.valueOf(pci));
                return null;
            }
            int nrarfcn = cellIdentityNr.getNrarfcn();
            if (!inRange(nrarfcn, 0, 3279165)) {
                Log.w(TAG, "createNrNeighbor: Invalid NRARFCN %d", Integer.valueOf(nrarfcn));
                return null;
            }
            NrNetworkMeasurement nrNetworkMeasurement = new NrNetworkMeasurement(pci, nrarfcn);
            int tac = cellIdentityNr.getTac();
            if (inRange(tac, 0, (int) Http2CodecUtil.MAX_FRAME_SIZE_UPPER_BOUND)) {
                nrNetworkMeasurement.setTac(tac);
            }
            CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) cellInfoNr.getCellSignalStrength();
            if (cellSignalStrengthNr != null) {
                int ssRsrp = cellSignalStrengthNr.getSsRsrp();
                boolean isValid = isValid(ssRsrp, -156, -31);
                if (!inRange(ssRsrp, -156, -31)) {
                    ssRsrp = Integer.MAX_VALUE;
                }
                int ssRsrq = cellSignalStrengthNr.getSsRsrq();
                if (!inRange(ssRsrq, (int) EUTRA_MAX_ANDROID_REFERENCE_SIGNAL_RECEIVED_POWER, 20)) {
                    ssRsrq = Integer.MAX_VALUE;
                }
                int ssSinr = cellSignalStrengthNr.getSsSinr();
                if (!inRange(cellSignalStrengthNr.getSsSinr(), -23, 40)) {
                    ssSinr = Integer.MAX_VALUE;
                }
                if (isValid && ssRsrp != Integer.MAX_VALUE) {
                    nrNetworkMeasurement.setSynchronizationSignal(ssRsrp, ssRsrq, ssSinr);
                }
                int csiRsrp = cellSignalStrengthNr.getCsiRsrp();
                boolean isValid2 = isValid(csiRsrp, -156, -31);
                if (!inRange(csiRsrp, -156, -31)) {
                    csiRsrp = Integer.MAX_VALUE;
                }
                int csiRsrq = cellSignalStrengthNr.getCsiRsrq();
                if (!inRange(csiRsrq, (int) EUTRA_MAX_ANDROID_REFERENCE_SIGNAL_RECEIVED_POWER, 20)) {
                    csiRsrq = Integer.MAX_VALUE;
                }
                int csiSinr = cellSignalStrengthNr.getCsiSinr();
                if (!inRange(csiSinr, -23, 40)) {
                    csiSinr = Integer.MAX_VALUE;
                }
                if (isValid2 && csiRsrp != Integer.MAX_VALUE) {
                    nrNetworkMeasurement.setChannelStateSignal(csiRsrp, csiRsrq, csiSinr);
                }
            }
            return nrNetworkMeasurement;
        }
    }

    @TargetApi(29)
    private static CellMeasurement createNrServingCell(CellInfoNr cellInfoNr) {
        CellMeasurement cellMeasurement = new CellMeasurement();
        cellMeasurement.type = CellMeasurement.RANType.NR;
        cellMeasurement.timeStamp = getCellTimeStamp(cellInfoNr);
        CellIdentityNr cellIdentityNr = (CellIdentityNr) cellInfoNr.getCellIdentity();
        if (!CellMeasurement.storeOperator(cellMeasurement, cellIdentityNr.getMccString(), cellIdentityNr.getMncString())) {
            return null;
        }
        long nci = cellIdentityNr.getNci();
        cellMeasurement.gclL4Value = nci;
        boolean inRange = inRange(nci, 0, 68719476735L);
        cellMeasurement.hasGclL4Value = inRange;
        if (!inRange) {
            Log.w(TAG, "createNrServingCell: Invalid gclL4Value %d", Long.valueOf(cellMeasurement.gclL4Value));
            return null;
        }
        int tac = cellIdentityNr.getTac();
        cellMeasurement.gciL3Value = tac;
        boolean inRange2 = inRange(tac, 0, (int) Http2CodecUtil.MAX_FRAME_SIZE_UPPER_BOUND);
        cellMeasurement.hasGciL3Value = inRange2;
        if (!inRange2) {
            Log.w(TAG, "createNrServingCell: Invalid gciL3Value ignored: %d", Integer.valueOf(cellMeasurement.gciL3Value));
        }
        int pci = cellIdentityNr.getPci();
        int nrarfcn = cellIdentityNr.getNrarfcn();
        boolean z = true;
        if (inRange(pci, 0, 1007) && inRange(nrarfcn, 0, 3279165)) {
            cellMeasurement.lciL1Value = pci;
            cellMeasurement.hasLciL1Value = true;
            cellMeasurement.lciL2Value = nrarfcn;
            cellMeasurement.hasLciL2Value = true;
        }
        CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) cellInfoNr.getCellSignalStrength();
        if (cellSignalStrengthNr != null) {
            int ssRsrp = cellSignalStrengthNr.getSsRsrp();
            cellMeasurement.lciL3Value = ssRsrp;
            boolean isValid = isValid(ssRsrp, -156, -31);
            int ssRsrq = cellSignalStrengthNr.getSsRsrq();
            cellMeasurement.lciL4Value = ssRsrq;
            boolean isValid2 = isValid(ssRsrq, EUTRA_MAX_ANDROID_REFERENCE_SIGNAL_RECEIVED_POWER, 20);
            int ssSinr = cellSignalStrengthNr.getSsSinr();
            cellMeasurement.lciL5Value = ssSinr;
            boolean isValid3 = isValid(ssSinr, -23, 40);
            if (isValid) {
                boolean inRange3 = inRange(cellMeasurement.lciL3Value, -156, -31);
                cellMeasurement.hasLciL3Value = inRange3;
                if (inRange3) {
                    cellMeasurement.hasLciL4Value = isValid2 && inRange(cellMeasurement.lciL4Value, (int) EUTRA_MAX_ANDROID_REFERENCE_SIGNAL_RECEIVED_POWER, 20);
                    cellMeasurement.hasLciL5Value = isValid3 && inRange(cellMeasurement.lciL5Value, -23, 40);
                }
            }
            int csiRsrp = cellSignalStrengthNr.getCsiRsrp();
            cellMeasurement.lciL6Value = csiRsrp;
            boolean isValid4 = isValid(csiRsrp, -156, -31);
            int csiRsrq = cellSignalStrengthNr.getCsiRsrq();
            cellMeasurement.lciL7Value = csiRsrq;
            boolean isValid5 = isValid(csiRsrq, EUTRA_MAX_ANDROID_REFERENCE_SIGNAL_RECEIVED_POWER, 20);
            int csiSinr = cellSignalStrengthNr.getCsiSinr();
            cellMeasurement.lciL8Value = csiSinr;
            boolean isValid6 = isValid(csiSinr, -23, 40);
            if (isValid4) {
                boolean inRange4 = inRange(cellMeasurement.lciL6Value, -156, -31);
                cellMeasurement.hasLciL6Value = inRange4;
                if (inRange4) {
                    cellMeasurement.hasLciL7Value = isValid5 && inRange(cellMeasurement.lciL7Value, (int) EUTRA_MAX_ANDROID_REFERENCE_SIGNAL_RECEIVED_POWER, 20);
                    if (!isValid6 || !inRange(cellMeasurement.lciL8Value, -23, 40)) {
                        z = false;
                    }
                    cellMeasurement.hasLciL8Value = z;
                }
            }
        }
        cellMeasurement.simulated = false;
        return cellMeasurement;
    }

    private static CellMeasurement createServingCell(CellInfo cellInfo) {
        if (cellInfo instanceof CellInfoGsm) {
            return createGeranServingCell((CellInfoGsm) cellInfo);
        }
        if (cellInfo instanceof CellInfoWcdma) {
            return createUtraFddServingCell((CellInfoWcdma) cellInfo);
        }
        if (cellInfo instanceof CellInfoLte) {
            return createEutraServingCell((CellInfoLte) cellInfo);
        }
        if (cellInfo instanceof CellInfoCdma) {
            return createCdmaServingCell((CellInfoCdma) cellInfo);
        }
        if (cellInfo instanceof CellInfoNr) {
            return createNrServingCell((CellInfoNr) cellInfo);
        }
        Log.e(TAG, "createServingCell: Unsupported cell info type: %s", cellInfo);
        return null;
    }

    @TargetApi(24)
    private static UtraFddNetworkMeasurement createUtraFddNeighbor(CellMeasurement cellMeasurement, CellInfoWcdma cellInfoWcdma) {
        int scaleUtraFddRscp;
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        if (cellIdentity == null) {
            Log.w(TAG, "createUtraFddNeighbor: No cell identity", new Object[0]);
            return null;
        } else if (!validateNeighborOperator(cellMeasurement, cellIdentity.getMccString(), cellIdentity.getMncString())) {
            return null;
        } else {
            int psc = cellIdentity.getPsc();
            if (!inRange(psc, 1, 511)) {
                Log.w(TAG, "createUtraFddNeighbor: Invalid PSC value: %d", Integer.valueOf(psc));
                return null;
            }
            int uarfcn = cellIdentity.getUarfcn();
            if (!inRange(uarfcn, 1, 16383)) {
                Log.w(TAG, "createUtraFddNeighbor: Invalid UARFCN value: %d", Integer.valueOf(uarfcn));
                return null;
            } else if (!cellMeasurement.hasLciL1Value || cellMeasurement.lciL1Value != psc || !cellMeasurement.hasLciL2Value || cellMeasurement.lciL2Value != uarfcn) {
                UtraFddNetworkMeasurement utraFddNetworkMeasurement = new UtraFddNetworkMeasurement(psc, uarfcn);
                CellSignalStrengthWcdma cellSignalStrength = cellInfoWcdma.getCellSignalStrength();
                if (!(cellSignalStrength == null || (scaleUtraFddRscp = scaleUtraFddRscp(cellSignalStrength.getDbm())) == Integer.MAX_VALUE)) {
                    utraFddNetworkMeasurement.setRscp(scaleUtraFddRscp);
                }
                return utraFddNetworkMeasurement;
            } else {
                Log.w(TAG, "createUtraFddNeighbor: Duplicate neighbor measurement for serving cell: PSC: %d, UARFCN: %d", Integer.valueOf(psc), Integer.valueOf(uarfcn));
                return null;
            }
        }
    }

    @TargetApi(24)
    private static CellMeasurement createUtraFddServingCell(CellInfoWcdma cellInfoWcdma) {
        int scaleUtraFddRscp;
        CellMeasurement cellMeasurement = new CellMeasurement();
        cellMeasurement.type = CellMeasurement.RANType.UTRAFDD;
        cellMeasurement.timeStamp = getCellTimeStamp(cellInfoWcdma);
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        if (!CellMeasurement.storeOperator(cellMeasurement, cellIdentity.getMccString(), cellIdentity.getMncString())) {
            return null;
        }
        int cid = cellIdentity.getCid();
        cellMeasurement.gciL4Value = cid;
        boolean inRange = inRange(cid, 1, 268435455);
        cellMeasurement.hasGciL4Value = inRange;
        if (!inRange) {
            Log.w(TAG, "createUtraFddServingCell: Invalid gciL4Value %d", Integer.valueOf(cellMeasurement.gciL4Value));
            return null;
        }
        int lac = cellIdentity.getLac();
        cellMeasurement.gciL3Value = lac;
        if (inRange(lac, 1, 65535)) {
            cellMeasurement.hasGciL3Value = Arrays.binarySearch(CellMeasurement.INVALID_LACS, cellMeasurement.gciL3Value) < 0;
        }
        if (!cellMeasurement.hasGciL3Value) {
            Log.w(TAG, "createUtraFddServingCell: Invalid gciL3Value ignored: %d", Integer.valueOf(cellMeasurement.gciL3Value));
        }
        int psc = cellIdentity.getPsc();
        int uarfcn = cellIdentity.getUarfcn();
        if (inRange(psc, 1, 511) && inRange(uarfcn, 1, 16383)) {
            cellMeasurement.lciL1Value = psc;
            cellMeasurement.hasLciL1Value = true;
            cellMeasurement.lciL2Value = uarfcn;
            cellMeasurement.hasLciL2Value = true;
        }
        CellSignalStrengthWcdma cellSignalStrength = cellInfoWcdma.getCellSignalStrength();
        if (!(cellSignalStrength == null || (scaleUtraFddRscp = scaleUtraFddRscp(cellSignalStrength.getDbm())) == Integer.MAX_VALUE)) {
            cellMeasurement.lciL3Value = scaleUtraFddRscp;
            cellMeasurement.hasLciL3Value = true;
        }
        cellMeasurement.simulated = false;
        return cellMeasurement;
    }

    private static int geranDbmToRxLevel(int i) {
        if (i < GERAN_ANDROID_MIN_SIGNAL_STRENGTH_DBM_VALUE) {
            return 0;
        }
        if (i >= GERAN_ANDROID_MAX_SIGNAL_STRENGTH_DBM_VALUE) {
            return 87;
        }
        return i + 111;
    }

    private static long getCellTimeStamp(CellInfo cellInfo) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long seconds = timeUnit.toSeconds(TimeManager.timeSinceBoot());
        long seconds2 = TimeUnit.NANOSECONDS.toSeconds(cellInfo.getTimeStamp());
        long max = Math.max(0, seconds - seconds2);
        long seconds3 = timeUnit.toSeconds(TimeManager.currentTimeMillis());
        long max2 = Math.max(Math.min(seconds3, seconds3 - max), 0);
        Log.v(TAG, "getCellTimeStamp: age: %d, secBoot: %d, secCell: %d, secTime: %d, secTimeStamp: %d", Long.valueOf(max), Long.valueOf(seconds), Long.valueOf(seconds2), Long.valueOf(seconds3), Long.valueOf(max2));
        return max2;
    }

    private static boolean inRange(int i, int i2, int i3) {
        return i >= i2 && i <= i3;
    }

    private static boolean isValid(int i, int i2, int i3) {
        return i == Integer.MAX_VALUE || inRange(i, i2, i3);
    }

    private static int scaleGeranTimingAdvance(int i) {
        return (int) Math.floor(((double) (i * 64)) / 220.0d);
    }

    private static int scaleUtraFddRscp(int i) {
        return i == Integer.MAX_VALUE ? i : Math.max(-5, Math.min(UTRAFDD_POSCLIENT_MAX_RSCP_VALUE, i + 116));
    }

    private static boolean validateNeighborOperator(CellMeasurement cellMeasurement, int i, int i2) {
        if ((i == Integer.MAX_VALUE || i == cellMeasurement.gciL1Value) && (i2 == Integer.MAX_VALUE || i2 == cellMeasurement.gciL2Value)) {
            return true;
        }
        Log.v(TAG, "validateNeighborOperator: Mismatch operator: MCC: %d, MNC: %d", Integer.valueOf(i), Integer.valueOf(i2));
        return false;
    }

    private static boolean inRange(long j, long j2, long j3) {
        return j >= j2 && j <= j3;
    }

    private static boolean validateNeighborOperator(CellMeasurement cellMeasurement, String str, String str2) {
        boolean z = true;
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            Log.w(TAG, "validateNeighborOperator: invalid MCC: null", new Object[0]);
            return false;
        } else if (str2 == null) {
            Log.w(TAG, "validateNeighborOperator: invalid MNC: null", new Object[0]);
            return false;
        } else {
            if (!str.equals(cellMeasurement.mccStr) || !str2.equals(cellMeasurement.mncStr)) {
                z = false;
            }
            if (!z) {
                Log.v(TAG, "validateNeighborOperator: Mismatch operator: MCC: %s, MNC: %s", str, str2);
            }
            return z;
        }
    }
}
