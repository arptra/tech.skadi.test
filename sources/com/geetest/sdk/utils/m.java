package com.geetest.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public static String f2967a = "";

    public static String a() {
        return f2967a;
    }

    public static void b(Context context) {
        if (TextUtils.isEmpty(f2967a)) {
            try {
                File externalFilesDir = context.getExternalFilesDir((String) null);
                if (externalFilesDir == null) {
                    externalFilesDir = context.getFilesDir();
                }
                f2967a = externalFilesDir.getAbsolutePath();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
