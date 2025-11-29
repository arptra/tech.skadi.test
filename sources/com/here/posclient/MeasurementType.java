package com.here.posclient;

import com.here.posclient.PositionEstimate;

public enum MeasurementType {
    MSMTYPE_UNKNOWN(0),
    MSMTYPE_CELLULAR(1),
    MSMTYPE_WLAN(2),
    MSMTYPE_GNSS(4),
    MSMTYPE_CACHED_WLAN(64),
    MSMTYPE_ACTIVITY(128),
    MSMTYPE_ACCELERATION(256),
    MSMTYPE_BAROMETER(512),
    MSMTYPE_GNSS_OBSERVATION(16384),
    MSMTYPE_STATUS(PositionEstimate.Value.SITUATION),
    MSMTYPE_CELLULAR_STATUS(r0.value | r3.value),
    MSMTYPE_WLAN_STATUS(r1.value | r3.value),
    MSMTYPE_GNSS_STATUS(r2.value | r3.value),
    MSMTYPE_ALL(Integer.MAX_VALUE);
    
    public final int value;

    private MeasurementType(int i) {
        this.value = i;
    }

    public static MeasurementType fromInt(int i) {
        for (MeasurementType measurementType : values()) {
            if (measurementType.toInt() == i) {
                return measurementType;
            }
        }
        return MSMTYPE_UNKNOWN;
    }

    public int toInt() {
        return this.value;
    }
}
