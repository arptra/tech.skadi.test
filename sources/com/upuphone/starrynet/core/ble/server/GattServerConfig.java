package com.upuphone.starrynet.core.ble.server;

import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.server.character.IGattCharacterService;
import java.util.ArrayList;
import java.util.List;

public class GattServerConfig {
    private static final String TAG = "GattServerConfig";
    private final List<IGattCharacterService> mServices = new ArrayList();

    public boolean addGattService(IGattCharacterService iGattCharacterService) {
        StLog.d(TAG, "addGattService " + iGattCharacterService.getUUID());
        if (this.mServices.size() != 0) {
            for (IGattCharacterService uuid : this.mServices) {
                if (uuid.getUUID().equals(iGattCharacterService.getUUID())) {
                    return false;
                }
            }
        }
        this.mServices.add(iGattCharacterService);
        return true;
    }

    public List<IGattCharacterService> getGattService() {
        return this.mServices;
    }
}
