package com.upuphone.starrynet.strategy.hid;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHidDevice;
import com.upuphone.starrynet.api.hid.IMouseWrapper;
import com.upuphone.starrynet.common.StLog;

@SuppressLint({"MissingPermission"})
public class MouseWrapper implements IMouseWrapper {
    private static final String TAG = "MouseWrapper";
    private byte[] mBuffer = new byte[4];
    private BluetoothHidDevice mHidDevice;
    private BluetoothDevice mHost;
    private int mReportID = 2;

    public MouseWrapper(BluetoothHidDevice bluetoothHidDevice, BluetoothDevice bluetoothDevice, int i) {
        this.mHidDevice = bluetoothHidDevice;
        this.mHost = bluetoothDevice;
    }

    private void sendInputReport() {
        BluetoothDevice bluetoothDevice;
        BluetoothHidDevice bluetoothHidDevice = this.mHidDevice;
        if (bluetoothHidDevice == null || (bluetoothDevice = this.mHost) == null) {
            String str = "not";
            String str2 = bluetoothHidDevice == null ? "" : str;
            if (this.mHost == null) {
                str = "";
            }
            StLog.d(TAG, "sendInputReport, hidDevice is %s null ,host device is %s null", str2, str);
            return;
        }
        bluetoothHidDevice.sendReport(bluetoothDevice, this.mReportID, this.mBuffer);
    }

    public void buttonDown(int i) {
        StLog.v(TAG, "buttonDown which=%d", Integer.valueOf(i));
        byte[] bArr = this.mBuffer;
        bArr[0] = (byte) ((1 << i) | bArr[0]);
        bArr[1] = 0;
        bArr[2] = 0;
        bArr[3] = 0;
        sendInputReport();
    }

    public void buttonUp(int i) {
        StLog.v(TAG, "buttonUp which=%d", Integer.valueOf(i));
        byte[] bArr = this.mBuffer;
        bArr[0] = (byte) ((~(1 << i)) & bArr[0]);
        bArr[1] = 0;
        bArr[2] = 0;
        bArr[3] = 0;
        sendInputReport();
    }

    public void move(byte b, byte b2) {
        StLog.v(TAG, "move dx =%d, dy=%d", Byte.valueOf(b), Byte.valueOf(b2));
        byte[] bArr = this.mBuffer;
        bArr[1] = b;
        bArr[2] = b2;
        bArr[3] = 0;
        sendInputReport();
    }

    public void scroll(byte b) {
        StLog.v(TAG, "scroll delta =%d", Byte.valueOf(b));
        byte[] bArr = this.mBuffer;
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 0;
        bArr[3] = b;
        sendInputReport();
    }

    public void updateHidDevice(BluetoothHidDevice bluetoothHidDevice) {
        this.mHidDevice = bluetoothHidDevice;
    }

    public void updateHost(BluetoothDevice bluetoothDevice) {
        this.mHost = bluetoothDevice;
    }

    public void updateProtocol(int i) {
    }
}
