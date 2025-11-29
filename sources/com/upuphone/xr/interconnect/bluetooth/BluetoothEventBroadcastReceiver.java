package com.upuphone.xr.interconnect.bluetooth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BluetoothEventBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        BluetoothEventMonitor.getInstance().onReceive(context, intent);
    }
}
