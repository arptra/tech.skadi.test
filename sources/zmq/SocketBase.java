package zmq;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import zmq.Ctx;
import zmq.ZMQ;
import zmq.io.IOThread;
import zmq.io.net.Listener;
import zmq.io.net.NetProtocol;
import zmq.pipe.Pipe;
import zmq.poll.IPollEvents;
import zmq.poll.Poller;
import zmq.util.Clock;
import zmq.util.MultiMap;

public abstract class SocketBase extends Own implements IPollEvents, Pipe.IPipeEvents {
    public String A;
    public final ReentrantLock B;
    public final boolean C;
    public final ReentrantLock D;
    public Signaler E;
    public final MultiMap k;
    public final MultiMap l;
    public boolean m;
    public AtomicBoolean n;
    public ThreadLocal o;
    public AtomicBoolean p;
    public final IMailbox q;
    public final Set r;
    public Poller s;
    public Poller.Handle t;
    public long u;
    public int v;
    public boolean w;
    public SocketChannel x;
    public SocketBase y;
    public int z;

    /* renamed from: zmq.SocketBase$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3604a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                zmq.io.net.NetProtocol[] r0 = zmq.io.net.NetProtocol.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3604a = r0
                zmq.io.net.NetProtocol r1 = zmq.io.net.NetProtocol.inproc     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3604a     // Catch:{ NoSuchFieldError -> 0x001d }
                zmq.io.net.NetProtocol r1 = zmq.io.net.NetProtocol.pgm     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3604a     // Catch:{ NoSuchFieldError -> 0x0028 }
                zmq.io.net.NetProtocol r1 = zmq.io.net.NetProtocol.epgm     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3604a     // Catch:{ NoSuchFieldError -> 0x0033 }
                zmq.io.net.NetProtocol r1 = zmq.io.net.NetProtocol.norm     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3604a     // Catch:{ NoSuchFieldError -> 0x003e }
                zmq.io.net.NetProtocol r1 = zmq.io.net.NetProtocol.tcp     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f3604a     // Catch:{ NoSuchFieldError -> 0x0049 }
                zmq.io.net.NetProtocol r1 = zmq.io.net.NetProtocol.ipc     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f3604a     // Catch:{ NoSuchFieldError -> 0x0054 }
                zmq.io.net.NetProtocol r1 = zmq.io.net.NetProtocol.tipc     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zmq.SocketBase.AnonymousClass1.<clinit>():void");
        }
    }

    public static class EndpointPipe {

        /* renamed from: a  reason: collision with root package name */
        public final Own f3605a;
        public final Pipe b;

        public EndpointPipe(Own own, Pipe pipe) {
            this.f3605a = own;
            this.b = pipe;
        }

