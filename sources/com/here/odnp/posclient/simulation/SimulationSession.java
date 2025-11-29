package com.here.odnp.posclient.simulation;

import android.util.Log;
import com.here.odnp.posclient.CloseableSession;
import com.here.odnp.posclient.PosClientManager;
import com.here.odnp.posclient.simulation.ISimulationSession;
import com.here.posclient.PositionEstimate;
import com.here.posclient.StatusCallback;
import com.here.posclient.UpdateOptions;

public class SimulationSession extends CloseableSession implements ISimulationSession {
    private static final String TAG = "odnp.posclient.SimulationSession";

    public SimulationSession(PosClientManager posClientManager) {
        super(posClientManager);
    }

    public boolean continueSimulation(Object[] objArr, StatusCallback statusCallback) {
        return this.mPosClientManager.continueSimulation(objArr, statusCallback);
    }

    public void onClose() {
        if (!this.mPosClientManager.removeSimulationSession(this)) {
            Log.w(TAG, "onClose: session is not set");
        }
    }

    public void onOpen() {
        this.mPosClientManager.addSimulationSession(this);
    }

    public boolean startSimulation(ISimulationSession.Listener listener, PositionEstimate positionEstimate, Object[] objArr, UpdateOptions updateOptions) {
        return this.mPosClientManager.startSimulation(listener, positionEstimate, objArr, updateOptions);
    }

    public void stopSimulation() {
        this.mPosClientManager.stopSimulation();
    }
}
