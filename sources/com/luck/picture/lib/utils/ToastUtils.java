package com.luck.picture.lib.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.luck.picture.lib.app.PictureAppMaster;
import com.luck.picture.lib.thread.PictureThreadUtils;

public class ToastUtils {

    /* renamed from: a  reason: collision with root package name */
    public static long f9475a;
    public static String b;

    public static boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f9475a < 1000) {
            return true;
        }
        f9475a = currentTimeMillis;
        return false;
    }

    public static void c(final Context context, final String str) {
        if (!b() || !TextUtils.equals(str, b)) {
            Context b2 = PictureAppMaster.c().b();
            if (b2 == null) {
                b2 = context.getApplicationContext();
            }
            if (PictureThreadUtils.m()) {
                Toast.makeText(b2, str, 0).show();
                b = str;
                return;
            }
            PictureThreadUtils.n(new Runnable() {
                public void run() {
                    Context b2 = PictureAppMaster.c().b();
                    if (b2 == null) {
                        b2 = context.getApplicationContext();
                    }
                    Toast.makeText(b2, str, 0).show();
                    String unused = ToastUtils.b = str;
                }
            });
        }
    }
}
