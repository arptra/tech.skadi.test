package com.here.odnp.posclient.rmm;

import com.here.odnp.posclient.ICloseableSession;
import com.here.posclient.RadioMapManager;
import com.here.services.radiomap.common.GeoArea;

public interface IRmDownloadSession extends ICloseableSession {
    boolean startRadioMapQuery(RadioMapManager.RadioMapQueryAction radioMapQueryAction, long j, GeoArea[] geoAreaArr, int i);

    void stopRadioMapUpdate();

    boolean updateRadioMapCoverage(RadioMapManager.RadioMapStorageAction radioMapStorageAction, long j, GeoArea[] geoAreaArr, int i, long j2);
}
