package com.honey.account.g3;

import com.ucar.protocol.UCarMessage;
import com.ucar.protocol.channel.SendFutureCallback;
import com.ucar.protocol.log.ProtocolLogger;

public final /* synthetic */ class f implements SendFutureCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProtocolLogger f9197a;
    public final /* synthetic */ UCarMessage b;

    public /* synthetic */ f(ProtocolLogger protocolLogger, UCarMessage uCarMessage) {
        this.f9197a = protocolLogger;
        this.b = uCarMessage;
    }

    public final void c(Exception exc) {
        this.f9197a.e("SocketChannel", "send ack fail:" + this.b.a(), exc);
    }
}
