package com.honey.account.s6;

import android.os.Handler;
import android.os.Message;
import com.upuphone.starrynet.core.ble.channel.SendChannel;

public final /* synthetic */ class c implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SendChannel f5132a;

    public /* synthetic */ c(SendChannel sendChannel) {
        this.f5132a = sendChannel;
    }

    public final boolean handleMessage(Message message) {
        return this.f5132a.lambda$new$0(message);
    }
}
