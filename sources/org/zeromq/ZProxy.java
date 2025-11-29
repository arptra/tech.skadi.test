package org.zeromq;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.zeromq.ZActor;
import org.zeromq.ZMQ;
import zmq.Msg;
import zmq.SocketBase;

public class ZProxy {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3507a = Command.START.name();
    public static final String b = Command.PAUSE.name();
    public static final String c = Command.STOP.name();
    public static final String d = Command.RESTART.name();
    public static final String e = Command.EXIT.name();
    public static final String f = Command.STATUS.name();
    public static final String g = Command.CONFIG.name();
    public static final String h = State.STARTED.name();
    public static final String i = State.PAUSED.name();
    public static final String j = State.STOPPED.name();
    public static final String k = State.EXITED.name();
    public static final String l = State.ALIVE.name();
    public static final AtomicInteger m = new AtomicInteger();

    public enum Command {
        START,
        PAUSE,
        STOP,
        RESTART,
        EXIT,
        STATUS,
        CONFIG
    }

    public enum Plug {
        FRONT,
        BACK,
        CAPTURE
    }

    public interface Proxy {

        public static abstract class SimpleProxy implements Proxy {
            public boolean a(ZMsg zMsg, ZMQ.Socket socket, Plug plug, Object... objArr) {
                return true;
            }

            public boolean b(ZMQ.Socket socket, String str, ZMQ.Socket socket2, ZMQ.Socket socket3, ZMQ.Socket socket4, Object... objArr) {
                return true;
            }

            public boolean e(ZMQ.Socket socket, ZMsg zMsg, ZMQ.Socket socket2, ZMQ.Socket socket3, ZMQ.Socket socket4, Object... objArr) {
                return true;
            }
        }

        boolean a(ZMsg zMsg, ZMQ.Socket socket, Plug plug, Object... objArr);

        boolean b(ZMQ.Socket socket, String str, ZMQ.Socket socket2, ZMQ.Socket socket3, ZMQ.Socket socket4, Object... objArr);

        ZMQ.Socket c(ZContext zContext, Plug plug, Object... objArr);

        boolean d(ZMQ.Socket socket, Plug plug, Object... objArr);

        boolean e(ZMQ.Socket socket, ZMsg zMsg, ZMQ.Socket socket2, ZMQ.Socket socket3, ZMQ.Socket socket4, Object... objArr);
    }

    public static final class ProxyActor extends ZActor.SimpleActor {

        /* renamed from: a  reason: collision with root package name */
        public final State f3508a;
        public final Pump b;
        public final String c;
        public Proxy d;
        public Object[] e;
        public ZMQ.Socket f;
        public ZMQ.Socket g;
        public ZMQ.Socket h;

        public static final class State {

            /* renamed from: a  reason: collision with root package name */
            public boolean f3509a;
            public boolean b;
            public boolean c;
            public boolean d;
            public ZMsg e;

            public String toString() {
                return "State [alive=" + this.f3509a + ", started=" + this.b + ", paused=" + this.c + ", restart=" + this.d + ", hot=" + this.e + "]";
            }
        }

        public boolean a(ZContext zContext, ZMQ.Socket socket, ZPoller zPoller) {
            ZMQ.Socket socket2 = this.h;
            if (socket2 != null) {
                socket2.close();
            }
            boolean unused = this.f3508a.f3509a = false;
            if (!this.f3508a.d) {
                n().D(socket);
            }
            return this.f3508a.d;
        }

        public long b(ZMQ.Socket socket, ZPoller zPoller) {
            ZMsg unused = this.f3508a.e = null;
            return super.b(socket, zPoller);
        }

        public boolean c(ZMQ.Socket socket, ZPoller zPoller) {
            if (!this.f3508a.d) {
                return true;
            }
            if (this.f3508a.e == null) {
                return false;
            }
            ZMsg i = this.f3508a.e;
            ZMsg unused = this.f3508a.e = null;
            ZMsg h2 = i.h();
            try {
                boolean a2 = this.d.a(h2, this.f, Plug.FRONT, this.e);
                h2.f();
                ZMsg h3 = i.h();
                h3.f();
                ZMsg h4 = i.h();
                boolean a3 = a2 | this.d.a(h3, this.g, Plug.BACK, this.e) | this.d.a(h4, this.h, Plug.CAPTURE, this.e);
                h4.f();
                i.f();
                return !a3;
            } catch (IOException | RuntimeException e2) {
                e2.printStackTrace();
                boolean unused2 = this.f3508a.d = false;
                return false;
            }
        }

        public boolean d(ZMQ.Socket socket, ZMQ.Socket socket2, ZPoller zPoller, int i) {
            ZMQ.Socket socket3 = this.f;
            if (socket == socket3) {
                return this.b.a(Plug.FRONT, socket3, this.h, Plug.BACK, this.g);
            }
            ZMQ.Socket socket4 = this.g;
            if (socket == socket4) {
                return this.b.a(Plug.BACK, socket4, this.h, Plug.FRONT, socket3);
            }
            return false;
        }

        public boolean e(ZMQ.Socket socket, ZPoller zPoller, int i) {
            String s = socket.s();
            if (ZProxy.f3507a.equals(s)) {
                if (m(zPoller)) {
                    return n().D(socket);
                }
                boolean unused = this.f3508a.d = false;
                return false;
            } else if (ZProxy.c.equals(s)) {
                o();
                return n().D(socket);
            } else if (ZProxy.b.equals(s)) {
                k(zPoller, true);
                return n().D(socket);
            } else if (ZProxy.d.equals(s)) {
                return l(socket, Boolean.parseBoolean(socket.s()));
            } else {
                if (ZProxy.f.equals(s)) {
                    return n().D(socket);
                }
                if (ZProxy.g.equals(s)) {
                    ZMsg x = ZMsg.x(socket);
                    boolean e2 = this.d.e(socket, x, this.f, this.g, this.h, this.e);
                    x.f();
                    return e2;
                } else if (ZProxy.e.equals(s)) {
                    boolean unused2 = this.f3508a.d = false;
                    return false;
                } else {
                    return this.d.b(socket, s, this.f, this.g, this.h, this.e);
                }
            }
        }

