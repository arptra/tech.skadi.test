package com.upuphone.starrynet.strategy.discovery.fastpair;

import android.content.Context;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import com.upuphone.starrynet.api.StConstant;
import com.upuphone.starrynet.common.StLog;

public final class FastPairUtil {
    public static final int ERROR_CODE_CONNECT_PARAM_ERROR = 2;
    public static final int ERROR_CODE_CONNECT_TIMEOUT = 1;
    public static final int MESSAGE_AUTO_CONNECT_TIMEOUT = 9;
    public static final int MESSAGE_BOND_FAILED = 6;
    public static final int MESSAGE_BOND_OK = 5;
    public static final int MESSAGE_CLASSIC_BOND = 7;
    public static final int MESSAGE_CLICK_CANCEL = 4;
    public static final int MESSAGE_CLICK_CONNECT = 3;
    public static final int MESSAGE_CLICK_RECONNECT = 13;
    public static final int MESSAGE_CONNECT_FAIL = 12;
    public static final int MESSAGE_CONNECT_TIMEOUT = 8;
    public static final int MESSAGE_DISMISS_WINDOW = 2;
    public static final int MESSAGE_DISPATCH_TO_APP = 10;
    public static final int MESSAGE_REMOVE_BOND = 11;
    public static final int MESSAGE_SHOW_WINDOW = 1;
    public static final String SETTING_KEY_FAST_PAIR = "setting_fast_pair";
    private static final String TAG = "FastPairUtil";

    public static String getFastPairFlag(Context context) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.WRITE_SECURE_SETTINGS") == 0) {
            return Settings.Global.getString(context.getContentResolver(), SETTING_KEY_FAST_PAIR);
        }
        StLog.w(TAG, "getFastPairFlag no permission");
        return null;
    }

    public static int getPrivacyPolicyFlag(Context context) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.WRITE_SECURE_SETTINGS") != 0) {
            StLog.w(TAG, "getPrivacyPolicyFlag no permission");
            return 0;
        }
        int i = Settings.Global.getInt(context.getContentResolver(), StConstant.SETTING_PRIVACY_POLICY, 0);
        StLog.d(TAG, "getPrivacyPolicyFlag, flag = " + i);
        return i;
    }

    public static void saveFastPairFlag(Context context, String str) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.WRITE_SECURE_SETTINGS") != 0) {
            StLog.w(TAG, "saveFastPairFlag no permission");
        } else {
            Settings.Global.putString(context.getContentResolver(), SETTING_KEY_FAST_PAIR, str);
        }
    }

    public static void savePrivacyPolicyFlag(Context context, int i) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.WRITE_SECURE_SETTINGS") != 0) {
            StLog.w(TAG, "savePrivacyPolicyFlag no permission");
            return;
        }
        StLog.d(TAG, "savePrivacyPolicyFlag, flag = " + i);
        if (getPrivacyPolicyFlag(context) != i) {
            Settings.Global.putInt(context.getContentResolver(), StConstant.SETTING_PRIVACY_POLICY, i);
        }
    }
}
