package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class o0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebChromeClientHostApi f7398a;

    public /* synthetic */ o0(GeneratedAndroidWebView.WebChromeClientHostApi webChromeClientHostApi) {
        this.f7398a = webChromeClientHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.WebChromeClientHostApi.lambda$setup$1(this.f7398a, obj, reply);
    }
}
