package com.here.odnp.cell;

import com.here.posclient.CellMeasurement;
import com.here.posclient.CellularStatus;

public interface ICellManager {

    public interface ICellListener {
        void onCellMeasurementChanged(CellMeasurement cellMeasurement);

        void onCellScanFailed();

        void onCellularStatusChanged(CellularStatus cellularStatus);
    }

    void cancelCellScan();

    void close();

    boolean isCellNeighborSupported();

    boolean isCellSupported();

    void open(ICellListener iCellListener);

    boolean startCellScan();
}
