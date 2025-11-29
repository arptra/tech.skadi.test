package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class t1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebViewClientHostApi f7419a;

    public /* synthetic */ t1(GeneratedAndroidWebView.WebViewClientHostApi webViewClientHostApi) {
        this.f7419a = webViewClientHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.WebViewClientHostApi.lambda$setup$0(this.f7419a, obj, reply);
    }
}
