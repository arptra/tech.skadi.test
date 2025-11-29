package com.xjmz.glasses.ipc.server;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import com.honey.account.constant.AccountConstantKt;
import com.xjmz.glasses.usb.hid.IGlassesEventCallback;
import com.xjmz.glasses.usb.hid.IGlassesHid;
import com.xjmz.openxr.usb.hid.HidManager;
import com.xjmz.openxr.usb.hid.IEventCallback;

public class GlassedHidBinder extends IGlassesHid.Stub {
    private static final boolean DEBUG = true;
    /* access modifiers changed from: private */
    public static final String TAG = "GlassedHidBinder";
    private final RemoteCallbackList<IGlassesEventCallback> mCallbacks = new RemoteCallbackList<>();
    IEventCallback mEventCallback = new IEventCallback() {
        public void a() {
            Log.w(GlassedHidBinder.TAG, "onHidExit");
            GlassedHidBinder.this.mHidManager.h();
        }

        public void on7911StatusChanged(int i, int i2, int i3) {
            GlassedHidBinder.this.notify7911StatusChanged(i, i2, i3);
        }

        public void onBrightnessChanged(int i) {
            GlassedHidBinder.this.notifyBrightnessChanged(i);
        }

        public void onHidChannelConnectionStatusChanged(int i) {
            GlassedHidBinder.this.notifyChannelConnectionStatusChanged(i);
        }

        public void onKeyEvent(int i, int i2) {
            if (GlassedHidBinder.this.mGlassesKeyPolicy.a(i, i2)) {
                GlassedHidBinder.this.notifyKeyEvent(i, i2);
                return;
            }
            String access$600 = GlassedHidBinder.TAG;
            Log.d(access$600, "no need to client, code:" + i + " action:" + i2);
        }

        public void onLog(String str) {
            GlassedHidBinder.this.notifyLog(str);
        }

        public void onUpgradeProgressChanged(int i, int i2, int i3, int i4) {
            GlassedHidBinder.this.notifyUpgradeProgressChanged(i, i2, i3, i4);
        }

        public void onWearingStatusChanged(boolean z) {
            GlassedHidBinder.this.notifyWearingStatusChanged(z);
        }
    };
    /* access modifiers changed from: private */
    public final GlassesKeyPolicy mGlassesKeyPolicy;
    /* access modifiers changed from: private */
    public final HidManager mHidManager;

    public GlassedHidBinder(Context context) {
        HidManager hidManager = new HidManager(context, Utils.a("debug.force.usb.auto", 0) != 0);
        this.mHidManager = hidManager;
        this.mGlassesKeyPolicy = new GlassesKeyPolicy(context, hidManager);
        hidManager.P(this.mEventCallback);
        String str = TAG;
        Log.d(str, "GlassedHidBinder :" + this);
    }

    /* access modifiers changed from: private */
    public synchronized void notify7911StatusChanged(int i, int i2, int i3) {
        int beginBroadcast = this.mCallbacks.beginBroadcast();
        String str = TAG;
        Log.d(str, "notify7911StatusChanged  N:" + beginBroadcast + " rate:" + i + " resolution:" + i2 + " output:" + i3);
        for (int i4 = 0; i4 < beginBroadcast; i4++) {
            try {
                this.mCallbacks.getBroadcastItem(i4).on7911StatusChanged(i, i2, i3);
            } catch (RemoteException e) {
                String str2 = TAG;
                Log.w(str2, "notify7911StatusChanged exception:" + e);
                RemoteCallbackList<IGlassesEventCallback> remoteCallbackList = this.mCallbacks;
                remoteCallbackList.unregister(remoteCallbackList.getBroadcastItem(i4));
            }
        }
        this.mCallbacks.finishBroadcast();
    }

    /* access modifiers changed from: private */
    public synchronized void notifyBrightnessChanged(int i) {
        int beginBroadcast = this.mCallbacks.beginBroadcast();
        String str = TAG;
        Log.d(str, "notifyBrightnessChanged  N:" + beginBroadcast + " level:" + i);
        for (int i2 = 0; i2 < beginBroadcast; i2++) {
            try {
                this.mCallbacks.getBroadcastItem(i2).onBrightnessChanged(i);
            } catch (RemoteException e) {
                String str2 = TAG;
                Log.w(str2, "notifyBrightnessChanged exception:" + e);
                RemoteCallbackList<IGlassesEventCallback> remoteCallbackList = this.mCallbacks;
                remoteCallbackList.unregister(remoteCallbackList.getBroadcastItem(i2));
            }
        }
        this.mCallbacks.finishBroadcast();
    }

