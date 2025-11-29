package com.here.odnp.posclient;

import android.content.Context;
import android.os.Bundle;
import com.here.odnp.posclient.analytics.IUsageTrackingSession;
import com.here.odnp.posclient.auth.IAuthSession;
import com.here.odnp.posclient.consent.IConsentSession;
import com.here.odnp.posclient.hd.IHdCrowdsourceSession;
import com.here.odnp.posclient.pos.IPositioningSession;
import com.here.odnp.posclient.rmm.IRmDownloadSession;
import com.here.odnp.posclient.simulation.ISimulationSession;
import com.here.odnp.posclient.test.IPosClientTesterSession;
import com.here.odnp.posclient.upload.IUploadSession;
import com.here.posclient.ClientConfiguration;
import com.here.posclient.PositioningFeature;
import com.here.posclient.RadioMapManager;
import com.here.posclient.Status;

public interface IPosClientManager {
    void close();

    IAuthSession createAuthSession();

    IConsentSession createConsentSession();

    IHdCrowdsourceSession createHdCrowdsourceSession();

    IPositioningSession createPositionerSession(IPositioningSession.ILocationListener iLocationListener);

    IRmDownloadSession createRmDownloaderSession(RadioMapManager.IRadioMapStorageActionListener iRadioMapStorageActionListener);

    ISimulationSession createSimulationSession();

    IPosClientTesterSession createTesterSession();

    IUploadSession createUploadSession();

    IUsageTrackingSession createUsageTrackingSession();

    ClientConfiguration getClientConfiguration();

    Context getContext();

    void positioningConsentRevoked();

    Status toggleFeature(PositioningFeature positioningFeature, boolean z);

    boolean updateOptions(Bundle bundle);
}
