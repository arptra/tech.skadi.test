package com.upuphone.runasone.relay.lib.device;

import android.os.Handler;
import android.os.Message;
import com.upuphone.runasone.relay.lib.device.MessageManager;

public final /* synthetic */ class a implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MessageManager.TimeOutHandler.AnonymousClass1 f6438a;

    public /* synthetic */ a(MessageManager.TimeOutHandler.AnonymousClass1 r1) {
        this.f6438a = r1;
    }

    public final boolean handleMessage(Message message) {
        return this.f6438a.lambda$run$0(message);
    }
}
