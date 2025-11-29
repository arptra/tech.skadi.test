package com.here.services.location.internal;

import android.location.Location;
import com.here.odnp.posclient.pos.IPositioningSession;
import com.here.posclient.UpdateOptions;
import com.here.posclient.sensors.GeneralActivityResult;

public interface ISdkPosClientManager {
    int availableFeatures();

    int enabledFeatures();

    Location getLastPosition();

    boolean injectActivity(GeneralActivityResult generalActivityResult);

    boolean injectLocation(Location location);

    void positioningConsentRevoked();

    boolean requestSingleUpdate(UpdateOptions updateOptions, IPositioningSession.ILocationListener iLocationListener);

    boolean startInjectionUpdates();

    boolean startLocationUpdates(UpdateOptions updateOptions);

    void stopLocationUpdates();

    void toggleFeature(String str, boolean z);
}
