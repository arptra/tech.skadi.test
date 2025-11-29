package com.fm.sdk.deviceid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.xjsd.ai.assistant.protocol.AssistantConstants;

public class DeviceId {

    /* renamed from: a  reason: collision with root package name */
    public static String f2830a;
    public static String b;
    public static long c;
    public static int d;

    public static String getAaid(Context context) {
        return b.a().h();
    }

    public static String getAndroidId(Context context) {
        return Settings.System.getString(context.getContentResolver(), "android_id");
    }

    public static String getImei(Context context) {
        return "";
    }

    @SuppressLint({"NewApi"})
    public static String getMaid(Context context) {
        if (TextUtils.isEmpty(f2830a)) {
            f2830a = d.a(context);
        }
        return f2830a;
    }

    public static String getOaid(Context context) {
        if ((TextUtils.equals("00000000000000000000000000000000", b) || TextUtils.isEmpty(b)) && System.currentTimeMillis() - c > AssistantConstants.TIMEOUT_VAD_MUTE) {
            int i = d;
            d = i + 1;
            if (i < 5) {
                init(context);
                b = "";
            }
        }
        if (TextUtils.isEmpty(b)) {
            String f = b.a().f();
            b = f;
            if (TextUtils.isEmpty(f) && "sony".equalsIgnoreCase(Build.BRAND)) {
                String a2 = c.a(context);
                b = a2;
                if (TextUtils.isEmpty(a2)) {
                    try {
                        b = Settings.System.getString(context.getContentResolver(), "fm.maid");
                    } catch (Exception unused) {
                    }
                }
            }
            c = System.currentTimeMillis();
        }
        if (TextUtils.equals("00000000000000000000000000000000", b)) {
            return null;
        }
        return b;
    }

    public static String getSn() {
        return "";
    }

    public static String getVaid(Context context) {
        return b.a().g();
    }

    public static void init(Context context) {
        b.a().b(context);
    }

    public static boolean isSupported() {
        return b.a().e();
    }
}
