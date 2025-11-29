package com.here.posclient;

import android.os.Bundle;

public class FingerprintStats {
    public long cleanUpCounterGnss;
    public long cleanUpCounterNonGnss;
    public long gnssFingerprintCount;
    public boolean isActiveCollectionEnabled;
    public boolean isAutoUploadEnabled;
    public boolean isCrowdsourcingEnabled;
    public long lastFailTime;
    public long lastSuccessTime;
    public long nonGnssFingerprintCount;
    public boolean wasLastUploadSuccess;
    public boolean wasSuccessWifi;

    public static FingerprintStats fromBundle(Bundle bundle) {
        FingerprintStats fingerprintStats = new FingerprintStats();
        if (bundle == null) {
            return fingerprintStats;
        }
        fingerprintStats.isCrowdsourcingEnabled = bundle.getBoolean("isCrowdsourcingEnabled");
        fingerprintStats.isActiveCollectionEnabled = bundle.getBoolean("isActiveCollectionEnabled");
        fingerprintStats.isAutoUploadEnabled = bundle.getBoolean("isAutoUploadEnabled");
        fingerprintStats.wasSuccessWifi = bundle.getBoolean("wasSuccessWifi");
        fingerprintStats.wasLastUploadSuccess = bundle.getBoolean("wasLastUploadSuccess");
        fingerprintStats.gnssFingerprintCount = bundle.getLong("gnssFingerprintCount");
        fingerprintStats.nonGnssFingerprintCount = bundle.getLong("nonGnssFingerprintCount");
        fingerprintStats.lastSuccessTime = bundle.getLong("lastSuccessTime");
        fingerprintStats.lastFailTime = bundle.getLong("lastFailTime");
        fingerprintStats.cleanUpCounterGnss = bundle.getLong("cleanUpCounterGnss");
        fingerprintStats.cleanUpCounterNonGnss = bundle.getLong("cleanUpCounterNonGnss");
        return fingerprintStats;
    }

    public Bundle asBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isCrowdsourcingEnabled", this.isCrowdsourcingEnabled);
        bundle.putBoolean("isActiveCollectionEnabled", this.isActiveCollectionEnabled);
        bundle.putBoolean("isAutoUploadEnabled", this.isAutoUploadEnabled);
        bundle.putBoolean("wasSuccessWifi", this.wasSuccessWifi);
        bundle.putBoolean("wasLastUploadSuccess", this.wasLastUploadSuccess);
        bundle.putLong("gnssFingerprintCount", this.gnssFingerprintCount);
        bundle.putLong("nonGnssFingerprintCount", this.nonGnssFingerprintCount);
        bundle.putLong("lastSuccessTime", this.lastSuccessTime);
        bundle.putLong("lastFailTime", this.lastFailTime);
        bundle.putLong("cleanUpCounterGnss", this.cleanUpCounterGnss);
        bundle.putLong("cleanUpCounterNonGnss", this.cleanUpCounterNonGnss);
        return bundle;
    }
}
