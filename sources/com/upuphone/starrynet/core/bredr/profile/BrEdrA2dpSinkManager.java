package com.upuphone.starrynet.core.bredr.profile;

import android.bluetooth.BluetoothA2dpSink;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.Handler;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.starrynet.common.StLog;

public class BrEdrA2dpSinkManager extends BrEdrBaseProfile {
    static final String TAG = "BrEdrA2dpSinkManager";
    BluetoothA2dpSink mA2dpSinkService;
    Handler mHandler;

    public BrEdrA2dpSinkManager(Context context, Handler handler) {
        StLog.d(TAG, MzContactsContract.START_PARAM_KEY);
        this.mHandler = handler;
        this.mAdapter.getProfileProxy(context, this.listener, 11);
    }

    public boolean checkA2dpSinkConnectionState(BluetoothDevice bluetoothDevice) {
        BluetoothA2dpSink bluetoothA2dpSink = this.mA2dpSinkService;
        boolean z = false;
        if (bluetoothA2dpSink == null) {
            StLog.d(TAG, "checkA2dpSinkConnectionState, mHfpClientService null ");
            return false;
        }
        if (bluetoothA2dpSink.getConnectionState(bluetoothDevice) == 2) {
            z = true;
        }
        StLog.d(TAG, "checkA2dpSinkConnectionState, isA2dpSinkConnected = " + z);
        return z;
    }

    public boolean connectA2dp(BluetoothDevice bluetoothDevice) {
        BluetoothA2dpSink bluetoothA2dpSink = this.mA2dpSinkService;
        if (bluetoothA2dpSink != null) {
            return bluetoothA2dpSink.connect(bluetoothDevice);
        }
        StLog.d(TAG, "connectA2dp, mHfpClientService null ");
        return false;
    }

    public boolean disconnectA2dp(BluetoothDevice bluetoothDevice) {
        BluetoothA2dpSink bluetoothA2dpSink = this.mA2dpSinkService;
        if (bluetoothA2dpSink != null) {
            return bluetoothA2dpSink.disconnect(bluetoothDevice);
        }
        StLog.d(TAG, "disconnectA2dp, mHfpClientService null ");
        return false;
    }

    public void serviceConnected(int i, BluetoothProfile bluetoothProfile) {
        if (i == 11) {
            StLog.d(TAG, "serviceConnected a2dp sink");
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(2));
            this.mA2dpSinkService = (BluetoothA2dpSink) bluetoothProfile;
        }
    }

    public void serviceDisconnected(int i) {
        if (i == 11) {
            StLog.d(TAG, "serviceDisconnected a2dp sink");
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(4));
        }
    }
}
