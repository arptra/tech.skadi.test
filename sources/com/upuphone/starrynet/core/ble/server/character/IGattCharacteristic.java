package com.upuphone.starrynet.core.ble.server.character;

import com.upuphone.starrynet.core.ble.server.handler.ICharacterHandler;

public interface IGattCharacteristic extends IGattCharacter {
    ICharacterHandler getHandler();

    int getPermissions();

    int getProperties();

    boolean isSupportMultiplePacket();
}
