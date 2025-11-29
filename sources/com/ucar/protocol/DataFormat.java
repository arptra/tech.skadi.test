package com.ucar.protocol;

public enum DataFormat {
    RAW(0),
    PB3(1),
    RAW_NO_ENCRYPTED(2);
    
    private final int mValue;

    private DataFormat(int i) {
        this.mValue = i;
    }

    public static DataFormat ofValue(int i) {
        DataFormat dataFormat = PB3;
        if (i == dataFormat.mValue) {
            return dataFormat;
        }
        DataFormat dataFormat2 = RAW_NO_ENCRYPTED;
        return i == dataFormat2.mValue ? dataFormat2 : RAW;
    }

    public final int getValue() {
        return this.mValue;
    }
}
