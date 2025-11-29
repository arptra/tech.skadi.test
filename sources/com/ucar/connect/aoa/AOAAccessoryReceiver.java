package com.ucar.connect.aoa;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import com.easy.logger.EasyLog;
import com.share.connect.ConnectState;

public class AOAAccessoryReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final Context f9619a;
    public boolean b = false;

    public AOAAccessoryReceiver(Context context) {
        this.f9619a = context;
    }

    public synchronized void a() {
        if (!this.b) {
            EasyLog.a("AOAAccessoryReceiver", "registerReceiver");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
            this.f9619a.registerReceiver(this, intentFilter);
            this.b = true;
        }
    }

    public synchronized void b() {
        if (this.b) {
            try {
                EasyLog.a("AOAAccessoryReceiver", "unregisterReceiver");
                this.f9619a.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                EasyLog.c("AOAAccessoryReceiver", "Failed to unregister receiver: " + e);
            }
            this.b = false;
        }
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        EasyLog.a("AOAAccessoryReceiver", action);
        try {
            if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
                EasyLog.e("AOAAccessoryReceiver", "USB Device Attached, current state:" + ConnectState.b().a());
                AOAConnectManager.h().d();
                if (!ConnectState.b().g()) {
                    if (!ConnectState.b().e()) {
                        return;
                    }
                }
                AOAConnectManager.h().x();
            } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
                EasyLog.e("AOAAccessoryReceiver", "USB Device Detached, current state:" + ConnectState.b().a());
                if (ConnectState.b().g()) {
                    AOAConnectManager.h().v();
                    return;
                }
                if (AOAHostSetup.m().y((UsbDevice) intent.getParcelableExtra("device"))) {
                    AOAConnectManager.h().D();
                    AOAConnectManager.h().r();
                }
            }
        } catch (Exception e) {
            EasyLog.b("AOAAccessoryReceiver", "get unknown exception", e);
        }
    }
}
