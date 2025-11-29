package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class n0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebChromeClientHostApi f7393a;

    public /* synthetic */ n0(GeneratedAndroidWebView.WebChromeClientHostApi webChromeClientHostApi) {
        this.f7393a = webChromeClientHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.WebChromeClientHostApi.lambda$setup$0(this.f7393a, obj, reply);
    }
}
