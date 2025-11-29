package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.List;

public final /* synthetic */ class d0 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply f7350a;

    public /* synthetic */ d0(GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply reply) {
        this.f7350a = reply;
    }

    public final void reply(Object obj) {
        this.f7350a.reply((List) obj);
    }
}
