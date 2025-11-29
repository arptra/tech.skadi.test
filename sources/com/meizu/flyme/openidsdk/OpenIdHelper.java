package com.meizu.flyme.openidsdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

public class OpenIdHelper {
    private static final String TAG = "OpenIdHelper";
    private static Method sContextMethod;

    public static String getAAID(Context context) {
        b a2 = b.a();
        return a2.a(context.getApplicationContext(), a2.c);
    }

    public static String getOAID(Context context) {
        b a2 = b.a();
        return a2.a(context.getApplicationContext(), a2.b);
    }

    public static String getUDID(Context context) {
        b a2 = b.a();
        return a2.a(context.getApplicationContext(), a2.f3145a);
    }

    public static String getVAID(Context context) {
        b a2 = b.a();
        return a2.a(context.getApplicationContext(), a2.d);
    }

    public static final boolean isSupported() {
        Context context = null;
        try {
            if (sContextMethod == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", (Class[]) null);
                sContextMethod = method;
                method.setAccessible(true);
            }
            context = (Context) sContextMethod.invoke((Object) null, (Object[]) null);
        } catch (Exception e) {
            Log.e(TAG, "ActivityThread:currentApplication --> " + e.toString());
        }
        if (context == null) {
            return false;
        }
        return b.a().a(context, false);
    }

    public static void setLogEnable(boolean z) {
        b.a().getClass();
        b.i = z;
    }
}
