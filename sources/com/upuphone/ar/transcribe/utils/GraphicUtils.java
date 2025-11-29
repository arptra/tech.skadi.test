package com.upuphone.ar.transcribe.utils;

import android.content.res.Resources;

public class GraphicUtils {
    public static int a(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }
}
