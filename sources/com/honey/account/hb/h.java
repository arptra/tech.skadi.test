package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class h implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.CustomViewCallbackHostApi f7365a;

    public /* synthetic */ h(GeneratedAndroidWebView.CustomViewCallbackHostApi customViewCallbackHostApi) {
        this.f7365a = customViewCallbackHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.CustomViewCallbackHostApi.lambda$setup$0(this.f7365a, obj, reply);
    }
}
