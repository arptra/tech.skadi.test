package com.here.odnp.posclient.pos;

import android.location.Location;
import com.here.odnp.posclient.ICloseableSession;
import com.here.posclient.PositioningFeature;
import com.here.posclient.Status;
import com.here.posclient.UpdateOptions;
import com.here.posclient.sensors.GeneralActivityResult;
import com.here.services.common.PositioningError;

public interface IPositioningSession extends ICloseableSession {
    public static final int INVALID_REQUEST_ID = Integer.MIN_VALUE;

    public interface ILocationListener {
        void onClosed();

        void onLocationChanged(Location location);

        void onLocationInfoChanged(PositioningError positioningError);

        void onLocationResolvingFailed(PositioningError positioningError);

        void onOptionsChanged(UpdateOptions updateOptions, UpdateOptions updateOptions2);
    }

    public interface StatusListener {
        void onRequestCompleted(int i, Status status);
    }

    int availableFeatures();

    void clearData(int i);

    int enabledFeatures();

    Location getLastPosition();

    UpdateOptions getUpdateOptions();

    boolean injectActivity(GeneralActivityResult generalActivityResult);

    boolean injectLocation(Location location);

    boolean isOfflineModeSet();

    void onNetworkLocationDisabled(boolean z);

    void onNetworkLocationEnabled();

    void positioningConsentRevoked();

    void requestLastPosition();

    void requestPosition();

    boolean requestSingleUpdate(UpdateOptions updateOptions);

    void resetMeasurements();

    void setOfflineMode(boolean z);

    int setUpdateOptions(UpdateOptions updateOptions);

    int setUpdateOptions(UpdateOptions updateOptions, StatusListener statusListener);

    boolean startInjectionUpdates();

    boolean startPositionUpdates();

    void stopPositionUpdates();

    void toggleFeature(PositioningFeature positioningFeature, boolean z);
}
