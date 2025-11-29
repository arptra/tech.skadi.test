package com.honey.account.ca;

import com.xjsd.ai.assistant.flutter.AndroidAssistantApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class b implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAssistantApi.VoidResult f7194a;
    public final /* synthetic */ String b;

    public /* synthetic */ b(AndroidAssistantApi.VoidResult voidResult, String str) {
        this.f7194a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidAssistantApi.AssistantFlutterApi.f(this.f7194a, this.b, obj);
    }
}
