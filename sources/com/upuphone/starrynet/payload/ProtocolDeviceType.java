package com.upuphone.starrynet.payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ProtocolDeviceType {
    public static final int HID_DEVICE = 2;
    public static final int RING = 1;
}