        public String toString() {
            return "EndpointPipe [endpoint=" + this.f3605a + ", pipe=" + this.b + "]";
        }
    }

    public static class SimpleURI {

        /* renamed from: a  reason: collision with root package name */
        public final String f3606a;
        public final String b;

        public SimpleURI(String str, String str2) {
            this.f3606a = str;
            this.b = str2;
        }

        public static SimpleURI a(String str) {
            int indexOf = str.indexOf("://");
            if (indexOf >= 0) {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 3);
                if (!substring.isEmpty() && !substring2.isEmpty()) {
                    return new SimpleURI(substring, substring2);
                }
                throw new IllegalArgumentException("Invalid URI: " + str);
            }
            throw new IllegalArgumentException("Invalid URI: " + str);
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.f3606a;
        }
    }

    public SocketBase(Ctx ctx, int i, int i2) {
        this(ctx, i, i2, false);
    }

    public final void A1(String str, int i) {
        z1(str, Integer.valueOf(i), 64);
    }

    public final void B1(String str, SelectableChannel selectableChannel) {
        z1(str, selectableChannel, 32);
    }

    public final void C0() {
        try {
            this.B.lock();
            i2();
            this.n.set(true);
        } finally {
            this.B.unlock();
        }
    }

    public final void C1(String str, int i) {
        z1(str, Integer.valueOf(i), 16);
    }

    public final void D0(int i) {
        e1(this);
        for (Pipe pipe : this.r) {
            pipe.s1();
            pipe.B1(false);
        }
        l1(this.r.size());
        super.D0(i);
    }

    public final void D1(String str, int i) {
        z1(str, Integer.valueOf(i), 256);
    }

    public final void E1(String str, SelectableChannel selectableChannel) {
        z1(str, selectableChannel, 128);
    }

    public final void F1(String str, int i) {
        z1(str, Integer.valueOf(i), 2);
    }

    public final void G1(String str, int i) {
        z1(str, Integer.valueOf(i), 4);
    }

    public final void H1(String str, SelectableChannel selectableChannel) {
        z1(str, selectableChannel, 1);
    }

    public final void I1(String str, SelectableChannel selectableChannel) {
        z1(str, selectableChannel, 512);
    }

    public final void J1(String str, int i) {
        z1(str, Integer.valueOf(i), 16384);
    }

    public final void K1(String str, int i) {
        z1(str, Integer.valueOf(i), 8192);
    }

    public final void L1(String str, int i) {
        z1(str, Integer.valueOf(i), 32768);
    }

    public final void M1(String str, SelectableChannel selectableChannel) {
        z1(str, selectableChannel, 8);
    }

    public final void N1(Msg msg) {
        msg.u();
        this.w = msg.n();
    }

    public final SelectableChannel O1() {
        if (!this.C) {
            return ((Mailbox) this.q).a();
        }
        this.j.c(22);
        return null;
    }

    public final IMailbox P1() {
        return this.q;
    }

    public final int Q1(int i) {
        X1();
        try {
            if (this.n.get()) {
                this.j.c(156384765);
                return -1;
            } else if (i == 13) {
                boolean z2 = this.w;
                j2();
                return z2 ? 1 : 0;
            } else if (i == 15) {
                int i2 = 0;
                if (a2(0, false, (AtomicBoolean) null) || !(this.j.a() == 156384765 || this.j.a() == 4)) {
                    if (T1()) {
                        i2 = 2;
                    }
                    if (S1()) {
                        i2 |= 1;
                    }
                    j2();
                    return i2;
                }
                j2();
                return -1;
            } else {
                Object d = this.c.d(i);
                if (d instanceof Integer) {
                    int intValue = ((Integer) d).intValue();
                    j2();
                    return intValue;
                } else if (d instanceof Boolean) {
                    boolean booleanValue = ((Boolean) d).booleanValue();
                    j2();
                    return booleanValue ? 1 : 0;
                } else {
                    throw new IllegalArgumentException(d + " is neither an integer or a boolean for option " + i);
                }
            }
        } finally {
            j2();
        }
    }

    public final Object R1(int i) {
        if (this.n.get()) {
            this.j.c(156384765);
            return null;
        } else if (i == 13) {
            return Integer.valueOf(this.w ? 1 : 0);
        } else {
            if (i == 14) {
                if (!this.C) {
                    return ((Mailbox) this.q).a();
                }
                this.j.c(22);
                return null;
            } else if (i != 15) {
                return this.c.d(i);
            } else {
                int i2 = 0;
                if (!a2(0, false, (AtomicBoolean) null) && (this.j.a() == 156384765 || this.j.a() == 4)) {
                    return -1;
                }
                if (T1()) {
                    i2 = 2;
                }
                if (S1()) {
                    i2 |= 1;
                }
                return Integer.valueOf(i2);
            }
        }
    }

    public final boolean S1() {
        return l2();
    }

    public final boolean T1() {
        return m2();
    }

    public final void U(Pipe pipe) {
        q1(pipe, false);
    }

    public boolean U1() {
        return this.m;
    }

    public final boolean V1() {
        Boolean bool = (Boolean) this.o.get();
        return bool != null && bool.booleanValue();
    }

    public final void W1() {
        this.o.remove();
    }

    public final void X1() {
        if (this.C) {
            this.D.lock();
        }
    }

    public final boolean Y1(String str, int i) {
        try {
            this.B.lock();
            if (this.n.get()) {
                this.j.c(156384765);
            } else if (str == null) {
                i2();
                this.B.unlock();
                return true;
            } else if (this.y == null) {
                NetProtocol u1 = u1(SimpleURI.a(str).c());
                if (u1 != null) {
                    if (u1 != NetProtocol.inproc) {
                        this.j.c(43);
                    } else {
                        this.z = i;
                        SocketBase h = w().h(0);
                        this.y = h;
                        if (h != null) {
                            h.f2(17, 0);
                            boolean s1 = this.y.s1(str);
                            if (!s1) {
                                i2();
                            }
                            this.B.unlock();
                            return s1;
                        }
                    }
                }
            } else {
                throw new IllegalStateException("Monitor registred twice");
            }
            this.B.unlock();
            return false;
        } catch (IllegalArgumentException e) {
            i2();
            throw e;
        } catch (Throwable th) {
            this.B.unlock();
            throw th;
        }
    }

    public final void Z1(ZMQ.Event event) {
        SocketBase socketBase = this.y;
        if (socketBase != null) {
            event.c(socketBase);
        }
    }

    public final boolean a2(int i, boolean z2, AtomicBoolean atomicBoolean) {
        Command M = i != 0 ? this.q.M((long) i) : this.q.M(0);
        while (M != null) {
            M.a();
            M = this.q.M(0);
        }
        if (!V1() && this.p.get()) {
            X0();
        }
        if (this.j.a() == 4) {
            return false;
        }
        if (atomicBoolean != null && atomicBoolean.get()) {
            this.j.c(125);
            return false;
        } else if (!this.n.get()) {
            return true;
        } else {
            this.j.c(156384765);
            return false;
        }
    }

    public final void b(Pipe pipe) {
        t2(pipe);
    }

    public final Msg b2(int i) {
        return c2(i, (AtomicBoolean) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0077 A[Catch:{ all -> 0x0018 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0079 A[Catch:{ all -> 0x0018 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0084 A[SYNTHETIC, Splitter:B:51:0x0084] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final zmq.Msg c2(int r10, java.util.concurrent.atomic.AtomicBoolean r11) {
        /*
            r9 = this;
            r9.X1()
            java.util.concurrent.atomic.AtomicBoolean r0 = r9.n     // Catch:{ all -> 0x0018 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0018 }
            r1 = 0
            if (r0 == 0) goto L_0x001b
            zmq.util.Errno r10 = r9.j     // Catch:{ all -> 0x0018 }
            r11 = 156384765(0x9523dfd, float:2.5306977E-33)
            r10.c(r11)     // Catch:{ all -> 0x0018 }
            r9.j2()
            return r1
        L_0x0018:
            r10 = move-exception
            goto L_0x00d2
        L_0x001b:
            int r0 = r9.v     // Catch:{ all -> 0x0018 }
            r2 = 1
            int r0 = r0 + r2
            r9.v = r0     // Catch:{ all -> 0x0018 }
            zmq.Config r3 = zmq.Config.INBOUND_POLL_RATE     // Catch:{ all -> 0x0018 }
            int r3 = r3.getValue()     // Catch:{ all -> 0x0018 }
            r4 = 0
            if (r0 != r3) goto L_0x0036
            boolean r0 = r9.a2(r4, r4, r11)     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x0034
            r9.j2()
            return r1
        L_0x0034:
            r9.v = r4     // Catch:{ all -> 0x0018 }
        L_0x0036:
            zmq.Msg r0 = r9.q2()     // Catch:{ all -> 0x0018 }
            r3 = 35
            if (r0 != 0) goto L_0x004a
            zmq.util.Errno r5 = r9.j     // Catch:{ all -> 0x0018 }
            int r5 = r5.a()     // Catch:{ all -> 0x0018 }
            if (r5 == r3) goto L_0x004a
            r9.j2()
            return r1
        L_0x004a:
            if (r0 == 0) goto L_0x005a
            java.nio.channels.SocketChannel r10 = r9.x     // Catch:{ all -> 0x0018 }
            if (r10 == 0) goto L_0x0053
            r0.I(r10)     // Catch:{ all -> 0x0018 }
        L_0x0053:
            r9.N1(r0)     // Catch:{ all -> 0x0018 }
            r9.j2()
            return r0
        L_0x005a:
            r10 = r10 & r2
            if (r10 > 0) goto L_0x00b5
            zmq.Options r10 = r9.c     // Catch:{ all -> 0x0018 }
            int r10 = r10.s     // Catch:{ all -> 0x0018 }
            if (r10 != 0) goto L_0x0064
            goto L_0x00b5
        L_0x0064:
            if (r10 >= 0) goto L_0x0069
            r5 = 0
            goto L_0x006f
        L_0x0069:
            long r5 = zmq.util.Clock.a()     // Catch:{ all -> 0x0018 }
            long r7 = (long) r10     // Catch:{ all -> 0x0018 }
            long r5 = r5 + r7
        L_0x006f:
            int r0 = r9.v     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0074
            goto L_0x00b3
        L_0x0074:
            r0 = r4
        L_0x0075:
            if (r0 == 0) goto L_0x0079
            r0 = r10
            goto L_0x007a
        L_0x0079:
            r0 = r4
        L_0x007a:
            boolean r0 = r9.a2(r0, r4, r11)     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x0084
            r9.j2()
            return r1
        L_0x0084:
            zmq.Msg r0 = r9.q2()     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0093
            r9.v = r4     // Catch:{ all -> 0x0018 }
            r9.N1(r0)     // Catch:{ all -> 0x0018 }
            r9.j2()
            return r0
        L_0x0093:
            zmq.util.Errno r0 = r9.j     // Catch:{ all -> 0x0018 }
            int r0 = r0.a()     // Catch:{ all -> 0x0018 }
            if (r0 == r3) goto L_0x009f
            r9.j2()
            return r1
        L_0x009f:
            if (r10 <= 0) goto L_0x00b3
            long r7 = zmq.util.Clock.a()     // Catch:{ all -> 0x0018 }
            long r7 = r5 - r7
            int r10 = (int) r7     // Catch:{ all -> 0x0018 }
            if (r10 > 0) goto L_0x00b3
            zmq.util.Errno r10 = r9.j     // Catch:{ all -> 0x0018 }
            r10.c(r3)     // Catch:{ all -> 0x0018 }
            r9.j2()
            return r1
        L_0x00b3:
            r0 = r2
            goto L_0x0075
        L_0x00b5:
            boolean r10 = r9.a2(r4, r4, r11)     // Catch:{ all -> 0x0018 }
            if (r10 != 0) goto L_0x00bf
            r9.j2()
            return r1
        L_0x00bf:
            r9.v = r4     // Catch:{ all -> 0x0018 }
            zmq.Msg r10 = r9.q2()     // Catch:{ all -> 0x0018 }
            if (r10 != 0) goto L_0x00cb
            r9.j2()
            return r1
        L_0x00cb:
            r9.N1(r10)     // Catch:{ all -> 0x0018 }
            r9.j2()
            return r10
        L_0x00d2:
            r9.j2()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: zmq.SocketBase.c2(int, java.util.concurrent.atomic.AtomicBoolean):zmq.Msg");
    }

    public final void close() {
        X1();
        try {
            if (this.C) {
                ((MailboxSafe) this.q).b();
            }
            this.m = false;
            W0(this);
            j2();
        } catch (Throwable th) {
            j2();
            throw th;
        }
    }

    public final boolean d2(Msg msg, int i) {
        return e2(msg, i, (AtomicBoolean) null);
    }

    public final boolean e2(Msg msg, int i, AtomicBoolean atomicBoolean) {
        X1();
        try {
            if (this.n.get()) {
                this.j.c(156384765);
                return false;
            }
            if (msg != null) {
                if (msg.b()) {
                    if (!a2(0, true, atomicBoolean)) {
                        j2();
                        return false;
                    }
                    msg.F(1);
                    if ((i & 2) > 0) {
                        msg.J(1);
                    }
                    msg.G();
                    if (r2(msg)) {
                        j2();
                        return true;
                    } else if (this.j.a() != 35) {
                        j2();
                        return false;
                    } else {
                        if ((i & 1) <= 0) {
                            int i2 = this.c.t;
                            if (i2 != 0) {
                                long a2 = i2 < 0 ? 0 : Clock.a() + ((long) i2);
                                while (a2(i2, false, atomicBoolean)) {
                                    if (r2(msg)) {
                                        j2();
                                        return true;
                                    } else if (this.j.a() != 35) {
                                        j2();
                                        return false;
                                    } else if (i2 > 0) {
                                        i2 = (int) (a2 - Clock.a());
                                        if (i2 <= 0) {
                                            this.j.c(35);
                                            j2();
                                            return false;
                                        }
                                    }
                                }
                                j2();
                                return false;
                            }
                        }
                        j2();
                        return false;
                    }
                }
            }
            this.j.c(14);
            j2();
            return false;
        } finally {
            j2();
        }
    }

    public final boolean f2(int i, Object obj) {
        X1();
        try {
            if (this.n.get()) {
                this.j.c(156384765);
                return false;
            }
            boolean s2 = s2(i, obj);
            if (!s2) {
                if (this.j.a() == 22) {
                    boolean i2 = this.c.i(i, obj);
                    if (i2) {
                        this.j.c(0);
                    }
                    j2();
                    return i2;
                }
            }
            j2();
            return s2;
        } finally {
            j2();
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0014 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000d */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0011 A[SYNTHETIC, Splitter:B:8:0x0011] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g1() {
        /*
            r1 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r1.B     // Catch:{ all -> 0x000b }
            r0.lock()     // Catch:{ all -> 0x000b }
            zmq.IMailbox r0 = r1.q     // Catch:{ IOException -> 0x000d }
            r0.close()     // Catch:{ IOException -> 0x000d }
            goto L_0x000d
        L_0x000b:
            r0 = move-exception
            goto L_0x001d
        L_0x000d:
            zmq.Signaler r0 = r1.E     // Catch:{ all -> 0x000b }
            if (r0 == 0) goto L_0x0014
            r0.close()     // Catch:{ IOException -> 0x0014 }
        L_0x0014:
            r1.i2()     // Catch:{ all -> 0x000b }
            java.util.concurrent.locks.ReentrantLock r1 = r1.B
            r1.unlock()
            return
        L_0x001d:
            java.util.concurrent.locks.ReentrantLock r1 = r1.B
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zmq.SocketBase.g1():void");
    }

    public final void g2(Poller poller) {
        SelectableChannel selectableChannel;
        this.s = poller;
        if (!this.C) {
            selectableChannel = ((Mailbox) this.q).a();
        } else {
            this.D.lock();
            try {
                Signaler signaler = new Signaler(w(), z(), w().k());
                this.E = signaler;
                selectableChannel = signaler.i();
                ((MailboxSafe) this.q).a(this.E);
                this.E.w();
            } finally {
                this.D.unlock();
            }
        }
        Poller.Handle h = this.s.h(selectableChannel, this);
        this.t = h;
        this.s.r(h);
        this.n.set(true);
        n1();
        t1();
    }

    public final void h2() {
        Z0();
    }

    public final void i(Pipe pipe) {
        o2(pipe);
        this.l.i(pipe);
        this.r.remove(pipe);
        if (i1()) {
            o1();
        }
    }

    public final void i2() {
        if (this.y != null) {
            if ((this.z & 1024) != 0) {
                Z1(new ZMQ.Event(1024, "", 0));
            }
            this.y.close();
            this.y = null;
            this.z = 0;
        }
    }

    public final void j(Pipe pipe) {
        p2(pipe);
    }

    public final void j2() {
        if (this.C) {
            this.D.unlock();
        }
    }

    public final void k1() {
        this.p.set(true);
    }

    public abstract void k2(Pipe pipe, boolean z2, boolean z3);

    public boolean l2() {
        return false;
    }

    public boolean m2() {
        return false;
    }

    public final void n(Pipe pipe) {
        if (!this.c.v) {
            pipe.B1(false);
        } else {
            n2(pipe);
        }
    }

    public void n2(Pipe pipe) {
        throw new UnsupportedOperationException("Must override");
    }

    public final void o() {
        X1();
        try {
            if (this.C) {
                this.E.v();
            }
            x1();
            a2(0, false, (AtomicBoolean) null);
            W1();
            j2();
            t1();
        } catch (Throwable th) {
            W1();
            j2();
            throw th;
        }
    }

    public abstract void o2(Pipe pipe);

    public final void p1(String str, Own own, Pipe pipe) {
        j1(own);
        this.k.e(str, new EndpointPipe(own, pipe));
    }

    public void p2(Pipe pipe) {
        throw new UnsupportedOperationException("Must Override");
    }

    public final void q1(Pipe pipe, boolean z2) {
        r1(pipe, false, z2);
    }

    public Msg q2() {
        throw new UnsupportedOperationException("Must Override");
    }

    public final void r1(Pipe pipe, boolean z2, boolean z3) {
        pipe.v1(this);
        this.r.add(pipe);
        k2(pipe, z2, z3);
        if (i1()) {
            l1(1);
            pipe.B1(false);
        }
    }

    public boolean r2(Msg msg) {
        throw new UnsupportedOperationException("Must Override");
    }

    public final boolean s1(String str) {
        X1();
        try {
            if (this.n.get()) {
                this.j.c(156384765);
                return false;
            }
            Options options = this.c;
            options.G.check(options);
            if (!a2(0, false, (AtomicBoolean) null)) {
                j2();
                return false;
            }
            SimpleURI a2 = SimpleURI.a(str);
            String b = a2.b();
            NetProtocol u1 = u1(a2.c());
            if (u1 == null) {
                j2();
                return false;
            }
            switch (AnonymousClass1.f3604a[u1.ordinal()]) {
                case 1:
                    boolean G0 = G0(str, new Ctx.Endpoint(this, this.c));
                    if (G0) {
                        s(str, this);
                        this.c.f = str;
                    } else {
                        this.j.c(48);
                    }
                    j2();
                    return G0;
                case 2:
                case 3:
                case 4:
                    boolean v1 = v1(str);
                    j2();
                    return v1;
                case 5:
                case 6:
                case 7:
                    IOThread r2 = r(this.c.c);
                    if (r2 == null) {
                        this.j.c(156384766);
                        j2();
                        return false;
                    }
                    Listener listener = u1.getListener(r2, this, this.c);
                    if (!listener.q1(b)) {
                        listener.g1();
                        C1(b, this.j.a());
                        j2();
                        return false;
                    }
                    this.c.f = listener.p1();
                    p1(this.c.f, listener, (Pipe) null);
                    j2();
                    return true;
                default:
                    throw new IllegalArgumentException(str);
            }
            j2();
        } finally {
            j2();
        }
    }

    public boolean s2(int i, Object obj) {
        this.j.c(22);
        return false;
    }

    public final void t1() {
        if (this.p.get()) {
            this.s.m(this.t);
            u(this);
            Y0();
            super.k1();
        }
    }

    public void t2(Pipe pipe) {
        throw new UnsupportedOperationException("Must Override");
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + this.c.R + "]";
    }

    public final NetProtocol u1(String str) {
        try {
            NetProtocol protocol = NetProtocol.getProtocol(str);
            if (!protocol.valid) {
                this.j.c(43);
                return protocol;
            } else if (protocol.compatible(this.c.m)) {
                return protocol;
            } else {
                this.j.c(156384764);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            this.j.c(43);
            return null;
        }
    }

    public final boolean v1(String str) {
        X1();
        try {
            return w1(str);
        } finally {
            j2();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0057, code lost:
        r6 = r2.b.b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean w1(java.lang.String r14) {
        /*
            r13 = this;
            r0 = 1
            r1 = 2
            java.util.concurrent.atomic.AtomicBoolean r2 = r13.n
            boolean r2 = r2.get()
            r3 = 0
            if (r2 == 0) goto L_0x0014
            zmq.util.Errno r13 = r13.j
            r14 = 156384765(0x9523dfd, float:2.5306977E-33)
            r13.c(r14)
            return r3
        L_0x0014:
            zmq.Options r2 = r13.c
            zmq.io.mechanism.Mechanisms r4 = r2.G
            r4.check(r2)
            r2 = 0
            boolean r4 = r13.a2(r3, r3, r2)
            if (r4 != 0) goto L_0x0023
            return r3
        L_0x0023:
            zmq.SocketBase$SimpleURI r4 = zmq.SocketBase.SimpleURI.a(r14)
            java.lang.String r5 = r4.b()
            java.lang.String r4 = r4.c()
            zmq.io.net.NetProtocol r4 = r13.u1(r4)
            if (r4 == 0) goto L_0x0214
            boolean r6 = r4.valid
            if (r6 != 0) goto L_0x003b
            goto L_0x0214
        L_0x003b:
            zmq.io.net.NetProtocol r6 = zmq.io.net.NetProtocol.inproc
            r7 = 8
            r8 = 7
            r9 = 5
            r10 = -1
            if (r4 != r6) goto L_0x0187
            zmq.Ctx$Endpoint r2 = r13.v(r14)
            zmq.SocketBase r4 = r2.f3596a
            if (r4 != 0) goto L_0x0051
            zmq.Options r5 = r13.c
            int r5 = r5.f3601a
            goto L_0x0060
        L_0x0051:
            zmq.Options r5 = r13.c
            int r5 = r5.f3601a
            if (r5 == 0) goto L_0x005f
            zmq.Options r6 = r2.b
            int r6 = r6.b
            if (r6 == 0) goto L_0x005f
            int r5 = r5 + r6
            goto L_0x0060
        L_0x005f:
            r5 = r3
        L_0x0060:
            if (r4 != 0) goto L_0x0067
            zmq.Options r6 = r13.c
            int r6 = r6.b
            goto L_0x0076
        L_0x0067:
            zmq.Options r6 = r13.c
            int r6 = r6.b
            if (r6 == 0) goto L_0x0075
            zmq.Options r11 = r2.b
            int r11 = r11.f3601a
            if (r11 == 0) goto L_0x0075
            int r6 = r6 + r11
            goto L_0x0076
        L_0x0075:
            r6 = r3
        L_0x0076:
            if (r4 != 0) goto L_0x0079
            r4 = r13
        L_0x0079:
            zmq.ZObject[] r11 = new zmq.ZObject[r1]
            r11[r3] = r13
            r11[r0] = r4
            zmq.Options r4 = r13.c
            boolean r12 = r4.S
            if (r12 == 0) goto L_0x0093
            int r4 = r4.m
            if (r4 == r9) goto L_0x0091
            if (r4 == r8) goto L_0x0091
            if (r4 == r7) goto L_0x0091
            if (r4 == r0) goto L_0x0091
            if (r4 != r1) goto L_0x0093
        L_0x0091:
            r4 = r0
            goto L_0x0094
        L_0x0093:
            r4 = r3
        L_0x0094:
            if (r4 == 0) goto L_0x0097
            r5 = r10
        L_0x0097:
            if (r4 == 0) goto L_0x009a
            goto L_0x009b
        L_0x009a:
            r10 = r6
        L_0x009b:
            int[] r5 = new int[]{r5, r10}
            boolean[] r1 = new boolean[r1]
            r1[r3] = r4
            r1[r0] = r4
            zmq.pipe.Pipe[] r1 = zmq.pipe.Pipe.o1(r11, r5, r1)
            r4 = r1[r3]
            r13.q1(r4, r0)
            zmq.SocketBase r4 = r2.f3596a
            r5 = 64
            if (r4 != 0) goto L_0x00f3
            zmq.Msg r2 = new zmq.Msg
            zmq.Options r4 = r13.c
            short r4 = r4.d
            r2.<init>((int) r4)
            zmq.Options r4 = r13.c
            byte[] r6 = r4.e
            short r4 = r4.d
            r2.D(r6, r3, r4)
            r2.J(r5)
            r4 = r1[r3]
            r4.C1(r2)
            r2 = r1[r3]
            r2.flush()
            zmq.Options r2 = r13.c
            boolean r4 = r2.d0
            if (r4 == 0) goto L_0x00e7
            zmq.Msg r2 = r2.c0
            if (r2 == 0) goto L_0x00e7
            r4 = r1[r3]
            r4.C1(r2)
            r2 = r1[r3]
            r2.flush()
        L_0x00e7:
            zmq.Ctx$Endpoint r2 = new zmq.Ctx$Endpoint
            zmq.Options r4 = r13.c
            r2.<init>(r13, r4)
            r13.J(r14, r2, r1)
            goto L_0x017b
        L_0x00f3:
            zmq.Options r4 = r2.b
            boolean r4 = r4.x
            if (r4 == 0) goto L_0x0118
            zmq.Msg r4 = new zmq.Msg
            zmq.Options r6 = r13.c
            short r6 = r6.d
            r4.<init>((int) r6)
            zmq.Options r6 = r13.c
            byte[] r7 = r6.e
            short r6 = r6.d
            r4.D(r7, r3, r6)
            r4.J(r5)
            r6 = r1[r3]
            r6.C1(r4)
            r4 = r1[r3]
            r4.flush()
        L_0x0118:
            zmq.Options r4 = r13.c
            boolean r4 = r4.x
            if (r4 == 0) goto L_0x013d
            zmq.Msg r4 = new zmq.Msg
            zmq.Options r6 = r2.b
            short r6 = r6.d
            r4.<init>((int) r6)
            zmq.Options r6 = r2.b
            byte[] r7 = r6.e
            short r6 = r6.d
            r4.D(r7, r3, r6)
            r4.J(r5)
            r5 = r1[r0]
            r5.C1(r4)
            r4 = r1[r0]
            r4.flush()
        L_0x013d:
            zmq.Options r4 = r13.c
            boolean r5 = r4.d0
            if (r5 == 0) goto L_0x0151
            zmq.Msg r4 = r4.c0
            if (r4 == 0) goto L_0x0151
            r5 = r1[r3]
            r5.C1(r4)
            r4 = r1[r3]
            r4.flush()
        L_0x0151:
            zmq.Options r4 = r2.b
            boolean r5 = r4.d0
            if (r5 == 0) goto L_0x0165
            zmq.Msg r4 = r4.c0
            if (r4 == 0) goto L_0x0165
            r5 = r1[r0]
            r5.C1(r4)
            r4 = r1[r0]
            r4.flush()
        L_0x0165:
            zmq.Options r4 = r2.b
            boolean r5 = r4.f0
            if (r5 == 0) goto L_0x0174
            zmq.Msg r4 = r4.e0
            if (r4 == 0) goto L_0x0174
            r5 = r1[r3]
            r5.u1(r4)
        L_0x0174:
            zmq.SocketBase r2 = r2.f3596a
            r4 = r1[r0]
            r13.M0(r2, r4, r3)
        L_0x017b:
            zmq.Options r2 = r13.c
            r2.f = r14
            zmq.util.MultiMap r13 = r13.l
            r1 = r1[r3]
            r13.e(r14, r1)
            return r0
        L_0x0187:
            zmq.Options r6 = r13.c
            int r6 = r6.m
            if (r6 == r9) goto L_0x0192
            if (r6 == r1) goto L_0x0192
            r11 = 3
            if (r6 != r11) goto L_0x019b
        L_0x0192:
            zmq.util.MultiMap r6 = r13.k
            boolean r6 = r6.d(r14)
            if (r6 == 0) goto L_0x019b
            return r0
        L_0x019b:
            zmq.Options r6 = r13.c
            long r11 = r6.c
            zmq.io.IOThread r6 = r13.r(r11)
            if (r6 != 0) goto L_0x01ae
            zmq.util.Errno r13 = r13.j
            r14 = 156384766(0x9523dfe, float:2.530698E-33)
            r13.c(r14)
            return r3
        L_0x01ae:
            zmq.io.net.Address r11 = new zmq.io.net.Address
            r11.<init>(r4, r5)
            zmq.Options r5 = r13.c
            boolean r5 = r5.u
            r4.resolve(r11, r5)
            zmq.Options r5 = r13.c
            zmq.io.SessionBase r5 = zmq.socket.Sockets.createSession(r6, r0, r13, r5, r11)
            boolean r4 = r4.subscribe2all
            zmq.Options r6 = r13.c
            boolean r12 = r6.v
            if (r12 != 0) goto L_0x01ca
            if (r4 == 0) goto L_0x0208
        L_0x01ca:
            zmq.ZObject[] r2 = new zmq.ZObject[r1]
            r2[r3] = r13
            r2[r0] = r5
            boolean r12 = r6.S
            if (r12 == 0) goto L_0x01e2
            int r12 = r6.m
            if (r12 == r9) goto L_0x01e0
            if (r12 == r8) goto L_0x01e0
            if (r12 == r7) goto L_0x01e0
            if (r12 == r0) goto L_0x01e0
            if (r12 != r1) goto L_0x01e2
        L_0x01e0:
            r7 = r0
            goto L_0x01e3
        L_0x01e2:
            r7 = r3
        L_0x01e3:
            if (r7 == 0) goto L_0x01e7
            r8 = r10
            goto L_0x01e9
        L_0x01e7:
            int r8 = r6.f3601a
        L_0x01e9:
            if (r7 == 0) goto L_0x01ec
            goto L_0x01ee
        L_0x01ec:
            int r10 = r6.b
        L_0x01ee:
            int[] r6 = new int[]{r8, r10}
            boolean[] r1 = new boolean[r1]
            r1[r3] = r7
            r1[r0] = r7
            zmq.pipe.Pipe[] r1 = zmq.pipe.Pipe.o1(r2, r6, r1)
            r2 = r1[r3]
            r13.r1(r2, r4, r0)
            r2 = r1[r3]
            r1 = r1[r0]
            r5.p1(r1)
        L_0x0208:
            zmq.Options r1 = r13.c
            java.lang.String r3 = r11.toString()
            r1.f = r3
            r13.p1(r14, r5, r2)
            return r0
        L_0x0214:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: zmq.SocketBase.w1(java.lang.String):boolean");
    }

    public final void x1() {
        this.o.set(Boolean.TRUE);
    }

    public final int y1() {
        return this.j.a();
    }

    public final void z1(String str, Object obj, int i) {
        try {
            this.B.lock();
            if ((this.z & i) != 0) {
                if (this.y != null) {
                    Z1(new ZMQ.Event(i, str, obj));
                    this.B.unlock();
                }
            }
        } finally {
            this.B.unlock();
        }
    }

    public SocketBase(Ctx ctx, int i, int i2, boolean z2) {
        super(ctx, i);
        int i3 = 0;
        this.B = new ReentrantLock(false);
        boolean z3 = true;
        this.m = true;
        this.n = new AtomicBoolean();
        this.o = new ThreadLocal();
        this.p = new AtomicBoolean();
        this.u = 0;
        this.v = 0;
        this.w = false;
        this.y = null;
        this.z = 0;
        Options options = this.c;
        options.R = i2;
        options.u = ctx.n(42) == 0 ? false : z3;
        this.c.n = ctx.n(70) != 0 ? -1 : i3;
        this.k = new MultiMap();
        this.l = new MultiMap();
        this.r = new HashSet();
        this.C = z2;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.D = reentrantLock;
        this.E = null;
        if (z2) {
            this.q = new MailboxSafe(ctx, reentrantLock, "safe-socket-" + i2);
            return;
        }
        this.q = new Mailbox(ctx, "socket-" + i2, i);
    }
}
