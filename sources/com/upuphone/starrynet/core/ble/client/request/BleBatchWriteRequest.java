package com.upuphone.starrynet.core.ble.client.request;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Message;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.client.listener.WriteCharacterListener;
import com.upuphone.starrynet.core.ble.client.response.BleResponser;
import com.upuphone.starrynet.core.ble.listener.ITryInterruptRequestCallback;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import java.util.List;
import java.util.UUID;

public class BleBatchWriteRequest extends BleRequest implements WriteCharacterListener {
    private static final int DELAY_TIME = 3;
    private static int MSG_SEND_NEXT_DATA = 88;
    private static final String TAG = "BleBatchWriteRequest";
    private List<byte[]> dataBytes;
    private int dataSize;
    private ITryInterruptRequestCallback interruptRequestCallback;
    private boolean isWaitingOnWrite = false;
    private int totalWriteNum = 1;

    public BleBatchWriteRequest(UUID uuid, UUID uuid2, List<byte[]> list, BleResponser bleResponser) {
        super(bleResponser);
        this.mServiceUUID = uuid;
        this.mCharacterUUID = uuid2;
        this.dataBytes = list;
        this.dataSize = list.size();
    }

    private boolean isHighLevelRequest(UUID uuid, UUID uuid2) {
        if (BluetoothConstants.STARRY_NET_SERVICE_UUID.equals(uuid)) {
            return BluetoothConstants.STARRY_NET_AIR_INTERNAL_MESSAGE_UUID.equals(uuid2);
        }
        return false;
    }

    private boolean startWrite() {
        List<byte[]> list = this.dataBytes;
        if (list == null || list.isEmpty()) {
            onRequestCompleted(0);
            stopRequestTiming();
            return false;
        }
        if (writeCharacteristic(this.mServiceUUID, this.mCharacterUUID, this.dataBytes.get(0))) {
            this.dataBytes.remove(0);
            this.isWaitingOnWrite = true;
        } else {
            BluetoothLog.error(TAG, "write fail", new Object[0]);
        }
        return true;
    }

    public boolean checkNeedInterrupt() {
        List<byte[]> list;
        if (isHighLevelRequest(this.mServiceUUID, this.mCharacterUUID) || (list = this.dataBytes) == null || list.size() <= 5) {
            return false;
        }
        BluetoothLog.log(TAG, "checkNeed interrupt true", new Object[0]);
        return true;
    }

    public long getTimeoutInMillis() {
        return Math.max((long) (this.dataSize * 1000), super.getTimeoutInMillis());
    }

    public boolean handleMessage(Message message) {
        if (message.what != MSG_SEND_NEXT_DATA) {
            return super.handleMessage(message);
        }
        startWrite();
        return true;
    }

    public BleBatchWriteRequest interrupt() {
        BluetoothLog.log(TAG, "interrupt, remain list byte[] size=" + this.dataBytes.size(), new Object[0]);
        BleBatchWriteRequest bleBatchWriteRequest = new BleBatchWriteRequest(this.mServiceUUID, this.mCharacterUUID, this.dataBytes, this.mResponse);
        bleBatchWriteRequest.setRuntimeChecker(this.mRuntimeChecker);
        bleBatchWriteRequest.setWorker(this.mWorker);
        bleBatchWriteRequest.setAddress(this.mAddress);
        return bleBatchWriteRequest;
    }

    public void onCharacteristicWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, byte[] bArr) {
        this.isWaitingOnWrite = false;
        ITryInterruptRequestCallback iTryInterruptRequestCallback = this.interruptRequestCallback;
        if (iTryInterruptRequestCallback != null) {
            iTryInterruptRequestCallback.onReady();
            return;
        }
        int i2 = this.totalWriteNum + 1;
        this.totalWriteNum = i2;
        if (i2 >= this.dataSize * 2) {
            onRequestCompleted(0);
            stopRequestTiming();
            return;
        }
        List<byte[]> list = this.dataBytes;
        if (list == null || list.isEmpty()) {
            onRequestCompleted(0);
            stopRequestTiming();
            return;
        }
        this.mHandler.sendEmptyMessageDelayed(MSG_SEND_NEXT_DATA, 3);
    }

    public void processRequest() {
        int currentStatus = getCurrentStatus();
        if (currentStatus != 2 && currentStatus != 19) {
            onRequestCompleted(-1);
        } else if (startWrite()) {
            startRequestTiming();
        }
    }

    public void triggerCompleted() {
        BluetoothLog.log(TAG, "triggerCompleted", new Object[0]);
        this.interruptRequestCallback = null;
        this.mHandler.removeMessages(MSG_SEND_NEXT_DATA);
        this.mFinished = true;
        onRequestCompleted(0);
        stopRequestTiming();
    }

    public void tryInterruptRequest(ITryInterruptRequestCallback iTryInterruptRequestCallback) {
        BluetoothLog.log(TAG, "tryInterruptRequest isWaitingOnWrite=" + this.isWaitingOnWrite, new Object[0]);
        if (this.isWaitingOnWrite) {
            this.interruptRequestCallback = iTryInterruptRequestCallback;
        } else if (iTryInterruptRequestCallback != null) {
            iTryInterruptRequestCallback.onReady();
        }
    }
}
