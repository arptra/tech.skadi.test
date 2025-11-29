package com.xjsd.ai.assistant.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;

public class ContextHelper {

    /* renamed from: a  reason: collision with root package name */
    public static Context f8455a;
    public static boolean b;
    public static final Handler c = new Handler(Looper.getMainLooper());

    public static Context a() {
        return f8455a;
    }

    public static String b(int i, Object... objArr) {
        return a().getResources().getString(i, objArr);
    }

    public static String[] c(int i) {
        return a().getResources().getStringArray(i);
    }

    public static boolean d(String str) {
        return ContextCompat.checkSelfPermission(f8455a, str) == 0;
    }

    public static void e(Context context, boolean z) {
        f8455a = context;
        b = z;
    }

    public static boolean f(String str) {
        return !d(str);
    }
}
