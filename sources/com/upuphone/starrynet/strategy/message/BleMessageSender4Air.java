package com.upuphone.starrynet.strategy.message;

import com.upuphone.starrynet.core.ble.BluetoothConstants;
import java.util.UUID;

public class BleMessageSender4Air extends BleMessageSenderV2 {
    public BleMessageSender4Air() {
        super(BluetoothConstants.STARRY_NET_AIR_EXTERNAL_MESSAGE_UUID, (UUID) null, BluetoothConstants.STARRY_NET_AIR_INTERNAL_MESSAGE_UUID);
    }

    public void prepareMessage(StarryMessage starryMessage) {
        this.messageHandler.prepareAirMessage(starryMessage);
    }
}
