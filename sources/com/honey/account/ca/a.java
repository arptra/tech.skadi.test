package com.honey.account.ca;

import com.xjsd.ai.assistant.flutter.AndroidAssistantApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class a implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAssistantApi.VoidResult f7193a;
    public final /* synthetic */ String b;

    public /* synthetic */ a(AndroidAssistantApi.VoidResult voidResult, String str) {
        this.f7193a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidAssistantApi.AssistantFlutterApi.e(this.f7193a, this.b, obj);
    }
}
