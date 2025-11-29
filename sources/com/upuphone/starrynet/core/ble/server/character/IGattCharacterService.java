package com.upuphone.starrynet.core.ble.server.character;

import java.util.List;

public interface IGattCharacterService extends IGattCharacter {
    List<IGattCharacteristic> getGattCharacteristic();

    int getServiceType();
}
