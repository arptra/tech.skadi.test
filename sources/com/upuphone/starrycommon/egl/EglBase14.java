package com.upuphone.starrycommon.egl;

import android.annotation.TargetApi;
import android.os.Build;
import com.upuphone.starrycommon.egl.EglBase;

@TargetApi(18)
public class EglBase14 extends EglBase {
    public static final int g = Build.VERSION.SDK_INT;

    public static class Context extends EglBase.Context {
    }
}
