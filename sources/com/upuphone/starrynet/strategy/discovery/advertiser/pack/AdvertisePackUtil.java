package com.upuphone.starrynet.strategy.discovery.advertiser.pack;

import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import java.util.Arrays;

public class AdvertisePackUtil {
    public static final int LENGTH_BASE_INFO = 13;
    private static final String TAG = "AdvertisePackUtil";

    public static byte[] getDeviceId(byte[] bArr) {
        if (bArr.length == 6) {
            return bArr;
        }
        if (bArr.length == 7) {
            return Arrays.copyOfRange(bArr, 1, 7);
        }
        return null;
    }

    public static byte[] getNotifyData(int i, byte[] bArr) {
        if (i != 1) {
            StLog.d(TAG, "getNotifyData with unknown type");
            return new byte[0];
        }
        byte[] bArr2 = new byte[7];
        bArr2[0] = (byte) i;
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        return bArr2;
    }

    public static byte[] getPeerMac(StDiscoveryDevice stDiscoveryDevice) {
        byte version = stDiscoveryDevice.getVersion();
        if (version == 1) {
            return stDiscoveryDevice.getDeviceDetail().get((byte) 11);
        }
        if (version != 2) {
            return stDiscoveryDevice.getDeviceDetail().get((byte) 17);
        }
        byte[] bArr = stDiscoveryDevice.getDeviceDetail().get((byte) 3);
        return Arrays.copyOfRange(bArr, 1, bArr.length);
    }
}
