package com.upuphone.starrynet.strategy.encrypt;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.encrypt.bean.DeviceTransferInfoV2;
import com.upuphone.starrynet.strategy.encrypt.bean.KeyPair;
import com.upuphone.starrynet.strategy.encrypt.bean.MasterKeyV2;
import com.upuphone.starrynet.strategy.encrypt.utils.EncryptionUtil;
import java.util.Base64;

public class StarryNetDecryptHelperV2 {
    private static final String TAG = "StarryNetDecryptHelperV2";

    private StarryNetDecryptHelperV2() {
    }

    public static MasterKeyV2 parseMasterInfo(byte[] bArr) {
        try {
            return (MasterKeyV2) new Gson().fromJson(new String(bArr), MasterKeyV2.class);
        } catch (Exception e) {
            StLog.d(TAG, "parseMasterInfo error: ", (Throwable) e);
            return null;
        }
    }

    public static DeviceTransferInfoV2 parseSlaveKey(byte[] bArr) {
        DeviceTransferInfoV2 deviceTransferInfoV2 = (DeviceTransferInfoV2) new Gson().fromJson(new String(bArr), DeviceTransferInfoV2.class);
        if (deviceTransferInfoV2 == null) {
            return null;
        }
        if (TextUtils.isEmpty(deviceTransferInfoV2.getKey())) {
            return deviceTransferInfoV2;
        }
        StLog.d(TAG, "clientKeyV2 before:" + deviceTransferInfoV2);
        KeyPair keyPairV2 = StarryNetEncryptData.getInstance().getKeyPairV2();
        String ivParamV2 = StarryNetEncryptData.getInstance().getIvParamV2();
        byte[] decode = Base64.getDecoder().decode(deviceTransferInfoV2.getKey());
        byte[] secretKey = EncryptionUtil.getSecretKey(decode, keyPairV2.getPrivateKey());
        String str = new String(EncryptionUtil.decryptCTR(Base64.getDecoder().decode(deviceTransferInfoV2.getMac()), secretKey, ivParamV2.getBytes()));
        String str2 = new String(EncryptionUtil.decryptCTR(Base64.getDecoder().decode(deviceTransferInfoV2.getSsid()), secretKey, ivParamV2.getBytes()));
        String str3 = new String(EncryptionUtil.decryptCTR(Base64.getDecoder().decode(deviceTransferInfoV2.getPsk()), secretKey, ivParamV2.getBytes()));
        deviceTransferInfoV2.setMac(str);
        deviceTransferInfoV2.setSsid(str2);
        deviceTransferInfoV2.setPsk(str3);
        deviceTransferInfoV2.setKey(new String(decode));
        return deviceTransferInfoV2;
    }
}
