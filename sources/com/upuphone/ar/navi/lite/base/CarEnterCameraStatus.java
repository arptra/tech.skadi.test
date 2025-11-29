package com.upuphone.ar.navi.lite.base;

import java.io.Serializable;

public class CarEnterCameraStatus implements Serializable {
    public static final int ENTER = 2;
    public static final int LEAVE = 3;
    public static final int UNENTER = 1;
    public static final int UNKNOWN = 0;

    private CarEnterCameraStatus() {
    }
}
