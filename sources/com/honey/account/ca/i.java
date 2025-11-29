package com.honey.account.ca;

import com.xjsd.ai.assistant.flutter.AndroidAssistantApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class i implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAssistantApi.AssistantHostApi f7201a;

    public /* synthetic */ i(AndroidAssistantApi.AssistantHostApi assistantHostApi) {
        this.f7201a = assistantHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidAssistantApi.AssistantHostApi.e(this.f7201a, obj, reply);
    }
}
