package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class p0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebChromeClientHostApi f7402a;

    public /* synthetic */ p0(GeneratedAndroidWebView.WebChromeClientHostApi webChromeClientHostApi) {
        this.f7402a = webChromeClientHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.WebChromeClientHostApi.lambda$setup$2(this.f7402a, obj, reply);
    }
}