        public String f(ZMQ.Socket socket) {
            ZMsg zMsg = new ZMsg();
            zMsg.a(ZProxy.l);
            zMsg.D(socket);
            return this.c;
        }

        public List g(ZContext zContext, Object... objArr) {
            this.d = objArr[0];
            Object[] objArr2 = new Object[(objArr.length - 1)];
            this.e = objArr2;
            System.arraycopy(objArr, 1, objArr2, 0, objArr2.length);
            this.f = this.d.c(zContext, Plug.FRONT, this.e);
            this.h = this.d.c(zContext, Plug.CAPTURE, this.e);
            ZMQ.Socket c2 = this.d.c(zContext, Plug.BACK, this.e);
            this.g = c2;
            return Arrays.asList(new ZMQ.Socket[]{this.f, c2});
        }

        public void j(ZMQ.Socket socket, List list, ZPoller zPoller) {
            boolean unused = this.f3508a.f3509a = true;
            boolean unused2 = this.f3508a.d = false;
        }

        public final boolean k(ZPoller zPoller, boolean z) {
            boolean unused = this.f3508a.c = z;
            if (z) {
                zPoller.u(this.f);
                zPoller.u(this.g);
            } else {
                zPoller.o(this.f, 1);
                zPoller.o(this.g, 1);
            }
            return true;
        }

        public final boolean l(ZMQ.Socket socket, boolean z) {
            boolean unused = this.f3508a.d = true;
            if (!z) {
                return false;
            }
            ZMsg unused2 = this.f3508a.e = ZMsg.x(socket);
            return true;
        }

        public final boolean m(ZPoller zPoller) {
            boolean z = true;
            if (!this.f3508a.b) {
                try {
                    boolean d2 = this.d.d(this.f, Plug.FRONT, this.e) | this.d.d(this.g, Plug.BACK, this.e) | this.d.d(this.h, Plug.CAPTURE, this.e);
                    boolean unused = this.f3508a.b = true;
                    z = d2;
                } catch (IOException | RuntimeException e2) {
                    e2.printStackTrace();
                    boolean unused2 = this.f3508a.d = false;
                    boolean unused3 = this.f3508a.b = false;
                    return false;
                }
            }
            k(zPoller, false);
            return z;
        }

        public final ZMsg n() {
            ZMsg zMsg = new ZMsg();
            if (!this.f3508a.f3509a) {
                zMsg.a(ZProxy.k);
            } else if (this.f3508a.c) {
                zMsg.a(ZProxy.i);
            } else if (this.f3508a.b) {
                zMsg.a(ZProxy.h);
            } else {
                zMsg.a(ZProxy.j);
            }
            return zMsg;
        }

        public final boolean o() {
            boolean unused = this.f3508a.b = false;
            boolean unused2 = this.f3508a.c = false;
            boolean unused3 = this.f3508a.d = true;
            return true;
        }
    }

    public interface Pump {
        boolean a(Plug plug, ZMQ.Socket socket, ZMQ.Socket socket2, Plug plug2, ZMQ.Socket socket3);
    }

    public enum State {
        ALIVE,
        STARTED,
        PAUSED,
        STOPPED,
        EXITED
    }

    public static class ZPump implements Pump {
        public static final Identity b = new Identity();

        /* renamed from: a  reason: collision with root package name */
        public final Transformer f3510a;

        public static class Identity implements Transformer {
            public Identity() {
            }

            public ZMsg a(ZMsg zMsg, Plug plug, Plug plug2) {
                return zMsg;
            }
        }

        public interface Transformer {
            ZMsg a(ZMsg zMsg, Plug plug, Plug plug2);
        }

        public boolean a(Plug plug, ZMQ.Socket socket, ZMQ.Socket socket2, Plug plug2, ZMQ.Socket socket3) {
            ZMsg x = ZMsg.x(socket);
            boolean z = false;
            if (x == null) {
                return false;
            }
            if (socket2 != null) {
                ZMsg a2 = this.f3510a.a(x, plug, Plug.CAPTURE);
                if (x != a2) {
                    z = true;
                }
                a2.E(socket2, z);
            }
            boolean D = this.f3510a.a(x, plug, plug2).D(socket3);
            x.f();
            return D;
        }
    }

    public static final class ZmqPump implements Pump {
        public boolean a(Plug plug, ZMQ.Socket socket, ZMQ.Socket socket2, Plug plug2, ZMQ.Socket socket3) {
            int i;
            SocketBase b = socket.b();
            SocketBase b2 = socket3.b();
            SocketBase b3 = socket2 == null ? null : socket2.b();
            do {
                Msg b22 = b.b2(0);
                if (b22 == null || ((long) b.Q1(13)) < 0) {
                    return false;
                }
                int i2 = 2;
                if (b3 != null) {
                    b3.d2(new Msg(b22), i > 0 ? 2 : 0);
                }
                if (i <= 0) {
                    i2 = 0;
                }
                if (!b2.d2(b22, i2)) {
                    return false;
                }
            } while (i != 0);
            return true;
        }
    }
}
