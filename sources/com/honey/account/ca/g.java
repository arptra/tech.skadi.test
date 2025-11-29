package com.honey.account.ca;

import com.xjsd.ai.assistant.flutter.AndroidAssistantApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class g implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAssistantApi.AssistantHostApi f7199a;

    public /* synthetic */ g(AndroidAssistantApi.AssistantHostApi assistantHostApi) {
        this.f7199a = assistantHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidAssistantApi.AssistantHostApi.g(this.f7199a, obj, reply);
    }
}
