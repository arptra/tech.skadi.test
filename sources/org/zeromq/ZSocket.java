package org.zeromq;

import java.util.concurrent.atomic.AtomicBoolean;
import zmq.SocketBase;

public class ZSocket implements AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    public final SocketBase f3511a;
    public final AtomicBoolean b;

    public void close() {
        if (this.b.compareAndSet(false, true)) {
            ManagedContext.d().c(this.f3511a);
        }
    }
}
