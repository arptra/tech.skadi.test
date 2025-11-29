package com.upuphone.starrynet.strategy.encrypt;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.encrypt.bean.DeviceTransferInfoV2;
import com.upuphone.starrynet.strategy.encrypt.bean.KeyPair;
import com.upuphone.starrynet.strategy.encrypt.bean.MasterKeyV2;
import com.upuphone.starrynet.strategy.encrypt.utils.EncryptionUtil;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class StarryNetEncryptHelperV2 {
    private static final String TAG = "StarryNetEncryptHelperV";

    private StarryNetEncryptHelperV2() {
    }

    public static byte[] getMasterKey(String str) {
        KeyPair generatorECKeyPair = EncryptionUtil.generatorECKeyPair();
        if (generatorECKeyPair == null) {
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("mac", str);
        jsonObject.addProperty("state", (Number) Integer.valueOf(StarryNetData.getInstance().isUupBusy() ? 1 : 0));
        jsonObject.addProperty(IntentKey.ACTIVITY.ACTION_KEY, Base64.getEncoder().encodeToString(generatorECKeyPair.getPublicKey()));
        StarryNetEncryptData.getInstance().setKeyPairV2(generatorECKeyPair);
        return jsonObject.toString().getBytes();
    }

    public static String getMasterKey(MasterKeyV2 masterKeyV2, byte[] bArr, String str, int i, int i2, String str2, String str3) {
        DeviceTransferInfoV2 deviceTransferInfoV2;
        byte[] secretKey;
        if (masterKeyV2 == null) {
            return null;
        }
        if (TextUtils.isEmpty(masterKeyV2.getKey())) {
            deviceTransferInfoV2 = new DeviceTransferInfoV2();
            deviceTransferInfoV2.setId(new String(bArr));
            deviceTransferInfoV2.setMac(str);
            deviceTransferInfoV2.setPort(i);
            deviceTransferInfoV2.setFreq(i2);
            deviceTransferInfoV2.setSsid(str2);
            deviceTransferInfoV2.setPsk(str3);
        } else {
            byte[] decode = Base64.getDecoder().decode(masterKeyV2.getKey());
            KeyPair generateECKeyPairByPublicKey = EncryptionUtil.generateECKeyPairByPublicKey(decode);
            if (generateECKeyPairByPublicKey == null || (secretKey = EncryptionUtil.getSecretKey(decode, generateECKeyPairByPublicKey.getPrivateKey())) == null) {
                deviceTransferInfoV2 = null;
            } else {
                DeviceTransferInfoV2 deviceTransferInfoV22 = new DeviceTransferInfoV2();
                deviceTransferInfoV22.setId(new String(bArr));
                deviceTransferInfoV22.setPort(i);
                deviceTransferInfoV22.setFreq(i2);
                String ivParamV2 = StarryNetEncryptData.getInstance().getIvParamV2();
                deviceTransferInfoV22.setMac(Base64.getEncoder().encodeToString(EncryptionUtil.encryptCTR(str.getBytes(StandardCharsets.UTF_8), secretKey, ivParamV2.getBytes())));
                deviceTransferInfoV22.setSsid(Base64.getEncoder().encodeToString(EncryptionUtil.encryptCTR(str2.getBytes(), secretKey, ivParamV2.getBytes())));
                deviceTransferInfoV22.setPsk(Base64.getEncoder().encodeToString(EncryptionUtil.encryptCTR(str3.getBytes(), secretKey, ivParamV2.getBytes())));
                deviceTransferInfoV22.setKey(Base64.getEncoder().encodeToString(generateECKeyPairByPublicKey.getPublicKey()));
                deviceTransferInfoV2 = deviceTransferInfoV22;
            }
        }
        if (deviceTransferInfoV2 == null) {
            return null;
        }
        String json = new Gson().toJson((Object) deviceTransferInfoV2);
        StLog.d(TAG, "generate : " + json);
        return json;
    }
}
