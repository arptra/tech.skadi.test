package com.dexterous.flutterlocalnotifications.utils;

import androidx.annotation.Keep;

@Keep
public class BooleanUtils {
    public static boolean getValue(Boolean bool) {
        return bool != null && bool.booleanValue();
    }
}
