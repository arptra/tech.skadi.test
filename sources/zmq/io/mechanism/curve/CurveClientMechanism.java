package zmq.io.mechanism.curve;

import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants;
import com.xjsd.ai.assistant.protocol.CmdCode;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import zmq.Msg;
import zmq.Options;
import zmq.ZMQ;
import zmq.io.SessionBase;
import zmq.io.mechanism.Mechanism;
import zmq.io.mechanism.curve.Curve;
import zmq.io.net.Address;
import zmq.util.Errno;
import zmq.util.Wire;

public class CurveClientMechanism extends Mechanism {
    public State i = State.SEND_HELLO;
    public final byte[] j;
    public final byte[] k;
    public final byte[] l;
    public final byte[] m;
    public final byte[] n;
    public byte[] o = new byte[Curve.Size.PUBLICKEY.bytes()];
    public byte[] p = new byte[96];
    public final byte[] q = new byte[Curve.Size.BEFORENM.bytes()];
    public long r = 1;
    public long s = 1;
    public final Curve t;
    public final Errno u;

    /* renamed from: zmq.io.mechanism.curve.CurveClientMechanism$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3632a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                zmq.io.mechanism.curve.CurveClientMechanism$State[] r0 = zmq.io.mechanism.curve.CurveClientMechanism.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3632a = r0
                zmq.io.mechanism.curve.CurveClientMechanism$State r1 = zmq.io.mechanism.curve.CurveClientMechanism.State.SEND_HELLO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3632a     // Catch:{ NoSuchFieldError -> 0x001d }
                zmq.io.mechanism.curve.CurveClientMechanism$State r1 = zmq.io.mechanism.curve.CurveClientMechanism.State.SEND_INITIATE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zmq.io.mechanism.curve.CurveClientMechanism.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        SEND_HELLO,
        EXPECT_WELCOME,
        SEND_INITIATE,
        EXPECT_READY,
        ERROR_RECEIVED,
        CONNECTED
    }

    public CurveClientMechanism(SessionBase sessionBase, Options options) {
        super(sessionBase, (Address) null, options);
        this.j = options.L;
        this.k = options.M;
        this.n = options.N;
        Curve curve = new Curve();
        this.t = curve;
        byte[][] f = curve.f();
        this.l = f[0];
        this.m = f[1];
        this.u = options.k0;
    }

    public final int A(Msg msg) {
        State state = this.i;
        if (state == State.EXPECT_WELCOME || state == State.EXPECT_READY) {
            this.i = State.ERROR_RECEIVED;
            return n(msg);
        }
        this.f.t1().K1(this.f.s1(), 268435457);
        return 156384820;
    }

    public final int B(Msg msg) {
        if (msg.O() < 30) {
            this.f.t1().K1(this.f.s1(), 268435478);
            return 156384820;
        }
        Curve.Size size = Curve.Size.BOXZERO;
        int bytes = (size.bytes() + msg.O()) - 14;
        ByteBuffer allocate = ByteBuffer.allocate(Curve.Size.NONCE.bytes());
        Curve.Size size2 = Curve.Size.ZERO;
        ByteBuffer allocate2 = ByteBuffer.allocate(size2.bytes() + 256);
        ByteBuffer allocate3 = ByteBuffer.allocate(size.bytes() + 272);
        allocate3.position(size.bytes());
        msg.P(allocate3, 14, bytes - size.bytes());
        allocate.put("CurveZMQREADY---".getBytes(ZMQ.c));
        msg.P(allocate, 6, 8);
        this.s = msg.i(6);
        if (this.t.i(allocate2, allocate3, bytes, allocate, this.q) != 0) {
            this.f.t1().K1(this.f.s1(), 285212673);
            return 156384820;
        }
        allocate2.limit(bytes);
        int o2 = o(allocate2, size2.bytes(), false);
        if (o2 == 0) {
            this.i = State.CONNECTED;
        }
        return o2;
    }

    public final int C(Msg msg) {
        if (msg.O() != 168) {
            this.f.t1().K1(this.f.s1(), 268435478);
            return 156384820;
        }
        ByteBuffer allocate = ByteBuffer.allocate(Curve.Size.NONCE.bytes());
        Curve.Size size = Curve.Size.ZERO;
        ByteBuffer allocate2 = ByteBuffer.allocate(size.bytes() + 128);
        Curve.Size size2 = Curve.Size.BOXZERO;
        ByteBuffer allocate3 = ByteBuffer.allocate(size2.bytes() + AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW);
        allocate3.position(size2.bytes());
        msg.P(allocate3, 24, AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW);
        allocate.put("WELCOME-".getBytes(ZMQ.c));
        msg.P(allocate, 8, 16);
        if (this.t.g(allocate2, allocate3, allocate3.capacity(), allocate, this.n, this.m) != 0) {
            this.f.t1().K1(this.f.s1(), 285212673);
            return 156384820;
        }
        allocate2.position(size.bytes());
        allocate2.get(this.o);
        allocate2.get(this.p);
        this.t.c(this.q, this.o, this.m);
        this.i = State.SEND_INITIATE;
        return 0;
    }

    public final int D(Msg msg) {
        ByteBuffer allocate = ByteBuffer.allocate(Curve.Size.NONCE.bytes());
        ByteBuffer allocate2 = ByteBuffer.allocate(Curve.Size.ZERO.bytes() + 64);
        Curve.Size size = Curve.Size.BOXZERO;
        ByteBuffer allocate3 = ByteBuffer.allocate(size.bytes() + 80);
        allocate.put("CurveZMQHELLO---".getBytes(ZMQ.c));
        Wire.l(allocate, this.r);
        if (this.t.d(allocate3, allocate2, allocate2.capacity(), allocate, this.n, this.m) != 0) {
            this.f.t1().K1(this.f.s1(), 285212673);
            return -1;
        }
        msg.E("HELLO");
        msg.y(1);
        msg.y(0);
        msg.C(new byte[72]);
        msg.C(this.l);
        msg.B(allocate, 16, 8);
        msg.B(allocate3, size.bytes(), 80);
        this.r++;
        return 0;
    }

    public final int E(Msg msg) {
        Msg msg2 = msg;
        Curve.Size size = Curve.Size.NONCE;
        ByteBuffer allocate = ByteBuffer.allocate(size.bytes());
        Curve.Size size2 = Curve.Size.ZERO;
        ByteBuffer allocate2 = ByteBuffer.allocate(size2.bytes() + 64);
        Curve.Size size3 = Curve.Size.BOXZERO;
        ByteBuffer allocate3 = ByteBuffer.allocate(size3.bytes() + 80);
        allocate2.position(size2.bytes());
        allocate2.put(this.l);
        allocate2.put(this.n);
        Charset charset = ZMQ.c;
        allocate.put("VOUCH---".getBytes(charset));
        allocate.put(this.t.k(16));
        if (this.t.d(allocate3, allocate2, allocate2.capacity(), allocate, this.o, this.k) == -1) {
            this.f.t1().K1(this.f.s1(), 285212673);
            return -1;
        }
        ByteBuffer allocate4 = ByteBuffer.allocate(size.bytes());
        ByteBuffer allocate5 = ByteBuffer.allocate(size2.bytes() + 384);
        ByteBuffer allocate6 = ByteBuffer.allocate(size3.bytes() + CmdCode.CODE_WAKEUP_RECORDING);
        allocate5.position(size2.bytes());
        allocate5.put(this.j);
        allocate.limit(24).position(8);
        allocate5.put(allocate);
        allocate3.limit(size3.bytes() + 80).position(size3.bytes());
        allocate5.put(allocate3);
        b(allocate5, "Socket-Type", x());
        Options options = this.f3630a;
        int i2 = options.m;
        if (i2 == 3 || i2 == 5 || i2 == 6) {
            c(allocate5, "Identity", options.e);
        }
        int position = allocate5.position();
        allocate4.put("CurveZMQINITIATE".getBytes(charset));
        Wire.l(allocate4, this.r);
        if (this.t.d(allocate6, allocate5, position, allocate4, this.o, this.m) == -1) {
            this.f.t1().K1(this.f.s1(), 285212673);
            return -1;
        }
        msg2.E("INITIATE");
        msg2.C(this.p);
        msg2.B(allocate4, 16, 8);
        msg2.B(allocate6, size3.bytes(), position - size3.bytes());
        this.r++;
        return 0;
    }

    public Msg h(Msg msg) {
        if (!g(msg, "MESSAGE", true)) {
            this.f.t1().K1(this.f.s1(), 268435457);
            this.u.c(156384820);
            return null;
        } else if (msg.O() < 33) {
            this.f.t1().K1(this.f.s1(), 268435474);
            this.u.c(156384820);
            return null;
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(Curve.Size.NONCE.bytes());
            allocate.put("CurveZMQMESSAGES".getBytes(ZMQ.c));
            msg.P(allocate, 8, 8);
            long i2 = msg.i(8);
            if (i2 <= this.s) {
                this.f.t1().K1(this.f.s1(), 285212673);
                this.u.c(156384820);
                return null;
            }
            this.s = i2;
            Curve.Size size = Curve.Size.BOXZERO;
            int bytes = size.bytes() + msg.O();
            int i3 = bytes - 16;
            ByteBuffer allocate2 = ByteBuffer.allocate(i3);
            ByteBuffer allocate3 = ByteBuffer.allocate(i3);
            allocate3.position(size.bytes());
            msg.P(allocate3, 16, msg.O() - 16);
            if (this.t.i(allocate2, allocate3, i3, allocate, this.q) == 0) {
                Curve.Size size2 = Curve.Size.ZERO;
                Msg msg2 = new Msg((bytes - 17) - size2.bytes());
                byte b = allocate2.get(size2.bytes());
                if ((b & 1) != 0) {
                    msg2.J(1);
                }
                if ((b & 2) != 0) {
                    msg2.J(2);
                }
                allocate2.position(size2.bytes() + 1);
                msg2.A(allocate2);
                return msg2;
            }
            this.f.t1().K1(this.f.s1(), 285212673);
            this.u.c(156384820);
            return null;
        }
    }

    public Msg j(Msg msg) {
        byte b = msg.n() ? (byte) 1 : 0;
        if (msg.r()) {
            b = (byte) (b | 2);
        }
        ByteBuffer allocate = ByteBuffer.allocate(Curve.Size.NONCE.bytes());
        allocate.put("CurveZMQMESSAGEC".getBytes(ZMQ.c));
        Wire.l(allocate, this.r);
        Curve.Size size = Curve.Size.ZERO;
        int bytes = size.bytes() + 1 + msg.O();
        ByteBuffer allocate2 = ByteBuffer.allocate(bytes);
        allocate2.put(size.bytes(), b);
        allocate2.position(size.bytes() + 1);
        msg.P(allocate2, 0, msg.O());
        ByteBuffer allocate3 = ByteBuffer.allocate(bytes);
        this.t.a(allocate3, allocate2, bytes, allocate, this.q);
        Curve.Size size2 = Curve.Size.BOXZERO;
        Msg msg2 = new Msg((bytes + 16) - size2.bytes());
        msg2.E("MESSAGE");
        msg2.B(allocate, 16, 8);
        msg2.B(allocate3, size2.bytes(), bytes - size2.bytes());
        this.r++;
        return msg2;
    }

    public int m(Msg msg) {
        int D;
        int i2 = AnonymousClass1.f3632a[this.i.ordinal()];
        if (i2 == 1) {
            D = D(msg);
            if (D == 0) {
                this.i = State.EXPECT_WELCOME;
            }
        } else if (i2 != 2) {
            return 35;
        } else {
            D = E(msg);
            if (D == 0) {
                this.i = State.EXPECT_READY;
            }
        }
        return D;
    }

    public int r(Msg msg) {
        int O = msg.O();
        if (O >= 8 && g(msg, "WELCOME", true)) {
            return C(msg);
        }
        if (O >= 6 && g(msg, "READY", true)) {
            return B(msg);
        }
        if (O >= 6 && g(msg, "ERROR", true)) {
            return A(msg);
        }
        this.f.t1().K1(this.f.s1(), 268435457);
        return 156384820;
    }

    public Mechanism.Status y() {
        State state = this.i;
        return state == State.CONNECTED ? Mechanism.Status.READY : state == State.ERROR_RECEIVED ? Mechanism.Status.ERROR : Mechanism.Status.HANDSHAKING;
    }

    public int z() {
        return 0;
    }
}
