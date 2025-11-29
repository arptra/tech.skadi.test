package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class r0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebChromeClientHostApi f7410a;

    public /* synthetic */ r0(GeneratedAndroidWebView.WebChromeClientHostApi webChromeClientHostApi) {
        this.f7410a = webChromeClientHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.WebChromeClientHostApi.lambda$setup$4(this.f7410a, obj, reply);
    }
}
