package com.upuphone.starrynet.core.spp.task;

import android.bluetooth.BluetoothSocket;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.core.spp.callback.IConnectionEventListener;
import com.upuphone.starrynet.strategy.pair.ble.RingSecurityPair;
import java.io.IOException;
import java.io.OutputStream;

public class SPPWriteTask implements Runnable {
    private static final String TAG = "SPPWriteTask";
    private byte[] SPP_HEADER_ID_CODE_ARRAY = {-22, RingSecurityPair.OPCODE_RING_ENCRYPTED_DATA, -109, 83};
    private BluetoothSocket mBluetoothSocket;
    private String mDeviceAddress;
    private IConnectionEventListener mIConnectionEventListener;
    private byte[] mMessage;
    private OutputStream mOutputStream;

    public SPPWriteTask(byte[] bArr, BluetoothSocket bluetoothSocket, IConnectionEventListener iConnectionEventListener) {
        this.mMessage = bArr;
        this.mBluetoothSocket = bluetoothSocket;
        this.mDeviceAddress = bluetoothSocket.getRemoteDevice().getAddress();
        this.mIConnectionEventListener = iConnectionEventListener;
        try {
            this.mOutputStream = this.mBluetoothSocket.getOutputStream();
        } catch (IOException unused) {
            StLog.d(TAG, "SPPWriteTask: init mOutputStream error");
            this.mIConnectionEventListener.onConnectionStateChanged(this.mDeviceAddress, 100);
        }
    }

    public void run() {
        if (this.mOutputStream == null) {
            StLog.d(TAG, "SPPWriteTask, mOutputStream is null");
            this.mIConnectionEventListener.onMessageDispatched(this.mDeviceAddress, this.mMessage, 200);
            return;
        }
        String str = TAG;
        StLog.d(str, "SPPWriteTask, payload len:" + this.mMessage.length);
        byte[] bArr = this.mMessage;
        try {
            this.mOutputStream.write(ByteUtils.concatenate(this.SPP_HEADER_ID_CODE_ARRAY, ByteUtils.concatenate(new byte[]{(byte) ((bArr.length >> 24) & 255), (byte) ((bArr.length >> 16) & 255), (byte) ((bArr.length >> 8) & 255), (byte) (bArr.length & 255)}, bArr)));
            this.mIConnectionEventListener.onMessageDispatched(this.mDeviceAddress, this.mMessage, 201);
        } catch (IOException e) {
            String str2 = TAG;
            StLog.d(str2, "SPPWriteTask:run error: " + e);
            this.mIConnectionEventListener.onMessageDispatched(this.mDeviceAddress, this.mMessage, 200);
        }
    }
}
