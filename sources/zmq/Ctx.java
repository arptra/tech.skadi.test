package zmq;

import com.honey.account.xc.a;
import java.io.IOException;
import java.lang.Thread;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.nio.channels.SelectableChannel;
import java.nio.channels.Selector;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.zeromq.ZMQException;
import zmq.Command;
import zmq.ZError;
import zmq.io.IOThread;
import zmq.pipe.Pipe;
import zmq.socket.Sockets;
import zmq.util.Errno;
import zmq.util.MultiMap;

public class Ctx {
    public static AtomicInteger z = new AtomicInteger(0);

    /* renamed from: a  reason: collision with root package name */
    public boolean f3594a = true;
    public final List b = new ArrayList();
    public final Deque c = new ArrayDeque();
    public final AtomicBoolean d = new AtomicBoolean(true);
    public boolean e = false;
    public final Lock f = new ReentrantLock();
    public final List g = new ArrayList();
    public Reaper h = null;
    public final List i = new ArrayList();
    public int j = 0;
    public IMailbox[] k = null;
    public final Mailbox l = new Mailbox(this, "terminater", -1);
    public final Map m = new HashMap();
    public final Lock n = new ReentrantLock();
    public int o = 1024;
    public int p = 1;
    public boolean q = true;
    public final Lock r = new ReentrantLock();
    public final Lock s = new ReentrantLock();
    public final MultiMap t = new MultiMap();
    public boolean u = false;
    public final Errno v = new Errno();
    public Thread.UncaughtExceptionHandler w = Thread.getDefaultUncaughtExceptionHandler();
    public Thread.UncaughtExceptionHandler x = new a();
    public ChannelForwardHolder y = null;

    public static class ChannelForwardHolder {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f3595a;
        public final Map b;
        public final Map c;
        public final ReferenceQueue d;

        public ChannelForwardHolder() {
            this.f3595a = new AtomicInteger(0);
            this.b = new ConcurrentHashMap();
            this.c = new ConcurrentHashMap();
            this.d = new ReferenceQueue();
        }
    }

    public static class Endpoint {

        /* renamed from: a  reason: collision with root package name */
        public final SocketBase f3596a;
        public final Options b;

        public Endpoint(SocketBase socketBase, Options options) {
            this.f3596a = socketBase;
            this.b = options;
        }
    }

    public static class PendingConnection {

        /* renamed from: a  reason: collision with root package name */
        public final Endpoint f3597a;
        public final Pipe b;
        public final Pipe c;

        public PendingConnection(Endpoint endpoint, Pipe pipe, Pipe pipe2) {
            this.f3597a = endpoint;
            this.b = pipe;
            this.c = pipe2;
        }
    }

    public enum Side {
        CONNECT,
        BIND
    }

    public void A(SocketBase socketBase) {
        this.n.lock();
        try {
            Iterator it = this.m.entrySet().iterator();
            while (it.hasNext()) {
                if (((Endpoint) ((Map.Entry) it.next()).getValue()).f3596a == socketBase) {
                    it.remove();
                }
            }
        } finally {
            this.n.unlock();
        }
    }

    public IOThread b(long j2) {
        IOThread iOThread = null;
        if (this.i.isEmpty()) {
            return null;
        }
        int i2 = -1;
        for (int i3 = 0; i3 != this.i.size(); i3++) {
            if (j2 == 0 || ((1 << i3) & j2) > 0) {
                int f1 = ((IOThread) this.i.get(i3)).f1();
                if (iOThread == null || f1 < i2) {
                    iOThread = (IOThread) this.i.get(i3);
                    i2 = f1;
                }
            }
        }
        return iOThread;
    }

    public final void c() {
        while (true) {
            Reference poll = this.y.d.poll();
            if (poll != null) {
                this.y.b.remove((Integer) this.y.c.remove(poll));
            } else {
                return;
            }
        }
    }

    public boolean d(Selector selector) {
        this.s.lock();
        try {
            boolean remove = this.g.remove(selector);
            if (remove) {
                selector.close();
            }
            this.s.unlock();
            return remove;
        } catch (IOException e2) {
            throw new ZError.IOException(e2);
        } catch (Throwable th) {
            this.s.unlock();
            throw th;
        }
    }

