package com.ucar.connect.aoa;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.os.IBinder;
import com.easy.logger.EasyLog;
import com.ucar.util.DigitalTrans;
import com.ucar.vehiclesdk.MDevice;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

class AOAHostSetup {
    public static final AOAHostSetup m = new AOAHostSetup();
    public static final Map n;
    public static final Map o = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public Context f9624a = null;
    public UsbManager b = null;
    public UsbDevice c = null;
    public UsbInterface d = null;
    public UsbDeviceConnection e = null;
    public UsbEndpoint f = null;
    public UsbEndpoint g = null;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public String k;
    public CountDownLatch l;

    public static class UsbDeviceStatus implements Comparable<UsbDeviceStatus> {

        /* renamed from: a  reason: collision with root package name */
        public int f9625a;
        public int b = 0;
        public String c;
        public final boolean d;

        public UsbDeviceStatus(String str, int i, boolean z) {
            this.c = str;
            this.f9625a = i;
            this.d = z;
        }

        /* renamed from: a */
        public int compareTo(UsbDeviceStatus usbDeviceStatus) {
            if (this.d && !usbDeviceStatus.g()) {
                return -1;
            }
            if (this.d || !usbDeviceStatus.g()) {
                return this.f9625a != usbDeviceStatus.f() ? Integer.compare(this.f9625a, usbDeviceStatus.f()) * -1 : Integer.compare(this.b, usbDeviceStatus.d());
            }
            return 1;
        }

        public int d() {
            return this.b;
        }

        public int f() {
            return this.f9625a;
        }

        public boolean g() {
            return this.d;
        }

        public String h() {
            return this.c;
        }

        public void i() {
            if (this.f9625a == 1) {
                this.b++;
                this.f9625a = 0;
            }
        }

        public void j() {
            this.f9625a = 0;
            this.c = null;
        }

        public void k(int i) {
            this.f9625a = i;
        }

        public void l(String str) {
            this.c = str;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        n = hashMap;
        hashMap.put(6353, "google");
        hashMap.put(8921, MDevice.MANUFACTURERS_OPPO);
        hashMap.put(11669, MDevice.MANUFACTURERS_VIVO);
        hashMap.put(10007, MDevice.MANUFACTURERS_XIAOMI);
        hashMap.put(10864, MDevice.MANUFACTURERS_OPPO);
        hashMap.put(10821, MDevice.MANUFACTURERS_MEIZU);
    }

    public static AOAHostSetup m() {
        return m;
    }

    public void A() {
        UsbDevice usbDevice = this.c;
        if (usbDevice != null) {
            Map map = o;
            if (map.get(usbDevice.getSerialNumber()) != null) {
                ((UsbDeviceStatus) map.get(this.c.getSerialNumber())).i();
            }
        }
    }

    public final void B() {
        EasyLog.a("AOAHostSetup", "reConnectUsbDevice");
        this.l = new CountDownLatch(1);
        h();
        u();
        p();
        this.l.countDown();
    }

    public final void C(UsbDeviceConnection usbDeviceConnection) {
        try {
            Method declaredMethod = Class.forName("android.hardware.usb.UsbDeviceConnection").getDeclaredMethod("resetDevice", (Class[]) null);
            declaredMethod.setAccessible(true);
            boolean booleanValue = ((Boolean) declaredMethod.invoke(usbDeviceConnection, (Object[]) null)).booleanValue();
            EasyLog.a("AOAHostSetup", "reset usb connection is " + booleanValue);
        } catch (Exception e2) {
            EasyLog.d("AOAHostSetup", "try to reset usb connection fail.", e2);
        }
    }

    public final void D() {
        Map map = o;
        if (!map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                if (!Integer.valueOf(((UsbDeviceStatus) entry.getValue()).f()).equals(-1)) {
                    ((UsbDeviceStatus) entry.getValue()).j();
                }
            }
        }
    }

