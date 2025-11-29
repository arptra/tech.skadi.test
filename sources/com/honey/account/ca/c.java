package com.honey.account.ca;

import com.xjsd.ai.assistant.flutter.AndroidAssistantApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class c implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAssistantApi.VoidResult f7195a;
    public final /* synthetic */ String b;

    public /* synthetic */ c(AndroidAssistantApi.VoidResult voidResult, String str) {
        this.f7195a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidAssistantApi.AssistantFlutterApi.g(this.f7195a, this.b, obj);
    }
}
