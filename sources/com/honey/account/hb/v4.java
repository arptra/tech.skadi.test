package com.honey.account.hb;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import io.flutter.plugins.webviewflutter.InstanceManager;

public final /* synthetic */ class v4 implements InstanceManager.FinalizationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BinaryMessenger f7429a;

    public /* synthetic */ v4(BinaryMessenger binaryMessenger) {
        this.f7429a = binaryMessenger;
    }

    public final void onFinalize(long j) {
        new GeneratedAndroidWebView.JavaObjectFlutterApi(this.f7429a).dispose(Long.valueOf(j), new u4());
    }
}
