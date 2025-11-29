package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class t0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebSettingsHostApi f7418a;

    public /* synthetic */ t0(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi) {
        this.f7418a = webSettingsHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.WebSettingsHostApi.lambda$setup$0(this.f7418a, obj, reply);
    }
}
