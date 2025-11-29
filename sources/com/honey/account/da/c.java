package com.honey.account.da;

import com.xjsd.ai.assistant.flutter.util.OpusEncoder;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OpusEncoder f7221a;
    public final /* synthetic */ byte[] b;

    public /* synthetic */ c(OpusEncoder opusEncoder, byte[] bArr) {
        this.f7221a = opusEncoder;
        this.b = bArr;
    }

    public final void run() {
        OpusEncoder.d(this.f7221a, this.b);
    }
}
