package com.share.connect.ble;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.AdvertisingSet;
import android.bluetooth.le.AdvertisingSetCallback;
import android.bluetooth.le.AdvertisingSetParameters;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.bluetooth.le.PeriodicAdvertisingParameters;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.easy.logger.EasyLog;
import com.honey.account.a3.a;
import com.share.connect.ble.CompatLeScanner;
import com.share.connect.ble.Constants;
import com.share.connect.ble.DeviceCache;
import com.share.connect.ble.IBluetoothLe;
import com.share.connect.utils.DebugTools;
import com.share.connect.utils.ShaUtil;
import com.upuphone.starrynet.strategy.utils.BleUtil;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class BluetoothLeService extends Service {
    public String A;
    public final AtomicInteger B = new AtomicInteger(0);
    public int C;
    public String D;
    public final BleServiceStub E = new BleServiceStub();
    public final List F = new ArrayList();
    public boolean G = false;
    public CountDownLatch H = null;

    /* renamed from: a  reason: collision with root package name */
    public BluetoothManager f9882a;
    public BluetoothAdapter b;
    public CompatLeScanner c;
    public BluetoothLeAdvertiser d;
    public BluetoothGattServer e;
    public BluetoothGattService f;
    public final GattServerCallback g = new GattServerCallback();
    public BluetoothGatt h;
    public GattClientCallback i;
    public BleConnectDelayer j;
    public Handler k;
    public final Runnable l = new Runnable() {
        public void run() {
            EasyLog.i("BLEService", "Connect timeout, take this as failure.");
            BluetoothLeService.this.E.connectDone();
            BluetoothLeService.this.p0();
            BluetoothLeService.this.x0(3, 1);
        }
    };
    public AdvertisingSetCallback m;
    public CompatLeScanner.ScanCallback n;
    public DeviceCache o;
    public BroadcastReceiver p;
    public final AtomicBoolean q = new AtomicBoolean(false);
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public int z;

    @WorkerThread
    public class BleConnectDelayer extends Handler {
        public BleConnectDelayer(Looper looper) {
            super(looper);
        }

        public synchronized void a(String str) {
            EasyLog.a("BLEService-Delayer", "Post connectMsg");
            Message obtainMessage = obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = str;
            sendMessage(obtainMessage);
        }

        public synchronized void b() {
            EasyLog.a("BLEService-Delayer", "Post disconnectMsg");
            Message obtainMessage = obtainMessage();
            obtainMessage.what = 2;
            sendMessage(obtainMessage);
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:14:0x006b=Splitter:B:14:0x006b, B:8:0x003e=Splitter:B:8:0x003e} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r7) {
            /*
                r6 = this;
                java.util.concurrent.CountDownLatch r0 = new java.util.concurrent.CountDownLatch
                r1 = 1
                r0.<init>(r1)
                int r2 = r7.what
                r3 = 200(0xc8, double:9.9E-322)
                java.lang.String r5 = "BLEService-Delayer"
                if (r2 == r1) goto L_0x0045
                r1 = 2
                if (r2 == r1) goto L_0x0028
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r0 = "Unable handle msg.what="
                r6.append(r0)
                int r7 = r7.what
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                com.easy.logger.EasyLog.a(r5, r6)
                goto L_0x0071
            L_0x0028:
                com.share.connect.ble.BluetoothLeService r7 = com.share.connect.ble.BluetoothLeService.this
                android.os.Handler r7 = r7.k
                if (r7 == 0) goto L_0x003e
                com.share.connect.ble.BluetoothLeService r7 = com.share.connect.ble.BluetoothLeService.this
                android.os.Handler r7 = r7.k
                com.share.connect.ble.BluetoothLeService$BleConnectDelayer$2 r1 = new com.share.connect.ble.BluetoothLeService$BleConnectDelayer$2
                r1.<init>(r0)
                r7.post(r1)
            L_0x003e:
                r0.await()     // Catch:{ Exception -> 0x0071 }
                java.lang.Thread.sleep(r3)     // Catch:{ Exception -> 0x0071 }
                goto L_0x0071
            L_0x0045:
                java.lang.Object r7 = r7.obj
                java.lang.String r7 = (java.lang.String) r7
                com.share.connect.ble.BluetoothLeService r2 = com.share.connect.ble.BluetoothLeService.this
                android.os.Handler r2 = r2.k
                if (r2 == 0) goto L_0x0060
                com.share.connect.ble.BluetoothLeService r1 = com.share.connect.ble.BluetoothLeService.this
                android.os.Handler r1 = r1.k
                com.share.connect.ble.BluetoothLeService$BleConnectDelayer$1 r2 = new com.share.connect.ble.BluetoothLeService$BleConnectDelayer$1
                r2.<init>(r7, r0)
                r1.post(r2)
                goto L_0x006b
            L_0x0060:
                java.lang.String r7 = "Receive connect message but handler is null."
                com.easy.logger.EasyLog.i(r5, r7)
                com.share.connect.ble.BluetoothLeService r6 = com.share.connect.ble.BluetoothLeService.this
                r7 = 3
                r6.x0(r7, r1)
            L_0x006b:
                r0.await()     // Catch:{ Exception -> 0x0071 }
                java.lang.Thread.sleep(r3)     // Catch:{ Exception -> 0x0071 }
            L_0x0071:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.share.connect.ble.BluetoothLeService.BleConnectDelayer.handleMessage(android.os.Message):void");
        }
    }

    public class BleServiceStub extends IBluetoothLe.Stub {
        private ArrayMap<String, Integer> mCache;

        private BleServiceStub() {
            this.mCache = new ArrayMap<>();
        }

        public void allowProcessNewConnection() {
            BluetoothLeService.this.g.a();
        }

        public void close() {
            BluetoothLeService.this.j0();
        }

        public boolean connect(String str) {
            if (BluetoothLeService.this.o != null) {
                String d = BluetoothLeService.this.o.d(str);
                if (TextUtils.isEmpty(d) || BluetoothLeService.this.j == null) {
                    EasyLog.i("BLEService", BluetoothLeService.this.j == null ? "Internal error." : "Can't find mac in scan cache.");
                    return false;
                }
                BluetoothLeService.this.j.a(d);
                return true;
            }
            EasyLog.i("BLEService", "Cache is null, do not connect when scan has stopped.");
            return false;
        }

        public void connectDone() {
            EasyLog.a("BLEService", "connectDone...");
            if (BluetoothLeService.this.i != null) {
                BluetoothLeService.this.i.a();
            }
            BluetoothLeService.this.g.b();
            BluetoothLeService.this.D0(false);
        }

        public void disconnect() {
            if (BluetoothLeService.this.j != null) {
                BluetoothLeService.this.j.b();
            }
        }

        public void disconnectWithoutState() {
            EasyLog.c("BLEService", "TEST-ONLY METHOD INVOKED!!");
            if (BluetoothLeService.this.h != null) {
                EasyLog.a("BLEService", "disconnect gatt client");
                BluetoothLeService.this.h.close();
                BluetoothGatt unused = BluetoothLeService.this.h = null;
            }
            if (BluetoothLeService.this.e != null && !TextUtils.isEmpty(BluetoothLeService.this.s)) {
                EasyLog.a("BLEService", "cancelConnection for " + BluetoothLeService.this.s);
                try {
                    BluetoothLeService.this.e.cancelConnection(BluetoothLeService.this.b.getRemoteDevice(BluetoothLeService.this.s));
                } catch (IllegalArgumentException e) {
                    EasyLog.d("BLEService", "cancelConnection failed because of illegal argument.", e);
                }
            }
        }

        public Map getDevicesSignal(int i, int i2) {
            if (BluetoothLeService.this.o == null) {
                EasyLog.i("BLEService", "Call signal list while scanning is stopped.");
                return Collections.emptyMap();
            }
            if (i == 0 || this.mCache.isEmpty()) {
                this.mCache.clear();
                this.mCache = BluetoothLeService.this.o.e();
            }
            if (this.mCache.size() <= i) {
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap();
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                int i4 = i3 + i;
                if (i4 >= this.mCache.size()) {
                    this.mCache.clear();
                    break;
                }
                arrayMap.put((String) this.mCache.j(i4), (Integer) this.mCache.n(i4));
                i3++;
            }
            return arrayMap;
        }

        public boolean isDeviceInMatch(String str) {
            if (BluetoothLeService.this.o != null) {
                return BluetoothLeService.this.o.a(str);
            }
            return false;
        }

        public void notifyServerInfo(String str, String str2, String str3, int i, int i2, String str4) {
            StringBuilder sb = new StringBuilder();
            sb.append("Ready to notify server info: m:");
            String str5 = str3;
            sb.append(!str3.equalsIgnoreCase(BleUtil.DEFAULT_ADDRESS));
            sb.append(", f:");
            sb.append(i);
            EasyLog.e("BLEService", sb.toString());
            DebugTools.b("Ble-notifyCharacteristic");
            BluetoothLeService bluetoothLeService = BluetoothLeService.this;
            JSONObject I = bluetoothLeService.r0(str, str2, str3, i, bluetoothLeService.w, i2, str4);
            byte[] e = BleUtils.e(I != null ? I.toString() : null);
            if (e == null || BluetoothLeService.this.s == null) {
                BluetoothLeService.this.x0(6, 1);
                return;
            }
            BluetoothLeService.this.O0(Constants.ServiceInfo.h.getUuid(), e);
            BluetoothLeService.this.y0();
            connectDone();
            boolean unused = BluetoothLeService.this.h0(1, 0);
        }

        public void open(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, String str7) {
            String unused = BluetoothLeService.this.t = str;
            String unused2 = BluetoothLeService.this.u = str2;
            BluetoothLeService bluetoothLeService = BluetoothLeService.this;
            if (str3 == null) {
                str3 = "";
            }
            String unused3 = bluetoothLeService.v = str3;
            BluetoothLeService bluetoothLeService2 = BluetoothLeService.this;
            if (str4 == null) {
                str4 = "";
            }
            String unused4 = bluetoothLeService2.w = str4;
            String unused5 = BluetoothLeService.this.x = str5;
            String unused6 = BluetoothLeService.this.y = str6;
            boolean unused7 = BluetoothLeService.this.G = z;
            int unused8 = BluetoothLeService.this.z = i;
            String unused9 = BluetoothLeService.this.A = str7;
            BluetoothLeService.this.A0();
        }

        public void registerBluetoothLeObserver(BluetoothLeObserver bluetoothLeObserver) {
            BluetoothLeService.this.B0(bluetoothLeObserver);
        }

        public void setBandSupported(int i) {
            int unused = BluetoothLeService.this.C = i;
        }

        public void setP2pDeviceMac(String str) {
            if (!TextUtils.isEmpty(BluetoothLeService.this.D) && !TextUtils.equals(BluetoothLeService.this.D, str)) {
                EasyLog.c("BLEService", "Warning!!!! Mac address changed from " + BluetoothLeService.this.D + " to " + str);
            }
            String unused = BluetoothLeService.this.D = str;
        }

        public void startScan() {
            BluetoothLeService.this.I0();
        }

        public void stopAdvertise() throws RemoteException {
            BluetoothLeService.this.J0();
        }

        public void stopScan() {
            BluetoothLeService.this.K0();
        }

        public void unregisterBluetoothLeObserver(BluetoothLeObserver bluetoothLeObserver) {
            BluetoothLeService.this.M0(bluetoothLeObserver);
        }
    }

    public class GattClientCallback extends BluetoothGattCallback {

        /* renamed from: a  reason: collision with root package name */
        public int f9893a;
        public boolean b;
        public boolean c;
        public AtomicBoolean d;

        public GattClientCallback() {
            this.f9893a = 2;
            this.b = false;
            this.c = false;
            this.d = new AtomicBoolean(false);
        }

        public void a() {
            EasyLog.a("GattClientCallback", "Connect done.");
            this.b = true;
            if (this.c && BluetoothLeService.this.h != null) {
                BluetoothLeService.this.h.close();
            }
        }

        public final void b(BluetoothGatt bluetoothGatt) {
            if (bluetoothGatt.discoverServices()) {
                EasyLog.a("GattClientCallback", "Discover service action success.");
                return;
            }
            EasyLog.c("GattClientCallback", "Discover service action failed.");
            BluetoothLeService.this.x0(3, 1);
        }

        public void c(boolean z) {
            EasyLog.e("GattClientCallback", "Set positive: " + z);
            this.c = z;
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            EasyLog.a("GattClientCallback", "onCharacteristicChanged: connectDone=" + this.b + ", device=" + bluetoothGatt.getDevice() + ", targetDevice=" + BluetoothLeService.this.r + ", characteristic=" + Constants.a(bluetoothGattCharacteristic.getUuid().toString()) + ", value=" + BleUtils.a(bluetoothGattCharacteristic.getValue()));
            boolean equals = TextUtils.equals(BluetoothLeService.this.r, Objects.toString(bluetoothGatt.getDevice()));
            if (!this.b && equals && Constants.ServiceInfo.h.getUuid().equals(bluetoothGattCharacteristic.getUuid())) {
                BluetoothLeService.this.o0(BleUtils.b(BleUtils.f(bluetoothGattCharacteristic.getValue())));
            }
        }

        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            int i3;
            EasyLog.e("GattClientCallback", "onConnectionStateChange: isConnectDone=" + this.b + ", device=" + bluetoothGatt.getDevice() + ", targetDevice=" + BluetoothLeService.this.r + ", status=" + i + ", newState=" + i2);
            boolean equals = TextUtils.equals(BluetoothLeService.this.r, Objects.toString(bluetoothGatt.getDevice()));
            if (i != 0) {
                EasyLog.i("GattClientCallback", "Gatt client status: " + i);
                if (this.b || !equals) {
                    bluetoothGatt.close();
                } else if (i != 133 || (i3 = this.f9893a) <= 0) {
                    BluetoothLeService.this.x0(3, 1);
                } else {
                    this.f9893a = i3 - 1;
                    EasyLog.i("GattClientCallback", "Gatt reconnect...");
                    bluetoothGatt.close();
                    if (BluetoothLeService.this.k != null) {
                        BluetoothLeService.this.k.postDelayed(new Runnable() {
                            public void run() {
                                try {
                                    BluetoothDevice remoteDevice = BluetoothLeService.this.b.getRemoteDevice(BluetoothLeService.this.r);
                                    BluetoothLeService bluetoothLeService = BluetoothLeService.this;
                                    BluetoothGatt unused = bluetoothLeService.h = remoteDevice.connectGatt(bluetoothLeService, false, bluetoothLeService.i);
                                } catch (IllegalArgumentException e) {
                                    EasyLog.d("GattClientCallback", "Reconnect failed because of illegal argument.", e);
                                    BluetoothLeService.this.x0(3, 1);
                                }
                            }
                        }, 300);
                    } else {
                        EasyLog.i("GattClientCallback", "Handler is null, cancel reconnect.");
                        BluetoothLeService.this.x0(3, 1);
                    }
                }
                if (i == 257) {
                    EasyLog.c("GattClientCallback", "Receives GATT_FAILURE !!");
                }
            } else if (i2 == 0) {
                EasyLog.i("GattClientCallback", "Gatt disconnected");
                if (this.b || !equals) {
                    bluetoothGatt.close();
                } else {
                    BluetoothLeService.this.p0();
                }
            } else if (i2 == 2 && !this.b && equals) {
                BluetoothLeService.this.q.set(true);
                if (this.d.compareAndSet(false, true)) {
                    DebugTools.a("Ble-connect");
                    DebugTools.b("Ble-discoverServices");
                    if (!bluetoothGatt.requestMtu(512)) {
                        b(bluetoothGatt);
                        return;
                    }
                    return;
                }
                EasyLog.i("GattClientCallback", "Twice in onConnectionStateChange, ignored.");
            }
        }

        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            EasyLog.a("GattClientCallback", "onMtuChanged: mtu=" + i + ", status=" + i2);
            EasyLog.a("GattClientCallback", "Connected, Trying discoverService...");
            b(bluetoothGatt);
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            EasyLog.a("GattClientCallback", "onServicesDiscovered: connectDone=" + this.b + ", device=" + bluetoothGatt.getDevice() + ", targetDevice=" + BluetoothLeService.this.r + ", status=" + i);
            boolean equals = TextUtils.equals(BluetoothLeService.this.r, Objects.toString(bluetoothGatt.getDevice()));
            if (i != 0) {
                EasyLog.i("GattClientCallback", "ServicesDiscover failed with status: " + i);
                if (this.b || !equals) {
                    bluetoothGatt.close();
                } else {
                    BluetoothLeService.this.x0(3, 1);
                }
            } else if (!this.b && equals) {
                EasyLog.a("GattClientCallback", "Connected and services discovered ! Hooyaaah!");
                DebugTools.a("Ble-discoverServices");
                DebugTools.b("Ble-writeCharacteristics");
                if (bluetoothGatt.getService(Constants.ServiceInfo.f.getUuid()) != null) {
                    String substring = UUID.randomUUID().toString().substring(0, 6);
                    if (BluetoothLeService.this.N0(Constants.ServiceInfo.g.getUuid(), BleUtils.e(BluetoothLeService.this.q0(substring).toString()))) {
                        boolean unused = BluetoothLeService.this.L0(Constants.ServiceInfo.h.getUuid());
                        BluetoothLeService.this.D0(false);
                        synchronized (BluetoothLeService.this.F) {
                            for (BluetoothLeObserver onPinAvailable : BluetoothLeService.this.F) {
                                try {
                                    onPinAvailable.onPinAvailable(substring);
                                } catch (RemoteException e2) {
                                    EasyLog.d("GattClientCallback", "Error when invoke onPinAvailable.", e2);
                                }
                            }
                        }
                        return;
                    }
                    BluetoothLeService.this.x0(6, 1);
                }
            }
        }
    }

    public class GattServerCallback extends BluetoothGattServerCallback {

        /* renamed from: a  reason: collision with root package name */
        public boolean f9895a;
        public boolean b;
        public Map c;
        public Map d;
        public List e;
        public boolean f;
        public String g;
        public OnDeviceDisconnectListener h;

        public GattServerCallback() {
            this.f9895a = true;
            this.b = true;
            this.c = new ArrayMap();
            this.d = new ArrayMap();
            this.e = new LinkedList();
            this.f = true;
        }

        public void a() {
            if (!this.e.isEmpty()) {
                Pair pair = (Pair) this.e.get(0);
                BluetoothDevice bluetoothDevice = (BluetoothDevice) pair.first;
                String unused = BluetoothLeService.this.s = bluetoothDevice.getAddress();
                BluetoothLeService bluetoothLeService = BluetoothLeService.this;
                bluetoothLeService.v0(bluetoothLeService.s);
                EasyLog.e("GattServerCallback", "process cached client info. phone address:" + bluetoothDevice.getAddress());
                c();
                BluetoothLeService.this.n0((String) pair.second);
                this.e.remove(0);
                return;
            }
            this.f = true;
        }

        public void b() {
            try {
                this.f9895a = true;
                if (this.b) {
                    BluetoothDevice remoteDevice = BluetoothLeService.this.b.getRemoteDevice(BluetoothLeService.this.s);
                    EasyLog.e("GattServerCallback", "connectDone for " + BluetoothLeService.this.s);
                    BluetoothLeService.this.e.cancelConnection(remoteDevice);
                }
            } catch (IllegalArgumentException e2) {
                EasyLog.i("GattServerCallback", "cancelConnection for " + BluetoothLeService.this.s + " failed: " + e2.getMessage());
            }
        }

        public final void c() {
            this.f9895a = false;
            this.f = false;
        }

        public final void d(BluetoothDevice bluetoothDevice, byte[] bArr) {
            if (this.f || bluetoothDevice.getAddress().equals(BluetoothLeService.this.s)) {
                c();
                String unused = BluetoothLeService.this.s = bluetoothDevice.getAddress();
                BluetoothLeService bluetoothLeService = BluetoothLeService.this;
                bluetoothLeService.v0(bluetoothLeService.s);
                BluetoothLeService.this.n0(BleUtils.b(bArr));
                return;
            }
            EasyLog.e("GattServerCallback", "There is already a phone connecting, caching client info. phone address:" + bluetoothDevice.getAddress());
            this.e.add(new Pair(bluetoothDevice, BleUtils.b(bArr)));
        }

        public final byte[] e(BluetoothDevice bluetoothDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, int i2, byte[] bArr) {
            if (!z) {
                return bArr;
            }
            this.d.put(bluetoothDevice.getAddress(), bluetoothGattCharacteristic.getUuid());
            byte[] bArr2 = (byte[]) this.c.get(bluetoothDevice.getAddress());
            if (bArr2 == null) {
                bArr2 = new byte[1024];
                this.c.put(bluetoothDevice.getAddress(), bArr2);
            }
            if (i2 < 0 || bArr.length + i2 > bArr2.length) {
                return null;
            }
            System.arraycopy(bArr, 0, bArr2, i2, bArr.length);
            return null;
        }

        public final boolean f(BluetoothDevice bluetoothDevice, byte[] bArr) {
            if (BluetoothLeService.this.A != null) {
                try {
                    String string = new JSONObject(BleUtils.b(bArr)).getString("id");
                    String f2 = CarBluetoothMacRecord.f(BluetoothLeService.this.A, BluetoothLeService.this);
                    if (f2 == null) {
                        EasyLog.c("GattServerCallback", "invalid expect phone id : " + BluetoothLeService.this.A);
                        return true;
                    }
                    String a2 = ShaUtil.a(bluetoothDevice.getAddress());
                    if (!BluetoothLeService.this.A.equalsIgnoreCase(string) && !f2.equalsIgnoreCase(a2)) {
                        EasyLog.i("GattServerCallback", "expect directed ble connection, but this device id " + string + " is not equal expected device id " + BluetoothLeService.this.A);
                        BluetoothLeService.this.e.cancelConnection(bluetoothDevice);
                        return false;
                    }
                } catch (Exception e2) {
                    EasyLog.j("GattServerCallback", "Parsing client id failed.", e2);
                }
            }
            return true;
        }

        public void g() {
            this.e.clear();
            this.f = true;
        }

        public void h(String str, OnDeviceDisconnectListener onDeviceDisconnectListener) {
            this.g = str;
            this.h = onDeviceDisconnectListener;
        }

        public void i(boolean z) {
            EasyLog.e("GattServerCallback", "Set positive: " + z);
            this.b = z;
        }

        public void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i3, byte[] bArr) {
            byte[] e2;
            EasyLog.a("GattServerCallback", "onCharacteristicWriteRequest: device=" + bluetoothDevice + ", requestId=" + i2 + ", offset=" + i3 + ", preparedWrite=" + z + ", responseNeeded=" + z2 + ", characteristic={" + bluetoothGattCharacteristic.getUuid() + ", " + BleUtils.a(bArr) + "}");
            if (BluetoothLeService.this.e != null && z2) {
                BluetoothLeService.this.e.sendResponse(bluetoothDevice, i2, 0, i3, bArr);
            }
            if (Constants.ServiceInfo.g.getUuid().equals(bluetoothGattCharacteristic.getUuid()) && (e2 = e(bluetoothDevice, bluetoothGattCharacteristic, z, i3, bArr)) != null && f(bluetoothDevice, e2)) {
                d(bluetoothDevice, e2);
            }
        }

        public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i2, int i3) {
            if (bluetoothDevice == null) {
                EasyLog.c("GattServerCallback", "bluetooth device cannot be null.");
                return;
            }
            EasyLog.e("GattServerCallback", "onConnectionStateChange: device=" + bluetoothDevice + ", targetMac=" + BluetoothLeService.this.s + ", status=" + i2 + ", newState=" + i3);
            if (TextUtils.equals(bluetoothDevice.getAddress(), BluetoothLeService.this.r) && i3 == 0) {
                EasyLog.e("GattServerCallback", "Client(self) disconnected with GATT server.");
                BluetoothLeService.this.q.set(false);
            }
            if (TextUtils.equals(bluetoothDevice.getAddress(), this.g)) {
                EasyLog.c("GattServerCallback", "Listen device disconnected.");
                OnDeviceDisconnectListener onDeviceDisconnectListener = this.h;
                if (onDeviceDisconnectListener != null) {
                    onDeviceDisconnectListener.a();
                }
                this.g = null;
                this.h = null;
            }
            boolean equals = TextUtils.equals(BluetoothLeService.this.s, bluetoothDevice.getAddress());
            if (!this.f9895a && equals) {
                if (i2 != 0 || i3 == 0) {
                    b();
                    g();
                    BluetoothLeService.this.x0(4, 1);
                }
            }
        }

        public void onExecuteWrite(BluetoothDevice bluetoothDevice, int i2, boolean z) {
            EasyLog.a("GattServerCallback", "onExecuteWrite: device=" + bluetoothDevice + ", requestId=" + i2 + ", execute=" + z);
            byte[] bArr = (byte[]) this.c.remove(bluetoothDevice.getAddress());
            UUID uuid = (UUID) this.d.remove(bluetoothDevice.getAddress());
            if (uuid == null) {
                EasyLog.i("GattServerCallback", "Characteristic Uuid is null.");
            } else if (bArr == null) {
                EasyLog.i("GattServerCallback", "Cache byte[] is null.");
            } else {
                EasyLog.a("GattServerCallback", "Cache byte: " + BleUtils.a(bArr));
                if (BluetoothLeService.this.e != null) {
                    BluetoothLeService.this.e.sendResponse(bluetoothDevice, i2, 0, 0, (byte[]) null);
                }
                if (Constants.ServiceInfo.g.getUuid().equals(uuid)) {
                    d(bluetoothDevice, bArr);
                }
            }
        }

        public void onMtuChanged(BluetoothDevice bluetoothDevice, int i2) {
            EasyLog.a("GattServerCallback", "onMtuChanged: device=" + bluetoothDevice.getAddress() + ", mtu=" + i2);
        }

        public void onServiceAdded(int i2, BluetoothGattService bluetoothGattService) {
            EasyLog.e("GattServerCallback", "onServiceAdded: " + Constants.b(bluetoothGattService.getUuid().toString()));
            BluetoothLeService.this.m0();
        }
    }

    public interface OnDeviceDisconnectListener {
        void a();
    }

    public synchronized void A0() {
        try {
            EasyLog.e("BLEService", "Opening...");
            this.k = new Handler(Looper.getMainLooper());
            HandlerThread handlerThread = new HandlerThread("ConnectDelayer");
            handlerThread.start();
            if (handlerThread.getLooper() != null) {
                this.j = new BleConnectDelayer(handlerThread.getLooper());
            }
            i0(1);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void B0(BluetoothLeObserver bluetoothLeObserver) {
        synchronized (this.F) {
            try {
                if (!this.F.contains(bluetoothLeObserver)) {
                    this.F.add(bluetoothLeObserver);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void C0() {
        EasyLog.e("BLEService", "Reset state.");
        this.B.set(0);
    }

    public final void D0(boolean z2) {
        EasyLog.e("BLEService", "setConnectTimeout: " + z2);
        if (z2) {
            Handler handler = this.k;
            if (handler != null) {
                handler.postDelayed(this.l, 30000);
                return;
            }
            EasyLog.i("BLEService", "Enable timeout but handler is null, closed?");
            x0(3, 1);
            return;
        }
        Handler handler2 = this.k;
        if (handler2 != null) {
            handler2.removeCallbacks(this.l);
        }
    }

    public final synchronized boolean E0() {
        try {
            if (!t0()) {
                return false;
            }
            G0();
            return true;
        } catch (IllegalStateException e2) {
            EasyLog.j("BLEService", "Setup Bt failed because of illegal state.", e2);
            return false;
        }
    }

    public final void F0() {
        int i2;
        EasyLog.e("BLEService", "Starting advertiser.");
        int i3 = 1;
        AdvertisingSetParameters.Builder txPowerLevel = new AdvertisingSetParameters.Builder().setConnectable(true).setScannable(true).setLegacyMode(true).setPrimaryPhy(1).setTxPowerLevel(1);
        try {
            Field declaredField = AdvertisingSetParameters.Builder.class.getDeclaredField("mInterval");
            declaredField.setAccessible(true);
            declaredField.set(txPowerLevel, 48);
        } catch (Exception e2) {
            EasyLog.d("BLEService", "set Advertising interval failed. ", e2);
        }
        AdvertisingSetParameters build = txPowerLevel.build();
        AdvertiseSettings b0 = b0(true);
        AdvertiseData e0 = e0();
        AdvertiseData f0 = f0();
        int timeout = b0.getTimeout();
        if (timeout > 0) {
            if (timeout >= 10) {
                i3 = timeout / 10;
            }
            i2 = i3;
        } else {
            i2 = 0;
        }
        if (this.d != null) {
            if (this.m != null) {
                J0();
            }
            BluetoothLeAdvertiser bluetoothLeAdvertiser = this.d;
            AnonymousClass7 r13 = new AdvertisingSetCallback() {
                public void onAdvertisingEnabled(AdvertisingSet advertisingSet, boolean z, int i) {
                    if (z) {
                        EasyLog.c("BLEService", "Legacy advertiser should be only disabled on timeout, but was enabled!");
                    }
                }

                public void onAdvertisingSetStarted(AdvertisingSet advertisingSet, int i, int i2) {
                    EasyLog.e("BLEService", "onAdvertisingSetStarted status " + i2 + " advertisingSet: " + advertisingSet + " txPower " + i);
                    if (i2 == 0) {
                        BluetoothLeService.this.z0(1);
                    } else {
                        BluetoothLeService.this.x0(1, 3);
                    }
                    BluetoothLeService.this.m0();
                }
            };
            this.m = r13;
            bluetoothLeAdvertiser.startAdvertisingSet(build, e0, f0, (PeriodicAdvertisingParameters) null, (AdvertiseData) null, i2, 0, r13);
        }
    }

    public void G0() {
        if (H0()) {
            try {
                F0();
            } catch (Exception e2) {
                EasyLog.e("BLEService", "startAdvertising() e:" + e2);
            }
        }
    }

    public final boolean H0() {
        EasyLog.e("BLEService", "Starting Gatt Server");
        if (this.e != null) {
            EasyLog.i("BLEService", "startGattServer while mBluetoothGattServer is not null");
            BluetoothGattService bluetoothGattService = this.f;
            if (bluetoothGattService != null) {
                this.e.removeService(bluetoothGattService);
                this.f = null;
            }
            this.e.close();
            this.e = null;
        }
        this.g.g();
        this.g.i(false);
        BluetoothGattServer openGattServer = this.f9882a.openGattServer(this, this.g);
        this.e = openGattServer;
        if (openGattServer != null) {
            this.H = new CountDownLatch(2);
            BluetoothGattService g0 = g0();
            this.f = g0;
            this.e.addService(g0);
        } else {
            EasyLog.c("BLEService", "Opening gatt server failed.");
            x0(1, 3);
        }
        return this.e != null;
    }

    public void I0() {
        EasyLog.e("BLEService", "Starting scan...");
        DeviceCache deviceCache = new DeviceCache();
        this.o = deviceCache;
        deviceCache.l(new DeviceCache.OnDeviceChangeCallback() {
            public void a(DeviceCache.BtDevice btDevice) {
                BluetoothLeService.this.w0(false, btDevice);
            }

            public void b(DeviceCache.BtDevice btDevice) {
                BluetoothLeService.this.w0(true, btDevice);
            }
        });
        CompatLeScanner compatLeScanner = this.c;
        List c0 = c0();
        ScanSettings d0 = d0();
        AnonymousClass4 r3 = new CompatLeScanner.ScanCallback() {
            public void a(int i, ScanResult scanResult) {
                if (BluetoothLeService.this.o == null) {
                    EasyLog.i("BLEService", "onScanResult invoked when mDeviceCache is null.");
                } else if (i == 1) {
                    BluetoothLeService.this.o.i(scanResult);
                } else if (i == 0) {
                    BluetoothLeService.this.o.g(scanResult);
                }
            }

            public void b(int i) {
                EasyLog.c("BLEService", "Start scanning failed with error code: " + i);
                BluetoothLeService.this.x0(2, 1);
            }
        };
        this.n = r3;
        compatLeScanner.i(c0, d0, r3);
    }

    public final synchronized void J0() {
        EasyLog.e("BLEService", "Stopping advertisers.");
        if (!(!this.b.isEnabled() || this.d == null || this.m == null)) {
            CountDownLatch countDownLatch = this.H;
            if (countDownLatch != null) {
                try {
                    if (!countDownLatch.await(1500, TimeUnit.MILLISECONDS)) {
                        EasyLog.e("BLEService", "Waiting for advertising ready timeout");
                    }
                } catch (InterruptedException e2) {
                    EasyLog.d("BLEService", "BluetoothLeService READY.await() failed.", e2);
                }
                this.H = null;
            }
            this.d.stopAdvertisingSet(this.m);
        }
        this.g.g();
        this.m = null;
    }

    public void K0() {
        EasyLog.e("BLEService", "Stopping scan...");
        this.o = null;
        if (!this.b.isEnabled()) {
            EasyLog.i("BLEService", "Stop scan after bluetooth down, do nothing.");
            return;
        }
        CompatLeScanner compatLeScanner = this.c;
        if (compatLeScanner != null && this.n != null) {
            compatLeScanner.j();
            this.n = null;
            EasyLog.e("BLEService", "Stop scan success");
        }
    }

    public final boolean L0(UUID uuid) {
        BluetoothGatt bluetoothGatt = this.h;
        if (bluetoothGatt != null) {
            List<BluetoothGattService> services = bluetoothGatt.getServices();
            if (services != null && services.size() > 0) {
                for (BluetoothGattService characteristic : services) {
                    BluetoothGattCharacteristic characteristic2 = characteristic.getCharacteristic(uuid);
                    if (characteristic2 != null) {
                        return this.h.setCharacteristicNotification(characteristic2, true);
                    }
                }
            }
            EasyLog.i("BLEService", "writeCharacteristic: Characteristic(" + Constants.a(uuid.toString()) + ") not found.");
            return false;
        }
        EasyLog.i("BLEService", "subscribeCharacteristic: mBluetoothGatt is null, already disconnected ?");
        return false;
    }

    public void M0(BluetoothLeObserver bluetoothLeObserver) {
        synchronized (this.F) {
            this.F.remove(bluetoothLeObserver);
        }
    }

    public final boolean N0(UUID uuid, byte[] bArr) {
        EasyLog.a("BLEService", "Trying to send write characteristic(" + Constants.a(uuid.toString()) + ") request to remote gatt server, value=" + BleUtils.a(bArr));
        BluetoothGatt bluetoothGatt = this.h;
        if (bluetoothGatt != null) {
            List<BluetoothGattService> services = bluetoothGatt.getServices();
            if (services != null && services.size() > 0) {
                for (BluetoothGattService characteristic : services) {
                    BluetoothGattCharacteristic characteristic2 = characteristic.getCharacteristic(uuid);
                    if (characteristic2 != null) {
                        characteristic2.setValue(bArr);
                        return this.h.writeCharacteristic(characteristic2);
                    }
                }
            }
            EasyLog.i("BLEService", "writeCharacteristic: Characteristic(" + Constants.a(uuid.toString()) + ") not found.");
            return false;
        }
        EasyLog.i("BLEService", "writeCharacteristic: mBluetoothGatt is null, already disconnected ?");
        return false;
    }

    public final void O0(UUID uuid, byte[] bArr) {
        BluetoothGattCharacteristic characteristic = this.e.getService(Constants.ServiceInfo.f.getUuid()).getCharacteristic(uuid);
        if (characteristic == null) {
            EasyLog.c("BLEService", "notify server info failed. characteristic is null ");
            x0(3, 1);
        } else if (!characteristic.setValue(bArr)) {
            EasyLog.c("BLEService", "notify server info failed. setting characteristic not successful");
            x0(3, 1);
        } else {
            this.e.notifyCharacteristicChanged(this.b.getRemoteDevice(this.s), characteristic, true);
        }
    }

    public final AdvertiseSettings b0(boolean z2) {
        AdvertiseSettings.Builder builder = new AdvertiseSettings.Builder();
        builder.setAdvertiseMode(2);
        builder.setTxPowerLevel(3);
        builder.setTimeout(0);
        return builder.build();
    }

    public final List c0() {
        ArrayList arrayList = new ArrayList();
        ScanFilter.Builder builder = new ScanFilter.Builder();
        builder.setServiceUuid(Constants.ServiceInfo.b);
        arrayList.add(builder.build());
        return arrayList;
    }

    public final ScanSettings d0() {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        builder.setScanMode(2);
        return builder.build();
    }

    public final AdvertiseData e0() {
        return BleAdvertisementBuilder.a(this.x, this.t, this.u, this.y, this.z, this.G, CarBluetoothMacRecord.f(this.A, getApplicationContext()), getApplicationContext());
    }

    public final AdvertiseData f0() {
        return BleAdvertisementBuilder.b(this.w);
    }

    public final BluetoothGattService g0() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(Constants.ServiceInfo.f.getUuid(), 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(Constants.ServiceInfo.g.getUuid(), 8, 16);
        BluetoothGattCharacteristic bluetoothGattCharacteristic2 = new BluetoothGattCharacteristic(Constants.ServiceInfo.h.getUuid(), 16, 1);
        bluetoothGattCharacteristic2.addDescriptor(new BluetoothGattDescriptor(Constants.ServiceInfo.f9902a.getUuid(), 16));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic2);
        return bluetoothGattService;
    }

    public final boolean h0(int i2, int i3) {
        EasyLog.e("BLEService", "Change state to " + i3 + " if current state is " + i2);
        boolean compareAndSet = this.B.compareAndSet(i2, i3);
        if (compareAndSet) {
            EasyLog.e("BLEService", "Change state to " + i3 + " success");
        } else {
            EasyLog.i("BLEService", "Change state to " + i3 + " failed");
        }
        return compareAndSet;
    }

    public final void i0(final int i2) {
        BluetoothAdapter bluetoothAdapter = this.b;
        if (bluetoothAdapter == null) {
            return;
        }
        if (!bluetoothAdapter.isEnabled()) {
            IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
            AnonymousClass2 r3 = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
                    EasyLog.e("BLEService", "Received bluetooth state: " + intExtra);
                    if (intExtra == 12) {
                        try {
                            BluetoothLeService bluetoothLeService = BluetoothLeService.this;
                            bluetoothLeService.unregisterReceiver(bluetoothLeService.p);
                        } catch (RuntimeException unused) {
                        }
                        if (!BluetoothLeService.this.E0()) {
                            int i = i2;
                            if (i > 0) {
                                BluetoothLeService.this.i0(i - 1);
                            } else {
                                BluetoothLeService.this.x0(1, 2);
                            }
                        }
                    }
                }
            };
            this.p = r3;
            registerReceiver(r3, intentFilter);
            boolean enable = this.b.enable();
            EasyLog.e("BLEService", "Enabling Bluetooth Action: " + enable);
            if (!enable) {
                try {
                    unregisterReceiver(this.p);
                } catch (RuntimeException unused) {
                }
                x0(1, 2);
            }
        } else if (E0()) {
        } else {
            if (i2 > 0) {
                i0(i2 - 1);
            } else {
                x0(1, 2);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:1|2|3|(1:5)|8|(3:10|(1:12)|13)|14|15|16|17|(6:19|(1:21)|22|(1:24)|25|(1:29))|30|31) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002c */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0037 A[Catch:{ all -> 0x0013 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void j0() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "BLEService"
            java.lang.String r1 = "Closing..."
            com.easy.logger.EasyLog.e(r0, r1)     // Catch:{ all -> 0x0013 }
            android.os.Handler r0 = r3.k     // Catch:{ all -> 0x0013 }
            r1 = 0
            if (r0 == 0) goto L_0x0015
            r0.removeCallbacksAndMessages(r1)     // Catch:{ all -> 0x0013 }
            r3.k = r1     // Catch:{ all -> 0x0013 }
            goto L_0x0015
        L_0x0013:
            r0 = move-exception
            goto L_0x0066
        L_0x0015:
            com.share.connect.ble.BluetoothLeService$BleConnectDelayer r0 = r3.j     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0027
            r0.removeCallbacksAndMessages(r1)     // Catch:{ all -> 0x0013 }
            android.os.Looper r0 = r0.getLooper()     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0025
            r0.quitSafely()     // Catch:{ all -> 0x0013 }
        L_0x0025:
            r3.j = r1     // Catch:{ all -> 0x0013 }
        L_0x0027:
            android.content.BroadcastReceiver r0 = r3.p     // Catch:{ Exception -> 0x002c }
            r3.unregisterReceiver(r0)     // Catch:{ Exception -> 0x002c }
        L_0x002c:
            r3.J0()     // Catch:{ all -> 0x0013 }
            android.bluetooth.BluetoothAdapter r0 = r3.b     // Catch:{ all -> 0x0013 }
            boolean r0 = r0.isEnabled()     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0050
            android.bluetooth.BluetoothGatt r0 = r3.h     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x003e
            r0.close()     // Catch:{ all -> 0x0013 }
        L_0x003e:
            android.bluetooth.BluetoothGattServer r0 = r3.e     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0045
            r0.close()     // Catch:{ all -> 0x0013 }
        L_0x0045:
            com.share.connect.ble.CompatLeScanner r0 = r3.c     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0050
            com.share.connect.ble.CompatLeScanner$ScanCallback r2 = r3.n     // Catch:{ all -> 0x0013 }
            if (r2 == 0) goto L_0x0050
            r0.j()     // Catch:{ all -> 0x0013 }
        L_0x0050:
            r3.p0()     // Catch:{ all -> 0x0013 }
            r3.d = r1     // Catch:{ all -> 0x0013 }
            r3.h = r1     // Catch:{ all -> 0x0013 }
            r3.e = r1     // Catch:{ all -> 0x0013 }
            r3.c = r1     // Catch:{ all -> 0x0013 }
            r3.n = r1     // Catch:{ all -> 0x0013 }
            java.lang.String r0 = "BLEService"
            java.lang.String r1 = "Closed."
            com.easy.logger.EasyLog.e(r0, r1)     // Catch:{ all -> 0x0013 }
            monitor-exit(r3)
            return
        L_0x0066:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.share.connect.ble.BluetoothLeService.j0():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0094, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void k0(final java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "BLEService"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0029 }
            r1.<init>()     // Catch:{ all -> 0x0029 }
            java.lang.String r2 = "Connecting device="
            r1.append(r2)     // Catch:{ all -> 0x0029 }
            r1.append(r6)     // Catch:{ all -> 0x0029 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0029 }
            com.easy.logger.EasyLog.e(r0, r1)     // Catch:{ all -> 0x0029 }
            android.bluetooth.BluetoothAdapter r0 = r5.b     // Catch:{ all -> 0x0029 }
            r1 = 3
            if (r0 != 0) goto L_0x002b
            java.lang.String r6 = "BLEService"
            java.lang.String r0 = "BluetoothAdapter not initialized."
            com.easy.logger.EasyLog.c(r6, r0)     // Catch:{ all -> 0x0029 }
            r6 = 2
            r5.x0(r1, r6)     // Catch:{ all -> 0x0029 }
            monitor-exit(r5)
            return
        L_0x0029:
            r6 = move-exception
            goto L_0x0095
        L_0x002b:
            if (r6 != 0) goto L_0x003a
            java.lang.String r6 = "BLEService"
            java.lang.String r0 = "Invalid address."
            com.easy.logger.EasyLog.c(r6, r0)     // Catch:{ all -> 0x0029 }
            r6 = 4
            r5.x0(r1, r6)     // Catch:{ all -> 0x0029 }
            monitor-exit(r5)
            return
        L_0x003a:
            r0 = 0
            r2 = 1
            boolean r0 = r5.h0(r0, r2)     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x004f
            java.lang.String r6 = "BLEService"
            java.lang.String r0 = "Conflicted. state is busy now."
            com.easy.logger.EasyLog.i(r6, r0)     // Catch:{ all -> 0x0029 }
            r6 = 6
            r5.x0(r1, r6)     // Catch:{ all -> 0x0029 }
            monitor-exit(r5)
            return
        L_0x004f:
            android.bluetooth.BluetoothGatt r0 = r5.h     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x008c
            java.lang.String r0 = "BLEService"
            java.lang.String r3 = "Disconnecting existing different bluetoothGatt connection."
            com.easy.logger.EasyLog.i(r0, r3)     // Catch:{ all -> 0x0029 }
            com.share.connect.ble.BluetoothLeService$GattClientCallback r0 = r5.i     // Catch:{ all -> 0x0029 }
            r0.a()     // Catch:{ all -> 0x0029 }
            com.share.connect.ble.BluetoothLeService$GattServerCallback r0 = r5.g     // Catch:{ all -> 0x0029 }
            java.lang.String r3 = r5.r     // Catch:{ all -> 0x0029 }
            com.share.connect.ble.BluetoothLeService$5 r4 = new com.share.connect.ble.BluetoothLeService$5     // Catch:{ all -> 0x0029 }
            r4.<init>(r6)     // Catch:{ all -> 0x0029 }
            r0.h(r3, r4)     // Catch:{ all -> 0x0029 }
            android.bluetooth.BluetoothGatt r0 = r5.h     // Catch:{ all -> 0x0029 }
            r0.close()     // Catch:{ all -> 0x0029 }
            r0 = 0
            r5.h = r0     // Catch:{ all -> 0x0029 }
            android.os.Handler r0 = r5.k     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0081
            java.lang.Runnable r6 = r5.l0(r6)     // Catch:{ all -> 0x0029 }
            r1 = 500(0x1f4, double:2.47E-321)
            r0.postDelayed(r6, r1)     // Catch:{ all -> 0x0029 }
            goto L_0x0093
        L_0x0081:
            java.lang.String r6 = "BLEService"
            java.lang.String r0 = "Handler is null, share service may already closed."
            com.easy.logger.EasyLog.i(r6, r0)     // Catch:{ all -> 0x0029 }
            r5.x0(r1, r2)     // Catch:{ all -> 0x0029 }
            goto L_0x0093
        L_0x008c:
            java.lang.Runnable r6 = r5.l0(r6)     // Catch:{ all -> 0x0029 }
            r6.run()     // Catch:{ all -> 0x0029 }
        L_0x0093:
            monitor-exit(r5)
            return
        L_0x0095:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.share.connect.ble.BluetoothLeService.k0(java.lang.String):void");
    }

    public final Runnable l0(final String str) {
        return new Runnable() {
            public void run() {
                try {
                    BluetoothDevice c = BluetoothLeService.this.s0(str);
                    GattClientCallback unused = BluetoothLeService.this.i = new GattClientCallback();
                    BluetoothLeService.this.i.c(true);
                    DebugTools.b("Ble-connect");
                    BluetoothLeService bluetoothLeService = BluetoothLeService.this;
                    BluetoothGatt unused2 = bluetoothLeService.h = c.connectGatt(bluetoothLeService, false, bluetoothLeService.i, 2);
                    String unused3 = BluetoothLeService.this.r = str;
                    BluetoothLeService.this.D0(true);
                } catch (IllegalArgumentException e) {
                    EasyLog.d("BLEService", "Connect failed because of illegal argument.", e);
                    BluetoothLeService.this.x0(3, 1);
                }
            }
        };
    }

    public final void m0() {
        new Thread(new a(this)).start();
    }

    public final void n0(String str) {
        List list;
        String str2 = str;
        EasyLog.e("BLEService", "Client info: " + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("id");
            String string2 = jSONObject.getString("name");
            String string3 = jSONObject.getString("model");
            int i2 = jSONObject.getInt("band");
            String string4 = jSONObject.getString("mac");
            int optInt = jSONObject.optInt("type", 1001);
            String optString = jSONObject.optString("manufactures", (String) null);
            int optInt2 = jSONObject.optInt("channel", 0);
            List list2 = this.F;
            synchronized (list2) {
                try {
                    for (BluetoothLeObserver onClientInfoReceived : this.F) {
                        list = list2;
                        try {
                            onClientInfoReceived.onClientInfoReceived(string, string2, string3, i2, string4, optInt, optString, optInt2);
                        } catch (RemoteException e2) {
                            EasyLog.d("BLEService", "Observer.onClientInfoReceived(...) failed.", e2);
                            x0(4, 1);
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                        list2 = list;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    list = list2;
                    throw th;
                }
            }
        } catch (Exception e3) {
            EasyLog.d("BLEService", "Parsing client info failed.", e3);
            x0(4, 1);
        }
    }

    public final void o0(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("ssid");
            String string2 = jSONObject.getString("psk");
            String string3 = jSONObject.getString("mac");
            int i2 = jSONObject.getInt("freq");
            synchronized (this.F) {
                for (BluetoothLeObserver onServerInfoReceived : this.F) {
                    try {
                        onServerInfoReceived.onServerInfoReceived(string, string2, string3, i2);
                    } catch (RemoteException e2) {
                        EasyLog.d("BLEService", "Observer.onServerInfoReceived(...) failed.", e2);
                        x0(3, 1);
                    }
                }
            }
        } catch (Exception e3) {
            EasyLog.d("BLEService", "Parsing server info failed.", e3);
            x0(3, 1);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.E;
    }

    public void onCreate() {
        super.onCreate();
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
        this.f9882a = bluetoothManager;
        if (bluetoothManager != null) {
            this.b = bluetoothManager.getAdapter();
        }
        if (this.f9882a == null || this.b == null) {
            EasyLog.c("BLEService", "mBluetoothManager=" + this.f9882a + ", mBluetoothAdapter=" + this.b);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        j0();
    }

    public synchronized void p0() {
        try {
            EasyLog.e("BLEService", "disconnect...");
            C0();
            if (this.h != null) {
                EasyLog.e("BLEService", "close exist bluetoothGatt connection");
                this.h.close();
                this.h = null;
            }
            if (this.e != null && !TextUtils.isEmpty(this.s)) {
                BluetoothDevice remoteDevice = this.b.getRemoteDevice(this.s);
                EasyLog.e("BLEService", "cancelConnection for " + this.s);
                this.e.cancelConnection(remoteDevice);
            }
        } catch (IllegalArgumentException e2) {
            EasyLog.d("BLEService", "cancelConnection failed because of illegal argument.", e2);
        } catch (Throwable th) {
            throw th;
        }
        D0(false);
        this.s = null;
        this.r = null;
        this.q.set(false);
    }

    public final JSONObject q0(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.t);
            jSONObject.put("name", this.v);
            jSONObject.put("pinCodeOrAuthentication", str);
            jSONObject.put("band", this.C);
            jSONObject.put("mac", this.D);
            EasyLog.a("BLEService", "Client info: " + jSONObject.toString());
            return jSONObject;
        } catch (Exception e2) {
            EasyLog.d("BLEService", "Generate receiver info failed.", e2);
            return null;
        }
    }

    public final JSONObject r0(String str, String str2, String str3, int i2, String str4, int i3, String str5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", str4);
            jSONObject.put("ssid", str);
            jSONObject.put("psk", str2);
            jSONObject.put("mac", str3);
            jSONObject.put("freq", i2);
            jSONObject.put(RtspHeaders.Values.PORT, 0);
            jSONObject.put("type", i3);
            if (!TextUtils.isEmpty(str5)) {
                jSONObject.put("ipAddress", str5);
            }
            return jSONObject;
        } catch (Exception e2) {
            EasyLog.d("BLEService", "Generate server info failed.", e2);
            return null;
        }
    }

    public final BluetoothDevice s0(String str) {
        BluetoothDevice remoteDevice = this.b.getRemoteDevice(str);
        int bondState = remoteDevice.getBondState();
        EasyLog.e("BLEService", "Bond state = " + bondState);
        return remoteDevice;
    }

    public final boolean t0() {
        this.d = this.b.getBluetoothLeAdvertiser();
        this.c = CompatLeScanner.h(this.b.getBluetoothLeScanner());
        StringBuilder sb = new StringBuilder();
        sb.append("initialize: advertiser=");
        sb.append(this.d != null);
        sb.append(", scanner=");
        sb.append(this.c != null);
        EasyLog.e("BLEService", sb.toString());
        return (this.d == null || this.c == null) ? false : true;
    }

    public final /* synthetic */ void u0() {
        try {
            Thread.sleep(50);
            CountDownLatch countDownLatch = this.H;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        } catch (InterruptedException e2) {
            EasyLog.d("BLEService", "delay to count down service ready failed.", e2);
        }
    }

    public final void v0(String str) {
        synchronized (this.F) {
            for (BluetoothLeObserver onReceivedClientBleMac : this.F) {
                try {
                    onReceivedClientBleMac.onReceivedClientBleMac(str);
                } catch (RemoteException e2) {
                    EasyLog.d("BLEService", "Observer.onReceivedClientBleMac(" + str + ") failed.", e2);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.util.Iterator} */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.util.Iterator] */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void w0(boolean r6, com.share.connect.ble.DeviceCache.BtDevice r7) {
        /*
            r5 = this;
            java.util.List r0 = r5.F
            monitor-enter(r0)
            java.util.List r5 = r5.F     // Catch:{ all -> 0x001b }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x001b }
        L_0x0009:
            boolean r1 = r5.hasNext()     // Catch:{ all -> 0x001b }
            if (r1 == 0) goto L_0x0046
            java.lang.Object r1 = r5.next()     // Catch:{ all -> 0x001b }
            com.share.connect.ble.BluetoothLeObserver r1 = (com.share.connect.ble.BluetoothLeObserver) r1     // Catch:{ all -> 0x001b }
            if (r6 == 0) goto L_0x001f
            r1.onDeviceMatch(r7)     // Catch:{ RemoteException -> 0x001d }
            goto L_0x0009
        L_0x001b:
            r5 = move-exception
            goto L_0x0048
        L_0x001d:
            r1 = move-exception
            goto L_0x0023
        L_0x001f:
            r1.onDeviceLost(r7)     // Catch:{ RemoteException -> 0x001d }
            goto L_0x0009
        L_0x0023:
            java.lang.String r2 = "BLEService"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x001b }
            r3.<init>()     // Catch:{ all -> 0x001b }
            java.lang.String r4 = "Observer."
            r3.append(r4)     // Catch:{ all -> 0x001b }
            if (r6 == 0) goto L_0x0034
            java.lang.String r4 = "onDeviceMatch"
            goto L_0x0036
        L_0x0034:
            java.lang.String r4 = "onDeviceLost"
        L_0x0036:
            r3.append(r4)     // Catch:{ all -> 0x001b }
            java.lang.String r4 = " failed"
            r3.append(r4)     // Catch:{ all -> 0x001b }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x001b }
            com.easy.logger.EasyLog.d(r2, r3, r1)     // Catch:{ all -> 0x001b }
            goto L_0x0009
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return
        L_0x0048:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.share.connect.ble.BluetoothLeService.w0(boolean, com.share.connect.ble.DeviceCache$BtDevice):void");
    }

    public final void x0(int i2, int i3) {
        synchronized (this.F) {
            for (BluetoothLeObserver onFailure : this.F) {
                try {
                    onFailure.onFailure(i2, i3);
                } catch (RemoteException e2) {
                    EasyLog.d("BLEService", "Observer.onFailure(" + i2 + ", " + i3 + ") failed.", e2);
                }
            }
        }
    }

    public final void y0() {
        synchronized (this.F) {
            for (BluetoothLeObserver onServerAddressSent : this.F) {
                try {
                    onServerAddressSent.onServerAddressSent();
                } catch (Exception e2) {
                    EasyLog.d("BLEService", "notifyServerAddressSent Exception", e2);
                }
            }
        }
    }

    public final void z0(int i2) {
        synchronized (this.F) {
            for (BluetoothLeObserver onSuccess : this.F) {
                try {
                    onSuccess.onSuccess(i2);
                } catch (RemoteException e2) {
                    EasyLog.d("BLEService", "Observer.onSuccess(" + i2 + ") failed.", e2);
                }
            }
        }
    }
}
