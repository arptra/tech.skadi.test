package com.upuphone.xr.interconnect.api;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Keep
@Retention(RetentionPolicy.CLASS)
public @interface DeviceBondState {
    public static final int STATE_BONDED = 2;
    public static final int STATE_BONDING = 1;
    public static final int STATE_UN_BOND = 0;
}
