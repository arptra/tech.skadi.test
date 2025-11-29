package com.honey.account.g7;

import com.upuphone.starrynet.strategy.message.MessageManager;
import com.upuphone.starrynet.strategy.message.StarryMessage;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarryMessage f4468a;

    public /* synthetic */ b(StarryMessage starryMessage) {
        this.f4468a = starryMessage;
    }

    public final void run() {
        MessageManager.lambda$onSendSuccess$0(this.f4468a);
    }
}
