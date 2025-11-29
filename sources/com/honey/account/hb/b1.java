package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class b1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebSettingsHostApi f7343a;

    public /* synthetic */ b1(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi) {
        this.f7343a = webSettingsHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.WebSettingsHostApi.lambda$setup$12(this.f7343a, obj, reply);
    }
}
