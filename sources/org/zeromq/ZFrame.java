package org.zeromq;

import java.nio.charset.Charset;
import java.util.Arrays;
import org.zeromq.ZMQ;
import org.zeromq.util.ZData;
import zmq.Msg;
import zmq.SocketBase;
import zmq.socket.clientserver.Server;

public class ZFrame {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3492a;
    public byte[] b;
    public int c;
    public String d;

    public ZFrame(byte[] bArr) {
        if (bArr != null) {
            this.b = bArr;
        }
    }

    public static ZFrame g(ZMQ.Socket socket, int i) {
        Msg b2 = socket.b().b2(i);
        if (b2 == null) {
            socket.j();
            return null;
        }
        ZFrame zFrame = new ZFrame(b2);
        zFrame.j(b2.g());
        return zFrame;
    }

    public void a() {
        if (e()) {
            this.b = null;
        }
    }

    public ZFrame b() {
        return new ZFrame(this.b);
    }

    public byte[] c() {
        return this.b;
    }

    public String d(Charset charset) {
        return !e() ? "" : new String(this.b, charset);
    }

    public boolean e() {
        return this.b != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.b, ((ZFrame) obj).b);
    }

    public boolean f() {
        return this.f3492a;
    }

    public boolean h(ZMQ.Socket socket, int i) {
        int i2 = 0;
        Utils.a(socket != null, "socket parameter must be set");
        SocketBase b2 = socket.b();
        Msg msg = new Msg(this.b);
        String str = this.d;
        if (str != null) {
            msg.K(str);
        }
        int i3 = 2;
        if ((i & 2) != 2) {
            i3 = 0;
        }
        if ((i & 1) == 1) {
            i2 = 1;
        }
        int i4 = i3 | i2;
        if (b2 instanceof Server) {
            msg.M(this.c);
        }
        return b2.d2(msg, i4);
    }

    public int hashCode() {
        return Arrays.hashCode(this.b);
    }

    public boolean i(ZMQ.Socket socket, int i) {
        return h(socket, i);
    }

    public void j(String str) {
        this.d = str;
    }

    public String toString() {
        return ZData.b(this.b);
    }

    public ZFrame(String str) {
        if (str != null) {
            this.b = str.getBytes(ZMQ.f);
        }
    }

    public ZFrame(Msg msg) {
        if (msg != null) {
            this.b = msg.c();
            this.f3492a = msg.n();
            this.c = msg.k();
        }
    }
}
