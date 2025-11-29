package com.honey.account.l6;

import android.net.Uri;
import com.upuphone.runasone.share.api.IHubUupShareStatusCallbackAdapter;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IHubUupShareStatusCallbackAdapter f4928a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Uri c;
    public final /* synthetic */ Uri d;

    public /* synthetic */ c(IHubUupShareStatusCallbackAdapter iHubUupShareStatusCallbackAdapter, String str, Uri uri, Uri uri2) {
        this.f4928a = iHubUupShareStatusCallbackAdapter;
        this.b = str;
        this.c = uri;
        this.d = uri2;
    }

    public final void run() {
        this.f4928a.lambda$adapt$2(this.b, this.c, this.d);
    }
}