    public final void e(SocketBase socketBase, Options options, PendingConnection pendingConnection, Side side) {
        socketBase.h1();
        pendingConnection.c.d1(socketBase.z());
        if (!options.x) {
            pendingConnection.c.q1();
        }
        int i2 = (pendingConnection.f3597a.b.f3601a == 0 || options.b == 0) ? 0 : pendingConnection.f3597a.b.f3601a + options.b;
        int i3 = (pendingConnection.f3597a.b.b == 0 || options.f3601a == 0) ? 0 : pendingConnection.f3597a.b.b + options.f3601a;
        boolean z2 = pendingConnection.f3597a.b.S && (pendingConnection.f3597a.b.m == 5 || pendingConnection.f3597a.b.m == 7 || pendingConnection.f3597a.b.m == 8 || pendingConnection.f3597a.b.m == 1 || pendingConnection.f3597a.b.m == 2);
        if (z2) {
            i2 = -1;
        }
        if (z2) {
            i3 = -1;
        }
        int[] iArr = {i2, i3};
        pendingConnection.b.w1(iArr[1], iArr[0]);
        pendingConnection.c.w1(iArr[0], iArr[1]);
        if (options.f0 && options.e0 != null) {
            pendingConnection.b.u1(options.e0);
        }
        if (side == Side.BIND) {
            socketBase.d0(new Command((ZObject) null, Command.Type.BIND, pendingConnection.c));
            socketBase.Q0(pendingConnection.f3597a.f3596a);
        } else {
            pendingConnection.b.M0(socketBase, pendingConnection.c, false);
        }
        if (pendingConnection.f3597a.b.x && pendingConnection.f3597a.f3596a.U1()) {
            Msg msg = new Msg((int) options.d);
            msg.D(options.e, 0, options.d);
            msg.J(64);
            pendingConnection.c.C1(msg);
            pendingConnection.c.flush();
        }
        if (options.d0 && options.c0 != null) {
            pendingConnection.c.C1(options.c0);
            pendingConnection.c.flush();
        }
    }

    public void f(String str, SocketBase socketBase) {
        this.n.lock();
        try {
            Collection<PendingConnection> g2 = this.t.g(str);
            if (g2 != null) {
                for (PendingConnection e2 : g2) {
                    e(socketBase, ((Endpoint) this.m.get(str)).b, e2, Side.BIND);
                }
            }
        } finally {
            this.n.unlock();
        }
    }

    public Selector g() {
        this.s.lock();
        try {
            Selector open = Selector.open();
            this.g.add(open);
            this.s.unlock();
            return open;
        } catch (IOException e2) {
            throw new ZError.IOException(e2);
        } catch (Throwable th) {
            this.s.unlock();
            throw th;
        }
    }

    public SocketBase h(int i2) {
        this.f.lock();
        try {
            if (this.d.compareAndSet(true, false)) {
                s();
            }
            if (this.e) {
                throw new ZError.CtxTerminatedException();
            } else if (!this.c.isEmpty()) {
                Integer num = (Integer) this.c.pollLast();
                int intValue = num.intValue();
                SocketBase create = Sockets.create(i2, this, intValue, z.incrementAndGet());
                if (create == null) {
                    this.c.addLast(num);
                    this.f.unlock();
                    return null;
                }
                this.b.add(create);
                this.k[intValue] = create.P1();
                this.f.unlock();
                return create;
            } else {
                throw new ZMQException(156384819);
            }
        } catch (Throwable th) {
            this.f.unlock();
            throw th;
        }
    }

    public final void i() {
        for (IOThread j1 : this.i) {
            j1.j1();
        }
        for (IOThread close : this.i) {
            close.close();
        }
        this.i.clear();
        this.s.lock();
        try {
            for (Selector selector : this.g) {
                if (selector != null) {
                    selector.close();
                }
            }
            this.g.clear();
            this.s.unlock();
            Reaper reaper = this.h;
            if (reaper != null) {
                reaper.close();
            }
            this.l.close();
            this.f3594a = false;
        } catch (Throwable th) {
            this.s.unlock();
            throw th;
        }
    }

    public void j(SocketBase socketBase) {
        this.f.lock();
        try {
            int z2 = socketBase.z();
            this.c.add(Integer.valueOf(z2));
            this.k[z2] = null;
            this.b.remove(socketBase);
            if (this.e && this.b.isEmpty()) {
                this.h.i1();
            }
        } finally {
            this.f.unlock();
        }
    }

    public Errno k() {
        return this.v;
    }

    public Endpoint l(String str) {
        this.n.lock();
        try {
            Endpoint endpoint = (Endpoint) this.m.get(str);
            if (endpoint == null) {
                return new Endpoint((SocketBase) null, new Options());
            }
            endpoint.f3596a.h1();
            this.n.unlock();
            return endpoint;
        } finally {
            this.n.unlock();
        }
    }

