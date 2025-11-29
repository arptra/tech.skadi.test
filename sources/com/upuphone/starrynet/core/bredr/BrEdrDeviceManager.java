package com.upuphone.starrynet.core.bredr;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.upuphone.starrynet.common.StLog;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressLint({"MissingPermission"})
public class BrEdrDeviceManager {
    private static final String TAG = "BrEdrDeviceManager";

    public static boolean cancelBondProcess(BluetoothDevice bluetoothDevice) {
        try {
            return bluetoothDevice.cancelBondProcess();
        } catch (Exception e) {
            StLog.w(TAG, "cancelBondProcess", (Throwable) e);
            return false;
        }
    }

    public static boolean createBrEdrBond(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return false;
        }
        int bondState = bluetoothDevice.getBondState();
        StLog.i(TAG, "createBrEdrBond, bond state = " + bondState);
        if (bondState == 10) {
            return bluetoothDevice.createBond();
        }
        return false;
    }

    public static List<BluetoothDevice> getBondDeviceList() {
        Set<BluetoothDevice> bondedDevices;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || (bondedDevices = defaultAdapter.getBondedDevices()) == null) {
            return null;
        }
        return new ArrayList(bondedDevices);
    }

    public static boolean invokeCreateBrEdrBond(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return false;
        }
        try {
            Object invoke = bluetoothDevice.getClass().getMethod("createBond", new Class[]{Integer.TYPE}).invoke(bluetoothDevice, new Object[]{1});
            StLog.i(TAG, "invokeCreateBrEdrBond, result=" + invoke);
            if (invoke != null) {
                return ((Boolean) invoke).booleanValue();
            }
            return false;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            StLog.e(TAG, "invokeCreateBrEdrBond", e);
            return false;
        }
    }

    private static boolean removeBond(BluetoothDevice bluetoothDevice) {
        try {
            return bluetoothDevice.removeBond();
        } catch (Exception e) {
            StLog.w(TAG, "removeBond", (Throwable) e);
            return false;
        }
    }

    public static boolean removeBrEdrBond(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return false;
        }
        int bondState = bluetoothDevice.getBondState();
        StLog.i(TAG, "removeBrEdrBond, bond state = " + bondState);
        if (bondState == 12) {
            return removeBond(bluetoothDevice);
        }
        if (bondState == 11) {
            return cancelBondProcess(bluetoothDevice);
        }
        return false;
    }

    public static void setDiscoverableTimeout(int i) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            defaultAdapter.setDiscoverableTimeout(i);
        }
    }

    public static void setPhonebookAccessPermission(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null) {
            bluetoothDevice.setPhonebookAccessPermission(1);
        }
    }

    public static void setScanMode(int i) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && !defaultAdapter.setScanMode(i)) {
            StLog.d(TAG, "setScanMode failed");
        }
    }
}
