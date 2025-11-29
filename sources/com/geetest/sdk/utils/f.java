package com.geetest.sdk.utils;

import android.content.Context;
import com.upuphone.starrynet.common.StarryNetConstant;

public class f {
    public static String a(Context context) {
        return context == null ? StarryNetConstant.DEVICE_NAME_UNKNOWN : context.getPackageName();
    }

    public static int b(Context context) {
        return context == null ? 0 : 4040100;
    }
}
