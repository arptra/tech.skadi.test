package com.honey.account.hb;

import io.flutter.plugins.webviewflutter.JavaScriptChannel;

public final /* synthetic */ class z2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JavaScriptChannel f7446a;
    public final /* synthetic */ String b;

    public /* synthetic */ z2(JavaScriptChannel javaScriptChannel, String str) {
        this.f7446a = javaScriptChannel;
        this.b = str;
    }

    public final void run() {
        this.f7446a.lambda$postMessage$1(this.b);
    }
}
