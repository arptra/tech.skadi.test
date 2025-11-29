package com.upuphone.starrynet.core.ble.server;

import androidx.core.util.Consumer;
import com.upuphone.starrynet.core.ble.server.character.IGattCharacterService;
import com.upuphone.starrynet.core.ble.server.reponse.BleNotificationResponse;
import com.upuphone.starrynet.core.ble.server.reponse.OpenServerResponse;
import java.util.List;
import java.util.UUID;

public interface IBleConnectManager {
    void addServices(IGattCharacterService iGattCharacterService);

    void disconnect(String str);

    void init(GattServerConfig gattServerConfig);

    void isCharacterNotify(String str, UUID uuid, Consumer<Boolean> consumer);

    void openServer(OpenServerResponse openServerResponse);

    void sendBatchNotifications(String str, UUID uuid, List<byte[]> list, BleNotificationResponse bleNotificationResponse);

    void sendNotification(String str, UUID uuid, byte[] bArr, BleNotificationResponse bleNotificationResponse);

    void sendNotificationAtOnce(String str, UUID uuid, byte[] bArr, BleNotificationResponse bleNotificationResponse);
}
