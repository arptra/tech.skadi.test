package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class j implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.DownloadListenerHostApi f7374a;

    public /* synthetic */ j(GeneratedAndroidWebView.DownloadListenerHostApi downloadListenerHostApi) {
        this.f7374a = downloadListenerHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.DownloadListenerHostApi.lambda$setup$0(this.f7374a, obj, reply);
    }
}
