package com.upuphone.xr.sapp.vu.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.hardware.usb.UsbDevice;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.honey.account.e9.b;
import com.xjmz.glasses.ipc.client.ErrorCodes;
import com.xjmz.glasses.usb.hid.IGlassesEventCallback;
import com.xjmz.glasses.usb.hid.IGlassesHid;
import java.util.ArrayList;
import java.util.List;

public class GlassesManager implements ServiceConnection {
    public static final String f = "GlassesManager";
    public static final boolean g = Log.isLoggable("GlassesManager", 3);

    /* renamed from: a  reason: collision with root package name */
    public IGlassesHid f8092a;
    public Context b;
    public final int c;
    public final List d;
    public IBinder.DeathRecipient e;

    public static class GlassesManagerHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final GlassesManager f8093a = new GlassesManager();
    }

    public interface IGlassesServiceConnection {
        void a();

        void onServiceConnected();
    }

    public static class WorkHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final GlassesManager f8094a;

        public void handleMessage(Message message) {
            if (message.what == 1) {
                GlassesManager glassesManager = this.f8094a;
                glassesManager.d(glassesManager.b);
            }
        }
    }

    public static GlassesManager n() {
        return GlassesManagerHolder.f8093a;
    }

    public boolean A(IGlassesEventCallback iGlassesEventCallback) {
        boolean z;
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            try {
                iGlassesHid.registerEventCallback(iGlassesEventCallback);
                z = true;
            } catch (RemoteException e2) {
                String str = f;
                Log.e(str, "register event callback failed:" + e2.getMessage());
            }
            String str2 = f;
            Log.d(str2, "registerEventCallback:" + z + " callback:" + iGlassesEventCallback);
            return z;
        }
        z = false;
        String str22 = f;
        Log.d(str22, "registerEventCallback:" + z + " callback:" + iGlassesEventCallback);
        return z;
    }

    public void B(IGlassesServiceConnection iGlassesServiceConnection) {
        if (iGlassesServiceConnection != null && !this.d.contains(iGlassesServiceConnection)) {
            this.d.add(iGlassesServiceConnection);
        }
    }

    public int C(int i) {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid == null) {
            if (!g) {
                return -100;
            }
            Log.d(f, "not bind service");
            return -100;
        } else if (i == 1 || i == 2) {
            return iGlassesHid.set2D3DMode(i);
        } else {
            throw new IllegalArgumentException("Illegal parameters, should be MODE_2D or MODE_3D");
        }
    }

    public int D(int i) {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid == null) {
            if (!g) {
                return -100;
            }
            Log.d(f, "not bind service");
            return -100;
        } else if (i >= 1 && i <= 10) {
            return iGlassesHid.setBrightness(i);
        } else {
            throw new IllegalArgumentException("Illegal parameters, should be [1..10]");
        }
    }

    public int E(String str) {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            return iGlassesHid.setDeviceName(str);
        }
        if (!g) {
            return -100;
        }
        Log.d(f, "not bind service");
        return -100;
    }

    public int F(int i) {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid == null) {
            if (!g) {
                return -100;
            }
            Log.d(f, "not bind service");
            return -100;
        } else if (i >= 0 && i <= 2) {
            return iGlassesHid.setDisplayStyleMode(i);
        } else {
            throw new IllegalArgumentException("Illegal parameters, should be [0..2]");
        }
    }

    public int G(String str, int i) {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid == null) {
            if (!g) {
                return -100;
            }
            Log.d(f, "not bind service");
            return -100;
        } else if (i == 2 || i == 1 || i == 0) {
            return iGlassesHid.setFirmwareFilepath(str, i);
        } else {
            throw new IllegalArgumentException("Illegal parameters, should be FIRMWARE_TYPE_PANEL7911, FIRMWARE_TYPE_AI_DSP or FIRMWARE_TYPE_MCU");
        }
    }

    public int H(int i) {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            return iGlassesHid.setSleepTime(i);
        }
        if (!g) {
            return -100;
        }
        Log.d(f, "not bind service");
        return -100;
    }

    public void I(Context context) {
        String str = f;
        Log.d(str, "startService " + this.b);
        if (this.b == null) {
            this.b = context.getApplicationContext();
        }
        d(this.b);
    }

    public int J(int[] iArr) {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            return iGlassesHid.svHidGet7911Status(iArr);
        }
        if (g) {
            Log.d(f, "not bind service");
        }
        return ErrorCodes.SERVICE_UNAVAILABLE.getCode();
    }

    public void K(IGlassesServiceConnection iGlassesServiceConnection) {
        if (iGlassesServiceConnection != null) {
            this.d.remove(iGlassesServiceConnection);
        }
    }

    public final void d(Context context) {
        Intent f2 = f(context);
        if (f2 == null) {
            Log.e(f, "can not create intent");
        } else if (!e(context, f2)) {
            String str = f;
            Log.e(str, "bindService: Service " + f2 + " could not be found to bind!");
        }
    }

    public final boolean e(Context context, Intent intent) {
        if (context.bindService(intent, this, 73)) {
            return true;
        }
        Log.e(f, "Bind failed immediately");
        return false;
    }

    public final Intent f(Context context) {
        Intent intent = new Intent("com.xjmz.glasses.ipc.usb.hid.ACTION");
        if (w(context)) {
            intent.setPackage(context.getPackageName());
            return intent;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService == null) {
            return null;
        }
        intent.setPackage(resolveService.serviceInfo.packageName);
        String str = f;
        Log.d(str, "ext packageName:" + resolveService.serviceInfo.packageName + ", action:" + "com.xjmz.glasses.ipc.usb.hid.ACTION");
        return intent;
    }

    public int g() {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            return iGlassesHid.get2D3DMode();
        }
        if (!g) {
            return -100;
        }
        Log.d(f, "not bind service");
        return -100;
    }

    public String h() {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            return iGlassesHid.getAiDspVersion();
        }
        if (!g) {
            return "";
        }
        Log.d(f, "not bind service");
        return "";
    }

    public int i() {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            return iGlassesHid.getBrightnessLevel();
        }
        if (!g) {
            return -100;
        }
        Log.d(f, "not bind service");
        return -100;
    }

    public String j() {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            return iGlassesHid.getDeviceName();
        }
        if (!g) {
            return "";
        }
        Log.d(f, "not bind service");
        return "";
    }

    public String k() {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            return iGlassesHid.getDisplayChipVersion();
        }
        if (!g) {
            return "";
        }
        Log.d(f, "not bind service");
        return "";
    }

    public int l() {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            return iGlassesHid.getDisplayStyleMode();
        }
        if (!g) {
            return -100;
        }
        Log.d(f, "not bind service");
        return -100;
    }

    public int m() {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            return iGlassesHid.getHidChannelConnectionStatus();
        }
        if (!g) {
            return 0;
        }
        Log.d(f, "not bind service");
        return 0;
    }

    public String o() {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            return iGlassesHid.getMCUAPPVersion();
        }
        if (!g) {
            return "";
        }
        Log.d(f, "not bind service");
        return "";
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d(f, "onServiceConnected");
        this.f8092a = IGlassesHid.Stub.asInterface(iBinder);
        try {
            iBinder.linkToDeath(this.e, 0);
        } catch (RemoteException e2) {
            String str = f;
            Log.e(str, "linkToDeath failed:" + e2);
        }
        if (g) {
            String str2 = f;
            Log.i(str2, "notify onServiceConnected :" + this.d.size());
        }
        for (IGlassesServiceConnection iGlassesServiceConnection : this.d) {
            if (iGlassesServiceConnection != null) {
                iGlassesServiceConnection.onServiceConnected();
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        String str = f;
        Log.d(str, "onServiceDisconnected!!!");
        this.f8092a = null;
        if (g) {
            Log.i(str, "notify onServiceDisconnected :" + this.d.size());
        }
        for (IGlassesServiceConnection iGlassesServiceConnection : this.d) {
            if (iGlassesServiceConnection != null) {
                iGlassesServiceConnection.a();
            }
        }
    }

    public String p() {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            return iGlassesHid.getModel();
        }
        if (!g) {
            return "";
        }
        Log.d(f, "not bind service");
        return "";
    }

    public int q() {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            return iGlassesHid.getSleepTime();
        }
        if (!g) {
            return -100;
        }
        Log.d(f, "not bind service");
        return -100;
    }

    public String r() {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            return iGlassesHid.getSn();
        }
        if (!g) {
            return "";
        }
        Log.d(f, "not bind service");
        return "";
    }

    public boolean s() {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            return iGlassesHid.getWearingStatus() > 0;
        }
        if (g) {
            Log.d(f, "not bind service");
        }
        return false;
    }

    public final void t() {
    }

    public boolean u() {
        int[] iArr = new int[3];
        try {
            return (J(iArr) == 0 && iArr[2] == 0) ? false : true;
        } catch (RemoteException e2) {
            String str = f;
            Log.d(str, "isReady:" + e2);
            return true;
        }
    }

    public boolean v() {
        return this.f8092a != null;
    }

    public final boolean w(Context context) {
        ResolveInfo resolveService = context.getPackageManager().resolveService(new Intent("com.xjmz.glasses.ipc.usb.hid.ACTION").setPackage(context.getPackageName()), 131072);
        String str = f;
        Log.d(str, "isServiceExist, packageName:" + context.getPackageName() + ", info:" + resolveService);
        return resolveService != null;
    }

    public void x(UsbDevice usbDevice) {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            iGlassesHid.notifyUsbDetached(usbDevice);
        } else if (g) {
            Log.d(f, "not bind service");
        }
    }

    public boolean y(UsbDevice usbDevice) {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            return iGlassesHid.openUsb(usbDevice);
        }
        Log.e(f, "not bind service");
        return false;
    }

    public int z() {
        IGlassesHid iGlassesHid = this.f8092a;
        if (iGlassesHid != null) {
            return iGlassesHid.reboot();
        }
        if (!g) {
            return -100;
        }
        Log.d(f, "not bind service");
        return -100;
    }

    public GlassesManager() {
        this.c = 1000;
        this.d = new ArrayList();
        this.e = new b(this);
        if (g) {
            Log.d(f, " GlassesManager ctor");
        }
    }
}
