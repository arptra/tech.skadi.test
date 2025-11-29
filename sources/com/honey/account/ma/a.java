package com.honey.account.ma;

import com.xjsd.ai.assistant.phone.vad.OpusDecoder;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f7462a;
    public final /* synthetic */ byte[] b;

    public /* synthetic */ a(Function1 function1, byte[] bArr) {
        this.f7462a = function1;
        this.b = bArr;
    }

    public final void run() {
        OpusDecoder.d(this.f7462a, this.b);
    }
}
