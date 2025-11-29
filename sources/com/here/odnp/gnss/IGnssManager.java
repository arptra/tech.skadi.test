package com.here.odnp.gnss;

import android.location.Location;
import com.here.posclient.GnssStatus;
import com.here.posclient.Status;

public interface IGnssManager {

    public interface IGnnsListener {
        void onGnssLocationChanged(Location location, boolean z);

        void onGnssMeasurementsReceived(Object obj);

        void onGnssStatusChanged(GnssStatus gnssStatus);

        void onGnssStatusReceived(long j, Object obj);
    }

    Location getLastKnownGnssLocation();

    Location getLastKnownLocation();

    boolean isGnssSupported();

    Status startGnss();

    Status startGnssMeasurements();

    boolean startListening(IGnnsListener iGnnsListener, long j) throws IllegalArgumentException;

    void stopGnss();

    void stopGnssMeasurements();

    void stopListening();
}
