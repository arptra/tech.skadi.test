package com.here.odnp.util;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.UserHandle;

public class OdnpContext {
    private static final String TAG = "odnp.util.OdnpContext";

    private OdnpContext() {
    }

    public static boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i, boolean z) {
        Log.v(TAG, "bindService: %s", intent);
        return z ? bindServiceAsUser(context, intent, serviceConnection, i, OdnpUserHandle.OWNER) : context.bindService(intent, serviceConnection, i);
    }

    public static boolean bindServiceAsUser(Context context, Intent intent, ServiceConnection serviceConnection, int i, UserHandle userHandle) {
        try {
            return ((Boolean) Context.class.getMethod("bindServiceAsUser", new Class[]{Intent.class, ServiceConnection.class, Integer.TYPE, UserHandle.class}).invoke(context, new Object[]{intent, serviceConnection, Integer.valueOf(i), userHandle})).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static void sendBroadcastAsUser(Context context, Intent intent, UserHandle userHandle) {
        try {
            Context.class.getMethod("sendBroadcastAsUser", new Class[]{Intent.class, UserHandle.class}).invoke(context, new Object[]{intent, userHandle});
        } catch (Exception unused) {
        }
    }
}
