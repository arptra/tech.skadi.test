package org.zeromq;

import java.io.Closeable;
import java.nio.channels.SelectableChannel;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.zeromq.ZMonitor;
import zmq.Ctx;
import zmq.Msg;
import zmq.SocketBase;
import zmq.ZError;
import zmq.ZMQ;
import zmq.io.mechanism.Mechanisms;

public class ZMQ {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f3493a = zmq.ZMQ.f3607a;
    public static final byte[] b = zmq.ZMQ.b;
    public static final byte[] c = zmq.ZMQ.d;
    public static final byte[] d = zmq.ZMQ.e;
    public static final byte[] e = zmq.ZMQ.f;
    public static final Charset f = zmq.ZMQ.c;

    public static class CancellationToken {
    }

    public static class Context implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicBoolean f3494a = new AtomicBoolean(false);
        public final Ctx b;

        public Context(int i) {
            this.b = zmq.ZMQ.c(i);
        }

        public boolean b(Selector selector) {
            return this.b.d(selector);
        }

        public Selector c() {
            return this.b.g();
        }

        public void close() {
            d();
        }

        public void d() {
            if (this.f3494a.compareAndSet(false, true)) {
                this.b.z();
            }
        }
    }

    public static class Curve {

        public static class KeyPair {
        }

        public static String a(byte[] bArr) {
            return zmq.io.mechanism.curve.Curve.p(bArr);
        }
    }

    public static class Event {

        /* renamed from: a  reason: collision with root package name */
        public final int f3495a;
        public final Object b;
        public final Object c;
        public final String d;

        public Event(int i, Object obj, Object obj2, String str) {
            this.f3495a = i;
            this.b = obj;
            this.d = str;
            this.c = obj2;
        }

        public static Event d(Socket socket) {
            return e(socket, 0);
        }

        public static Event e(Socket socket, int i) {
            ZMQ.Event b2 = ZMQ.Event.b(socket.b, i);
            Object obj = null;
            if (b2 == null) {
                return null;
            }
            int i2 = b2.f3608a;
            if (i2 != 1) {
                if (i2 != 2) {
                    switch (i2) {
                        case 8:
                        case 32:
                        case 128:
                        case 512:
                            break;
                        case 16:
                        case 64:
                        case 256:
                        case 2048:
                            obj = Error.findByCode(((Integer) b2.c).intValue());
                            break;
                        case 1024:
                        case 4096:
                            break;
                        case 8192:
                            obj = ZMonitor.ProtocolCode.findByCode(((Integer) b2.c).intValue());
                            break;
                        default:
                            obj = b2.c;
                            break;
                    }
                }
                return new Event(b2.f3608a, b2.c, obj, b2.b);
            }
            obj = b2.a(socket.b);
            return new Event(b2.f3608a, b2.c, obj, b2.b);
        }

        public String a() {
            return this.d;
        }

        public int b() {
            return this.f3495a;
        }

        public Object c() {
            return this.b;
        }
    }

    public static class PollItem {

        /* renamed from: a  reason: collision with root package name */
        public final zmq.poll.PollItem f3496a;
        public final Socket b;

        public PollItem(Socket socket, int i) {
            this.b = socket;
            this.f3496a = new zmq.poll.PollItem(socket.b, i);
        }

        public final zmq.poll.PollItem b() {
            return this.f3496a;
        }

        public final SelectableChannel c() {
            return this.f3496a.b();
        }

        public final Socket d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PollItem)) {
                return false;
            }
            PollItem pollItem = (PollItem) obj;
            Socket socket = this.b;
            if (socket == null || socket != pollItem.b) {
                return c() != null && c() == pollItem.c();
            }
            return true;
        }

        public int hashCode() {
            return this.f3496a.hashCode();
        }
    }

    public static class Poller implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        public final Selector f3497a;
        public final Context b;

        public void close() {
            this.b.b(this.f3497a);
        }
    }

    public static class Socket implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        public final ZContext f3498a;
        public final SocketBase b;
        public final AtomicBoolean c;

        public enum Mechanism {
            NULL(Mechanisms.NULL),
            PLAIN(Mechanisms.PLAIN),
            CURVE(Mechanisms.CURVE);
            
            private final Mechanisms mech;

            private Mechanism(Mechanisms mechanisms) {
                this.mech = mechanisms;
            }

            /* access modifiers changed from: private */
            public static Mechanism find(Mechanisms mechanisms) {
                for (Mechanism mechanism : values()) {
                    if (mechanism.mech == mechanisms) {
                        return mechanism;
                    }
                }
                return null;
            }
        }

        public Socket(ZContext zContext, SocketType socketType) {
            this(zContext.d(), zContext, socketType.type);
        }

        public boolean J(String str) {
            return z(str.getBytes(ZMQ.f), 2);
        }

        public boolean N(int i) {
            return this.b.f2(17, Integer.valueOf(i));
        }

        public boolean S(int i) {
            return c0(24, Integer.valueOf(i));
        }

        public boolean T(int i) {
            return c0(27, Integer.valueOf(i));
        }

        public boolean U(int i) {
            return c0(23, Integer.valueOf(i));
        }

        public SocketBase b() {
            return this.b;
        }

        public boolean c(String str) {
            boolean s1 = this.b.s1(str);
            j();
            return s1;
        }

        public final boolean c0(int i, Object obj) {
            boolean z = false;
            try {
                boolean f2 = this.b.f2(i, obj);
                if (this.b.y1() != 22) {
                    z = true;
                }
                return f2 & z;
            } catch (ZError.CtxTerminatedException unused) {
                return false;
            }
        }

        public void close() {
            ZContext zContext = this.f3498a;
            if (zContext != null) {
                zContext.a(this);
            } else {
                i();
            }
        }

        public boolean d(String str) {
            boolean v1 = this.b.v1(str);
            j();
            return v1;
        }

        public boolean d0(String str) {
            return c0(6, str);
        }

        public String g() {
            return (String) this.b.R1(32);
        }

        public void i() {
            if (this.c.compareAndSet(false, true)) {
                this.b.close();
            }
        }

        public void j() {
            int y1 = this.b.y1();
            if (y1 != 0 && y1 != 35) {
                throw new ZMQException(y1);
            }
        }

        public boolean n(String str, int i) {
            return this.b.Y1(str, i);
        }

        public byte[] o() {
            return r(0);
        }

        public byte[] r(int i) {
            Msg b2 = this.b.b2(i);
            if (b2 != null) {
                return b2.c();
            }
            j();
            return null;
        }

        public String s() {
            return u(0);
        }

        public String toString() {
            return this.b.toString();
        }

        public String u(int i) {
            byte[] r = r(i);
            if (r != null) {
                return new String(r, ZMQ.f);
            }
            return null;
        }

        public boolean v(String str) {
            return z(str.getBytes(ZMQ.f), 0);
        }

        public boolean w(byte[] bArr) {
            return z(bArr, 0);
        }

        public boolean z(byte[] bArr, int i) {
            if (this.b.d2(new Msg(bArr), i)) {
                return true;
            }
            j();
            return false;
        }

        public Socket(Context context, ZContext zContext, int i) {
            this.c = new AtomicBoolean(false);
            this.f3498a = zContext;
            this.b = context.b.h(i);
        }
    }

    public static Context a(int i) {
        return new Context(i);
    }

    public enum Error {
        ENOTSUP(45, "Not supported"),
        EPROTONOSUPPORT(43, "Protocol not supported"),
        ENOBUFS(55, "No buffer space available"),
        ENETDOWN(50, "Network is down"),
        EADDRINUSE(48, "Address already in use"),
        EADDRNOTAVAIL(49, "Address not available"),
        ECONNREFUSED(61, "Connection refused"),
        EINPROGRESS(36, "Operation in progress"),
        EHOSTUNREACH(65, "Host unreachable"),
        EMTHREAD(156384766, "No thread available"),
        EFSM(156384763, "Operation cannot be accomplished in current state"),
        ENOCOMPATPROTO(156384764, "The protocol is not compatible with the socket type"),
        ETERM(156384765, "Context was terminated"),
        ENOTSOCK(156384717, "Not a socket"),
        EAGAIN(35, "Resource unavailable, try again"),
        ENOENT(2, "No such file or directory"),
        EINTR(4, "Interrupted function"),
        EACCESS(13, "Permission denied"),
        EFAULT(14, "Bad address"),
        EINVAL(22, "Invalid argument"),
        EISCONN(56, "Socket is connected"),
        ENOTCONN(57, "The socket is not connected"),
        EMSGSIZE(156384722, "Message too large"),
        EAFNOSUPPORT(156384723, "Address family not supported"),
        ENETUNREACH(156384724, "Network unreachable"),
        ECONNABORTED(156384725, "Connection aborted"),
        ECONNRESET(156384726, "Connection reset"),
        ETIMEDOUT(156384728, "Connection timed out"),
        ENETRESET(156384730, "Connection aborted by network"),
        EIOEXC(156384817),
        ESOCKET(156384818),
        EMFILE(156384819, "File descriptor value too large"),
        EPROTO(156384820, "Protocol error");
        
        private static final Map<Integer, Error> map = null;
        private final int code;
        private final String message;

        static {
            int i;
            map = new HashMap(values().length);
            for (Error error : values()) {
                map.put(Integer.valueOf(error.code), error);
            }
        }

        private Error(int i) {
            this.code = i;
            this.message = "errno " + Integer.toString(i);
        }

        public static Error findByCode(int i) {
            Map<Integer, Error> map2 = map;
            if (map2.containsKey(Integer.valueOf(i))) {
                return map2.get(Integer.valueOf(i));
            }
            throw new IllegalArgumentException("Unknown " + Error.class.getName() + " enum code: " + i);
        }

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        private Error(int i, String str) {
            this.code = i;
            this.message = str;
        }
    }
}
