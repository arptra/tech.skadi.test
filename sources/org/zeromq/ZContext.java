package org.zeromq;

import java.io.Closeable;
import java.nio.channels.Selector;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.zeromq.ZMQ;

public class ZContext implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final ZMQ.Context f3491a;
    public final Set b;
    public final Set c;
    public final Set d;
    public final int e;
    public final boolean f;
    public volatile int g;
    public int h;
    public volatile int i;
    public volatile int j;

    public ZContext(int i2) {
        this((ZContext) null, i2);
    }

    public void a(ZMQ.Socket socket) {
        if (socket != null) {
            try {
                socket.i();
            } finally {
                this.b.remove(socket);
            }
        }
    }

    public ZMQ.Socket b(SocketType socketType) {
        ZMQ.Socket socket = new ZMQ.Socket(this, socketType);
        socket.S(this.j);
        socket.U(this.i);
        socket.N(this.g);
        this.b.add(socket);
        return socket;
    }

    public void c() {
        for (ZMQ.Socket i2 : this.b) {
            i2.i();
        }
        this.b.clear();
        for (Selector b2 : this.c) {
            this.f3491a.b(b2);
        }
        this.c.clear();
        if (g()) {
            for (ZContext close : this.d) {
                close.close();
            }
            this.f3491a.d();
            return;
        }
        this.d.remove(this);
    }

    public void close() {
        c();
    }

    public ZMQ.Context d() {
        return this.f3491a;
    }

    public boolean g() {
        return this.f;
    }

    public Selector i() {
        Selector c2 = this.f3491a.c();
        this.c.add(c2);
        return c2;
    }

    public ZContext(ZContext zContext, int i2) {
        if (zContext == null) {
            this.f = true;
            this.f3491a = ZMQ.a(i2);
            this.d = Collections.newSetFromMap(new ConcurrentHashMap());
        } else {
            this.f = false;
            this.f3491a = zContext.f3491a;
            Set set = zContext.d;
            this.d = set;
            set.add(this);
        }
        this.b = Collections.newSetFromMap(new ConcurrentHashMap());
        this.c = Collections.newSetFromMap(new ConcurrentHashMap());
        this.e = i2;
        this.g = 0;
        this.h = 1000;
        this.i = 1000;
        this.j = 1000;
    }
}
