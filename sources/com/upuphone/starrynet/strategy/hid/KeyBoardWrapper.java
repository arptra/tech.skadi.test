package com.upuphone.starrynet.strategy.hid;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHidDevice;
import android.util.Log;
import com.upuphone.starrynet.api.hid.IKeyBoardWrapper;

@SuppressLint({"MissingPermission"})
public class KeyBoardWrapper implements IKeyBoardWrapper {
    private static final byte MODIFIER_BASE = -32;
    private static final byte MODIFIER_COUNT = 8;
    private static final String TAG = "KeyBoardWrapper";
    private byte[] mBuffer = new byte[8];
    private BluetoothHidDevice mHidDevice;
    private BluetoothDevice mHost;
    private int mReportID = 1;

    public KeyBoardWrapper(BluetoothHidDevice bluetoothHidDevice, BluetoothDevice bluetoothDevice, int i) {
        this.mHidDevice = bluetoothHidDevice;
        this.mHost = bluetoothDevice;
    }

    public void keyDown(byte b) {
        Log.v(TAG, "yzy07SendReport(),  " + this.mHost.getName() + "key = " + b);
        if (b < -32 || b > -24) {
            if ((b & 128) == 0) {
                int i = 2;
                while (true) {
                    if (i >= 8) {
                        break;
                    }
                    byte[] bArr = this.mBuffer;
                    if (bArr[i] == 0) {
                        bArr[i] = b;
                        break;
                    }
                    i++;
                }
            } else {
                byte[] bArr2 = this.mBuffer;
                bArr2[1] = (byte) ((1 << (b & 7)) | bArr2[1]);
            }
        } else {
            byte[] bArr3 = this.mBuffer;
            bArr3[0] = (byte) ((1 << (b - MODIFIER_BASE)) | bArr3[0]);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : this.mBuffer) {
            stringBuffer.append("" + b2);
        }
        this.mHidDevice.sendReport(this.mHost, this.mReportID, this.mBuffer);
    }

    public void keyUp(byte b) {
        if (b < -32 || b > -24) {
            if ((b & 128) == 0) {
                int i = 2;
                while (true) {
                    if (i >= 8) {
                        break;
                    }
                    byte[] bArr = this.mBuffer;
                    if (bArr[i] == b) {
                        bArr[i] = 0;
                        break;
                    }
                    i++;
                }
            } else {
                byte[] bArr2 = this.mBuffer;
                bArr2[1] = (byte) ((~(1 << (b & 7))) & bArr2[1]);
            }
        } else {
            byte[] bArr3 = this.mBuffer;
            bArr3[0] = (byte) ((~(1 << (b - MODIFIER_BASE))) & bArr3[0]);
        }
        this.mHidDevice.sendReport(this.mHost, this.mReportID, this.mBuffer);
    }
}
