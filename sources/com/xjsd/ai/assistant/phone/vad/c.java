package com.xjsd.ai.assistant.phone.vad;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VadDetector f8616a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ VadEventListener c;

    public /* synthetic */ c(VadDetector vadDetector, byte[] bArr, VadEventListener vadEventListener) {
        this.f8616a = vadDetector;
        this.b = bArr;
        this.c = vadEventListener;
    }

    public final void run() {
        this.f8616a.lambda$onData$1(this.b, this.c);
    }
}
