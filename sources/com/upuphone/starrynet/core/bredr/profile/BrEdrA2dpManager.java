package com.upuphone.starrynet.core.bredr.profile;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.starrynet.common.StLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BrEdrA2dpManager extends BrEdrBaseProfile {
    static final String TAG = "BrEdrA2dpManager";
    BluetoothA2dp mA2dpService;
    Context mContext;
    Handler mHandler;

    public BrEdrA2dpManager(Context context, Handler handler) {
        StLog.d(TAG, MzContactsContract.START_PARAM_KEY);
        this.mContext = context;
        this.mHandler = handler;
        this.mAdapter.getProfileProxy(context, this.listener, 2);
    }

    /* access modifiers changed from: private */
    public void tryConnectA2dpWhenServiceConnected(BluetoothDevice bluetoothDevice) {
        if (this.mA2dpService == null) {
            StLog.d(TAG, "connectA2dp, mA2dpService null ");
            return;
        }
        StLog.d(TAG, "connectA2dp onServiceConnected, tryConnectA2dpWhenServiceConnected");
        if (checkA2dpConnectionPolicy(bluetoothDevice) && !checkA2dpConnectionState(bluetoothDevice)) {
            this.mA2dpService.connect(bluetoothDevice);
        }
    }

    public boolean checkA2dpConnectionPolicy(BluetoothDevice bluetoothDevice) {
        boolean z = true;
        if (ContextCompat.checkSelfPermission(this.mContext, "android.permission.BLUETOOTH_PRIVILEGED") != 0) {
            return true;
        }
        BluetoothA2dp bluetoothA2dp = this.mA2dpService;
        if (bluetoothA2dp == null) {
            StLog.d(TAG, "checkA2dpConnectionPolicy, mA2dpService null ");
            return false;
        }
        if (bluetoothA2dp.getConnectionPolicy(bluetoothDevice) != 100) {
            z = false;
        }
        StLog.d(TAG, "checkA2dpConnectionPolicy, isA2dpPolicy = " + z);
        return z;
    }

    public boolean checkA2dpConnectionState(BluetoothDevice bluetoothDevice) {
        BluetoothA2dp bluetoothA2dp = this.mA2dpService;
        boolean z = false;
        if (bluetoothA2dp == null) {
            StLog.d(TAG, "checkA2dpConnectionState, mA2dpService null ");
            return false;
        }
        if (bluetoothA2dp.getConnectionState(bluetoothDevice) == 2) {
            z = true;
        }
        StLog.d(TAG, "checkA2dpConnectionState, isA2dpConnected = " + z);
        return z;
    }

    public void connectA2dp(final BluetoothDevice bluetoothDevice) {
        if (this.mA2dpService == null) {
            StLog.d(TAG, "connectA2dp, mA2dpService null ");
            return;
        }
        StLog.d(TAG, "connectA2dp");
        if (!isProfileProxyServiceValid(this.mA2dpService)) {
            StLog.w(TAG, "connectA2dp ,getService() is null");
            this.mAdapter.closeProfileProxy(2, this.mA2dpService);
            final boolean[] zArr = {true};
            this.mAdapter.getProfileProxy(this.mContext, new BluetoothProfile.ServiceListener() {
                public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                    if (i == 2) {
                        BrEdrA2dpManager.this.listener.onServiceConnected(i, bluetoothProfile);
                        if (zArr[0]) {
                            BrEdrA2dpManager.this.tryConnectA2dpWhenServiceConnected(bluetoothDevice);
                            zArr[0] = false;
                        }
                    }
                }

                public void onServiceDisconnected(int i) {
                    BrEdrA2dpManager.this.listener.onServiceDisconnected(i);
                }
            }, 2);
        } else if (checkA2dpConnectionPolicy(bluetoothDevice) && !checkA2dpConnectionState(bluetoothDevice)) {
            this.mA2dpService.connect(bluetoothDevice);
        }
    }

    public void disconnectA2dp(BluetoothDevice bluetoothDevice) {
        if (this.mA2dpService == null) {
            StLog.d(TAG, "disconnectA2dp, mA2dpService null ");
            return;
        }
        StLog.d(TAG, "disconnectA2dp");
        if (checkA2dpConnectionState(bluetoothDevice)) {
            this.mA2dpService.disconnect(bluetoothDevice);
        }
    }

    public BluetoothDevice getA2dpActiveDevice() {
        if (this.mA2dpService == null) {
            StLog.d(TAG, "getHfpActiveDevice, mA2dpService null ");
            return null;
        }
        StLog.d(TAG, "getA2dpActiveDevice");
        return this.mA2dpService.getActiveDevice();
    }

    public boolean isProfileProxyServiceValid(BluetoothA2dp bluetoothA2dp) {
        if (bluetoothA2dp == null) {
            StLog.w(TAG, "isProfileProxyServiceValid bluetoothA2dp is null");
            return false;
        }
        try {
            Method declaredMethod = bluetoothA2dp.getClass().getDeclaredMethod("getService", (Class[]) null);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(bluetoothA2dp, (Object[]) null) != null;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return true;
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
            return true;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return true;
        }
    }

    public void serviceConnected(int i, BluetoothProfile bluetoothProfile) {
        if (i == 2) {
            StLog.d(TAG, "serviceConnected a2dp");
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(2));
            this.mA2dpService = (BluetoothA2dp) bluetoothProfile;
        }
    }

    public void serviceDisconnected(int i) {
        if (i == 2) {
            StLog.d(TAG, "serviceDisconnected a2dp");
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(4));
        }
    }

    public boolean setA2dpActiveDevice(BluetoothDevice bluetoothDevice) {
        if (this.mA2dpService == null) {
            StLog.d(TAG, "setA2dpActiveDevice, mA2dpService null ");
            return false;
        }
        StLog.d(TAG, "setA2dpActiveDevice");
        if (checkA2dpConnectionState(bluetoothDevice)) {
            return this.mA2dpService.setActiveDevice(bluetoothDevice);
        }
        StLog.w(TAG, "error, a2dp not connct");
        return false;
    }
}
