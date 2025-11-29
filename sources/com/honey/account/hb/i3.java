package com.honey.account.hb;

import android.webkit.JsResult;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import io.flutter.plugins.webviewflutter.WebChromeClientHostApiImpl;

public final /* synthetic */ class i3 implements GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JsResult f7373a;

    public /* synthetic */ i3(JsResult jsResult) {
        this.f7373a = jsResult;
    }

    public final void reply(Object obj) {
        WebChromeClientHostApiImpl.WebChromeClientImpl.lambda$onJsConfirm$9(this.f7373a, (Boolean) obj);
    }
}
