package com.honey.account.ca;

import com.xjsd.ai.assistant.flutter.AndroidAssistantApiHandler;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAssistantApiHandler f7206a;

    public /* synthetic */ n(AndroidAssistantApiHandler androidAssistantApiHandler) {
        this.f7206a = androidAssistantApiHandler;
    }

    public final void run() {
        this.f7206a.reconnectServer();
    }
}
