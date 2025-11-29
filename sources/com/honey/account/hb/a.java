package com.honey.account.hb;

import android.webkit.ValueCallback;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class a implements ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.Result f7338a;

    public /* synthetic */ a(GeneratedAndroidWebView.Result result) {
        this.f7338a = result;
    }

    public final void onReceiveValue(Object obj) {
        this.f7338a.success((Boolean) obj);
    }
}
