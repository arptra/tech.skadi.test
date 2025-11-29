package com.upuphone.starrynet.core.ble.server.request;

import com.upuphone.runasone.share.lib.TransferHandler;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.listener.ITryInterruptRequestCallback;
import com.upuphone.starrynet.core.ble.server.listener.NotificationListener;
import com.upuphone.starrynet.core.ble.server.reponse.BleServerResponser;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import java.util.List;
import java.util.UUID;

public class BatchNotificationRequest extends BleServerRequest implements NotificationListener {
    private static final int DELAY = 2;
    private static final String TAG = "BatchNotificationRequest";
    private List<byte[]> dataBytes;
    private int dataSize;
    private ITryInterruptRequestCallback interruptRequestCallback;
    private boolean isWaitingOnSent = false;
    private UUID mCharacterUUID;
    private int totalWriteNum = 1;

    public BatchNotificationRequest(String str, UUID uuid, List<byte[]> list, BleServerResponser bleServerResponser) {
        super(str, bleServerResponser);
        this.mBleMac = str;
        this.mCharacterUUID = uuid;
        this.dataBytes = list;
        this.dataSize = list.size();
    }

    private boolean isHighLevelRequest(UUID uuid) {
        return BluetoothConstants.STARRY_NET_AIR_INTERNAL_MESSAGE_UUID.equals(uuid);
    }

    private boolean sendNotification() {
        List<byte[]> list = this.dataBytes;
        if (list == null || list.isEmpty()) {
            onRequestCompleted(0);
            stopRequestTiming();
            return false;
        }
        if (sendNotification(this.mBleMac, this.mCharacterUUID, this.dataBytes.get(0))) {
            this.dataBytes.remove(0);
            this.isWaitingOnSent = true;
        } else {
            BluetoothLog.error(TAG, "send notification fail", new Object[0]);
        }
        return true;
    }

    public boolean checkNeedInterrupt() {
        List<byte[]> list;
        if (isHighLevelRequest(this.mCharacterUUID) || (list = this.dataBytes) == null || list.size() <= 5) {
            return false;
        }
        BluetoothLog.log(TAG, "checkNeed interrupt true", new Object[0]);
        return true;
    }

    public long getTimeoutInMillis() {
        return (long) Math.max(this.dataSize * 500, TransferHandler.TIMEOUT);
    }

    public BatchNotificationRequest interrupt() {
        BluetoothLog.log(TAG, "interrupt, remain list byte[] size=" + this.dataBytes.size(), new Object[0]);
        BatchNotificationRequest batchNotificationRequest = new BatchNotificationRequest(this.mBleMac, this.mCharacterUUID, this.dataBytes, this.mResponse);
        batchNotificationRequest.setRuntimeChecker(this.mRuntimeChecker);
        batchNotificationRequest.setBleServer(this.mServer);
        return batchNotificationRequest;
    }

    public void onNotificationSent(int i) {
        this.isWaitingOnSent = false;
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
        sendNotification();
    }

    public void processRequest() {
        if (isConnected(this.mBleMac)) {
            sendNotification();
            startRequestTiming();
            return;
        }
        onRequestCompleted(-101);
    }

    public void triggerCompleted() {
        BluetoothLog.log(TAG, "triggerCompleted", new Object[0]);
        this.interruptRequestCallback = null;
        this.mFinished = true;
        onRequestCompleted(0);
        stopRequestTiming();
    }

    public void tryInterruptRequest(ITryInterruptRequestCallback iTryInterruptRequestCallback) {
        BluetoothLog.log(TAG, "tryInterruptRequest isWaitingOnSent=" + this.isWaitingOnSent, new Object[0]);
        if (this.isWaitingOnSent) {
            this.interruptRequestCallback = iTryInterruptRequestCallback;
        } else if (iTryInterruptRequestCallback != null) {
            iTryInterruptRequestCallback.onReady();
        }
    }
}
