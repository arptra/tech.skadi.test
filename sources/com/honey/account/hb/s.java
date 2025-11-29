package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class s implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.HttpAuthHandlerHostApi f7413a;

    public /* synthetic */ s(GeneratedAndroidWebView.HttpAuthHandlerHostApi httpAuthHandlerHostApi) {
        this.f7413a = httpAuthHandlerHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.HttpAuthHandlerHostApi.lambda$setup$2(this.f7413a, obj, reply);
    }
}
