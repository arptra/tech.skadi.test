package com.upuphone.runasone.ble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
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
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelUuid;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.upuphone.runasone.utils.BleLogger;
import com.upuphone.runasone.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"MissingPermission"})
public class BleScanner extends BroadcastReceiver {
    private static final long DEVICE_CHECK_INTERVAL = 1000;
    private static final long DEVICE_LOSE_TIMEOUT = 15000;
    protected static final int MSG_CHECK_DEVICE = 4;
    protected static final int MSG_FOUND_DEVICE = 1;
    protected static final int MSG_LOSE_DEVICE = 2;
    protected static final int MSG_LOSE_DEVICES = 3;
    private static final String TAG = "BleScanner";
    private BluetoothAdapter bluetoothAdapter;
    private final List<BleInternalDevice> foundDevices = new ArrayList();
    private final Handler.Callback messageCallback = new Handler.Callback() {
        public boolean handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i == 1) {
                try {
                    BleScanner.this.handleFoundDevice((ScanResult) message.obj);
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    BleLogger.e(BleScanner.TAG, (Object) "adv praise error");
                    return false;
                }
            } else if (i == 2) {
                BleScanner.this.handleLoseDevice((BleInternalDevice) message.obj);
                return false;
            } else if (i == 3) {
                BleScanner.this.handleLoseDevices();
                return false;
            } else if (i != 4) {
                return false;
            } else {
                BleScanner.this.handleCheckDevice();
                return false;
            }
        }
    };
    private final ScanCallback scanCallback = new ScanCallback() {
        public void onScanFailed(int i) {
            super.onScanFailed(i);
            Log.d(BleScanner.TAG, "onScanFailed: " + i);
        }

        public void onScanResult(int i, ScanResult scanResult) {
            super.onScanResult(i, scanResult);
            Message obtain = Message.obtain(BleScanner.this.scanHandler, 1);
            obtain.obj = scanResult;
            obtain.sendToTarget();
        }
    };
    /* access modifiers changed from: private */
    public Handler scanHandler;
    private ScanListener scanListener;
    private BluetoothLeScanner scanner;

    public interface ScanListener {
        void onDeviceFound(BleInternalDevice bleInternalDevice);

        void onDeviceLost(BleInternalDevice bleInternalDevice);

        void onDevicesLost();
    }

    private BleInternalDevice createBleDevice(BluetoothDevice bluetoothDevice, ScanRecord scanRecord) {
        ScanRecord scanRecord2 = scanRecord;
        byte[] serviceData = scanRecord2.getServiceData(new ParcelUuid(BleConstants.SERVICE_DATA_UUID1));
        byte[] serviceData2 = scanRecord2.getServiceData(new ParcelUuid(BleConstants.SERVICE_DATA_UUID2));
        if (serviceData == null || serviceData2 == null) {
            BleLogger.d(TAG, (Object) String.format("Device %s is not IOT device.", new Object[]{bluetoothDevice.getAddress()}));
            return null;
        }
        String bytes2HexString = Utils.bytes2HexString(Arrays.copyOfRange(serviceData, 0, 6));
        String bytes2HexString2 = Utils.bytes2HexString(Arrays.copyOfRange(serviceData, 6, 7));
        String bytes2HexString3 = Utils.bytes2HexString(Arrays.copyOfRange(serviceData, 7, 8));
        String bytes2HexString4 = Utils.bytes2HexString(Arrays.copyOfRange(serviceData, 8, 10));
        byte b = serviceData[10];
        byte[] copyOfRange = Arrays.copyOfRange(serviceData, 11, 17);
        String bytes2HexString5 = Utils.bytes2HexString(Arrays.copyOfRange(serviceData2, 0, 15));
        String address = bluetoothDevice.getAddress();
        BleLogger.d(TAG, "after parse adv, deviceId=%s, vid=%s, pid=%s, version=%s, beaconId=%s, payload=%s, deviceName=%s", bytes2HexString, bytes2HexString2, bytes2HexString3, bytes2HexString4, Byte.valueOf(b), new String(copyOfRange), bytes2HexString5);
        return new BleInternalDevice(bytes2HexString, bytes2HexString2, bytes2HexString3, bytes2HexString4, bytes2HexString5, address, copyOfRange, b, bluetoothDevice);
    }

    private byte getBeaconId(ScanRecord scanRecord) {
        byte[] serviceData = scanRecord.getServiceData(new ParcelUuid(BleConstants.SERVICE_DATA_UUID1));
        if (serviceData == null) {
            return 0;
        }
        return serviceData[10];
    }

    private String getDeviceId(ScanRecord scanRecord) {
        byte[] serviceData = scanRecord.getServiceData(new ParcelUuid(BleConstants.SERVICE_DATA_UUID1));
        if (serviceData == null) {
            return null;
        }
        return Utils.bytes2HexString(Arrays.copyOfRange(serviceData, 0, 6));
    }

    /* access modifiers changed from: private */
    public void handleCheckDevice() {
        for (BleInternalDevice next : this.foundDevices) {
            if (System.currentTimeMillis() - next.lastFoundTime > 15000) {
                Message obtain = Message.obtain(this.scanHandler, 2);
                obtain.obj = next;
                obtain.sendToTarget();
            }
        }
        this.scanHandler.sendEmptyMessageDelayed(4, 1000);
    }

    /* access modifiers changed from: private */
    public void handleFoundDevice(ScanResult scanResult) {
        BleInternalDevice bleInternalDevice;
        BluetoothDevice device = scanResult.getDevice();
        ScanRecord scanRecord = scanResult.getScanRecord();
        if (scanRecord != null) {
            Iterator<BleInternalDevice> it = this.foundDevices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bleInternalDevice = null;
                    break;
                }
                bleInternalDevice = it.next();
                if (TextUtils.equals(bleInternalDevice.getDeviceId(), getDeviceId(scanRecord))) {
                    break;
                }
            }
            if (bleInternalDevice == null) {
                BleInternalDevice createBleDevice = createBleDevice(device, scanRecord);
                if (createBleDevice != null) {
                    createBleDevice.state = 0;
                    this.foundDevices.add(createBleDevice);
                    BleLogger.d(TAG, (Object) "first onDeviceFound, beaconID=" + createBleDevice.getBeaconId());
                    this.scanListener.onDeviceFound(createBleDevice);
                    createBleDevice.lastFoundTime = System.currentTimeMillis();
                    startCheckDevice();
                    return;
                }
                return;
            }
            byte beaconId = getBeaconId(scanRecord);
            if (beaconId != bleInternalDevice.getBeaconId()) {
                BleLogger.d(TAG, (Object) "beaconId change, trigger onDeviceFound, old=" + bleInternalDevice.getBeaconId() + ",new=" + beaconId);
                bleInternalDevice.state = 0;
                bleInternalDevice.setBeaconId(beaconId);
                bleInternalDevice.setBluetoothDevice(scanResult.getDevice());
                this.scanListener.onDeviceFound(bleInternalDevice);
            }
            if (bleInternalDevice.state == 0) {
                bleInternalDevice.lastFoundTime = System.currentTimeMillis();
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleLoseDevice(BleInternalDevice bleInternalDevice) {
        bleInternalDevice.state = 4;
        this.scanListener.onDeviceLost(bleInternalDevice);
        this.foundDevices.remove(bleInternalDevice);
        stopCheckDevice();
    }

    /* access modifiers changed from: private */
    public void handleLoseDevices() {
        for (BleInternalDevice bleInternalDevice : this.foundDevices) {
            bleInternalDevice.state = 4;
        }
        this.scanListener.onDevicesLost();
        this.foundDevices.clear();
        stopCheckDevice();
    }

    private void startCheckDevice() {
        if (this.foundDevices.size() == 1) {
            this.scanHandler.sendEmptyMessageDelayed(4, 1000);
        }
    }

    private void startScan() {
        if (this.scanner == null) {
            this.scanner = this.bluetoothAdapter.getBluetoothLeScanner();
        }
        ScanFilter build = new ScanFilter.Builder().setServiceUuid(new ParcelUuid(BleConstants.SERVICE_UUID)).build();
        ArrayList arrayList = new ArrayList();
        arrayList.add(build);
        this.scanner.startScan(arrayList, new ScanSettings.Builder().setScanMode(0).setCallbackType(1).setMatchMode(1).setReportDelay(0).build(), this.scanCallback);
    }

    private void stopCheckDevice() {
        if (this.foundDevices.isEmpty()) {
            this.scanHandler.removeMessages(4);
        }
    }

    public void init(Context context, Looper looper, ScanListener scanListener2) {
        BleLogger.d(TAG, (Object) "BleScanner init.");
        this.scanListener = scanListener2;
        this.scanHandler = new Handler(looper, this.messageCallback);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.bluetoothAdapter = defaultAdapter;
        if (defaultAdapter == null) {
            BleLogger.d(TAG, (Object) "This hardware platform is not supported Bluetooth.");
            return;
        }
        if (defaultAdapter.isEnabled()) {
            startScan();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        context.registerReceiver(this, intentFilter);
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
            if (12 == intExtra) {
                BleLogger.d(TAG, (Object) "Bluetooth turn on, start scan.");
                if (this.bluetoothAdapter != null) {
                    startScan();
                }
            } else if (10 == intExtra) {
                BleLogger.d(TAG, (Object) "Bluetooth turn off, stop scan.");
                this.scanHandler.sendEmptyMessage(3);
            }
        }
    }
}
