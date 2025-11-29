package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class i0 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply f7370a;

    public /* synthetic */ i0(GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply reply) {
        this.f7370a = reply;
    }

    public final void reply(Object obj) {
        this.f7370a.reply((String) obj);
    }
}
