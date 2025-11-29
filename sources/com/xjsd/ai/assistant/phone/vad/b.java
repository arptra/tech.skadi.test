package com.xjsd.ai.assistant.phone.vad;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VadDetector f8615a;
    public final /* synthetic */ byte[] b;

    public /* synthetic */ b(VadDetector vadDetector, byte[] bArr) {
        this.f8615a = vadDetector;
        this.b = bArr;
    }

    public final void run() {
        this.f8615a.lambda$feedToFspEngine$5(this.b);
    }
}
