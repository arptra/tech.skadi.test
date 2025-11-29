package com.honey.account.h0;

import androidx.window.layout.SidecarWindowBackend;
import androidx.window.layout.WindowLayoutInfo;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SidecarWindowBackend.WindowLayoutChangeCallbackWrapper f3055a;
    public final /* synthetic */ WindowLayoutInfo b;

    public /* synthetic */ d(SidecarWindowBackend.WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper, WindowLayoutInfo windowLayoutInfo) {
        this.f3055a = windowLayoutChangeCallbackWrapper;
        this.b = windowLayoutInfo;
    }

    public final void run() {
        SidecarWindowBackend.WindowLayoutChangeCallbackWrapper.c(this.f3055a, this.b);
    }
}
