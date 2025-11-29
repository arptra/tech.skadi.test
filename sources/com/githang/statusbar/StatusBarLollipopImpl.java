package com.githang.statusbar;

import android.view.Window;
import com.upuphone.runasone.uupcast.CaptureType;

class StatusBarLollipopImpl implements IStatusBar {
    public void a(Window window, int i) {
        window.clearFlags(CaptureType.CAPTURE_TYPE_ICCOA);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i);
    }
}
