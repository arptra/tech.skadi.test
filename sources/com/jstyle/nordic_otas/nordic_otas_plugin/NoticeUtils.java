package com.jstyle.nordic_otas.nordic_otas_plugin;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.uupcast.CaptureType;

public class NoticeUtils {
    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";

    public static String getMacAdd(@NonNull String str) {
        String substring = str.substring(0, 15);
        String format = String.format("%02X", new Object[]{Integer.valueOf((Integer.valueOf(str.substring(15), 16).intValue() + 1) & 255)});
        return (substring + format).toUpperCase();
    }

    public static String getMacMinus(@NonNull String str) {
        String substring = str.substring(0, 15);
        String format = String.format("%02X", new Object[]{Integer.valueOf((Integer.valueOf(str.substring(15), 16).intValue() - 1) & 255)});
        return (substring + format).toUpperCase();
    }

    public static boolean isEnabledNotification(Context context) {
        String packageName = context.getPackageName();
        String string = Settings.Secure.getString(context.getContentResolver(), ENABLED_NOTIFICATION_LISTENERS);
        if (!TextUtils.isEmpty(string)) {
            String[] split = string.split(AccountConstantKt.CODE_SEPARTOR);
            for (String unflattenFromString : split) {
                ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                if (unflattenFromString2 != null && TextUtils.equals(packageName, unflattenFromString2.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void setting(Context context) {
        Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
        intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        context.startActivity(intent);
    }
}
