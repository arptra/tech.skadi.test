package com.here.posclient.crowdsource.hd;

public interface IActivityEventDispatcher {
    void onDailyQuotaReached();

    void onDataUploadStarted();

    void onDataUploadStopped(long j);

    void onSensorUseStarted();

    void onSensorUseStopped();

    void onWifiScanStarted(long j);

    void onWifiScanStopped();
}
