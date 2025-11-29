package com.honey.account.g7;

import com.upuphone.starrynet.api.bean.StMessage;
import com.upuphone.starrynet.strategy.message.MessageManagerV2;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MessageManagerV2 f4469a;
    public final /* synthetic */ StMessage b;

    public /* synthetic */ c(MessageManagerV2 messageManagerV2, StMessage stMessage) {
        this.f4469a = messageManagerV2;
        this.b = stMessage;
    }

    public final void run() {
        this.f4469a.lambda$receiveStMessage$0(this.b);
    }
}
