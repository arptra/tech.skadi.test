package com.honey.account.bb;

import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class e implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KeyEventChannel.EventResponseHandler f7153a;

    public /* synthetic */ e(KeyEventChannel.EventResponseHandler eventResponseHandler) {
        this.f7153a = eventResponseHandler;
    }

    public final void reply(Object obj) {
        KeyEventChannel.lambda$createReplyHandler$0(this.f7153a, obj);
    }
}
