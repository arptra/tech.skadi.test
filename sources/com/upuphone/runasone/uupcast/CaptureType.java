package com.upuphone.runasone.uupcast;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface CaptureType {
    public static final int CAPTURE_AUDIO_WITHOUT_ENCODE = 256;
    public static final int CAPTURE_ICCOA_VIRTUAL_DISPLAY = Integer.MIN_VALUE;
    public static final int CAPTURE_OPEN_STATISTICS_MODE = 1073741824;
    public static final int CAPTURE_TYPE_AUDIO = 32;
    public static final int CAPTURE_TYPE_AUDIO_DIVIDED_WITHOUT_ENCODE = 32768;
    public static final int CAPTURE_TYPE_CAMERA = 8;
    public static final int CAPTURE_TYPE_CAMERA_VIDEO = 16;
    public static final int CAPTURE_TYPE_DUMMY_SOURCE = 4096;
    public static final int CAPTURE_TYPE_ICCOA = 67108864;
    public static final int CAPTURE_TYPE_MULTI_SINK = 2;
    public static final int CAPTURE_TYPE_RAW_VIDEO = 8192;
    public static final int CAPTURE_TYPE_VIRTUAL_DISPLAY = 1;
    public static final int CAPTURE_TYPE_VIRTUAL_DISPLAY_3RD = 512;
    public static final int CAPTURE_TYPE_VIRTUAL_DISPLAY_3RD_VIDEO = 1024;
    public static final int CAPTURE_TYPE_VIRTUAL_DISPLAY_ALPHA = 16384;
    public static final int CAPTURE_TYPE_VIRTUAL_DISPLAY_FULL_RATE = 128;
    public static final int CAPTURE_TYPE_VIRTUAL_DISPLAY_FULL_RATE_VIDEO = 2048;
    public static final int CAPTURE_TYPE_VIRTUAL_DISPLAY_VIDEO = 4;
    public static final int CAPTURE_VIRTUAL_DISPLAY_ENABLE_MAGIC_WINDOW = 134217728;
    public static final int CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED = 268435456;
    public static final int CAPTURE_WITH_MULTI_VIDEO = 536870912;
}
