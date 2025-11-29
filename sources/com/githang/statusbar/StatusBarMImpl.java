package com.githang.statusbar;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import com.upuphone.runasone.uupcast.CaptureType;

class StatusBarMImpl implements IStatusBar {
    public void a(Window window, int i) {
        window.clearFlags(CaptureType.CAPTURE_TYPE_ICCOA);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i);
        View findViewById = window.findViewById(16908290);
        if (findViewById != null) {
            findViewById.setForeground((Drawable) null);
        }
    }
}
