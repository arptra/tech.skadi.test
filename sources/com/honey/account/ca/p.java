package com.honey.account.ca;

import com.xjsd.ai.assistant.flutter.AndroidAssistantApi;
import com.xjsd.ai.assistant.flutter.AndroidAssistantApiHandler;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAssistantApi.NotifyEvent f7208a;

    public /* synthetic */ p(AndroidAssistantApi.NotifyEvent notifyEvent) {
        this.f7208a = notifyEvent;
    }

    public final void run() {
        AndroidAssistantApiHandler.broadcastEventToFlutter$lambda$1(this.f7208a);
    }
}
