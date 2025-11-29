package com.upuphone.starrynet.core.ble.server;

import com.upuphone.starrynet.core.ble.server.character.IGattCharacterService;
import com.upuphone.starrynet.core.ble.server.listener.GattServerResponseListener;
import java.util.UUID;

public interface IBleServer {
    void addServices(IGattCharacterService iGattCharacterService);

    void clearGattServerResponseListener(GattServerResponseListener gattServerResponseListener);

    void disconnect();

    boolean isCharacterNotify(String str, UUID uuid);

    boolean isConnected(String str);

    boolean isServerOpened();

    void openServer();

    void registerGattServerResponseListener(GattServerResponseListener gattServerResponseListener);

    boolean sendNotification(String str, UUID uuid, byte[] bArr);
}
