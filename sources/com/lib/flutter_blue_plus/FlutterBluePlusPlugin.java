package com.lib.flutter_blue_plus;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.here.posclient.analytics.TrackerEvent;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.p2.e;
import com.meizu.common.widget.MzContactsContract;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.upuphone.starrynet.api.StConstant;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import org.apache.commons.lang3.BooleanUtils;

public class FlutterBluePlusPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler, PluginRegistry.RequestPermissionsResultListener, PluginRegistry.ActivityResultListener, ActivityAware {

    /* renamed from: a  reason: collision with root package name */
    public LogLevel f9260a = LogLevel.DEBUG;
    public Context b;
    public MethodChannel c;
    public BluetoothManager d;
    public BluetoothAdapter e;
    public boolean f = false;
    public FlutterPlugin.FlutterPluginBinding g;
    public ActivityPluginBinding h;
    public final Semaphore i = new Semaphore(1);
    public final Map j = new ConcurrentHashMap();
    public final Map k = new ConcurrentHashMap();
    public final Map l = new ConcurrentHashMap();
    public final Map m = new ConcurrentHashMap();
    public final Map n = new ConcurrentHashMap();
    public final Map o = new ConcurrentHashMap();
    public final Map p = new ConcurrentHashMap();
    public final Map q = new ConcurrentHashMap();
    public final Map r = new ConcurrentHashMap();
    public HashMap s = new HashMap();
    public final Map t = new HashMap();
    public int u = 1452;
    public final int v = 1879842617;
    public final BroadcastReceiver w = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            BluetoothLeScanner bluetoothLeScanner;
            String action = intent.getAction();
            if (action != null && "android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                FlutterBluePlusPlugin flutterBluePlusPlugin = FlutterBluePlusPlugin.this;
                LogLevel logLevel = LogLevel.DEBUG;
                flutterBluePlusPlugin.x0(logLevel, "OnAdapterStateChanged: " + FlutterBluePlusPlugin.J(intExtra));
                if (intExtra == 12 && FlutterBluePlusPlugin.this.e != null && FlutterBluePlusPlugin.this.f && (bluetoothLeScanner = FlutterBluePlusPlugin.this.e.getBluetoothLeScanner()) != null) {
                    FlutterBluePlusPlugin.this.x0(logLevel, "calling stopScan (Bluetooth Restarted)");
                    bluetoothLeScanner.stopScan(FlutterBluePlusPlugin.this.j0());
                    boolean unused = FlutterBluePlusPlugin.this.f = false;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("adapter_state", Integer.valueOf(FlutterBluePlusPlugin.M(intExtra)));
                FlutterBluePlusPlugin.this.n0("OnAdapterStateChanged", hashMap);
                if (intExtra == 13 || intExtra == 10) {
                    FlutterBluePlusPlugin.this.Z("adapterTurnOff");
                }
            }
        }
    };
    public final BroadcastReceiver x = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
                BluetoothDevice bluetoothDevice = Build.VERSION.SDK_INT >= 33 ? (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE", BluetoothDevice.class) : (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
                int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", -1);
                FlutterBluePlusPlugin flutterBluePlusPlugin = FlutterBluePlusPlugin.this;
                LogLevel logLevel = LogLevel.DEBUG;
                flutterBluePlusPlugin.x0(logLevel, "OnBondStateChanged: " + FlutterBluePlusPlugin.W(intExtra) + " prev: " + FlutterBluePlusPlugin.W(intExtra2));
                String address = bluetoothDevice.getAddress();
                if (intExtra == 11) {
                    FlutterBluePlusPlugin.this.l.put(address, bluetoothDevice);
                } else {
                    FlutterBluePlusPlugin.this.l.remove(address);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("remote_id", address);
                hashMap.put("bond_state", Integer.valueOf(FlutterBluePlusPlugin.R(intExtra)));
                hashMap.put("prev_state", Integer.valueOf(FlutterBluePlusPlugin.R(intExtra2)));
                FlutterBluePlusPlugin.this.n0("OnBondStateChanged", hashMap);
            }
        }
    };
    public ScanCallback y;
    public final BluetoothGattCallback z = new BluetoothGattCallback() {
        public final boolean a(BluetoothGatt bluetoothGatt, int i, String str) {
            if (i == 2) {
                if (FlutterBluePlusPlugin.this.k.get(str) == null && FlutterBluePlusPlugin.this.n.get(str) == null) {
                    FlutterBluePlusPlugin.this.x0(LogLevel.DEBUG, "[unexpected connection] disconnecting now");
                    FlutterBluePlusPlugin.this.j.remove(str);
                    FlutterBluePlusPlugin.this.l.remove(str);
                    bluetoothGatt.disconnect();
                    bluetoothGatt.close();
                    return true;
                }
            } else if (i == 0 && FlutterBluePlusPlugin.this.k.get(str) == null && FlutterBluePlusPlugin.this.j.get(str) == null && FlutterBluePlusPlugin.this.n.get(str) == null) {
                FlutterBluePlusPlugin.this.x0(LogLevel.DEBUG, "[unexpected connection] disconnect complete");
                FlutterBluePlusPlugin.this.l.remove(str);
                bluetoothGatt.close();
                return true;
            }
            return false;
        }

        public void b(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
            if (FlutterBluePlusPlugin.this.B0(bluetoothGattCharacteristic.getService().getUuid()) == "1800" && FlutterBluePlusPlugin.this.B0(bluetoothGattCharacteristic.getUuid()) == "2A05") {
                FlutterBluePlusPlugin.this.n0("OnServicesReset", FlutterBluePlusPlugin.this.P(bluetoothGatt.getDevice()));
            }
            BluetoothGattService i0 = FlutterBluePlusPlugin.i0(bluetoothGatt, bluetoothGattCharacteristic);
            HashMap hashMap = new HashMap();
            hashMap.put("remote_id", bluetoothGatt.getDevice().getAddress());
            hashMap.put(StConstant.KEY_PAYLOAD_MESSAGE_SERVICE_UUID, FlutterBluePlusPlugin.this.B0(bluetoothGattCharacteristic.getService().getUuid()));
            hashMap.put("characteristic_uuid", FlutterBluePlusPlugin.this.B0(bluetoothGattCharacteristic.getUuid()));
            hashMap.put(AccountConstantKt.RESPONSE_VALUE, FlutterBluePlusPlugin.X(bArr));
            hashMap.put("success", Integer.valueOf(i == 0 ? 1 : 0));
            hashMap.put(MzContactsContract.MzNetContacts.ERROR_CODE_KEY, Integer.valueOf(i));
            hashMap.put("error_string", FlutterBluePlusPlugin.c0(i));
            if (i0 != null) {
                hashMap.put("primary_service_uuid", FlutterBluePlusPlugin.this.B0(i0.getUuid()));
            }
            FlutterBluePlusPlugin.this.n0("OnCharacteristicReceived", hashMap);
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            LogLevel logLevel = LogLevel.DEBUG;
            FlutterBluePlusPlugin.this.x0(logLevel, "onCharacteristicChanged:");
            FlutterBluePlusPlugin flutterBluePlusPlugin = FlutterBluePlusPlugin.this;
            flutterBluePlusPlugin.x0(logLevel, "  chr: " + FlutterBluePlusPlugin.this.B0(bluetoothGattCharacteristic.getUuid()));
            b(bluetoothGatt, bluetoothGattCharacteristic, bArr, 0);
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
            LogLevel logLevel = i == 0 ? LogLevel.DEBUG : LogLevel.ERROR;
            FlutterBluePlusPlugin.this.x0(logLevel, "onCharacteristicRead:");
            FlutterBluePlusPlugin flutterBluePlusPlugin = FlutterBluePlusPlugin.this;
            flutterBluePlusPlugin.x0(logLevel, "  chr: " + FlutterBluePlusPlugin.this.B0(bluetoothGattCharacteristic.getUuid()));
            FlutterBluePlusPlugin flutterBluePlusPlugin2 = FlutterBluePlusPlugin.this;
            flutterBluePlusPlugin2.x0(logLevel, "  status: " + FlutterBluePlusPlugin.c0(i) + " (" + i + ")");
            b(bluetoothGatt, bluetoothGattCharacteristic, bArr, i);
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            LogLevel logLevel = i == 0 ? LogLevel.DEBUG : LogLevel.ERROR;
            FlutterBluePlusPlugin.this.x0(logLevel, "onCharacteristicWrite:");
            FlutterBluePlusPlugin.this.x0(logLevel, "  chr: " + FlutterBluePlusPlugin.this.B0(bluetoothGattCharacteristic.getUuid()));
            FlutterBluePlusPlugin.this.x0(logLevel, "  status: " + FlutterBluePlusPlugin.c0(i) + " (" + i + ")");
            BluetoothGattService i0 = FlutterBluePlusPlugin.i0(bluetoothGatt, bluetoothGattCharacteristic);
            String address = bluetoothGatt.getDevice().getAddress();
            String B0 = FlutterBluePlusPlugin.this.B0(bluetoothGattCharacteristic.getService().getUuid());
            String B02 = FlutterBluePlusPlugin.this.B0(bluetoothGattCharacteristic.getUuid());
            String str = "";
            String str2 = address + AccountConstantKt.CODE_SEPARTOR + B0 + AccountConstantKt.CODE_SEPARTOR + B02 + AccountConstantKt.CODE_SEPARTOR + (i0 != null ? FlutterBluePlusPlugin.this.B0(i0.getUuid()) : str);
            if (FlutterBluePlusPlugin.this.o.get(str2) != null) {
                str = (String) FlutterBluePlusPlugin.this.o.get(str2);
            }
            FlutterBluePlusPlugin.this.o.remove(str2);
            HashMap hashMap = new HashMap();
            hashMap.put("remote_id", address);
            hashMap.put(StConstant.KEY_PAYLOAD_MESSAGE_SERVICE_UUID, B0);
            hashMap.put("characteristic_uuid", B02);
            hashMap.put(AccountConstantKt.RESPONSE_VALUE, str);
            hashMap.put("success", Integer.valueOf(i == 0 ? 1 : 0));
            hashMap.put(MzContactsContract.MzNetContacts.ERROR_CODE_KEY, Integer.valueOf(i));
            hashMap.put("error_string", FlutterBluePlusPlugin.c0(i));
            if (i0 != null) {
                hashMap.put("primary_service_uuid", FlutterBluePlusPlugin.this.B0(i0.getUuid()));
            }
            FlutterBluePlusPlugin.this.n0("OnCharacteristicWritten", hashMap);
        }

        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            try {
                FlutterBluePlusPlugin flutterBluePlusPlugin = FlutterBluePlusPlugin.this;
                flutterBluePlusPlugin.I(flutterBluePlusPlugin.i);
                FlutterBluePlusPlugin flutterBluePlusPlugin2 = FlutterBluePlusPlugin.this;
                LogLevel logLevel = LogLevel.DEBUG;
                flutterBluePlusPlugin2.x0(logLevel, "onConnectionStateChange:" + FlutterBluePlusPlugin.Y(i2));
                FlutterBluePlusPlugin flutterBluePlusPlugin3 = FlutterBluePlusPlugin.this;
                flutterBluePlusPlugin3.x0(logLevel, "  status: " + FlutterBluePlusPlugin.l0(i));
                if (i2 == 2 || i2 == 0) {
                    String address = bluetoothGatt.getDevice().getAddress();
                    if (!a(bluetoothGatt, i2, address)) {
                        if (i2 == 2) {
                            FlutterBluePlusPlugin.this.j.put(address, bluetoothGatt);
                            FlutterBluePlusPlugin.this.k.remove(address);
                            FlutterBluePlusPlugin.this.m.put(address, 23);
                        }
                        if (i2 == 0) {
                            FlutterBluePlusPlugin.this.j.remove(address);
                            FlutterBluePlusPlugin.this.k.remove(address);
                            FlutterBluePlusPlugin.this.l.remove(address);
                            if (FlutterBluePlusPlugin.this.n.containsKey(address)) {
                                FlutterBluePlusPlugin.this.x0(logLevel, "autoconnect is true. skipping gatt.close()");
                            } else {
                                bluetoothGatt.close();
                            }
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("remote_id", address);
                        hashMap.put("connection_state", Integer.valueOf(FlutterBluePlusPlugin.U(i2)));
                        hashMap.put("disconnect_reason_code", Integer.valueOf(i));
                        hashMap.put("disconnect_reason_string", FlutterBluePlusPlugin.l0(i));
                        FlutterBluePlusPlugin.this.n0("OnConnectionStateChanged", hashMap);
                        FlutterBluePlusPlugin.this.i.release();
                    }
                }
            } finally {
                FlutterBluePlusPlugin.this.i.release();
            }
        }

        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i, byte[] bArr) {
            LogLevel logLevel = i == 0 ? LogLevel.DEBUG : LogLevel.ERROR;
            FlutterBluePlusPlugin.this.x0(logLevel, "onDescriptorRead:");
            FlutterBluePlusPlugin flutterBluePlusPlugin = FlutterBluePlusPlugin.this;
            flutterBluePlusPlugin.x0(logLevel, "  chr: " + FlutterBluePlusPlugin.this.B0(bluetoothGattDescriptor.getCharacteristic().getUuid()));
            FlutterBluePlusPlugin flutterBluePlusPlugin2 = FlutterBluePlusPlugin.this;
            flutterBluePlusPlugin2.x0(logLevel, "  desc: " + FlutterBluePlusPlugin.this.B0(bluetoothGattDescriptor.getUuid()));
            FlutterBluePlusPlugin flutterBluePlusPlugin3 = FlutterBluePlusPlugin.this;
            flutterBluePlusPlugin3.x0(logLevel, "  status: " + FlutterBluePlusPlugin.c0(i) + " (" + i + ")");
            BluetoothGattService i0 = FlutterBluePlusPlugin.i0(bluetoothGatt, bluetoothGattDescriptor.getCharacteristic());
            HashMap hashMap = new HashMap();
            hashMap.put("remote_id", bluetoothGatt.getDevice().getAddress());
            hashMap.put(StConstant.KEY_PAYLOAD_MESSAGE_SERVICE_UUID, FlutterBluePlusPlugin.this.B0(bluetoothGattDescriptor.getCharacteristic().getService().getUuid()));
            hashMap.put("characteristic_uuid", FlutterBluePlusPlugin.this.B0(bluetoothGattDescriptor.getCharacteristic().getUuid()));
            hashMap.put("descriptor_uuid", FlutterBluePlusPlugin.this.B0(bluetoothGattDescriptor.getUuid()));
            hashMap.put(AccountConstantKt.RESPONSE_VALUE, FlutterBluePlusPlugin.X(bArr));
            hashMap.put("success", Integer.valueOf(i == 0 ? 1 : 0));
            hashMap.put(MzContactsContract.MzNetContacts.ERROR_CODE_KEY, Integer.valueOf(i));
            hashMap.put("error_string", FlutterBluePlusPlugin.c0(i));
            if (i0 != null) {
                hashMap.put("primary_service_uuid", FlutterBluePlusPlugin.this.B0(i0.getUuid()));
            }
            FlutterBluePlusPlugin.this.n0("OnDescriptorRead", hashMap);
        }

        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            LogLevel logLevel = i == 0 ? LogLevel.DEBUG : LogLevel.ERROR;
            FlutterBluePlusPlugin.this.x0(logLevel, "onDescriptorWrite:");
            FlutterBluePlusPlugin.this.x0(logLevel, "  chr: " + FlutterBluePlusPlugin.this.B0(bluetoothGattDescriptor.getCharacteristic().getUuid()));
            FlutterBluePlusPlugin.this.x0(logLevel, "  desc: " + FlutterBluePlusPlugin.this.B0(bluetoothGattDescriptor.getUuid()));
            FlutterBluePlusPlugin.this.x0(logLevel, "  status: " + FlutterBluePlusPlugin.c0(i) + " (" + i + ")");
            BluetoothGattService i0 = FlutterBluePlusPlugin.i0(bluetoothGatt, bluetoothGattDescriptor.getCharacteristic());
            String address = bluetoothGatt.getDevice().getAddress();
            String B0 = FlutterBluePlusPlugin.this.B0(bluetoothGattDescriptor.getCharacteristic().getService().getUuid());
            String B02 = FlutterBluePlusPlugin.this.B0(bluetoothGattDescriptor.getCharacteristic().getUuid());
            String B03 = FlutterBluePlusPlugin.this.B0(bluetoothGattDescriptor.getUuid());
            String str = "";
            String str2 = address + AccountConstantKt.CODE_SEPARTOR + B0 + AccountConstantKt.CODE_SEPARTOR + B02 + AccountConstantKt.CODE_SEPARTOR + B03 + AccountConstantKt.CODE_SEPARTOR + (i0 != null ? FlutterBluePlusPlugin.this.B0(i0.getUuid()) : str);
            if (FlutterBluePlusPlugin.this.p.get(str2) != null) {
                str = (String) FlutterBluePlusPlugin.this.p.get(str2);
            }
            FlutterBluePlusPlugin.this.p.remove(str2);
            HashMap hashMap = new HashMap();
            hashMap.put("remote_id", address);
            hashMap.put(StConstant.KEY_PAYLOAD_MESSAGE_SERVICE_UUID, B0);
            hashMap.put("characteristic_uuid", B02);
            hashMap.put("descriptor_uuid", B03);
            hashMap.put(AccountConstantKt.RESPONSE_VALUE, str);
            hashMap.put("success", Integer.valueOf(i == 0 ? 1 : 0));
            hashMap.put(MzContactsContract.MzNetContacts.ERROR_CODE_KEY, Integer.valueOf(i));
            hashMap.put("error_string", FlutterBluePlusPlugin.c0(i));
            if (i0 != null) {
                hashMap.put("primary_service_uuid", FlutterBluePlusPlugin.this.B0(i0.getUuid()));
            }
            FlutterBluePlusPlugin.this.n0("OnDescriptorWritten", hashMap);
        }

        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            LogLevel logLevel = i2 == 0 ? LogLevel.DEBUG : LogLevel.ERROR;
            FlutterBluePlusPlugin.this.x0(logLevel, "onMtuChanged:");
            FlutterBluePlusPlugin flutterBluePlusPlugin = FlutterBluePlusPlugin.this;
            flutterBluePlusPlugin.x0(logLevel, "  mtu: " + i);
            FlutterBluePlusPlugin flutterBluePlusPlugin2 = FlutterBluePlusPlugin.this;
            flutterBluePlusPlugin2.x0(logLevel, "  status: " + FlutterBluePlusPlugin.c0(i2) + " (" + i2 + ")");
            String address = bluetoothGatt.getDevice().getAddress();
            FlutterBluePlusPlugin.this.m.put(address, Integer.valueOf(i));
            HashMap hashMap = new HashMap();
            hashMap.put("remote_id", address);
            hashMap.put(StConstant.STARRY_NET_STACK_MTU, Integer.valueOf(i));
            hashMap.put("success", Integer.valueOf(i2 == 0 ? 1 : 0));
            hashMap.put(MzContactsContract.MzNetContacts.ERROR_CODE_KEY, Integer.valueOf(i2));
            hashMap.put("error_string", FlutterBluePlusPlugin.c0(i2));
            FlutterBluePlusPlugin.this.n0("OnMtuChanged", hashMap);
        }

        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            LogLevel logLevel = i2 == 0 ? LogLevel.DEBUG : LogLevel.ERROR;
            FlutterBluePlusPlugin.this.x0(logLevel, "onReadRemoteRssi:");
            FlutterBluePlusPlugin flutterBluePlusPlugin = FlutterBluePlusPlugin.this;
            flutterBluePlusPlugin.x0(logLevel, "  rssi: " + i);
            FlutterBluePlusPlugin flutterBluePlusPlugin2 = FlutterBluePlusPlugin.this;
            flutterBluePlusPlugin2.x0(logLevel, "  status: " + FlutterBluePlusPlugin.c0(i2) + " (" + i2 + ")");
            HashMap hashMap = new HashMap();
            hashMap.put("remote_id", bluetoothGatt.getDevice().getAddress());
            hashMap.put("rssi", Integer.valueOf(i));
            hashMap.put("success", Integer.valueOf(i2 == 0 ? 1 : 0));
            hashMap.put(MzContactsContract.MzNetContacts.ERROR_CODE_KEY, Integer.valueOf(i2));
            hashMap.put("error_string", FlutterBluePlusPlugin.c0(i2));
            FlutterBluePlusPlugin.this.n0("OnReadRssi", hashMap);
        }

        public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
            LogLevel logLevel = i == 0 ? LogLevel.DEBUG : LogLevel.ERROR;
            FlutterBluePlusPlugin.this.x0(logLevel, "onReliableWriteCompleted:");
            FlutterBluePlusPlugin flutterBluePlusPlugin = FlutterBluePlusPlugin.this;
            flutterBluePlusPlugin.x0(logLevel, "  status: " + FlutterBluePlusPlugin.c0(i) + " (" + i + ")");
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            LogLevel logLevel = i == 0 ? LogLevel.DEBUG : LogLevel.ERROR;
            FlutterBluePlusPlugin.this.x0(logLevel, "onServicesDiscovered:");
            FlutterBluePlusPlugin flutterBluePlusPlugin = FlutterBluePlusPlugin.this;
            flutterBluePlusPlugin.x0(logLevel, "  count: " + bluetoothGatt.getServices().size());
            FlutterBluePlusPlugin flutterBluePlusPlugin2 = FlutterBluePlusPlugin.this;
            flutterBluePlusPlugin2.x0(logLevel, "  status: " + i + FlutterBluePlusPlugin.c0(i));
            ArrayList arrayList = new ArrayList();
            for (BluetoothGattService next : bluetoothGatt.getServices()) {
                arrayList.add(FlutterBluePlusPlugin.this.Q(bluetoothGatt.getDevice(), next, (BluetoothGattService) null, bluetoothGatt));
                for (BluetoothGattService Q : next.getIncludedServices()) {
                    arrayList.add(FlutterBluePlusPlugin.this.Q(bluetoothGatt.getDevice(), Q, next, bluetoothGatt));
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("remote_id", bluetoothGatt.getDevice().getAddress());
            hashMap.put("services", arrayList);
            hashMap.put("success", Integer.valueOf(i == 0 ? 1 : 0));
            hashMap.put(MzContactsContract.MzNetContacts.ERROR_CODE_KEY, Integer.valueOf(i));
            hashMap.put("error_string", FlutterBluePlusPlugin.c0(i));
            FlutterBluePlusPlugin.this.n0("OnDiscoveredServices", hashMap);
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue());
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue(), i);
        }

        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i, bluetoothGattDescriptor.getValue());
        }
    };

    /* renamed from: com.lib.flutter_blue_plus.FlutterBluePlusPlugin$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9265a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.lib.flutter_blue_plus.FlutterBluePlusPlugin$LogLevel[] r0 = com.lib.flutter_blue_plus.FlutterBluePlusPlugin.LogLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9265a = r0
                com.lib.flutter_blue_plus.FlutterBluePlusPlugin$LogLevel r1 = com.lib.flutter_blue_plus.FlutterBluePlusPlugin.LogLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9265a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.lib.flutter_blue_plus.FlutterBluePlusPlugin$LogLevel r1 = com.lib.flutter_blue_plus.FlutterBluePlusPlugin.LogLevel.WARNING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9265a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.lib.flutter_blue_plus.FlutterBluePlusPlugin$LogLevel r1 = com.lib.flutter_blue_plus.FlutterBluePlusPlugin.LogLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lib.flutter_blue_plus.FlutterBluePlusPlugin.AnonymousClass5.<clinit>():void");
        }
    }

    public class ChrFound {

        /* renamed from: a  reason: collision with root package name */
        public BluetoothGattCharacteristic f9266a;
        public String b;

        public ChrFound(BluetoothGattCharacteristic bluetoothGattCharacteristic, String str) {
            this.f9266a = bluetoothGattCharacteristic;
            this.b = str;
        }
    }

    public enum LogLevel {
        NONE,
        ERROR,
        WARNING,
        INFO,
        DEBUG,
        VERBOSE
    }

    public interface OperationOnPermission {
        void a(boolean z, String str);
    }

    public static String J(int i2) {
        switch (i2) {
            case 10:
                return BooleanUtils.OFF;
            case 11:
                return "turningOn";
            case 12:
                return BooleanUtils.ON;
            case 13:
                return "turningOff";
            default:
                return "UNKNOWN_ADAPTER_STATE (" + i2 + ")";
        }
    }

    public static String L(int i2) {
        if (i2 == 0) {
            return "SUCCESS";
        }
        if (i2 == 1) {
            return "ERROR_BLUETOOTH_NOT_ENABLED";
        }
        if (i2 == 2) {
            return "ERROR_BLUETOOTH_NOT_ALLOWED";
        }
        if (i2 == 3) {
            return "ERROR_DEVICE_NOT_BONDED";
        }
        if (i2 == 6) {
            return "ERROR_MISSING_BLUETOOTH_CONNECT_PERMISSION";
        }
        if (i2 == Integer.MAX_VALUE) {
            return "ERROR_UNKNOWN";
        }
        if (i2 == 200) {
            return "ERROR_GATT_WRITE_NOT_ALLOWED";
        }
        if (i2 == 201) {
            return "ERROR_GATT_WRITE_REQUEST_BUSY";
        }
        switch (i2) {
            case 9:
                return "ERROR_PROFILE_SERVICE_NOT_BOUND";
            case 10:
                return "FEATURE_SUPPORTED";
            case 11:
                return "FEATURE_NOT_SUPPORTED";
            default:
                return "UNKNOWN_BLE_ERROR (" + i2 + ")";
        }
    }

    public static int M(int i2) {
        switch (i2) {
            case 10:
                return 6;
            case 11:
                return 3;
            case 12:
                return 4;
            case 13:
                return 5;
            default:
                return 0;
        }
    }

    public static int R(int i2) {
        if (i2 != 11) {
            return i2 != 12 ? 0 : 2;
        }
        return 1;
    }

    public static int T(int i2) {
        if (i2 != 0) {
            return i2 != 1 ? 2 : 1;
        }
        return 0;
    }

    public static int U(int i2) {
        return i2 != 2 ? 0 : 1;
    }

    public static String W(int i2) {
        switch (i2) {
            case 10:
                return "bond-none";
            case 11:
                return "bonding";
            case 12:
                return "bonded";
            default:
                return "UNKNOWN_BOND_STATE (" + i2 + ")";
        }
    }

    public static String X(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(Character.forDigit((b2 >> 4) & 15, 16));
            sb.append(Character.forDigit(b2 & 15, 16));
        }
        return sb.toString();
    }

    public static String Y(int i2) {
        if (i2 == 0) {
            return "disconnected";
        }
        if (i2 == 1) {
            return "connecting";
        }
        if (i2 == 2) {
            return "connected";
        }
        if (i2 == 3) {
            return "disconnecting";
        }
        return "UNKNOWN_CONNECTION_STATE (" + i2 + ")";
    }

    public static String c0(int i2) {
        if (i2 == 257) {
            return "GATT_FAILURE";
        }
        switch (i2) {
            case 0:
                return "GATT_SUCCESS";
            case 1:
                return "GATT_INVALID_HANDLE";
            case 2:
                return "GATT_READ_NOT_PERMITTED";
            case 3:
                return "GATT_WRITE_NOT_PERMITTED";
            case 4:
                return "GATT_INVALID_PDU";
            case 5:
                return "GATT_INSUFFICIENT_AUTHENTICATION";
            case 6:
                return "GATT_REQUEST_NOT_SUPPORTED";
            case 7:
                return "GATT_INVALID_OFFSET";
            case 8:
                return "GATT_INSUFFICIENT_AUTHORIZATION";
            case 9:
                return "GATT_PREPARE_QUEUE_FULL";
            case 10:
                return "GATT_ATTR_NOT_FOUND";
            case 11:
                return "GATT_ATTR_NOT_LONG";
            case 12:
                return "GATT_INSUFFICIENT_KEY_SIZE";
            case 13:
                return "GATT_INVALID_ATTRIBUTE_LENGTH";
            case 14:
                return "GATT_UNLIKELY";
            case 15:
                return "GATT_INSUFFICIENT_ENCRYPTION";
            case 16:
                return "GATT_UNSUPPORTED_GROUP";
            case 17:
                return "GATT_INSUFFICIENT_RESOURCES";
            default:
                switch (i2) {
                    case 128:
                        return "GATT_NO_RESOURCES";
                    case 129:
                        return "GATT_INTERNAL_ERROR";
                    case 130:
                        return "GATT_WRONG_STATE";
                    case TrackerEvent.PositioningOfflineOutdoor:
                        return "GATT_DB_FULL";
                    case 132:
                        return "GATT_BUSY";
                    case 133:
                        return "GATT_ERROR";
                    case 134:
                        return "GATT_CMD_STARTED";
                    case 135:
                        return "GATT_ILLEGAL_PARAMETER";
                    case 136:
                        return "GATT_PENDING";
                    case 137:
                        return "GATT_AUTH_FAIL";
                    case 138:
                        return "GATT_MORE";
                    case 139:
                        return "GATT_INVALID_CFG";
                    case 140:
                        return "GATT_SERVICE_STARTED";
                    case 141:
                        return "GATT_ENCRYPTED_NO_MITM";
                    case 142:
                        return "GATT_NOT_ENCRYPTED";
                    case 143:
                        return "GATT_CONNECTION_CONGESTED";
                    default:
                        return "UNKNOWN_GATT_ERROR (" + i2 + ")";
                }
        }
    }

    public static BluetoothGattService i0(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGattService service = bluetoothGattCharacteristic.getService();
        if (service.getType() == 0) {
            return null;
        }
        for (BluetoothGattService next : bluetoothGatt.getServices()) {
            Iterator<BluetoothGattService> it = next.getIncludedServices().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getUuid().equals(service.getUuid())) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    public static String l0(int i2) {
        if (i2 == 133) {
            return "ANDROID_SPECIFIC_ERROR";
        }
        if (i2 == 257) {
            return "FAILURE_REGISTERING_CLIENT";
        }
        switch (i2) {
            case 0:
                return "SUCCESS";
            case 1:
                return "UNKNOWN_COMMAND";
            case 2:
                return "UNKNOWN_CONNECTION_IDENTIFIER";
            case 3:
                return "HARDWARE_FAILURE";
            case 4:
                return "PAGE_TIMEOUT";
            case 5:
                return "AUTHENTICATION_FAILURE";
            case 6:
                return "PIN_OR_KEY_MISSING";
            case 7:
                return "MEMORY_FULL";
            case 8:
                return "LINK_SUPERVISION_TIMEOUT";
            case 9:
                return "CONNECTION_LIMIT_EXCEEDED";
            case 10:
                return "MAX_NUM_OF_CONNECTIONS_EXCEEDED";
            case 11:
                return "CONNECTION_ALREADY_EXISTS";
            case 12:
                return "COMMAND_DISALLOWED";
            case 13:
                return "CONNECTION_REJECTED_LIMITED_RESOURCES";
            case 14:
                return "CONNECTION_REJECTED_SECURITY_REASONS";
            case 15:
                return "CONNECTION_REJECTED_UNACCEPTABLE_MAC_ADDRESS";
            case 16:
                return "CONNECTION_ACCEPT_TIMEOUT_EXCEEDED";
            case 17:
                return "UNSUPPORTED_PARAMETER_VALUE";
            case 18:
                return "INVALID_COMMAND_PARAMETERS";
            case 19:
                return "REMOTE_USER_TERMINATED_CONNECTION";
            case 20:
                return "REMOTE_DEVICE_TERMINATED_CONNECTION_LOW_RESOURCES";
            case 21:
                return "REMOTE_DEVICE_TERMINATED_CONNECTION_POWER_OFF";
            case 22:
                return "CONNECTION_TERMINATED_BY_LOCAL_HOST";
            case 23:
                return "REPEATED_ATTEMPTS";
            case 24:
                return "PAIRING_NOT_ALLOWED";
            case 25:
                return "UNKNOWN_LMP_PDU";
            case 26:
                return "UNSUPPORTED_REMOTE_FEATURE";
            case 27:
                return "SCO_OFFSET_REJECTED";
            case 28:
                return "SCO_INTERVAL_REJECTED";
            case 29:
                return "SCO_AIR_MODE_REJECTED";
            case 30:
                return "INVALID_LMP_OR_LL_PARAMETERS";
            case 31:
                return "UNSPECIFIED";
            case 32:
                return "UNSUPPORTED_LMP_OR_LL_PARAMETER_VALUE";
            case 33:
                return "ROLE_CHANGE_NOT_ALLOWED";
            case 34:
                return "LMP_OR_LL_RESPONSE_TIMEOUT";
            case 35:
                return "LMP_OR_LL_ERROR_TRANS_COLLISION";
            case 36:
                return "LMP_PDU_NOT_ALLOWED";
            case 37:
                return "ENCRYPTION_MODE_NOT_ACCEPTABLE";
            case 38:
                return "LINK_KEY_CANNOT_BE_EXCHANGED";
            case 39:
                return "REQUESTED_QOS_NOT_SUPPORTED";
            case 40:
                return "INSTANT_PASSED";
            case 41:
                return "PAIRING_WITH_UNIT_KEY_NOT_SUPPORTED";
            case 42:
                return "DIFFERENT_TRANSACTION_COLLISION";
            case 43:
                return "UNDEFINED_0x2B";
            case 44:
                return "QOS_UNACCEPTABLE_PARAMETER";
            case 45:
                return "QOS_REJECTED";
            case WXMediaMessage.IMediaObject.TYPE_OPENSDK_APPBRAND_WEISHIVIDEO /*46*/:
                return "CHANNEL_CLASSIFICATION_NOT_SUPPORTED";
            case 47:
                return "INSUFFICIENT_SECURITY";
            case 48:
                return "PARAMETER_OUT_OF_RANGE";
            case 49:
                return "UNDEFINED_0x31";
            case 50:
                return "ROLE_SWITCH_PENDING";
            case 51:
                return "UNDEFINED_0x33";
            case 52:
                return "RESERVED_SLOT_VIOLATION";
            case 53:
                return "ROLE_SWITCH_FAILED";
            case 54:
                return "INQUIRY_RESPONSE_TOO_LARGE";
            case 55:
                return "SECURE_SIMPLE_PAIRING_NOT_SUPPORTED";
            case 56:
                return "HOST_BUSY_PAIRING";
            case 57:
                return "CONNECTION_REJECTED_NO_SUITABLE_CHANNEL";
            case 58:
                return "CONTROLLER_BUSY";
            case 59:
                return "UNACCEPTABLE_CONNECTION_PARAMETERS";
            case 60:
                return "ADVERTISING_TIMEOUT";
            case 61:
                return "CONNECTION_TERMINATED_MIC_FAILURE";
            case 62:
                return "CONNECTION_FAILED_ESTABLISHMENT";
            case 63:
                return "MAC_CONNECTION_FAILED";
            case 64:
                return "COARSE_CLOCK_ADJUSTMENT_REJECTED";
            case 65:
                return "TYPE0_SUBMAP_NOT_DEFINED";
            case 66:
                return "UNKNOWN_ADVERTISING_IDENTIFIER";
            case 67:
                return "LIMIT_REACHED";
            case 68:
                return "OPERATION_CANCELLED_BY_HOST";
            case 69:
                return "PACKET_TOO_LONG";
            default:
                return "UNKNOWN_HCI_ERROR (" + i2 + ")";
        }
    }

    public static byte[] m0(String str) {
        if (str == null) {
            return new byte[0];
        }
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i2 = 0; i2 < length; i2 += 2) {
            bArr[i2 / 2] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public static String z0(int i2) {
        switch (i2) {
            case 1:
                return "SCAN_FAILED_ALREADY_STARTED";
            case 2:
                return "SCAN_FAILED_APPLICATION_REGISTRATION_FAILED";
            case 3:
                return "SCAN_FAILED_INTERNAL_ERROR";
            case 4:
                return "SCAN_FAILED_FEATURE_UNSUPPORTED";
            case 5:
                return "SCAN_FAILED_OUT_OF_HARDWARE_RESOURCES";
            case 6:
                return "SCAN_FAILED_SCANNING_TOO_FREQUENTLY";
            default:
                return "UNKNOWN_SCAN_ERROR (" + i2 + ")";
        }
    }

    public String A0(Object obj) {
        if ((obj instanceof UUID) || (obj instanceof String)) {
            String obj2 = obj.toString();
            return obj2.length() == 4 ? String.format("0000%s-0000-1000-8000-00805f9b34fb", new Object[]{obj2}).toLowerCase() : obj2.length() == 8 ? String.format("%s-0000-1000-8000-00805f9b34fb", new Object[]{obj2}).toLowerCase() : obj2.toLowerCase();
        }
        throw new IllegalArgumentException("input must be UUID or String");
    }

    public String B0(Object obj) {
        String A0 = A0(obj);
        boolean startsWith = A0.startsWith("0000");
        boolean endsWith = A0.endsWith("-0000-1000-8000-00805f9b34fb");
        return (!startsWith || !endsWith) ? endsWith ? A0.substring(0, 8) : A0 : A0.substring(4, 8);
    }

    public final void C0() {
        if (!this.l.isEmpty()) {
            x0(LogLevel.DEBUG, "[FBP] waiting for bonding to complete...");
            try {
                Thread.sleep(50);
            } catch (Exception unused) {
            }
            x0(LogLevel.DEBUG, "[FBP] bonding completed");
        }
    }

    public final void I(Semaphore semaphore) {
        boolean z2 = false;
        while (!z2) {
            try {
                semaphore.acquire();
                z2 = true;
            } catch (InterruptedException unused) {
                x0(LogLevel.ERROR, "failed to acquire mutex, retrying");
            }
        }
    }

    public final void K(List list, OperationOnPermission operationOnPermission) {
        if (list.isEmpty()) {
            operationOnPermission.a(true, (String) null);
            return;
        }
        this.t.put(Integer.valueOf(this.u), operationOnPermission);
        ActivityCompat.e(this.h.getActivity(), (String[]) list.toArray(new String[0]), this.u);
        this.u++;
    }

    public HashMap N(BluetoothDevice bluetoothDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic, BluetoothGatt bluetoothGatt) {
        ArrayList arrayList = new ArrayList();
        for (BluetoothGattDescriptor O : bluetoothGattCharacteristic.getDescriptors()) {
            arrayList.add(O(bluetoothDevice, O, bluetoothGatt));
        }
        BluetoothGattService i0 = i0(bluetoothGatt, bluetoothGattCharacteristic);
        HashMap hashMap = new HashMap();
        hashMap.put("remote_id", bluetoothDevice.getAddress());
        hashMap.put(StConstant.KEY_PAYLOAD_MESSAGE_SERVICE_UUID, B0(bluetoothGattCharacteristic.getService().getUuid()));
        hashMap.put("characteristic_uuid", B0(bluetoothGattCharacteristic.getUuid()));
        hashMap.put("descriptors", arrayList);
        hashMap.put("properties", S(bluetoothGattCharacteristic.getProperties()));
        if (i0 != null) {
            hashMap.put("primary_service_uuid", B0(i0.getUuid()));
        }
        return hashMap;
    }

    public HashMap O(BluetoothDevice bluetoothDevice, BluetoothGattDescriptor bluetoothGattDescriptor, BluetoothGatt bluetoothGatt) {
        BluetoothGattService i0 = i0(bluetoothGatt, bluetoothGattDescriptor.getCharacteristic());
        HashMap hashMap = new HashMap();
        hashMap.put("remote_id", bluetoothDevice.getAddress());
        hashMap.put("descriptor_uuid", B0(bluetoothGattDescriptor.getUuid()));
        hashMap.put("characteristic_uuid", B0(bluetoothGattDescriptor.getCharacteristic().getUuid()));
        hashMap.put(StConstant.KEY_PAYLOAD_MESSAGE_SERVICE_UUID, B0(bluetoothGattDescriptor.getCharacteristic().getService().getUuid()));
        if (i0 != null) {
            hashMap.put("primary_service_uuid", B0(i0.getUuid()));
        }
        return hashMap;
    }

    public HashMap P(BluetoothDevice bluetoothDevice) {
        HashMap hashMap = new HashMap();
        hashMap.put("remote_id", bluetoothDevice.getAddress());
        hashMap.put("platform_name", bluetoothDevice.getName());
        return hashMap;
    }

    public HashMap Q(BluetoothDevice bluetoothDevice, BluetoothGattService bluetoothGattService, BluetoothGattService bluetoothGattService2, BluetoothGatt bluetoothGatt) {
        ArrayList arrayList = new ArrayList();
        for (BluetoothGattCharacteristic N : bluetoothGattService.getCharacteristics()) {
            arrayList.add(N(bluetoothDevice, N, bluetoothGatt));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("remote_id", bluetoothDevice.getAddress());
        hashMap.put(StConstant.KEY_PAYLOAD_MESSAGE_SERVICE_UUID, B0(bluetoothGattService.getUuid()));
        hashMap.put("characteristics", arrayList);
        if (bluetoothGattService2 != null) {
            hashMap.put("primary_service_uuid", B0(bluetoothGattService2.getUuid()));
        }
        return hashMap;
    }

    public HashMap S(int i2) {
        HashMap hashMap = new HashMap();
        int i3 = 0;
        hashMap.put("broadcast", Integer.valueOf((i2 & 1) != 0 ? 1 : 0));
        hashMap.put("read", Integer.valueOf((i2 & 2) != 0 ? 1 : 0));
        hashMap.put("write_without_response", Integer.valueOf((i2 & 4) != 0 ? 1 : 0));
        hashMap.put("write", Integer.valueOf((i2 & 8) != 0 ? 1 : 0));
        hashMap.put("notify", Integer.valueOf((i2 & 16) != 0 ? 1 : 0));
        hashMap.put("indicate", Integer.valueOf((i2 & 32) != 0 ? 1 : 0));
        hashMap.put("authenticated_signed_writes", Integer.valueOf((i2 & 64) != 0 ? 1 : 0));
        hashMap.put("extended_properties", Integer.valueOf((i2 & 128) != 0 ? 1 : 0));
        hashMap.put("notify_encryption_required", Integer.valueOf((i2 & 256) != 0 ? 1 : 0));
        if ((i2 & 512) != 0) {
            i3 = 1;
        }
        hashMap.put("indicate_encryption_required", Integer.valueOf(i3));
        return hashMap;
    }

    public HashMap V(BluetoothDevice bluetoothDevice, ScanResult scanResult) {
        ScanRecord scanRecord = scanResult.getScanRecord();
        boolean isConnectable = scanResult.isConnectable();
        Map<ParcelUuid, byte[]> map = null;
        String deviceName = scanRecord != null ? scanRecord.getDeviceName() : null;
        int txPowerLevel = scanRecord != null ? scanRecord.getTxPowerLevel() : Integer.MIN_VALUE;
        int d0 = scanRecord != null ? d0(scanRecord) : 0;
        Map g0 = scanRecord != null ? g0(scanRecord) : null;
        List<ParcelUuid> serviceUuids = scanRecord != null ? scanRecord.getServiceUuids() : null;
        if (scanRecord != null) {
            map = scanRecord.getServiceData();
        }
        HashMap hashMap = new HashMap();
        if (g0 != null) {
            for (Map.Entry entry : g0.entrySet()) {
                hashMap.put((Integer) entry.getKey(), X((byte[]) entry.getValue()));
            }
        }
        HashMap hashMap2 = new HashMap();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                hashMap2.put(B0(((ParcelUuid) next.getKey()).getUuid()), X((byte[]) next.getValue()));
            }
        }
        ArrayList arrayList = new ArrayList();
        if (serviceUuids != null) {
            for (ParcelUuid uuid : serviceUuids) {
                arrayList.add(B0(uuid.getUuid()));
            }
        }
        HashMap hashMap3 = new HashMap();
        if (bluetoothDevice.getAddress() != null) {
            hashMap3.put("remote_id", bluetoothDevice.getAddress());
        }
        if (bluetoothDevice.getName() != null) {
            hashMap3.put("platform_name", bluetoothDevice.getName());
        }
        if (isConnectable) {
            hashMap3.put("connectable", 1);
        }
        if (deviceName != null) {
            hashMap3.put("adv_name", deviceName);
        }
        if (txPowerLevel != Integer.MIN_VALUE) {
            hashMap3.put("tx_power_level", Integer.valueOf(txPowerLevel));
        }
        if (d0 != 0) {
            hashMap3.put("appearance", Integer.valueOf(d0));
        }
        if (g0 != null) {
            hashMap3.put("manufacturer_data", hashMap);
        }
        if (map != null) {
            hashMap3.put("service_data", hashMap2);
        }
        if (serviceUuids != null) {
            hashMap3.put("service_uuids", arrayList);
        }
        if (scanResult.getRssi() != 0) {
            hashMap3.put("rssi", Integer.valueOf(scanResult.getRssi()));
        }
        return hashMap3;
    }

    public final void Z(String str) {
        LogLevel logLevel = LogLevel.DEBUG;
        x0(logLevel, "disconnectAllDevices(" + str + ")");
        for (BluetoothGatt bluetoothGatt : this.j.values()) {
            if (str == "adapterTurnOff") {
                this.z.onConnectionStateChange(bluetoothGatt, 0, 0);
            } else {
                String address = bluetoothGatt.getDevice().getAddress();
                LogLevel logLevel2 = LogLevel.DEBUG;
                x0(logLevel2, "calling disconnect: " + address);
                bluetoothGatt.disconnect();
                x0(logLevel2, "calling close: " + address);
                bluetoothGatt.close();
            }
        }
        this.j.clear();
        this.k.clear();
        this.l.clear();
        this.m.clear();
        this.o.clear();
        this.p.clear();
        this.n.clear();
    }

    public final void a0(List list, OperationOnPermission operationOnPermission) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!(str == null || ContextCompat.checkSelfPermission(this.b, str) == 0)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            operationOnPermission.a(true, (String) null);
        } else {
            K(arrayList, operationOnPermission);
        }
    }

    public final boolean b0(List list, String str) {
        if (list.isEmpty()) {
            return true;
        }
        if (str == null) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (str.contains((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public int d0(ScanRecord scanRecord) {
        byte b2;
        byte b3;
        if (Build.VERSION.SDK_INT >= 33) {
            Map a2 = scanRecord.getAdvertisingDataMap();
            if (a2.containsKey(25)) {
                byte[] bArr = (byte[]) a2.get(25);
                if (bArr.length == 2) {
                    return ((bArr[1] & 255) * 256) + (bArr[0] & 255);
                }
            }
            return 0;
        }
        byte[] bytes = scanRecord.getBytes();
        int i2 = 0;
        while (i2 < bytes.length && (b2 = bytes[i2] & 255) > 0 && i2 + b2 < bytes.length && (b3 = bytes[i2 + 1] & 255) != 0) {
            if (b3 == 25 && b2 == 3) {
                return (bytes[i2 + 2] & 255) | ((bytes[i2 + 3] & 255) << 8);
            }
            i2 += b2 + 1;
        }
        return 0;
    }

    public final BluetoothGattCharacteristic e0(String str, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) it.next();
            if (A0(bluetoothGattCharacteristic.getUuid()).equals(A0(str))) {
                return bluetoothGattCharacteristic;
            }
        }
        return null;
    }

    public final BluetoothGattDescriptor f0(String str, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BluetoothGattDescriptor bluetoothGattDescriptor = (BluetoothGattDescriptor) it.next();
            if (A0(bluetoothGattDescriptor.getUuid()).equals(A0(str))) {
                return bluetoothGattDescriptor;
            }
        }
        return null;
    }

    public Map g0(ScanRecord scanRecord) {
        byte b2;
        byte[] bytes = scanRecord.getBytes();
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (i2 < bytes.length && (b2 = bytes[i2] & 255) > 0 && i2 + b2 < bytes.length) {
            if ((bytes[i2 + 1] & 255) == 255 && b2 >= 3) {
                byte b3 = (255 & bytes[i2 + 2]) | ((bytes[i2 + 3] & 255) << 8);
                int i3 = b2 - 3;
                int i4 = i2 + 4;
                if (hashMap.containsKey(Integer.valueOf(b3))) {
                    byte[] bArr = (byte[]) hashMap.get(Integer.valueOf(b3));
                    byte[] bArr2 = new byte[(bArr.length + i3)];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    System.arraycopy(bytes, i4, bArr2, bArr.length, i3);
                    hashMap.put(Integer.valueOf(b3), bArr2);
                } else {
                    byte[] bArr3 = new byte[i3];
                    System.arraycopy(bytes, i4, bArr3, 0, i3);
                    hashMap.put(Integer.valueOf(b3), bArr3);
                }
            }
            i2 += b2 + 1;
        }
        return hashMap;
    }

    public final int h0(String str, int i2, boolean z2) {
        if (i2 != 1 && z2) {
            return 512;
        }
        Integer num = (Integer) this.m.get(str);
        if (num == null) {
            num = 23;
        }
        return Math.min(num.intValue() - 3, 512);
    }

    public final ScanCallback j0() {
        if (this.y == null) {
            this.y = new ScanCallback() {
                public void onBatchScanResults(List list) {
                    super.onBatchScanResults(list);
                }

                public void onScanFailed(int i) {
                    FlutterBluePlusPlugin flutterBluePlusPlugin = FlutterBluePlusPlugin.this;
                    LogLevel logLevel = LogLevel.ERROR;
                    flutterBluePlusPlugin.x0(logLevel, "onScanFailed: " + FlutterBluePlusPlugin.z0(i));
                    super.onScanFailed(i);
                    HashMap hashMap = new HashMap();
                    hashMap.put("advertisements", new ArrayList());
                    hashMap.put("success", 0);
                    hashMap.put(MzContactsContract.MzNetContacts.ERROR_CODE_KEY, Integer.valueOf(i));
                    hashMap.put("error_string", FlutterBluePlusPlugin.z0(i));
                    FlutterBluePlusPlugin.this.n0("OnScanResponse", hashMap);
                }

                public void onScanResult(int i, ScanResult scanResult) {
                    FlutterBluePlusPlugin.this.x0(LogLevel.VERBOSE, "onScanResult");
                    super.onScanResult(i, scanResult);
                    BluetoothDevice device = scanResult.getDevice();
                    String address = device.getAddress();
                    ScanRecord scanRecord = scanResult.getScanRecord();
                    String str = "";
                    String H = scanRecord != null ? FlutterBluePlusPlugin.X(scanRecord.getBytes()) : str;
                    if (!((Boolean) FlutterBluePlusPlugin.this.s.get("continuous_updates")).booleanValue()) {
                        boolean z = FlutterBluePlusPlugin.this.q.containsKey(address) && ((String) FlutterBluePlusPlugin.this.q.get(address)).equals(H);
                        FlutterBluePlusPlugin.this.q.put(address, H);
                        if (z) {
                            return;
                        }
                    }
                    if (scanRecord != null) {
                        str = scanRecord.getDeviceName();
                    }
                    if (FlutterBluePlusPlugin.this.b0((List) FlutterBluePlusPlugin.this.s.get("with_keywords"), str)) {
                        if (!((Boolean) FlutterBluePlusPlugin.this.s.get("continuous_updates")).booleanValue() || FlutterBluePlusPlugin.this.y0(address) % ((Integer) FlutterBluePlusPlugin.this.s.get("continuous_divisor")).intValue() == 0) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("advertisements", Arrays.asList(new HashMap[]{FlutterBluePlusPlugin.this.V(device, scanResult)}));
                            FlutterBluePlusPlugin.this.n0("OnScanResponse", hashMap);
                        }
                    }
                }
            };
        }
        return this.y;
    }

    public final BluetoothGattService k0(String str, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BluetoothGattService bluetoothGattService = (BluetoothGattService) it.next();
            if (A0(bluetoothGattService.getUuid()).equals(A0(str))) {
                return bluetoothGattService;
            }
        }
        return null;
    }

    public final void n0(String str, HashMap hashMap) {
        new Handler(Looper.getMainLooper()).post(new e(this, str, hashMap));
    }

    public final boolean o0() {
        try {
            return this.e.getState() == 12;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean onActivityResult(int i2, int i3, Intent intent) {
        boolean z2 = false;
        if (i2 != 1879842617) {
            return false;
        }
        HashMap hashMap = new HashMap();
        if (i3 == -1) {
            z2 = true;
        }
        hashMap.put("user_accepted", Boolean.valueOf(z2));
        n0("OnTurnOnResponse", hashMap);
        return true;
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        x0(LogLevel.DEBUG, "onAttachedToActivity");
        this.h = activityPluginBinding;
        activityPluginBinding.addRequestPermissionsResultListener(this);
        this.h.addActivityResultListener(this);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        x0(LogLevel.DEBUG, "onAttachedToEngine");
        this.g = flutterPluginBinding;
        this.b = (Application) flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "flutter_blue_plus/methods");
        this.c = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.b.registerReceiver(this.w, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        this.b.registerReceiver(this.x, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
    }

    public void onDetachedFromActivity() {
        x0(LogLevel.DEBUG, "onDetachedFromActivity");
        this.h.removeRequestPermissionsResultListener(this);
        this.h = null;
    }

    public void onDetachedFromActivityForConfigChanges() {
        x0(LogLevel.DEBUG, "onDetachedFromActivityForConfigChanges");
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        BluetoothLeScanner bluetoothLeScanner;
        LogLevel logLevel = LogLevel.DEBUG;
        x0(logLevel, "onDetachedFromEngine");
        n0("OnDetachedFromEngine", new HashMap());
        this.g = null;
        BluetoothAdapter bluetoothAdapter = this.e;
        if (!(bluetoothAdapter == null || !this.f || (bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner()) == null)) {
            x0(logLevel, "calling stopScan (OnDetachedFromEngine)");
            bluetoothLeScanner.stopScan(j0());
            this.f = false;
        }
        Z("onDetachedFromEngine");
        this.b.unregisterReceiver(this.x);
        this.b.unregisterReceiver(this.w);
        this.b = null;
        this.c.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.c = null;
        this.e = null;
        this.d = null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01f9, code lost:
        r17 = "";
        r18 = "flutterRestart";
        r19 = r2;
        r20 = "android.permission.BLUETOOTH_CONNECT";
        r21 = "discoverServices";
        r22 = "readCharacteristic";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0213, code lost:
        switch(r3) {
            case 0: goto L_0x0c6c;
            case 1: goto L_0x0c65;
            case 2: goto L_0x0c2d;
            case 3: goto L_0x0c15;
            case 4: goto L_0x0c04;
            case 5: goto L_0x0be0;
            case 6: goto L_0x0bc0;
            case 7: goto L_0x0b9c;
            case 8: goto L_0x0b75;
            case 9: goto L_0x0ace;
            case 10: goto L_0x0ab5;
            case 11: goto L_0x0a9b;
            case 12: goto L_0x0a64;
            case 13: goto L_0x09c4;
            case 14: goto L_0x0994;
            case 15: goto L_0x092a;
            case 16: goto L_0x07c5;
            case 17: goto L_0x0739;
            case 18: goto L_0x05fa;
            case 19: goto L_0x0486;
            case 20: goto L_0x0442;
            case 21: goto L_0x0412;
            case 22: goto L_0x03ca;
            case 23: goto L_0x03a2;
            case 24: goto L_0x0353;
            case 25: goto L_0x0321;
            case 26: goto L_0x02f3;
            case 27: goto L_0x0294;
            case 28: goto L_0x024d;
            case 29: goto L_0x021b;
            default: goto L_0x0216;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:?, code lost:
        r25.notImplemented();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x021b, code lost:
        r1 = (android.bluetooth.BluetoothGatt) r13.j.get((java.lang.String) r1.arguments);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0227, code lost:
        if (r1 != null) goto L_0x022f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0229, code lost:
        r14.error("clearGattCache", "device is disconnected", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x022f, code lost:
        r3 = r1.getClass().getMethod("refresh", (java.lang.Class[]) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x023a, code lost:
        if (r3 != null) goto L_0x0243;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x023c, code lost:
        r14.error("clearGattCache", "unsupported on this android version", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0243, code lost:
        r3.invoke(r1, (java.lang.Object[]) null);
        r14.success(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x024d, code lost:
        r1 = r13.e.getRemoteDevice((java.lang.String) r1.arguments);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x025d, code lost:
        if (r1.getBondState() != 10) goto L_0x026d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x025f, code lost:
        x0(com.lib.flutter_blue_plus.FlutterBluePlusPlugin.LogLevel.WARNING, "already not bonded");
        r14.success(java.lang.Boolean.FALSE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0282, code lost:
        if (((java.lang.Boolean) r1.getClass().getMethod("removeBond", (java.lang.Class[]) null).invoke(r1, (java.lang.Object[]) null)).booleanValue() != false) goto L_0x028d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0284, code lost:
        r14.error("removeBond", "device.removeBond() returned false", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x028d, code lost:
        r14.success(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0294, code lost:
        r1 = (java.lang.String) r1.arguments;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x02a0, code lost:
        if (((android.bluetooth.BluetoothGatt) r13.j.get(r1)) != null) goto L_0x02aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x02a2, code lost:
        r14.error("createBond", "device is disconnected", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x02aa, code lost:
        r1 = r13.e.getRemoteDevice(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x02b6, code lost:
        if (r1.getBondState() != 12) goto L_0x02c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x02b8, code lost:
        x0(com.lib.flutter_blue_plus.FlutterBluePlusPlugin.LogLevel.WARNING, "already bonded");
        r14.success(java.lang.Boolean.FALSE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02cc, code lost:
        if (r1.getBondState() != 11) goto L_0x02dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x02ce, code lost:
        x0(com.lib.flutter_blue_plus.FlutterBluePlusPlugin.LogLevel.WARNING, "bonding already in progress");
        r14.success(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02e0, code lost:
        if (r1.createBond() != false) goto L_0x02ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x02e2, code lost:
        r14.error("createBond", "device.createBond() returned false", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02ec, code lost:
        r14.success(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02f3, code lost:
        r1 = (java.lang.String) r1.arguments;
        r2 = r13.e.getRemoteDevice(r1);
        r3 = new java.util.HashMap();
        r3.put("remote_id", r1);
        r3.put("bond_state", java.lang.Integer.valueOf(R(r2.getBondState())));
        r3.put("prev_state", (java.lang.Object) null);
        r14.success(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0321, code lost:
        r1 = r13.e.getBondedDevices();
        r2 = new java.util.ArrayList();
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0334, code lost:
        if (r1.hasNext() == false) goto L_0x0344;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0336, code lost:
        r2.add(P(r1.next()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0344, code lost:
        r1 = new java.util.HashMap();
        r1.put("devices", r2);
        r14.success(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0353, code lost:
        r1 = (java.util.HashMap) r24.arguments();
        r3 = ((java.lang.Integer) r1.get("tx_phy")).intValue();
        r4 = ((java.lang.Integer) r1.get("rx_phy")).intValue();
        r1 = ((java.lang.Integer) r1.get("phy_options")).intValue();
        r2 = (android.bluetooth.BluetoothGatt) r13.j.get((java.lang.String) r1.get("remote_id"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x038b, code lost:
        if (r2 != null) goto L_0x0395;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x038d, code lost:
        r14.error("setPreferredPhy", "device is disconnected", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0395, code lost:
        C0();
        r2.setPreferredPhy(r3, r4, r1);
        r14.success(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03a2, code lost:
        r1 = new java.util.HashMap();
        r1.put("le_2M", java.lang.Boolean.valueOf(r13.e.isLe2MPhySupported()));
        r1.put("le_coded", java.lang.Boolean.valueOf(r13.e.isLeCodedPhySupported()));
        r14.success(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03ca, code lost:
        r1 = (java.util.HashMap) r24.arguments();
        r1 = ((java.lang.Integer) r1.get("connection_priority")).intValue();
        r2 = (android.bluetooth.BluetoothGatt) r13.j.get((java.lang.String) r1.get("remote_id"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03ea, code lost:
        if (r2 != null) goto L_0x03f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03ec, code lost:
        r14.error("requestConnectionPriority", "device is disconnected", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03f4, code lost:
        C0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03ff, code lost:
        if (r2.requestConnectionPriority(T(r1)) != false) goto L_0x040b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0401, code lost:
        r14.error("requestConnectionPriority", "gatt.requestConnectionPriority() returned false", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x040b, code lost:
        r14.success(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0412, code lost:
        r1 = (android.bluetooth.BluetoothGatt) r13.j.get((java.lang.String) r1.arguments);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x041e, code lost:
        if (r1 != null) goto L_0x0428;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0420, code lost:
        r14.error("readRssi", "device is disconnected", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0428, code lost:
        C0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x042f, code lost:
        if (r1.readRemoteRssi() != false) goto L_0x043b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0431, code lost:
        r14.error("readRssi", "gatt.readRemoteRssi() returned false", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x043b, code lost:
        r14.success(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0442, code lost:
        r1 = (java.util.HashMap) r24.arguments();
        r1 = ((java.lang.Integer) r1.get(com.upuphone.starrynet.api.StConstant.STARRY_NET_STACK_MTU)).intValue();
        r2 = (android.bluetooth.BluetoothGatt) r13.j.get((java.lang.String) r1.get("remote_id"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0462, code lost:
        if (r2 != null) goto L_0x046c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0464, code lost:
        r14.error("requestMtu", "device is disconnected", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x046c, code lost:
        C0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0473, code lost:
        if (r2.requestMtu(r1) != false) goto L_0x047f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0475, code lost:
        r14.error("requestMtu", "gatt.requestMtu() returned false", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x047f, code lost:
        r14.success(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0486, code lost:
        r1 = (java.util.HashMap) r24.arguments();
        r3 = (java.lang.String) r1.get("remote_id");
        r5 = (java.lang.String) r1.get(com.upuphone.starrynet.api.StConstant.KEY_PAYLOAD_MESSAGE_SERVICE_UUID);
        r4 = (java.lang.String) r1.get("characteristic_uuid");
        r6 = (java.lang.String) r1.get("primary_service_uuid");
        r7 = ((java.lang.Boolean) r1.get("force_indications")).booleanValue();
        r1 = ((java.lang.Boolean) r1.get("enable")).booleanValue();
        r8 = (android.bluetooth.BluetoothGatt) r13.j.get(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x04c4, code lost:
        if (r8 != null) goto L_0x04cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x04c6, code lost:
        r14.error("setNotifyValue", "device is disconnected", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x04cc, code lost:
        C0();
        r9 = w0(r8, r5, r4, r6);
        r10 = r9.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x04d5, code lost:
        if (r10 == null) goto L_0x04dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x04d7, code lost:
        r14.error("setNotifyValue", r10, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x04dd, code lost:
        r9 = r9.f9266a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x04e3, code lost:
        if (r8.setCharacteristicNotification(r9, r1) != false) goto L_0x0501;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x04e5, code lost:
        r14.error("setNotifyValue", "gatt.setCharacteristicNotification(" + r1 + ") returned false", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0501, code lost:
        r10 = f0("2902", r9.getDescriptors());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x050b, code lost:
        if (r10 != null) goto L_0x0532;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x050d, code lost:
        r1 = B0(r9.getUuid());
        x0(com.lib.flutter_blue_plus.FlutterBluePlusPlugin.LogLevel.WARNING, "CCCD descriptor for characteristic not found: " + r1);
        r14.success(java.lang.Boolean.FALSE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0532, code lost:
        if (r1 == false) goto L_0x0573;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x053a, code lost:
        if ((r9.getProperties() & 16) <= 0) goto L_0x053e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x053c, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x053e, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0545, code lost:
        if ((r9.getProperties() & 32) <= 0) goto L_0x054a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0547, code lost:
        r16 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x054a, code lost:
        r16 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x054c, code lost:
        if (r16 != false) goto L_0x0558;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x054e, code lost:
        if (r1 != false) goto L_0x0558;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0550, code lost:
        r14.error("setNotifyValue", "neither NOTIFY nor INDICATE properties are supported by this BLE characteristic", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x0558, code lost:
        if (r7 == false) goto L_0x0564;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x055a, code lost:
        if (r16 != false) goto L_0x0564;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x055c, code lost:
        r14.error("setNotifyValue", "INDICATE not supported by this BLE characteristic", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0564, code lost:
        if (r16 == false) goto L_0x0569;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0566, code lost:
        r9 = android.bluetooth.BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0569, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x056a, code lost:
        if (r1 == false) goto L_0x056e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x056c, code lost:
        r9 = android.bluetooth.BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x056e, code lost:
        if (r7 == false) goto L_0x0575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0570, code lost:
        r9 = android.bluetooth.BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0573, code lost:
        r9 = android.bluetooth.BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0575, code lost:
        if (r6 != null) goto L_0x0579;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0577, code lost:
        r6 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x0579, code lost:
        r13.p.put(r3 + com.honey.account.constant.AccountConstantKt.CODE_SEPARTOR + r5 + com.honey.account.constant.AccountConstantKt.CODE_SEPARTOR + r4 + com.honey.account.constant.AccountConstantKt.CODE_SEPARTOR + "2902" + com.honey.account.constant.AccountConstantKt.CODE_SEPARTOR + r6, X(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x05ac, code lost:
        if (android.os.Build.VERSION.SDK_INT < 33) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x05ae, code lost:
        r1 = r8.writeDescriptor(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x05b2, code lost:
        if (r1 == 0) goto L_0x05f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x05b4, code lost:
        r14.error("setNotifyValue", "gatt.writeDescriptor() returned " + r1 + " : " + L(r1), (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x05db, code lost:
        if (r10.setValue(r9) != false) goto L_0x05e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x05dd, code lost:
        r14.error("setNotifyValue", "cccd.setValue() returned false", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x05e9, code lost:
        if (r8.writeDescriptor(r10) != false) goto L_0x05f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x05eb, code lost:
        r14.error("setNotifyValue", "gatt.writeDescriptor() returned false", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x05f3, code lost:
        r14.success(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x05fa, code lost:
        r1 = (java.util.HashMap) r24.arguments();
        r3 = (java.lang.String) r1.get("remote_id");
        r5 = (java.lang.String) r1.get(com.upuphone.starrynet.api.StConstant.KEY_PAYLOAD_MESSAGE_SERVICE_UUID);
        r4 = (java.lang.String) r1.get("characteristic_uuid");
        r7 = (java.lang.String) r1.get("descriptor_uuid");
        r6 = (java.lang.String) r1.get("primary_service_uuid");
        r1 = (java.lang.String) r1.get(com.honey.account.constant.AccountConstantKt.RESPONSE_VALUE);
        r8 = (android.bluetooth.BluetoothGatt) r13.j.get(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0630, code lost:
        if (r8 != null) goto L_0x0638;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x0632, code lost:
        r14.error("writeDescriptor", "device is disconnected", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0638, code lost:
        C0();
        r9 = w0(r8, r5, r4, r6);
        r10 = r9.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0641, code lost:
        if (r10 == null) goto L_0x0649;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x0643, code lost:
        r14.error("writeDescriptor", r10, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x0649, code lost:
        r9 = f0(r7, r9.f9266a.getDescriptors());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0653, code lost:
        if (r9 != null) goto L_0x0679;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0655, code lost:
        r14.error("writeDescriptor", "descriptor not found on characteristic. (desc: " + r7 + " chr: " + r4 + ")", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0679, code lost:
        r10 = ((java.lang.Integer) r13.m.get(r3)).intValue() - 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x068c, code lost:
        if (r10 >= m0(r1).length) goto L_0x06b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x068e, code lost:
        r14.error("writeDescriptor", "data longer than mtu allows. dataLength: " + m0(r1).length + "> max: " + r10, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x06b2, code lost:
        if (r6 != null) goto L_0x06b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x06b4, code lost:
        r6 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x06b6, code lost:
        r13.p.put(r3 + com.honey.account.constant.AccountConstantKt.CODE_SEPARTOR + r5 + com.honey.account.constant.AccountConstantKt.CODE_SEPARTOR + r4 + com.honey.account.constant.AccountConstantKt.CODE_SEPARTOR + r7 + com.honey.account.constant.AccountConstantKt.CODE_SEPARTOR + r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x06e3, code lost:
        if (android.os.Build.VERSION.SDK_INT < 33) goto L_0x0712;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x06e5, code lost:
        r1 = r8.writeDescriptor(r9, m0(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x06ed, code lost:
        if (r1 == 0) goto L_0x0732;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x06ef, code lost:
        r14.error("writeDescriptor", "gatt.writeDescriptor() returned " + r1 + " : " + L(r1), (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x071a, code lost:
        if (r9.setValue(m0(r1)) != false) goto L_0x0724;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x071c, code lost:
        r14.error("writeDescriptor", "descriptor.setValue() returned false", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x0728, code lost:
        if (r8.writeDescriptor(r9) != false) goto L_0x0732;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x072a, code lost:
        r14.error("writeDescriptor", "gatt.writeDescriptor() returned false", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x0732, code lost:
        r14.success(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x0739, code lost:
        r1 = (java.util.HashMap) r24.arguments();
        r3 = (java.lang.String) r1.get(com.upuphone.starrynet.api.StConstant.KEY_PAYLOAD_MESSAGE_SERVICE_UUID);
        r4 = (java.lang.String) r1.get("characteristic_uuid");
        r5 = (java.lang.String) r1.get("descriptor_uuid");
        r1 = (java.lang.String) r1.get("primary_service_uuid");
        r2 = (android.bluetooth.BluetoothGatt) r13.j.get((java.lang.String) r1.get("remote_id"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x0767, code lost:
        if (r2 != null) goto L_0x076f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x0769, code lost:
        r14.error("readDescriptor", "device is disconnected", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x076f, code lost:
        C0();
        r1 = w0(r2, r3, r4, r1);
        r3 = r1.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x0778, code lost:
        if (r3 == null) goto L_0x0780;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x077a, code lost:
        r14.error("readDescriptor", r3, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x0780, code lost:
        r1 = f0(r5, r1.f9266a.getDescriptors());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x078a, code lost:
        if (r1 != null) goto L_0x07b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x078c, code lost:
        r14.error("writeDescriptor", "descriptor not found on characteristic. (desc: " + r5 + " chr: " + r4 + ")", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x07b4, code lost:
        if (r2.readDescriptor(r1) != false) goto L_0x07be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x07b6, code lost:
        r14.error("readDescriptor", "gatt.readDescriptor() returned false", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x07be, code lost:
        r14.success(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x07c5, code lost:
        r1 = (java.util.HashMap) r24.arguments();
        r3 = (java.lang.String) r1.get("remote_id");
        r5 = (java.lang.String) r1.get(com.upuphone.starrynet.api.StConstant.KEY_PAYLOAD_MESSAGE_SERVICE_UUID);
        r4 = (java.lang.String) r1.get("characteristic_uuid");
        r6 = (java.lang.String) r1.get("primary_service_uuid");
        r7 = (java.lang.String) r1.get(com.honey.account.constant.AccountConstantKt.RESPONSE_VALUE);
        r9 = ((java.lang.Integer) r1.get("write_type")).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x0803, code lost:
        if (((java.lang.Integer) r1.get("allow_long_write")).intValue() == 0) goto L_0x0807;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0805, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x0807, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x0808, code lost:
        if (r9 != 0) goto L_0x080c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x080a, code lost:
        r10 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x080c, code lost:
        r10 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x080d, code lost:
        r12 = (android.bluetooth.BluetoothGatt) r13.j.get(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x0815, code lost:
        if (r12 != null) goto L_0x081d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x0817, code lost:
        r14.error("writeCharacteristic", "device is disconnected", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x081d, code lost:
        C0();
        r11 = w0(r12, r5, r4, r6);
        r15 = r11.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x0826, code lost:
        if (r15 == null) goto L_0x082e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x0828, code lost:
        r14.error("writeCharacteristic", r15, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x082e, code lost:
        r24 = r12;
        r11 = r11.f9266a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0833, code lost:
        if (r10 != 1) goto L_0x0845;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x083b, code lost:
        if ((r11.getProperties() & 4) != 0) goto L_0x0855;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x083d, code lost:
        r14.error("writeCharacteristic", "The WRITE_NO_RESPONSE property is not supported by this BLE characteristic", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x084b, code lost:
        if ((r11.getProperties() & 8) != 0) goto L_0x0855;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x084d, code lost:
        r14.error("writeCharacteristic", "The WRITE property is not supported by this BLE characteristic", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x0855, code lost:
        r12 = h0(r3, r10, r1);
        r15 = m0(r7).length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x085e, code lost:
        if (r15 <= r12) goto L_0x08a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x0860, code lost:
        if (r9 != 0) goto L_0x0865;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x0862, code lost:
        r2 = "withResponse";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x0865, code lost:
        r2 = "withoutResponse";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x0867, code lost:
        if (r9 != 0) goto L_0x086d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x0869, code lost:
        if (r1 == false) goto L_0x0870;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x086b, code lost:
        r17 = ", allowLongWrite";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:315:0x0870, code lost:
        r17 = ", noLongWrite";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x0873, code lost:
        r14.error("writeCharacteristic", "data longer than allowed. dataLen: " + r15 + " > max: " + r12 + " (" + r2 + r17 + ")", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x08a2, code lost:
        if (r6 != null) goto L_0x08a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:0x08a4, code lost:
        r6 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x08a6, code lost:
        r13.o.put(r3 + com.honey.account.constant.AccountConstantKt.CODE_SEPARTOR + r5 + com.honey.account.constant.AccountConstantKt.CODE_SEPARTOR + r4 + com.honey.account.constant.AccountConstantKt.CODE_SEPARTOR + r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x08cd, code lost:
        if (android.os.Build.VERSION.SDK_INT < 33) goto L_0x08fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x08cf, code lost:
        r1 = r24.writeCharacteristic(r11, m0(r7), r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x08d9, code lost:
        if (r1 == 0) goto L_0x0923;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x08db, code lost:
        r14.error("writeCharacteristic", "gatt.writeCharacteristic() returned " + r1 + " : " + L(r1), (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x08fe, code lost:
        r12 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x0908, code lost:
        if (r11.setValue(m0(r7)) != false) goto L_0x0912;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x090a, code lost:
        r14.error("writeCharacteristic", "characteristic.setValue() returned false", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:0x0912, code lost:
        r11.setWriteType(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x0919, code lost:
        if (r12.writeCharacteristic(r11) != false) goto L_0x0923;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:329:0x091b, code lost:
        r14.error("writeCharacteristic", "gatt.writeCharacteristic() returned false", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:330:0x0923, code lost:
        r14.success(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:331:0x092a, code lost:
        r1 = (java.util.HashMap) r24.arguments();
        r3 = (java.lang.String) r1.get(com.upuphone.starrynet.api.StConstant.KEY_PAYLOAD_MESSAGE_SERVICE_UUID);
        r4 = (java.lang.String) r1.get("characteristic_uuid");
        r1 = (java.lang.String) r1.get("primary_service_uuid");
        r2 = (android.bluetooth.BluetoothGatt) r13.j.get((java.lang.String) r1.get("remote_id"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x0950, code lost:
        if (r2 != null) goto L_0x095a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:333:0x0952, code lost:
        r14.error(r22, "device is disconnected", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:334:0x095a, code lost:
        r6 = r22;
        C0();
        r1 = w0(r2, r3, r4, r1);
        r3 = r1.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:335:0x0965, code lost:
        if (r3 == null) goto L_0x096d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x0967, code lost:
        r14.error(r6, r3, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x096d, code lost:
        r1 = r1.f9266a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:0x0975, code lost:
        if ((r1.getProperties() & 2) != 0) goto L_0x097f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:339:0x0977, code lost:
        r14.error(r6, "The READ property is not supported by this BLE characteristic", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x0983, code lost:
        if (r2.readCharacteristic(r1) != false) goto L_0x098d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:342:0x0985, code lost:
        r14.error(r6, "gatt.readCharacteristic() returned false", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:343:0x098d, code lost:
        r14.success(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x0994, code lost:
        r1 = (android.bluetooth.BluetoothGatt) r13.j.get((java.lang.String) r1.arguments);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x09a0, code lost:
        if (r1 != null) goto L_0x09aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x09a2, code lost:
        r14.error(r21, "device is disconnected", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x09aa, code lost:
        r3 = r21;
        C0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x09b3, code lost:
        if (r1.discoverServices() != false) goto L_0x09bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x09b5, code lost:
        r14.error(r3, "gatt.discoverServices() returned false", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x09bd, code lost:
        r14.success(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:0x09c4, code lost:
        r1 = (java.lang.String) r1.arguments;
        r2 = (android.bluetooth.BluetoothGatt) r13.k.get(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x09d0, code lost:
        if (r2 == null) goto L_0x09da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x09d2, code lost:
        r4 = r19;
        x0(r4, "disconnect: cancelling connection in progress");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:0x09da, code lost:
        r4 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:0x09dc, code lost:
        if (r2 != null) goto L_0x09e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x09de, code lost:
        r2 = (android.bluetooth.BluetoothGatt) r13.j.get(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:0x09e6, code lost:
        if (r2 != null) goto L_0x0a09;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x09e8, code lost:
        r2 = (android.bluetooth.BluetoothGatt) r13.n.get(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x09f0, code lost:
        if (r2 == null) goto L_0x0a09;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x09f2, code lost:
        x0(r4, "already disconnected. disabling autoconnect");
        r13.n.remove(r1);
        r2.disconnect();
        r2.close();
        r14.success(java.lang.Boolean.FALSE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x0a09, code lost:
        if (r2 != null) goto L_0x0a17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x0a0b, code lost:
        x0(r4, "already disconnected");
        r14.success(java.lang.Boolean.FALSE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x0a17, code lost:
        r13.n.remove(r1);
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x0a25, code lost:
        if (r13.k.get(r1) == null) goto L_0x0a5d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x0a27, code lost:
        r13.k.remove(r1);
        r2.close();
        r2 = new java.util.HashMap();
        r2.put("remote_id", r1);
        r2.put("connection_state", java.lang.Integer.valueOf(U(0)));
        r2.put("disconnect_reason_code", 23789258);
        r2.put("disconnect_reason_string", "connection canceled");
        n0("OnConnectionStateChanged", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x0a5d, code lost:
        r14.success(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x0a64, code lost:
        r12 = true;
        r1 = (java.util.HashMap) r24.arguments();
        r2 = (java.lang.String) r1.get("remote_id");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x0a7d, code lost:
        if (((java.lang.Integer) r1.get("auto_connect")).intValue() == 0) goto L_0x0a80;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x0a80, code lost:
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x0a81, code lost:
        r1 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x0a8a, code lost:
        if (android.os.Build.VERSION.SDK_INT < 31) goto L_0x0a91;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x0a8c, code lost:
        r1.add(r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x0a91, code lost:
        a0(r1, new com.lib.flutter_blue_plus.f(r13, r14, r2, r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x0a9b, code lost:
        r3 = r20;
        r1 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x0aa6, code lost:
        if (android.os.Build.VERSION.SDK_INT < 31) goto L_0x0aab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x0aa8, code lost:
        r1.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x0aab, code lost:
        a0(r1, new com.lib.flutter_blue_plus.e(r13, r14));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x0ab5, code lost:
        r1 = r13.e.getBluetoothLeScanner();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x0abb, code lost:
        if (r1 == null) goto L_0x0ac7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x0abd, code lost:
        r1.stopScan(j0());
        r13.f = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x0ac7, code lost:
        r14.success(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x0ace, code lost:
        r3 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:?, code lost:
        r12 = (java.util.HashMap) r24.arguments();
        r6 = (java.util.List) r12.get("with_services");
        r7 = (java.util.List) r12.get("with_remote_ids");
        r8 = (java.util.List) r12.get("with_names");
        r9 = (java.util.List) r12.get("with_keywords");
        r10 = (java.util.List) r12.get("with_msd");
        r11 = (java.util.List) r12.get("with_service_data");
        ((java.lang.Boolean) r12.get("continuous_updates")).booleanValue();
        r5 = ((java.lang.Boolean) r12.get("android_legacy")).booleanValue();
        r4 = ((java.lang.Integer) r12.get("android_scan_mode")).intValue();
        r1 = ((java.lang.Boolean) r12.get("android_uses_fine_location")).booleanValue();
        r15 = new java.util.ArrayList();
        r2 = android.os.Build.VERSION.SDK_INT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:386:0x0b45, code lost:
        if (r2 < 31) goto L_0x0b5d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:387:0x0b47, code lost:
        r15.add("android.permission.BLUETOOTH_SCAN");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:388:0x0b4c, code lost:
        if (r1 == false) goto L_0x0b5a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:389:0x0b4e, code lost:
        r15.add("android.permission.ACCESS_FINE_LOCATION");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:390:0x0b54, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:391:0x0b55, code lost:
        r5 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:393:0x0b5a, code lost:
        r15.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:395:0x0b5f, code lost:
        if (r2 > 30) goto L_0x0b66;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:396:0x0b61, code lost:
        r15.add("android.permission.ACCESS_FINE_LOCATION");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:397:0x0b66, code lost:
        a0(r15, new com.lib.flutter_blue_plus.d(r23, r25, r4, r5, r6, r7, r8, r9, r10, r11, r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x0b75, code lost:
        r3 = r20;
        r1 = new java.util.ArrayList();
        r2 = android.os.Build.VERSION.SDK_INT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:399:0x0b80, code lost:
        if (r2 < 31) goto L_0x0b85;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:400:0x0b82, code lost:
        r1.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:402:0x0b87, code lost:
        if (r2 > 30) goto L_0x0b8e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:403:0x0b89, code lost:
        r1.add("android.permission.BLUETOOTH");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:405:0x0b90, code lost:
        r5 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:407:?, code lost:
        a0(r1, new com.lib.flutter_blue_plus.c(r13, r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:408:0x0b9a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:410:0x0b9c, code lost:
        r5 = r14;
        r3 = r20;
        r1 = new java.util.ArrayList();
        r2 = android.os.Build.VERSION.SDK_INT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:411:0x0ba8, code lost:
        if (r2 < 31) goto L_0x0bad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:412:0x0baa, code lost:
        r1.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:0x0baf, code lost:
        if (r2 > 30) goto L_0x0bb6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x0bb1, code lost:
        r1.add("android.permission.BLUETOOTH");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:416:0x0bb6, code lost:
        a0(r1, new com.lib.flutter_blue_plus.b(r13, r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:417:0x0bc0, code lost:
        r5 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:419:?, code lost:
        r1 = r13.e.getState();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:420:0x0bc8, code lost:
        r1 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:424:0x0be0, code lost:
        r5 = r14;
        r3 = r20;
        r1 = new java.util.ArrayList();
        r2 = android.os.Build.VERSION.SDK_INT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:425:0x0bec, code lost:
        if (r2 < 31) goto L_0x0bf1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:426:0x0bee, code lost:
        r1.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:428:0x0bf3, code lost:
        if (r2 > 30) goto L_0x0bfa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:429:0x0bf5, code lost:
        r1.add("android.permission.BLUETOOTH");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:430:0x0bfa, code lost:
        a0(r1, new com.lib.flutter_blue_plus.a(r13, r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:431:0x0c04, code lost:
        r5 = r14;
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:432:0x0c08, code lost:
        if (r13.e == null) goto L_0x0c0b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:434:0x0c0b, code lost:
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:435:0x0c0c, code lost:
        r5.success(java.lang.Boolean.valueOf(r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:436:0x0c15, code lost:
        r13.f9260a = com.lib.flutter_blue_plus.FlutterBluePlusPlugin.LogLevel.values()[((java.lang.Integer) r1.arguments).intValue()];
        r14.success(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:437:0x0c2d, code lost:
        r5 = r14;
        r4 = r19;
        x0(r4, "connectedPeripherals: " + r13.j.size());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:438:0x0c50, code lost:
        if (r13.j.size() != 0) goto L_0x0c57;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:439:0x0c52, code lost:
        x0(r4, "Hot Restart: complete");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:440:0x0c57, code lost:
        r5.success(java.lang.Integer.valueOf(r13.j.size()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:441:0x0c65, code lost:
        r14.success(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:442:0x0c6c, code lost:
        r5 = r14;
        r4 = r19;
        r1 = r13.e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:443:0x0c71, code lost:
        if (r1 != null) goto L_0x0c7c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:444:0x0c73, code lost:
        r5.success(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:445:0x0c7c, code lost:
        r1 = r1.getBluetoothLeScanner();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:446:0x0c80, code lost:
        if (r1 == null) goto L_0x0c95;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:448:0x0c84, code lost:
        if (r13.f == false) goto L_0x0c95;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:449:0x0c86, code lost:
        x0(r4, "calling stopScan (flutterRestart)");
        r1.stopScan(j0());
        r13.f = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:450:0x0c95, code lost:
        Z(r18);
        x0(r4, "connectedPeripherals: " + r13.j.size());
        r5.success(java.lang.Integer.valueOf(r13.j.size()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r24, io.flutter.plugin.common.MethodChannel.Result r25) {
        /*
            r23 = this;
            r13 = r23
            r1 = r24
            r14 = r25
            java.util.concurrent.Semaphore r2 = r13.i     // Catch:{ Exception -> 0x0cc7 }
            r13.I(r2)     // Catch:{ Exception -> 0x0cc7 }
            com.lib.flutter_blue_plus.FlutterBluePlusPlugin$LogLevel r2 = com.lib.flutter_blue_plus.FlutterBluePlusPlugin.LogLevel.DEBUG     // Catch:{ Exception -> 0x0cc7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0cc7 }
            r3.<init>()     // Catch:{ Exception -> 0x0cc7 }
            java.lang.String r4 = "onMethodCall: "
            r3.append(r4)     // Catch:{ Exception -> 0x0cc7 }
            java.lang.String r4 = r1.method     // Catch:{ Exception -> 0x0cc7 }
            r3.append(r4)     // Catch:{ Exception -> 0x0cc7 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0cc7 }
            r13.x0(r2, r3)     // Catch:{ Exception -> 0x0cc7 }
            android.bluetooth.BluetoothAdapter r3 = r13.e     // Catch:{ Exception -> 0x0cc7 }
            r4 = 0
            if (r3 != 0) goto L_0x004c
            java.lang.String r3 = "initializing BluetoothAdapter"
            r13.x0(r2, r3)     // Catch:{ Exception -> 0x0044 }
            android.content.Context r3 = r13.b     // Catch:{ Exception -> 0x0044 }
            java.lang.String r5 = "bluetooth"
            java.lang.Object r3 = r3.getSystemService(r5)     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothManager r3 = (android.bluetooth.BluetoothManager) r3     // Catch:{ Exception -> 0x0044 }
            r13.d = r3     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x0049
            android.bluetooth.BluetoothAdapter r3 = r3.getAdapter()     // Catch:{ Exception -> 0x0044 }
            goto L_0x004a
        L_0x0040:
            r0 = move-exception
            r1 = r0
            goto L_0x0ce7
        L_0x0044:
            r0 = move-exception
            r1 = r0
            r5 = r14
            goto L_0x0ccb
        L_0x0049:
            r3 = r4
        L_0x004a:
            r13.e = r3     // Catch:{ Exception -> 0x0044 }
        L_0x004c:
            android.bluetooth.BluetoothAdapter r3 = r13.e     // Catch:{ Exception -> 0x0cc7 }
            java.lang.String r5 = "flutterRestart"
            if (r3 != 0) goto L_0x0099
            java.lang.String r3 = r1.method     // Catch:{ Exception -> 0x0044 }
            boolean r3 = r5.equals(r3)     // Catch:{ Exception -> 0x0044 }
            if (r3 != 0) goto L_0x0099
            java.lang.String r3 = "connectedCount"
            java.lang.String r6 = r1.method     // Catch:{ Exception -> 0x0044 }
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 != 0) goto L_0x0099
            java.lang.String r3 = "setLogLevel"
            java.lang.String r6 = r1.method     // Catch:{ Exception -> 0x0044 }
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 != 0) goto L_0x0099
            java.lang.String r3 = "isSupported"
            java.lang.String r6 = r1.method     // Catch:{ Exception -> 0x0044 }
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 != 0) goto L_0x0099
            java.lang.String r3 = "getAdapterName"
            java.lang.String r6 = r1.method     // Catch:{ Exception -> 0x0044 }
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 != 0) goto L_0x0099
            java.lang.String r3 = "getAdapterState"
            java.lang.String r6 = r1.method     // Catch:{ Exception -> 0x0044 }
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 != 0) goto L_0x0099
            java.lang.String r1 = "bluetoothUnavailable"
            java.lang.String r2 = "the device does not support bluetooth"
            r14.error(r1, r2, r4)     // Catch:{ Exception -> 0x0044 }
        L_0x0093:
            java.util.concurrent.Semaphore r1 = r13.i
            r1.release()
            return
        L_0x0099:
            java.lang.String r3 = r1.method     // Catch:{ Exception -> 0x0cc7 }
            int r6 = r3.hashCode()     // Catch:{ Exception -> 0x0cc7 }
            java.lang.String r7 = "discoverServices"
            java.lang.String r9 = "clearGattCache"
            java.lang.String r10 = "readDescriptor"
            java.lang.String r11 = "readCharacteristic"
            java.lang.String r15 = "writeDescriptor"
            java.lang.String r8 = "writeCharacteristic"
            java.lang.String r12 = "setNotifyValue"
            switch(r6) {
                case -2129330689: goto L_0x01ed;
                case -1824027656: goto L_0x01e2;
                case -1702200072: goto L_0x01d8;
                case -1683323867: goto L_0x01cd;
                case -1331239341: goto L_0x01c5;
                case -1301283666: goto L_0x01bc;
                case -1130630310: goto L_0x01b3;
                case -965507150: goto L_0x01a8;
                case -938333999: goto L_0x019f;
                case -867589363: goto L_0x0194;
                case -862429380: goto L_0x0189;
                case -309915358: goto L_0x017e;
                case -129472623: goto L_0x0172;
                case -55076540: goto L_0x0167;
                case 37093023: goto L_0x015b;
                case 131459558: goto L_0x0151;
                case 162324162: goto L_0x0145;
                case 206669221: goto L_0x013b;
                case 407411460: goto L_0x012f;
                case 530405532: goto L_0x0123;
                case 916212952: goto L_0x0117;
                case 951351530: goto L_0x010b;
                case 1098040679: goto L_0x00ff;
                case 1158616740: goto L_0x00f4;
                case 1368682975: goto L_0x00e8;
                case 1614410599: goto L_0x00de;
                case 1661332358: goto L_0x00d3;
                case 1714778527: goto L_0x00c7;
                case 1724190684: goto L_0x00bc;
                case 1911397115: goto L_0x00b2;
                default: goto L_0x00b0;
            }
        L_0x00b0:
            goto L_0x01f8
        L_0x00b2:
            boolean r3 = r3.equals(r9)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 29
            goto L_0x01f9
        L_0x00bc:
            java.lang.String r6 = "setOptions"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 1
            goto L_0x01f9
        L_0x00c7:
            java.lang.String r6 = "stopScan"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 10
            goto L_0x01f9
        L_0x00d3:
            java.lang.String r6 = "connectedCount"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 2
            goto L_0x01f9
        L_0x00de:
            boolean r3 = r3.equals(r7)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 14
            goto L_0x01f9
        L_0x00e8:
            java.lang.String r6 = "createBond"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 27
            goto L_0x01f9
        L_0x00f4:
            java.lang.String r6 = "isSupported"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 4
            goto L_0x01f9
        L_0x00ff:
            java.lang.String r6 = "removeBond"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 28
            goto L_0x01f9
        L_0x010b:
            java.lang.String r6 = "connect"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 12
            goto L_0x01f9
        L_0x0117:
            java.lang.String r6 = "getBondState"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 26
            goto L_0x01f9
        L_0x0123:
            java.lang.String r6 = "disconnect"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 13
            goto L_0x01f9
        L_0x012f:
            java.lang.String r6 = "getPhySupport"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 23
            goto L_0x01f9
        L_0x013b:
            boolean r3 = r3.equals(r10)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 17
            goto L_0x01f9
        L_0x0145:
            java.lang.String r6 = "setPreferredPhy"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 24
            goto L_0x01f9
        L_0x0151:
            boolean r3 = r3.equals(r12)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 19
            goto L_0x01f9
        L_0x015b:
            java.lang.String r6 = "requestMtu"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 20
            goto L_0x01f9
        L_0x0167:
            java.lang.String r6 = "getAdapterName"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 5
            goto L_0x01f9
        L_0x0172:
            java.lang.String r6 = "requestConnectionPriority"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 22
            goto L_0x01f9
        L_0x017e:
            java.lang.String r6 = "setLogLevel"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 3
            goto L_0x01f9
        L_0x0189:
            java.lang.String r6 = "turnOn"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 7
            goto L_0x01f9
        L_0x0194:
            java.lang.String r6 = "readRssi"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 21
            goto L_0x01f9
        L_0x019f:
            boolean r3 = r3.equals(r11)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 15
            goto L_0x01f9
        L_0x01a8:
            java.lang.String r6 = "turnOff"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 8
            goto L_0x01f9
        L_0x01b3:
            boolean r3 = r3.equals(r8)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 16
            goto L_0x01f9
        L_0x01bc:
            boolean r3 = r3.equals(r15)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 18
            goto L_0x01f9
        L_0x01c5:
            boolean r3 = r3.equals(r5)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 0
            goto L_0x01f9
        L_0x01cd:
            java.lang.String r6 = "getBondedDevices"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 25
            goto L_0x01f9
        L_0x01d8:
            java.lang.String r6 = "getAdapterState"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 6
            goto L_0x01f9
        L_0x01e2:
            java.lang.String r6 = "getSystemDevices"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x01f8
            r3 = 11
            goto L_0x01f9
        L_0x01ed:
            java.lang.String r6 = "startScan"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0cc7 }
            if (r3 == 0) goto L_0x01f8
            r3 = 9
            goto L_0x01f9
        L_0x01f8:
            r3 = -1
        L_0x01f9:
            java.lang.String r17 = ""
            java.lang.String r6 = "primary_service_uuid"
            java.lang.String r4 = "characteristic_uuid"
            r18 = r5
            java.lang.String r5 = "service_uuid"
            r19 = r2
            java.lang.String r2 = "android.permission.BLUETOOTH_CONNECT"
            r20 = r2
            java.lang.String r2 = ":"
            r21 = r7
            java.lang.String r7 = "remote_id"
            r22 = r11
            java.lang.String r11 = "device is disconnected"
            switch(r3) {
                case 0: goto L_0x0c6c;
                case 1: goto L_0x0c65;
                case 2: goto L_0x0c2d;
                case 3: goto L_0x0c15;
                case 4: goto L_0x0c04;
                case 5: goto L_0x0be0;
                case 6: goto L_0x0bc0;
                case 7: goto L_0x0b9c;
                case 8: goto L_0x0b75;
                case 9: goto L_0x0ace;
                case 10: goto L_0x0ab5;
                case 11: goto L_0x0a9b;
                case 12: goto L_0x0a64;
                case 13: goto L_0x09c4;
                case 14: goto L_0x0994;
                case 15: goto L_0x092a;
                case 16: goto L_0x07c5;
                case 17: goto L_0x0739;
                case 18: goto L_0x05fa;
                case 19: goto L_0x0486;
                case 20: goto L_0x0442;
                case 21: goto L_0x0412;
                case 22: goto L_0x03ca;
                case 23: goto L_0x03a2;
                case 24: goto L_0x0353;
                case 25: goto L_0x0321;
                case 26: goto L_0x02f3;
                case 27: goto L_0x0294;
                case 28: goto L_0x024d;
                case 29: goto L_0x021b;
                default: goto L_0x0216;
            }
        L_0x0216:
            r25.notImplemented()     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x021b:
            java.lang.Object r1 = r1.arguments     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0044 }
            java.util.Map r2 = r13.j     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothGatt r1 = (android.bluetooth.BluetoothGatt) r1     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x022f
            r2 = 0
            r14.error(r9, r11, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x022f:
            r2 = 0
            java.lang.Class r3 = r1.getClass()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r4 = "refresh"
            java.lang.reflect.Method r3 = r3.getMethod(r4, r2)     // Catch:{ Exception -> 0x0044 }
            if (r3 != 0) goto L_0x0243
            java.lang.String r1 = "unsupported on this android version"
            r14.error(r9, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0243:
            r3.invoke(r1, r2)     // Catch:{ Exception -> 0x0044 }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x024d:
            java.lang.Object r1 = r1.arguments     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothAdapter r2 = r13.e     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothDevice r1 = r2.getRemoteDevice(r1)     // Catch:{ Exception -> 0x0044 }
            int r2 = r1.getBondState()     // Catch:{ Exception -> 0x0044 }
            r3 = 10
            if (r2 != r3) goto L_0x026d
            com.lib.flutter_blue_plus.FlutterBluePlusPlugin$LogLevel r1 = com.lib.flutter_blue_plus.FlutterBluePlusPlugin.LogLevel.WARNING     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = "already not bonded"
            r13.x0(r1, r2)     // Catch:{ Exception -> 0x0044 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x026d:
            java.lang.Class r2 = r1.getClass()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = "removeBond"
            r4 = 0
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r1 = r2.invoke(r1, r4)     // Catch:{ Exception -> 0x0044 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x0044 }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x028d
            java.lang.String r1 = "removeBond"
            java.lang.String r2 = "device.removeBond() returned false"
            r14.error(r1, r2, r4)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x028d:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0294:
            java.lang.Object r1 = r1.arguments     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0044 }
            java.util.Map r2 = r13.j     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothGatt r2 = (android.bluetooth.BluetoothGatt) r2     // Catch:{ Exception -> 0x0044 }
            if (r2 != 0) goto L_0x02aa
            java.lang.String r1 = "createBond"
            r2 = 0
            r14.error(r1, r11, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x02aa:
            android.bluetooth.BluetoothAdapter r2 = r13.e     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothDevice r1 = r2.getRemoteDevice(r1)     // Catch:{ Exception -> 0x0044 }
            int r2 = r1.getBondState()     // Catch:{ Exception -> 0x0044 }
            r3 = 12
            if (r2 != r3) goto L_0x02c6
            com.lib.flutter_blue_plus.FlutterBluePlusPlugin$LogLevel r1 = com.lib.flutter_blue_plus.FlutterBluePlusPlugin.LogLevel.WARNING     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = "already bonded"
            r13.x0(r1, r2)     // Catch:{ Exception -> 0x0044 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x02c6:
            int r2 = r1.getBondState()     // Catch:{ Exception -> 0x0044 }
            r3 = 11
            if (r2 != r3) goto L_0x02dc
            com.lib.flutter_blue_plus.FlutterBluePlusPlugin$LogLevel r1 = com.lib.flutter_blue_plus.FlutterBluePlusPlugin.LogLevel.WARNING     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = "bonding already in progress"
            r13.x0(r1, r2)     // Catch:{ Exception -> 0x0044 }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x02dc:
            boolean r1 = r1.createBond()     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x02ec
            java.lang.String r1 = "createBond"
            java.lang.String r2 = "device.createBond() returned false"
            r3 = 0
            r14.error(r1, r2, r3)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x02ec:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x02f3:
            java.lang.Object r1 = r1.arguments     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothAdapter r2 = r13.e     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothDevice r2 = r2.getRemoteDevice(r1)     // Catch:{ Exception -> 0x0044 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0044 }
            r3.<init>()     // Catch:{ Exception -> 0x0044 }
            r3.put(r7, r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = "bond_state"
            int r2 = r2.getBondState()     // Catch:{ Exception -> 0x0044 }
            int r2 = R(r2)     // Catch:{ Exception -> 0x0044 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0044 }
            r3.put(r1, r2)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = "prev_state"
            r2 = 0
            r3.put(r1, r2)     // Catch:{ Exception -> 0x0044 }
            r14.success(r3)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0321:
            android.bluetooth.BluetoothAdapter r1 = r13.e     // Catch:{ Exception -> 0x0044 }
            java.util.Set r1 = r1.getBondedDevices()     // Catch:{ Exception -> 0x0044 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0044 }
            r2.<init>()     // Catch:{ Exception -> 0x0044 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0044 }
        L_0x0330:
            boolean r3 = r1.hasNext()     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x0344
            java.lang.Object r3 = r1.next()     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothDevice r3 = (android.bluetooth.BluetoothDevice) r3     // Catch:{ Exception -> 0x0044 }
            java.util.HashMap r3 = r13.P(r3)     // Catch:{ Exception -> 0x0044 }
            r2.add(r3)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0330
        L_0x0344:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x0044 }
            r1.<init>()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = "devices"
            r1.put(r3, r2)     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0353:
            java.lang.Object r1 = r24.arguments()     // Catch:{ Exception -> 0x0044 }
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r2 = r1.get(r7)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = "tx_phy"
            java.lang.Object r3 = r1.get(r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ Exception -> 0x0044 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r4 = "rx_phy"
            java.lang.Object r4 = r1.get(r4)     // Catch:{ Exception -> 0x0044 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x0044 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r5 = "phy_options"
            java.lang.Object r1 = r1.get(r5)     // Catch:{ Exception -> 0x0044 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0044 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0044 }
            java.util.Map r5 = r13.j     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r2 = r5.get(r2)     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothGatt r2 = (android.bluetooth.BluetoothGatt) r2     // Catch:{ Exception -> 0x0044 }
            if (r2 != 0) goto L_0x0395
            java.lang.String r1 = "setPreferredPhy"
            r2 = 0
            r14.error(r1, r11, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0395:
            r23.C0()     // Catch:{ Exception -> 0x0044 }
            r2.setPreferredPhy(r3, r4, r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x03a2:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x0044 }
            r1.<init>()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = "le_2M"
            android.bluetooth.BluetoothAdapter r3 = r13.e     // Catch:{ Exception -> 0x0044 }
            boolean r3 = r3.isLe2MPhySupported()     // Catch:{ Exception -> 0x0044 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x0044 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = "le_coded"
            android.bluetooth.BluetoothAdapter r3 = r13.e     // Catch:{ Exception -> 0x0044 }
            boolean r3 = r3.isLeCodedPhySupported()     // Catch:{ Exception -> 0x0044 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x0044 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x03ca:
            java.lang.Object r1 = r24.arguments()     // Catch:{ Exception -> 0x0044 }
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r2 = r1.get(r7)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = "connection_priority"
            java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0044 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0044 }
            java.util.Map r3 = r13.j     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r2 = r3.get(r2)     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothGatt r2 = (android.bluetooth.BluetoothGatt) r2     // Catch:{ Exception -> 0x0044 }
            if (r2 != 0) goto L_0x03f4
            java.lang.String r1 = "requestConnectionPriority"
            r2 = 0
            r14.error(r1, r11, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x03f4:
            r23.C0()     // Catch:{ Exception -> 0x0044 }
            int r1 = T(r1)     // Catch:{ Exception -> 0x0044 }
            boolean r1 = r2.requestConnectionPriority(r1)     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x040b
            java.lang.String r1 = "requestConnectionPriority"
            java.lang.String r2 = "gatt.requestConnectionPriority() returned false"
            r3 = 0
            r14.error(r1, r2, r3)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x040b:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0412:
            java.lang.Object r1 = r1.arguments     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0044 }
            java.util.Map r2 = r13.j     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothGatt r1 = (android.bluetooth.BluetoothGatt) r1     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x0428
            java.lang.String r1 = "readRssi"
            r2 = 0
            r14.error(r1, r11, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0428:
            r23.C0()     // Catch:{ Exception -> 0x0044 }
            boolean r1 = r1.readRemoteRssi()     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x043b
            java.lang.String r1 = "readRssi"
            java.lang.String r2 = "gatt.readRemoteRssi() returned false"
            r3 = 0
            r14.error(r1, r2, r3)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x043b:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0442:
            java.lang.Object r1 = r24.arguments()     // Catch:{ Exception -> 0x0044 }
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r2 = r1.get(r7)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = "mtu"
            java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0044 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0044 }
            java.util.Map r3 = r13.j     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r2 = r3.get(r2)     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothGatt r2 = (android.bluetooth.BluetoothGatt) r2     // Catch:{ Exception -> 0x0044 }
            if (r2 != 0) goto L_0x046c
            java.lang.String r1 = "requestMtu"
            r2 = 0
            r14.error(r1, r11, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x046c:
            r23.C0()     // Catch:{ Exception -> 0x0044 }
            boolean r1 = r2.requestMtu(r1)     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x047f
            java.lang.String r1 = "requestMtu"
            java.lang.String r2 = "gatt.requestMtu() returned false"
            r3 = 0
            r14.error(r1, r2, r3)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x047f:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0486:
            java.lang.Object r1 = r24.arguments()     // Catch:{ Exception -> 0x0044 }
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r3 = r1.get(r7)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r5 = r1.get(r5)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r4 = r1.get(r4)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r6 = r1.get(r6)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0044 }
            java.lang.String r7 = "force_indications"
            java.lang.Object r7 = r1.get(r7)     // Catch:{ Exception -> 0x0044 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ Exception -> 0x0044 }
            boolean r7 = r7.booleanValue()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r8 = "enable"
            java.lang.Object r1 = r1.get(r8)     // Catch:{ Exception -> 0x0044 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x0044 }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x0044 }
            java.util.Map r8 = r13.j     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r8 = r8.get(r3)     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothGatt r8 = (android.bluetooth.BluetoothGatt) r8     // Catch:{ Exception -> 0x0044 }
            if (r8 != 0) goto L_0x04cc
            r9 = 0
            r14.error(r12, r11, r9)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x04cc:
            r23.C0()     // Catch:{ Exception -> 0x0044 }
            com.lib.flutter_blue_plus.FlutterBluePlusPlugin$ChrFound r9 = r13.w0(r8, r5, r4, r6)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r10 = r9.b     // Catch:{ Exception -> 0x0044 }
            if (r10 == 0) goto L_0x04dd
            r11 = 0
            r14.error(r12, r10, r11)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x04dd:
            android.bluetooth.BluetoothGattCharacteristic r9 = r9.f9266a     // Catch:{ Exception -> 0x0044 }
            boolean r10 = r8.setCharacteristicNotification(r9, r1)     // Catch:{ Exception -> 0x0044 }
            if (r10 != 0) goto L_0x0501
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0044 }
            r2.<init>()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = "gatt.setCharacteristicNotification("
            r2.append(r3)     // Catch:{ Exception -> 0x0044 }
            r2.append(r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = ") returned false"
            r2.append(r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0044 }
            r2 = 0
            r14.error(r12, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0501:
            java.lang.String r10 = "2902"
            java.util.List r11 = r9.getDescriptors()     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothGattDescriptor r10 = r13.f0(r10, r11)     // Catch:{ Exception -> 0x0044 }
            if (r10 != 0) goto L_0x0532
            java.util.UUID r1 = r9.getUuid()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = r13.B0(r1)     // Catch:{ Exception -> 0x0044 }
            com.lib.flutter_blue_plus.FlutterBluePlusPlugin$LogLevel r2 = com.lib.flutter_blue_plus.FlutterBluePlusPlugin.LogLevel.WARNING     // Catch:{ Exception -> 0x0044 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0044 }
            r3.<init>()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r4 = "CCCD descriptor for characteristic not found: "
            r3.append(r4)     // Catch:{ Exception -> 0x0044 }
            r3.append(r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0044 }
            r13.x0(r2, r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0093
        L_0x0532:
            if (r1 == 0) goto L_0x0573
            int r1 = r9.getProperties()     // Catch:{ Exception -> 0x0044 }
            r1 = r1 & 16
            if (r1 <= 0) goto L_0x053e
            r1 = 1
            goto L_0x053f
        L_0x053e:
            r1 = 0
        L_0x053f:
            int r9 = r9.getProperties()     // Catch:{ Exception -> 0x0044 }
            r9 = r9 & 32
            if (r9 <= 0) goto L_0x054a
            r16 = 1
            goto L_0x054c
        L_0x054a:
            r16 = 0
        L_0x054c:
            if (r16 != 0) goto L_0x0558
            if (r1 != 0) goto L_0x0558
            java.lang.String r1 = "neither NOTIFY nor INDICATE properties are supported by this BLE characteristic"
            r2 = 0
            r14.error(r12, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0558:
            if (r7 == 0) goto L_0x0564
            if (r16 != 0) goto L_0x0564
            java.lang.String r1 = "INDICATE not supported by this BLE characteristic"
            r2 = 0
            r14.error(r12, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0564:
            if (r16 == 0) goto L_0x0569
            byte[] r9 = android.bluetooth.BluetoothGattDescriptor.ENABLE_INDICATION_VALUE     // Catch:{ Exception -> 0x0044 }
            goto L_0x056a
        L_0x0569:
            r9 = 0
        L_0x056a:
            if (r1 == 0) goto L_0x056e
            byte[] r9 = android.bluetooth.BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE     // Catch:{ Exception -> 0x0044 }
        L_0x056e:
            if (r7 == 0) goto L_0x0575
            byte[] r9 = android.bluetooth.BluetoothGattDescriptor.ENABLE_INDICATION_VALUE     // Catch:{ Exception -> 0x0044 }
            goto L_0x0575
        L_0x0573:
            byte[] r9 = android.bluetooth.BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE     // Catch:{ Exception -> 0x0044 }
        L_0x0575:
            if (r6 != 0) goto L_0x0579
            r6 = r17
        L_0x0579:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0044 }
            r1.<init>()     // Catch:{ Exception -> 0x0044 }
            r1.append(r3)     // Catch:{ Exception -> 0x0044 }
            r1.append(r2)     // Catch:{ Exception -> 0x0044 }
            r1.append(r5)     // Catch:{ Exception -> 0x0044 }
            r1.append(r2)     // Catch:{ Exception -> 0x0044 }
            r1.append(r4)     // Catch:{ Exception -> 0x0044 }
            r1.append(r2)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = "2902"
            r1.append(r3)     // Catch:{ Exception -> 0x0044 }
            r1.append(r2)     // Catch:{ Exception -> 0x0044 }
            r1.append(r6)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0044 }
            java.util.Map r2 = r13.p     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = X(r9)     // Catch:{ Exception -> 0x0044 }
            r2.put(r1, r3)     // Catch:{ Exception -> 0x0044 }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0044 }
            r2 = 33
            if (r1 < r2) goto L_0x05d7
            int r1 = r8.writeDescriptor(r10, r9)     // Catch:{ Exception -> 0x0044 }
            if (r1 == 0) goto L_0x05f3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0044 }
            r2.<init>()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = "gatt.writeDescriptor() returned "
            r2.append(r3)     // Catch:{ Exception -> 0x0044 }
            r2.append(r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = " : "
            r2.append(r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = L(r1)     // Catch:{ Exception -> 0x0044 }
            r2.append(r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0044 }
            r2 = 0
            r14.error(r12, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x05d7:
            boolean r1 = r10.setValue(r9)     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x05e5
            java.lang.String r1 = "cccd.setValue() returned false"
            r2 = 0
            r14.error(r12, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x05e5:
            boolean r1 = r8.writeDescriptor(r10)     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x05f3
            java.lang.String r1 = "gatt.writeDescriptor() returned false"
            r2 = 0
            r14.error(r12, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x05f3:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x05fa:
            java.lang.Object r1 = r24.arguments()     // Catch:{ Exception -> 0x0044 }
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r3 = r1.get(r7)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r5 = r1.get(r5)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r4 = r1.get(r4)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0044 }
            java.lang.String r7 = "descriptor_uuid"
            java.lang.Object r7 = r1.get(r7)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r6 = r1.get(r6)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0044 }
            java.lang.String r8 = "value"
            java.lang.Object r1 = r1.get(r8)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0044 }
            java.util.Map r8 = r13.j     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r8 = r8.get(r3)     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothGatt r8 = (android.bluetooth.BluetoothGatt) r8     // Catch:{ Exception -> 0x0044 }
            if (r8 != 0) goto L_0x0638
            r9 = 0
            r14.error(r15, r11, r9)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0638:
            r23.C0()     // Catch:{ Exception -> 0x0044 }
            com.lib.flutter_blue_plus.FlutterBluePlusPlugin$ChrFound r9 = r13.w0(r8, r5, r4, r6)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r10 = r9.b     // Catch:{ Exception -> 0x0044 }
            if (r10 == 0) goto L_0x0649
            r11 = 0
            r14.error(r15, r10, r11)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0649:
            android.bluetooth.BluetoothGattCharacteristic r9 = r9.f9266a     // Catch:{ Exception -> 0x0044 }
            java.util.List r9 = r9.getDescriptors()     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothGattDescriptor r9 = r13.f0(r7, r9)     // Catch:{ Exception -> 0x0044 }
            if (r9 != 0) goto L_0x0679
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0044 }
            r1.<init>()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = "descriptor not found on characteristic. (desc: "
            r1.append(r2)     // Catch:{ Exception -> 0x0044 }
            r1.append(r7)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = " chr: "
            r1.append(r2)     // Catch:{ Exception -> 0x0044 }
            r1.append(r4)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0044 }
            r2 = 0
            r14.error(r15, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0679:
            java.util.Map r10 = r13.m     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r10 = r10.get(r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ Exception -> 0x0044 }
            int r10 = r10.intValue()     // Catch:{ Exception -> 0x0044 }
            int r10 = r10 + -3
            byte[] r11 = m0(r1)     // Catch:{ Exception -> 0x0044 }
            int r11 = r11.length     // Catch:{ Exception -> 0x0044 }
            if (r10 >= r11) goto L_0x06b2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0044 }
            r2.<init>()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = "data longer than mtu allows. dataLength: "
            r2.append(r3)     // Catch:{ Exception -> 0x0044 }
            byte[] r1 = m0(r1)     // Catch:{ Exception -> 0x0044 }
            int r1 = r1.length     // Catch:{ Exception -> 0x0044 }
            r2.append(r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = "> max: "
            r2.append(r1)     // Catch:{ Exception -> 0x0044 }
            r2.append(r10)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0044 }
            r2 = 0
            r14.error(r15, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x06b2:
            if (r6 != 0) goto L_0x06b6
            r6 = r17
        L_0x06b6:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0044 }
            r10.<init>()     // Catch:{ Exception -> 0x0044 }
            r10.append(r3)     // Catch:{ Exception -> 0x0044 }
            r10.append(r2)     // Catch:{ Exception -> 0x0044 }
            r10.append(r5)     // Catch:{ Exception -> 0x0044 }
            r10.append(r2)     // Catch:{ Exception -> 0x0044 }
            r10.append(r4)     // Catch:{ Exception -> 0x0044 }
            r10.append(r2)     // Catch:{ Exception -> 0x0044 }
            r10.append(r7)     // Catch:{ Exception -> 0x0044 }
            r10.append(r2)     // Catch:{ Exception -> 0x0044 }
            r10.append(r6)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = r10.toString()     // Catch:{ Exception -> 0x0044 }
            java.util.Map r3 = r13.p     // Catch:{ Exception -> 0x0044 }
            r3.put(r2, r1)     // Catch:{ Exception -> 0x0044 }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0044 }
            r3 = 33
            if (r2 < r3) goto L_0x0712
            byte[] r1 = m0(r1)     // Catch:{ Exception -> 0x0044 }
            int r1 = r8.writeDescriptor(r9, r1)     // Catch:{ Exception -> 0x0044 }
            if (r1 == 0) goto L_0x0732
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0044 }
            r2.<init>()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = "gatt.writeDescriptor() returned "
            r2.append(r3)     // Catch:{ Exception -> 0x0044 }
            r2.append(r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = " : "
            r2.append(r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = L(r1)     // Catch:{ Exception -> 0x0044 }
            r2.append(r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0044 }
            r2 = 0
            r14.error(r15, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0093
        L_0x0712:
            byte[] r1 = m0(r1)     // Catch:{ Exception -> 0x0044 }
            boolean r1 = r9.setValue(r1)     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x0724
            java.lang.String r1 = "descriptor.setValue() returned false"
            r2 = 0
            r14.error(r15, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0724:
            boolean r1 = r8.writeDescriptor(r9)     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x0732
            java.lang.String r1 = "gatt.writeDescriptor() returned false"
            r2 = 0
            r14.error(r15, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0732:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0739:
            java.lang.Object r1 = r24.arguments()     // Catch:{ Exception -> 0x0044 }
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r2 = r1.get(r7)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r3 = r1.get(r5)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r4 = r1.get(r4)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0044 }
            java.lang.String r5 = "descriptor_uuid"
            java.lang.Object r5 = r1.get(r5)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0044 }
            java.util.Map r6 = r13.j     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r2 = r6.get(r2)     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothGatt r2 = (android.bluetooth.BluetoothGatt) r2     // Catch:{ Exception -> 0x0044 }
            if (r2 != 0) goto L_0x076f
            r6 = 0
            r14.error(r10, r11, r6)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x076f:
            r23.C0()     // Catch:{ Exception -> 0x0044 }
            com.lib.flutter_blue_plus.FlutterBluePlusPlugin$ChrFound r1 = r13.w0(r2, r3, r4, r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = r1.b     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x0780
            r6 = 0
            r14.error(r10, r3, r6)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0780:
            android.bluetooth.BluetoothGattCharacteristic r1 = r1.f9266a     // Catch:{ Exception -> 0x0044 }
            java.util.List r1 = r1.getDescriptors()     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothGattDescriptor r1 = r13.f0(r5, r1)     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x07b0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0044 }
            r1.<init>()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = "descriptor not found on characteristic. (desc: "
            r1.append(r2)     // Catch:{ Exception -> 0x0044 }
            r1.append(r5)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = " chr: "
            r1.append(r2)     // Catch:{ Exception -> 0x0044 }
            r1.append(r4)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0044 }
            r2 = 0
            r14.error(r15, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x07b0:
            boolean r1 = r2.readDescriptor(r1)     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x07be
            java.lang.String r1 = "gatt.readDescriptor() returned false"
            r2 = 0
            r14.error(r10, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x07be:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x07c5:
            java.lang.Object r1 = r24.arguments()     // Catch:{ Exception -> 0x0044 }
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r3 = r1.get(r7)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r5 = r1.get(r5)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r4 = r1.get(r4)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r6 = r1.get(r6)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0044 }
            java.lang.String r7 = "value"
            java.lang.Object r7 = r1.get(r7)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0044 }
            java.lang.String r9 = "write_type"
            java.lang.Object r9 = r1.get(r9)     // Catch:{ Exception -> 0x0044 }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ Exception -> 0x0044 }
            int r9 = r9.intValue()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r10 = "allow_long_write"
            java.lang.Object r1 = r1.get(r10)     // Catch:{ Exception -> 0x0044 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0044 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0044 }
            if (r1 == 0) goto L_0x0807
            r1 = 1
            goto L_0x0808
        L_0x0807:
            r1 = 0
        L_0x0808:
            if (r9 != 0) goto L_0x080c
            r10 = 2
            goto L_0x080d
        L_0x080c:
            r10 = 1
        L_0x080d:
            java.util.Map r12 = r13.j     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r12 = r12.get(r3)     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothGatt r12 = (android.bluetooth.BluetoothGatt) r12     // Catch:{ Exception -> 0x0044 }
            if (r12 != 0) goto L_0x081d
            r15 = 0
            r14.error(r8, r11, r15)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x081d:
            r23.C0()     // Catch:{ Exception -> 0x0044 }
            com.lib.flutter_blue_plus.FlutterBluePlusPlugin$ChrFound r11 = r13.w0(r12, r5, r4, r6)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r15 = r11.b     // Catch:{ Exception -> 0x0044 }
            if (r15 == 0) goto L_0x082e
            r12 = 0
            r14.error(r8, r15, r12)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x082e:
            r24 = r12
            android.bluetooth.BluetoothGattCharacteristic r11 = r11.f9266a     // Catch:{ Exception -> 0x0044 }
            r12 = 1
            if (r10 != r12) goto L_0x0845
            int r12 = r11.getProperties()     // Catch:{ Exception -> 0x0044 }
            r12 = r12 & 4
            if (r12 != 0) goto L_0x0855
            java.lang.String r1 = "The WRITE_NO_RESPONSE property is not supported by this BLE characteristic"
            r2 = 0
            r14.error(r8, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0845:
            int r12 = r11.getProperties()     // Catch:{ Exception -> 0x0044 }
            r12 = r12 & 8
            if (r12 != 0) goto L_0x0855
            java.lang.String r1 = "The WRITE property is not supported by this BLE characteristic"
            r2 = 0
            r14.error(r8, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0855:
            int r12 = r13.h0(r3, r10, r1)     // Catch:{ Exception -> 0x0044 }
            byte[] r15 = m0(r7)     // Catch:{ Exception -> 0x0044 }
            int r15 = r15.length     // Catch:{ Exception -> 0x0044 }
            if (r15 <= r12) goto L_0x08a2
            if (r9 != 0) goto L_0x0865
            java.lang.String r2 = "withResponse"
            goto L_0x0867
        L_0x0865:
            java.lang.String r2 = "withoutResponse"
        L_0x0867:
            if (r9 != 0) goto L_0x086d
            if (r1 == 0) goto L_0x0870
            java.lang.String r17 = ", allowLongWrite"
        L_0x086d:
            r1 = r17
            goto L_0x0873
        L_0x0870:
            java.lang.String r17 = ", noLongWrite"
            goto L_0x086d
        L_0x0873:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0044 }
            r3.<init>()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r4 = "data longer than allowed. dataLen: "
            r3.append(r4)     // Catch:{ Exception -> 0x0044 }
            r3.append(r15)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r4 = " > max: "
            r3.append(r4)     // Catch:{ Exception -> 0x0044 }
            r3.append(r12)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r4 = " ("
            r3.append(r4)     // Catch:{ Exception -> 0x0044 }
            r3.append(r2)     // Catch:{ Exception -> 0x0044 }
            r3.append(r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = ")"
            r3.append(r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0044 }
            r2 = 0
            r14.error(r8, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x08a2:
            if (r6 != 0) goto L_0x08a6
            r6 = r17
        L_0x08a6:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0044 }
            r1.<init>()     // Catch:{ Exception -> 0x0044 }
            r1.append(r3)     // Catch:{ Exception -> 0x0044 }
            r1.append(r2)     // Catch:{ Exception -> 0x0044 }
            r1.append(r5)     // Catch:{ Exception -> 0x0044 }
            r1.append(r2)     // Catch:{ Exception -> 0x0044 }
            r1.append(r4)     // Catch:{ Exception -> 0x0044 }
            r1.append(r2)     // Catch:{ Exception -> 0x0044 }
            r1.append(r6)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0044 }
            java.util.Map r2 = r13.o     // Catch:{ Exception -> 0x0044 }
            r2.put(r1, r7)     // Catch:{ Exception -> 0x0044 }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0044 }
            r2 = 33
            if (r1 < r2) goto L_0x08fe
            byte[] r1 = m0(r7)     // Catch:{ Exception -> 0x0044 }
            r12 = r24
            int r1 = r12.writeCharacteristic(r11, r1, r10)     // Catch:{ Exception -> 0x0044 }
            if (r1 == 0) goto L_0x0923
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0044 }
            r2.<init>()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = "gatt.writeCharacteristic() returned "
            r2.append(r3)     // Catch:{ Exception -> 0x0044 }
            r2.append(r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = " : "
            r2.append(r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = L(r1)     // Catch:{ Exception -> 0x0044 }
            r2.append(r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0044 }
            r2 = 0
            r14.error(r8, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0093
        L_0x08fe:
            r12 = r24
            byte[] r1 = m0(r7)     // Catch:{ Exception -> 0x0044 }
            boolean r1 = r11.setValue(r1)     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x0912
            java.lang.String r1 = "characteristic.setValue() returned false"
            r2 = 0
            r14.error(r8, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0912:
            r11.setWriteType(r10)     // Catch:{ Exception -> 0x0044 }
            boolean r1 = r12.writeCharacteristic(r11)     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x0923
            java.lang.String r1 = "gatt.writeCharacteristic() returned false"
            r2 = 0
            r14.error(r8, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0923:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x092a:
            java.lang.Object r1 = r24.arguments()     // Catch:{ Exception -> 0x0044 }
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r2 = r1.get(r7)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r3 = r1.get(r5)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r4 = r1.get(r4)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0044 }
            java.util.Map r5 = r13.j     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r2 = r5.get(r2)     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothGatt r2 = (android.bluetooth.BluetoothGatt) r2     // Catch:{ Exception -> 0x0044 }
            if (r2 != 0) goto L_0x095a
            r6 = r22
            r5 = 0
            r14.error(r6, r11, r5)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x095a:
            r6 = r22
            r23.C0()     // Catch:{ Exception -> 0x0044 }
            com.lib.flutter_blue_plus.FlutterBluePlusPlugin$ChrFound r1 = r13.w0(r2, r3, r4, r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = r1.b     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x096d
            r4 = 0
            r14.error(r6, r3, r4)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x096d:
            android.bluetooth.BluetoothGattCharacteristic r1 = r1.f9266a     // Catch:{ Exception -> 0x0044 }
            int r3 = r1.getProperties()     // Catch:{ Exception -> 0x0044 }
            r4 = 2
            r3 = r3 & r4
            if (r3 != 0) goto L_0x097f
            java.lang.String r1 = "The READ property is not supported by this BLE characteristic"
            r2 = 0
            r14.error(r6, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x097f:
            boolean r1 = r2.readCharacteristic(r1)     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x098d
            java.lang.String r1 = "gatt.readCharacteristic() returned false"
            r2 = 0
            r14.error(r6, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x098d:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0994:
            java.lang.Object r1 = r1.arguments     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0044 }
            java.util.Map r2 = r13.j     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothGatt r1 = (android.bluetooth.BluetoothGatt) r1     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x09aa
            r3 = r21
            r2 = 0
            r14.error(r3, r11, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x09aa:
            r3 = r21
            r23.C0()     // Catch:{ Exception -> 0x0044 }
            boolean r1 = r1.discoverServices()     // Catch:{ Exception -> 0x0044 }
            if (r1 != 0) goto L_0x09bd
            java.lang.String r1 = "gatt.discoverServices() returned false"
            r2 = 0
            r14.error(r3, r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x09bd:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x09c4:
            java.lang.Object r1 = r1.arguments     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0044 }
            java.util.Map r2 = r13.k     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothGatt r2 = (android.bluetooth.BluetoothGatt) r2     // Catch:{ Exception -> 0x0044 }
            if (r2 == 0) goto L_0x09da
            java.lang.String r3 = "disconnect: cancelling connection in progress"
            r4 = r19
            r13.x0(r4, r3)     // Catch:{ Exception -> 0x0044 }
            goto L_0x09dc
        L_0x09da:
            r4 = r19
        L_0x09dc:
            if (r2 != 0) goto L_0x09e6
            java.util.Map r2 = r13.j     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothGatt r2 = (android.bluetooth.BluetoothGatt) r2     // Catch:{ Exception -> 0x0044 }
        L_0x09e6:
            if (r2 != 0) goto L_0x0a09
            java.util.Map r2 = r13.n     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.BluetoothGatt r2 = (android.bluetooth.BluetoothGatt) r2     // Catch:{ Exception -> 0x0044 }
            if (r2 == 0) goto L_0x0a09
            java.lang.String r3 = "already disconnected. disabling autoconnect"
            r13.x0(r4, r3)     // Catch:{ Exception -> 0x0044 }
            java.util.Map r3 = r13.n     // Catch:{ Exception -> 0x0044 }
            r3.remove(r1)     // Catch:{ Exception -> 0x0044 }
            r2.disconnect()     // Catch:{ Exception -> 0x0044 }
            r2.close()     // Catch:{ Exception -> 0x0044 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0093
        L_0x0a09:
            if (r2 != 0) goto L_0x0a17
            java.lang.String r1 = "already disconnected"
            r13.x0(r4, r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0093
        L_0x0a17:
            java.util.Map r3 = r13.n     // Catch:{ Exception -> 0x0044 }
            r3.remove(r1)     // Catch:{ Exception -> 0x0044 }
            r2.disconnect()     // Catch:{ Exception -> 0x0044 }
            java.util.Map r3 = r13.k     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ Exception -> 0x0044 }
            if (r3 == 0) goto L_0x0a5d
            java.util.Map r3 = r13.k     // Catch:{ Exception -> 0x0044 }
            r3.remove(r1)     // Catch:{ Exception -> 0x0044 }
            r2.close()     // Catch:{ Exception -> 0x0044 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x0044 }
            r2.<init>()     // Catch:{ Exception -> 0x0044 }
            r2.put(r7, r1)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = "connection_state"
            r3 = 0
            int r3 = U(r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0044 }
            r2.put(r1, r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = "disconnect_reason_code"
            r3 = 23789258(0x16afeca, float:4.3161814E-38)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0044 }
            r2.put(r1, r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = "disconnect_reason_string"
            java.lang.String r3 = "connection canceled"
            r2.put(r1, r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = "OnConnectionStateChanged"
            r13.n0(r1, r2)     // Catch:{ Exception -> 0x0044 }
        L_0x0a5d:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0a64:
            r12 = 1
            java.lang.Object r1 = r24.arguments()     // Catch:{ Exception -> 0x0044 }
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ Exception -> 0x0044 }
            java.lang.Object r2 = r1.get(r7)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = "auto_connect"
            java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0044 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0044 }
            if (r1 == 0) goto L_0x0a80
            goto L_0x0a81
        L_0x0a80:
            r12 = 0
        L_0x0a81:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0044 }
            r1.<init>()     // Catch:{ Exception -> 0x0044 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0044 }
            r4 = 31
            if (r3 < r4) goto L_0x0a91
            r3 = r20
            r1.add(r3)     // Catch:{ Exception -> 0x0044 }
        L_0x0a91:
            com.lib.flutter_blue_plus.f r3 = new com.lib.flutter_blue_plus.f     // Catch:{ Exception -> 0x0044 }
            r3.<init>(r13, r14, r2, r12)     // Catch:{ Exception -> 0x0044 }
            r13.a0(r1, r3)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0a9b:
            r3 = r20
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0044 }
            r1.<init>()     // Catch:{ Exception -> 0x0044 }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0044 }
            r4 = 31
            if (r2 < r4) goto L_0x0aab
            r1.add(r3)     // Catch:{ Exception -> 0x0044 }
        L_0x0aab:
            com.lib.flutter_blue_plus.e r2 = new com.lib.flutter_blue_plus.e     // Catch:{ Exception -> 0x0044 }
            r2.<init>(r13, r14)     // Catch:{ Exception -> 0x0044 }
            r13.a0(r1, r2)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0ab5:
            android.bluetooth.BluetoothAdapter r1 = r13.e     // Catch:{ Exception -> 0x0044 }
            android.bluetooth.le.BluetoothLeScanner r1 = r1.getBluetoothLeScanner()     // Catch:{ Exception -> 0x0044 }
            if (r1 == 0) goto L_0x0ac7
            android.bluetooth.le.ScanCallback r2 = r23.j0()     // Catch:{ Exception -> 0x0044 }
            r1.stopScan(r2)     // Catch:{ Exception -> 0x0044 }
            r1 = 0
            r13.f = r1     // Catch:{ Exception -> 0x0044 }
        L_0x0ac7:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0044 }
            r14.success(r1)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0cc1
        L_0x0ace:
            r3 = r20
            java.lang.Object r1 = r24.arguments()     // Catch:{ Exception -> 0x0b54 }
            r12 = r1
            java.util.HashMap r12 = (java.util.HashMap) r12     // Catch:{ Exception -> 0x0b54 }
            java.lang.String r1 = "with_services"
            java.lang.Object r1 = r12.get(r1)     // Catch:{ Exception -> 0x0b54 }
            r6 = r1
            java.util.List r6 = (java.util.List) r6     // Catch:{ Exception -> 0x0b54 }
            java.lang.String r1 = "with_remote_ids"
            java.lang.Object r1 = r12.get(r1)     // Catch:{ Exception -> 0x0b54 }
            r7 = r1
            java.util.List r7 = (java.util.List) r7     // Catch:{ Exception -> 0x0b54 }
            java.lang.String r1 = "with_names"
            java.lang.Object r1 = r12.get(r1)     // Catch:{ Exception -> 0x0b54 }
            r8 = r1
            java.util.List r8 = (java.util.List) r8     // Catch:{ Exception -> 0x0b54 }
            java.lang.String r1 = "with_keywords"
            java.lang.Object r1 = r12.get(r1)     // Catch:{ Exception -> 0x0b54 }
            r9 = r1
            java.util.List r9 = (java.util.List) r9     // Catch:{ Exception -> 0x0b54 }
            java.lang.String r1 = "with_msd"
            java.lang.Object r1 = r12.get(r1)     // Catch:{ Exception -> 0x0b54 }
            r10 = r1
            java.util.List r10 = (java.util.List) r10     // Catch:{ Exception -> 0x0b54 }
            java.lang.String r1 = "with_service_data"
            java.lang.Object r1 = r12.get(r1)     // Catch:{ Exception -> 0x0b54 }
            r11 = r1
            java.util.List r11 = (java.util.List) r11     // Catch:{ Exception -> 0x0b54 }
            java.lang.String r1 = "continuous_updates"
            java.lang.Object r1 = r12.get(r1)     // Catch:{ Exception -> 0x0b54 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x0b54 }
            r1.booleanValue()     // Catch:{ Exception -> 0x0b54 }
            java.lang.String r1 = "android_legacy"
            java.lang.Object r1 = r12.get(r1)     // Catch:{ Exception -> 0x0b54 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x0b54 }
            boolean r5 = r1.booleanValue()     // Catch:{ Exception -> 0x0b54 }
            java.lang.String r1 = "android_scan_mode"
            java.lang.Object r1 = r12.get(r1)     // Catch:{ Exception -> 0x0b54 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0b54 }
            int r4 = r1.intValue()     // Catch:{ Exception -> 0x0b54 }
            java.lang.String r1 = "android_uses_fine_location"
            java.lang.Object r1 = r12.get(r1)     // Catch:{ Exception -> 0x0b54 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x0b54 }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x0b54 }
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ Exception -> 0x0b54 }
            r15.<init>()     // Catch:{ Exception -> 0x0b54 }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0b54 }
            r14 = 31
            if (r2 < r14) goto L_0x0b5d
            java.lang.String r14 = "android.permission.BLUETOOTH_SCAN"
            r15.add(r14)     // Catch:{ Exception -> 0x0b54 }
            if (r1 == 0) goto L_0x0b5a
            java.lang.String r1 = "android.permission.ACCESS_FINE_LOCATION"
            r15.add(r1)     // Catch:{ Exception -> 0x0b54 }
            goto L_0x0b5a
        L_0x0b54:
            r0 = move-exception
            r5 = r25
        L_0x0b57:
            r1 = r0
            goto L_0x0ccb
        L_0x0b5a:
            r15.add(r3)     // Catch:{ Exception -> 0x0b54 }
        L_0x0b5d:
            r1 = 30
            if (r2 > r1) goto L_0x0b66
            java.lang.String r1 = "android.permission.ACCESS_FINE_LOCATION"
            r15.add(r1)     // Catch:{ Exception -> 0x0b54 }
        L_0x0b66:
            com.lib.flutter_blue_plus.d r14 = new com.lib.flutter_blue_plus.d     // Catch:{ Exception -> 0x0b54 }
            r1 = r14
            r2 = r23
            r3 = r25
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0b54 }
            r13.a0(r15, r14)     // Catch:{ Exception -> 0x0b54 }
            goto L_0x0cc1
        L_0x0b75:
            r3 = r20
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0b54 }
            r1.<init>()     // Catch:{ Exception -> 0x0b54 }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0b54 }
            r4 = 31
            if (r2 < r4) goto L_0x0b85
            r1.add(r3)     // Catch:{ Exception -> 0x0b54 }
        L_0x0b85:
            r3 = 30
            if (r2 > r3) goto L_0x0b8e
            java.lang.String r2 = "android.permission.BLUETOOTH"
            r1.add(r2)     // Catch:{ Exception -> 0x0b54 }
        L_0x0b8e:
            com.lib.flutter_blue_plus.c r2 = new com.lib.flutter_blue_plus.c     // Catch:{ Exception -> 0x0b54 }
            r5 = r25
            r2.<init>(r13, r5)     // Catch:{ Exception -> 0x0b9a }
            r13.a0(r1, r2)     // Catch:{ Exception -> 0x0b9a }
            goto L_0x0cc1
        L_0x0b9a:
            r0 = move-exception
            goto L_0x0b57
        L_0x0b9c:
            r5 = r14
            r3 = r20
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0b9a }
            r1.<init>()     // Catch:{ Exception -> 0x0b9a }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0b9a }
            r4 = 31
            if (r2 < r4) goto L_0x0bad
            r1.add(r3)     // Catch:{ Exception -> 0x0b9a }
        L_0x0bad:
            r3 = 30
            if (r2 > r3) goto L_0x0bb6
            java.lang.String r2 = "android.permission.BLUETOOTH"
            r1.add(r2)     // Catch:{ Exception -> 0x0b9a }
        L_0x0bb6:
            com.lib.flutter_blue_plus.b r2 = new com.lib.flutter_blue_plus.b     // Catch:{ Exception -> 0x0b9a }
            r2.<init>(r13, r5)     // Catch:{ Exception -> 0x0b9a }
            r13.a0(r1, r2)     // Catch:{ Exception -> 0x0b9a }
            goto L_0x0cc1
        L_0x0bc0:
            r5 = r14
            android.bluetooth.BluetoothAdapter r1 = r13.e     // Catch:{ Exception -> 0x0bc8 }
            int r1 = r1.getState()     // Catch:{ Exception -> 0x0bc8 }
            goto L_0x0bc9
        L_0x0bc8:
            r1 = -1
        L_0x0bc9:
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x0b9a }
            r2.<init>()     // Catch:{ Exception -> 0x0b9a }
            java.lang.String r3 = "adapter_state"
            int r1 = M(r1)     // Catch:{ Exception -> 0x0b9a }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0b9a }
            r2.put(r3, r1)     // Catch:{ Exception -> 0x0b9a }
            r5.success(r2)     // Catch:{ Exception -> 0x0b9a }
            goto L_0x0cc1
        L_0x0be0:
            r5 = r14
            r3 = r20
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0b9a }
            r1.<init>()     // Catch:{ Exception -> 0x0b9a }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0b9a }
            r4 = 31
            if (r2 < r4) goto L_0x0bf1
            r1.add(r3)     // Catch:{ Exception -> 0x0b9a }
        L_0x0bf1:
            r3 = 30
            if (r2 > r3) goto L_0x0bfa
            java.lang.String r2 = "android.permission.BLUETOOTH"
            r1.add(r2)     // Catch:{ Exception -> 0x0b9a }
        L_0x0bfa:
            com.lib.flutter_blue_plus.a r2 = new com.lib.flutter_blue_plus.a     // Catch:{ Exception -> 0x0b9a }
            r2.<init>(r13, r5)     // Catch:{ Exception -> 0x0b9a }
            r13.a0(r1, r2)     // Catch:{ Exception -> 0x0b9a }
            goto L_0x0cc1
        L_0x0c04:
            r5 = r14
            r12 = 1
            android.bluetooth.BluetoothAdapter r1 = r13.e     // Catch:{ Exception -> 0x0b9a }
            if (r1 == 0) goto L_0x0c0b
            goto L_0x0c0c
        L_0x0c0b:
            r12 = 0
        L_0x0c0c:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r12)     // Catch:{ Exception -> 0x0b9a }
            r5.success(r1)     // Catch:{ Exception -> 0x0b9a }
            goto L_0x0cc1
        L_0x0c15:
            r5 = r14
            java.lang.Object r1 = r1.arguments     // Catch:{ Exception -> 0x0b9a }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0b9a }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0b9a }
            com.lib.flutter_blue_plus.FlutterBluePlusPlugin$LogLevel[] r2 = com.lib.flutter_blue_plus.FlutterBluePlusPlugin.LogLevel.values()     // Catch:{ Exception -> 0x0b9a }
            r1 = r2[r1]     // Catch:{ Exception -> 0x0b9a }
            r13.f9260a = r1     // Catch:{ Exception -> 0x0b9a }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0b9a }
            r5.success(r1)     // Catch:{ Exception -> 0x0b9a }
            goto L_0x0cc1
        L_0x0c2d:
            r5 = r14
            r4 = r19
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0b9a }
            r1.<init>()     // Catch:{ Exception -> 0x0b9a }
            java.lang.String r2 = "connectedPeripherals: "
            r1.append(r2)     // Catch:{ Exception -> 0x0b9a }
            java.util.Map r2 = r13.j     // Catch:{ Exception -> 0x0b9a }
            int r2 = r2.size()     // Catch:{ Exception -> 0x0b9a }
            r1.append(r2)     // Catch:{ Exception -> 0x0b9a }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0b9a }
            r13.x0(r4, r1)     // Catch:{ Exception -> 0x0b9a }
            java.util.Map r1 = r13.j     // Catch:{ Exception -> 0x0b9a }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0b9a }
            if (r1 != 0) goto L_0x0c57
            java.lang.String r1 = "Hot Restart: complete"
            r13.x0(r4, r1)     // Catch:{ Exception -> 0x0b9a }
        L_0x0c57:
            java.util.Map r1 = r13.j     // Catch:{ Exception -> 0x0b9a }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0b9a }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0b9a }
            r5.success(r1)     // Catch:{ Exception -> 0x0b9a }
            goto L_0x0cc1
        L_0x0c65:
            r5 = r14
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0b9a }
            r5.success(r1)     // Catch:{ Exception -> 0x0b9a }
            goto L_0x0cc1
        L_0x0c6c:
            r5 = r14
            r4 = r19
            android.bluetooth.BluetoothAdapter r1 = r13.e     // Catch:{ Exception -> 0x0b9a }
            if (r1 != 0) goto L_0x0c7c
            r2 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0b9a }
            r5.success(r1)     // Catch:{ Exception -> 0x0b9a }
            goto L_0x0cc1
        L_0x0c7c:
            android.bluetooth.le.BluetoothLeScanner r1 = r1.getBluetoothLeScanner()     // Catch:{ Exception -> 0x0b9a }
            if (r1 == 0) goto L_0x0c95
            boolean r2 = r13.f     // Catch:{ Exception -> 0x0b9a }
            if (r2 == 0) goto L_0x0c95
            java.lang.String r2 = "calling stopScan (flutterRestart)"
            r13.x0(r4, r2)     // Catch:{ Exception -> 0x0b9a }
            android.bluetooth.le.ScanCallback r2 = r23.j0()     // Catch:{ Exception -> 0x0b9a }
            r1.stopScan(r2)     // Catch:{ Exception -> 0x0b9a }
            r1 = 0
            r13.f = r1     // Catch:{ Exception -> 0x0b9a }
        L_0x0c95:
            r1 = r18
            r13.Z(r1)     // Catch:{ Exception -> 0x0b9a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0b9a }
            r1.<init>()     // Catch:{ Exception -> 0x0b9a }
            java.lang.String r2 = "connectedPeripherals: "
            r1.append(r2)     // Catch:{ Exception -> 0x0b9a }
            java.util.Map r2 = r13.j     // Catch:{ Exception -> 0x0b9a }
            int r2 = r2.size()     // Catch:{ Exception -> 0x0b9a }
            r1.append(r2)     // Catch:{ Exception -> 0x0b9a }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0b9a }
            r13.x0(r4, r1)     // Catch:{ Exception -> 0x0b9a }
            java.util.Map r1 = r13.j     // Catch:{ Exception -> 0x0b9a }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0b9a }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0b9a }
            r5.success(r1)     // Catch:{ Exception -> 0x0b9a }
        L_0x0cc1:
            java.util.concurrent.Semaphore r1 = r13.i
            r1.release()
            return
        L_0x0cc7:
            r0 = move-exception
            r5 = r14
            goto L_0x0b57
        L_0x0ccb:
            java.io.StringWriter r2 = new java.io.StringWriter     // Catch:{ all -> 0x0040 }
            r2.<init>()     // Catch:{ all -> 0x0040 }
            java.io.PrintWriter r3 = new java.io.PrintWriter     // Catch:{ all -> 0x0040 }
            r3.<init>(r2)     // Catch:{ all -> 0x0040 }
            r1.printStackTrace(r3)     // Catch:{ all -> 0x0040 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0040 }
            java.lang.String r3 = "androidException"
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0040 }
            r5.error(r3, r1, r2)     // Catch:{ all -> 0x0040 }
            goto L_0x0093
        L_0x0ce7:
            java.util.concurrent.Semaphore r2 = r13.i
            r2.release()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lib.flutter_blue_plus.FlutterBluePlusPlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        x0(LogLevel.DEBUG, "onReattachedToActivityForConfigChanges");
        onAttachedToActivity(activityPluginBinding);
    }

    public boolean onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        OperationOnPermission operationOnPermission = (OperationOnPermission) this.t.get(Integer.valueOf(i2));
        this.t.remove(Integer.valueOf(i2));
        if (operationOnPermission == null || iArr.length <= 0) {
            return false;
        }
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] != 0) {
                operationOnPermission.a(false, strArr[i3]);
                return true;
            }
        }
        operationOnPermission.a(true, (String) null);
        return true;
    }

    public final /* synthetic */ void p0(String str, HashMap hashMap) {
        MethodChannel methodChannel = this.c;
        if (methodChannel != null) {
            methodChannel.invokeMethod(str, hashMap);
            return;
        }
        LogLevel logLevel = LogLevel.WARNING;
        x0(logLevel, "invokeMethodUIThread: tried to call method on closed channel: " + str);
    }

    public final /* synthetic */ void q0(MethodChannel.Result result, boolean z2, String str) {
        BluetoothAdapter bluetoothAdapter = this.e;
        String name = bluetoothAdapter != null ? bluetoothAdapter.getName() : "N/A";
        if (name == null) {
            name = "";
        }
        result.success(name);
    }

    public final /* synthetic */ void r0(MethodChannel.Result result, boolean z2, String str) {
        if (!z2) {
            result.error("turnOn", String.format("FlutterBluePlus requires %s permission", new Object[]{str}), (Object) null);
        } else if (this.e.isEnabled()) {
            result.success(Boolean.FALSE);
        } else {
            this.h.getActivity().startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1879842617);
            result.success(Boolean.TRUE);
        }
    }

    public final /* synthetic */ void s0(MethodChannel.Result result, boolean z2, String str) {
        if (!z2) {
            result.error("turnOff", String.format("FlutterBluePlus requires %s permission", new Object[]{str}), (Object) null);
        } else if (!this.e.isEnabled()) {
            result.success(Boolean.TRUE);
        } else {
            result.success(Boolean.valueOf(this.e.disable()));
        }
    }

    public final /* synthetic */ void t0(MethodChannel.Result result, int i2, boolean z2, List list, List list2, List list3, List list4, List list5, List list6, HashMap hashMap, boolean z3, String str) {
        if (!z3) {
            result.error("startScan", String.format("FlutterBluePlus requires %s permission", new Object[]{str}), (Object) null);
            return;
        }
        if (!o0()) {
            result.error("startScan", String.format("bluetooth must be turned on", new Object[0]), (Object) null);
            return;
        }
        BluetoothLeScanner bluetoothLeScanner = this.e.getBluetoothLeScanner();
        if (bluetoothLeScanner == null) {
            result.error("startScan", String.format("getBluetoothLeScanner() is null. Is the Adapter on?", new Object[0]), (Object) null);
            return;
        }
        ScanSettings.Builder builder = new ScanSettings.Builder();
        builder.setScanMode(i2);
        builder.setPhy(255);
        builder.setLegacy(z2);
        ScanSettings build = builder.build();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            arrayList.add(new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString(A0(list.get(i3)))).build());
        }
        for (int i4 = 0; i4 < list2.size(); i4++) {
            arrayList.add(new ScanFilter.Builder().setDeviceAddress((String) list2.get(i4)).build());
        }
        for (int i5 = 0; i5 < list3.size(); i5++) {
            arrayList.add(new ScanFilter.Builder().setDeviceName((String) list3.get(i5)).build());
        }
        if (Build.VERSION.SDK_INT >= 33 && list4.size() > 0) {
            ScanFilter build2 = new ScanFilter.Builder().setAdvertisingDataType(8).build();
            ScanFilter build3 = new ScanFilter.Builder().setAdvertisingDataType(9).build();
            arrayList.add(build2);
            arrayList.add(build3);
        }
        for (int i6 = 0; i6 < list5.size(); i6++) {
            HashMap hashMap2 = (HashMap) list5.get(i6);
            int intValue = ((Integer) hashMap2.get("manufacturer_id")).intValue();
            byte[] m0 = m0((String) hashMap2.get("data"));
            byte[] m02 = m0((String) hashMap2.get("mask"));
            arrayList.add(m02.length == 0 ? new ScanFilter.Builder().setManufacturerData(intValue, m0).build() : new ScanFilter.Builder().setManufacturerData(intValue, m0, m02).build());
        }
        for (int i7 = 0; i7 < list6.size(); i7++) {
            HashMap hashMap3 = (HashMap) list6.get(i7);
            ParcelUuid fromString = ParcelUuid.fromString(A0((String) hashMap3.get("service")));
            byte[] m03 = m0((String) hashMap3.get("data"));
            byte[] m04 = m0((String) hashMap3.get("mask"));
            arrayList.add(m04.length == 0 ? new ScanFilter.Builder().setServiceData(fromString, m03).build() : new ScanFilter.Builder().setServiceData(fromString, m03, m04).build());
        }
        this.s = hashMap;
        this.q.clear();
        this.r.clear();
        bluetoothLeScanner.startScan(arrayList, build, j0());
        this.f = true;
        result.success(Boolean.TRUE);
    }

    public final /* synthetic */ void u0(MethodChannel.Result result, boolean z2, String str) {
        if (!z2) {
            result.error("getSystemDevices", String.format("FlutterBluePlus requires %s permission", new Object[]{str}), (Object) null);
            return;
        }
        List<BluetoothDevice> connectedDevices = this.d.getConnectedDevices(7);
        ArrayList arrayList = new ArrayList();
        for (BluetoothDevice P : connectedDevices) {
            arrayList.add(P(P));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("devices", arrayList);
        result.success(hashMap);
    }

    public final /* synthetic */ void v0(MethodChannel.Result result, String str, boolean z2, boolean z3, String str2) {
        if (!z3) {
            result.error("connect", String.format("FlutterBluePlus requires %s for new connection", new Object[]{str2}), (Object) null);
        } else if (!o0()) {
            result.error("connect", String.format("bluetooth must be turned on", new Object[0]), (Object) null);
        } else if (this.k.get(str) != null) {
            x0(LogLevel.DEBUG, "already connecting");
            result.success(Boolean.TRUE);
        } else if (this.j.get(str) != null) {
            x0(LogLevel.DEBUG, "already connected");
            result.success(Boolean.FALSE);
        } else {
            C0();
            BluetoothGatt connectGatt = this.e.getRemoteDevice(str).connectGatt(this.b, z2, this.z, 2);
            if (connectGatt == null) {
                result.error("connect", String.format("device.connectGatt returned null", new Object[0]), (Object) null);
                return;
            }
            this.k.put(str, connectGatt);
            if (z2) {
                this.n.put(str, connectGatt);
            } else {
                this.n.remove(str);
            }
            result.success(Boolean.TRUE);
        }
    }

    public final ChrFound w0(BluetoothGatt bluetoothGatt, String str, String str2, String str3) {
        BluetoothGattService bluetoothGattService;
        boolean z2 = str3 != null;
        if (str3 == null) {
            str3 = str;
        }
        BluetoothGattService k0 = k0(str3, bluetoothGatt.getServices());
        if (k0 == null) {
            return new ChrFound((BluetoothGattCharacteristic) null, "primary service not found '" + str3 + "'");
        }
        if (z2) {
            bluetoothGattService = k0(str, k0.getIncludedServices());
            if (bluetoothGattService == null) {
                return new ChrFound((BluetoothGattCharacteristic) null, "secondary service not found '" + str + "' (primary service '" + str3 + "')");
            }
        } else {
            bluetoothGattService = null;
        }
        if (bluetoothGattService != null) {
            k0 = bluetoothGattService;
        }
        BluetoothGattCharacteristic e0 = e0(str2, k0.getCharacteristics());
        if (e0 != null) {
            return new ChrFound(e0, (String) null);
        }
        return new ChrFound((BluetoothGattCharacteristic) null, "characteristic not found in service (chr: '" + str2 + "' svc: '" + str + "')");
    }

    public final void x0(LogLevel logLevel, String str) {
        if (logLevel.ordinal() <= this.f9260a.ordinal()) {
            int i2 = AnonymousClass5.f9265a[logLevel.ordinal()];
            if (i2 == 1) {
                Log.d("[FBP-Android]", "[FBP] " + str);
            } else if (i2 == 2) {
                Log.w("[FBP-Android]", "[FBP] " + str);
            } else if (i2 != 3) {
                Log.d("[FBP-Android]", "[FBP] " + str);
            } else {
                Log.e("[FBP-Android]", "[FBP] " + str);
            }
        }
    }

    public final int y0(String str) {
        if (this.r.get(str) == null) {
            this.r.put(str, 0);
        }
        int intValue = ((Integer) this.r.get(str)).intValue();
        this.r.put(str, Integer.valueOf(intValue + 1));
        return intValue;
    }
}
