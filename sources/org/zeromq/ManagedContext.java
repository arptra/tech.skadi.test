package org.zeromq;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import zmq.Ctx;
import zmq.SocketBase;
import zmq.ZMQ;

class ManagedContext {

    /* renamed from: a  reason: collision with root package name */
    public final Lock f3471a;
    public final Ctx b;
    public final Set c;

    public static class ContextHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final ManagedContext f3472a = new ManagedContext();
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                ManagedContext.d().b();
            }
        });
    }

    public static ManagedContext d() {
        return ContextHolder.f3472a;
    }

    public final void b() {
        this.f3471a.lock();
        try {
            for (SocketBase socketBase : this.c) {
                try {
                    socketBase.f2(17, 0);
                    socketBase.close();
                } catch (Exception unused) {
                }
            }
            this.c.clear();
        } finally {
            this.f3471a.unlock();
        }
    }

    public void c(SocketBase socketBase) {
        try {
            socketBase.f2(17, 0);
            socketBase.close();
        } catch (Exception unused) {
        }
        this.f3471a.lock();
        try {
            this.c.remove(socketBase);
        } finally {
            this.f3471a.unlock();
        }
    }

    public ManagedContext() {
        this.b = ZMQ.c(1);
        this.f3471a = new ReentrantLock();
        this.c = new HashSet();
    }
}
