package com.upuphone.runasone.relay.lib.utils.log;

import androidx.exifinterface.media.ExifInterface;

public class LogLevel {
    public static final int ALL = Integer.MIN_VALUE;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int NONE = Integer.MAX_VALUE;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    public static String getShortLevelName(int i) {
        if (i == 2) {
            return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        }
        if (i == 3) {
            return "D";
        }
        if (i == 4) {
            return "I";
        }
        if (i == 5) {
            return ExifInterface.LONGITUDE_WEST;
        }
        if (i == 6) {
            return ExifInterface.LONGITUDE_EAST;
        }
        if (i < 2) {
            return "V-" + (2 - i);
        }
        return "E+" + (i - 6);
    }
}
