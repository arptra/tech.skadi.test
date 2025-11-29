package com.honey.account.ca;

import com.xjsd.ai.assistant.flutter.AndroidAssistantApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class e implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAssistantApi.AssistantHostApi f7197a;

    public /* synthetic */ e(AndroidAssistantApi.AssistantHostApi assistantHostApi) {
        this.f7197a = assistantHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidAssistantApi.AssistantHostApi.i(this.f7197a, obj, reply);
    }
}
