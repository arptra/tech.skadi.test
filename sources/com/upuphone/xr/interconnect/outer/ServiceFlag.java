package com.upuphone.xr.interconnect.outer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.CLASS)
public @interface ServiceFlag {
    public static final int SERVICE_ACCOUNT_ABILITY = 14;
    public static final int SERVICE_APP_MANAGE = 9;
    public static final int SERVICE_DATA_BINDER = 15;
    public static final int SERVICE_DEVICE_INFO_MANAGER = 11;
    public static final int SERVICE_DEVICE_MANAGER = 0;
    public static final int SERVICE_DIALER_MANAGER = 13;
    public static final int SERVICE_DLNA_SERVER = 7;
    public static final int SERVICE_FILE_TRANSPORT = 1;
    public static final int SERVICE_GROUP_MESSAGE_TRANSPORT = 5;
    public static final int SERVICE_MESSAGE_TRANSPORT = 2;
    public static final int SERVICE_NAVI_ABILITY = 10;
    public static final int SERVICE_RESOURCE_MANAGER = 17;
    public static final int SERVICE_SAPP_ABILITY = 8;
    public static final int SERVICE_TASK_MANAGER = 16;
    public static final int SERVICE_TRANS_ABILITY = 18;
    public static final int SERVICE_VOLUME_CHANGE_CONTROLLER = 6;
    public static final int SERVICE_WIFI_MANAGER = 12;
}
