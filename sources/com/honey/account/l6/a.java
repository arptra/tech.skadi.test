package com.honey.account.l6;

import com.upuphone.runasone.share.api.IHubUupShareStatusCallbackAdapter;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IHubUupShareStatusCallbackAdapter f4926a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ a(IHubUupShareStatusCallbackAdapter iHubUupShareStatusCallbackAdapter, String str, String str2) {
        this.f4926a = iHubUupShareStatusCallbackAdapter;
        this.b = str;
        this.c = str2;
    }

    public final void run() {
        this.f4926a.lambda$adapt$0(this.b, this.c);
    }
}
