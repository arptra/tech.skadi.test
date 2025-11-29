package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class v0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebSettingsHostApi f7426a;

    public /* synthetic */ v0(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi) {
        this.f7426a = webSettingsHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.WebSettingsHostApi.lambda$setup$6(this.f7426a, obj, reply);
    }
}
