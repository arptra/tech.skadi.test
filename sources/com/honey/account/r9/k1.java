package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidRing2MessageApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class k1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidRing2MessageApi.Ring2MessageSendApi f7560a;

    public /* synthetic */ k1(AndroidRing2MessageApi.Ring2MessageSendApi ring2MessageSendApi) {
        this.f7560a = ring2MessageSendApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidRing2MessageApi.Ring2MessageSendApi.b(this.f7560a, obj, reply);
    }
}
