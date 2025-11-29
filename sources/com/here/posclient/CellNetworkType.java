package com.here.posclient;

public enum CellNetworkType {
    CELL_NW_TYPE_UNKNOWN(0),
    CELL_NW_TYPE_GERAN(1),
    CELL_NW_TYPE_GERAN_NB(2),
    CELL_NW_TYPE_UTRA_FDD(4),
    CELL_NW_TYPE_UTRA_FDD_NB(8),
    CELL_NW_TYPE_UTRA_TDD(16),
    CELL_NW_TYPE_UTRA_TDD_NB(32),
    CELL_NW_TYPE_EUTRA(64),
    CELL_NW_TYPE_EUTRA_NB(128),
    CELL_NW_TYPE_CDMA(256),
    CELL_NW_TYPE_CDMA_NB(512),
    CELL_NW_TYPE_NR(1024),
    CELL_NW_TYPE_NR_NB(2048),
    CELL_NW_TYPE_ALL_GSM_SERVING(r0.value | r2.value | r4.value | r7.value | r6.value),
    CELL_NW_TYPE_ALL_GSM_NEIGHBOR(r1.value | r3.value | r5.value | r8.value | r9.value);
    
    public final int value;

    private CellNetworkType(int i) {
        this.value = i;
    }
}