    public int m(SelectableChannel selectableChannel) {
        synchronized (ChannelForwardHolder.class) {
            try {
                if (this.y == null) {
                    this.y = new ChannelForwardHolder();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        WeakReference weakReference = new WeakReference(selectableChannel, this.y.d);
        int andIncrement = this.y.f3595a.getAndIncrement();
        this.y.b.put(Integer.valueOf(andIncrement), weakReference);
        this.y.c.put(weakReference, Integer.valueOf(andIncrement));
        c();
        return andIncrement;
    }

    public int n(int i2) {
        if (i2 == 2) {
            return this.o;
        }
        if (i2 == 1) {
            return this.p;
        }
        if (i2 == 70) {
            return this.q ? 1 : 0;
        }
        if (i2 == 42) {
            return this.u ? 1 : 0;
        }
        throw new IllegalArgumentException("option = " + i2);
    }

    public SelectableChannel o(Integer num) {
        c();
        WeakReference weakReference = (WeakReference) this.y.b.remove(num);
        if (weakReference != null) {
            return (SelectableChannel) weakReference.get();
        }
        return null;
    }

    public Thread.UncaughtExceptionHandler p() {
        return this.x;
    }

    public ZObject q() {
        return this.h;
    }

    public Thread.UncaughtExceptionHandler r() {
        return this.w;
    }

    public final void s() {
        int i2;
        this.f.lock();
        try {
            this.r.lock();
            int i3 = this.p;
            this.j = this.o + i3 + 2;
            this.r.unlock();
            IMailbox[] iMailboxArr = new IMailbox[this.j];
            this.k = iMailboxArr;
            iMailboxArr[0] = this.l;
            Reaper reaper = new Reaper(this, 1);
            this.h = reaper;
            this.k[1] = reaper.g1();
            this.h.h1();
            int i4 = 2;
            while (true) {
                i2 = i3 + 2;
                if (i4 == i2) {
                    break;
                }
                IOThread iOThread = new IOThread(this, i4);
                this.i.add(iOThread);
                this.k[i4] = iOThread.g1();
                iOThread.i1();
                i4++;
            }
            for (int i5 = this.j - 1; i5 >= i2; i5--) {
                this.c.add(Integer.valueOf(i5));
                this.k[i5] = null;
            }
            this.f.unlock();
        } catch (Throwable th) {
            this.f.unlock();
            throw th;
        }
    }

    public boolean t() {
        return this.f3594a;
    }

    public void v(String str, Endpoint endpoint, Pipe[] pipeArr) {
        PendingConnection pendingConnection = new PendingConnection(endpoint, pipeArr[0], pipeArr[1]);
        this.n.lock();
        try {
            Endpoint endpoint2 = (Endpoint) this.m.get(str);
            if (endpoint2 == null) {
                endpoint.f3596a.h1();
                this.t.e(str, pendingConnection);
            } else {
                e(endpoint2.f3596a, endpoint2.b, pendingConnection, Side.CONNECT);
            }
        } finally {
            this.n.unlock();
        }
    }

    public boolean w(String str, Endpoint endpoint) {
        this.n.lock();
        try {
            return ((Endpoint) this.m.put(str, endpoint)) == null;
        } finally {
            this.n.unlock();
        }
    }

    public void x(int i2, Command command) {
        this.k[i2].D(command);
    }

    public boolean y(int i2, int i3) {
        if (i2 == 2 && i3 >= 1) {
            this.r.lock();
            try {
                this.o = i3;
            } finally {
                this.r.unlock();
            }
        } else if (i2 != 1 || i3 < 0) {
            boolean z2 = false;
            if (i2 == 70 && i3 >= 0) {
                this.r.lock();
                if (i3 != 0) {
                    z2 = true;
                }
                try {
                    this.q = z2;
                } finally {
                    this.r.unlock();
                }
            } else if (i2 != 42 || i3 < 0) {
                return false;
            } else {
                this.r.lock();
                if (i3 != 0) {
                    z2 = true;
                }
                try {
                    this.u = z2;
                } finally {
                    this.r.unlock();
                }
            }
        } else {
            this.r.lock();
            try {
                this.p = i3;
            } finally {
                this.r.unlock();
            }
        }
        return true;
    }

    public void z() {
        this.f.lock();
        try {
            for (Map.Entry value : this.t.a()) {
                SocketBase h2 = h(0);
                h2.s1((String) value.getValue());
                h2.close();
            }
            if (!this.d.get()) {
                boolean z2 = this.e;
                this.e = true;
                if (!z2) {
                    for (SocketBase h22 : this.b) {
                        h22.h2();
                    }
                    if (this.b.isEmpty()) {
                        this.h.i1();
                    }
                }
            }
            this.f.unlock();
            if (!this.d.get()) {
                if (this.l.M(-1) != null) {
                    this.f.lock();
                    this.f.unlock();
                } else {
                    throw new ZMQException(this.v.a());
                }
            }
            try {
                i();
            } catch (IOException e2) {
                throw new ZError.IOException(e2);
            }
        } catch (Throwable th) {
            this.f.unlock();
            throw th;
        }
    }
}
