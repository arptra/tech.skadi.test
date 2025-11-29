package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class r implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.HttpAuthHandlerHostApi f7409a;

    public /* synthetic */ r(GeneratedAndroidWebView.HttpAuthHandlerHostApi httpAuthHandlerHostApi) {
        this.f7409a = httpAuthHandlerHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.HttpAuthHandlerHostApi.lambda$setup$1(this.f7409a, obj, reply);
    }
}
