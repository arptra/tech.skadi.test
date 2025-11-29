package com.honey.account.g7;

import com.upuphone.starrynet.strategy.message.MessageManager;
import com.upuphone.starrynet.strategy.message.StarryMessage;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MessageManager f4467a;
    public final /* synthetic */ StarryMessage b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;

    public /* synthetic */ a(MessageManager messageManager, StarryMessage starryMessage, int i, String str) {
        this.f4467a = messageManager;
        this.b = starryMessage;
        this.c = i;
        this.d = str;
    }

    public final void run() {
        this.f4467a.lambda$onSendFail$1(this.b, this.c, this.d);
    }
}
