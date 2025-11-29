package com.geetest.sdk;

import android.app.Dialog;

public abstract class GT3Listener implements GT3BaseListener, NoProguard {
    public void actionAfterDialogShow(Dialog dialog) {
    }

    public void actionBeforeDialogShow(Dialog dialog) {
    }

    public void onDialogReady(String str) {
    }

    public void onDialogResult(String str) {
    }

    public void onWindowFocusChanged(Dialog dialog, boolean z) {
    }
}
