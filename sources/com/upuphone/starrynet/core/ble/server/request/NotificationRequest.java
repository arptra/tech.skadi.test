package com.upuphone.starrynet.core.ble.server.request;

import com.upuphone.starrynet.core.ble.server.listener.NotificationListener;
import com.upuphone.starrynet.core.ble.server.reponse.BleServerResponser;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import java.util.UUID;

public class NotificationRequest extends BleServerRequest implements NotificationListener {
    private String mBleMac;
    private byte[] mBytes;
    private UUID mCharacterUUID;

    public NotificationRequest(String str, UUID uuid, byte[] bArr, BleServerResponser bleServerResponser) {
        super(str, bleServerResponser);
        this.mCharacterUUID = uuid;
        this.mBytes = bArr;
        this.mBleMac = str;
    }

    public long getTimeoutInMillis() {
        return 20000;
    }

    public void onNotificationSent(int i) {
        stopRequestTiming();
        onRequestCompleted(i);
    }

    public void processRequest() {
        if (!isConnected(this.mBleMac)) {
            onRequestCompleted(-101);
        } else if (!sendNotification(this.mBleMac, this.mCharacterUUID, this.mBytes)) {
            BluetoothLog.error("NotificationRequest", "sendNotification fail!", new Object[0]);
            onRequestCompleted(-1);
        } else {
            startRequestTiming();
        }
    }
}
