package com.here.services.location.internal;

import android.location.Location;
import com.here.posclient.PositioningFeature;
import com.here.posclient.UpdateOptions;
import com.here.posclient.sensors.GeneralActivityResult;
import com.here.services.common.PositioningError;
import com.here.services.internal.Manager;

public interface IPositioning extends Manager {

    public interface IPositionListener {
        void onOptionsChanged(UpdateOptions updateOptions, UpdateOptions updateOptions2);

        void onPositionInfoChanged(PositioningError positioningError);

        void onPositionResolvingFailed(PositioningError positioningError);

        void onPositionUpdate(Location location);

        void onSessionClosed();
    }

    int availableFeatures();

    void clearPositioningData();

    void close();

    int enabledFeatures();

    Location getLastPosition();

    boolean injectActivity(GeneralActivityResult generalActivityResult);

    boolean injectLocation(Location location);

    boolean requestSingleUpdate(Options options, IPositionListener iPositionListener);

    boolean startInjectionUpdates(IPositionListener iPositionListener);

    boolean startPositionUpdates(Options options, IPositionListener iPositionListener);

    void stopPositionUpdates(IPositionListener iPositionListener);

    void toggleFeature(PositioningFeature positioningFeature, boolean z);
}