    /* access modifiers changed from: private */
    public synchronized void notifyChannelConnectionStatusChanged(int i) {
        int beginBroadcast = this.mCallbacks.beginBroadcast();
        String str = TAG;
        Log.d(str, "notifyChannelConnectionStatusChanged  N:" + beginBroadcast + " status:" + i);
        for (int i2 = 0; i2 < beginBroadcast; i2++) {
            try {
                this.mCallbacks.getBroadcastItem(i2).onHidChannelConnectionStatusChanged(i);
            } catch (RemoteException e) {
                String str2 = TAG;
                Log.w(str2, "notifyChannelConnectionStatusChanged exception:" + e);
                RemoteCallbackList<IGlassesEventCallback> remoteCallbackList = this.mCallbacks;
                remoteCallbackList.unregister(remoteCallbackList.getBroadcastItem(i2));
            }
        }
        this.mCallbacks.finishBroadcast();
    }

    /* access modifiers changed from: private */
    public synchronized void notifyKeyEvent(int i, int i2) {
        int beginBroadcast = this.mCallbacks.beginBroadcast();
        String str = TAG;
        Log.d(str, "notifyKeyEvent  N:" + beginBroadcast + " code:" + i + " action:" + i2);
        for (int i3 = 0; i3 < beginBroadcast; i3++) {
            try {
                this.mCallbacks.getBroadcastItem(i3).onKeyEvent(i, i2);
            } catch (RemoteException e) {
                String str2 = TAG;
                Log.w(str2, "notifyKeyEvent exception:" + e);
                RemoteCallbackList<IGlassesEventCallback> remoteCallbackList = this.mCallbacks;
                remoteCallbackList.unregister(remoteCallbackList.getBroadcastItem(i3));
            }
        }
        this.mCallbacks.finishBroadcast();
    }

    /* access modifiers changed from: private */
    public synchronized void notifyLog(String str) {
        int beginBroadcast = this.mCallbacks.beginBroadcast();
        String str2 = TAG;
        Log.d(str2, "notifyLog  N:" + beginBroadcast);
        for (int i = 0; i < beginBroadcast; i++) {
            try {
                this.mCallbacks.getBroadcastItem(i).onLog(str);
            } catch (RemoteException e) {
                String str3 = TAG;
                Log.w(str3, "notifyLog exception:" + e);
                RemoteCallbackList<IGlassesEventCallback> remoteCallbackList = this.mCallbacks;
                remoteCallbackList.unregister(remoteCallbackList.getBroadcastItem(i));
            }
        }
        this.mCallbacks.finishBroadcast();
    }

    /* access modifiers changed from: private */
    public synchronized void notifyUpgradeProgressChanged(int i, int i2, int i3, int i4) {
        int beginBroadcast = this.mCallbacks.beginBroadcast();
        String str = TAG;
        Log.d(str, "notifyUpgradeProgressChanged  N:" + beginBroadcast + " cur:" + i + " total:" + i2 + " type:" + i3 + " state:" + i4);
        for (int i5 = 0; i5 < beginBroadcast; i5++) {
            try {
                this.mCallbacks.getBroadcastItem(i5).onUpgradeProgressChanged(i, i2, i3, i4);
            } catch (RemoteException e) {
                String str2 = TAG;
                Log.w(str2, "notifyUpgradeProgressChanged exception:" + e);
                RemoteCallbackList<IGlassesEventCallback> remoteCallbackList = this.mCallbacks;
                remoteCallbackList.unregister(remoteCallbackList.getBroadcastItem(i5));
            }
        }
        this.mCallbacks.finishBroadcast();
    }

    /* access modifiers changed from: private */
    public synchronized void notifyWearingStatusChanged(boolean z) {
        int beginBroadcast = this.mCallbacks.beginBroadcast();
        String str = TAG;
        Log.d(str, "notifyWearingStatusChanged  N:" + beginBroadcast + " on:" + z);
        for (int i = 0; i < beginBroadcast; i++) {
            try {
                this.mCallbacks.getBroadcastItem(i).onWearingStatusChanged(z);
            } catch (RemoteException e) {
                String str2 = TAG;
                Log.w(str2, "notifyWearingStatusChanged exception:" + e);
                RemoteCallbackList<IGlassesEventCallback> remoteCallbackList = this.mCallbacks;
                remoteCallbackList.unregister(remoteCallbackList.getBroadcastItem(i));
            }
        }
        this.mCallbacks.finishBroadcast();
    }

    public void destroy() {
        String str = TAG;
        Log.d(str, "destroy :" + this);
        this.mHidManager.m0(this.mEventCallback);
        this.mHidManager.h();
    }

