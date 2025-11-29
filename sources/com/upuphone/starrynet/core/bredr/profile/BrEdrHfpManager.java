package com.upuphone.starrynet.core.bredr.profile;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.starrynet.common.StLog;

public class BrEdrHfpManager extends BrEdrBaseProfile {
    static final String TAG = "BrEdrHfpManager";
    Context mContext;
    Handler mHandler;
    BluetoothHeadset mHeadsetService;

    public BrEdrHfpManager(Context context, Handler handler) {
        StLog.d(TAG, MzContactsContract.START_PARAM_KEY);
        this.mAdapter.getProfileProxy(context, this.listener, 1);
        this.mContext = context;
        this.mHandler = handler;
    }

    public boolean checkHfpConnectionPolicy(BluetoothDevice bluetoothDevice) {
        boolean z = true;
        if (ContextCompat.checkSelfPermission(this.mContext, "android.permission.BLUETOOTH_PRIVILEGED") != 0) {
            return true;
        }
        BluetoothHeadset bluetoothHeadset = this.mHeadsetService;
        if (bluetoothHeadset == null) {
            StLog.d(TAG, "checkHfpConnectionPolicy, mHeadsetService null ");
            return false;
        }
        if (bluetoothHeadset.getConnectionPolicy(bluetoothDevice) != 100) {
            z = false;
        }
        StLog.d(TAG, "checkHfpConnectionPolicy, isHfpPolicy = " + z);
        return z;
    }

    public boolean checkHfpConnectionState(BluetoothDevice bluetoothDevice) {
        BluetoothHeadset bluetoothHeadset = this.mHeadsetService;
        boolean z = false;
        if (bluetoothHeadset == null) {
            StLog.d(TAG, "checkHfpConnectionState, mHeadsetService null ");
            return false;
        }
        if (bluetoothHeadset.getConnectionState(bluetoothDevice) == 2) {
            z = true;
        }
        StLog.d(TAG, "checkHfpConnectionState, isHfpConnected = " + z);
        return z;
    }

    public void connectHfp(BluetoothDevice bluetoothDevice) {
        if (this.mHeadsetService == null) {
            StLog.d(TAG, "connectHfp, mHeadsetService null ");
            return;
        }
        StLog.d(TAG, "connectHfp");
        if (checkHfpConnectionPolicy(bluetoothDevice) && !checkHfpConnectionState(bluetoothDevice)) {
            this.mHeadsetService.connect(bluetoothDevice);
        }
    }

    public void disconnectHfp(BluetoothDevice bluetoothDevice) {
        if (this.mHeadsetService == null) {
            StLog.d(TAG, "disconnectHfp, mHeadsetService null ");
            return;
        }
        StLog.d(TAG, "disconnectHfp");
        if (checkHfpConnectionState(bluetoothDevice)) {
            this.mHeadsetService.disconnect(bluetoothDevice);
        }
    }

    public BluetoothDevice getHfpActiveDevice() {
        if (this.mHeadsetService == null) {
            StLog.d(TAG, "getHfpActiveDevice, mHeadsetService null ");
            return null;
        }
        StLog.d(TAG, "getHfpActiveDevice");
        return this.mHeadsetService.getActiveDevice();
    }

    public void serviceConnected(int i, BluetoothProfile bluetoothProfile) {
        if (i == 1) {
            StLog.d(TAG, "serviceConnected hfp");
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1));
            this.mHeadsetService = (BluetoothHeadset) bluetoothProfile;
        }
    }

    public void serviceDisconnected(int i) {
        if (i == 1) {
            StLog.d(TAG, "serviceDisconnected hfp");
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(3));
        }
    }

    public boolean setHfpActiveDevice(BluetoothDevice bluetoothDevice) {
        if (this.mHeadsetService == null) {
            StLog.d(TAG, "setHfpActiveDevice, mHeadsetService null ");
            return false;
        }
        StLog.d(TAG, "setActiveDevice");
        if (checkHfpConnectionState(bluetoothDevice)) {
            return this.mHeadsetService.setActiveDevice(bluetoothDevice);
        }
        return false;
    }
}
