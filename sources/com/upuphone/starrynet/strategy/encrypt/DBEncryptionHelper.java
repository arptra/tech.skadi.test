package com.upuphone.starrynet.strategy.encrypt;

import android.text.TextUtils;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.core.database.dao.BondInfo;
import com.upuphone.starrynet.strategy.encrypt.utils.EncryptionUtil;

public class DBEncryptionHelper {
    private static final int IV_SIZE = 16;
    private static final String TAG = "DBEncryptionHelper";

    private DBEncryptionHelper() {
    }

    public static BondInfo decryptBondInfo(BondInfo bondInfo) {
        byte[] cipher = bondInfo.getCipher();
        if (cipher != null && cipher.length > 16) {
            try {
                byte[] subArray = ByteUtils.subArray(cipher, cipher.length - 16);
                byte[] subArray2 = ByteUtils.subArray(cipher, 0, cipher.length - 16);
                if (!TextUtils.isEmpty(bondInfo.getBrEdrMac())) {
                    bondInfo.setBrEdrMac(new String(EncryptionUtil.decrypt(ByteUtils.fromHexString(bondInfo.getBrEdrMac()), subArray2, subArray)));
                }
            } catch (Exception e) {
                StLog.e(TAG, "decryptBondInfo", (Throwable) e);
            }
        }
        StLog.d(TAG, "decryptBondInfo after:" + bondInfo);
        return bondInfo;
    }

    public static BondInfo encryptBondInfo(BondInfo bondInfo) {
        BondInfo clone = bondInfo.clone();
        byte[] cipher = clone.getCipher();
        if (cipher != null && cipher.length > 16) {
            try {
                byte[] subArray = ByteUtils.subArray(cipher, cipher.length - 16);
                byte[] subArray2 = ByteUtils.subArray(cipher, 0, cipher.length - 16);
                if (!TextUtils.isEmpty(clone.getBrEdrMac())) {
                    clone.setBrEdrMac(ByteUtils.toHexString(EncryptionUtil.encrypt(clone.getBrEdrMac().getBytes(), subArray2, subArray)));
                }
            } catch (Exception e) {
                StLog.e(TAG, "encryptBondInfo", (Throwable) e);
            }
        }
        return clone;
    }
}
