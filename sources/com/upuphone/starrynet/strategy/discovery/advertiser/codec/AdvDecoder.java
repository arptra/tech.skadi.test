package com.upuphone.starrynet.strategy.discovery.advertiser.codec;

import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.utils.BleUtil;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class AdvDecoder {
    private static final String TAG = "AdvDecoder";

    public static boolean decodeAdvData(StDiscoveryDevice stDiscoveryDevice, byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        byte b = wrap.get();
        stDiscoveryDevice.setVersion(b);
        decodeCommonDeviceInfo(stDiscoveryDevice, wrap);
        return decodeTLVData(b, stDiscoveryDevice, wrap);
    }

    private static void decodeCommonDeviceInfo(StDiscoveryDevice stDiscoveryDevice, ByteBuffer byteBuffer) {
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        String bytes2HexString = Utils.bytes2HexString(bArr);
        stDiscoveryDevice.setCompanyID(bytes2HexString);
        stDiscoveryDevice.setCompanyName(StarryNetData.getInstance().getCompanyName(bytes2HexString));
        byte[] bArr2 = new byte[2];
        byteBuffer.get(bArr2);
        String bytes2HexString2 = Utils.bytes2HexString(bArr2);
        stDiscoveryDevice.setCategoryID(bytes2HexString2);
        stDiscoveryDevice.setCategoryName(StarryNetData.getInstance().getCategoryName(bytes2HexString2));
        byte[] bArr3 = new byte[2];
        byteBuffer.get(bArr3);
        String bytes2HexString3 = Utils.bytes2HexString(bArr3);
        stDiscoveryDevice.setModelID(bytes2HexString3);
        stDiscoveryDevice.setModelName(StarryNetData.getInstance().getModelName(bytes2HexString3));
        byte[] bArr4 = new byte[6];
        byteBuffer.get(bArr4);
        stDiscoveryDevice.setIdentifier(BleUtil.dealDeviceId(bArr4));
    }

    public static boolean decodeResponseData(StDiscoveryDevice stDiscoveryDevice, byte[] bArr) {
        return decodeTLVData(stDiscoveryDevice.getVersion(), stDiscoveryDevice, ByteBuffer.wrap(bArr));
    }

    private static boolean decodeTLVData(byte b, StDiscoveryDevice stDiscoveryDevice, ByteBuffer byteBuffer) {
        if (b == 1) {
            return decodeV1Data(stDiscoveryDevice, byteBuffer);
        }
        if (b >= 2) {
            return decodeV2PlusData(stDiscoveryDevice, byteBuffer);
        }
        StLog.e(TAG, "not support adv version:" + b);
        return false;
    }

    private static boolean decodeV1Data(StDiscoveryDevice stDiscoveryDevice, ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            int baseTypeLength = AdvCodes.getBaseTypeLength(b);
            if (baseTypeLength <= 0) {
                StLog.e(TAG, "decodeV1Data not support adv type :" + b);
                return false;
            }
            byte[] bArr = new byte[baseTypeLength];
            if (byteBuffer.remaining() < baseTypeLength) {
                return false;
            }
            byteBuffer.get(bArr);
            stDiscoveryDevice.getDeviceDetail().put(Byte.valueOf(b), bArr);
            if (b == 12) {
                stDiscoveryDevice.setBeaconId(bArr[0]);
            } else if (b == 10) {
                stDiscoveryDevice.setDeviceName(new String(bArr, StandardCharsets.UTF_8));
            } else if (b == 15) {
                stDiscoveryDevice.setUserData(bArr);
            }
        }
        return true;
    }

    private static boolean decodeV2PlusData(StDiscoveryDevice stDiscoveryDevice, ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            int v2TypeLength = AdvCodes.getV2TypeLength(b);
            if (v2TypeLength == -2) {
                return false;
            }
            if (v2TypeLength == 0) {
                v2TypeLength = byteBuffer.remaining();
            } else if (v2TypeLength == -1) {
                v2TypeLength = byteBuffer.get();
            }
            if (v2TypeLength < 0 || byteBuffer.remaining() < v2TypeLength) {
                return false;
            }
            byte[] bArr = new byte[v2TypeLength];
            byteBuffer.get(bArr);
            if (b == 19) {
                String str = new String(bArr, StandardCharsets.UTF_8);
                if (str.endsWith(" ")) {
                    str = str.trim() + "...";
                }
                stDiscoveryDevice.setDeviceName(str);
            } else if (b == 20) {
                if (v2TypeLength > 5) {
                    StLog.e(TAG, "extra name len error");
                    return false;
                }
                stDiscoveryDevice.setRingName(bArr, false);
            } else if (b == 5) {
                stDiscoveryDevice.setBeaconId(bArr[0]);
            } else if (b == 6 || b == 18) {
                try {
                    stDiscoveryDevice.setDeviceName(new String(bArr, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    stDiscoveryDevice.setDeviceName(new String(bArr));
                }
            } else if (b == 22) {
                stDiscoveryDevice.setRegion(bArr[0]);
            } else {
                if (b == 21) {
                    stDiscoveryDevice.setConnectVersion(3);
                }
                stDiscoveryDevice.getDeviceDetail().put(Byte.valueOf(b), bArr);
            }
        }
        return true;
    }
}
