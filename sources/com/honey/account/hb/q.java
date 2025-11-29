package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class q implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.HttpAuthHandlerHostApi f7405a;

    public /* synthetic */ q(GeneratedAndroidWebView.HttpAuthHandlerHostApi httpAuthHandlerHostApi) {
        this.f7405a = httpAuthHandlerHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.HttpAuthHandlerHostApi.lambda$setup$0(this.f7405a, obj, reply);
    }
}
