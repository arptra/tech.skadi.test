package com.xjmz.openxr.usb.hid;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.u9.a;
import com.upuphone.runasone.uupcast.CaptureType;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HidManager implements IHidInterface {
    public static final boolean p = Log.isLoggable("GlassesManager", 3);
    public static final List q = Arrays.asList(new Integer[]{10821, 13080});
    public static final List r = Arrays.asList(new Integer[]{8272, 8273, 1060, 1064, 1074});

    /* renamed from: a  reason: collision with root package name */
    public final Context f8374a;
    public UsbDevice b;
    public volatile String c;
    public ParcelFileDescriptor d;
    public UsbDeviceConnection e;
    public final Object f = new Object();
    public final Object g = new Object();
    public final Object h = new Object();
    public final UsbManager i;
    public volatile boolean j = false;
    public SvHidWrapper k;
    public final boolean l;
    public final GlassesCache m;
    public final BroadcastReceiver n = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Class<UsbDevice> cls = UsbDevice.class;
            if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
                UsbDevice usbDevice = Build.VERSION.SDK_INT >= 33 ? (UsbDevice) intent.getParcelableExtra("device", cls) : (UsbDevice) intent.getParcelableExtra("device");
                if (usbDevice != null) {
                    Log.d("HidManager", "ACTION_USB_DEVICE_ATTACHED " + usbDevice.getDeviceName());
                    if (HidManager.this.l) {
                        HidManager.this.C();
                    }
                }
            } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
                UsbDevice usbDevice2 = Build.VERSION.SDK_INT >= 33 ? (UsbDevice) intent.getParcelableExtra("device", cls) : (UsbDevice) intent.getParcelableExtra("device");
                if (usbDevice2 != null) {
                    Log.d("HidManager", "ACTION_USB_DEVICE_DETACHED " + usbDevice2.getDeviceName());
                    HidManager.this.D(usbDevice2);
                }
            } else {
                Log.d("HidManager", "unknown: " + action);
            }
        }
    };
    public final BroadcastReceiver o = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if ("com.xjmz.xrruntime.USB_PERMISSION".equals(intent.getAction())) {
                UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                if (!intent.getBooleanExtra("permission", false)) {
                    Log.d("HidManager", "permission denied for device " + usbDevice);
                    if (HidManager.this.b == null) {
                        HidManager.this.l0();
                    }
                } else if (usbDevice != null) {
                    Log.d("HidManager", "permission for device " + usbDevice);
                    boolean unused = HidManager.this.K(usbDevice);
                }
            }
        }
    };

    public HidManager(Context context, boolean z) {
        this.f8374a = context;
        this.i = (UsbManager) context.getSystemService("usb");
        this.k = new SvHidWrapper();
        this.l = z;
        n0();
        if (p) {
            Log.d("HidManager", "HidManager ctor:" + z);
        }
        if (z) {
            Q();
            new Handler(Looper.getMainLooper()).post(new a(this));
        }
        this.m = new GlassesCache(this.k);
    }

    public String A() {
        if (this.j) {
            return this.k.svHidGetSn();
        }
        Log.w("HidManager", "getSn not init");
        return "";
    }

    public int B() {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidGetWearGlassesInfo();
    }

    public final void C() {
        if (this.b != null) {
            Log.w("HidManager", "multiple usb devices or something wrong! Do nothing.");
        } else {
            l0();
        }
    }

    public void D(UsbDevice usbDevice) {
        if (d0(usbDevice)) {
            h();
            J(0);
        }
    }

    public int E(int i2, boolean z) {
        return this.k.svHidInit(i2, z);
    }

    public final boolean F(int i2, boolean z) {
        if (p) {
            Log.d("HidManager", "initHid with fd " + i2);
        }
        int E = E(i2, z);
        if (E != 0) {
            Log.e("HidManager", "hid init failed:" + E);
            return false;
        } else if (e0() == 0) {
            return true;
        } else {
            Log.e("HidManager", "hid start failed");
            return false;
        }
    }

    public final boolean G() {
        UsbDeviceConnection usbDeviceConnection = this.e;
        return usbDeviceConnection == null || usbDeviceConnection.getSerial() != null;
    }

    public final boolean H(UsbDevice usbDevice) {
        boolean z = usbDevice.getVendorId() == 13080;
        if (z) {
            Log.i("HidManager", "xreal device");
        }
        return z;
    }

    public int I(int i2) {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidLongPressReact(i2);
    }

    public final void J(int i2) {
        this.k.notifyChannelConnectionStatusChanged(i2);
    }

    public final boolean K(UsbDevice usbDevice) {
        ParcelFileDescriptor parcelFileDescriptor;
        Log.d("HidManager", "openUsbDevice:" + usbDevice.getVendorId() + AccountConstantKt.CODE_SEPARTOR + usbDevice.getProductId() + " state:" + this.j);
        UsbDeviceConnection openDevice = this.i.openDevice(usbDevice);
        if (openDevice == null) {
            return false;
        }
        try {
            parcelFileDescriptor = ParcelFileDescriptor.fromFd(openDevice.getFileDescriptor());
        } catch (IOException unused) {
            Log.d("HidManager", "openUsbDevice: dup failed");
            parcelFileDescriptor = null;
        }
        if (parcelFileDescriptor != null) {
            return M(parcelFileDescriptor, usbDevice, openDevice);
        }
        openDevice.close();
        return false;
    }

    public boolean L(UsbDevice usbDevice) {
        if (this.i.hasPermission(usbDevice)) {
            return K(usbDevice);
        }
        Log.e("HidManager", "no permission for " + usbDevice.getVendorId() + AccountConstantKt.CODE_SEPARTOR + usbDevice.getProductId());
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b3, code lost:
        if (r4.j == false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b5, code lost:
        J(1);
        j0(0);
        j(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00be, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c3, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c4, code lost:
        android.util.Log.e("HidManager", "close failed: " + r4.getMessage());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean M(android.os.ParcelFileDescriptor r5, android.hardware.usb.UsbDevice r6, android.hardware.usb.UsbDeviceConnection r7) {
        /*
            r4 = this;
            boolean r0 = p
            if (r0 == 0) goto L_0x002a
            java.lang.String r1 = "HidManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "openUsbDeviceInternal opened device:"
            r2.append(r3)
            int r3 = r6.getVendorId()
            r2.append(r3)
            java.lang.String r3 = ":"
            r2.append(r3)
            int r3 = r6.getProductId()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r1, r2)
        L_0x002a:
            boolean r1 = r4.j
            r2 = 1
            if (r1 == 0) goto L_0x0066
            boolean r1 = r4.G()
            if (r1 == 0) goto L_0x0061
            java.lang.String r4 = "HidManager"
            java.lang.String r6 = "openUsbDeviceByUser already opened"
            android.util.Log.w(r4, r6)
            r5.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x005b
        L_0x0040:
            r4 = move-exception
            java.lang.String r5 = "HidManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "openUsbDeviceByUser pdf close failed:"
            r6.append(r0)
            java.lang.String r4 = r4.getMessage()
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            android.util.Log.d(r5, r4)
        L_0x005b:
            if (r7 == 0) goto L_0x0060
            r7.close()
        L_0x0060:
            return r2
        L_0x0061:
            android.hardware.usb.UsbDevice r1 = r4.b
            r4.D(r1)
        L_0x0066:
            if (r0 == 0) goto L_0x0080
            java.lang.String r0 = "HidManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "openUsbDeviceByUser should be null:"
            r1.append(r3)
            android.os.ParcelFileDescriptor r3 = r4.d
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
        L_0x0080:
            java.lang.Object r0 = r4.g
            monitor-enter(r0)
            boolean r1 = r4.j     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x008b
            monitor-exit(r0)     // Catch:{ all -> 0x0089 }
            return r2
        L_0x0089:
            r4 = move-exception
            goto L_0x00df
        L_0x008b:
            int r1 = r5.getFd()     // Catch:{ all -> 0x0089 }
            boolean r3 = r4.H(r6)     // Catch:{ all -> 0x0089 }
            boolean r1 = r4.F(r1, r3)     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x00af
            java.lang.Object r1 = r4.f     // Catch:{ all -> 0x0089 }
            monitor-enter(r1)     // Catch:{ all -> 0x0089 }
            r4.b = r6     // Catch:{ all -> 0x00ac }
            r4.d = r5     // Catch:{ all -> 0x00ac }
            r4.e = r7     // Catch:{ all -> 0x00ac }
            monitor-exit(r1)     // Catch:{ all -> 0x00ac }
            java.lang.String r6 = r6.getProductName()     // Catch:{ all -> 0x0089 }
            r4.c = r6     // Catch:{ all -> 0x0089 }
            r4.j = r2     // Catch:{ all -> 0x0089 }
            goto L_0x00af
        L_0x00ac:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00ac }
            throw r4     // Catch:{ all -> 0x0089 }
        L_0x00af:
            monitor-exit(r0)     // Catch:{ all -> 0x0089 }
            boolean r6 = r4.j
            r7 = 0
            if (r6 == 0) goto L_0x00bf
            r4.J(r2)
            r4.j0(r7)
            r4.j(r7)
            return r2
        L_0x00bf:
            r5.close()     // Catch:{ IOException -> 0x00c3 }
            goto L_0x00de
        L_0x00c3:
            r4 = move-exception
            java.lang.String r5 = "HidManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "close failed: "
            r6.append(r0)
            java.lang.String r4 = r4.getMessage()
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            android.util.Log.e(r5, r4)
        L_0x00de:
            return r7
        L_0x00df:
            monitor-exit(r0)     // Catch:{ all -> 0x0089 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.openxr.usb.hid.HidManager.M(android.os.ParcelFileDescriptor, android.hardware.usb.UsbDevice, android.hardware.usb.UsbDeviceConnection):boolean");
    }

    public boolean N(ParcelFileDescriptor parcelFileDescriptor, UsbDevice usbDevice) {
        if (p) {
            Log.d("HidManager", "openUsbDeviceWithFdByUser opened device:" + usbDevice.getVendorId() + AccountConstantKt.CODE_SEPARTOR + usbDevice.getProductId());
        }
        return M(parcelFileDescriptor, usbDevice, (UsbDeviceConnection) null);
    }

    public int O() {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidRestartUpgrade();
    }

    public void P(IEventCallback iEventCallback) {
        this.k.registerEventCallback(iEventCallback);
    }

    public final void Q() {
        IntentFilter intentFilter = new IntentFilter("com.xjmz.xrruntime.USB_PERMISSION");
        if (Build.VERSION.SDK_INT >= 33) {
            this.f8374a.registerReceiver(this.o, intentFilter, 2);
        } else {
            this.f8374a.registerReceiver(this.o, intentFilter);
        }
    }

    public final void R(UsbDevice usbDevice) {
        Log.d("HidManager", "requestUsbPermission");
        this.i.requestPermission(usbDevice, PendingIntent.getBroadcast(this.f8374a, 0, new Intent("com.xjmz.xrruntime.USB_PERMISSION"), CaptureType.CAPTURE_TYPE_ICCOA));
    }

    public int S(String str) {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidSendCalibrationDataToImu(str);
    }

    public int T(int i2) {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidSet2D3DState(i2);
    }

    public int U(int i2) {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidSetBrightness(i2);
    }

    public int V(String str) {
        if (!this.j) {
            return -1000;
        }
        return this.m.g(str);
    }

    public int W(int i2) {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidSwitchDisplayStyleMode(i2);
    }

    public int X(String str, int i2) {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidSetFirmwareFilepath(str, i2);
    }

    public int Y(int i2) {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidSetImu(i2);
    }

    public int Z(int i2) {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidSetImuConfig(i2);
    }

    public int a0(int i2) {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidSetImuFrequency(i2);
    }

    public int b0(int i2) {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidSetShallowSleepTime(i2);
    }

    public int c0(int i2) {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidSetSleepTime(i2);
    }

    public final boolean d0(UsbDevice usbDevice) {
        UsbDevice usbDevice2;
        synchronized (this.f) {
            usbDevice2 = this.b;
        }
        return usbDevice != null && usbDevice2 != null && usbDevice.getProductId() == usbDevice2.getProductId() && usbDevice.getVendorId() == usbDevice2.getVendorId();
    }

    public int e0() {
        return this.k.svHidStart();
    }

    public int f0() {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidGet7911CurrentResolution();
    }

    public int g(int i2) {
        return this.k.svHidDestroy(i2);
    }

    public int g0(int[] iArr) {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidGet7911Status(iArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0032, code lost:
        android.util.Log.d("HidManager", "destroyByUser:" + r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
        g(r2.getFd());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0055, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0056, code lost:
        android.util.Log.d("HidManager", "close failed:" + r5.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h() {
        /*
            r5 = this;
            boolean r0 = r5.j
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.Object r0 = r5.h
            monitor-enter(r0)
            boolean r1 = r5.j     // Catch:{ all -> 0x000e }
            if (r1 != 0) goto L_0x0010
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            return
        L_0x000e:
            r5 = move-exception
            goto L_0x0073
        L_0x0010:
            r1 = 0
            r5.j = r1     // Catch:{ all -> 0x000e }
            r1 = 0
            r5.c = r1     // Catch:{ all -> 0x000e }
            com.xjmz.openxr.usb.hid.GlassesCache r2 = r5.m     // Catch:{ all -> 0x000e }
            r2.a()     // Catch:{ all -> 0x000e }
            android.os.ParcelFileDescriptor r2 = r5.d     // Catch:{ all -> 0x000e }
            java.lang.Object r3 = r5.f     // Catch:{ all -> 0x000e }
            monitor-enter(r3)     // Catch:{ all -> 0x000e }
            r5.b = r1     // Catch:{ all -> 0x002e }
            r5.d = r1     // Catch:{ all -> 0x002e }
            android.hardware.usb.UsbDeviceConnection r4 = r5.e     // Catch:{ all -> 0x002e }
            if (r4 == 0) goto L_0x0030
            r4.close()     // Catch:{ all -> 0x002e }
            r5.e = r1     // Catch:{ all -> 0x002e }
            goto L_0x0030
        L_0x002e:
            r5 = move-exception
            goto L_0x0071
        L_0x0030:
            monitor-exit(r3)     // Catch:{ all -> 0x002e }
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            java.lang.String r0 = "HidManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "destroyByUser:"
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
            if (r2 == 0) goto L_0x0070
            int r0 = r2.getFd()
            r5.g(r0)
            r2.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0070
        L_0x0055:
            r5 = move-exception
            java.lang.String r0 = "HidManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "close failed:"
            r1.append(r2)
            java.lang.String r5 = r5.getMessage()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            android.util.Log.d(r0, r5)
        L_0x0070:
            return
        L_0x0071:
            monitor-exit(r3)     // Catch:{ all -> 0x002e }
            throw r5     // Catch:{ all -> 0x000e }
        L_0x0073:
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.openxr.usb.hid.HidManager.h():void");
    }

    public int h0() {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidGetActivateState();
    }

    public int i(boolean z) {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidSetLogTrigger(z ? 1 : 0);
    }

    public int i0() {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidGetDuty();
    }

    public int j(int i2) {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidSetMagSensor(i2);
    }

    public int j0(int i2) {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidOpenHidData(i2);
    }

    public int k() {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidEraseData();
    }

    public int k0(int i2) {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidSetDuty(i2);
    }

    public final UsbDevice l() {
        for (UsbDevice next : this.i.getDeviceList().values()) {
            if (q.contains(Integer.valueOf(next.getVendorId())) && r.contains(Integer.valueOf(next.getProductId()))) {
                return next;
            }
        }
        return null;
    }

    public final void l0() {
        UsbDevice l2 = l();
        if (l2 == null) {
            Log.d("HidManager", "not find device");
        } else if (this.i.hasPermission(l2)) {
            K(l2);
        } else {
            R(l2);
        }
    }

    public int m() {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidGet2D3DState();
    }

    public void m0(IEventCallback iEventCallback) {
        this.k.unregisterEventCallback(iEventCallback);
    }

    public String n() {
        if (this.j) {
            return this.m.b();
        }
        Log.w("HidManager", "getAiDspVersion not init");
        return "";
    }

    public final void n0() {
        if (p) {
            Log.d("HidManager", "hot plug monitor");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        if (Build.VERSION.SDK_INT >= 33) {
            this.f8374a.registerReceiver(this.n, intentFilter, 2);
        } else {
            this.f8374a.registerReceiver(this.n, intentFilter);
        }
    }

    public int o() {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidGetBrightnessLevel();
    }

    public int o0(int i2) {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidLongPressWakeUpVoiceAssistant(i2);
    }

    public String p() {
        if (this.j) {
            return this.k.svHidGetCalibrationData();
        }
        Log.w("HidManager", "getCalibrationData not init");
        return "";
    }

    public String q() {
        if (this.j) {
            return this.m.c();
        }
        Log.w("HidManager", "getDeviceName not init");
        return "";
    }

    public String r() {
        if (this.j) {
            return this.m.d();
        }
        Log.w("HidManager", "getDisplayChipVersion not init");
        return "";
    }

    public int s() {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidGetDisplayStyleMode();
    }

    public int t() {
        if (!this.j || !G()) {
            Log.d("HidManager", "getHidChannelConnectionStatus 0, " + this.j);
            return 0;
        }
        Log.d("HidManager", "getHidChannelConnectionStatus 1");
        return 1;
    }

    public int u() {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidGetImuFrequency();
    }

    public String v() {
        if (this.j) {
            return this.m.e();
        }
        Log.w("HidManager", "getMCUAPPVersion not init");
        return "";
    }

    public String w() {
        if (this.j) {
            return this.m.f();
        }
        Log.w("HidManager", "getMCUBootVersion not init");
        return "";
    }

    public String x() {
        if (this.j) {
            return this.c;
        }
        Log.w("HidManager", "getModel not init");
        return "";
    }

    public int y() {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidGetShallowSleepTime();
    }

    public int z() {
        if (!this.j) {
            return -1000;
        }
        return this.k.svHidGetSleepTime();
    }
}
