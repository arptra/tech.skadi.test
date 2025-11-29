package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class c1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebSettingsHostApi f7347a;

    public /* synthetic */ c1(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi) {
        this.f7347a = webSettingsHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.WebSettingsHostApi.lambda$setup$13(this.f7347a, obj, reply);
    }
}
