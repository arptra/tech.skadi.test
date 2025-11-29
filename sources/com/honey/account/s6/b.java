package com.honey.account.s6;

import android.os.Handler;
import android.os.Message;
import com.upuphone.starrynet.core.ble.channel.Channel;

public final /* synthetic */ class b implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Channel f5131a;

    public /* synthetic */ b(Channel channel) {
        this.f5131a = channel;
    }

    public final boolean handleMessage(Message message) {
        return this.f5131a.lambda$new$2(message);
    }
}
