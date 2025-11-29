package com.honey.account.l6;

import com.upuphone.runasone.share.api.IHubUupShareStatusCallbackAdapter;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IHubUupShareStatusCallbackAdapter f4929a;
    public final /* synthetic */ String b;

    public /* synthetic */ d(IHubUupShareStatusCallbackAdapter iHubUupShareStatusCallbackAdapter, String str) {
        this.f4929a = iHubUupShareStatusCallbackAdapter;
        this.b = str;
    }

    public final void run() {
        this.f4929a.lambda$adapt$3(this.b);
    }
}
