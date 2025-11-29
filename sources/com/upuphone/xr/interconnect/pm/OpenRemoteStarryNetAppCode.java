package com.upuphone.xr.interconnect.pm;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Keep
@Retention(RetentionPolicy.CLASS)
public @interface OpenRemoteStarryNetAppCode {
    public static final int CODE_NO_DEVICE = 501;
    public static final int CODE_NO_STARRY_NET_APP_ID_ERROR = 602;
    public static final int CODE_PULL_MAIN_APP_FAIL = 503;
    public static final int CODE_SEND_MESSAGE_FAIL = 504;
    public static final int CODE_STARRY_NET_APP_ID_ERROR = 601;
    public static final int CODE_STARRY_SDK_NOT_AVAILABLE = 502;
    public static final int CODE_SUCCESS = 200;
}
