package com.upuphone.xr.sapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.upuphone.star.core.log.ULog;

public class HuaWeiFeatureParser {
    public static HuaWeiFeatureParser c;

    /* renamed from: a  reason: collision with root package name */
    public final String f7891a = "50061";
    public final String b = "50005";

    public interface HUAWEICancelAuthorizationListener {
    }

    public static synchronized HuaWeiFeatureParser b() {
        HuaWeiFeatureParser huaWeiFeatureParser;
        synchronized (HuaWeiFeatureParser.class) {
            try {
                if (c == null) {
                    c = new HuaWeiFeatureParser();
                }
                huaWeiFeatureParser = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return huaWeiFeatureParser;
    }

    public void a(Context context, HUAWEICancelAuthorizationListener hUAWEICancelAuthorizationListener) {
        ULog.i("HuaWeiFeatureParser", "The overseas version is not realized");
    }

    public boolean c() {
        return ((Boolean) DataStoreUtils.e.a().f("huawei_auth_open", Boolean.TRUE)).booleanValue();
    }

    public int d(Context context) {
        e(context);
        return ((Integer) DataStoreUtils.e.a().f("huawei_step", 0)).intValue();
    }

    public void e(Context context) {
        ULog.i("HuaWeiFeatureParser", "The overseas version is not realized");
    }

    public void f(Activity activity) {
        ULog.i("HuaWeiFeatureParser", "The overseas version is not realized");
    }

    public boolean g() {
        return ((Boolean) DataStoreUtils.e.a().f("huawei_auth", Boolean.TRUE)).booleanValue();
    }

    public void h(int i, int i2, Intent intent) {
        ULog.i("HuaWeiFeatureParser", "The overseas version is not realized");
    }

    public void i(Activity activity) {
        ULog.i("HuaWeiFeatureParser", "The overseas version is not realized");
    }
}
