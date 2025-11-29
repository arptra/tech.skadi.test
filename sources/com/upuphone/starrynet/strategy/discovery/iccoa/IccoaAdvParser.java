package com.upuphone.starrynet.strategy.discovery.iccoa;

import android.bluetooth.le.ScanResult;
import android.os.ParcelUuid;
import android.util.Log;
import androidx.core.util.Pair;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class IccoaAdvParser {
    private static final int ADV_DATA_LENGTH = 15;
    private static final int DEFAULT_MIN_ALLOWED_RSSI = -70;
    public static final ParcelUuid ICCOA_ADV_CAR_INFO_1_UUID = ParcelUuid.fromString("00000001-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid ICCOA_ADV_CAR_INFO_2_UUID = ParcelUuid.fromString("00000002-0000-1000-8000-00805F9B34FB");
    private static final int[] MIN_ALLOWED_RSSI = {15, 1};
    private static final int[] PHONE_BT_MAC_CRC16 = {16, 2};
    private static final int SCAN_RESP_LENGTH = 16;
    private static final String TAG = "IccoaAdvParser";

    public static boolean parseScanRecord(ScanResult scanResult, StDiscoveryDevice stDiscoveryDevice, List<Pair<String, String>> list) {
        byte b;
        int i;
        try {
            byte[] serviceData = scanResult.getScanRecord().getServiceData(ICCOA_ADV_CAR_INFO_1_UUID);
            byte[] serviceData2 = scanResult.getScanRecord().getServiceData(ICCOA_ADV_CAR_INFO_2_UUID);
            if (serviceData != null) {
                if (serviceData.length >= 15) {
                    if (serviceData2 != null) {
                        if (serviceData2.length >= 16) {
                            String bytes2HexString = Utils.bytes2HexString(Arrays.copyOfRange(serviceData, 9, 11));
                            String bytes2HexString2 = Utils.bytes2HexString(Arrays.copyOfRange(serviceData, 11, 13));
                            if (list != null && !list.isEmpty()) {
                                for (Pair next : list) {
                                    if (((String) next.f847a).equalsIgnoreCase(bytes2HexString) && ((String) next.b).equalsIgnoreCase(bytes2HexString2)) {
                                        return false;
                                    }
                                }
                            }
                            String str = Byte.toUnsignedInt(serviceData[0]) + "." + Byte.toUnsignedInt(serviceData[1]);
                            String bytes2HexString3 = Utils.bytes2HexString(new byte[]{serviceData[2]});
                            byte[] copyOfRange = Arrays.copyOfRange(serviceData, 3, 9);
                            String bytes2HexString4 = Utils.bytes2HexString(Arrays.copyOfRange(serviceData, 13, 15));
                            String trim = new String(serviceData2, 0, 16, StandardCharsets.UTF_8).trim();
                            int length = serviceData.length;
                            int[] iArr = MIN_ALLOWED_RSSI;
                            if (length >= iArr[0] + iArr[1]) {
                                StLog.d(TAG, "getAllowedMinRssi = " + serviceData[iArr[0]]);
                                b = serviceData[iArr[0]];
                            } else {
                                b = -70;
                            }
                            int length2 = serviceData.length;
                            int[] iArr2 = PHONE_BT_MAC_CRC16;
                            int i2 = iArr2[0];
                            if (length2 >= iArr2[1] + i2) {
                                i = (serviceData[i2] << 8) + serviceData[i2 + 1];
                                StLog.d(TAG, "getPhoneBtMacCRC16 ,value =" + i);
                            } else {
                                i = 0;
                            }
                            stDiscoveryDevice.setIdentifier(copyOfRange);
                            stDiscoveryDevice.setCarId(Utils.bytes2HexString(copyOfRange));
                            stDiscoveryDevice.setCarProductId(bytes2HexString2);
                            stDiscoveryDevice.setCarVendorId(bytes2HexString);
                            stDiscoveryDevice.setIccoaSerialNum(bytes2HexString3);
                            stDiscoveryDevice.setCarName(trim);
                            stDiscoveryDevice.setCarProtocolVersion(str);
                            stDiscoveryDevice.setCarVendorData(bytes2HexString4);
                            stDiscoveryDevice.setIccoaMinAllowedRssi(b);
                            stDiscoveryDevice.setPhoneBtMacCRC16(i);
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Exception e) {
            StLog.e(TAG, "parseScanRecord error, detail:" + Log.getStackTraceString(e));
            return false;
        }
    }
}
