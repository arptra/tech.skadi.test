package com.xjsd.ai.assistant.phone.vad;

import androidx.core.util.Consumer;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VadDetector f8620a;

    public /* synthetic */ g(VadDetector vadDetector) {
        this.f8620a = vadDetector;
    }

    public final void accept(Object obj) {
        this.f8620a.onOfflineAsrResult((OfflineAsrResult) obj);
    }
}
