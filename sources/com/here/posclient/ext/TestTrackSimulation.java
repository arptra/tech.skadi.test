package com.here.posclient.ext;

import com.here.odnp.posclient.simulation.ISimulationSession;
import com.here.posclient.PositionEstimate;
import com.here.posclient.UpdateOptions;

public class TestTrackSimulation {
    public static native int continueSimulation(Object[] objArr);

    public static native int startSimulation(ISimulationSession.Listener listener, PositionEstimate positionEstimate, Object[] objArr, UpdateOptions updateOptions);

    public static native void stopSimulation();
}
