package com.here.services.playback.internal.cell;

import com.here.odnp.cell.ICellManager;
import com.here.odnp.util.Log;

public class NullCellManager implements ICellManager {
    private static final String TAG = "services.playback.internal.cell.NullCellManager";

    public NullCellManager() {
        Log.v(TAG, "NullCellManager", new Object[0]);
    }

    public void cancelCellScan() {
    }

    public void close() {
    }

    public boolean isCellNeighborSupported() {
        return true;
    }

    public boolean isCellSupported() {
        return true;
    }

    public void open(ICellManager.ICellListener iCellListener) {
    }

    public boolean startCellScan() {
        return false;
    }
}
