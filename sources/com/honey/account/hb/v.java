package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class v implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.JavaObjectHostApi f7425a;

    public /* synthetic */ v(GeneratedAndroidWebView.JavaObjectHostApi javaObjectHostApi) {
        this.f7425a = javaObjectHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.JavaObjectHostApi.lambda$setup$0(this.f7425a, obj, reply);
    }
}
