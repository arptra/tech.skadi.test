package com.upuphone.starrynet.strategy.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.AdvertiseData;
import android.os.BatteryManager;
import android.os.ParcelUuid;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class BleUtil {
    public static final byte ADV_MODE_FAST_PAIR = 3;
    public static final byte ADV_MODE_FAST_PAIR_RESPONSE = 4;
    public static final byte ADV_MODE_FIND = 1;
    public static final byte ADV_MODE_GROUP_MSG = 5;
    public static final byte ADV_MODE_RESPONSE = 2;
    public static final String ALL_ZERO_ADDRESS = "00:00:00:00:00:00";
    public static final ParcelUuid BASE_UUID = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    public static final String DEFAULT_ADDRESS = "02:00:00:00:00:00";
    public static final ParcelUuid ICCOA_ADV_SERVICE_UUID = ParcelUuid.fromString("0000fcfb-0000-1000-8000-00805f9b34fb");
    public static final int MANU_ID = 3025;
    public static final int MANU_OTA_INTL_RING = 3028;
    public static final int MANU_OTA_RING = 3027;
    public static final int MANU_RESPONSE_ID = 3026;
    public static final ParcelUuid RING_SERVICE_UUID = ParcelUuid.fromString("00001812-0000-1000-8000-00805F9B34FB");
    private static final String TAG = "BleUtil";
    public static final byte[] TYPE_ALL = new byte[0];
    public static final ParcelUuid UUP_SHARE_ADV_SERVICE_UUID = ParcelUuid.fromString("00003331-0000-1000-8000-008123456789");
    public static final ParcelUuid UUP_SHARE_CONNECT_SERVICE_UUID = ParcelUuid.fromString("00009955-0000-1000-8000-00805f9b34fb");
    public static final ParcelUuid UUP_SHARE_READ_UUID = ParcelUuid.fromString("00009954-0000-1000-8000-00805f9b34fb");
    public static final ParcelUuid UUP_SHARE_SERVICE_DATA_UUID = ParcelUuid.fromString("000001B4-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid UUP_SHARE_SERVICE_RESPONSE_DATA_UUID = ParcelUuid.fromString("00000100-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid UUP_SHARE_WRITE_UUID = ParcelUuid.fromString("00009953-0000-1000-8000-00805f9b34fb");

    private BleUtil() {
    }

    public static boolean checkTypeNeedRsp(byte b, byte b2) {
        return (convertToAdvRspType(b) & b2) == 1;
    }

    public static boolean checkTypeNeedRspV3(byte b, byte[] bArr) {
        if (!ByteUtils.equals(bArr, AdvPackConstants.ADV_RSP_PHONE) || (b != 1 && b != 9)) {
            return ByteUtils.equals(bArr, AdvPackConstants.ADV_RSP_CAR) && b == 3;
        }
        return true;
    }

    public static byte convertToAdvRspType(byte b) {
        if (b != 1) {
            return b != 3 ? (byte) 0 : 2;
        }
        return 1;
    }

    public static byte[] dealDeviceId(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        int i = length - 1;
        for (int i2 = i; i2 >= 0; i2--) {
            bArr2[i - i2] = (byte) (~bArr[i2]);
        }
        return bArr2;
    }

    private static byte[] getAdvData(byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + 13);
        allocate.put(getLocalDeviceInfo());
        if (bArr != null) {
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static int getBatteryData() {
        if (StarryNetData.getInstance().getOwnDevice().getTerminalType() == 3) {
            return 0;
        }
        BatteryManager batteryManager = (BatteryManager) StarryNetData.getInstance().getApplicationContext().getSystemService("batterymanager");
        if (batteryManager == null) {
            StLog.e(TAG, "BatteryManager is null");
            return 0;
        }
        int intProperty = batteryManager.getIntProperty(4);
        StLog.d(TAG, "getBatteryData:" + intProperty);
        return intProperty;
    }

    public static String getBluetoothAddress() {
        String address = BluetoothAdapter.getDefaultAdapter().getAddress();
        return address == null ? DEFAULT_ADDRESS : address;
    }

    public static BluetoothDevice getBluetoothDevice(String str) {
        BluetoothAdapter defaultAdapter;
        if (BluetoothAdapter.checkBluetoothAddress(str) && (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) != null && defaultAdapter.isEnabled()) {
            return defaultAdapter.getRemoteDevice(str);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        r2 = r2[0];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFlymeUid(android.content.Context r2) {
        /*
            java.lang.String r0 = "account"
            java.lang.Object r2 = r2.getSystemService(r0)     // Catch:{ Exception -> 0x001b }
            android.accounts.AccountManager r2 = (android.accounts.AccountManager) r2     // Catch:{ Exception -> 0x001b }
            java.lang.String r0 = "com.meizu.account"
            android.accounts.Account[] r2 = r2.getAccountsByType(r0)     // Catch:{ Exception -> 0x001b }
            if (r2 == 0) goto L_0x0036
            int r0 = r2.length     // Catch:{ Exception -> 0x001b }
            if (r0 <= 0) goto L_0x0036
            r0 = 0
            r2 = r2[r0]     // Catch:{ Exception -> 0x001b }
            if (r2 == 0) goto L_0x0036
            java.lang.String r2 = r2.name     // Catch:{ Exception -> 0x001b }
            return r2
        L_0x001b:
            r2 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getFlymeUid error: "
            r0.append(r1)
            java.lang.String r2 = r2.getMessage()
            r0.append(r2)
            java.lang.String r2 = r0.toString()
            java.lang.String r0 = "BleUtil"
            android.util.Log.e(r0, r2)
        L_0x0036:
            java.lang.String r2 = ""
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.utils.BleUtil.getFlymeUid(android.content.Context):java.lang.String");
    }

    public static AdvertiseData getGroupMsgAdvData(byte b, int i) {
        return new AdvertiseData.Builder().addManufacturerData(3025, getGroupMsgManuData(b, i)).build();
    }

    public static AdvertiseData getGroupMsgAdvRspData(byte[] bArr) {
        return new AdvertiseData.Builder().addManufacturerData(MANU_RESPONSE_ID, bArr).build();
    }

    private static byte[] getGroupMsgManuData(byte b, int i) {
        byte[] bArr = {6, 5, 13, b};
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.put(bArr);
        allocate.putInt(i);
        return getAdvData(allocate.array());
    }

    public static byte[] getLocalDeviceInfo() {
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        byte[] bArr = new byte[13];
        bArr[0] = ownDevice.getVersion();
        System.arraycopy(Utils.hexString2Bytes(ownDevice.getCompanyID()), 0, bArr, 1, 2);
        System.arraycopy(Utils.hexString2Bytes(ownDevice.getCategoryID()), 0, bArr, 3, 2);
        System.arraycopy(Utils.hexString2Bytes(ownDevice.getModelID()), 0, bArr, 5, 2);
        byte[] bytesFromAddress = Utils.getBytesFromAddress(ownDevice.getBrEdrMac());
        if (bytesFromAddress.length > 0) {
            System.arraycopy(bytesFromAddress, 0, bArr, 7, 6);
        }
        return bArr;
    }

    public static AdvertiseData getUupShareAdvData() {
        byte[] bArr = new byte[6];
        System.arraycopy(StarryNetData.getInstance().getOwnDevice().getUupShareDeviceID(), 0, bArr, 0, 6);
        return new AdvertiseData.Builder().addServiceUuid(UUP_SHARE_ADV_SERVICE_UUID).addServiceData(UUP_SHARE_SERVICE_DATA_UUID, bArr).build();
    }

    public static AdvertiseData getUupShareAdvResponseData() {
        byte[] bArr = new byte[27];
        bArr[26] = 1;
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        System.arraycopy(ownDevice.getUupShareDeviceID(), 6, bArr, 0, 10);
        byte[] bytes = ownDevice.getDeviceName().getBytes(StandardCharsets.UTF_8);
        int i = 16;
        if (bytes.length <= 16) {
            i = bytes.length;
        }
        System.arraycopy(bytes, 0, bArr, 10, i);
        return new AdvertiseData.Builder().addServiceData(UUP_SHARE_SERVICE_RESPONSE_DATA_UUID, bArr).build();
    }
}
