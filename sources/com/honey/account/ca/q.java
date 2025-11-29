package com.honey.account.ca;

import com.xjsd.ai.assistant.flutter.AndroidAssistantApiHandler;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EndToEndResponse f7209a;

    public /* synthetic */ q(EndToEndResponse endToEndResponse) {
        this.f7209a = endToEndResponse;
    }

    public final void run() {
        AndroidAssistantApiHandler.onMsg$lambda$24(this.f7209a);
    }
}
