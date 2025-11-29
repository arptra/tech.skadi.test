package com.xjsd.ai.assistant.connect;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.connect.InterconnectAbilityImpl;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterconnectAbilityImpl.AnonymousClass3 f8451a;
    public final /* synthetic */ OnReceiveRemoteMsgListener b;
    public final /* synthetic */ StarryNetMessage c;

    public /* synthetic */ a(InterconnectAbilityImpl.AnonymousClass3 r1, OnReceiveRemoteMsgListener onReceiveRemoteMsgListener, StarryNetMessage starryNetMessage) {
        this.f8451a = r1;
        this.b = onReceiveRemoteMsgListener;
        this.c = starryNetMessage;
    }

    public final void run() {
        this.f8451a.lambda$onMessageReceive$0(this.b, this.c);
    }
}
