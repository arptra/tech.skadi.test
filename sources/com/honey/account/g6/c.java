package com.honey.account.g6;

import android.os.Handler;
import android.os.Message;
import com.upuphone.runasone.relay.lib.air.AirPortMessageManager;

public final /* synthetic */ class c implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AirPortMessageManager.TimeOutHandler f4466a;

    public /* synthetic */ c(AirPortMessageManager.TimeOutHandler timeOutHandler) {
        this.f4466a = timeOutHandler;
    }

    public final boolean handleMessage(Message message) {
        return AirPortMessageManager.TimeOutHandler.m1678_init_$lambda0(this.f4466a, message);
    }
}
