package com.share.connect.ble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import com.easy.logger.EasyLog;

@SuppressLint({"PrivateApi"})
class BluetoothAdapterProxy {

    /* renamed from: a  reason: collision with root package name */
    public static String f9881a;
    public static int b;

    static {
        Class<BluetoothAdapter> cls = BluetoothAdapter.class;
        try {
            f9881a = (String) cls.getField("ACTION_BLE_STATE_CHANGED").get((Object) null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            EasyLog.d("BluetoothAdapterProxy", "Exception trace:", e);
        }
        try {
            b = ((Integer) cls.getField("STATE_BLE_ON").get((Object) null)).intValue();
        } catch (IllegalAccessException | NoSuchFieldException e2) {
            EasyLog.d("BluetoothAdapterProxy", "Exception trace:", e2);
        }
    }
}
