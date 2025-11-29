package com.upuphone.starrynet.core.ble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SystemActionObserver {
    private static final String TAG = "SystemActionObserver";
    private volatile boolean isBluetoothOn;
    /* access modifiers changed from: private */
    public volatile boolean isScreenOn;
    private BluetoothAdapter mAdapter;
    /* access modifiers changed from: private */
    public final Handler mHandler;
    /* access modifiers changed from: private */
    public final List<SystemActionChangedCallback> mStateChangeCallback;

    public static class Holder {
        /* access modifiers changed from: private */
        public static final SystemActionObserver INSTANCE = new SystemActionObserver();

        private Holder() {
        }
    }

    public class SysActionReceiver extends BroadcastReceiver {
        private SysActionReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            StLog.d(SystemActionObserver.TAG, "onReceive : " + action);
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                SystemActionObserver.this.onBluetoothStateChange(intent);
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                boolean unused = SystemActionObserver.this.isScreenOn = true;
                SystemActionObserver.this.mHandler.post(new Runnable() {
                    public void run() {
                        for (SystemActionChangedCallback onScreenStateChange : SystemActionObserver.this.mStateChangeCallback) {
                            onScreenStateChange.onScreenStateChange(true);
                        }
                    }
                });
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                boolean unused2 = SystemActionObserver.this.isScreenOn = false;
                SystemActionObserver.this.mHandler.post(new Runnable() {
                    public void run() {
                        for (SystemActionChangedCallback onScreenStateChange : SystemActionObserver.this.mStateChangeCallback) {
                            onScreenStateChange.onScreenStateChange(false);
                        }
                    }
                });
            }
        }
    }

    public static abstract class SystemActionChangedCallback {
        public boolean onBluetoothStateChange(boolean z) {
            return false;
        }

        public boolean onScreenStateChange(boolean z) {
            return false;
        }
    }

    public static SystemActionObserver getInstance() {
        return Holder.INSTANCE;
    }

    /* access modifiers changed from: private */
    public void onBluetoothStateChange(Intent intent) {
        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
        StLog.d(TAG, "BT state change : " + intExtra);
        if (intExtra == 12) {
            this.isBluetoothOn = true;
            StLog.d(TAG, "Bluetooth enabled");
            this.mHandler.post(new Runnable() {
                public void run() {
                    for (SystemActionChangedCallback onBluetoothStateChange : SystemActionObserver.this.mStateChangeCallback) {
                        onBluetoothStateChange.onBluetoothStateChange(true);
                    }
                }
            });
        } else if ((intExtra == 10 || intExtra == 13) && this.isBluetoothOn) {
            this.isBluetoothOn = false;
            StLog.d(TAG, "Bluetooth disabled");
            this.mHandler.post(new Runnable() {
                public void run() {
                    for (SystemActionChangedCallback onBluetoothStateChange : SystemActionObserver.this.mStateChangeCallback) {
                        onBluetoothStateChange.onBluetoothStateChange(false);
                    }
                }
            });
        }
    }

    @SuppressLint({"MissingPermission"})
    public void enableBluetooth() {
        StLog.d(TAG, "enableBluetooth");
        if (this.mAdapter == null) {
            this.mAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        BluetoothAdapter bluetoothAdapter = this.mAdapter;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.enable();
        } else {
            StLog.d(TAG, "Bluetooth state error");
        }
    }

    public SystemActionObserver init(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        BluetoothUtils.registerReceiver(new SysActionReceiver(), intentFilter);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mAdapter = defaultAdapter;
        if (defaultAdapter != null) {
            this.isBluetoothOn = defaultAdapter.isEnabled();
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            this.isScreenOn = powerManager.isInteractive();
        }
        return this;
    }

    public boolean isBtOn() {
        return this.isBluetoothOn;
    }

    public boolean isScreenOn() {
        return this.isScreenOn;
    }

    public void registerSystemActionCallback(SystemActionChangedCallback systemActionChangedCallback) {
        if (systemActionChangedCallback != null && !this.mStateChangeCallback.contains(systemActionChangedCallback)) {
            this.mStateChangeCallback.add(systemActionChangedCallback);
        }
    }

    public void unregisterSystemActionCallback(SystemActionChangedCallback systemActionChangedCallback) {
        this.mStateChangeCallback.remove(systemActionChangedCallback);
    }

    private SystemActionObserver() {
        this.isBluetoothOn = false;
        this.isScreenOn = false;
        this.mStateChangeCallback = new CopyOnWriteArrayList();
        this.mHandler = new Handler(Looper.getMainLooper());
    }
}
