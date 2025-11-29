package org.extra.tools;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import org.extra.relinker.c;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3359a = "a";
    public static Context b;

    public static Context a() {
        return b;
    }

    public static boolean b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            System.load((context.getApplicationInfo().dataDir + "/lib") + File.separator + "lib" + str + ".so");
            return true;
        } catch (Throwable th) {
            Log.i(f3359a, "load  fail! Error: " + th.getMessage());
            return false;
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable th) {
            String str2 = f3359a;
            Log.i(str2, "loadLibrary " + str + " fail! Error: " + th.getMessage());
            return false;
        }
    }

    public static void d(Context context, String str) {
        if (!c(str) && !b(context, str)) {
            f(context, str);
        }
    }

    public static void e(String str) {
        try {
            b = ((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", (Class[]) null).invoke((Object) null, (Object[]) null)).getApplicationContext();
        } catch (Exception unused) {
        }
        d(b, str);
    }

    public static boolean f(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                c.a(context, str);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
