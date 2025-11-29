package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class g1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebSettingsHostApi f7363a;

    public /* synthetic */ g1(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi) {
        this.f7363a = webSettingsHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.WebSettingsHostApi.lambda$setup$3(this.f7363a, obj, reply);
    }
}
