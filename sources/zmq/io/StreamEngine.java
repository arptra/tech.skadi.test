package zmq.io;

import com.honey.account.yc.a;
import com.honey.account.yc.b;
import com.honey.account.yc.c;
import com.honey.account.yc.d;
import com.honey.account.yc.e;
import com.honey.account.yc.f;
import com.honey.account.yc.g;
import com.honey.account.yc.h;
import com.honey.account.yc.i;
import com.honey.account.yc.j;
import com.honey.account.yc.k;
import com.honey.account.yc.l;
import com.meizu.common.util.LunarCalendar;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import zmq.Config;
import zmq.Msg;
import zmq.Options;
import zmq.SocketBase;
import zmq.ZError;
import zmq.ZMQ;
import zmq.io.coder.IDecoder;
import zmq.io.coder.IEncoder;
import zmq.io.coder.raw.RawDecoder;
import zmq.io.coder.raw.RawEncoder;
import zmq.io.coder.v1.V1Decoder;
import zmq.io.coder.v1.V1Encoder;
import zmq.io.coder.v2.V2Decoder;
import zmq.io.coder.v2.V2Encoder;
import zmq.io.mechanism.Mechanism;
import zmq.io.mechanism.Mechanisms;
import zmq.io.net.Address;
import zmq.poll.IPollEvents;
import zmq.poll.Poller;
import zmq.util.Blob;
import zmq.util.Errno;
import zmq.util.Utils;
import zmq.util.ValueReference;
import zmq.util.Wire;
import zmq.util.function.Function;
import zmq.util.function.Supplier;

public class StreamEngine implements IEngine, IPollEvents {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public final int E;
    public final byte[] F;
    public SocketBase G;
    public final Address H;
    public final Errno I;
    public final Function J;
    public final Supplier K;
    public final Function L = new g(this);
    public final Supplier M = new h(this);
    public final Function N = new i(this);
    public final Supplier O = new j(this);
    public final Function P = new k(this);
    public final Function Q = new l(this);
    public final Supplier R = new b(this);
    public final Function S = new c(this);
    public final Function T = new d(this);
    public final Supplier U = new e(this);

    /* renamed from: a  reason: collision with root package name */
    public IOObject f3619a;
    public SocketChannel b;
    public Poller.Handle c;
    public ByteBuffer d;
    public int e;
    public IDecoder f;
    public final ValueReference g;
    public int h;
    public IEncoder i;
    public Metadata j;
    public boolean k;
    public int l;
    public final ByteBuffer m;
    public final ByteBuffer n;
    public Protocol o;
    public SessionBase p;
    public final Options q;
    public final String r;
    public boolean s;
    public Supplier t;
    public Function u;
    public boolean v;
    public boolean w;
    public Mechanism x;
    public boolean y;
    public boolean z;

    public enum ErrorReason {
        PROTOCOL,
        CONNECTION,
        TIMEOUT
    }

    public final class ProducePongMessage implements Supplier<Msg> {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f3620a;

        public ProducePongMessage(byte[] bArr) {
            this.f3620a = bArr;
        }

        /* renamed from: a */
        public Msg get() {
            return StreamEngine.this.N(this.f3620a);
        }
    }

    public enum Protocol {
        V0(-1),
        V1(0),
        V2(1),
        V3(3);
        
        /* access modifiers changed from: private */
        public final byte revision;

        private Protocol(int i) {
            this.revision = (byte) i;
        }
    }

    public StreamEngine(SocketChannel socketChannel, Options options, String str) {
        a aVar = new a(this);
        this.J = aVar;
        f fVar = new f(this);
        this.K = fVar;
        this.I = options.k0;
        this.b = socketChannel;
        this.k = true;
        this.l = 12;
        this.q = options;
        this.r = str;
        this.t = fVar;
        this.u = aVar;
        this.g = new ValueReference();
        this.m = ByteBuffer.allocate(64);
        this.n = ByteBuffer.allocate(64);
        try {
            Utils.j(this.b);
            this.H = Utils.d(socketChannel);
            this.E = D();
            byte[] bArr = options.X;
            this.F = Arrays.copyOf(bArr, bArr.length);
        } catch (IOException e2) {
            throw new ZError.IOException(e2);
        }
    }

