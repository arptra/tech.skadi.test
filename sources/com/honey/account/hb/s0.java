package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class s0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebChromeClientHostApi f7414a;

    public /* synthetic */ s0(GeneratedAndroidWebView.WebChromeClientHostApi webChromeClientHostApi) {
        this.f7414a = webChromeClientHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.WebChromeClientHostApi.lambda$setup$5(this.f7414a, obj, reply);
    }
}