    public void disconnect() {
        String str = TAG;
        Log.d(str, "disconnect " + Binder.getCallingPid() + AccountConstantKt.CODE_SEPARTOR + Process.myPid());
        if (Binder.getCallingPid() != Process.myPid()) {
            Process.killProcess(Process.myPid());
        }
    }

    public int enableLog(boolean z) {
        return this.mHidManager.i(z);
    }

    public int enableMagSensor(boolean z) {
        return this.mHidManager.j(z ? 1 : 0);
    }

    public int eraseData() {
        return this.mHidManager.k();
    }

    public int get2D3DMode() {
        return this.mHidManager.m();
    }

    public String getAiDspVersion() {
        return this.mHidManager.n();
    }

    public int getBrightnessLevel() {
        return this.mHidManager.o();
    }

    public String getCalibrationData() {
        return this.mHidManager.p();
    }

    public String getDeviceName() {
        return this.mHidManager.q();
    }

    public String getDisplayChipVersion() {
        return this.mHidManager.r();
    }

    public int getDisplayStyleMode() {
        return this.mHidManager.s();
    }

    public int getHidChannelConnectionStatus() {
        return this.mHidManager.t();
    }

    public int getImuFrequency() {
        return this.mHidManager.u();
    }

    public String getMCUAPPVersion() {
        return this.mHidManager.v();
    }

    public String getMCUBootVersion() {
        return this.mHidManager.w();
    }

    public String getModel() {
        return this.mHidManager.x();
    }

    public int getPid() {
        return Process.myPid();
    }

    public int getShallowSleepTime() {
        return this.mHidManager.y();
    }

    public int getSleepTime() {
        return this.mHidManager.z();
    }

    public String getSn() {
        return this.mHidManager.A();
    }

    public int getWearingStatus() {
        return this.mHidManager.B();
    }

    public void notifyUsbDetached(UsbDevice usbDevice) {
        Log.d(TAG, "notify usb detached");
        this.mHidManager.D(usbDevice);
    }

    public boolean openUsb(UsbDevice usbDevice) {
        return this.mHidManager.L(usbDevice);
    }

    public boolean openUsbWithFd(ParcelFileDescriptor parcelFileDescriptor, UsbDevice usbDevice) {
        return this.mHidManager.N(parcelFileDescriptor, usbDevice);
    }

    public int reboot() {
        return this.mHidManager.O();
    }

    public void registerEventCallback(IGlassesEventCallback iGlassesEventCallback) {
        String str = TAG;
        Log.d(str, "registerEventCallback :" + iGlassesEventCallback);
        this.mCallbacks.register(iGlassesEventCallback);
    }

    public int sendCalibrationDataToImu(String str) {
        return this.mHidManager.S(str);
    }

    public int set2D3DMode(int i) {
        return this.mHidManager.T(i);
    }

    public int setBrightness(int i) {
        return this.mHidManager.U(i);
    }

    public int setDeviceName(String str) {
        return this.mHidManager.V(str);
    }

    public int setDisplayStyleMode(int i) {
        return this.mHidManager.W(i);
    }

    public void setEndPoint(String str, String str2) {
        System.setProperty("debug.xrt.XRT_MYVU_MSG_PUB_ENDPOINT", str2);
        System.setProperty("debug.xrt.XRT_MYVU_MSG_SUB_ENDPOINT", str);
    }

    public int setFirmwareFilepath(String str, int i) {
        return this.mHidManager.X(str, i);
    }

    public int setImu(int i) {
        return this.mHidManager.Y(i);
    }

    public int setImuConfig(int i) {
        return this.mHidManager.Z(i);
    }

    public int setImuFrequency(int i) {
        return this.mHidManager.a0(i);
    }

    public int setShallowSleepTime(int i) {
        return this.mHidManager.b0(i);
    }

    public int setSleepTime(int i) {
        return this.mHidManager.c0(i);
    }

    public int svHidGet7911CurrentResolution() {
        return this.mHidManager.f0();
    }

    public int svHidGet7911Status(int[] iArr) {
        return this.mHidManager.g0(iArr);
    }

    public int svHidGetActivateState() {
        return this.mHidManager.h0();
    }

    public int svHidGetDuty() {
        return this.mHidManager.i0();
    }

    public int svHidSetDuty(int i) {
        return this.mHidManager.k0(i);
    }

    public void unregisterEventCallback(IGlassesEventCallback iGlassesEventCallback) {
        String str = TAG;
        Log.d(str, "unregisterEventCallback :" + iGlassesEventCallback);
        this.mCallbacks.unregister(iGlassesEventCallback);
    }

    public int wakeUpVoiceAssistant() {
        return this.mHidManager.o0(1);
    }
}
