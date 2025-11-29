package com.upuphone.xr.interconnect.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface FunctionType {
    public static final int TYPE_CONNECT_WIFI_REQUEST = 9;
    public static final int TYPE_CONNECT_WIFI_RESPONSE = 10;
    public static final int TYPE_DATA_BINDER_UPDATE = 15;
    public static final int TYPE_DATA_BINDER_UPDATE_REQUEST = 16;
    public static final int TYPE_DEVICE_INFO_REQUEST = 5;
    public static final int TYPE_DEVICE_INFO_RESPONSE = 6;
    public static final int TYPE_NOTIFY_CHANNEL_CHANGE = 4;
    public static final int TYPE_NOTIFY_CLIENT_DIED = 1;
    public static final int TYPE_NOTIFY_FILE_RECEIVED = 0;
    public static final int TYPE_OPEN_STARRY_NET_APP_REQUEST = 11;
    public static final int TYPE_OPEN_STARRY_NET_APP_RESPONSE = 12;
    public static final int TYPE_RESOURCE_OPEN_REQUEST = 17;
    public static final int TYPE_RUNNING_TASK_ACTION_REQUEST = 19;
    public static final int TYPE_SYNC_TIME_REQUEST = 2;
    public static final int TYPE_SYNC_TIME_RESPONSE = 3;
    public static final int TYPE_TASK_EXECUTION_REQUEST = 18;
    public static final int TYPE_WIFI_INFO_REQUEST = 7;
    public static final int TYPE_WIFI_INFO_RESPONSE = 8;
}
