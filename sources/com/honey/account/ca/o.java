package com.honey.account.ca;

import com.xjsd.ai.assistant.flutter.AndroidAssistantApi;
import com.xjsd.ai.assistant.flutter.AndroidAssistantApiHandler;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAssistantApi.CloudResponse f7207a;

    public /* synthetic */ o(AndroidAssistantApi.CloudResponse cloudResponse) {
        this.f7207a = cloudResponse;
    }

    public final void run() {
        AndroidAssistantApiHandler.sendResToFlutter$lambda$25(this.f7207a);
    }
}
