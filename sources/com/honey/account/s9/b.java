package com.honey.account.s9;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler;

public final /* synthetic */ class b implements InterconnectManager.OnStarrySdkStateChangeListener {
    public final void onStateChanged(boolean z) {
        StarryNetApiHandler.Companion.c(z);
    }
}
