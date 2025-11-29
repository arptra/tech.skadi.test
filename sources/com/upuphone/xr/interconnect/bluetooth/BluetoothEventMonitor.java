package com.upuphone.xr.interconnect.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.annotation.NonNull;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class BluetoothEventMonitor {
    private static final String TAG = "BluetoothEventMonitor";
    private boolean hasRegister;
    private boolean isBluetoothEnable;
    private BluetoothEventBroadcastReceiver mBroadcastReceiver;
    private List<OnBluetoothStateListener> mOnBluetoothStateListeners;

    public static final class Holder {
        /* access modifiers changed from: private */
        public static final BluetoothEventMonitor MONITOR = new BluetoothEventMonitor();

        private Holder() {
        }
    }

    public static BluetoothEventMonitor getInstance() {
        return Holder.MONITOR;
    }

    private void onBluetoothBondStateChanged(BluetoothDevice bluetoothDevice, boolean z) {
        for (OnBluetoothStateListener onBondStateChanged : this.mOnBluetoothStateListeners) {
            onBondStateChanged.onBondStateChanged(bluetoothDevice, z);
        }
    }

    private void onBluetoothNameChanged(String str) {
        for (OnBluetoothStateListener onNameChanged : this.mOnBluetoothStateListeners) {
            onNameChanged.onNameChanged(str);
        }
    }

    private boolean onBluetoothPairRequest(BluetoothDevice bluetoothDevice, int i, int i2) {
        boolean z = false;
        for (OnBluetoothStateListener onReceivePairRequest : this.mOnBluetoothStateListeners) {
            if (onReceivePairRequest.onReceivePairRequest(bluetoothDevice, i, i2)) {
                z = true;
            }
        }
        return z;
    }

    private void onBluetoothStateChanged(boolean z) {
        this.isBluetoothEnable = z;
        for (OnBluetoothStateListener onStateChanged : this.mOnBluetoothStateListeners) {
            onStateChanged.onStateChanged(z);
        }
    }

    public void onReceive(Context context, Intent intent) {
        ILog.d(TAG, "收到蓝牙相关广播，action--" + intent.getAction());
        String action = intent.getAction();
        action.hashCode();
        char c = 65535;
        switch (action.hashCode()) {
            case -1530327060:
                if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                    c = 0;
                    break;
                }
                break;
            case -223687943:
                if (action.equals("android.bluetooth.device.action.PAIRING_REQUEST")) {
                    c = 1;
                    break;
                }
                break;
            case 1260591598:
                if (action.equals("android.bluetooth.adapter.action.LOCAL_NAME_CHANGED")) {
                    c = 2;
                    break;
                }
                break;
            case 2116862345:
                if (action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
                ILog.d(TAG, "蓝牙状态更改--" + intExtra);
                if (intExtra == 12) {
                    onBluetoothStateChanged(true);
                    return;
                } else if (intExtra == 10) {
                    onBluetoothStateChanged(false);
                    return;
                } else {
                    return;
                }
            case 1:
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", Integer.MIN_VALUE);
                int intExtra3 = intent.getIntExtra("android.bluetooth.device.extra.PAIRING_KEY", Integer.MIN_VALUE);
                ILog.d(TAG, "收到蓝牙配对请求，type--" + intExtra2 + "，pairingKey--" + intExtra3);
                if (intExtra3 == Integer.MIN_VALUE) {
                    return;
                }
                if (intExtra2 != Integer.MIN_VALUE) {
                    onBluetoothPairRequest(bluetoothDevice, intExtra2, intExtra3);
                    return;
                } else {
                    onBluetoothPairRequest(bluetoothDevice, 2, intExtra3);
                    return;
                }
            case 2:
                String stringExtra = intent.getStringExtra("android.bluetooth.adapter.extra.LOCAL_NAME");
                ILog.d(TAG, "蓝牙名称更改--" + stringExtra);
                onBluetoothNameChanged(stringExtra);
                return;
            case 3:
                int intExtra4 = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", 10);
                BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                ILog.d(TAG, "蓝牙配对状态更改，新状态--" + intExtra4);
                if (intExtra4 == 12) {
                    onBluetoothBondStateChanged(bluetoothDevice2, true);
                    return;
                } else if (intExtra4 == 10) {
                    onBluetoothBondStateChanged(bluetoothDevice2, false);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void registerBluetoothStateListener(@NonNull OnBluetoothStateListener onBluetoothStateListener) {
        if (!this.mOnBluetoothStateListeners.contains(onBluetoothStateListener)) {
            this.mOnBluetoothStateListeners.add(onBluetoothStateListener);
            onBluetoothStateListener.onStateChanged(this.isBluetoothEnable);
        }
    }

    public void start() {
        if (!this.hasRegister) {
            this.hasRegister = true;
            this.mBroadcastReceiver = new BluetoothEventBroadcastReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.adapter.action.LOCAL_NAME_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
            if (Build.VERSION.SDK_INT >= 33) {
                InterconnectManager.getInstance().getContext().registerReceiver(this.mBroadcastReceiver, intentFilter, 4);
            } else {
                InterconnectManager.getInstance().getContext().registerReceiver(this.mBroadcastReceiver, intentFilter);
            }
        }
    }

    public void stop() {
        if (this.hasRegister) {
            InterconnectManager.getInstance().getContext().unregisterReceiver(this.mBroadcastReceiver);
        }
        this.hasRegister = false;
    }

    public void unregisterBluetoothStateListener(@NonNull OnBluetoothStateListener onBluetoothStateListener) {
        this.mOnBluetoothStateListeners.remove(onBluetoothStateListener);
    }

    private BluetoothEventMonitor() {
        this.hasRegister = false;
        this.mOnBluetoothStateListeners = new CopyOnWriteArrayList();
    }
}
