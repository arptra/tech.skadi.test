package com.here.odnp.posclient.simulation;

import com.here.posclient.PositionEstimate;
import com.here.posclient.StatusCallback;
import com.here.posclient.UpdateOptions;
import java.util.List;

public interface ISimulationSession {

    public interface Listener {
        void onFinished(int i, List<PositionEstimate> list);

        void onProgressUpdated(int i);
    }

    boolean continueSimulation(Object[] objArr, StatusCallback statusCallback);

    boolean startSimulation(Listener listener, PositionEstimate positionEstimate, Object[] objArr, UpdateOptions updateOptions);

    void stopSimulation();
}
