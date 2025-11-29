package com.here.services.playback.internal.gnss;

import android.location.Location;
import com.here.odnp.gnss.IGnssManager;
import com.here.odnp.util.Log;
import com.here.posclient.GnssStatus;
import com.here.posclient.Status;
import com.here.services.playback.internal.util.PlaybackReader;

public class PlaybackGnssManager implements IGnssManager {
    private static final String TAG = "services.playback.internal.gnss.PlaybackGnssManager";
    private IGnssManager.IGnnsListener mGnssListener;
    /* access modifiers changed from: private */
    public Location mLastKnownLocation;
    private final PlaybackReader mPlaybackReader;

    public class GnssListenerProxy implements IGnssManager.IGnnsListener {
        private final IGnssManager.IGnnsListener mRealListener;

        public GnssListenerProxy(IGnssManager.IGnnsListener iGnnsListener) {
            this.mRealListener = iGnnsListener;
        }

        public void onGnssLocationChanged(Location location, boolean z) {
            Location unused = PlaybackGnssManager.this.mLastKnownLocation = location;
            this.mRealListener.onGnssLocationChanged(location, z);
        }

        public void onGnssMeasurementsReceived(Object obj) {
            this.mRealListener.onGnssMeasurementsReceived(obj);
        }

        public void onGnssStatusChanged(GnssStatus gnssStatus) {
            this.mRealListener.onGnssStatusChanged(gnssStatus);
        }

        public void onGnssStatusReceived(long j, Object obj) {
            this.mRealListener.onGnssStatusReceived(j, obj);
        }
    }

    public PlaybackGnssManager(PlaybackReader playbackReader) {
        this.mPlaybackReader = playbackReader;
    }

    public Location getLastKnownGnssLocation() {
        return this.mLastKnownLocation;
    }

    public Location getLastKnownLocation() {
        return null;
    }

    public boolean isGnssSupported() {
        return true;
    }

    public Status startGnss() {
        return this.mPlaybackReader.startGnss() ? Status.Ok : Status.GeneralError;
    }

    public Status startGnssMeasurements() {
        return Status.NotSupportedError;
    }

    public synchronized boolean startListening(IGnssManager.IGnnsListener iGnnsListener, long j) {
        if (iGnnsListener == null) {
            Log.w(TAG, "startListening: listener is null -> ignored", new Object[0]);
            return false;
        }
        stopListening();
        GnssListenerProxy gnssListenerProxy = new GnssListenerProxy(iGnnsListener);
        this.mGnssListener = gnssListenerProxy;
        this.mPlaybackReader.addGnssListener(gnssListenerProxy);
        return true;
    }

    public void stopGnss() {
        this.mPlaybackReader.stopGnss();
    }

    public void stopGnssMeasurements() {
    }

    public synchronized void stopListening() {
        IGnssManager.IGnnsListener iGnnsListener = this.mGnssListener;
        if (iGnnsListener != null) {
            this.mPlaybackReader.removeGnssListener(iGnnsListener);
            this.mGnssListener = null;
        }
    }
}
