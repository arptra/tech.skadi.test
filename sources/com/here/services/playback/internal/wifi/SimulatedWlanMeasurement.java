package com.here.services.playback.internal.wifi;

import com.here.annotations.SuppressFBWarnings;
import com.here.odnp.wifi.IWifiManager;
import com.here.posclient.WifiMeasurement;

public class SimulatedWlanMeasurement {
    private final long mMeasurementId;
    private final WifiMeasurement[] mMeasurements;
    private final long mTimeStamp;

    public SimulatedWlanMeasurement(long j, IWifiManager.WifiScanResultContainer wifiScanResultContainer) {
        this.mMeasurementId = wifiScanResultContainer.measurementId;
        this.mTimeStamp = j;
        this.mMeasurements = (WifiMeasurement[]) wifiScanResultContainer.scanResultList.toArray(new WifiMeasurement[0]);
    }

    public long getId() {
        return this.mMeasurementId;
    }

    @SuppressFBWarnings({"EI_EXPOSE_REP"})
    public WifiMeasurement[] getMeasurementArray() {
        return this.mMeasurements;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }
}
