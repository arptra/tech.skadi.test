package com.upuphone.starrynet.strategy.discovery.advertiser.pack.v3;

import android.bluetooth.le.AdvertiseData;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.strategy.discovery.advertiser.codec.AdvEncoder;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.base.AbsAdvPackHelper;
import com.upuphone.starrynet.strategy.utils.BleUtil;

public class AdvertisePackHelperV3 extends AbsAdvPackHelper {
    public static final int ADV_ACTIVE_NO_WINDOW_DISCOVERY_CAR = 12;
    public static final int ADV_ACTIVE_NO_WINDOW_DISCOVERY_PHONE = 11;
    public static final int ADV_ACTIVE_NO_WINDOW_DISCOVERY_PHONE_CAR = 13;
    public static final int ADV_ACTIVE_WINDOW_CAR = 2;
    public static final int ADV_ACTIVE_WINDOW_PHONE = 1;
    public static final int ADV_ACTIVE_WINDOW_PHONE_CAR = 3;
    public static final int ADV_CONNECT_PHONE_DISPATCH = 31;
    public static final int ADV_NOTIFY_STARRYNET_CAR_DISPATCH = 42;
    public static final int ADV_NOTIFY_STARRYNET_PHONE_DISPATCH = 41;
    public static final int ADV_NOTIFY_THIRD_CAR_DISPATCH = 52;
    public static final int ADV_NOTIFY_THIRD_PHONE_DISPATCH = 51;
    public static final int ADV_PASSIVE_NO_WINDOW_CAR_DISPATCH = 24;
    public static final int ADV_PASSIVE_NO_WINDOW_PHONE_DISPATCH = 23;
    public static final int ADV_PASSIVE_WINDOW_CAR_DISPATCH = 22;
    public static final int ADV_PASSIVE_WINDOW_PHONE_DISPATCH = 21;
    public static final int ADV_RECONNECT = 33;
    private static final String TAG = "AdvertisePackHelperV3";
    private short mAbility = -1;
    private byte[] mUserId = new byte[7];

    public AdvertiseData getAdvertiseData(int i, int i2) {
        return new AdvertiseData.Builder().addManufacturerData(3025, AdvEncoder.buildAdv(i, i2)).build();
    }

    public AdvertiseData getRspAdvertiseData(int i) {
        return getRspAdvertiseData(i, (byte[]) null);
    }

    public boolean initUserId(byte[] bArr) {
        if (bArr == null || bArr.length > 7) {
            StLog.d(TAG, "initUserId param not allow!");
            return false;
        } else if (!ByteUtils.byteEquals(bArr, this.mUserId)) {
            System.arraycopy(bArr, 0, this.mUserId, 0, bArr.length);
            return true;
        } else {
            StLog.d(TAG, "initUserId equals, not need update!");
            return false;
        }
    }

    public void setAbility(short s) {
        this.mAbility = s;
    }

    public AdvertiseData getRspAdvertiseData(int i, byte[] bArr) {
        return new AdvertiseData.Builder().addManufacturerData(BleUtil.MANU_RESPONSE_ID, AdvEncoder.buildResponseAdv(i, bArr, this.mAbility, this.mUserId)).build();
    }
}
