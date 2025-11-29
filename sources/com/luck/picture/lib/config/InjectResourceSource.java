package com.luck.picture.lib.config;

import android.content.Context;
import com.luck.picture.lib.interfaces.OnInjectLayoutResourceListener;

public final class InjectResourceSource {
    public static int a(Context context, int i, SelectorConfig selectorConfig) {
        OnInjectLayoutResourceListener onInjectLayoutResourceListener;
        if (selectorConfig == null || (onInjectLayoutResourceListener = selectorConfig.e1) == null) {
            return 0;
        }
        return onInjectLayoutResourceListener.a(context, i);
    }
}
