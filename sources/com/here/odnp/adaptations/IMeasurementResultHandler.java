package com.here.odnp.adaptations;

import com.here.posclient.CellMeasurement;
import com.here.posclient.CellularStatus;
import com.here.posclient.GnssStatus;
import com.here.posclient.MeasurementType;
import com.here.posclient.PositionEstimate;
import com.here.posclient.Status;
import com.here.posclient.WifiMeasurement;
import com.here.posclient.WifiStatus;

public interface IMeasurementResultHandler {
    void handleAndroidGnssStatus(long j, Object obj);

    void handleCellularScanResult(CellMeasurement cellMeasurement, boolean z);

    void handleCellularStatusChange(CellularStatus cellularStatus);

    void handleGnssLocationUpdate(PositionEstimate positionEstimate, boolean z);

    void handleGnssMeasurements(Object obj);

    void handleGnssStatus(GnssStatus gnssStatus);

    void handleRequestError(MeasurementType measurementType, Status status);

    void handleWifiScanResult(long j, WifiMeasurement[] wifiMeasurementArr, boolean z, boolean z2);

    void handleWifiStateChanged(WifiStatus wifiStatus);
}
