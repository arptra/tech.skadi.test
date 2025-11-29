package com.honey.account.o2;

import android.content.DialogInterface;
import android.webkit.SslErrorHandler;
import com.honey.account.view.web.WebActivity;
import com.honey.account.view.web.WebActivity$onCreate$2$2;

public final /* synthetic */ class d implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SslErrorHandler f9218a;
    public final /* synthetic */ WebActivity b;

    public /* synthetic */ d(SslErrorHandler sslErrorHandler, WebActivity webActivity) {
        this.f9218a = sslErrorHandler;
        this.b = webActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        WebActivity$onCreate$2$2.onReceivedSslError$lambda$0(this.f9218a, this.b, dialogInterface, i);
    }
}
