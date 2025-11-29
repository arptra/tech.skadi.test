package com.upuphone.xr.interconnect.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.CLASS)
public @interface ConnectionState {
    public static final int STATE_INIT = -1;
    public static final int STATE_P2P_GC_CONNECTED = 4;
    public static final int STATE_P2P_GC_DISCONNECTED = 5;
    public static final int STATE_P2P_GO_CONNECTED = 1;
    public static final int STATE_P2P_GO_CRATED = 0;
    public static final int STATE_P2P_GO_DISCONNECTED = 2;
    public static final int STATE_P2P_GO_REMOVED = 3;
}
