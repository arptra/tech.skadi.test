package com.upuphone.starrynet.strategy.channel.uup;

import com.upuphone.starrynet.core.ble.server.character.IGattCharacterService;
import com.upuphone.starrynet.core.ble.server.character.IGattCharacteristic;
import com.upuphone.starrynet.core.ble.server.handler.ICharacterHandler;
import com.upuphone.starrynet.strategy.utils.BleUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UupShareConnectGattCharacterService implements IGattCharacterService {
    private final List<IGattCharacteristic> mCharacters;

    public UupShareConnectGattCharacterService(final ICharacterHandler iCharacterHandler) {
        ArrayList arrayList = new ArrayList();
        this.mCharacters = arrayList;
        arrayList.add(new IGattCharacteristic() {
            public ICharacterHandler getHandler() {
                return iCharacterHandler;
            }

            public int getPermissions() {
                return 1;
            }

            public int getProperties() {
                return 2;
            }

            public UUID getUUID() {
                return BleUtil.UUP_SHARE_READ_UUID.getUuid();
            }

            public boolean isSupportMultiplePacket() {
                return false;
            }
        });
        arrayList.add(new IGattCharacteristic() {
            public ICharacterHandler getHandler() {
                return iCharacterHandler;
            }

            public int getPermissions() {
                return 16;
            }

            public int getProperties() {
                return 8;
            }

            public UUID getUUID() {
                return BleUtil.UUP_SHARE_WRITE_UUID.getUuid();
            }

            public boolean isSupportMultiplePacket() {
                return false;
            }
        });
    }

    public List<IGattCharacteristic> getGattCharacteristic() {
        return this.mCharacters;
    }

    public int getServiceType() {
        return 0;
    }

    public UUID getUUID() {
        return BleUtil.UUP_SHARE_CONNECT_SERVICE_UUID.getUuid();
    }
}
