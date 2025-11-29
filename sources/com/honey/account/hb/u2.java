package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class u2 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebViewHostApi f7424a;

    public /* synthetic */ u2(GeneratedAndroidWebView.WebViewHostApi webViewHostApi) {
        this.f7424a = webViewHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.WebViewHostApi.lambda$setup$16(this.f7424a, obj, reply);
    }
}
