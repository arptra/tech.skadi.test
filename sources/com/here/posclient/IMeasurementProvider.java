package com.here.posclient;

public interface IMeasurementProvider {
    void cancelCellularScan();

    void cancelWifiScan();

    PositionEstimate getLastKnownPosition();

    int requestCurrentWlanList();

    boolean startCellularScan();

    int startGnss();

    int startGnssMeasurements();

    boolean startWifiScan();

    void stopGnss();

    void stopGnssMeasurements();

    int subscribe(int i);

    int supportedCellMeasurementTypes();

    int supportedMeasurementTypes();

    void unsubscribe(int i);
}
