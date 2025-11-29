package com.honey.account.g3;

import com.ucar.protocol.channel.socket.FutureRequestManager;
import com.ucar.protocol.log.ProtocolLogger;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FutureRequestManager f9192a;
    public final /* synthetic */ ProtocolLogger b;

    public /* synthetic */ a(FutureRequestManager futureRequestManager, ProtocolLogger protocolLogger) {
        this.f9192a = futureRequestManager;
        this.b = protocolLogger;
    }

    public final void run() {
        this.f9192a.f(this.b);
    }
}
