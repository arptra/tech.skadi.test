package com.honey.account.l6;

import android.net.Uri;
import com.upuphone.runasone.share.api.IHubUupShareStatusCallbackAdapter;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IHubUupShareStatusCallbackAdapter f4927a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Uri d;

    public /* synthetic */ b(IHubUupShareStatusCallbackAdapter iHubUupShareStatusCallbackAdapter, String str, int i, Uri uri) {
        this.f4927a = iHubUupShareStatusCallbackAdapter;
        this.b = str;
        this.c = i;
        this.d = uri;
    }

    public final void run() {
        this.f4927a.lambda$adapt$1(this.b, this.c, this.d);
    }
}
