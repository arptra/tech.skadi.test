package com.honey.account.q5;

import com.upuphone.runasone.channel.linker.bt.BtServer;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BtServer f5113a;
    public final /* synthetic */ String b;
    public final /* synthetic */ byte[] c;

    public /* synthetic */ a(BtServer btServer, String str, byte[] bArr) {
        this.f5113a = btServer;
        this.b = str;
        this.c = bArr;
    }

    public final void run() {
        this.f5113a.lambda$startAuth$0(this.b, this.c);
    }
}
