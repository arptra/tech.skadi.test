package com.geetest.sdk.model.beans;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.geetest.sdk.NoProguard;
import com.geetest.sdk.utils.o;
import com.meizu.common.util.LunarCalendar;
import java.util.Locale;

public class Gt3GeetestText implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public static String f2943a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";
    public static String f = "";
    public static String g = "";
    public static String h = "";
    public static String i = "";
    public static String j = "";
    public static String k = "";

    public static String a() {
        return e;
    }

    public static String b() {
        return k;
    }

    public static String c() {
        return f;
    }

    public static String d() {
        return b;
    }

    public static String e() {
        return f2943a;
    }

    public static String f() {
        return i;
    }

    public static String g() {
        return h;
    }

    public static String h() {
        return d;
    }

    public static String i() {
        return g;
    }

    public static String j() {
        return j;
    }

    public static String k() {
        return c;
    }

    public static void l(Context context) {
        m(context, (String) null);
    }

    public static void m(Context context, String str) {
        Resources resources;
        if (!TextUtils.isEmpty(str)) {
            Configuration configuration = new Configuration(context.getResources().getConfiguration());
            String[] split = str.split(LunarCalendar.DATE_SEPARATOR);
            if (split.length == 1) {
                configuration.setLocale(new Locale(split[0]));
            } else if (split.length == 2) {
                configuration.setLocale(new Locale(split[0], split[1]));
            }
            resources = context.createConfigurationContext(configuration).getResources();
        } else {
            resources = context.getResources();
        }
        try {
            f2943a = resources.getString(o.g(context, "gt3_geetest_click"));
            b = resources.getString(o.g(context, "gt3_geetest_http_error"));
            c = resources.getString(o.g(context, "gt3_geetest_please_verify"));
            d = resources.getString(o.g(context, "gt3_geetest_success"));
            e = resources.getString(o.g(context, "gt3_geetest_analyzing"));
            f = resources.getString(o.g(context, "gt3_geetest_checking"));
            g = resources.getString(o.g(context, "gt3_geetest_support"));
            h = resources.getString(o.g(context, "gt3_geetest_pass"));
            i = resources.getString(o.g(context, "gt3_geetest_http_timeout"));
            j = resources.getString(o.g(context, "gt3_geetest_try_again"));
            k = resources.getString(o.g(context, "gt3_geetest_closed"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
