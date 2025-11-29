package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class x implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.JavaScriptChannelHostApi f7435a;

    public /* synthetic */ x(GeneratedAndroidWebView.JavaScriptChannelHostApi javaScriptChannelHostApi) {
        this.f7435a = javaScriptChannelHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.JavaScriptChannelHostApi.lambda$setup$0(this.f7435a, obj, reply);
    }
}
