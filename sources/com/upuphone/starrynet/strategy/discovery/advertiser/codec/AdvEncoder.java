package com.upuphone.starrynet.strategy.discovery.advertiser.codec;

import android.text.TextUtils;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.utils.BleUtil;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class AdvEncoder {
    private static final int MAX_RSP_DATA_LEN = 25;
    private static final String TAG = "AdvEncoder";

    private static byte[] buffer2Bytes(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.position()];
        byteBuffer.flip();
        byteBuffer.get(bArr);
        return bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] buildAdv(int r10, int r11) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "buildAdv, adType="
            r0.append(r1)
            r0.append(r10)
            java.lang.String r1 = ",beaconID="
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "AdvEncoder"
            com.upuphone.starrynet.common.StLog.d(r1, r0)
            r0 = 31
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r0)
            com.upuphone.starrynet.strategy.StarryNetData r3 = com.upuphone.starrynet.strategy.StarryNetData.getInstance()
            com.upuphone.starrynet.api.bean.StDevice r3 = r3.getOwnDevice()
            putDeviceBaseInfo(r3, r2)
            r4 = 0
            r5 = 33
            if (r10 == r5) goto L_0x004b
            boolean r6 = r3.isBleConnected()
            if (r6 != 0) goto L_0x0043
            boolean r6 = r3.isP2pConnected()
            if (r6 == 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r6 = r4
            goto L_0x0044
        L_0x0043:
            r6 = 2
        L_0x0044:
            r7 = 4
            r2.put(r7)
            r2.put(r6)
        L_0x004b:
            r6 = 5
            r2.put(r6)
            byte r11 = (byte) r11
            r2.put(r11)
            r11 = 11
            r6 = 144(0x90, float:2.02E-43)
            r7 = 21
            r8 = 1
            if (r10 == r11) goto L_0x00ae
            r11 = 12
            if (r10 == r11) goto L_0x00a9
            if (r10 == r7) goto L_0x00a4
            if (r10 == r0) goto L_0x009f
            r11 = 0
            if (r10 == r5) goto L_0x009c
            r0 = 42
            if (r10 == r0) goto L_0x0098
            r0 = 23
            r5 = 176(0xb0, float:2.47E-43)
            if (r10 == r0) goto L_0x0093
            r0 = 24
            if (r10 == r0) goto L_0x008e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "getAdvertiseData error type:"
            r0.append(r5)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            com.upuphone.starrynet.common.StLog.d(r1, r10)
            r10 = -1
        L_0x008a:
            r9 = r4
            r4 = r10
            r10 = r9
            goto L_0x00b2
        L_0x008e:
            byte[] r11 = com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants.ADV_RSP_CAR_DISPATCH
            r4 = r5
        L_0x0091:
            r10 = r8
            goto L_0x00b2
        L_0x0093:
            byte[] r11 = com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants.ADV_RSP_PHONE_DISPATCH
            r10 = r4
            r4 = r5
            goto L_0x00b2
        L_0x0098:
            byte[] r11 = com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants.ADV_RSP_CAR_DISPATCH
            r10 = r4
            goto L_0x00b2
        L_0x009c:
            r4 = 64
            goto L_0x0091
        L_0x009f:
            byte[] r11 = com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants.ADV_RSP_PHONE_DISPATCH
            r10 = 208(0xd0, float:2.91E-43)
            goto L_0x008a
        L_0x00a4:
            byte[] r11 = com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants.ADV_RSP_PHONE_DISPATCH
            r10 = 160(0xa0, float:2.24E-43)
            goto L_0x008a
        L_0x00a9:
            byte[] r11 = com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants.ADV_RSP_CAR
            r10 = r4
            r4 = r6
            goto L_0x00b2
        L_0x00ae:
            byte[] r11 = com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants.ADV_RSP_PHONE
            r4 = r6
            goto L_0x0091
        L_0x00b2:
            if (r4 <= 0) goto L_0x00bb
            r2.put(r8)
            byte r0 = (byte) r4
            r2.put(r0)
        L_0x00bb:
            if (r11 == 0) goto L_0x00c5
            r0 = 16
            r2.put(r0)
            r2.put(r11)
        L_0x00c5:
            if (r10 == 0) goto L_0x00d1
            r2.put(r7)
            byte r10 = getUpgradeData(r3)
            r2.put(r10)
        L_0x00d1:
            byte[] r10 = buffer2Bytes(r2)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "packAdvertiser:"
            r11.append(r0)
            java.lang.String r0 = com.upuphone.starrynet.common.utils.ByteUtils.toHexString(r10)
            r11.append(r0)
            java.lang.String r0 = ",length="
            r11.append(r0)
            int r0 = r10.length
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            com.upuphone.starrynet.common.StLog.d(r1, r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.discovery.advertiser.codec.AdvEncoder.buildAdv(int, int):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0079, code lost:
        if (r7 != null) goto L_0x00a6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] buildResponseAdv(int r6, byte[] r7, short r8, byte[] r9) {
        /*
            r0 = 25
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "buildResponseAdv:"
            r2.append(r3)
            r2.append(r6)
            java.lang.String r4 = ",connectParams:"
            r2.append(r4)
            java.lang.String r4 = com.upuphone.starrynet.common.utils.ByteUtils.byteToString(r7)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "AdvEncoder"
            com.upuphone.starrynet.common.StLog.d(r4, r2)
            r2 = 15
            r1.put(r2)
            byte r2 = getOwnBondState()
            r1.put(r2)
            if (r8 <= 0) goto L_0x0042
            r2 = 14
            r1.put(r2)
            byte[] r8 = com.upuphone.starrynet.common.utils.ByteUtils.fromShort(r8)
            r1.put(r8)
        L_0x0042:
            r8 = 11
            r2 = 1
            r5 = 0
            if (r6 == r8) goto L_0x0097
            r8 = 12
            if (r6 == r8) goto L_0x0097
            r8 = 21
            if (r6 == r8) goto L_0x0097
            r8 = 31
            if (r6 == r8) goto L_0x007c
            r8 = 33
            if (r6 == r8) goto L_0x007c
            r8 = 42
            if (r6 == r8) goto L_0x0079
            r7 = 23
            if (r6 == r7) goto L_0x0097
            r7 = 24
            if (r6 == r7) goto L_0x0097
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "getRspAdvertiseData error type:"
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.upuphone.starrynet.common.StLog.d(r4, r6)
            goto L_0x00a5
        L_0x0079:
            if (r7 == 0) goto L_0x00a5
            goto L_0x00a6
        L_0x007c:
            if (r7 == 0) goto L_0x00a5
            byte[] r6 = com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvertisePackUtil.getDeviceId(r7)
            r8 = 17
            r1.put(r8)
            r1.put(r6)
            int r6 = r7.length
            r8 = 7
            if (r6 != r8) goto L_0x00a5
            byte[] r6 = new byte[r2]
            r8 = 0
            byte r7 = r7[r8]
            r6[r8] = r7
            r7 = r6
            goto L_0x00a6
        L_0x0097:
            boolean r6 = com.upuphone.starrynet.common.utils.ByteUtils.isAllMin(r9)
            if (r6 != 0) goto L_0x00a5
            r6 = 8
            r1.put(r6)
            r1.put(r9)
        L_0x00a5:
            r7 = r5
        L_0x00a6:
            int r6 = r1.position()
            int r0 = r0 - r6
            if (r7 == 0) goto L_0x00b0
            int r6 = r7.length
            int r0 = r0 - r6
            int r0 = r0 - r2
        L_0x00b0:
            int r0 = r0 - r2
            byte[] r6 = getDeviceName(r0)
            r8 = 19
            r1.put(r8)
            r1.put(r6)
            if (r7 == 0) goto L_0x00c6
            r6 = -1
            r1.put(r6)
            r1.put(r7)
        L_0x00c6:
            byte[] r6 = buffer2Bytes(r1)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r3)
            java.lang.String r8 = com.upuphone.starrynet.common.utils.ByteUtils.toHexString(r6)
            r7.append(r8)
            java.lang.String r8 = ",length="
            r7.append(r8)
            int r8 = r6.length
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.upuphone.starrynet.common.StLog.d(r4, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.discovery.advertiser.codec.AdvEncoder.buildResponseAdv(int, byte[], short, byte[]):byte[]");
    }

    public static byte[] getDeviceName(int i) {
        String trim = StarryNetData.getInstance().getOwnDevice().getDeviceName().trim();
        if (TextUtils.isEmpty(trim)) {
            trim = "AR Glass";
        }
        byte[] bytes = trim.getBytes(StandardCharsets.UTF_8);
        int length = bytes.length;
        if (length < i) {
            return ByteUtils.append(new byte[]{(byte) bytes.length}, bytes);
        }
        while (length > i - 2) {
            trim = trim.substring(0, trim.length() - 1);
            bytes = trim.getBytes(StandardCharsets.UTF_8);
            length = bytes.length;
        }
        byte[] bArr = new byte[(length + 2)];
        int i2 = length + 1;
        bArr[0] = (byte) i2;
        System.arraycopy(bytes, 0, bArr, 1, length);
        bArr[i2] = 32;
        return bArr;
    }

    public static byte getOwnBondState() {
        StConnectDevice curBondInfo = StarryDeviceManager.getInstance().getCurBondInfo();
        if (curBondInfo == null) {
            return 0;
        }
        return (byte) curBondInfo.getBleBondStatus();
    }

    public static byte getUpgradeData(StDevice stDevice) {
        if (StarryNetData.getInstance().getOwnDevice().getTerminalType() != 3 || !StarryNetData.getInstance().getDiscoveryManager().isCarActiveDisconnectPad()) {
            return 0;
        }
        return (byte) 1;
    }

    private static void putDeviceBaseInfo(StDevice stDevice, ByteBuffer byteBuffer) {
        byteBuffer.put(stDevice.getVersion());
        byteBuffer.put(Utils.hexString2Bytes(stDevice.getCompanyID()));
        byteBuffer.put(Utils.hexString2Bytes(stDevice.getCategoryID()));
        byteBuffer.put(Utils.hexString2Bytes(stDevice.getModelID()));
        byteBuffer.put(BleUtil.dealDeviceId(Utils.getBytesFromAddress(stDevice.getBrEdrMac())));
    }
}
