package com.upuphone.star.core.log;

import androidx.exifinterface.media.ExifInterface;

public class LogLevel {
    public static String a(int i) {
        if (i == 2) {
            return "VERBOSE";
        }
        if (i == 3) {
            return "DEBUG";
        }
        if (i == 4) {
            return "INFO";
        }
        if (i == 5) {
            return "WARN";
        }
        if (i == 6) {
            return "ERROR";
        }
        if (i < 2) {
            return "VERBOSE-" + (2 - i);
        }
        return "ERROR+" + (i - 6);
    }

    public static String b(int i) {
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
