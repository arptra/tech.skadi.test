package com.here.services.test.fingerprint;

import com.here.posclient.FingerprintStats;
import com.here.posclient.Status;
import com.here.services.HereLocationApiClient;

public interface FingerprintCollectionTestApi {

    public interface StatsListener {
        void onGetStatsCompleted(Status status, FingerprintStats fingerprintStats);
    }

    void dumpFingerprints(HereLocationApiClient hereLocationApiClient);

    boolean getActiveCollection(HereLocationApiClient hereLocationApiClient);

    boolean getAutoUpload(HereLocationApiClient hereLocationApiClient);

    Status getCollectionStats(HereLocationApiClient hereLocationApiClient, StatsListener statsListener);

    boolean getCollectionStatus(HereLocationApiClient hereLocationApiClient);

    long getGnssFingerprintCount(HereLocationApiClient hereLocationApiClient);

    long getNonGnssFingerprintCount(HereLocationApiClient hereLocationApiClient);

    void sendFingerprints(HereLocationApiClient hereLocationApiClient);

    boolean setActiveCollection(HereLocationApiClient hereLocationApiClient, boolean z);

    boolean setAutoUpload(HereLocationApiClient hereLocationApiClient, boolean z);

    void setUsername(HereLocationApiClient hereLocationApiClient, String str);
}
