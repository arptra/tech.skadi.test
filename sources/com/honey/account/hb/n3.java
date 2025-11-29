package com.honey.account.hb;

import android.webkit.ValueCallback;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import io.flutter.plugins.webviewflutter.WebChromeClientHostApiImpl;
import java.util.List;

public final /* synthetic */ class n3 implements GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f7396a;
    public final /* synthetic */ ValueCallback b;

    public /* synthetic */ n3(boolean z, ValueCallback valueCallback) {
        this.f7396a = z;
        this.b = valueCallback;
    }

    public final void reply(Object obj) {
        WebChromeClientHostApiImpl.WebChromeClientImpl.lambda$onShowFileChooser$5(this.f7396a, this.b, (List) obj);
    }
}
