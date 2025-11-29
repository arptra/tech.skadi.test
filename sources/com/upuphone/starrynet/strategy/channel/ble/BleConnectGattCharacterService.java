package com.upuphone.starrynet.strategy.channel.ble;

import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.server.character.IGattCharacterService;
import com.upuphone.starrynet.core.ble.server.character.IGattCharacteristic;
import com.upuphone.starrynet.core.ble.server.handler.ICharacterHandler;
import com.upuphone.starrynet.core.ble.server.handler.IMultipleCharacterHandler;
import com.upuphone.starrynet.strategy.StarryNetData;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BleConnectGattCharacterService implements IGattCharacterService {
    private final List<IGattCharacteristic> mCharacters = new ArrayList();

    public static class CharacterConfig {
        public UUID characterUUID;
        public ICharacterHandler handler;
        public boolean isSupportMultiplePacket;
        public int permissions;
        public int properties;

        public CharacterConfig(UUID uuid, int i, int i2, boolean z, ICharacterHandler iCharacterHandler) {
            this.characterUUID = uuid;
            this.properties = i;
            this.permissions = i2;
            this.handler = iCharacterHandler;
            this.isSupportMultiplePacket = z;
        }
    }

    public BleConnectGattCharacterService(ICharacterHandler iCharacterHandler, IMultipleCharacterHandler iMultipleCharacterHandler) {
        ArrayList<CharacterConfig> arrayList = new ArrayList<>();
        arrayList.add(new CharacterConfig(BluetoothConstants.STARRY_NET_READ_UUID, 2, 1, false, iCharacterHandler));
        arrayList.add(new CharacterConfig(BluetoothConstants.STARRY_NET_WRITE_UUID, 8, 16, false, iCharacterHandler));
        arrayList.add(new CharacterConfig(BluetoothConstants.STARRY_NET_MULTI_WRITE_UUID, 20, 16, true, iMultipleCharacterHandler));
        arrayList.add(new CharacterConfig(BluetoothConstants.STARRY_NET_READ_CONFIG_UUID, 18, 1, false, (ICharacterHandler) null));
        arrayList.add(new CharacterConfig(BluetoothConstants.STARRY_NET_WRITE_MESSAGE_UUID, 20, 16, false, iCharacterHandler));
        if (StarryNetData.getInstance().isAR()) {
            arrayList.add(new CharacterConfig(BluetoothConstants.STARRY_NET_GLASS_WRITE_UUID, 2, 1, false, iCharacterHandler));
        }
        for (final CharacterConfig characterConfig : arrayList) {
            this.mCharacters.add(new IGattCharacteristic() {
                public ICharacterHandler getHandler() {
                    return characterConfig.handler;
                }

                public int getPermissions() {
                    return characterConfig.permissions;
                }

                public int getProperties() {
                    return characterConfig.properties;
                }

                public UUID getUUID() {
                    return characterConfig.characterUUID;
                }

                public boolean isSupportMultiplePacket() {
                    return characterConfig.isSupportMultiplePacket;
                }
            });
        }
    }

    public List<IGattCharacteristic> getGattCharacteristic() {
        return this.mCharacters;
    }

    public int getServiceType() {
        return 0;
    }

    public UUID getUUID() {
        return BluetoothConstants.STARRY_NET_SERVICE_UUID;
    }
}
