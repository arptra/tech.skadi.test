package com.honey.account.n1;

import com.google.android.material.motion.MaterialBackOrchestrator;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialBackOrchestrator f9781a;

    public /* synthetic */ c(MaterialBackOrchestrator materialBackOrchestrator) {
        this.f9781a = materialBackOrchestrator;
    }

    public final void run() {
        this.f9781a.startListeningForBackCallbacksWithPriorityOverlay();
    }
}
