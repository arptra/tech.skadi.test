package com.here.odnp.util;

import android.app.ActivityManager;
import android.content.Context;

public class OdnpUserManager {
    private static final String TAG = "odnp.util.OdnpUserManager";

    private OdnpUserManager() {
    }

    public static int getCurrentUser(Context context) {
        try {
            return ((Integer) ActivityManager.class.getMethod("getCurrentUser", (Class[]) null).invoke((ActivityManager) context.getSystemService("activity"), (Object[]) null)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }
}
