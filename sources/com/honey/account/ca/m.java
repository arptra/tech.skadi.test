package com.honey.account.ca;

import com.xjsd.ai.assistant.flutter.AndroidAssistantApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class m implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAssistantApi.AssistantHostApi f7205a;

    public /* synthetic */ m(AndroidAssistantApi.AssistantHostApi assistantHostApi) {
        this.f7205a = assistantHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidAssistantApi.AssistantHostApi.k(this.f7205a, obj, reply);
    }
}
