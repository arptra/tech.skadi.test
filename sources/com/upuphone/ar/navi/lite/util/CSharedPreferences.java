package com.upuphone.ar.navi.lite.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.ar.navi.lite.manger.StarryNetManger;
import com.upuphone.ar.navi.lite.protocol.ProtocolUtils;
import com.upuphone.xr.interconnect.listener.SendMessageListener;

public final class CSharedPreferences {
    public static String a(Context context) {
        return context != null ? context.getSharedPreferences(context.getPackageName(), 0).getString("account_id", "") : "";
    }

    public static boolean b(Context context, String str, boolean z) {
        return context.getSharedPreferences(k(context), 0).getBoolean(str, z);
    }

    public static String c(Context context) {
        return context.getSharedPreferences(k(context), 0).getString("car_license", "");
    }

    public static int d(Context context) {
        return context.getSharedPreferences(k(context), 0).getInt("car_type", -1);
    }

    public static int e(Context context) {
        return context.getSharedPreferences(k(context), 0).getInt("navi_displat_pos", 1);
    }

    public static int f(Context context, String str, int i) {
        return context.getSharedPreferences(k(context), 0).getInt(str, i);
    }

    public static long g(Context context, String str, long j) {
        return context.getSharedPreferences(k(context), 0).getLong(str, j);
    }

    public static Boolean h(Context context) {
        return Boolean.valueOf(context.getSharedPreferences(context.getPackageName(), 0).getBoolean("navi_migrated", false));
    }

    public static String i(Context context) {
        return context != null ? context.getSharedPreferences(context.getPackageName(), 0).getString("navi_country_code", "") : "";
    }

    public static int j(Context context) {
        return context.getSharedPreferences(k(context), 0).getInt("navi_mode", 3);
    }

    public static String k(Context context) {
        String t = NaviUtil.t();
        if (TextUtils.isEmpty(t)) {
            return "navi_preferences";
        }
        return t + AccountConstantKt.DEFAULT_SEGMENT + "navi_preferences";
    }

    public static String l(Context context, String str, String str2) {
        return context.getSharedPreferences(k(context), 0).getString(str, str2);
    }

    public static boolean m(Context context) {
        return context.getSharedPreferences(k(context), 0).getBoolean("voice_state", true);
    }

    public static void n(Context context, String str) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName(), 0).edit();
            edit.putString("account_id", str);
            edit.apply();
        }
    }

    public static void o(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(k(context), 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static void p(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(k(context), 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
        String str2 = "0";
        if ("msg_mask".equalsIgnoreCase(str)) {
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.a("maskMsg", !z ? "1" : str2), (SendMessageListener) null);
        }
        if ("navi_brightness".equalsIgnoreCase(str)) {
            if (z) {
                str2 = "1";
            }
            StarryNetManger.getInstance().sendMessage(ProtocolUtils.a("brightness_state", str2), (SendMessageListener) null);
        }
    }

    public static void q(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences(k(context), 0).edit();
        edit.putString("car_license", str);
        edit.apply();
    }

    public static void r(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(k(context), 0).edit();
        edit.putInt("car_type", i);
        edit.apply();
    }

    public static void s(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(k(context), 0).edit();
        edit.putInt("navi_displat_pos", i);
        edit.apply();
        StarryNetManger.getInstance().sendMessage(ProtocolUtils.a("displayPos", i + ""), (SendMessageListener) null);
    }

    public static void t(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(k(context), 0).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public static void u(Context context, String str, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences(k(context), 0).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static void v(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName(), 0).edit();
        edit.putBoolean("navi_migrated", z);
        edit.apply();
    }

    public static void w(Context context, String str) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName(), 0).edit();
            edit.putString("navi_country_code", str);
            edit.apply();
        }
    }

    public static void x(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(k(context), 0).edit();
        edit.putInt("navi_mode", i);
        edit.apply();
    }

    public static void y(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(k(context), 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void z(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(k(context), 0).edit();
        edit.putBoolean("voice_state", z);
        edit.apply();
        StarryNetManger.getInstance().sendMessage(ProtocolUtils.a("speechMode", z ? "1" : "0"), (SendMessageListener) null);
    }
}
