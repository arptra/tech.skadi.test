package com.upuphone.starrynet.core.ble.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.BluetoothContextManager;
import com.upuphone.starrynet.core.ble.SystemActionObserver;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BluetoothUtils extends BluetoothContextManager {
    private static final String TAG = "BluetoothUtils";
    private static BluetoothAdapter mBluetoothAdapter;
    private static BluetoothManager mBluetoothManager;

    public static BluetoothAdapter getBluetoothAdapter() {
        if (mBluetoothAdapter == null) {
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        return mBluetoothAdapter;
    }

    public static BluetoothManager getBluetoothManager() {
        if (!isBleSupported()) {
            return null;
        }
        if (mBluetoothManager == null) {
            mBluetoothManager = (BluetoothManager) BluetoothContextManager.getContext().getSystemService("bluetooth");
        }
        return mBluetoothManager;
    }

    public static BluetoothDevice getRemoteDevice(String str) {
        BluetoothAdapter bluetoothAdapter;
        if (TextUtils.isEmpty(str) || (bluetoothAdapter = getBluetoothAdapter()) == null) {
            return null;
        }
        try {
            return bluetoothAdapter.getRemoteDevice(str);
        } catch (Exception e) {
            StLog.e(TAG, "getRemoteDevice exception", (Throwable) e);
            return null;
        }
    }

    public static boolean isBleDeviceConnected(BluetoothDevice bluetoothDevice) {
        BluetoothManager bluetoothManager;
        if (bluetoothDevice == null || !isBleSupported() || (bluetoothManager = getBluetoothManager()) == null || bluetoothManager.getConnectionState(bluetoothDevice, 7) != 2) {
            return false;
        }
        return true;
    }

    public static boolean isBleDeviceDisconnected(String str) {
        if (TextUtils.isEmpty(str) || !isBleSupported()) {
            return false;
        }
        BluetoothDevice remoteDevice = getRemoteDevice(str);
        BluetoothManager bluetoothManager = getBluetoothManager();
        if (remoteDevice == null || bluetoothManager == null) {
            return true;
        }
        return bluetoothManager.getConnectionState(remoteDevice, 7) == 0;
    }

    public static boolean isBleSupported() {
        return BluetoothContextManager.getContext() != null && BluetoothContextManager.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static boolean isBluetoothEnabled() {
        return SystemActionObserver.getInstance().isBtOn();
    }

    public static boolean refreshGattCache(BluetoothGatt bluetoothGatt) {
        boolean z = false;
        if (bluetoothGatt != null) {
            try {
                Method method = BluetoothGatt.class.getMethod("refresh", (Class[]) null);
                if (method != null) {
                    method.setAccessible(true);
                    z = ((Boolean) method.invoke(bluetoothGatt, (Object[]) null)).booleanValue();
                }
            } catch (Exception e) {
                BluetoothLog.e(e);
            }
        }
        BluetoothLog.log(TAG, "refreshDeviceCache return %b", Boolean.valueOf(z));
        return z;
    }

    public static void registerBleStateReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (Build.VERSION.SDK_INT >= 33) {
            BluetoothContextManager.getContext().registerReceiver(broadcastReceiver, intentFilter, 2);
        } else {
            BluetoothContextManager.getContext().registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    private static void registerGlobalReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        BluetoothContextManager.getContext().registerReceiver(broadcastReceiver, intentFilter);
    }

    public static void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        registerGlobalReceiver(broadcastReceiver, intentFilter);
    }

    public static void registerReceiverCompatApi34(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(broadcastReceiver, intentFilter, 2);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public static void sendBroadcast(Intent intent) {
        sendGlobalBroadcast(intent);
    }

    private static void sendGlobalBroadcast(Intent intent) {
        BluetoothContextManager.getContext().sendBroadcast(intent);
    }

    public static void setBluetoothDeviceAliasName(String str, String str2) {
        BluetoothDevice remoteDevice = getRemoteDevice(str);
        if (remoteDevice != null) {
            try {
                remoteDevice.getClass().getMethod("setAlias", new Class[]{String.class}).invoke(remoteDevice, new Object[]{str2});
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                StLog.w(TAG, "setAlias", e);
            }
        }
    }

    public static void sendBroadcast(String str) {
        sendGlobalBroadcast(new Intent(str));
    }

    public static boolean isBleDeviceConnected(String str) {
        if (TextUtils.isEmpty(str) || !isBleSupported()) {
            return false;
        }
        BluetoothDevice remoteDevice = getRemoteDevice(str);
        BluetoothManager bluetoothManager = getBluetoothManager();
        if (remoteDevice == null || bluetoothManager == null || bluetoothManager.getConnectionState(remoteDevice, 7) != 2) {
            return false;
        }
        return true;
    }
}
