package com.upuphone.starrynet.core.spp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.HandlerThreadUtil;
import com.upuphone.starrynet.core.spp.callback.IConnectionEventListener;
import com.upuphone.starrynet.core.spp.task.SPPReadTask;
import com.upuphone.starrynet.core.spp.task.SPPWriteTask;
import java.io.IOException;
import java.util.UUID;

class SPPConnection {
    private static final String READ_THREAD = "spp_read_thread_";
    private static final String TAG = "SPPConnection";
    private static final String WRITE_THREAD = "spp_write_thread_";
    private BluetoothSocket mBluetoothSocket;
    private String mDeviceAddress;
    private IConnectionEventListener mIConnectionEventListener;
    private Handler mWriteHandler;

    public SPPConnection(String str, IConnectionEventListener iConnectionEventListener) {
        this.mDeviceAddress = str;
        this.mIConnectionEventListener = iConnectionEventListener;
    }

    private void initReadTask() {
        HandlerThreadUtil instance = HandlerThreadUtil.getInstance();
        new Handler(instance.getLooper(READ_THREAD + this.mDeviceAddress)).post(new SPPReadTask(this.mBluetoothSocket, this.mIConnectionEventListener));
    }

    private void initWriteTask() {
        HandlerThreadUtil instance = HandlerThreadUtil.getInstance();
        this.mWriteHandler = new Handler(instance.getLooper(WRITE_THREAD + this.mDeviceAddress));
    }

    public void clientConnect(UUID uuid) {
        try {
            BluetoothSocket createRfcommSocketToServiceRecord = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(this.mDeviceAddress).createRfcommSocketToServiceRecord(uuid);
            this.mBluetoothSocket = createRfcommSocketToServiceRecord;
            createRfcommSocketToServiceRecord.connect();
            initReadTask();
            initWriteTask();
            this.mIConnectionEventListener.onConnectionStateChanged(this.mDeviceAddress, 101);
        } catch (IOException e) {
            String str = TAG;
            StLog.d(str, "clientConnect: error " + e);
            this.mIConnectionEventListener.onConnectionStateChanged(this.mDeviceAddress, 102);
        }
    }

    public void close() {
        BluetoothSocket bluetoothSocket = this.mBluetoothSocket;
        if (bluetoothSocket != null) {
            try {
                bluetoothSocket.close();
            } catch (IOException e) {
                String str = TAG;
                StLog.e(str, "close: " + e);
            }
        }
        HandlerThreadUtil instance = HandlerThreadUtil.getInstance();
        instance.quitThread(READ_THREAD + this.mDeviceAddress);
        HandlerThreadUtil instance2 = HandlerThreadUtil.getInstance();
        instance2.quitThread(WRITE_THREAD + this.mDeviceAddress);
        this.mWriteHandler = null;
    }

    public void serverOpenConnection(BluetoothSocket bluetoothSocket) {
        this.mBluetoothSocket = bluetoothSocket;
        initReadTask();
        initWriteTask();
        this.mIConnectionEventListener.onConnectionStateChanged(this.mDeviceAddress, 101);
    }

    public void write(byte[] bArr) {
        Handler handler = this.mWriteHandler;
        if (handler != null) {
            handler.post(new SPPWriteTask(bArr, this.mBluetoothSocket, this.mIConnectionEventListener));
        } else {
            StLog.d(TAG, "write: error, writer not ready ");
        }
    }
}
