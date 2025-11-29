package com.honey.account.hb;

import android.webkit.JsPromptResult;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import io.flutter.plugins.webviewflutter.WebChromeClientHostApiImpl;

public final /* synthetic */ class l3 implements GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JsPromptResult f7386a;

    public /* synthetic */ l3(JsPromptResult jsPromptResult) {
        this.f7386a = jsPromptResult;
    }

    public final void reply(Object obj) {
        WebChromeClientHostApiImpl.WebChromeClientImpl.lambda$onJsPrompt$10(this.f7386a, (String) obj);
    }
}
