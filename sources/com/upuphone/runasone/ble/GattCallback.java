package com.upuphone.runasone.ble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.honey.account.o5.s;
import com.honey.account.o5.t;
import com.honey.account.o5.u;
import com.honey.account.o5.v;
import com.honey.account.o5.w;
import com.honey.account.o5.x;
import com.upuphone.runasone.utils.BleLogger;
import java.lang.reflect.Method;

@SuppressLint({"MissingPermission"})
public class GattCallback extends BluetoothGattCallback {
    private static final String TAG = "GattCallback";
    private ConnectCallback connectCallback;
    private final Handler handler;
    private boolean isConnected = false;
    private BleInternalSession session;

    public interface ConnectCallback {
        void onConnectFail(BluetoothGatt bluetoothGatt, int i);

        void onConnected(BluetoothGatt bluetoothGatt);

        void onDisconnected(int i);
    }

    public GattCallback(Looper looper, ConnectCallback connectCallback2) {
        BleLogger.d(TAG, (Object) "init");
        this.handler = new Handler(looper);
        this.connectCallback = connectCallback2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCharacteristicChanged$3(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        this.session.onCharacteristicChanged(bluetoothGattCharacteristic, bArr);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCharacteristicRead$1(byte[] bArr, int i) {
        this.session.onCharacteristicRead(bArr, i);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCharacteristicWrite$2(int i) {
        this.session.onCharacteristicWrite(i);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onDescriptorWrite$4(BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        this.session.onDescriptorWrite(bluetoothGattDescriptor, i);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onMtuChanged$5(int i, int i2) {
        this.session.onMtuChanged(i, i2);
    }

    private void refreshGatt(BluetoothGatt bluetoothGatt) {
        boolean z;
        try {
            Method method = BluetoothGatt.class.getMethod("refresh", (Class[]) null);
            method.setAccessible(true);
            z = ((Boolean) method.invoke(bluetoothGatt, (Object[]) null)).booleanValue();
        } catch (Exception e) {
            BleLogger.e(e);
            z = false;
        }
        BleLogger.d(TAG, "refreshGatt return %b", Boolean.valueOf(z));
    }

    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BleLogger.d(TAG, (Object) "onCharacteristicChanged");
        onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue());
    }

    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        BleLogger.d(TAG, (Object) "onCharacteristicRead");
        onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue(), i);
    }

    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        if (this.session != null) {
            this.handler.post(new w(this, i));
        } else {
            BleLogger.w(TAG, (Object) "session is null ,onCharacteristicWrite ");
        }
    }

    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        BleLogger.d(TAG, (Object) "onConnectionStateChange status=" + i + ",newState=" + i2);
        if (i == 0 && i2 == 2) {
            this.handler.postDelayed(new x(bluetoothGatt), 800);
            return;
        }
        refreshGatt(bluetoothGatt);
        bluetoothGatt.close();
        if (this.isConnected) {
            ConnectCallback connectCallback2 = this.connectCallback;
            if (connectCallback2 != null) {
                connectCallback2.onDisconnected(i);
            } else {
                BleLogger.w(TAG, (Object) "connectCallback is null, trigger onDisconnected fail");
            }
            this.isConnected = false;
            return;
        }
        ConnectCallback connectCallback3 = this.connectCallback;
        if (connectCallback3 != null) {
            connectCallback3.onConnectFail(bluetoothGatt, i);
        } else {
            BleLogger.w(TAG, (Object) "connectCallback is null, trigger onConnectFail fail ");
        }
    }

    public void onDescriptorRead(@NonNull BluetoothGatt bluetoothGatt, @NonNull BluetoothGattDescriptor bluetoothGattDescriptor, int i, @NonNull byte[] bArr) {
    }

    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        if (this.session != null) {
            this.handler.post(new u(this, bluetoothGattDescriptor, i));
        } else {
            BleLogger.w(TAG, (Object) "session is null ,onDescriptorWrite ");
        }
    }

    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        if (this.session != null) {
            this.handler.post(new s(this, i, i2));
        } else {
            BleLogger.w(TAG, (Object) "session is null ,onMtuChanged ");
        }
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        BleLogger.d(TAG, (Object) "onServicesDiscovered, status=" + i);
        if (i == 0) {
            ConnectCallback connectCallback2 = this.connectCallback;
            if (connectCallback2 != null) {
                connectCallback2.onConnected(bluetoothGatt);
            }
            this.isConnected = true;
            return;
        }
        ConnectCallback connectCallback3 = this.connectCallback;
        if (connectCallback3 != null) {
            connectCallback3.onConnectFail(bluetoothGatt, BleConstants.DISCOVERY_GATT_SERVICE_FAIL);
        }
    }

    public void release() {
        this.session = null;
        this.connectCallback = null;
        BleLogger.d(TAG, (Object) "release");
    }

    public void setSession(BleInternalSession bleInternalSession) {
        this.session = bleInternalSession;
    }

    public void onCharacteristicChanged(@NonNull BluetoothGatt bluetoothGatt, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr) {
        if (this.session != null) {
            this.handler.post(new v(this, bluetoothGattCharacteristic, bArr));
        } else {
            BleLogger.w(TAG, (Object) "session is null ,onCharacteristicChanged ");
        }
    }

    public void onCharacteristicRead(@NonNull BluetoothGatt bluetoothGatt, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr, int i) {
        if (this.session != null) {
            this.handler.post(new t(this, bArr, i));
        } else {
            BleLogger.w(TAG, (Object) "session is null ,onCharacteristicRead ");
        }
    }
}
