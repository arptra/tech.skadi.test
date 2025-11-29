package com.upuphone.starrynet.strategy.channel.iccoa;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import com.honey.account.a7.a;
import com.honey.account.a7.b;
import com.honey.account.a7.c;
import com.honey.account.a7.d;
import com.honey.account.a7.e;
import com.honey.account.a7.f;
import com.honey.account.a7.g;
import com.honey.account.a7.h;
import com.upuphone.starrynet.common.StLog;

@Keep
public class BleClientGattCallback extends BluetoothGattCallback {
    private static final String TAG = "IccoaChannelGattCallback";
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    private IBleClientGattCallback response;

    public BleClientGattCallback(IBleClientGattCallback iBleClientGattCallback) {
        this.response = iBleClientGattCallback;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCharacteristicChanged$4(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.response.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCharacteristicChanged$5(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        this.response.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic, bArr);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCharacteristicWrite$2(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        this.response.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onConnectionStateChange$0(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.response.onConnectionStateChange(bluetoothGatt, i, i2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onDescriptorWrite$3(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        this.response.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onMtuChanged$6(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.response.onMtuChanged(bluetoothGatt, i, i2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onServiceChanged$7(BluetoothGatt bluetoothGatt) {
        this.response.onServiceChanged(bluetoothGatt);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onServicesDiscovered$1(BluetoothGatt bluetoothGatt, int i) {
        this.response.onServicesDiscovered(bluetoothGatt, i);
    }

    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        StLog.d(TAG, "onCharacteristicChanged");
        this.mainHandler.post(new g(this, bluetoothGatt, bluetoothGattCharacteristic));
    }

    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        StLog.d(TAG, "onCharacteristicWrite status=" + i);
        this.mainHandler.post(new e(this, bluetoothGatt, bluetoothGattCharacteristic, i));
    }

    @SuppressLint({"MissingPermission"})
    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        StLog.d(TAG, "onConnectionStateChange, status =" + i + ",newState=" + i2);
        this.mainHandler.post(new c(this, bluetoothGatt, i, i2));
    }

    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        StLog.d(TAG, "onDescriptorWrite,uuid=" + bluetoothGattDescriptor.getUuid() + ", status=" + i);
        this.mainHandler.post(new b(this, bluetoothGatt, bluetoothGattDescriptor, i));
    }

    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        StLog.d(TAG, "onMtuChanged mtu =" + i + ",status=" + i2);
        this.mainHandler.post(new f(this, bluetoothGatt, i, i2));
    }

    public void onPhyRead(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
        StLog.d(TAG, "onPhyRead ,txPhy =" + i + ",rxPhy=" + i2 + ",status=" + i3);
    }

    public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
        StLog.d(TAG, "onPhyUpdate ,txPhy =" + i + ",rxPhy=" + i2 + ",status=" + i3);
    }

    public void onServiceChanged(BluetoothGatt bluetoothGatt) {
        StLog.d(TAG, "onServiceChanged");
        this.mainHandler.post(new a(this, bluetoothGatt));
    }

    @SuppressLint({"MissingPermission"})
    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        StLog.d(TAG, "onServicesDiscovered status=" + i);
        this.mainHandler.post(new d(this, bluetoothGatt, i));
    }

    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        StLog.d(TAG, "onCharacteristicChanged value.length =" + bArr.length);
        this.mainHandler.post(new h(this, bluetoothGatt, bluetoothGattCharacteristic, bArr));
    }
}
