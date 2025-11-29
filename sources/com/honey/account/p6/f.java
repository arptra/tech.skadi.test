package com.honey.account.p6;

import com.upuphone.runasone.uupcast.api.IHandleReceiverCarMessageListenerAdapter;
import com.upuphone.starryiccoaproto.UCarMessage;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IHandleReceiverCarMessageListenerAdapter f5092a;
    public final /* synthetic */ UCarMessage b;

    public /* synthetic */ f(IHandleReceiverCarMessageListenerAdapter iHandleReceiverCarMessageListenerAdapter, UCarMessage uCarMessage) {
        this.f5092a = iHandleReceiverCarMessageListenerAdapter;
        this.b = uCarMessage;
    }

    public final void run() {
        this.f5092a.lambda$adapt$0(this.b);
    }
}
