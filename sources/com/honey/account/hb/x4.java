package com.honey.account.hb;

import android.webkit.ValueCallback;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class x4 implements ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.Result f7439a;

    public /* synthetic */ x4(GeneratedAndroidWebView.Result result) {
        this.f7439a = result;
    }

    public final void onReceiveValue(Object obj) {
        this.f7439a.success((String) obj);
    }
}
