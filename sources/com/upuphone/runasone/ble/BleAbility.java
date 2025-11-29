package com.upuphone.runasone.ble;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.honey.account.o5.a;
import com.honey.account.o5.b;
import com.honey.account.o5.c;
import com.honey.account.o5.d;
import com.honey.account.o5.e;
import com.honey.account.o5.f;
import com.honey.account.o5.g;
import com.honey.account.o5.h;
import com.honey.account.o5.i;
import com.honey.account.o5.j;
import com.honey.account.o5.k;
import com.honey.account.o5.l;
import com.upuphone.hub.HubException;
import com.upuphone.runasone.ble.BleScanner;
import com.upuphone.runasone.host.api.IAbility;
import com.upuphone.runasone.utils.BleLogger;
import com.upuphone.runasone.utils.Utils;
import com.upuphone.runasone.uupcast.CaptureType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.LongCompanionObject;

public class BleAbility implements IAbility, BleScanner.ScanListener, Api {
    private static final String TAG = "BleAbility";
    private final ApiAdapter apiAdapter = new ApiAdapter(this);
    private final Handler bleHandler;
    private final List<BleInternalDevice> devices = new ArrayList();

    public BleAbility() {
        BleLogger.d(TAG, (Object) "BleAbility init.");
        HandlerThread handlerThread = new HandlerThread("BleThread");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        this.bleHandler = new Handler(looper);
        new BleScanner().init(Utils.getContext(), looper, this);
    }

