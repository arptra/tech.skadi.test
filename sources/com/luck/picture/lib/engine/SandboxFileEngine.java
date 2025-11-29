package com.luck.picture.lib.engine;

import android.content.Context;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnCallbackIndexListener;

@Deprecated
public interface SandboxFileEngine {
    void a(Context context, boolean z, int i, LocalMedia localMedia, OnCallbackIndexListener onCallbackIndexListener);
}
