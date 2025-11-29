package com.here.services.radiomap.internal;

import com.here.posclient.RadioMapManager;
import com.here.services.radiomap.common.GeoArea;

public interface IRmmPosClientManager {
    void close();

    boolean startRadioMapQuery(RadioMapManager.RadioMapQueryAction radioMapQueryAction, long j, GeoArea[] geoAreaArr, int i, RadioMapManager.IRadioMapStorageActionListener iRadioMapStorageActionListener);

    boolean startRadioMapUpdate(RadioMapManager.RadioMapStorageAction radioMapStorageAction, long j, GeoArea[] geoAreaArr, int i, long j2, RadioMapManager.IRadioMapStorageActionListener iRadioMapStorageActionListener);

    void stopRadioMapActions(RadioMapManager.IRadioMapStorageActionListener iRadioMapStorageActionListener);
}
