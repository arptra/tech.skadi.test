package com.xjsd.ai.assistant.phone.vad;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VadDetector f8618a;
    public final /* synthetic */ OfflineAsrResult b;

    public /* synthetic */ e(VadDetector vadDetector, OfflineAsrResult offlineAsrResult) {
        this.f8618a = vadDetector;
        this.b = offlineAsrResult;
    }

    public final void run() {
        this.f8618a.lambda$onOfflineAsrResult$0(this.b);
    }
}
