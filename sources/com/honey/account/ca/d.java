package com.honey.account.ca;

import com.xjsd.ai.assistant.flutter.AndroidAssistantApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class d implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAssistantApi.AssistantHostApi f7196a;

    public /* synthetic */ d(AndroidAssistantApi.AssistantHostApi assistantHostApi) {
        this.f7196a = assistantHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidAssistantApi.AssistantHostApi.u(this.f7196a, obj, reply);
    }
}
