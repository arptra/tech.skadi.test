package com.honey.account.hb;

import android.webkit.JsResult;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class m3 implements GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JsResult f7391a;

    public /* synthetic */ m3(JsResult jsResult) {
        this.f7391a = jsResult;
    }

    public final void reply(Object obj) {
        this.f7391a.confirm();
    }
}
