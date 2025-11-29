package com.githang.statusbar;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.upuphone.runasone.uupcast.CaptureType;

class StatusBarKitkatImpl implements IStatusBar {
    public void a(Window window, int i) {
        window.addFlags(CaptureType.CAPTURE_TYPE_ICCOA);
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        View findViewWithTag = viewGroup.findViewWithTag("ghStatusBarView");
        if (findViewWithTag == null) {
            findViewWithTag = new StatusBarView(window.getContext());
            findViewWithTag.setTag("ghStatusBarView");
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 48;
            findViewWithTag.setLayoutParams(layoutParams);
            viewGroup.addView(findViewWithTag);
        }
        findViewWithTag.setBackgroundColor(i);
        StatusBarCompat.a(window, true);
    }
}
