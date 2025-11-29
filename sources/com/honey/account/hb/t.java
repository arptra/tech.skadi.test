package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class t implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.InstanceManagerHostApi f7417a;

    public /* synthetic */ t(GeneratedAndroidWebView.InstanceManagerHostApi instanceManagerHostApi) {
        this.f7417a = instanceManagerHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.InstanceManagerHostApi.lambda$setup$0(this.f7417a, obj, reply);
    }
}
