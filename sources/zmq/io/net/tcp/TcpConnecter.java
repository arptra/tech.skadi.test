package zmq.io.net.tcp;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import zmq.Options;
import zmq.Own;
import zmq.SocketBase;
import zmq.ZError;
import zmq.io.IOObject;
import zmq.io.IOThread;
import zmq.io.SessionBase;
import zmq.io.StreamEngine;
import zmq.io.net.Address;
import zmq.io.net.SelectorProviderChooser;
import zmq.io.net.StandardProtocolFamily;
import zmq.poll.IPollEvents;
import zmq.poll.Poller;
import zmq.util.Utils;

public class TcpConnecter extends Own implements IPollEvents {
    public final IOObject k;
    public final Address l;
    public SocketChannel m = null;
    public Poller.Handle n;
    public final boolean o;
    public boolean p;
    public final SessionBase q;
    public int r;
    public final SocketBase s;

    public TcpConnecter(IOThread iOThread, SessionBase sessionBase, Options options, Address address, boolean z) {
        super(iOThread, options);
        this.k = new IOObject(iOThread, this);
        this.l = address;
        this.o = z;
        this.p = false;
        this.q = sessionBase;
        this.r = this.c.o;
        this.s = sessionBase.t1();
    }

    public void D0(int i) {
        if (this.p) {
            this.k.f(1);
            this.p = false;
        }
        Poller.Handle handle = this.n;
        if (handle != null) {
            this.k.i(handle);
            this.n = null;
        }
        if (this.m != null) {
            close();
        }
        super.D0(i);
    }

    public void c() {
        this.k.i(this.n);
        this.n = null;
        SocketChannel q1 = q1();
        if (q1 == null) {
            close();
            p1();
            return;
        }
        try {
            TcpUtils.A(q1);
            Options options = this.c;
            TcpUtils.z(q1, options.A, options.B, options.C, options.D);
            try {
                StreamEngine streamEngine = new StreamEngine(q1, this.c, this.l.toString());
                this.m = null;
                J0(this.q, streamEngine);
                n1();
                this.s.H1(this.l.toString(), q1);
            } catch (ZError.InstantiationException unused) {
            }
        } catch (IOException e) {
            throw new ZError.IOException(e);
        }
    }

    public void close() {
        try {
            this.m.close();
            this.s.E1(this.l.toString(), this.m);
        } catch (IOException e) {
            this.s.D1(this.l.toString(), ZError.a(e));
        }
        this.m = null;
    }

    public void d() {
    }

    public void g(int i) {
        this.p = false;
        t1();
    }

    public void g1() {
        this.k.q();
    }

    public void o() {
    }

    public final void p1() {
        int r1 = r1();
        this.k.e((long) r1, 1);
        try {
            this.l.e(this.c.u);
        } catch (Exception unused) {
        }
        this.s.G1(this.l.toString(), r1);
        this.p = true;
    }

    public final SocketChannel q1() {
        try {
            this.m.finishConnect();
            return this.m;
        } catch (IOException unused) {
            return null;
        }
    }

    public void r0() {
        this.k.h();
        if (this.o) {
            p1();
        } else {
            t1();
        }
    }

    public final int r1() {
        int i = this.r;
        int g = Utils.g();
        Options options = this.c;
        int i2 = options.o;
        int i3 = i + (g % i2);
        int i4 = options.p;
        if (i4 > 0 && i4 > i2) {
            this.r = Math.min(this.r * 2, i4);
        }
        return i3;
    }

    public final boolean s1() {
        Address address = this.l;
        if (address != null) {
            address.e(this.c.u);
            Address.IZAddress f = this.l.f();
            if (f != null) {
                SocketAddress address2 = f.address();
                if (address2 != null) {
                    Options options = this.c;
                    SelectorProviderChooser selectorProviderChooser = options.b0;
                    if (selectorProviderChooser == null) {
                        this.m = SocketChannel.open();
                    } else {
                        this.m = selectorProviderChooser.a(f, options).openSocketChannel();
                    }
                    if (f.b() == StandardProtocolFamily.INET6) {
                        TcpUtils.j(this.m);
                    }
                    TcpUtils.B(this.m);
                    int i = this.c.j;
                    if (i != 0) {
                        TcpUtils.y(this.m, i);
                    }
                    int i2 = this.c.k;
                    if (i2 != 0) {
                        TcpUtils.x(this.m, i2);
                    }
                    int i3 = this.c.l;
                    if (i3 != 0) {
                        TcpUtils.t(this.m, i3);
                    }
                    f.a();
                    try {
                        boolean connect = this.m.connect(address2);
                        if (!connect) {
                            this.j.c(36);
                        }
                        return connect;
                    } catch (IllegalArgumentException e) {
                        throw new IOException(e.getMessage(), e);
                    }
                } else {
                    throw new IOException("Socket address not resolved");
                }
            } else {
                throw new IOException("Address not resolved");
            }
        } else {
            throw new IOException("Null address");
        }
    }

    public final void t1() {
        try {
            if (s1()) {
                this.n = this.k.b(this.m);
                c();
                return;
            }
            Poller.Handle b = this.k.b(this.m);
            this.n = b;
            this.k.m(b);
            this.s.F1(this.l.toString(), -1);
        } catch (IOException | RuntimeException unused) {
            if (this.m != null) {
                close();
            }
            p1();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + this.c.R + "]";
    }
}