    private BleInternalDevice getInternalDevice(String str) {
        for (BleInternalDevice next : this.devices) {
            if (TextUtils.equals(str, next.getDeviceId())) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$connect$5(String str, ConnectConfig connectConfig) {
        BleInternalDevice internalDevice = getInternalDevice(str);
        if (internalDevice != null) {
            int i = internalDevice.state;
            if (i == 0) {
                internalDevice.connect(connectConfig);
                internalDevice.state = 1;
                internalDevice.lastFoundTime = LongCompanionObject.MAX_VALUE;
            } else if (i == 2) {
                DeviceCallback deviceCallback = internalDevice.getDeviceCallback();
                BleInternalSession session = internalDevice.getSession();
                if (deviceCallback != null && session != null) {
                    deviceCallback.onConnected(new BleRawSession(str, session.getSessionId()));
                }
            } else {
                BleLogger.w(TAG, (Object) "Connect device but device state is :" + internalDevice.state);
            }
        } else {
            BleLogger.w(TAG, (Object) "connect fail, cannot find bleInternalDevice by deviceId=" + str);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$disconnect$6(String str) {
        BleInternalDevice internalDevice = getInternalDevice(str);
        if (internalDevice == null) {
            BleLogger.w(TAG, (Object) "disconnect fail, cannot find bleInternalDevice by deviceId=" + str);
        } else if (internalDevice.state == 2) {
            internalDevice.disconnect();
        } else {
            BleLogger.w(TAG, (Object) "device is not connected.");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initSession$7(String str, SessionConfig sessionConfig, InitSessionCallback initSessionCallback) {
        BleInternalDevice internalDevice = getInternalDevice(str);
        if (internalDevice != null) {
            internalDevice.initSession(sessionConfig, initSessionCallback);
            return;
        }
        BleLogger.w(TAG, (Object) "initBleSettings fail, cannot find bleInternalDevice by deviceId=" + str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$openNotify$10(String str, String str2, OpenNotifyCallback openNotifyCallback) {
        BleInternalDevice internalDevice = getInternalDevice(str);
        if (internalDevice != null) {
            internalDevice.openNotify(UUID.fromString(str2), openNotifyCallback);
            return;
        }
        BleLogger.w(TAG, (Object) "setMtu fail, cannot find bleInternalDevice by deviceId=" + str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$read$9(String str, String str2, ReadCallback readCallback) {
        BleInternalDevice internalDevice = getInternalDevice(str);
        if (internalDevice != null) {
            internalDevice.read(UUID.fromString(str2), readCallback);
            return;
        }
        BleLogger.w(TAG, (Object) "read fail, cannot find bleInternalDevice by deviceId=" + str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$registerDeviceCallback$0(String str, DeviceCallback deviceCallback) {
        BleInternalDevice internalDevice = getInternalDevice(str);
        if (internalDevice != null) {
            internalDevice.setDeviceCallback(deviceCallback);
            return;
        }
        BleLogger.w(TAG, (Object) "registerDeviceCallback fail, cannot find bleInternalDevice by deviceId=" + str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$registerSessionCallback$2(SessionCallback sessionCallback, BleInternalDevice bleInternalDevice, String str, byte[] bArr) {
        try {
            sessionCallback.onNotify(str, bArr);
        } catch (HubException unused) {
            BleLogger.d(TAG, (Object) "SessionCallback notify failed, fallback to startActivity.");
            Uri parse = Uri.parse(BleConstants.URL + bleInternalDevice.getVid());
            Intent intent = new Intent(BleConstants.ACTION, parse);
            intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            intent.putExtra(BleConstants.EXTRA_TYPE, BleConstants.EXTRA_MESSAGE);
            intent.putExtra(BleConstants.EXTRA_MESSAGE1, str);
            intent.putExtra(BleConstants.EXTRA_MESSAGE2, bArr);
            try {
                Utils.getContext().startActivity(intent);
            } catch (ActivityNotFoundException unused2) {
                BleLogger.d(TAG, (Object) "Activity not found, uri =  " + parse);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$registerSessionCallback$3(String str, SessionCallback sessionCallback) {
        BleInternalDevice internalDevice = getInternalDevice(str);
        if (internalDevice != null) {
            internalDevice.setSessionCallback(new k(sessionCallback, internalDevice));
            return;
        }
        BleLogger.w(TAG, (Object) "registerBleSessionCallback fail, cannot find bleInternalDevice by deviceId=" + str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setMtu$11(String str, int i, MtuCallback mtuCallback) {
        BleInternalDevice internalDevice = getInternalDevice(str);
        if (internalDevice != null) {
            internalDevice.setMtu(i, mtuCallback);
            return;
        }
        BleLogger.w(TAG, (Object) "setMtu fail, cannot find bleInternalDevice by deviceId=" + str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$unregisterDeviceCallback$1(String str) {
        BleInternalDevice internalDevice = getInternalDevice(str);
        if (internalDevice != null) {
            internalDevice.setDeviceCallback((DeviceCallback) null);
            return;
        }
        BleLogger.w(TAG, (Object) "unregisterDeviceCallback fail, cannot find bleInternalDevice by deviceId=" + str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$unregisterSessionCallback$4(String str) {
        BleInternalDevice internalDevice = getInternalDevice(str);
        if (internalDevice != null) {
            internalDevice.setSessionCallback((SessionCallback) null);
            return;
        }
        BleLogger.w(TAG, (Object) "unregisterBleSessionCallback fail, cannot find bleInternalDevice by deviceId=" + str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$write$8(String str, String str2, byte[] bArr, WriteCallback writeCallback) {
        BleInternalDevice internalDevice = getInternalDevice(str);
        if (internalDevice != null) {
            internalDevice.write(UUID.fromString(str2), bArr, writeCallback);
            return;
        }
        BleLogger.w(TAG, (Object) "write fail, cannot find bleInternalDevice by deviceId=" + str);
    }

    private void runOnBleThread(Runnable runnable) {
        this.bleHandler.post(runnable);
    }

    public void appStateChanged(int i, String str, String str2, int i2) {
    }

    public void connect(String str, ConnectConfig connectConfig) {
        runOnBleThread(new f(this, str, connectConfig));
    }

    public void disconnect(String str) {
        runOnBleThread(new j(this, str));
    }

    public ArrayList<BleRawDevice> getFoundDeviceList(String str) {
        ArrayList<BleRawDevice> arrayList = new ArrayList<>();
        for (BleInternalDevice next : this.devices) {
            if (str == null || str.equals(next.getVid())) {
                arrayList.add(next.toRawDevice());
            }
        }
        return arrayList;
    }

    public void initSession(String str, SessionConfig sessionConfig, InitSessionCallback initSessionCallback) {
        runOnBleThread(new i(this, str, sessionConfig, initSessionCallback));
    }

    public void onDeviceFound(BleInternalDevice bleInternalDevice) {
        BleLogger.d(TAG, (Object) "onDeviceFound: " + bleInternalDevice.getDeviceId() + ",vid=" + bleInternalDevice.getVid());
        bleInternalDevice.setBleLooper(this.bleHandler.getLooper());
        this.devices.add(bleInternalDevice);
        Uri parse = Uri.parse(BleConstants.URL + bleInternalDevice.getVid());
        Intent intent = new Intent(BleConstants.ACTION, parse);
        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        intent.putExtra(BleConstants.EXTRA_TYPE, BleConstants.EXTRA_DEVICE);
        intent.putExtra(BleConstants.EXTRA_DEVICE, bleInternalDevice.toRawDevice());
        try {
            Utils.getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            BleLogger.d(TAG, (Object) "Activity not found, uri =  " + parse);
        }
    }

    public void onDeviceLost(BleInternalDevice bleInternalDevice) {
        BleLogger.d(TAG, (Object) "onDeviceLost: " + bleInternalDevice.getDeviceId());
        if (bleInternalDevice.getDeviceCallback() != null) {
            bleInternalDevice.getDeviceCallback().onLose();
        } else {
            BleLogger.w(TAG, (Object) "DeviceCallback is null ,cannot trigger onLose");
        }
        this.devices.remove(bleInternalDevice);
    }

    public void onDevicesLost() {
        BleLogger.d(TAG, (Object) "onDevicesLost");
        for (BleInternalDevice next : this.devices) {
            if (next.getDeviceCallback() != null) {
                next.getDeviceCallback().onLose();
            } else {
                BleLogger.w(TAG, (Object) "DeviceCallback is null ,cannot trigger onLose");
            }
        }
        this.devices.clear();
    }

    public void openNotify(String str, String str2, OpenNotifyCallback openNotifyCallback) {
        runOnBleThread(new a(this, str, str2, openNotifyCallback));
    }

    public void read(String str, String str2, ReadCallback readCallback) {
        runOnBleThread(new e(this, str, str2, readCallback));
    }

    public void registerDeviceCallback(String str, DeviceCallback deviceCallback) {
        runOnBleThread(new c(this, str, deviceCallback));
    }

    public void registerSessionCallback(String str, SessionCallback sessionCallback) {
        runOnBleThread(new l(this, str, sessionCallback));
    }

    public void setMtu(String str, int i, MtuCallback mtuCallback) {
        runOnBleThread(new b(this, str, i, mtuCallback));
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        this.apiAdapter.adapt(bundle, bundle2);
    }

    public void unregisterDeviceCallback(String str) {
        runOnBleThread(new g(this, str));
    }

    public void unregisterSessionCallback(String str) {
        runOnBleThread(new d(this, str));
    }

    public void write(String str, String str2, byte[] bArr, WriteCallback writeCallback) {
        runOnBleThread(new h(this, str, str2, bArr, writeCallback));
    }
}
