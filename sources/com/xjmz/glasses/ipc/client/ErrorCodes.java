package com.xjmz.glasses.ipc.client;

import com.upuphone.runasone.channel.linker.starrystack.XdpNetStackManager;
import com.upuphone.starrynet.strategy.SysActionManager;

public enum ErrorCodes {
    SUCCESS(0, "success"),
    SERVICE_UNAVAILABLE(-100, "service unavailable"),
    HID_UNINITIALIZED(-1000, "HID uninitialized"),
    HID_XREAL_NOT_SUPPORT(XdpNetStackManager.LOAD_ERROR, "xreal not support"),
    UNKNOWN(SysActionManager.USER_NULL, "unknown error");
    
    private final int mCode;
    private final String mMessage;

    private ErrorCodes(int i, String str) {
        this.mCode = i;
        this.mMessage = str;
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public static String getMessage(int i) {
        for (ErrorCodes errorCodes : values()) {
            if (errorCodes.mCode == i) {
                return errorCodes.mMessage;
            }
        }
        return UNKNOWN.mMessage;
    }
}
