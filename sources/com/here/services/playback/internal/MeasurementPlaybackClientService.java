package com.here.services.playback.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.here.odnp.posclient.IPosClientManager;
import com.here.odnp.util.Log;
import com.here.services.internal.IBoundService;
import com.here.services.playback.internal.IMeasurementPlaybackClient;

public class MeasurementPlaybackClientService extends IMeasurementPlaybackClient.Stub implements IBoundService {
    private static final String TAG = "services.playback.internal.MeasurementPlaybackClientService";
    private final PosClientPlaybackManager mPosClientPlaybackManager;

    public MeasurementPlaybackClientService(IPosClientManager iPosClientManager, Intent intent) {
        Log.v(TAG, "PositioningTestClientService", new Object[0]);
        this.mPosClientPlaybackManager = PosClientPlaybackManager.create(iPosClientManager);
    }

    public boolean startNetworkMeasurementPlayback(Bundle bundle) throws RemoteException {
        Log.v(TAG, "startNetworkMeasurementPlayback", new Object[0]);
        return this.mPosClientPlaybackManager.startNetworkMeasurementPlayback(bundle);
    }

    public boolean startSimulation(ITestTrackSimulationListener iTestTrackSimulationListener, Bundle bundle) throws RemoteException {
        Log.v(TAG, "startSimulation", new Object[0]);
        return this.mPosClientPlaybackManager.startSimulation(iTestTrackSimulationListener, bundle);
    }

    public void stopNetworkMeasurementPlayback() throws RemoteException {
        this.mPosClientPlaybackManager.stopNetworkMeasurementPlayback();
    }

    public void stopSimulation() throws RemoteException {
        Log.v(TAG, "stopSimulation", new Object[0]);
        this.mPosClientPlaybackManager.stopSimulation();
    }

    public void unBind() {
        Log.v(TAG, "unBind", new Object[0]);
        this.mPosClientPlaybackManager.close();
    }
}
