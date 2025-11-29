package com.honey.account.zc;

import zmq.pipe.Pipe;
import zmq.socket.pubsub.Mtrie;
import zmq.socket.pubsub.XPub;

public final /* synthetic */ class a implements Mtrie.IMtrieHandler {
    public final void a(Pipe pipe, byte[] bArr, int i, XPub xPub) {
        XPub.x2(pipe, bArr, i, xPub);
    }
}
