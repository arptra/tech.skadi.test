package com.here.posclient;

import com.here.odnp.posclient.test.IPosClientTesterSession;

public class CrowdsourcingTest {
    private CrowdsourcingTest() {
    }

    public static native void dumpFingerprints();

    public static native boolean getActiveCollection();

    public static native boolean getAutoUpload();

    public static native boolean getCollectionStatus();

    public static native int getFingerprintStats(FingerprintStats fingerprintStats);

    public static native long getGnssFingerprintCount();

    public static native long getNonGnssFingerprintCount();

    public static native void overrideConfiguration(String str);

    public static native void sendFingerprints();

    public static native boolean setActiveCollection(boolean z);

    public static native boolean setAutoUpload(boolean z);

    public static native void setUsername(String str);

    public static native boolean startHDWifiStateMonitoring(IPosClientTesterSession.HDWifiStateListener hDWifiStateListener);

    public static native void stopHDWifiStateMonitoring(IPosClientTesterSession.HDWifiStateListener hDWifiStateListener);
}
