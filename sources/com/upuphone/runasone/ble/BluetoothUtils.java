package com.upuphone.runasone.ble;

import android.content.Context;

public class BluetoothUtils {
    private static Context sContext;

    public static boolean isBleSupported() {
        Context context = sContext;
        return context != null && context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static void setContext(Context context) {
        sContext = context;
    }
}
