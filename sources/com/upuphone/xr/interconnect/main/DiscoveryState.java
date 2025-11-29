package com.upuphone.xr.interconnect.main;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Keep
@Retention(RetentionPolicy.CLASS)
public @interface DiscoveryState {
    public static final int DISCOVERY_STARTED = 1;
    public static final int DISCOVERY_STOPPED = 0;
}
