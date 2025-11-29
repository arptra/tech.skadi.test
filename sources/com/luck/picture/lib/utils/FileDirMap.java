package com.luck.picture.lib.utils;

import android.content.Context;
import android.os.Environment;
import java.util.HashMap;

public final class FileDirMap {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap f9473a = new HashMap();

    public static void a() {
        f9473a.clear();
    }

    public static String b(Context context, int i) {
        HashMap hashMap = f9473a;
        String str = (String) hashMap.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        c(context);
        return (String) hashMap.get(Integer.valueOf(i));
    }

    public static void c(Context context) {
        if (ActivityCompatHelper.a(context)) {
            HashMap hashMap = f9473a;
            if (hashMap.get(1) == null) {
                hashMap.put(1, context.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getPath());
            }
            if (hashMap.get(2) == null) {
                hashMap.put(2, context.getExternalFilesDir(Environment.DIRECTORY_MOVIES).getPath());
            }
            if (hashMap.get(3) == null) {
                hashMap.put(3, context.getExternalFilesDir(Environment.DIRECTORY_MUSIC).getPath());
            }
        }
    }
}
