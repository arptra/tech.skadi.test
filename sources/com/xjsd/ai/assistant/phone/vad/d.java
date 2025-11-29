package com.xjsd.ai.assistant.phone.vad;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VadEventListener f8617a;
    public final /* synthetic */ String b;

    public /* synthetic */ d(VadEventListener vadEventListener, String str) {
        this.f8617a = vadEventListener;
        this.b = str;
    }

    public final void run() {
        this.f8617a.d(this.b);
    }
}
