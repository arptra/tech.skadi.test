package com.here.posclient;

import android.util.SparseArray;

public enum Status {
    StatusInProgress(-1),
    Ok(0),
    GeneralError(1),
    InternalError(2),
    OomError(3),
    NotFoundError(4),
    AlreadyExistsError(5),
    UsageError(6),
    NotSupportedError(7),
    BusyError(8),
    TimeoutError(9),
    ConversionError(10),
    InvalidArgumentError(11),
    InputOutputError(12),
    ConnectionError(13),
    DataTransferError(14),
    CancelError(15),
    VersionMismatch(16),
    DataCorrupted(17),
    InjectionRejectedForCepError(18),
    InjectionRejectedError(19),
    NoConnectionFoundError(20),
    RadiomapDisabledError(21),
    NotEnabledError(22),
    InjectError(23),
    NoCoverageError(24),
    NoRadioMapError(25),
    NoQuotaError(26),
    TemporarilyNotAllowedError(27),
    SessionClosedError(10022);
    
    private static SparseArray<Status> mLookupTable;
    private static final Object mLookupTableLock = null;
    private final int mStatusCode;

    static {
        int i;
        mLookupTableLock = new Object();
        mLookupTable = new SparseArray<>();
        for (Status status : values()) {
            mLookupTable.append(status.mStatusCode, status);
        }
    }

    private Status(int i) {
        this.mStatusCode = i;
    }

    public static Status fromInt(int i) {
        Status status = mLookupTable.get(i);
        if (status != null) {
            return status;
        }
        throw new RuntimeException("Unknown status: " + i);
    }

    public int toInt() {
        return this.mStatusCode;
    }
}