    public boolean E() {
        UsbManager usbManager;
        UsbDevice usbDevice;
        if (this.f9624a == null || (usbManager = this.b) == null) {
            EasyLog.c("AOAHostSetup", "scanUsbDevices fail");
            return false;
        }
        HashMap<String, UsbDevice> deviceList = usbManager.getDeviceList();
        EasyLog.a("AOAHostSetup", "device count = " + deviceList.size());
        if (deviceList.size() == 0) {
            if (this.h > 0) {
                int i2 = this.i + 1;
                this.i = i2;
                if (i2 < 5) {
                    return false;
                }
                EasyLog.a("AOAHostSetup", "can't get devices again after change to AOA mode");
                this.i = 0;
                return true;
            }
            this.i = 0;
        }
        for (Map.Entry next : deviceList.entrySet()) {
            UsbDevice usbDevice2 = (UsbDevice) next.getValue();
            if (!(usbDevice2 == null || usbDevice2.getSerialNumber() == null)) {
                String serialNumber = usbDevice2.getSerialNumber();
                Map map = o;
                UsbDeviceStatus usbDeviceStatus = (UsbDeviceStatus) map.get(serialNumber);
                if (usbDeviceStatus != null) {
                    usbDeviceStatus.l((String) next.getKey());
                } else if (w(usbDevice2)) {
                    map.put(serialNumber, new UsbDeviceStatus((String) next.getKey(), 0, true));
                } else if (!x(usbDevice2)) {
                    EasyLog.a("AOAHostSetup", "ignore non Android number: " + usbDevice2.getSerialNumber());
                    map.put(serialNumber, new UsbDeviceStatus((String) next.getKey(), -1, false));
                } else {
                    map.put(serialNumber, new UsbDeviceStatus((String) next.getKey(), 0, false));
                }
            }
        }
        PriorityQueue priorityQueue = new PriorityQueue(o.values());
        while (!priorityQueue.isEmpty()) {
            UsbDeviceStatus usbDeviceStatus2 = (UsbDeviceStatus) priorityQueue.poll();
            if (!(usbDeviceStatus2 == null || usbDeviceStatus2.h() == null || (usbDevice = deviceList.get(usbDeviceStatus2.h())) == null || usbDevice.getSerialNumber() == null)) {
                int vendorId = usbDevice.getVendorId();
                int productId = usbDevice.getProductId();
                EasyLog.a("AOAHostSetup", "vid = 0x" + DigitalTrans.a(vendorId, 4));
                EasyLog.a("AOAHostSetup", "pid = 0x" + DigitalTrans.a(productId, 4));
                EasyLog.a("AOAHostSetup", usbDevice.toString());
                if (this.b.hasPermission(usbDevice) || q(usbDevice, this.f9624a)) {
                    if (this.h < 20) {
                        this.h = 20;
                    }
                    if (t(usbDevice)) {
                        EasyLog.a("AOAHostSetup", "init device success");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean F() {
        Charset charset = StandardCharsets.UTF_8;
        if (j(52, 0, "ICCOA".getBytes(charset)) < 0) {
            EasyLog.a("AOAHostSetup", "send identity AOA_MANUFACTURER fail");
            return false;
        } else if (j(52, 1, "CarLink".getBytes(charset)) < 0) {
            EasyLog.a("AOAHostSetup", "send identity AOA_MODEL_NAME fail");
            return false;
        } else if (j(52, 2, "ICCOA CarLink".getBytes(charset)) < 0) {
            EasyLog.a("AOAHostSetup", "send identity AOA_DESCRIPTION fail");
            return false;
        } else if (j(52, 3, "1.0.0".getBytes(charset)) < 0) {
            EasyLog.a("AOAHostSetup", "send identity AOA_VERSION fail");
            return false;
        } else if (j(52, 4, "http://www.iccoa.cn/".getBytes(charset)) < 0) {
            EasyLog.a("AOAHostSetup", "send identity AOA_URI fail");
            return false;
        } else if (j(52, 5, this.k.getBytes(charset)) < 0) {
            EasyLog.a("AOAHostSetup", "send identity AOA_SERIAL_NUMBER fail");
            return false;
        } else {
            EasyLog.a("AOAHostSetup", "send identity string success");
            return true;
        }
    }

    public final boolean G() {
        if (j(53, 0, (byte[]) null) < 0) {
            EasyLog.a("AOAHostSetup", "start accessory mode fail");
            return false;
        }
        EasyLog.a("AOAHostSetup", "start accessory mode success");
        return true;
    }

    public final void H() {
        p();
        if (this.h < 100) {
            this.h = 100;
        }
        AOAConnectManager.h().q();
        this.h = 0;
        EasyLog.a("AOAHostSetup", "initUsbDevice success");
    }

    public final boolean I(String str) {
        EasyLog.a("AOAHostSetup", "wait for accessory device reconnect");
        int i2 = 0;
        while (i2 <= 20) {
            try {
                Thread.sleep(50);
                for (Map.Entry<String, UsbDevice> value : this.b.getDeviceList().entrySet()) {
                    UsbDevice usbDevice = (UsbDevice) value.getValue();
                    if (usbDevice != null && usbDevice.getSerialNumber() != null && Objects.equals(usbDevice.getSerialNumber(), str) && !usbDevice.getDeviceName().equals(this.c.getDeviceName())) {
                        this.c = usbDevice;
                        return true;
                    }
                }
                i2++;
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            }
        }
        EasyLog.c("AOAHostSetup", "accessory device reconnect timeout");
        return false;
    }

    public int b(byte[] bArr, int i2) {
        try {
            if (this.e == null || this.f == null) {
                throw new IOException("mUsbDeviceConnection or mUsbEndpointIn is null");
            }
            int i3 = 0;
            int i4 = i2;
            int i5 = 0;
            while (true) {
                if (i4 <= 0) {
                    break;
                }
                int c2 = c(bArr, i3, Math.min(i4, 16384));
                if (c2 <= 0) {
                    break;
                }
                i5 = i3 + c2;
                i4 -= c2;
                i3 = i5;
            }
            if (i5 != 0) {
                if (i5 != i2) {
                    throw new IOException("Expect bulkTransferIn " + i2 + " bytes, but received " + i5 + " bytes");
                }
            }
            return i5;
        } catch (Exception e2) {
            EasyLog.d("AOAHostSetup", "bulkTransferIn catch exception " + e2.getMessage(), e2);
            AOAConnectManager.h().m();
            return -1;
        }
    }

    public final int c(byte[] bArr, int i2, int i3) {
        int a2 = UsbNative.a(this.e, this.f, bArr, i2, i3, 0);
        if (a2 < 0) {
            EasyLog.c("AOAHostSetup", "bulkTransferIn error, ret = " + a2 + " , expect len = " + i3 + " , offset = " + i2);
            try {
                CountDownLatch countDownLatch = this.l;
                if (countDownLatch != null) {
                    if (!countDownLatch.await(300, TimeUnit.MILLISECONDS)) {
                        throw new IOException("wait reconnect usb device timeout.");
                    }
                }
                a2 = UsbNative.a(this.e, this.f, bArr, i2, i3, 0);
                if (a2 < 0) {
                    throw new IOException("retry bulkTransferIn error, ret = " + a2);
                }
            } catch (InterruptedException unused) {
                throw new IOException("wait reconnect usb device Interrupted.");
            }
        }
        return a2;
    }

    public final int d(byte[] bArr, int i2) {
        try {
            if (this.e == null || this.g == null) {
                throw new IOException("mUsbDeviceConnection or mUsbEndpointIn is null");
            }
            int i3 = 0;
            int i4 = i2;
            int i5 = 0;
            while (true) {
                if (i4 <= 0) {
                    break;
                }
                int f2 = f(bArr, i3, Math.min(i4, 16384));
                if (f2 <= 0) {
                    break;
                }
                i5 = i3 + f2;
                i4 -= f2;
                i3 = i5;
            }
            if (i5 == i2) {
                return i5;
            }
            throw new IOException("Expect send " + i2 + " bytes, but sent " + i5 + " bytes");
        } catch (Exception e2) {
            EasyLog.d("AOAHostSetup", "bulkTransferOut catch exception" + e2.getMessage(), e2);
            AOAConnectManager.h().m();
            return -1;
        }
    }

    public synchronized int e(byte[] bArr, int i2, byte[] bArr2, int i3) {
        if (d(bArr, i2) < 0) {
            EasyLog.c("AOAHostSetup", "bulkTransferOut fail 1");
            return -1;
        } else if (d(bArr2, i3) < 0) {
            EasyLog.c("AOAHostSetup", "bulkTransferOut fail 2");
            return -1;
        } else {
            return i2 + i3;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int f(byte[] r11, int r12, int r13) {
        /*
            r10 = this;
            java.lang.String r0 = "AOAHostSetup"
            r1 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.util.concurrent.CompletableFuture r2 = r10.o(r11, r12, r13)
            r3 = 500(0x1f4, double:2.47E-321)
            r5 = -1
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0019 }
            java.lang.Object r6 = r2.get(r3, r6)     // Catch:{ Exception -> 0x0019 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ Exception -> 0x0019 }
            if (r6 != 0) goto L_0x0045
            return r5
        L_0x0019:
            r6 = move-exception
            java.lang.String r7 = "bulkTransferOut error"
            com.easy.logger.EasyLog.d(r0, r7, r6)
            r10.B()
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x003b }
            r7 = 10
            java.lang.Object r2 = r2.get(r7, r6)     // Catch:{ Exception -> 0x003b }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x003b }
            if (r2 != 0) goto L_0x0044
            java.lang.String r1 = "ret is null after retrieve write result again"
            com.easy.logger.EasyLog.c(r0, r1)     // Catch:{ Exception -> 0x0039 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0039 }
            r6 = r1
            goto L_0x0045
        L_0x0039:
            r1 = move-exception
            goto L_0x003f
        L_0x003b:
            r2 = move-exception
            r9 = r2
            r2 = r1
            r1 = r9
        L_0x003f:
            java.lang.String r6 = "try get last bulkTransferOut result again error: "
            com.easy.logger.EasyLog.b(r0, r6, r1)
        L_0x0044:
            r6 = r2
        L_0x0045:
            int r1 = r6.intValue()
            if (r1 > 0) goto L_0x006f
            java.lang.String r1 = "retry bulkTransferOut"
            com.easy.logger.EasyLog.a(r0, r1)
            java.util.concurrent.CompletableFuture r11 = r10.o(r11, r12, r13)
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0060 }
            java.lang.Object r11 = r11.get(r3, r12)     // Catch:{ Exception -> 0x0060 }
            r6 = r11
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ Exception -> 0x0060 }
            if (r6 != 0) goto L_0x006f
            return r5
        L_0x0060:
            r11 = move-exception
            java.lang.String r12 = "retry bulkTransferOut error"
            com.easy.logger.EasyLog.d(r0, r12, r11)
            r10.l()
            java.io.IOException r10 = new java.io.IOException
            r10.<init>(r12)
            throw r10
        L_0x006f:
            int r10 = r6.intValue()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucar.connect.aoa.AOAHostSetup.f(byte[], int, int):int");
    }

    public final boolean g() {
        EasyLog.a("AOAHostSetup", "changeToAccessoryMode");
        if (this.c == null) {
            return false;
        }
        if (!n()) {
            EasyLog.c("AOAHostSetup", "Change Accessory Mode getProtocolVersion Fail");
            return false;
        } else if (!F()) {
            EasyLog.c("AOAHostSetup", "Change Accessory Mode sendIdentityStrings Fail");
            return false;
        } else if (!G()) {
            EasyLog.c("AOAHostSetup", "Change Accessory Mode startAccessoryMode Fail");
            return false;
        } else {
            EasyLog.a("AOAHostSetup", "Change Accessory Mode Success");
            return true;
        }
    }

    public final void h() {
        UsbDeviceConnection usbDeviceConnection = this.e;
        if (usbDeviceConnection != null) {
            usbDeviceConnection.releaseInterface(this.d);
            this.e.close();
        }
    }

    public final int i(byte[] bArr) {
        UsbDeviceConnection usbDeviceConnection = this.e;
        if (usbDeviceConnection == null) {
            return -1;
        }
        return usbDeviceConnection.controlTransfer(192, 51, 0, 0, bArr, bArr == null ? 0 : bArr.length, 0);
    }

    public final int j(int i2, int i3, byte[] bArr) {
        UsbDeviceConnection usbDeviceConnection = this.e;
        if (usbDeviceConnection == null) {
            return -1;
        }
        return usbDeviceConnection.controlTransfer(64, i2, 0, i3, bArr, bArr == null ? 0 : bArr.length, 0);
    }

    public void k() {
        l();
        D();
    }

    public final void l() {
        EasyLog.a("AOAHostSetup", "deInitUsbDevice");
        try {
            this.f = null;
            this.g = null;
            this.c = null;
            h();
            this.e = null;
        } catch (Exception e2) {
            EasyLog.d("AOAHostSetup", "deInitUsbDevice fail", e2);
        }
    }

    public final boolean n() {
        byte[] bArr = new byte[2];
        if (i(bArr) < 0) {
            EasyLog.a("AOAHostSetup", "get protocol version fail");
            return false;
        }
        byte b2 = bArr[0] | (bArr[1] << 8);
        if (b2 < 1 || b2 > 2) {
            EasyLog.c("AOAHostSetup", "usb device not capable of AOA 1.0 or 2.0, version = " + b2);
            return false;
        }
        EasyLog.a("AOAHostSetup", "usb device AOA version is " + b2);
        return true;
    }

    public final CompletableFuture o(byte[] bArr, int i2, int i3) {
        return CompletableFuture.supplyAsync(new a(this, i3, bArr, i2));
    }

    public final void p() {
        EasyLog.a("AOAHostSetup", "get endpoint to read/write");
        this.f = this.d.getEndpoint(0);
        this.g = this.d.getEndpoint(1);
    }

    public final boolean q(UsbDevice usbDevice, Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                EasyLog.c("AOAHostSetup", "can't get package manager");
                return false;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
            Method declaredMethod = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            IBinder iBinder = (IBinder) declaredMethod.invoke((Object) null, new Object[]{"usb"});
            Class<?> cls = Class.forName("android.hardware.usb.IUsbManager");
            Method declaredMethod2 = Class.forName("android.hardware.usb.IUsbManager$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class});
            declaredMethod2.setAccessible(true);
            Object invoke = declaredMethod2.invoke((Object) null, new Object[]{iBinder});
            EasyLog.a("AOAHostSetup", "UID : " + applicationInfo.uid + " " + applicationInfo.processName + " " + applicationInfo.permission);
            Method declaredMethod3 = cls.getDeclaredMethod("grantDevicePermission", new Class[]{UsbDevice.class, Integer.TYPE});
            declaredMethod3.setAccessible(true);
            declaredMethod3.invoke(invoke, new Object[]{usbDevice, Integer.valueOf(applicationInfo.uid)});
            EasyLog.a("AOAHostSetup", "Method OK : " + iBinder + FastRecordHistoryDetailActivity.TAG_SPLIT + invoke);
            return true;
        } catch (Exception e2) {
            EasyLog.d("AOAHostSetup", "Error trying to assigning automatic usb permission : ", e2);
            return false;
        }
    }

    public void r(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        EasyLog.a("AOAHostSetup", "init");
        this.f9624a = context;
        this.k = AOAPreambleBuilder.a(str2, str, str3, str4, str5, str6);
        this.b = (UsbManager) this.f9624a.getSystemService("usb");
        UsbNative.d(this.f9624a.getApplicationInfo().targetSdkVersion);
    }

    public void s() {
        this.h = 0;
        this.j = 0;
        this.i = 0;
    }

    public final boolean t(UsbDevice usbDevice) {
        EasyLog.a("AOAHostSetup", "initUsbDevice");
        l();
        if (usbDevice == null) {
            EasyLog.c("AOAHostSetup", "device is null, initUsbDevice fail");
            return false;
        } else if (this.b == null) {
            EasyLog.c("AOAHostSetup", "mUsbManager is null, initUsbDevice fail");
            return false;
        } else {
            this.c = usbDevice;
            String serialNumber = usbDevice.getSerialNumber();
            UsbDeviceStatus usbDeviceStatus = (UsbDeviceStatus) o.get(serialNumber);
            if (usbDeviceStatus == null) {
                EasyLog.c("AOAHostSetup", "UsbDeviceStatus: " + serialNumber + " is null, initUsbDevice fail");
                return false;
            }
            if (this.h < 40) {
                this.h = 40;
            }
            if (u()) {
                return false;
            }
            if (!v()) {
                if (this.h < 60) {
                    this.h = 60;
                }
                if (g()) {
                    usbDeviceStatus.k(1);
                    AOAConnectManager.h().s(this.c.getProductName(), (String) n.get(Integer.valueOf(this.c.getVendorId())));
                    if (!I(serialNumber)) {
                        return false;
                    }
                } else {
                    int i2 = this.j + 1;
                    this.j = i2;
                    if (i2 >= 10) {
                        EasyLog.c("AOAHostSetup", "can't change to accessory mode");
                        AOAConnectManager.h().m();
                        this.j = 0;
                        usbDeviceStatus.k(-1);
                    }
                    return false;
                }
            }
            if (u()) {
                return false;
            }
            this.j = 0;
            if (this.h < 60) {
                AOAConnectManager.h().s(this.c.getProductName(), (String) n.get(Integer.valueOf(this.c.getVendorId())));
            }
            if (this.h < 80) {
                this.h = 80;
            }
            Integer num = 1;
            if (!num.equals(Integer.valueOf(usbDeviceStatus.f()))) {
                C(this.e);
                usbDeviceStatus.k(1);
            }
            H();
            return true;
        }
    }

    public final boolean u() {
        try {
            this.d = this.c.getInterface(0);
            UsbDeviceConnection openDevice = this.b.openDevice(this.c);
            this.e = openDevice;
            openDevice.claimInterface(this.d, true);
            return false;
        } catch (Exception e2) {
            EasyLog.d("AOAHostSetup", "initUsbDevice fail", e2);
            l();
            return true;
        }
    }

    public final boolean v() {
        EasyLog.a("AOAHostSetup", "isAccessoryMode");
        UsbDevice usbDevice = this.c;
        boolean z = false;
        if (usbDevice == null) {
            return false;
        }
        int vendorId = usbDevice.getVendorId();
        int productId = this.c.getProductId();
        if (vendorId == 6353 && (productId == 11520 || productId == 11521 || productId == 11524 || productId == 11525)) {
            z = true;
        }
        if (z) {
            EasyLog.a("AOAHostSetup", "Android device attached in Accessory Mode");
        } else {
            EasyLog.a("AOAHostSetup", "Android device attached not in Accessory Mode");
        }
        return z;
    }

    public final boolean w(UsbDevice usbDevice) {
        if (usbDevice == null) {
            return false;
        }
        if (!n.containsKey(Integer.valueOf(usbDevice.getVendorId()))) {
            return false;
        }
        EasyLog.a("AOAHostSetup", "this device match vendor id");
        return true;
    }

    public final boolean x(UsbDevice usbDevice) {
        if (!(usbDevice == null || usbDevice.getManufacturerName() == null || usbDevice.getProductName() == null || usbDevice.getSerialNumber() == null)) {
            for (int i2 = 0; i2 < usbDevice.getInterfaceCount(); i2++) {
                UsbInterface usbInterface = usbDevice.getInterface(i2);
                if (usbInterface != null) {
                    if (usbDevice.getInterfaceCount() == 1 && i2 == 0 && 8 == usbInterface.getInterfaceClass() && 6 == usbInterface.getInterfaceSubclass() && 80 == usbInterface.getInterfaceProtocol()) {
                        EasyLog.a("AOAHostSetup", "this device is storage device, ignore it");
                        return false;
                    } else if (6 == usbInterface.getInterfaceClass() && 6 == usbInterface.getInterfaceSubclass() && 1 == usbInterface.getInterfaceProtocol()) {
                        EasyLog.a("AOAHostSetup", "this device is ptp device");
                        return true;
                    }
                }
            }
            for (int i3 = 0; i3 < usbDevice.getConfigurationCount(); i3++) {
                String name = usbDevice.getConfiguration(i3).getName();
                if (name != null) {
                    if (Pattern.compile(Pattern.quote("accessory"), 2).matcher(name).find()) {
                        EasyLog.a("AOAHostSetup", "this device has accessory configuration");
                        return true;
                    } else if (Pattern.compile(Pattern.quote("adb"), 2).matcher(name).find()) {
                        EasyLog.a("AOAHostSetup", "this device has adb configuration");
                        return true;
                    } else if (Pattern.compile(Pattern.quote("mtp"), 2).matcher(name).find()) {
                        EasyLog.a("AOAHostSetup", "this device has mtp configuration");
                        return true;
                    } else if (Pattern.compile(Pattern.quote("ptp"), 2).matcher(name).find()) {
                        EasyLog.a("AOAHostSetup", "this device has ptp configuration");
                        return true;
                    } else if (Pattern.compile(Pattern.quote("midi"), 2).matcher(name).find()) {
                        EasyLog.a("AOAHostSetup", "this device has midi configuration");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean y(UsbDevice usbDevice) {
        UsbDevice usbDevice2 = this.c;
        EasyLog.a("AOAHostSetup", "isSameDeviceUnsafe. currentDevice: " + usbDevice2 + "\ndevice: " + usbDevice);
        if (usbDevice == null || usbDevice2 == null) {
            return true;
        }
        return usbDevice2.getVendorId() == usbDevice.getVendorId() && usbDevice2.getDeviceId() == usbDevice.getDeviceId();
    }

    public final /* synthetic */ Integer z(int i2, byte[] bArr, int i3) {
        int i4;
        EasyLog.c("AOAHostSetup", "bulkTransferOut begin,len: " + i2);
        try {
            i4 = UsbNative.b(this.e, this.g, bArr, i3, i2, 0);
        } catch (Exception e2) {
            EasyLog.d("AOAHostSetup", "bulkTransferOut end, error", e2);
            i4 = 0;
        }
        EasyLog.c("AOAHostSetup", "bulkTransferOut end, len: " + i4);
        return Integer.valueOf(i4);
    }
}
