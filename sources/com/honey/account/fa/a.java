package com.honey.account.fa;

import com.xjsd.ai.assistant.net.ws.VirtualWebSocket;
import com.xjsd.ai.assistant.net.ws.VirtualWebSocket$mCloudClientListener$1;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VirtualWebSocket f7296a;

    public /* synthetic */ a(VirtualWebSocket virtualWebSocket) {
        this.f7296a = virtualWebSocket;
    }

    public final void run() {
        VirtualWebSocket$mCloudClientListener$1.f(this.f7296a);
    }
}
