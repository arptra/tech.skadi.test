package com.upuphone.runasone.ble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.honey.account.o5.m;
import com.honey.account.o5.n;
import com.upuphone.runasone.ble.GattCallback;
import com.upuphone.runasone.utils.BleLogger;
import com.upuphone.runasone.utils.Utils;
import java.util.UUID;

@SuppressLint({"MissingPermission"})
public class BleInternalDevice extends BleRawDevice implements GattCallback.ConnectCallback, Handler.Callback {
    private static final int MSG_CONNECT_REQUEST_TIMEOUT = 101;
    public static final int STATE_CONNECTED = 2;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_FOUND = 0;
    public static final int STATE_LOSE = 4;
    private static final String TAG = "BleInternalDevice";
    private byte beaconId;
    private Handler bleHandler;
    private Looper bleLooper;
    private BluetoothGatt bluetoothGatt;
    private ConnectConfig connectConfig;
    private BluetoothDevice device;
    private DeviceCallback deviceCallback;
    private GattCallback gattCallback;
    public long lastFoundTime;
    private RequestDispatcher requestDispatcher;
    private int retryConnectCount = 0;
    private BleInternalSession session;
    private SessionCallback sessionCallback;
    public int state;

    public BleInternalDevice(String str, String str2, String str3, String str4, String str5, String str6, byte[] bArr, byte b, BluetoothDevice bluetoothDevice) {
        super(str, str2, str3, str4, str5, str6, bArr);
        this.beaconId = b;
        this.device = bluetoothDevice;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onConnectFail$1() {
        this.bluetoothGatt = this.device.connectGatt(Utils.getContext(), false, this.gattCallback, 2);
    }

    public void connect(ConnectConfig connectConfig2) {
        BleLogger.d(TAG, (Object) "connect");
        this.connectConfig = connectConfig2;
        this.gattCallback = new GattCallback(this.bleLooper, this);
        this.bluetoothGatt = this.device.connectGatt(Utils.getContext(), false, this.gattCallback, 2);
        this.bleHandler.sendEmptyMessageDelayed(101, connectConfig2.getTimeout());
    }

    public void disconnect() {
        BleInternalSession bleInternalSession = this.session;
        if (bleInternalSession != null) {
            bleInternalSession.disconnect();
        } else {
            BleLogger.w(TAG, (Object) "disconnect fail, you need connect first!");
        }
        Handler handler = this.bleHandler;
        if (handler != null && handler.hasMessages(101)) {
            this.bleHandler.removeMessages(101);
            DeviceCallback deviceCallback2 = this.deviceCallback;
            if (deviceCallback2 != null) {
                deviceCallback2.onError(BleConstants.CANCEL_REQUEST);
            }
        }
    }

    public byte getBeaconId() {
        return this.beaconId;
    }

    public DeviceCallback getDeviceCallback() {
        return this.deviceCallback;
    }

    public BleInternalSession getSession() {
        return this.session;
    }

    public SessionCallback getSessionCallback() {
        return this.sessionCallback;
    }

    public boolean handleMessage(@NonNull Message message) {
        if (message.what != 101) {
            return false;
        }
        BleLogger.w(TAG, (Object) "connect request timeout");
        DeviceCallback deviceCallback2 = this.deviceCallback;
        if (deviceCallback2 != null) {
            deviceCallback2.onError(BleConstants.GATT_REQUEST_TIMEOUT);
        }
        BluetoothGatt bluetoothGatt2 = this.bluetoothGatt;
        if (bluetoothGatt2 != null) {
            bluetoothGatt2.disconnect();
        }
        this.gattCallback.release();
        this.state = 0;
        return true;
    }

    public void initSession(SessionConfig sessionConfig, InitSessionCallback initSessionCallback) {
        BleInternalSession bleInternalSession = this.session;
        if (bleInternalSession != null) {
            bleInternalSession.init(sessionConfig, initSessionCallback);
        } else {
            BleLogger.w(TAG, (Object) "initBleSettings fail, you need connect first!");
        }
    }

    public void onConnectFail(BluetoothGatt bluetoothGatt2, int i) {
        if (!this.bleHandler.hasMessages(101)) {
            BleLogger.w(TAG, (Object) "had happen timeout, onConnectFail:" + i);
        } else if (((long) this.retryConnectCount) < this.connectConfig.getRetryCount()) {
            this.retryConnectCount++;
            if (i == 206018) {
                this.bleHandler.postDelayed(new m(bluetoothGatt2), 50);
            } else {
                this.bleHandler.postDelayed(new n(this), 200);
            }
        } else {
            BleLogger.w(TAG, (Object) "after retry %d times connect still connect fail...");
            DeviceCallback deviceCallback2 = this.deviceCallback;
            if (deviceCallback2 != null) {
                deviceCallback2.onError(i);
            }
            this.state = 0;
        }
    }

    public void onConnected(BluetoothGatt bluetoothGatt2) {
        BleInternalSession bleInternalSession = new BleInternalSession(getDeviceId(), this, bluetoothGatt2, this.bleLooper);
        this.session = bleInternalSession;
        this.gattCallback.setSession(bleInternalSession);
        DeviceCallback deviceCallback2 = this.deviceCallback;
        if (deviceCallback2 != null) {
            deviceCallback2.onConnected(new BleRawSession(getDeviceId(), this.session.getSessionId()));
        }
        this.state = 2;
        this.bleHandler.removeMessages(101);
        this.requestDispatcher = new RequestDispatcher(this.session);
    }

    public void onDisconnected(int i) {
        DeviceCallback deviceCallback2 = this.deviceCallback;
        if (deviceCallback2 != null) {
            deviceCallback2.onDisconnected(i);
        }
        BleInternalSession bleInternalSession = this.session;
        if (bleInternalSession != null) {
            bleInternalSession.release();
        }
        GattCallback gattCallback2 = this.gattCallback;
        if (gattCallback2 != null) {
            gattCallback2.release();
        }
        RequestDispatcher requestDispatcher2 = this.requestDispatcher;
        if (requestDispatcher2 != null) {
            requestDispatcher2.release();
        }
        this.state = 0;
    }

    public void openNotify(UUID uuid, OpenNotifyCallback openNotifyCallback) {
        RequestDispatcher requestDispatcher2 = this.requestDispatcher;
        if (requestDispatcher2 != null) {
            requestDispatcher2.openNotify(uuid, openNotifyCallback);
        } else {
            BleLogger.w(TAG, (Object) "write fail, you need connect first!");
        }
    }

    public void read(UUID uuid, ReadCallback readCallback) {
        RequestDispatcher requestDispatcher2 = this.requestDispatcher;
        if (requestDispatcher2 != null) {
            requestDispatcher2.read(uuid, readCallback);
        } else {
            BleLogger.w(TAG, (Object) "read fail, you need connect first!");
        }
    }

    public void setBeaconId(byte b) {
        this.beaconId = b;
    }

    public void setBleLooper(Looper looper) {
        this.bleLooper = looper;
        this.bleHandler = new Handler(looper, this);
    }

    public void setBluetoothDevice(BluetoothDevice bluetoothDevice) {
        this.device = bluetoothDevice;
    }

    public void setDeviceCallback(DeviceCallback deviceCallback2) {
        this.deviceCallback = deviceCallback2;
    }

    public void setMtu(int i, MtuCallback mtuCallback) {
        RequestDispatcher requestDispatcher2 = this.requestDispatcher;
        if (requestDispatcher2 != null) {
            requestDispatcher2.setMtu(i, mtuCallback);
        } else {
            BleLogger.w(TAG, (Object) "setMtu fail, you need bind BleSession Object first!");
        }
    }

    public void setSessionCallback(SessionCallback sessionCallback2) {
        this.sessionCallback = sessionCallback2;
        BleInternalSession bleInternalSession = this.session;
        if (bleInternalSession != null) {
            bleInternalSession.setSessionCallback(sessionCallback2);
        }
    }

    public BleRawDevice toRawDevice() {
        return new BleRawDevice(getDeviceId(), getVid(), getPid(), getVersion(), getDeviceName(), getAddress(), getPayload());
    }

    public void write(UUID uuid, byte[] bArr, WriteCallback writeCallback) {
        RequestDispatcher requestDispatcher2 = this.requestDispatcher;
        if (requestDispatcher2 != null) {
            requestDispatcher2.write(uuid, bArr, writeCallback);
        } else {
            BleLogger.w(TAG, (Object) "write fail, you need connect first!");
        }
    }
}
