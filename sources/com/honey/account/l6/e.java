package com.honey.account.l6;

import com.upuphone.runasone.share.api.IHubUupShareStatusCallbackAdapter;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IHubUupShareStatusCallbackAdapter f4930a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ int d;

    public /* synthetic */ e(IHubUupShareStatusCallbackAdapter iHubUupShareStatusCallbackAdapter, String str, boolean z, int i) {
        this.f4930a = iHubUupShareStatusCallbackAdapter;
        this.b = str;
        this.c = z;
        this.d = i;
    }

    public final void run() {
        this.f4930a.lambda$adapt$4(this.b, this.c, this.d);
    }
}
