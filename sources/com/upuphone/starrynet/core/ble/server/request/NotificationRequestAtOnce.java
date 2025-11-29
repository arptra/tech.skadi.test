package com.upuphone.starrynet.core.ble.server.request;

import com.upuphone.starrynet.core.ble.server.reponse.BleServerResponser;
import java.util.UUID;

public class NotificationRequestAtOnce extends NotificationRequest {
    public NotificationRequestAtOnce(String str, UUID uuid, byte[] bArr, BleServerResponser bleServerResponser) {
        super(str, uuid, bArr, bleServerResponser);
    }
}
