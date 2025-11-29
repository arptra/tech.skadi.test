package com.here.odnp.wifi;

import com.here.posclient.WifiMeasurement;
import java.util.List;

public interface IWifiFilter {
    WifiMeasurement[] getFilteredMeasurements();

    void reset();

    void setInitialMeasurements(List<WifiMeasurement> list);

    void updateMeasurements(List<WifiMeasurement> list);
}
