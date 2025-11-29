package com.upuphone.starrynet.core.bredr.profile;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadsetClient;
import android.bluetooth.BluetoothHeadsetClientCall;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.Handler;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.starrynet.common.StLog;
import java.util.List;

public class BrEdrHfpClientManager extends BrEdrBaseProfile {
    static final String TAG = "BrEdrHfpClientManager";
    Handler mHandler;
    BluetoothHeadsetClient mHfpClientService;

    public BrEdrHfpClientManager(Context context, Handler handler) {
        StLog.d(TAG, MzContactsContract.START_PARAM_KEY);
        this.mHandler = handler;
        this.mAdapter.getProfileProxy(context, this.listener, 16);
    }

    public void acceptCall(BluetoothDevice bluetoothDevice) {
        BluetoothHeadsetClient bluetoothHeadsetClient = this.mHfpClientService;
        if (bluetoothHeadsetClient == null) {
            StLog.d(TAG, "acceptCall, mHfpClientService null ");
        } else {
            bluetoothHeadsetClient.acceptCall(bluetoothDevice, 0);
        }
    }

    public boolean checkHfpConnectionState(BluetoothDevice bluetoothDevice) {
        BluetoothHeadsetClient bluetoothHeadsetClient = this.mHfpClientService;
        boolean z = false;
        if (bluetoothHeadsetClient == null) {
            StLog.d(TAG, "checkHfpConnectionState, mHfpClientService null ");
            return false;
        }
        if (bluetoothHeadsetClient.getConnectionState(bluetoothDevice) == 2) {
            z = true;
        }
        StLog.d(TAG, "checkHfpConnectionState, isHfpConnected = " + z);
        return z;
    }

    public boolean conncetHfp(BluetoothDevice bluetoothDevice) {
        BluetoothHeadsetClient bluetoothHeadsetClient = this.mHfpClientService;
        if (bluetoothHeadsetClient != null) {
            return bluetoothHeadsetClient.connect(bluetoothDevice);
        }
        StLog.d(TAG, "conncetHfp, mHfpClientService null ");
        return false;
    }

    public void dial(BluetoothDevice bluetoothDevice, String str) {
        BluetoothHeadsetClient bluetoothHeadsetClient = this.mHfpClientService;
        if (bluetoothHeadsetClient == null) {
            StLog.d(TAG, "dial, mHfpClientService null ");
        } else {
            bluetoothHeadsetClient.dial(bluetoothDevice, str);
        }
    }

    public boolean disconnectHfp(BluetoothDevice bluetoothDevice) {
        BluetoothHeadsetClient bluetoothHeadsetClient = this.mHfpClientService;
        if (bluetoothHeadsetClient != null) {
            return bluetoothHeadsetClient.disconnect(bluetoothDevice);
        }
        StLog.d(TAG, "disconnectHfp, mHfpClientService null ");
        return false;
    }

    public void holdCall(BluetoothDevice bluetoothDevice) {
        BluetoothHeadsetClient bluetoothHeadsetClient = this.mHfpClientService;
        if (bluetoothHeadsetClient == null) {
            StLog.d(TAG, "holdCall, mHfpClientService null ");
        } else {
            bluetoothHeadsetClient.holdCall(bluetoothDevice);
        }
    }

    public void rejectCall(BluetoothDevice bluetoothDevice) {
        BluetoothHeadsetClient bluetoothHeadsetClient = this.mHfpClientService;
        if (bluetoothHeadsetClient == null) {
            StLog.d(TAG, "rejectCall, mHfpClientService null ");
        } else {
            bluetoothHeadsetClient.rejectCall(bluetoothDevice);
        }
    }

    public void serviceConnected(int i, BluetoothProfile bluetoothProfile) {
        if (i == 16) {
            StLog.d(TAG, "serviceConnected hfp client");
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1));
            this.mHfpClientService = (BluetoothHeadsetClient) bluetoothProfile;
        }
    }

    public void serviceDisconnected(int i) {
        if (i == 16) {
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(3));
            StLog.d(TAG, "serviceDisconnected hfp client");
        }
    }

    public void terminateCall(BluetoothDevice bluetoothDevice) {
        BluetoothHeadsetClient bluetoothHeadsetClient = this.mHfpClientService;
        if (bluetoothHeadsetClient == null) {
            StLog.d(TAG, "terminateCall, mHfpClientService null ");
            return;
        }
        List currentCalls = bluetoothHeadsetClient.getCurrentCalls(bluetoothDevice);
        if (currentCalls != null && !currentCalls.isEmpty()) {
            this.mHfpClientService.terminateCall(bluetoothDevice, (BluetoothHeadsetClientCall) currentCalls.get(0));
        }
    }
}
