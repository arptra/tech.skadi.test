package zmq.io;

import com.meizu.common.util.LunarCalendar;
import java.util.HashSet;
import java.util.Set;
import zmq.Ctx;
import zmq.Msg;
import zmq.Options;
import zmq.Own;
import zmq.SocketBase;
import zmq.ZObject;
import zmq.io.StreamEngine;
import zmq.io.net.Address;
import zmq.io.net.NetProtocol;
import zmq.io.net.ipc.IpcConnecter;
import zmq.io.net.norm.NormEngine;
import zmq.io.net.pgm.PgmReceiver;
import zmq.io.net.pgm.PgmSender;
import zmq.io.net.tcp.SocksConnecter;
import zmq.io.net.tcp.TcpConnecter;
import zmq.io.net.tipc.TipcConnecter;
import zmq.pipe.Pipe;
import zmq.poll.IPollEvents;

public class SessionBase extends Own implements Pipe.IPipeEvents, IPollEvents {
    public final boolean k;
    public Pipe l = null;
    public Pipe m = null;
    public final Set n;
    public boolean o = false;
    public boolean p = false;
    public IEngine q = null;
    public final SocketBase r;
    public final IOThread s;
    public boolean t;
    public final Address u;
    public final IOObject v;

    /* renamed from: zmq.io.SessionBase$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3618a;
        public static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0064 */
        static {
            /*
                zmq.io.net.NetProtocol[] r0 = zmq.io.net.NetProtocol.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b = r0
                r1 = 1
                zmq.io.net.NetProtocol r2 = zmq.io.net.NetProtocol.tcp     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = b     // Catch:{ NoSuchFieldError -> 0x001d }
                zmq.io.net.NetProtocol r3 = zmq.io.net.NetProtocol.ipc     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x0028 }
                zmq.io.net.NetProtocol r4 = zmq.io.net.NetProtocol.tipc     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x0033 }
                zmq.io.net.NetProtocol r4 = zmq.io.net.NetProtocol.pgm     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x003e }
                zmq.io.net.NetProtocol r4 = zmq.io.net.NetProtocol.epgm     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x0049 }
                zmq.io.net.NetProtocol r4 = zmq.io.net.NetProtocol.norm     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                zmq.io.StreamEngine$ErrorReason[] r3 = zmq.io.StreamEngine.ErrorReason.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f3618a = r3
                zmq.io.StreamEngine$ErrorReason r4 = zmq.io.StreamEngine.ErrorReason.TIMEOUT     // Catch:{ NoSuchFieldError -> 0x005a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r1 = f3618a     // Catch:{ NoSuchFieldError -> 0x0064 }
                zmq.io.StreamEngine$ErrorReason r3 = zmq.io.StreamEngine.ErrorReason.CONNECTION     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = f3618a     // Catch:{ NoSuchFieldError -> 0x006e }
                zmq.io.StreamEngine$ErrorReason r1 = zmq.io.StreamEngine.ErrorReason.PROTOCOL     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zmq.io.SessionBase.AnonymousClass1.<clinit>():void");
        }
    }

    public SessionBase(IOThread iOThread, boolean z, SocketBase socketBase, Options options, Address address) {
        super(iOThread, options);
        this.v = new IOObject(iOThread, this);
        this.k = z;
        this.r = socketBase;
        this.s = iOThread;
        this.t = false;
        this.u = address;
        this.n = new HashSet();
    }

    public boolean A1(Msg msg) {
        Pipe pipe = this.m;
        if (pipe == null) {
            this.j.c(57);
            return false;
        }
        pipe.C1(msg);
        if (msg.n()) {
            return true;
        }
        this.m.flush();
        return true;
    }

    public int B1() {
        if (this.m == null) {
            Ctx.Endpoint v2 = v("inproc://zeromq.zap.01");
            SocketBase socketBase = v2.f3596a;
            if (socketBase == null) {
                this.j.c(61);
                return 61;
            }
            int i = v2.b.m;
            if (i == 4 || i == 6 || i == 12) {
                Pipe[] o1 = Pipe.o1(new ZObject[]{this, socketBase}, new int[]{0, 0}, new boolean[]{false, false});
                Pipe pipe = o1[0];
                this.m = pipe;
                pipe.y1();
                this.m.v1(this);
                M0(v2.f3596a, o1[1], false);
                if (v2.b.x) {
                    Msg msg = new Msg();
                    msg.J(64);
                    this.m.C1(msg);
                    this.m.flush();
                }
            } else {
                this.j.c(61);
                return 61;
            }
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r2 = r2.I;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean C1() {
        /*
            r2 = this;
            zmq.Options r2 = r2.c
            zmq.io.mechanism.Mechanisms r0 = r2.G
            zmq.io.mechanism.Mechanisms r1 = zmq.io.mechanism.Mechanisms.NULL
            if (r0 != r1) goto L_0x0015
            java.lang.String r2 = r2.I
            if (r2 == 0) goto L_0x0013
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r2 = 0
            goto L_0x0016
        L_0x0015:
            r2 = 1
        L_0x0016:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: zmq.io.SessionBase.C1():boolean");
    }

    public void D0(int i) {
        if (this.l == null && this.m == null && this.n.isEmpty()) {
            super.D0(0);
            return;
        }
        boolean z = true;
        this.p = true;
        if (this.l != null) {
            if (i > 0) {
                this.v.e((long) i, 32);
                this.t = true;
            }
            Pipe pipe = this.l;
            if (i == 0) {
                z = false;
            }
            pipe.B1(z);
            if (this.q == null) {
                this.l.g1();
            }
        }
        Pipe pipe2 = this.m;
        if (pipe2 != null) {
            pipe2.B1(false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        r5 = r3.m;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void T(zmq.io.IEngine r9) {
        /*
            r8 = this;
            r0 = 1
            r1 = 0
            r2 = 2
            zmq.pipe.Pipe r3 = r8.l
            if (r3 != 0) goto L_0x0058
            boolean r3 = r8.i1()
            if (r3 != 0) goto L_0x0058
            zmq.SocketBase r3 = r8.r
            zmq.ZObject[] r4 = new zmq.ZObject[r2]
            r4[r1] = r8
            r4[r0] = r3
            zmq.Options r3 = r8.c
            boolean r5 = r3.S
            if (r5 == 0) goto L_0x002d
            int r5 = r3.m
            r6 = 5
            if (r5 == r6) goto L_0x002b
            r6 = 7
            if (r5 == r6) goto L_0x002b
            r6 = 8
            if (r5 == r6) goto L_0x002b
            if (r5 == r0) goto L_0x002b
            if (r5 != r2) goto L_0x002d
        L_0x002b:
            r5 = r0
            goto L_0x002e
        L_0x002d:
            r5 = r1
        L_0x002e:
            r6 = -1
            if (r5 == 0) goto L_0x0033
            r7 = r6
            goto L_0x0035
        L_0x0033:
            int r7 = r3.b
        L_0x0035:
            if (r5 == 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            int r6 = r3.f3601a
        L_0x003a:
            int[] r3 = new int[]{r7, r6}
            boolean[] r2 = new boolean[r2]
            r2[r1] = r5
            r2[r0] = r5
            zmq.pipe.Pipe[] r2 = zmq.pipe.Pipe.o1(r4, r3, r2)
            r3 = r2[r1]
            r3.v1(r8)
            r1 = r2[r1]
            r8.l = r1
            zmq.SocketBase r1 = r8.r
            r0 = r2[r0]
            r8.L0(r1, r0)
        L_0x0058:
            r8.q = r9
            zmq.io.IOThread r0 = r8.s
            r9.i(r0, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zmq.io.SessionBase.T(zmq.io.IEngine):void");
    }

    public void b(Pipe pipe) {
        IEngine iEngine;
        if (this.l == pipe && (iEngine = this.q) != null) {
            iEngine.b();
        }
    }

    public void flush() {
        Pipe pipe = this.l;
        if (pipe != null) {
            pipe.flush();
        }
    }

    public void g(int i) {
        this.t = false;
        this.l.B1(false);
    }

    public void g1() {
        if (this.t) {
            this.v.f(32);
            this.t = false;
        }
        IEngine iEngine = this.q;
        if (iEngine != null) {
            iEngine.terminate();
        }
        this.v.q();
    }

    public final void h1() {
        super.h1();
    }

    public void i(Pipe pipe) {
        IEngine iEngine;
        if (this.l == pipe) {
            this.l = null;
            if (this.t) {
                this.v.f(32);
                this.t = false;
            }
        } else if (this.m == pipe) {
            this.m = null;
        } else {
            this.n.remove(pipe);
        }
        if (!i1() && this.c.y && (iEngine = this.q) != null) {
            iEngine.terminate();
            this.q = null;
        }
        if (this.p && this.l == null && this.m == null && this.n.isEmpty()) {
            this.p = false;
            super.D0(0);
        }
    }

    public void j(Pipe pipe) {
        Pipe pipe2 = this.l;
        if (pipe2 == pipe || this.m == pipe) {
            IEngine iEngine = this.q;
            if (iEngine == null) {
                pipe2.g1();
            } else if (pipe2 == pipe) {
                iEngine.e();
            } else {
                iEngine.f();
            }
        }
    }

    public void n(Pipe pipe) {
        throw new UnsupportedOperationException("Must Override");
    }

    public void p1(Pipe pipe) {
        this.l = pipe;
        pipe.v1(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x000a A[LOOP:0: B:1:0x000a->B:4:0x0012, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q1() {
        /*
            r1 = this;
            zmq.pipe.Pipe r0 = r1.l
            r0.r1()
            zmq.pipe.Pipe r0 = r1.l
            r0.flush()
        L_0x000a:
            boolean r0 = r1.o
            if (r0 == 0) goto L_0x0014
            zmq.Msg r0 = r1.u1()
            if (r0 != 0) goto L_0x000a
        L_0x0014:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zmq.io.SessionBase.q1():void");
    }

    public void r0() {
        this.v.h();
        if (this.k) {
            z1(false);
        }
    }

    public void r1(boolean z, StreamEngine.ErrorReason errorReason) {
        Msg msg;
        Msg msg2;
        this.q = null;
        if (this.l != null) {
            q1();
            if (!this.k && z) {
                Options options = this.c;
                if (options.f0 && (msg2 = options.e0) != null) {
                    this.l.u1(msg2);
                    this.l.s1();
                }
            }
            if (this.k && z) {
                Options options2 = this.c;
                if (options2.h0 && (msg = options2.g0) != null) {
                    this.l.t1(msg);
                }
            }
        }
        int i = AnonymousClass1.f3618a[errorReason.ordinal()];
        if (i == 1 || i == 2) {
            if (this.k) {
                x1();
            } else {
                n1();
            }
        } else if (i == 3) {
            n1();
        }
        Pipe pipe = this.l;
        if (pipe != null) {
            pipe.g1();
        }
        Pipe pipe2 = this.m;
        if (pipe2 != null) {
            pipe2.g1();
        }
    }

    public String s1() {
        return this.q.h();
    }

    public SocketBase t1() {
        return this.r;
    }

    public String toString() {
        return getClass().getSimpleName() + LunarCalendar.DATE_SEPARATOR + this.r;
    }

    public Msg u1() {
        Msg q1;
        Pipe pipe = this.l;
        if (pipe == null || (q1 = pipe.q1()) == null) {
            return null;
        }
        this.o = q1.n();
        return q1;
    }

    public boolean v1(Msg msg) {
        if (msg.r()) {
            return true;
        }
        Pipe pipe = this.l;
        if (pipe != null && pipe.C1(msg)) {
            return true;
        }
        this.j.c(35);
        return false;
    }

    public Msg w1() {
        Pipe pipe = this.m;
        if (pipe == null) {
            this.j.c(57);
            return null;
        }
        Msg q1 = pipe.q1();
        if (q1 == null) {
            this.j.c(35);
        }
        return q1;
    }

    public final void x1() {
        if (this.l != null && !this.c.v && !this.u.d().isMulticast) {
            this.l.m1();
            this.l.B1(false);
            this.n.add(this.l);
            this.l = null;
        }
        y1();
        if (this.c.o != -1) {
            z1(true);
        }
        Pipe pipe = this.l;
        if (pipe != null) {
            int i = this.c.m;
            if (i == 2 || i == 10) {
                pipe.m1();
            }
        }
    }

    public void y1() {
    }

    public final void z1(boolean z) {
        IOThread r2 = r(this.c.c);
        NetProtocol d = this.u.d();
        if (d == null) {
            this.j.c(43);
            return;
        }
        boolean z2 = false;
        switch (AnonymousClass1.b[d.ordinal()]) {
            case 1:
                String str = this.c.z;
                if (str != null) {
                    j1(new SocksConnecter(r2, this, this.c, this.u, new Address(NetProtocol.tcp, str), z));
                    return;
                }
                j1(new TcpConnecter(r2, this, this.c, this.u, z));
                return;
            case 2:
                j1(new IpcConnecter(r2, this, this.c, this.u, z));
                return;
            case 3:
                j1(new TipcConnecter(r2, this, this.c, this.u, z));
                return;
            case 4:
            case 5:
                if (d == NetProtocol.epgm) {
                    z2 = true;
                }
                Options options = this.c;
                int i = options.m;
                if (i == 1 || i == 9) {
                    PgmSender pgmSender = new PgmSender(r2, options);
                    pgmSender.a(z2, this.u);
                    J0(this, pgmSender);
                    return;
                }
                PgmReceiver pgmReceiver = new PgmReceiver(r2, options);
                pgmReceiver.a(z2, this.u);
                J0(this, pgmReceiver);
                return;
            case 6:
                Options options2 = this.c;
                int i2 = options2.m;
                if (i2 == 1 || i2 == 9) {
                    NormEngine normEngine = new NormEngine(r2, options2);
                    normEngine.a(this.u, true, false);
                    J0(this, normEngine);
                    return;
                }
                NormEngine normEngine2 = new NormEngine(r2, options2);
                normEngine2.a(this.u, false, true);
                J0(this, normEngine2);
                return;
            default:
                return;
        }
    }
}
