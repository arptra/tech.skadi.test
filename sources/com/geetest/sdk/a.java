package com.geetest.sdk;

import android.content.Context;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Context f2900a;

    public static Context a() {
        if (f2900a == null) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getDeclaredMethod("currentActivityThread", (Class[]) null).invoke(cls, (Object[]) null);
                if (invoke != null) {
                    Context context = (Context) invoke.getClass().getDeclaredMethod("getApplication", (Class[]) null).invoke(invoke, (Object[]) null);
                    if (context != null) {
                        f2900a = context;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return f2900a;
    }

    public static void b(Context context) {
        if (context == null) {
            f2900a = a();
        } else {
            f2900a = context.getApplicationContext();
        }
    }
}
