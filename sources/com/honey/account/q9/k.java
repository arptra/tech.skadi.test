package com.honey.account.q9;

import com.xjmz.myvu.dialog.starrynet.StarryNetConnectDialog;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarryNetConnectDialog f7508a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ k(StarryNetConnectDialog starryNetConnectDialog, String str, boolean z) {
        this.f7508a = starryNetConnectDialog;
        this.b = str;
        this.c = z;
    }

    public final void run() {
        StarryNetConnectDialog.C(this.f7508a, this.b, this.c);
    }
}
