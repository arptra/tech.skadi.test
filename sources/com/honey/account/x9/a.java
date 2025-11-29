package com.honey.account.x9;

import com.xjsd.ai.assistant.asr.engine.AsrEngine;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AsrEngine f7681a;

    public /* synthetic */ a(AsrEngine asrEngine) {
        this.f7681a = asrEngine;
    }

    public final void run() {
        this.f7681a.stopRecognize();
    }
}
