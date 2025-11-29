package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class d implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.CookieManagerHostApi f7349a;

    public /* synthetic */ d(GeneratedAndroidWebView.CookieManagerHostApi cookieManagerHostApi) {
        this.f7349a = cookieManagerHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.CookieManagerHostApi.lambda$setup$1(this.f7349a, obj, reply);
    }
}