    private void V() {
        this.s = false;
        if (this.A) {
            this.f3619a.f(64);
            this.A = false;
        }
        if (this.B) {
            this.f3619a.f(128);
            this.B = false;
        }
        if (this.C) {
            this.f3619a.f(130);
            this.C = false;
        }
        if (this.D) {
            this.f3619a.f(129);
            this.D = false;
        }
        if (!this.v) {
            this.f3619a.i(this.c);
            this.c = null;
        }
        this.f3619a.q();
        this.p = null;
    }

    public void A() {
        SocketChannel socketChannel = this.b;
        if (socketChannel != null) {
            try {
                socketChannel.close();
            } catch (IOException unused) {
            }
            this.b = null;
        }
        IEncoder iEncoder = this.i;
        if (iEncoder != null) {
            iEncoder.destroy();
        }
        IDecoder iDecoder = this.f;
        if (iDecoder != null) {
            iDecoder.destroy();
        }
        Mechanism mechanism = this.x;
        if (mechanism != null) {
            mechanism.i();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0024, code lost:
        r1 = r3.x;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void B(zmq.io.StreamEngine.ErrorReason r4) {
        /*
            r3 = this;
            zmq.Options r0 = r3.q
            boolean r0 = r0.y
            if (r0 == 0) goto L_0x0010
            zmq.Msg r0 = new zmq.Msg
            r0.<init>()
            zmq.util.function.Function r1 = r3.u
            r1.apply(r0)
        L_0x0010:
            zmq.SocketBase r0 = r3.G
            java.lang.String r1 = r3.r
            java.nio.channels.SocketChannel r2 = r3.b
            r0.I1(r1, r2)
            zmq.io.SessionBase r0 = r3.p
            r0.flush()
            zmq.io.SessionBase r0 = r3.p
            boolean r1 = r3.k
            if (r1 != 0) goto L_0x0032
            zmq.io.mechanism.Mechanism r1 = r3.x
            if (r1 == 0) goto L_0x0030
            zmq.io.mechanism.Mechanism$Status r1 = r1.y()
            zmq.io.mechanism.Mechanism$Status r2 = zmq.io.mechanism.Mechanism.Status.HANDSHAKING
            if (r1 == r2) goto L_0x0032
        L_0x0030:
            r1 = 1
            goto L_0x0033
        L_0x0032:
            r1 = 0
        L_0x0033:
            r0.r1(r1, r4)
            r3.V()
            r3.A()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zmq.io.StreamEngine.B(zmq.io.StreamEngine$ErrorReason):void");
    }

    public final boolean C() {
        int i2;
        boolean z2;
        Options options = this.q;
        Mechanisms mechanisms = options.G;
        int max = Math.max(options.k, Config.IN_BATCH_SIZE.getValue());
        int max2 = Math.max(this.q.j, Config.OUT_BATCH_SIZE.getValue());
        while (true) {
            i2 = 10;
            if (this.m.position() < this.l) {
                int T2 = T(this.m);
                if (T2 != 0) {
                    if (T2 != -1) {
                        if ((this.m.get(0) & 255) != 255) {
                            break;
                        } else if (this.m.position() >= 10) {
                            if ((this.m.get(9) & 1) != 1) {
                                break;
                            }
                            int position = this.n.position();
                            if (this.n.limit() == 10) {
                                if (this.h == 0) {
                                    this.f3619a.p(this.c);
                                }
                                this.n.limit(11);
                                this.n.put(10, Protocol.V3.revision);
                                this.h++;
                            }
                            if (this.m.position() > 10 && this.n.limit() == 11) {
                                if (this.h == 0) {
                                    this.f3619a.p(this.c);
                                }
                                byte b2 = this.m.get(10);
                                if (b2 == Protocol.V1.revision || b2 == Protocol.V2.revision) {
                                    this.n.limit(12);
                                    this.n.position(11);
                                    this.n.put((byte) this.q.m);
                                    this.h++;
                                } else {
                                    this.n.limit(64);
                                    this.n.position(11);
                                    this.n.put((byte) 0);
                                    this.h++;
                                    this.n.mark();
                                    this.n.put(new byte[20]);
                                    this.n.reset();
                                    this.n.put(mechanisms.name().getBytes(ZMQ.c));
                                    this.n.reset();
                                    ByteBuffer byteBuffer = this.n;
                                    byteBuffer.position(byteBuffer.position() + 20);
                                    this.h += 20;
                                    this.n.put(new byte[32]);
                                    this.h += 32;
                                    this.l = 64;
                                }
                            }
                            this.n.position(position);
                        }
                    } else {
                        if (!this.I.b(35)) {
                            B(ErrorReason.CONNECTION);
                        }
                        return false;
                    }
                } else {
                    B(ErrorReason.CONNECTION);
                    return false;
                }
            } else {
                break;
            }
        }
        if ((this.m.get(0) & 255) != 255 || (this.m.get(9) & 1) == 0) {
            z2 = false;
            if (this.p.C1()) {
                B(ErrorReason.PROTOCOL);
                return false;
            }
            this.o = Protocol.V0;
            this.i = new V1Encoder(this.I, max2);
            Errno errno = this.I;
            Options options2 = this.q;
            this.f = new V1Decoder(errno, max, options2.r, options2.a0);
            if (this.q.d + 1 < 255) {
                i2 = 2;
            }
            ByteBuffer allocate = ByteBuffer.allocate(i2);
            Msg msg = new Msg((int) this.q.d);
            Options options3 = this.q;
            msg.D(options3.e, 0, options3.d);
            this.i.a(msg);
            this.i.b(new ValueReference(allocate), i2);
            z(0);
            int i3 = this.q.m;
            if (i3 == 1 || i3 == 9) {
                this.w = true;
            }
            this.t = this.O;
            this.u = this.J;
        } else {
            byte b3 = this.m.get(10);
            Protocol protocol = Protocol.V1;
            if (b3 == protocol.revision) {
                this.o = protocol;
                if (this.p.C1()) {
                    B(ErrorReason.PROTOCOL);
                    return false;
                }
                this.i = new V1Encoder(this.I, max2);
                Errno errno2 = this.I;
                Options options4 = this.q;
                z2 = false;
                this.f = new V1Decoder(errno2, max, options4.r, options4.a0);
                z(12);
            } else {
                z2 = false;
                byte b4 = this.m.get(10);
                Protocol protocol2 = Protocol.V2;
                if (b4 == protocol2.revision) {
                    this.o = protocol2;
                    if (this.p.C1()) {
                        B(ErrorReason.PROTOCOL);
                        return false;
                    }
                    this.i = new V2Encoder(this.I, max2);
                    Errno errno3 = this.I;
                    Options options5 = this.q;
                    this.f = new V2Decoder(errno3, max, options5.r, options5.a0);
                    z(12);
                } else {
                    this.o = Protocol.V3;
                    this.i = new V2Encoder(this.I, max2);
                    Errno errno4 = this.I;
                    Options options6 = this.q;
                    this.f = new V2Decoder(errno4, max, options6.r, options6.a0);
                    this.m.position(12);
                    if (mechanisms.isMechanism(this.m)) {
                        this.x = mechanisms.create(this.p, this.H, this.q);
                        this.t = this.M;
                        this.u = this.L;
                    } else {
                        B(ErrorReason.PROTOCOL);
                        return false;
                    }
                }
            }
        }
        if (this.h == 0) {
            this.f3619a.p(this.c);
        }
        this.k = z2;
        if (this.A) {
            this.f3619a.f(64);
            this.A = z2;
        }
        this.G.L1(this.r, this.o.ordinal());
        return true;
    }

    public final int D() {
        Options options = this.q;
        int i2 = options.V;
        if (i2 <= 0) {
            return 0;
        }
        int i3 = options.W;
        return i3 == -1 ? i2 : i3;
    }

    public final Msg E() {
        Msg msg = new Msg((int) this.q.d);
        Options options = this.q;
        short s2 = options.d;
        if (s2 > 0) {
            msg.D(options.e, 0, s2);
        }
        this.t = this.O;
        return msg;
    }

    public final Object F(Class cls, int i2, long j2) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getConstructor(new Class[]{Integer.TYPE, Long.TYPE}).newInstance(new Object[]{Integer.valueOf(i2), Long.valueOf(j2)});
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e2) {
            throw new ZError.InstantiationException(e2);
        }
    }

    public final void G() {
        int i2 = this.q.V;
        if (i2 > 0) {
            this.f3619a.e((long) i2, 129);
            this.D = true;
        }
        if (this.q.x) {
            if (this.p.v1(this.x.q()) || !this.I.b(35)) {
                this.p.flush();
            } else {
                return;
            }
        }
        this.t = this.R;
        this.u = this.Q;
        this.j = new Metadata();
        Address address = this.H;
        if (address != null && !address.a().isEmpty()) {
            this.j.e("Peer-Address", this.H.a());
        }
        this.j.f(this.x.d);
        this.j.f(this.x.e);
        if (this.j.c()) {
            this.j = null;
        }
    }

    public final Msg H() {
        if (this.x.y() == Mechanism.Status.READY) {
            G();
            return (Msg) this.R.get();
        } else if (this.x.y() == Mechanism.Status.ERROR) {
            this.I.c(156384820);
            return null;
        } else {
            Msg.Builder builder = new Msg.Builder();
            int m2 = this.x.m(builder);
            if (m2 == 0) {
                builder.J(2);
                return builder.Q();
            }
            this.I.c(m2);
            return null;
        }
    }

    public final boolean I(Msg msg) {
        if (Msgs.a(msg, "PING", true)) {
            return K(msg);
        }
        return false;
    }

    public final boolean J(Msg msg) {
        int r2 = this.x.r(msg);
        if (r2 == 0) {
            if (this.x.y() == Mechanism.Status.READY) {
                G();
            } else if (this.x.y() == Mechanism.Status.ERROR) {
                this.I.c(156384820);
                return false;
            }
            if (this.z) {
                e();
            }
        } else {
            this.I.c(r2);
        }
        return r2 == 0;
    }

    public final boolean K(Msg msg) {
        int l2 = msg.l(5) * 100;
        if (!this.B && l2 > 0) {
            this.f3619a.e((long) l2, 128);
            this.B = true;
        }
        int O2 = msg.O() - 7;
        if (O2 > 16) {
            O2 = 16;
        }
        byte[] bArr = new byte[O2];
        msg.f(7, bArr, 0, O2);
        this.t = new ProducePongMessage(bArr);
        d();
        return true;
    }

    public final boolean L(Msg msg) {
        if (this.q.x) {
            msg.J(64);
            this.p.v1(msg);
        }
        if (this.w) {
            Msg msg2 = new Msg(1);
            msg2.x((byte) 1);
            this.p.v1(msg2);
        }
        this.u = this.N;
        return true;
    }

    public final Msg M() {
        int i2;
        Msg msg = new Msg(this.F.length + 7);
        msg.J(2);
        msg.E("PING");
        Wire.h(msg, this.q.U);
        msg.C(this.F);
        Msg j2 = this.x.j(msg);
        this.t = this.R;
        if (!this.C && (i2 = this.E) > 0) {
            this.f3619a.e((long) i2, 130);
            this.C = true;
        }
        return j2;
    }

    public final Msg N(byte[] bArr) {
        Msg msg = new Msg(bArr.length + 5);
        msg.J(2);
        msg.E("PONG");
        msg.C(bArr);
        Msg j2 = this.x.j(msg);
        this.t = this.R;
        return j2;
    }

    public final Msg O() {
        Msg u1 = this.p.u1();
        if (u1 == null) {
            return null;
        }
        return this.x.j(u1);
    }

    public final Msg P() {
        return this.p.u1();
    }

    public final boolean Q(Msg msg) {
        return this.p.v1(msg);
    }

    public final boolean R(Msg msg) {
        boolean v1 = this.p.v1(msg);
        if (v1) {
            this.u = this.S;
        }
        return v1;
    }

    public final boolean S(Msg msg) {
        Metadata metadata = this.j;
        if (metadata != null && !metadata.equals(msg.j())) {
            msg.L(this.j);
        }
        return Q(msg);
    }

    public final int T(ByteBuffer byteBuffer) {
        try {
            int read = this.b.read(byteBuffer);
            if (read == -1) {
                this.I.c(57);
            } else if (read == 0 && !this.b.isBlocking()) {
                this.I.c(35);
                return -1;
            }
            return read;
        } catch (IOException unused) {
            this.I.c(57);
            return -1;
        }
    }

    public final void U() {
        int i2;
        Options options = this.q;
        if (!options.y && (i2 = options.T) > 0) {
            this.f3619a.e((long) i2, 64);
            this.A = true;
        }
    }

    public final int W(ByteBuffer byteBuffer) {
        try {
            int write = this.b.write(byteBuffer);
            if (write != 0) {
                return write;
            }
            this.I.c(35);
            return write;
        } catch (IOException unused) {
            this.I.c(57);
            return -1;
        }
    }

    public final boolean X(Msg msg) {
        Blob k2 = this.x.k();
        if (k2 != null && k2.e() > 0) {
            Msg msg2 = new Msg(k2.e());
            msg2.D(k2.d(), 0, k2.e());
            msg2.J(32);
            if (!this.p.v1(msg2)) {
                return false;
            }
        }
        Function function = this.S;
        this.u = function;
        return ((Boolean) function.apply(msg)).booleanValue();
    }

    public void b() {
        if (((Boolean) this.u.apply(this.f.a())).booleanValue()) {
            boolean y2 = y();
            if (!y2 && this.I.b(35)) {
                this.p.flush();
            } else if (this.v) {
                B(ErrorReason.CONNECTION);
            } else if (!y2) {
                B(ErrorReason.PROTOCOL);
            } else {
                this.y = false;
                this.f3619a.n(this.c);
                this.p.flush();
                o();
            }
        } else if (this.I.b(35)) {
            this.p.flush();
        } else {
            B(ErrorReason.PROTOCOL);
        }
    }

    public void d() {
        Msg msg;
        if (this.h == 0) {
            if (this.i != null) {
                this.g.b((Object) null);
                this.h = this.i.b(this.g, 0);
                int max = Math.max(this.q.j, Config.OUT_BATCH_SIZE.getValue());
                while (this.h < max && (msg = (Msg) this.t.get()) != null) {
                    this.i.a(msg);
                    this.h += this.i.b(this.g, max - this.h);
                }
                if (this.h == 0) {
                    this.z = true;
                    this.f3619a.k(this.c);
                    return;
                }
                this.i.encoded();
            } else {
                return;
            }
        }
        int W = W((ByteBuffer) this.g.a());
        if (W == -1) {
            this.f3619a.k(this.c);
            return;
        }
        int i2 = this.h - W;
        this.h = i2;
        if (this.k && i2 == 0) {
            this.f3619a.k(this.c);
        }
    }

    public void e() {
        if (!this.v) {
            if (this.z) {
                this.f3619a.p(this.c);
                this.z = false;
            }
            d();
        }
    }

    public void f() {
        if (this.x.z() == -1) {
            B(ErrorReason.PROTOCOL);
            return;
        }
        if (this.y) {
            b();
        }
        if (this.z) {
            e();
        }
    }

    public void g(int i2) {
        if (i2 == 64) {
            this.A = false;
            B(ErrorReason.TIMEOUT);
        } else if (i2 == 129) {
            this.t = this.U;
            d();
            this.f3619a.e((long) this.q.V, 129);
        } else if (i2 == 128) {
            this.B = false;
            B(ErrorReason.TIMEOUT);
        } else if (i2 == 130) {
            this.C = false;
            B(ErrorReason.TIMEOUT);
        }
    }

    public String h() {
        return this.r;
    }

    public void i(IOThread iOThread, SessionBase sessionBase) {
        this.s = true;
        this.p = sessionBase;
        this.G = sessionBase.t1();
        IOObject iOObject = new IOObject(iOThread, this);
        this.f3619a = iOObject;
        iOObject.h();
        this.c = this.f3619a.b(this.b);
        this.v = false;
        int max = Math.max(this.q.k, Config.IN_BATCH_SIZE.getValue());
        int max2 = Math.max(this.q.j, Config.OUT_BATCH_SIZE.getValue());
        Options options = this.q;
        if (options.y) {
            IDecoder iDecoder = (IDecoder) F(options.Y, max, options.r);
            this.f = iDecoder;
            if (iDecoder == null) {
                this.f = new RawDecoder(max);
            }
            Options options2 = this.q;
            IEncoder iEncoder = (IEncoder) F(options2.Z, max2, options2.r);
            this.i = iEncoder;
            if (iEncoder == null) {
                this.i = new RawEncoder(this.I, max2);
            }
            this.k = false;
            this.t = this.O;
            this.u = this.P;
            Address address = this.H;
            if (address != null && !address.a().isEmpty()) {
                Metadata metadata = new Metadata();
                this.j = metadata;
                metadata.e("Peer-Address", this.H.a());
            }
            S(new Msg());
            sessionBase.flush();
        } else {
            U();
            this.n.put((byte) -1);
            Wire.l(this.n, (long) (this.q.d + 1));
            this.n.put(Byte.MAX_VALUE);
            this.g.b(this.n);
            this.h = this.n.position();
            this.n.flip();
        }
        this.f3619a.n(this.c);
        this.f3619a.p(this.c);
        o();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0093, code lost:
        r3 = r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o() {
        /*
            r7 = this;
            boolean r0 = r7.k
            if (r0 == 0) goto L_0x000b
            boolean r0 = r7.C()
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            boolean r0 = r7.y
            r1 = 1
            if (r0 == 0) goto L_0x001d
            zmq.io.IOObject r0 = r7.f3619a
            zmq.poll.Poller$Handle r2 = r7.c
            r0.i(r2)
            r0 = 0
            r7.c = r0
            r7.v = r1
            return
        L_0x001d:
            int r0 = r7.e
            r2 = 35
            if (r0 != 0) goto L_0x004e
            zmq.io.coder.IDecoder r0 = r7.f
            java.nio.ByteBuffer r0 = r0.getBuffer()
            r7.d = r0
            int r0 = r7.T(r0)
            if (r0 != 0) goto L_0x0036
            zmq.io.StreamEngine$ErrorReason r3 = zmq.io.StreamEngine.ErrorReason.CONNECTION
            r7.B(r3)
        L_0x0036:
            r3 = -1
            if (r0 != r3) goto L_0x0047
            zmq.util.Errno r0 = r7.I
            boolean r0 = r0.b(r2)
            if (r0 != 0) goto L_0x0046
            zmq.io.StreamEngine$ErrorReason r0 = zmq.io.StreamEngine.ErrorReason.CONNECTION
            r7.B(r0)
        L_0x0046:
            return
        L_0x0047:
            java.nio.ByteBuffer r3 = r7.d
            r3.flip()
            r7.e = r0
        L_0x004e:
            zmq.util.ValueReference r0 = new zmq.util.ValueReference
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r0.<init>(r4)
            r4 = r3
        L_0x0059:
            int r5 = r7.e
            if (r5 <= 0) goto L_0x0093
            zmq.io.coder.IDecoder r4 = r7.f
            java.nio.ByteBuffer r6 = r7.d
            zmq.io.coder.IDecoder$Step$Result r4 = r4.b(r6, r5, r0)
            int r5 = r7.e
            java.lang.Object r6 = r0.a()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            int r5 = r5 - r6
            r7.e = r5
            zmq.io.coder.IDecoder$Step$Result r5 = zmq.io.coder.IDecoder.Step.Result.MORE_DATA
            if (r4 != r5) goto L_0x007a
            r3 = r1
            goto L_0x0094
        L_0x007a:
            zmq.io.coder.IDecoder$Step$Result r5 = zmq.io.coder.IDecoder.Step.Result.ERROR
            if (r4 != r5) goto L_0x007f
            goto L_0x0094
        L_0x007f:
            zmq.io.coder.IDecoder r4 = r7.f
            zmq.Msg r4 = r4.a()
            zmq.util.function.Function r5 = r7.u
            java.lang.Object r4 = r5.apply(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x0059
        L_0x0093:
            r3 = r4
        L_0x0094:
            if (r3 != 0) goto L_0x00ad
            zmq.util.Errno r0 = r7.I
            boolean r0 = r0.b(r2)
            if (r0 != 0) goto L_0x00a4
            zmq.io.StreamEngine$ErrorReason r0 = zmq.io.StreamEngine.ErrorReason.PROTOCOL
            r7.B(r0)
            return
        L_0x00a4:
            r7.y = r1
            zmq.io.IOObject r0 = r7.f3619a
            zmq.poll.Poller$Handle r1 = r7.c
            r0.j(r1)
        L_0x00ad:
            zmq.io.SessionBase r7 = r7.p
            r7.flush()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zmq.io.StreamEngine.o():void");
    }

    public void terminate() {
        V();
        A();
    }

    public String toString() {
        return getClass().getSimpleName() + this.G + LunarCalendar.DATE_SEPARATOR + this.o;
    }

    public final boolean x(Msg msg) {
        Msg h2 = this.x.h(msg);
        if (h2 == null) {
            return false;
        }
        if (this.C) {
            this.C = false;
            this.f3619a.f(130);
        }
        if (this.B) {
            this.B = false;
            this.f3619a.f(128);
        }
        if (h2.r()) {
            I(h2);
        }
        Metadata metadata = this.j;
        if (metadata != null) {
            h2.L(metadata);
        }
        if (this.p.v1(h2)) {
            return true;
        }
        if (this.I.b(35)) {
            this.u = this.T;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0005  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean y() {
        /*
            r6 = this;
        L_0x0000:
            int r0 = r6.e
            r1 = 1
            if (r0 <= 0) goto L_0x0047
            zmq.util.ValueReference r0 = new zmq.util.ValueReference
            r2 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r0.<init>(r3)
            zmq.io.coder.IDecoder r3 = r6.f
            java.nio.ByteBuffer r4 = r6.d
            int r5 = r6.e
            zmq.io.coder.IDecoder$Step$Result r3 = r3.b(r4, r5, r0)
            int r4 = r6.e
            java.lang.Object r0 = r0.a()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r4 = r4 - r0
            r6.e = r4
            zmq.io.coder.IDecoder$Step$Result r0 = zmq.io.coder.IDecoder.Step.Result.MORE_DATA
            if (r3 != r0) goto L_0x002d
            return r1
        L_0x002d:
            zmq.io.coder.IDecoder$Step$Result r0 = zmq.io.coder.IDecoder.Step.Result.ERROR
            if (r3 != r0) goto L_0x0032
            return r2
        L_0x0032:
            zmq.util.function.Function r0 = r6.u
            zmq.io.coder.IDecoder r1 = r6.f
            zmq.Msg r1 = r1.a()
            java.lang.Object r0 = r0.apply(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0000
            return r2
        L_0x0047:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zmq.io.StreamEngine.y():boolean");
    }

    public final void z(int i2) {
        int position = this.m.position();
        if (position > i2) {
            this.m.position(i2).limit(position);
            ByteBuffer byteBuffer = this.m;
            this.d = byteBuffer;
            this.e = byteBuffer.remaining();
        }
    }
}
