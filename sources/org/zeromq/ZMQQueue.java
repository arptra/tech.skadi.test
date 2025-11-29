package org.zeromq;

import org.zeromq.ZMQ;
import zmq.SocketBase;

public class ZMQQueue implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final ZMQ.Socket f3499a;
    public final ZMQ.Socket b;

    public void run() {
        zmq.ZMQ.f(this.f3499a.b(), this.b.b(), (SocketBase) null);
    }
}
