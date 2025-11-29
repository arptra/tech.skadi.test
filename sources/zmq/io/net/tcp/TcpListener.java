package zmq.io.net.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Locale;
import zmq.Options;
import zmq.SocketBase;
import zmq.ZError;
import zmq.io.IOObject;
import zmq.io.IOThread;
import zmq.io.SessionBase;
import zmq.io.StreamEngine;
import zmq.io.net.Address;
import zmq.io.net.Listener;
import zmq.io.net.SelectorProviderChooser;
import zmq.io.net.StandardProtocolFamily;
import zmq.io.net.tcp.TcpAddress;
import zmq.poll.Poller;
import zmq.socket.Sockets;

public class TcpListener extends Listener {
    public static final boolean q = System.getProperty("os.name").toLowerCase(Locale.ENGLISH).contains("win");
    public TcpAddress l;
    public ServerSocketChannel m = null;
    public Poller.Handle n;
    public String o;
    public final IOObject p;

    public TcpListener(IOThread iOThread, SocketBase socketBase, Options options) {
        super(iOThread, socketBase, options);
        this.p = new IOObject(iOThread, this);
    }

    private void close() {
        try {
            this.m.close();
            this.k.E1(this.o, this.m);
        } catch (IOException e) {
            this.k.D1(this.o, ZError.a(e));
        }
        this.m = null;
    }

    public void D0(int i) {
        this.p.i(this.n);
        this.n = null;
        close();
        super.D0(i);
    }

    public void a() {
        try {
            SocketChannel r1 = r1();
            if (r1 == null) {
                this.k.A1(this.o, 49);
                return;
            }
            TcpUtils.A(r1);
            Options options = this.c;
            TcpUtils.z(r1, options.A, options.B, options.C, options.D);
            try {
                StreamEngine streamEngine = new StreamEngine(r1, this.c, this.o);
                SessionBase createSession = Sockets.createSession(r(this.c.c), false, this.k, this.c, (Address) null);
                createSession.h1();
                j1(createSession);
                K0(createSession, streamEngine, false);
                this.k.B1(this.o, r1);
            } catch (ZError.InstantiationException unused) {
                this.k.A1(this.o, 22);
            }
        } catch (IOException e) {
            this.k.A1(this.o, ZError.a(e));
        }
    }

    public void g1() {
        this.p.q();
    }

    public String p1() {
        return s1(this.l);
    }

    public boolean q1(String str) {
        this.l = new TcpAddress(str, this.c.u);
        return t1();
    }

    public void r0() {
        this.p.h();
        Poller.Handle b = this.p.b(this.m);
        this.n = b;
        this.p.l(b);
    }

    public final SocketChannel r1() {
        SocketChannel accept = this.m.accept();
        if (!this.c.E.isEmpty()) {
            for (TcpAddress.TcpAddressMask e : this.c.E) {
                if (e.e(this.l.address())) {
                }
            }
            try {
                accept.close();
                return null;
            } catch (IOException unused) {
                return null;
            }
        }
        int i = this.c.l;
        if (i != 0) {
            TcpUtils.t(accept, i);
        }
        int i2 = this.c.j;
        if (i2 != 0) {
            TcpUtils.y(accept, i2);
        }
        int i3 = this.c.k;
        if (i3 != 0) {
            TcpUtils.x(accept, i3);
        }
        if (!q) {
            TcpUtils.w(accept, true);
        }
        return accept;
    }

    public String s1(Address.IZAddress iZAddress) {
        return iZAddress.c(this.m.socket().getLocalPort());
    }

    public final boolean t1() {
        this.o = this.l.toString();
        try {
            Options options = this.c;
            SelectorProviderChooser selectorProviderChooser = options.b0;
            if (selectorProviderChooser == null) {
                this.m = ServerSocketChannel.open();
            } else {
                this.m = selectorProviderChooser.a(this.l, options).openServerSocketChannel();
            }
            if (this.l.b() == StandardProtocolFamily.INET6) {
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
            if (!q) {
                TcpUtils.w(this.m, true);
            }
            this.m.socket().bind(this.l.address(), this.c.q);
            String p1 = p1();
            this.o = p1;
            this.k.M1(p1, this.m);
            return true;
        } catch (IOException unused) {
            close();
            this.j.c(48);
            return false;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + this.c.R + "]";
    }

    public boolean u1(InetSocketAddress inetSocketAddress) {
        this.l = new TcpAddress(inetSocketAddress);
        return t1();
    }
}
