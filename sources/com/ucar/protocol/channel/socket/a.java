package com.ucar.protocol.channel.socket;

import com.ucar.protocol.UCarMessage;
import com.ucar.protocol.log.ProtocolLogger;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SocketChannelReadTask f9649a;
    public final /* synthetic */ ProtocolLogger b;
    public final /* synthetic */ UCarMessage c;

    public /* synthetic */ a(SocketChannelReadTask socketChannelReadTask, ProtocolLogger protocolLogger, UCarMessage uCarMessage) {
        this.f9649a = socketChannelReadTask;
        this.b = protocolLogger;
        this.c = uCarMessage;
    }

    public final void run() {
        this.f9649a.i(this.b, this.c);
    }
}
