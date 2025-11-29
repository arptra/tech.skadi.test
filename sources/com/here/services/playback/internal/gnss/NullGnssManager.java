package com.here.services.playback.internal.gnss;

import android.location.Location;
import com.here.odnp.gnss.IGnssManager;
import com.here.odnp.util.Log;
import com.here.posclient.Status;

public class NullGnssManager implements IGnssManager {
    private static final String TAG = "services.playback.internal.gnss.NullGnssManager";

    public NullGnssManager() {
        Log.v(TAG, "NullGnssManager", new Object[0]);
    }

    public Location getLastKnownGnssLocation() {
        return null;
    }

    public Location getLastKnownLocation() {
        return null;
    }

    public boolean isGnssSupported() {
        return true;
    }

    public Status startGnss() {
        return Status.Ok;
    }

    public Status startGnssMeasurements() {
        return Status.Ok;
    }

    public synchronized boolean startListening(IGnssManager.IGnnsListener iGnnsListener, long j) {
        return true;
    }

    public void stopGnss() {
    }

    public void stopGnssMeasurements() {
    }

    public synchronized void stopListening() {
    }
}
