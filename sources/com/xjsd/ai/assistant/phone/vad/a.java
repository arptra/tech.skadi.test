package com.xjsd.ai.assistant.phone.vad;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f8614a;
    public final /* synthetic */ VadEventListener b;

    public /* synthetic */ a(int i, VadEventListener vadEventListener) {
        this.f8614a = i;
        this.b = vadEventListener;
    }

    public final void run() {
        VadDetector.lambda$notifyVadEventListener$4(this.f8614a, this.b);
    }
}
