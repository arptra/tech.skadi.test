package com.honey.account.w8;

import android.content.Context;
import com.upuphone.xr.sapp.utils.WebViewPool;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f7648a;
    public final /* synthetic */ WebViewPool b;

    public /* synthetic */ j(Context context, WebViewPool webViewPool) {
        this.f7648a = context;
        this.b = webViewPool;
    }

    public final void run() {
        WebViewPool.h(this.f7648a, this.b);
    }
}
